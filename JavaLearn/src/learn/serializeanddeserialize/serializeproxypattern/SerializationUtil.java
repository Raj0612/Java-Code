package learn.serializeanddeserialize.serializeproxypattern;



import java.io.*;

public class SerializationUtil {
    public static Object deserialize(String fileName) throws IOException,  ClassNotFoundException {
        Data obj = null;
        try {
            FileInputStream is = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(is);
            obj = (Data) ois.readObject();
            System.out.println(obj.toString());
            ois.close();
            is.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  obj;
    }

    public static void serialize(Object obj, String fileName)  throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            System.out.println(obj.toString());
            System.out.println("Done");
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
