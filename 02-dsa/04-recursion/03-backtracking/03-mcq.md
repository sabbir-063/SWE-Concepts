# 03. Backtracking (Practice MCQs)

This file contains 40 in-depth MCQs covering the core concepts of Backtracking, State-Space Trees, Pruning, N-Queens, Time Complexities, and the difference between standard Recursion and Backtracking.

---

**Q1. What is the fundamental strategy behind a Backtracking algorithm?**
A) Always making the mathematically optimal choice at every step without looking back
B) Exploring all possible paths by making choices, and retreating (undoing the choice) when a path leads to a dead-end or invalid state
C) Using a Queue to process nodes level by level
D) Dividing the array into halves recursively

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Backtracking হলো ট্রায়াল অ্যান্ড এরর (Trial and error)। একটি রাস্তায় গিয়ে যদি দেখি কন্ডিশন মিলছে না (Dead-end), তখন আমরা পেছনে ফিরে এসে (Undo) অন্য রাস্তা ট্রাই করি।
</details>

---

**Q2. How does Backtracking fundamentally differ from standard (naive) Recursion?**
A) Standard recursion uses a Stack, while Backtracking uses a Queue
B) Backtracking actively incorporates an "Undo" step to restore the program state before trying alternative branches in the recursion tree
C) Standard recursion is only for math problems
D) There is no difference; they are exactly the same concept

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নরমাল রিকার্সন সোজা গভীরে যায়। কিন্তু Backtracking এ গভীরে যাওয়ার পর ফেরার পথে আমরা আমাদের আগের করা কাজ মুছে ফেলি (Undo/Un-choose), যাতে নতুন পাথটা ক্লিন স্টেট পায়।
</details>

---

**Q3. What does a "State-Space Tree" represent in the context of Backtracking?**
A) A binary tree used for sorting
B) A visual or conceptual representation of all possible states (choices) the algorithm can explore to find the solution
C) A tree data structure strictly stored in Heap memory
D) The file system hierarchy

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: State-Space Tree হলো একটি কাল্পনিক ট্রি, যার একেকটি ডাল (Branch) একেকটি অপশন বা চয়েসকে রিপ্রেজেন্ট করে। Backtracking এই ট্রির ডালগুলোতেই ঘুরে ঘুরে সলিউশন খোঁজে।
</details>

---

**Q4. What is the purpose of "Pruning" in a Backtracking algorithm?**
A) To safely remove elements from a Linked List
B) To intentionally cut off or ignore branches of the state-space tree that are guaranteed to yield invalid results, significantly speeding up execution
C) To increase the recursion depth
D) To convert a recursive algorithm into an iterative one

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Pruning (ডাল ছেঁটে ফেলা) হলো অপ্টিমাইজেশন। যদি আমরা বুঝতে পারি যে এই রাস্তায় গেলে কখনোই সলিউশন পাবো না, তখন আমরা অযথাই রিকার্সন না করে ওখান থেকেই স্কিপ বা রিটার্ন করে দিই।
</details>

---

**Q5. What is the classic template of operations inside a Backtracking loop?**
A) Read -> Write -> Delete
B) Push -> Pop -> Peek
C) Choose -> Explore (Recurse) -> Un-choose (Undo)
D) Divide -> Conquer -> Merge

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: পৃথিবীর প্রায় সব Backtracking প্রবলেম এই ৩টি স্টেপ ফলো করে: ১. চয়েসটি নাও, ২. রিকার্সন করে গভীরে যাও, ৩. ফিরে আসার সময় চয়েসটি মুছে ফেলো।
</details>

---

**Q6. Why is the "Un-choose" or "Undo" step critically important?**
A) To prevent memory leaks in Java
B) To ensure the shared state variable (e.g., a List or Array) is correctly restored to its original form so the next iteration can use it cleanly
C) To satisfy compiler warnings
D) To avoid NullPointerExceptions

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু আমরা সাধারণত একই `List` বা `Array` এর ভেতর ডেটা পুশ করি, তাই ফেরার পথে ডেটা পপ না করলে পরের অপশন চেক করার সময় আগের ডেটা থেকে গিয়ে ভুল রেজাল্ট দেবে।
</details>

---

