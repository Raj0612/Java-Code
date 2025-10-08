package learn.serializeanddeserialize.externalize;

import java.io.*;

public class ExternalizationTest {
    public static void main(String[] args) {

        String fileName = "C:\\Mine\\Tutorial\\Java\\person.ser";
        Person person = new Person();
        person.setId(1);
        person.setName("Pankaj");
        person.setGender("Male");

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();
            System.out.println("Person Object write="+person);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person p = (Person)ois.readObject();
            ois.close();
            System.out.println("Person Object Read="+p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
