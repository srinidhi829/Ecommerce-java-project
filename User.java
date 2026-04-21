import java.util.*;

public class User {
    String username;
    String password;
    Cart cart = new Cart();
    ArrayList<Order> orders = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders");
            return;
        }

        for (Order o : orders) {
            o.showOrder();
        }
    }
}