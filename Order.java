import java.util.*;

public class Order {
    static int counter = 1;

    int orderId;
    HashMap<Product, Integer> items;
    double total;
    Date date;

    public Order(HashMap<Product, Integer> items, double total) {
        this.orderId = counter++;
        this.items = new HashMap<>(items);
        this.total = total;
        this.date = new Date();
    }

    public void showOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Date: " + date);

        for (Product p : items.keySet()) {
            System.out.println(p.name + " x " + items.get(p));
        }

        System.out.println("Total: ₹" + total);
        System.out.println("---------------------");
    }
}