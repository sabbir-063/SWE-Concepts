# 01. Encryption & Hashing (Practice MCQs)

This file contains 40 in-depth MCQs covering the differences between Encoding, Encryption, and Hashing, Symmetric vs Asymmetric algorithms, Salting, Peppering, Bcrypt, and Rainbow Tables.

---

**Q1. What is the primary purpose of "Encoding"?**
A) To hide data from hackers
B) To transform data into a different format (like Base64) using a publicly available scheme so that it can be safely and easily consumed by different systems
C) To create a digital signature
D) To permanently delete data

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এনকোডিংয়ের কাজ ডেটা লুকানো বা সিকিউর করা নয়। এর কাজ হলো ডেটার ফরম্যাট চেঞ্জ করা, যাতে সিস্টেম (যেমন ব্রাউজার বা ইমেইল) তা সহজে বুঝতে পারে। যে কেউ চাইলেই এটিকে আগের রূপে ফিরিয়ে আনতে পারে।
</details>

---

**Q2. Does Encoding use a Secret Key or Password?**
A) Yes, a 256-bit key
B) No. Encoding algorithms (like Base64 or URL Encoding) are publicly known, and anyone can decode the data without needing any secret key.
C) Yes, but only in Java
D) Only when sent over HTTPS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এনকোডিংয়ে কোনো চাবির দরকার হয় না। Base64 দিয়ে এনকোড করলে যে কেউ আবার Base64 ডিকোড করে ডেটা পড়ে ফেলতে পারবে।
</details>

---

**Q3. What is the primary purpose of "Encryption"?**
A) To reduce the file size
B) To transform plaintext into an unreadable format (ciphertext) using a secret Key, ensuring that ONLY someone with the correct Key can decrypt and read it
C) To verify the integrity of a file
D) To convert XML to JSON

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এনক্রিপশনের মূল কাজই হলো ডেটা লুকিয়ে ফেলা বা সিকিউর করা। যার কাছে চাবি (Key) আছে, শুধু সে-ই এটি পড়তে পারবে।
</details>

---

**Q4. Is Encryption a Two-way or One-way function?**
A) One-way
B) Two-way (Reversible). Data is encrypted into ciphertext, and can be decrypted back into the exact original plaintext using a key.
C) Three-way
D) No-way

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এনক্রিপশন সবসময় দ্বিমুখী (Two-way)। চাবি দিয়ে ডেটা লক করা যায়, আবার সেই চাবি দিয়ে আনলক করে আগের ডেটা ফেরত পাওয়া যায়।
</details>

---

**Q5. What is the primary purpose of "Hashing"?**
A) To compress video files
B) To generate a fixed-size, unique digital fingerprint (hash) of an input data, primarily used to verify data Integrity and store passwords safely
C) To encrypt files before emailing them
D) To translate languages

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাশিংয়ের কাজ হলো ডেটার একটি ইউনিক ফিঙ্গারপ্রিন্ট তৈরি করা। এটি দিয়ে আমরা চেক করি ডেটা চেঞ্জ হয়েছে কি না (Integrity), এবং পাসওয়ার্ড সেভ রাখি।
</details>

---

**Q6. Is Hashing a Two-way or One-way function?**
A) Two-way
B) One-way (Irreversible). It is mathematically practically impossible to reverse a hash back to its original input data.
C) Reversible with a master key
D) Reversible only on Linux

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাশিং একমুখী (One-way)। একবার হ্যাশ হয়ে গেলে কোনোভাবেই আর আগের ডেটা ফেরত পাওয়া সম্ভব নয়। এর কোনো আনলক করার চাবি থাকে না।
</details>

---

**Q7. If you hash a 1-character string and a 1-Gigabyte file using the SHA-256 algorithm, what will be the sizes of the resulting hashes?**
A) The file hash will be 1 Gigabyte, the string hash will be 1 byte
B) Both hashes will be exactly 256 bits (64 hexadecimal characters) in length.
C) The hash size depends on the RAM
D) The algorithm will crash on the 1GB file

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাশিংয়ের সবচেয়ে বড় বৈশিষ্ট্য হলো এটি সবসময় একটি নির্দিষ্ট সাইজের (Fixed-size) আউটপুট দেয়। ইনপুট যত বড় বা ছোটই হোক না কেন, SHA-256 সবসময় ২৫৬ বিটের আউটপুট দেবে।
</details>

