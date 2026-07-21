# 06. Hash Tables (Practice MCQs)

এই ফাইলে Hash Tables, Hash Functions, Collisions, এবং Java HashMap এর ইন্টার্নালস নিয়ে ৪০টি ইন-ডেপথ MCQ দেওয়া হলো।

---

**Q1. Hash Table মূলত কী ধরনের ডেটা স্টোর করে?**
A) শুধুমাত্র স্ট্রিং (Strings)
B) শুধুমাত্র ইনটিজার (Integers)
C) Key-Value পেয়ার (Pairs)
D) নোড এবং এজ (Nodes and Edges)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Hash Table (বা Dictionary/Map) সবসময় Key এর সাহায্যে Value স্টোর করে। যেমন "Sabbir" (Key) -> 1234 (Value)।
</details>

---

**Q2. Hash Table এ কোনো ডেটা সার্চ (Search) করার Average Time Complexity কত?**
A) $O(\log n)$
B) $O(1)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাশ ফাংশন সরাসরি বলে দেয় ডেটাটি অ্যারের কোন ইনডেক্সে আছে, তাই কোনো লুপ ছাড়াই $O(1)$ টাইমে ডেটা পাওয়া যায়।
</details>

---

**Q3. Hash Table এর Worst-case Time Complexity (Search/Insert/Delete) কত হতে পারে?**
A) $O(\log n)$
B) $O(1)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যদি এমন কোনো বাজে হ্যাশ ফাংশন থাকে যা সব Key কেই একই ইনডেক্সে ফেলে দেয় (Extreme Collision), তখন সবগুলো ডেটা একটি Linked List এ জমা হয় এবং সার্চ টাইম $O(n)$ হয়ে যায়।
</details>

---

**Q4. "Hash Function" এর মূল কাজ কী?**
A) ডেটাকে এনক্রিপ্ট করে সিকিউর করা
B) একটি Key কে ইনপুট হিসেবে নিয়ে একটি ইনটিজার (Index) আউটপুট দেওয়া
C) অ্যারে থেকে ഡেটা ডিলিট করা
D) ডেটাকে ছোট থেকে বড় সাজানো

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হ্যাশ ফাংশনের কাজ হলো যেকোনো টাইপের Key (যেমন স্ট্রিং বা অবজেক্ট) কে অ্যারের একটি নির্দিষ্ট ইনডেক্স নাম্বারে রূপান্তর করা।
</details>

---

**Q5. নিচের কোনটি একটি "Good Hash Function" এর বৈশিষ্ট্য নয়?**
A) এটি ডিটারমিনিস্টিক (Deterministic) হতে হবে (একই ইনপুটে সবসময় একই আউটপুট আসবে)
B) এটি ফাস্ট হতে হবে
C) এটি সবসময় Random আউটপুট দেবে
D) এটি ডেটাগুলোকে পুরো অ্যারেতে সমানভাবে ছড়িয়ে (Uniformly distribute) দেবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: হ্যাশ ফাংশন কখনো Random আউটপুট দিতে পারে না। যদি দেয়, তবে যে ডেটা যেখানে রাখা হয়েছে, তাকে আর কখনো খুঁজে পাওয়া যাবে না!
</details>

---

**Q6. Hash Table এ "Collision" (সংঘর্ষ) বলতে কী বোঝায়?**
A) যখন Hash Table মেমোরি থেকে মুছে যায়
B) যখন দুটি ভিন্ন Key এর জন্য Hash Function একই ইনডেক্স আউটপুট দেয়
C) যখন Hash Table এর সাইজ দ্বিগুণ করা হয়
D) যখন দুটি ভিন্ন Value একই Key তে সেভ করা হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গাণিতিকভাবে (Pigeonhole Principle) লিমিটেড অ্যারে সাইজে অসীম সংখ্যক Key ম্যাপ করতে গেলে কখনো না কখনো দুটো Key একই ইনডেক্সে এসে পড়বেই। এটিই কলিশন।
</details>

