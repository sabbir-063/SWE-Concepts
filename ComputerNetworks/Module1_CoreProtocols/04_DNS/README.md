# Chapter 4: Domain Name System (DNS)

Welcome to Chapter 4! In previous chapters, we learned how devices communicate using IP addresses. But humans are not good at remembering numbers like `142.250.190.46`. Instead, we remember names like `google.com`. 

**DNS (Domain Name System)** হলো ইন্টারনেটের ফোনবুক। এটি মানুষের বোধগম্য ডোমেইন নামকে (যেমন: facebook.com) মেশিনের বোধগম্য IP Address-এ রূপান্তর করে।

---

## 1. DNS Hierarchy (DNS হায়ারার্কি)

ইন্টারনেটে বিলিয়ন বিলিয়ন ওয়েবসাইট আছে। এতগুলো ওয়েবসাইটের রেকর্ড কোনো একটা সিঙ্গেল সার্ভারে রাখা সম্ভব নয়। তাই DNS একটি ডিস্ট্রিবিউটেড এবং হায়ারার্কিক্যাল (Tree structure) সিস্টেমে কাজ করে।

DNS হায়ারার্কির প্রধান তিনটি লেভেল আছে:

### 1.1 Root Name Servers
এটি হলো DNS ট্রির একদম উপরের লেভেল। সারাবিশ্বে ১৩টি লজিক্যাল রুট সার্ভার ক্লাস্টার আছে (A থেকে M পর্যন্ত)। রুট সার্ভার কোনো নির্দিষ্ট ওয়েবসাইটের আইপি জানে না, কিন্তু সে জানে কোন TLD (Top-Level Domain) সার্ভারের কাছে যেতে হবে।
- *যেমন: `com`, `net`, `org`, `bd` এর TLD সার্ভারের ঠিকানা রুট সার্ভার জানে।*

### 1.2 TLD (Top-Level Domain) Servers
TLD সার্ভার ডোমেইনের শেষের অংশগুলো মেইনটেইন করে। যেমন: `.com`, `.net`, `.edu`, `.gov`।
- *আপনি যখন `google.com` খোঁজেন, তখন `.com` TLD সার্ভার আপনাকে বলে দেয় যে `google` এর Authoritative Server কোথায় আছে।*

### 1.3 Authoritative Name Servers
এটি হলো চূড়ান্ত গন্তব্য। একটি নির্দিষ্ট ডোমেইনের (যেমন `google.com`) অরিজিনাল আইপি অ্যাড্রেস এই সার্ভারেই সেভ করা থাকে। ডোমেইন কেনার পর আমরা যে Nameserver (NS) সেট করি, সেটাই হলো Authoritative Server।

**Hierarchy Example:**
```text
                     [ Root (.) ]
                    /      |      \
                 .com    .net    .org   <-- TLD Servers
                 /         |
             google      cisco            <-- Authoritative Servers
```

---

## 2. DNS Query Resolution Process (কিভাবে কাজ করে?)

আপনি যখন ব্রাউজারে `www.example.com` লিখে এন্টার দেন, তখন ব্যাকগ্রাউন্ডে কী ঘটে?

### Step-by-step Process:
1. **Browser & OS Cache:** প্রথমে ব্রাউজার তার নিজের ক্যাশে চেক করে আইপিটা আছে কিনা। না থাকলে OS (Operating System) এর ক্যাশ চেক করে।
2. **DNS Resolver (ISP):** OS ক্যাশে না পেলে, রিকোয়েস্টটি আপনার ইন্টারনেটের (ISP) DNS Resolver-এর কাছে যায়। একে **Recursive Resolver**-ও বলে।
3. **Root Server:** Resolver-এর কাছেও আইপি না থাকলে, সে **Root Server**-কে জিজ্ঞেস করে: "ভাই, `example.com`-এর আইপি জানো?"
4. **TLD Server:** Root Server বলে, "আমি জানি না, তবে এটি একটি `.com` ডোমেইন। তুমি **.com TLD Server**-কে জিজ্ঞেস করো।"
5. **Authoritative Server:** Resolver এবার TLD Server-কে জিজ্ঞেস করে। TLD Server বলে, "আমি `example.com`-এর Authoritative Server-এর ঠিকানা জানি। তুমি ওকে জিজ্ঞেস করো।"
6. **Final IP:** Resolver এবার Authoritative Server-কে জিজ্ঞেস করে। সে ফাইনালি `example.com`-এর আসল আইপি অ্যাড্রেসটা Resolver-কে দেয়।
7. **Return & Cache:** Resolver আইপিটা আপনার ব্রাউজারকে দেয় এবং নিজের কাছে ক্যাশ করে রাখে যেন ভবিষ্যতে আবার এতদূর ঘুরতে না হয়।

