package solidprinciples.dependencyinversion.sample1.solution;

interface PaymentGateway {
    void processPayment(double amount);
}

//High-level-module
class PaymentProcessor{
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(double amount){
        paymentGateway.processPayment(amount);
    }
}

//Low-level-module
class PaypalGateway implements  PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing payment of $" + amount + " via paypal");
    }
}


//Low-level-module
class Ebay implements PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing payment of $" + amount + " via ebay");
    }
}


