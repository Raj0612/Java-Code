package java11.privateInterfaceMethods;

interface Tennis{
    private static void hit(String stroke){
        System.out.println("Hitting a "+stroke);
    }
    private void smash(){ hit("smash"); }
    default void forehand(){ hit("forehand");
        smash();}
    static void backhand(){ 
       // smash();// static to instance not allowed! non-static method smash() cannot be referenced from a static context
        hit("backhand"); 
    }
}
public class SportTest implements Tennis{
    public static void main(String[] args) {
        new SportTest().forehand(); // Hitting a forehand
        Tennis.backhand();          // Hitting a backhand
       // new SportTest().hit();
       // new SportTest().smash();
    }
}



