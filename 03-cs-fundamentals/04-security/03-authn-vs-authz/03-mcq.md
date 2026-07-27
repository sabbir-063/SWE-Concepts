# 03. Authentication vs Authorization (Practice MCQs)

This file contains 40 in-depth MCQs covering the core differences between Authentication (AuthN) and Authorization (AuthZ), HTTP Status codes 401 and 403, Role-Based Access Control (RBAC), and the Principle of Least Privilege.

---

**Q1. What is the primary purpose of "Authentication" (AuthN)?**
A) To determine what a user is allowed to do
B) To verify the identity of a user, device, or system (answering "Who are you?")
C) To encrypt the database
D) To format the hard drive

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Authentication এর মূল কাজই হলো ইউজারের পরিচয় নিশ্চিত করা। অর্থাৎ আপনি দাবি করছেন আপনি 'রাকিব', সিস্টেম সেটি ভেরিফাই করে দেখবে।
</details>

---

**Q2. Which of the following is a mechanism used for Authentication?**
A) Checking if a user has the "ADMIN" role
B) Verifying a username and password
C) Determining if a user can delete a file
D) Giving a user access to the VIP lounge

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউজারনেম এবং পাসওয়ার্ড দিয়ে আমরা প্রমাণ করি যে আমরা কে (Identity)। এটি Authentication এর পার্ট।
</details>

---

**Q3. What is the primary purpose of "Authorization" (AuthZ)?**
A) To check the user's password
B) To verify a user's fingerprint
C) To determine what an authenticated user is permitted to do or access within the system (answering "What can you do?")
D) To send an OTP via SMS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Authorization ডিসাইড করে যে আপনার কতটুকু পাওয়ার বা পারমিশন আছে। আপনি লগইন করার পর কোন পেজে যেতে পারবেন আর কোনটাতে পারবেন না, সেটি Authorization ঠিক করে।
</details>

---

**Q4. In a typical application workflow, which comes first?**
A) Authorization happens first, then Authentication
B) They happen at the exact same time
C) Authentication happens first, then Authorization
D) It depends on the operating system

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: আপনি কে, সেটাই যদি সিস্টেম না জানে (Authentication), তবে সে আপনাকে পাওয়ার (Authorization) দেবে কীভাবে? তাই সবসময় আগে লগইন (AuthN) করতে হয়, তারপর পারমিশন (AuthZ) চেক করা হয়।
</details>

---

**Q5. When you log into Facebook using your email and password, which process is taking place?**
A) Authorization
B) Authentication
C) Encryption
D) Hashing

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: লগইন করা মানেই হলো নিজের পরিচয় প্রমাণ করা (Authentication)।
</details>

---

**Q6. When you are logged into Facebook, you can edit your own profile but you CANNOT edit Mark Zuckerberg's profile. Which process enforces this rule?**
A) Authentication
B) Encryption
C) Authorization
D) Compression

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: আপনি যে অন্যের প্রোফাইল এডিট করার পারমিশন রাখেন না, সেটি Authorization বা Access Control হ্যান্ডেল করে।
</details>

---

**Q7. What does the HTTP Status Code `401 Unauthorized` actually mean in the context of web security?**
A) The user is banned
B) Unauthenticated: The client must authenticate itself (e.g., log in) to get the requested response.
C) The user lacks the necessary admin roles
D) The server is down

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এর নাম 'Unauthorized' হলেও এটি মূলত Authentication ফেইল করার এরর। এর মানে হলো: "আমি জানি না আপনি কে, দয়া করে আগে লগইন করে আসুন!"
</details>

---

**Q8. What does the HTTP Status Code `403 Forbidden` mean?**
A) The user entered the wrong password
B) The client is authenticated (the server knows who they are), but they do NOT have the necessary permissions/authorization to access the resource.
C) The website is blocked by the government
D) The server cannot find the page

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 403 এর মানে হলো সিস্টেম জানে আপনি কে, কিন্তু আপনার ওই পেজে ঢোকার কোনো পারমিশন (Authorization) নেই। এটি আপনার জন্য নিষিদ্ধ (Forbidden)।
</details>

---

**Q9. If an anonymous user (not logged in) tries to access a protected `/dashboard` page, which HTTP status code should the server ideally return?**
A) 200 OK
B) 403 Forbidden
C) 401 Unauthorized
D) 500 Internal Server Error

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেহেতু সে লগইন করেনি (Unauthenticated), তাই তাকে 401 Unauthorized এরর দিতে হবে, যাতে সে বুঝতে পারে যে তাকে আগে লগইন করতে হবে।
</details>

