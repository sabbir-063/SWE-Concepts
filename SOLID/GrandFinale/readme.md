# The Grand Finale: Mini-Project

এই মডিউলে আমরা ৫টি SOLID প্রিন্সিপাল একসাথে এপ্লাই করে একটি লেগাসি (Legacy) বা জগাখিচুড়ি অ্যাপকে ক্লিন কোডে রূপান্তর করেছি।

## 📂 এই ফোল্ডারে যা যা আছে

### ১. `BadECommerceApp.java` ❌
এই ফাইলে একটি `OrderProcessor` ক্লাস বানানো হয়েছে, যেখানে একসাথে ৫টি SOLID প্রিন্সিপালই ব্রেক করা হয়েছে:
- **SRP Violation:** পেমেন্ট, ডাটাবেস, শিপিং, ইমেইল— সব কাজ এক ক্লাসের ভেতর। 
- **OCP Violation:** নতুন পেমেন্ট মেথড আসলে `if-else` ব্লক মডিফাই করতে হবে।
- **LSP Violation:** `Software` ক্লাসের `shipProduct()` কল করলে সিস্টেম ক্র্যাশ করছে (কারণ সফটওয়্যার কুরিয়ারে পাঠানো যায় না)।
- **ISP Violation:** `IProduct` একটি বিশাল ইন্টারফেস, যেখানে `ship()` এবং `download()` দুটোই আছে।
- **DIP Violation:** `OrderProcessor` নিজেই সরাসরি `new MySQLDatabase()` তৈরি করছে।

### ২. `GoodECommerceApp.java` ✅
এখানে আমরা একে একে সব প্রবলেম সলভ করেছি:
- **(ISP & LSP):** `IProduct` কে ভেঙে ছোট ছোট `Shippable` এবং `Downloadable` ইন্টারফেস বানিয়েছি। এতে কোনো ক্লাসে ফেইক মেথড (throw exception) থাকলো না, ফলে সিস্টেম ক্র্যাশের চান্স ০% হয়ে গেলো!
- **(OCP):** `PaymentMethod` ইন্টারফেস বানিয়ে পেমেন্ট লজিক আলাদা করে ফেলেছি। এখন আর `if-else` নেই। 
- **(DIP):** `Database` এবং `NotificationService` ইন্টারফেস বানিয়েছি। 
- **(SRP):** প্রতিটি ক্লাস শুধু তার নিজের কাজ করছে। `OrderProcessor` এখন শুধু অর্কেস্ট্রেশনের কাজ (সবাইকে ডেকে ডেকে কাজ করানো) করছে, নিজে থেকে কোনো কাজ করছে না। 

---

## 🚀 কিভাবে রান করবেন (How to Run)

এই কোডগুলো রান করতে আপনার প্রজেক্টের রুট ডিরেক্টরি (`SWE`) থেকে টার্মিনালে নিচের কমান্ডগুলো দিন:

### ১. Bad Example রান করতে:
```bash
javac SOLID/GrandFinale/BadECommerceApp.java
java SOLID.GrandFinale.BadECommerceApp
```
**Expected Output:**
```
--- Processing Order for: T-Shirt ---
Paid BDT 500.0 using bKash.
Saving to MySQL DB: T-Shirt paid via BKASH
Shipping T-Shirt via Pathao.
Email sent: Your order for T-Shirt is confirmed!

--- Processing Order for: Antivirus ---
Paid BDT 1200.0 using Credit Card.
Saving to MySQL DB: Antivirus paid via CARD
Shipping Error: Cannot ship Software via courier!
Email sent: Your order for Antivirus is confirmed!
```

### ২. Good Example রান করতে (The Clean Code):
```bash
javac SOLID/GrandFinale/GoodECommerceApp.java
java SOLID.GrandFinale.GoodECommerceApp
```
**Expected Output:**
```
--- Processing Order for: T-Shirt ---
💳 Paid BDT 500.0 using bKash.
💾 Saving to MySQL DB: Order placed for T-Shirt
📦 Shipping T-Shirt via Pathao.
✉️ Email sent: Your order for T-Shirt is confirmed!

--- Processing Order for: Antivirus ---
💳 Paid BDT 1200.0 using Credit Card.
💾 Saving to MySQL DB: Order placed for Antivirus
⬇️ Downloading Antivirus software...
✉️ Email sent: Your order for Antivirus is confirmed!
```
