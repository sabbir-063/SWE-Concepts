# 02. Load Balancing & CDN (Code & Configuration)

এই ফাইলে আমরা দুনিয়ার সবচেয়ে পপুলার ওয়েব সার্ভার **NGINX** ব্যবহার করে কীভাবে একটি প্র্যাকটিক্যাল Load Balancer সেটআপ করতে হয় তা দেখবো। পাশাপাশি CDN ক্যাশিং কন্ট্রোল করার জন্য HTTP Header কীভাবে লিখতে হয় তা দেখবো।

---

## 1. NGINX as a Layer 7 Load Balancer

ধরা যাক, আপনার ৩টি Node.js সার্ভার চলছে (পোর্ট ৩০০০, ৩০০১ এবং ৩০০২ এ)। আমরা Nginx-কে ট্রাফিক পুলিশ (Load Balancer) হিসেবে সেট করবো।

`nginx.conf` ফাইলের কনফিগারেশন:

```nginx
http {
    // ১. ব্যাকএন্ড সার্ভারগুলোর একটি গ্রুপ (Upstream) তৈরি করা
    upstream my_nodejs_servers {
        // ডিফল্টভাবে এটি Round Robin অ্যালগরিদম ফলো করবে
        server 127.0.0.1:3000;
        server 127.0.0.1:3001;
        server 127.0.0.1:3002;
    }

    server {
        listen 80;
        server_name mywebsite.com;

        // ২. ইউজার যখন '/' (মেইন পেজ) এ হিট করবে
        location / {
            // Nginx রিকোয়েস্টটিকে 'my_nodejs_servers' গ্রুপে পাঠিয়ে দেবে (Proxy Pass)
            proxy_pass http://my_nodejs_servers;
            
            // রিয়েল ইউজারের IP যেন ব্যাকএন্ড সার্ভার পায়, সেজন্য হেডার সেট করা
            proxy_set_header X-Real-IP $remote_addr;
        }
    }
}
```

---

## 2. Changing the Load Balancing Algorithm

আপনি চাইলে Nginx এর অ্যালগরিদম খুব সহজেই চেঞ্জ করতে পারেন।

### A. Least Connections (যাদের লোড কম, তাদের কাছে পাঠাও)
```nginx
upstream my_nodejs_servers {
    least_conn;  // এই লাইনটি অ্যাড করলেই হবে
    server 127.0.0.1:3000;
    server 127.0.0.1:3001;
    server 127.0.0.1:3002;
}
```

### B. IP Hash (একই ইউজার সবসময় একই সার্ভারে যাবে)
```nginx
upstream my_nodejs_servers {
    ip_hash;     // সেশন বা লগইন স্টেট মেইনটেইন করার জন্য দারুণ
    server 127.0.0.1:3000;
    server 127.0.0.1:3001;
    server 127.0.0.1:3002;
}
```

### C. Weighted Round Robin (পাওয়ারফুল সার্ভারকে বেশি কাজ দাও)
```nginx
upstream my_nodejs_servers {
    // পোর্ট 3000 এর সার্ভারটি 3 গুন বেশি রিকোয়েস্ট পাবে!
    server 127.0.0.1:3000 weight=3; 
    server 127.0.0.1:3001 weight=1;
    server 127.0.0.1:3002 weight=1;
}
```

---

## 3. Controlling CDN Cache via HTTP Headers

CDN বা ইউজারের ব্রাউজার কীভাবে এবং কতক্ষণ আপনার ডেটা ক্যাশ (Cache) করে রাখবে, তা আপনার মেইন সার্ভার থেকে `Cache-Control` হেডারের মাধ্যমে বলে দেওয়া যায়। Node.js (Express) এর উদাহরণ:

```javascript
const express = require('express');
const app = express();

// ১. Static Files (Images, CSS) - অনেক দিনের জন্য ক্যাশ করা
app.get('/logo.png', (req, res) => {
    // max-age=86400 মানে ২৪ ঘণ্টা (সেকেন্ডে)। 
    // public মানে CDN এবং ব্রাউজার উভয়েই এটি ক্যাশ করতে পারবে।
    res.setHeader('Cache-Control', 'public, max-age=86400');
    res.sendFile(__dirname + '/logo.png');
});

// ২. Private Data (User Profile) - CDN যেন ক্যাশ না করে!
app.get('/profile', (req, res) => {
    // private মানে শুধু ইউজারের ব্রাউজার ক্যাশ করবে, কোনো CDN বা পাবলিক সার্ভার ক্যাশ করবে না।
    res.setHeader('Cache-Control', 'private, max-age=3600');
    res.json({ name: "Sabbir", balance: 5000 });
});

// ৩. Real-time Data (Stock Prices) - একদমই ক্যাশ করা যাবে না!
app.get('/live-stock', (req, res) => {
    // no-store মানে কোনো অবস্থাতেই কেউ এটি সেভ করে রাখবে না। সবসময় মেইন সার্ভার থেকে ফ্রেশ ডেটা নিতে হবে।
    res.setHeader('Cache-Control', 'no-store');
    res.json({ applePrice: 150.50 });
});

app.listen(3000);
```
