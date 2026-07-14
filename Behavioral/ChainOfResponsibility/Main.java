package Behavioral.ChainOfResponsibility;

// ==========================================
// Component 1: Handler (অ্যাবস্ট্রাক্ট ক্লাস)
// ==========================================
abstract class SupportHandler {
    protected SupportHandler nextHandler; // চেইনের পরবর্তী জন কে হবে, তার রেফারেন্স

    // পরবর্তী হ্যান্ডলার সেট করার মেথড
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // এই মেথডটি চাইল্ড ক্লাসগুলো ইমপ্লিমেন্ট করবে
    public abstract void handleRequest(String issueSeverity);
}


// ==========================================
// Component 2: Concrete Handlers (আসল কর্মী ক্লাসগুলো)
// ==========================================

// লেভেল ১: সাধারণ সমস্যার সমাধানকারী
class Level1Support extends SupportHandler {
    @Override
    public void handleRequest(String issueSeverity) {
        if (issueSeverity.equalsIgnoreCase("BASIC")) {
            System.out.println("Level 1 Support: I have solved this basic issue. ✅");
        } 
        else if (nextHandler != null) {
            System.out.println("Level 1 Support: It's too complex for me. Passing to Level 2... ⏭️");
            nextHandler.handleRequest(issueSeverity); // পরের জনের কাছে পাঠিয়ে দিলো
        }
    }
}

// লেভেল ২: মাঝারি সমস্যার সমাধানকারী
class Level2Support extends SupportHandler {
    @Override
    public void handleRequest(String issueSeverity) {
        if (issueSeverity.equalsIgnoreCase("INTERMEDIATE")) {
            System.out.println("Level 2 Support (Manager): I have solved this intermediate issue. ✅");
        } 
        else if (nextHandler != null) {
            System.out.println("Level 2 Support: It's extremely complex. Passing to Level 3... ⏭️");
            nextHandler.handleRequest(issueSeverity); // পরের জনের কাছে পাঠিয়ে দিলো
        }
    }
}

// লেভেল ৩: চরম জটিল সমস্যার সমাধানকারী (Technical Expert)
class Level3Support extends SupportHandler {
    @Override
    public void handleRequest(String issueSeverity) {
        if (issueSeverity.equalsIgnoreCase("CRITICAL")) {
            System.out.println("Level 3 Support (Tech Team): We have fixed the critical issue. 🛠️✅");
        } 
        else {
            // এর পরে আর কেউ নেই, তাই চেইন শেষ
            System.out.println("Level 3 Support: Sorry, this issue cannot be resolved by our team. ❌");
        }
    }
}


// ==========================================
// Component 3: Client (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // ১. চেইনের অবজেক্টগুলো তৈরি করা
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();

        // ২. চেইনটি সেটআপ করা (কে কার পরে কাজ করবে)
        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        // ৩. রিকোয়েস্ট পাঠানো (ক্লায়েন্ট সব সময় প্রথম জনের কাছেই রিকোয়েস্ট পাঠাবে)
        System.out.println("--- Scenario 1: BASIC Issue ---");
        level1.handleRequest("BASIC");

        System.out.println("\n--- Scenario 2: INTERMEDIATE Issue ---");
        level1.handleRequest("INTERMEDIATE");

        System.out.println("\n--- Scenario 3: CRITICAL Issue ---");
        level1.handleRequest("CRITICAL");

        System.out.println("\n--- Scenario 4: EXTRA CRITICAL Issue ---");
        level1.handleRequest("EXTRA CRITICAL");
    }
}