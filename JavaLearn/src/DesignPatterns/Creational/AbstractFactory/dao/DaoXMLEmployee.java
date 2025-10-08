package DesignPatterns.Creational.AbstractFactory.dao;

public class DaoXMLEmployee implements Dao {
    @Override
    public void save() {
        System.out.println("Saving Employee in XML");
    }
}

