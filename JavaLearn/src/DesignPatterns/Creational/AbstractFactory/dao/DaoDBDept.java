package DesignPatterns.Creational.AbstractFactory.dao;

public class DaoDBDept implements Dao {
    @Override
    public void save() {
        System.out.println("Saving Dept in DB");
    }
}
