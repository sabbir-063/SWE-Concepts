package DesignPatterns.Behavioral.Iterator;

// ==========================================
// Component 1: Iterator Interface (কমন রুলস)
// ==========================================
interface MyIterator {
    boolean hasNext(); // পরের কোনো আইটেম বাকি আছে কি না?
    String next();     // পরের আইটেমটা দাও
}

// ==========================================
// Component 3: IterableCollection Interface
// ==========================================
interface SongCollection {
    MyIterator createIterator(); // কালেকশনকে অবশ্যই একটি ইটারেটর দিতে হবে
}


// ==========================================
// Component 4: Concrete Collection (আসল ডাটা হোল্ডার)
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

    // কালেকশনটি তার নিজের জন্য একটি স্পেশাল ইটারেটর বানিয়ে রিটার্ন করবে
    @Override
    public MyIterator createIterator() {
        return new PlaylistIterator(this.songs);
    }
}


// ==========================================
// Component 2: Concrete Iterator (আসল লুপ চালানোর লজিক)
// ==========================================
class PlaylistIterator implements MyIterator {
    private String[] songs;
    private int currentPosition = 0; // কারেন্ট পজিশন ট্র্যাক রাখার জন্য পয়েন্টার

    public PlaylistIterator(String[] songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        // যদি পয়েন্টারটি অ্যারের লেংথ বা নাল (null) ভ্যালুর চেয়ে ছোট থাকে
        return currentPosition < songs.length && songs[currentPosition] != null;
    }

    @Override
    public String next() {
        // বর্তমান পজিশনের গানটি রিটার্ন করে পয়েন্টার এক ধাপ বাড়িয়ে দিলো
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
        
        // ১. একটি প্লে-লিস্ট বানালাম এবং গান রাখলাম
        Playlist myPlaylist = new Playlist(3);
        myPlaylist.addSong("Song 1: Believer");
        myPlaylist.addSong("Song 2: Shape of You");
        myPlaylist.addSong("Song 3: Faded");

        // ২. ক্লায়েন্ট প্লে-লিস্টের ইন্টারনাল স্ট্রাকচার (Array) জানে না। 
        // সে শুধু ইটারেটর চাইলো।
        MyIterator iterator = myPlaylist.createIterator();

        // ৩. ইউনিভার্সাল স্টাইলে লুপ চালানো
        System.out.println("--- Playing My Playlist ---");
        
        while (iterator.hasNext()) {
            String song = iterator.next();
            System.out.println("Playing 🎵: " + song);
        }
        
        System.out.println("--- Playlist Ended ---");
    }
}