### Recursive vs Iterative Query
- **Recursive Query:** ক্লায়েন্ট Resolver-কে রিকোয়েস্ট দেয় এবং Resolver পুরো দায়িত্ব নেয় আইপিটা খুঁজে বের করার। (ক্লায়েন্ট থেকে Resolver-এর রিকোয়েস্ট)।
- **Iterative Query:** Resolver যখন Root, TLD এবং Authoritative-কে জিজ্ঞেস করে, তখন তারা পুরো উত্তর না দিয়ে পরের জনের ঠিকানা দিয়ে দেয়। (Resolver থেকে অন্যান্য সার্ভারের রিকোয়েস্ট)।

---

## 3. DNS Records (DNS রেকর্ডসমূহ)

DNS শুধু আইপি অ্যাড্রেস রাখে না, আরো অনেক ধরণের ডেটা রাখে। এগুলোকে DNS Records বলে।

| Record Type | Full Meaning | Purpose (কাজ) | Example |
| :--- | :--- | :--- | :--- |
| **A** | Address | ডোমেইন নামকে **IPv4** অ্যাড্রেসে ম্যাপ করে। | `example.com -> 192.0.2.1` |
| **AAAA** | Quad-A | ডোমেইন নামকে **IPv6** অ্যাড্রেসে ম্যাপ করে। | `example.com -> 2001:db8::1` |
| **CNAME** | Canonical Name | একটি ডোমেইনকে অন্য একটি ডোমেইনের দিকে পয়েন্ট করে (Alias)। | `www.example.com -> example.com` |
| **MX** | Mail Exchange | ইমেইল রিসিভ করার জন্য মেইল সার্ভারের ঠিকানা বলে দেয়। | `mail.example.com` |
| **TXT** | Text | ওয়েবসাইটের সাথে টেক্সট ডেটা রাখার জন্য (যেমন: Security, SPF, DKIM verification)। | `v=spf1 include:_spf.google.com ~all` |
| **NS** | Name Server | ডোমেইনটির Authoritative Server কারা, তা নির্দিষ্ট করে দেয়। | `ns1.cloudflare.com` |

> **Note:** CNAME রেকর্ড কখনো রুট ডোমেইনে (যেমন `example.com`) বসানো যায় না, শুধু সাবডোমেইনে (যেমন `www.example.com`) বসানো যায়।

---

## 4. DNS Caching and Propagation

DNS কোয়েরি প্রসেসটি কিছুটা সময়সাপেক্ষ। তাই স্পিড বাড়ানোর জন্য **Caching** ব্যবহার করা হয়।

### 4.1 Caching Levels
1. **Browser Cache:** ব্রাউজার কিছুক্ষণের জন্য আইপি সেভ করে রাখে।
2. **OS Cache:** অপারেটিং সিস্টেম (যেমন: Windows-এর `ipconfig /displaydns`) আইপি ক্যাশ করে রাখে।
3. **Resolver Cache:** আপনার রাউটার বা ইন্টারনেট প্রোভাইডারের (ISP) DNS সার্ভার আইপি ক্যাশ করে রাখে।

### 4.2 TTL (Time to Live)
ক্যাশ কতক্ষণ থাকবে তা **TTL** দিয়ে ঠিক করা হয়। TTL হলো সেকেন্ডের হিসেব (যেমন: ৩০০০ সেকেন্ড)। TTL শেষ হলে ক্যাশ মুছে যায় এবং নতুন করে আইপি খুঁজতে হয়।

### 4.3 DNS Propagation
আপনি যখন কোনো ওয়েবসাইটের সার্ভার বা আইপি চেঞ্জ করেন, তখন সারাবিশ্বের সব DNS ক্যাশ আপডেট হতে কিছুটা সময় লাগে (সাধারণত কয়েক ঘন্টা থেকে ৪৮ ঘন্টা)। এই আপডেট হওয়ার সময়টাকেই **DNS Propagation** বলে।

---

## Summary
- **DNS** হলো ইন্টারনেটের ফোনবুক।
- **Hierarchy:** Root -> TLD -> Authoritative.
- **Resolver** হলো সেই ব্যক্তি যে আপনার হয়ে আইপি খুঁজে নিয়ে আসে।
- **A Record** (IPv4), **AAAA Record** (IPv6), **CNAME** (Alias), **MX** (Email).
- **TTL** নির্ধারণ করে কতক্ষণ ডেটা ক্যাশে সেভ থাকবে।

এখন আপনি DNS-এর কনসেপ্ট ক্লিয়ার! চলুন এবার Quiz.md ফাইলে গিয়ে আপনার জ্ঞান যাচাই করে নিই।
