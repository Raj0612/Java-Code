package DesignPatterns.Creational.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DateUtilReflectionProblem {

    public static void main(String[] args) {

        DateUtilSerializable dateUtil = DateUtilSerializable.getInstance();
        DateUtilSerializable dateUtil1 = null;
        System.out.println("dateUtil " + dateUtil + " hashcode " + dateUtil.hashCode());
        Constructor<?>[] declaredConstructors = DateUtilSerializable.class.getDeclaredConstructors();

        for(Constructor constructor: declaredConstructors){
            constructor.setAccessible(true);
            try {
                dateUtil1 = (DateUtilSerializable) constructor.newInstance();

            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println("dateUtil1 " + dateUtil1 + " hashcode " + dateUtil1.hashCode()) ;
    }
}
