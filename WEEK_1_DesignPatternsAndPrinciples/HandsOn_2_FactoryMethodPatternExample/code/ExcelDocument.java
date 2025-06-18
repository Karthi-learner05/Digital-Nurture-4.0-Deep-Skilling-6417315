package WEEK_1_DesignPatternsAndPrinciples.HandsOn_2_FactoryMethodPatternExample.code;

public class ExcelDocument implements Document {
    public void open() {
        System.out.println("Excel Document Created...");
    }
}

