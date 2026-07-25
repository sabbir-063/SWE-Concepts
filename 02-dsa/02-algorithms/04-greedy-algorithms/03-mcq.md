# 04. Greedy Algorithms (Practice MCQs)

This file contains 40 in-depth MCQs covering Greedy Algorithms, their properties, Activity Selection, Fractional Knapsack, Huffman Coding, and scenarios where Greedy logic fails.

---

**Q1. What is the defining characteristic of a Greedy Algorithm?**
A) It evaluates all future consequences before making a decision
B) It makes the locally optimal choice at each step with the hope of finding a global optimum
C) It relies heavily on Backtracking to correct mistakes
D) It is exclusively used for Graph traversal

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Greedy মানেই হলো লোভী। চোখের সামনে যেটাকে এই মুহূর্তে সবচেয়ে লাভজনক মনে হয়, সে তাকেই পিক করে নেয়। ভবিষ্যতে এর কী ইমপ্যাক্ট হবে তা নিয়ে সে ভাবে না।
</details>

---

**Q2. Which two primary properties must a problem exhibit for a Greedy Algorithm to guarantee an optimal solution?**
A) Recursion and Iteration
B) Memoization and Tabulation
C) Greedy Choice Property and Optimal Substructure
D) Time Complexity and Space Complexity

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: "Greedy Choice Property" মানে হলো লোকাল বেস্ট চয়েস নিলে আমরা গ্লোবাল বেস্ট রেজাল্ট পাবো। আর "Optimal Substructure" মানে হলো বড় প্রবলেমের বেস্ট সলিউশনের ভেতরে ছোট প্রবলেমের বেস্ট সলিউশন লুকিয়ে থাকবে।
</details>

---

**Q3. Which of the following classic algorithms strictly follows the Greedy approach?**
A) Merge Sort
B) Dijkstra's Algorithm
C) Binary Search
D) Depth-First Search (DFS)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Dijkstra's Algorithm প্রতি ধাপে সবচেয়ে কাছের আনভিজিটেড নোডটি বেছে নেয়, যা একটি ক্লাসিক Greedy চয়েস।
</details>

---

**Q4. Why does the Greedy approach fail to guarantee an optimal solution for the "0/1 Knapsack Problem"?**
A) Because the data cannot be sorted based on a specific ratio
B) Because items cannot be fractioned (broken down), meaning taking a seemingly optimal item now might waste critical space preventing better combinations later
C) Because its Time Complexity is inherently too high for a Greedy logic
D) It only fails when implemented in languages other than C++

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 0/1 Knapsack এ কোনো আইটেম নিলে পুরোপুরি নিতে হয়, না হলে বাদ দিতে হয়। Greedy দিয়ে বেশি দামি আইটেম নিলে দেখা যায় ব্যাগে অল্প জায়গা ফাঁকা থাকে যা অন্য কোনো আইটেম দিয়ে পূরণ করা যায় না, ফলে মোটের ওপর প্রফিট কমে যায়।
</details>

---

**Q5. For which variation of the Knapsack Problem does the Greedy Algorithm always yield the perfect optimal result?**
A) 0/1 Knapsack
B) Bounded Knapsack
C) Fractional Knapsack
D) Multiple Knapsack

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Fractional Knapsack এ আইটেম ভেঙে ব্যাগের বাকি ফাঁকা জায়গায় ঢোকানো যায়। তাই রেশিও (Value/Weight) অনুযায়ী বড় থেকে ছোট নিলেও কোনো জায়গা নষ্ট হয় না এবং গ্লোবাল বেস্ট রেজাল্ট পাওয়া যায়।
</details>

---

**Q6. In the "Activity Selection Problem" (maximizing the number of non-overlapping meetings), what is the correct Greedy Choice?**
A) Sort activities by Start Time and pick the earliest one
B) Sort activities by End Time and pick the one that finishes earliest
C) Sort activities by Duration and pick the shortest ones first
D) Pick activities completely at random

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: End Time অনুযায়ী সর্ট করলে আমরা এমন মিটিং আগে পাই যা তাড়াতাড়ি শেষ হয়ে যায়। ফলে বাকি সময়টাতে আরও বেশি মিটিং করার সুযোগ থাকে। Start Time বা Duration দিয়ে করলে ওভারল্যাপ হওয়ার চান্স বেশি থাকে।
</details>

