# 01. HTTP Headers & Caching (Practice MCQs)

This file contains 40 in-depth MCQs covering HTTP Request and Response Headers, Caching mechanisms, `Cache-Control` directives, ETag, `If-None-Match`, and the `304 Not Modified` status code.

---

**Q1. What are HTTP Headers?**
A) The `<head>` tag in an HTML document
B) Key-value pairs sent in HTTP requests and responses that contain metadata about the transaction, such as content type, caching policies, and authentication tokens.
C) The title of a webpage
D) The top navigation bar of a website

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: HTTP Headers হলো ক্লায়েন্ট এবং সার্ভারের মধ্যে আদান-প্রদান করা গোপন মেসেজ বা মেটাডেটা। এরা ডেটা সম্পর্কে অতিরিক্ত তথ্য দেয় (যেমন: ডেটার সাইজ কত, ক্যাশ হবে কি না)।
</details>

---

**Q2. Which of the following is typically a Request Header (sent by the client)?**
A) `Content-Length`
B) `Server`
C) `User-Agent`
D) `Set-Cookie`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: `User-Agent` হেডারটি ব্রাউজার পাঠায় (Request), যাতে সার্ভার বুঝতে পারে যে রিকোয়েস্টটি Chrome থেকে এসেছে নাকি Safari থেকে এসেছে। বাকিগুলো সার্ভার পাঠায় (Response)।
</details>

---

**Q3. Which of the following is typically a Response Header (sent by the server)?**
A) `Accept-Language`
B) `Set-Cookie`
C) `Authorization`
D) `Host`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সার্ভার `Set-Cookie` হেডার পাঠিয়ে ক্লায়েন্টকে নির্দেশ দেয় যে "এই কুকিটা তোমার ব্রাউজারে সেভ করে রাখো"। এটি একটি Response হেডার।
</details>

---

**Q4. What is the purpose of the `Content-Type` header?**
A) To define the keyboard language
B) To tell the receiver what kind of data format is being sent in the body (e.g., `application/json` or `text/html`), so the receiver knows how to parse it.
C) To compress the data
D) To encrypt the payload

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `Content-Type` বলে দেয় যে বডিতে থাকা ডেটাটি আসলে কী! এটি কি একটি ছবি, নাকি JSON, নাকি HTML? এটি দেখে ব্রাউজার ঠিক করে সে ডেটাটিকে কীভাবে স্ক্রিনে দেখাবে।
</details>

---

**Q5. Where should a client typically place a JWT (JSON Web Token) when making an API request?**
A) In the URL query string
B) In the `Authorization` request header, usually prefixed with the word `Bearer `
C) In the HTML body
D) In the `Content-Type` header

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সিকিউরিটির জন্য লগইন টোকেন বা JWT সবসময় Request Header এর `Authorization: Bearer <token>` ফিল্ডে পাঠাতে হয়।
</details>

---

**Q6. What does the `Accept` request header do?**
A) It accepts terms and conditions
B) It tells the server what media types (e.g., `application/json`, `image/png`) the client is able to understand and prefers to receive in the response.
C) It accepts cookies automatically
D) It tells the server the client's IP address

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ক্লায়েন্ট (ব্রাউজার) `Accept` হেডার পাঠিয়ে সার্ভারকে তার পছন্দ বলে দেয়। যেমন: "আমাকে JSON ডেটা পাঠালে ভালো হয়, কারণ আমি JSON বুঝতে পারি।"
</details>

---

**Q7. What is the primary purpose of HTTP Caching?**
A) To permanently save user passwords
B) To store copies of frequently requested responses (like images, CSS, or API data) on the client side, reducing server load, saving bandwidth, and making the application load significantly faster.
C) To bypass firewalls
D) To hide data from hackers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Caching এর মূল উদ্দেশ্যই হলো বারবার একই ডেটা সার্ভার থেকে ডাউনলোড না করে, ব্রাউজারের মেমোরিতে (Cache) সেভ করে রাখা, যাতে ওয়েবসাইট রকেটের মতো ফাস্ট লোড হয়।
</details>

---

**Q8. Which HTTP header is the modern, standard way for a server to control how a response should be cached by the client?**
A) `Expires`
B) `Pragma`
C) `Cache-Control`
D) `Keep-Alive`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: `Cache-Control` হলো ক্যাশিং কন্ট্রোল করার সবচেয়ে আধুনিক এবং স্ট্যান্ডার্ড হেডার। (আগে `Expires` বা `Pragma` ইউজ করা হতো)।
</details>

