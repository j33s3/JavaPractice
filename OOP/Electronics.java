package OOP;

public class Electronics extends Product{


    /**
     * Constructor for the Electronics object
     * @param name
     * @param price
     * @param stock
     */
    Electronics(String name, float price, int stock) {
        super(name, price, stock);
    }

    /**
     * Calculates the discount bases on stock
     * @return
     */
    public float calculateDiscount() {
        if(this.getStock() > 100) {
            float discount = this.getPrice() * 0.10f;
            return (float) (Math.floor(discount * 100) / 100);
        }

        else if(this.getStock() > 50) {
            float discount = this.getPrice() * 0.25f;
            return (float) (Math.floor(discount * 100) / 100);
        }
        
        else {
            float discount = this.getPrice() * 0.40f;
            return (float) (Math.floor(discount * 100) / 100);
        }
    }

    /**
     * Formats the objects fields
     * name, stock, price, discount, total
     */
    @Override
    public String toString() {
        float discount = calculateDiscount();
        return "Name: " + this.getName() + "\nStock: " + this.getStock() + "\nPrice: " + this.getPrice() + "\nDiscount: " + discount + "\nTotal: " + (this.getPrice() - discount);
    }
}
