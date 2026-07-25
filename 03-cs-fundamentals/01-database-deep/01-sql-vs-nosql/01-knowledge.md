# 01. SQL vs NoSQL (Knowledge & Theory)

## Learning Objectives
- SQL (Relational) এবং NoSQL (Non-Relational) ডাটাবেসের মধ্যে মূল পার্থক্যগুলো ক্লিয়ার করা।
- **Schema**, **Scaling (Vertical vs Horizontal)**, এবং **ACID vs BASE** প্রপার্টি বোঝা।
- রিয়েল লাইফ প্রজেক্টে কখন SQL এবং কখন NoSQL ব্যবহার করতে হবে তার সঠিক ডিসিশন নিতে শেখা।

---

## 1. Core Concepts & Definitions

### SQL (Relational Database)
SQL (Structured Query Language) ডাটাবেসগুলো ডেটাকে ছক বা **Table** (Rows and Columns) আকারে স্টোর করে। এখানে টেবিলগুলোর মধ্যে সম্পর্ক (Relations) থাকে। 
- **উদাহরণ:** MySQL, PostgreSQL, Oracle, SQL Server.
- **স্ট্রাকচার:** রিজিড বা ফিক্সড। ডেটা ঢোকানোর আগেই টেবিলের ডিজাইন (Schema) ঠিক করে নিতে হয়।

### NoSQL (Non-Relational Database)
NoSQL ডাটাবেসগুলো ডেটাকে ফ্লেক্সিবল ফরম্যাটে স্টোর করে, যেমন Document (JSON), Key-Value, Column-family বা Graph হিসেবে।
- **উদাহরণ:** MongoDB (Document), Redis (Key-Value), Cassandra (Wide-Column), Neo4j (Graph).
- **স্ট্রাকচার:** ডাইনামিক। কোনো ফিক্সড Schema নেই। এক ডেটার সাথে অন্য ডেটার স্ট্রাকচার না মিললেও সমস্যা নেই।

---

## 2. Head-to-Head Comparison

| Feature | SQL | NoSQL |
| :--- | :--- | :--- |
| **Data Structure** | Table (Rows & Columns) | Document (JSON), Key-Value, Graph, Column |
| **Schema** | Rigid/Fixed Schema (আগে ডিজাইন করতে হয়) | Dynamic/Flexible Schema (যেকোনো সময় চেঞ্জ করা যায়) |
| **Relations** | Table এ `JOIN` ব্যবহার করে জটিল সম্পর্ক তৈরি করা যায় | `JOIN` সাপোর্ট খুব কম বা নেই, ডেটা একসাথে (Denormalized) রাখা হয় |
| **Scaling** | **Vertical Scaling** (সার্ভারের র‍্যাম/প্রসেসর বাড়াতে হয়) | **Horizontal Scaling** (একাধিক সার্ভার/নোড যোগ করা যায়) |
| **Properties** | **ACID** (Atomicity, Consistency, Isolation, Durability) | **BASE** (Basically Available, Soft state, Eventual consistency) |
| **Best For** | ফাইন্যান্স, ব্যাংকিং, জটিল ট্রানজ্যাকশন (Transaction) | বিগ ডেটা (Big Data), রিয়েল-টাইম অ্যাপ, চ্যাট অ্যাপ, ক্যাটালগ |

---

## 3. The Scaling Battle: Vertical vs Horizontal

**Vertical Scaling (SQL এর ধরন):**
ধরা যাক আপনার একটি বিল্ডিং আছে। সেখানে আরও মানুষ থাকার জায়গা করতে আপনি বিল্ডিংয়ের ওপরে আরও ফ্লোর বানাচ্ছেন। অর্থাৎ, একটি সিঙ্গেল সার্ভারের CPU বা RAM বাড়ানো। এর একটি লিমিট আছে, একসময় আর ফ্লোর বাড়ানো যাবে না। 

**Horizontal Scaling (NoSQL এর ধরন):**
নতুন ফ্লোর না বানিয়ে আপনি পাশাপাশি আরও অনেকগুলো ছোট ছোট বিল্ডিং বানাচ্ছেন। অর্থাৎ, সিস্টেমে নতুন নতুন সার্ভার (Nodes) অ্যাড করা। এটি অনেক সস্তা এবং আনলিমিটেড স্কেল করা যায়। 
*(যদিও আধুনিক SQL ডাটাবেসগুলো হরাইজন্টাল স্কেলিং সাপোর্ট করে (যেমন Sharding), কিন্তু NoSQL এর মতো এটা ডিফল্ট বা ইজি নয়)।*

