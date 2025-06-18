package WEEK_1_DesignPatternsAndPrinciples.HandsOn_2_FactoryMethodPatternExample.code;

public class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

