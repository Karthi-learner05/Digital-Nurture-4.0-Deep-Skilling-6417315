package WEEK_1_DesignPatternsAndPrinciples.HandsOn_2_FactoryMethodPatternExample.code;

public class DocumentFactoryProvider {
    public static DocumentFactory getFactory(String type) {
        switch (type.toLowerCase()) {
            case "word":
                return new WordDocumentFactory();
            case "pdf":
                return new PdfDocumentFactory();
            case "excel":
                return new ExcelDocumentFactory();
            default:
                throw new IllegalArgumentException("Error: Unsupported document type! " + type);
        }
    }
}
