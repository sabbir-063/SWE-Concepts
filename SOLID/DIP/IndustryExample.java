package SOLID.DIP;

// 🏢 Industry Level Example: Order Processing & Notification System (Spring Boot Style)
// রিয়েল ওয়ার্ল্ডে Dependency Injection (DI) ফ্রেমওয়ার্কগুলো (যেমন: Spring) এভাবেই কাজ করে।

// ১. Abstraction
interface NotificationService {
    void sendMessage(String message, String receiver);
}

// ২. Concrete Implementation 1: Email
class EmailNotification implements NotificationService {
    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println("✉️ Sending Email to " + receiver + ": " + message);
    }
}

// ৩. Concrete Implementation 2: SMS
class SMSNotification implements NotificationService {
    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println("📱 Sending SMS to " + receiver + ": " + message);
    }
}

// ৪. High-level module: OrderProcessor
// এই ক্লাসটি ইমেইল নাকি এসএমএস পাঠানো হবে তা নিয়ে চিন্তা করে না। 
// সে শুধু জানে যে তাকে একটি NotificationService দেওয়া হবে, আর সে `sendMessage` কল করবে।
class OrderProcessor {
    private final NotificationService notificationService;

    // Constructor Injection (Best Practice for DIP)
    public OrderProcessor(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void processOrder(String item, String customer) {
        System.out.println("📦 Processing order for item: " + item);
        // অনেক লজিক থাকতে পারে...
        System.out.println("✅ Order processed successfully!");
        
        // ডাইনামিক নোটিফিকেশন পাঠানো
        notificationService.sendMessage("Your order for " + item + " is confirmed!", customer);
    }
}

public class IndustryExample {
    public static void main(String[] args) {
        // App Configuration (বা Spring Framework এর কাজ):
        // ধরুন কাস্টমার ইমেইল প্রেফার করে:
        NotificationService emailService = new EmailNotification();
        OrderProcessor processorForEmail = new OrderProcessor(emailService);
        processorForEmail.processOrder("MacBook Pro", "sabbir@example.com");

        System.out.println("--------------------------------------------------");

        // ধরুন কাস্টমার এসএমএস প্রেফার করে:
        NotificationService smsService = new SMSNotification();
        OrderProcessor processorForSms = new OrderProcessor(smsService);
        processorForSms.processOrder("iPhone 15", "+8801700000000");
    }
}
