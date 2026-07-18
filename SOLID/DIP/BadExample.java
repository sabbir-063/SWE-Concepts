package SOLID.DIP;

// ❌ Bad Example: Dependency Inversion Principle (DIP) ভায়োলেট করছে
// DIP এর মূল কথা হলো: High-level module কখনো Low-level module এর উপর সরাসরি নির্ভর করবে না। 
// উভয়েই Abstraction (Interface) এর উপর নির্ভর করবে।

public class BadExample {

    // Low-level module (Database connection)
    static class MySQLDatabase {
        public void save(String data) {
            System.out.println("Saving [" + data + "] to MySQL Database.");
        }
    }

    // High-level module (Business Logic)
    static class UserService {
        // ❌ DIP Violation: UserService সরাসরি MySQLDatabase এর উপর নির্ভরশীল!
        // যদি কালকে আমরা MongoDB ব্যবহার করতে চাই, তবে এই পুরো ক্লাসটি এডিট করতে হবে।
        private MySQLDatabase database;

        public UserService() {
            this.database = new MySQLDatabase(); // Tight coupling
        }

        public void registerUser(String username) {
            // Business logic...
            database.save("User: " + username);
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.registerUser("Sabbir");
    }
}
