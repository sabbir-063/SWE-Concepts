# 05. Dynamic Programming Intro (Practice MCQs)

This file contains 40 in-depth MCQs covering the fundamentals of Dynamic Programming, Memoization vs Tabulation, space optimization, and identifying DP problems.

---

**Q1. What is the fundamental concept behind Dynamic Programming (DP)?**
A) Always making the locally optimal choice
B) Dividing a problem into non-overlapping subproblems
C) Solving each subproblem just once and storing its result to avoid redundant calculations
D) Exploring all possible paths using backtracking

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: DP এর মূল মন্ত্রই হলো "Remembering the past"। একই সাব-প্রবলেম (যেমন ফিবোনাচিতে $F(3)$) বারবার ক্যালকুলেট না করে একবার হিসাব করে সেভ করে রাখা হয়, যাতে পরে ডাইরেক্ট ইউজ করা যায়।
</details>

---

**Q2. Which two properties must a problem exhibit to be successfully solved using Dynamic Programming?**
A) Greedy Choice Property and Optimal Substructure
B) Overlapping Subproblems and Optimal Substructure
C) Overlapping Subproblems and Greedy Choice Property
D) Recursion and Iteration

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রবলেমটি ছোট ছোট সাব-প্রবলেমে ভাগ করা গেলে এবং সেই সাব-প্রবলেমগুলো বারবার রিপিট হলে (Overlapping Subproblems), এবং ছোট প্রবলেমের বেস্ট সলিউশন দিয়ে বড় প্রবলেমের বেস্ট সলিউশন (Optimal Substructure) তৈরি করা গেলেই DP কাজে লাগে।
</details>

---

**Q3. What is "Memoization" in the context of Dynamic Programming?**
A) An iterative, bottom-up approach using loops
B) A top-down recursive approach where results of subproblems are cached in an array or map
C) A technique to reduce space complexity to $O(1)$
D) A method to sort data before processing

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Memoization (Top-Down) মানে হলো নরমাল রিকার্সন লেখার পর জাস্ট একটা মেমোরি (Array/Map) অ্যাড করে দেওয়া। ক্যালকুলেশনের আগে চেক করা হয় যে রেজাল্ট মেমোরিতে আছে কি না।
</details>

---

**Q4. What is "Tabulation" in the context of Dynamic Programming?**
A) An iterative, bottom-up approach that builds the solution starting from the smallest base cases
B) A top-down recursive approach
C) Using a Hash Map to store string frequencies
D) A technique exclusively used for Matrix Chain Multiplication

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Tabulation (Bottom-Up) এ কোনো রিকার্সন থাকে না। একটি লুপ চালিয়ে বেস কেস (যেমন $dp[0], dp[1]$) থেকে শুরু করে আস্তে আস্তে টার্গেটের দিকে (যেমন $dp[n]$) টেবিল ফিলাপ করা হয়।
</details>

---

**Q5. In terms of function call overhead, which DP approach is generally slightly faster in practice?**
A) Memoization (Top-Down)
B) Tabulation (Bottom-Up)
C) Both are exactly the same
D) Recursion without caching

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Tabulation এ লুপ ব্যবহার করা হয়। আর Memoization এ রিকার্সিভ ফাংশন কল করা হয়। ফাংশন কলের একটা এক্সট্রা মেমোরি ও টাইম ওভারহেড থাকে, তাই লুপ (Tabulation) সামান্য ফাস্ট হয়।
</details>

---

**Q6. Which DP approach is vulnerable to a `StackOverflowError` if the input size is extremely large?**
A) Memoization (Top-Down)
B) Tabulation (Bottom-Up)
C) Space-Optimized DP
D) None of the above

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: যেহেতু Memoization রিকার্সন ব্যবহার করে, তাই $N$ এর ভ্যালু অনেক বড় হলে (যেমন $N = 100,000$) কল-স্ট্যাক লিমিট ক্রস করে StackOverflow হতে পারে।
</details>

---

