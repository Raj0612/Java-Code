package DesignPatterns.Structural.Adapter.socket;


/**
 * An existing class used in our system
 * Adaptee
 */
public class Socket {
    public Volt getVolt(){
        return new Volt(120);
    }
}
