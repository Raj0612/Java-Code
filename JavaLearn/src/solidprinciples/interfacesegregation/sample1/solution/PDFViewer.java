package solidprinciples.interfacesegregation.sample1.solution;

public class PDFViewer {

    private ReadableDocument document;

    public PDFViewer(ReadableDocument document) {
        this.document = document;
    }

    public void view() {
        document.open();
        // Display PDF content
    }
}
