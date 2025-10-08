package LowLevelDesign.GitLab.Shrayansh8.DesignOrderManagementSystem;


public class Payment {

   PaymentMode paymentMode;

   Payment(PaymentMode paymentMode){
       this.paymentMode = paymentMode;
   }

    public boolean makePayment(){
        return paymentMode.makePayment();
    }

}
