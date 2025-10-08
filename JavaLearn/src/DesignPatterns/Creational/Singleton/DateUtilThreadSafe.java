package DesignPatterns.Creational.Singleton;

public class DateUtilThreadSafe {


    static DateUtilThreadSafe instance;

  //  static volatile  DateUtilThreadSafe instance;
    private DateUtilThreadSafe(){

    }

    public static synchronized DateUtilThreadSafe getInstance(){
        if(instance == null)
            instance = new DateUtilThreadSafe();
        return instance;
    }

    public static  DateUtilThreadSafe getInstanceByBlock(){
        synchronized (DateUtilThreadSafe.class){
            if(instance == null)
                instance = new DateUtilThreadSafe();
        }

        return instance;
    }

    public static  DateUtilThreadSafe getInstanceThreadImprove(){

        if(instance == null){
            synchronized (DateUtilThreadSafe.class) {
                if(instance == null)
                  instance = new DateUtilThreadSafe();
            }
        }

        return instance;
    }
}
