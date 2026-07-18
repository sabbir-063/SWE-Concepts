package DesignPatterns.Creational.AbstructFactory;

// ---- Products (ইন্টারফেস) ----
interface Button {
    void render();
}
interface Checkbox {
    void render();
}
// ---- Windows Family Products ----
class WindowsButton implements Button {
    public void render() { System.out.println("Rendering a Windows-style button 🟦"); }
}
class WindowsCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering a Windows-style checkbox ☑️"); }
}
// ---- Mac Family Products ----
class MacButton implements Button {
    public void render() { System.out.println("Rendering a Mac-style button 🍎"); }
}
class MacCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering a Mac-style checkbox ✅"); }
}
// ---- Abstract Factory (এখানে ফ্যামিলির সব প্রোডাক্ট বানানোর মেথড থাকবে) ----
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
// ---- Concrete Factories (আলাদা আলাদা ফ্যামিলির ফ্যাক্টরি) ----
class WindowsFactory implements UIFactory {
    public Button createButton() { return new WindowsButton(); }
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}
class MacFactory implements UIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

// ---- Client Code (অ্যাপ্লিকেশন) ----
class Application {
    private Button button;
    private Checkbox checkbox;
    // অ্যাপ্লিকেশন শুধু জানে সে একটি UIFactory পাবে, সেটা Windows না Mac তা তার জানার দরকার নেই
    public Application(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }
    public void paint() {
        button.render();
        checkbox.render();
    }
}

// ---- Client Code (Main) ----
public class Main {
    public static void main(String[] args) {
        
        // ধরুন ইউজার Windows সিলেক্ট করেছে
        UIFactory factory = new WindowsFactory(); 
        Application app = new Application(factory);
        app.paint();
        
        System.out.println("\n-------------------------\n");

        // এখন User Mac সিলেক্ট করলো
        factory = new MacFactory(); // শুধু factory পরিবর্তন করলাম
        app = new Application(factory);
        app.paint();

    }
}
