package DesignPatterns.Behavioral.TemplateMethod;

// ==========================================
// Component 1: Abstract Class (অ্যালগরিদমের স্কেলেটন বা মূল কাঠামো)
// ==========================================
abstract class BeverageMaker {
    
    // এটিই হলো "Template Method"
    // মেথডটিকে 'final' করা হয়েছে যাতে সাব-ক্লাসগুলো একে ওভাররাইড করে 
    // মূল অ্যালগরিদমের সিরিয়াল (Sequence) নষ্ট করতে না পারে!
    public final void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
        
        // হুক (Hook) ব্যবহার করে সিদ্ধান্ত নেওয়া হচ্ছে
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // ১. কমন মেথড (সবার জন্য সেম, তাই এখানেই লিখে দেওয়া হলো)
    private void boilWater() {
        System.out.println("Boiling water...");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup...");
    }

    // ২. অ্যাবস্ট্রাক্ট মেথড (যেগুলো সাব-ক্লাসকে অবশ্যই ইমপ্লিমেন্ট করতে হবে)
    protected abstract void brew();
    protected abstract void addCondiments();

    // ৩. হুক (Hook) মেথড (এটি একটি অপশনাল মেথড। 
    // ডিফল্টভাবে এটি true রিটার্ন করে, কিন্তু সাব-ক্লাস চাইলে একে ওভাররাইড করে পরিবর্তন করতে পারে)
    protected boolean customerWantsCondiments() {
        return true; 
    }
}

// ==========================================
// Component 2: Concrete Classes (আলাদা আলাদা ইমপ্লিমেন্টেশন)
// ==========================================

// চা বানানোর রেসিপি
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

// কফি বানানোর রেসিপি
class CoffeeMaker extends BeverageMaker {
    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through filter...");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Sugar and Milk...");
    }

    // কফিতে হুক (Hook) মেথড ওভাররাইড করে দিলাম
    // ধরুন, এই কাস্টমার ব্ল্যাক কফি পছন্দ করে, তাই সে চিনি/দুধ চায় না।
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
        // ক্লায়েন্ট শুধু টেমপ্লেট মেথডটিকে কল করবে
        teaMaker.makeBeverage();
        /* আউটপুট:
           Boiling water...
           Steeping the tea...
           Pouring into cup...
           Adding Lemon...
        */

        System.out.println("\n--- Making Black Coffee ---");
        BeverageMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.makeBeverage();
        /* আউটপুট:
           Boiling water...
           Dripping Coffee through filter...
           Pouring into cup...
           (এখানে Adding Sugar... প্রিন্ট হবে না কারণ হুক মেথডে false দেওয়া আছে)
        */
    }
}
