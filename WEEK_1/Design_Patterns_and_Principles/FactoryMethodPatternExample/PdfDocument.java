package WEEK_1.Design_Patterns_and_Principles.FactoryMethodPatternExample;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("PDF Document Created...");
    }
}
