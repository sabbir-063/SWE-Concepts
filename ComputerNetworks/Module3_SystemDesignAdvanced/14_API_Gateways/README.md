# Chapter 14: API Gateways & Service Mesh

Welcome to Chapter 14! যখন একটি সিস্টেমে ১০০টি মাইক্রোসার্ভিস থাকে, তখন মোবাইল অ্যাপ বা ওয়েবসাইট কীভাবে বুঝবে কোন রিকোয়েস্ট কোন সার্ভিসে পাঠাতে হবে? অথবা, সার্ভিসগুলো নিজেদের মধ্যে সিকিউরভাবে কীভাবে কথা বলবে? 

এই সমস্যার সমাধান হলো **API Gateway** এবং **Service Mesh**।

---

## 1. API Gateway (এপিআই গেটওয়ে)

**API Gateway** হলো একটি রিভার্স প্রক্সি সার্ভার, যা ইউজার (Client) এবং ব্যাকএন্ড মাইক্রোসার্ভিসগুলোর ঠিক মাঝখানে বসে থাকে। ইউজার সরাসরি কোনো মাইক্রোসার্ভিসের (যেমন User Service বা Payment Service) সাথে কথা বলে না, তারা শুধু API Gateway-এর সাথে কথা বলে।

### API Gateway-এর প্রধান কাজগুলো (Features):
1. **Routing:** ইউজার `api.example.com/payment` এ হিট করলে API Gateway জানে যে এই রিকোয়েস্টটি Payment Service-এর IP অ্যাড্রেসে পাঠাতে হবে।
2. **Authentication & Authorization:** প্রতিটি মাইক্রোসার্ভিস আলাদাভাবে ইউজার লগইন চেক করার বদলে, API Gateway প্রথমেই ইউজারের টোকেন (JWT) চেক করে নেয়। টোকেন ভুল থাকলে সে রিকোয়েস্টটি সার্ভিস পর্যন্ত যেতেই দেয় না।
3. **Rate Limiting:** একজন হ্যাকার যেন এক সেকেন্ডে ১০,০০০ রিকোয়েস্ট করে সার্ভার ডাউন (DDoS) করতে না পারে, সেজন্য API Gateway রিকোয়েস্ট লিমিট করে দেয় (যেমন: "100 requests per IP per minute")।
4. **BFF (Backend for Frontend):** মোবাইল অ্যাপের জন্য কম ডেটা এবং ওয়েব অ্যাপের জন্য বেশি ডেটা প্রয়োজন হতে পারে। API Gateway ক্লায়েন্টের ডিভাইস অনুযায়ী ডেটা ফিল্টার বা এগ্রিগেট (একত্রিত) করে পাঠাতে পারে।

*জনপ্রিয় API Gateways:* **Kong**, **AWS API Gateway**, **NGINX**, **Traefik**।

### API Gateway-এর সুবিধা:
- ক্লায়েন্টকে শুধু একটি URL জানলেই হয়।
- সিকিউরিটি এবং রেট লিমিটিং একটি সেন্ট্রাল জায়গায় ম্যানেজ করা যায়।
- মাইক্রোসার্ভিসগুলো থেকে কমপ্লেক্স লজিক (লগইন চেক, রাউটিং) সরে যায়।

### API Gateway-এর অসুবিধা:
- এটি একটি **Single Point of Failure (SPOF)**। API Gateway ক্র্যাশ করলে পুরো সিস্টেম ডাউন হয়ে যাবে (তাই এটিকেও স্কেল করতে হয়)।
- একটি এক্সট্রা নেটওয়ার্ক হপ (Network hop) যোগ হওয়ায় সামান্য ল্যাটেন্সি (Latency) বাড়ে।

---

## 2. Service Mesh (সার্ভিস মেশ)

API Gateway ইউজারের (বাইরের) রিকোয়েস্টগুলো ম্যানেজ করে। কিন্তু **Service Mesh** মাইক্রোসার্ভিসগুলোর **নিজেদের ভেতরের (Internal)** যোগাযোগ ম্যানেজ করে।

