package WEEK_1_AlgorithmsDataStructures.HandsOn_2_E_CommercePlatformSearch.code;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch implements Search {
    public void search(String str, Product[] product) {
        Product[] products = product.clone();
        Arrays.sort(products, Comparator.comparing(p -> p.getProductName().toLowerCase()));
        int left = 0;
        int right = products.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];

            if (midProduct.getProductName().equalsIgnoreCase(str)) {
                System.out.println("Product found:-\nName      : " + midProduct.getProductName() + "\nID        : " + midProduct.getProductId()+"\nCategory  : " + midProduct.getCategory());
                found = true;
                break;
            } else if (midProduct.getProductName().compareToIgnoreCase(str) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Product not found");
        }
    }
    
}