**Q7. In Java, when adding a valid combination to your `List<List<Integer>> result` inside the base case, what is the most common mistake made by beginners?**
A) Adding the list directly via `result.add(currentList);`, which adds a reference instead of a deep copy, leading to a list full of empty sub-lists later
B) Using `.add()` instead of `.push()`
C) Returning the list instead of printing it
D) Forgetting to cast the list

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: `currentList` একটি অবজেক্ট রেফারেন্স। রিকার্সন শেষে যখন আপনি `currentList` থেকে সব রিমুভ করবেন, তখন `result` এর ভেতরে থাকা লিস্টগুলোও ফাঁকা হয়ে যাবে। তাই সবসময় `new ArrayList<>(currentList)` দিয়ে কপি অ্যাড করতে হয়।
</details>

---

**Q8. Which algorithmic paradigm does Backtracking heavily rely on?**
A) Breadth-First Search (BFS)
B) Depth-First Search (DFS)
C) Sliding Window
D) Dynamic Programming

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Backtracking একটি অপশন ধরে ট্রির একদম গভীরে চলে যায় (DFS)। কাজ না হলে ফিরে এসে আবার অন্য ডাল ধরে গভীরে যায়।
</details>

---

**Q9. Generating all "Permutations" of an array (e.g., [1, 2, 3]) results in how many unique combinations?**
A) $2^N$
B) $N^2$
C) $N!$ (N Factorial)
D) $N^N$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ৩টি আইটেম সাজানোর উপায় $3! = 6$ টি। $N$ টি আইটেমের জন্য সবসমসয় $N!$ পারমুটেশন হয়।
</details>

---

**Q10. What is the primary difference in the loop structure between generating "Subsets" and generating "Permutations" using Backtracking?**
A) There is no difference
B) Subsets use a `while` loop; Permutations use a `for` loop
C) Subsets loop from a `start` index moving forward to avoid duplicates, whereas Permutations always loop from `0` to $N$ and use a `contains()` or `visited` check
D) Subsets do not use loops

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: সাবসেটে `[1, 2]` আর `[2, 1]` একই জিনিস, তাই পেছনের ইনডেক্সে আর ফেরা যায় না (`start` থেকে লুপ চলে)। কিন্তু পারমুটেশনে `[1, 2]` এবং `[2, 1]` আলাদা, তাই সবসময় 0 থেকেই লুপ চলে।
</details>

---

**Q11. What is the typical Time Complexity for generating all "Subsets" (Power Set) of an array of size N?**
A) $O(N^2)$
B) $O(N!)$
C) $O(N \log N)$
D) $O(2^N \times N)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: $N$ সাইজের সেটে মোট সাবসেট থাকে $2^N$ টি। প্রতিটি সাবসেটকে রিকার্সন থেকে কপি করে রেজাল্টে অ্যাড করতে $N$ সময় লাগে, তাই টোটাল $O(2^N \times N)$।
</details>

---

**Q12. What does the "N-Queens Problem" fundamentally require?**
A) Placing N Kings on a board
B) Placing N Queens on an N x N chessboard such that no two Queens threaten each other (no two in the same row, column, or diagonal)
C) Finding the shortest path for a Queen to cross the board
D) Sorting the chessboard cells

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি Backtracking এর সবচেয়ে ফেমাস প্রবলেম। দাবার নিয়মে কোনো রানি যেন অন্য রানির সোজা বা কোণাকুণি (Diagonal) না পড়ে, সেই কন্ডিশন চেক করে বসাতে হয়।
</details>

---

**Q13. In the N-Queens problem, how do you typically optimize the check to see if a Queen is safe?**
A) By running a BFS from the current cell
B) By using a Hash Map for rows, and mathematical arrays (`col + row` and `col - row`) for tracking occupied diagonals
C) By simulating a game of chess
D) By sorting the board

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: লুপ চালিয়ে চেক করতে $O(N)$ সময় লাগে। কিন্তু ডায়াগনালগুলোর কো-অর্ডিনেটের যোগফল বা বিয়োগফল (row+col, row-col) কনস্ট্যান্ট থাকে, যা অ্যারে বা হ্যাশম্যাপ দিয়ে $O(1)$ টাইমে চেক (Pruning) করা যায়।
</details>

---

