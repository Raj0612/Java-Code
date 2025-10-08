package Test.InterfaceTest.Test3;


public class ClassA implements Test{

    public String role;

    ClassA(String role){
        this.role = role;
    }


    @Override
    public void getRole() {
        System.out.println("ClassA role " + role);
    }


    public void getTestRole() {
        System.out.println("ClassA testRole ");
    }
}
