package DesignPatterns.Creational.Prototype.educative;

public class Client {

    public static void main(String[] args) {
        IAircraftPrototype prototype = new F16();

        // Create F16-A
        IAircraftPrototype f16A = prototype.clone();
        f16A.setEngine(new F16AEngine());

        System.out.println("Engine " + f16A.getEngine().getName());

        // Create F16-B
        IAircraftPrototype f16B = prototype.clone();
        f16B.setEngine(new F16BEngine());

        System.out.println("Engine " + f16B.getEngine().getName());
    }

}
