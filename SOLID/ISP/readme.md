# Interface Segregation Principle (ISP)

> **"Clients should not be forced to depend on methods they do not use."**

## 📖 মূল কনসেপ্ট (The Concept)
ISP-এর মানে হলো— একটি বিশাল বা "Fat" ইন্টারফেস বানানোর চেয়ে ছোট ছোট এবং স্পেসিফিক (Specific) ইন্টারফেস বানানো ভালো। 
যখন আমরা একটি ইন্টারফেসের ভেতর অনেকগুলো মেথড দিয়ে দিই, তখন ওই ইন্টারফেসটি যে ক্লাসই ইমপ্লিমেন্ট করবে, তাকে বাধ্য হয়ে সবগুলো মেথড ইমপ্লিমেন্ট করতে হবে (এমনকি তার ওই মেথডগুলোর দরকার না থাকলেও!)।

**উদাহরণ:**
আপনার একটি `MultiFunctionPrinter` ইন্টারফেস আছে, যেখানে `print()`, `scan()`, এবং `fax()` আছে। 
এখন আপনার কাছে এমন একটি সস্তা প্রিন্টার আসলো, যেটা শুধু প্রিন্ট করতে পারে। কিন্তু ওই ইন্টারফেস ইমপ্লিমেন্ট করতে গেলে তাকে জোর করে `scan()` এবং `fax()` মেথডও নিজের ক্লাসে রাখতে হবে এবং সেখানে `Exception` থ্রো করতে হবে। এটি একটি ব্যাড প্র্যাকটিস (ISP Violation)!

---

## 📂 এই ফোল্ডারে যা যা আছে

### ১. `BadExample.java` ❌
এই ফাইলে `BasicPrinter` কে জোর করে `scan()` এবং `fax()` মেথড ইমপ্লিমেন্ট করানো হয়েছে, যা সে করতে পারে না। ফলে সেগুলোতে কল পড়লেই সিস্টেম ক্র্যাশ করবে।

### ২. `GoodExample.java` ✅
এখানে আমরা বিশাল ইন্টারফেসটিকে ভেঙে ৩টি ছোট ইন্টারফেসে (`Printer`, `Scanner`, `Fax`) ভাগ করেছি। যার যেটা দরকার, সে শুধু সেটাই ইমপ্লিমেন্ট করবে। `BasicPrinter` শুধু `Printer` নিলো, ফলে তার ভেতরে অপ্রয়োজনীয় কোনো মেথড থাকলো না!

### ৩. `IndustryExample.java` 🏢
ক্লাউড স্টোরেজ প্রোভাইডারদের একটি রিয়েল ওয়ার্ল্ড উদাহরণ।
সব ক্লাউড সার্ভার পাবলিক লিংক শেয়ারিং ফিচার দেয় না (যেমন: সিকিউরড কোম্পানি সার্ভার)। তাই আমরা `CloudStorage` এবং `SharableStorage` নামে দুটি আলাদা ইন্টারফেস করেছি। `GoogleDrive` দুটোই নিলো, কিন্তু `SecureCompanyServer` শুধু `CloudStorage` নিলো। 

---

## 🚀 কিভাবে রান করবেন (How to Run)

এই কোডগুলো রান করতে আপনার প্রজেক্টের রুট ডিরেক্টরি (`SWE`) থেকে টার্মিনালে নিচের কমান্ডগুলো দিন:

### ১. BadExample রান করতে:
```bash
javac SOLID/ISP/BadExample.java
java SOLID.ISP.BadExample
```
**Expected Output:**
```
Advanced Printer is printing...
Advanced Printer is scanning...
Basic Printer is printing...
Error: Basic Printer cannot scan!
```

### ২. GoodExample রান করতে:
```bash
javac SOLID/ISP/GoodExample.java
java SOLID.ISP.GoodExample
```
**Expected Output:**
```
Advanced Printer is printing... 🖨️
Advanced Printer is scanning... 📄
Advanced Printer is sending a fax... 📠
-----------------
Basic Printer is printing... 🖨️
```

### ৩. IndustryExample রান করতে:
```bash
javac SOLID/ISP/IndustryExample.java
java SOLID.ISP.IndustryExample
```
**Expected Output:**
```
Uploading photo.png to Google Drive ☁️
Link: https://drive.google.com/open?id=photo.png
-----------------
Uploading secret-document.pdf securely to Company Server 🔒
```

---

## ✅ ISP ফলো করার সুবিধা (Pros)
- **কোড ক্লিন থাকে:** ক্লাসগুলোতে কোনো অদরকারি বা ফেইক মেথড (যেমন: `throw new Exception()`) থাকে না।
- **নির্ভরশীলতা (Coupling) কমে:** একটি ক্লাসের শুধু যতটুকু দরকার, সে ঠিক ততটুকুর সাথেই কানেক্টেড থাকে।
- **মেইনটেইন করা সহজ:** বড় ইন্টারফেস চেঞ্জ করলে তার সাথে যুক্ত সব ক্লাস ভেঙে যেতে পারে, কিন্তু ছোট ইন্টারফেসে সেই ভয় থাকে না।

## ❌ কখন ব্যবহার করবেন না (Cons/When NOT to use)
- যদি ইন্টারফেসটি প্রাকৃতিকভাবেই একটি সম্পূর্ণ জিনিসকে রিপ্রেজেন্ট করে এবং একে ভাঙলে লজিক নষ্ট হয়ে যায়, তবে অযথা ভাঙার দরকার নেই। অনেক বেশি ছোট ছোট ইন্টারফেস বানালে আবার কোড খুঁজে পাওয়া কঠিন হতে পারে।
