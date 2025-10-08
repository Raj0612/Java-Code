package learn.clone;

public class DataTypeCopyExample {

    public static void main(String[] args) {
        int x = 9;
        int y = x;

        System.out.println("The value of x & y are: " + x + ", " + y);

        y = 10;
        System.out.println("The value of x & y are: " + x + ", " + y);

        boolean b1 = false;
        boolean b2 = b1;
        System.out.println("The value of b1 & b2 are: " + b1 + ", " + b2);

        b2 = true;
        System.out.println("The value of b1 & b2 are: " + b1 + ", " + b2);
    }
}