---

**Q7. What is the Time Complexity of an optimally implemented Activity Selection algorithm?**
A) $O(1)$
B) $O(n)$
C) $O(n \log n)$
D) $O(n^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: মিটিংগুলোকে End Time অনুযায়ী সর্ট করতে $O(n \log n)$ সময় লাগে। এরপর একটি লুপ চালিয়ে চেক করতে $O(n)$ লাগে। তাই টোটাল কমপ্লেক্সিটি $O(n \log n)$।
</details>

---

**Q8. The Huffman Coding algorithm is primarily utilized for what purpose?**
A) Encrypting sensitive data
B) Finding the shortest path in a network
C) Lossless Data Compression
D) Sorting massive arrays

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Huffman Coding ফাইল সাইজ কমানোর জন্য ব্যবহৃত হয়। এটি বেশি আসা ক্যারেক্টারকে ছোট বিট (যেমন 0) এবং কম আসা ক্যারেক্টারকে বড় বিট দিয়ে রিপ্লেস করে স্পেস বাঁচায়।
</details>

---

**Q9. Which data structure is most crucial for efficiently building a Huffman Tree?**
A) Stack
B) Queue
C) Hash Map
D) Min-Priority Queue (Min Heap)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: Huffman Coding এ প্রতি ধাপে সবচেয়ে কম ফ্রিকোয়েন্সির (Frequency) দুটো নোডকে মার্জ (Merge) করতে হয়। সবচেয়ে ছোট দুটো নোড ফাস্ট বের করার জন্য Min-Priority Queue বেস্ট অপশন।
</details>

---

**Q10. What is the fundamental difference between a Greedy Algorithm and Dynamic Programming (DP)?**
A) Greedy uses recursion, whereas DP does not
B) Greedy makes irreversible local optimal choices without looking ahead, whereas DP explores all possibilities and evaluates future consequences before deciding
C) Greedy is always slower than DP
D) There is no logical difference

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Greedy হলো "Never look back"। একবার সিদ্ধান্ত নিয়ে নিলে সেটাই ফাইনাল। কিন্তু DP ভবিষ্যতের সব ইমপ্যাক্ট হিসাব করে তারপর বেস্ট সিদ্ধান্তটা নেয়।
</details>

---

**Q11. Is Kruskal’s Algorithm, used for finding the Minimum Spanning Tree (MST), considered a Greedy Algorithm?**
A) Yes
B) No, it is a Dynamic Programming algorithm
C) No, it uses Divide and Conquer
D) No, it uses Backtracking

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Kruskal's অ্যালগরিদম গ্রাফের সবগুলো এজকে ওয়েট অনুযায়ী সর্ট করে এবং প্রতি ধাপে সাইকেল তৈরি না করে সবচেয়ে ছোট এজটি বেছে নেয়। এটি একটি পারফেক্ট Greedy চয়েস।
</details>

---

**Q12. What constitutes the Greedy choice in Prim’s Algorithm for finding an MST?**
A) Picking the globally smallest edge across the entire graph
B) Picking the edge with the minimum weight that connects a node inside the currently growing tree to an unvisited node outside the tree
C) Picking the edge with the maximum weight
D) Picking an edge at random

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Prim's একটি রুট থেকে শুরু করে এবং প্রতি ধাপে ওই ট্রি থেকে সবচেয়ে কম খরচে পৌঁছানো যায় এমন নতুন নোডটিকে যুক্ত করে (Min-Priority Queue ব্যবহার করে)।
</details>

---

**Q13. Under what condition might the Greedy Algorithm fail to provide the minimum number of coins in the "Coin Change Problem"?**
A) When the coin denominations are excessively large
B) When the coin system is non-canonical (e.g., random values like {1, 3, 4})
C) When the system only has coins of value 1
D) Greedy logic never fails in Coin Change problems

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আমাদের দেশের কারেন্সি সিস্টেমে (1, 2, 5, 10...) Greedy কাজ করে। কিন্তু 1, 3, 4 সিস্টেমে 6 বানাতে দিলে Greedy নেবে 4, 1, 1 (৩টি)। কিন্তু বেস্ট সলিউশন হলো 3, 3 (২টি)। এখানে Greedy ফেইল করে।
</details>

