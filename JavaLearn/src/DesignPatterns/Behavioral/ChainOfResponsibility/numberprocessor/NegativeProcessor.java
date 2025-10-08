package DesignPatterns.Behavioral.ChainOfResponsibility.numberprocessor;

public class NegativeProcessor extends Processor {
    public NegativeProcessor(Processor nextProcessor) {
        super(nextProcessor);

    }

    public void process(Number request) {
        System.out.println("NegativeProcessor process");
        if (request.getNumber() < 0) {
            System.out.println("NegativeProcessor : " + request.getNumber());
        } else {
            super.process(request);
        }
    }
}
