# 02. Load Balancing & CDN (Practice MCQs)

This file contains 40 in-depth MCQs covering Load Balancers, L4 vs L7 routing, Load Balancing Algorithms (Round Robin, Least Connections, IP Hash), Content Delivery Networks (CDNs), Edge computing, and Caching strategies.

---

**Q1. What is the primary purpose of a Load Balancer?**
A) To encrypt database passwords
B) To distribute incoming network traffic across multiple backend servers to prevent any single server from becoming a bottleneck (overloaded)
C) To compress image files on the website
D) To prevent users from accessing the website

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: লোড ব্যালান্সারের মূল কাজই হলো ইউজারদের রিকোয়েস্টগুলোকে অনেকগুলো সার্ভারের মধ্যে সুন্দরভাবে ভাগ করে দেওয়া, যাতে কোনো একটি সার্ভার ওভারলোডেড হয়ে ক্র্যাশ না করে।
</details>

---

**Q2. Which scaling approach inherently relies on a Load Balancer to function properly?**
A) Vertical Scaling (Scaling Up)
B) Horizontal Scaling (Scaling Out)
C) Diagonal Scaling
D) Database Normalization

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Horizontal Scaling এ আমরা নতুন নতুন সার্ভার (Node) যোগ করি। এতগুলো সার্ভারের মধ্যে ট্রাফিক ভাগ করে দেওয়ার জন্য লোড ব্যালান্সার মাস্ট লাগে।
</details>

---

**Q3. How does the "Round Robin" load balancing algorithm work?**
A) It sends all traffic to the fastest server
B) It distributes requests sequentially to the servers in a circular order (e.g., Server 1, then 2, then 3, then back to 1)
C) It sends traffic only to the server with the least active connections
D) It randomly picks a server

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি সবচেয়ে সিম্পল অ্যালগরিদম। সিরিয়াল অনুযায়ী একেক জনকে একেকটি রিকোয়েস্ট দেয়। সবার সাইজ বা ক্যাপাসিটি সেম থাকলে এটি খুব ভালো কাজ করে।
</details>

---

**Q4. When is the "Least Connections" load balancing algorithm heavily preferred over Round Robin?**
A) When all incoming requests take the exact same amount of time to process
B) When there are long-lived connections (like WebSockets, Chat Apps, or heavy database queries), causing some servers to accumulate significantly more active load than others over time
C) When the servers are all identical
D) When dealing purely with static HTML files

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: চ্যাট অ্যাপে একজন ইউজার হয়তো ৩ ঘণ্টা ধরে কানেক্টেড থাকতে পারে। রাউন্ড রবিন দিলে দেখা যাবে একজনের ঘাড়ে সব ভারী ইউজার পড়ে গেছে। তাই যার কাছে কানেকশন কম, তাকে নতুন রিকোয়েস্ট দেওয়া (Least Connections) বেস্ট।
</details>

---

**Q5. What does the "IP Hash" algorithm do?**
A) It hashes the server's IP address to hide it
B) It takes the client's IP address, applies a hash function, and uses the result to always route that specific client to the exact same backend server
C) It encrypts the user's IP
D) It routes traffic based on the HTTP headers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউজারের আইপি হ্যাস করে সার্ভার সিলেক্ট করা হয়। এর মানে হলো, আপনি যতক্ষণ ওই আইপি থেকে ব্রাউজ করবেন, আপনি সবসময় সার্ভার-১ এই যাবেন (আপনার সেশন বা লগইন স্টেট ঠিক থাকবে)।
</details>

---

**Q6. What is the primary drawback of using the "IP Hash" algorithm?**
A) It is very slow
B) It requires a lot of RAM
C) If many users are behind the same NAT/Router (e.g., a corporate office with one public IP), one server will receive a massive spike in traffic while others sit idle, destroying the balance
D) It does not work on HTTPS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: একটি অফিসের ১০০ জন মানুষের পাবলিক আইপি সেম হতে পারে। IP Hash ইউজ করলে ওই ১০০ জনই একটিমাত্র সার্ভারে গিয়ে পড়বে, ফলে লোড ব্যালান্সিং ফেইল করবে।
</details>

---

