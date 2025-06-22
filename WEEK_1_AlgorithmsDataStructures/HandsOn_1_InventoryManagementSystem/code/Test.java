package WEEK_1_AlgorithmsDataStructures.HandsOn_1_InventoryManagementSystem.code;

public class Test {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(101, "Keyboard", 20, 999.99));
        manager.addProduct(new Product(102, "Mouse", 50, 499.50));

        manager.displayInventory();

        manager.updateProduct(101, "Mechanical Keyboard", 25, 1299.00);
        manager.deleteProduct(102);

        manager.displayInventory();
    }
}

