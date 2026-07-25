# 01. HTTPS & TLS (Practice MCQs)

This file contains 40 in-depth MCQs covering HTTP vs HTTPS, Symmetric vs Asymmetric Encryption, the TLS Handshake, and Digital Certificates.

---

**Q1. What is the fundamental difference between HTTP and HTTPS?**
A) HTTP uses port 443, HTTPS uses port 80
B) HTTPS encrypts the data transferred between the client and server, whereas HTTP transfers data in plain text
C) HTTP is for images, HTTPS is for text
D) They are exactly the same protocol

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: HTTP তে ডেটা প্লেইন টেক্সট হিসেবে যায়, যা হ্যাকাররা সহজেই পড়ে ফেলতে পারে। HTTPS (Secure) এ ডেটা এনক্রিপ্ট করে পাঠানো হয়, ফলে কেউ তা পড়তে পারে না।
</details>

---

**Q2. Which default ports do HTTP and HTTPS use respectively?**
A) 80 and 8080
B) 21 and 22
C) 80 and 443
D) 443 and 8443

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: এটি নেটওয়ার্কিংয়ের খুব কমন একটি বিষয়। HTTP সবসময় পোর্ট ৮০ তে চলে এবং HTTPS পোর্ট ৪৪৩ তে চলে।
</details>

---

**Q3. What does the "S" in HTTPS stand for?**
A) Standard
B) Secure
C) System
D) Synchronous

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: HTTPS মানে হলো HyperText Transfer Protocol Secure.
</details>

---

**Q4. What is the primary vulnerability of transmitting sensitive data (like passwords) over plain HTTP?**
A) The server might crash
B) The data size becomes too large
C) It is highly susceptible to a "Man-in-the-Middle" (MitM) attack, where an attacker intercepts and reads the plain text data
D) It slows down the internet

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: HTTP তে পাসওয়ার্ড পাঠালে রাউটার বা আইএসপি (ISP) লেভেলে যে কেউ নেটওয়ার্ক স্নিফ (Sniff) করে পাসওয়ার্ড চুরি করে নিতে পারে।
</details>

---

**Q5. Which cryptographic protocol is primarily used by modern HTTPS?**
A) SSL (Secure Sockets Layer)
B) TLS (Transport Layer Security)
C) SSH (Secure Shell)
D) FTP

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আগে SSL ব্যবহার করা হতো। কিন্তু SSL এখন অনেক পুরনো এবং ইনসিকিউর হয়ে গেছে। বর্তমানে সবাই TLS (যেমন TLS 1.2 বা 1.3) ব্যবহার করে। (যদিও মানুষ অভ্যাসবশত একে এখনো SSL সার্টিফিকেট বলে)।
</details>

---

**Q6. In Symmetric Encryption, how many keys are used?**
A) 0
B) 1 key used for both encryption and decryption
C) 2 keys (one public, one private)
D) 3 keys

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Symmetric এনক্রিপশনে একটাই চাবি থাকে। যে চাবি দিয়ে ডেটা লক (Encrypt) করা হয়, ঠিক সেই চাবি দিয়েই আবার আনলক (Decrypt) করা হয়।
</details>

---

**Q7. What is the main advantage of Symmetric Encryption compared to Asymmetric Encryption?**
A) It is much more secure
B) It requires no keys
C) It is computationally much faster and requires less CPU power
D) The key can be safely sent over the internet in plain text

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Symmetric এনক্রিপশন অনেক ফাস্ট, কারণ এর অ্যালগরিদম সিম্পল। বড় ডেটা বা মুভি ডাউনলোডের মতো কাজে এটি খুব ফাস্ট কাজ করে।
</details>

---

**Q8. What is the main drawback or challenge of using ONLY Symmetric Encryption over the internet?**
A) It is too slow
B) The "Key Distribution Problem": If both parties need the same key to communicate, how do they safely share that key in the first place without a hacker intercepting it?
C) It cannot encrypt text
D) It uses too much battery

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু একটাই চাবি, তাই ক্লায়েন্ট থেকে সার্ভারে চাবিটা তো পাঠাতে হবে! কিন্তু পাঠানোর সময় হ্যাকার যদি চাবিটা ধরে ফেলে, তবে সে সব ডেটা আনলক করে ফেলবে। এটিই এর সবচেয়ে বড় সমস্যা।
</details>

