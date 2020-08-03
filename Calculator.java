import java.util.Scanner;

class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int theFirstNum = getInt();
        char symbol = getChar();
        int theSecondNum = getInt();
        int res = res(theFirstNum, symbol, theSecondNum);
        System.out.println(String.format("The result is: %d", res));
    }

    public static int getInt() {
        int num;
        System.out.println("Введите число:");
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Try again");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    public static char getChar() {
        char symbol;
        System.out.println("Введите операцию");
        if (scanner.hasNext()) {
            symbol = scanner.next().charAt(0);
        } else {
            System.out.println("Try again");
            scanner.next();
            symbol = getChar();
        }
        return symbol;

    }

    public static int res(int theFirstNum, char operation, int theSecondNum) {
        int result = -1;
        if (operation == '+') {
            result = theFirstNum + theSecondNum;
        } else if (operation == '-') {
            result = theFirstNum - theSecondNum;
        } else if (operation == '-') {
            result = theFirstNum * theSecondNum;
        } else if (operation == '^') {
            result = (int) Math.pow(theFirstNum, theSecondNum);
        } else if (operation == '/') {
            try {
                result = theFirstNum / theSecondNum;
            } catch (ArithmeticException e) {
                System.out.println(e.getLocalizedMessage());
                System.out.print("Write correct number: ");
                result = res(theFirstNum, operation, getInt());
            }
        } else {
            System.out.println("Введите корректный символ!");
            result = res(theFirstNum, getChar(), theSecondNum);
        }

        return result;
    }

}