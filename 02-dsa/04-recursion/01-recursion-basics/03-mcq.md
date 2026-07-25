# 01. Recursion Basics (Practice MCQs)

This file contains 40 in-depth MCQs covering the core concepts of Recursion, Call Stack, Base Case, Tail vs Head Recursion, and common pitfalls like StackOverflowError.

---

**Q1. What is the standard definition of Recursion in programming?**
A) A process where a loop executes indefinitely
B) A process where a function calls itself directly or indirectly
C) A process of finding the factorial of a number
D) A process of dynamically allocating memory

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সন হলো এমন একটি মেকানিজম যেখানে একটি ফাংশন নিজের কাজ সম্পন্ন করার জন্য নিজেরই একটি ছোট ভার্সনকে কল করে।
</details>

---

**Q2. Which two essential components must be present in every properly designed recursive function?**
A) A loop and a return statement
B) A Base Case and a Recursive Case
C) A Stack and a Queue
D) Tail Recursion and Head Recursion

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Base Case রিকার্সনকে থামায়, আর Recursive Case প্রবলেমের সাইজ ছোট করে নিজেকে কল করে। এই দুটি ছাড়া রিকার্সন হয় না।
</details>

---

**Q3. What is the primary purpose of a "Base Case" in a recursive function?**
A) To initiate the very first recursive call
B) To calculate the time complexity of the function
C) To terminate the recursion and prevent an infinite loop
D) To optimize memory usage automatically

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Base Case হলো থামার শর্ত। এটি না থাকলে ফাংশন অনন্তকাল নিজেকে কল করতে থাকবে।
</details>

---

**Q4. What happens when a recursive function lacks a Base Case or fails to reach it?**
A) The program simply returns 0
B) The compiler throws a syntax error during compilation
C) The program executes normally but gives a wrong output
D) The program crashes with a `StackOverflowError` at runtime

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: Base Case না থাকলে ফাংশন কল হতেই থাকে এবং Call Stack মেমোরি ফুল হয়ে যায়, যার ফলে `StackOverflowError` ঘটে।
</details>

---

**Q5. Which underlying Data Structure is utilized by the operating system/compiler to manage recursive function calls?**
A) Queue
B) Stack (Call Stack)
C) Linked List
D) Hash Table

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফাংশন কলগুলো LIFO (Last In First Out) ফলো করে। সবার শেষে কল হওয়া ফাংশনটি সবার আগে শেষ হয়। তাই এটি Stack মেমোরিতে স্টোর হয়।
</details>

---

**Q6. What does the term "Depth of Recursion" or "Recursion Tree Depth" refer to?**
A) The total number of variables declared inside the function
B) The total time taken to execute the function
C) The maximum number of active recursive calls present in the Call Stack at any given time
D) The number of loops inside the recursive function

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: রিকার্সন ট্রি যতো লম্বা হবে (গভীরতা), স্ট্যাকে ততোগুলো ফাংশন একই সাথে জমা থাকবে। এটিকেই Depth বলে, যা সরাসরি Space Complexity এর সমান।
</details>

---

**Q7. What exactly is "Tail Recursion"?**
A) When a function calls itself at the very beginning of its execution
B) When a function has two or more base cases
C) When the recursive call is the absolute last operation performed in the function, with no computation left after it returns
D) When a function returns a string value

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: রিকার্সন থেকে ফেরার পর যদি আর কোনো যোগ-বিয়োগের কাজ বাকি না থাকে (যেমন `return fact(n-1);`), তখন তাকে Tail Recursion বলে।
</details>

---

**Q8. Why is Tail Recursion considered highly optimized in modern compilers (like C++ or Scala)?**
A) It uses a Queue instead of a Stack
B) The compiler converts it into an iterative loop, preventing the creation of new stack frames and reducing Space Complexity to $O(1)$
C) It automatically runs in $O(1)$ Time Complexity
D) It prevents division by zero errors

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু রিকার্সন কলের পর কারেন্ট ফাংশনের আর কোনো কাজ বাকি থাকে না, তাই কম্পাইলার কারেন্ট স্ট্যাক ফ্রেমটাকে ডেস্ট্রয় না করে রিইউজ (Reuse) করে বা `while` লুপে কনভার্ট করে দেয়।
</details>

---