---

**Q10. If a regular logged-in user tries to access the `/admin-panel` page, which HTTP status code should the server return?**
A) 401 Unauthorized
B) 403 Forbidden
C) 404 Not Found
D) 200 OK

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু সে লগইন করা আছে কিন্তু তার অ্যাডমিন হওয়ার পারমিশন নেই, তাই তাকে 403 Forbidden এরর দিতে হবে।
</details>

---

**Q11. What is "MFA" or "2FA"?**
A) A type of authorization model
B) Multi-Factor Authentication (or Two-Factor Authentication): Requiring two or more pieces of evidence (factors) to authenticate a user, such as a password (something you know) and an SMS OTP (something you have).
C) A hashing algorithm
D) A firewall setting

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: শুধু পাসওয়ার্ড হ্যাক হয়ে যেতে পারে, তাই সিকিউরিটি বাড়ানোর জন্য পাসওয়ার্ডের পাশাপাশি ফোনে আসা OTP বা ফিঙ্গারপ্রিন্ট দেওয়াকে 2FA (Two-Factor Authentication) বলে।
</details>

---

**Q12. Which of the following is NOT a common Authentication factor?**
A) Something you know (Password, PIN)
B) Something you have (Smartphone, Smart Card)
C) Something you are (Fingerprint, Iris scan)
D) Something you want (Role, Permission)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: Authentication এর মূল ৩টি ফ্যাক্টর হলো: আপনি যা জানেন (পাসওয়ার্ড), আপনার কাছে যা আছে (ফোন), এবং আপনি নিজে যা (বায়োমেট্রিক)। Role বা Permission হলো Authorization এর পার্ট।
</details>

---

**Q13. What does RBAC stand for?**
A) Routing Based Access Control
B) Role-Based Access Control
C) Random Base Authentication Code
D) Remote Backup and Configuration

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: RBAC (Role-Based Access Control) হলো Authorization হ্যান্ডেল করার সবচেয়ে পপুলার মেথড।
</details>

---

**Q14. How does Role-Based Access Control (RBAC) work?**
A) Permissions are assigned directly to individual users
B) Users are assigned specific Roles (e.g., Admin, Editor, Viewer), and Permissions are assigned to those Roles. Users inherit the permissions of their assigned roles.
C) Users must guess a password to get a role
D) Permissions change randomly every hour

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এখানে সরাসরি ইউজারকে পারমিশন দেওয়া হয় না। পারমিশনগুলো একটি Role (যেমন Admin) এর ওপর দেওয়া হয়। এরপর ইউজারকে শুধু ওই Role টি অ্যাসাইন করে দেওয়া হয়।
</details>

---

**Q15. What is the primary benefit of using RBAC over assigning permissions directly to users?**
A) It makes the website faster
B) Manageability and Scalability. If a company hires 100 new Editors, the admin simply assigns them the "Editor" role instead of manually configuring 100 sets of complex permissions.
C) It encrypts the database
D) It prevents DDoS attacks

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: বারবার ১০০ জনকে আলাদা পারমিশন দেওয়ার চেয়ে, একটি Role বানিয়ে ১০০ জনকে সেই Role এ অ্যাড করে দেওয়াটা অনেক ইজি এবং স্কেলেবল।
</details>

---

**Q16. In an RBAC system, if the "Editor" role has the permission to `PUBLISH_POST`, and user 'Alice' is assigned the "Editor" role, can Alice publish a post?**
A) No
B) Yes, because she inherits the permissions of her role
C) Only if she is also an Admin
D) Only on Tuesdays

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউজার তার Role এর সব পারমিশন অটোমেটিক পেয়ে যায় (Inherit করে)। তাই সে পাবলিশ করতে পারবে।
</details>

---

**Q17. What does ABAC stand for?**
A) Authorization Based Access Code
B) Attribute-Based Access Control
C) Automatic Backup and Clean
D) Advanced Biometric Authentication Control

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ABAC হলো RBAC এর চেয়েও অ্যাডভান্সড একটি Authorization মডেল।
</details>

---

**Q18. How does Attribute-Based Access Control (ABAC) differ from RBAC?**
A) ABAC is older and deprecated
B) ABAC grants access based on dynamic attributes and policies (e.g., User's location, Time of day, Device security level) rather than just a static Role.
C) ABAC is only used for databases
D) There is no difference

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: RBAC শুধু Role চেক করে। কিন্তু ABAC ইউজারের রোল, লোকেশন, বয়স, সময়—সবকিছু (Attributes) চেক করে অনেক জটিল কন্ডিশন অনুযায়ী পারমিশন দিতে পারে।
</details>

