package DesignPatterns.Structural.Proxy.internet;

public class RealInternet implements Internet{
    @Override
    public void connectTo(String serverhost)  {
        System.out.println("Connecting to "+ serverhost);
    }
}
