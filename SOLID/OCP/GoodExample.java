package SOLID.OCP;

// ✅ Good Example: Open/Closed Principle (OCP) ফলো করছে
// এই ডিজাইনে আমরা "Open for extension, Closed for modification" রুল মেনে চলেছি।
// ইন্টারফেস বা অ্যাবস্ট্রাকশন ব্যবহারের কারণে আমাদের পুরোনো কোড এডিট করতে হবে না।

// ১. একটি কমন ইন্টারফেস বানালাম, যা সব কাস্টমার টাইপের জন্য প্রযোজ্য
interface CustomerDiscount {
    double calculateDiscount(double amount);
}

// ২. Regular Customer-এর জন্য একটি ক্লাস
class RegularCustomer implements CustomerDiscount {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.1; // 10% discount
    }
}

// ৩. VIP Customer-এর জন্য একটি ক্লাস
class VIPCustomer implements CustomerDiscount {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.2; // 20% discount
    }
}

// 💡 Extension (নতুন ফিচার অ্যাড করা): 
// ধরুন নতুন "SuperVIP" কাস্টমার আসলো। এখন আর আমাদের পুরোনো কোড (if-else) এডিট করতে হবে না!
// জাস্ট নতুন একটি ক্লাস বানিয়ে নিলেই হবে (Open for extension)।
class SuperVIPCustomer implements CustomerDiscount {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.3; // 30% discount
    }
}

// ৪. Calculator ক্লাস: এটি আর কখনোই চেঞ্জ হবে না (Closed for modification)
class DiscountCalculator {
    public double calculate(CustomerDiscount customer, double amount) {
        return customer.calculateDiscount(amount);
    }
}

public class GoodExample {
    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        
        System.out.println("Regular Discount: $" + calculator.calculate(new RegularCustomer(), 100));
        System.out.println("VIP Discount: $" + calculator.calculate(new VIPCustomer(), 100));
        
        // নতুন কাস্টমার টাইপ খুব সহজেই অ্যাড করা গেলো, কোনো পুরোনো কোড ব্রেক না করেই!
        System.out.println("Super VIP Discount: $" + calculator.calculate(new SuperVIPCustomer(), 100));
    }
}
