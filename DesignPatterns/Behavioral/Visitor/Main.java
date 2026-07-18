package DesignPatterns.Behavioral.Visitor;

import java.util.ArrayList;
import java.util.List;

// ==========================================
// Component 3: Element Interface (যাকে ভিজিট করা হবে)
// ==========================================
interface ItemElement {
    // এই মেথডটি ভিজিটরকে অবজেক্টের ভেতরে ঢোকার পারমিশন দেয়
    int accept(ShoppingCartVisitor visitor);
}

// ==========================================
// Component 4: Concrete Elements (আসল অবজেক্টগুলো)
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
        // ভিজিটরকে বলছে— "তুমি এবার তোমার লজিক আমার ওপর চালাও"
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
// Component 1: Visitor Interface (ভিজিটরের রুলস)
// ==========================================
// প্রতিটা আলাদা আলাদা Concrete Element এর জন্য একটি করে visit মেথড থাকবে
interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}

// ==========================================
// Component 2: Concrete Visitor (আসল লজিক বা অপারেশন)
// ==========================================
// এটি একটি ভিজিটর যা প্রতিটি আইটেমের ডিসকাউন্টসহ দাম হিসাব করবে
class PriceCalculatorVisitor implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        int cost = book.getPrice();
        // বইয়ের দাম ৫০০ টাকার বেশি হলে ৫০ টাকা ডিসকাউন্ট
        if (cost > 500) {
            cost = cost - 50;
        }
        System.out.println("Book ISBN: " + book.getIsbnNumber() + " -> Cost = " + cost);
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        // ফলের দাম = প্রতি কেজির দাম * ওজন
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
        
        // ১. কার্টে কিছু আইটেম রাখলাম
        List<ItemElement> cartItems = new ArrayList<>();
        cartItems.add(new Book(600, "1234")); // ডিসকাউন্ট পাবে
        cartItems.add(new Book(300, "5678")); // ডিসকাউন্ট পাবে না
        cartItems.add(new Fruit(100, 2, "Apple")); // ২০০ টাকা
        cartItems.add(new Fruit(50, 3, "Banana")); // ১৫০ টাকা

        // ২. ভিজিটর তৈরি করলাম (যে সবার দাম হিসাব করবে)
        ShoppingCartVisitor calculator = new PriceCalculatorVisitor();

        // ৩. কার্টের সব আইটেমের ভেতর দিয়ে ভিজিটরকে পাঠালাম
        int total = 0;
        System.out.println("--- Calculating Total Cost ---");
        for (ItemElement item : cartItems) {
            // আইটেমটি ভিজিটরকে অ্যাক্সেপ্ট করছে
            total += item.accept(calculator); 
        }

        System.out.println("\nTotal Price of Cart: " + total + " BDT");
    }
}
