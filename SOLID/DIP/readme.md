# Dependency Inversion Principle (DIP)

> **"High-level modules should not depend on low-level modules. Both should depend on abstractions. (e.g., interfaces)"**

## 📖 মূল কনসেপ্ট (The Concept)
DIP-এর মানে হলো— একটি গুরুত্বপূর্ণ ক্লাস (High-level) কখনোই সরাসরি অন্য কোনো সাধারণ ক্লাসের (Low-level) অবজেক্ট তৈরি করবে না। অর্থাৎ `new Database()` এরকম কোড ক্লাসের ভেতরে থাকা যাবে না! 

এর বদলে, তারা দুজনই একটি **Interface (Abstraction)** এর উপর নির্ভর করবে। আর মূল ক্লাসটি (High-level) বাইরে থেকে ওই ইন্টারফেসের একটি ইমপ্লিমেন্টেশন রিসিভ করবে। এই কনসেপ্টটিকেই বলা হয় **Dependency Injection (DI)**! 

**কেন এটা দরকার?**
ধরুন আপনার `UserService` (High-level) সরাসরি `MySQLDatabase` (Low-level) এর সাথে কানেক্টেড। এখন হঠাৎ করে কোম্পানি বললো MongoDB ব্যবহার করতে। তখন আপনাকে `UserService` ক্লাসের ভেতরে ঢুকে কোড চেঞ্জ করতে হবে। এটি SRP এবং OCP দুটোই ব্রেক করে। DIP ফলো করলে এই সমস্যাটি একদম জিরো হয়ে যায়!

---

## 📂 এই ফোল্ডারে যা যা আছে

### ১. `BadExample.java` ❌
এই ফাইলে `UserService` নিজেই `new MySQLDatabase()` করে অবজেক্ট তৈরি করেছে। একে বলা হয় Tight Coupling। ফলে ডাটাবেস পরিবর্তন করতে চাইলে `UserService` এডিট করা ছাড়া কোনো উপায় নেই।

### ২. `GoodExample.java` ✅
এখানে আমরা `Database` নামে একটি ইন্টারফেস বানিয়েছি। `UserService` আর `MySQLDatabase` কে সরাসরি চেনে না। সে শুধু `Database` ইন্টারফেস চেনে। আমরা বাইরে থেকে (Constructor এর মাধ্যমে) `UserService` কে কখনো `MySQLDatabase`, আবার কখনো `MongoDatabase` দিচ্ছি। `UserService` এ একটি লাইনও কোড চেঞ্জ করা লাগেনি!

### ৩. `IndustryExample.java` 🏢
এটি স্প্রিং বুট (Spring Boot) এর মতো ফ্রেমওয়ার্কে যেভাবে DI (Dependency Injection) কাজ করে তার একটি উদাহরণ।
`OrderProcessor` একটি নোটিফিকেশন পাঠাতে চায়। সে `NotificationService` ইন্টারফেস এর উপর ডিপেন্ড করে। আমরা রানটাইমে ডিসাইড করছি তাকে কি `EmailNotification` দেবো নাকি `SMSNotification` দেবো।

---

## 🚀 কিভাবে রান করবেন (How to Run)

এই কোডগুলো রান করতে আপনার প্রজেক্টের রুট ডিরেক্টরি (`SWE`) থেকে টার্মিনালে নিচের কমান্ডগুলো দিন:

### ১. BadExample রান করতে:
```bash
javac SOLID/DIP/BadExample.java
java SOLID.DIP.BadExample
```
**Expected Output:**
```
Saving [User: Sabbir] to MySQL Database.
```

### ২. GoodExample রান করতে:
```bash
javac SOLID/DIP/GoodExample.java
java SOLID.DIP.GoodExample
```
**Expected Output:**
```
Saving [User: Rahim] to MySQL Database 🐬
Saving [User: Karim] to MongoDB 🍃
```

### ৩. IndustryExample রান করতে:
```bash
javac SOLID/DIP/IndustryExample.java
java SOLID.DIP.IndustryExample
```
**Expected Output:**
```
📦 Processing order for item: MacBook Pro
✅ Order processed successfully!
✉️ Sending Email to sabbir@example.com: Your order for MacBook Pro is confirmed!
--------------------------------------------------
📦 Processing order for item: iPhone 15
✅ Order processed successfully!
📱 Sending SMS to +8801700000000: Your order for iPhone 15 is confirmed!
```

---

## ✅ DIP ফলো করার সুবিধা (Pros)
- **কোড লুজলি কাপলড (Loosely Coupled) হয়:** এক ক্লাস চেঞ্জ করলে অন্য ক্লাসে প্রভাব পড়ে না।
- **টেস্টিং করা খুব সহজ:** High-level ক্লাস টেস্ট করার সময় আসল ডাটাবেসের বদলে সহজেই Mock ডাটাবেস পাস করে দেওয়া যায়।
- **ফ্রেমওয়ার্ক ফ্রেন্ডলি:** আধুনিক সব ফ্রেমওয়ার্ক (Spring, Angular, .NET) এই পিন্সিপালের (Dependency Injection) উপর ভিত্তি করে তৈরি।

## ❌ কখন ব্যবহার করবেন না (Cons/When NOT to use)
- অনেক ছোট বা ওয়ান-টাইম স্ক্রিপ্টের জন্য এত ইন্টারফেস বানানো শুধু শুধু সময় নষ্ট।
- Dependency Injection ম্যানুয়ালি করতে গেলে অনেক Boilerplate কোড লিখতে হয় (অবশ্য স্প্রিং এর মত ফ্রেমওয়ার্কগুলো এটা অটোমেটিক করে দেয়)। 
