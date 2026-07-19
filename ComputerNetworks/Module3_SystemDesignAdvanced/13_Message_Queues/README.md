# Chapter 13: Message Queues & Event Streaming

Welcome to Module 3: Advanced System Design! এই মডিউলে আমরা জানবো বড় বড় ডিস্ট্রিবিউটেড সিস্টেমগুলো (Microservices) কীভাবে একে অপরের সাথে কাজ করে এবং প্রচুর ডেটা নিখুঁতভাবে হ্যান্ডেল করে। আমাদের প্রথম টপিক হলো **Message Queues** এবং **Event Streaming**।

---

## 1. Synchronous vs Asynchronous Communication

Microservices-এ দুটি সার্ভিস একে অপরের সাথে দু'ভাবে কথা বলতে পারে:

### 1.1 Synchronous (যেমন HTTP/REST, gRPC)
- *কিভাবে কাজ করে:* Service A একটি রিকোয়েস্ট পাঠায় Service B-কে এবং উত্তরের জন্য অপেক্ষা করে। উত্তর না আসা পর্যন্ত Service A ব্লকড থাকে।
- *সমস্যা:* যদি Service B স্লো হয় বা ডাউন থাকে, তবে Service A-ও আটকে যাবে। অনেকগুলো সার্ভিস চেইনের মতো যুক্ত থাকলে একটির সমস্যা পুরো সিস্টেমকে স্লো করে দেয় (Cascading Failure)।

### 1.2 Asynchronous (যেমন Message Queues)
- *কিভাবে কাজ করে:* Service A একটি মেসেজ (ডেটা) পাঠিয়ে দেয় এবং নিজের কাজ চালিয়ে যায়। সে Service B-এর উত্তরের জন্য অপেক্ষা করে না। Service B তার সময়মতো মেসেজটি রিসিভ করে কাজ করে।
- *সুবিধা:* এটি **Decoupled**। একটি সার্ভিস ডাউন থাকলেও অন্যটি কাজ করতে পারে।

---

## 2. Message Queue (মেসেজ কিউ)

**Message Queue** হলো একটি মিডলম্যান। এটি সার্ভিসগুলোর মাঝখানে বসে ডেটা আদান-প্রদান করতে সাহায্য করে। জনপ্রিয় Message Queue সফটওয়্যার হলো **RabbitMQ** বা **AWS SQS**।

### কিভাবে কাজ করে?
1. **Producer (প্রযোজক):** যে সার্ভিস মেসেজ তৈরি করে। (যেমন: Order Service)।
2. **Queue (কিউ/লাইন):** এটি একটি বাফার, যেখানে মেসেজগুলো লাইনে দাঁড়িয়ে থাকে (FIFO - First In, First Out)।
3. **Consumer (গ্রাহক):** যে সার্ভিস মেসেজগুলো লাইন থেকে নিয়ে কাজ করে। (যেমন: Email Service)।

*Example:* ইউজার একটি ই-কমার্স সাইটে অর্ডার করলো (Order Service)। Order Service একটি মেসেজ বানালো "Send Email to user@mail.com" এবং সেটি Queue-তে রেখে ইউজারকে "Order Successful" দেখিয়ে দিলো। এদিকে Email Service তার সুবিধামতো Queue থেকে মেসেজটি নিয়ে ইমেইল পাঠিয়ে দিলো। 

### Message Queue-এর সুবিধা:
- **Decoupling:** Order Service-কে জানতে হয় না Email Service কোথায় বা কিভাবে কাজ করে।
- **Buffering/Load Leveling:** যদি হঠাৎ 10,000 ইউজার অর্ডার করে, তবে Email Service ক্র্যাশ করবে না। মেসেজগুলো Queue-তে সেইফ থাকবে এবং Email Service আস্তে আস্তে একটি করে ইমেইল পাঠাবে।
- **Reliability:** Email Service ক্র্যাশ করলে মেসেজ Queue-তে থেকে যাবে। সার্ভার ঠিক হলে আবার কাজ শুরু করবে, কোনো ডেটা হারাবে না।

---

## 3. Pub/Sub Model (পাবলিশ/সাবস্ক্রাইব)

