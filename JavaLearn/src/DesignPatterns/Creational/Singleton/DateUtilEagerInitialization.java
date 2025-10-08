package DesignPatterns.Creational.Singleton;

public class DateUtilEagerInitialization {
    private static final DateUtilEagerInitialization instance = new DateUtilEagerInitialization();

  /*  static{
        instance = new DateUtilEagerInitialization();
    }*/
    private DateUtilEagerInitialization(){

    }

    public static DateUtilEagerInitialization getInstance(){
        return instance;
    }
}
