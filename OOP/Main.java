package OOP;

import java.util.ArrayList;

public class Main {

    // Stores all of the items
    private static ArrayList<Product> items = new ArrayList<Product>();

    public static void main (String[] args) {
        items.add(new Electronics("Electric Guitar", 364.99f,200));
        items.add(new Electronics("Computer", 1404.99f, 50));
        items.add(new Electronics("Camera", 150.75f, 9));


        items.add(new Clothing("White Short Sleeved Tee",30.24f, 234));
        items.add(new Clothing("Straight-Cut Denim Jeans", 40.00f, 50));

        displayProducts();  

    }

    /**
     * Displays each of the items on the list
     */
    private static void displayProducts() {
        for (Product item : items) {
            System.out.println(item.toString());
            System.out.println();
        }
    }
    
}
