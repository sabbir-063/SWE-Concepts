package DesignPatterns.Creational.Prototype;

// à§§. à¦ªà§à¦°à§‹à¦Ÿà§‹à¦Ÿà¦¾à¦‡à¦ª à¦•à§à¦²à¦¾à¦¸ (à¦¯à§‡à¦Ÿà¦¾à¦•à§‡ à¦†à¦®à¦°à¦¾ à¦•à§à¦²à§‹à¦¨ à¦•à¦°à¦¤à§‡ à¦šà¦¾à¦‡)
// à¦œà¦¾à¦­à¦¾à¦¤à§‡ à¦•à§à¦²à§‹à¦¨ à¦¸à¦¾à¦ªà§‹à¦°à§à¦Ÿ à¦•à¦°à¦¾à¦° à¦œà¦¨à§à¦¯ Cloneable à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦«à§‡à¦¸ à¦‡à¦®à¦ªà§à¦²à¦¿à¦®à§‡à¦¨à§à¦Ÿ à¦•à¦°à¦¤à§‡ à¦¹à§Ÿ
class Sheep implements Cloneable {
    private String name;
    private String color;

    public Sheep(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void describe() {
        System.out.println(name + " is a " + color + " sheep ðŸ‘");
    }

    // à§¨. à¦•à§à¦²à§‹à¦¨ à¦®à§‡à¦¥à¦¡ à¦“à¦­à¦¾à¦°à¦°à¦¾à¦‡à¦¡ à¦•à¦°à¦¾
    @Override
    protected Sheep clone() {
        try {
            // à¦œà¦¾à¦­à¦¾à¦° à¦¡à¦¿à¦«à¦²à§à¦Ÿ à¦•à§à¦²à§‹à¦¨ à¦®à§‡à¦¥à¦¡ à¦¬à§à¦¯à¦¬à¦¹à¦¾à¦° à¦•à¦°à¦›à¦¿ (Shallow Copy)
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// ---- Main Method (Client Code) ----
public class Main {
    public static void main(String[] args) {
        // à§§. à¦à¦•à¦Ÿà¦¿ à¦†à¦¸à¦² à¦­à§‡à§œà¦¾ à¦¬à¦¾à¦¨à¦¾à¦²à¦¾à¦®
        Sheep originalDolly = new Sheep("Dolly", "white");
        originalDolly.describe(); // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Dolly is a white sheep ðŸ‘

        // à§¨. à¦¨à¦¤à§à¦¨ à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦¨à¦¾ à¦¬à¦¾à¦¨à¦¿à§Ÿà§‡ à¦†à¦—à§‡à¦°à¦Ÿà¦¾à¦•à§‡à¦‡ à¦•à§à¦²à§‹à¦¨ à¦•à¦°à¦²à¦¾à¦®
        Sheep clonedDolly = originalDolly.clone();
        
        // à¦•à§à¦²à§‹à¦¨ à¦•à¦°à¦¾ à¦­à§‡à§œà¦¾à¦° à¦¶à§à¦§à§ à¦¨à¦¾à¦®à¦Ÿà¦¾ à¦¬à¦¦à¦²à§‡ à¦¦à¦¿à¦²à¦¾à¦®, à¦¬à¦¾à¦•à¦¿ à¦¬à§ˆà¦¶à¦¿à¦·à§à¦Ÿà§à¦¯ (color) à¦¸à§‡à¦® à¦¥à¦¾à¦•à¦²à§‹!
        clonedDolly.setName("Dolly Clone 1");
        clonedDolly.setColor("black");
        clonedDolly.describe(); // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Dolly Clone 1 is a black sheep ðŸ‘

        // à¦šà§‡à¦• à¦•à¦°à§‡ à¦¦à§‡à¦–à¦¿ à¦¤à¦¾à¦°à¦¾ à¦à¦•à¦‡ à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦•à¦¿ à¦¨à¦¾
        System.out.println(originalDolly == clonedDolly); 
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: false (à¦…à¦°à§à¦¥à¦¾à§Ž à¦®à§‡à¦®à¦°à¦¿à¦¤à§‡ à¦¤à¦¾à¦°à¦¾ à¦¸à¦®à§à¦ªà§‚à¦°à§à¦£ à¦†à¦²à¦¾à¦¦à¦¾ à¦¦à§à¦Ÿà¦¿ à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ)
    }
}