**Q7. What is the time complexity of a naive (pure recursive) implementation of the Fibonacci sequence without DP?**
A) $O(n)$
B) $O(n \log n)$
C) $O(n^2)$
D) $O(2^n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: নরমাল রিকার্সনে ফিবোনাচির ট্রি প্রতি স্টেপে ২ ভাগ হয়ে এক্সপোনেনশিয়ালি বাড়তে থাকে। তাই কমপ্লেক্সিটি হয় $O(2^n)$, যা খুবই স্লো।
</details>

---

**Q8. What is the time complexity of the Fibonacci sequence when optimized using DP (either Memoization or Tabulation)?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: DP ব্যবহার করলে আমরা প্রতিটি স্টেট (১ থেকে $n$) মাত্র একবার ক্যালকুলেট করি এবং সেভ করে রাখি। তাই টাইম ড্রাস্টিক্যালি কমে $O(n)$ হয়ে যায়।
</details>

---

**Q9. Is it possible to optimize the space complexity of the Tabulation approach for the Fibonacci sequence to $O(1)$?**
A) Yes, by only keeping track of the last two computed values
B) No, an array of size $N$ is always strictly required
C) Yes, by using a Hash Map
D) Yes, by replacing the loop with recursion

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: ফিবোনাচিতে $F(n)$ বের করতে শুধু $F(n-1)$ এবং $F(n-2)$ দরকার হয়। পুরো $N$ সাইজের অ্যারে না নিয়ে শুধু দুটি ভেরিয়েবল (`prev1`, `prev2`) আপডেট করে কাজ চালানো যায়, ফলে স্পেস $O(1)$ হয়ে যায়।
</details>

---

**Q10. How does Dynamic Programming differ fundamentally from the Divide and Conquer strategy?**
A) Divide and Conquer uses recursion, whereas DP does not
B) Divide and Conquer subproblems are independent and non-overlapping, whereas DP subproblems heavily overlap
C) DP is always slower than Divide and Conquer
D) DP cannot solve optimization problems

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Merge Sort বা Quick Sort (Divide & Conquer) এ অ্যারে ২ ভাগ হয়, যেখানে এক ভাগের ডেটার সাথে অন্য ভাগের কোনো মিল থাকে না (Non-overlapping)। কিন্তু DP তে সাব-প্রবলেমগুলো কমন বা ওভারল্যাপিং থাকে।
</details>

---

**Q11. How does Dynamic Programming differ from the Greedy Algorithm?**
A) Greedy makes a localized optimal choice without looking back, while DP exhaustively considers all possible subproblems to find the global optimum
B) DP is always faster than Greedy
C) DP only works on graphs
D) Greedy guarantees a correct optimal answer for every problem, DP does not

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Greedy হলো শর্টকাট। এটি বর্তমানের সেরা অপশনটি নেয়। কিন্তু DP শর্টকাট নেয় না, সে সব পসিবল অপশন (যেমন আইটেমটি নিলে কী হবে, না নিলে কী হবে) চেক করে তারপর বেস্টটা রিটার্ন করে।
</details>

---

**Q12. If a problem asks you to find the "Total number of ways" to reach a target, which algorithmic paradigm is usually the most appropriate?**
A) Greedy Algorithm
B) Dynamic Programming
C) Binary Search
D) Two Pointers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: "Total Ways" বা "ম্যাক্সিমাম/মিনিমাম কস্ট" বের করতে বললে সেটি সাধারণত DP এর প্রবলেম হয়। কারণ এখানে সব কম্বিনেশন চেক করে যোগ করতে হয়।
</details>

---

**Q13. In the context of DP, what does the term "State" refer to?**
A) A variable that remains constant throughout the execution
B) A specific set of parameters that uniquely identifies a subproblem (e.g., current index and remaining capacity)
C) The final answer of the problem
D) The time complexity of the algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: State হলো রিকার্সন ফাংশনের সেই প্যারামিটারগুলো যেগুলো কল টু কলে চেঞ্জ হয়। যেমন Knapsack প্রবলেমে `(index, capacity)` হলো একটি স্টেট।
</details>

---

**Q14. What does "State Transition" or "Recurrence Relation" mean in DP?**
A) The conversion of recursive code into iterative code
B) The mathematical equation or logic that defines how to compute the answer for the current state using the answers of smaller states
C) The transition from a Greedy logic to DP logic
D) The memory allocation process

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেমন ফিবোনাচির ক্ষেত্রে $F(n) = F(n-1) + F(n-2)$ হলো এর State Transition বা Recurrence Relation। এটি ছাড়া DP কোড লেখা অসম্ভব।
</details>

