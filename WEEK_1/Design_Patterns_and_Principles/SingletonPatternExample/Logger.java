package WEEK_1.Design_Patterns_and_Principles.SingletonPatternExample;

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