package DesignPatterns.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

// ==========================================
// Component 1: Subject (à¦ªà¦¾à¦¬à¦²à¦¿à¦¶à¦¾à¦° / à¦¯à¦¾à¦° à¦ªà¦°à¦¿à¦¬à¦°à§à¦¤à¦¨ à¦¸à¦¬à¦¾à¦‡ à¦œà¦¾à¦¨à¦¤à§‡ à¦šà¦¾à§Ÿ)
// ==========================================
interface Publisher {
    void subscribe(Subscriber subscriber);     // à¦¸à¦¾à¦¬à¦¸à§à¦•à§à¦°à¦¾à¦‡à¦¬ à¦•à¦°à¦¾à¦° à¦œà¦¨à§à¦¯
    void unsubscribe(Subscriber subscriber);   // à¦†à¦¨à¦¸à¦¾à¦¬à¦¸à§à¦•à§à¦°à¦¾à¦‡à¦¬ à¦•à¦°à¦¾à¦° à¦œà¦¨à§à¦¯
    void notifySubscribers();                  // à¦†à¦ªà¦¡à§‡à¦Ÿ à¦œà¦¾à¦¨à¦¾à¦¨à§‹à¦° à¦œà¦¨à§à¦¯
}

// ==========================================
// Component 2: Observer (à¦¸à¦¾à¦¬à¦¸à§à¦•à§à¦°à¦¾à¦‡à¦¬à¦¾à¦° / à¦¯à¦¾à¦°à¦¾ à¦†à¦ªà¦¡à§‡à¦Ÿ à¦ªà§‡à¦¤à§‡ à¦šà¦¾à§Ÿ)
// ==========================================
interface Subscriber {
    // à¦¸à¦¾à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦¯à¦–à¦¨à¦‡ à¦†à¦ªà¦¡à§‡à¦Ÿ à¦¹à¦¬à§‡, à¦¤à¦–à¦¨ à¦¸à§‡ à¦¸à¦¾à¦¬à¦¸à§à¦•à§à¦°à¦¾à¦‡à¦¬à¦¾à¦°à§‡à¦° à¦à¦‡ à¦®à§‡à¦¥à¦¡à¦Ÿà¦¾ à¦•à¦² à¦•à¦°à§‡ à¦¦à¦¿à¦¬à§‡
    void update(String latestArticle);
}

// ==========================================
// Component 3: Concrete Subject (à¦†à¦¸à¦² à¦ªà¦¾à¦¬à¦²à¦¿à¦¶à¦¾à¦°)
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
            sub.update(latestArticle); // à¦¸à¦¬à¦¾à¦‡à¦•à§‡ à¦¨à¦¤à§à¦¨ à¦†à¦°à§à¦Ÿà¦¿à¦•à§‡à¦²à§‡à¦° à¦–à¦¬à¦° à¦ªà¦¾à¦ à¦¿à§Ÿà§‡ à¦¦à¦¿à¦²à§‹
        }
    }

    // à¦¨à¦¤à§à¦¨ à¦†à¦°à§à¦Ÿà¦¿à¦•à§‡à¦² à¦ªà¦¾à¦¬à¦²à¦¿à¦¶ à¦•à¦°à¦¾à¦° à¦®à§‡à¦¥à¦¡
    public void publishNewArticle(String title) {
        this.latestArticle = title;
        System.out.println("\n>>> [TechBlog] Published New Article: " + title + " <<<");
        // à¦ªà¦¾à¦¬à¦²à¦¿à¦¶ à¦¹à¦“à§Ÿà¦¾à¦° à¦¸à¦¾à¦¥à§‡ à¦¸à¦¾à¦¥à§‡à¦‡ à¦¸à¦¬à¦¾à¦‡à¦•à§‡ à¦…à¦Ÿà§‹à¦®à§à¦¯à¦¾à¦Ÿà¦¿à¦• à¦¨à§‹à¦Ÿà¦¿à¦«à¦¾à¦‡ à¦•à¦°à¦¾ à¦¹à¦šà§à¦›à§‡
        notifySubscribers();
    }
}

