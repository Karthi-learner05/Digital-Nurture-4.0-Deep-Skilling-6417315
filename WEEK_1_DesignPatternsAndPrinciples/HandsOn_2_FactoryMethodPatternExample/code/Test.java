package WEEK_1_DesignPatternsAndPrinciples.HandsOn_2_FactoryMethodPatternExample.code;

import java.util.Scanner;

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