# Single Responsibility Principle (SRP)

> **"A class should have one, and only one, reason to change."**

## 📖 মূল কনসেপ্ট (The Concept)
SRP-এর মানে হলো— একটি ক্লাসের বা মেথডের মাত্র **একটি সুনির্দিষ্ট দায়িত্ব** (Responsibility) থাকা উচিত। 
যখন আমরা একটি ক্লাসের ভেতর অনেকগুলো সম্পূর্ণ আলাদা কাজ দিয়ে দিই (যেমন: ডাটাবেস সেভ করা, UI তে দেখানো, ক্যালকুলেশন করা), তখন সেটাকে বলা হয় **"God Class"**। 

God Class মেইনটেইন করা খুব কঠিন। কারণ এক জায়গার কোড পরিবর্তন করলে আরেক জায়গায় বাগ (bug) দেখা দিতে পারে।

**উদাহরণ:**
আপনার একটি `Employee` ক্লাস আছে। 
- যদি `Employee`-এর ট্যাক্স ক্যালকুলেশন রুল পরিবর্তন হয়, তাহলে ক্লাসটি এডিট করতে হবে।
- যদি ডাটাবেস MySQL থেকে MongoDB হয়, তাহলেও ক্লাসটি এডিট করতে হবে।
- যদি রিপোর্টের ফরম্যাট PDF থেকে HTML হয়, তাহলেও ক্লাসটি এডিট করতে হবে।

এই ক্লাসের **চেঞ্জ হওয়ার ৩টি রিজন (Reason to change)** তৈরি হলো। SRP অনুযায়ী, এর চেঞ্জ হওয়ার রিজন মাত্র ১টি হওয়া উচিত।

---

## 📂 এই ফোল্ডারে যা যা আছে

### ১. `BadExample.java` ❌
এই ফাইলে দেখানো হয়েছে SRP কিভাবে ব্রেক হয়। একটি ক্লাসের মধ্যেই Business Logic, Database Logic এবং Presentation Logic একসাথে রাখা হয়েছে।

### ২. `GoodExample.java` ✅
এখানে `BadExample` কে রিফ্যাক্টর করে ৩টি আলাদা ক্লাসে ভাগ করা হয়েছে:
- `Employee`: শুধু ইউজারের বেসিক ডাটা ধরে রাখবে।
- `EmployeeRepository`: শুধু ডাটাবেসে সেভ করার কাজ করবে।
- `EmployeeReportFormatter`: শুধু রিপোর্ট তৈরি বা প্রিন্ট করার কাজ করবে।

এখন ডাটাবেস পরিবর্তন হলে শুধু Repository ক্লাস চেঞ্জ হবে, অন্য ক্লাসে কোনো প্রভাব পড়বে না!

### ৩. `IndustryExample.java` 🏢
একটি প্রোডাকশন-লেভেলের ই-কমার্স অ্যাপে কিভাবে SRP মেইনটেইন করে User Registration করানো হয়, তার উদাহরণ এটি।
এখানে ৫টি আলাদা ক্লাস তৈরি করে দায়িত্ব ভাগ করা হয়েছে:
1. `UserValidator`: ইমেইল ও পাসওয়ার্ড ঠিক আছে কি না চেক করে।
2. `PasswordHasher`: পাসওয়ার্ড হ্যাশ করে সিকিউরিটি দেয়।
3. `UserRepository`: ডাটাবেসে সেভ করে।
4. `EmailService`: ওয়েলকাম ইমেইল পাঠায়।
5. `UserService` (Facade): এই সবগুলোকে একসাথে কল করে একটা রেজিস্ট্রেশন ফ্লো তৈরি করে।

---

## ✅ SRP ফলো করার সুবিধা (Pros)
- **টেস্টিং সহজ হয়:** ছোট ক্লাসগুলো সহজেই Unit Test করা যায়।
- **কোড বোঝা সহজ হয়:** ২০০ লাইনের ক্লাসের চেয়ে ৫০ লাইনের ৪টি ক্লাস পড়ে বোঝা অনেক সহজ।
- **বাগ (Bug) কমে যায়:** এক জায়গার পরিবর্তনে পুরো অ্যাপ ক্র্যাশ করে না।
- **রিইউজেবল (Reusable):** একটি ক্লাস একটি মাত্র কাজ করলে, অন্য কোথাও সেই কাজ লাগলে ক্লাসটি সরাসরি ব্যবহার করা যায়।

## ❌ কখন ব্যবহার করবেন না (Cons/When NOT to use)
- ছোট প্রজেক্টে বা একদম বেসিক স্ক্রিপ্টে অতিরিক্ত ছোট ছোট ক্লাস বানালে কোডের কমপ্লেক্সিটি (Over-engineering) বেড়ে যেতে পারে। তখন একটি ক্লাসেই ২-৩ টি কাজ রাখা যেতে পারে। 

---

## 🚀 কিভাবে রান করবেন (How to Run)

এই কোডগুলো রান করতে আপনার প্রজেক্টের রুট ডিরেক্টরি (`SWE`) থেকে টার্মিনালে নিচের কমান্ডগুলো দিন:

### ১. BadExample রান করতে:
```bash
javac SOLID/SRP/BadExample.java
java SOLID.SRP.BadExample
```
**Expected Output:**
```
Employee Report: Name = Rahim, Salary = 50000.0
Rahim has been saved to the database.
```

### ২. GoodExample রান করতে:
```bash
javac SOLID/SRP/GoodExample.java
java SOLID.SRP.GoodExample
```
**Expected Output:**
```
Employee Report: Name = Karim, Salary = 60000.0
<div><h1>Karim</h1><p>Salary: 60000.0</p></div>
Karim has been successfully saved to the database.
```

### ৩. IndustryExample রান করতে:
```bash
javac SOLID/SRP/IndustryExample.java
java SOLID.SRP.IndustryExample
```
**Expected Output:**
```
💾 DB: User saved with email: sabbir@example.com
✉️ EMAIL: Sending welcome email to: sabbir@example.com
✅ User registration successful!
```
*(বিঃদ্রঃ আপনার টার্মিনাল যদি ইমোজি সাপোর্ট না করে, তবে ইমোজির জায়গায় `?` দেখতে পারেন।)*
