public class StripPayAdapter implements PaymentProcessor {
    private StripPayGateway strippay;
    private double amount;
    public StripPayAdapter(StripPayGateway strippay,double amount){
        this.strippay=strippay;
        this.amount=amount;
    }

    public void processPayment(){
        strippay.sendStrip(amount);
    }
}
