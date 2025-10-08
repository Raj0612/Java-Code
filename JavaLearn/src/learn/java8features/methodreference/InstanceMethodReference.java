package learn.java8features.methodreference;

interface Sayable {
    void say();
}
public class InstanceMethodReference {

    public void saySomething() {
        System.out.println("Hello, this is non-static method.");
    }
    public static void main(String[] args) {

        InstanceMethodReference  methodReference = new InstanceMethodReference();
        Sayable sayable = methodReference::saySomething;
        sayable.say();

        Sayable sayable1 = new InstanceMethodReference()::saySomething;
        sayable1.say();
    }
}
