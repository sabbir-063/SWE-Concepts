# 01. Encryption & Hashing (Code & Implementations)

এই ফাইলে আমরা জাভাতে (Java) প্র্যাকটিক্যালি দেখবো কীভাবে AES দিয়ে Symmetric Encryption করতে হয় এবং কীভাবে Bcrypt দিয়ে পাসওয়ার্ড সেফলি Hash করতে হয়।

---

## 1. Hashing Passwords safely using Bcrypt

Bcrypt হলো পাসওয়ার্ড হ্যাশ করার জন্য বর্তমান সময়ের সবচেয়ে সিকিউর এবং পপুলার লাইব্রেরি। এর সবচেয়ে বড় সুবিধা হলো, এটি **নিজে থেকেই অটোমেটিক্যালি একটি ইউনিক Salt জেনারেট করে** এবং হ্যাশের ভেতরেই লুকিয়ে রাখে! তাই আপনাকে ম্যানুয়ালি Salt ম্যানেজ করতে হয় না।

*(নোট: জাভাতে এটি রান করতে হলে `jbcrypt` বা `spring-security-crypto` লাইব্রেরি ইম্পোর্ট করতে হবে)।*

```java
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashingExample {
    public static void main(String[] args) {
        
        String userPassword = "mySecretPassword123";

        // ১. Registration: পাসওয়ার্ড Hash করা
        // BCrypt.gensalt() অটোমেটিক্যালি একটি র‍্যান্ডম salt তৈরি করে দেবে
        String hashedPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt(12)); 
        
        System.out.println("Original Password: " + userPassword);
        System.out.println("Stored in Database (Hash): " + hashedPassword);

        // ২. Login: পাসওয়ার্ড ভেরিফাই করা
        // যখন ইউজার লগইন করতে আসবে, সে পাসওয়ার্ড টাইপ করবে
        String inputPassword = "mySecretPassword123";
        String wrongPassword = "wrongPassword123";

        // checkpw() মেথডটি ইনপুট পাসওয়ার্ড এবং ডাটাবেসের হ্যাশ মিলিয়ে দেখবে
        boolean isMatch = BCrypt.checkpw(inputPassword, hashedPassword);
        boolean isWrongMatch = BCrypt.checkpw(wrongPassword, hashedPassword);

        System.out.println("\nLogin with correct password: " + (isMatch ? "SUCCESS" : "FAILED"));
        System.out.println("Login with wrong password: " + (isWrongMatch ? "SUCCESS" : "FAILED"));
    }
}
```

**কেন Bcrypt এত সিকিউর?** 
Bcrypt ইচ্ছে করেই একটু স্লো (Slow) করে বানানো হয়েছে। এতে `gensalt(12)` এর `12` হলো 'Work Factor' বা রাউন্ড। এটি যত বাড়াবেন, হ্যাশ তৈরি হতে তত বেশি মিলিসেকেন্ড সময় লাগবে। এতে ইউজারের কোনো সমস্যা হবে না (লগইন হতে হয়তো ১০০ মি.সে বেশি লাগবে), কিন্তু হ্যাকার যখন স্ক্রিপ্ট দিয়ে সেকেন্ডে কোটি কোটি পাসওয়ার্ড গেস (Brute-force) করতে চাইবে, তখন এই সামান্য স্লোনেসের কারণেই তার বছরের পর বছর সময় লেগে যাবে!

---

## 2. Symmetric Encryption using AES

AES (Advanced Encryption Standard) হলো পৃথিবীর সবচেয়ে বেশি ব্যবহৃত এনক্রিপশন স্ট্যান্ডার্ড। এটি ব্যাংকিং বা ডেটা সেভ রাখার জন্য ইউজ করা হয়। এটি Two-way, অর্থাৎ একটি সিক্রেট চাবি (Key) দিয়ে লক করা হয় এবং সেই চাবি দিয়েই আবার আনলক করা হয়।

```java
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AESEncryptionExample {
    public static void main(String[] args) throws Exception {
        
        String plainText = "Hello Sabbir, this is a highly confidential message!";
        System.out.println("Original Text: " + plainText);

        // ১. একটি সিক্রেট চাবি (Secret Key) তৈরি করা
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // 256-bit AES (সবচেয়ে সিকিউর)
        SecretKey secretKey = keyGenerator.generateKey();

        // ২. Encryption (লক করা)
        Cipher encryptCipher = Cipher.getInstance("AES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey); // চাবি দিয়ে এনক্রিপ্ট মোড অন করলাম
        
        // টেক্সটকে বাইটে কনভার্ট করে এনক্রিপ্ট করলাম
        byte[] encryptedBytes = encryptCipher.doFinal(plainText.getBytes());
        // ডেটা যেন দেখতে সুন্দর (স্ট্রিং) হয়, তাই Base64 এনকোড করে নিলাম
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        
        System.out.println("\nEncrypted Text (Ciphertext): " + encryptedText);

        // ৩. Decryption (আনলক করা)
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey); // একই চাবি দিয়ে ডিক্রিপ্ট মোড অন করলাম
        
        // প্রথমে Base64 ডিকোড করে বাইট বানালাম, তারপর ডিক্রিপ্ট করলাম
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = decryptCipher.doFinal(decodedBytes);
        
        String decryptedText = new String(decryptedBytes);
        System.out.println("\nDecrypted Text: " + decryptedText);
    }
}
```

### 🔴 Encryption vs Encoding (কোডে প্রমাণ)
খেয়াল করে দেখুন, আমরা এনক্রিপ্ট করা হাবিজাবি বাইটগুলোকে (bytes) স্ট্রিং হিসেবে প্রিন্ট করার জন্য `Base64.getEncoder()` ব্যবহার করেছি। 
এখানে Base64 কোনো সিকিউরিটি দিচ্ছে না, সে শুধু বাইনারি ডেটাকে সুন্দর টেক্সট ফরম্যাটে (Encode) সাজিয়ে দিচ্ছে। আর আসল সিকিউরিটি বা ডেটা লক করার কাজটি করেছে `Cipher` (AES) ক্লাসটি তার Secret Key দিয়ে!
