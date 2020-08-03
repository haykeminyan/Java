package main

import (
	"database/sql"
	"encoding/json"
	"flag"
	"fmt"
	"log"
	"net/http"
	"time"

	"github.com/gorilla/mux"
	_ "github.com/lib/pq"
)

type Book struct {
	ID          int64  `json:"id"`
	Name        string `json:"title"`
	Author      string `json:"author"`
	Description string `json:"description"`
}

var host, portDB, userDB, passDB, nameDB, port string
var db *sql.DB

func connection() (err error) {
	psqlInfo := fmt.Sprintf("host=%s port=%s user=%s password=%s dbname=%s sslmode=disable", host, portDB, userDB, passDB, nameDB)
	db, err = sql.Open("postgres", psqlInfo)
	if err != nil {
		return err
	}
	db.SetMaxIdleConns(5)
	db.SetMaxOpenConns(50)
	return nil
}

func main() {
	flag.StringVar(&host, "host", "0.0.0.0", "Localhost")
	flag.StringVar(&portDB, "portDB", "5432", "portDatabase")
	flag.StringVar(&userDB, "userDB", "haykeminyan", "portDatabase")
	flag.StringVar(&passDB, "passDB", "", "passwordDatabase")
	flag.StringVar(&nameDB, "nameDB", "postgres", "nameDatabase")
	flag.StringVar(&port, "port", "9001", "EnterPort")

	err := connection()
	if err != nil {
		log.Println("database not available")
	} else {
		go func() {
			for {
				err := db.Ping()
				if err != nil {
					log.Println("database ping error")
				}
				time.Sleep(6 * time.Second)
			}
		}()
		log.Println("database connect")
	}
	flag.Parse()
	r := mux.NewRouter()
	r.HandleFunc("/api/v1/getbook", getBook).Methods("GET").Queries("ID", "{ID}")
	log.Fatal(http.ListenAndServe(port, r))
	http.Handle("/api/v1/", r)

}

func getBook(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	params := mux.Vars(r)
	id, ok := params["ID"]
	if ok {
		row := db.QueryRow("SELECT * FROM tbooks WHERE id = $1", id)
		p := Book{}
		err := row.Scan(&p.ID, &p.Name, &p.Author, &p.Description)
		if err == sql.ErrNoRows {
			http.NotFound(w, r)
			return
		} else if err != nil {
			http.Error(w, http.StatusText(500), 500)
			fmt.Println(err)
			return
		}
		fmt.Println(p)
		json.NewEncoder(w).Encode(p)

	}
}
