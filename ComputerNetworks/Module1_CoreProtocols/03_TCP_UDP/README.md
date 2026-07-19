# Chapter 3: TCP & UDP (Transmission Control Protocol & User Datagram Protocol)

Welcome to Chapter 3! In the previous chapter, we explored the OSI and TCP/IP models, where we learned about the Transport Layer (Layer 4). Now, we will take a deep dive into the two most important protocols of the Transport Layer: **TCP** and **UDP**.

Transport layer-এর মূল কাজ হলো end-to-end communication নিশ্চিত করা। IP (Network Layer) শুধুমাত্র হোস্ট (কম্পিউটার) পর্যন্ত ডেটা পৌঁছে দেয়, কিন্তু সেই কম্পিউটারের কোন অ্যাপ্লিকেশন (যেমন: Browser নাকি Game) ডেটা পাবে, সেটা ঠিক করে Transport Layer (TCP/UDP) পোর্ট নাম্বারের মাধ্যমে।

---

## 1. TCP (Transmission Control Protocol)

TCP হলো একটি **Connection-Oriented** এবং **Reliable** প্রোটোকল। এর মানে হলো, ডেটা পাঠানোর আগে সেন্ডার এবং রিসিভারের মধ্যে একটি কানেকশন তৈরি করতে হয়, এবং ডেটা ঠিকমতো পৌঁছেছে কিনা তার গ্যারান্টি থাকে।

### Key Characteristics of TCP:
- **Reliable (নির্ভরযোগ্য):** প্যাকেট লস হলে আবার পাঠায় (Retransmission)।
- **Connection-Oriented:** ডেটা পাঠানোর আগে কানেকশন সেটআপ করে (3-Way Handshake)।
- **Ordered Delivery:** ডেটা যেই সিরিয়ালে পাঠানো হয়, সেই সিরিয়ালেই রিসিভ হয় (Sequence numbers ব্যবহার করে)।
- **Flow Control:** রিসিভারের ক্ষমতার চেয়ে বেশি ডেটা একসাথে পাঠায় না।
- **Congestion Control:** নেটওয়ার্কে জ্যাম (congestion) থাকলে ডেটা পাঠানোর স্পিড কমিয়ে দেয়।

### 1.1 TCP Header Format

TCP Header সাধারণত ২০ বাইটের (20 Bytes) হয়।

```text
 0                   1                   2                   3
 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|          Source Port          |       Destination Port        |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|                        Sequence Number                        |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|                    Acknowledgment Number                      |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|  Data |           |U|A|P|R|S|F|                               |
| Offset| Reserved  |R|C|S|S|Y|I|            Window             |
|       |           |G|K|H|T|N|N|                               |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|           Checksum            |         Urgent Pointer        |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|                    Options                    |    Padding    |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|                             data                              |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
```

**গুরুত্বপূর্ণ ফিল্ডসমূহ:**
- **Source & Destination Port:** কোন অ্যাপ থেকে ডেটা যাচ্ছে এবং কোন অ্যাপে যাবে।
- **Sequence Number:** ডেটার সিরিয়াল মেইনটেইন করার জন্য।
- **Acknowledgment Number (ACK):** রিসিভার সেন্ডারকে জানায় যে সে কতটুকু ডেটা পেয়েছে।
- **Flags (Control Bits):** 
  - **SYN (Synchronize):** কানেকশন তৈরির জন্য।
  - **ACK (Acknowledgment):** রিসিভ কনফার্ম করার জন্য।
  - **FIN (Finish):** কানেকশন ক্লোজ করার জন্য।
  - **RST (Reset):** কানেকশন জোর করে রিসেট করার জন্য।
- **Window:** Flow control-এর জন্য। রিসিভার জানায় সে কতটুকু ডেটা একবারে রিসিভ করতে পারবে।

---

### 1.2 TCP 3-Way Handshake (Connection Establishment)

TCP ডেটা পাঠানোর আগে সেন্ডার এবং রিসিভারের মধ্যে কানেকশন তৈরি করে। একে **3-Way Handshake** বলে। 

ধরি, Client (আপনার ব্রাউজার) এবং Server (ওয়েবসাইট) এর মধ্যে কানেকশন হবে:

