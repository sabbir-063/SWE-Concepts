package DesignPatterns.Behavioral.Strategy;

// ==========================================
// Component 1: Strategy Interface (à¦¸à§à¦Ÿà§à¦°à§à¦¯à¦¾à¦Ÿà§‡à¦œà¦¿à¦° à¦•à¦®à¦¨ à¦°à§à¦²à¦¸)
// ==========================================
interface PaymentStrategy {
    void pay(int amount);
}

// ==========================================
// Component 2: Concrete Strategies (à¦†à¦²à¦¾à¦¦à¦¾ à¦†à¦²à¦¾à¦¦à¦¾ à¦…à§à¦¯à¦¾à¦²à¦—à¦°à¦¿à¦¦à¦®)
// ==========================================

// à¦¬à¦¿à¦•à¦¾à¦¶ à¦ªà§‡à¦®à§‡à¦¨à§à¦Ÿ à¦…à§à¦¯à¦¾à¦²à¦—à¦°à¦¿à¦¦à¦®
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

// à¦•à§à¦°à§‡à¦¡à¦¿à¦Ÿ à¦•à¦¾à¦°à§à¦¡ à¦ªà§‡à¦®à§‡à¦¨à§à¦Ÿ à¦…à§à¦¯à¦¾à¦²à¦—à¦°à¦¿à¦¦à¦®
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

// à¦•à§à¦¯à¦¾à¦¶ à¦…à¦¨ à¦¡à§‡à¦²à¦¿à¦­à¦¾à¦°à¦¿ à¦ªà§‡à¦®à§‡à¦¨à§à¦Ÿ à¦…à§à¦¯à¦¾à¦²à¦—à¦°à¦¿à¦¦à¦®
class CashOnDelivery implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Payment of " + amount + " BDT will be collected upon delivery.");
    }
}

// ==========================================
// Component 3: Context (à¦¯à§‡à¦–à¦¾à¦¨à§‡ à¦¸à§à¦Ÿà§à¦°à§à¦¯à¦¾à¦Ÿà§‡à¦œà¦¿à¦Ÿà¦¿ à¦¬à§à¦¯à¦¬à¦¹à¦¾à¦° à¦•à¦°à¦¾ à¦¹à¦¬à§‡)
// ==========================================
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // à¦°à¦¾à¦¨-à¦Ÿà¦¾à¦‡à¦®à§‡ à¦¯à§‡ à¦•à§‡à¦‰ à¦ªà§‡à¦®à§‡à¦¨à§à¦Ÿ à¦®à§‡à¦¥à¦¡ à¦¸à§‡à¦Ÿ à¦•à¦°à§‡ à¦¦à¦¿à¦¤à§‡ à¦ªà¦¾à¦°à¦¬à§‡
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int totalAmount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method first!");
            return;
        }
        // à¦¶à¦ªà¦¿à¦‚ à¦•à¦¾à¦°à§à¦Ÿ à¦¨à¦¿à¦œà§‡ à¦œà¦¾à¦¨à§‡ à¦¨à¦¾ à¦ªà§‡à¦®à§‡à¦¨à§à¦Ÿ à¦•à§€à¦­à¦¾à¦¬à§‡ à¦¹à¦¬à§‡à¥¤
        // à¦¸à§‡ à¦¶à§à¦§à§ à¦•à¦¾à¦°à§‡à¦¨à§à¦Ÿ à¦¸à§à¦Ÿà§à¦°à§à¦¯à¦¾à¦Ÿà§‡à¦œà¦¿à¦•à§‡ à¦¬à¦²à§‡ à¦•à¦¾à¦œà¦Ÿà¦¾ à¦•à¦°à§‡ à¦¦à¦¿à¦¤à§‡à¥¤
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
        // à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿ à¦°à¦¾à¦¨-à¦Ÿà¦¾à¦‡à¦®à§‡ à¦ à¦¿à¦• à¦•à¦°à§‡ à¦¦à¦¿à¦šà§à¦›à§‡ à¦¸à§‡ à¦•à§‹à¦¨ à¦¸à§à¦Ÿà§à¦°à§à¦¯à¦¾à¦Ÿà§‡à¦œà¦¿ à¦¬à§à¦¯à¦¬à¦¹à¦¾à¦° à¦•à¦°à¦¬à§‡
        cart.setPaymentStrategy(new BkashPayment("01712345678"));
        cart.checkout(totalAmount); 
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Paid 5000 BDT using bKash. Number: 01712345678

        System.out.println("\n--- Scenario 2: Customer changes to Credit Card ---");
        // à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿ à¦šà¦¾à¦‡à¦²à§‡ à¦¯à§‡à¦•à§‹à¦¨à§‹ à¦®à§à¦¹à§‚à¦°à§à¦¤à§‡ à¦¸à§à¦Ÿà§à¦°à§à¦¯à¦¾à¦Ÿà§‡à¦œà¦¿ à¦ªà¦¾à¦²à§à¦Ÿà§‡ à¦«à§‡à¦²à¦¤à§‡ à¦ªà¦¾à¦°à§‡!
        cart.setPaymentStrategy(new CreditCardPayment("Mohammad Sabbir", "1234-5678-9876"));
        cart.checkout(totalAmount);
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Paid 5000 BDT using Credit Card. Name: Mohammad Sabbir

        System.out.println("\n--- Scenario 3: Customer chooses Cash on Delivery ---");
        cart.setPaymentStrategy(new CashOnDelivery());
        cart.checkout(totalAmount);
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Payment of 5000 BDT will be collected upon delivery.
    }
}