---

**Q9. If a server sends `Cache-Control: max-age=3600`, what does it mean?**
A) The client must be at least 3600 days old
B) The client can safely store and reuse the response for 3600 seconds (1 hour) without checking back with the server.
C) The server will delete the file in 3600 seconds
D) The file is exactly 3600 bytes large

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `max-age` মানে হলো সেকেন্ডের হিসাব। ৩৬০০ সেকেন্ড মানে ১ ঘণ্টা। সার্ভার বলছে: "আগামী ১ ঘণ্টার জন্য এই ডেটা তোমার কাছে ক্যাশ করে রাখো।"
</details>

---

**Q10. What does `Cache-Control: no-store` mean?**
A) The server has no more storage space
B) The client (and any intermediate proxies) MUST NOT store any part of the request or response in any cache memory. It is used for highly sensitive data like bank balances.
C) The client should store it, but not use it
D) The store is currently closed

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `no-store` হলো সবচেয়ে কড়া নির্দেশ! এর মানে হলো: "ভুলেও এই ডেটা ব্রাউজার বা হার্ডডিস্কের কোথাও সেভ করে রাখবে না।" ব্যাংকের ব্যালান্স বা সেনসিটিভ ডেটার ক্ষেত্রে এটি ইউজ করা হয়।
</details>

---

**Q11. What does `Cache-Control: no-cache` mean?**
A) The client cannot use caching at all (same as `no-store`)
B) The client can store the response in the cache, but it MUST send a validation request to the server (e.g., using ETag) to check if the data has changed BEFORE using the cached copy.
C) The server clears its own cache
D) The cache is currently broken

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি খুবই কনফিউজিং একটি নাম! `no-cache` মানে এই নয় যে ক্যাশ করা যাবে না। এর মানে হলো: "তুমি ক্যাশ করে রাখতে পারো, কিন্তু ইউজ করার আগে প্রতিবার আমার (সার্ভারের) কাছ থেকে পারমিশন নিয়ে নেবে যে ডেটা আপডেট হয়েছে কি না।"
</details>

---

**Q12. What is an ETag (Entity Tag)?**
A) An electronic price tag
B) A unique identifier (usually a hash) assigned by the server to a specific version of a resource. If the resource content changes, the ETag changes.
C) An HTML tag like `<etag>`
D) A type of CSS selector

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ETag হলো একটি ফাইলের ফিঙ্গারপ্রিন্ট বা হ্যাশ। ফাইলের ভেতরে একটু চেঞ্জ হলেই ETag চেঞ্জ হয়ে যায়। সার্ভার এটি দিয়ে বোঝে যে ফাইল আপডেট হয়েছে কি না।
</details>

---

**Q13. How does the client use the ETag in subsequent requests to check if its cached version is still valid?**
A) By sending it in the URL
B) By sending it in the `If-None-Match` request header
C) By sending it in the `Authorization` header
D) By sending it in the request body

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ব্রাউজার আগেরবার সেভ করে রাখা ETag টিকে সার্ভারের কাছে পাঠায় `If-None-Match` হেডার দিয়ে। এর মানে হলো: "ভাই, আমার কাছে এই ভার্সনটা আছে, যদি তোমার নতুন ভার্সন এর সাথে ম্যাচ না করে (None-Match), তবেই আমাকে নতুন ডেটা দাও।"
</details>

---

**Q14. If the server sees that the client's `If-None-Match` ETag exactly matches the server's current ETag for the resource, what status code should the server return?**
A) `200 OK` (with the full body)
B) `404 Not Found`
C) `304 Not Modified` (with NO body)
D) `500 Internal Server Error`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ETag মিলে যাওয়া মানে হলো ডেটা চেঞ্জ হয়নি। তখন সার্ভার আর পুরো ডেটা না পাঠিয়ে জাস্ট `304 Not Modified` স্ট্যাটাস কোড পাঠিয়ে দেয়। ব্রাউজার তখন নিজের ক্যাশ থেকে ডেটা দেখিয়ে দেয়।
</details>

---