```text
    Client                                               Server
      |                                                    |
      | -------- (1) SYN (Seq = X) ----------------------> |
      |          "Hello, I want to connect!"               |
      |                                                    |
      | <------- (2) SYN + ACK (Seq=Y, ACK=X+1) ---------- |
      |          "Hi! I received it. Let's connect!"       |
      |                                                    |
      | -------- (3) ACK (ACK=Y+1) ----------------------> |
      |          "Awesome, connection established!"        |
      |                                                    |
```

1. **Step 1 (SYN):** Client সার্ভারকে একটি SYN (Synchronize) প্যাকেট পাঠায় একটি Random Sequence Number (X) সহ।
2. **Step 2 (SYN-ACK):** Server প্যাকেটটি রিসিভ করে। সে Client-কে একটি SYN প্যাকেট পাঠায় তার নিজের Sequence Number (Y) সহ, এবং Client-এর প্যাকেট রিসিভ করেছে তা বোঝানোর জন্য একটি ACK (X+1) পাঠায়।
3. **Step 3 (ACK):** Client সার্ভারের প্যাকেট রিসিভ করে এবং ফাইনাল একটি ACK (Y+1) পাঠায়। 

কানেকশন এস্টাবলিশড! এখন তারা নিশ্চিন্তে ডেটা আদান-প্রদান করতে পারবে।

---

### 1.3 TCP Connection Termination (4-Way Handshake)

কাজ শেষে কানেকশন ক্লোজ করার জন্যও একটি প্রসেস আছে। যেহেতু TCP ফুল-ডুপ্লেক্স (দুই দিক থেকেই ডেটা যেতে পারে), তাই কানেকশন বন্ধ করতে ৪টি স্টেপ লাগে।

```text
    Client                                               Server
      |                                                    |
      | -------- (1) FIN --------------------------------> | (Client has no more data)
      |                                                    |
      | <------- (2) ACK --------------------------------- | (Server acknowledges)
      |                                                    |
      | <------- (3) FIN --------------------------------- | (Server has no more data)
      |                                                    |
      | -------- (4) ACK --------------------------------> | (Client acknowledges)
      |                                                    |
```
FIN মানে হলো Finish। যে ডেটা পাঠানো শেষ করেছে, সে FIN পাঠায়।

---

### 1.4 TCP Flow Control (Sliding Window)

Flow control মানে হলো সেন্ডারের ডেটা পাঠানোর স্পিড এবং রিসিভারের ডেটা রিসিভ করার স্পিডের মধ্যে ব্যালেন্স করা। 
ধরি, একটি সার্ভার অনেক ফাস্ট ডেটা পাঠাচ্ছে, কিন্তু ক্লায়েন্টের প্রসেসিং স্পিড স্লো বা র‍্যাম কম। এই অবস্থায় সার্ভার যদি ডেটা পাঠাতেই থাকে, তাহলে ক্লায়েন্টের বাফার (buffer) ফুল হয়ে ডেটা লস হবে।

TCP এটি সমাধান করে **Sliding Window** প্রোটোকল দিয়ে। 
- রিসিভার প্রতিটি ACK-এর সাথে একটি `Window Size` পাঠায়। 
- Window Size মানে হলো: "আমার কাছে এখন এত বাইট ডেটা রিসিভ করার জায়গা (buffer) ফাঁকা আছে।"
- সেন্ডার ঠিক ততটুকু ডেটাই পাঠায়। বাফার ফুল হয়ে গেলে রিসিভার Window Size 0 (Zero Window) পাঠায়, তখন সেন্ডার ডেটা পাঠানো থামিয়ে দেয়।

---

### 1.5 TCP Congestion Control

Flow Control দেখে রিসিভারের ক্ষমতা, আর **Congestion Control** দেখে পুরো নেটওয়ার্কের (রাউটার, লিংক) ক্ষমতা। নেটওয়ার্কে যদি অনেক ট্রাফিক থাকে, রাউটারগুলো প্যাকেট ড্রপ করতে শুরু করে। 

TCP তখন নিচের এলগরিদমগুলো ব্যবহার করে ডেটা পাঠানোর স্পিড কন্ট্রোল করে:
1. **Slow Start:** শুরুতে খুব কম ডেটা পাঠায় (1 segment), এরপর আস্তে আস্তে স্পিড বাড়ায় (Exponentially: 1, 2, 4, 8...)।
2. **Congestion Avoidance:** একটি নির্দিষ্ট থ্রেশহোল্ড (ssthresh) পার হলে, স্পিড খুব ধীরে ধীরে বাড়ায় (Linearly: 8, 9, 10...)।
3. **Congestion Detection:** প্যাকেট লস হলে (ACK না আসলে), TCP বুঝতে পারে নেটওয়ার্কে জ্যাম। তখন সে থ্রেশহোল্ড অর্ধেক করে দেয় এবং আবার Slow Start থেকে শুরু করে।

