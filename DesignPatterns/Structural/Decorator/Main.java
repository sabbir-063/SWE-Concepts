package DesignPatterns.Structural.Decorator;

// à§§. Base Component (à¦®à§‚à¦² à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦«à§‡à¦¸)
interface Coffee {
    int getCost();
    String getDescription();
}

// à§¨. Concrete Component (à¦†à¦®à¦¾à¦¦à§‡à¦° à¦¬à§‡à¦¸à¦¿à¦• à¦•à¦«à¦¿)
class SimpleCoffee implements Coffee {
    @Override
    public int getCost() {
        return 50; // à¦¬à§‡à¦¸à¦¿à¦• à¦•à¦«à¦¿à¦° à¦¦à¦¾à¦® à§«à§¦ à¦Ÿà¦¾à¦•à¦¾
    }

    @Override
    public String getDescription() {
        return "Plain Coffee";
    }
}

// à§©. Base Decorator (à¦à¦Ÿà¦¿ à¦¹à¦²à§‹ à¦®à§‚à¦² à¦°à§à¦¯à¦¾à¦ªà¦¾à¦° / Wrapper à¦•à§à¦²à¦¾à¦¸)
// à¦à¦Ÿà¦¿ Coffee à¦‡à¦®à¦ªà§à¦²à¦¿à¦®à§‡à¦¨à§à¦Ÿ à¦•à¦°à§‡, à¦†à¦¬à¦¾à¦° à¦­à§‡à¦¤à¦°à§‡ à¦à¦•à¦Ÿà¦¿ Coffee à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦§à¦¾à¦°à¦£à¦“ à¦•à¦°à§‡ (Composition)!
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee; // à¦¯à§‡ à¦•à¦«à¦¿à¦Ÿà¦¾à¦•à§‡ à¦¸à§‡ à¦®à§à§œà¦¿à§Ÿà§‡ (wrap) à¦°à¦¾à¦–à¦›à§‡

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return coffee.getCost(); // à¦­à§‡à¦¤à¦°à§‡à¦° à¦•à¦«à¦¿à¦° à¦¦à¦¾à¦® à¦°à¦¿à¦Ÿà¦¾à¦°à§à¦¨ à¦•à¦°à¦¬à§‡
    }

    @Override
    public String getDescription() {
        return coffee.getDescription(); // à¦­à§‡à¦¤à¦°à§‡à¦° à¦•à¦«à¦¿à¦° à¦¡à§‡à¦¸à¦•à§à¦°à¦¿à¦ªà¦¶à¦¨ à¦°à¦¿à¦Ÿà¦¾à¦°à§à¦¨ à¦•à¦°à¦¬à§‡
    }
}

// à§ª. Concrete Decorators (à¦à¦• à¦à¦•à¦Ÿà¦¾ à¦¨à¦¤à§à¦¨ à¦«à¦¿à¦šà¦¾à¦° à¦¬à¦¾ à¦²à§‡à§Ÿà¦¾à¦°)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 15; // à¦•à¦«à¦¿à¦° à¦®à§‚à¦² à¦¦à¦¾à¦®à§‡à¦° à¦¸à¦¾à¦¥à§‡ à¦¦à§à¦§à§‡à¦° à¦¦à¦¾à¦® à§§à§« à¦Ÿà¦¾à¦•à¦¾ à¦¯à§‹à¦—
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Milk";
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 5; // à¦šà¦¿à¦¨à¦¿à¦° à¦¦à¦¾à¦® à§« à¦Ÿà¦¾à¦•à¦¾ à¦¯à§‹à¦—
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Sugar";
    }
}

class CaramelDecorator extends CoffeeDecorator {
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 25; // à¦•à§à¦¯à¦¾à¦°à¦¾à¦®à§‡à¦²à§‡à¦° à¦¦à¦¾à¦® à§¨à§« à¦Ÿà¦¾à¦•à¦¾ à¦¯à§‹à¦—
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Caramel";
    }
}

// ---- Main Method (Client Code) ----
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦ªà§à¦°à¦¥à¦®à§‡ à¦¶à§à¦§à§ à¦à¦•à¦Ÿà¦¿ à¦¬à§‡à¦¸à¦¿à¦• à¦•à¦«à¦¿ à¦¬à¦¾à¦¨à¦¾à¦²à¦¾à¦®
        Coffee myCoffee = new SimpleCoffee();
        System.out.println(myCoffee.getDescription() + " = " + myCoffee.getCost() + " BDT");
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Plain Coffee = 50 BDT

        // à§¨. à¦à¦¬à¦¾à¦° à¦¬à§‡à¦¸à¦¿à¦• à¦•à¦«à¦¿à¦° à¦šà¦¾à¦°à¦§à¦¾à¦°à§‡ à¦¦à§à¦§à§‡à¦° (Milk) à¦²à§‡à§Ÿà¦¾à¦° à¦¬à¦¾ à¦¡à§‡à¦•à§‹à¦°à§‡à¦¶à¦¨ à¦¯à§à¦•à§à¦¤ à¦•à¦°à¦²à¦¾à¦®
        myCoffee = new MilkDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " = " + myCoffee.getCost() + " BDT");
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Plain Coffee + Milk = 65 BDT

        // à§©. à¦à¦°à¦ªà¦° à¦šà¦¿à¦¨à¦¿ à¦à¦¬à¦‚ à¦•à§à¦¯à¦¾à¦°à¦¾à¦®à§‡à¦² à¦²à§‡à§Ÿà¦¾à¦°à¦“ à¦¯à§à¦•à§à¦¤ à¦•à¦°à¦²à¦¾à¦® (Nested Wrapping)
        myCoffee = new SugarDecorator(myCoffee);
        myCoffee = new CaramelDecorator(myCoffee);

        // à¦«à¦¾à¦‡à¦¨à¦¾à¦² à¦°à§‡à¦œà¦¾à¦²à§à¦Ÿ:
        System.out.println(myCoffee.getDescription() + " = " + myCoffee.getCost() + " BDT");
        // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Plain Coffee + Milk + Sugar + Caramel = 95 BDT
    }
}