---

**Q9. How does Asymmetric Encryption solve the Key Distribution Problem?**
A) By sending the key via email
B) By using a pair of mathematically linked keys: a Public Key (shared with everyone) to encrypt data, and a Private Key (kept strictly secret by the owner) to decrypt it
C) By using passwords instead of keys
D) By not encrypting the data at all

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Asymmetric এ দুইটি চাবি থাকে। আপনি পাবলিক কি (Public Key) সবাইকে দিয়ে দেন। যে কেউ সেটি দিয়ে ডেটা লক করতে পারে, কিন্তু আনলক করার চাবি (Private Key) শুধু আপনার কাছেই থাকে। তাই হ্যাকার ডেটা চুরি করলেও কিছু করতে পারে না।
</details>

---

**Q10. If Alice wants to send a secure message to Bob using Asymmetric Encryption, whose key does Alice use to encrypt the message?**
A) Alice's Private Key
B) Alice's Public Key
C) Bob's Public Key
D) Bob's Private Key

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: অ্যালিস ববের পাবলিক কি (Public Key) দিয়ে ডেটা লক করে পাঠাবে। কারণ লক করার পর সেই ডেটা আনলক করতে ববের প্রাইভেট কি লাগবে, যা শুধু ববের কাছেই আছে!
</details>

---

**Q11. Why don't we use Asymmetric Encryption for encrypting the entire HTTPS session?**
A) Because it is illegal
B) Because it is computationally very expensive and slow compared to symmetric encryption, which would make loading web pages unacceptably sluggish
C) Because it only works for images
D) Because public keys expire every minute

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Asymmetric এনক্রিপশনের ক্যালকুলেশন অনেক ভারী (Heavy)। এটি দিয়ে পুরো ওয়েবসাইট বা মুভি পাঠাতে গেলে সিপিইউ হ্যাং করবে এবং ইন্টারনেট অনেক স্লো হয়ে যাবে।
</details>

---

**Q12. Since Asymmetric is slow and Symmetric has a key-sharing problem, how does the TLS Handshake elegantly solve this?**
A) It ignores encryption altogether
B) It uses Asymmetric encryption ONLY at the beginning to safely exchange a "Shared Secret Key". Once exchanged, they switch to Symmetric encryption for the rest of the fast data transfer.
C) It uses a USB drive
D) It uses Symmetric encryption first, then Asymmetric

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি একটি মাস্টারস্ট্রোক! প্রথমে তারা স্লো Asymmetric এনক্রিপশন ব্যবহার করে একটি সিক্রেট চাবি (Symmetric Key) শেয়ার করে নেয়। চাবি শেয়ার করা হয়ে গেলে তারা Asymmetric বাদ দিয়ে ফাস্ট Symmetric এনক্রিপশন দিয়ে কাজ চালিয়ে যায়।
</details>

---

**Q13. What is a "Digital Certificate" (SSL/TLS Certificate)?**
A) A PDF document thanking you for using the internet
B) An electronic document containing a website's Public Key, domain name, and a Digital Signature from a trusted Certificate Authority (CA) proving the website's identity
C) A firewall rule
D) A JavaScript file

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডিজিটাল সার্টিফিকেট হলো ওয়েবসাইটের একটি আইডেন্টিটি কার্ড বা পাসপোর্ট। এতে ওয়েবসাইটের নাম এবং তাদের Public Key থাকে। এবং এটি আসল কি না তা বোঝানোর জন্য একটি CA এর সিগনেচার থাকে।
</details>

---

