package learn.java8features.lambdaexpressions;

interface display {
    void show(String msg);
    default int doSum(int a, int b) { return a + b; }
}
public class FunctioanlIntf implements display{

    public void show(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        FunctioanlIntf obj = new FunctioanlIntf();
        obj.show("Hello World!");
        System.out.println(obj.doSum(2, 3));
    }
}
