# 02. CAP Theorem (Configurations & Behaviors)

CAP Theorem কোনো কোড বা অ্যালগরিদম নয়, এটি একটি আর্কিটেকচারাল কনসেপ্ট। তবে ডাটাবেসের কিছু কনফিগারেশন চেঞ্জ করে আমরা একই ডাটাবেসকে CP বা AP এর দিকে বায়াস (Bias) করতে পারি। 
এই ফাইলে আমরা MongoDB এবং Cassandra এর বিভিন্ন কনফিগারেশনের মাধ্যমে Strong Consistency এবং Eventual Consistency এর কোড/লজিক কেমন হয় তা দেখবো।

---

## 1. MongoDB (Bias towards CP - Consistency)

MongoDB সাধারণত **CP (Consistent and Partition Tolerant)** সিস্টেম হিসেবে কাজ করে। এর আর্কিটেকচারে একটি Primary নোড থাকে এবং কয়েকটি Secondary নোড (Replica) থাকে। সব Write অপারেশন Primary তেই হয়।

### Example: Tuning Write Consistency (Write Concern)

ধরা যাক, আমাদের ৩টি নোড আছে (1 Primary, 2 Secondaries)। ডেটা রাইট করার সময় আমরা ঠিক করে দিতে পারি আমরা কতটা Consistency চাই।

```javascript
// ১. Low Consistency (Fast Speed) - AP এর মতো আচরণ
// Primary তে ডেটা সেভ হলেই সাকসেস মেসেজ দিয়ে দেবে। Secondary তে কপি হতে দেরি হতে পারে।
db.users.insertOne(
   { name: "Sabbir", age: 25 },
   { writeConcern: { w: 1 } } // w: 1 মানে শুধু ১টি নোডে সেভ হলেই হবে
)

// ২. Strong Consistency (Slow Speed, High Safety) - Strict CP
// Primary এবং অন্তত ১টি Secondary তে ডেটা কপি হওয়ার পর সাকসেস মেসেজ দেবে।
db.users.insertOne(
   { name: "Sabbir", age: 25 },
   { writeConcern: { w: "majority" } } // w: "majority" মানে অর্ধেকের বেশি নোডে সেভ হতে হবে
)
```

### Understanding the Trade-off:
- `w: 1` দিলে খুব ফাস্ট রেসপন্স পাবেন। কিন্তু Primary নোড যদি Secondary তে কপি হওয়ার আগেই ক্র্যাশ করে, তবে ডেটা চিরতরে হারিয়ে যাবে।
- `w: "majority"` দিলে ডেটা সেভ হতে একটু সময় বেশি লাগবে (Latency), কিন্তু ডেটা 100% সেফ থাকবে।

---

## 2. Apache Cassandra (Bias towards AP - Availability)

Cassandra মূলত **AP (Highly Available)** সিস্টেম হিসেবে পরিচিত। এর কোনো Primary নোড নেই (Masterless)। সব নোডই ডেটা রিসিভ করতে পারে। তাই কোনো নোড ডাউন হলেও সিস্টেম ডাউন হয় না। 

### Example: Tuning Read/Write Consistency (Consistency Levels)

ক্যাসান্দ্রাতেও আপনি কুয়েরি করার সময় Consistency Level সেট করে দিতে পারেন, যা PACELC থিওরেমের লজিক অনুযায়ী কাজ করে।

```cql
-- ১. High Availability, Low Consistency (Eventual Consistency)
-- যেকোনো ১টি নোড ডেটা কনফার্ম করলেই ক্লায়েন্টকে সাকসেস দিয়ে দেবে।
CONSISTENCY ONE;
INSERT INTO users (id, name) VALUES (1, 'Sabbir');


-- ২. Balance between Consistency and Availability
-- ক্লাস্টারের মেজরিটি (অর্ধেকের বেশি) নোড কনফার্ম করলে সাকসেস দেবে।
CONSISTENCY QUORUM;
INSERT INTO users (id, name) VALUES (1, 'Sabbir');


-- ৩. Strong Consistency (Slower, Risk of Failure)
-- ক্লাস্টারের সব নোড কনফার্ম না করা পর্যন্ত সাকসেস দেবে না। 
-- কোনো একটি নোড অফলাইন থাকলে এটি Error দেবে! (Availability কমে গেলো)।
CONSISTENCY ALL;
SELECT * FROM users WHERE id = 1;
```

---

## 3. The "Quorum" Concept (The Magic Number)

ডিস্ট্রিবিউটেড সিস্টেমে `Quorum` (কোরাম) হচ্ছে সেই ম্যাজিক নাম্বার যা ঠিক করে দেয় কতটা নোডের পারমিশন পেলে একটি কাজ ভ্যালিড হবে।
ফর্মুলা: `Quorum = (Total Nodes / 2) + 1`

**কেন Quorum ইম্পর্ট্যান্ট? (The Split-Brain Problem)**
ধরা যাক আপনার ৫টি নোডের একটি ক্লাস্টার আছে। নেটওয়ার্ক ক্যাবল কাটা গিয়ে এটি ২ ভাগ হয়ে গেলো (একপাশে ৩টি নোড, অন্যপাশে ২টি নোড)। 
এখন দুই পাশের ক্লায়েন্টই যদি ডেটা আপডেট করা শুরু করে, তবে ডেটাবেসে কনফ্লিক্ট বা দুই ধরনের ডেটা তৈরি হবে। একে বলে **Split-Brain** প্রবলেম।

Quorum এটি সলভ করে। `Quorum = (5/2)+1 = 3`। 
যেহেতু একপাশে ৩টি নোড আছে, তারা Quorum অর্জন করতে পারবে এবং কাজ চালিয়ে যাবে। আর যেপাশে ২টি নোড আছে, তারা Quorum পাবে না, তাই তারা কোনো রাইট (Write) অপারেশন একসেপ্ট না করে ক্লায়েন্টকে Error দিয়ে দেবে। 

এভাবেই ডিস্ট্রিবিউটেড সিস্টেম কনসিস্টেন্সি (C) মেইনটেইন করে!