**Q15. What is the primary benefit of returning a `304 Not Modified` response?**
A) It makes the database faster
B) It dramatically saves network bandwidth and download time, because the server does not need to send the actual payload (body) over the network; the client just reuses its cached copy.
C) It encrypts the payload
D) It prevents SQL Injection

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ২ এমবির একটি লোগো বারবার না পাঠিয়ে, সার্ভার শুধু কয়েক বাইটের `304` মেসেজ পাঠায়। এতে সার্ভারের প্রচুর ব্যান্ডউইথ (ইন্টারনেট বিল) বেঁচে যায়।
</details>

---

**Q16. Besides ETag, what is another common header used for Conditional Requests (checking if a cache is valid based on a timestamp)?**
A) `Last-Modified` (Response) and `If-Modified-Since` (Request)
B) `Time-To-Live`
C) `Update-Check`
D) `Cache-Timestamp`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: ETag (হ্যাশ) ছাড়াও সময় (Timestamp) দিয়েও ক্যাশ চেক করা যায়। সার্ভার পাঠায় `Last-Modified` (কবে লাস্ট আপডেট হয়েছিল), আর ক্লায়েন্ট পাঠায় `If-Modified-Since` (এই তারিখের পর কি আর আপডেট হয়েছে?)।
</details>

---

**Q17. Which HTTP method is generally considered "Idempotent" and safe to Cache?**
A) POST
B) GET
C) PUT
D) DELETE

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: GET রিকোয়েস্ট শুধু ডেটা রিড করে, সার্ভারের কোনো ডেটা চেঞ্জ করে না। তাই ব্রাউজার সাধারণত শুধুমাত্র GET রিকোয়েস্টের রেজাল্টগুলোকেই ক্যাশ (Cache) করে রাখে।
</details>

---

**Q18. Are POST requests typically cached by browsers?**
A) Yes, always
B) No. POST requests are used to submit data and change the server state (e.g., creating a user, processing a payment), so caching them could lead to duplicated or missed actions.
C) Only if they return JSON
D) Only on mobile devices

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: POST রিকোয়েস্ট (যেমন টাকা পাঠানো বা রেজিস্ট্রেশন করা) ক্যাশ করা মানে হলো মহাবিপদ! তাই ব্রাউজার ডিফল্টভাবে কখনোই POST রিকোয়েস্ট ক্যাশ করে না।
</details>

---

**Q19. What does the HTTP status code `200 OK` mean in the context of caching?**
A) The cache is broken
B) The requested resource is being returned in full (the server sent the entire body because the client didn't have a valid cache, or the cache expired and the ETag didn't match).
C) The client should use its cache
D) The server is too busy

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `200 OK` মানে হলো সার্ভার পুরো ডেটা (Body সহ) নতুন করে পাঠিয়েছে।
</details>

---

**Q20. What is a "Cache Buster"?**
A) An antivirus that deletes caches
B) A technique to force the browser to ignore its cache and download a fresh file, often done by appending a unique version string or hash to the file URL (e.g., `style.css?v=2.1`).
C) A physical hammer
D) A server reboot

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আপনি সাইটের CSS চেঞ্জ করেছেন, কিন্তু ইউজার তার পুরনো ক্যাশ করা ডিজাইনই দেখছে! এই সমস্যা সমাধানের জন্য আমরা CSS ফাইলের নামের শেষে ভার্সন (`?v=2`) লাগিয়ে দিই। নাম চেঞ্জ হলে ব্রাউজার বাধ্য হয়ে নতুন ফাইল ডাউনলোড করে। একেই Cache Busting বলে।
</details>

---

**Q21. What happens if a server sends both `Cache-Control: max-age=3600` and an `ETag`?**
A) They conflict and the browser crashes
B) The browser will cache the file and use it WITHOUT contacting the server for 3600 seconds. After 3600 seconds, the cache is "stale", so the browser will THEN send an `If-None-Match` request with the ETag to ask the server if it can keep using it.
C) The ETag is ignored
D) The max-age is ignored

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি খুবই পাওয়ারফুল একটি কম্বিনেশন! প্রথম ১ ঘণ্টা ব্রাউজার সার্ভারের কাছে আসতেই চাইবে না (Full offline speed)। ১ ঘণ্টা পর সে এসে ETag দিয়ে চেক করবে, "ভাই, ১ ঘণ্টা তো পার হলো, ফাইলটা কি এখনো সেম আছে?"
</details>

