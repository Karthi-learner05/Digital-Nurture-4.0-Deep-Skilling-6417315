# DECORATOR PATTERN EXAMPLE

This pattern involves in the adding new features to the existing system without modification of the existing classes.

## Notifier Interface

This was the common interface shared by the all notification system classes.

```Notifier.java```

``` java

public interface Notifier {
    void send(String msg);
}

```

## E-Mail Notifier

This is the raw-existing notifier system.

```EmailNotifier.java```

``` java

public class EmailNotifier implements Notifier{
    public void send(String msg)
    {
        System.out.println("\nNotifications from E-Mail for the message : "+msg);
    }
}

```

## Notifier Decorator

This class is responsible for wrapping the Decorations made for the notifications.

```NotifierDecorator.java```

``` java

public class NotifierDecorator implements Notifier{
    protected Notifier wrapedNotifier;

    public NotifierDecorator(Notifier notifier){
        this.wrapedNotifier=notifier;
    }

    public void send(String msg){
        wrapedNotifier.send(msg);
    }
}

```

## Decorators

These are the add up on decorators to the existing Notification system.

```SmsNotifierDecorator.java```

``` java

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

```

```SlackNotifierDecorator.java```

``` java

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

```

## Client Code

This is the code visible to the users and clients.

```Test.java```

``` java

public class Test {
        public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier = new SmsNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);
        notifier.send("Hello, I am Karthikeyan");
    }
}

```