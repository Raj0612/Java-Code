package learn.designpattern.dimitrinesteruk.creational.singletom;

public class Monostate {
    public static void main(String[] args) {
            CheifExecutiveOfficer ceo1 = new CheifExecutiveOfficer();
            ceo1.setAge(37);
            ceo1.setName("Raj");
        System.out.println("ceo1 " + ceo1);
        CheifExecutiveOfficer ceo2 = new CheifExecutiveOfficer();
        System.out.println("ceo2 " + ceo2);
        ceo2.setAge(38);
        ceo2.setName("Sekar");
        System.out.println("ceo2 " + ceo2);
        System.out.println("ceo1 " + ceo1);
    }
}

class CheifExecutiveOfficer{

    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        CheifExecutiveOfficer.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        CheifExecutiveOfficer.age = age;
    }

    @Override
    public String toString() {
        return "CheifExecutiveOfficer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

