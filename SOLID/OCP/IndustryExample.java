package SOLID.OCP;

// 🏢 Industry Level Example: Payment Gateway Integration

// রিয়েল ওয়ার্ল্ডে যখন কোনো ই-কমার্স সাইটে পেমেন্ট সিস্টেম বসানো হয়, 
// তখন OCP ফলো করা খুবই জরুরি। কারণ ভবিষ্যতে নতুন নতুন পেমেন্ট মেথড (যেমন: Nagad, Rocket) আসতে পারে।

// ১. Payment ইন্টারফেস (অ্যাবস্ট্রাকশন)
interface PaymentProcessor {
    void processPayment(double amount);
}

// ২. bKash এর জন্য ইমপ্লিমেন্টেশন
class BkashPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bKash payment of BDT " + amount);
        // bKash API connection logic here
    }
}

// ৩. SSLCommerz (Card) এর জন্য ইমপ্লিমেন্টেশন
class SSLCommerzPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Card payment via SSLCommerz of BDT " + amount);
        // SSLCommerz API connection logic here
    }
}

// 💡 Extension: হঠাৎ করে কোম্পানি বললো Nagad অ্যাড করতে হবে। 
// আমরা পুরোনো কোড (CheckoutService বা BkashPayment) একটুও এডিট করবো না! 
// জাস্ট নতুন ক্লাস বানাবো।
class NagadPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Nagad payment of BDT " + amount);
        // Nagad API logic here
    }
}

// ৪. Checkout সার্ভিস: এটি পেমেন্ট রিসিভ করে। এটি Closed for modification.
class CheckoutService {
    // এটি শুধু ইন্টারফেস চিনে, কোনো স্পেসিফিক পেমেন্ট গেটওয়ে চিনে না (Polymorphism)
    public void checkout(PaymentProcessor paymentProcessor, double amount) {
        paymentProcessor.processPayment(amount);
    }
}

public class IndustryExample {
    public static void main(String[] args) {
        CheckoutService checkout = new CheckoutService();
        
        // কাস্টমার বিকাশ সিলেক্ট করলো
        PaymentProcessor bkash = new BkashPayment();
        checkout.checkout(bkash, 1500.50);
        
        // কাস্টমার কার্ড সিলেক্ট করলো
        PaymentProcessor ssl = new SSLCommerzPayment();
        checkout.checkout(ssl, 5000.00);
        
        // নতুন অ্যাড হওয়া নগদ পেমেন্ট! (পুরোনো কোনো কোড ব্রেক হয়নি)
        PaymentProcessor nagad = new NagadPayment();
        checkout.checkout(nagad, 100.00);
    }
}
