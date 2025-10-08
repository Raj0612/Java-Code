package DesignPatterns.Creational.Singleton;

import java.io.Serializable;

public class DateUtilSerializeHandle implements Serializable {
    private static volatile DateUtilSerializeHandle instance;
    private DateUtilSerializeHandle(){

    }

    public static DateUtilSerializeHandle getInstance(){
        if(instance == null){
            synchronized (DateUtilSerializeHandle.class){
                if(instance == null)
                    instance = new DateUtilSerializeHandle();

            }
        }
        return instance;
    }
    private int num =0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    //to read the same object
    public Object readResolve(){
        return instance;
    }
}
