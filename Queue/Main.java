class Main {
    public static void main(String[] args) {
        Queue big = new Queue(64);
        for (int i = 0; i < 64; i++) {
            big.put((char) ('A' + i));
        }
        char ch;
        for (int i = 0; i < 64; i++) {
            ch = big.get();
            if (ch != (char) 0) {
                System.out.print(ch);
            }
        }
    }
}

class Queue {
    int putloc, getloc;
    char[] q;

    Queue(int size) {
        q = new char[size];
        putloc = getloc = 0;
    }

    void put(char ch) {
        if (putloc == q.length) {
            System.out.println("Queue is full");
        }
        q[putloc++] = ch;
    }

    char get() {
        if (getloc == putloc) {
            System.out.println("Empty");
            return (char) 0;
        }
        return q[getloc++];
    }
}
