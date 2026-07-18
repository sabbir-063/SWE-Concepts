package Behavioral.Strategy;

// ==========================================
// Component 1: Strategy Interface (স্ট্র্যাটেজির কমন রুলস)
// ==========================================
interface PaymentStrategy {
    void pay(int amount);
}

// ==========================================
// Component 2: Concrete Strategies (আলাদা আলাদা অ্যালগরিদম)
// ==========================================

// বিকাশ পেমেন্ট অ্যালগরিদম
class BkashPayment implements PaymentStrategy {
    private String mobileNumber;

    public BkashPayment(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " BDT using bKash. Number: " + mobileNumber);
    }
}

// ক্রেডিট কার্ড পেমেন্ট অ্যালগরিদম
class CreditCardPayment implements PaymentStrategy {
    private String nameOnCard;
    private String cardNumber;

    public CreditCardPayment(String nameOnCard, String cardNumber) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " BDT using Credit Card. Name: " + nameOnCard);
    }
}

// ক্যাশ অন ডেলিভারি পেমেন্ট অ্যালগরিদম
class CashOnDelivery implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Payment of " + amount + " BDT will be collected upon delivery.");
    }
}

// ==========================================
// Component 3: Context (যেখানে স্ট্র্যাটেজিটি ব্যবহার করা হবে)
// ==========================================
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // রান-টাইমে যে কেউ পেমেন্ট মেথড সেট করে দিতে পারবে
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int totalAmount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method first!");
            return;
        }
        // শপিং কার্ট নিজে জানে না পেমেন্ট কীভাবে হবে।
        // সে শুধু কারেন্ট স্ট্র্যাটেজিকে বলে কাজটা করে দিতে।
        paymentStrategy.pay(totalAmount);
    }
}

// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        ShoppingCart cart = new ShoppingCart();
        int totalAmount = 5000;
        
        System.out.println("--- Scenario 1: Customer chooses bKash ---");
        // ক্লায়েন্ট রান-টাইমে ঠিক করে দিচ্ছে সে কোন স্ট্র্যাটেজি ব্যবহার করবে
        cart.setPaymentStrategy(new BkashPayment("01712345678"));
        cart.checkout(totalAmount); 
        // আউটপুট: Paid 5000 BDT using bKash. Number: 01712345678

        System.out.println("\n--- Scenario 2: Customer changes to Credit Card ---");
        // ক্লায়েন্ট চাইলে যেকোনো মুহূর্তে স্ট্র্যাটেজি পাল্টে ফেলতে পারে!
        cart.setPaymentStrategy(new CreditCardPayment("Mohammad Sabbir", "1234-5678-9876"));
        cart.checkout(totalAmount);
        // আউটপুট: Paid 5000 BDT using Credit Card. Name: Mohammad Sabbir

        System.out.println("\n--- Scenario 3: Customer chooses Cash on Delivery ---");
        cart.setPaymentStrategy(new CashOnDelivery());
        cart.checkout(totalAmount);
        // আউটপুট: Payment of 5000 BDT will be collected upon delivery.
    }
}
