package SOLID.ISP;

// ✅ Good Example: Interface Segregation Principle (ISP) ফলো করছে
// আমরা একটি বড় "Fat" ইন্টারফেসকে ভেঙে ছোট ছোট স্পেসিফিক (Specific) ইন্টারফেস বানাবো।
// এতে করে কোনো ক্লাসকে অপ্রয়োজনীয় মেথড ইমপ্লিমেন্ট করতে হবে না।

// ছোট এবং স্পেসিফিক ইন্টারফেসগুলো:
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

// Advanced Printer: এর সবই দরকার, তাই সে ৩টি ইন্টারফেসই ইমপ্লিমেন্ট করলো
class AdvancedPrinter implements Printer, Scanner, Fax {
    @Override
    public void print() {
        System.out.println("Advanced Printer is printing... 🖨️");
    }

    @Override
    public void scan() {
        System.out.println("Advanced Printer is scanning... 📄");
    }

    @Override
    public void fax() {
        System.out.println("Advanced Printer is sending a fax... 📠");
    }
}

// Basic Printer: এর শুধু প্রিন্ট করা দরকার, তাই সে শুধু Printer ইন্টারফেস নিলো।
// এখন আর তাকে জোর করে scan() বা fax() বানাতে হচ্ছে না!
class BasicPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Basic Printer is printing... 🖨️");
    }
}

public class GoodExample {
    public static void main(String[] args) {
        // Advanced Printer এর ক্ষেত্রে
        AdvancedPrinter advanced = new AdvancedPrinter();
        advanced.print();
        advanced.scan();
        advanced.fax();

        System.out.println("-----------------");

        // Basic Printer এর ক্ষেত্রে
        BasicPrinter basic = new BasicPrinter();
        basic.print();
        // basic.scan(); // ❌ কম্পাইল টাইমেই এরর খাবে, কারণ এর স্ক্যান করার ক্ষমতাই নেই! (ভুল হওয়ার সুযোগ 0%)
    }
}
