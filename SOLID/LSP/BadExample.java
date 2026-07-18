package SOLID.LSP;

// ❌ Bad Example: Liskov Substitution Principle (LSP) ভায়োলেট করছে
// LSP এর মূল কথা হলো: Child class কে Parent class এর জায়গায় বসালে সিস্টেম ব্রেক করা যাবে না।

public class BadExample {

    // Parent Class
    static class Bird {
        public void fly() {
            System.out.println("Bird is flying! 🐦");
        }
    }

    // Child Class 1: ঈগল (উড়তে পারে, তাই কোনো সমস্যা নেই)
    static class Eagle extends Bird {
        @Override
        public void fly() {
            System.out.println("Eagle is flying high! 🦅");
        }
    }

    // Child Class 2: উটপাখি (উড়তে পারে না!)
    // ❌ LSP Violation: Ostrich ক্লাসে fly() কল করলে exception দিচ্ছে। 
    // যদি আমরা Bird এর জায়গায় Ostrich বসাই, তবে সিস্টেম ক্র্যাশ করবে!
    static class Ostrich extends Bird {
        @Override
        public void fly() {
            throw new UnsupportedOperationException("Ostriches can't fly! 🚫");
        }
    }

    public static void main(String[] args) {
        // যদি ہم Parent Class (Bird) এর একটি লিস্ট বানাই...
        Bird myBird = new Eagle();
        myBird.fly(); // কাজ করছে!

        // এবার Parent class এর জায়গায় Child class (Ostrich) বসালাম...
        Bird mySecondBird = new Ostrich();
        
        try {
            mySecondBird.fly(); // ❌ সিস্টেম ক্র্যাশ করবে!
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
