package DesignPatterns.Creational.FactoryMethod.dao;

public class DaoXMLFactory extends DaoAbstractFactory {
    @Override
    public Dao createDao(String type) {
        Dao dao = null;
        if(type.equals("Emp"))
            dao = new DaoXMLEmployee();
        else if(type.equals("Dept"))
            dao = new DaoXMLDept();

        return dao;
    }
}
