package WEEK_1_AlgorithmsDataStructures.HandsOn_3_SortingCustomersOrders.code;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
    Order[] orders = {
        new Order(101, "Karthikeyan", 250.0),
        new Order(102, "Selvaraj", 180.5),
        new Order(103, "Nandhakumar", 320.0),
        new Order(104, "Kanagamani", 150.0)
    };

    System.out.println("\nBefore Sorting :- ");
    for (Order o : orders) System.out.println(o);

    Scanner in=new Scanner(System.in);
    System.out.print("\nEnter sort type(bubble/quick) : ");
    String sortType=in.next().toLowerCase();
    in.close();
    switch (sortType) {
        case "bubble":
            Bubble(orders);
            break;
        case "quick":
            Quick(orders);
            break;
        default:
            System.out.println("Sort Method added soon");
            break;
    }



}

public static void Quick(Order[] orders){

    QuickSort.quickSort(orders, 0, orders.length - 1);
    System.out.println("\nAfter Sorting by Total Price using Quick Sort :-");
    for (Order o : orders)
        System.out.println(o);

}

public static void Bubble(Order[] orders){

    BubbleSort.bubbleSort(orders);
    System.out.println("\nAfter Sorting by Total Price using Bubble Sort :-");
    for (Order o : orders)
        System.out.println(o);

}

}
