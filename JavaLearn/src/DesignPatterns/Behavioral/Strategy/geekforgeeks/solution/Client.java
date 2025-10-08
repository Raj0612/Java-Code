package DesignPatterns.Behavioral.Strategy.geekforgeeks.solution;

public class Client {

    public static void main(String[] args) {
        Document doc = new Document("text");
        SaveStrategy saveStrategy = new HTMLStrategy();
        doc.setSaveStrategy(saveStrategy);
        doc.save();
    }
}
