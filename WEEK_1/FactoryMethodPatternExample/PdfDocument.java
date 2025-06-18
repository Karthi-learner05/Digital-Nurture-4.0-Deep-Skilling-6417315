package WEEK_1.FactoryMethodPatternExample;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("PDF Document Created...");
    }
}
