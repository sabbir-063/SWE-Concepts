package DesignPatterns.Creational.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance("First Data");
        Singleton obj2 = Singleton.getInstance("Second Data"); 

        System.out.println(obj1.getData()); // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: "First Data"
        System.out.println(obj2.getData()); // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: "First Data"
        
        System.out.println(obj1 == obj2);   // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: true (à¦¦à§à¦Ÿà§‹à¦‡ à¦à¦•à¦‡ à¦®à§‡à¦®à¦°à¦¿ à¦°à§‡à¦«à¦¾à¦°à§‡à¦¨à§à¦¸)
    }
}
