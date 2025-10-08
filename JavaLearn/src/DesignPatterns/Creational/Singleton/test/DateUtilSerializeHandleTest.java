package DesignPatterns.Creational.Singleton.test;


import DesignPatterns.Creational.Singleton.DateUtilSerializeHandle;

import java.io.*;

public class DateUtilSerializeHandleTest {

    public static void main(String[] args) throws FileNotFoundException {
        DateUtilSerializeHandle dateUtil =  DateUtilSerializeHandle.getInstance();
        System.out.println("dateUtil " + dateUtil);
        dateUtil.setNum(100);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("C:\\Mine\\Tutorial\\Java\\dateUtil1.ser")));
            oos.writeObject(dateUtil);
            dateUtil.setNum(200);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("C:\\Mine\\Tutorial\\Java\\dateUtil1.ser")));
            DateUtilSerializeHandle readObj = (DateUtilSerializeHandle)ois.readObject();

            System.out.println("readObj dateUtil " + readObj);

            System.out.println("Object Equal " + dateUtil.equals(readObj));

            System.out.println("Obj Num " + readObj.getNum() + " act obj num " + dateUtil.getNum());

            oos.close();
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