---

**Q7. নিচের কোন টেকনিকটি Collision সলভ করতে ব্যবহৃত হয়?**
A) Separate Chaining
B) Binary Search
C) Quick Sort
D) Memoization

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Separate Chaining এ অ্যারের প্রতিটি ইনডেক্সে একটি Linked List রাখা হয়, ফলে একই ইনডেক্সে একাধিক ডেটা চেইন আকারে স্টোর করা যায়।
</details>

---

**Q8. Open Addressing টেকনিকে Collision হলে ডেটা কোথায় রাখা হয়?**
A) অ্যারের বাইরে অন্য একটি ফাইলে
B) একটি Linked List তৈরি করে
C) মূল অ্যারের ভেতরেই অন্য কোনো ফাঁকা ইনডেক্স খুঁজে সেখানে
D) ডেটাটি ডিলিট করে দেওয়া হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Open Addressing এ কোনো Linked List ব্যবহার করা হয় না। যদি কাঙ্ক্ষিত ইনডেক্সটি ব্লকড থাকে, তবে পরবর্তী ফাঁকা ইনডেক্স খুঁজে ডেটা বসানো হয়।
</details>

---

**Q9. Open Addressing এ "Linear Probing" বলতে কী বোঝায়?**
A) ইনডেক্স $i$ ব্লকড থাকলে $i+1, i+2, i+3...$ এভাবে ফাঁকা জায়গা খোঁজা
B) ইনডেক্স $i$ ব্লকড থাকলে $i+1^2, i+2^2, i+3^2...$ এভাবে খোঁজা
C) ডেটাকে সরাসরি Linked List এ যুক্ত করা
D) দ্বিতীয় একটি হ্যাশ ফাংশন ব্যবহার করা

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Linear Probing এ এক ঘর করে সামনে এগিয়ে লিনিয়ারলি ফাঁকা জায়গা খোঁজা হয়।
</details>

---

**Q10. Linear Probing এর সবচেয়ে বড় সমস্যা (Disadvantage) কী?**
A) এটি ইমপ্লিমেন্ট করা খুব কঠিন
B) এতে "Clustering" (ডেটা এক জায়গায় দলা পাকিয়ে যাওয়া) তৈরি হয়
C) এটি অতিরিক্ত মেমোরি নষ্ট করে
D) এটি Separate Chaining এর চেয়েও বেশি পয়েন্টার ব্যবহার করে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Linear Probing এ ডেটাগুলো একে অপরের গা ঘেঁষে বসতে থাকে (Primary Clustering)। ফলে পরে ফাঁকা জায়গা খুঁজতে অনেক বেশি সময় লাগে।
</details>

---

**Q11. Quadratic Probing কীভাবে Clustering সমস্যা সমাধান করার চেষ্টা করে?**
A) $1, 2, 3$ ইনডেক্স দূরে না খুঁজে, $1^2, 2^2, 3^2$ ইনডেক্স দূরে দূরে ফাঁকা জায়গা খোঁজে
B) এটি Random নম্বর জেনারেট করে
C) এটি Linked List ব্যবহার করে
D) এটি ডেটা ডিলিট করে দেয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Quadratic Probing স্কয়ার (Square) দূরত্বে জাম্প করে, ফলে ডেটাগুলো অ্যারেতে ছড়িয়ে পড়ে এবং Primary Clustering কমে যায়।
</details>

---

**Q12. "Double Hashing" টেকনিকে কী করা হয়?**
A) Key কে দুইবার হ্যাশ করে তারপর Linked List এ রাখা হয়
B) Collision হলে ফাঁকা জায়গা খোঁজার স্টেপ সাইজ (Step size) নির্ধারণ করতে দ্বিতীয় আরেকটি হ্যাশ ফাংশন ব্যবহার করা হয়
C) ডেটাকে ডাবল সাইজের অ্যারেতে রাখা হয়
D) Key এবং Value দুটোকেই হ্যাশ করা হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডাবল হ্যাশিং এ দ্বিতীয় হ্যাশ ফাংশন ঠিক করে দেয় যে কলিশন হলে ঠিক কত ঘর পর পর জাম্প করতে হবে। এটি Clustering রোধ করার সবচেয়ে বেস্ট উপায়।
</details>