---

**Q14. In the Fractional Knapsack problem, how should the items be sorted to apply the Greedy approach?**
A) By descending order of Weight
B) By descending order of Value
C) By descending order of the (Value / Weight) ratio
D) By descending order of the (Weight / Value) ratio

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: আমরা সেই আইটেমটিই আগে চাইবো যার প্রতি কেজির দাম সবচেয়ে বেশি! তাই Value কে Weight দিয়ে ভাগ করে সেই রেশিও অনুযায়ী ডিসেন্ডিং অর্ডারে সাজাতে হয়।
</details>

---

**Q15. What is the Greedy trick used in the "Job Sequencing Problem with Deadlines" to maximize profit?**
A) Sort jobs by descending profit, and schedule each job in the latest possible available slot just before its deadline
B) Sort jobs purely by their deadlines
C) Sort jobs purely by their duration
D) Schedule the jobs with the least profit first

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: যেহেতু আমরা ম্যাক্সিমাম প্রফিট চাই, তাই বেশি প্রফিটের কাজ আগে করবো। তবে সেটি যত দেরিতে (ডেডলাইনের ঠিক আগে) করা যায় ততই ভালো, যাতে অন্য কাজ করার জন্য শুরুর দিকের স্লটগুলো ফাঁকা থাকে।
</details>

---

**Q16. In a completed Huffman Tree, what does the frequency value of the absolute root node represent?**
A) 0
B) 1
C) The sum total of all characters' frequencies in the entire file
D) The frequency of the single most occurring character

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Huffman Tree নিচ থেকে ওপরের দিকে তৈরি হয় (Bottom-up)। দুটি ছোট ফ্রিকোয়েন্সি যোগ হয়ে নতুন প্যারেন্ট হয়। এভাবে একদম রুটে এসে পুরো ফাইলের মোট ফ্রিকোয়েন্সির সমান হয়ে যায়।
</details>

---

**Q17. What is the most common overall Time Complexity bound for Greedy Algorithms?**
A) $O(1)$
B) $O(n)$
C) $O(n \log n)$
D) $O(n^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: প্রায় সব Greedy প্রবলেমেই শুরুতে ডেটাকে কোনো না কোনো লজিকে સর্ট (Sort) করতে হয়। সর্টিংয়ের কস্ট $O(n \log n)$ হওয়ায় পুরো অ্যালগরিদমের টাইম কমপ্লেক্সিটি $O(n \log n)$ হয়ে যায়।
</details>

---

**Q18. What is the exact Time Complexity of the Fractional Knapsack problem for 'n' items?**
A) $O(n)$
B) $O(n \log n)$
C) $O(W)$ where W is the total weight capacity
D) $O(2^n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রেশিও বের করা এবং ব্যাগ ভরা দুটোই $O(n)$ টাইমের কাজ। কিন্তু তার আগে রেশিও অনুযায়ী আইটেমগুলোকে সর্ট করতে $O(n \log n)$ সময় লাগে, যা মেইন বটলনেক।
</details>

---

**Q19. If the intervals in the Activity Selection problem are already provided to you sorted by their End Times, what becomes the Time Complexity?**
A) $O(n \log n)$
B) $O(n)$
C) $O(n^2)$
D) $O(1)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সর্ট করা থাকলে শুধু একটি সিঙ্গেল `for` লুপ চালিয়ে চেক করতে হবে পরের মিটিং ওভারল্যাপ করছে কি না। এর জন্য $O(n)$ সময় লাগবে।
</details>

---

**Q20. [Gotcha] In Activity Selection, if two activities happen to share the exact same End Time, which one should you pick to maximize the total count of activities?**
A) The one with the earlier Start Time
B) The one with the later Start Time
C) It does not matter; picking either will yield the same maximum count
D) You must discard both to avoid collision

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেহেতু আমরা ম্যাক্সিমাম "সংখ্যায়" মিটিং করতে চাই, তাই End Time সমান হলে যেকোনো একটি নিলেও মোট মিটিংয়ের সংখ্যায় (Total count) কোনো পরিবর্তন আসবে না।
</details>

