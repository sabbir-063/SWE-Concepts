package DesignPatterns.Behavioral.Visitor;

import java.util.ArrayList;
import java.util.List;

// ==========================================
// Component 3: Element Interface (à¦¯à¦¾à¦•à§‡ à¦­à¦¿à¦œà¦¿à¦Ÿ à¦•à¦°à¦¾ à¦¹à¦¬à§‡)
// ==========================================
interface ItemElement {
    // à¦à¦‡ à¦®à§‡à¦¥à¦¡à¦Ÿà¦¿ à¦­à¦¿à¦œà¦¿à¦Ÿà¦°à¦•à§‡ à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿà§‡à¦° à¦­à§‡à¦¤à¦°à§‡ à¦¢à§‹à¦•à¦¾à¦° à¦ªà¦¾à¦°à¦®à¦¿à¦¶à¦¨ à¦¦à§‡à§Ÿ
    int accept(ShoppingCartVisitor visitor);
}

// ==========================================
// Component 4: Concrete Elements (à¦†à¦¸à¦² à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿà¦—à§à¦²à§‹)
// ==========================================
class Book implements ItemElement {
    private int price;
    private String isbnNumber;

    public Book(int price, String isbnNumber) {
        this.price = price;
        this.isbnNumber = isbnNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        // à¦­à¦¿à¦œà¦¿à¦Ÿà¦°à¦•à§‡ à¦¬à¦²à¦›à§‡â€” "à¦¤à§à¦®à¦¿ à¦à¦¬à¦¾à¦° à¦¤à§‹à¦®à¦¾à¦° à¦²à¦œà¦¿à¦• à¦†à¦®à¦¾à¦° à¦“à¦ªà¦° à¦šà¦¾à¦²à¦¾à¦“"
        return visitor.visit(this);
    }
}

class Fruit implements ItemElement {
    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int pricePerKg, int weight, String name) {
        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.name = name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}


// ==========================================
// Component 1: Visitor Interface (à¦­à¦¿à¦œà¦¿à¦Ÿà¦°à§‡à¦° à¦°à§à¦²à¦¸)
// ==========================================
// à¦ªà§à¦°à¦¤à¦¿à¦Ÿà¦¾ à¦†à¦²à¦¾à¦¦à¦¾ à¦†à¦²à¦¾à¦¦à¦¾ Concrete Element à¦à¦° à¦œà¦¨à§à¦¯ à¦à¦•à¦Ÿà¦¿ à¦•à¦°à§‡ visit à¦®à§‡à¦¥à¦¡ à¦¥à¦¾à¦•à¦¬à§‡
interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}

// ==========================================
// Component 2: Concrete Visitor (à¦†à¦¸à¦² à¦²à¦œà¦¿à¦• à¦¬à¦¾ à¦…à¦ªà¦¾à¦°à§‡à¦¶à¦¨)
// ==========================================
// à¦à¦Ÿà¦¿ à¦à¦•à¦Ÿà¦¿ à¦­à¦¿à¦œà¦¿à¦Ÿà¦° à¦¯à¦¾ à¦ªà§à¦°à¦¤à¦¿à¦Ÿà¦¿ à¦†à¦‡à¦Ÿà§‡à¦®à§‡à¦° à¦¡à¦¿à¦¸à¦•à¦¾à¦‰à¦¨à§à¦Ÿà¦¸à¦¹ à¦¦à¦¾à¦® à¦¹à¦¿à¦¸à¦¾à¦¬ à¦•à¦°à¦¬à§‡
class PriceCalculatorVisitor implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        int cost = book.getPrice();
        // à¦¬à¦‡à§Ÿà§‡à¦° à¦¦à¦¾à¦® à§«à§¦à§¦ à¦Ÿà¦¾à¦•à¦¾à¦° à¦¬à§‡à¦¶à¦¿ à¦¹à¦²à§‡ à§«à§¦ à¦Ÿà¦¾à¦•à¦¾ à¦¡à¦¿à¦¸à¦•à¦¾à¦‰à¦¨à§à¦Ÿ
        if (cost > 500) {
            cost = cost - 50;
        }
        System.out.println("Book ISBN: " + book.getIsbnNumber() + " -> Cost = " + cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        // à¦«à¦²à§‡à¦° à¦¦à¦¾à¦® = à¦ªà§à¦°à¦¤à¦¿ à¦•à§‡à¦œà¦¿à¦° à¦¦à¦¾à¦® * à¦“à¦œà¦¨
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println("Fruit: " + fruit.getName() + " -> Cost = " + cost);
        return cost;
    }
}


// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦•à¦¾à¦°à§à¦Ÿà§‡ à¦•à¦¿à¦›à§ à¦†à¦‡à¦Ÿà§‡à¦® à¦°à¦¾à¦–à¦²à¦¾à¦®
        List<ItemElement> cartItems = new ArrayList<>();
        cartItems.add(new Book(600, "1234")); // à¦¡à¦¿à¦¸à¦•à¦¾à¦‰à¦¨à§à¦Ÿ à¦ªà¦¾à¦¬à§‡
        cartItems.add(new Book(300, "5678")); // à¦¡à¦¿à¦¸à¦•à¦¾à¦‰à¦¨à§à¦Ÿ à¦ªà¦¾à¦¬à§‡ à¦¨à¦¾
        cartItems.add(new Fruit(100, 2, "Apple")); // à§¨à§¦à§¦ à¦Ÿà¦¾à¦•à¦¾
        cartItems.add(new Fruit(50, 3, "Banana")); // à§§à§«à§¦ à¦Ÿà¦¾à¦•à¦¾

        // à§¨. à¦­à¦¿à¦œà¦¿à¦Ÿà¦° à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦²à¦¾à¦® (à¦¯à§‡ à¦¸à¦¬à¦¾à¦° à¦¦à¦¾à¦® à¦¹à¦¿à¦¸à¦¾à¦¬ à¦•à¦°à¦¬à§‡)
        ShoppingCartVisitor calculator = new PriceCalculatorVisitor();

        // à§©. à¦•à¦¾à¦°à§à¦Ÿà§‡à¦° à¦¸à¦¬ à¦†à¦‡à¦Ÿà§‡à¦®à§‡à¦° à¦­à§‡à¦¤à¦° à¦¦à¦¿à§Ÿà§‡ à¦­à¦¿à¦œà¦¿à¦Ÿà¦°à¦•à§‡ à¦ªà¦¾à¦ à¦¾à¦²à¦¾à¦®
        int total = 0;
        System.out.println("--- Calculating Total Cost ---");
        for (ItemElement item : cartItems) {
            // à¦†à¦‡à¦Ÿà§‡à¦®à¦Ÿà¦¿ à¦­à¦¿à¦œà¦¿à¦Ÿà¦°à¦•à§‡ à¦…à§à¦¯à¦¾à¦•à§à¦¸à§‡à¦ªà§à¦Ÿ à¦•à¦°à¦›à§‡
            total += item.accept(calculator); 
        }

        System.out.println("\nTotal Price of Cart: " + total + " BDT");
    }
}
