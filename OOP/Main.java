class Main {
    public static void main(String[] args) {
        Vol ob1 = new Vol(2, 3, 4);
        Vol ob2 = new Vol(1, 2, 12);
        System.out.println(ob1.checker(ob2));
        System.out.println(ob1.checkVol(ob2));
    }
}

class Vol {
    int a, b, c;
    int volume;

    Vol(int i, int j, int k) {
        this.a = i;
        this.b = j;
        this.c = k;
        volume = a * b * c;
    }

    boolean checker(Vol ob) {
        if ((ob.a == a) && (ob.b == b) && (ob.c == c)) {
            return true;
        }
        return false;
    }

    boolean checkVol(Vol ob) {
        if (ob.volume == volume) {
            return true;
        }
        return false;
    }
}