---

**Q8. What is the "Avalanche Effect" in Hashing?**
A) When a server crashes due to too many requests
B) A property where changing even a single bit (like a comma) in the input data causes the resulting hash to change drastically and completely (typically more than 50% of the bits flip).
C) When hashes are frozen in memory
D) A type of network attack

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: তুষারপাত (Avalanche) যেমন ছোট থেকে বিশাল আকার ধারণ করে, তেমনি হ্যাশিংয়ে ডেটার মধ্যে একটি ডট (.) চেঞ্জ করে দিলেও পুরো হ্যাশ আউটপুটটি ১০০% চেঞ্জ হয়ে যায়!
</details>

---

**Q9. Which of the following is a classic example of "Encoding"?**
A) AES-256
B) RSA
C) Base64
D) SHA-256

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Base64 হলো একটি এনকোডিং মেকানিজম। বাকিগুলোর মধ্যে AES ও RSA হলো এনক্রিপশন, আর SHA-256 হলো হ্যাশিং।
</details>

---

**Q10. Which of the following is a classic example of "Symmetric Encryption"?**
A) MD5
B) Bcrypt
C) AES (Advanced Encryption Standard)
D) Base64

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: AES হলো সবচেয়ে বিখ্যাত সিমেট্রিক এনক্রিপশন (যাতে একটাই চাবি থাকে)।
</details>

---

**Q11. What defines "Symmetric Encryption"?**
A) It uses no keys
B) It uses the EXACT SAME secret key for both encrypting the plaintext and decrypting the ciphertext.
C) It uses a Public key and a Private key
D) It uses random numbers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সিমেট্রিক (Symmetric) মানে হলো সেম (Same)। অর্থাৎ লক করতেও যে চাবি লাগে, আনলক করতেও সেই একই চাবি লাগে।
</details>

---

**Q12. What defines "Asymmetric Encryption"?**
A) It uses a single key
B) It uses a mathematically linked pair of keys: A Public Key (shared with everyone) to encrypt data, and a Private Key (kept secret) to decrypt the data.
C) It encrypts only text, not images
D) It is much faster than Symmetric encryption

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: অ্যাসিমেন্ট্রিকে দুটি চাবি থাকে। পাবলিক কী দিয়ে যে কেউ ডেটা লক করে পাঠাতে পারে, কিন্তু আনলক করতে হলে শুধু রিসিভারের প্রাইভেট কী লাগবে।
</details>

---

**Q13. Which of the following is a classic example of "Asymmetric Encryption"?**
A) AES
B) RSA (Rivest-Shamir-Adleman)
C) SHA-1
D) URL Encoding

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: RSA হলো সবচেয়ে বিখ্যাত অ্যাসিমেন্ট্রিক এনক্রিপশন অ্যালগরিদম।
</details>

---

**Q14. In general, which is faster for encrypting large amounts of data: Symmetric or Asymmetric Encryption?**
A) Asymmetric is faster
B) Symmetric Encryption is MUCH faster and requires significantly less computational power, which is why it is used for bulk data encryption.
C) They are exactly the same speed
D) It depends on the internet connection

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সিমেট্রিক এনক্রিপশন (যেমন AES) অনেক ফাস্ট কাজ করে। তাই বড় ফাইল বা মুভি এনক্রিপ্ট করতে এটাই ইউজ করা হয়।
</details>

---

**Q15. Why should you NEVER store user passwords in plain text in a database?**
A) Because it takes up too much storage space
B) Because if the database is ever compromised (hacked or leaked), the attacker instantly has the real passwords of all users, which they often reuse on other websites.
C) Because the OS doesn't allow it
D) Because passwords have special characters

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্লেইন টেক্সটে সেভ রাখলে হ্যাকার ডাটাবেস চুরি করলেই সব পাসওয়ার্ড পেয়ে যাবে। আর মানুষ এক পাসওয়ার্ড সব জায়গায় ইউজ করে, তাই তার ফেসবুক, জিমেইল সব হ্যাক হয়ে যাবে।
</details>

