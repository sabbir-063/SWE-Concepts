package DesignPatterns.Behavioral.TemplateMethod;

// ==========================================
// Component 1: Abstract Class (à¦…à§à¦¯à¦¾à¦²à¦—à¦°à¦¿à¦¦à¦®à§‡à¦° à¦¸à§à¦•à§‡à¦²à§‡à¦Ÿà¦¨ à¦¬à¦¾ à¦®à§‚à¦² à¦•à¦¾à¦ à¦¾à¦®à§‹)
// ==========================================
abstract class BeverageMaker {
    
    // à¦à¦Ÿà¦¿à¦‡ à¦¹à¦²à§‹ "Template Method"
    // à¦®à§‡à¦¥à¦¡à¦Ÿà¦¿à¦•à§‡ 'final' à¦•à¦°à¦¾ à¦¹à§Ÿà§‡à¦›à§‡ à¦¯à¦¾à¦¤à§‡ à¦¸à¦¾à¦¬-à¦•à§à¦²à¦¾à¦¸à¦—à§à¦²à§‹ à¦à¦•à§‡ à¦“à¦­à¦¾à¦°à¦°à¦¾à¦‡à¦¡ à¦•à¦°à§‡ 
    // à¦®à§‚à¦² à¦…à§à¦¯à¦¾à¦²à¦—à¦°à¦¿à¦¦à¦®à§‡à¦° à¦¸à¦¿à¦°à¦¿à§Ÿà¦¾à¦² (Sequence) à¦¨à¦·à§à¦Ÿ à¦•à¦°à¦¤à§‡ à¦¨à¦¾ à¦ªà¦¾à¦°à§‡!
    public final void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
        
        // à¦¹à§à¦• (Hook) à¦¬à§à¦¯à¦¬à¦¹à¦¾à¦° à¦•à¦°à§‡ à¦¸à¦¿à¦¦à§à¦§à¦¾à¦¨à§à¦¤ à¦¨à§‡à¦“à§Ÿà¦¾ à¦¹à¦šà§à¦›à§‡
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // à§§. à¦•à¦®à¦¨ à¦®à§‡à¦¥à¦¡ (à¦¸à¦¬à¦¾à¦° à¦œà¦¨à§à¦¯ à¦¸à§‡à¦®, à¦¤à¦¾à¦‡ à¦à¦–à¦¾à¦¨à§‡à¦‡ à¦²à¦¿à¦–à§‡ à¦¦à§‡à¦“à§Ÿà¦¾ à¦¹à¦²à§‹)
    private void boilWater() {
        System.out.println("Boiling water...");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    // à§¨. à¦…à§à¦¯à¦¾à¦¬à¦¸à§à¦Ÿà§à¦°à¦¾à¦•à§à¦Ÿ à¦®à§‡à¦¥à¦¡ (à¦¯à§‡à¦—à§à¦²à§‹ à¦¸à¦¾à¦¬-à¦•à§à¦²à¦¾à¦¸à¦•à§‡ à¦…à¦¬à¦¶à§à¦¯à¦‡ à¦‡à¦®à¦ªà§à¦²à¦¿à¦®à§‡à¦¨à§à¦Ÿ à¦•à¦°à¦¤à§‡ à¦¹à¦¬à§‡)
    protected abstract void brew();
    protected abstract void addCondiments();

    // à§©. à¦¹à§à¦• (Hook) à¦®à§‡à¦¥à¦¡ (à¦à¦Ÿà¦¿ à¦à¦•à¦Ÿà¦¿ à¦…à¦ªà¦¶à¦¨à¦¾à¦² à¦®à§‡à¦¥à¦¡à¥¤ 
    // à¦¡à¦¿à¦«à¦²à§à¦Ÿà¦­à¦¾à¦¬à§‡ à¦à¦Ÿà¦¿ true à¦°à¦¿à¦Ÿà¦¾à¦°à§à¦¨ à¦•à¦°à§‡, à¦•à¦¿à¦¨à§à¦¤à§ à¦¸à¦¾à¦¬-à¦•à§à¦²à¦¾à¦¸ à¦šà¦¾à¦‡à¦²à§‡ à¦à¦•à§‡ à¦“à¦­à¦¾à¦°à¦°à¦¾à¦‡à¦¡ à¦•à¦°à§‡ à¦ªà¦°à¦¿à¦¬à¦°à§à¦¤à¦¨ à¦•à¦°à¦¤à§‡ à¦ªà¦¾à¦°à§‡)
    protected boolean customerWantsCondiments() {
        return true; 
    }
}

// ==========================================
// Component 2: Concrete Classes (à¦†à¦²à¦¾à¦¦à¦¾ à¦†à¦²à¦¾à¦¦à¦¾ à¦‡à¦®à¦ªà§à¦²à¦¿à¦®à§‡à¦¨à§à¦Ÿà§‡à¦¶à¦¨)
// ==========================================

// à¦šà¦¾ à¦¬à¦¾à¦¨à¦¾à¦¨à§‹à¦° à¦°à§‡à¦¸à¦¿à¦ªà¦¿
class TeaMaker extends BeverageMaker {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Lemon...");
    }
}

// à¦•à¦«à¦¿ à¦¬à¦¾à¦¨à¦¾à¦¨à§‹à¦° à¦°à§‡à¦¸à¦¿à¦ªà¦¿
class CoffeeMaker extends BeverageMaker {
    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through filter...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Sugar and Milk...");
    }

    // à¦•à¦«à¦¿à¦¤à§‡ à¦¹à§à¦• (Hook) à¦®à§‡à¦¥à¦¡ à¦“à¦­à¦¾à¦°à¦°à¦¾à¦‡à¦¡ à¦•à¦°à§‡ à¦¦à¦¿à¦²à¦¾à¦®
    // à¦§à¦°à§à¦¨, à¦à¦‡ à¦•à¦¾à¦¸à§à¦Ÿà¦®à¦¾à¦° à¦¬à§à¦²à§à¦¯à¦¾à¦• à¦•à¦«à¦¿ à¦ªà¦›à¦¨à§à¦¦ à¦•à¦°à§‡, à¦¤à¦¾à¦‡ à¦¸à§‡ à¦šà¦¿à¦¨à¦¿/à¦¦à§à¦§ à¦šà¦¾à§Ÿ à¦¨à¦¾à¥¤
    @Override
    protected boolean customerWantsCondiments() {
        return false; 
    }
}

// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- Making Lemon Tea ---");
        BeverageMaker teaMaker = new TeaMaker();
        // à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿ à¦¶à§à¦§à§ à¦Ÿà§‡à¦®à¦ªà§à¦²à§‡à¦Ÿ à¦®à§‡à¦¥à¦¡à¦Ÿà¦¿à¦•à§‡ à¦•à¦² à¦•à¦°à¦¬à§‡
        teaMaker.makeBeverage();
        /* à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ:
           Boiling water...
           Steeping the tea...
           Pouring into cup...
           Adding Lemon...
        */

        System.out.println("\n--- Making Black Coffee ---");
        BeverageMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.makeBeverage();
        /* à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ:
           Boiling water...
           Dripping Coffee through filter...
           Pouring into cup...
           (à¦à¦–à¦¾à¦¨à§‡ Adding Sugar... à¦ªà§à¦°à¦¿à¦¨à§à¦Ÿ à¦¹à¦¬à§‡ à¦¨à¦¾ à¦•à¦¾à¦°à¦£ à¦¹à§à¦• à¦®à§‡à¦¥à¦¡à§‡ false à¦¦à§‡à¦“à§Ÿà¦¾ à¦†à¦›à§‡)
        */
    }
}
