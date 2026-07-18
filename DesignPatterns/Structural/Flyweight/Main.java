package DesignPatterns.Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

// à§§. Flyweight Interface
interface TreeType {
    void draw(int x, int y); // x, y à¦¹à¦²à§‹ Extrinsic state (à¦¯à§‡à¦Ÿà¦¾ à¦ªà§à¦°à¦¤à¦¿à¦Ÿà¦¾ à¦—à¦¾à¦›à§‡à¦° à¦†à¦²à¦¾à¦¦à¦¾)
}

// à§¨. Concrete Flyweight (à¦à¦‡ à¦•à§à¦²à¦¾à¦¸à¦Ÿà¦¿ à¦®à§‡à¦®à¦°à¦¿à¦¤à§‡ à¦¶à§‡à§Ÿà¦¾à¦° à¦•à¦°à¦¾ à¦¹à¦¬à§‡)
class SharedTreeType implements TreeType {
    private String name;    // Intrinsic State (à¦¸à¦¬à¦¾à¦° à¦œà¦¨à§à¦¯ à¦¸à§‡à¦®)
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

// à§©. Flyweight Factory (à¦à¦Ÿà¦¿ à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦¶à§‡à§Ÿà¦¾à¦°à¦¿à¦‚ à¦®à§à¦¯à¦¾à¦¨à§‡à¦œ à¦•à¦°à¦¬à§‡)
class TreeFactory {
    // à¦•à§à¦¯à¦¾à¦¶ (Cache) à¦®à§‡à¦®à¦°à¦¿ à¦¹à¦¿à¦¸à§‡à¦¬à§‡ à¦à¦•à¦Ÿà¦¿ HashMap à¦¬à§à¦¯à¦¬à¦¹à¦¾à¦° à¦•à¦°à¦¾ à¦¹à¦²à§‹
    private static Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        // à¦¯à¦¦à¦¿ à¦à¦‡ à¦¨à¦¾à¦®à§‡à¦° à¦—à¦¾à¦› à¦†à¦—à§‡ à¦¥à§‡à¦•à§‡à¦‡ à¦•à§à¦¯à¦¾à¦¶à§‡ à¦¥à¦¾à¦•à§‡, à¦¤à¦¬à§‡ à¦¸à§‡à¦Ÿà¦¾à¦‡ à¦°à¦¿à¦Ÿà¦¾à¦°à§à¦¨ à¦•à¦°à¦¬à§‡
        TreeType type = treeTypes.get(name);
        
        if (type == null) {
            // à¦†à¦° à¦¯à¦¦à¦¿ à¦¨à¦¾ à¦¥à¦¾à¦•à§‡, à¦¤à¦¬à§‡ à¦¨à¦¤à§à¦¨ à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦¬à¦¾à¦¨à¦¿à§Ÿà§‡ à¦•à§à¦¯à¦¾à¦¶à§‡ à¦¸à§‡à¦­ à¦•à¦°à§‡ à¦°à¦¾à¦–à¦¬à§‡
            type = new SharedTreeType(name, color, texture);
            treeTypes.put(name, type);
            System.out.println("--> Created new TreeType object in memory: " + name);
        }
        return type;
    }
}

// à§ª. Client Code (Main Method)
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦ªà§à¦°à¦¥à¦® à¦—à¦¾à¦›à¦Ÿà¦¿ à¦°à§‡à¦¨à§à¦¡à¦¾à¦° à¦•à¦°à¦›à¦¿ 
        TreeType oak1 = TreeFactory.getTreeType("Oak", "Green", "Rough");
        oak1.draw(10, 20); 
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: --> Created new TreeType object in memory: Oak
        //         Drawing a Green Oak tree... at (10, 20)

        // à§¨. à¦¦à§à¦¬à¦¿à¦¤à§€à§Ÿ Oak à¦—à¦¾à¦›à¦Ÿà¦¿ à¦°à§‡à¦¨à§à¦¡à¦¾à¦° à¦•à¦°à¦›à¦¿ 
        TreeType oak2 = TreeFactory.getTreeType("Oak", "Green", "Rough");
        oak2.draw(50, 70);
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Drawing a Green Oak tree... at (50, 70) 
        // (à¦à¦–à¦¾à¦¨à§‡ à¦–à§‡à§Ÿà¦¾à¦² à¦•à¦°à§à¦¨, à¦¨à¦¤à§à¦¨ à¦•à¦°à§‡ à¦•à§‹à¦¨à§‹ à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦¤à§ˆà¦°à¦¿ à¦¹à¦²à§‹ à¦¨à¦¾! à¦†à¦—à§‡à¦°à¦Ÿà¦¾à¦‡ à¦¶à§‡à§Ÿà¦¾à¦° à¦¹à¦²à§‹)

        // à§©. à¦¨à¦¤à§à¦¨ à¦à¦•à¦Ÿà¦¿ Pine à¦—à¦¾à¦› à¦°à§‡à¦¨à§à¦¡à¦¾à¦° à¦•à¦°à¦›à¦¿
        TreeType pine1 = TreeFactory.getTreeType("Pine", "Dark Green", "Smooth");
        pine1.draw(100, 150);
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: --> Created new TreeType object in memory: Pine
        //         Drawing a Dark Green Pine tree... at (100, 150)
        
        // à¦šà§‡à¦• à¦•à¦°à§‡ à¦¦à§‡à¦–à¦¿ oak1 à¦à¦¬à¦‚ oak2 à¦®à§‡à¦®à¦°à¦¿à¦¤à§‡ à¦à¦•à¦‡ à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦•à¦¿ à¦¨à¦¾
        System.out.println("Are both Oak trees the same object? " + (oak1 == oak2)); 
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: true (à¦®à§à¦¯à¦¾à¦œà¦¿à¦•! à¦°â€à§à¦¯à¦¾à¦® à¦¬à§‡à¦à¦šà§‡ à¦—à§‡à¦²à§‹!)
    }
}