---

**Q22. What is a "CDN" (Content Delivery Network)?**
A) A local TV channel
B) A globally distributed network of proxy servers that cache static assets (images, videos, JS files) closer to the users, dramatically speeding up loading times globally.
C) A database backup system
D) A type of CSS framework

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ক্লাউডফ্লেয়ার (Cloudflare) এর মতো CDN গুলো আপনার ওয়েবসাইটের ছবি বা ভিডিওগুলোকে পৃথিবীর বিভিন্ন দেশের সার্ভারে ক্যাশ (Cache) করে রাখে। ফলে আমেরিকার ইউজার আমেরিকা থেকে এবং বাংলাদেশের ইউজার বাংলাদেশ থেকেই সুপার ফাস্ট স্পিডে ডেটা লোড করতে পারে।
</details>

---

**Q23. In the context of CDN caching, what does `Cache-Control: public` mean?**
A) The data is posted on Facebook
B) The response can be cached by ANY cache (including the user's browser, corporate proxies, and shared CDNs like Cloudflare).
C) It means the opposite of private
D) The server is public

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `public` মানে হলো এই ডেটাটি সিক্রেট কিছু নয়। ব্রাউজার, ইন্টারনেট প্রোভাইডার (ISP), বা CDN—যে কেউ চাইলে এটি তাদের সার্ভারে ক্যাশ করে রাখতে পারে।
</details>

---

**Q24. In the context of CDN caching, what does `Cache-Control: private` mean?**
A) The data is encrypted
B) The response is intended for a SINGLE user only (e.g., a personalized dashboard). It can be cached by the user's local browser, but MUST NOT be cached by a shared proxy or CDN (otherwise user A might see user B's data).
C) The server requires a password
D) The network is offline

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `private` মানে হলো এটি স্পেসিফিক ইউজারের পার্সোনাল ডেটা। এটি শুধু ইউজারের নিজের ব্রাউজারেই ক্যাশ করা যাবে, মাঝখানের কোনো CDN বা রাউটার এটি ক্যাশ করতে পারবে না (করলে আরেকজন ইউজার অন্যের ডেটা দেখে ফেলবে)।
</details>

---

**Q25. What is a "Preflight Request" (OPTIONS method) in HTTP?**
A) A request sent before an airplane takes off
B) A small CORS request sent by the browser to check if the server permits the actual cross-origin request (e.g., checking if it's allowed to send a POST request with custom headers).
C) A request to pre-load images
D) A DNS lookup

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যখন অন্য কোনো ডোমেইনে (CORS) কোনো ড্যাঞ্জারাস রিকোয়েস্ট (যেমন POST/DELETE) পাঠাতে হয়, তখন ব্রাউজার আগে থেকে একটি `OPTIONS` রিকোয়েস্ট পাঠিয়ে সার্ভারের কাছে পারমিশন চায় যে "আমি কি আসবো?"। একেই Preflight বলে।
</details>

---

**Q26. What does the `Location` HTTP response header do?**
A) Tells the user their GPS coordinates
B) It is used in redirection (e.g., Status Codes 301 or 302). It tells the browser the new URL to automatically navigate to.
C) Tells the server where the client is located
D) Locates a file on the hard drive

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সার্ভার যখন `301 Redirect` স্ট্যাটাস দেয়, তখন সাথে `Location` হেডারে নতুন ওয়েবসাইটের লিংকটি দিয়ে দেয়। ব্রাউজার ওই লিংক দেখে অটোমেটিক নতুন পেজে চলে যায়।
</details>

---

**Q27. What is the `Strict-Transport-Security` (HSTS) header?**
A) A header that makes the transport faster
B) A security header that tells the browser to ONLY communicate with the server using secure HTTPS connections for a specified period of time, automatically upgrading any insecure HTTP attempts.
C) A header used by trains and buses
D) A caching strategy

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: HSTS হেডার ব্রাউজারকে বাধ্য করে যেন সে ওই সাইটে সবসময় HTTPS দিয়েই ঢোকে। ইউজার যদি ভুল করে `http://` লিখেও এন্টার দেয়, ব্রাউজার নিজে থেকেই সেটিকে `https://` বানিয়ে নেবে।
</details>

---

