# 03. Authentication vs Authorization (Code & Implementations)

এই ফাইলে আমরা জাভাতে (Java) প্র্যাকটিক্যালি দেখবো কীভাবে **Role-Based Access Control (RBAC)** ইমপ্লিমেন্ট করে Authorization হ্যান্ডেল করতে হয়। 
আমরা একটি ডামি সিস্টেম বানাবো, যেখানে User এবং Admin এর আলাদা আলাদা পাওয়ার থাকবে।

---

## Role-Based Access Control (RBAC) in Java

ধরা যাক, আমাদের একটি ওয়েবসাইট আছে যেখানে দুটি পেজ আছে: 
1. `/dashboard` (সবাই দেখতে পারে)
2. `/admin-settings` (শুধুমাত্র অ্যাডমিনরা দেখতে পারে)

```java
import java.util.Arrays;
import java.util.List;

public class RBACExample {

    // ১. Role (পদবি) গুলো ডিফাইন করা
    enum Role {
        USER,
        ADMIN
    }

    // ২. User ক্লাস তৈরি করা
    static class User {
        String username;
        Role role; // ইউজারের একটি রোল থাকবে

        public User(String username, Role role) {
            this.username = username;
            this.role = role;
        }
    }

    // ৩. Controller বা রাউটার, যা চেক করবে কার কোন পেজে যাওয়ার পারমিশন আছে
    static class SecurityController {

        // এই পেজটিতে USER এবং ADMIN দুজনই ঢুকতে পারবে
        public static void accessDashboard(User user) {
            System.out.print("[" + user.username + "] is trying to access /dashboard -> ");
            
            // Authorization Check (AuthZ)
            if (user.role == Role.USER || user.role == Role.ADMIN) {
                System.out.println("✅ Access Granted! (Status: 200 OK)");
            } else {
                System.out.println("❌ Access Denied! (Status: 403 Forbidden)");
            }
        }

        // এই পেজটিতে শুধুমাত্র ADMIN ঢুকতে পারবে
        public static void accessAdminSettings(User user) {
            System.out.print("[" + user.username + "] is trying to access /admin-settings -> ");
            
            // Authorization Check (AuthZ) - Only Admin
            if (user.role == Role.ADMIN) {
                System.out.println("✅ Access Granted! (Status: 200 OK)");
            } else {
                // ইউজার লগইন করা আছে (Authentication = true), কিন্তু পারমিশন নেই! তাই 403 Forbidden.
                System.out.println("❌ Access Denied! You are not an Admin. (Status: 403 Forbidden)");
            }
        }
    }

    public static void main(String[] args) {
        
        // কিছু ডামি ইউজার তৈরি করা (ধরে নিচ্ছি তারা সাকসেসফুলি পাসওয়ার্ড দিয়ে লগইন করেছে)
        User normalUser = new User("Sabbir", Role.USER);
        User adminUser = new User("SuperBoss", Role.ADMIN);

        System.out.println("--- Testing /dashboard access ---");
        SecurityController.accessDashboard(normalUser);
        SecurityController.accessDashboard(adminUser);

        System.out.println("\n--- Testing /admin-settings access ---");
        // সাধারণ ইউজার অ্যাডমিন পেজে যাওয়ার চেষ্টা করছে...
        SecurityController.accessAdminSettings(normalUser); 
        
        // অ্যাডমিন নিজে অ্যাডমিন পেজে যাওয়ার চেষ্টা করছে...
        SecurityController.accessAdminSettings(adminUser); 
    }
}
```

### 🔴 Output Explanation
```text
--- Testing /dashboard access ---
[Sabbir] is trying to access /dashboard -> ✅ Access Granted! (Status: 200 OK)
[SuperBoss] is trying to access /dashboard -> ✅ Access Granted! (Status: 200 OK)

--- Testing /admin-settings access ---
[Sabbir] is trying to access /admin-settings -> ❌ Access Denied! You are not an Admin. (Status: 403 Forbidden)
[SuperBoss] is trying to access /admin-settings -> ✅ Access Granted! (Status: 200 OK)
```

**কী ঘটলো এখানে?**
- `Sabbir` যখন `/admin-settings` এ যাওয়ার চেষ্টা করলো, তখন সিস্টেম জানতো সে কে (Authentication Done)।
- কিন্তু সিস্টেম যখন তার রোল চেক করলো (Authorization), দেখলো সে একজন সাধারণ `USER`। 
- তাই সিস্টেম তাকে ঢুকতে দিলো না এবং একটি **403 Forbidden** এরর থ্রো করলো। 
- বাস্তবে Spring Security বা Express.js (Node) এ এই কাজটি মিডলওয়্যার (Middleware) দিয়ে করা হয়, যাতে প্রতিটি রাউটের ভেতর বারবার `if-else` লিখতে না হয়!
