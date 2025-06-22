package WEEK_1_DesignPatternsAndPrinciples.HandsOn_5_DecoratorPatternExample.code;

public class SlackNotifierDecorator extends NotifierDecorator{
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        sendSlackMessage(message);
    }

    private void sendSlackMessage(String message) {
        System.out.println("Notifications from Slack for the message  : " + message);
    }
}
