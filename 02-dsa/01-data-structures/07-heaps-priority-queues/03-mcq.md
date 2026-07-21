# 07. Heaps & Priority Queues (Practice MCQs)

এই ফাইলে Heap, Priority Queue, Array Representation এবং টাইম কমপ্লেক্সিটির ওপর ৪০টি ইন-ডেপথ MCQ দেওয়া হলো।

---

**Q1. Heap ডেটা স্ট্রাকচার মূলত কোন ট্রির একটি স্পেশাল ফর্ম?**
A) Binary Search Tree (BST)
B) AVL Tree
C) Complete Binary Tree
D) Full Binary Tree

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Heap সবসময় একটি Complete Binary Tree হয়, যার মানে হলো সব লেভেল ভর্তি থাকতে হবে এবং শেষের লেভেলটি যতটা সম্ভব বাম দিক থেকে ভর্তি হতে হবে।
</details>

---

**Q2. Max Heap এর মূল শর্ত (Property) কী?**
A) লেফট চাইল্ড সবসময় প্যারেন্টের চেয়ে ছোট হবে
B) রাইট চাইল্ড সবসময় প্যারেন্টের চেয়ে বড় হবে
C) প্যারেন্টের ভ্যালু তার লেফট এবং রাইট উভয় চাইল্ডের চেয়ে বড় (বা সমান) হবে
D) রুট নোডে সবসময় সবচেয়ে ছোট ভ্যালু থাকবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Max Heap এ প্যারেন্ট সবসময় চাইল্ডগুলোর চেয়ে বড় হয়। তবে লেফট এবং রাইট চাইল্ডের মধ্যে কে বড় হবে তার কোনো নির্দিষ্ট রুল নেই।
</details>

---

**Q3. Min Heap এর রুট (Root) নোডে কোন ভ্যালুটি থাকে?**
A) সবচেয়ে বড় ভ্যালু
B) সবচেয়ে ছোট ভ্যালু
C) মিডিয়ান (Median) ভ্যালু
D) যেকোনো র‍্যান্ডম ভ্যালু

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Min Heap এর প্রপার্টি অনুযায়ী প্যারেন্ট সবসময় চাইল্ডের চেয়ে ছোট হয়, তাই একদম ওপরে (রুটে) সবচেয়ে ছোট ভ্যালুটি থাকে।
</details>

---

**Q4. Heap ডেটা স্ট্রাকচার কোথায় স্টোর করা সবচেয়ে বেশি মেমোরি-এফিশিয়েন্ট (Memory-efficient)?**
A) Linked List
B) Doubly Linked List
C) Array
D) Hash Map

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেহেতু Heap একটি Complete Tree (কোনো গ্যাপ থাকে না), তাই পয়েন্টার ব্যবহার না করে একে সরাসরি Array তে রাখা যায়। এতে মেমোরি অনেক বাঁচে।
</details>

---

**Q5. একটি 0-indexed Array তে Heap রাখা হলে, $i$ তম ইনডেক্সের লেফট চাইল্ড (Left Child) কোথায় থাকে?**
A) $2i$
B) $2i + 1$
C) $2i + 2$
D) $(i - 1) / 2$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 0-indexed অ্যারেতে লেফট চাইল্ডের ফর্মুলা হলো $2i + 1$।
</details>

---

**Q6. একটি 0-indexed Array তে $i$ তম নোডের প্যারেন্ট (Parent) কোন ইনডেক্সে থাকে?**
A) $i / 2$
B) $(i + 1) / 2$
C) $2i - 1$
D) $(i - 1) / 2$ (Integer division)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: যেকোনো চাইল্ড (লেফট বা রাইট) এর ইনডেক্স থেকে ১ বিয়োগ করে ২ দিয়ে ভাগ করলে তার প্যারেন্টের ইনডেক্স পাওয়া যায়।
</details>

---

**Q7. Priority Queue ইমপ্লিমেন্ট করার জন্য নিচের কোন ডেটা স্ট্রাকচারটি সবচেয়ে উপযুক্ত?**
A) Array
B) Linked List
C) Heap
D) Stack

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Priority Queue তে সবচেয়ে হাই-প্রায়োরিটি এলিমেন্টটি দ্রুত বের করতে হয়। Heap এ রুট থেকে $O(1)$ টাইমে ম্যাক্স/মিন দেখা যায় এবং $O(\log n)$ এ ডিলিট করা যায়। তাই এটি বেস্ট।
</details>

