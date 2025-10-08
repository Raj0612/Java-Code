package DesignPatterns.Behavioral.ChainOfResponsibility.numberprocessor;

public abstract class Processor {
    private Processor nextProcessor;

    public Processor(Processor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void process(Number request){
        System.out.println("Processor process nextProcessor " + nextProcessor);
        if(nextProcessor != null)
            nextProcessor.process(request);
    }
}
