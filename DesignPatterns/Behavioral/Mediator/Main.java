package DesignPatterns.Behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

// ==========================================
// Component 1: Mediator Interface
// ==========================================
interface ChatMediator {
    void sendMessage(String message, User user); // à¦‡à¦‰à¦œà¦¾à¦° à¦®à§‡à¦¸à§‡à¦œ à¦ªà¦¾à¦ à¦¾à¦²à§‡ à¦®à¦¿à¦¡à¦¿à§Ÿà§‡à¦Ÿà¦° à¦¤à¦¾ à¦°à¦¿à¦¸à¦¿à¦­ à¦•à¦°à¦¬à§‡
    void addUser(User user);                     // à¦šà§à¦¯à¦¾à¦Ÿ à¦°à§à¦®à§‡ à¦‡à¦‰à¦œà¦¾à¦° à¦…à§à¦¯à¦¾à¦¡ à¦•à¦°à¦¾à¦° à¦œà¦¨à§à¦¯
}

// ==========================================
// Component 2: Concrete Mediator (à¦†à¦¸à¦² à¦šà§à¦¯à¦¾à¦Ÿ à¦°à§à¦®)
// ==========================================
class ChatRoomImpl implements ChatMediator {
    // à¦®à¦¿à¦¡à¦¿à§Ÿà§‡à¦Ÿà¦° à¦¸à¦¬à¦¾à¦° à¦–à¦¬à¦°à¦¾à¦–à¦¬à¦° à¦°à¦¾à¦–à§‡
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
        // à¦¯à§‡ à¦®à§‡à¦¸à§‡à¦œ à¦ªà¦¾à¦ à¦¿à§Ÿà§‡à¦›à§‡ à¦¤à¦¾à¦•à§‡ à¦›à¦¾à§œà¦¾ à¦¬à¦¾à¦•à¦¿ à¦¸à¦¬à¦¾à¦‡à¦•à§‡ à¦®à§‡à¦¸à§‡à¦œà¦Ÿà¦¿ à¦ªà§Œà¦à¦›à§‡ à¦¦à¦¿à¦¬à§‡ à¦®à¦¿à¦¡à¦¿à§Ÿà§‡à¦Ÿà¦°
        for (User u : users) {
            if (u != sender) {
                u.receiveMessage(message);
            }
        }
    }
}


// ==========================================
// Component 3: Colleagues (à¦¯à¦¾à¦¦à§‡à¦° à¦®à¦§à§à¦¯à§‡ à¦¯à§‹à¦—à¦¾à¦¯à§‹à¦— à¦¹à¦¬à§‡)
// ==========================================
abstract class User {
    protected ChatMediator mediator; // à¦‡à¦‰à¦œà¦¾à¦°à§‡à¦° à¦•à¦¾à¦›à§‡ à¦¶à§à¦§à§ à¦®à¦¿à¦¡à¦¿à§Ÿà§‡à¦Ÿà¦°à§‡à¦° à¦°à§‡à¦«à¦¾à¦°à§‡à¦¨à§à¦¸ à¦¥à¦¾à¦•à¦¬à§‡
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
        // à¦‡à¦‰à¦œà¦¾à¦° à¦¸à¦°à¦¾à¦¸à¦°à¦¿ à¦•à¦¾à¦‰à¦•à§‡ à¦¨à¦¾ à¦ªà¦¾à¦ à¦¿à§Ÿà§‡ à¦®à¦¿à¦¡à¦¿à§Ÿà§‡à¦Ÿà¦°à¦•à§‡ à¦®à§‡à¦¸à§‡à¦œà¦Ÿà¦¿ à¦¦à¦¿à§Ÿà§‡ à¦¦à¦¿à¦²à§‹!
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
        
        // à§§. à¦à¦•à¦Ÿà¦¿ à¦®à¦¿à¦¡à¦¿à§Ÿà§‡à¦Ÿà¦° (à¦šà§à¦¯à¦¾à¦Ÿ à¦°à§à¦®) à¦¬à¦¾à¦¨à¦¾à¦²à¦¾à¦®
        ChatMediator chatRoom = new ChatRoomImpl();

        // à§¨. à¦‡à¦‰à¦œà¦¾à¦°à¦¦à§‡à¦° à¦¤à§ˆà¦°à¦¿ à¦•à¦°à¦²à¦¾à¦® à¦à¦¬à¦‚ à¦¤à¦¾à¦¦à§‡à¦° à¦¹à¦¾à¦¤à§‡ à¦®à¦¿à¦¡à¦¿à§Ÿà§‡à¦Ÿà¦° à¦§à¦°à¦¿à§Ÿà§‡ à¦¦à¦¿à¦²à¦¾à¦®
        User user1 = new ChatUser(chatRoom, "Sabbir");
        User user2 = new ChatUser(chatRoom, "Musfique");
        User user3 = new ChatUser(chatRoom, "John");

        // à§©. à¦‡à¦‰à¦œà¦¾à¦°à¦¦à§‡à¦° à¦šà§à¦¯à¦¾à¦Ÿ à¦°à§à¦®à§‡ à¦¯à§à¦•à§à¦¤ à¦•à¦°à¦²à¦¾à¦®
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        // à§ª. à¦®à§à¦¯à¦¾à¦œà¦¿à¦•! à¦¸à¦¾à¦¬à§à¦¬à¦¿à¦° à¦®à§‡à¦¸à§‡à¦œ à¦ªà¦¾à¦ à¦¾à¦²à§‹, à¦•à¦¿à¦¨à§à¦¤à§ à¦¸à§‡ à¦œà¦¾à¦¨à§‡ à¦¨à¦¾ à¦œà¦¨ à¦¬à¦¾ à¦®à§à¦¶à¦«à¦¿à¦• à¦•à§‡!
        // à¦¸à§‡ à¦¶à§à¦§à§ à¦šà§à¦¯à¦¾à¦Ÿ à¦°à§à¦®à¦•à§‡ à¦®à§‡à¦¸à§‡à¦œ à¦¦à¦¿à¦²à§‹à¥¤ 
        user1.send("Hi Everyone! How are you?");
        
        /* à¦†à¦‰à¦Ÿà¦ªà§à¦Ÿ:
           Sabbir Sending Message: Hi Everyone! How are you?
           Musfique Received: Hi Everyone! How are you?
           John Received: Hi Everyone! How are you?
        */
    }
}