---

**Q21. Under what condition does Dijkstra's Algorithm lose its Greedy guarantee and potentially fail?**
A) When the graph is massive
B) When the graph contains edges with negative weights
C) When the graph is undirected
D) When the graph contains cycles

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Dijkstra বর্তমানের সবচেয়ে ছোট এজ পিক করে এবং ধরে নেয় যে পরে আর কোনো ছোট রাস্তা পাওয়া যাবে না। কিন্তু নেগেটিভ এজ থাকলে পরে ঘুরে এসে আরও ছোট রাস্তা পাওয়া যেতে পারে। তখন Greedy লজিক ফেইল করে এবং Bellman-Ford (DP) লাগে।
</details>

---

**Q22. When calculating the Value/Weight ratio in Java for Fractional Knapsack, which syntax prevents precision loss?**
A) `int ratio = value / weight;`
B) `double ratio = (double) value / weight;`
C) `float ratio = value % weight;`
D) Just sort by `value` instead of a ratio

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Integer ডিভিশন করলে দশমিকের পরের অংশ হারিয়ে যায় (যেমন 5/2 = 2 হয়ে যাবে, কিন্তু আসল রেশিও 2.5)। তাই টাইপকাস্ট করে `double` এ রেশিও বের করতে হয়।
</details>

---

**Q23. In Huffman Coding, which character gets assigned the shortest binary code?**
A) The character that comes first alphabetically
B) The character with the largest byte size
C) The character that appears most frequently (Highest frequency) in the text
D) The character that appears least frequently

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: কম্প্রেশনের মূল থিমই হলো—যেটা বেশিবার আসবে, তাকে ছোট কোড দিলে টোটাল ফাইলের সাইজ অনেক কমে যাবে।
</details>

---

**Q24. Why are the bit sequences generated by Huffman Coding called "Prefix Codes"?**
A) Because they all begin with the prefix '0'
B) Because no character's assigned code is a prefix of any other character's assigned code
C) Because they are always of a fixed length
D) Because they are generated using a pre-order tree traversal

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Prefix Code এর সুবিধা হলো ডিকোড করার সময় কোনো কনফিউশন (Ambiguity) তৈরি হয় 파 না। 'A' এর কোড যদি `10` হয়, তবে অন্য কোনো ক্যারেক্টারের কোড `10` দিয়ে শুরু হতে পারবে না।
</details>

---

**Q25. In the canonical "Coin Change" problem, what is the Greedy decision at each step?**
A) Pick the smallest available coin denomination
B) Pick a random coin denomination
C) Pick the largest available coin denomination that does not exceed the remaining target amount
D) Always pick the absolute largest denomination, even if it exceeds the target

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Greedy সবসময় কম কয়েন ব্যবহার করতে চাইবে। তাই সে টার্গেটের কাছাকাছি থাকা সবচেয়ে বড় কয়েনটি আগে পিক করবে। (যেমন ১০০ টাকা বানাতে আগে ৫০ বা ১০০ টাকার নোট খুঁজবে)।
</details>

---

**Q26. [Interview Check] In a Fractional Knapsack problem, if every item happens to have the exact same Value/Weight ratio, which item will the Greedy algorithm pick first?**
A) The one with the highest absolute Value
B) The one with the lowest absolute Weight
C) Picking any sequence will yield the same global optimal profit
D) The problem becomes unsolvable

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেহেতু প্রতি কেজির দাম (রেশিও) সবার সমান, তাই আপনি যে আইটেমই আগে নেন না কেন, প্রতি কেজিতে আপনি সমান প্রফিটই পাবেন। টোটাল প্রফিটে কোনো চেঞ্জ আসবে না।
</details>

---

