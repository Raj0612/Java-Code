package DesignPatterns.Creational.FactoryMethod.dao;

public class DaoDBEmployee implements Dao {

    @Override
    public void save() {
        System.out.println("Saving Employee in DB");
    }
}
