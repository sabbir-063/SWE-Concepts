# Chapter 9: Proxy (Forward & Reverse)

Welcome to Chapter 9! In everyday life, a "Proxy" is someone who does something on your behalf. In computer networking, a **Proxy Server** is an intermediary server that sits between a client and a destination server, acting on behalf of one or the other.

Proxies are critical for security, privacy, caching, and load distribution. There are two main types of proxies: **Forward Proxy** and **Reverse Proxy**.

---

## 1. Forward Proxy (ফরোয়ার্ড প্রক্সি)

**Forward Proxy** ক্লায়েন্টদের (আপনার কম্পিউটার/ব্রাউজার) সামনে বসে থাকে এবং ক্লায়েন্টের হয়ে ইন্টারনেটে রিকোয়েস্ট পাঠায়। সাধারণত যখন আমরা শুধু "Proxy" বা "VPN" বলি, তখন আমরা Forward Proxy-কেই বোঝাই।

### কিভাবে কাজ করে?
1. ক্লায়েন্ট `facebook.com`-এ ঢুকতে চায়।
2. ক্লায়েন্ট সরাসরি `facebook.com`-কে রিকোয়েস্ট না পাঠিয়ে, রিকোয়েস্টটি Forward Proxy-কে পাঠায়।
3. Forward Proxy সেই রিকোয়েস্টটি `facebook.com`-এর কাছে পাঠায়।
4. `facebook.com` রেসপন্সটি Proxy-কে দেয়, এবং Proxy সেটি ক্লায়েন্টকে ফেরত দেয়।

### Forward Proxy-এর কাজ (Use Cases):
- **Privacy & Anonymity:** ইন্টারনেট বা ওয়েবসাইট জানতে পারে না যে আসল ইউজার কে, তারা শুধু Proxy Server-এর IP Address দেখতে পায়।
- **Bypassing Restrictions (অবরোধ এড়ানো):** আপনার অফিসে বা দেশে যদি কোনো ওয়েবসাইট ব্লক থাকে, তবে আপনি এমন একটি Proxy ব্যবহার করতে পারেন যা ব্লকড নয়। Proxy আপনার হয়ে ঐ ওয়েবসাইটে ঢুকে ডেটা এনে দেবে।
- **Content Filtering:** স্কুল বা অফিসে ইন্টারনেট কন্ট্রোল করার জন্য Forward Proxy বসানো হয়, যাতে কেউ খারাপ ওয়েবসাইটে ঢুকতে না পারে। Proxy ঐ ওয়েবসাইটগুলোকে ব্লক করে দেয়।
- **Caching:** একই অফিসের অনেক মানুষ যদি একই ফাইল বারবার ডাউনলোড করে, তবে Proxy সেটা একবার ইন্টারনেট থেকে নামিয়ে নিজের কাছে ক্যাশ করে রাখে এবং বাকিদের দ্রুত দিয়ে দেয়।

---

## 2. Reverse Proxy (রিভার্স প্রক্সি)

**Reverse Proxy** সার্ভারগুলোর (অরিজিন সার্ভার) সামনে বসে থাকে এবং ইন্টারনেটের ইউজারদের কাছ থেকে রিকোয়েস্ট গ্রহণ করে সার্ভারগুলোকে দেয়। এটি ক্লায়েন্টকে প্রটেক্ট করার বদলে **সার্ভারকে প্রটেক্ট** করে।

> **Note:** Nginx, HAProxy, এবং Apache হলো বিখ্যাত কিছু Reverse Proxy সফটওয়্যার।

### কিভাবে কাজ করে?
1. ইউজার `yourwebsite.com`-এ রিকোয়েস্ট পাঠায়।
2. রিকোয়েস্টটি আপনার আসল সার্ভারে না গিয়ে, সামনে বসে থাকা Reverse Proxy-তে হিট করে।
3. Reverse Proxy চেক করে দেখে রিকোয়েস্টটি ভ্যালিড কিনা, তারপর সেটি পেছনের কোনো একটি আসল সার্ভারে পাঠিয়ে দেয়।
4. সার্ভার রেসপন্স তৈরি করে Proxy-কে দেয়, এবং Proxy সেটি ইউজারকে দেয়। ইউজার কখনোই জানতে পারে না যে আসল সার্ভার কোথায় বা কয়টি।

