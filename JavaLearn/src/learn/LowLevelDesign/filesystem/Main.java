package learn.LowLevelDesign.filesystem;

public class Main {
    public static void main(String[] args) {
        Folder desktop = new Folder("Desktop");
        Folder java = new Folder("Java");
        Folder python = new Folder("Python");
        Folder dsa = new Folder("DSA");

        File java1 = new File("Test1.java", 10);
        File java2 = new File("Test2.java", 20);
        File dsa1 = new File("dsa1.java", 30);
        File dsa2 = new File("dsa2.java", 40);
        File python1 = new File("Test1.py", 15);
        File python2 = new File("Test2.py", 25);
    }
}
