import java.util.*;

public class Store {
    HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product p) {
        products.put(p.id, p);
    }

    public void viewProducts() {
        for (Product p : products.values()) {
            System.out.println(p.id + " " + p.name + " ₹" + p.price + " Stock:" + p.stock);
        }
    }

    public Product searchById(int id) {
        return products.get(id);
    }

    public void searchByName(String keyword) {
        boolean found = false;
        for (Product p : products.values()) {
            if (p.name.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(p.id + " " + p.name + " ₹" + p.price);
                found = true;
            }
        }
        if (!found) System.out.println("No product found");
    }

    public void sortByPrice() {
        List<Product> list = new ArrayList<>(products.values());
        list.sort(Comparator.comparingDouble(p -> p.price));

        for (Product p : list) {
            System.out.println(p.id + " " + p.name + " ₹" + p.price);
        }
    }
}