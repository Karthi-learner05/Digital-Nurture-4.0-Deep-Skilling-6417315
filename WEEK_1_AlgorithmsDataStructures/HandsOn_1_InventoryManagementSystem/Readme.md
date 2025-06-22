# INVENTORY MANAGEMENT SYSTEM

This involves in managing the inventory with management options such as ```add```,```update``` and ```delete``` the products.

## Why Data Structures and Algorithms essential ?

In an inventory system:

->Quick access to products (by ID, name) is crucial.

->We need to support fast addition, updates, deletions.

->With thousands of products, inefficient structures can drastically slow performance.

🔹 Suitable Data Structures:

ArrayList – Good for simple iteration, but not optimal for searching/updating by ID.

HashMap – Excellent for O(1) average-time complexity for search, update, and delete using keys like productId.

👉 Best choice: HashMap<Integer, Product> where key is ```productId```.

## Product Class

This class was responsible for the creation of ```Product``` data type to store the products in an Hashmap.

```Product.java```

``` java

public class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + " | " + productName + " | Qty: " + quantity + " | Price: " + price;
    }
}

```

## Inventory Management Methods

These methods are responsible for the creation ,``` modification``` and ```deletion``` of the ```products```.

``` java

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

```

## Client Code

This was the code responsible for the demonstrating the Inventory management.

```Test.java```

``` java

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

```

## Analysis

```HashMap``` method

| Operation          | Time Complexity | Explanation                     |
| ------------------ | --------------- | ------------------------------- |
| `addProduct`       | **O(1)**        | Direct key insert               |
| `updateProduct`    | **O(1)**        | Get & modify using key          |
| `deleteProduct`    | **O(1)**        | Remove using key                |
| `displayInventory` | **O(n)**        | Must iterate through all values |

## Optimization

➡️ Use HashMap with productId for fastest operations.

➡️ For range queries (e.g., list products by price), consider TreeMap or maintain a SortedList alongside.

➡️ For searching by name, maintain a HashMap<String, List<Product>> (multi-map logic).

➡️ Use Database + Indexing for real-world large-scale warehouses.
