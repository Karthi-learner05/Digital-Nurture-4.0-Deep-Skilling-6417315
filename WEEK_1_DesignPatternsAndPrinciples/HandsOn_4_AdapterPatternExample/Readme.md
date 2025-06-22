# ADAPTER PATTERN EXAMPLE

Adapter pattern involves in accepting the Third-part API to connect with user desired incompaitable class using the adapter class.

## Target Interface

This was the Original payment processing interface to connect with the Adapters.

```PaymentProcessor.java```

``` java

public interface PaymentProcessor{
    void processPayment();
}

```

## Adaptee Classes

These are the ```Third parties``` which uses their own functions to transact payments.

```PayPalGateway.java```

``` java

public class PayPalGateway {
    public void MakePayment(double amount){
        System.out.println("Payment made through Paypal was : "+amount+"$");
    }
}

```

```RazorPayGateway.java```

``` java

public class RazorPayGateway {
    public void SendToProvider(double amount){
        System.out.println("Razorpay sended your payment of Rs."+amount+" to the payment method");
    }
}

```

```StripPayGateway.java```

``` java

public class StripPayGateway {
    public void sendStrip(double amount){
        System.out.println("StripPay sended your payment of "+amount+"$");
    }
}

```

```UpirPaymentGateway.java```

``` java

public class UpiPaymentGateway {
    public void SendtoUpi(double amount){
        System.out.println("Payment of Rs."+amount+" sended to the UPI ID");
    }
}

```

## Adapter Classes

These classes are responsible for adapting the ```Third Parties``` to the ```PaymentProcessor```.

```PaypalAdapter.java```

``` java

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

```

```RazorPayAdapter.java```

``` java

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

```

```StripPayAdapter.java```

``` java

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

```

```UpiPaymentAdapter.java```

``` java

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

```

## Client Code

This was the code which is visible to the useres and clients which demostrate the ```Adapter Pattern```.

```Test.java```

``` java

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

```