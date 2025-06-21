package WEEK_1_AlgorithmsDataStructures.HandsOn_2_E_CommercePlatformSearch.code;

import java.util.Scanner;

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
