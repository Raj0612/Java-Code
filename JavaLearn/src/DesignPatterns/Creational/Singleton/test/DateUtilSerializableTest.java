package DesignPatterns.Creational.Singleton.test;


import DesignPatterns.Creational.Singleton.DateUtilSerializable;

import java.io.*;

public class DateUtilSerializableTest {

    public static void main(String[] args) throws FileNotFoundException {
        DateUtilSerializable dateUtil =  DateUtilSerializable.getInstance();
        dateUtil.setNum(100);
        System.out.println("dateUtil " + dateUtil);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("C:\\Mine\\Tutorial\\Java\\dateUtil.ser")));
            oos.writeObject(dateUtil);
            dateUtil.setNum(200);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("C:\\Mine\\Tutorial\\Java\\dateUtil.ser")));
            DateUtilSerializable readObj = (DateUtilSerializable)ois.readObject();

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
