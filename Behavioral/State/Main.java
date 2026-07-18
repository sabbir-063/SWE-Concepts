package Behavioral.State;

// ==========================================
// Component 2: State Interface (স্টেটের কমন রুলস)
// ==========================================
interface MobileAlertState {
    void alert(MobileContext context);
}

// ==========================================
// Component 3: Concrete States (আলাদা আলাদা স্টেট)
// ==========================================

// ভাইব্রেশন স্টেট
class VibrationState implements MobileAlertState {
    @Override
    public void alert(MobileContext context) {
        System.out.println("Mobile is in VIBRATION Mode: Bzzzz... Bzzzz...");
    }
}

// সাইলেন্ট স্টেট
class SilentState implements MobileAlertState {
    @Override
    public void alert(MobileContext context) {
        System.out.println("Mobile is in SILENT Mode: (No sound, just screen wakes up)");
    }
}

// সাউন্ড বা রিং স্টেট
class SoundState implements MobileAlertState {
    @Override
    public void alert(MobileContext context) {
        System.out.println("Mobile is in SOUND Mode: Ring... Ring... Ring...");
    }
}

// ==========================================
// Component 1: Context (আসল অবজেক্ট যার স্টেট বদলাবে)
// ==========================================
class MobileContext {
    private MobileAlertState currentState;

    // ডিফল্টভাবে মোবাইল রিং স্টেটে থাকে
    public MobileContext() {
        currentState = new SoundState(); 
    }

    // স্টেট পরিবর্তন করার মেথড
    public void setState(MobileAlertState state) {
        this.currentState = state;
    }

    // স্টেট অনুযায়ী কাজ করার মেথড
    public void alert() {
        // মোবাইল নিজে চেক করে না সে কোন স্টেটে আছে, 
        // সে শুধু কারেন্ট স্টেটকে বলে- "তোমার কাজটা করো"
        currentState.alert(this);
    }
}

// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // ১. একটি মোবাইল তৈরি করলাম (ডিফল্ট Sound mode)
        MobileContext myMobile = new MobileContext();
        
        System.out.println("--- Someone is calling ---");
        myMobile.alert(); // আউটপুট: Ring... Ring... Ring...

        // ২. ইউজার মোবাইলটি ভাইব্রেশনে দিলো
        System.out.println("\n--- Changed to Vibrate Mode ---");
        myMobile.setState(new VibrationState());
        myMobile.alert(); // আউটপুট: Bzzzz... Bzzzz...

        // ৩. ইউজার মিটিংয়ে গেলো, তাই সাইলেন্ট করে দিলো
        System.out.println("\n--- Changed to Silent Mode ---");
        myMobile.setState(new SilentState());
        myMobile.alert(); // আউটপুট: (No sound, just screen wakes up)
    }
}
