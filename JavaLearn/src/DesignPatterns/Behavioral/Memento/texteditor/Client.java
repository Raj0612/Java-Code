package DesignPatterns.Behavioral.Memento.texteditor;

public class Client {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();
        textEditor.appendText("Hello");
        System.out.println(textEditor.getText()); // Output: Hello
        // Save the state
        history.saveState(textEditor.save());
        textEditor.appendText(" World");
        System.out.println(textEditor.getText()); // Output: Hello World
        // Restore the previous state
        TextEditorMemento memento = history.restoreState();
        if (memento != null) {
            textEditor.restore(memento);
        }
        System.out.println(textEditor.getText()); // Output: Hello
    }
}