**Q14. What role does a Certificate Authority (CA) play in HTTPS?**
A) They provide internet bandwidth
B) They act as a trusted third party that verifies the identity of the website owner and digitally signs their certificate, preventing hackers from using fake public keys
C) They store all passwords
D) They act as a database

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাকার যদি গুগল সেজে তার নিজের ফেক পাবলিক কি পাঠায়, তখন আপনি কীভাবে বুঝবেন? এই সমস্যার সমাধানে CA (যেমন Let's Encrypt) সাহায্য করে। তারা ভেরিফাই করে আসল ওয়েবসাইটকে সিগনেচার দেয়।
</details>

---

**Q15. How does your web browser (like Chrome or Firefox) know if a CA is trustworthy?**
A) It asks the user every time
B) It searches Google
C) The browser (or OS) comes pre-installed with a "Root Store" containing the public keys of globally trusted Certificate Authorities
D) It does not check

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: অপারেটিং সিস্টেম (Windows/Mac) বা ব্রাউজার ইনস্টল করার সময়ই তার ভেতরে দুনিয়ার সব ট্রাস্টেড CA-দের লিস্ট এবং পাবলিক কি (Root Certificates) আগে থেকেই দেওয়া থাকে।
</details>

---

**Q16. What happens if you generate your own SSL certificate locally (a "Self-Signed Certificate") and use it on your website?**
A) The website loads perfectly with a green padlock
B) The browser throws a stark "Your connection is not private / NET::ERR_CERT_AUTHORITY_INVALID" warning because it cannot find a trusted CA signature
C) The browser crashes
D) The server refuses to start

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আপনি নিজে সাইন (Self-signed) করলে ব্রাউজার আপনাকে চিনবে না। সে দেখবে এটি কোনো পরিচিত CA-এর সাইন না, তাই সে বিশাল বড় লাল রঙের ওয়ার্নিং দেখাবে।
</details>

---

**Q17. In the first step of the TLS Handshake (Client Hello), what information does the browser send to the server?**
A) The user's password
B) The website's HTML
C) The TLS versions it supports and a list of supported Cipher Suites (encryption algorithms)
D) A database query

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: হ্যালো বলার সময় ব্রাউজার মূলত জানায় যে সে কোন কোন এনক্রিপশন ল্যাঙ্গুয়েজ বোঝে (Cipher suites), যাতে সার্ভার সেখান থেকে একটি সিলেক্ট করে কথা বলতে পারে।
</details>

---

**Q18. What is a "Cipher Suite"?**
A) A hotel room for hackers
B) A set of algorithms that help secure a network connection (including Key Exchange, Authentication, Bulk Encryption, and MAC algorithms)
C) A browser extension
D) A type of firewall

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Cipher Suite হলো এনক্রিপশনের একটি প্যাকেজ। এতে বলে দেওয়া থাকে যে কোন অ্যালগরিদম দিয়ে চাবি এক্সচেঞ্জ হবে, কোনটা দিয়ে ডেটা লক হবে (যেমন AES) ইত্যাদি।
</details>

---

**Q19. During the TLS Handshake, after the server sends its Certificate, what does the client (browser) do?**
A) It downloads a virus
B) It verifies the certificate against its pre-installed trusted CAs and extracts the server's Public Key
C) It sends its own private key to the server
D) It closes the connection

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ব্রাউজার আগে চেক করে দেখে সার্টিফিকেটটি ভ্যালিড কি না। ভ্যালিড হলে সে সার্টিফিকেটের ভেতর থেকে সার্ভারের পাঠানো Public Key-টি বের করে নেয়।
</details>

---

**Q20. What is a "Digital Signature"?**
A) A scanned copy of a handwritten signature
B) A mathematical scheme for verifying the authenticity of a digital message or document, typically created by encrypting a hash with a Private Key
C) An image file
D) A barcode

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডিজিটাল সিগনেচার মানে হলো Private Key দিয়ে কোনো ডেটার হ্যাশ (Hash) কে এনক্রিপ্ট করে দেওয়া। এটি প্রমাণ করে যে ডেটাটি সঠিক সোর্স থেকেই এসেছে এবং মাঝপথে কেউ এডিট করেনি।
</details>

---

