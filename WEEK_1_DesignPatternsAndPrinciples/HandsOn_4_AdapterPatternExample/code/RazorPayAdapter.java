public class RazorPayAdapter implements PaymentProcessor{
    private RazorPayGateway razorpay;
    private double amount;
    public RazorPayAdapter(RazorPayGateway razorpay,double amount){
        this.amount=amount;
        this.razorpay=razorpay;
    }

    public void processPayment(){
        razorpay.SendToProvider(amount);;
    }
}