সাধারণ Message Queue-তে একটি মেসেজ শুধুমাত্র একজন Consumer পায়। কিন্তু যদি এমন হয় যে একটি মেসেজ একাধিক সার্ভিসের দরকার? তখন আমরা **Pub/Sub (Publish/Subscribe)** আর্কিটেকচার ব্যবহার করি।

- **Publisher:** মেসেজ তৈরি করে একটি 'Topic' (চ্যানেল)-এ পাবলিশ করে।
- **Subscriber:** যারা ঐ Topic-এ সাবস্ক্রাইব করে থাকে, তারা সবাই মেসেজটির একটি করে কপি পায়।

*Example:* ইউজার নতুন অ্যাকাউন্ট খুললো (User Service)। User Service একটি মেসেজ পাবলিশ করলো `user.created` টপিকে। 
- Email Service সাবস্ক্রাইব করা ছিল, সে ওয়েলকাম ইমেইল পাঠালো।
- Analytics Service সাবস্ক্রাইব করা ছিল, সে ইউজারের ডেটা ট্র্যাকিং ডেটাবেসে রাখলো।
- (দুটি সার্ভিসই একই মেসেজ পেলো)।

---

## 4. Event Streaming (যেমন Apache Kafka)

Message Queue (RabbitMQ) এবং Event Streaming (Kafka) দেখতে একই রকম মনে হলেও এদের মধ্যে বড় একটি পার্থক্য আছে।

### 4.1 Message Queue (RabbitMQ)
- এটি "Smart Broker, Dumb Consumer" মডেলে কাজ করে। 
- Consumer মেসেজ রিসিভ করার পর Broker (RabbitMQ) সেটি **ডিলিট করে দেয়**। 
- এটি মূলত কাজ (Tasks/Commands) ডিস্ট্রিবিউট করার জন্য ব্যবহৃত হয়।

### 4.2 Event Streaming (Apache Kafka)
- এটি "Dumb Broker, Smart Consumer" মডেলে কাজ করে।
- Broker (Kafka) কোনো মেসেজ ডিলিট করে না! এটি একটি **Append-only Log** (খাতার মতো) যেখানে ইভেন্টগুলো সেভ করা থাকে। 
- Consumer-রা লগ থেকে মেসেজ পড়ে এবং মনে রাখে তারা কতদূর পড়েছে (Offset)। 
- যেহেতু মেসেজ ডিলিট হয় না, তাই চাইলে এক মাস আগের ডেটাও আবার "Replay" করা সম্ভব। 
- এটি মূলত বিশাল পরিমাণের ডেটা (Big Data/Real-time Analytics) হ্যান্ডেল করার জন্য ব্যবহৃত হয়।

---

## 5. Event-Driven Architecture (EDA)

Message Queue এবং Event Streaming ব্যবহার করে যে আর্কিটেকচার তৈরি হয়, তাকে **Event-Driven Architecture** বলে।
এখানে মাইক্রোসার্ভিসগুলো একে অপরকে "তুমি এটা করো" (Command) বলার বদলে, "আমার সিস্টেমে এটা ঘটেছে" (Event) বলে ঘোষণা দেয়। বাকি সার্ভিসগুলো সেই ইভেন্ট শুনে নিজেরা সিদ্ধান্ত নেয় কী করতে হবে। এটি সিস্টেমকে হাইলি স্কেলেবল এবং ডিকাপলড করে তোলে।

---

## Summary
- **Synchronous Communication:** উত্তরের জন্য অপেক্ষা করতে হয় (HTTP/REST)।
- **Asynchronous Communication:** অপেক্ষা করতে হয় না, কাজ দ্রুত হয় (Message Queues)।
- **Message Queue (RabbitMQ):** মেসেজ বাফার করে রাখে, রিসিভ করার পর ডিলিট করে দেয়।
- **Pub/Sub:** একটি মেসেজ অনেকগুলো সার্ভিসকে দেওয়া।
- **Event Streaming (Kafka):** মেসেজ ডিলিট হয় না, লগে সেভ থাকে। বিগ ডেটার জন্য পারফেক্ট।

Message Queues এবং Kafka-র কনসেপ্টগুলো আধুনিক সিস্টেম ডিজাইনের জন্য অপরিহার্য। চলুন এবার Quiz.md ফাইলে গিয়ে আপনার জ্ঞান যাচাই করে নিই।