**Q28. What is a Weak ETag vs a Strong ETag?**
A) Weak is for small files, Strong is for large files
B) A Strong ETag guarantees the resource is bit-for-bit perfectly identical. A Weak ETag (prefixed with `W/`) indicates the resource is semantically equivalent, even if some minor bytes (like dynamic ads) have changed.
C) Weak ETags are easier to hack
D) Strong ETags use RSA encryption

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Strong ETag মানে ডেটার একটি বাইট (Byte) চেঞ্জ হলেও হ্যাশ চেঞ্জ হয়ে যাবে। আর Weak ETag (`W/"hash"`) মানে হলো ডেটার মিনিং বা আসল কথা চেঞ্জ না হলে ছোটখাটো চেঞ্জের (যেমন অ্যাড বা ফুটার) জন্য হ্যাশ চেঞ্জ হবে না।
</details>

---

**Q29. Why might caching an API response that returns a random quote on every request be a bad idea?**
A) Because quotes are copyrighted
B) The user will keep seeing the exact same "cached" quote instead of a new random one, completely breaking the intended functionality of the application.
C) It will crash the server
D) It takes up too much memory

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যে API এর কাজই হলো প্রতিবার নতুন নতুন ডেটা (যেমন র‍্যান্ডম কোট বা কারেন্ট টাইম) দেওয়া, তাকে ক্যাশ করে রাখলে ইউজার বারবার একই পুরনো ডেটাই দেখতে থাকবে। এক্ষেত্রে ক্যাশ করা যাবে না (`no-store` ইউজ করতে হবে)।
</details>

---

**Q30. [Code Logic] If a Spring Boot developer writes `ResponseEntity.ok().cacheControl(CacheControl.noStore()).body(data);`, what will the browser do?**
A) It will cache it forever
B) It will NOT save the data anywhere in its cache, and will make a full network request to the server every single time this endpoint is hit.
C) It will use ETag
D) It will store it in the database

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `noStore()` মানে হলো কড়া নিষেধ! ব্রাউজার কোনোভাবেই ডেটা ক্যাশ করতে পারবে না, প্রতিবার তাকে সার্ভারে আসতেই হবে।
</details>

---

**Q31. What is the `User-Agent` header primarily used for by developers?**
A) Identifying the user's real name
B) Analytics, Browser-specific bug fixes, or determining if the request is coming from a mobile phone vs a desktop to serve different layouts.
C) Authenticating the user
D) Increasing internet speed

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `User-Agent` দেখে সার্ভার বুঝতে পারে যে রিকোয়েস্টটি আইফোন থেকে এসেছে নাকি পিসি থেকে। সেই অনুযায়ী সে মোবাইল ভিউ বা ডেস্কটপ ভিউয়ের ডেটা পাঠাতে পারে।
</details>

---

**Q32. How can an attacker bypass the information provided by the `User-Agent` header?**
A) They cannot bypass it
B) The `User-Agent` is just a simple string sent by the client; an attacker can easily "Spoof" (fake) it using tools like Postman or cURL to pretend they are a different browser or Googlebot.
C) By using a VPN
D) By disabling JavaScript

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `User-Agent` কে কখনোই ১০০% বিশ্বাস করা উচিত নয়। কারণ হ্যাকার চাইলে পোস্টম্যান (Postman) দিয়ে খুব সহজেই এটিকে চেঞ্জ করে সার্ভারকে ধোঁকা দিতে পারে।
</details>

---

**Q33. Which HTTP status code class indicates a "Client Error" (e.g., the client sent a bad request or lacks permissions)?**
A) 2xx
B) 3xx
C) 4xx (e.g., 400 Bad Request, 404 Not Found)
D) 5xx

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: 4xx মানেই হলো ক্লায়েন্ট বা ইউজারের নিজের দোষ! সে হয়তো ভুল URL এ হিট করেছে (404), বা ভুল ডেটা পাঠিয়েছে (400), বা তার পারমিশন নেই (403)।
</details>

---

**Q34. Which HTTP status code class indicates a "Server Error" (e.g., the code threw an exception)?**
A) 2xx
B) 3xx
C) 4xx
D) 5xx (e.g., 500 Internal Server Error)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: 5xx মানে হলো সার্ভারের নিজের দোষ! সার্ভারের ভেতরে হয়তো কোড ক্র্যাশ করেছে বা ডাটাবেস ডাউন হয়ে গেছে।
</details>