---

**Q8. Heap এ নতুন ডেটা ইনসার্ট (Insert) করার Time Complexity কত?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নতুন ডেটা অ্যারের শেষে যোগ করা হয়, তারপর সঠিক জায়গায় পৌঁছানো পর্যন্ত উপরে ওঠানো (Heapify Up) হয়। ট্রির হাইট $\log n$ হওয়ায় ম্যাক্সিমাম $\log n$ বার সোয়াপ করতে হয়।
</details>

---

**Q9. Heap থেকে ম্যাক্সিমাম বা মিনিমাম ভ্যালুটি ডিলিট (Poll) করার Time Complexity কত?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডিলিট করার সময় রুট মুছে দিয়ে শেষের ডেটা রুটে আনা হয়। এরপর তাকে নিচে নামানো (Heapify Down) হয়। এর কস্ট $O(\log n)$।
</details>

---

**Q10. Heap এ ম্যাক্সিমাম বা মিনিমাম ভ্যালু শুধুমাত্র দেখা (Peek) এর Time Complexity কত?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(1)$ (Average), $O(n)$ (Worst)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: ম্যাক্স বা মিন ভ্যালু সবসময় রুটে (ইনডেক্স 0) থাকে। তাই শুধু দেখতে বা এক্সেস করতে $O(1)$ সময় লাগে।
</details>

---

**Q11. Heap ডেটা স্ট্রাকচারে কোনো নির্দিষ্ট র‍্যান্ডম ভ্যালু (যেমন 45) সার্চ করার Time Complexity কত?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Heap এ ডেটা সর্ট করা থাকে না। তাই নির্দিষ্ট কোনো ডেটা খুঁজতে হলে পুরো অ্যারে লিনিয়ারলি স্ক্যান করতে হয়, যার কস্ট $O(n)$। এটি একটি কমন ইন্টারভিউ ট্র্যাপ।
</details>

---

**Q12. "Heapify Up" (বা Bubble Up) অপারেশনটি কখন করা হয়?**
A) যখন রুট ডিলিট করা হয়
B) যখন নতুন ডেটা ইনসার্ট করা হয়
C) যখন Heap কে সর্ট করা হয়
D) যখন Heap খালি করা হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নতুন ডেটা শেষে বসানোর পর সে যদি তার প্যারেন্টের চেয়ে ছোট (Min Heap) বা বড় (Max Heap) হয়, তবে তাকে উপরে ওঠাতে Heapify Up করা হয়।
</details>

---

**Q13. "Heapify Down" (বা Bubble Down) অপারেশনটি কখন করা হয়?**
A) যখন নতুন ডেটা ইনসার্ট করা হয়
B) যখন রুট (Max/Min) রিমুভ করা হয়
C) যখন সাইজ চেক করা হয়
D) যখন Heap এ সার্চ করা হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রুট ডিলিট করে শেষের নোডটি রুটে আনা হয়, তারপর সেটি সঠিক জায়গায় না যাওয়া পর্যন্ত চাইল্ডদের সাথে সোয়াপ করে নিচে নামানো হয় (Heapify Down)।
</details>

---

**Q14. একটি আনসর্টেড অ্যারে (Unsorted Array) থেকে $O(n)$ টাইমে একটি Heap তৈরি করার প্রসেসকে কী বলা হয়?**
A) Heap Sort
B) Build Heap
C) Heapify Up
D) Binary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একটি একটি করে ইনসার্ট করলে $O(n \log n)$ সময় লাগে। কিন্তু ফ্লোয়েড (Floyd's) এর "Build Heap" অ্যালগরিদম ব্যবহার করে একটি অ্যারে থেকে $O(n)$ টাইমে Heap বানানো যায়।
</details>

---

**Q15. Java এর `PriorityQueue` বাই ডিফল্ট কোন ধরনের Heap হিসেবে কাজ করে?**
A) Max Heap
B) Min Heap
C) Fibonacci Heap
D) Binomial Heap

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: জাভাতে `PriorityQueue` ডিফল্টভাবে ছোট ভ্যালুকে হাই-প্রায়োরিটি দেয়, অর্থাৎ এটি একটি Min Heap।
</details>

---

