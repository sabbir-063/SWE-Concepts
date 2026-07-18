package SOLID.GrandFinale;

// ❌ The Grand Finale: BAD E-Commerce App
// এই ফাইলে আমরা দেখবো কিভাবে একটি ক্লাসের ভেতর SOLID এর ৫টি রুলসই ব্রেক করা হয়েছে!

class BadECommerceApp {

    // ❌ ISP Violation: একটি বড় ইন্টারফেস যেখানে ফিজিক্যাল এবং ডিজিটাল প্রোডাক্টের সব মেথড একসাথে!
    interface IProduct {
        String getName();
        double getPrice();
        void shipProduct(); // ডিজিটাল প্রোডাক্ট (যেমন সফটওয়্যার) শিপ করা যায় না!
        void downloadProduct(); // ফিজিক্যাল প্রোডাক্ট (যেমন টি-শার্ট) ডাউনলোড করা যায় না!
    }

    static class TShirt implements IProduct {
        public String getName() { return "T-Shirt"; }
        public double getPrice() { return 500; }
        public void shipProduct() { System.out.println("Shipping T-Shirt via Pathao."); }
        
        // ❌ LSP Violation: TShirt ডাউনলোড করা যায় না, তাই Exception থ্রো করা হচ্ছে।
        public void downloadProduct() { throw new UnsupportedOperationException("Cannot download T-Shirt!"); }
    }

    static class Software implements IProduct {
        public String getName() { return "Antivirus"; }
        public double getPrice() { return 1200; }
        
        // ❌ LSP Violation: সফটওয়্যার কুরিয়ারে শিপ করা যায় না!
        public void shipProduct() { throw new UnsupportedOperationException("Cannot ship Software via courier!"); }
        public void downloadProduct() { System.out.println("Downloading Antivirus software..."); }
    }

    // ❌ DIP Violation: ডাটাবেস ক্লাস সরাসরি ইমপ্লিমেন্ট করা হয়েছে (No interface)
    static class MySQLDatabase {
        public void saveOrder(String orderDetails) {
            System.out.println("Saving to MySQL DB: " + orderDetails);
        }
    }

    // ❌ SRP Violation: OrderProcessor একই সাথে পেমেন্ট নিচ্ছে, ডাটাবেস সেভ করছে এবং ইমেইল পাঠাচ্ছে (God Class)
    static class OrderProcessor {
        private MySQLDatabase db = new MySQLDatabase(); // ❌ DIP Violation (Direct Instantiation)

        // ❌ OCP Violation: নতুন পেমেন্ট মেথড আসলে এই if-else ব্লকটি বারবার এডিট করতে হবে!
        public void processOrder(IProduct product, String paymentType) {
            System.out.println("--- Processing Order for: " + product.getName() + " ---");
            
            // Payment Logic (OCP Violation)
            if (paymentType.equals("BKASH")) {
                System.out.println("Paid BDT " + product.getPrice() + " using bKash.");
            } else if (paymentType.equals("CARD")) {
                System.out.println("Paid BDT " + product.getPrice() + " using Credit Card.");
            } else {
                System.out.println("Unknown payment method!");
                return;
            }

            // Database Logic (SRP Violation)
            db.saveOrder(product.getName() + " paid via " + paymentType);

            // Shipping/Downloading Logic (LSP Violation in action!)
            try {
                product.shipProduct();
            } catch (Exception e) {
                System.out.println("Shipping Error: " + e.getMessage());
            }

            // Email Notification Logic (SRP Violation)
            System.out.println("Email sent: Your order for " + product.getName() + " is confirmed!");
        }
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        
        IProduct tshirt = new TShirt();
        processor.processOrder(tshirt, "BKASH");

        System.out.println();

        IProduct software = new Software();
        processor.processOrder(software, "CARD"); // এইখানে Shipping Error খাবে!
    }
}