**Q21. How does Hashing differ from Encryption?**
A) They are identical
B) Encryption is a two-way function (can be decrypted), whereas Hashing is a one-way mathematical function (cannot be reversed)
C) Hashing is slower
D) Encryption is used for passwords, hashing is for images

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এনক্রিপ্ট করলে চাবি দিয়ে আবার আনলক (Decrypt) করা যায়। কিন্তু হ্যাশ (যেমন MD5 বা SHA-256) করলে সেটি আর জীবনেও আগের রূপে ফেরানো যায় না (One-way)।
</details>

---

**Q22. Which popular modern algorithm is commonly used for Asymmetric Encryption / Key Exchange?**
A) AES (Advanced Encryption Standard)
B) RSA or Diffie-Hellman (ECDHE)
C) MD5
D) SHA-256

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: RSA এবং Diffie-Hellman হলো Asymmetric এনক্রিপশন (দুই চাবির তালা) এর সবচেয়ে পপুলার অ্যালগরিদম।
</details>

---

**Q23. Which popular modern algorithm is commonly used for Symmetric Encryption (Bulk data transfer) in HTTPS?**
A) RSA
B) AES (e.g., AES-128 or AES-256)
C) SHA
D) Diffie-Hellman

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: AES (Advanced Encryption Standard) হলো Symmetric এনক্রিপশন। চাবি এক্সচেঞ্জ হয়ে যাওয়ার পর পুরো ওয়েবসাইটের ডেটা ফাস্ট ট্রান্সফার করার জন্য AES ব্যবহার করা হয়।
</details>

---

**Q24. What is the purpose of MAC (Message Authentication Code) in TLS?**
A) To assign IP addresses
B) To ensure Data Integrity—verifying that the encrypted data was not tampered with or modified by a hacker while in transit
C) To identify Apple devices
D) To compress the data

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাকার যদি ডেটা আনলক করতে নাও পারে, সে চাইলে মাঝপথে ডেটা উল্টাপাল্টা বা নষ্ট (Tamper) করে দিতে পারে। MAC চেক করে দেখে যে ডেটা মাঝপথে একটুও চেঞ্জ হয়েছে কি না।
</details>

---

**Q25. What is Forward Secrecy (Perfect Forward Secrecy) in modern TLS (TLS 1.3)?**
A) Keeping secrets for the future
B) A feature ensuring that even if a server's long-term Private Key is compromised in the future, past session data cannot be decrypted because unique, temporary session keys were used for every connection
C) Sending data quickly
D) Bypassing firewalls

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আগে সার্ভারের মেইন Private Key লিক হয়ে গেলে হ্যাকার পুরোনো সব ডেটা আনলক করতে পারতো। কিন্তু Forward Secrecy তে প্রতিটি সেশনের জন্য আলাদা আলাদা টেম্পোরারি চাবি তৈরি হয়, তাই মেইন চাবি লিক হলেও আগের ডেটাগুলো সেফ থাকে।
</details>

---

**Q26. Which version of TLS is the most modern, fastest, and most secure as of today?**
A) SSL 3.0
B) TLS 1.0
C) TLS 1.2
D) TLS 1.3

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: TLS 1.3 হলো লেটেস্ট ভার্সন। এটি আগের ভার্সনগুলোর চেয়ে অনেক ফাস্ট (হ্যান্ডশেক টাইম কম) এবং বেশি সিকিউর।
</details>

---

**Q27. When setting up HTTPS on a Node.js Express server locally, which two files do you strictly need to pass into the `https.createServer()` options?**
A) `index.html` and `style.css`
B) A Private Key (`.key` or `.pem`) and a Certificate (`.crt` or `.pem`)
C) `package.json` and `node_modules`
D) A username and password

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: HTTPS সার্ভার রান করার জন্য মাস্ট দুটি ফাইল লাগে: একটি Private Key (লুকিয়ে রাখার জন্য) এবং একটি Certificate (ক্লায়েন্টকে পাঠানোর জন্য)।
</details>

---

