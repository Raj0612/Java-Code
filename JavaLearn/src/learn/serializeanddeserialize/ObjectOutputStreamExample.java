package learn.serializeanddeserialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamExample {
    public static void main(String[] args) {
        Employee emp =  new Employee();

        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);
        System.out.println(emp);

        try {
            FileOutputStream fos = new FileOutputStream("C:\\Mine\\Tutorial\\Java\\EmployeeObject.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // write object to file
            oos.writeObject(emp);
            System.out.println("Done");
            // closing resources
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
