package WEEK_1.Design_Patterns_and_Principles.FactoryMethodPatternExample;

public class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

