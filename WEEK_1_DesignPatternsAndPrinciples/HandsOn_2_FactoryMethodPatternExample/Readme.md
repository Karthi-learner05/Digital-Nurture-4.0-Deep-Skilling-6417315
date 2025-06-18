# factory Method Pattern Example

The Factory Pattern is used to create objects without exposing the exact class name to the client code. Instead, we let a Factory class decide which object to create based on input.



## Document Interface
Document interface used to assign the primary functions to the Document classes

``` java
public interface Document {
void open();
}
```
## Document Factory Classes

```DocumentFactory``` was used to start the all other Document classes.

``` java
public abstract class DocumentFactory {
    public abstract Document createDocument();
}
```

```ExcelDocumentFactory``` is the document factory for Excel files used as an abstrat class.

``` java
public class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

```
```PDFDocumentFactory``` is the document factory for PDF files used as an abstrat class.

``` java
public class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}
```
```WordDocumentFactory``` is the document factory for Word files used as an abstrat class.

``` java
public class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}
```
## Original Classes
These classes are the actual implementation for the Clients that was hidden to users.

``` ExcelDocument ```
``` java
public class ExcelDocument implements Document {
    public void open() {
        System.out.println("Excel Document Created...");
    }
}
```
``` WordDocument ```
``` java
public class WordDocument implements Document {
    public void open() {
        System.out.println("Word Document Created...");
    }
}
```
``` PDFDocument ```
``` java
public class PdfDocument implements Document {
    public void open() {
        System.out.println("PDF Document Created...");
    }
}
```

## Document factory provider

This class is responsible for the selection of user wished Document object creation

``` java
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
```
## Test Class
This was the client side code used to check Factory method patter.
``` java
public class Test{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter document type (word/pdf/excel): ");
        String input = scanner.nextLine();
        scanner.close();
        try {
            DocumentFactory factory = DocumentFactoryProvider.getFactory(input);
            Document document = factory.createDocument();
            document.open();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
}
}
```

## Output
```Excel type accessing```

``` bash
Enter document type (word/pdf/excel): excel
Excel Document Created...
```

```PDF type accessing```

``` bash
Enter document type (word/pdf/excel): pdf
PDF Document Created...
```

```Word type accessing```

``` bash
Enter document type (word/pdf/excel): word
Word Document Created...
```

```Invalid document type accessing```

``` bash
Enter document type (word/pdf/excel): mp3
Error: Unsupported document type! mp3

```

