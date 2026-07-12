package Structural.Facade;

// ==========================================
// Complex Subsystem (জটিল সাব-সিস্টেমের ক্লাসগুলো)
// ==========================================

class Light {
    public void turnOff() { System.out.println("Lights are OFF 💡"); }
}

class TV {
    public void turnOn() { System.out.println("TV is ON 📺"); }
}

class SoundSystem {
    public void turnOn() { System.out.println("Sound System is ON 🔊"); }
    public void setVolume(int level) { System.out.println("Volume set to " + level); }
}

class DVDPlayer {
    public void play(String movie) { System.out.println("Playing movie: " + movie + " 🎬"); }
}

// ==========================================
// Facade Class (সহজ ইন্টারফেস বা দরজা)
// ==========================================

class SmartHomeFacade {
    private Light light;
    private TV tv;
    private SoundSystem soundSystem;
    private DVDPlayer dvdPlayer;

    // কনস্ট্রাক্টরে সব জটিল সাব-সিস্টেমগুলো ইনিশিয়ালাইজ করা হলো
    public SmartHomeFacade(Light light, TV tv, SoundSystem soundSystem, DVDPlayer dvdPlayer) {
        this.light = light;
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.dvdPlayer = dvdPlayer;
    }

    // ক্লায়েন্টের জন্য একটি সিম্পল মেথড
    public void watchMovie(String movieName) {
        System.out.println("--- Get ready to watch a movie! ---");
        // ফ্যাসাড ক্লাস নিজেই সব জটিল লজিক হ্যান্ডেল করছে
        light.turnOff();
        tv.turnOn();
        soundSystem.turnOn();
        soundSystem.setVolume(20);
        dvdPlayer.play(movieName);
        System.out.println("--- Enjoy! ---");
    }
}

// ==========================================
// Main Method (Client Code)
// ==========================================
public class Main {
    public static void main(String[] args) {
        // ১. সাব-সিস্টেমগুলো তৈরি করা
        Light light = new Light();
        TV tv = new TV();
        SoundSystem soundSystem = new SoundSystem();
        DVDPlayer dvdPlayer = new DVDPlayer();

        // ২. ক্লায়েন্ট শুধু ফ্যাসাড তৈরি করলো
        SmartHomeFacade homeTheater = new SmartHomeFacade(light, tv, soundSystem, dvdPlayer);

        // ৩. ক্লায়েন্টকে আর আলাদা করে ৫টি মেথড কল করতে হলো না!
        // সে শুধু ফ্যাসাডের একটি মেথড কল করলো
        homeTheater.watchMovie("Inception");
    }
}
