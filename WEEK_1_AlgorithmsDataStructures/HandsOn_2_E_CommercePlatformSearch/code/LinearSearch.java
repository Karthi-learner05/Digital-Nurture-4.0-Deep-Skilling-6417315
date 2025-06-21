package WEEK_1_AlgorithmsDataStructures.HandsOn_2_E_CommercePlatformSearch.code;

public class LinearSearch implements Search {
    public void search(String str, Product[] products) {
        boolean found = false;
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(str)) {
                System.out.println("Product found:-\nName      : " + p.getProductName() + "\nID        : " + p.getProductId()+"\nCategory  : " + p.getCategory());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found");
        }
        
    }
}