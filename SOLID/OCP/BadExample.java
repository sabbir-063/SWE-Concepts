package SOLID.OCP;

// ❌ Bad Example: Open/Closed Principle (OCP) ভায়োলেট করছে
// ধরি, আমাদের একটি ডিসকাউন্ট ক্যালকুলেটর আছে, যেখানে রেগুলার এবং ভিআইপি কাস্টমারদের জন্য ডিসকাউন্ট দেওয়া হয়।

public class BadExample {
    
    static class DiscountCalculator {
        // ❌ OCP Violation: নতুন কোনো কাস্টমার টাইপ (যেমন: Employee বা SuperVIP) আসলে, 
        // এই existing ক্লাসটি এডিট করে নতুন if-else লিখতে হবে। 
        // এটি "Closed for modification" রুল ব্রেক করছে।
        public double calculateDiscount(String customerType, double amount) {
            if (customerType.equals("REGULAR")) {
                return amount * 0.1; // 10% discount
            } else if (customerType.equals("VIP")) {
                return amount * 0.2; // 20% discount
            } else {
                return 0; // No discount
            }
        }
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Regular Discount: $" + calculator.calculateDiscount("REGULAR", 100));
        System.out.println("VIP Discount: $" + calculator.calculateDiscount("VIP", 100));
    }
}
