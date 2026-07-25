# 02. Searching Algorithms (Practice MCQs)

এই ফাইলে Linear Search, Binary Search, Time Complexities, Edge Cases এবং জাভার বিল্ট-ইন সার্চ মেথডগুলোর ওপর ৪০টি ইন-ডেপথ MCQ দেওয়া হলো।

---

**Q1. Linear Search এর Worst-case Time Complexity কত?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Worst-case এ যে ডেটাটি খুঁজছি তা অ্যারের একদম শেষে থাকতে পারে বা অ্যারেতে না-ও থাকতে পারে। তখন অ্যারের $n$ টি ইলিমেন্টই চেক করতে হয়, তাই কমপ্লেক্সিটি $O(n)$।
</details>

---

**Q2. Binary Search অ্যালগরিদমের মূল শর্ত (Prerequisite) কী?**
A) ডেটা অবশ্যই পজিটিভ হতে হবে
B) অ্যারের সাইজ জোড় সংখ্যা হতে হবে
C) ডেটা অবশ্যই সর্টেড (Sorted) বা সাজানো থাকতে হবে
D) ডেটা শুধুমাত্র ইনটিজার হতে হবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Binary Search কাজ করে "অর্ধেক বাদ দেওয়ার" (Divide and Conquer) নীতির ওপর। ডেটা সর্টেড না থাকলে বোঝা যাবে না যে বামে খুঁজবো নাকি ডানে।
</details>

---

**Q3. Binary Search এর Time Complexity কত?**
A) $O(n)$
B) $O(\log n)$
C) $O(n \log n)$
D) $O(1)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রতিবার সার্চ স্পেস অর্ধেক হয়ে যায়। তাই $N$ সাইজের অ্যারেতে ম্যাক্সিমাম $\log_2(N)$ বার চেক করতে হয়।
</details>

---

**Q4. Binary Search এর Space Complexity (Iterative method) কত?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Iterative মেথডে শুধু কয়েকটি ভেরিয়েবল (left, right, mid) ব্যবহার করা হয়, কোনো এক্সট্রা মেমোরি বা কল-স্ট্যাক লাগে না। তাই $O(1)$।
</details>

---

**Q5. যদি Binary Search রিকার্সিভলি (Recursively) ইমপ্লিমেন্ট করা হয়, তবে এর Space Complexity কত হবে?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সিভ কলে প্রতিবার মেমোরিতে একটি করে স্ট্যাক ফ্রেম তৈরি হয়। যেহেতু ম্যাক্সিমাম $\log n$ বার কল হয়, তাই কল-স্ট্যাকের জন্য $O(\log n)$ স্পেস লাগে।
</details>

---

**Q6. [Interview Gotcha] জাভাতে Binary Search এর `mid` বের করার সবচেয়ে নিরাপদ উপায় কোনটি?**
A) `(left + right) / 2`
B) `(left + right) >> 1`
C) `left + (right - left) / 2`
D) `left + right / 2`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যদি `left` এবং `right` দুটোই খুব বড় সংখ্যা হয়, তবে তাদের যোগফল Integer এর ম্যাক্স লিমিট ক্রস করে ওভারফ্লো (Overflow) করতে পারে এবং নেগেটিভ ভ্যালু দিতে পারে। `left + (right - left) / 2` ওভারফ্লো প্রিভেন্ট করে।
</details>

---

**Q7. Interpolation Search এর Worst-case Time Complexity কত?**
A) $O(\log (\log n))$
B) $O(\log n)$
C) $O(n)$
D) $O(1)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Interpolation Search ভালো কাজ করে যখন ডেটা ইউনিফর্মলি ডিস্ট্রিবিউটেড (সমান গ্যাপে) থাকে। কিন্তু ডেটা যদি ছড়ানো-ছিটানো (Skewed) থাকে, তবে এটি $O(n)$ বা লিনিয়ার টাইমে নেমে যেতে পারে।
</details>

