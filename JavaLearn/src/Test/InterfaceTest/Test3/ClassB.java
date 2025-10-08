package Test.InterfaceTest.Test3;

public class ClassB implements Test{

    Test test;

    ClassB(Test test){
        this.test= test;

    }

    @Override
    public void getRole() {
        System.out.println("ClassB getRole");
    }
}