---

**Q19. "A doctor can view patient records, but ONLY during their scheduled hospital shift hours." Which access control model is best suited to enforce this rule easily?**
A) RBAC (Role-Based Access Control)
B) ABAC (Attribute-Based Access Control)
C) MAC (Mandatory Access Control)
D) Basic Authentication

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এখানে শুধু 'Doctor' রোল থাকলেই হবে না, 'Time' (সময়) এর অ্যাট্রিবিউটও চেক করতে হবে। তাই এটি ABAC দিয়ে করা সবচেয়ে সহজ।
</details>

---

**Q20. What is the "Principle of Least Privilege" (POLP)?**
A) Paying developers the minimum wage
B) A security discipline that requires that a particular user, system, or application be given no more privilege (access) than strictly necessary to perform its intended function.
C) Giving everyone Admin rights to make things easier
D) Using the shortest possible passwords

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সিকিউরিটির গোল্ডেন রুল হলো: যার যতটুকু পাওয়ার দরকার, তাকে ঠিক ততটুকুই পাওয়ার দেওয়া। এক বিন্দুও বেশি পাওয়ার না দেওয়া।
</details>

---

**Q21. Why is the Principle of Least Privilege important?**
A) It saves hard drive space
B) It minimizes the potential damage if a user's account is compromised. An attacker who hijacks a restricted "Viewer" account cannot delete the database.
C) It makes the internet faster
D) It prevents hardware failures

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাকার যদি সাধারণ কোনো ইউজারের অ্যাকাউন্ট হ্যাকও করে ফেলে, Least Privilege এর কারণে সে ওই অ্যাকাউন্ট দিয়ে ডাটাবেস ডিলিট করার মতো বড় কোনো ক্ষতি করতে পারবে না।
</details>

---

**Q22. In Linux, what does the command `chmod` relate to?**
A) Authentication
B) Authorization (It changes file permissions/access rights for Users, Groups, and Others)
C) Encryption
D) Hashing

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `chmod` কমান্ড দিয়ে লিনাক্সে ঠিক করে দেওয়া হয় যে কোন ফাইল কে রিড বা রাইট করতে পারবে। এটি পুরোপুরি Authorization এর কাজ।
</details>

---

**Q23. What is "OAuth 2.0"?**
A) A new version of HTML
B) An industry-standard protocol for Authorization. It allows a user to grant a third-party application limited access to their resources on another site (like letting a game access your Facebook friends list) WITHOUT sharing their password.
C) A hashing algorithm
D) A type of firewall

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আপনি যখন কোনো গেমে "Login with Facebook" দেন, তখন আপনি আসলে গেমটিকে আপনার পাসওয়ার্ড দিচ্ছেন না, শুধু একটি টোকেন (Authorization) দিচ্ছেন, যাতে সে আপনার প্রোফাইল পিকচার বা ফ্রেন্ডলিস্ট দেখতে পারে। এটি OAuth 2.0 প্রটোকল দিয়ে কাজ করে।
</details>

---

**Q24. Does OAuth 2.0 handle Authentication or Authorization?**
A) Authentication only
B) Primarily Authorization (Delegated Access). (However, extensions like OpenID Connect add Authentication on top of it).
C) Neither
D) Both equally by default

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: OAuth 2.0 মূলত Authorization বা পারমিশন শেয়ার করার জন্য বানানো হয়েছিল। তবে বর্তমানে এর ওপর OpenID Connect (OIDC) লেয়ার বসিয়ে Authentication এর কাজেও ইউজ করা হয়।
</details>

---

**Q25. What is a "JWT" (JSON Web Token)?**
A) A JavaScript framework
B) A compact, URL-safe means of representing claims to be transferred between two parties. It is heavily used in modern web apps to securely transmit information about the user's Authentication and Authorization state after login.
C) A type of NoSQL database
D) A CSS preprocessor

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউজার একবার লগইন করলে সার্ভার তাকে একটি টোকেন (JWT) দেয়। ওই টোকেনের ভেতরেই লেখা থাকে যে ইউজার কে এবং তার রোল কী (AuthN + AuthZ)। পরবর্তীতে ইউজার ওই টোকেন দেখিয়েই সব কাজ করে।
</details>

---