**Q14. In Backtracking, what does it mean to do an "Exhaustive Search"?**
A) The program runs until the CPU is exhausted
B) Exploring strictly a single path to the end
C) Systematically generating and checking all possible solutions (brute force) to find the correct one(s)
D) Running DP iteratively

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Exhaustive Search মানে হলো ট্রির প্রতিটি পসিবল ডাল চেক করা। কোনো অপশন বাদ না দেওয়া।
</details>

---

**Q15. Can Dynamic Programming (DP) be viewed as an optimized version of Backtracking?**
A) Yes, DP is essentially backtracking on overlapping subproblems supplemented with Memoization (caching) so we do not re-calculate states we have already explored
B) No, DP and Backtracking are completely unrelated
C) Yes, but only for sorting arrays
D) No, Backtracking is always faster than DP

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Backtracking সব পথ চেক করে। আর ওই পথে যদি বারবার একই কাজ (Overlapping Subproblems) রিপিট হতে থাকে, তখন সেখানে মেমোরি অ্যাড করে দিলেই সেটি DP (Memoization) হয়ে যায়।
</details>

---

**Q16. "Sudoku Solver" is widely solved using which algorithmic technique?**
A) Dynamic Programming
B) Binary Search
C) Greedy Algorithm
D) Backtracking

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: সুডোকুতে আমরা একটি খালি ঘরে ১ থেকে ৯ পর্যন্ত সংখ্যা বসিয়ে ট্রাই করি (Choose)। যদি মিলে যায় তো ভালো, না মিললে ওই সংখ্যা মুছে (Undo) অন্য সংখ্যা ট্রাই করি। এটি ক্লাসিক Backtracking।
</details>

---

**Q17. In the "Combination Sum" problem (finding subsets that add up to a target sum where elements can be reused), how does the recursive call handle reuse?**
A) By skipping the element
B) By passing `i + 1` as the `start` index
C) By passing `i` as the `start` index again for the next recursive call, allowing the current element to be picked multiple times
D) By cloning the array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেহেতু একই ইলিমেন্ট বারবার নেওয়া যাবে, তাই রিকার্সনে আমরা ইনডেক্স না বাড়িয়ে কারেন্ট ইনডেক্সটাই (`i`) পাঠিয়ে দিই, যাতে সে নিজেকে আবার নিতে পারে।
</details>

---

**Q18. What is the defining characteristic of NP-Hard problems (like the Traveling Salesperson Problem)?**
A) They can be solved efficiently in $O(N)$ time
B) There is no known polynomial-time solution for them; finding the exact answer usually requires checking all permutations, making algorithms like Backtracking necessary for small inputs
C) They are exclusively hardware problems
D) They cannot be solved by computers at all

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: NP-Hard প্রবলেমের কোনো ম্যাজিক শর্টকাট বা ফাস্ট ফর্মুলা নেই। বাধ্য হয়ে Backtracking দিয়ে সব পসিবল কম্বিনেশন চেক করেই উত্তর বের করতে হয়।
</details>

---

**Q19. When writing a Backtracking solution to find a path through a Maze, what is the role of a `boolean[][] visited` matrix?**
A) It marks the end point
B) It keeps track of cells currently in the path to prevent infinite loops (going back and forth between two cells)
C) It stores the final result
D) It sorts the maze

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একটি ঘরে একবার ঢুকলে সেটিকে `visited = true` করে দিতে হয়। না হলে অ্যালগরিদম একই ডানে-বামে করে ইনফিনিট লুপে পড়ে যাবে। ফেরার পথে (Undo) আবার এটিকে `false` করে দিতে হয়।
</details>

---

**Q20. In string permutation (e.g., finding permutations of "AAB"), how do you handle duplicates to avoid returning duplicate results like "ABA" twice?**
A) By using a Set to store the final results, or by sorting the array first and using a `if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;` logic (Pruning)
B) Duplicates are impossible in strings
C) By changing all characters to lowercase
D) By converting it to a numeric array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: `HashSet` ব্যবহার করলে ডুপ্লিকেট রিমুভ হয়, তবে এটি ধীরগতির। সবচেয়ে ফাস্ট উপায় হলো আগে সর্ট করে নেওয়া এবং লুপের ভেতর Pruning চেক বসানো যাতে একই ক্যারেক্টার একই পজিশনে দুইবার না বসে।
</details>

