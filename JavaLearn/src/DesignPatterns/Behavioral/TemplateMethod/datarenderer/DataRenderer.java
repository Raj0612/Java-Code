package DesignPatterns.Behavioral.TemplateMethod.datarenderer;

public abstract class DataRenderer {

    public void render(){
        String readData = readData();
        String processedData = processData(readData);
        System.out.println("processedData " + processedData);
    }
    public abstract String readData();

    public abstract String processData(String data);
}
