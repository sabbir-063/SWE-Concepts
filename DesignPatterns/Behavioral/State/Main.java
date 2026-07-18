package DesignPatterns.Behavioral.State;

// ==========================================
// Component 2: State Interface (à¦¸à§à¦Ÿà§‡à¦Ÿà§‡à¦° à¦•à¦®à¦¨ à¦°à§à¦²à¦¸)
// ==========================================
interface MobileAlertState {
    void alert(MobileContext context);
}

// ==========================================
// Component 3: Concrete States (à¦†à¦²à¦¾à¦¦à¦¾ à¦†à¦²à¦¾à¦¦à¦¾ à¦¸à§à¦Ÿà§‡à¦Ÿ)
// ==========================================

// à¦­à¦¾à¦‡à¦¬à§à¦°à§‡à¦¶à¦¨ à¦¸à§à¦Ÿà§‡à¦Ÿ
class VibrationState implements MobileAlertState {
    @Override
    public void alert(MobileContext context) {
        System.out.println("Mobile is in VIBRATION Mode: Bzzzz... Bzzzz...");
    }
}

// à¦¸à¦¾à¦‡à¦²à§‡à¦¨à§à¦Ÿ à¦¸à§à¦Ÿà§‡à¦Ÿ
class SilentState implements MobileAlertState {
    @Override
    public void alert(MobileContext context) {
        System.out.println("Mobile is in SILENT Mode: (No sound, just screen wakes up)");
    }
}

// à¦¸à¦¾à¦‰à¦¨à§à¦¡ à¦¬à¦¾ à¦°à¦¿à¦‚ à¦¸à§à¦Ÿà§‡à¦Ÿ
class SoundState implements MobileAlertState {
    @Override
    public void alert(MobileContext context) {
        System.out.println("Mobile is in SOUND Mode: Ring... Ring... Ring...");
    }
}

// ==========================================
// Component 1: Context (à¦†à¦¸à¦² à¦…à¦¬à¦œà§‡à¦•à§à¦Ÿ à¦¯à¦¾à¦° à¦¸à§à¦Ÿà§‡à¦Ÿ à¦¬à¦¦à¦²à¦¾à¦¬à§‡)
// ==========================================
class MobileContext {
    private MobileAlertState currentState;

    // à¦¡à¦¿à¦«à¦²à§à¦Ÿà¦­à¦¾à¦¬à§‡ à¦®à§‹à¦¬à¦¾à¦‡à¦² à¦°à¦¿à¦‚ à¦¸à§à¦Ÿà§‡à¦Ÿà§‡ à¦¥à¦¾à¦•à§‡
    public MobileContext() {
        currentState = new SoundState(); 
    }

    // à¦¸à§à¦Ÿà§‡à¦Ÿ à¦ªà¦°à¦¿à¦¬à¦°à§à¦¤à¦¨ à¦•à¦°à¦¾à¦° à¦®à§‡à¦¥à¦¡
    public void setState(MobileAlertState state) {
        this.currentState = state;
    }

    // à¦¸à§à¦Ÿà§‡à¦Ÿ à¦…à¦¨à§à¦¯à¦¾à§Ÿà§€ à¦•à¦¾à¦œ à¦•à¦°à¦¾à¦° à¦®à§‡à¦¥à¦¡
    public void alert() {
        // à¦®à§‹à¦¬à¦¾à¦‡à¦² à¦¨à¦¿à¦œà§‡ à¦šà§‡à¦• à¦•à¦°à§‡ à¦¨à¦¾ à¦¸à§‡ à¦•à§‹à¦¨ à¦¸à§à¦Ÿà§‡à¦Ÿà§‡ à¦†à¦›à§‡, 
        // à¦¸à§‡ à¦¶à§à¦§à§ à¦•à¦¾à¦°à§‡à¦¨à§à¦Ÿ à¦¸à§à¦Ÿà§‡à¦Ÿà¦•à§‡ à¦¬à¦²à§‡- "à¦¤à§‹à¦®à¦¾à¦° à¦•à¦¾à¦œà¦Ÿà¦¾ à¦•à¦°à§‹"
        currentState.alert(this);
    }
}

// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦à¦•à¦Ÿà¦¿ à¦®à§‹à¦¬à¦¾à¦‡à¦² à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦²à¦¾à¦® (à¦¡à¦¿à¦«à¦²à§à¦Ÿ Sound mode)
        MobileContext myMobile = new MobileContext();
        
        System.out.println("--- Someone is calling ---");
        myMobile.alert(); // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Ring... Ring... Ring...

        // à§¨. à¦‡à¦‰à¦œà¦¾à¦° à¦®à§‹à¦¬à¦¾à¦‡à¦²à¦Ÿà¦¿ à¦­à¦¾à¦‡à¦¬à§à¦°à§‡à¦¶à¦¨à§‡ à¦¦à¦¿à¦²à§‹
        System.out.println("\n--- Changed to Vibrate Mode ---");
        myMobile.setState(new VibrationState());
        myMobile.alert(); // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: Bzzzz... Bzzzz...

        // à§©. à¦‡à¦‰à¦œà¦¾à¦° à¦®à¦¿à¦Ÿà¦¿à¦‚à§Ÿà§‡ à¦—à§‡à¦²à§‹, à¦¤à¦¾à¦‡ à¦¸à¦¾à¦‡à¦²à§‡à¦¨à§à¦Ÿ à¦•à¦°à§‡ à¦¦à¦¿à¦²à§‹
        System.out.println("\n--- Changed to Silent Mode ---");
        myMobile.setState(new SilentState());
        myMobile.alert(); // à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ: (No sound, just screen wakes up)
    }
}
