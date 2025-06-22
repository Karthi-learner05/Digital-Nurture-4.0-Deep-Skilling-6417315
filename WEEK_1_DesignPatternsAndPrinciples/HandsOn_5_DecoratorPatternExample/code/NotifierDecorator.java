package WEEK_1_DesignPatternsAndPrinciples.HandsOn_5_DecoratorPatternExample.code;

public class NotifierDecorator implements Notifier{
    protected Notifier wrapedNotifier;

    public NotifierDecorator(Notifier notifier){
        this.wrapedNotifier=notifier;
    }

    public void send(String msg){
        wrapedNotifier.send(msg);
    }
}
