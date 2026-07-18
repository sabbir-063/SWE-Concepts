package DesignPatterns.Behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

// ==========================================
// Component 1: Mediator Interface
// ==========================================
interface ChatMediator {
    void sendMessage(String message, User user); // ইউজার মেসেজ পাঠালে মিডিয়েটর তা রিসিভ করবে
    void addUser(User user);                     // চ্যাট রুমে ইউজার অ্যাড করার জন্য
}

// ==========================================
// Component 2: Concrete Mediator (আসল চ্যাট রুম)
// ==========================================
class ChatRoomImpl implements ChatMediator {
    // মিডিয়েটর সবার খবরাখবর রাখে
    private List<User> users;

    public ChatRoomImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        // যে মেসেজ পাঠিয়েছে তাকে ছাড়া বাকি সবাইকে মেসেজটি পৌঁছে দিবে মিডিয়েটর
        for (User u : users) {
            if (u != sender) {
                u.receiveMessage(message);
            }
        }
    }
}


// ==========================================
// Component 3: Colleagues (যাদের মধ্যে যোগাযোগ হবে)
// ==========================================
abstract class User {
    protected ChatMediator mediator; // ইউজারের কাছে শুধু মিডিয়েটরের রেফারেন্স থাকবে
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receiveMessage(String message);
}

class ChatUser extends User {
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " Sending Message: " + message);
        // ইউজার সরাসরি কাউকে না পাঠিয়ে মিডিয়েটরকে মেসেজটি দিয়ে দিলো!
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(this.name + " Received: " + message);
    }
}


// ==========================================
// Client Code (Main Method)
// ==========================================
public class Main {
    public static void main(String[] args) {
        
        // ১. একটি মিডিয়েটর (চ্যাট রুম) বানালাম
        ChatMediator chatRoom = new ChatRoomImpl();

        // ২. ইউজারদের তৈরি করলাম এবং তাদের হাতে মিডিয়েটর ধরিয়ে দিলাম
        User user1 = new ChatUser(chatRoom, "Sabbir");
        User user2 = new ChatUser(chatRoom, "Musfique");
        User user3 = new ChatUser(chatRoom, "John");

        // ৩. ইউজারদের চ্যাট রুমে যুক্ত করলাম
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        // ৪. ম্যাজিক! সাব্বির মেসেজ পাঠালো, কিন্তু সে জানে না জন বা মুশফিক কে!
        // সে শুধু চ্যাট রুমকে মেসেজ দিলো। 
        user1.send("Hi Everyone! How are you?");
        
        /* আউটপুট:
           Sabbir Sending Message: Hi Everyone! How are you?
           Musfique Received: Hi Everyone! How are you?
           John Received: Hi Everyone! How are you?
        */
    }
}
