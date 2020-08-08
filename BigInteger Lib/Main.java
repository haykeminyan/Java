import java.math.BigInteger;

class Main {
	public static void main(String[] args) {
        System.out.println(factorial(31312);
        System.out.println(power(123992));
        System.out.println(multiply());
	}

	public static BigInteger factorial(int value) {
		BigInteger factor = BigInteger.valueOf(1);
		for (int i = 1; i <= value; i++) {
			factor = factor.multiply(BigInteger.valueOf(i));
		}
		return factor;
	}
	public static BigInteger power(int exp) {
		BigInteger b1 = new BigInteger("12321000");
		BigInteger res = b1.pow(exp);
		return res;
    }
    public static BigInteger multiply() {
        BigInteger one = new BigInteger("231243143214233123415");
        BigInteger two = new BigInteger("3434315425352154314232");
        return one.multiply(two);
    }
}
