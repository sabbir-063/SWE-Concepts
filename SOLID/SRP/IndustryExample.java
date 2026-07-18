package SOLID.SRP;

// 🏢 Industry Level Example: E-Commerce User Registration

// SRP violation (Bad):
// class UserService {
//     public void registerUser(String email, String password) {
//         // 1. Validate email and password (Validation Logic)
//         // 2. Hash password (Security Logic)
//         // 3. Save to database (Database Logic)
//         // 4. Send Welcome Email (Notification Logic)
//     }
// }

// ✅ SRP Followed (Good):

class User {
    String email;
    String hashedPassword;
    
    public User(String email, String hashedPassword) {
        this.email = email;
        this.hashedPassword = hashedPassword;
    }
}

// দায়িত্ব ১: Validation
class UserValidator {
    public boolean isValid(String email, String password) {
        return email != null && email.contains("@") && password.length() >= 6;
    }
}

// দায়িত্ব ২: Security (Hashing)
class PasswordHasher {
    public String hash(String password) {
        // In real world, use BCrypt or Argon2
        return "hashed_" + password + "_xyz";
    }
}

// দায়িত্ব ৩: Database
class UserRepository {
    public void save(User user) {
        System.out.println("💾 DB: User saved with email: " + user.email);
    }
}

// দায়িত্ব ৪: Notification
class EmailService {
    public void sendWelcomeEmail(String email) {
        System.out.println("✉️ EMAIL: Sending welcome email to: " + email);
    }
}

// দায়িত্ব ৫: Orchestration (সবগুলোকে মিলিয়ে কাজ করানো)
// এটাকে বলা হয় Facade বা Service Layer, এর কাজ শুধু অন্য ক্লাসগুলোকে কল করা।
class UserService {
    private UserValidator validator = new UserValidator();
    private PasswordHasher hasher = new PasswordHasher();
    private UserRepository repository = new UserRepository();
    private EmailService emailService = new EmailService();

    public void registerUser(String email, String password) {
        if (!validator.isValid(email, password)) {
            throw new IllegalArgumentException("Invalid email or password!");
        }

        String hashedPassword = hasher.hash(password);
        User newUser = new User(email, hashedPassword);
        
        repository.save(newUser);
        emailService.sendWelcomeEmail(email);
        
        System.out.println("✅ User registration successful!");
    }
}

public class IndustryExample {
    public static void main(String[] args) {
        UserService userService = new UserService();
        
        try {
            userService.registerUser("sabbir@example.com", "secret123");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
