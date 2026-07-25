# 02. Recursion vs Iteration (Practice MCQs)

This file contains 40 in-depth MCQs comparing Recursion and Iteration, focusing on Time/Space Complexity trade-offs, Call Stack overhead, and scenario-based decision making.

---

**Q1. What is the most fundamental operational difference between Recursion and Iteration?**
A) Iteration uses the system's Call Stack, while recursion uses local variables
B) Iteration explicitly uses loop constructs (e.g., `for`, `while`) to repeat code, whereas recursion repeats code by having a function call itself
C) Recursion is always faster than Iteration
D) Iteration can only be used with arrays

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইটারেশন লুপ ব্যবহার করে বারবার একই কাজ করে, আর রিকার্সন ফাংশনকে বারবার কল করে লুপের মতো ইফেক্ট তৈরি করে।
</details>

---

**Q2. How is the "State" (the current variables and progress) maintained in Iteration vs Recursion?**
A) Both maintain state exactly the same way
B) Iteration maintains state using mutable local variables, while Recursion maintains state implicitly via function parameters and the Call Stack
C) Iteration uses the OS kernel, while recursion uses the hard drive
D) Recursion cannot maintain state

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: লুপের ভেতরে ভেরিয়েবল (`i++` বা `sum += x`) আপডেট করে স্টেট মেইনটেইন করা হয়। কিন্তু রিকার্সনে ফাংশনের প্যারামিটার দিয়ে (যেমন `fact(n-1)`) স্টেট পাঠানো হয়, যা স্ট্যাক ফ্রেমে সেভ থাকে।
</details>

---

**Q3. When comparing standard Space Complexity, how does an Iterative solution usually compare to a Recursive solution for the same problem (assuming no extra arrays/data structures are manually created)?**
A) Iteration usually takes $O(N)$ space, Recursion takes $O(1)$ space
B) Both take $O(1)$ space
C) Iteration usually takes $O(1)$ space, Recursion takes $O(N)$ space (due to the Call Stack)
D) Both take $O(N)$ space

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: সাধারণ লুপে শুধু গুটিকয়েক ভেরিয়েবল লাগে তাই স্পেস $O(1)$। কিন্তু রিকার্সনে প্রতিটি কলের জন্য স্ট্যাকে মেমোরি ব্লক (Frame) তৈরি হয়, তাই স্পেস $O(N)$ হয়।
</details>

---

**Q4. In terms of sheer Execution Speed (Time overhead), which approach is generally faster at the CPU level?**
A) Recursion, because it uses the Call Stack
B) Iteration, because it avoids the overhead of context switching and creating new stack frames for every function call
C) Both execute at the exact same speed
D) Recursion, because it avoids loops

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফাংশন কল করাটা CPU এর জন্য একটি ভারী (Heavy) কাজ। মেমোরি অ্যালোকেট করা, পয়েন্টার মুভ করা—এসবের জন্য রিকার্সন লুপের চেয়ে সামান্য স্লো হয়।
</details>

---

**Q5. What is a "Stack Frame" in the context of Recursion?**
A) A GUI window that displays the code
B) A block of memory pushed onto the Call Stack that holds the local variables, parameters, and return address for a specific function call
C) A specialized data structure used exclusively in Java
D) An array that stores iterative variables

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফাংশন কল হলেই তার নিজস্ব ডেটা (যেমন লোকাল ভেরিয়েবল, কোথা থেকে কল হয়েছে তার এড্রেস) সেভ করার জন্য মেমোরিতে একটি ব্লক তৈরি হয়, একেই Stack Frame বলে।
</details>

---

**Q6. What happens when an Iterative `while` loop has a faulty or missing termination condition?**
A) The program immediately throws a `StackOverflowError`
B) The program terminates normally but returns a garbage value
C) The program enters an Infinite Loop, utilizing CPU heavily until manually killed or timed out
D) The compiler fixes it automatically

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: লুপের কন্ডিশন ভুল হলে সেটি অনন্তকাল ঘুরতে থাকে (Infinite loop)। প্রোগ্রাম হ্যাং হয়ে যায় কিন্তু সাধারণত ক্র্যাশ করে না (Memory leak না হলে)।
</details>

---