**Q28. What is Let's Encrypt?**
A) A hacking tool
B) A non-profit Certificate Authority (CA) that provides free SSL/TLS certificates to encourage the entire web to move to HTTPS
C) An encryption algorithm
D) A web browser

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আগে সার্টিফিকেট কিনতে অনেক টাকা লাগতো। Let's Encrypt এসে সবাইকে ফ্রিতে ট্রাস্টেড সার্টিফিকেট দেওয়া শুরু করে, যার ফলে আজ ইন্টারনেটের প্রায় সব ওয়েবসাইট HTTPS হয়ে গেছে।
</details>

---

**Q29. What happens if an SSL/TLS Certificate expires?**
A) The website gets deleted
B) The database drops all tables
C) The browser will block access to the site and display a stark "Your connection is not private" warning because the certificate is no longer valid
D) The website automatically switches back to HTTP smoothly

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: সার্টিফিকেটের একটি মেয়াদ (যেমন ৩ মাস বা ১ বছর) থাকে। মেয়াদ শেষ হলে ব্রাউজার সাথে সাথে ওয়ার্নিং দেওয়া শুরু করে এবং ইউজারকে সাইটে ঢুকতে বাধা দেয়।
</details>

---

**Q30. Is it possible for a hacker on the same public Wi-Fi to see which exact domain you are visiting (e.g., `https://youtube.com`) even if it is HTTPS?**
A) Yes, because the domain name is sent in plain text during the initial DNS lookup and SNI (Server Name Indication) before the encryption starts
B) No, everything is encrypted immediately
C) Only if they know your password
D) Yes, but only for mobile devices

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: HTTPS শুধু ডেটা (URL path, password) এনক্রিপ্ট করে। কিন্তু আপনি কোন মেইন ডোমেইনে (google.com) যাচ্ছেন, তা রাউটার বা হ্যাকার দেখতে পারে, কারণ DNS রিকোয়েস্ট এবং SNI প্লেইন টেক্সটেই যায়।
</details>

---

**Q31. Can a hacker using a Packet Sniffer (like Wireshark) see the specific URL path (e.g., `https://example.com/login?user=sabbir`) on an HTTPS connection?**
A) Yes
B) No, the entire URL path and query parameters are encrypted; the hacker only sees the IP/Domain of `example.com`
C) Yes, if they use Linux
D) Only the query parameters are visible

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: HTTPS এ ডোমেইনের পরের সবটুকু অংশ (যেমন `/login` বা `?id=5`) এবং বডির সব ডেটা এনক্রিপ্ট হয়ে যায়।
</details>

---

**Q32. What is "SNI" (Server Name Indication) in the TLS Handshake?**
A) An extension that allows a single server (IP address) to host multiple HTTPS websites by letting the client indicate which hostname it is trying to connect to at the start of the handshake
B) A tool to crack passwords
C) A routing protocol
D) A type of symmetric key

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: একটি সার্ভারে (একই IP তে) একাধিক ডোমেইন হোস্ট করা থাকলে, হ্যান্ডশেকের শুরুতেই ব্রাউজার SNI এর মাধ্যমে বলে দেয় যে সে কোন ডোমেইনের সার্টিফিকেট চাচ্ছে।
</details>

---

**Q33. What is "HSTS" (HTTP Strict Transport Security)?**
A) A faster version of HTTP
B) A web server directive (header) that forces the browser to ONLY communicate over HTTPS and completely ignore any HTTP requests for that domain
C) A database security measure
D) A CSS rule

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: HSTS অন করা থাকলে, কোনো ইউজার ভুল করে `http://` লিখলেও ব্রাউজার নিজে থেকেই সেটাকে `https://` বানিয়ে দেয়। এটি Downgrade Attack থেকে বাঁচায়।
</details>

---

**Q34. [Scenario] You intercept an encrypted TLS packet. You know the server's Public Key. Can you decrypt the packet?**
A) Yes, because the Public Key can decrypt it
B) No, the Public Key is only used for encryption. Only the server's Private Key (which you don't have) can decrypt it.
C) Yes, if you use a brute-force attack for 5 minutes
D) Yes, if you intercept it twice

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Asymmetric এনক্রিপশনের নিয়মই হলো, Public Key দিয়ে শুধু লক করা যায়। আনলক করতে হলে মাস্ট Private Key লাগবেই।
</details>

