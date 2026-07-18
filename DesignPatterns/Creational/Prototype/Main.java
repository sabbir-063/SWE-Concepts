package DesignPatterns.Creational.Prototype;

// ১. প্রোটোটাইপ ক্লাস (যেটাকে আমরা ক্লোন করতে চাই)
// জাভাতে ক্লোন সাপোর্ট করার জন্য Cloneable ইন্টারফেস ইমপ্লিমেন্ট করতে হয়
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
        System.out.println(name + " is a " + color + " sheep 🐑");
    }

    // ২. ক্লোন মেথড ওভাররাইড করা
    @Override
    protected Sheep clone() {
        try {
            // জাভার ডিফল্ট ক্লোন মেথড ব্যবহার করছি (Shallow Copy)
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
        // ১. একটি আসল ভেড়া বানালাম
        Sheep originalDolly = new Sheep("Dolly", "white");
        originalDolly.describe(); // আউটপুট: Dolly is a white sheep 🐑

        // ২. নতুন অবজেক্ট না বানিয়ে আগেরটাকেই ক্লোন করলাম
        Sheep clonedDolly = originalDolly.clone();
        
        // ক্লোন করা ভেড়ার শুধু নামটা বদলে দিলাম, বাকি বৈশিষ্ট্য (color) সেম থাকলো!
        clonedDolly.setName("Dolly Clone 1");
        clonedDolly.setColor("black");
        clonedDolly.describe(); // আউটপুট: Dolly Clone 1 is a black sheep 🐑

        // চেক করে দেখি তারা একই অবজেক্ট কি না
        System.out.println(originalDolly == clonedDolly); 
        // আউটপুট: false (অর্থাৎ মেমরিতে তারা সম্পূর্ণ আলাদা দুটি অবজেক্ট)
    }
}