**Q16. Java তে `PriorityQueue` কে Max Heap বানাতে হলে কী করতে হয়?**
A) `new PriorityQueue(true)` লিখতে হয়
B) `new PriorityQueue(Collections.reverseOrder())` লিখতে হয়
C) এটি সম্ভব নয়, কাস্টম ক্লাস লিখতে হবে
D) `maxHeapify()` মেথড কল করতে হবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `Collections.reverseOrder()` একটি Comparator প্রোভাইড করে যা ডিফল্ট ন্যাচারাল অর্ডারিংকে উল্টে দেয়, ফলে এটি Max Heap এ পরিণত হয়।
</details>

---

**Q17. LeetCode এর "K-th Largest Element in an Array" প্রবলেমটি সবচেয়ে ইফিশিয়েন্টলি সলভ করার জন্য কোন ডেটা স্ট্রাকচার ব্যবহৃত হয়?**
A) Stack
B) Hash Map
C) Min Heap (Priority Queue)
D) Linked List

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: একটি K সাইজের Min Heap মেইনটেইন করলে লুপ শেষে ওই Heap এর রুটে K-th Largest এলিমেন্টটি পাওয়া যায়।
</details>

---

**Q18. K-th Largest প্রবলেমে $N$ সাইজের অ্যারে এবং $K$ সাইজের Min Heap ব্যবহার করলে Time Complexity কত হয়?**
A) $O(N \log N)$
B) $O(N \log K)$
C) $O(K \log N)$
D) $O(N^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: অ্যারের প্রতিটি এলিমেন্ট ($N$) Heap এ ইনসার্ট/রিমুভ করতে $\log K$ সময় লাগে (যেহেতু Heap এর সাইজ সবসময় K রাখা হয়)। তাই মোট সময় $O(N \log K)$।
</details>

---

**Q19. Heap Sort অ্যালগরিদমের Time Complexity কত?**
A) $O(n)$
B) $O(n \log n)$
C) $O(n^2)$
D) $O(\log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Heap Sort এ প্রথমে $O(n)$ টাইমে Build Heap করা হয়। এরপর $n$ বার রুট ডিলিট করে পেছনে রাখা হয়, প্রতি ডিলিটে $O(\log n)$ সময় লাগে। তাই মোট $O(n \log n)$।
</details>

---

**Q20. Heap Sort এর Space Complexity কত? (In-place sorting এর ক্ষেত্রে)**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Heap Sort মেইন অ্যারের ভেতরেই সোয়াপ করে কাজ করে, তাই এর কোনো এক্সট্রা স্পেস লাগে না ($O(1)$)।
</details>

---

**Q21. [Tricky] আপনি যদি একটি Binary Search Tree (BST) থেকে সবচেয়ে ছোট ভ্যালু এবং একটি Min Heap থেকে সবচেয়ে ছোট ভ্যালু বের করতে চান, তবে কোনটির পারফরম্যান্স ভালো?**
A) BST এর ভালো ($O(1)$)
B) Min Heap এর ভালো ($O(1)$)
C) দুটোরই $O(\log n)$
D) দুটোরই $O(n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Min Heap এ সবচেয়ে ছোট ভ্যালু রুটে থাকে, তাই $O(1)$ লাগে। কিন্তু BST তে সবচেয়ে ছোট ভ্যালু বের করতে একদম বাম দিকের লিফ (Leftmost) পর্যন্ত যেতে হয়, যাতে $O(\log n)$ বা আনব্যালেন্সড হলে $O(n)$ লাগতে পারে।
</details>

---

**Q22. একটি Max Heap এ দ্বিতীয় বৃহত্তম (2nd Largest) এলিমেন্টটি কোথায় থাকতে পারে?**
A) শুধুমাত্র রুটের লেফট চাইল্ডে
B) শুধুমাত্র রুটের রাইট চাইল্ডে
C) রুটের যেকোনো একটি চাইল্ডে (লেফট বা রাইট)
D) লিফ নোডে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: রুটে সবচেয়ে বড় ভ্যালু থাকে। দ্বিতীয় বৃহত্তম ভ্যালুটি অবশ্যই রুটের ঠিক নিচে (লেফট বা রাইট চাইল্ড) থাকবে, কারণ তারা প্যারেন্টের ঠিক পরেই পজিশন নেয়।
</details>

---

