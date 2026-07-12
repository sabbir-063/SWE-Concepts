package Creational.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance("First Data");
        Singleton obj2 = Singleton.getInstance("Second Data"); 

        System.out.println(obj1.getData()); // আউটপুট: "First Data"
        System.out.println(obj2.getData()); // আউটপুট: "First Data"
        
        System.out.println(obj1 == obj2);   // আউটপুট: true (দুটোই একই মেমরি রেফারেন্স)
    }
}