package Test.InterfaceTest.Test3;

public class Client {

    public static void main(String[] args) {
        ClassA classA = new ClassA("TestRole");
        ClassB classB = new ClassB( classA);

        classB.test.getRole();

    }
}
