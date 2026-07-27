# 02. Common Vulnerabilities (Code & Implementations)

এই ফাইলে আমরা জাভাতে (Java) প্র্যাকটিক্যালি দেখবো কীভাবে একটি **SQL Injection** অ্যাটাক কাজ করে এবং কীভাবে **PreparedStatement** ব্যবহার করে আমরা খুব সহজেই তা ঠেকিয়ে দিতে পারি।

---

## 1. The Vulnerable Code (How SQL Injection happens)

নিচের কোডটিতে আমরা ইউজারের কাছ থেকে `email` এবং `password` নিয়ে সরাসরি স্ট্রিং কনক্যাটেনেশন (String Concatenation `+`) করে SQL কোয়েরি বানাচ্ছি। এটিই হলো সবচেয়ে বড় ভুল!

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VulnerableLogin {
    public static void main(String[] args) {
        // হ্যাকার পাসওয়ার্ডের বক্সে এই ক্ষতিকর স্ট্রিংটি ইনপুট দিলো
        String userInputEmail = "admin@bank.com";
        String userInputPassword = "' OR '1'='1"; // হ্যাকারের ইনপুট

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "pass")) {
            
            Statement statement = conn.createStatement();
            
            // 🔴 VULNERABLE QUERY (স্ট্রিং জোড়া লাগানো হচ্ছে)
            String query = "SELECT * FROM users WHERE email = '" + userInputEmail + 
                           "' AND password = '" + userInputPassword + "'";
            
            System.out.println("Executing Query: " + query);
            /* 
             * কোয়েরিটি প্রিন্ট করলে দেখবেন এরকম হয়ে গেছে:
             * SELECT * FROM users WHERE email = 'admin@bank.com' AND password = '' OR '1'='1'
             * যেহেতু 1=1 সবসময়ই সত্য (True), তাই পাসওয়ার্ড ভুল হলেও কোয়েরি সাকসেসফুল হবে!
             */

            ResultSet rs = statement.executeQuery(query);
            
            if (rs.next()) {
                System.out.println("Login Success! Welcome Admin."); // হ্যাকার ঢুকে গেল!
            } else {
                System.out.println("Login Failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

## 2. The Secure Code (Preventing SQL Injection)

SQL Injection ঠেকানোর একমাত্র এবং সবচেয়ে বেস্ট উপায় হলো **`PreparedStatement`** ব্যবহার করা। 
এখানে আমরা কোয়েরিতে সরাসরি ইউজারের ডেটা বসাবো না, তার বদলে প্রশ্নবোধক চিহ্ন `?` (Placeholder) ব্যবহার করবো।

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SecureLogin {
    public static void main(String[] args) {
        
        String userInputEmail = "admin@bank.com";
        String userInputPassword = "' OR '1'='1"; // হ্যাকার আবার সেম ইনপুট দিলো

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "pass")) {
            
            // 🟢 SECURE QUERY (Placeholder '?' ব্যবহার করা হচ্ছে)
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            
            // Statement এর বদলে PreparedStatement ব্যবহার করতে হবে
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            // এরপর আমরা ভ্যালুগুলো সেট করে দেবো
            pstmt.setString(1, userInputEmail); // প্রথম '?' এর জায়গায় ইমেইল বসবে
            pstmt.setString(2, userInputPassword); // দ্বিতীয় '?' এর জায়গায় পাসওয়ার্ড বসবে

            /*
             * ম্যাজিকটা হলো: PreparedStatement ইউজারের ইনপুটকে কখনোই "আসল SQL কমান্ড" হিসেবে রান করে না। 
             * সে ইনপুটটিকে পিওর স্ট্রিং বা টেক্সট হিসেবে ধরে নেয়। 
             * ডাটাবেস তখন এমন একটি পাসওয়ার্ড খুঁজবে যার নাম হুবহু "' OR '1'='1" !
             * যেহেতু এমন কোনো পাসওয়ার্ড ডাটাবেসে নেই, তাই লগইন ফেইল করবে। হ্যাকিং আটকানো গেলো!
             */

            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Login Success! Welcome Admin.");
            } else {
                System.out.println("Login Failed. Nice try, Hacker!"); // লগইন ফেইল করবে
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 💡 XSS Prevention in Java (Bonus)
XSS ঠেকানোর জন্য ইউজারের ইনপুট করা টেক্সটকে (যেমন কমেন্ট) ডাটাবেসে সেভ করার আগে বা ব্রাউজারে দেখানোর আগে **HTML Escaping** করতে হয়। জাভাতে `OWASP Java Encoder` লাইব্রেরি ব্যবহার করে এটি খুব সহজেই করা যায়:

```java
// হ্যাকারের ইনপুট: <script>alert('Hacked!');</script>
String safeInput = Encode.forHtml(userInput); 
// আউটপুট হবে: &lt;script&gt;alert(&#39;Hacked!&#39;);&lt;/script&gt;
// ব্রাউজার এটিকে রান করবে না, শুধু টেক্সট হিসেবে স্ক্রিনে দেখাবে।
```