### Reverse Proxy-এর কাজ (Use Cases):
- **Load Balancing (ট্রাফিক ভাগ করা):** Reverse Proxy একই সাথে Load Balancer হিসেবে কাজ করতে পারে (যেমন আমরা Chapter 5-এ দেখেছি)।
- **Security & Hiding Origin:** হ্যাকাররা কখনোই আপনার আসল সার্ভারের (Origin Server) IP Address জানতে পারে না। তারা শুধু Proxy-কে অ্যাটাক করতে পারে। Proxy চাইলে খারাপ ট্রাফিক বা DDoS অ্যাটাক ব্লক করে দিতে পারে।
- **TLS/SSL Termination:** প্রতিটি সার্ভারকে আলাদাভাবে HTTPS (এনক্রিপশন/ডিক্রিপশন) হ্যান্ডেল করতে দিলে সার্ভারের CPU এর উপর প্রেশার পড়ে। Reverse Proxy নিজেই ক্লায়েন্টের সাথে HTTPS হ্যান্ডেল করে এবং পেছনের সার্ভারের সাথে নরমাল HTTP-তে কথা বলে।
- **Static Content Caching:** Reverse Proxy ইমেজ, CSS বা স্ট্যাটিক HTML পেজগুলো নিজের কাছে ক্যাশ করে রাখে, যাতে অ্যাপ্লিকেশন সার্ভারকে অযথা কাজ করতে না হয়।

---

## 3. Forward Proxy vs Reverse Proxy (Comparison)

| Feature | Forward Proxy | Reverse Proxy |
| :--- | :--- | :--- |
| **Whom it protects?** | Protects the **Client** (User) | Protects the **Server** (Origin) |
| **Position** | Sits in front of Clients | Sits in front of Backend Servers |
| **Visibility** | Servers don't know who the real client is. | Clients don't know who the real server is. |
| **Main Usage** | Bypassing firewalls, anonymity, content filtering. | Load balancing, security (DDoS protection), SSL termination. |

---

## 4. Transparent Proxy vs Anonymous Proxy

Forward Proxy আবার কয়েক ধরণের হতে পারে:
- **Transparent Proxy (স্বচ্ছ প্রক্সি):** এটি আপনার IP Address লুকায় না। ওয়েবসাইট বুঝতে পারে যে আপনি প্রক্সি ব্যবহার করছেন এবং আপনার আসল IP-ও দেখতে পায়। এটি মূলত শুধু ক্যাশিং বা ফিল্টারিংয়ের (যেমন অফিসে) জন্য ব্যবহার হয়।
- **Anonymous Proxy (অজ্ঞাত প্রক্সি):** এটি ওয়েবসাইটের কাছে আপনার IP লুকিয়ে ফেলে। ওয়েবসাইট বুঝতে পারে যে একটি প্রক্সি থেকে রিকোয়েস্ট আসছে, কিন্তু আসল ইউজার কে তা বুঝতে পারে না।

---

## Summary
- **Proxy Server** হলো একটি মিডলম্যান বা মধ্যস্থতাকারী।
- **Forward Proxy** ইউজারের সামনে বসে ইউজারকে ইন্টারনেট থেকে আড়াল করে (যেমন VPN, School firewall)।
- **Reverse Proxy** সার্ভারের সামনে বসে সার্ভারকে ইন্টারনেট থেকে আড়াল করে (যেমন Nginx, Load Balancers)।
- Reverse Proxy সার্ভারের সিকিউরিটি বাড়ায়, লোড ব্যালেন্সিং করে এবং SSL Termination করে।

এখন আপনি Proxy-এর কনসেপ্ট পুরোপুরি ক্লিয়ার! চলুন এবার Quiz.md ফাইলে গিয়ে আপনার জ্ঞান যাচাই করে নিই।
