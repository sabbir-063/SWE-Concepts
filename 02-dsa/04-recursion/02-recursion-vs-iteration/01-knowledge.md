# 02. Recursion vs Iteration (Knowledge & Theory)

## Learning Objectives
- Recursion এবং Iteration (Loops) এর মধ্যে মূল পার্থক্যগুলো ক্লিয়ার করা।
- Time এবং Space Complexity এর ক্ষেত্রে এদের মধ্যে তুলনামূলক (Trade-off) বিশ্লেষণ।
- কখন Recursion ব্যবহার করা উচিত এবং কখন Iteration ব্যবহার করা উচিত তা বোঝা।
- Recursion কে কীভাবে Iteration এ কনভার্ট করা যায় তার বেসিক আইডিয়া।

---

## 1. Core Definitions

### Iteration (লুপ)
Iteration হলো একই কাজ বারবার করা (Repetition), যা সাধারণত `for`, `while`, বা `do-while` লুপ দিয়ে করা হয়। একটি নির্দিষ্ট কন্ডিশন `false` না হওয়া পর্যন্ত লুপটি চলতে থাকে।
- **Key concept:** স্টেট (State) আপডেট করার জন্য ভেরিয়েবল (যেমন `i`, `count`) ব্যবহার করে।

### Recursion (রিকার্সন)
Recursion হলো একটি ফাংশন যা নিজের কাজ শেষ করার জন্য নিজেকেই (Itself) কল করে।
- **Key concept:** স্টেট আপডেট করার জন্য ফাংশনের প্যারামিটার (Parameters) এবং কল-স্ট্যাক (Call Stack) ব্যবহার করে।

---

## 2. Head-to-Head Comparison

| Feature | Iteration (Loop) | Recursion |
| :--- | :--- | :--- |
| **State Management** | ভেরিয়েবল আপডেট করে (Mutable state)। | প্যারামিটার পাস করে (Immutable/Functional style)। |
| **Termination** | লুপের কন্ডিশন `false` হলে থামে। | `Base Case` হিট করলে থামে। |
| **Memory (Space)** | $O(1)$ স্পেস লাগে (যদি এক্সট্রা অ্যারে না নেওয়া হয়)। | $O(N)$ স্পেস লাগে (Call Stack এর কারণে)। |
| **Speed (Time)** | ফাস্ট। ফাংশন কলের কোনো ওভারহেড নেই। | স্লো। বারবার ফাংশন কল এবং স্ট্যাক ফ্রেম তৈরির ওভারহেড আছে। |
| **Infinite Loop Risk** | ইনফিনিট লুপ হলে শুধু CPU ইউজ হয়, প্রোগ্রাম ক্র্যাশ করে না (সাধারণত)। | Base Case ভুল হলে `StackOverflowError` দিয়ে প্রোগ্রাম সাথে সাথে ক্র্যাশ করে। |
| **Code Readability** | কমপ্লেক্স ডেটা স্ট্রাকচারে (যেমন Tree/Graph) কোড লেখা কঠিন ও বড় হয়। | Tree/Graph এ কোড অনেক ক্লিন, ছোট এবং মানুষের পড়ার উপযোগী (Readable) হয়। |

---

## 3. The "Under the Hood" Mechanics

### Iteration এর মেমোরি:
যখন একটি `while(i < 10)` লুপ চলে, মেমোরিতে শুধু `i` নামের একটি ভেরিয়েবল থাকে যার ভ্যালু বারবার আপডেট (ওভাররাইট) হয়। তাই এটি মেমোরি-ফ্রেন্ডলি।

### Recursion এর মেমোরি:
যখন `fact(5)` কল হয়, মেমোরিতে একটি বক্স (Stack Frame) তৈরি হয়। সে আবার `fact(4)` কে কল করলে তার ওপর আরেকটি বক্স তৈরি হয়। এভাবে ৫টি আলাদা বক্স তৈরি হয়। 
এটি ঠিক যেন ৫টি আলাদা ফাংশন মেমোরিতে একই সাথে জায়গা দখল করে বসে আছে! একারণেই রিকার্সন বেশি স্পেস খায়।

---

## 4. When to use Which? (ইন্টারভিউ ডিসিশন মেকিং)

### ✅ Use Recursion When:
1. **Tree or Graph Traversal:** (DFS, Inorder, Preorder, Postorder) এগুলোর লজিক রিকার্সন দিয়ে লিখলে ২-৩ লাইনে হয়ে যায়, কিন্তু লুপ দিয়ে লিখতে গেলে ম্যানুয়ালি Stack বানাতে হয় যা অনেক পেইনফুল।
2. **Divide and Conquer:** Merge Sort, Quick Sort এ প্রবলেমকে অর্ধেক করে ভাঙার কাজটা রিকার্সনে খুব ন্যাচারাল।
3. **Dynamic Programming (Memoization):** রিকার্সন লিখে জাস্ট ২ লাইনে মেমোরি অ্যাড করে দিলে DP হয়ে যায়।
4. **Code Clarity is priority:** পারফরম্যান্সের চেয়ে যদি কোডের রিডাবিলিটি বেশি দরকার হয়।

### ❌ Avoid Recursion (Use Iteration) When:
1. **Massive Input Size ($N > 10,000$):** অনেক প্ল্যাটফর্মে (যেমন LeetCode, HackerRank) বা জাভাতে স্ট্যাক সাইজ লিমিট থাকে। ইনপুট অনেক বড় হলে নিশ্চিত `StackOverflow` খাবে।
2. **Performance is Critical:** এম্বেডেড সিস্টেম বা গেম ইঞ্জিনে যেখানে এক মিলি-সেকেন্ড এবং এক বাইট মেমোরিও ইম্পর্ট্যান্ট, সেখানে রিকার্সনের বদলে লুপ ব্যবহার করা হয়।
3. **Simple Math/Linear Traversal:** ফ্যাক্টোরিয়াল বের করা বা অ্যারে ট্রাভার্স করার মতো সাধারণ কাজে রিকার্সন ব্যবহার করা বোকামি, লুপই বেস্ট।

---

## 5. Converting Recursion to Iteration
**Rule of thumb:** "যেকোনো রিকার্সনকেই লুপে কনভার্ট করা সম্ভব।"

কারণ রিকার্সন কিছুই না, এটি শুধু OS এর বিল্ট-ইন **Call Stack** ব্যবহার করে। আপনি যদি OS এর স্ট্যাক ব্যবহার না করে নিজেই একটি `Stack` ডেটা স্ট্রাকচার (যেমন `Stack<Integer> stack = new Stack<>()`) ডিক্লেয়ার করেন এবং তার ভেতরে `while(!stack.isEmpty())` লুপ চালান, তবে আপনি যেকোনো রিকার্সনকে ইটারেটিভে কনভার্ট করে ফেলতে পারবেন! 

*(এটির প্র্যাকটিক্যাল কোড `02-code.md` ফাইলে দেখানো হয়েছে)।*
