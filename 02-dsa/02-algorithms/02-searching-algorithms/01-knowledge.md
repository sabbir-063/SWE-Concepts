# 02. Searching Algorithms (Knowledge & Theory)

## Learning Objectives
- Linear Search এবং Binary Search এর কোর কনসেপ্ট এবং তাদের Time/Space Complexity বোঝা।
- Binary Search কেন এত পাওয়ারফুল এবং এর জন্য ডেটা কেন **Sorted (সাজানো)** থাকতে হয়, তা শেখা।
- Binary Search এর বিভিন্ন வேরিয়েশন (First occurrence, Last occurrence, Floor, Ceil) সম্পর্কে জানা।
- Interpolation Search, Exponential Search এবং Ternary Search এর বেসিক আইডিয়া ক্লিয়ার করা।

---

## 1. Linear Search
Linear Search হলো সবচেয়ে সিম্পল সার্চিং অ্যালগরিদম। এটি প্রথম থেকে শুরু করে শেষ পর্যন্ত একটা একটা করে ডেটা চেক করে।

- **Time Complexity:** $O(n)$ (Worst case), $O(1)$ (Best case, যদি শুরুতেই ডেটা পাওয়া যায়)।
- **Space Complexity:** $O(1)$।
- **কখন ব্যবহার করবো?** যখন ডেটা খুব ছোট হয়, অথবা ডেটা **Unsorted (এলোমেলো)** অবস্থায় থাকে।
- **রিয়েল ওয়ার্ল্ড অ্যানালজি:** একটি এলোমেলো বইয়ের স্তূপ থেকে নির্দিষ্ট একটি বই খোঁজা। আপনাকে সবগুলো বই এক এক করে চেক করতে হবে।

---

## 2. Binary Search (The Interview Favorite)
Binary Search হলো সার্চিং অ্যালগরিদমের রাজা। এটি ডেটাকে অর্ধেক করে করে (Divide and Conquer) খোঁজে। তবে এর প্রধান শর্ত হলো—**ডেটা অবশ্যই সর্টেড (Sorted) বা সাজানো থাকতে হবে!**

### কীভাবে কাজ করে?
১. প্রথমে অ্যারের মাঝখানের (Mid) এলিমেন্টটি চেক করে।
২. যদি টার্গেট ভ্যালু মিড এলিমেন্টের সমান হয়, তবে ডান!
৩. যদি টার্গেট ছোট হয়, তবে শুধু বাম দিকের অর্ধাংশ (Left half) নিয়ে খুঁজবে।
৪. যদি টার্গেট বড় হয়, তবে ডান দিকের অর্ধাংশ (Right half) নিয়ে খুঁজবে।

### Time Complexity Magic
যেহেতু প্রতি ধাপে ডেটা অর্ধেক হয়ে যায়, তাই $N$ সাইজের অ্যারে হলে:
$N \to N/2 \to N/4 \dots \to 1$
এই জন্য এর **Time Complexity হলো $O(\log n)$**।
(অর্থাৎ ১ বিলিয়ন ডেটা থাকলেও মাত্র ৩০ বার চেক করলেই কাঙ্ক্ষিত ডেটা পাওয়া যাবে!)

### 💡 Interview / MCQ Angle
ইন্টারভিউতে প্রায়ই সরাসরি Binary Search ইমপ্লিমেন্ট করতে বলে না, বরং এর লজিক ব্যবহার করে প্রবলেম সলভ করতে দেয়। যেমন:
- "Rotated Sorted Array তে সার্চ করো" (LeetCode 33)
- "Peak Element বের করো" (LeetCode 162)
- "Monotonic ফাংশনে উত্তর খোঁজো" (Advanced BS on Answer)

---

## 3. Other Searching Algorithms (Concepts)

