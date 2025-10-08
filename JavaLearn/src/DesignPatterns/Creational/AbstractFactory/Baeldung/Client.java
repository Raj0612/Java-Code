package DesignPatterns.Creational.AbstractFactory.Baeldung;

public class Client {

    public static void main(String[] args) {
        Corporation corporation = new FutureVehicleCorporation();
        MotorVehicle motorVehicle = corporation.createMotorVehicle();
        motorVehicle.build();

        ElectricVehicle electricVehicle = corporation.createElectricVehicle();
        electricVehicle.build();


        Corporation nextGenCorporation = new NextGenCorporation();
        MotorVehicle motorVehicle1 = nextGenCorporation.createMotorVehicle();
        motorVehicle1.build();


        ElectricVehicle electricVehicle1 = corporation.createElectricVehicle();
        motorVehicle1.build();
    }

}
