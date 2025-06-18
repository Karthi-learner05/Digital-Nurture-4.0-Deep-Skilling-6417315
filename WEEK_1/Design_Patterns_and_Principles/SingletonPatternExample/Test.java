package WEEK_1.Design_Patterns_and_Principles.SingletonPatternExample;
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