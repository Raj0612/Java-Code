package DesignPatterns.Behavioral.Memento.geekforgeeks;

import java.util.ArrayList;
import java.util.List;

//CareTaker
public class History {

    private List<DocumentMemento> mementos;

    public History() {
        this.mementos = new ArrayList<>();
    }

    public void addMemento(DocumentMemento memento) {
        this.mementos.add(memento);
    }

    public DocumentMemento getMemento(int index) {
        return this.mementos.get(index);
    }

    public int getMementoSize(){
        return this.mementos.size();
    }
}
