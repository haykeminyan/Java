import java.math.BigInteger;
final String[] args) {
        final Block obl = new Block(1, 2, 3);
        final Block ob2 = new Block(5, 4, 3);
        System.out.println(ob1.sameBlock(ob2));
    }
}

class Block {
    int a, b, c;
    int volume;

    Block(final int i, final int j, final int k) {
        this.a = i;
        this.b = j;
        this.c = k;
        volume = a * b * c;
    }
    boolean sameBlock(final 
    }
    public static BigInteger multiply() {
	final BigInteger one = new BigInteger("231243143214233123415");
	BigInteger two = new BigInteger("3434315425352154314232");
	return one.multiply(two);
    }
}