---

**Q21. Why is the Space Complexity of Backtracking algorithms usually $O(N)$ despite checking millions of paths?**
A) Because the JVM compresses the data
B) Because it uses an iterative `while` loop
C) Because we only ever explore one deep branch of the tree at a time (DFS depth), so the maximum number of frames on the Call Stack is proportional to the tree's height (N)
D) It is actually $O(2^N)$ space

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: রিকার্সন কখনোই একই সাথে সব ডাল চেক করে না। সে একবারে একটি ডালে একদম নিচ পর্যন্ত যায়। তাই ট্রির হাইট যতো (সাধারণত N), ম্যাক্সিমাম ততোগুলো স্ট্যাক ফ্রেমই একসাথে মেমোরিতে থাকে।
</details>

---

**Q22. "Generate Parentheses" (LeetCode 22) asks you to generate all valid combinations of $n$ pairs of parentheses. What are the constraints for pruning the backtracking tree?**
A) Close brackets must always equal Open brackets
B) You can add an Open bracket if `open < n`, and you can add a Close bracket only if `close < open`
C) There are no constraints
D) Open brackets must be added last

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ব্র্যাকেটের রুল হলো, আপনি চাইলেই ক্লোজ `)` ব্র্যাকেট দিতে পারবেন না যতক্ষণ না আগে ওপেন `(` ব্র্যাকেট দেওয়া থাকে। এই লজিকটাই Pruning কন্ডিশন হিসেবে কাজ করে।
</details>

---

**Q23. Is it possible to implement Backtracking without Recursion?**
A) No, impossible
B) Yes, by explicitly using a manual Stack data structure to simulate the Call Stack and carefully managing the state for the "Undo" process
C) Yes, by using a Queue
D) Only in Python

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সনকে সবসময় লুপে কনভার্ট করা যায়। কিন্তু Backtracking এর State Undo করার লজিকটা কাস্টম Stack দিয়ে ম্যানুয়ালি ইমপ্লিমেন্ট করা খুবই পেইনফুল, একারণেই সবাই রিকার্সন ইউজ করে।
</details>

---

**Q24. [Code Output] Consider a Backtracking function to generate Subsets of `[1, 2]`. Without the "Undo" step (e.g., `list.remove(list.size()-1)`), what would likely happen?**
A) The program would throw a NullPointerException
B) Elements would keep accumulating in the list indiscriminately, resulting in incorrect sizes and garbage combinations like `[1, 1, 2, 2]`
C) The output would perfectly remain `[[], [1], [1,2], [2]]`
D) The compiler would automatically undo it

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Undo না করলে লিস্ট থেকে ডেটা রিমুভ হবে না। পরের রিকার্সনগুলো ওই আগের ময়লা (Stale data) লিস্টের ওপরেই নতুন ডেটা পুশ করতে থাকবে, ফলে রেজাল্ট পুরো ভুল আসবে।
</details>

---

**Q25. Which problem is NOT a classic Backtracking problem?**
A) Word Search (Boggle)
B) Graph Coloring
C) Shortest Path in an unweighted Graph
D) Hamiltonian Path

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: আনওয়েটেড গ্রাফে শর্টেস্ট পাথ বের করার জন্য BFS (Queue) ব্যবহার করা হয়, Backtracking নয়।
</details>

---

**Q26. What does "State Exploration" mean in Backtracking?**
A) Formatting the hard drive
B) Making a valid choice and moving to the next logical step (e.g., calling `backtrack(row + 1)`)
C) Sorting an array
D) Returning the final answer

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Explore মানে হলো বর্তমান চয়েসটি নিয়ে পরবর্তী ধাপে (যেমন পরের সারি, বা পরের ইনডেক্সে) রিকার্সিভলি প্রবেশ করা।
</details>

---

**Q27. In the "Letter Combinations of a Phone Number" problem, how is the recursion tree bounded (what determines the depth of the tree)?**
A) By the number of letters on the keypad
B) By the length of the input digit string
C) By the English alphabet length (26)
D) It is unbounded

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউজার যদি ৩টি ডিজিট (যেমন "234") দেয়, তবে ট্রি এর গভীরতা হবে ৩। কারণ আমাদের ৩টি লেটারের কম্বিনেশন বানাতে হবে।
</details>

