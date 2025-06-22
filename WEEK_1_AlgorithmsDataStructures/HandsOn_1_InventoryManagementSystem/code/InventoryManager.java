package WEEK_1_AlgorithmsDataStructures.HandsOn_1_InventoryManagementSystem.code;

import java.util.HashMap;

public class InventoryManager {
    private HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        if (inventory.containsKey(product.productId)) {
            System.out.println(product.productName+" already exists in Inventory");
        } else {
            inventory.put(product.productId, product);
            System.out.println(product.productName+" added to Inventory");
        }
    }

    public void updateProduct(int productId, String name, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.productName = name;
            product.quantity = quantity;
            product.price = price;
            System.out.println(product.productName+" updated ");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        Product product = inventory.get(productId);
        if (inventory.remove(productId) != null) {
            System.out.println("Deleted "+product.productName);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }
}

