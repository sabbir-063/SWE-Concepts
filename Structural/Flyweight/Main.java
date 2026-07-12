package Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

// ১. Flyweight Interface
interface TreeType {
    void draw(int x, int y); // x, y হলো Extrinsic state (যেটা প্রতিটা গাছের আলাদা)
}

// ২. Concrete Flyweight (এই ক্লাসটি মেমরিতে শেয়ার করা হবে)
class SharedTreeType implements TreeType {
    private String name;    // Intrinsic State (সবার জন্য সেম)
    private String color;   // Intrinsic State
    private String texture; // Intrinsic State

    public SharedTreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " " + name + 
                           " tree with " + texture + " at coordinates: (" + x + ", " + y + ")");
    }
}

// ৩. Flyweight Factory (এটি অবজেক্ট শেয়ারিং ম্যানেজ করবে)
class TreeFactory {
    // ক্যাশ (Cache) মেমরি হিসেবে একটি HashMap ব্যবহার করা হলো
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        // যদি এই নামের গাছ আগে থেকেই ক্যাশে থাকে, তবে সেটাই রিটার্ন করবে
        TreeType type = treeTypes.get(name);
        
        if (type == null) {
            // আর যদি না থাকে, তবে নতুন অবজেক্ট বানিয়ে ক্যাশে সেভ করে রাখবে
            type = new SharedTreeType(name, color, texture);
            treeTypes.put(name, type);
            System.out.println("--> Created new TreeType object in memory: " + name);
        }
        return type;
    }
}

// ৪. Client Code (Main Method)
public class Main {
    public static void main(String[] args) {
        
        // ১. প্রথম গাছটি রেন্ডার করছি 
        TreeType oak1 = TreeFactory.getTreeType("Oak", "Green", "Rough");
        oak1.draw(10, 20); 
        // আউটপুট: --> Created new TreeType object in memory: Oak
        //         Drawing a Green Oak tree... at (10, 20)

        // ২. দ্বিতীয় Oak গাছটি রেন্ডার করছি 
        TreeType oak2 = TreeFactory.getTreeType("Oak", "Green", "Rough");
        oak2.draw(50, 70);
        // আউটপুট: Drawing a Green Oak tree... at (50, 70) 
        // (এখানে খেয়াল করুন, নতুন করে কোনো অবজেক্ট তৈরি হলো না! আগেরটাই শেয়ার হলো)

        // ৩. নতুন একটি Pine গাছ রেন্ডার করছি
        TreeType pine1 = TreeFactory.getTreeType("Pine", "Dark Green", "Smooth");
        pine1.draw(100, 150);
        // আউটপুট: --> Created new TreeType object in memory: Pine
        //         Drawing a Dark Green Pine tree... at (100, 150)
        
        // চেক করে দেখি oak1 এবং oak2 মেমরিতে একই অবজেক্ট কি না
        System.out.println("Are both Oak trees the same object? " + (oak1 == oak2)); 
        // আউটপুট: true (ম্যাজিক! র‍্যাম বেঁচে গেলো!)
    }
}