---

**Q28. What is a "Heuristic" in the context of search algorithms (like A* or advanced backtracking)?**
A) A hardware accelerator
B) A rule-of-thumb or educated guess that helps the algorithm decide which branch to explore first, potentially finding the answer faster
C) A type of error
D) A sorting method

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Heuristic মানে হলো গেস (Guess) করা। যেমন আমরা জানি ডেস্টিনেশন ডানে আছে, তাই আমরা বাঁয়ে না গিয়ে আগে ডানদিকের ডালগুলো চেক করবো। এটি সার্চকে অনেক ফাস্ট করে।
</details>

---

**Q29. What is the fundamental Time Complexity of solving a standard $9 \times 9$ Sudoku puzzle using Brute-Force Backtracking?**
A) $O(1)$ (because the board size is strictly constant $9 \times 9$, technically it's a fixed upper bound $9^{81}$)
B) $O(N^2)$
C) $O(\log N)$
D) $O(N)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Big-O নোটেশনে, যেহেতু সুডোকু বোর্ডের সাইজ ফিক্সড ($9 \times 9$) এবং ম্যাক্সিমাম অপারেশন $9^{81}$ (যা বিশাল হলেও কনস্ট্যান্ট), তাই টেকনিক্যালি এর কমপ্লেক্সিটি $O(1)$ ধরা হয়।
</details>

---

**Q30. In "Word Break II" (finding all valid sentence constructions), what makes Backtracking painfully slow, and how is it fixed?**
A) It is slow because of garbage collection; it is fixed by using C++
B) It encounters massive overlapping subproblems (e.g., solving the same suffix repeatedly); it is fixed by adding Memoization (turning it into DP)
C) It cannot read strings; fixed by converting to bytes
D) There is no fix

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Backtracking সব পাথ এক্সপ্লোর করে। একই শব্দের বাকি অংশ যদি বারবার ভাঙতে হয়, তবে তা স্লো হয়ে যায়। মেমোরি (Cache) বসিয়ে দিলে এটি DP হয়ে যায় এবং ফাস্ট হয়ে যায়।
</details>

---

**Q31. [Code Logic] When using `StringBuilder` instead of `String` for state tracking in Backtracking (e.g., generating parentheses), what must you manually do?**
A) Call `sb.toString()` after every step
B) Manually undo the append by calling `sb.deleteCharAt(sb.length() - 1)` because `StringBuilder` is mutable and modifies the original object
C) Nothing, it acts like a normal String
D) Clear the entire builder

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `String` ইমিউটেবল (Immutable) হওয়ায় প্রতি কলে নতুন অবজেক্ট তৈরি হয় (Undo লাগে না)। কিন্তু `StringBuilder` একই অবজেক্টে চেঞ্জ করে, তাই ফেরার পথে অবশ্যই লাস্ট ক্যারেক্টারটি ডিলিট করতে হয়।
</details>

---

**Q32. In the "Palindrome Partitioning" problem, what is the Pruning condition before moving to the next substring?**
A) The string length must be even
B) The current selected substring must inherently be a valid Palindrome before we recursively try to partition the rest of the string
C) The string must contain no numbers
D) There is no pruning

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যদি কারেন্ট কাটা অংশটুকু প্যালিনড্রোম (উভয় দিক থেকে সেম) না হয়, তবে আমাদের বাকি অংশ চেক করার কোনো দরকারই নেই। এটিই হলো Pruning।
</details>

---

**Q33. What is the Space Complexity of Backtracking to find all permutations of a string of length $N$ (excluding the space required to store the final list of answers)?**
A) $O(N!)$
B) $O(1)$
C) $O(N)$ for the recursion stack
D) $O(N^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: পারমুটেশনের ট্রি এর গভীরতা হয় ইনপুটের সাইজের সমান ($N$)। তাই Call Stack এর ম্যাক্সিমাম সাইজ হবে $O(N)$। (রেজাল্ট স্টোর করার স্পেস বাদে)।
</details>

---

**Q34. Why do we usually pass the `result` List as a parameter to the backtracking function instead of returning it?**
A) Because Java does not allow functions to return Lists
B) To maintain a single shared reference (Global state) that all recursive branches can append their successful answers to without merging lists at every step
C) To save memory
D) It is a syntax rule

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সনে গ্লোবাল বা শেয়ারড একটি লিস্ট পাস করলে সব ডাল থেকে সাকসেসফুল অ্যান্সারগুলো সরাসরি সেখানে পুশ করা যায়। রিটার্ন করে মার্জ করতে গেলে কোড কঠিন এবং স্লো হয়ে যায়।
</details>

