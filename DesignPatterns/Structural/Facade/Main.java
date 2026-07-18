package DesignPatterns.Structural.Facade;

// ==========================================
// Complex Subsystem (à¦œà¦Ÿà¦¿à¦² à¦¸à¦¾à¦¬-à¦¸à¦¿à¦¸à§à¦Ÿà§‡à¦®à§‡à¦° à¦•à§à¦²à¦¾à¦¸à¦—à§à¦²à§‹)
// ==========================================

class Light {
    public void turnOff() { System.out.println("Lights are OFF ðŸ’¡"); }
}

class TV {
    public void turnOn() { System.out.println("TV is ON ðŸ“º"); }
}

class SoundSystem {
    public void turnOn() { System.out.println("Sound System is ON ðŸ”Š"); }
    public void setVolume(int level) { System.out.println("Volume set to " + level); }
}

class DVDPlayer {
    public void play(String movie) { System.out.println("Playing movie: " + movie + " ðŸŽ¬"); }
}

// ==========================================
// Facade Class (à¦¸à¦¹à¦œ à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦«à§‡à¦¸ à¦¬à¦¾ à¦¦à¦°à¦œà¦¾)
// ==========================================

class SmartHomeFacade {
    private Light light;
    private TV tv;
    private SoundSystem soundSystem;
    private DVDPlayer dvdPlayer;

    // à¦•à¦¨à¦¸à§à¦Ÿà§à¦°à¦¾à¦•à§à¦Ÿà¦°à§‡ à¦¸à¦¬ à¦œà¦Ÿà¦¿à¦² à¦¸à¦¾à¦¬-à¦¸à¦¿à¦¸à§à¦Ÿà§‡à¦®à¦—à§à¦²à§‹ à¦‡à¦¨à¦¿à¦¶à¦¿à§Ÿà¦¾à¦²à¦¾à¦‡à¦œ à¦•à¦°à¦¾ à¦¹à¦²à§‹
    public SmartHomeFacade(Light light, TV tv, SoundSystem soundSystem, DVDPlayer dvdPlayer) {
        this.light = light;
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.dvdPlayer = dvdPlayer;
    }

    // à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿà§‡à¦° à¦œà¦¨à§à¦¯ à¦à¦•à¦Ÿà¦¿ à¦¸à¦¿à¦®à§à¦ªà¦² à¦®à§‡à¦¥à¦¡
    public void watchMovie(String movieName) {
        System.out.println("--- Get ready to watch a movie! ---");
        // à¦«à§à¦¯à¦¾à¦¸à¦¾à¦¡ à¦•à§à¦²à¦¾à¦¸ à¦¨à¦¿à¦œà§‡à¦‡ à¦¸à¦¬ à¦œà¦Ÿà¦¿à¦² à¦²à¦œà¦¿à¦• à¦¹à§à¦¯à¦¾à¦¨à§à¦¡à§‡à¦² à¦•à¦°à¦›à§‡
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
        // à§§. à¦¸à¦¾à¦¬-à¦¸à¦¿à¦¸à§à¦Ÿà§‡à¦®à¦—à§à¦²à§‹ à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦¾
        Light light = new Light();
        TV tv = new TV();
        SoundSystem soundSystem = new SoundSystem();
        DVDPlayer dvdPlayer = new DVDPlayer();

        // à§¨. à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿ à¦¶à§à¦§à§ à¦«à§à¦¯à¦¾à¦¸à¦¾à¦¡ à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦²à§‹
        SmartHomeFacade homeTheater = new SmartHomeFacade(light, tv, soundSystem, dvdPlayer);

        // à§©. à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿà¦•à§‡ à¦†à¦° à¦†à¦²à¦¾à¦¦à¦¾ à¦•à¦°à§‡ à§«à¦Ÿà¦¿ à¦®à§‡à¦¥à¦¡ à¦•à¦² à¦•à¦°à¦¤à§‡ à¦¹à¦²à§‹ à¦¨à¦¾!
        // à¦¸à§‡ à¦¶à§à¦§à§ à¦«à§à¦¯à¦¾à¦¸à¦¾à¦¡à§‡à¦° à¦à¦•à¦Ÿà¦¿ à¦®à§‡à¦¥à¦¡ à¦•à¦² à¦•à¦°à¦²à§‹
        homeTheater.watchMovie("Inception");
    }
}
