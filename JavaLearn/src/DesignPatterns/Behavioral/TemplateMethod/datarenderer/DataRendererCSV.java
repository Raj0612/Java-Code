package DesignPatterns.Behavioral.TemplateMethod.datarenderer;

public class DataRendererCSV extends DataRenderer{
    @Override
    public String readData() {
        return "CSV Data";
    }

    @Override
    public String processData(String data) {
        return "Processed " + data;
    }
}