**Q7. What is "Weighted Round Robin"?**
A) Assigning heavier servers to the front
B) Assigning a "weight" (priority/capacity) to each server so that more powerful servers receive a proportionally larger share of the traffic (e.g., Server A gets 3 requests for every 1 request Server B gets)
C) Using machine learning to guess the server load
D) A method only used for databases

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আপনার যদি একটি সার্ভার 32GB র‍্যামের এবং আরেকটি 8GB র‍্যামের হয়, তবে 32GB সার্ভারকে বেশি ওয়েট (Weight) দিয়ে দিলে সে বেশি রিকোয়েস্ট পাবে।
</details>

---

**Q8. What does a "Layer 4 (L4) Load Balancer" operate on?**
A) The Transport Layer (TCP/UDP); it makes routing decisions purely based on IP addresses and Port numbers without looking at the actual data payload
B) The Application Layer (HTTP); it reads cookies
C) The Physical Layer (Cables)
D) The Presentation Layer

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: OSI মডেলের লেয়ার ৪ হলো ট্রান্সপোর্ট লেয়ার। এটি শুধু দেখে রিকোয়েস্ট কোথা থেকে এসেছে (IP) এবং কোথায় যাবে (Port)। ভেতরে কী ডেটা আছে তা সে পড়ে না।
</details>

---

**Q9. Which load balancer type can read the HTTP URL (e.g., `/images` vs `/api`) and route the traffic to completely different specialized server groups based on that URL?**
A) Layer 2 Switch
B) Layer 3 Router
C) Layer 4 Load Balancer
D) Layer 7 Load Balancer

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: Layer 7 (Application Layer) লোড ব্যালান্সার প্যাকেটের ভেতরের আসল ডেটা (URL, Headers, Cookies) পড়তে পারে, তাই সে স্মার্ট ডিসিশন (Microservices routing) নিতে পারে।
</details>

---

**Q10. Why is Layer 4 load balancing generally faster than Layer 7?**
A) Because it is newer technology
B) Because it uses fiber optics
C) Because it doesn't have to decrypt the SSL/TLS traffic or inspect the deep application data payload; it simply forwards the packets
D) Because it skips the network entirely

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: L4 যেহেতু ডেটা পড়ে না বা ডিক্রিপ্ট করে না, তাই তার প্রসেসিং টাইম অনেক কম লাগে (অনেক ফাস্ট)।
</details>

---

**Q11. What is "SSL Termination" (or SSL Offloading) on a Load Balancer?**
A) When the SSL certificate expires
B) The load balancer handles the heavy CPU work of decrypting HTTPS traffic from the client, and then forwards the plain HTTP traffic to the backend servers in the private network, saving server resources
C) Terminating hackers
D) Upgrading SSL to TLS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এনক্রিপ্ট/ডিক্রিপ্ট করা সার্ভারের জন্য অনেক কষ্টের কাজ। তাই লোড ব্যালান্সার নিজেই এনক্রিপশনের কাজটা করে দেয় এবং পেছনের সার্ভারগুলোকে নরমাল প্লেইন টেক্সট পাঠায় (যেহেতু ভেতরের নেটওয়ার্ক সেফ)।
</details>

---

**Q12. What does CDN stand for?**
A) Centralized Data Node
B) Content Delivery Network
C) Computer Directed Network
D) Cached Data Network

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: CDN (Content Delivery Network) হলো সারা পৃথিবীতে ছড়িয়ে থাকা সার্ভার নেটওয়ার্ক যা ইউজারকে দ্রুত কন্টেন্ট ডেলিভারি দেয়।
</details>

---

**Q13. What is the primary purpose of a CDN?**
A) To execute complex backend Python scripts
B) To reduce Latency by caching static assets (like images, CSS, JS) on globally distributed "Edge Servers" geographically closer to the end-users
C) To store primary SQL databases
D) To prevent SQL Injection

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: মেইন সার্ভার আমেরিকায় থাকলেও CDN এর সার্ভার (Edge) বাংলাদেশে থাকে। তাই বাংলাদেশের ইউজাররা চোখের পলকে (Low latency) ছবি বা ভিডিও দেখতে পায়।
</details>

---

**Q14. In CDN terminology, what is an "Edge Server"?**
A) A server that is about to crash
B) The main centralized database server
C) A server in the CDN network located at the "edge" of the internet, physically as close to the local user populations (ISPs) as possible
D) A server used only for AI processing

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Edge (প্রান্ত) মানে হলো ইউজারের খুব কাছাকাছি থাকা সার্ভার (যেমন ঢাকার কোনো ডেটাসেন্টারে বসা ক্লাউডফ্লেয়ারের সার্ভার)।
</details>

