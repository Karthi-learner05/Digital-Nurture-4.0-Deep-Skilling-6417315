public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;
    private double amount;
    public PayPalAdapter(PayPalGateway paypal,double amount){
        this.paypal=paypal;
        this.amount=amount;
    }
    public void processPayment(){
        paypal.MakePayment(amount);
    }
}