---

**Q8. কোন পরিস্থিতিতে Interpolation Search, Binary Search এর চেয়ে ভালো কাজ করে?**
A) যখন ডেটা Unsorted থাকে
B) যখন ডেটা Uniformly distributed এবং অনেক বড় হয়
C) যখন অ্যারেতে ডুপ্লিকেট ডেটা থাকে
D) যখন মেমোরি কম থাকে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেমন ডিকশনারিতে 'Z' খুঁজতে আমরা সরাসরি শেষের দিকে চলে যাই, তেমনি Uniform ডেটাতে Interpolation Search সরাসরি অনুমিত জায়গায় চলে যায়, যার টাইম $O(\log(\log n))$।
</details>

---

**Q9. Ternary Search এ অ্যারেকে কয় ভাগে ভাগ করা হয়?**
A) ২ ভাগে
B) ৩ ভাগে
C) ৪ ভাগে
D) ভাগ করা হয় না

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Ternary Search এ দুটি মিড পয়েন্ট (mid1, mid2) দিয়ে অ্যারেকে সমান ৩ ভাগে ভাগ করা হয়। এর Time Complexity $O(\log_3 n)$।
</details>

---

**Q10. প্র্যাকটিক্যালি Binary Search এবং Ternary Search এর মধ্যে কোনটি বেশি ফাস্ট?**
A) Ternary Search
B) Binary Search
C) দুটোই সমান
D) নির্ভর করে অ্যারের ডেটার ওপর

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গাণিতিকভাবে $\log_3 n < \log_2 n$ হলেও, Ternary Search এ প্রতি ধাপে ২টি কম্পারিজন (Comparison) করতে হয়, যেখানে Binary তে মাত্র ১টি। তাই প্র্যাকটিক্যালি Binary Search দ্রুত কাজ করে।
</details>

---

**Q11. Exponential Search সাধারণত কোথায় ব্যবহার করা হয়?**
A) Unsorted Array তে
B) Infinite বা Unknown সাইজের সর্টেড অ্যারেতে
C) Linked List এ
D) Binary Search Tree তে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যখন অ্যারের সাইজ জানা থাকে না (Infinite streams), তখন $2^0, 2^1, 2^2...$ এভাবে লাফ দিয়ে বাউন্ডারি বের করা হয়, তারপর ওই বাউন্ডারির মাঝে Binary Search করা হয়।
</details>

---

**Q12. একটি সর্টেড অ্যারেতে `target` এর "First Occurrence" (প্রথম কোথায় আছে) বের করতে Binary Search এ কী পরিবর্তন করতে হয়?**
A) `mid` এ ডেটা পেলেই লুপ ব্রেক করতে হয়
B) `mid` এ ডেটা পেলেও খোঁজা না থামিয়ে `right = mid - 1` করে বাম দিকে খুঁজতে হয়
C) `mid` এ ডেটা পেলেও `left = mid + 1` করে ডান দিকে খুঁজতে হয়
D) এটি Binary Search দিয়ে করা সম্ভব নয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু ডেটা সর্টেড, তাই ডুপ্লিকেট ডেটাগুলো পাশাপাশি থাকবে। `target` পেলেও তার আগের ইনডেক্সগুলোতে একই ভ্যালু আছে কি না তা নিশ্চিত করতে বাম দিকে (left side) মুভ করতে হয়।
</details>

---

**Q13. একটি সর্টেড অ্যারেতে `target` এর "Last Occurrence" (সবশেষ কোথায় আছে) বের করতে Binary Search এ কী করতে হয়?**
A) `right = mid - 1` করতে হয়
B) `left = mid + 1` করে ডান দিকে খুঁজতে হয়
C) লুপ উল্টো করে চালাতে হয়
D) `break` করতে হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `target` পাওয়ার পরও ডান দিকে (Right side) আরও একই ভ্যালু আছে কি না তা চেক করার জন্য `left = mid + 1` করতে হয়।
</details>