---

**Q15. Why might the Memoization (Top-Down) approach sometimes be preferred over Tabulation (Bottom-Up) even though Tabulation avoids recursion overhead?**
A) Because Memoization is always mathematically faster
B) Because Memoization only computes the states that are strictly necessary (on-demand), while Tabulation computes every single state from the base case up
C) Because Tabulation takes $O(n^2)$ space
D) Memoization is never preferred over Tabulation

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Tabulation লুপ চালিয়ে সব সাব-প্রবলেম হিসাব করে। কিন্তু কিছু প্রবলেমে সব স্টেট দরকার নাও হতে পারে। Memoization যেহেতু রিকার্সিভলি কল হয়, তাই শুধু দরকারি স্টেটগুলোই (On-demand) সে ক্যালকুলেট করে।
</details>

---

**Q16. The "Climbing Stairs" problem (finding total ways to reach step N by taking 1 or 2 steps at a time) is mathematically identical to which famous sequence?**
A) Catalan Numbers
B) Fibonacci Sequence
C) Arithmetic Progression
D) Geometric Progression

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: $n$ তলায় যাওয়ার উপায় = $(n-1)$ তলায় যাওয়ার উপায় + $(n-2)$ তলায় যাওয়ার উপায়। এটি হুবহু ফিবোনাচির লজিক: $DP[n] = DP[n-1] + DP[n-2]$।
</details>

---

**Q17. In a standard 1D DP array of size $N$, what is typically stored at `dp[i]`?**
A) The optimal answer for the input of size $i$
B) The time taken to compute step $i$
C) A boolean flag indicating if index $i$ is visited
D) A pointer to the next state

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: `dp[i]` সাধারণত রিপ্রেজেন্ট করে "সাইজ $i$ এর জন্য বেস্ট রেজাল্ট"। যেমন `dp[5]` মানে হলো ৫ সাইজের প্রবলেমের অপ্টিমাল অ্যান্সার।
</details>

---

**Q18. What is the standard initialization value for a DP memoization array before starting the recursion?**
A) 0
B) -1 (or any value that cannot be a valid answer)
C) 1
D) Infinity

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Memo অ্যারেটি এমন একটি ভ্যালু দিয়ে (সাধারণত -1) ফিল করতে হয়, যা কখনো লিগ্যাল রেজাল্ট হতে পারবে না। এতে করে আমরা `if (memo[i] != -1)` চেক করে বুঝতে পারি যে এটি আগে ক্যালকুলেট হয়েছে কি না।
</details>

---

**Q19. The "0/1 Knapsack Problem" is a classic example of which algorithmic paradigm?**
A) Greedy Algorithm
B) Dynamic Programming
C) Divide and Conquer
D) Two Pointers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 0/1 Knapsack এ আইটেম ভাঙা যায় না। তাই এটি Greedy দিয়ে সলভ করা যায় না। এর জন্য 2D DP (ডায়নামিক প্রোগ্রামিং) লাগে, যেখানে প্রতিটি আইটেম নেওয়ার বা না নেওয়ার (Include/Exclude) দুটি অপশনই চেক করা হয়।
</details>

---

**Q20. In a 2D DP table for the 0/1 Knapsack problem, what do the two dimensions (Rows and Columns) typically represent?**
A) Row: Profit, Column: Weight
B) Row: Current Item Index, Column: Current Remaining Capacity
C) Row: Total Items, Column: Total Profit
D) Row: Index, Column: Index

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 0/1 Knapsack এর রিকার্সন স্টেট হলো: কোন আইটেমটি চেক করছি (Index) এবং ব্যাগে আর কতটুকু জায়গা বাকি আছে (Capacity)। তাই 2D টেবিলের `dp[i][w]` এই দুটি জিনিসই রিপ্রেজেন্ট করে।
</details>

---

**Q21. The "Longest Common Subsequence (LCS)" problem between two strings of lengths $M$ and $N$ can be solved using DP. What is the time complexity of the standard DP approach?**
A) $O(M+N)$
B) $O(M \times N)$
C) $O(M \log N)$
D) $O(2^{\min(M,N)})$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: LCS সলভ করতে একটি 2D DP টেবিল লাগে যার সাইজ $M \times N$। লুপটি এই টেবিলের প্রতিটি সেল ফিল আপ করে, তাই টাইম কমপ্লেক্সিটি $O(M \times N)$।
</details>

