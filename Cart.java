import java.util.*;

public class Cart {
    HashMap<Product, Integer> items = new HashMap<>();

    public void addToCart(Product p, int qty) {
        if (p == null) {
            System.out.println("Invalid product");
            return;
        }

        if (p.stock >= qty) {
            items.put(p, items.getOrDefault(p, 0) + qty);
            p.stock -= qty;
            System.out.println("Added to cart");
        } else {
            System.out.println("Insufficient stock");
        }
    }

    public void removeFromCart(Product p) {
        if (items.containsKey(p)) {
            int qty = items.get(p);
            p.stock += qty;
            items.remove(p);
            System.out.println("Removed");
        } else {
            System.out.println("Not in cart");
        }
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Cart empty");
            return;
        }

        for (Product p : items.keySet()) {
            System.out.println(p.name + " x " + items.get(p));
        }
    }

    public double getTotal() {
        double total = 0;
        for (Product p : items.keySet()) {
            total += p.price * items.get(p);
        }
        return total;
    }

    public void clearCart() {
        items.clear();
    }
}