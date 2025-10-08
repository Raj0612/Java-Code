package DesignPatterns.Creational.Singleton;

import java.io.Serializable;

public class DateUtilCloneNonSupport implements Serializable, Cloneable {
    static volatile DateUtilCloneNonSupport instance;
    private DateUtilCloneNonSupport(){

    }

    public static DateUtilCloneNonSupport getInstance(){
        if(instance == null){
            synchronized (DateUtilCloneNonSupport.class){
                if(instance == null)
                    instance = new DateUtilCloneNonSupport();

            }
        }
        return instance;
    }

    //to read the same object
    public Object readResolve(){
        return instance;
    }

    //to prevent clone
    @Override
    public Object clone() throws  CloneNotSupportedException{
        throw new CloneNotSupportedException();
    }

}