**Q7. What happens when a Recursive function has a faulty or missing Base Case?**
A) It enters an Infinite Loop but the program stays responsive
B) It executes exactly once and stops
C) It continually creates new stack frames until the memory limit is reached, resulting in a `StackOverflowError` and an immediate program crash
D) The compiler fixes it automatically

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: রিকার্সন না থামলে স্ট্যাকে ফ্রেম জমা হতেই থাকে। একসময় স্ট্যাক ফুল হয়ে যায় এবং প্রোগ্রাম ক্র্যাশ করে।
</details>

---

**Q8. Why is Tree or Graph traversal (like DFS) heavily biased towards using Recursion rather than Iteration?**
A) Because Iteration cannot process trees
B) Because the recursive structure directly maps to the hierarchical nature of trees, making the code vastly shorter, cleaner, and more readable
C) Because recursion makes tree traversal execute in $O(1)$ time
D) Because Java requires recursion for custom objects

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ট্রির ডেটা স্ট্রাকচারটাই রিকার্সিভ (একটি নোডের নিচে আরও সাব-ট্রি থাকে)। তাই রিকার্সন দিয়ে ট্রির কোড লিখলে তা ২-৩ লাইনে হয়ে যায় এবং বুঝতে খুব সহজ হয়।
</details>

---

**Q9. If you attempt to traverse a binary tree iteratively instead of recursively, what data structure must you manually implement/utilize to manage the state?**
A) A HashMap
B) A Stack (to mimic the OS Call Stack)
C) A Priority Queue
D) A Boolean Array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সন যে কাজটা OS এর Call Stack দিয়ে অটোমেটিকভাবে করে, ইটারেটিভ অ্যাপ্রোচে সেই একই কাজ করার জন্য আমাদেরকে কোডের ভেতরে ম্যানুয়ালি `Stack` অবজেক্ট বানাতে হয়।
</details>

---

**Q10. Can every single recursive function mathematically be rewritten as an iterative algorithm?**
A) No, only Tail Recursive functions can be rewritten iteratively
B) Yes, absolutely every recursive function can be rewritten iteratively (often by introducing a manual Stack)
C) Yes, but only in functional programming languages
D) No, Tree Recursions cannot be rewritten

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: চার্চ-টুরিং থিসিস (Church-Turing Thesis) অনুযায়ী, রিকার্সন দিয়ে যা করা সম্ভব, লুপ (এবং প্রয়োজনে কাস্টম স্ট্যাক) দিয়েও হুবহু তা-ই করা সম্ভব।
</details>

---

**Q11. Which algorithmic paradigm explicitly relies on recursively dividing a problem into smaller chunks?**
A) Greedy Algorithms
B) Divide and Conquer (e.g., Merge Sort)
C) Sliding Window
D) Two Pointers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Divide and Conquer এর মূল থিমই হলো প্রবলেমকে অর্ধেক করে ভাঙা (রিকার্সন), এবং ছোট প্রবলেম সলভ করে জোড়া লাগানো।
</details>

---

**Q12. What is the fundamental Time Complexity difference between calculating Fibonacci recursively via $F(n) = F(n-1) + F(n-2)$ versus iteratively using a loop?**
A) Recursion: $O(n)$, Iteration: $O(n^2)$
B) Recursion: $O(n \log n)$, Iteration: $O(n)$
C) Recursion: $O(2^n)$ (Exponential), Iteration: $O(n)$ (Linear)
D) Both are exactly $O(n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: সাধারণ রিকার্সনে ফিবোনাচির একই কাজ বারবার হয় বলে টাইম $O(2^n)$ হয়ে যায়। কিন্তু লুপে শুধু একবার ১ থেকে $n$ পর্যন্ত যাওয়া হয়, তাই টাইম $O(n)$ হয়।
</details>

---

**Q13. In highly memory-constrained environments (like embedded systems or microcontrollers), which approach is strictly preferred?**
A) Recursion
B) Iteration
C) Memoized Recursion
D) Tree Recursion

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এম্বেডেড সিস্টেমে RAM থাকে খুবই কম। রিকার্সন ব্যবহার করলে হঠাৎ করে Call Stack ফুল হয়ে ডিভাইস ক্র্যাশ করতে পারে। তাই সেখানে সবসময় লুপ (Iteration) ব্যবহার করা হয়।
</details>

