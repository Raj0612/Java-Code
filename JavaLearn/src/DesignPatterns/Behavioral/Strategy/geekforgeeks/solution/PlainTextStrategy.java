package DesignPatterns.Behavioral.Strategy.geekforgeeks.solution;

public class PlainTextStrategy implements SaveStrategy{
    @Override
    public void save(String text) {
        System.out.println("Saving as plain text: " + text);
    }
}