---

**Q35. How does a CA technically "sign" a certificate?**
A) By printing it and putting a stamp
B) By taking a Hash of the certificate data and encrypting that Hash with the CA's own Private Key. (Browsers then decrypt it with the CA's pre-installed Public Key to verify).
C) By modifying the HTML
D) By embedding a password

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: CA তার নিজের Private Key দিয়ে সার্টিফিকেটের একটি হ্যাশকে এনক্রিপ্ট করে দেয় (ডিজিটাল সিগনেচার)। আপনার ব্রাউজারের কাছে CA এর Public Key থাকে, তাই সে সহজেই সিগনেচারটা চেক করে বুঝতে পারে এটি আসল CA এর কাজ।
</details>

---

**Q36. What happens if a CA's own Private Key gets hacked?**
A) Nothing, it's safe
B) It is a catastrophe. The hacker can generate valid, trusted certificates for ANY website (like google.com) and perform flawless MitM attacks. The CA must be revoked globally.
C) The internet gets faster
D) Only HTTP sites are affected

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: CA এর প্রাইভেট কি লিক হওয়া মানে ইন্টারনেটের সবচেয়ে বড় বিপর্যয়। হ্যাকার ফেক ওয়েবসাইট বানিয়ে আসল CA-এর সিগনেচার দিয়ে দেবে, আর আপনার ব্রাউজার বুঝতেই পারবে না যে ওয়েবসাইটটি ফেক!
</details>

---

**Q37. What is the difference between a `.pem` file and a `.crt` file?**
A) `.pem` is for Windows, `.crt` is for Mac
B) `.crt` is only for images
C) They are often the same base64 encoded text data (PEM format), just with different file extensions used by convention
D) `.pem` contains viruses

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: সার্ভারের সার্টিফিকেট বা কি ফাইলে সাধারণত Base64 এনকোড করা টেক্সট থাকে, যা `-----BEGIN CERTIFICATE-----` দিয়ে শুরু হয়। একে PEM ফরম্যাট বলে। `.crt` বা `.pem` এক্সটেনশন যাই হোক না কেন, ভেতরের জিনিস সেম।
</details>

---

**Q38. Why is it dangerous to ignore browser certificate warnings (e.g., clicking "Proceed to unsafe site")?**
A) Your computer will restart
B) You are actively choosing to trust a connection that might be intercepted by a hacker (MitM), meaning your passwords and data are exposed
C) The website will load slower
D) Your IP will be banned

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ব্রাউজার ওয়ার্নিং দেওয়ার মানে হলো সে ওয়েবসাইটটিকে ট্রাস্ট করতে পারছে না। সেখানে "Proceed" করার মানে হলো আপনি জেনেশুনেই হ্যাকারকে আপনার ডেটা দেখার পারমিশন দিয়ে দিচ্ছেন।
</details>

---

**Q39. [Code Logic] In the Node.js `https` module, what does the `key` property in the options object expect?**
A) The password to the database
B) The contents of the Private Key file (used to decrypt incoming master secrets)
C) A random API key
D) The CA's public key

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `options.key` এর মধ্যে সার্ভারের Private Key ফাইলটি (যেমন `fs.readFileSync('key.pem')`) দিতে হয়।
</details>

---

**Q40. [Conclusion] In one sentence, why do we use a hybrid of Asymmetric and Symmetric encryption in TLS?**
A) Because two is better than one
B) Asymmetric encryption securely solves the "Key Distribution Problem," enabling the safe exchange of a Symmetric Key, which is then used because it is much faster for bulk data transfer.
C) To confuse hackers
D) Because CAs require it

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটিই TLS এর মূল মন্ত্র। চাবি এক্সচেঞ্জ করার জন্য সেফ কিন্তু স্লো Asymmetric ব্যবহার করা হয়। আর চাবি এক্সচেঞ্জ হয়ে গেলে পুরো ডেটা পাঠানোর জন্য ফাস্ট Symmetric ব্যবহার করা হয়।
</details>
