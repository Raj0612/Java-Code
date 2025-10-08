package nestedclass;

class StaticNestedClassA{
    static int x = 10;
    int y = 20;
    private static int z = 30;

    void print(){
        System.out.println("Method in outer Class");
    }

    static void staticPrint(){
        System.out.println("Method in outer Class of StaticNestedClass");
    }
    static class StaticNestedClassB {
        void get()  {
            System.out.println("x: " + x);
            System.out.println("z: " + z);
        }

        void getOuterClassVariable(){
            StaticNestedClassA objA = new StaticNestedClassA();
            System.out.println("Outer Class Variable in Nested Class " + objA.y);
        }

        void printMessage(){
           // print();
            staticPrint();
        }
    }
}
public class StaticNestedClassExample {

    public static void main(String[] args) {
        StaticNestedClassA.StaticNestedClassB obj = new StaticNestedClassA.StaticNestedClassB();
        obj.get();
        obj.getOuterClassVariable();
        obj.printMessage();
        StaticNestedClassA objA = new StaticNestedClassA();
        System.out.println("Outer Class Variable " + objA.y);
    }
}
