package WEEK_1_DesignPatternsAndPrinciples.HandsOn_5_DecoratorPatternExample.code;

public class SmsNotifierDecorator extends NotifierDecorator{
    public SmsNotifierDecorator(Notifier notifier){
        super(notifier);
    }
    public void send(String msg){
        super.send(msg);
        sendSms(msg);
    }
    public static void sendSms(String msg){
        System.out.println("Notifications from SMS for the message    : " + msg);
    }
}
