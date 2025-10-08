package solidprinciples.interfacesegregation.sample1.solution;

public class TextEditor {

    private ReadableDocument document;

    public TextEditor(ReadableDocument document) {
        this.document = document;
    }

    public void edit() {
        document.open();
        // Perform text editing
    }
}
