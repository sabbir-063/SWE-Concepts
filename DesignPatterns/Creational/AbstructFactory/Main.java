package DesignPatterns.Creational.AbstructFactory;

// ---- Products (à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦«à§‡à¦¸) ----
interface Button {
    void render();
}
interface Checkbox {
    void render();
}
// ---- Windows Family Products ----
class WindowsButton implements Button {
    public void render() { System.out.println("Rendering a Windows-style button ðŸŸ¦"); }
}
class WindowsCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering a Windows-style checkbox â˜‘ï¸"); }
}
// ---- Mac Family Products ----
class MacButton implements Button {
    public void render() { System.out.println("Rendering a Mac-style button ðŸŽ"); }
}
class MacCheckbox implements Checkbox {
    public void render() { System.out.println("Rendering a Mac-style checkbox âœ…"); }
}
// ---- Abstract Factory (à¦à¦–à¦¾à¦¨à§‡ à¦«à§à¦¯à¦¾à¦®à¦¿à¦²à¦¿à¦° à¦¸à¦¬ à¦ªà§à¦°à§‹à¦¡à¦¾à¦•à§à¦Ÿ à¦¬à¦¾à¦¨à¦¾à¦¨à§‹à¦° à¦®à§‡à¦¥à¦¡ à¦¥à¦¾à¦•à¦¬à§‡) ----
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
// ---- Concrete Factories (à¦†à¦²à¦¾à¦¦à¦¾ à¦†à¦²à¦¾à¦¦à¦¾ à¦«à§à¦¯à¦¾à¦®à¦¿à¦²à¦¿à¦° à¦«à§à¦¯à¦¾à¦•à§à¦Ÿà¦°à¦¿) ----
class WindowsFactory implements UIFactory {
    public Button createButton() { return new WindowsButton(); }
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}
class MacFactory implements UIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}

// ---- Client Code (à¦…à§à¦¯à¦¾à¦ªà§à¦²à¦¿à¦•à§‡à¦¶à¦¨) ----
class Application {
    private Button button;
    private Checkbox checkbox;
    // à¦…à§à¦¯à¦¾à¦ªà§à¦²à¦¿à¦•à§‡à¦¶à¦¨ à¦¶à§à¦§à§ à¦œà¦¾à¦¨à§‡ à¦¸à§‡ à¦à¦•à¦Ÿà¦¿ UIFactory à¦ªà¦¾à¦¬à§‡, à¦¸à§‡à¦Ÿà¦¾ Windows à¦¨à¦¾ Mac à¦¤à¦¾ à¦¤à¦¾à¦° à¦œà¦¾à¦¨à¦¾à¦° à¦¦à¦°à¦•à¦¾à¦° à¦¨à§‡à¦‡
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
        
        // à¦§à¦°à§à¦¨ à¦‡à¦‰à¦œà¦¾à¦° Windows à¦¸à¦¿à¦²à§‡à¦•à§à¦Ÿ à¦•à¦°à§‡à¦›à§‡
        UIFactory factory = new WindowsFactory(); 
        Application app = new Application(factory);
        app.paint();
        
        System.out.println("\n-------------------------\n");

        // à¦à¦–à¦¨ User Mac à¦¸à¦¿à¦²à§‡à¦•à§à¦Ÿ à¦•à¦°à¦²à§‹
        factory = new MacFactory(); // à¦¶à§à¦§à§ factory à¦ªà¦°à¦¿à¦¬à¦°à§à¦¤à¦¨ à¦•à¦°à¦²à¦¾à¦®
        app = new Application(factory);
        app.paint();

    }
}