---

**Q22. In the "Coin Change" problem (finding the minimum number of coins to make an amount), if the coin denominations are not canonical (e.g., {1, 3, 4}), why do we use DP instead of Greedy?**
A) Greedy is too slow
B) Greedy might not yield the minimum number of coins
C) DP uses less memory
D) DP is easier to write

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 1, 3, 4 সিস্টেমে 6 বানাতে দিলে Greedy নেবে 4, 1, 1 (৩টি)। কিন্তু বেস্ট হলো 3, 3 (২টি)। Greedy বেস্ট রেজাল্ট দিতে পারে না বলেই DP দিয়ে সব পসিবল কম্বিনেশন চেক করে মিনিমামটা নিতে হয়।
</details>

---

**Q23. When writing a Memoization (Top-Down) solution in Java, what is generally preferred for the memoization structure if the state parameters are large or sparse (e.g., large strings or discontinuous large integers)?**
A) A deeply nested Multi-dimensional Array
B) A `HashMap<String, Integer>` (using a concatenated string key)
C) A standard Array initialized with `Integer.MAX_VALUE`
D) It is impossible to memoize such states

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যদি ইনডেক্স অনেক বড় হয় (যেমন $10^9$) বা স্টেট হিসেবে স্ট্রিং থাকে, তখন Array ডিক্লেয়ার করা যায় না (Memory Limit Exceed)। এক্ষেত্রে `HashMap` বেস্ট অপশন, যেখানে কাস্টম কি (Key) জেনারেট করে রেজাল্ট স্টোর করা হয়।
</details>

---

**Q24. In DP, what is a "Base Case"?**
A) The final answer of the algorithm
B) The condition where the recursion naturally terminates and returns a known constant value
C) The largest possible subproblem
D) The starting point of an iterative loop

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Base case হলো রিকার্সনের থ্রেশহোল্ড। যেমন ফিবোনাচিতে `n <= 1` হলে `n` রিটার্ন করে। এটি ছাড়া রিকার্সন ইনফিনিট লুপে পড়ে যাবে।
</details>

---

**Q25. What happens if you forget to add the caching step (`memo[n] = result`) in a Top-Down DP approach?**
A) The program throws a Syntax Error
B) The Time Complexity reverts to the exponential naive recursion time (e.g., $O(2^n)$)
C) The Space Complexity becomes $O(1)$
D) The answer becomes logically incorrect

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: মেমোরিতে সেভ না করলে এটি আর DP থাকে না, সাধারণ স্লো রিকার্সনে পরিণত হয়। ফলে ওভারল্যাপিং প্রবলেমগুলো বারবার ক্যালকুলেট হয়ে Time Limit Exceeded (TLE) খাবে।
</details>

---

**Q26. [Interview Trick] Which DP approach is generally easier to trace back (reconstruct the actual path/items chosen, not just the final max value)?**
A) Memoization
B) Tabulation
C) Neither can reconstruct paths
D) They are equally easy

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Tabulation এ যেহেতু পুরো 2D বা 1D টেবিল আমাদের সামনে লুপের মাধ্যমে ফিল হয়, তাই টেবিলের শেষ থেকে শুরু করে কন্ডিশন চেক করতে করতে রিভার্স ইঞ্জিনিয়ারিং করে সহজেই পাথ (Path) বা আইটেম লিস্ট বের করা যায়।
</details>

---

**Q27. The "Matrix Chain Multiplication" problem is an example of which specific DP pattern?**
A) 1D DP
B) Knapsack Pattern
C) Interval DP / Partition DP
D) LCS Pattern

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Matrix Chain বা Palindrome Partitioning এ একটি বড় রেঞ্জকে (i থেকে j) বিভিন্ন পয়েন্টে (k) ভেঙে ভেঙে চেক করতে হয়। একে Interval DP বা Partition DP বলে।
</details>

---

