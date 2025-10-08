package DesignPatterns.Behavioral.TemplateMethod.datarenderer;

public class Client {
    public static void main(String[] args) {
        DataRenderer xmlRenderer = new DataRendererXML();
        xmlRenderer.render();
        DataRenderer csvRenderer = new DataRendererXML();
        csvRenderer.render();
    }
}
