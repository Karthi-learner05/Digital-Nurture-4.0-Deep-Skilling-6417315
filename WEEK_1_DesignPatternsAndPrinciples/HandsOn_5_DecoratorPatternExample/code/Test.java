package WEEK_1_DesignPatternsAndPrinciples.HandsOn_5_DecoratorPatternExample.code;

public class Test {
        public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier = new SmsNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);
        notifier.send("Hello, I am Karthikeyan");
    }
}
