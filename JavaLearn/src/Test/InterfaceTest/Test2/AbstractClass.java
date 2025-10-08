package Test.InterfaceTest.Test2;

public abstract class AbstractClass implements  Test{

    public String role;

    AbstractClass(String role){
        this.role = role;
    }
    @Override
    public void getRole() {
        System.out.println("AbstractClass role " + role);
    }


    public void getTestRole(){

        System.out.println("AbstractClass getTestRole " );
    }
}
