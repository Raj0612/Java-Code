package DesignPatterns.Creational.AbstractFactory.dao;

public class DaoXMLDept implements Dao {
    @Override
    public void save() {
        System.out.println("Saving Dept in XML");
    }
}
