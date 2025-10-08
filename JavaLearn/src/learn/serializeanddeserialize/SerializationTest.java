package learn.serializeanddeserialize;

import java.io.IOException;

public class SerializationTest {

    public static void main(String[] args) throws IOException {
        String fileName ="C:\\Mine\\Tutorial\\Java\\employee.ser";
        Employee emp =  new Employee();

        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);

        SerializationUtil.serialize(emp, fileName);


    }
}
