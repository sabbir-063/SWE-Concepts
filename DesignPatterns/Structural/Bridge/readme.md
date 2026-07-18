# 7. Bridge Pattern (ব্রিজ প্যাটার্ন)

### 📖 মূল কনসেপ্ট (Definition)
**সহজ বাংলায়:** যখন একটি বিশাল ক্লাসকে দুটি আলাদা ভাগে (Abstraction এবং Implementation) ভাগ করে দেওয়া হয়, যাতে তারা একে অপরের ওপর নির্ভরশীল না হয়ে স্বাধীনভাবে বড় হতে পারে, তখন তাকে ব্রিজ প্যাটার্ন বলে। 
সহজ কথায়: "কী করতে হবে" (Abstraction) এবং "কীভাবে করতে হবে" (Implementation)— এই দুটোকে ইনহেরিট্যান্সের (Inheritance) বদলে কম্পোজিশন (Composition) দিয়ে জোড়া লাগানো হয়।

**In English:** Bridge pattern lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.

---

### 💻 কিভাবে কাজ করে? (Implementation Details)
1. **Abstraction (যেমন: RemoteControl):** এটি হলো ক্লায়েন্টের সাথে যোগাযোগের লেয়ার। এর ভেতরে Implementation-এর একটি রেফারেন্স থাকে।
2. **Implementation (যেমন: Device):** এটি হলো আসল কাজ করার লেয়ার (টিভি, রেডিও)।
3. ক্লায়েন্ট যখন রিমোটের `power()` মেথড কল করে, রিমোটটি তখন তার ভেতরে থাকা ডিভাইসের `turnOn()` মেথড কল করে দেয়। 
4. এতে করে রিমোটের ডিজাইন বদলালে ডিভাইসের কোনো প্রভাব পড়ে না, আবার নতুন ডিভাইস আসলে রিমোট বদলাতে হয় না।

---

### 🧪 বাস্তব জীবনের উদাহরণ (Industry Use Cases)
1. **Cross-Platform Apps:** একটি অ্যাপের উইন্ডোজ এবং লিনাক্স ভার্সন বানানোর সময়। GUI লজিক থাকে Abstraction-এ আর অপারেটিং সিস্টেমের API কলগুলো থাকে Implementation-এ।
2. **Database Drivers:** JDBC (Java Database Connectivity) একটি ব্রিজ হিসেবে কাজ করে। আপনার কোড (Abstraction) ডাটাবেস ড্রাইভারের (Implementation) সাথে ব্রিজের মাধ্যমে কথা বলে।

---

### ✅ সুবিধা (Pros)
- প্ল্যাটফর্ম ইন্ডিপেন্ডেন্ট (Platform-independent) ফিচার ডেভেলপ করা যায়।
- ক্লায়েন্টের কোড থেকে ইমপ্লিমেন্টেশন ডিটেইলস পুরোপুরি লুকিয়ে রাখা যায়।

### ❌ অসুবিধা (Cons)
- অনেক বেশি ক্লাস এবং ইন্টারফেস তৈরি হয়, যা কোড বুঝতে কঠিন করে তোলে।