---

**Q14. If you write a deeply recursive function in Java to process an array of $1,000,000$ elements linearly, what is the most likely outcome?**
A) It will execute incredibly fast
B) It will throw a `StackOverflowError` because the JVM limits the maximum call stack depth (default is often around 1MB)
C) It will throw an `OutOfMemoryError: Java heap space`
D) The JVM will automatically convert it to a loop

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: জাভাতে Thread Stack সাইজ ডিফল্টভাবে খুব ছোট থাকে। ১ মিলিয়ন রিকার্সন কল স্ট্যাকে জায়গা পাবে না, ফলে গ্যারান্টিড StackOverflow হবে।
</details>

---

**Q15. How can you increase the Call Stack memory limit in Java if you absolutely must run a deep recursion?**
A) By using the `-Xmx` JVM flag
B) By using the `-Xss` JVM flag
C) By importing `java.lang.Stack`
D) It cannot be increased

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `-Xmx` হলো Heap মেমোরি বাড়ানোর জন্য। আর `-Xss` (যেমন `java -Xss4m MyClass`) হলো প্রতিটি থ্রেডের Stack সাইজ বাড়ানোর জন্য। তবে এটি কম্পিটিটিভ প্রোগ্রামিংয়ে করা যায় না।
</details>

---

**Q16. What is the Space Complexity of reversing a Linked List iteratively versus recursively?**
A) Iterative: $O(N)$, Recursive: $O(N)$
B) Iterative: $O(1)$, Recursive: $O(1)$
C) Iterative: $O(1)$, Recursive: $O(N)$ (due to Call Stack)
D) Iterative: $O(N)$, Recursive: $O(1)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: লুপ দিয়ে রিভার্স করলে ৩টি পয়েন্টার (`prev`, `current`, `next`) লাগে, তাই স্পেস $O(1)$। রিকার্সনে প্রতিটি নোডের জন্য একটি স্ট্যাক ফ্রেম তৈরি হয়, তাই স্পেস $O(N)$।
</details>

---

**Q17. Which of the following is an advantage of Iteration over Recursion?**
A) It makes complex tree parsing algorithms much easier to write
B) It requires declaring fewer variables
C) It avoids the overhead of function calls, saving both CPU cycles and memory space
D) It automatically handles Backtracking

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: লুপে ফাংশন কলের কোনো ঝামেলা নেই, তাই এটি রিকার্সনের চেয়ে দ্রুত রান করে এবং মেমোরিও কম নেয়।
</details>

---

**Q18. Which of the following is an advantage of Recursion over Iteration?**
A) It is mathematically faster
B) It leads to concise, highly readable, and declarative code, especially for inherently hierarchical data structures
C) It completely eliminates the possibility of infinite loops
D) It requires zero memory space

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ট্রি, গ্রাফ বা যেকোনো জটিল হায়ারার্কিক্যাল প্রবলেমে রিকার্সনের কোড অনেক ছোট এবং মানুষের বোঝার জন্য সহজ (Readable) হয়।
</details>

---

**Q19. When writing Dynamic Programming solutions, how does the Memoization (Top-Down) approach primarily use recursion?**
A) It uses recursion to exhaustively search all paths without caching
B) It uses a loop inside a recursion
C) It uses recursion to traverse the state space naturally, but intercepts calls using a Cache (array/map) to prevent redundant overlapping computations
D) It strictly avoids recursion

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: মেমোইজেশন হলো রিকার্সন উইথ ব্রেন! সে রিকার্সনই ব্যবহার করে, কিন্তু কোনো কিছু ক্যালকুলেট করার আগে মেমোরিতে (Cache) চেক করে নেয় যে সেটা আগে করা হয়েছে কি না।
</details>

---

**Q20. When converting a recursive algorithm into a Tabulation (Bottom-Up) Dynamic Programming solution, what happens to the control flow?**
A) It remains recursive but uses a hash map
B) The recursion is completely removed and replaced by Iterative loops that fill up a DP table from the smallest base cases upward
C) It uses recursion but only visits the base cases
D) It relies on random numbers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Tabulation-এ রিকার্সনের কোনো অস্তিত্ব থাকে না। এখানে একটি বা দুটি লুপ চালিয়ে 1D বা 2D অ্যারে ফিল আপ করা হয়।
</details>