---

**Q35. What is the purpose of the `Origin` request header?**
A) It specifies the exact time the request started
B) It indicates the scheme, hostname, and port from which the request was initiated. It is heavily used by the server to evaluate CORS (Cross-Origin Resource Sharing) policies.
C) It creates a database origin
D) It tracks the user's GPS location

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `Origin` হেডার বলে দেয় যে রিকোয়েস্টটি আসলে কোন ওয়েবসাইট (ডোমেইন) থেকে এসেছে। সার্ভার এটি দেখেই ডিসাইড করে যে ওই ওয়েবসাইটকে (CORS) ডেটা দেওয়া যাবে কি না।
</details>

---

**Q36. If an API response lacks a `Cache-Control` header entirely, what will the browser do?**
A) It will crash
B) It might use "Heuristic Caching", where the browser guesses a cache duration based on other headers like `Last-Modified`. This can lead to unpredictable caching behavior.
C) It will never cache it
D) It caches it for 10 years

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `Cache-Control` না দিলে ব্রাউজার নিজের মনগড়া লজিক (Heuristic) দিয়ে ডেটা ক্যাশ করতে শুরু করে, যা ডেভেলপারদের জন্য খুবই বিপদের কারণ হতে পারে (পাগলাটে বিহেভিয়র)। তাই সবসময় হেডার দেওয়া উচিত।
</details>

---

**Q37. What does the `X-Requested-With: XMLHttpRequest` header usually indicate?**
A) An XML file is attached
B) It was historically used by libraries like jQuery to tell the server that the request was an AJAX call, rather than a full page navigation.
C) A request to X (formerly Twitter)
D) A database request

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: পুরোনো দিনে (jQuery এর যুগে) সার্ভারকে বোঝানোর জন্য এই হেডার ইউজ করা হতো যে, "আমি পেজ রিলোড করছি না, শুধু ব্যাকগ্রাউন্ডে AJAX রিকোয়েস্ট পাঠাচ্ছি।"
</details>

---

**Q38. Why is ETag calculation potentially expensive on the server side?**
A) Because hashes cost money to buy
B) To generate an ETag, the server often has to fully render the payload and run a hashing algorithm (like MD5 or SHA) on it. For large files or complex DB queries, this consumes CPU cycles.
C) Because ETags use AES encryption
D) Because ETags use external APIs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সার্ভারকে ETag (হ্যাশ) বানাতে হলে আগে পুরো ডেটাটা জেনারেট বা রিড করতে হয়, তারপর সেটিকে হ্যাশ অ্যালগরিদমের ভেতর দিয়ে পাঠাতে হয়। বড় ডেটার ক্ষেত্রে এটি CPU এর ওপর প্রেশার ফেলতে পারে।
</details>

---

**Q39. To save CPU cycles on ETag generation, what optimization is often done?**
A) ETags are disabled completely
B) Generating the ETag based on a combination of `File Size + Last Modified Date` rather than running a full cryptographic hash of the file contents.
C) Using the user's password as the ETag
D) Making the user calculate the ETag

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: পুরো বড় ফাইলের হ্যাশ না বানিয়ে, সার্ভার চালাকি করে "ফাইলের সাইজ + লাস্ট এডিটের টাইম" জোড়া লাগিয়েই একটি ETag বানিয়ে ফেলে। এটি অনেক ফাস্ট এবং CPU বাঁচে। (যেমন Nginx সার্ভার এভাবেই করে)।
</details>

---

**Q40. [Conclusion] Why is mastering HTTP Headers and Caching essential for a Senior Backend Engineer?**
A) It makes the code look longer
B) Proper caching is the most effective way to scale an application. By offloading traffic to the browser's cache or a CDN via headers, you can support millions of users with minimal server resources, while dramatically improving the UX with instant load times.
C) It is required by Google Search
D) It prevents CSS bugs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আপনি কোড যতই অপটিমাইজ করুন না কেন, ক্যাশিং (Caching) হলো স্কেলিংয়ের আসল রাজা! ব্রাউজার বা CDN যদি ডেটা ক্যাশ করে নেয়, তবে সার্ভারের ওপর কোনো প্রেশারই পড়ে না, আর ওয়েবসাইট রকেটের মতো লোড হয়।
</details>
