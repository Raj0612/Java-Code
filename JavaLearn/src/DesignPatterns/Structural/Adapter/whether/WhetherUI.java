package DesignPatterns.Structural.Adapter.whether;

public class WhetherUI {
    public void showTemp(int zipcode){
        WhetherAdapter adapter = new WhetherAdapter();
        System.out.println("Temp " + adapter.findTemp(zipcode));
    }
}