---

**Q16. Should you use "Encryption" (like AES) to store passwords in a database?**
A) Yes, it's the most secure way
B) No. Encryption is reversible. If an attacker gains access to the database AND the secret key (often stored on the same server), they can decrypt all passwords back to plain text. Passwords should be Hashed, not encrypted.
C) Only for admin accounts
D) Yes, but only with RSA

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এনক্রিপ্ট করে রাখলে সমস্যা হলো, এর একটি আনলক করার চাবি থাকে। হ্যাকার ডাটাবেসের সাথে সার্ভার থেকে চাবিটাও চুরি করে নিলে সে সব পাসওয়ার্ড আনলক করে ফেলতে পারবে! তাই পাসওয়ার্ড সবসময় 'হ্যাশ' করে রাখতে হয় (যার কোনো চাবি নেই)।
</details>

---

**Q17. What is a "Rainbow Table"?**
A) A table with colorful CSS
B) A massive, pre-computed dictionary containing millions of common passwords (e.g., "123456", "password") and their corresponding Hashes, allowing hackers to quickly reverse-lookup a stolen hash.
C) A database routing table
D) A type of Excel spreadsheet

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রেইনবো টেবিল হলো হ্যাকারদের ডিকশনারি, যেখানে দুনিয়ার সব কমন পাসওয়ার্ড আর তার হ্যাশ আগে থেকেই ক্যালকুলেট করে রাখা আছে। হ্যাকার ডাটাবেস থেকে হ্যাশ চুরি করে এই ডিকশনারিতে খুঁজলেই আসল পাসওয়ার্ড পেয়ে যায়।
</details>

---

**Q18. How do we defend against Rainbow Table attacks when hashing passwords?**
A) By changing the database name
B) By adding a "Salt" (random characters) to the password before hashing it.
C) By zipping the database
D) By disabling the internet

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রেইনবো টেবিলকে ফাঁকি দেওয়ার জন্যই আমরা পাসওয়ার্ডের সাথে এক্সট্রা কিছু র‍্যান্ডম ক্যারেক্টার (Salt) অ্যাড করে দিই। ফলে ওই নতুন হ্যাশটি আর হ্যাকারের ডিকশনারিতে থাকে না!
</details>

---

**Q19. What is a "Salt" in cryptography?**
A) A hardware chip
B) A randomly generated string added to a user's password before it is hashed. A unique salt is generated for EVERY individual user and stored alongside the hash in the database.
C) A method to compress data
D) An antivirus signature

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সল্ট হলো কিছু র‍্যান্ডম ক্যারেক্টার (যেমন `x#9p`)। এটি প্রতিটি ইউজারের জন্য আলাদাভাবে তৈরি করা হয় এবং ডাটাবেসেই হ্যাশের পাশে সেভ করে রাখা হয়।
</details>

---

**Q20. If two users choose the exact same password (e.g., "apple"), but a unique Salt is used for each user, what happens to their final Hashes in the database?**
A) The hashes will be exactly the same
B) The hashes will be completely different, because `Hash("apple" + Salt1)` yields a drastically different result than `Hash("apple" + Salt2)`.
C) The database will throw a duplicate error
D) One account will be deleted

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: দুজনের পাসওয়ার্ড "apple" হলেও, দুজনের সল্ট আলাদা হবে। আর হ্যাশিংয়ের Avalanche রুল অনুযায়ী, একটু চেঞ্জ হলেই আউটপুট পুরো চেঞ্জ হয়ে যায়। তাই দুজনের হ্যাশ সম্পূর্ণ আলাদা হবে!
</details>

---

