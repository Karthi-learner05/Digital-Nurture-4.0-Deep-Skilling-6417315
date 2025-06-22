package WEEK_1_AlgorithmsDataStructures.HandsOn_3_SortingCustomersOrders.code;

public class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return  "\torderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice ;
    }
}

