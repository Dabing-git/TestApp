import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String name;      // The name or description of the item
    private double price;     // The price of the item
    private int quantity;     // The quantity of the item

    // Constructor to initialize an Item object with provided name, price, and quantity
    public Item(String name, double price, int quantity) {
        this.name = name;       // Assign the provided name to the name attribute of the item
        this.price = price;     // Assign the provided price to the price attribute of the item
        this.quantity = quantity; // Assign the provided quantity to the quantity attribute of the item
    }
    // Getter method to retrieve the name of the item
    public String getName() {
        return name;       // Return the value of the 'name' attribute
    }
    // Getter method to retrieve the price of the item
    public double getPrice() {
        return price;      // Return the value of the 'price' attribute
    }
    // Getter method to retrieve the quantity of the item
    public int getQuantity() {
        return quantity;   // Return the value of the 'quantity' attribute
    }
    // Setter method to update the quantity of the item
    public void setQuantity(int quantity) {
        this.quantity = quantity;  // Set the value of the 'quantity' attribute to the provided quantity
    }
}

class MyShoppingCart {
    private List<Item> items = new ArrayList<>();

    // Method to add an item to the shopping cart
    public void addItem(Item item) {
        items.add(item); // Add the provided item to the list of items in the shopping cart
    }

    // Method to remove an item from the shopping cart
    public void removeItem(Item item) {
        items.remove(item); // Remove the provided item from the list of items in the shopping cart
    }
    // Method to display the items in the shopping cart
    public void displayCart() {
        System.out.println("Shopping Cart:"); // Print a header for the shopping cart
        for (Item item : items) {
            // Print details of each item in the shopping cart
            System.out.println(item.getName() + " - $" + item.getPrice() + " - Quantity: " + item.getQuantity());
        }
    }
    // Method to calculate the total cost of items in the shopping cart
    public double calculateTotal() {
        double total = 0; // Initialize the total cost to zero
        for (Item item : items) {
            // For each item in the shopping cart, calculate its cost and add to the total
            total += item.getPrice() * item.getQuantity();
        }
        return total; // Return the total cost of all items in the shopping cart
    }

    public List<Item> getItems() {
        return items;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyShoppingCart cart = new MyShoppingCart(); // Create a new shopping cart object
        // Infinite loop to display the menu and process user input
        while (true) {
            System.out.println("\n1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. View cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt(); // Read user's choice from the console

            // Switch statement to handle different menu options
            switch (choice) {
                case 1:
                    // Prompt user to enter details of the item to add
                    System.out.print("Enter item name: ");
                    String name = scanner.next();
                    System.out.print("Enter item pric  e: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    // Create a new Item object with the provided details
                    Item newItem = new Item(name, price, quantity);
                    // Add the new item to the shopping cart
                    cart.addItem(newItem);
                    break;
                case 2:
                    // Check if the shopping cart is not empty
                    if (cart.getItems().size() > 0) {
                        // Display the items in the shopping cart
                        cart.displayCart();
                        // Prompt user to enter the index of the item to remove
                        System.out.print("Enter item index to remove: ");
                        int indexToRemove = scanner.nextInt();
                        // Check if the entered index is valid
                        if (indexToRemove >= 0 && indexToRemove < cart.getItems().size()) {
                            // Remove the item at the specified index from the shopping cart
                            cart.removeItem(cart.getItems().get(indexToRemove));
                        } else {
                            // Display an error message for invalid index
                            System.out.println("Invalid index!");
                        }
                    } else {
                        // Display a message if the shopping cart is empty
                        System.out.println("Cart is empty!");
                    }
                    break;
                case 3:
                    // Display the items in the shopping cart
                    cart.displayCart();
                    break;
                case 4:
                    // Display the total cost of items in the shopping cart
                    System.out.println("Total: $" + cart.calculateTotal());
                    break;
                case 5:
                    // Display a thank you message and exit the program
                    System.out.println("Thank you for shopping with us!");
                    System.exit(0);
                default:
                    // Display an error message for invalid choice
                    System.out.println("Invalid choice!");
            }
        }
    }
}