**Q28. In a 2D Grid DP problem (e.g., "Unique Paths" from top-left to bottom-right), the number of ways to reach cell `(i, j)` is typically the sum of the ways to reach which two cells?**
A) `(i-1, j)` and `(i, j-1)`
B) `(i+1, j)` and `(i, j+1)`
C) `(i-1, j-1)` and `(i+1, j+1)`
D) The entire previous row

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: আপনি শুধুমাত্র ওপর থেকে (i-1) অথবা বাম দিক থেকে (j-1) কারেন্ট সেলে আসতে পারেন। তাই এই দুই সেলে আসার টোটাল ওয়ে (Ways) যোগ করলেই কারেন্ট সেলের অ্যান্সার পাওয়া যায়: `dp[i][j] = dp[i-1][j] + dp[i][j-1]`।
</details>

---

**Q29. What is the purpose of the "Space Optimization" technique in DP?**
A) To reduce the time complexity from $O(N^2)$ to $O(N)$
B) To reduce the memory usage (e.g., from an $O(N)$ array to $O(1)$ variables) when only the last few computed states are needed
C) To eliminate the need for base cases
D) To convert a Greedy problem into DP

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: লুপ চালানোর সময় যদি দেখা যায় কারেন্ট স্টেট বের করতে শুধু আগের ১টি বা ২টি স্টেট দরকার, তখন পুরো অ্যারে না নিয়ে শুধু ২-৩টি ভেরিয়েবল দিয়েই মেমোরি কমানো যায়। এটি স্পেস অপ্টিমাইজেশনের মূল কনসেপ্ট।
</details>

---

**Q30. In 0/1 Knapsack, the 2D DP array space complexity is $O(N \times W)$. Can this space be optimized?**
A) No, it strictly requires a 2D array
B) Yes, it can be optimized to a 1D array of size $W$, resulting in $O(W)$ space
C) Yes, it can be optimized to $O(1)$ space
D) Yes, by sorting the items first

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 0/1 Knapsack এ কারেন্ট রোর (Row i) ভ্যালু বের করতে শুধু আগের রোর (Row i-1) ভ্যালু দরকার হয়। তাই পুরো 2D ম্যাট্রিক্স না নিয়ে, সাইজ $W$ এর একটি 1D অ্যারে (যা ডান থেকে বামে আপডেট হয়) দিয়েই স্পেস অপ্টিমাইজ করা যায়।
</details>

---

**Q31. Which of the following problems does NOT exhibit "Overlapping Subproblems"?**
A) Finding the $N$-th Fibonacci number
B) Merge Sort
C) Longest Common Subsequence
D) Coin Change

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Merge Sort (Divide & Conquer) এ অ্যারে ভাগ হয়ে যায় এবং বাম দিকের অংশের সাথে ডান দিকের অংশের কোনো কমন কাজ বা ওভারল্যাপ থাকে না। তাই এটি DP নয়।
</details>

---

**Q32. "Edit Distance" (finding minimum operations to convert word1 to word2) is solved using which DP table initialization?**
A) All zeros
B) First row and first column initialized to represent the length of prefixes (i.e., inserting/deleting against an empty string)
C) All infinities
D) All negative ones

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Edit Distance এ বেস কেস হলো একটি স্ট্রিং এম্পটি (Empty) হলে অন্য স্ট্রিংয়ের সাইজ অনুযায়ী অপারেশন (Insert/Delete) লাগবে। তাই 2D টেবিলের প্রথম রো `0, 1, 2...` এবং প্রথম কলাম `0, 1, 2...` দিয়ে ইনিশিয়ালাইজ করতে হয়।
</details>

---

**Q33. What is the fundamental logic of the "Longest Increasing Subsequence (LIS)" DP solution in $O(N^2)$ time?**
A) Compare every element with all its subsequent elements
B) For each element `i`, check all previous elements `j`. If `arr[j] < arr[i]`, then `dp[i] = max(dp[i], dp[j] + 1)`
C) Sort the array first, then remove duplicates
D) Use a Greedy approach to always pick the next immediate larger element

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: LIS এ আমরা প্রতিটি ইলিমেন্টের জন্য তার আগের সব ছোট ইলিমেন্ট চেক করি এবং তাদের মধ্যে যার সাবসিকুয়েন্স সবচেয়ে বড়, তার সাথে ১ যোগ করে কারেন্ট সাবসিকুয়েন্স আপডেট করি।
</details>

---