---

## 2. UDP (User Datagram Protocol)

UDP হলো একটি **Connectionless** এবং **Unreliable** প্রোটোকল। 
UDP-এর কোনো মাথা ব্যথা নেই ডেটা পৌঁছালো কিনা, বা সিরিয়াল ঠিক আছে কিনা। সে শুধু ডেটা ফায়ার করে দেয় (Fire and Forget)।

### Key Characteristics of UDP:
- **Connectionless:** কোনো 3-way handshake নেই। সরাসরি ডেটা পাঠানো শুরু করে।
- **Unreliable (নির্ভরযোগ্য নয়):** প্যাকেট ড্রপ হলে আবার পাঠায় না। 
- **No Overhead:** হেডার সাইজ খুবই ছোট, কোনো Flow Control বা Congestion Control নেই।
- **Very Fast:** যেহেতু কানেকশন সেটআপের সময় লাগে না এবং চেকিং নেই, তাই এটি অনেক ফাস্ট।

### 2.1 UDP Header Format

UDP Header মাত্র ৮ বাইটের (8 Bytes)। খুবই সিম্পল!

```text
 0      7 8     15 16    23 24    31  
+--------+--------+--------+--------+ 
|     Source      |   Destination   | 
|      Port       |      Port       | 
+--------+--------+--------+--------+ 
|                 |                 | 
|     Length      |    Checksum     | 
+--------+--------+--------+--------+ 
|                                   | 
|          data octets ...          | 
+-----------------------------------+
```

### 2.2 When to use UDP?
যেখানে স্পিড দরকার, কিন্তু কয়েকটা প্যাকেট লস হলে খুব একটা ক্ষতি নেই, সেখানে UDP ব্যবহার হয়।
- **Video/Audio Streaming:** (YouTube, Zoom, Skype) ভিডিও কলের সময় ২-১টা ফ্রেম ড্রপ হলে খুব সমস্যা নেই, কিন্তু লেগ (delay) হলে সমস্যা।
- **Online Gaming:** রিয়েল-টাইম গেমিংয়ে মিলি-সেকেন্ড লেটেন্সি ম্যাটার করে।
- **DNS Lookup:** DNS কুয়েরি খুব ছোট হয়, কানেকশন সেটআপ করতে গেলে বেশি সময় লাগবে।
- **VoIP:** Voice over IP (ইন্টারনেটে কথা বলা)।

---

## 3. TCP vs UDP (Summary Comparison)

| Feature | TCP | UDP |
| :--- | :--- | :--- |
| **Connection** | Connection-oriented | Connectionless |
| **Reliability** | Reliable (Retransmits lost packets) | Unreliable (No retransmission) |
| **Speed** | Slower (Overhead of ACKs and Handshakes) | Faster (Fire and Forget) |
| **Header Size** | 20 Bytes | 8 Bytes |
| **Flow Control**| Yes (Sliding Window) | No |
| **Ordering** | Yes (Ordered Delivery) | No (Packets may arrive out of order) |
| **Use Cases** | Web (HTTP/HTTPS), Email (SMTP), File Transfer (FTP), SSH | DNS, Video Streaming, Gaming, VoIP |

---
## Summary

- **TCP** হলো বিশ্বস্ত ডেলিভারিম্যানের মতো। সে প্যাকেট হাতে দিয়ে সাইন (ACK) নিয়ে আসে। দেরি হলেও গ্যারান্টি দেয় যে প্যাকেট পৌঁছাবে এবং সিরিয়াল মতো পৌঁছাবে।
- **UDP** হলো রেডিও ব্রডকাস্টের মতো। সে শুধু ডেটা ছুঁড়ে মারে। কে পেলো, কে পেলো না, তা নিয়ে তার কোনো চিন্তা নেই।

এখন আপনি TCP এবং UDP-এর কনসেপ্ট ক্লিয়ার! চলুন এবার Quiz.md ফাইলে গিয়ে আপনার জ্ঞান যাচাই করে নিই।