**Q21. What is a "Pepper" in cryptography?**
A) A type of firewall
B) A secret cryptographic key (a string) added to the password (along with the salt) before hashing. Unlike the salt, the Pepper is NOT stored in the database; it is hardcoded in the application source code or stored in Environment Variables.
C) A type of database
D) A hashing algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: পেপার হলো সল্টের বড় ভাই! সল্ট ডাটাবেসে থাকে, তাই হ্যাকার ডাটাবেস চুরি করলে সল্টও পেয়ে যায়। কিন্তু পেপার ডাটাবেসে থাকে না, থাকে সার্ভারের কোডে (ENV)। তাই ডাটাবেস হ্যাক হলেও পেপার ছাড়া হ্যাকার হ্যাশ ভাঙতে পারে না।
</details>

---

**Q22. What makes "Bcrypt" an excellent choice for hashing passwords?**
A) It is the fastest algorithm in the world
B) It is intentionally designed to be SLOW and computationally expensive. You can configure its "Work Factor" to make brute-force or dictionary attacks practically impossible for hackers, while regular logins only take a fraction of a second.
C) It compresses the password
D) It sends an SMS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাশিং ফাস্ট হওয়া ভালো, কিন্তু পাসওয়ার্ড হ্যাশিংয়ের ক্ষেত্রে স্লো হওয়াটাই ভালো! Bcrypt ইচ্ছে করেই স্লো কাজ করে, যাতে হ্যাকাররা স্ক্রিপ্ট দিয়ে সেকেন্ডে কোটি কোটি পাসওয়ার্ড গেস করতে না পারে।
</details>

---

**Q23. Does a developer using Bcrypt need to manually generate and store the Salt in a separate database column?**
A) Yes, always
B) No. Bcrypt automatically generates a secure random salt and includes it directly inside the final output hash string (e.g., the first 29 characters of a Bcrypt string contain algorithm info and the salt).
C) Only in PHP
D) Yes, in a separate table

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Bcrypt এর সবচেয়ে বড় সুবিধা হলো এটি নিজ দায়িত্বেই সল্ট জেনারেট করে এবং ফাইনাল হ্যাশের ভেতরেই সেই সল্ট লুকিয়ে রাখে। ডেভেলপারকে আলাদাভাবে সল্ট সেভ করতে হয় না।
</details>

---

**Q24. Which of the following is considered a weak and broken hashing algorithm that should NO LONGER be used for passwords?**
A) Bcrypt
B) Argon2
C) MD5
D) PBKDF2

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: MD5 এবং SHA-1 অনেক পুরনো এবং হ্যাক হয়ে গেছে। এগুলো এখন পাসওয়ার্ড সেভ করার জন্য ব্যবহার করা একদমই উচিত নয়।
</details>

---

**Q25. What is a "Hash Collision"?**
A) When two cars crash
B) When two completely DIFFERENT input strings somehow produce the EXACT SAME output hash. (A severe flaw in older algorithms like MD5).
C) When a hash is too long
D) When the database runs out of memory

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু হ্যাশের সাইজ ফিক্সড (যেমন ২৫৬ বিট), তাই গাণিতিকভাবে এটা সম্ভব যে দুটি আলাদা ডেটার হ্যাশ সেম হয়ে যেতে পারে (যদিও এর চান্স কোটিতে এক)। একেই Collision বলে। MD5 এ এমন সমস্যা প্রচুর পাওয়া গেছে।
</details>

---

**Q26. What does it mean when a Cryptographic function is described as "Deterministic"?**
A) It has a mind of its own
B) Providing the exact same input will ALWAYS produce the exact same output hash, no matter how many times you run it or what computer you run it on.
C) It uses artificial intelligence
D) The output changes every time

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Deterministic মানে হলো আউটপুট ফিক্সড। "1234" এর হ্যাশ আপনি আজকে করলেও যা আসবে, ১০ বছর পর করলেও হুবহু তাই আসবে।
</details>

---

