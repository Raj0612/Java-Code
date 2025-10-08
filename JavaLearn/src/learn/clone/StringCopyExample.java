package learn.clone;

public class StringCopyExample {

    public static void main(String[] args) {
        String obj1 = new String("JavaTpoint is a 1very good site.");
        //shallow copy
        String obj2 = obj1;
        System.out.println("The hash code of obj1 is : " + obj1.hashCode() + " and obj2 is " + obj2.hashCode()) ;
        obj1 = "test";
        System.out.println("The hash code of obj1 is : " + obj1.hashCode() + " and obj2 is " + obj2.hashCode()) ;
        obj2 = "JavaTpoint is very good.";
        System.out.println("The hash code of obj1 is : " + obj1.hashCode() + " and obj2 is " + obj2.hashCode()) ;
    }
}