---

**Q14. Java এর `Arrays.binarySearch(arr, key)` মেথডটি যদি ডেটা খুঁজে না পায়, তবে কী রিটার্ন করে?**
A) -1
B) `false`
C) `NullPointerException`
D) `-(insertion point) - 1`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: জাভার বিল্ট-ইন মেথড ডেটা না পেলে নেগেটিভ ভ্যালু দেয়। এটি এমনভাবে ডিজাইন করা যে, `-(insertion point) - 1` রিটার্ন করে। অর্থাৎ যেখানে ভ্যালুটি বসালে অ্যারেটি সর্টেড থাকতো, তার ওপর ভিত্তি করে নেগেটিভ নাম্বার দেয়।
</details>

---

**Q15. `arr = [10, 20, 30, 40, 50]`। আপনি `Arrays.binarySearch(arr, 25)` কল করলেন। আউটপুট কত হবে?**
A) -1
B) -2
C) -3
D) 2

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: `25` বসানোর সঠিক জায়গা হলো ইনডেক্স 2 (30 এর জায়গায়)। ফর্মুলা অনুযায়ী: `-(2) - 1 = -3` রিটার্ন করবে।
</details>

---

**Q16. Binary Search কি Linked List এর ওপর সরাসরি (Efficiently) প্রয়োগ করা যায়?**
A) হ্যাঁ, $O(\log n)$ টাইমে
B) না, কারণ Linked List এ ডাইরেক্ট অ্যাক্সেস (Random Access) নেই, তাই মিডিল এলিমেন্ট বের করতে $O(n)$ সময় লাগে
C) হ্যাঁ, যদি Doubly Linked List হয়
D) না, কারণ Linked List সর্ট করা যায় না

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Array তে `arr[mid]` দিয়ে $O(1)$ টাইমে মাঝের এলিমেন্ট পাওয়া যায়। কিন্তু Linked List এ মাঝখানে যেতে লুপ চালিয়ে $O(n)$ সময় লাগে, ফলে Binary Search এর মূল সুবিধাটাই নষ্ট হয়ে যায়।
</details>

---

**Q17. নিচের কোনটি "Divide and Conquer" অ্যালগরিদমের উদাহরণ?**
A) Linear Search
B) Binary Search
C) Bubble Sort
D) Insertion Sort

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Binary Search প্রতি ধাপে প্রবলেমটিকে (অ্যারেকে) অর্ধেক করে ফেলে, তাই এটি Divide and Conquer এর চমৎকার উদাহরণ।
</details>

---

**Q18. একটি Array তে কোনো ইলিমেন্ট না থাকলে `left` এবং `right` পয়েন্টার Binary Search লুপ শেষে কী অবস্থায় থাকবে?**
A) `left == right`
B) `left > right` (ক্রস করে যাবে)
C) `left < right`
D) `left = 0`, `right = 0`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `while (left <= right)` লুপটি তখনই ব্রেক হয় যখন `left` পয়েন্টারটি `right` কে ক্রস করে সামনে চলে যায় (অর্থাৎ `left > right` হয়)। এর মানে পুরো সার্চ স্পেস শেষ।
</details>

---

**Q19. $1,000,000$ (১ মিলিয়ন) এলিমেন্টের একটি সর্টেড অ্যারেতে Binary Search করলে সর্বোচ্চ (Worst-case) কতবার কম্পারিজন (Comparison) করতে হবে?**
A) 1,000,000 বার
B) প্রায় 10 বার
C) প্রায় 20 বার
D) 500,000 বার

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: $2^{20} \approx 1,000,000$। অর্থাৎ ১ মিলিয়ন ডেটাকে অর্ধেক করতে করতে ১ এ পৌঁছাতে সর্বোচ্চ ২০ বার ভাগ করতে হবে। ($\log_2(1,000,000) \approx 20$)।
</details>

---

