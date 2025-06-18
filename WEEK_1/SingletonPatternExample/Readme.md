# Singleton Pattern Example

The Singleton Pattern ensures that a class has only one instance in the whole application and provides a global point of access to it.


## Logger Class
Logger class maintains an single instance throughout the life cycle called ```instance```. It does not allows for creation of new instance by making the ```Logger()``` constructor as private. It also balance the thread safe by using ```synchronized```.
``` java
public class Logger {
    private static Logger instance;
    private Logger() {
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized(Logger.class){
                if(instance==null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    public void log(){
        System.out.println("Logged as "+instance);
    }
}
```
## Test Class
Test class uses two objects ```logger1``` and ```logger2``` that uses same instances that was get by the ```getInstance()``` method. It demonstrate that two objects are logged but they refering to the same instances.
``` java
public class Test {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log();
        logger2.log();
        if (logger1 == logger2) {
            System.out.println("Same Instances");
        } else {
            System.out.println("Different Instances");
        }
    }
}
```

## Output
The two loggers are logged. They are refering to the same instance.
```
Logged as WEEK_1.SingletonPatternExample.Logger@7344699f
Logged as WEEK_1.SingletonPatternExample.Logger@7344699f
Same Instances
```