---

**Q13. Hash Table এ "Load Factor" এর সূত্র (Formula) কী?**
A) Array Size / Total Elements
B) Total Elements / Array Size
C) Array Size + Total Elements
D) Number of Collisions / Array Size

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Load Factor বা $\alpha$ হলো $n/k$, অর্থাৎ মোট কয়টি এলিমেন্ট রাখা হয়েছে তাকে অ্যারের মোট সাইজ দিয়ে ভাগ করলে যা পাওয়া যায়।
</details>

---

**Q14. জাভাতে `HashMap` এর ডিফল্ট Load Factor Threshold কত?**
A) 0.50 (50%)
B) 1.00 (100%)
C) 0.75 (75%)
D) 0.25 (25%)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: জাভাতে Load Factor 0.75। অর্থাৎ অ্যারেটি ৭৫% ভর্তি হয়ে গেলেই Rehashing করা হয়।
</details>

---

**Q15. "Rehashing" বলতে কী বোঝায়?**
A) ডেটা ডিলিট করে নতুন করে ইনসার্ট করা
B) অ্যারের সাইজ দ্বিগুণ করা এবং পুরোনো সব ডেটাকে নতুন অ্যারেতে পুনরায় হ্যাশ করে বসানো
C) হ্যাশ ফাংশন পরিবর্তন করা
D) Key এর ভ্যালু পরিবর্তন করা

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যখন Load Factor থ্রেশহোল্ড পার হয়ে যায়, তখন পারফরম্যান্স $O(1)$ এ ধরে রাখার জন্য বড় অ্যারে তৈরি করে ডেটা মাইগ্রেট করা হয়।
</details>

---

**Q16. Rehashing অপারেশনটির Time Complexity কত? (যেখানে n = মোট এলিমেন্ট)**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: পুরোনো অ্যারের প্রতিটি ডেটাকে নতুন অ্যারেতে আবার হ্যাশ করে বসাতে $O(n)$ সময় লাগে।
</details>

---

**Q17. যদি Rehashing এ $O(n)$ সময় লাগে, তবে Hash Table এর ইনসার্শন কস্ট $O(1)$ বলা হয় কেন?**
A) কারণ Rehashing কখনো হয় না
B) এটি Amortized $O(1)$, অর্থাৎ কালেভদ্রে একবার $O(n)$ লাগলেও গড়ের হিসেবে এটি $O(1)$ ই থাকে
C) কারণ এটি মাল্টি-থ্রেডিং ব্যবহার করে
D) কারণ ডেটা মেমোরিতে থাকে না

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Rehashing খুব কমই ঘটে। ১০০ বার $O(1)$ এ ইনসার্ট করার পর হয়তো একবার $O(n)$ কস্ট দিতে হয়। তাই গাণিতিকভাবে এর Amortized (গড়) টাইম $O(1)$ ধরা হয়।
</details>

---

**Q18. Java 8 এর আগে `HashMap` এ চরম Collision হলে Worst-case Time Complexity কত ছিল?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: জাভা ৮ এর আগে Separate Chaining এ শুধুমাত্র Linked List ব্যবহৃত হতো। সব ডেটা এক ইনডেক্সে পড়লে লিস্টের শেষ পর্যন্ত খুঁজতে $O(n)$ সময় লাগতো।
</details>

---