---

**Q21. [Interview Trick] If an interviewer asks you to traverse a Binary Tree in Level-Order (Breadth-First), which approach is strictly required?**
A) Recursion only
B) Iteration using a Queue
C) Recursion using a Hash Map
D) Backtracking

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সন (DFS) গভীরে যায়। লেভেল-অর্ডার (BFS) হলো লেভেল বাই লেভেল স্ক্যান করা। এর জন্য রিকার্সন কাজ করে না, ম্যানুয়ালি `Queue` ব্যবহার করে লুপ চালাতে হয়।
</details>

---

**Q22. What happens if a recursive function declares a very large local array (e.g., `int[] arr = new int[10000];`) inside the function body on every call?**
A) Nothing, Java automatically optimizes it
B) The arrays will be stored efficiently in the Call Stack
C) The Call Stack will exhaust extremely fast, or Heap Memory will fill up rapidly, leading to a much faster crash
D) The array is shared across all recursive calls

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: রিকার্সনের প্রতি কলে যদি আপনি বড় অ্যারে বা অবজেক্ট তৈরি করেন, তবে সেটি মেমোরি লিক বা খুব দ্রুত মেমোরি ফুল করে দেবে। এরকম ক্ষেত্রে অ্যারে গ্লোবালি ডিক্লেয়ার করা বা প্যারামিটার হিসেবে রেফারেন্স পাস করা উচিত।
</details>

---

**Q23. Is the standard Binary Search typically written using Recursion or Iteration in production code?**
A) Recursion, because it's impossible to write iteratively
B) Iteration, using a `while(left <= right)` loop, to save $O(\log N)$ stack space overhead, though recursion is also very easy to write
C) Recursion, because Iteration takes $O(N)$ space
D) Neither

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Binary Search রিকার্সন দিয়ে লেখাও খুব সহজ (3-4 লাইন)। কিন্তু প্রোডাকশনে লুপ ব্যবহার করা হয় যাতে কল-স্ট্যাকের $O(\log N)$ এক্সট্রা স্পেসটা বাঁচানো যায়।
</details>

---

**Q24. In the context of functional programming languages (like Haskell or Scala), how is the Iteration vs Recursion debate handled?**
A) They strictly use `for` loops
B) They heavily rely on Recursion (specifically Tail Recursion), and the compiler automatically optimizes it to run exactly like a loop under the hood
C) They do not support iteration or recursion
D) They only use `while` loops

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফাংশনাল প্রোগ্রামিং ল্যাঙ্গুয়েজগুলোতে ভেরিয়েবল চেঞ্জ (Mutation) করা যায় না, তাই লুপ কাজ করে না। সেখানে সবকিছু রিকার্সন দিয়ে করা হয় এবং কম্পাইলার নিজে থেকে সেটাকে অপ্টিমাইজ (TCO) করে নেয়।
</details>

---

**Q25. Which of the following is a classic problem where Iteration is almost universally preferred over Recursion due to simplicity and performance?**
A) Validating a Binary Search Tree
B) Printing permutations of a String
C) Reversing a purely numeric Array in-place (e.g., Two Pointers `left` and `right`)
D) Solving the N-Queens problem

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: অ্যারে রিভার্স করার জন্য Two Pointers দিয়ে একটি `while` লুপ চালানো সবচেয়ে সহজ এবং ফাস্ট। এর জন্য রিকার্সন লেখা বোকামি। (বাকি অপশনগুলো রিকার্সন/ব্যাকট্র্যাকিংয়ের ক্লাসিক প্রবলেম)।
</details>

---

**Q26. If you have a recursive function `void dfs(Node n)` and you want to convert it to an iterative version, what is the FIRST thing you should introduce into your code?**
A) A `Queue` data structure
B) A `Stack` data structure
C) A `String` builder
D) A global counter

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সন (DFS) মানেই স্ট্যাক। তাই একে ইটারেটিভে কনভার্ট করতে হলে প্রথমেই একটি `Stack` অবজেক্ট ডিক্লেয়ার করে রুট নোডটি তাতে পুশ করতে হবে।
</details>

---