**Q27. When authenticating a user during Login, what exactly does the server do?**
A) It decrypts the hash from the database and compares it to the plaintext input
B) It takes the plaintext password entered by the user, hashes it using the exact same algorithm (and same salt), and compares the RESULTING HASH with the hash stored in the database.
C) It emails the password
D) It bypasses the hash check

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সার্ভার কখনো ডাটাবেসের হ্যাশকে ডিক্রিপ্ট করতে পারে না (কারণ হ্যাশ One-way)। তাই সে ইউজারের দেওয়া পাসওয়ার্ডকে নতুন করে আবার হ্যাশ বানায়, তারপর সেই নতুন হ্যাশের সাথে ডাটাবেসের পুরনো হ্যাশ মিলিয়ে দেখে।
</details>

---

**Q28. What is the standard hashing algorithm used in Blockchain technologies like Bitcoin?**
A) MD5
B) Base64
C) SHA-256 (Secure Hash Algorithm 256-bit)
D) AES

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: বিটকয়েন বা ব্লকচেইনের ট্রানজেকশন সিকিউর করার জন্য SHA-256 অ্যালগরিদম ব্যবহার করা হয়।
</details>

---

**Q29. Which of the following is true about Base64?**
A) It provides strong encryption
B) It expands the original data size by about 33% and is mainly used to safely transmit binary data (like images) over text-based protocols (like JSON/HTML)
C) It is a hashing algorithm
D) It shrinks data size

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Base64 হলো একটি এনকোডিং প্রসেস। এটি সাধারণত ইমেজের মতো বাইনারি ডেটাকে টেক্সটে কনভার্ট করার কাজে লাগে, যাতে সেটি JSON এর মাধ্যমে পাঠানো যায়। এতে ডেটার সাইজ কিছুটা বেড়ে যায়।
</details>

---

**Q30. If you see a string ending with one or two equals signs (e.g., `SGVsbG8gV29ybGQ==`), what format is it most likely in?**
A) SHA-256 Hash
B) AES Ciphertext
C) Base64 Encoded string (The equals signs are used for padding)
D) A SQL Injection

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Base64 স্ট্রিংয়ের শেষে প্রায়ই `==` বা `=` চিহ্ন থাকে, যাকে Padding বলা হয়। এটি দেখলেই বোঝা যায় যে এটি Base64 এনকোড করা ডেটা।
</details>

---

**Q31. In Java, what class from `javax.crypto` is primarily used to perform Encryption and Decryption?**
A) `String`
B) `Cipher`
C) `Math`
D) `System`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: জাভাতে এনক্রিপ্ট বা ডিক্রিপ্ট করার জন্য `Cipher` ক্লাসটি ব্যবহার করা হয়।
</details>

---

**Q32. [Code Logic] If a developer writes: `BCrypt.hashpw(password, BCrypt.gensalt(4));`, what is the security implication of the `4`?**
A) It will encrypt it 4 times
B) The Work Factor is 4, which is extremely low and very fast to compute, making the hash highly vulnerable to brute-force attacks. (Default is usually 10 or 12).
C) It adds 4 characters of salt
D) It limits the password to 4 letters

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Bcrypt এ `gensalt(12)` মানে হলো এটি প্রচুর স্লো হবে (যা সিকিউরিটির জন্য ভালো)। এখানে `4` দিলে এটি এতই ফাস্ট হবে যে হ্যাকার সহজেই ব্রুট-ফোর্স করে ভেঙে ফেলবে।
</details>

---

**Q33. Which algorithm is best suited for encrypting a 5GB database backup file?**
A) RSA
B) Bcrypt
C) AES (Symmetric)
D) SHA-256

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ৫ জিবি ফাইল হ্যাশ (SHA) করলে তো আগের ডেটা আর ফেরত পাওয়া যাবে না! আর RSA (Asymmetric) অনেক স্লো কাজ করে। তাই বড় ফাইল লক করার জন্য AES (Symmetric) ই বেস্ট।
</details>

---

**Q34. Which algorithm is best suited for securely exchanging a secret key over an insecure public internet connection?**
A) AES
B) MD5
C) RSA (Asymmetric)
D) Base64

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ইন্টারনেটে চাবি আদানপ্রদানের জন্য RSA (পাবলিক-প্রাইভেট কী) সবচেয়ে সেফ। আমরা HTTPS চ্যাপ্টারে পড়েছি যে 클ায়েন্ট ও সার্ভার প্রথমে RSA দিয়ে চাবি শেয়ার করে, তারপর AES দিয়ে ফাস্ট কথা বলে।
</details>

