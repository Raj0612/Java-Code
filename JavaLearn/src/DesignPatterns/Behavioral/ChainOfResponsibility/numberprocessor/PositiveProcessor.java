package DesignPatterns.Behavioral.ChainOfResponsibility.numberprocessor;

public class PositiveProcessor extends Processor {
    public PositiveProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Number request) {
        System.out.println("PositiveProcessor process");
        if (request.getNumber() > 0) {
            System.out.println("PositiveProcessor : " + request.getNumber());
        } else {
            super.process(request);
        }
    }
}
