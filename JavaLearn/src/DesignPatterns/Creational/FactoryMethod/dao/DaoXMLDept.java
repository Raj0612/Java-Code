package DesignPatterns.Creational.FactoryMethod.dao;

public class DaoXMLDept implements Dao {
    @Override
    public void save() {
        System.out.println("Saving Dept in XML");
    }
}
