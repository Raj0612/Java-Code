package DesignPatterns.Behavioral.ChainOfResponsibility.numberprocessor;

public class ZeroProcessor extends Processor {
    public ZeroProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Number request) {
        System.out.println("ZeroProcessor process");
        if (request.getNumber() == 0) {
            System.out.println("ZeroProcessor : " + request.getNumber());
        } else {
            super.process(request);
        }
    }
}