---

**Q35. What is a "Digital Signature"?**
A) A scanned image of your handwritten signature
B) A cryptographic mechanism (combining Hashing and Asymmetric Encryption) used to verify the Authenticity and Integrity of a message or document.
C) A stylish font
D) A watermark

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডিজিটাল সিগনেচারে ডেটাকে প্রথমে হ্যাশ করা হয়, তারপর সেন্ডার তার Private key দিয়ে সেটিকে লক করে পাঠায়। রিসিভার পাবলিক কী দিয়ে আনলক করে হ্যাশ মেলায়। এটি দিয়ে শিওর হওয়া যায় যে ডেটাটি আসল মানুষই পাঠিয়েছে এবং মাঝপথে কেউ চেঞ্জ করেনি।
</details>

---

**Q36. What is the fundamental difference between Encryption and Encoding?**
A) Encoding uses AES, Encryption uses Base64
B) Encryption is designed to maintain confidentiality and requires a key. Encoding is designed for data usability/format compatibility and requires no key.
C) They are the exact same thing
D) Encoding is illegal

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এনক্রিপশনের উদ্দেশ্য হলো ডেটা সিকিউর করা (চাবি লাগে)। এনকোডিংয়ের উদ্দেশ্য হলো ডেটার ফরম্যাট চেঞ্জ করা (কোনো চাবি লাগে না)।
</details>

---

**Q37. What is the fundamental difference between Encryption and Hashing?**
A) Encryption is One-way, Hashing is Two-way
B) Encryption is reversible (Two-way) if you have the key. Hashing is mathematically irreversible (One-way).
C) Hashing is only for images
D) Encryption is open-source

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এনক্রিপশন হলো একটি তালা (চাবি দিয়ে আনলক করা যায়)। আর হ্যাশিং হলো একটি মিক্সার মেশিন (একবার মিক্স করলে আর আগের ফল ফেরত পাওয়া যায় না)।
</details>

---

**Q38. Why might an application use both Salt and Pepper together?**
A) To make the code look professional
B) Defense in Depth: Salt protects against Rainbow Tables if the database is leaked. Pepper adds a second layer of defense requiring the attacker to also compromise the application server to get the Pepper key.
C) To compress the database
D) It's required by law

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সল্ট হ্যাকারের ডিকশনারি অ্যাটাক ঠেকায়। আর পেপার সার্ভারে সেভ থাকায়, হ্যাকার ডাটাবেস চুরি করলেও পেপার না পাওয়ায় কিছুই করতে পারে না। এটি ডাবল সিকিউরিটি দেয়।
</details>

---

**Q39. What is a "Brute Force" attack on passwords?**
A) Using a hammer on the server
B) An attacker systematically trying every single possible combination of characters (e.g., aaaa, aaab, aaac...) until they find the correct password.
C) Hacking the Wi-Fi
D) Phishing

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ব্রুট-ফোর্স হলো একটি একটি করে দুনিয়ার সব সম্ভাব্য পাসওয়ার্ড ট্রাই করে দেখা, যতক্ষণ না সঠিক পাসওয়ার্ডটি মিলে যায়। Bcrypt এর স্লোনেস এই অ্যাটাককেই আটকে দেয়।
</details>

---

**Q40. [Conclusion] If you are building a Login system today, what is the absolute minimum standard you must follow?**
A) Store passwords in plain text
B) Store passwords using Base64 encoding
C) Hash passwords using MD5
D) Hash passwords using a slow, salted algorithm like Bcrypt, Argon2, or PBKDF2
<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: বর্তমান যুগে পাসওয়ার্ড সেভ করার একমাত্র নিরাপদ উপায় হলো Bcrypt বা Argon2 এর মতো স্লো এবং সল্টেড হ্যাশিং অ্যালগরিদম ব্যবহার করা।
</details>