ধরি, আপনার সিস্টেমে Order Service এবং Payment Service আছে। Order Service-কে Payment Service-এর সাথে কথা বলতে হবে। এখানে কিছু সমস্যা দেখা দেয়:
- Payment Service ডাউন থাকলে কী হবে? (Retry logic দরকার)।
- রিকোয়েস্ট ফেইল করলে কতক্ষণ পর পর ট্রাই করবে? (Circuit Breaker দরকার)।
- সার্ভিসগুলোর মধ্যকার ডেটা কি এনক্রিপ্টেড (mTLS)? (Security দরকার)।
- কোন সার্ভিস স্লো কাজ করছে তা কীভাবে বুঝবো? (Observability দরকার)।

এই সব লজিক যদি ডেভেলপারকে Java বা Python কোডে লিখতে হয়, তবে অনেক সময় নষ্ট হবে। **Service Mesh** এই সমস্যার সমাধান করে।

### Service Mesh কীভাবে কাজ করে? (The Sidecar Pattern)
Service Mesh প্রতিটি মাইক্রোসার্ভিসের পাশে একটি ছোট প্রক্সি সার্ভার (যাকে **Sidecar Proxy** বলা হয়) বসিয়ে দেয়।
- Order Service সরাসরি Payment Service-কে কল করে না।
- Order Service তার নিজের Sidecar-কে বলে "পেমেন্ট সার্ভিসকে ডাকো"। 
- Order Service-এর Sidecar প্রক্সি, Payment Service-এর Sidecar প্রক্সির সাথে সিকিউরভাবে (mTLS) কথা বলে। 

### Service Mesh-এর প্রধান কাজগুলো:
1. **Traffic Management:** Load balancing, Retries, Circuit Breaking।
2. **Security:** Mutual TLS (mTLS) এনক্রিপশন (সার্ভিসগুলো নিজেদের মধ্যে এনক্রিপ্টেড ডেটা আদান-প্রদান করে)।
3. **Observability:** কোন সার্ভিস কতক্ষণ সময় নিচ্ছে (Distributed Tracing), তার ম্যাট্রিক্স (Metrics) সংগ্রহ করা।

*জনপ্রিয় Service Mesh:* **Istio**, **Linkerd**, **Consul**।

---

## 3. API Gateway বনাম Service Mesh

অনেকেই এই দুটির পার্থক্য নিয়ে কনফিউজড থাকেন। খুব সহজে মনে রাখার উপায় হলো:

| ফিচার | API Gateway | Service Mesh |
| --- | --- | --- |
| **ট্রাফিক টাইপ** | North-South (বাইরের ইউজার থেকে ভেতরের সিস্টেম) | East-West (সিস্টেমের ভেতরের সার্ভিস থেকে সার্ভিস) |
| **প্রধান কাজ** | Authentication, Rate Limiting, Routing, BFF | mTLS Security, Circuit Breaker, Retries, Observability |
| **ব্যবহারকারী** | Client (Web/Mobile App) | Internal Microservices |
| **উদাহরণ** | Kong, AWS API Gateway | Istio, Linkerd |

---

## Summary
- **API Gateway:** আপনার সিস্টেমের "Front Door" বা সদর দরজা। ইউজাররা এটি দিয়েই প্রবেশ করে। এটি সিকিউরিটি গার্ডের মতো টোকেন চেক করে এবং সঠিক দরজায় (সার্ভিসে) পাঠিয়ে দেয়।
- **Service Mesh:** এটি সিস্টেমের ভেতরের "Intercom" বা ওয়াকিটকি। সার্ভিসগুলো একে অপরের সাথে যোগাযোগ করার জন্য এটি ব্যবহার করে। এটি নিশ্চিত করে যে ভেতরের যোগাযোগ ১০০% সিকিউর এবং ফেইল-সেফ।
- **Sidecar Pattern:** Service Mesh-এর একটি ডিজাইন যেখানে মূল কোডের পাশে একটি ছোট প্রক্সি সার্ভার চালানো হয়, যেন নেটওয়ার্কিংয়ের সমস্ত কাজ ওই প্রক্সি করতে পারে।

দারুন! আপনি এখন মাইক্রোসার্ভিসের নেটওয়ার্কিং নিয়ে মাস্টার হয়ে গেছেন! চলুন এবার Quiz.md ফাইলে গিয়ে আপনার জ্ঞান যাচাই করে নিই।