---

**Q35. "Knights Tour" is a classic Backtracking problem. How many choices does a Knight typically have from a given square?**
A) 4
B) 8
C) 2
D) 6

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: দাবার বোর্ডে একটি ঘোড়া (Knight) "L" শেপে লাফ দেয়। বোর্ডের মাঝখানে থাকলে সে সর্বোচ্চ ৮টি দিকে লাফ দেওয়ার অপশন (Choices) পায়।
</details>

---

**Q36. How do you detect if a given Backtracking problem guarantees ONLY ONE unique solution versus MULTIPLE solutions?**
A) By looking at the compiler flags
B) Problems asking for "True/False" or "Can it reach the end?" usually require finding just one path (we can return immediately). Problems asking for "All possible ways" require exhaustive search.
C) They always guarantee multiple solutions
D) By the size of the array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যদি শুধু একটি সলিউশন চায় (যেমন সুডোকু বা মেজ), তবে একটি অ্যান্সার পেলেই আমরা `return true` করে পুরো রিকার্সন ব্রেক করে দিই। কিন্তু "সবগুলো উপায়" চাইলে ট্রির শেষ পর্যন্ত সব অপশন খুঁজতে হয়।
</details>

---

**Q37. Can Bitwise Operators be used to optimize the Backtracking process?**
A) No, Bitwise operations are only for cryptography
B) Yes, Bit Masking is frequently used in problems like N-Queens or TSP to track visited columns/nodes in $O(1)$ time and extremely low memory (using an integer instead of a boolean array)
C) Yes, but only in C++
D) No, they slow down recursion

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `visited` চেক করার জন্য `boolean[]` এর বদলে একটি `int` ভেরিয়েবলের বিটগুলো (0/1) কে মাস্ক হিসেবে ব্যবহার করলে পারফরম্যান্স অনেক বেশি ফাস্ট হয়।
</details>

---

**Q38. What is the fundamental difference between Divide and Conquer and Backtracking?**
A) Divide and Conquer breaks a problem into non-overlapping subproblems and combines them. Backtracking explores all potential configurations by building solutions step-by-step and abandoning invalid ones.
B) Backtracking uses loops, Divide and Conquer uses recursion
C) They are the exact same paradigm
D) Divide and Conquer is for Graphs, Backtracking is for Arrays

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Divide and Conquer (Merge Sort) এ অপশন যাচাই করার কিছু নেই, সে শুধু ভেঙে সলভ করে জোড়া লাগায়। কিন্তু Backtracking এ সে নিজে নিজে অপশন যাচাই করে, ভুল হলে বাতিল করে।
</details>

---

**Q39. [Interview Logic] If your Backtracking solution is producing Time Limit Exceeded (TLE) on LeetCode, what is the FIRST thing you should look for?**
A) Switching from Java to C++
B) Missed opportunities for Pruning (cutting dead-ends earlier) or identifying Overlapping Subproblems (requiring DP/Memoization)
C) Adding more recursion depth
D) Using a larger array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: TLE খাওয়ার মানে হলো আপনার কোড এমন অনেক ডালপালা চেক করছে যেগুলোর কোনো দরকারই নেই। তাই আগে দেখতে হবে কোথায় `if` কন্ডিশন দিয়ে Prune করা যায় বা DP অ্যাড করা যায়।
</details>

---

**Q40. [Conclusion] Summarize the Backtracking Philosophy in one sentence.**
A) Look at the whole problem and divide it into two
B) Pick the greedy optimal choice and never look back
C) Take a step, see if it works, if it fails, step back and try another path
D) Calculate everything iteratively from bottom to top

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: এটিই Backtracking এর মূল মন্ত্র। "ট্রাই করো, কাজ না হলে আনডু করে অন্য রাস্তায় যাও"।
</details>
