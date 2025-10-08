package learn.java8features.staticanddefaultmethods;

interface MyData {

    default void print(String str) {
        if (!isNull(str))
            System.out.println("MyData Print::" + str);
    }

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }
}
public class StaticMethodExample implements MyData{

    public boolean isNull(String str) {
        System.out.println("Impl Null Check");

        return str == null ? true : false;
    }

    public static void main(String args[]){
        StaticMethodExample obj = new StaticMethodExample();
        obj.print("");
        obj.isNull("abc");
    }
}
