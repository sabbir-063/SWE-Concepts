package DesignPatterns.Creational.Singleton;
public class Singleton {
    // à§¨. Private Static Instance (volatile à¦¬à§à¦¯à¦¬à¦¹à¦¾à¦° à¦•à¦°à¦¾ à¦¹à§Ÿ thread safety à¦à¦° à¦œà¦¨à§à¦¯)
    private static volatile Singleton instance = null;
    
    private String data;

    // à§§. Private Constructor
    private Singleton(String data) {
        this.data = data;
    }

    // à§©. Public Static Method
    public static Singleton getInstance(String data) {
        if (instance == null) { 
            // à¦ªà§à¦°à¦¥à¦® à¦šà§‡à¦• (Double-checked locking)
            synchronized (Singleton.class) {
                if (instance == null) { 
                    // à¦¥à§à¦°à§‡à¦¡ à¦¸à§‡à¦«à¦Ÿà¦¿à¦° à¦œà¦¨à§à¦¯ à¦¦à§à¦¬à¦¿à¦¤à§€à§Ÿ à¦šà§‡à¦•
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
