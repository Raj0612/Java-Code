package DesignPatterns.Behavioral.Memento.texteditor;

import java.util.Stack;

// Caretaker
public class TextEditorHistory {

    private Stack<TextEditorMemento> history;
    public TextEditorHistory() {
        this.history = new Stack<>();
    }
    public void saveState(TextEditorMemento memento) {
        history.push(memento);
    }
    public TextEditorMemento restoreState() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