**Q26. Is the data inside a standard JWT encrypted or just encoded?**
A) Encrypted (No one can read it)
B) Encoded (Base64). Anyone who intercepts the token can decode and read the payload (like the user ID or role). It relies on a Signature to prevent tampering, not encryption for secrecy.
C) Hashed
D) Zipped

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি ইন্টারভিউয়ের খুবই কমন প্রশ্ন! JWT এর ভেতরের ডেটা এনক্রিপ্ট করা থাকে না, শুধু Base64 দিয়ে এনকোড করা থাকে। যে কেউ টোকেন ডিকোড করে ডেটা পড়তে পারবে। তবে সে ডেটা চেঞ্জ করতে পারবে না, কারণ এর শেষে একটি সিকিউরিটি সিগনেচার (Signature) থাকে।
</details>

---

**Q27. What is "SSO" (Single Sign-On)?**
A) Using a password with exactly one character
B) An authentication scheme that allows a user to log in with a single ID and password to any of several related, yet independent, software systems (e.g., logging into Gmail automatically logs you into YouTube and Google Drive).
C) Only allowing one user to use the app at a time
D) A single server handling all requests

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একবার লগইন করেই ওই কোম্পানির অন্য সব সার্ভিসে অটোমেটিক লগইন হয়ে যাওয়াকেই Single Sign-On (SSO) বলে। এতে ইউজারকে বারবার পাসওয়ার্ড দিতে হয় না।
</details>

---

**Q28. What is "Biometric Authentication"?**
A) Using a biological password like "DNA"
B) Verifying a person's identity using unique biological traits, such as fingerprints, facial recognition, or iris patterns.
C) Authenticating plants and animals
D) Using a smartwatch

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফিঙ্গারপ্রিন্ট বা ফেস-আইডি দিয়ে লগইন করাকে বায়োমেট্রিক অথেনটিকেশন বলে। এটি "Something you are" ক্যাটাগরিতে পড়ে।
</details>

---

**Q29. In a Web API, where should Authorization checks take place?**
A) Only on the frontend (Client-side)
B) On every single relevant route/endpoint on the Backend (Server-side). Frontend checks are only for UX (hiding buttons), not for real security.
C) Only during login
D) Only in the database

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফ্রন্টএন্ডে বাটন হাইড করে রাখলে হ্যাকার পোস্টম্যান (Postman) দিয়ে সরাসরি API তে হিট করবে। তাই আসল সিকিউরিটি বা Authorization চেক সবসময় ব্যাকএন্ডের API তেই করতে হয়।
</details>

---

**Q30. What is "Session Hijacking"?**
A) Stealing a user's laptop
B) An attack where a hacker steals a user's valid Session ID (often via XSS) and uses it to impersonate the user (Authentication bypass).
C) Hacking a conference session
D) Crashing the server

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আপনার লগইন করার পর ব্রাউজারে যে সেশন কুকি (Session ID) সেভ থাকে, হ্যাকার যদি কোনোভাবে সেটি চুরি করে নেয়, তবে সে পাসওয়ার্ড ছাড়াই আপনার অ্যাকাউন্টে ঢুকে যেতে পারবে। একেই সেশন হাইজ্যাকিং বলে।
</details>

---

**Q31. Which of the following best describes "Identity and Access Management" (IAM)?**
A) A framework for managing both Authentication (Identity) and Authorization (Access) policies across an organization.
B) A new programming language
C) An antivirus software
D) A database management system

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: বড় বড় কোম্পানিতে হাজার হাজার ইউজারের আইডেন্টিটি এবং কার কী পাওয়ার আছে, তা ম্যানেজ করার পুরো সিস্টেমটিকেই IAM বলা হয় (যেমন: AWS IAM)।
</details>

---

**Q32. [Code Logic] If a middleware function checks `if (user.role === 'ADMIN')`, what process is it performing?**
A) Authentication
B) Authorization
C) Encryption
D) Logging

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউজারের রোল বা পারমিশন চেক করা মানেই হলো সে Authorization চেক করছে।
</details>

---

**Q33. [Code Logic] If a middleware function checks `bcrypt.compare(inputPass, dbHash)`, what process is it performing?**
A) Authentication
B) Authorization
C) File Compression
D) Routing

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: পাসওয়ার্ড চেক করে ইউজারের আইডেন্টিটি কনফার্ম করা মানেই হলো সে Authentication চেক করছে।
</details>

---

