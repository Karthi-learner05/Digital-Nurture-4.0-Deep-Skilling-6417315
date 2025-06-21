package WEEK_1_AlgorithmsDataStructures.HandsOn_2_E_CommercePlatformSearch.code;

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
