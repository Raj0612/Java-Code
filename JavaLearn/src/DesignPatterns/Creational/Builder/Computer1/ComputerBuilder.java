package DesignPatterns.Creational.Builder.Computer1;


public class ComputerBuilder {

    public String HDD;
    public String RAM;

    // optional parameters
    public boolean isGraphicsCardEnabled;
    public boolean isBluetoothEnabled;

    public ComputerBuilder(String hdd, String ram){
        this.HDD=hdd;
        this.RAM=ram;
    }

    public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
        this.isGraphicsCardEnabled = isGraphicsCardEnabled;
        return this;
    }

    public ComputerBuilder bluetoothEnabled(boolean isBluetoothEnabled) {
        this.isBluetoothEnabled = isBluetoothEnabled;
        return this;
    }

    public Computer build(){

        return  new Computer(this);

    }
}
