package DesignPatterns.Structural.Bridge;

// ==========================================
// Implementation Hierarchy (à¦•à§€à¦­à¦¾à¦¬à§‡ à¦•à¦¾à¦œ à¦¹à¦¬à§‡)
// ==========================================

// à§§. Device à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦«à§‡à¦¸ (à¦à¦Ÿà¦¿ à¦¹à¦²à§‹ Bridge)
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int level);
}

// à§¨. Concrete Implementations (à¦†à¦¸à¦² à¦¡à¦¿à¦­à¦¾à¦‡à¦¸à¦—à§à¦²à§‹)
class TV implements Device {
    @Override
    public void turnOn() { System.out.println("TV is now ON ðŸ“º"); }
    
    @Override
    public void turnOff() { System.out.println("TV is now OFF"); }
    
    @Override
    public void setVolume(int level) { System.out.println("TV volume set to " + level); }
}

class Radio implements Device {
    @Override
    public void turnOn() { System.out.println("Radio is now ON ðŸ“»"); }
    
    @Override
    public void turnOff() { System.out.println("Radio is now OFF"); }
    
    @Override
    public void setVolume(int level) { System.out.println("Radio volume set to " + level); }
}

// ==========================================
// Abstraction Hierarchy (à¦•à§€ à¦•à¦¾à¦œ à¦¹à¦¬à§‡)
// ==========================================

// à§©. à¦°à¦¿à¦®à§‹à¦Ÿ à¦•à¦¨à§à¦Ÿà§à¦°à§‹à¦² (à¦à¦Ÿà¦¿ à¦¡à¦¿à¦­à¦¾à¦‡à¦¸à§‡à¦° à¦¸à¦¾à¦¥à§‡ Bridge à¦¤à§ˆà¦°à¦¿ à¦•à¦°à§‡ Composition-à¦à¦° à¦®à¦¾à¦§à§à¦¯à¦®à§‡)
class RemoteControl {
    protected Device device; // Bridge - à¦¡à¦¿à¦­à¦¾à¦‡à¦¸à§‡à¦° à¦°à§‡à¦«à¦¾à¦°à§‡à¦¨à§à¦¸

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

// à§ª. à¦‰à¦¨à§à¦¨à¦¤ à¦°à¦¿à¦®à§‹à¦Ÿ à¦•à¦¨à§à¦Ÿà§à¦°à§‹à¦² (à¦¨à¦¤à§à¦¨ à¦«à¦¿à¦šà¦¾à¦° à¦¯à§‹à¦— à¦•à¦°à¦¾ à¦¹à¦²à§‹, à¦•à¦¿à¦¨à§à¦¤à§ à¦¡à¦¿à¦­à¦¾à¦‡à¦¸à§‡à¦° à¦•à§‹à¦¡ à¦›à§à¦à¦¤à§‡ à¦¹à¦²à§‹ à¦¨à¦¾)
class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    // à¦¨à¦¤à§à¦¨ à¦à¦•à¦Ÿà¦¿ à¦®à§‡à¦¥à¦¡ (Mute)
    public void mute() {
        device.setVolume(0);
        System.out.println("Device is muted ðŸ”‡");
    }
}

// ==========================================
// Client Code / Main Method
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦à¦•à¦Ÿà¦¿ à¦°à§‡à¦¡à¦¿à¦“ à¦¬à¦¾à¦¨à¦¾à¦²à¦¾à¦® à¦à¦¬à¦‚ à¦¸à§‡à¦Ÿà¦¾ à¦¸à¦¾à¦§à¦¾à¦°à¦£ à¦°à¦¿à¦®à§‹à¦Ÿà§‡à¦° à¦¸à¦¾à¦¥à§‡ à¦•à¦¾à¦¨à§‡à¦•à§à¦Ÿ à¦•à¦°à¦²à¦¾à¦®
        Device radio = new Radio();
        RemoteControl radioRemote = new RemoteControl(radio);
        
        radioRemote.togglePower(); // à¦°à§‡à¦¡à¦¿à¦“ à¦šà¦¾à¦²à§ à¦¹à¦¬à§‡
        
        System.out.println("-----------------");

        // à§¨. à¦à¦•à¦Ÿà¦¿ à¦Ÿà¦¿à¦­à¦¿ à¦¬à¦¾à¦¨à¦¾à¦²à¦¾à¦® à¦à¦¬à¦‚ à¦¸à§‡à¦Ÿà¦¾ à¦…à§à¦¯à¦¾à¦¡à¦­à¦¾à¦¨à§à¦¸à¦¡ à¦°à¦¿à¦®à§‹à¦Ÿà§‡à¦° à¦¸à¦¾à¦¥à§‡ à¦•à¦¾à¦¨à§‡à¦•à§à¦Ÿ à¦•à¦°à¦²à¦¾à¦®
        Device tv = new TV();
        AdvancedRemoteControl tvRemote = new AdvancedRemoteControl(tv);
        
        tvRemote.togglePower(); // à¦Ÿà¦¿à¦­à¦¿ à¦šà¦¾à¦²à§ à¦¹à¦¬à§‡
        tvRemote.mute();        // à¦Ÿà¦¿à¦­à¦¿ à¦®à¦¿à¦‰à¦Ÿ à¦¹à¦¬à§‡
    }
}
