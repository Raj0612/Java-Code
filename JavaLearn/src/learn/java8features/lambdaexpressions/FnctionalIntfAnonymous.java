package learn.java8features.lambdaexpressions;

@FunctionalInterface
interface Cab {
    void bookCab();
}
public class FnctionalIntfAnonymous {
    public static void main(String[] args) {
        Cab cab = new Cab() {
            @Override
            public void bookCab() {
                System.out.println(
                        "Booking Successful!! Arriving Soon!!");
            }
        };
        cab.bookCab();
    }
}

