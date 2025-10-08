package DesignPatterns.Creational.AbstractFactory.dao;

public class DaoDBFactory extends DaoAbstractFactory {
    @Override
    public Dao createDao(String type) {
        Dao dao = null;
        if(type.equals("Emp"))
            dao = new DaoDBEmployee();
        else if(type.equals("Dept"))
            dao = new DaoDBDept();

        return dao;
    }
}