**Q34. [Code Logic] If a recursive function `solve(index, sum)` is called frequently, and `index` goes from 0 to N, while `sum` goes from 0 to S, what should be the dimensions of the DP memoization table?**
A) `dp[N]`
B) `dp[S]`
C) `dp[N+1][S+1]`
D) `dp[N*S]`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: রিকার্সনে যে যে প্যারামিটার চেঞ্জ হয় (State), সেগুলোর ম্যাক্সিমাম সাইজ নিয়ে DP টেবিল বানাতে হয়। এখানে ইনডেক্স এবং সাম দুটোই চেঞ্জ হচ্ছে, তাই এটি একটি 2D DP যার সাইজ হবে `(N+1) x (S+1)`।
</details>

---

**Q35. "Kadane's Algorithm" for finding the Maximum Subarray Sum is an optimized DP approach. What is its Space Complexity?**
A) $O(N^2)$
B) $O(N)$
C) $O(\log N)$
D) $O(1)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: Kadane's এ আমরা পুরো অ্যারে সেভ করি না, শুধু কারেন্ট সাম এবং ম্যাক্সিমাম সাম দুটি ভেরিয়েবলে আপডেট করতে থাকি। তাই স্পেস $O(1)$।
</details>

---

**Q36. In DP, when you are asked to "Maximize" a value, what should the base cases usually return when they hit an invalid or out-of-bounds state?**
A) `0`
B) `Integer.MAX_VALUE` (Infinity)
C) `Integer.MIN_VALUE` (Negative Infinity)
D) `1`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ম্যাক্সিমাম চাইলে ইনভ্যালিড স্টেটে একটি অনেক ছোট নেগেটিভ ভ্যালু রিটার্ন করতে হয়, যাতে `Math.max()` ফাংশন ভুল করে ওই পাথকে পিক না করে।
</details>

---

**Q37. Conversely, in DP, when asked to "Minimize" a value (like Coin Change), what should the base cases return for an invalid state?**
A) `0`
B) `Integer.MAX_VALUE` (Infinity or a very large number)
C) `Integer.MIN_VALUE`
D) `-1`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: মিনিমাম চাইলে ইনভ্যালিড স্টেটে একটি অনেক বড় ভ্যালু (যেমন Infinity) রিটার্ন করতে হয়, যাতে `Math.min()` ফাংশন সেই ফালতু পাথটাকে ইগনোর করে।
</details>

---

**Q38. "Subset Sum" (checking if any subset adds up to a given sum) returns a Boolean value. What is the suitable datatype for its Memoization table?**
A) `boolean[][]`
B) `Boolean[][]` (Object type to allow null for unvisited states) or `int[][]` (-1, 0, 1)
C) `String[][]`
D) `double[][]`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রিমিটিভ `boolean` ডিফল্টভাবে `false` থাকে, তাই বোঝা যায় না এটা আনভিজিটেড নাকি আসলেই রেজাল্ট `false`। এজন্য `Boolean` অবজেক্ট (null মানে আনভিজিটেড) অথবা `int` (-1 মানে আনভিজিটেড, 1 মানে True, 0 মানে False) ব্যবহার করা সেফ।
</details>

---

**Q39. Can dynamic programming be applied to Graph algorithms?**
A) No, graph algorithms are distinct
B) Yes, for example, the Bellman-Ford algorithm and Floyd-Warshall algorithm are heavily based on DP principles
C) Yes, but only for directed acyclic graphs (DAG)
D) Yes, but only for unweighted graphs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Bellman-Ford এবং Floyd-Warshall দুটোই সব পসিবল নোড বা পাথের ওপর ইটারেট করে ধীরে ধীরে অপ্টিমাল ডিস্টেন্স আপডেট করে, যা সম্পূর্ণ DP লজিক।
</details>

---

**Q40. [Conclusion] If you can easily express a problem using Recursion, what is usually the next most natural step to optimize it into a DP solution?**
A) Rewrite the entire logic using iterative loops
B) Add a memoization array/map to cache the recursive results
C) Apply a Greedy heuristic
D) Change the data structure to a Priority Queue

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সন লিখে ফেলতে পারাই হলো DP এর সবচেয়ে কঠিন পার্ট। রিকার্সন রেডি থাকলে জাস্ট ৩ লাইন কোড অ্যাড করে মেমোরি (Memoization) বসিয়ে দিলেই সেটি ফুল্লি অপ্টিমাইজড DP সলিউশন হয়ে যায়!
</details>