---

**Q15. What is the "Origin Server" in a CDN setup?**
A) The very first server ever built
B) The user's laptop
C) The central, original backend server that holds the master copy of all the files and database (where the CDN goes to fetch data if it doesn't have it cached)
D) A DNS router

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Edge সার্ভারের কাছে কোনো ফাইল না থাকলে সে যার কাছ থেকে আসল ফাইলটি চেয়ে নিয়ে আসে, তাকেই Origin Server বলে (অর্থাৎ আপনার নিজের কোম্পানির মেইন সার্ভার)।
</details>

---

**Q16. What happens during a "Cache Miss" at a CDN Edge Server?**
A) The CDN immediately returns a 404 Error
B) The CDN contacts the Origin Server, retrieves the requested file, sends it to the user, and saves (caches) a copy locally for future users
C) The CDN crashes
D) The user is banned

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ক্যাশ মিস মানে হলো Edge সার্ভারে ফাইলটি নেই। তখন সে Origin এর কাছ থেকে ফাইলটা এনে ইউজারকে দেয় এবং নিজের কাছে একটা কপি রেখে দেয় (যাতে নেক্সট টাইম আর Origin এ যেতে না হয়)।
</details>

---

**Q17. Which of the following file types is perfectly suited to be heavily cached by a CDN?**
A) A user's live bank account balance JSON response
B) The real-time chat history of a WhatsApp conversation
C) A 5MB static `.mp4` background video file for a landing page
D) An Admin dashboard showing live server metrics

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ভিডিও, ইমেজ, ফন্ট—এগুলো স্ট্যাটিক ফাইল। এগুলো সহজে চেঞ্জ হয় না এবং সবার জন্য সেম থাকে। তাই এগুলো CDN এ ক্যাশ করা বেস্ট।
</details>

---

**Q18. Why is it generally a terrible idea to aggressively cache Dynamic API responses (like `/api/user/profile`) on a public CDN?**
A) CDNs cannot read JSON
B) Because one user's private sensitive data (e.g., name, email, balance) might be cached and accidentally shown to the next user who visits that endpoint (Data Leak/Privacy Violation)
C) Because API responses are too large
D) It slows down the CDN

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডাইনামিক বা পার্সোনাল ডেটা পাবলিক CDN এ ক্যাশ করলে এক ইউজারের ব্যাংক ব্যালান্স অন্য ইউজার দেখে ফেলতে পারে, যা একটি মারাত্মক সিকিউরিটি রিস্ক!
</details>

---

**Q19. What is "Time to Live" (TTL) in caching?**
A) The lifespan of the server hardware
B) The amount of time (usually in seconds) a cached file is considered "fresh" or valid before the CDN or browser must delete it and check the Origin Server for an updated version
C) The time it takes to ping a server
D) The maximum length of a video on CDN

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: TTL (বা max-age) বলে দেয় যে ফাইলটি কতক্ষণ ভ্যালিড থাকবে। TTL শেষ হয়ে গেলে CDN ধরে নেয় ফাইলটি এক্সপায়ার্ড এবং সে আবার Origin থেকে নতুন কপি নিয়ে আসে।
</details>

---

**Q20. Which HTTP Header is primarily used by the Origin Server to dictate exactly how and for how long CDNs and browsers should cache a response?**
A) `Authorization`
B) `Content-Type`
C) `Cache-Control`
D) `X-Forwarded-For`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: `Cache-Control` হেডার (যেমন `Cache-Control: max-age=3600`) দিয়ে সার্ভার বলে দেয় যে ক্লায়েন্ট বা CDN এই ফাইলটি কতক্ষণ ক্যাশ করে রাখবে।
</details>

---

**Q21. What does `Cache-Control: public` signify?**
A) The data is unencrypted
B) The response can be safely cached by ANY intermediary, including public CDNs, proxies, and the end-user's browser
C) The server is open to the public
D) It means the API does not require authentication

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `public` মানে হলো এটি একটি সাধারণ ফাইল (যেমন লোগো বা CSS)। রাস্তার মাঝখানে থাকা যেকোনো রাউটার বা CDN এটিকে ক্যাশ করে রাখতে পারে।
</details>

---

