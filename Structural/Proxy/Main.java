package Structural.Proxy;

import java.util.ArrayList;
import java.util.List;
// ১. Subject Interface (আসল অবজেক্ট এবং প্রক্সি— দুজনকেই এটি মানতে হবে)
interface Internet {
    void connectTo(String serverHost);
}

// ২. Real Subject (আসল ইন্টারনেট কানেকশন, যা সরাসরি সাইটে কানেক্ট করে)
class RealInternet implements Internet {
    @Override
    public void connectTo(String serverHost) {
        System.out.println("Connecting to " + serverHost + " 🌐");
    }
}

// ৩. Proxy Subject (পাহারাদার, যে আসল ইন্টারনেটের আগে চেক করবে)
class ProxyInternet implements Internet {
    private RealInternet realInternet;
    // ব্লক করা সাইটের লিস্ট
    private static List<String> bannedSites = new ArrayList<>();

    static {
        bannedSites.add("facebook.com");
        bannedSites.add("youtube.com");
        bannedSites.add("tiktok.com");
    }

    @Override
    public void connectTo(String serverHost) {
        // প্রক্সির নিজস্ব লজিক (Access Control)
        if (bannedSites.contains(serverHost.toLowerCase())) {
            System.out.println("Access Denied ❌: Cannot connect to " + serverHost);
            return; // রিকোয়েস্ট এখানেই ব্লক করে দিলো!
        }

        // যদি সব ঠিক থাকে, তবে আসল ইন্টারনেটের অবজেক্ট তৈরি করে তাকে কল করা
        if (realInternet == null) {
            realInternet = new RealInternet(); 
        }
        
        // আসল অবজেক্টকে কাজটা বুঝিয়ে দেওয়া (Delegation)
        realInternet.connectTo(serverHost);
    }
}

// ---- Main Method (Client Code) ----
public class Main {
    public static void main(String[] args) {
        
        // ক্লায়েন্ট মনে করছে সে আসল ইন্টারনেট ব্যবহার করছে
        // কিন্তু আমরা তাকে প্রক্সি ইন্টারনেট ধরিয়ে দিয়েছি!
        Internet internet = new ProxyInternet();

        try {
            internet.connectTo("google.com");      // আউটপুট: Connecting to google.com 🌐
            internet.connectTo("wikipedia.org");   // আউটপুট: Connecting to wikipedia.org 🌐
            
            // এবার ব্লকড সাইটে যাওয়ার চেষ্টা
            internet.connectTo("facebook.com");    // আউটপুট: Access Denied ❌: Cannot connect to facebook.com
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
