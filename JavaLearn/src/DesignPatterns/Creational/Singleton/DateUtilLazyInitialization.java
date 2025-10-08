package DesignPatterns.Creational.Singleton;

public class DateUtilLazyInitialization {

    private static DateUtilLazyInitialization instance;
    private DateUtilLazyInitialization(){

    }

    public static DateUtilLazyInitialization getInstance(){
        if(instance == null)
            instance = new DateUtilLazyInitialization();
        return instance;
    }
}
