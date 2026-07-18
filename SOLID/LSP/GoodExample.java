package SOLID.LSP;

// ✅ Good Example: Liskov Substitution Principle (LSP) ফলো করছে
// এখন আমরা ইন্টারফেস বা অ্যাবস্ট্রাকশন এমনভাবে বানাবো যেন Child class কখনো Parent এর রুলস ব্রেক না করে।

// ১. বেসিক Bird ইন্টারফেস (সব পাখির সাধারণ বৈশিষ্ট্য)
interface Bird {
    void eat();
}

// ২. যে পাখিরা উড়তে পারে, তাদের জন্য আলাদা ইন্টারফেস
interface FlyingBird extends Bird {
    void fly();
}

// ৩. Eagle একটি FlyingBird, তাই সে উড়তে পারবে
class Eagle implements FlyingBird {
    @Override
    public void eat() {
        System.out.println("Eagle is eating meat 🥩");
    }

    @Override
    public void fly() {
        System.out.println("Eagle is flying high! 🦅");
    }
}

// ৪. Ostrich শুধু একটি Bird, সে FlyingBird নয়! তাই fly() মেথডটি এখানে আসলোই না।
class Ostrich implements Bird {
    @Override
    public void eat() {
        System.out.println("Ostrich is eating grass 🌱");
    }
}

public class GoodExample {
    public static void main(String[] args) {
        
        // FlyingBird এর জায়গায় Eagle বসালাম, কোনো সমস্যা নেই!
        FlyingBird myEagle = new Eagle();
        myEagle.eat();
        myEagle.fly();

        // Bird এর জায়গায় Ostrich বসালাম, সে শুধু খাবে, উড়ার চেষ্টা করে ক্র্যাশ করবে না!
        Bird myOstrich = new Ostrich();
        myOstrich.eat();
        // myOstrich.fly(); // ❌ Compile time error! উটপাখি তো উড়তেই পারে না!
    }
}