**Q27. How does Iteration handle "Backtracking"?**
A) Automatically, just by exiting the loop
B) Very elegantly, without extra variables
C) Iteration cannot naturally backtrack; you must manually manage states, reverse changes, and pop elements from a custom Stack, making the code quite complex
D) It relies on OS-level interrupts

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: রিকার্সন যখন রিটার্ন করে, সে অটোমেটিক তার আগের স্টেটে (variables) ফিরে যায়। কিন্তু লুপে আগের স্টেটে ফিরে যেতে হলে আপনাকে ম্যানুয়ালি স্ট্যাক থেকে ডেটা বের করে হিসাব মেলাতে হয়, যা বেশ কঠিন।
</details>

---

**Q28. Why is debugging a heavily Recursive function sometimes considered harder than debugging an Iterative function?**
A) Because debuggers cannot step into recursive functions
B) Because the state is scattered across multiple stack frames, making it hard to track the exact sequence of events in your head or watch window
C) Because variables are hidden
D) It is actually much easier to debug recursion

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: লুপে একটি ভেরিয়েবল চেঞ্জ হয়, আপনি চোখ বুলিয়েই ধরতে পারেন। কিন্তু রিকার্সনে কোন কল স্ট্যাকের কোন লেভেলে কোন ভ্যালু আছে—সেটি ট্র্যাকিং করা (Dry run) বেশ মাথা ঘোরানো কাজ।
</details>

---

**Q29. What does the "Master Theorem" analyze?**
A) The time complexity of iterative `for` loops
B) The space complexity of Hash Maps
C) The time complexity of Divide and Conquer recursive algorithms (e.g., $T(n) = aT(n/b) + O(n^d)$)
D) The probability of a `StackOverflowError`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Master Theorem ব্যবহার করে Merge Sort, Binary Search এর মতো রিকার্সিভ ফাংশনগুলোর টাইম কমপ্লেক্সিটি খুব দ্রুত বের করা যায়।
</details>

---

**Q30. In Java, what happens to the variables declared inside a recursive function when it makes a recursive call?**
A) They are instantly destroyed
B) They are overwritten by the new call
C) They are paused and preserved safely in their specific Stack Frame until the recursive call returns and execution resumes
D) They are moved to the Heap

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: প্রতিটি রিকার্সিভ কলের লোকাল ভেরিয়েবলগুলো তার নিজস্ব স্ট্যাক ফ্রেমে সেফ থাকে। নতুন কলটি নতুন ভেরিয়েবল নিয়ে কাজ করে। যখন নতুন কলটি ব্যাক (Return) করে, পুরনো ভেরিয়েবলগুলো আবার জেগে ওঠে।
</details>

---

**Q31. [Code Logic] To calculate the sum of numbers from 1 to N, an Iterative approach uses a loop. A Recursive approach uses `sum(N) = N + sum(N-1)`. What is the math formula that does it in $O(1)$ Time and $O(1)$ Space?**
A) $N!$
B) $N \times (N-1) / 2$
C) $N \times (N+1) / 2$
D) $N^2$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: গৌস (Gauss) এর ফর্মুলা: $N \times (N+1)/2$ ব্যবহার করলে কোনো লুপ বা রিকার্সন ছাড়াই $O(1)$ টাইমে ১ থেকে $N$ এর যোগফল বের করা যায়। ইন্টারভিউতে এটি একটি দারুন অপ্টিমাইজেশন ট্রিক!
</details>

---

**Q32. Can recursion be applied to sorting an Array?**
A) Yes, algorithms like Quick Sort and Merge Sort rely on recursion
B) No, arrays can only be sorted iteratively
C) Yes, but only Bubble Sort can be recursive
D) No, recursion is strictly for Linked Lists

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Quick Sort এবং Merge Sort দুটোই রিকার্সন (Divide & Conquer) ব্যবহার করে অ্যারে সর্ট করে।
</details>

---

**Q33. What is the fundamental disadvantage of Iteration when dealing with problems like "Generating all Subsets" of an array?**
A) Iteration cannot generate subsets
B) Iteration requires managing complex index tracking and dynamic state arrays manually, whereas Recursion elegantly explores "Include" and "Exclude" branches naturally
C) Iteration causes StackOverflow
D) Iteration uses too much CPU Cache

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সাবসেট বা কম্বিনেশন জেনারেট করার লজিক (একটি নেবো, একটি নেবো না) রিকার্সন ট্রি দিয়ে খুব সুন্দরভাবে হ্যান্ডেল করা যায়। লুপ দিয়ে এটি করতে গেলে Bit Manipulation বা জটিল লজিক লাগে।
</details>

