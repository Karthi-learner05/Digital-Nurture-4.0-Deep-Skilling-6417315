package WEEK_1_DesignPatternsAndPrinciples.HandsOn_5_DecoratorPatternExample.code;

public class EmailNotifier implements Notifier{
    public void send(String msg)
    {
        System.out.println("\nNotifications from E-Mail for the message : "+msg);
    }
}