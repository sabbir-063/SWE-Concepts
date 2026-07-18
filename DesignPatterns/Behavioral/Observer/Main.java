package DesignPatterns.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

// ==========================================
// Component 1: Subject (পাবলিশার / যার পরিবর্তন সবাই জানতে চায়)
// ==========================================
interface Publisher {
    void subscribe(Subscriber subscriber);     // সাবস্ক্রাইব করার জন্য
    void unsubscribe(Subscriber subscriber);   // আনসাবস্ক্রাইব করার জন্য
    void notifySubscribers();                  // আপডেট জানানোর জন্য
}

// ==========================================
// Component 2: Observer (সাবস্ক্রাইবার / যারা আপডেট পেতে চায়)
// ==========================================
interface Subscriber {
    // সাবজেক্ট যখনই আপডেট হবে, তখন সে সাবস্ক্রাইবারের এই মেথডটা কল করে দিবে
    void update(String latestArticle);
}

// ==========================================
// Component 3: Concrete Subject (আসল পাবলিশার)
// ==========================================
class TechBlog implements Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String latestArticle;

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println("A new user subscribed to the Tech Blog.");
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println("A user unsubscribed from the Tech Blog.");
    }

    @Override
    public void notifySubscribers() {
        System.out.println("\nNotifying all " + subscribers.size() + " subscribers...");
        for (Subscriber sub : subscribers) {
            sub.update(latestArticle); // সবাইকে নতুন আর্টিকেলের খবর পাঠিয়ে দিলো
        }
    }

    // নতুন আর্টিকেল পাবলিশ করার মেথড
    public void publishNewArticle(String title) {
        this.latestArticle = title;
        System.out.println("\n>>> [TechBlog] Published New Article: " + title + " <<<");
        // পাবলিশ হওয়ার সাথে সাথেই সবাইকে অটোম্যাটিক নোটিফাই করা হচ্ছে
        notifySubscribers();
    }
}

// ==========================================
// Component 4: Concrete Observer (আসল সাবস্ক্রাইবার)
// ==========================================
class User implements Subscriber {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String latestArticle) {
        // নতুন আপডেট পেলে ইউজার কী করবে, সেটা এখানে বলা আছে
        System.out.println(name + " received a notification! New post: " + latestArticle);
    }
}


// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // ১. একটি পাবলিশার বানালাম
        TechBlog codingBlog = new TechBlog();

        // ২. কিছু সাবস্ক্রাইবার বানালাম
        User sabbir = new User("Sabbir");
        User musfique = new User("Musfique");
        User john = new User("John");

        // ৩. সাবস্ক্রাইবাররা ব্লগে সাবস্ক্রাইব করলো
        codingBlog.subscribe(sabbir);
        codingBlog.subscribe(musfique);
        codingBlog.subscribe(john);

        // ৪. ব্লগ যখনই নতুন কিছু পাবলিশ করবে, সবার কাছে অটোম্যাটিক খবর চলে যাবে!
        codingBlog.publishNewArticle("Mastering Observer Pattern in Java");
        
        // ৫. জন আনসাবস্ক্রাইব করলো
        codingBlog.unsubscribe(john);

        // ৬. এবার নতুন আর্টিকেল পাবলিশ হলে জন আর নোটিফিকেশন পাবে না
        codingBlog.publishNewArticle("How to write Clean Code");
    }
}
