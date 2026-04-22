import java.util.*;

// Product class
class Product {
    int id;
    String name;
    int price;

    Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(id + " - " + name + " - ₹" + price);
    }
}

// Cart class
class Cart {
    List<Product> items = new ArrayList<>();

    void add(Product p) {
        items.add(p);
        System.out.println(p.name + " added to cart!");
    }

    void show() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        int total = 0;
        System.out.println("\nCart Items:");
        for (Product p : items) {
            p.display();
            total += p.price;
        }
        System.out.println("Total = ₹" + total);
    }
}

// Main class
public class BuyNow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product p1 = new Product(1, "Mobile", 10000);
        Product p2 = new Product(2, "Laptop", 50000);
        Product p3 = new Product(3, "Shoes", 2000);

        Cart cart = new Cart();

        while (true) {
            System.out.println("\n--- BuyNow Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Buy Now");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    p1.display();
                    p2.display();
                    p3.display();
                    break;

                case 2:
                    System.out.print("Enter product id: ");
                    int id = sc.nextInt();

                    if (id == 1) cart.add(p1);
                    else if (id == 2) cart.add(p2);
                    else if (id == 3) cart.add(p3);
                    else System.out.println("Invalid ID");
                    break;

                case 3:
                    cart.show();
                    break;

                case 4:
                    System.out.print("Enter product id to buy: ");
                    int buyId = sc.nextInt();

                    if (buyId == 1) System.out.println("You bought Mobile for ₹10000");
                    else if (buyId == 2) System.out.println("You bought Laptop for ₹50000");
                    else if (buyId == 3) System.out.println("You bought Shoes for ₹2000");
                    else System.out.println("Invalid ID");

                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
