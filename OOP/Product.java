package OOP;

public class Product {
    
    // Class Fields
    private String name;
    private float price;
    private int stock;

    /**
     * Constructor
     * @param name
     * @param price
     * @param stock
     */
    Product(String name, float price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    //** Getters **//
    protected String getName() {
        return name;
    }

    protected float getPrice() {
        return price;
    }

    protected int getStock() {
        return stock;
    }


    //** Setters **//
    protected void setName(String newName) {
        name = newName;
    }
    
    protected void setPrice(float newPrice) {
        price = newPrice;
    }

    protected void setStock(int newStock) {
        stock = newStock;
    }

    /**
     * Formats the fields into
     * name, price and stock.
     */
    @Override
    public String toString() {
        return "Name: " + name + "\nPrice: " + price + "\nStock: " + stock;
    }
}
