package WEEK_1_DesignPatternsAndPrinciples.HandsOn_1_SingletonPatternExample.code;

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