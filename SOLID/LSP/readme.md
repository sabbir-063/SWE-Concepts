# Liskov Substitution Principle (LSP)

> **"Objects of a superclass shall be replaceable with objects of its subclasses without breaking the application."**

## 📖 মূল কনসেপ্ট (The Concept)
LSP-এর মানে হলো— যদি কোনো ক্লাসের (Parent) একটি চাইল্ড ক্লাস (Child) থাকে, তবে আমরা কোডের যেকোনো জায়গায় Parent-এর বদলে Child-কে বসালে যেন কোড ঠিকঠাক কাজ করে, কোনো এরর (Error) না দেয়।

সহজ ভাষায়: **Child class যেন কখনোই Parent class এর রুলস ব্রেক না করে।** 
যেমন: Parent class যদি বলে "সব পাখি উড়তে পারে", আর Child class হিসেবে "উটপাখি (Ostrich)" এসে বলে "আমি তো উড়তে পারি না!" — তাহলেই LSP ব্রেক হলো। 

---

## 📂 এই ফোল্ডারে যা যা আছে

### ১. `BadExample.java` ❌
এই ফাইলে `Bird` ক্লাসে `fly()` মেথড আছে। `Eagle` ঠিকঠাক কাজ করলেও, `Ostrich` ক্লাসটি `fly()` কল করলে `UnsupportedOperationException` থ্রো করছে। এর ফলে, Parent class (`Bird`) এর জায়গায় Child class (`Ostrich`) বসালে সিস্টেম ক্র্যাশ করছে! 

### ২. `GoodExample.java` ✅
এখানে আমরা `Bird` ইন্টারফেস থেকে `fly()` মেথড সরিয়ে ফেলেছি (কারণ সব পাখি ওড়ে না)। যারা ওড়ে, তাদের জন্য আলাদা ইন্টারফেস `FlyingBird` বানানো হয়েছে। এখন `Ostrich` শুধু `Bird`, আর `Eagle` হলো `FlyingBird`। এতে করে ভুল মেথড কল হওয়ার কোনো সুযোগই নেই!

### ৩. `IndustryExample.java` 🏢
রিয়েল ওয়ার্ল্ড ব্যাংকিং সিস্টেমের একটি উদাহরণ। 
সব অ্যাকাউন্ট থেকে টাকা উইথড্র করা যায় না (যেমন: Fixed Deposit Account)। তাই আমরা `WithdrawableAccount` নামে আলাদা অ্যাবস্ট্রাক্ট ক্লাস বানিয়েছি। `SavingsAccount` সেখান থেকে এসেছে। আর `FixedDepositAccount` সরাসরি মেইন `Account` থেকে এসেছে, যার ভেতর `withdraw` মেথডই নেই। ফলে ডেভেলপার ভুল করেও FD অ্যাকাউন্ট থেকে টাকা উইথড্র করার কোড লিখতে পারবে না।

---

## 🚀 কিভাবে রান করবেন (How to Run)

এই কোডগুলো রান করতে আপনার প্রজেক্টের রুট ডিরেক্টরি (`SWE`) থেকে টার্মিনালে নিচের কমান্ডগুলো দিন:

### ১. BadExample রান করতে:
```bash
javac SOLID/LSP/BadExample.java
java SOLID.LSP.BadExample
```
**Expected Output:**
```
Eagle is flying high! 🦅
Error: Ostriches can't fly! 🚫
```

### ২. GoodExample রান করতে:
```bash
javac SOLID/LSP/GoodExample.java
java SOLID.LSP.GoodExample
```
**Expected Output:**
```
Eagle is eating meat 🥩
Eagle is flying high! 🦅
Ostrich is eating grass 🌱
```

### ৩. IndustryExample রান করতে:
```bash
javac SOLID/LSP/IndustryExample.java
java SOLID.LSP.IndustryExample
```
**Expected Output:**
```
Withdrawn 2000.0 from Savings Account. New Balance: 3000.0
FD Balance: 10000.0
```

---

## ✅ LSP ফলো করার সুবিধা (Pros)
- **Unexpected Errors কমে যায়:** রানটাইমে (Runtime) হঠাৎ করে `UnsupportedOperationException` বা `NotImplementedException` খাওয়ার চান্স থাকে না।
- **কোড প্রেডিক্টেবল (Predictable) হয়:** Parent ক্লাসের ইন্টারফেস দেখে ডেভেলপার নিশ্চিন্তে কোড লিখতে পারে, তাকে চাইল্ড ক্লাসের ভেতরের লজিক দেখতে হয় না।

## ❌ কখন ব্যবহার করবেন না (Cons/When NOT to use)
- অনেক সময় লেগাসি (পুরোনো) কোডবেসে কাজ করার সময় অনেক ভুল হায়ারার্কি (Hierarchy) আগে থেকেই থাকে। তখন হুট করে LSP ফলো করতে গেলে পুরো সিস্টেম রিফ্যাক্টর করতে হয়, যা খুব রিস্কি। 