**Q20. "Floor of a Number" (Binary Search variation) বলতে কী বোঝায়?**
A) অ্যারের সবচেয়ে ছোট নাম্বার
B) টার্গেটের চেয়ে ছোট বা সমান সবচেয়ে বড় নাম্বারটি
C) টার্গেটের চেয়ে বড় বা সমান সবচেয়ে ছোট নাম্বারটি
D) টার্গেটের ইনডেক্স

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Floor মানে হলো ওই নাম্বারের ঠিক ইমিডিয়েট ছোট বা সমান ভ্যালু। যেমন `[2, 4, 6, 8]` এ 5 এর Floor হলো 4।
</details>

---

**Q21. "Ceiling of a Number" (Ceil) বলতে কী বোঝায়?**
A) টার্গেটের চেয়ে ছোট সবচেয়ে বড় নাম্বার
B) টার্গেটের চেয়ে বড় বা সমান সবচেয়ে ছোট নাম্বারটি
C) অ্যারের সবচেয়ে বড় নাম্বার
D) টার্গেটের ইনডেক্স

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Ceil মানে হলো ওই নাম্বারের ঠিক ইমিডিয়েট বড় বা সমান ভ্যালু। যেমন `[2, 4, 6, 8]` এ 5 এর Ceil হলো 6।
</details>

---

**Q22. LeetCode এর "Search in Rotated Sorted Array" (যেমন `[4,5,6,7,0,1,2]`) প্রবলেমে $O(\log n)$ এ সলভ করার মূল ট্রিক কী?**
A) প্রথমে Array টি সর্ট করে নেওয়া
B) Linear Search ব্যবহার করা
C) প্রতি ধাপে চেক করা যে Array এর বাম অংশ (Left half) সর্টেড নাকি ডান অংশ (Right half) সর্টেড
D) Array টিকে নতুন দুটি Array তে ভাগ করা

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Rotated Array তে যেকোনো Mid পয়েন্ট নিলে হয় তার বাম দিক সর্টেড থাকবে, না হয় ডান দিক সর্টেড থাকবে। এই প্রপার্টি কাজে লাগিয়ে Binary Search করা হয়।
</details>

---

**Q23. [Code Output] নিচের লুপে কী ভুল আছে?**
```java
int left = 0, right = arr.length - 1;
while(left < right) {
    int mid = left + (right - left) / 2;
    if(arr[mid] == target) return mid;
    else if(arr[mid] < target) left = mid; // Here
    else right = mid - 1;
}
```
A) কোনো ভুল নেই
B) `left = mid` দেওয়ার কারণে এটি Infinite Loop এ পড়ে যেতে পারে
C) `mid` ক্যালকুলেশন ভুল
D) `while` কন্ডিশন ভুল

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যখন `left` এবং `right` পাশাপাশি থাকে (যেমন ২ ও ৩), তখন `mid` হবে ২। যদি `arr[mid] < target` হয়, তবে `left = mid` করলে `left` ২-ই থেকে যাবে এবং লুপটি আজীবন চলতে থাকবে! সঠিক নিয়ম হলো `left = mid + 1`।
</details>

---