**Q19. [Interview Angle] Java 8 থেকে `HashMap` এর ইন্টার্নাল ইমপ্লিমেন্টেশনে কী বড় পরিবর্তন আনা হয়েছে?**
A) এটি Separate Chaining বাদ দিয়ে Open Addressing এ শিফট করেছে
B) একটি নির্দিষ্ট ইনডেক্সে কলিশন ৮ এর বেশি হলে Linked List টি Red-Black Tree তে কনভার্ট হয়ে যায়
C) এটি ডিফল্ট Load Factor পরিবর্তন করে 1.0 করেছে
D) `HashMap` এর বদলে `TreeMap` কে ডিফল্ট করা হয়েছে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: পারফরম্যান্স ইমপ্রুভ করার জন্য এই `TREEIFY_THRESHOLD = 8` রুলটি আনা হয়েছে। ফলে Worst Case টাইম $O(n)$ থেকে কমে $O(\log n)$ হয়ে গেছে!
</details>

---

**Q20. Java 8 এর `HashMap` এ Treeify হওয়ার পর যদি ডেটা ডিলিট হতে হতে ৬ টিতে নেমে আসে, তবে কী হয়?**
A) ট্রি টি ডিলিট হয়ে যায়
B) এটি পুনরায় Linked List (Untreeify) এ ফিরে যায়
C) এটি সারা জীবন ট্রি ই থেকে যায়
D) মেমোরি লিক (Memory Leak) হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যখন সাইজ ৬ বা তার নিচে নেমে আসে (UNTREEIFY_THRESHOLD = 6), তখন মেমোরি বাঁচানোর জন্য ট্রি আবার Linked List এ কনভার্ট হয়ে যায়।
</details>

---

**Q21. জাভাতে `HashMap` এ কি `null` Key রাখা যায়?**
A) না, NullPointerException খাবে
B) হ্যাঁ, তবে শুধুমাত্র ১টি `null` Key রাখা যায়
C) হ্যাঁ, যত খুশি রাখা যায়
D) শুধুমাত্র `null` Value রাখা যায়, Key না

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `HashMap` এ ঠিক একটি `null` Key অ্যালাউড। এটি সবসময় ইনডেক্স `0` তে স্টোর হয় (কারণ null এর হ্যাশকোড ০ ধরা হয়)।
</details>

---

**Q22. জাভাতে `Hashtable` (Map ইন্টারফেসের লিগ্যাসি ক্লাস) এবং `HashMap` এর মধ্যে প্রধান পার্থক্য কী?**
A) `HashMap` Thread-safe, `Hashtable` নয়
B) `Hashtable` Thread-safe (Synchronized), `HashMap` নয়
C) `Hashtable` এ `null` অ্যালাউড, `HashMap` এ নয়
D) কোনো পার্থক্য নেই

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `Hashtable` লিগ্যাসি ক্লাস এবং এর সব মেথড সিঙ্ক্রোনাইজড। কিন্তু এটি স্লো। `HashMap` সিঙ্ক্রোনাইজড নয়, তাই ফাস্ট।
</details>

---

**Q23. Custom Object (যেমন `Student` ক্লাস) কে `HashMap` এর Key হিসেবে ব্যবহার করতে হলে নিচের কোন কাজগুলো করা বাধ্যতামূলক?**
A) শুধুমাত্র `hashCode()` মেথড ওভাররাইড করা
B) শুধুমাত্র `equals()` মেথড ওভাররাইড করা
C) `hashCode()` এবং `equals()` দুটো মেথডই সঠিকভাবে ওভাররাইড করা
D) ক্লাসটিকে `Comparable` ইন্টারফেস ইমপ্লিমেন্ট করা

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: `hashCode()` ঠিক করে ডেটা কোন বাকেটে (ইনডেক্সে) যাবে। আর ওই বাকেটে একাধিক ডেটা থাকলে `equals()` দিয়ে চেক করা হয় ঠিক কোন ডেটাটি আপনার দরকার। দুটোই মাস্ট!
</details>

---

