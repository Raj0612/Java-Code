package solidprinciples.dependencyinversion.sample1;

public class PaymentProcessor {

    private PayPalGateway payPalGateway;

    public PaymentProcessor(){
        this.payPalGateway = new PayPalGateway();
    }

    public void processPayment(double amount){
        payPalGateway.processPayment(amount);
    }
}

//Low Level Module
class PayPalGateway{
    public void processPayment(double amount){
        System.out.println("Processing payment of $" + amount + "via paypal");
    }
}
