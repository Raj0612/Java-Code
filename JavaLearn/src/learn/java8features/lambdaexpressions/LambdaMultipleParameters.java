package learn.java8features.lambdaexpressions;

public class LambdaMultipleParameters {
    interface FuncInter1 {
        int operation(int a, int b);
    }

    interface FuncInter2 {
        void sayMessage(String message);
    }

    private int operate(int a, int b, FuncInter1 fobj) {
        return fobj.operation(a, b);
    }

    public static void main(String[] args) {
        FuncInter1 add = (int x, int y) -> x + y;
        System.out.println("Addition is " + add.operation(5, 4));
        FuncInter1 multiply = (int x, int y) -> x * y;
        LambdaMultipleParameters tobj = new LambdaMultipleParameters();
        System.out.println("Addition is "
                + tobj.operate(6, 3, add));

        System.out.println("Multiplication is "
                + tobj.operate(6, 3, multiply));

        FuncInter2 fobj1 = message
                -> System.out.println("Hello " + message);
        fobj1.sayMessage("Geek");

        FuncInter2 fobj = (String message)
                -> System.out.println("Hello " + message);
        fobj.sayMessage("Geek");
    }
}