**Q9. Does Java (JVM) inherently optimize Tail Recursion automatically?**
A) Yes, always
B) Yes, but only in Java 8 and above
C) No, Java does not support automatic Tail Call Optimization (TCO) at the JVM level due to security and stack-trace preservation reasons
D) Only if the `@TailRec` annotation is used

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: জাভা বাই ডিফল্ট Tail Recursion অপ্টিমাইজ করে না, কারণ এতে Exception ঘটলে Stack-trace এ সঠিক লাইন নাম্বার পাওয়া যায় না।
</details>

---

**Q10. What is "Head Recursion"?**
A) When the recursive call is made at the very beginning of the function, before any other processing or printing
B) When the base case is placed at the end of the function
C) When the function returns the head of a Linked List
D) When a function calls multiple different functions

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Head Recursion এ আগে ফাংশন গভীরে যায়, তারপর ফেরার পথে (Backtracking) বাকি কাজ বা প্রিন্টিং সম্পন্ন করে।
</details>

---

**Q11. What is the difference between Direct Recursion and Indirect Recursion?**
A) Direct uses loops; Indirect uses functions
B) Direct is when Function A calls Function A; Indirect is when Function A calls Function B, which in turn calls Function A
C) Direct is faster than Indirect
D) Indirect recursion does not use a Call Stack

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সরাসরি নিজেকে কল করলে Direct। আর ঘুরেফিরে অন্য কোনো ফাংশনের মাধ্যমে কল হলে Indirect Recursion।
</details>

---

**Q12. In terms of Space Complexity, how does a standard recursive function compare to its equivalent iterative (loop) version?**
A) Recursion generally takes less space
B) They take the exact same space
C) Recursion takes more space ($O(N)$ vs $O(1)$) due to the overhead of maintaining multiple frames in the Call Stack
D) Recursion takes $O(N^2)$ space

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: লুপে একটি ভেরিয়েবলই বারবার আপডেট হয় (Space $O(1)$)। কিন্তু রিকার্সনে প্রতি কলের জন্য স্ট্যাকে নতুন করে মেমোরি বরাদ্দ হয়।
</details>

---

**Q13. Which of the following problems is generally NOT recommended to be solved using raw, unoptimized recursion due to exponential Time Complexity?**
A) Finding the factorial of N
B) Searching in a Binary Search Tree (BST)
C) Calculating the N-th Fibonacci number using $F(n) = F(n-1) + F(n-2)$
D) Reversing a Linked List

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ফিবোনাচিতে একই সাব-প্রবলেম বারবার কল হয় (Overlapping subproblems), ফলে টাইম কমপ্লেক্সিটি $O(2^n)$ হয়ে যায়। এটি সলভ করতে Dynamic Programming লাগে।
</details>

---

**Q14. Consider this recursive function: `void fun(int n) { if(n>0) { fun(n-1); System.out.print(n); } }`. If you call `fun(3)`, what will be printed?**
A) 321
B) 123
C) 3
D) 0

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি Head Recursion। আগে `fun(0)` পর্যন্ত যাবে, তারপর ফেরার পথে প্রথমে 1, তারপর 2, তারপর 3 প্রিন্ট করবে।
</details>

---

**Q15. Consider this recursive function: `void fun(int n) { if(n>0) { System.out.print(n); fun(n-1); } }`. If you call `fun(3)`, what will be printed?**
A) 321
B) 123
C) 3
D) 0

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: এটি Tail Recursion। ফাংশন নিজে ঢোকার সাথে সাথেই ভ্যালু প্রিন্ট করে দেয়। তাই 3, তারপর 2, তারপর 1 প্রিন্ট হবে।
</details>

---

**Q16. What is the fundamental concept of "Tree Recursion"?**
A) Recursion applied only on Tree data structures
B) A function that makes only one recursive call to itself
C) A function that makes two or more recursive calls to itself within a single execution
D) A function that visualizes its output as a tree

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেমন `fib(n) = fib(n-1) + fib(n-2)`। এখানে একটি ফাংশন নিজের ভেতরে দুটি কল করছে, ফলে এক্সিকিউশন ফ্লো একটি গাছের ডালপালার মতো (Tree) ছড়াতে থাকে।
</details>

---

**Q17. Which prominent sorting algorithm strictly utilizes the Divide and Conquer recursive paradigm?**
A) Bubble Sort
B) Insertion Sort
C) Merge Sort
D) Selection Sort

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Merge Sort প্রথমে অ্যারেকে রিকার্সিভলি অর্ধেক করে করে একদম ১ সাইজে নিয়ে যায় (Divide), তারপর ফেরার পথে তাদের মার্জ (Conquer) করে।
</details>

