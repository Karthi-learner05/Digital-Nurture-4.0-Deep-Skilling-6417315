# E-commerce Platform Search Function

This solution involves on implementing the ```Linear Search``` and ```Binary Search``` on an E-Commerce platform.

## Big O Notation
Big O Notation is a mathematical way to describe worst case pf an algorithm’s runtime or space grows with the size of input ```n```.

## Product Class

This class was used to Create an product database type along with their name,id and category.Here I used the ```Builder``` pattern to reduce the complexity of new product creation.

``` java

public class Product {
    private int ProductId;
    private String ProductName;
    private String Category;

    private Product(ProductSetter pr){
        this.ProductId=pr.ProductId;
        this.ProductName=pr.ProductName;
        this.Category=pr.Category;
    }

    public int getProductId() {
        return ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getCategory() {
        return Category;
    }


    public static class ProductSetter{
        private int ProductId;
        private String ProductName;
        private String Category;

        public ProductSetter(int id){
            this.ProductId=id;
        }

        public ProductSetter SetName(String str)
        {
            this.ProductName=str;
            return this;
        }

        public ProductSetter SetCategory(String str){
            this.Category=str;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
}

```

## Factory pattern implementation

Here I used the Factory pattern to hide the usage of Class for the Search methods.

### Search interface

``` java

public interface Search {
    void search(String str, Product[] products);
}

```

### SearchFactory

This class was used to select the Class of for the search either ```Linear``` or ```Binary```.

``` java

public class SearchFactory {
    public static Search getSearch(String type) {
        switch (type.toLowerCase()) {
            case "linear":
                return new LinearSearch();
            case "binary":
                return new BinarySearch();
            default:
                throw new IllegalArgumentException("Error: Search Method will be added soon " + type);
        }
    }
}

```
## Search Methods
Search methods are used to check whether the product is available in ```product[]``` or not.

### LinearSearch

It search the product in ```product[]``` one by one product sequentially.

``` java

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

```

### BinarySearch

It search the product in the ```product[]``` by using the mid value.

``` java

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


```
### Comparison of Search methods
    
| Algorithm         | Best Case | Average Case | Worst Case | Time Complexity             |
| ----------------- | --------- | ------------ | ---------- | --------------------------- |
| **Linear Search** | Ω(1)      | Θ(n)         | O(n)       | Slow for large arrays       |
| **Binary Search** | Ω(1)      | Θ(log n)     | O(log n)   | Fast, requires sorted array |

## Client Code

This was the actual code given to the user which is visible.For the implementation I have initiallized some of the products in ```product[]```.

``` java

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Product[] product=new Product[10];
        product[0]=new Product.ProductSetter(1).SetName("Soap").SetCategory("Cosmetics").build();
        product[1]=new Product.ProductSetter(2).SetName("Shampoo").SetCategory("Cosmetics").build();
        product[2]=new Product.ProductSetter(3).SetName("Toothpaste").SetCategory("Cosmetics").build();
        product[3]=new Product.ProductSetter(4).SetName("Laptop").SetCategory("Electronics").build();
        product[4]=new Product.ProductSetter(5).SetName("Mobile").SetCategory("Electronics").build();
        product[5]=new Product.ProductSetter(6).SetName("Television").SetCategory("Electronics").build();
        product[6]=new Product.ProductSetter(7).SetName("Refrigerator").SetCategory("Electronics").build();
        product[7]=new Product.ProductSetter(8).SetName("Rice").SetCategory("Grocery").build();
        product[8]=new Product.ProductSetter(9).SetName("Salt").SetCategory("Grocery").build();
        product[9]=new Product.ProductSetter(10).SetName("Sugar").SetCategory("Grocery").build();
        System.out.print("Enter search type (linear/binary): ");
        String input = in.nextLine();
        try{
            Search search= SearchFactory.getSearch(input);
            System.out.print("Enter search item: ");
            String item=in.nextLine();
            search.search(item, product);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        finally {
            in.close();
        }
    }
}

```
