# 14. Command Pattern (কমান্ড প্যাটার্ন)

### 📖 মূল কনসেপ্ট (Definition)
**সহজ বাংলায়:** কমান্ড প্যাটার্ন একটি কাজ বা রিকোয়েস্টকে সরাসরি এক্সিকিউট না করে, সেটিকে একটি আলাদা অবজেক্ট (Command Object)-এ পরিণত করে ফেলে। 
ফলে আপনি একটি বাটনকে ডাইনামিক্যালি যেকোনো কাজ শেখাতে পারেন, কমান্ডগুলোকে লাইনে দাঁড় করিয়ে রাখতে পারেন, অথবা সবচেয়ে বড় সুবিধা— **"Undo" (আগের অবস্থায় ফিরে যাওয়া)** ফিচার তৈরি করতে পারেন।

**In English:** Command pattern encapsulates a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

---

### 💻 কিভাবে কাজ করে? (Implementation Details)
1. **Command Interface:** সব কমান্ডের জন্য কমন রুলস (`execute()` এবং `undo()`)।
2. **Concrete Commands:** আসল কমান্ড অবজেক্ট (যেমন `TurnOnLightCommand`)। এর ভেতর লেখা থাকে কাজটা আসলে কে করবে (Receiver)।
3. **Receiver:** যে আসল কাজটি করে (যেমন `Light` বা `TV`)।
4. **Invoker:** যে কমান্ড ট্রিগার করে (যেমন রিমোট কন্ট্রোলের `Button`)।

---

### 🧪 বাস্তব জীবনের উদাহরণ (Industry Use Cases)
1. **Undo/Redo System (Text Editors):** MS Word বা VS Code-এ `Ctrl + Z` চাপলে আগের অবস্থায় ফিরে যাওয়া যায়, কারণ প্রতিটি কাজ এক-একটি কমান্ড অবজেক্ট হিসেবে সেভ থাকে।
2. **Job Queues (Task Scheduling):** সার্ভারে যখন লাখ লাখ টাস্ক আসে, সেগুলোকে কমান্ড অবজেক্ট বানিয়ে Queue-তে রাখা হয়। সার্ভার ফাঁকা হলে একটা করে এক্সিকিউট করে।
3. **Macro Recording:** গেমে বাটনের কম্বিনেশন রেকর্ড করা।

---

### ✅ সুবিধা (Pros)
- **Single Responsibility Principle:** যে কাজ করতে বলছে (Invoker) এবং যে কাজ করছে (Receiver)— এরা সম্পূর্ণ আলাদা।
- চমৎকার Undo/Redo ফিচার বানানো যায়।

### ❌ অসুবিধা (Cons)
- ক্লাসের সংখ্যা প্রচুর বেড়ে যায়, কারণ প্রতিটি ছোট কাজের জন্যও একটি করে ক্লাস বানাতে হয়।
