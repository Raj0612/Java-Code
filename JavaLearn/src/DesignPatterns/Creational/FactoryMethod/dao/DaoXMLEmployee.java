package DesignPatterns.Creational.FactoryMethod.dao;

public class DaoXMLEmployee implements Dao {
    @Override
    public void save() {
        System.out.println("Saving Employee in XML");
    }
}