**Q24. Binary Search Tree (BST) তে ডেটা সার্চ করার টাইম কমপ্লেক্সিটি এবং একটি Sorted Array তে Binary Search করার টাইম কমপ্লেক্সিটির মধ্যে পার্থক্য কী?**
A) BST তে $O(n)$, Array তে $O(\log n)$
B) BST তে ব্যালান্সড হলে $O(\log n)$, আনব্যালান্সড (Skewed) হলে $O(n)$। কিন্তু Sorted Array তে সবসময় $O(\log n)$।
C) দুটোই সবসময় $O(\log n)$
D) Array তে $O(n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: BST যদি একপাশে লম্বা হয়ে যায় (Skewed), তবে সার্চ টাইম $O(n)$ হয়ে যায়। কিন্তু Array তে সরাসরি Mid ইনডেক্সে যাওয়া যায় বলে সবসময় $O(\log n)$ গ্যারান্টিড।
</details>

---

**Q25. "Binary Search on Answer" বা "Monotonic Search" কখন ব্যবহার করা হয়?**
A) যখন String এর মধ্যে Character খুঁজতে হয়
B) যখন আমাদের উত্তরের রেঞ্জ (যেমন ১ থেকে ম্যাক্স ক্যাপাসিটি) জানা থাকে এবং উত্তরটি একটি নির্দিষ্ট পয়েন্টের পর থেকে সবসময় True বা False হয় (Monotonic)
C) যখন Array Unsorted থাকে
D) যখন Graph Traversal করতে হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: অনেক প্রবলেমে ডাইরেক্ট ডেটা খুঁজতে না বলে ক্যাপাসিটি বা স্পিড বের করতে বলে। সেখানে আমরা উত্তরের রেঞ্জের ওপর Binary Search চালিয়ে চেক করি। (যেমন: Koko Eating Bananas - LeetCode 875)।
</details>

---

**Q26. Unsorted Array তে একটি নির্দিষ্ট ইলিমেন্ট খোঁজার একমাত্র উপায় কী?**
A) Binary Search
B) Interpolation Search
C) Linear Search
D) Ternary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেহেতু ডেটা এলোমেলো, তাই প্রথম থেকে শেষ পর্যন্ত একটি একটি করে চেক করা (Linear Search) ছাড়া আর কোনো উপায় নেই।
</details>

---

**Q27. একটি ম্যাট্রিক্সের (2D Array) সারি (Row) এবং কলাম (Column) উভয়ই সর্টেড। এখানে $O(N+M)$ টাইমে সার্চ করার জন্য কোথা থেকে খোঁজা শুরু করা উচিত?**
A) টপ-লেফট (0, 0) থেকে
B) বটম-রাইট (N, M) থেকে
C) টপ-রাইট (0, M-1) বা বটম-লেফট (N-1, 0) থেকে
D) যেকোনো জায়গা থেকে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: টপ-রাইট কর্নার থেকে শুরু করলে বামে গেলে ভ্যালু কমে আর নিচে নামলে ভ্যালু বাড়ে। এটি অনেকটা Binary Search এর ডিসিশন মেকিংয়ের মতো কাজ করে, ফলে খুব দ্রুত টার্গেট পাওয়া যায়।
</details>

---

**Q28. "Peak Element" (যে নোডটি তার দুই পাশের নোডের চেয়ে বড়) বের করতে $O(\log n)$ টাইমে কোন লজিক কাজ করে?**
A) Linear Search
B) Binary Search (Mid পয়েন্টের ঢাল বা Slope চেক করে)
C) Array Sorting
D) Hashing

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `mid` এবং `mid+1` চেক করে বোঝা যায় গ্রাফটি উপরের দিকে উঠছে নাকি নিচের দিকে নামছে। উপরের দিকে উঠলে পিক ডানদিকে আছে, আর নামলে পিক বামদিকে আছে।
</details>

---

**Q29. Binary Search এ যদি Array তে একাধিক টার্গেট এলিমেন্ট থাকে এবং আপনি নরমাল `if (arr[mid] == target) return mid;` ব্যবহার করেন, তবে এটি কোন ইনডেক্সটি রিটার্ন করবে?**
A) ফার্স্ট ইনডেক্স
B) লাস্ট ইনডেক্স
C) যেকোনো একটি (যেটি প্রথমে mid হিসেবে ধরা পড়বে)
D) সবগুলো ইনডেক্সের লিস্ট

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: নরমাল Binary Search গ্যারান্টি দেয় না যে সে ফার্স্ট বা লাস্ট ইনডেক্সটাই দেবে। লুপ চালানোর সময় যে ইনডেক্সটি প্রথম `mid` এর সাথে ম্যাচ করে যাবে, সেটিই রিটার্ন হয়ে যাবে।
</details>