**Q27. How does the optimal Greedy approach solve LeetCode's "Jump Game"?**
A) By calculating all possible jumps iteratively from left to right
B) By starting from the last index and moving backwards, updating the required "target" index if the current position can reach it
C) By strictly executing the largest possible jump at each step
D) By sorting the array in ascending order

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Jump Game এ পিছন থেকে (Last index) টার্গেট ধরে সামনের দিকে আসা একটি চমৎকার Greedy লজিক। যদি কারেন্ট ইনডেক্স থেকে টার্গেটে জাম্প করা যায়, তবে কারেন্ট ইনডেক্সটাই নতুন টার্গেট হয়ে যায়।
</details>

---

**Q28. In Kruskal’s Algorithm, which Data Structure is primarily utilized to efficiently enforce the rule "do not form cycles" when picking edges?**
A) Stack
B) Queue
C) Union-Find (Disjoint Set)
D) Hash Map

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Kruskal এ ছোট ছোট এজ পিক করার সময় দেখতে হয় তারা কোনো সাইকেল তৈরি করছে কি না। Union-Find প্রায় $O(1)$ টাইমে এটি ডিটেক্ট করতে পারে।
</details>

---

**Q29. Which mathematical technique is most commonly used in interviews or proofs to demonstrate the Correctness of a Greedy Algorithm?**
A) Mathematical Induction
B) Exchange Argument (showing that swapping the Greedy choice with any other choice yields an equal or worse result)
C) Proof by Contradiction
D) Both B and C are heavily utilized

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: ইন্টারভিউ বা প্রমাণের জন্য আমরা দেখাই যে, আমাদের Greedy চয়েসের বদলে অন্য কোনো চয়েস (Exchange) নিলে রেজাল্ট একই থাকবে বা খারাপ হবে। এটিই Exchange Argument বা Contradiction পদ্ধতি।
</details>

---

**Q30. Which of the following prominent graph algorithms does NOT employ a Greedy strategy?**
A) Bellman-Ford Algorithm
B) Dijkstra’s Algorithm
C) Kruskal’s Algorithm
D) Prim’s Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Bellman-Ford হলো একটি Dynamic Programming (DP) অ্যালগরিদম যা সব এজে $V-1$ বার রিল্যাক্সেশন করে। বাকি ৩টিই Greedy।
</details>

---

**Q31. Why does Dijkstra's Algorithm fail in the presence of negative weight edges?**
A) Because it fundamentally relies on a Queue
B) Because once a node is extracted and marked final (the Greedy choice), it never re-evaluates or updates that node even if a "longer" path with a negative drop is discovered later
C) Because it instantly triggers an infinite loop
D) It is syntactically restricted to positive numbers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Dijkstra যখন Priority Queue থেকে একটি নোড বের করে, সে ধরে নেয় এটাই তার মিনিমাম ডিস্টেন্স। কিন্তু নেগেটিভ এজ থাকলে অন্য লম্বা পথ ঘুরে এসেও ডিস্টেন্স কমে যেতে পারে, যা Dijkstra বুঝতে পারে না।
</details>

---

**Q32. Is "Kadane's Algorithm" (for Maximum Subarray Sum) technically a Greedy Algorithm?**
A) Yes, entirely
B) No, it is purely Dynamic Programming
C) It is widely regarded as a space-optimized Dynamic Programming approach that relies on a Greedy-like local decision (resetting sum to 0 if it drops below zero)
D) It is a Divide and Conquer algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Kadane's Algorithm কে DP এর স্পেস-অপ্টিমাইজড ভার্সন বলা হয়, তবে এর লজিকটি (কারেন্ট সাম নেগেটিভ হলে 0 করে দেওয়া) অনেকটা Greedy চয়েসের মতো কাজ করে।
</details>

---

**Q33. When building a Huffman Tree, if two candidate nodes happen to have the exact same frequency, which one should be merged first?**
A) The one that appears first alphabetically
B) It does not matter; picking either will still produce an optimal, valid Huffman Tree
C) The program will inherently crash
D) They cannot be merged at all

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফ্রিকোয়েন্সি সমান হলে যেকোনো দুটিকে মার্জ করলেই অপ্টিমাল Huffman Tree তৈরি হবে। টোটাল কম্প্রেশন সাইজে কোনো পার্থক্য হবে না।
</details>

---

