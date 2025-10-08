package solidprinciples.dependencyinversion.sample1.solution;

public class MakePayment {

    public static void main(String[] args) {
        Ebay ebay = new Ebay();
        PaymentProcessor paymentProcessor = new PaymentProcessor(ebay);
        paymentProcessor.processPayment(70);

        PaypalGateway paypalGateway = new PaypalGateway();
        PaymentProcessor paymentProcessor1 = new PaymentProcessor(paypalGateway);
        paymentProcessor1.processPayment(80);
    }
}
