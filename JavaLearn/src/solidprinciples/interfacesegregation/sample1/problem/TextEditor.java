package solidprinciples.interfacesegregation.sample1.problem;

public class TextEditor {
    private Document document;

    public TextEditor(Document document) {
        this.document = document;
    }

    public void edit() {
        document.open();
        // Perform text editing
        document.save();
    }
}