**Q24. [Gotcha] যদি আপনি Custom Class এ `hashCode()` ওভাররাইড করেন কিন্তু `equals()` ওভাররাইড না করেন, তবে কী সমস্যা হবে?**
A) কম্পাইলেশন এরর আসবে
B) ডেটা সঠিক বাকেটে যাবে, কিন্তু `get()` করার সময় খুঁজে পাওয়া যাবে না
C) ডেটা অন্য বাকেটে চলে যাবে
D) `HashMap` অটোমেটিকভাবে `equals()` তৈরি করে নেবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `hashCode()` থাকায় ডেটা ঠিক জায়গায় যাবে। কিন্তু `get()` করার সময় ডিফল্ট `equals()` (যা মেমোরি রেফারেন্স চেক করে) ব্যবহার হওয়ায় এটি `false` রিটার্ন করবে এবং আপনি `null` পাবেন।
</details>

---

**Q25. নিচের কোন ডেটা স্ট্রাকচারটি ইন্টার্নালি Hash Table ব্যবহার করে তৈরি?**
A) `ArrayList`
B) `TreeSet`
C) `HashSet`
D) `LinkedList`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: `HashSet` ইন্টার্নালি একটি `HashMap` ব্যবহার করে, যেখানে আপনার ডেটাগুলো Key হিসেবে স্টোর হয় এবং Value হিসেবে একটি ডামি অবজেক্ট (Dummy Object) রাখা হয়।
</details>

---

**Q26. Caching System (যেমন Redis) ডেটা খুব দ্রুত খুঁজে পাওয়ার জন্য মূলত কোন স্ট্রাকচার ফলো করে?**
A) Graph
B) Hash Table (Key-Value Store)
C) Stack
D) Queue

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Redis হলো একটি ইন-মেমরি Key-Value ডেটাবেস, যা মূলত Hash Table কনসেপ্টের ওপর দাঁড়িয়ে আছে $O(1)$ পারফরম্যান্স দেওয়ার জন্য।
</details>

---

**Q27. Cryptographic Hash Function (যেমন SHA-256) এবং Data Structure Hash Function এর মধ্যে মূল পার্থক্য কী?**
A) ডেটা স্ট্রাকচার হ্যাশ ফাংশন অনেক স্লো হয়
B) ক্রিপ্টোগ্রাফিক হ্যাশ ফাংশন রিভার্স করা (ডিক্রিপ্ট করা) প্রায় অসম্ভব, ডেটা স্ট্রাকচারে স্পিডটাই মেইন ফোকাস
C) ডেটা স্ট্রাকচার হ্যাশ ফাংশন সিকিউরিটির জন্য ব্যবহৃত হয়
D) দুটোর মধ্যে কোনো পার্থক্য নেই

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডেটা স্ট্রাকচারে ব্যবহৃত হ্যাশ ফাংশন (যেমন `hashCode()`) এর কাজ শুধু দ্রুত ইনডেক্স বের করা। এটি সিকিউর নয়। অন্যদিকে SHA-256 সিকিউরিটির জন্য ব্যবহৃত হয়।
</details>

---

**Q28. "Perfect Hash Function" কাকে বলে?**
A) যে হ্যাশ ফাংশনে কোনো কলিশন (Collision) হয় না
B) যে হ্যাশ ফাংশন সবসময় ০ রিটার্ন করে
C) যে হ্যাশ ফাংশন অনেক মেমোরি নেয়
D) যে হ্যাশ ফাংশন String কে Integer এ কনভার্ট করে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: যদি একটি হ্যাশ ফাংশন প্রতিটি ইউনিক Key এর জন্য একটি ইউনিক ইনডেক্স দিতে পারে (কোনো কলিশন ছাড়াই), তবে তাকে Perfect Hashing বলে।
</details>

---

**Q29. LeetCode এর বিখ্যাত "Two Sum" প্রবলেমে Hash Map ব্যবহার করলে Time Complexity $O(n^2)$ থেকে কমে কত হয়?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: লুপের ভেতরে (যা $n$ বার চলে) Hash Map এর `containsKey()` চেক করা হয় যা $O(1)$। তাই টোটাল কমপ্লেক্সিটি $O(n \times 1) = O(n)$ হয়।
</details>

---

