public class Test {
    public static void main(String[] args) {
        PayPalGateway paypal=new PayPalGateway();
        PaymentProcessor byPaypal=new PayPalAdapter(paypal, 150.2);
        byPaypal.processPayment();

        StripPayGateway strippay=new StripPayGateway();
        PaymentProcessor byStrippay=new StripPayAdapter(strippay, 320.54);
        byStrippay.processPayment();

        RazorPayGateway razor=new RazorPayGateway();
        PaymentProcessor byRazor=new RazorPayAdapter(razor, 1872.00);
        byRazor.processPayment();

        UpiPaymentGateway upi=new UpiPaymentGateway();
        PaymentProcessor byUpi=new UpiPaymentAdapter(upi, 6025);
        byUpi.processPayment();
    }
}