---

**Q18. "Backtracking" (e.g., solving a Sudoku or N-Queens puzzle) is heavily reliant on which programming concept?**
A) Hashing
B) Greedy Algorithm
C) Recursion
D) Binary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Backtracking মানে হলো একটি রাস্তায় যাওয়া, ভুল বুঝলে পিছে ফিরে আসা। রিকার্সনের Call Stack অটোমেটিকভাবে এই পিছে ফেরার (Return) কাজটা সুন্দরভাবে হ্যান্ডেল করে।
</details>

---

**Q19. [Code Logic] What does the following recursive function return for `f(5)`?
`int f(int n) { if (n == 0) return 0; return n + f(n - 1); }`**
A) 5
B) 10
C) 15
D) 120

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: এটি ১ থেকে ৫ পর্যন্ত সংখ্যার যোগফল বের করছে। $5 + 4 + 3 + 2 + 1 + 0 = 15$।
</details>

---

**Q20. [Code Logic] What does the following recursive function return for `foo(345)`?
`int foo(int n) { if (n == 0) return 0; return (n % 10) + foo(n / 10); }`**
A) 345
B) 543
C) 12
D) 3

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: এটি একটি নাম্বারের ডিজিটগুলোর যোগফল (Sum of digits) বের করছে। $3 + 4 + 5 = 12$।
</details>

---

**Q21. Can every recursive function theoretically be rewritten as an iterative function (using loops)?**
A) No, some complex recursions cannot be converted
B) Yes, every recursive function can be rewritten iteratively, often by explicitly using a manual Stack data structure
C) Only Tail Recursion can be rewritten iteratively
D) Only Tree Recursion can be rewritten iteratively

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সন যা করে, তা হলো OS এর Call Stack ব্যবহার করে। আমরা চাইলে ম্যানুয়ালি `Stack` অবজেক্ট বানিয়ে `while` লুপের মাধ্যমে যেকোনো রিকার্সনকে ইটারেটিভে কনভার্ট করতে পারি।
</details>

---

**Q22. When traversing a Graph or Tree using Depth-First Search (DFS), what is the most common and concise way to implement it?**
A) Using a Queue
B) Using Recursion
C) Using a Hash Map
D) Using multiple nested `for` loops

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: DFS এর নেচারই হলো গভীরে যাওয়া এবং ডেড-এন্ড থেকে ফিরে আসা। রিকার্সন নিজে থেকেই এই কাজটা করে দেয়, তাই DFS রিকার্সন দিয়ে লেখা সবচেয়ে সহজ।
</details>

---

**Q23. What happens if a recursive function modifies a global or static variable during its execution?**
A) The variable's state resets to its initial value after every recursive return
B) The changes persist across all recursive calls and returns
C) It throws a Compilation Error
D) A separate copy of the variable is created for each call

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Global বা Static ভেরিয়েবল Call Stack এর অংশ নয়, এরা Heap/Data সেগমেন্টে থাকে। তাই যেকোনো রিকার্সিভ কল একে চেঞ্জ করলে সেটা স্থায়ীভাবে চেঞ্জ হয়ে যায়।
</details>

---

**Q24. In the standard recursive implementation of the Euclidean algorithm to find the GCD of A and B `gcd(A, B)`, what is the recursive relation?**
A) `return gcd(B, A / B);`
B) `return gcd(B, A % B);`
C) `return gcd(A - 1, B - 1);`
D) `return gcd(B, A);`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউক্লিড আলগরিদমের মূল রুল হলো: `A` এবং `B` এর গসাগু যা, `B` এবং `A % B` এর গসাগুও তা-ই। Base case হলো `B == 0` হলে `A` রিটার্ন করবে।
</details>

---

**Q25. Which of the following is a prominent risk when using deep recursion in Java compared to C++?**
A) Java is slower at math
B) Java has a strictly limited default Call Stack size, making it much more prone to `StackOverflowError` for deep recursions (e.g., $N > 10,000$)
C) Java does not allow functions to call themselves
D) Java requires the `return` statement to be placed first

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: C++ এ স্ট্যাক সাইজ OS এর ওপর নির্ভর করে এবং অনেক বড় হয়। কিন্তু জাভাতে JVM থ্রেড স্ট্যাক সাইজ ফিক্সড করে দেয় (ডিফল্ট 1MB), তাই সামান্য গভীর রিকার্সনেই ক্র্যাশ করতে পারে।
</details>

---

