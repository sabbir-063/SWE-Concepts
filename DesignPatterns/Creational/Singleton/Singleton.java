package DesignPatterns.Creational.Singleton;
public class Singleton {
    // ২. Private Static Instance (volatile ব্যবহার করা হয় thread safety এর জন্য)
    private static volatile Singleton instance = null;
    
    private String data;

    // ১. Private Constructor
    private Singleton(String data) {
        this.data = data;
    }

    // ৩. Public Static Method
    public static Singleton getInstance(String data) {
        if (instance == null) { 
            // প্রথম চেক (Double-checked locking)
            synchronized (Singleton.class) {
                if (instance == null) { 
                    // থ্রেড সেফটির জন্য দ্বিতীয় চেক
                    instance = new Singleton(data);
                    System.out.println("New instance created!");
                }
            }
        } else {
            System.out.println("Returning existing instance.");
        }
        return instance;
    }

    public String getData() {
        return data;
    }
}