---

## 4. The Philosophy: ACID vs BASE

### SQL follows ACID:
- **A (Atomicity):** ট্রানজ্যাকশন হলে পুরোটাই হবে, না হলে কিছুই হবে না। (যেমন: ব্যাংক থেকে টাকা কাটলে অন্যের অ্যাকাউন্টে যেতেই হবে)।
- **C (Consistency):** ডেটাবেসের রুলস সবসময় মানা হবে।
- **I (Isolation):** একসাথে একাধিক ট্রানজ্যাকশন চললেও তারা একে অপরের কাজে বাধা দেবে না।
- **D (Durability):** একবার সেভ হয়ে গেলে কারেন্ট চলে গেলেও ডেটা হারাবে না।
*(এটি রিলায়েবিলিটি গ্যারান্টি দেয়)।*

### NoSQL follows BASE:
- **BA (Basically Available):** সিস্টেম সবসময় রেসপন্স করবে, কখনো ডাউন হবে না।
- **S (Soft state):** ইনপুট না দিলেও সিস্টেমের স্টেট একা একাই চেঞ্জ হতে পারে।
- **E (Eventual consistency):** ডেটা আপডেট করলে সাথে সাথে সব সার্ভারে আপডেট নাও হতে পারে, তবে "একটু পরে" (Eventually) সব ঠিক হয়ে যাবে।
*(যেমন: আপনি ফেসবুকে ছবি আপলোড করলে আপনার এক বন্ধু সাথে সাথে দেখলো, আরেক বন্ধু ৫ সেকেন্ড পরে দেখলো। এতে কোনো সমস্যা নেই)।*

---

## 5. When to Choose What? (Interview Decision Matrix)

### ✅ Use SQL When:
1. **Financial/Transactional Data:** ব্যাংক অ্যাকাউন্ট বা ই-কমার্স পেমেন্ট যেখানে ডেটার 100% অ্যাকুরেসি (ACID) দরকার।
2. **Complex Queries:** যদি অনেকগুলো টেবিল মিলিয়ে জটিল রিপোর্ট বা `JOIN` অপারেশন করতে হয়।
3. **Structured & Unchanging Data:** ডেটার ধরন যদি ফিক্সড থাকে (যেমন: Employee এর নাম, বয়স, আইডি)।

### ✅ Use NoSQL When:
1. **Rapid Development:** স্টার্টআপ প্রজেক্ট যেখানে ডেটাবেসের ডিজাইন (Schema) ঘন ঘন চেঞ্জ হতে পারে।
2. **Huge Volume of Data (Big Data):** প্রচুর ডেটা আসছে (যেমন IoT সেন্সর, লগ ফাইল) যা সস্তায় স্টোর করতে হবে।
3. **High Read/Write Speed:** লিডারবোর্ড (Redis) বা চ্যাট মেসেজ (MongoDB/Cassandra) যেখানে রিয়েল-টাইম স্পিড দরকার।

---

## 6. Real-World Architecture (Polyglot Persistence)
রিয়েল লাইফে বড় কোম্পানিগুলো (যেমন Uber, Netflix) শুধু SQL বা শুধু NoSQL ব্যবহার করে না, তারা প্রোজেক্টের ডিমান্ড অনুযায়ী দুটোই একসাথে ব্যবহার করে। 
যেমন: 
- ইউজারের পেমেন্ট ইনফো এবং বিলিং ➡️ **PostgreSQL (SQL)**
- ইউজারের কারেন্ট লোকেশন এবং রিয়েল-টাইম ডেটা ➡️ **Cassandra (NoSQL)**
- সার্চ এবং প্রোডাক্ট ক্যাটালগ ➡️ **ElasticSearch (NoSQL)**
- লিডারবোর্ড এবং ক্যাশিং ➡️ **Redis (NoSQL)** 

একেই বলে **Polyglot Persistence** (বহুভাষিক ডেটাবেস আর্কিটেকচার)।