**Q26. [Interview Check] Is the expression `return n * fact(n-1);` an example of Tail Recursion?**
A) Yes, because the recursive call is on the same line as the return
B) Yes, because it is the last statement
C) No, because after `fact(n-1)` returns, the multiplication with `n` still needs to be executed
D) No, because `n` is an integer

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Tail Recursion হতে হলে রিকার্সন কলটাই হতে হবে একদম শেষ কাজ। এখানে রিকার্সন থেকে ভ্যালু ফেরত আসার পর তাকে `n` দিয়ে গুণ করার কাজ বাকি থাকে। তাই এটি Tail Recursion নয়।
</details>

---

**Q27. How do you optimally convert `fact(n)` into a true Tail Recursive function?**
A) By placing the multiplication before the `return` keyword
B) By using a global variable
C) By passing an `accumulator` parameter down the recursive chain to hold the running product (e.g., `fact(n-1, n*acc)`)
D) It cannot be converted

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: গুণফলটা আগেভাগেই ক্যালকুলেট করে প্যারামিটার দিয়ে পাস করে দিলে, ফেরার পথে আর গুণ করার দরকার হয় না।
</details>

---

**Q28. When recursively reversing a String or a Linked List, how does the Call Stack aid in the reversal process?**
A) It automatically sorts the characters
B) It stores the characters/nodes in LIFO order, meaning as the recursion unwinds, we get access to the elements starting from the last one to the first
C) It converts strings to integers
D) It does not aid in the reversal

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: স্ট্রিংয়ের প্রথম ক্যারেক্টার সবার আগে স্ট্যাকে ঢোকে। তাই রিকার্সন যখন আনওয়াইন্ড (Unwind) বা রিটার্ন করে, তখন সেই ক্যারেক্টার সবার শেষে প্রসেস হয়, ফলে অটোমেটিক উল্টে যায়।
</details>

---

**Q29. What is "Nested Recursion"?**
A) When a recursive function defines another function inside it
B) When a function passes its own recursive call as a parameter to itself (e.g., `fun(fun(n+1))`)
C) When a loop is placed inside a recursion
D) When two functions call each other

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Nested Recursion মানে প্যারামিটার হিসেবেই আবার নিজেকে কল করা। Ackermann Function এর একটি বিখ্যাত উদাহরণ।
</details>

---

**Q30. To recursively calculate $X^Y$ (X to the power Y) in $O(\log Y)$ time, what is the core recurrence relation?**
A) `return X * power(X, Y-1)`
B) `return X + power(X, Y-1)`
C) `half = power(X, Y/2); return half * half;` (with adjustments for odd Y)
D) `return power(X/2, Y)`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: একে Fast Exponentiation বলে। $X^{10}$ বের করতে $X^5 \times X^5$ করলেই হয়। এতে পাওয়ার বারবার অর্ধেক হয়ে যায়, ফলে টাইম $O(\log Y)$ হয়।
</details>

---

**Q31. Consider: `int f(int n) { if(n <= 1) return 1; return f(n-1) + f(n-1); }`. What is the time complexity of this function?**
A) $O(n)$
B) $O(n^2)$
C) $O(2^n)$
D) $O(\log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ফাংশনটি নিজের ভেতরে নিজেকে ২ বার কল করছে, এবং ডেপথ হলো $N$। তাই ট্রি এর সাইজ হবে $2^0 + 2^1 + 2^2...$ অর্থাৎ টোটাল $O(2^n)$।
</details>

---

**Q32. In the "Tower of Hanoi" problem with $N$ disks, how many recursive steps (moves) are required to solve it?**
A) $N$
B) $2N$
C) $2^N - 1$
D) $N^2$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Tower of Hanoi এর রিকার্সন ফর্মুলা হলো $T(n) = 2T(n-1) + 1$। সলভ করলে এটি $2^n - 1$ হয়। অর্থাৎ ৩টি ডিস্ক সরাতে ৭টি চাল লাগে।
</details>

---

