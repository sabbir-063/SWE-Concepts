package DesignPatterns.Structural.Decorator;

// ১. Base Component (মূল ইন্টারফেস)
interface Coffee {
    int getCost();
    String getDescription();
}

// ২. Concrete Component (আমাদের বেসিক কফি)
class SimpleCoffee implements Coffee {
    @Override
    public int getCost() {
        return 50; // বেসিক কফির দাম ৫০ টাকা
    }

    @Override
    public String getDescription() {
        return "Plain Coffee";
    }
}

// ৩. Base Decorator (এটি হলো মূল র্যাপার / Wrapper ক্লাস)
// এটি Coffee ইমপ্লিমেন্ট করে, আবার ভেতরে একটি Coffee অবজেক্ট ধারণও করে (Composition)!
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee; // যে কফিটাকে সে মুড়িয়ে (wrap) রাখছে

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getCost() {
        return coffee.getCost(); // ভেতরের কফির দাম রিটার্ন করবে
    }

    @Override
    public String getDescription() {
        return coffee.getDescription(); // ভেতরের কফির ডেসক্রিপশন রিটার্ন করবে
    }
}

// ৪. Concrete Decorators (এক একটা নতুন ফিচার বা লেয়ার)
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public int getCost() {
        return super.getCost() + 15; // কফির মূল দামের সাথে দুধের দাম ১৫ টাকা যোগ
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
        return super.getCost() + 5; // চিনির দাম ৫ টাকা যোগ
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
        return super.getCost() + 25; // ক্যারামেলের দাম ২৫ টাকা যোগ
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Caramel";
    }
}

// ---- Main Method (Client Code) ----
public class Main {
    public static void main(String[] args) {
        
        // ১. প্রথমে শুধু একটি বেসিক কফি বানালাম
        Coffee myCoffee = new SimpleCoffee();
        System.out.println(myCoffee.getDescription() + " = " + myCoffee.getCost() + " BDT");
        // আউটপুট: Plain Coffee = 50 BDT

        // ২. এবার বেসিক কফির চারধারে দুধের (Milk) লেয়ার বা ডেকোরেশন যুক্ত করলাম
        myCoffee = new MilkDecorator(myCoffee);
        System.out.println(myCoffee.getDescription() + " = " + myCoffee.getCost() + " BDT");
        // আউটপুট: Plain Coffee + Milk = 65 BDT

        // ৩. এরপর চিনি এবং ক্যারামেল লেয়ারও যুক্ত করলাম (Nested Wrapping)
        myCoffee = new SugarDecorator(myCoffee);
        myCoffee = new CaramelDecorator(myCoffee);

        // ফাইনাল রেজাল্ট:
        System.out.println(myCoffee.getDescription() + " = " + myCoffee.getCost() + " BDT");
        // আউটপুট: Plain Coffee + Milk + Sugar + Caramel = 95 BDT
    }
}
