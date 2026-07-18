package SOLID.ISP;

// ❌ Bad Example: Interface Segregation Principle (ISP) ভায়োলেট করছে
// ISP এর মূল কথা হলো: কোনো ক্লাসকে এমন কোনো ইন্টারফেস ইমপ্লিমেন্ট করতে বাধ্য করা যাবে না, 
// যেটার সবগুলো মেথড তার দরকার নেই। অর্থাৎ, "Fat" ইন্টারফেস বানানো যাবে না।

public class BadExample {

    // একটি বড় "Fat" ইন্টারফেস, যেখানে অনেক কাজ একসাথে দেওয়া আছে
    interface MultiFunctionPrinter {
        void print();
        void scan();
        void fax();
    }

    // Advanced Printer: এটি প্রিন্ট, স্ক্যান, ফ্যাক্স সবই করতে পারে।
    // এর জন্য এই ইন্টারফেসটি একদম পারফেক্ট!
    static class AdvancedPrinter implements MultiFunctionPrinter {
        public void print() {
            System.out.println("Advanced Printer is printing...");
        }
        public void scan() {
            System.out.println("Advanced Printer is scanning...");
        }
        public void fax() {
            System.out.println("Advanced Printer is sending a fax...");
        }
    }

    // Basic Printer: এটি শুধু প্রিন্ট করতে পারে। স্ক্যান বা ফ্যাক্স করতে পারে না।
    // ❌ ISP Violation: BasicPrinter কে জোর করে scan() এবং fax() ইমপ্লিমেন্ট করতে হচ্ছে!
    static class BasicPrinter implements MultiFunctionPrinter {
        public void print() {
            System.out.println("Basic Printer is printing...");
        }
        
        public void scan() {
            // কিছুই করার নেই, অথবা Exception থ্রো করতে হবে
            throw new UnsupportedOperationException("Basic Printer cannot scan!");
        }
        
        public void fax() {
            throw new UnsupportedOperationException("Basic Printer cannot fax!");
        }
    }

    public static void main(String[] args) {
        MultiFunctionPrinter advanced = new AdvancedPrinter();
        advanced.print();
        advanced.scan(); // কাজ করবে

        MultiFunctionPrinter basic = new BasicPrinter();
        basic.print(); // কাজ করবে
        
        try {
            basic.scan(); // ❌ ক্র্যাশ করবে!
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