**Q30. Two Sum প্রবলেমে Hash Map এ Value হিসেবে কী স্টোর করা হয়? (ওপরের কোড এক্সাম্পলের আলোকে)**
A) অ্যারের ইলিমেন্ট
B) টার্গেট ভ্যালু
C) অ্যারের ইলিমেন্টের ইনডেক্স
D) বুলিয়ান ভ্যালু (True/False)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: প্রবলেমটিতে যেহেতু ইনডেক্স রিটার্ন করতে হয়, তাই Key হিসেবে ইলিমেন্ট এবং Value হিসেবে তার ইনডেক্স ম্যাপে স্টোর করে রাখা হয়।
</details>

---

**Q31. একটি স্ট্রিংয়ে প্রথম ইউনিক (Non-repeating) ক্যারেক্টার বের করতে Hash Map কীভাবে সাহায্য করে?**
A) এটি স্ট্রিংটিকে সর্ট করে দেয়
B) এটি ক্যারেক্টারগুলোর ফ্রিকোয়েন্সি বা কাউন্ট (Count) স্টোর করে রাখে
C) এটি ডুপ্লিকেট ক্যারেক্টার ডিলিট করে দেয়
D) এটি স্ট্রিংয়ের লেংথ বের করে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Hash Map এ Key হিসেবে ক্যারেক্টার এবং Value হিসেবে তার ফ্রিকোয়েন্সি (কতবার এসেছে) স্টোর করে খুব সহজেই ইউনিক ক্যারেক্টার (যার ভ্যালু ১) বের করা যায়।
</details>

---

**Q32. [Tricky] যদি একটি Custom `Student` ক্লাসের `hashCode()` মেথড সবসময় `return 1;` করে, তবে কী হবে?**
A) এটি কম্পাইল হবে না
B) `HashMap` কাজ করবে না
C) `HashMap` একটি Linked List (বা Tree) এর মতো আচরণ করবে এবং সার্চ টাইম $O(n)$ হয়ে যাবে
D) এটি Perfect Hashing এর উদাহরণ

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: সবসময় ১ রিটার্ন করলে সবগুলো Student অবজেক্ট একই বাকেটে (Index 1) গিয়ে পড়বে। এটি Extreme Collision এর উদাহরণ। $O(1)$ এর বদলে পারফরম্যান্স $O(n)$ হয়ে যাবে।
</details>

---

**Q33. "Consistent Hashing" কনসেপ্টটি কোথায় সবচেয়ে বেশি ব্যবহৃত হয়?**
A) সাধারণ Java `HashMap` এ
B) Distributed Systems এ (যেমন: ডেটাবেস শার্ডিং বা লোড ব্যালান্সিং)
C) String Reversing এ
D) Tree Traversal এ

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডিস্ট্রিবিউটেড সিস্টেমে যখন নতুন সার্ভার অ্যাড করা হয় বা কোনো সার্ভার ডাউন হয়ে যায়, তখন পুরো ডেটা রিহ্যাশ না করে শুধুমাত্র অল্প কিছু ডেটা মুভ করার জন্য Consistent Hashing (একটি রিং বা বৃত্তাকার ম্যাপ) ব্যবহার করা হয়।
</details>

---

**Q34. Open Addressing এ যদি অনেক ডেটা ডিলিট করা হয়, তবে একটি বিশেষ ফ্ল্যাগ (Flag) ব্যবহার করতে হয়। একে কী বলা হয়?**
A) Null Pointer
B) Tombstone (বা Deleted marker)
C) Exception
D) Dummy Node

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Open Addressing এ কোনো ডেটা সরাসরি ডিলিট করে ফাঁকা (`null`) করে দিলে সার্চ অ্যালগরিদম ভাবতে পারে যে এরপর আর ডেটা নেই! তাই সেখানে একটি "Tombstone" ফ্ল্যাগ বসিয়ে দেওয়া হয়, যার মানে হলো "এখানে ডেটা ছিল, এখন নেই, তুমি সামনে খুঁজতে থাকো"।
</details>