---

**Q30. `System.out.println(Arrays.binarySearch(new int[]{1, 2, 4, 5}, 3));` এর আউটপুট কত?**
A) -2
B) -3
C) -1
D) 2

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 3 এর সঠিক পজিশন হলো ইনডেক্স 2 (4 এর জায়গায়)। তাই আউটপুট হবে `-(2) - 1 = -3`।
</details>

---

**Q31. 1000 সাইজের একটি সর্টেড অ্যারেতে Linear Search এর এভারেজ (Average) টাইম কমপ্লেক্সিটি কত?**
A) $O(\log n)$
B) $O(1)$
C) $O(n/2)$ যা গাণিতিকভাবে $O(n)$
D) $O(n^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: গড়ে আপনাকে অ্যারের অর্ধেক (৫০০ বার) স্ক্যান করতে হতে পারে। তবে Big-O নোটেশনে কনস্ট্যান্ট (1/2) বাদ দেওয়া হয়, তাই এটি $O(n)$ ই থাকে।
</details>

---

**Q32. নিচের কোন ক্ষেত্রে Linear Search, Binary Search এর চেয়ে দ্রুত কাজ করতে পারে?**
A) যখন টার্গেট এলিমেন্টটি অ্যারের একেবারে প্রথম ইনডেক্সে (0) থাকে
B) যখন অ্যারে অনেক বড় হয়
C) যখন টার্গেট এলিমেন্টটি অ্যারের মাঝে থাকে
D) যখন অ্যারে পুরোপুরি সর্টেড থাকে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: টার্গেট যদি ইনডেক্স 0 তেই থাকে, তবে Linear Search প্রথম চেক করেই উত্তর দিয়ে দেবে ($O(1)$)। কিন্তু Binary Search প্রথমে মাঝখানে যাবে, তারপর বামে আসবে, ফলে একটু বেশি স্টেপ লাগবে।
</details>

---

**Q33. "Jump Search" অ্যালগরিদম কীভাবে কাজ করে?**
A) এটি র্যান্ডমলি ইনডেক্স চেক করে
B) এটি ফিক্সড সাইজের ব্লক (যেমন $\sqrt{n}$) জাম্প করে চেক করে, এবং ব্লক পেয়ে গেলে সেখানে Linear Search করে
C) এটি Binary Search এর মতোই কাজ করে
D) এটি Linked list এর জন্য ব্যবহৃত হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Jump Search এ $\sqrt{n}$ স্টেপ পর পর জাম্প করে বাউন্ডারি খোঁজা হয়। এর Time Complexity $O(\sqrt{n})$ যা Linear Search এর চেয়ে ভালো কিন্তু Binary Search এর চেয়ে স্লো।
</details>

---

**Q34. C++ এর STL এ Binary Search এর জন্য কোন ফাংশনগুলো আছে (জাভার বিকল্প হিসেবে জানার জন্য)?**
A) `binary_search()`, `lower_bound()`, `upper_bound()`
B) `find()`
C) `search()`
D) `b_search()`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: `binary_search()` শুধু True/False দেয়। `lower_bound()` ফার্স্ট অকারেন্স বা Ceil দেয় এবং `upper_bound()` টার্গেটের ঠিক বড় ভ্যালুটি দেয়।
</details>

---

**Q35. আপনি একটি 3D গেম বানাচ্ছেন যেখানে একটি অবজেক্ট অন্য অবজেক্টের সাথে ধাক্কা (Collision) খেয়েছে কি না তা ডিটেক্ট করতে হবে। অবজেক্টগুলোর পজিশন সর্ট করা নেই। কোন সার্চ ব্যবহার করবেন?**
A) Binary Search
B) Linear Search (বা Spatial Partitioning Tree)
C) Interpolation Search
D) Jump Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: পজিশন আনসর্টেড থাকলে Linear Search ই বেসিক উপায়। তবে ગેম ইঞ্জিনে অপ্টিমাইজ করার জন্য Quadtree/Octree (Spatial Partitioning) ব্যবহার করা হয়।
</details>