**Q33. What is the Space Complexity of the Tower of Hanoi algorithm for $N$ disks?**
A) $O(1)$
B) $O(N)$
C) $O(2^N)$
D) $O(N^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যদিও টাইম $O(2^N)$, কিন্তু রিকার্সন কল-স্ট্যাকের ম্যাক্সিমাম গভীরতা (Depth) কখনোই $N$ এর বেশি হয় না। তাই স্পেস $O(N)$।
</details>

---

**Q34. If you have an array `arr` and you pass it into a recursive function, and the function modifies `arr[0]`, will the change reflect in the calling function?**
A) Yes, because arrays in Java are passed by reference (technically reference by value), so they point to the same memory location
B) No, the recursive function creates a deep copy of the array
C) It depends on whether the array is static
D) Compilation error

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: জাভাতে অবজেক্ট এবং অ্যারে রেফারেন্স হিসেবে পাস হয়। তাই রিকার্সনের ভেতরে অ্যারে চেঞ্জ করলে অরিজিনাল অ্যারেও চেঞ্জ হয়ে যায়।
</details>

---

**Q35. In a recursive backtracking algorithm, why do we often "undo" changes (e.g., `arr[i] = 0` after making it `1`) after a recursive call returns?**
A) To save memory
B) To reset the state for the next possible parallel branch or path in the recursion tree
C) Because Java forces us to do so
D) To prevent `StackOverflowError`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Backtracking এ আমরা একটি পসিবল অপশন ট্রাই করি, সেটা কাজ না করলে বা চেক করা শেষ হলে আবার আগের অবস্থায় ফিরে আসতে হয়, যেন অন্য অপশনগুলো ট্রাই করা যায়।
</details>

---

**Q36. When parsing mathematical expressions or JSON, which technique is predominantly used?**
A) Dynamic Programming
B) Recursive Descent Parsing
C) Binary Search
D) Two Pointers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: JSON বা ম্যাথ এক্সপ্রেশন (যেমন ব্র্যাকেটের ভেতর ব্র্যাকেট) পার্স করার জন্য রিকার্সন ছাড়া উপায় নেই, কারণ এদের স্ট্রাকচারটাই রিকার্সিভ।
</details>

---

**Q37. Can a recursive function have more than one Base Case?**
A) Yes, absolutely. For example, Fibonacci has two base cases ($N=0$ and $N=1$)
B) No, having more than one base case causes a syntax error
C) No, multiple base cases lead to infinite loops
D) Yes, but only in C++

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: প্রবলেমের লজিক অনুযায়ী একাধিক Base Case থাকতেই পারে। ফিবোনাচিতে `n==0` হলে `0` এবং `n==1` হলে `1` রিটার্ন করতে হয়।
</details>

---

**Q38. Why is recursion generally frowned upon in deeply embedded systems with very limited RAM?**
A) It makes the code too readable
B) The unpredictable or deep growth of the Call Stack can easily overwrite critical memory sectors, causing system failure
C) Compilers for embedded systems do not support functions
D) Recursion is too fast for embedded CPUs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এম্বেডেড সিস্টেমে (যেমন মাইক্রোকন্ট্রোলার) RAM থাকে মাত্র কয়েক কিলোবাইট। রিকার্সন কল স্ট্যাক ফুল করে দিলে ক্র্যাশ বা ডেটা করাপ্ট হতে পারে।
</details>

---

**Q39. [Code Logic] Consider `int sum(int n) { return (n==0) ? 0 : n + sum(n-1); }`. Is this function utilizing the Ternary Operator correctly to handle the base case and recursive case?**
A) Yes, it's a perfectly valid and concise recursive implementation
B) No, ternary operators cannot invoke recursive functions
C) No, it will cause an infinite loop
D) Yes, but it will return `n` instead of the sum

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: `if-else` এর বদলে `? :` টার্নারি অপারেটর ব্যবহার করে রিকার্সন কোডকে এক লাইনে (One-liner) লেখা খুব পপুলার একটি প্র্যাকটিস।
</details>

---

**Q40. [Conclusion] If you are solving a LeetCode problem where $N = 10^5$, and your logic requires exploring paths, should you use pure Recursion (DFS)?**
A) Yes, Java can easily handle 100,000 deep recursion frames
B) No, you should convert your logic to Iterative (using a manual Stack/Queue) or expect a `StackOverflowError` in many languages like Java/Python
C) Yes, but only if you use Tail Recursion
D) Yes, by increasing the JVM heap size (`-Xmx`)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: জাভা বা পাইথনে ডিফল্ট স্ট্যাক সাইজ ছোট থাকে। $10^5$ গভীরতায় রিকার্সন গেলে গ্যারান্টিড `StackOverflowError` খাবে (Heap সাইজ বাড়ালেও কাজ হবে না, Stack সাইজ `-Xss` বাড়াতে হয়, যা কম্পিটিটিভ প্ল্যাটফর্মে করা যায় না)। তাই লুপ ব্যবহার করতে হবে।
</details>
