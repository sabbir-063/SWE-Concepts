# 01. HTTPS & TLS (Code & Implementation)

এই ফাইলে আমরা Node.js ব্যবহার করে একটি সাধারণ HTTP সার্ভার এবং একটি সিকিউর HTTPS সার্ভার তৈরি করে দেখবো। 
HTTPS সার্ভার রান করার জন্য আমাদের একটি `Private Key` এবং একটি `Certificate` লাগবে, যা আমরা সাধারণত OpenSSL বা Let's Encrypt দিয়ে তৈরি করি।

---

## 1. Creating an Insecure HTTP Server (Not Recommended)

এটি একটি বেসিক সার্ভার যেখানে ডেটা প্লেইন টেক্সট হিসেবে ট্রান্সফার হয়।

```javascript
const http = require('http');

const server = http.createServer((req, res) => {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    // এই মেসেজটি হ্যাকার খুব সহজেই নেটওয়ার্ক স্নিফ (Sniff) করে পড়তে পারবে
    res.end('Hello from INSECURE Server!\n'); 
});

server.listen(80, () => {
    console.log('HTTP Server is running on port 80');
});
```

---

## 2. Generating SSL Certificates (Local Testing)

প্রোডাকশনে আমরা **Let's Encrypt** বা AWS ACM থেকে আসল সার্টিফিকেট নিই। কিন্তু লোকাল পিসিতে টেস্ট করার জন্য আমরা `openssl` টার্মিনাল কমান্ড ব্যবহার করে একটি সেলফ-সাইন্ড (Self-signed) সার্টিফিকেট বানাতে পারি।

```bash
# ১. Private Key তৈরি করা (এটি সার্ভারের কাছে সিক্রেট থাকবে)
openssl genrsa -out private-key.pem 2048

# ২. Private Key থেকে Certificate তৈরি করা (এটি পাবলিকলি ক্লায়েন্টকে দেওয়া হবে)
openssl req -new -x509 -key private-key.pem -out certificate.pem -days 365
```

---

## 3. Creating a Secure HTTPS Server

এবার আমরা উপরের জেনারেট করা `private-key.pem` এবং `certificate.pem` ফাইল দুটি ব্যবহার করে Node.js এ HTTPS সার্ভার তৈরি করবো।

```javascript
const https = require('https');
const fs = require('fs');

// ১. অপশনস অবজেক্টে Key এবং Certificate লোড করা
const options = {
    // Private Key (লুকিয়ে রাখা চাবি, ডিক্রিপ্ট করার জন্য)
    key: fs.readFileSync('./private-key.pem'), 
    
    // Certificate (পাবলিক চাবি এবং CA এর সিগনেচার থাকে এতে)
    cert: fs.readFileSync('./certificate.pem') 
};

// ২. HTTPS সার্ভার তৈরি করা (http.createServer এর বদলে)
const secureServer = https.createServer(options, (req, res) => {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    // এই মেসেজটি এনক্রিপ্টেড (Ciphertext) হয়ে ক্লায়েন্টের কাছে যাবে
    res.end('Hello from SECURE HTTPS Server!\n');
});

secureServer.listen(443, () => {
    console.log('HTTPS Server is running on port 443');
});
```

### 💡 Why do browsers show a "Not Secure" warning for Self-Signed certs?
লোকালে উপরের কোডটি রান করে ব্রাউজারে `https://localhost` এ গেলে ব্রাউজার একটি বড় লাল ওয়ার্নিং দেবে। 
**কারণ:** ব্রাউজার দেখে যে আপনার সার্টিফিকেটে কোনো ট্রাস্টেড CA (Certificate Authority) এর সিগনেচার নেই। আপনি নিজেই নিজের সার্টিফিকেট সাইন করেছেন (Self-signed)। ব্রাউজার তো আর আপনাকে চেনে না! প্রোডাকশনে একটি আসল CA-এর সিগনেচার থাকলে এই ওয়ার্নিং আর আসে না এবং ব্রাউজারে সবুজ রঙের একটি "তালার (Padlock)" আইকন দেখায়।