---

**Q34. [Interview Question] If a Graph is extremely deep (e.g., 100,000 nodes in a single straight line), which traversal method is safest to avoid crashing in standard Java?**
A) Recursive DFS
B) Iterative DFS (using a custom `Stack`) or BFS (using a `Queue`)
C) Both are equally safe
D) Neither will work

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু গ্রাফটি অনেক লম্বা, রিকার্সিভ DFS দিলে ১ লাখ ডেপথের কারণে StackOverflow হবে। তাই কাস্টম Stack (যা Heap মেমোরি ইউজ করে) দিয়ে ইটারেটিভ DFS বা Queue দিয়ে BFS করা সেফ।
</details>

---

**Q35. How is "Dynamic Programming Tabulation" related to Iteration?**
A) It is literally Iteration—using loops to fill an array/table iteratively from smaller subproblems to larger ones
B) It uses Recursion under the hood
C) It has no relation to Iteration
D) It relies on Hash Maps exclusively

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Tabulation মানেই হলো লুপ (Iteration) ব্যবহার করে Base case থেকে শুরু করে টেবিল বা অ্যারে ফিল আপ করা।
</details>

---

**Q36. Which approach is inherently better suited for "Parallel Processing" or Multi-threading?**
A) Iterative `while` loops with shared mutable counters
B) Functional/Recursive approaches with immutable states (since different branches of the recursion tree can often be processed on different CPU cores without lock contention)
C) They are equally suited
D) Neither can be parallelized

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সনে (বিশেষ করে Divide & Conquer এ) বাম পাশের ট্রি এবং ডান পাশের ট্রি একে অপরের ওপর নির্ভরশীল নয়। তাই এদেরকে সহজেই আলাদা থ্রেডে (Multi-core) রান করানো যায়।
</details>

---

**Q37. When designing a completely new algorithm for a complex problem, what is a common developer workflow?**
A) Write the optimized Iterative version first, then convert to Recursion
B) Write the Recursive version first because it's easier to reason about the logic, verify correctness, and then convert it to an Iterative or Memoized version if performance issues arise
C) Write it entirely in Assembly
D) Ignore recursion completely

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সন দিয়ে প্রবলেমের লজিক (Recurrence relation) দাঁড় করানো অনেক সহজ। কোড কাজ করলে পরে প্রয়োজন অনুযায়ী সেটিকে DP বা লুপ দিয়ে অপ্টিমাইজ করা হয়।
</details>

---

**Q38. What is the Space Complexity of an Iterative "Binary Search" algorithm?**
A) $O(N)$
B) $O(\log N)$
C) $O(1)$
D) $O(N \log N)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ইটারেটিভ Binary Search এ শুধু `left`, `right`, এবং `mid` ভেরিয়েবল লাগে। তাই স্পেস $O(1)$। (রিকার্সিভ হলে স্ট্যাকের কারণে $O(\log N)$ হতো)।
</details>

---

**Q39. What is the defining trait of "Mutual Recursion" (Indirect Recursion)?**
A) Function `A` calls itself twice
B) Function `A` calls Function `B`, and Function `B` calls Function `C`
C) Function `A` calls Function `B`, and Function `B` calls Function `A`
D) Function `A` contains a `while` loop

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: দুজন বন্ধু একে অপরকে কল করার মতো। `A` কল করে `B` কে, আর `B` আবার কল করে `A` কে। এটি অনেক সময় স্টেট মেশিন (State Machine) ডিজাইনে কাজে লাগে।
</details>

---

**Q40. [Conclusion] If your only goal is absolute maximum execution speed and minimal memory footprint, which should you choose?**
A) Recursion
B) Tail Recursion (in Java)
C) Iteration
D) Memoization

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: আল্টিমেট স্পিড এবং কম মেমোরি চাইলে লুপ (Iteration) এর কোনো বিকল্প নেই। গেম ডেভেলপমেন্ট বা লো-লেভেল সিস্টেমে একারণেই রিকার্সন এড়িয়ে লুপ ব্যবহার করা হয়।
</details>
