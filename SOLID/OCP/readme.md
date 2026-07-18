# Open/Closed Principle (OCP)

> **"Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification."**

## 📖 মূল কনসেপ্ট (The Concept)
OCP-এর মানে হলো— একটি ক্লাস এমনভাবে ডিজাইন করতে হবে যেন নতুন ফিচার অ্যাড করার সময় **(Open for extension)** ওই ক্লাসের ভেতরের পুরোনো কোড পরিবর্তন করতে না হয় **(Closed for modification)**। 

যখন আমরা `if-else` বা `switch` কেস দিয়ে অনেক অপশন চেক করি, তখন নতুন কোনো অপশন আসলে ওই `if-else` ব্লকটি এডিট করতে হয়। এতে পুরোনো, ঠিকঠাক কাজ করা কোডে বাগ (bug) আসার চান্স থাকে। 

OCP ফলো করতে আমরা **Polymorphism (Interfaces/Abstract classes)** ব্যবহার করি। 

---

## 📂 এই ফোল্ডারে যা যা আছে

### ১. `BadExample.java` ❌
এই ফাইলে `DiscountCalculator` ক্লাসে OCP ব্রেক করা হয়েছে। এখানে কাস্টমার টাইপ (REGULAR বা VIP) চেক করতে `if-else` ব্যবহার করা হয়েছে। যদি নতুন 'SuperVIP' কাস্টমার আসে, তবে এই ক্লাসটি মডিফাই করতে হবে!

### ২. `GoodExample.java` ✅
এখানে আমরা `CustomerDiscount` নামে একটি ইন্টারফেস বানিয়েছি। প্রতিটি কাস্টমার টাইপ নিজের মতো করে ডিসকাউন্ট ক্যালকুলেট করে। `DiscountCalculator` ক্লাসটি আর কখনো এডিট করতে হবে না। নতুন কাস্টমার টাইপ আসলে শুধু একটি নতুন ক্লাস বানাতে হবে!

### ৩. `IndustryExample.java` 🏢
রিয়েল ওয়ার্ল্ড পেমেন্ট গেটওয়ের (Payment Gateway) চমৎকার একটি উদাহরণ। 
`CheckoutService` ক্লাসটি শুধু `PaymentProcessor` ইন্টারফেস চিনে। কাস্টমার bKash, SSLCommerz নাকি Nagad সিলেক্ট করেছে তা নিয়ে তার মাথা ব্যথা নেই। ভবিষ্যতে Rocket বা Upay পেমেন্ট অ্যাড করতে হলে পুরোনো কোনো কোড এডিট করতে হবে না।

---

## 🚀 কিভাবে রান করবেন (How to Run)

এই কোডগুলো রান করতে আপনার প্রজেক্টের রুট ডিরেক্টরি (`SWE`) থেকে টার্মিনালে নিচের কমান্ডগুলো দিন:

### ১. BadExample রান করতে:
```bash
javac SOLID/OCP/BadExample.java
java SOLID.OCP.BadExample
```
**Expected Output:**
```
Regular Discount: $10.0
VIP Discount: $20.0
```

### ২. GoodExample রান করতে:
```bash
javac SOLID/OCP/GoodExample.java
java SOLID.OCP.GoodExample
```
**Expected Output:**
```
Regular Discount: $10.0
VIP Discount: $20.0
Super VIP Discount: $30.0
```

### ৩. IndustryExample রান করতে:
```bash
javac SOLID/OCP/IndustryExample.java
java SOLID.OCP.IndustryExample
```
**Expected Output:**
```
Processing bKash payment of BDT 1500.5
Processing Card payment via SSLCommerz of BDT 5000.0
Processing Nagad payment of BDT 100.0
```

---

## ✅ OCP ফলো করার সুবিধা (Pros)
- **পুরোনো কোড সুরক্ষিত থাকে:** নতুন ফিচার অ্যাড করতে গিয়ে রানিং কোড ব্রেক হয় না।
- **নতুন ফিচার বানানো সহজ:** শুধু একটি নতুন ক্লাস বানিয়ে ইন্টারফেস ইমপ্লিমেন্ট করে দিলেই হয়ে যায়।
- **কোড কাপলিং (Coupling) কমে:** ক্লাসগুলো একে অপরের উপর কম নির্ভরশীল থাকে।

## ❌ কখন ব্যবহার করবেন না (Cons/When NOT to use)
- যদি আপনার সিস্টেমের রিকোয়ারমেন্ট খুব সিম্পল হয় এবং ভবিষ্যতে ওই ফিচারটি আর চেঞ্জ হওয়ার কোনোই সম্ভাবনা না থাকে, তবে ইন্টারফেস বানিয়ে OCP ফলো করাটা **Over-engineering** হতে পারে। তখন `if-else` বা `switch` ব্যবহার করাই ভালো।
