import java.util.*;

public class Main {
    static HashMap<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Store store = new Store();

        // Sample products
        store.addProduct(new Product(1, "Phone", 20000, 5));
        store.addProduct(new Product(2, "Laptop", 50000, 3));
        store.addProduct(new Product(3, "Headphones", 2000, 10));

        System.out.println("1.Register 2.Login");
        int choice = sc.nextInt();
        sc.nextLine();

        User currentUser = null;

        if (choice == 1) {
            System.out.print("Enter username: ");
            String u = sc.nextLine();
            System.out.print("Enter password: ");
            String p = sc.nextLine();

            currentUser = new User(u, p);
            users.put(u, currentUser);
        } else {
            System.out.print("Enter username: ");
            String u = sc.nextLine();
            System.out.print("Enter password: ");
            String p = sc.nextLine();

            if (users.containsKey(u) && users.get(u).password.equals(p)) {
                currentUser = users.get(u);
            } else {
                System.out.println("Invalid login");
                return;
            }
        }

        while (true) {
            System.out.println("\n1.View Products");
            System.out.println("2.Search Product");
            System.out.println("3.Sort by Price");
            System.out.println("4.Add to Cart");
            System.out.println("5.Remove from Cart");
            System.out.println("6.View Cart");
            System.out.println("7.Checkout");
            System.out.println("8.View Orders");
            System.out.println("9.Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    store.viewProducts();
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    store.searchByName(sc.nextLine());
                    break;

                case 3:
                    store.sortByPrice();
                    break;

                case 4:
                    System.out.print("Enter id & qty: ");
                    Product p = store.searchById(sc.nextInt());
                    int qty = sc.nextInt();
                    currentUser.cart.addToCart(p, qty);
                    break;

                case 5:
                    System.out.print("Enter id: ");
                    Product rp = store.searchById(sc.nextInt());
                    currentUser.cart.removeFromCart(rp);
                    break;

                case 6:
                    currentUser.cart.viewCart();
                    break;

                case 7:
                    double total = currentUser.cart.getTotal();
                    if (total == 0) {
                        System.out.println("Cart empty");
                        break;
                    }
                    Order order = new Order(currentUser.cart.items, total);
                    currentUser.addOrder(order);
                    currentUser.cart.clearCart();
                    System.out.println("Order placed!");
                    break;

                case 8:
                    currentUser.viewOrders();
                    break;

                case 9:
                    System.out.println("Thank you!");
                    return;
            }
        }
    }
}