package learn.serializeanddeserialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamExample {

    public static void main(String[] args) {
        try {
            FileInputStream is = new FileInputStream("C:\\Mine\\Tutorial\\Java\\EmployeeObject.ser");
            ObjectInputStream ois = new ObjectInputStream(is);
            Employee emp = (Employee) ois.readObject();
            System.out.println(emp.toString());
            ois.close();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