**Q23. একটি Min Heap এ সবচেয়ে বড় ভ্যালুটি (Maximum Element) কোথায় থাকে?**
A) রুটে
B) রুটের রাইট চাইল্ডে
C) যেকোনো লিফ নোডে (Leaf Node)
D) ইনডেক্স ১ এ

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Min Heap এ সবচেয়ে বড় ভ্যালুটি নিচে নামতে নামতে একদম লিফ নোডে গিয়ে ঠেকে। তবে এটি ঠিক কোন লিফ নোডে আছে, তা গ্যারান্টি দিয়ে বলা যায় না।
</details>

---

**Q24. [Code Output] নিচের জাভা কোডের আউটপুট কী হবে?**
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(5);
pq.add(1);
pq.add(3);
System.out.println(pq.poll() + " " + pq.peek());
```
A) 5 1
B) 1 3
C) 1 5
D) 3 5

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি Min Heap। `poll()` করলে সবচেয়ে ছোট ভ্যালু 1 বের হবে। এরপর Heap এ থাকবে 3 এবং 5। `peek()` করলে নতুন ছোট ভ্যালু 3 দেখাবে। আউটপুট: "1 3"।
</details>

---

**Q25. "Merge K Sorted Lists" প্রবলেমটি ইফিশিয়েন্টলি সলভ করতে কোন ডেটা স্ট্রাকচার সবচেয়ে বেশি কাজে লাগে?**
A) Stack
B) Hash Map
C) Min Heap
D) Array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: প্রতিটি লিস্টের প্রথম (ছোট) এলিমেন্টটি একটি Min Heap এ রাখা হয়। এরপর Heap থেকে ছোট এলিমেন্টটি পপ করে তার লিস্টের পরবর্তী এলিমেন্ট Heap এ পুশ করা হয়।
</details>

---

**Q26. Dijkstra's Algorithm এ নেক্সট শর্টেস্ট পাথ বের করতে কোন ডেটা স্ট্রাকচার ব্যবহৃত হয়?**
A) Stack
B) Priority Queue (Min Heap)
C) Queue
D) Array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Dijkstra তে সবসময় সবচেয়ে কম দূরত্বের (Minimum distance) নোডটি আগে প্রসেস করতে হয়। এজন্য Priority Queue (Min Heap) ব্যবহার করা হয়।
</details>

---

**Q27. জাভার `PriorityQueue` তে `null` ইনসার্ট করার চেষ্টা করলে কী হবে?**
A) এটি 0 হিসেবে ট্রিট করা হবে
B) এটি স্টোর হবে, কিন্তু `poll()` করার সময় এরর দেবে
C) `NullPointerException` থ্রো করবে
D) এটি ইগনোর করে পরবর্তী লাইনে চলে যাবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: `PriorityQueue` তে `null` ইনসার্ট করা যায় না, কারণ Heap এ এলিমেন্টগুলোকে একে অপরের সাথে Compare করতে হয়। `null` কে compare করতে গেলে Exception খাবে।
</details>

---

**Q28. Custom Object (যেমন `Student` ক্লাস) কে `PriorityQueue` তে রাখতে হলে নিচের কোনটি বাধ্যতামূলক?**
A) ক্লাসটিকে `Comparable` ইন্টারফেস ইমপ্লিমেন্ট করতে হবে অথবা PQ তে একটি `Comparator` পাস করতে হবে
B) `hashCode()` ওভাররাইড করতে হবে
C) `toString()` ওভাররাইড করতে হবে
D) ক্লাসটিকে `Serializable` হতে হবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Heap এ ডেটা সাজানোর জন্য তাদের মধ্যে তুলনা (Comparison) করতে হয়। `Comparable` বা `Comparator` ছাড়া জাভা বুঝতে পারবে না কোন `Student` বড় আর কে ছোট।
</details>

---

**Q29. [Gotcha] জাভাতে `PriorityQueue` এর ওপর `for-each` লুপ (যেমন `for(int x : pq)`) চালালে ডেটাগুলো কি সর্টেড (Sorted) অর্ডারে প্রিন্ট হবে?**
A) হ্যাঁ, সবসময় সর্টেড অর্ডারে প্রিন্ট হবে
B) না, এটি গ্যারান্টিড সর্টেড অর্ডার দেবে না (ইন্টারনাল অ্যারে অর্ডার প্রিন্ট করবে)
C) রিভার্স অর্ডারে প্রিন্ট করবে
D) Exception থ্রো করবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `for-each` লুপ ইন্টারনাল Array এর ডেটা প্রিন্ট করে, আর Heap এর অ্যারে পুরোপুরি সর্টেড থাকে না (শুধু রুট ছোট/বড় থাকে)। সর্টেড অর্ডারে পেতে হলে `while(!pq.isEmpty()) { pq.poll(); }` করতে হয়।
</details>

---

**Q30. "Median of Data Stream" প্রবলেমে ডেটার মিডিয়ান (মাঝখানের ভ্যালু) বের করতে সাধারণত কোন ট্রিকটি ব্যবহার করা হয়?**
A) একটি Array এবং Sort ফাংশন
B) একটি Hash Map
C) দুটি Heap (একটি Max Heap এবং একটি Min Heap)
D) একটি Queue

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ছোট অর্ধেক ডেটা Max Heap এ এবং বড় অর্ধেক ডেটা Min Heap এ রাখা হয়। ফলে দুই Heap এর রুট চেক করলেই $O(1)$ টাইমে মিডিয়ান পাওয়া যায়!
</details>

---

**Q31. একটি আনসর্টেড অ্যারে থেকে $K$ টি সবচেয়ে ছোট এলিমেন্ট (K Smallest Elements) বের করার জন্য কোন সাইজের এবং কোন ধরনের Heap ব্যবহার করা সবচেয়ে ইফিশিয়েন্ট?**
A) K সাইজের Min Heap
B) K সাইজের Max Heap
C) N সাইজের Min Heap
D) N সাইজের Max Heap

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: K-টি *ছোট* এলিমেন্ট চাইলে K সাইজের *Max Heap* ব্যবহার করতে হয়। কারণ Max Heap এর রুটে সবচেয়ে বড় ভ্যালু থাকে, যা সহজেই $O(1)$ এ ফেলে দেওয়া (Discard) যায় যখন সাইজ K পার হয়।
</details>

---

**Q32. Heap এ "Heapify Down" করার সময় কার সাথে সোয়াপ (Swap) করা হয়?**
A) যেকোনো চাইল্ডের সাথে
B) Max Heap এ সবচেয়ে বড় চাইল্ডের সাথে, এবং Min Heap এ সবচেয়ে ছোট চাইল্ডের সাথে
C) সবসময় লেফট চাইল্ডের সাথে
D) সবসময় রাইট চাইল্ডের সাথে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নিচে নামার সময় সঠিক পজিশন ধরে রাখতে Max Heap এ দুই চাইল্ডের মধ্যে যে বড় তার সাথে সোয়াপ করা হয়, আর Min Heap এ যে ছোট তার সাথে।
</details>

---

**Q33. Fibonacci Heap এর মূল সুবিধা কী?**
A) এটি ইমপ্লিমেন্ট করা সবচেয়ে সহজ
B) এটি Array তে স্টোর করা যায়
C) এর কিছু অপারেশনের Amortized Time Complexity $O(1)$ (যেমন `insert` এবং `decrease-key`)
D) এটি কোনো মেমোরি নেয় না

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Dijkstra's Algorithm এ `decrease-key` অনেক বেশি ব্যবহৃত হয়। Binary Heap এ এটি $O(\log n)$, কিন্তু Fibonacci Heap এ এটি $O(1)$। তবে এটি ইমপ্লিমেন্ট করা খুব কঠিন।
</details>

---

**Q34. একটি Max Heap এ ইনসার্ট করা প্রথম এলিমেন্টটি কি সবসময় রুটেই থাকবে?**
A) হ্যাঁ
B) না, যদি তার চেয়ে বড় কোনো এলিমেন্ট ইনসার্ট করা হয়, তবে সে নিচে নেমে যাবে
C) না, ইনসার্ট করলেই রুট চেঞ্জ হয়
D) এটি অ্যারের সাইজের ওপর নির্ভর করে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Heap এ ভ্যালুগুলো তাদের আকার অনুযায়ী জায়গা করে নেয়। প্রথম এলিমেন্টটি সাময়িকভাবে রুট হলেও, পরে বড় ভ্যালু আসলে সেটি নিচে নেমে যায়।
</details>

---

**Q35. "Heap" শব্দটি অপারেটিং সিস্টেমের মেমোরি (Heap Memory) এবং ডেটা স্ট্রাকচার (Heap Data Structure) এর ক্ষেত্রে কি একই অর্থ বহন করে?**
A) হ্যাঁ, দুটোই এক
B) না, দুটো সম্পূর্ণ আলাদা কনসেপ্ট
C) হ্যাঁ, কারণ মেমোরিতে ডেটা Tree আকারে থাকে
D) মেমোরি Heap হলো Max Heap এর উদাহরণ

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সম্পূর্ণ আলাদা! Data Structure Heap হলো একটি Complete Binary Tree। আর OS এর Heap Memory হলো কম্পিউটারের র‍্যামের একটি অংশ যেখানে ডাইনামিক্যালি মেমোরি অ্যালোকেট (যেমন `new` কিওয়ার্ড দিয়ে) করা হয়।
</details>

---

**Q36. জাভার `PriorityQueue` কি Thread-safe?**
A) হ্যাঁ
B) না
C) শুধুমাত্র `add` মেথড Thread-safe
D) শুধুমাত্র `poll` মেথড Thread-safe

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `PriorityQueue` সিঙ্ক্রোনাইজড বা থ্রেড-সেইফ নয়। মাল্টি-থ্রেডিংয়ের জন্য `PriorityBlockingQueue` ব্যবহার করতে হয়।
</details>

---

**Q37. আপনি একটি Max Heap বানাচ্ছেন। আপনার Array এর সাইজ $N$। Heap এর লিফ নোডগুলো (Leaf Nodes) অ্যারের কোন ইনডেক্স থেকে শুরু হবে?**
A) 0 থেকে
B) $N/2$ থেকে $N-1$ পর্যন্ত
C) $N/4$ থেকে
D) শেষের একটি মাত্র ইনডেক্স

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Complete Binary Tree তে মোট নোডের অর্ধেকই হয় লিফ নোড। এবং এরা সবাই অ্যারের শেষের অর্ধাংশে (অর্থাৎ $N/2$ থেকে $N-1$ ইনডেক্স পর্যন্ত) থাকে।
</details>

---

**Q38. "Decrease Key" অপারেশনটি Min Heap এ কল করলে কী করতে হয়?**
A) শুধু ভ্যালু কমিয়ে দিলেই হয়
B) ভ্যালু কমানোর পর Heapify Down করতে হয়
C) ভ্যালু কমানোর পর Heapify Up করতে হয়
D) ভ্যালু ডিলিট করতে হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Min Heap এ কোনো নোডের ভ্যালু কমালে সে তার প্যারেন্টের চেয়েও ছোট হয়ে যেতে পারে। তাই তাকে সঠিক জায়গায় পৌঁছাতে Heapify Up (উপরে ওঠানো) করতে হয়।
</details>

---

**Q39. একটি Heap এ একই ভ্যালু (Duplicate values) কি একাধিকবার ইনসার্ট করা যায়?**
A) হ্যাঁ, যায়
B) না, Heap এ সব ভ্যালু ইউনিক হতে হয় (Set এর মতো)
C) শুধুমাত্র Max Heap এ যায়
D) শুধুমাত্র Min Heap এ যায়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Heap এ ডুপ্লিকেট ভ্যালু রাখা পুরোপুরি অ্যালাউড। তারা প্যারেন্ট-চাইল্ড রুল (বড় বা সমান / ছোট বা সমান) ফলো করে পাশাপাশি পজিশন নিয়ে নেবে।
</details>

---

**Q40. [Scenario] আপনার কাছে ১ বিলিয়ন ($10^9$) নাম্বারের একটি স্ট্রিম (Stream) আসছে। আপনাকে বলা হলো এর মধ্য থেকে টপ ১০ টি সবচেয়ে বড় নাম্বার বের করতে। কোন ডেটা স্ট্রাকচার বেস্ট?**
A) Array তে রেখে Sort করা
B) Hash Table
C) 10 সাইজের Min Heap
D) 10 সাইজের Max Heap

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেহেতু আমাদের "টপ ১০ বড়" নাম্বার লাগবে, তাই আমরা ১০ সাইজের একটি Min Heap মেইনটেইন করবো। যখনই নতুন নাম্বার আসবে, যদি তা Heap এর রুটের (১০ জনের মধ্যে সবচেয়ে ছোট) চেয়ে বড় হয়, তবে রুটটি ফেলে দিয়ে নতুন নাম্বারটি ঢোকাবো। এতে স্পেস লাগবে মাত্র $O(10)$ এবং টাইম $O(N \log 10)$!
</details>
