package DesignPatterns.Behavioral.Command;

// ==========================================
// Component 3: Receiver (à¦¯à§‡ à¦†à¦¸à¦²à§‡à¦‡ à¦•à¦¾à¦œà¦—à§à¦²à§‹ à¦•à¦°à¦¬à§‡)
// ==========================================
class Light {
    public void turnOn() { System.out.println("Light is ON ðŸ’¡"); }
    public void turnOff() { System.out.println("Light is OFF â¬›"); }
}

// ==========================================
// Component 1: Command Interface (à¦•à¦®à¦¨ à¦°à§à¦²à¦¸)
// ==========================================
interface Command {
    void execute(); // à¦•à¦¾à¦œà¦Ÿà¦¾ à¦•à¦°à¦¾à¦° à¦œà¦¨à§à¦¯
    void undo();    // à¦•à¦¾à¦œà¦Ÿà¦¾ à¦«à¦¿à¦°à¦¿à§Ÿà§‡ à¦¨à§‡à¦“à§Ÿà¦¾à¦° à¦œà¦¨à§à¦¯ (Undo)
}

// ==========================================
// Component 2: Concrete Commands (à¦†à¦²à¦¾à¦¦à¦¾ à¦†à¦²à¦¾à¦¦à¦¾ à¦•à¦®à¦¾à¦¨à§à¦¡à§‡à¦° à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ)
// ==========================================

// à¦²à¦¾à¦‡à¦Ÿ à¦…à¦¨ à¦•à¦°à¦¾à¦° à¦•à¦®à¦¾à¦¨à§à¦¡
class TurnOnLightCommand implements Command {
    private Light light; // à¦°à¦¿à¦¸à¦¿à¦­à¦¾à¦°à§‡à¦° à¦°à§‡à¦«à¦¾à¦°à§‡à¦¨à§à¦¸

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff(); // On-à¦à¦° à¦‰à¦²à§à¦Ÿà§‹ à¦¹à¦²à§‹ Off
    }
}

// à¦²à¦¾à¦‡à¦Ÿ à¦…à¦« à¦•à¦°à¦¾à¦° à¦•à¦®à¦¾à¦¨à§à¦¡
class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn(); // Off-à¦à¦° à¦‰à¦²à§à¦Ÿà§‹ à¦¹à¦²à§‹ On
    }
}

// ==========================================
// Component 4: Invoker (à¦¯à§‡ à¦•à¦®à¦¾à¦¨à§à¦¡ à¦§à¦¾à¦°à¦£ à¦•à¦°à§‡ à¦à¦¬à¦‚ à¦à¦•à§à¦¸à¦¿à¦•à¦¿à¦‰à¦Ÿ à¦•à¦°à§‡)
// ==========================================
class RemoteControl {
    private Command buttonCommand;
    private Command lastCommand; // Undo à¦•à¦°à¦¾à¦° à¦œà¦¨à§à¦¯ à¦†à¦—à§‡à¦° à¦•à¦®à¦¾à¦¨à§à¦¡à¦Ÿà¦¾ à¦¸à§‡à¦­ à¦°à¦¾à¦–à¦¾

    // à¦¬à¦¾à¦Ÿà¦¨à§‡ à¦†à¦®à¦°à¦¾ à¦¯à§‡à¦•à§‹à¦¨à§‹ à¦•à¦®à¦¾à¦¨à§à¦¡ à¦¸à§‡à¦Ÿ à¦•à¦°à¦¤à§‡ à¦ªà¦¾à¦°à¦¿ (Dynamically)
    public void setCommand(Command command) {
        this.buttonCommand = command;
    }

    public void pressButton() {
        if (buttonCommand != null) {
            buttonCommand.execute();
            lastCommand = buttonCommand; // à¦•à¦¾à¦œ à¦¶à§‡à¦·à§‡ à¦¸à§‡à¦­ à¦•à¦°à§‡ à¦°à¦¾à¦–à¦²à¦¾à¦®
        }
    }

    public void pressUndo() {
        if (lastCommand != null) {
            System.out.println("--- Undo Button Pressed ---");
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo!");
        }
    }
}

// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦°à¦¿à¦¸à¦¿à¦­à¦¾à¦° (Light) à¦à¦¬à¦‚ à¦‡à¦¨à¦­à§‹à¦•à¦¾à¦° (Remote) à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦²à¦¾à¦®
        Light livingRoomLight = new Light();
        RemoteControl remote = new RemoteControl();

        // à§¨. à¦•à¦¿à¦›à§ à¦•à¦®à¦¾à¦¨à§à¦¡ à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦²à¦¾à¦®
        Command turnOn = new TurnOnLightCommand(livingRoomLight);
        Command turnOff = new TurnOffLightCommand(livingRoomLight);

        // à§©. à¦°à¦¿à¦®à§‹à¦Ÿà§‡à¦° à¦¬à¦¾à¦Ÿà¦¨à§‡ "Turn ON" à¦•à¦®à¦¾à¦¨à§à¦¡ à¦¸à§‡à¦Ÿ à¦•à¦°à§‡ à¦¬à¦¾à¦Ÿà¦¨ à¦šà¦¾à¦ªà¦²à¦¾à¦®
        remote.setCommand(turnOn);
        remote.pressButton();  // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Light is ON ðŸ’¡

        // à§ª. à¦à¦¬à¦¾à¦° à¦¬à¦¾à¦Ÿà¦¨à§‡à¦° à¦•à¦¾à¦œ à¦ªà¦¾à¦²à§à¦Ÿà§‡ à¦¦à¦¿à¦²à¦¾à¦® "Turn OFF"-à¦
        remote.setCommand(turnOff);
        remote.pressButton();  // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Light is OFF â¬›

        // à§«. à¦®à§à¦¯à¦¾à¦œà¦¿à¦•! à¦à¦¬à¦¾à¦° Undo à¦¬à¦¾à¦Ÿà¦¨ à¦šà¦¾à¦ªà¦¬à§‹!
        remote.pressUndo();    // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: --- Undo Button Pressed --- \n Light is ON ðŸ’¡
    }
}