**Q34. What is "IDOR" (Insecure Direct Object Reference)?**
A) An Authentication failure
B) An Authorization failure (Broken Access Control) where an application provides direct access to objects based on user-supplied input (like changing `id=1` to `id=2` in a URL) without properly checking if the user is Authorized to view the other object.
C) A database error
D) A UI bug

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: URL এর শেষে আইডি চেঞ্জ করে অন্যের ডেটা দেখে ফেলার এই দুর্বলতাটি মূলত Authorization এর অভাবের কারণেই ঘটে। সার্ভার চেক করতে ভুলে যায় যে ওই ডেটা দেখার পারমিশন ইউজারের আছে কি না।
</details>

---

**Q35. In an enterprise system, what is the concept of "Separation of Duties" (SoD)?**
A) Giving everyone the exact same duties
B) Dividing a critical task among multiple users so that no single person has enough power/authorization to complete it alone (e.g., one person creates a check, another must approve it), reducing the risk of fraud.
C) Separating frontend and backend code
D) Working in different timezones

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একটি কাজকে ভাগ করে দেওয়া, যাতে একজন চাইলেই কোনো ফ্রড না করতে পারে। যেমন: ব্যাংকে একজন চেক এন্ট্রি করে, কিন্তু তাকে অ্যাপ্রুভ করার পাওয়ার অন্য আরেকজন ম্যানেজারের কাছে থাকে। এটিও Authorization এর একটি কনসেপ্ট।
</details>

---

**Q36. What is the main drawback of using basic API Keys for Authentication compared to JWTs?**
A) API Keys are too long
B) API Keys typically don't carry internal information (like roles or expiry times); the server must constantly hit the database to validate the key and fetch the user's role. JWTs contain this information inside the token itself.
C) API Keys cost money
D) API Keys only work on Windows

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সাধারণ API Key দেখলে কিছুই বোঝা যায় না, সার্ভারকে প্রতিবার ডাটাবেসে চেক করতে হয় এটি কার Key। কিন্তু JWT এর ভেতরেই লেখা থাকে এটি কার টোকেন এবং তার রোল কী। ফলে ডাটাবেসে হিট করা লাগে না।
</details>

---

**Q37. Which header is standard for sending Authentication tokens (like Bearer tokens or JWTs) in an HTTP request?**
A) `Content-Type`
B) `Authorization: Bearer <token>`
C) `User-Agent`
D) `Accept-Language`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: API তে টোকেন পাঠানোর জন্য সবসময় HTTP হেডারে `Authorization: Bearer <টোকেন>` ফরম্যাটটি ব্যবহার করা হয়। (যদিও নাম Authorization, কিন্তু টোকেনটি মূলত Authentication এর জন্যই পাঠানো হয়)।
</details>

---

**Q38. Why is it important to implement "Account Lockout" policies (e.g., locking an account after 5 failed login attempts)?**
A) To annoy users
B) To protect the Authentication system against Brute-Force and Dictionary password attacks.
C) To save server bandwidth
D) To clear the cache

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ৫ বার ভুল পাসওয়ার্ড দিলে অ্যাকাউন্ট কিছুক্ষণের জন্য লক করে দিলে হ্যাকাররা স্ক্রিপ্ট দিয়ে ব্রুট-ফোর্স অ্যাটাক করতে পারে না। এটি Authentication সিকিউরিটির একটি বড় অংশ।
</details>

---

**Q39. What is "Zero Trust Architecture"?**
A) A system where users don't trust the company
B) A security model based on the principle of "never trust, always verify". It assumes threats exist both outside and INSIDE the network, requiring strict Authentication and Authorization for every person and device trying to access resources, regardless of their location.
C) A network without a firewall
D) Using null variables in code

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: জিরো ট্রাস্ট মানে হলো "কাউকে বিশ্বাস করো না, বারবার চেক করো।" আপনি অফিসের ভেতরে বসে অফিসের ওয়াইফাই দিয়ে ঢুকলেও সে আপনাকে বিশ্বাস করবে না, বারবার AuthN ও AuthZ চেক করবে। এটি আধুনিক সিকিউরিটির বেস্ট প্র্যাকটিস।
</details>

---

**Q40. [Conclusion] To secure a sensitive feature like "Delete User", what must the system do?**
A) Only Authentication
B) Only Authorization
C) First Authenticate the user to know who is making the request, and then Authorize the user to ensure they have the specific "Admin" permissions required to perform the deletion.
D) Hide the delete button using CSS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: সেনসিটিভ যেকোনো কাজের ক্ষেত্রে অবশ্যই প্রথমে Authentication (লগইন) চেক করতে হবে, তারপর Authorization (অ্যাডমিন পারমিশন) চেক করতে হবে।
</details>
