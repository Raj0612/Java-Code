package DesignPatterns.Structural.Adapter.socket;

/**
 * Target interface required by new client code
 * Target Interface
 */
public interface SocketAdapter {
    public Volt get120Volt();

    public Volt get12Volt();

    public Volt get3Volt();
}
