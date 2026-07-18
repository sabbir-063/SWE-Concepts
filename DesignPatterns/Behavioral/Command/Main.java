package DesignPatterns.Behavioral.Command;

// ==========================================
// Component 3: Receiver (যে আসলেই কাজগুলো করবে)
// ==========================================
class Light {
    public void turnOn() { System.out.println("Light is ON 💡"); }
    public void turnOff() { System.out.println("Light is OFF ⬛"); }
}

// ==========================================
// Component 1: Command Interface (কমন রুলস)
// ==========================================
interface Command {
    void execute(); // কাজটা করার জন্য
    void undo();    // কাজটা ফিরিয়ে নেওয়ার জন্য (Undo)
}

// ==========================================
// Component 2: Concrete Commands (আলাদা আলাদা কমান্ডের অবজেক্ট)
// ==========================================

// লাইট অন করার কমান্ড
class TurnOnLightCommand implements Command {
    private Light light; // রিসিভারের রেফারেন্স

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff(); // On-এর উল্টো হলো Off
    }
}

// লাইট অফ করার কমান্ড
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
        light.turnOn(); // Off-এর উল্টো হলো On
    }
}

// ==========================================
// Component 4: Invoker (যে কমান্ড ধারণ করে এবং এক্সিকিউট করে)
// ==========================================
class RemoteControl {
    private Command buttonCommand;
    private Command lastCommand; // Undo করার জন্য আগের কমান্ডটা সেভ রাখা

    // বাটনে আমরা যেকোনো কমান্ড সেট করতে পারি (Dynamically)
    public void setCommand(Command command) {
        this.buttonCommand = command;
    }

    public void pressButton() {
        if (buttonCommand != null) {
            buttonCommand.execute();
            lastCommand = buttonCommand; // কাজ শেষে সেভ করে রাখলাম
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
        
        // ১. রিসিভার (Light) এবং ইনভোকার (Remote) তৈরি করলাম
        Light livingRoomLight = new Light();
        RemoteControl remote = new RemoteControl();

        // ২. কিছু কমান্ড অবজেক্ট তৈরি করলাম
        Command turnOn = new TurnOnLightCommand(livingRoomLight);
        Command turnOff = new TurnOffLightCommand(livingRoomLight);

        // ৩. রিমোটের বাটনে "Turn ON" কমান্ড সেট করে বাটন চাপলাম
        remote.setCommand(turnOn);
        remote.pressButton();  // আউটপুট: Light is ON 💡

        // ৪. এবার বাটনের কাজ পাল্টে দিলাম "Turn OFF"-এ
        remote.setCommand(turnOff);
        remote.pressButton();  // আউটপুট: Light is OFF ⬛

        // ৫. ম্যাজিক! এবার Undo বাটন চাপবো!
        remote.pressUndo();    // আউটপুট: --- Undo Button Pressed --- \n Light is ON 💡
    }
}
