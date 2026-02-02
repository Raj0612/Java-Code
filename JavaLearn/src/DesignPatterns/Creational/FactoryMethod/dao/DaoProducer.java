package DesignPatterns.Creational.FactoryMethod.dao;

public class DaoProducer {

    public static DaoAbstractFactory produce(String factoryType){
        DaoAbstractFactory abstractFactory = null;

        if(factoryType.equals("XML"))
            abstractFactory = new DaoXMLFactory();
        else if(factoryType.equals("DB"))
            abstractFactory = new DaoDBFactory();

        return abstractFactory;
    }
}