---

**Q35. Hash Table এর কোন প্রপার্টিটি একে Binary Search Tree (BST) থেকে আলাদা করে?**
A) Hash Table ডেটা সর্টেড (Sorted) অর্ডারে রাখে না, BST রাখে
B) Hash Table $O(\log n)$ এ কাজ করে
C) Hash Table এ মেমোরি কম লাগে
D) Hash Table শুধুমাত্র ইনটিজার স্টোর করতে পারে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Hash Table ডেটা স্টোর করার সময় হ্যাশকোড ব্যবহার করে যত্রতত্র ফেলে, তাই এখানে ডেটা কোনো নির্দিষ্ট অর্ডারে থাকে না। সর্টেড ডেটা লাগলে `TreeMap` বা BST ব্যবহার করতে হয়।
</details>

---

**Q36. [Code Output] নিচের কোডটির আউটপুট কী হবে?**
```java
HashMap<String, Integer> map = new HashMap<>();
map.put("A", 10);
map.put("A", 20);
System.out.println(map.size());
```
A) 2
B) 1
C) 0
D) Exception

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `HashMap` এ Key ইউনিক হতে হয়। দ্বিতীয়বার "A" ইনসার্ট করলে সেটি নতুন এন্ট্রি তৈরি না করে আগের "A" এর Value 10 কে 20 দিয়ে রিপ্লেস করে দেবে। তাই সাইজ 1 ই থাকবে।
</details>

---

**Q37. আপনি যদি `ConcurrentHashMap` ব্যবহার করেন, তবে এটি `Hashtable` এর চেয়ে ভালো পারফর্ম করে কেন?**
A) এটি কোনো সিঙ্ক্রোনাইজেশন ব্যবহার করে না
B) এটি পুরো ম্যাপটিকে লক না করে শুধুমাত্র নির্দিষ্ট বাকেট (Bucket / Segment) লক করে
C) এটি C++ এ লেখা
D) এটি ডেটা হার্ডডিস্কে সেভ করে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `Hashtable` মাল্টি-থ্রেডিংয়ের সময় পুরো অবজেক্টটাকে লক করে রাখে, ফলে অন্য থ্রেড ওয়েট করে। `ConcurrentHashMap` লক স্ট্রিপিং (Lock Striping) বা বাকেট-লেভেল লকিং ব্যবহার করে, তাই অনেকগুলো থ্রেড একই সাথে কাজ করতে পারে।
</details>

---

**Q38. "Dictionary" ডেটা স্ট্রাকচার (যেমন পাইথনের `dict`) ইন্টার্নালি কোনটি ব্যবহার করে তৈরি?**
A) Binary Search Tree
B) B-Tree
C) Hash Table
D) Linked List

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: পাইথনের ডিকশনারি, জাভাস্ক্রিপ্টের অবজেক্ট (অনেক ক্ষেত্রে), এবং জাভার ম্যাপ—এগুলোর সবই ইন্টার্নালি Hash Table কনসেপ্ট ব্যবহার করে।
</details>

---

**Q39. একটি Hash Function এর আউটপুট রেঞ্জ যদি 0 থেকে 99 হয়, তবে Array এর সাইজ কত হতে হবে?**
A) 99
B) 100
C) 101
D) 1000

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 0 থেকে 99 পর্যন্ত মোট ১০০টি ইউনিক নাম্বার আছে, তাই অ্যারের সাইজ ১০০ হতে হবে।
</details>

---

**Q40. [Gotcha] `HashMap` এ `containsValue(Object value)` মেথডটির Time Complexity কত?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Hash Table শুধু Key এর সাহায্যে $O(1)$ এ খুঁজতে পারে। Value দিয়ে খুঁজতে হলে পুরো অ্যারে এবং সব Linked List ম্যানুয়ালি স্ক্যান করতে হয়, যার টাইম কমপ্লেক্সিটি $O(n)$। এটি একটি কমন ইন্টারভিউ ট্র্যাপ!
</details>
