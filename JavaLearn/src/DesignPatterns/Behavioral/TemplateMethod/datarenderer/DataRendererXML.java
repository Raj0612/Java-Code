package DesignPatterns.Behavioral.TemplateMethod.datarenderer;

public class DataRendererXML extends DataRenderer{
    @Override
    public String readData() {
        return "XML Data";
    }

    @Override
    public String processData(String data) {
        return "Processed " + data;
    }
}
