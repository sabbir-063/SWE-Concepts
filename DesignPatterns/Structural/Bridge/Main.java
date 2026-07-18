package DesignPatterns.Structural.Bridge;

// ==========================================
// Implementation Hierarchy (কীভাবে কাজ হবে)
// ==========================================

// ১. Device ইন্টারফেস (এটি হলো Bridge)
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int level);
}

// ২. Concrete Implementations (আসল ডিভাইসগুলো)
class TV implements Device {
    @Override
    public void turnOn() { System.out.println("TV is now ON 📺"); }
    
    @Override
    public void turnOff() { System.out.println("TV is now OFF"); }
    
    @Override
    public void setVolume(int level) { System.out.println("TV volume set to " + level); }
}

class Radio implements Device {
    @Override
    public void turnOn() { System.out.println("Radio is now ON 📻"); }
    
    @Override
    public void turnOff() { System.out.println("Radio is now OFF"); }
    
    @Override
    public void setVolume(int level) { System.out.println("Radio volume set to " + level); }
}

// ==========================================
// Abstraction Hierarchy (কী কাজ হবে)
// ==========================================

// ৩. রিমোট কন্ট্রোল (এটি ডিভাইসের সাথে Bridge তৈরি করে Composition-এর মাধ্যমে)
class RemoteControl {
    protected Device device; // Bridge - ডিভাইসের রেফারেন্স

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void togglePower() {
        device.turnOn();
    }

    public void volumeUp() {
        device.setVolume(10);
    }
}

// ৪. উন্নত রিমোট কন্ট্রোল (নতুন ফিচার যোগ করা হলো, কিন্তু ডিভাইসের কোড ছুঁতে হলো না)
class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    // নতুন একটি মেথড (Mute)
    public void mute() {
        device.setVolume(0);
        System.out.println("Device is muted 🔇");
    }
}

// ==========================================
// Client Code / Main Method
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // ১. একটি রেডিও বানালাম এবং সেটা সাধারণ রিমোটের সাথে কানেক্ট করলাম
        Device radio = new Radio();
        RemoteControl radioRemote = new RemoteControl(radio);
        
        radioRemote.togglePower(); // রেডিও চালু হবে
        
        System.out.println("-----------------");

        // ২. একটি টিভি বানালাম এবং সেটা অ্যাডভান্সড রিমোটের সাথে কানেক্ট করলাম
        Device tv = new TV();
        AdvancedRemoteControl tvRemote = new AdvancedRemoteControl(tv);
        
        tvRemote.togglePower(); // টিভি চালু হবে
        tvRemote.mute();        // টিভি মিউট হবে
    }
}
