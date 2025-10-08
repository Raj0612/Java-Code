package learn.java8features.methodreference;

public interface ISayable {
    String say();

    public default void defaultMethod(){
        System.out.println("Isayable Default Method");
    }

    static void staticMethod(String msg){
        System.out.println(msg);
    }

    default void defaultMethod1(){
        System.out.println("Hello, this is default method");
    }
}
