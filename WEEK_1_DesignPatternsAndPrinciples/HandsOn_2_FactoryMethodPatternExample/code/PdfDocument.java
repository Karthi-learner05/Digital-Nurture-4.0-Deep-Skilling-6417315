package WEEK_1_DesignPatternsAndPrinciples.HandsOn_2_FactoryMethodPatternExample.code;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("PDF Document Created...");
    }
}