### A. Interpolation Search
- **কনসেপ্ট:** এটি Binary Search এর মতোই, তবে এটি মাঝখানে (Mid) না গিয়ে ডেটার প্যাটার্ন বুঝে ডাইরেক্ট ইনডেক্স অনুমান করে (যেমন ডিকশনারিতে 'Z' দিয়ে কিছু খুঁজতে আমরা সরাসরি শেষের দিকে যাই)।
- **শর্ত:** ডেটা সর্টেড হতে হবে এবং **Uniformly distributed** (সমান গ্যাপে) হতে হবে।
- **Time Complexity:** $O(\log (\log n))$ (Best/Average case), কিন্তু ডেটা ঠিকমতো ছড়ানো না থাকলে $O(n)$ (Worst case)।

### B. Exponential Search
- **কনসেপ্ট:** যদি অ্যারের সাইজ অনেক বড় (বা অসীম) হয়, তবে টার্গেট কোথায় থাকতে পারে তার একটি বাউন্ডারি ($2^0, 2^1, 2^2 \dots$) বের করা হয় এবং তারপর ওই রেঞ্জে Binary Search করা হয়।
- **Time Complexity:** $O(\log i)$ যেখানে $i$ হলো টার্গেটের ইনডেক্স।

### C. Ternary Search
- **কনসেপ্ট:** Binary Search এর মতো অ্যারেকে ২ ভাগ না করে ৩ ভাগ (২টি মিড পয়েন্ট দিয়ে) করা হয়।
- **Time Complexity:** $O(\log_3 n)$। গাণিতিকভাবে মনে হলেও প্র্যাকটিক্যালি এটি Binary Search এর চেয়ে স্লো, কারণ এতে Comparison বেশি করতে হয়।

---

## Diagrams

### 1. Binary Search Execution Flow
ধরি, আমাদের অ্যারে: `[2, 5, 8, 12, 16, 23, 38, 56, 72, 91]` এবং আমরা `23` খুঁজছি।

```mermaid
graph TD
    subgraph Step 1 (Search Space: 0 to 9)
    A1["[2, 5, 8, 12, 16, 23, 38, 56, 72, 91]"]
    A2[Mid = Index 4 = 16]
    A2 -->|23 is greater than 16| A3[Search Right Half]
    end

    subgraph Step 2 (Search Space: 5 to 9)
    B1["[23, 38, 56, 72, 91]"]
    B2[Mid = Index 7 = 56]
    B2 -->|23 is less than 56| B3[Search Left Half]
    end
    
    subgraph Step 3 (Search Space: 5 to 6)
    C1["[23, 38]"]
    C2[Mid = Index 5 = 23]
    C2 -->|Target Found!| C3((Return Index 5))
    end
    
    Step 1 --> Step 2
    Step 2 --> Step 3
```

## Binary Search "Gotchas" (The `mid` calculation)
ইন্টারভিউতে বা কম্পিটিটিভ প্রোগ্রামিংয়ে `mid` ক্যালকুলেট করার সময় অনেকেই একটি বড় ভুল করে:
❌ `int mid = (left + right) / 2;`
**কেন ভুল?** যদি `left` এবং `right` অনেক বড় ইনটিজার হয় (যেমন Integer.MAX_VALUE এর কাছাকাছি), তবে তাদের যোগফল Integer রেঞ্জ ওভারফ্লো (Overflow) করতে পারে এবং নেগেটিভ ভ্যালু দিতে পারে!

✅ **সঠিক উপায়:**
`int mid = left + (right - left) / 2;`
অথবা (বিটওয়াইজ অপারেটর দিয়ে):
`int mid = (left + right) >>> 1;` (জাভাতে)

## Quick Recap
| Algorithm | Best Time | Worst Time | When to use? |
| :--- | :--- | :--- | :--- |
| **Linear Search** | $O(1)$ | $O(n)$ | Unsorted data বা ছোট অ্যারে। |
| **Binary Search** | $O(1)$ | $O(\log n)$ | Sorted data। |
| **Interpolation** | $O(1)$ | $O(n)$ | Sorted এবং Uniformly Distributed ডেটা। |
| **Ternary Search**| $O(1)$ | $O(\log n)$ | unimodal ফাংশনে ম্যাক্স/মিন খুঁজতে (Advanced)। |