**Q34. In the Fractional Knapsack problem, if you blindly sort items by descending Value alone (ignoring weights), what happens?**
A) The algorithm runs exponentially faster
B) You lose the guarantee of finding the Global Optimal result (maximum profit)
C) The problem instantly morphs into the 0/1 Knapsack problem
D) There is no change in behavior

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: শুধু দামি জিনিস নিলে সে ব্যাগের অনেক বেশি জায়গা খেয়ে ফেলতে পারে। আবার শুধু হালকা জিনিস নিলে প্রফিট কম আসতে পারে। তাই ব্যালান্স করার জন্য প্রতি কেজির দাম (রেশিও) টাই সবচেয়ে বেস্ট।
</details>

---

**Q35. The "Optimal Substructure" property is a core requirement shared by Greedy algorithms and which other major algorithmic paradigm?**
A) Backtracking
B) Divide and Conquer
C) Dynamic Programming
D) Branch and Bound

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Greedy এবং DP উভয়েই Optimal Substructure (বড় প্রবলেম ছোট প্রবলেমের ওপর নির্ভরশীল) প্রপার্টিটি ব্যবহার করে। তবে DP সব সাব-প্রবলেম সলভ করে, আর Greedy শুধু একটি (লোকাল বেস্ট) সাব-প্রবলেমে যায়।
</details>

---

**Q36. What is the optimal Greedy strategy for LeetCode's "Assign Cookies" (455) problem?**
A) Dynamic Programming
B) Sort both arrays, and assign the smallest possible cookie that satisfies the least demanding child
C) Perform Graph Search
D) Utilize Binary Search exclusively

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সবচেয়ে কম চাহিদাসম্পন্ন বাচ্চাকে সবচেয়ে ছোট যে কুকিটি দিয়ে খুশি করা যায়, সেটি দেওয়াই হলো Greedy চয়েস। এতে বড় কুকিগুলো বেশি চাহিদাসম্পন্ন বাচ্চাদের জন্য বেঁচে যায়।
</details>

---

**Q37. What is the most common computational bottleneck when implementing Greedy Algorithms?**
A) Recursion Depth limits
B) Sorting the input data
C) Hash Map Collisions
D) Tree traversals

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: বেশিরভাগ Greedy লজিক কাজ করানোর জন্য ডেটাকে একটি নির্দিষ্ট অর্ডারে সাজাতে হয়। এই সর্টিংয়ের জন্য $O(n \log n)$ সময় লাগে, যা সাধারণত পুরো অ্যালগরিদমের সবচেয়ে স্লো পার্ট।
</details>

---

**Q38. Can you reliably solve the "Longest Palindromic Subsequence" problem using a purely Greedy approach?**
A) Yes
B) No, it requires Dynamic Programming due to heavily overlapping subproblems
C) Yes, but only if the string is sorted first
D) Only via Backtracking

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: স্ট্রিং বা সাবসিকুয়েন্সে অনেকগুলো Overlapping Subproblem থাকে, যেখানে লোকাল চয়েস নিলে গ্লোবাল রেজাল্ট মিস হতে পারে। তাই এখানে Greedy ফেইল করে এবং DP লাগে।
</details>

---

**Q39. [Code Output] In Fractional Knapsack, if the provided bag capacity is exactly 0, what is the maximum profit obtained?**
A) `-1`
B) `0`
C) Infinity
D) An ArithmeticException occurs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ব্যাগে কোনো জায়গা না থাকলে কোনো আইটেমই ঢোকানো যাবে না, তাই প্রফিট হবে 0।
</details>

---

**Q40. [Conclusion] If you are stuck in an interview and unsure whether a problem requires a Greedy approach or Dynamic Programming, what is the best initial step?**
A) Immediately start writing a bottom-up DP table
B) Attempt to construct a small counter-example where taking the obvious local optimal choice leads to a worse global outcome
C) Just write a recursive function
D) Represent the problem as a graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Greedy কাজ করবে কি না তা চেক করার বেস্ট উপায় হলো এমন একটি টেস্ট কেস (Counter-example) চিন্তা করা যেখানে লোকাল বেস্ট নিলে লস হয়। যদি এমন উদাহরণ না পান, তবে Greedy দিয়ে ট্রাই করা উচিত।
</details>
