public class UpiPaymentAdapter implements PaymentProcessor{
    private UpiPaymentGateway upi;
    private double amount;
    public UpiPaymentAdapter(UpiPaymentGateway upi,double amount){
        this.upi=upi;
        this.amount=amount;
    }

    public void processPayment(){
        upi.SendtoUpi(amount);
    }
}
