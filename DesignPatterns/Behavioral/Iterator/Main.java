package DesignPatterns.Behavioral.Iterator;

// ==========================================
// Component 1: Iterator Interface (à¦•à¦®à¦¨ à¦°à§à¦²à¦¸)
// ==========================================
interface MyIterator {
    boolean hasNext(); // à¦ªà¦°à§‡à¦° à¦•à§‹à¦¨à§‹ à¦†à¦‡à¦Ÿà§‡à¦® à¦¬à¦¾à¦•à¦¿ à¦†à¦›à§‡ à¦•à¦¿ à¦¨à¦¾?
    String next();     // à¦ªà¦°à§‡à¦° à¦†à¦‡à¦Ÿà§‡à¦®à¦Ÿà¦¾ à¦¦à¦¾à¦“
}

// ==========================================
// Component 3: IterableCollection Interface
// ==========================================
interface SongCollection {
    MyIterator createIterator(); // à¦•à¦¾à¦²à§‡à¦•à¦¶à¦¨à¦•à§‡ à¦…à¦¬à¦¶à§à¦¯à¦‡ à¦à¦•à¦Ÿà¦¿ à¦‡à¦Ÿà¦¾à¦°à§‡à¦Ÿà¦° à¦¦à¦¿à¦¤à§‡ à¦¹à¦¬à§‡
}


// ==========================================
// Component 4: Concrete Collection (à¦†à¦¸à¦² à¦¡à¦¾à¦Ÿà¦¾ à¦¹à§‹à¦²à§à¦¡à¦¾à¦°)
// ==========================================
class Playlist implements SongCollection {
    private String[] songs;
    private int count = 0;

    public Playlist(int size) {
        songs = new String[size];
    }

    public void addSong(String songName) {
        if (count < songs.length) {
            songs[count] = songName;
            count++;
        }
    }

    // à¦•à¦¾à¦²à§‡à¦•à¦¶à¦¨à¦Ÿà¦¿ à¦¤à¦¾à¦° à¦¨à¦¿à¦œà§‡à¦° à¦œà¦¨à§à¦¯ à¦à¦•à¦Ÿà¦¿ à¦¸à§à¦ªà§‡à¦¶à¦¾à¦² à¦‡à¦Ÿà¦¾à¦°à§‡à¦Ÿà¦° à¦¬à¦¾à¦¨à¦¿à§Ÿà§‡ à¦°à¦¿à¦Ÿà¦¾à¦°à§à¦¨ à¦•à¦°à¦¬à§‡
    @Override
    public MyIterator createIterator() {
        return new PlaylistIterator(this.songs);
    }
}


// ==========================================
// Component 2: Concrete Iterator (à¦†à¦¸à¦² à¦²à§à¦ª à¦šà¦¾à¦²à¦¾à¦¨à§‹à¦° à¦²à¦œà¦¿à¦•)
// ==========================================
class PlaylistIterator implements MyIterator {
    private String[] songs;
    private int currentPosition = 0; // à¦•à¦¾à¦°à§‡à¦¨à§à¦Ÿ à¦ªà¦œà¦¿à¦¶à¦¨ à¦Ÿà§à¦°à§à¦¯à¦¾à¦• à¦°à¦¾à¦–à¦¾à¦° à¦œà¦¨à§à¦¯ à¦ªà§Ÿà§‡à¦¨à§à¦Ÿà¦¾à¦°

    public PlaylistIterator(String[] songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        // à¦¯à¦¦à¦¿ à¦ªà§Ÿà§‡à¦¨à§à¦Ÿà¦¾à¦°à¦Ÿà¦¿ à¦…à§à¦¯à¦¾à¦°à§‡à¦° à¦²à§‡à¦‚à¦¥ à¦¬à¦¾ à¦¨à¦¾à¦² (null) à¦­à§à¦¯à¦¾à¦²à§à¦° à¦šà§‡à§Ÿà§‡ à¦›à§‹à¦Ÿ à¦¥à¦¾à¦•à§‡
        return currentPosition < songs.length && songs[currentPosition] != null;
    }

    @Override
    public String next() {
        // à¦¬à¦°à§à¦¤à¦®à¦¾à¦¨ à¦ªà¦œà¦¿à¦¶à¦¨à§‡à¦° à¦—à¦¾à¦¨à¦Ÿà¦¿ à¦°à¦¿à¦Ÿà¦¾à¦°à§à¦¨ à¦•à¦°à§‡ à¦ªà§Ÿà§‡à¦¨à§à¦Ÿà¦¾à¦° à¦à¦• à¦§à¦¾à¦ª à¦¬à¦¾à§œà¦¿à§Ÿà§‡ à¦¦à¦¿à¦²à§‹
        String song = songs[currentPosition];
        currentPosition++;
        return song;
    }
}


// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // à§§. à¦à¦•à¦Ÿà¦¿ à¦ªà§à¦²à§‡-à¦²à¦¿à¦¸à§à¦Ÿ à¦¬à¦¾à¦¨à¦¾à¦²à¦¾à¦® à¦à¦¬à¦‚ à¦—à¦¾à¦¨ à¦°à¦¾à¦–à¦²à¦¾à¦®
        Playlist myPlaylist = new Playlist(3);
        myPlaylist.addSong("Song 1: Believer");
        myPlaylist.addSong("Song 2: Shape of You");
        myPlaylist.addSong("Song 3: Faded");

        // à§¨. à¦•à§à¦²à¦¾à§Ÿà§‡à¦¨à§à¦Ÿ à¦ªà§à¦²à§‡-à¦²à¦¿à¦¸à§à¦Ÿà§‡à¦° à¦‡à¦¨à§à¦Ÿà¦¾à¦°à¦¨à¦¾à¦² à¦¸à§à¦Ÿà§à¦°à¦¾à¦•à¦šà¦¾à¦° (Array) à¦œà¦¾à¦¨à§‡ à¦¨à¦¾à¥¤ 
        // à¦¸à§‡ à¦¶à§à¦§à§ à¦‡à¦Ÿà¦¾à¦°à§‡à¦Ÿà¦° à¦šà¦¾à¦‡à¦²à§‹à¥¤
        MyIterator iterator = myPlaylist.createIterator();

        // à§©. à¦‡à¦‰à¦¨à¦¿à¦­à¦¾à¦°à§à¦¸à¦¾à¦² à¦¸à§à¦Ÿà¦¾à¦‡à¦²à§‡ à¦²à§à¦ª à¦šà¦¾à¦²à¦¾à¦¨à§‹
        System.out.println("--- Playing My Playlist ---");
        
        while (iterator.hasNext()) {
            String song = iterator.next();
            System.out.println("Playing ðŸŽµ: " + song);
        }
        
        System.out.println("--- Playlist Ended ---");
    }
}
