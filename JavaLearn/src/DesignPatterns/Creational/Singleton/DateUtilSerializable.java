package DesignPatterns.Creational.Singleton;

import java.io.Serializable;

public class DateUtilSerializable implements Serializable {

    static volatile DateUtilSerializable instance;
    private DateUtilSerializable(){

    }

    public static DateUtilSerializable getInstance(){
        if(instance == null){
            synchronized (DateUtilSerializable.class){
                if(instance == null)
                    instance = new DateUtilSerializable();
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
}
