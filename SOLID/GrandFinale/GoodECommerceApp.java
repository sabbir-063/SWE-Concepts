package SOLID.GrandFinale;

// ✅ The Grand Finale: GOOD E-Commerce App
// এই ফাইলে আমরা ৫টি SOLID রুলস অ্যাপ্লাই করে জগাখিচুড়ি কোডকে ক্লিন করবো!

// ==========================================
// 1. Interfaces (ISP - Interface Segregation Principle)
// ==========================================
// বিশাল IProduct কে ভেঙে ছোট ও স্পেসিফিক করা হলো।
interface Product {
    String getName();
    double getPrice();
}

interface Shippable {
    void shipProduct();
}

interface Downloadable {
    void downloadProduct();
}

// ==========================================
// 2. Concrete Products (LSP - Liskov Substitution Principle)
// ==========================================
// এখন কোনো ক্লাসেই অদরকারি মেথড নেই, তাই Exception থ্রো হওয়ার সুযোগ নেই (LSP Followed).
class TShirt implements Product, Shippable {
    public String getName() { return "T-Shirt"; }
    public double getPrice() { return 500; }
    public void shipProduct() { System.out.println("📦 Shipping T-Shirt via Pathao."); }
}

class Software implements Product, Downloadable {
    public String getName() { return "Antivirus"; }
    public double getPrice() { return 1200; }
    public void downloadProduct() { System.out.println("⬇️ Downloading Antivirus software..."); }
}

// ==========================================
// 3. Payment Processing (OCP - Open/Closed Principle)
// ==========================================
// if-else বাদ দিয়ে Polymorphism ব্যবহার করা হলো।
interface PaymentMethod {
    void pay(double amount);
}

class BkashPayment implements PaymentMethod {
    public void pay(double amount) { System.out.println("💳 Paid BDT " + amount + " using bKash."); }
}

class CardPayment implements PaymentMethod {
    public void pay(double amount) { System.out.println("💳 Paid BDT " + amount + " using Credit Card."); }
}

// ==========================================
// 4. Repositories and Notifications (DIP & SRP)
// ==========================================
interface Database {
    void save(String data);
}

class MySQLDatabase implements Database {
    public void save(String data) { System.out.println("💾 Saving to MySQL DB: " + data); }
}

interface NotificationService {
    void notify(String message);
}

class EmailNotification implements NotificationService {
    public void notify(String message) { System.out.println("✉️ Email sent: " + message); }
}

// ==========================================
// 5. Order Processor (SRP & DIP)
// ==========================================
// এই ক্লাসটি এখন শুধু প্রসেস করার অর্কেস্ট্রেশন করে। 
// সে Database বা NotificationService এর অবজেক্ট নিজে বানায় না (DI / DIP).
class OrderProcessor {
    private Database db;
    private NotificationService notifier;

    public OrderProcessor(Database db, NotificationService notifier) {
        this.db = db;
        this.notifier = notifier;
    }

    public void processOrder(Product product, PaymentMethod payment) {
        System.out.println("--- Processing Order for: " + product.getName() + " ---");
        
        // 1. Pay
        payment.pay(product.getPrice());
        
        // 2. Save to DB
        db.save("Order placed for " + product.getName());
        
        // 3. Deliver (Checking capabilities safely)
        if (product instanceof Shippable) {
            ((Shippable) product).shipProduct();
        } else if (product instanceof Downloadable) {
            ((Downloadable) product).downloadProduct();
        }

        // 4. Notify
        notifier.notify("Your order for " + product.getName() + " is confirmed!");
    }
}

// ==========================================
// Main Class (Client)
// ==========================================
public class GoodECommerceApp {
    public static void main(String[] args) {
        // Setup Dependencies (DI)
        Database myDb = new MySQLDatabase();
        NotificationService emailService = new EmailNotification();
        OrderProcessor processor = new OrderProcessor(myDb, emailService);

        // Order 1: T-Shirt via bKash
        Product tshirt = new TShirt();
        PaymentMethod bkash = new BkashPayment();
        processor.processOrder(tshirt, bkash);

        System.out.println();

        // Order 2: Software via Card
        Product software = new Software();
        PaymentMethod card = new CardPayment();
        processor.processOrder(software, card);
    }
}
