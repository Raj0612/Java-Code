package DesignPatterns.Behavioral.Memento.geekforgeeks;

public class Client {

    public static void main(String[] args) {
        Document document = new Document("Initial content ");
        History history = new History();

        // Write some content
        document.write("Additional content ");
        history.addMemento(document.createMemento());
        System.out.println("document: " + document.getContent());
        // Write more content
        document.write("More content ");
        history.addMemento(document.createMemento());
        System.out.println("document1: " + document.getContent());

        System.out.println("getMementoSize: " +history.getMementoSize());
        // Restore to previous state
        document.restoreFromMemento(history.getMemento(1));

        // Print document content
        System.out.println(document.getContent());


        document.restoreFromMemento(history.getMemento(0));
        System.out.println(document.getContent());
    }
}
