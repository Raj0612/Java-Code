package DesignPatterns.Behavioral.Strategy.geekforgeeks.solution;

public class HTMLStrategy implements SaveStrategy{
    @Override
    public void save(String text) {
        System.out.println("Saving as HTML <html><body> " + text + "</body></html>");
    }
}