---

**Q36. Bitwise Right Shift (`>>> 1`) ব্যবহার করে $mid$ বের করার সুবিধা কী?**
A) এটি অ্যারের সাইজ কমিয়ে দেয়
B) এটি আনসাইনড (Unsigned) রাইট শিফট করে, যা পজিটিভ ওভারফ্লো হ্যান্ডেল করে এবং ডিভাইড `/ 2` এর চেয়ে সামান্য ফাস্ট
C) এটি ডাবল (Double) রিটার্ন করে
D) এটি শুধুমাত্র নেগেটিভ নাম্বারের জন্য কাজ করে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `(left + right) >>> 1` জাভাতে ওভারফ্লো হওয়া নেগেটিভ বিটকে পজিটিভে কনভার্ট করে দেয় এবং ২ দিয়ে ভাগ করার কাজটা খুব দ্রুত (CPU লেভেলে) করে।
</details>

---

**Q37. Array এর সাইজ যদি 1 হয়, তবে Binary Search (while left <= right) লুপটি কতবার চলবে?**
A) 0 বার
B) 1 বার
C) 2 বার
D) Infinite বার

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `left = 0`, `right = 0`। `0 <= 0` কন্ডিশন সত্য, তাই লুপ ১ বার চলবে, `mid = 0` চেক করবে এবং তারপর `left` বা `right` আপডেট হয়ে লুপ ব্রেক হবে।
</details>

---

**Q38. "Square Root of an Integer" (যেমন $\sqrt{10}$) বের করার জন্য Binary Search ব্যবহার করা যায়। এর সার্চ স্পেস (Search Space) কত থেকে কত হবে?**
A) 0 থেকে 10
B) 0 থেকে 5
C) 1 থেকে $x/2$ (যেখানে x = 10)
D) 1 থেকে $x$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: যেকোনো সংখ্যার (যেমন $x$) বর্গমূল 1 থেকে $x$ এর মাঝেই থাকবে (ছোট সংখ্যার জন্য)। তাই `left = 1` এবং `right = x` ধরে Binary Search করে $mid \times mid \le x$ চেক করা যায়।
</details>

---

**Q39. একটি অসীম (Infinite) ডেটা স্ট্রিমে যেখানে শেষ ইনডেক্স জানা নেই, সেখানে Binary Search চালানোর আগে কোন অ্যালগরিদম ব্যবহার করে বাউন্ডারি বের করতে হয়?**
A) Linear Search
B) Exponential Search ($1, 2, 4, 8, 16...$ করে ইনডেক্স বাড়িয়ে রেঞ্জ খোঁজা)
C) Jump Search
D) Ternary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Exponential Search খুব দ্রুত $O(\log i)$ টাইমে একটি বাউন্ডারি (যেখানে `arr[high] > target`) বের করে দেয়। এরপর ওই `low` এবং `high` রেঞ্জের মাঝে Binary Search করা হয়।
</details>

---

**Q40. [Conclusion] ডেটাবেস ইনডেক্সিং (Database Indexing) এ সার্চ ফাস্ট করার জন্য ইন্টার্নালি কোন কনসেপ্টের হাইব্রিড বা মডিফায়েড রূপ ব্যবহার করা হয়?**
A) Linear Search
B) B-Tree / B+ Tree (যা এক ধরনের N-ary Search Tree)
C) Bubble Sort
D) Interpolation Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডেটাবেসে B+ Tree ব্যবহার করা হয়, যা Binary Search Tree এর একটি ব্যালান্সড এবং মাল্টি-নোড ভার্সন। এটি ডিস্ক আই/ও (I/O) কমানোর পাশাপাশি $O(\log n)$ টাইমে ডেটা সার্চ করতে পারে।
</details>