**Q22. What does `Cache-Control: private` signify?**
A) The response is encrypted with a private key
B) The response contains user-specific private data; it MUST NOT be cached by public CDNs or proxies, but the end-user's personal browser is allowed to cache it locally
C) It cannot be cached by anything
D) It hides the IP address

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `private` মানে হলো এটি শুধু ওই নির্দিষ্ট ইউজারের জন্যই। ইউজারের নিজের ব্রাউজার এটি সেভ রাখতে পারবে, কিন্তু কোনো পাবলিক CDN এটি ক্যাশ করতে পারবে না।
</details>

---

**Q23. If you are building a real-time stock market dashboard, which Cache-Control directive guarantees that the browser and CDN will NEVER cache the data, always fetching fresh prices?**
A) `Cache-Control: public, max-age=0`
B) `Cache-Control: no-store`
C) `Cache-Control: private`
D) `Cache-Control: keep-alive`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `no-store` হলো সবচেয়ে কড়া নির্দেশ। এর মানে হলো "ভুল করেও মেমোরি বা হার্ডডিস্কে এই ডেটা সেভ করবা না, সবসময় ফ্রেশ ডেটা আনবা"।
</details>

---

**Q24. What is a "Health Check" (or Heartbeat) performed by a Load Balancer?**
A) Checking if the server has an active antivirus
B) Periodically sending quick requests (like a ping or `GET /health`) to backend servers to ensure they are alive. If a server fails, the load balancer temporarily stops sending traffic to it.
C) Monitoring the user's internet speed
D) A database backup process

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: লোড ব্যালান্সার মাঝে মাঝেই পেছনের সার্ভারগুলোকে নক করে দেখে তারা বেঁচে আছে কি না। কেউ ডেড (Dead) হয়ে গেলে তাকে ট্রাফিক দেওয়া বন্ধ করে দেয় (High Availability নিশ্চিত করে)।
</details>

---

**Q25. NGINX is widely used as: **
A) A web browser
B) An operating system
C) A highly performant Web Server, Reverse Proxy, and Load Balancer
D) A NoSQL database

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: NGINX পৃথিবীর অন্যতম সেরা একটি ওয়েব সার্ভার, যা মেইনলি রিভার্স প্রক্সি এবং লেয়ার ৭ লোড ব্যালান্সার হিসেবে ব্যাপকভাবে ব্যবহৃত হয়।
</details>

---

**Q26. What is the purpose of the `X-Forwarded-For` HTTP header in a load balancing scenario?**
A) To forward emails
B) Because a Load Balancer acts as a middleman, the backend server only sees the Load Balancer's IP. The Load Balancer injects the original user's IP into `X-Forwarded-For` so the backend server knows who actually made the request.
C) To skip the cache
D) To redirect HTTP to HTTPS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: লোড ব্যালান্সার যেহেতু ইউজারের পক্ষ হয়ে সার্ভারকে রিকোয়েস্ট পাঠায়, তাই সার্ভার মনে করে রিকোয়েস্ট লোড ব্যালান্সারের কাছ থেকে এসেছে। আসল ইউজারের আইপি সার্ভারকে জানানোর জন্যই এই হেডার ব্যবহার করা হয়।
</details>

---

**Q27. How does a CDN mitigate Distributed Denial of Service (DDoS) attacks?**
A) By shutting down the origin server immediately
B) By reporting the attackers to the police
C) CDNs have massive global bandwidth and built-in scrubbing centers. They absorb the massive flood of junk traffic at the "Edge", protecting the Origin Server from ever seeing the load and crashing.
D) By encrypting the DDoS traffic

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ক্লাউডফ্লেয়ার (Cloudflare) এর মতো CDN গুলোর বিশাল ব্যান্ডউইথ থাকে। হ্যাকাররা বট দিয়ে অ্যাটাক করলে সেই ট্রাফিকগুলো Edge সার্ভারেই আটকে যায়, ফলে আসল সার্ভার বেঁচে যায়।
</details>

---

**Q28. What is "Cache Invalidation" (or Cache Purging)?**
A) Deleting the database
B) The difficult process of explicitly telling the CDN to delete a cached file before its TTL expires, usually because a developer just updated that file (like a new CSS file) and wants users to see it immediately
C) An error thrown by the browser
D) Clearing browser cookies

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আপনি ওয়েবসাইটের ডিজাইন চেঞ্জ করলেন, কিন্তু CDN এ এখনো পুরনো CSS ফাইল ক্যাশ করা আছে। তখন ম্যানুয়ালি বা API দিয়ে ওই ক্যাশ ডিলিট করে দেওয়াকেই Cache Invalidation বলে। এটি ডিস্ট্রিবিউটেড সিস্টেমের অন্যতম কঠিন একটি কাজ!
</details>

