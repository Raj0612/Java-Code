package learn.javabasic.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            //testException(-5);
            testException(5);
           // testException(15);
        } catch(FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } finally {
            System.out.println("Releasing resources");
        }
        testException(15);
    }

    public static void testException(int i) throws FileNotFoundException, IOException {
        if(i==5) {
            System.out.println("Pass");

        }else if (i < 0) {
            FileNotFoundException myException = new FileNotFoundException("Negative Integer " + i);
            throw myException;
        } else if (i > 10) {
            throw new IOException("Only supported for index 0 to 10");
        }
    }
}
