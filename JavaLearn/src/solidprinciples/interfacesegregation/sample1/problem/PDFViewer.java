package solidprinciples.interfacesegregation.sample1.problem;

public class PDFViewer {
    private Document document;

        public PDFViewer(Document document) {
            this.document = document;
        }

        public void view() {
            document.open();
            // Display PDF content
        }
}