---

**Q29. To completely avoid the headache of Cache Invalidation for static assets (CSS/JS), what is the most common modern web development practice (often done by Webpack/Vite)?**
A) Disabling caching entirely
B) Cache Busting: Appending a unique hash to the filename on every build (e.g., `main.a4b9f.css`). The CDN sees a brand-new URL and fetches the new file instantly.
C) Rebooting the CDN servers
D) Using XML instead of HTML

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফ্রেমেওয়ার্কগুলো (React/Angular) বিল্ড করার সময় CSS/JS ফাইলের নামের শেষে একটি র‍্যান্ডম হ্যাশ জুড়ে দেয়। নাম চেঞ্জ হয়ে যাওয়ায় CDN এটিকে নতুন ফাইল মনে করে এবং পুরনো ক্যাশ নিয়ে কোনো ঝামেলা হয় না। একে Cache Busting বলে।
</details>

---

**Q30. What is an "Anycast" network routing protocol, commonly used by CDNs?**
A) Broadcasting data to all users simultaneously
B) Multiple globally distributed servers share the exact same IP address. The internet's BGP routing automatically sends the user's request to the server physically closest to them.
C) Routing traffic through satellites
D) Converting IPv4 to IPv6

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Anycast এর ম্যাজিক হলো, ক্লাউডফ্লেয়ারের আমেরিকার সার্ভারের আইপিও `1.1.1.1`, আবার ঢাকার সার্ভারের আইপিও `1.1.1.1`। রাউটার অটোমেটিক্যালি আপনাকে সবচেয়ে কাছের সার্ভারটিতে (ঢাকায়) পাঠিয়ে দেবে।
</details>

---

**Q31. Which of the following is an example of a popular modern CDN provider?**
A) Redis
B) PostgreSQL
C) Cloudflare
D) React

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Cloudflare, AWS CloudFront, Fastly, Akamai—এগুলো হলো পৃথিবীর সবচেয়ে পপুলার CDN।
</details>

---

**Q32. Can a Load Balancer be a hardware device, or is it strictly software (like NGINX)?**
A) It is strictly software
B) It is strictly hardware
C) Historically they were expensive hardware appliances (like F5 Networks BIG-IP), but today software load balancers (NGINX, HAProxy) and cloud load balancers (AWS ALB) are overwhelmingly popular
D) They are just network cables

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: আগে বড় বড় ফিজিক্যাল মেশিন (Hardware) কিনে লোড ব্যালান্সিং করা হতো। এখন NGINX বা AWS এর মাধ্যমে সফটওয়্যার দিয়েই অনেক ভালোভাবে এই কাজ করা যায়।
</details>

---

**Q33. What is "Session Persistence" (or Sticky Sessions) on a Load Balancer?**
A) Saving user data to a hard drive
B) Configuring the load balancer to remember a user (usually via injecting a Cookie) and route all their subsequent requests to the SAME backend server for the duration of their session
C) Keeping the load balancer turned on 24/7
D) Persisting the database schema

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: IP Hash এর মতোই, এটি ইউজারের ব্রাউজারে একটি কুকি (Cookie) সেট করে দেয়। ফলে ইউজার লগইন করার পর সবসময় একই সার্ভারেই যায় (Sticky), অন্য সার্ভারে গিয়ে লগআউট হয়ে যায় না।
</details>

---

**Q34. Why do modern Microservice architectures often prefer stateless backends over Sticky Sessions?**
A) Because sticky sessions violate HTML5 rules
B) If the backend server holding a user's sticky session crashes, the user gets logged out abruptly. Stateless servers (where session data is stored in a centralized Redis cache) allow any server to handle any request safely.
C) Stateless backends are harder to hack
D) Sticky sessions use too much bandwidth

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Sticky Session ইউজ করলে, ওই নির্দিষ্ট সার্ভারটি ক্র্যাশ করলে ইউজারের সব ডেটা হারিয়ে যাবে। তাই আধুনিক সিস্টেমে সার্ভারে কোনো ডেটা (State) না রেখে, সেটি Redis ডাটাবেসে রাখা হয়, যাতে যেকোনো সার্ভার কাজ করতে পারে।
</details>

