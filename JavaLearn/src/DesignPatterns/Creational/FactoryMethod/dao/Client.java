package DesignPatterns.Creational.FactoryMethod.dao;

public class Client {
    public static void main(String[] args) {

        DaoAbstractFactory abstractFactory = DaoProducer.produce("XML");

        Dao dao = abstractFactory.createDao("Emp");
        dao.save();
    }
}
