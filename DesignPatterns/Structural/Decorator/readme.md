# 9. Decorator Pattern (ডেকোরেটর প্যাটার্ন)

### 📖 মূল কনসেপ্ট (Definition)
**সহজ বাংলায়:** কোনো একটি অবজেক্টে ডায়নামিক্যালি (রান-টাইমে) নতুন ফিচার বা লেয়ার যুক্ত করার জন্য ডেকোরেটর প্যাটার্ন ব্যবহার করা হয়। 
এটি একটি পেঁয়াজের মতো কাজ করে! একটি অবজেক্টকে আরেকটা অবজেক্ট দিয়ে মুড়িয়ে (Wrap) দেওয়া হয়, সেটাকে আবার আরেকটা দিয়ে মোড়ানো যায়। যেমন: প্লেইন কফির ওপর দুধের লেয়ার, তার ওপর চিনির লেয়ার।

**In English:** Decorator pattern lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

---

### 💻 কিভাবে কাজ করে? (Implementation Details)
1. **Component Interface (যেমন: Coffee):** মূল ক্লাস এবং ডেকোরেটর— দুজনকেই এটি ইমপ্লিমেন্ট করতে হয়।
2. **Concrete Component (যেমন: SimpleCoffee):** এটি হলো আমাদের বেসিক আইটেম।
3. **Base Decorator:** এটি কম্পোনেন্ট ইন্টারফেস ইমপ্লিমেন্ট করে এবং নিজের ভেতরে একটি কম্পোনেন্ট অবজেক্ট ধারণ করে (Composition)।
4. **Concrete Decorators (যেমন: MilkDecorator):** এরা মূল অবজেক্টের মেথড কল করার আগে বা পরে নিজেদের এক্সট্রা কাজটুকু জুড়ে দেয়।

---

### 🧪 বাস্তব জীবনের উদাহরণ (Industry Use Cases)
1. **Java I/O Streams:** `new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")))` — এটি জাভাতে ডেকোরেটরের সবচেয়ে বড় উদাহরণ।
2. **Text Formatting:** একটি টেক্সটকে ডায়নামিক্যালি Bold, Italic বা Underline করার জন্য।
3. **Web Middleware:** ওয়েব রিকোয়েস্টে লগিং (Logging), অথেন্টিকেশন (Auth) ইত্যাদি লেয়ার যুক্ত করার জন্য।

---

### ✅ সুবিধা (Pros)
- সাব-ক্লাস (Inheritance) তৈরি করার চেয়ে এটি অনেক বেশি ফ্লেক্সিবল। রান-টাইমে যেকোনো ফিচার অন/অফ করা যায়।
- **Single Responsibility Principle:** প্রতিটি ফিচারের (যেমন: শুধু Milk অ্যাড করার) লজিক আলাদা ক্লাসে থাকে।

### ❌ অসুবিধা (Cons)
- প্রচুর ছোট ছোট ক্লাস তৈরি হয়ে যায়, যা অনেক সময় কোড বেজকে অপরিষ্কার করে তোলে।
- অবজেক্ট তৈরি করার সময় অনেক বড় চেইন (`new A(new B(new C()))`) লিখতে হয়।
