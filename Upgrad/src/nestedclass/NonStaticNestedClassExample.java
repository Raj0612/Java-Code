package nestedclass;

class NonStaticNestedClassA{
    static int x = 10;
    int y = 20;
    private static int z = 30;

    void print(){
        System.out.println("Method in outer Class");
    }
    class NonStaticNestedClassB {
        void get(){
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            System.out.println("z: " + z);
        }

        void printMessage(){
            print();
        }
    }
}
public class NonStaticNestedClassExample {
    public static void main(String[] args) {
        NonStaticNestedClassA objA = new NonStaticNestedClassA();
        NonStaticNestedClassA.NonStaticNestedClassB obj = objA.new NonStaticNestedClassB();
        NonStaticNestedClassA.NonStaticNestedClassB objB = new NonStaticNestedClassA().new NonStaticNestedClassB();

        obj.get();
        objB.printMessage();
    }
}
