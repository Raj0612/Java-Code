package DesignPatterns.Behavioral.Strategy.geekforgeeks.solution;


public class Document {
    private String text;
    private SaveStrategy saveStrategy;

    public Document(String text) {
        this.text = text;
    }

    public void setSaveStrategy(SaveStrategy saveStrategy) {
        this.saveStrategy = saveStrategy;
    }

    public void save(){
        if(saveStrategy != null){
            saveStrategy.save(text);
        }else {
            System.out.println("Save Strategy not set");
        }
    }
}
