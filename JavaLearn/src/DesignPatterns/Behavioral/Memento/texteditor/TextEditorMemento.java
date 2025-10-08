package DesignPatterns.Behavioral.Memento.texteditor;

// Memento
public class TextEditorMemento {

    private String text;
    public TextEditorMemento(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