---

**Q35. What does the HTTP header `ETag` (Entity Tag) do in caching?**
A) It tracks user analytics
B) It acts as a unique fingerprint/version-hash for a file. The browser sends it back to the server in an `If-None-Match` header. If the file hasn't changed, the server replies with a tiny `304 Not Modified` to save bandwidth.
C) It encrypts the HTML body
D) It routes traffic to the Edge server

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ETag হলো ফাইলের একটি হ্যাশ। ব্রাউজার সার্ভারকে বলে, "আমার কাছে XYZ হ্যাশের ফাইল আছে, নতুন কিছু কি এসেছে?" সার্ভার চেক করে দেখে ফাইল চেঞ্জ হয়নি, তখন সে পুরো ফাইল না পাঠিয়ে শুধু `304 Not Modified` স্ট্যাটাস পাঠিয়ে দেয়। এতে প্রচুর ডেটা বাঁচে।
</details>

---

**Q36. [Code Logic] In NGINX, what does the `upstream` block do?**
A) It upgrades the HTTP version
B) It defines a logical group of backend servers that the load balancer can route traffic to
C) It blocks bad IP addresses
D) It streams video files

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `upstream` ব্লক দিয়ে আমরা ব্যাকএন্ড সার্ভারগুলোর একটি লিস্ট বা গ্রুপ বানাই (যেমন ৩টি Node.js সার্ভারের IP)।
</details>

---

**Q37. Which load balancing algorithm is best for a scenario where backend servers have VASTLY different hardware specs (e.g., one 32GB RAM server and two 4GB RAM servers)?**
A) Round Robin
B) IP Hash
C) Weighted Round Robin or Least Connections
D) Random

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: সার্ভারের সাইজ ভিন্ন হলে Round Robin ইউজ করলে ছোট সার্ভার ক্র্যাশ করবে। তাই Weighted দিয়ে বড় সার্ভারকে বেশি কাজ দেওয়া হয়, অথবা Least Connection দিয়ে অটোমেটিক লোড ব্যালান্স করা হয়।
</details>

---

**Q38. What is a "Reverse Proxy"?**
A) A proxy used by a client to hide their IP from the internet (like a VPN)
B) A proxy that sits in front of backend servers and intercepts incoming client requests, providing load balancing, security, and caching (NGINX is a classic example)
C) A proxy that reverses strings
D) A database backup proxy

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সাধারণ Proxy ক্লায়েন্টকে লুকিয়ে রাখে (যেমন VPN)। আর Reverse Proxy সার্ভারকে লুকিয়ে রাখে। ক্লায়েন্ট কখনোই পেছনের আসল সার্ভারগুলোকে দেখতে পায় না, সে শুধু Reverse Proxy (Nginx) এর সাথেই কথা বলে।
</details>

---

**Q39. Can a CDN execute backend logic (like User Authentication or modifying HTTP headers) right at the Edge?**
A) No, CDNs only serve static files
B) Historically no, but modern CDNs offer "Edge Computing" (like Cloudflare Workers or AWS Lambda@Edge) which allows running small JavaScript/WASM functions directly on the edge servers for extreme low-latency processing
C) Yes, but it requires PHP
D) Only if the origin server is offline

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একেই বলে Edge Computing! এখন আর CDN শুধু ফাইল দেয় না, তারা ক্লাউডফ্লেয়ার ওয়ার্কার (Cloudflare Workers) এর মাধ্যমে মেইন সার্ভারে যাওয়ার আগেই Edge সার্ভারেই ছোটখাটো লজিক বা সিকিউরিটি চেক রান করতে পারে।
</details>

---

**Q40. [Conclusion] If your application users complain about slow page loads in Australia while your server is in New York, what is the single most effective architectural upgrade?**
A) Add more CPU to the New York server
B) Implement a Load Balancer in New York
C) Integrate a global CDN to cache your static assets at Edge servers in Australia
D) Switch from SQL to NoSQL

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: দূরত্বের কারণে হওয়া ল্যাটেন্সি (Latency) কমানোর একমাত্র উপায় হলো ইউজারের কাছাকাছি ডেটা নিয়ে যাওয়া। আর এই কাজটিই CDN সবচেয়ে ভালোভাবে করে।
</details>