// ==========================================
// Component 4: Concrete Observer (à¦†à¦¸à¦² à¦¸à¦¾à¦¬à¦¸à§à¦•à§à¦°à¦¾à¦‡à¦¬à¦¾à¦°)
// ==========================================
class User implements Subscriber {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String latestArticle) {
        // à¦¨à¦¤à§à¦¨ à¦†à¦ªà¦¡à§‡à¦Ÿ à¦ªà§‡à¦²à§‡ à¦‡à¦‰à¦œà¦¾à¦° à¦•à§€ à¦•à¦°à¦¬à§‡, à¦¸à§‡à¦Ÿà¦¾ à¦à¦–à¦¾à¦¨à§‡ à¦¬à¦²à¦¾ à¦†à¦›à§‡
        System.out.println(name + " received a notification! New post: " + latestArticle);
    }
}


// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦à¦•à¦Ÿà¦¿ à¦ªà¦¾à¦¬à¦²à¦¿à¦¶à¦¾à¦° à¦¬à¦¾à¦¨à¦¾à¦²à¦¾à¦®
        TechBlog codingBlog = new TechBlog();

        // à§¨. à¦•à¦¿à¦›à§ à¦¸à¦¾à¦¬à¦¸à§à¦•à§à¦°à¦¾à¦‡à¦¬à¦¾à¦° à¦¬à¦¾à¦¨à¦¾à¦²à¦¾à¦®
        User sabbir = new User("Sabbir");
        User musfique = new User("Musfique");
        User john = new User("John");

        // à§©. à¦¸à¦¾à¦¬à¦¸à§à¦•à§à¦°à¦¾à¦‡à¦¬à¦¾à¦°à¦°à¦¾ à¦¬à§à¦²à¦—à§‡ à¦¸à¦¾à¦¬à¦¸à§à¦•à§à¦°à¦¾à¦‡à¦¬ à¦•à¦°à¦²à§‹
        codingBlog.subscribe(sabbir);
        codingBlog.subscribe(musfique);
        codingBlog.subscribe(john);

        // à§ª. à¦¬à§à¦²à¦— à¦¯à¦–à¦¨à¦‡ à¦¨à¦¤à§à¦¨ à¦•à¦¿à¦›à§ à¦ªà¦¾à¦¬à¦²à¦¿à¦¶ à¦•à¦°à¦¬à§‡, à¦¸à¦¬à¦¾à¦° à¦•à¦¾à¦›à§‡ à¦…à¦Ÿà§‹à¦®à§à¦¯à¦¾à¦Ÿà¦¿à¦• à¦–à¦¬à¦° à¦šà¦²à§‡ à¦¯à¦¾à¦¬à§‡!
        codingBlog.publishNewArticle("Mastering Observer Pattern in Java");
        
        // à§«. à¦œà¦¨ à¦†à¦¨à¦¸à¦¾à¦¬à¦¸à§à¦•à§à¦°à¦¾à¦‡à¦¬ à¦•à¦°à¦²à§‹
        codingBlog.unsubscribe(john);

        // à§¬. à¦à¦¬à¦¾à¦° à¦¨à¦¤à§à¦¨ à¦†à¦°à§à¦Ÿà¦¿à¦•à§‡à¦² à¦ªà¦¾à¦¬à¦²à¦¿à¦¶ à¦¹à¦²à§‡ à¦œà¦¨ à¦†à¦° à¦¨à§‹à¦Ÿà¦¿à¦«à¦¿à¦•à§‡à¦¶à¦¨ à¦ªà¦¾à¦¬à§‡ à¦¨à¦¾
        codingBlog.publishNewArticle("How to write Clean Code");
    }
}
