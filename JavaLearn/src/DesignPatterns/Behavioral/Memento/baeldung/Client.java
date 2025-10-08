package DesignPatterns.Behavioral.Memento.baeldung;

public class Client {

    public static void main(String[] args) {

        TextWindow textWindow = new TextWindow();
        TextEditor textEditor = new TextEditor(textWindow);
        textEditor.write("The Memento Design Pattern\n");
        textEditor.write("How to implement it in Java?\n");
        textEditor.hitSave();


        textEditor.write("Buy milk and eggs before coming home\n");
        System.out.println("Text After saving memento");
        textEditor.hitUndo();
        System.out.println("Text After Undo memento");
        textEditor.print();
    }
}
