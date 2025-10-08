package Test.InterfaceTest.Test2;

public class ClassA implements Test{

    public String role;

    ClassA(String role){
        this.role = role;
    }


    @Override
    public void getRole() {
        System.out.println("CLassA role " + role);
    }
}
