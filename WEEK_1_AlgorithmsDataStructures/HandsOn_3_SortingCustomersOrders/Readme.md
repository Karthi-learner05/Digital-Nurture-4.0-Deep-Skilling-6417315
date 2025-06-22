# SORTING CUSTOMER ORDERS

This involves in sorting of the customer orders in an E-Commerce platform by using the ```Total Price```.

## Sorting Algorithms

### 1. Bubble Sort:

Compares adjacent elements and swaps if they are in the wrong order.

```Time Complexity```

**Best      : O(n)**
**Average   : O(n²)**
**Worst     : O(n²)**

```Use case```

**Very small or nearly sorted datasets.**

### 2. Insertion Sort:

Builds the sorted array one element at a time.

```Time Complexity```

**Best      : O(n)**
**Average   : O(n²)**
**Worst     : O(n²)**

```Use case```

**Small datasets**
**real-time systems**

### 3. Quick Sort:

Divide-and-conquer. Picks a pivot and partitions the array.

```Time Complexity```

**Best      : O(n logn)**
**Average   : O(n logn)**
**Worst     : O(n²)**

```Use case```

**General-purpose**
**fast in practice**

### 4. Merge Sort:

Divide-and-conquer. Recursively splits and merges.

```Time Complexity```

**Best      : O(n logn)**
**Average   : O(n logn)**
**Worst     : O(n logn)**

```Use case```

**Stable sorting**
**works well with linked lists and large datasets**

## Order Class

This class consist of the attributes for an order such as ```OrderId``` , ```CustomerName``` and ```totalPrice```.

```Order.java```

``` java

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

```

## Sorting Algorithms

This algorithms was used to sort Orders using the Order's totalPrice.

```BubbleSort.java```

``` java

public class BubbleSort {
    public static void bubbleSort(Order[] orders) {
    int n = orders.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                Order temp = orders[j];
                orders[j] = orders[j + 1];
                orders[j + 1] = temp;
            }
        }
    }
}
}

```

```QuickSort.java```

``` java

public class QuickSort {
    public static void quickSort(Order[] orders, int low, int high) {
    if (low < high) {
        int pi = partition(orders, low, high);
        quickSort(orders, low, pi - 1);
        quickSort(orders, pi + 1, high);
    }
}

public static int partition(Order[] orders, int low, int high) {
    double pivot = orders[high].totalPrice;
    int i = (low - 1);

    for (int j = low; j < high; j++) {
        if (orders[j].totalPrice <= pivot) {
            i++;
            Order temp = orders[i];
            orders[i] = orders[j];
            orders[j] = temp;
        }
    }

    Order temp = orders[i + 1];
    orders[i + 1] = orders[high];
    orders[high] = temp;

    return i + 1;
}

}

```

## Analysis of Sorting Algorithms

| Algorithm       | Best Case  | Average Case | Worst Case | Stable | In-place |
| --------------- | ---------- | ------------ | ---------- | ------ | -------- |
| **Bubble Sort** | O(n)       | O(n²)        | O(n²)      | ✅ Yes  | ✅ Yes    |
| **Quick Sort**  | O(n log n) | O(n log n)   | O(n²)      | ❌ No   | ✅ Yes    |
