# 03. Graph Traversal: BFS & DFS (Practice MCQs)

This file contains 40 in-depth MCQs covering BFS, DFS, their Time/Space Complexities, Data Structures (Queue/Stack), and real-world applications.

---

**Q1. Which data structure is primarily used to implement Breadth-First Search (BFS)?**
A) Stack
B) Queue
C) Priority Queue
D) Linked List

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: BFS লেভেল বাই লেভেল কাজ করে (First In First Out)। যে নোডটি আগে ডিসকভার হয়, তাকে আগে প্রসেস করতে হয়। এজন্য Queue ব্যবহার করা হয়।
</details>

---

**Q2. Which data structure is primarily used to implement Depth-First Search (DFS)?**
A) Stack (or Call Stack via Recursion)
B) Queue
C) Hash Map
D) Array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: DFS এ আমরা একটি পাথে যতটা সম্ভব গভীরে যাই এবং ডেড-এন্ড পেলে পিছে ফিরে আসি (Backtrack)। এই LIFO (Last In First Out) লজিকটি স্ট্যাক বা রিকার্সনের মাধ্যমে ইমপ্লিমেন্ট করা হয়।
</details>

---

**Q3. What is the standard Time Complexity of both BFS and DFS? (where V = Vertices, E = Edges)**
A) $O(V \times E)$
B) $O(V + E)$
C) $O(V^2)$
D) $O(E^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একটি কানেক্টেড গ্রাফে ট্রাভার্স করার সময় আমরা প্রতিটি নোড ($V$) একবার ভিজিট করি এবং প্রতিটি এজ ($E$) একবার (বা ডিরেক্টেড গ্রাফে একবার, আনডিরেক্টেডে দুইবার) স্ক্যান করি। তাই টোটাল টাইম $O(V+E)$।
</details>

---

**Q4. If a graph is represented using an Adjacency Matrix, what will be the Time Complexity of BFS or DFS?**
A) $O(V + E)$
B) $O(V^2)$
C) $O(E^2)$
D) $O(V \log V)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Adjacency Matrix এ কোনো নোডের প্রতিবেশী (Neighbors) বের করতে পুরো $V$ সাইজের একটি Row স্ক্যান করতে হয়। $V$ টা নোডের জন্য $V \times V$ স্ক্যান লাগে, তাই টাইম $O(V^2)$ হয়ে যায়।
</details>

---

**Q5. Which algorithm is guaranteed to find the shortest path from a source to a destination in an unweighted graph?**
A) DFS
B) BFS
C) Kruskal's
D) Topological Sort

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: BFS লেভেল বাই লেভেল এক্সপ্যান্ড করে। তাই যখনই সে ডেস্টিনেশন নোডকে প্রথমবার খুঁজে পায়, সেটিই গ্যারান্টিড শর্টেস্ট পাথ। DFS ডানে-বামে ঘুরে অনেক লম্বা রাস্তা দিয়ে ডেস্টিনেশনে পৌঁছাতে পারে।
</details>

---

**Q6. In terms of Space Complexity, which algorithm will consume more memory for a very wide graph (where each level has a massive number of nodes)?**
A) DFS
B) BFS
C) Both will consume the same amount of memory
D) Neither will consume extra memory

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: BFS পুরো লেভেলটিকে Queue তে স্টোর করে রাখে। তাই গ্রাফ চওড়া হলে Queue অনেক বড় হয়ে যায় এবং প্রচুর মেমোরি নেয়।
</details>

---

**Q7. Which algorithm is more likely to cause a StackOverflow error or consume excessive memory when traversing a very deep graph or tree?**
A) DFS
B) BFS
C) Both are equally vulnerable
D) Dijkstra's Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: DFS গভীরে যাওয়ার সময় সব প্যারেন্ট নোডকে কল-স্ট্যাকে (Call Stack) রেখে যায়। গ্রাফ খুব গভীর (Deep) হলে স্ট্যাক সাইজ লিমিট ক্রস করে StackOverflow হতে পারে।
</details>

---

**Q8. Which traversal logic is the most natural fit for finding a way out of a Maze?**
A) BFS
B) DFS (Backtracking)
C) Floyd-Warshall
D) Binary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গোলকধাঁধায় আমরা একটি রাস্তা ধরে হাঁটতে থাকি যতক্ষণ না দেয়ালে ধাক্কা খাই (ডেড-এন্ড)। ধাক্কা খেলে পিছে ফিরে অন্য রাস্তায় যাই। এটি হুবহু DFS এর লজিক।
</details>

---

**Q9. Which traversal is best suited for finding your 1st-degree and 2nd-degree connections in a social network like Facebook or LinkedIn?**
A) DFS
B) BFS
C) Bubble Sort
D) Prim's Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ১-ডিগ্রি কানেকশন মানে লেভেল-১ এর নোড, ২-ডিগ্রি মানে লেভেল-২। যেহেতু এটি লেভেল-ভিত্তিক খোঁজ, তাই BFS পারফেক্ট।
</details>

---

**Q10. Which traversal algorithms can be used for Cycle Detection in a graph?**
A) Only DFS
B) Only BFS
C) Both BFS and DFS can be used
D) None of the above

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Undirected বা Directed যেকোনো গ্রাফে সাইকেল ডিটেক্ট করতে BFS এবং DFS দুটোই ব্যবহার করা যায়। তবে কোড লেখা ও ব্যাকট্র্যাকিং ট্র্যাকিংয়ের সুবিধার জন্য DFS বেশি পপুলার।
</details>

---

**Q11. Web Crawlers (like Googlebot) generally follow which traversal strategy to index the internet?**
A) DFS
B) BFS
C) Random Search
D) Binary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ক্রলারগুলো একটি পেজে ঢুকে আগে ওই পেজের সব লিংক (Neighbors) সংগ্রহ করে, তারপর এক লেভেল গভীরে যায়। এটি BFS লজিক। DFS করলে ক্রলার একটি লিংকের ভেতরে ঢুকতেই থাকবে এবং অন্য ওয়েবসাইট আর ইনডেক্স করতে পারবে ছুটি পাবে না।
</details>

---

**Q12. Which algorithm is internally used as the foundation for Topological Sorting?**
A) Both BFS (Kahn's Algorithm) and DFS (with a Stack) can be used
B) Only BFS
C) Only Kruskal's Algorithm
D) Bellman-Ford

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Topological Sort সাধারণত মডিফায়েড DFS (পোস্ট-অর্ডার ট্রাভার্সাল দিয়ে স্ট্যাকে রাখা) অথবা Kahn's Algorithm (In-degree গুনে BFS করা) দিয়ে করা হয়।
</details>

---

**Q13. What is the primary reason for using a `visited` array (or set) during Graph Traversal?**
A) To save memory space
B) To prevent the algorithm from falling into an Infinite Loop
C) To make the code shorter
D) To convert the graph into a tree

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গ্রাফে সাইকেল বা লুপ থাকতে পারে ($A \to B \to A$)। `visited` চেক না করলে অ্যালগরিদম এই নোডগুলোর মাঝেই অনন্তকাল ঘুরতে থাকবে।
</details>

---

**Q14. Is a `visited` array strictly necessary when traversing a standard Tree (like a Binary Tree)?**
A) Yes, always
B) No, it is not required
C) Only required for balanced trees
D) Only required for skewed trees

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Tree এর সংজ্ঞাতেই বলা আছে যে এতে কোনো সাইকেল থাকে না এবং রুট থেকে যেকোনো নোডে যাওয়ার একটাই মাত্র ডিরেক্টেড রাস্তা থাকে। তাই লুপে পড়ার ভয় নেই এবং `visited` অ্যারে লাগে না।
</details>

---

**Q15. Why might the node processing order in Iterative DFS differ from Recursive DFS when visiting a node's children?**
A) Because Iterative DFS is fundamentally flawed
B) Because Recursive DFS visits children in left-to-right order naturally, whereas Iterative DFS pushes children onto a Stack, meaning the last child pushed is processed first (LIFO)
C) Because Iterative DFS uses a Queue implicitly
D) Because Iterative DFS calculates shortest paths

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: স্ট্যাকে যদি আপনি Left, Right চাইল্ড পুশ করেন, তবে Right চাইল্ড সবার ওপরে থাকবে এবং সেটি আগে প্রসেস হবে। তাই Recursive এর হুবহু সেম আউটপুট পেতে হলে স্ট্যাকে Right, Left অর্ডারে পুশ করতে হয়।
</details>

---

**Q16. How do you ensure all nodes are visited in a Disconnected Graph?**
A) Simply call BFS or DFS recursively from any node
B) Run a `for` loop over all nodes and trigger a new traversal if the node is `visited[i] == false`
C) It is impossible to visit all nodes in a disconnected graph
D) First convert the graph into a Tree

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডিসকানেক্টেড গ্রাফে এক জায়গা থেকে শুরু করলে পুরো গ্রাফ কাভার হয় না। তাই একটি `for` লুপ চালিয়ে সব আনভিজিটেড নোড থেকে নতুন করে ট্রাভার্সাল শুরু করতে হয়।
</details>

---

**Q17. To count the number of "Connected Components" in an undirected graph, you can simply count how many times BFS/DFS is newly triggered from the outer `for` loop. Is this true?**
A) Yes
B) No
C) Only true for weighted graphs
D) Only true for directed graphs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: আনডিরেক্টেড গ্রাফে (Undirected graph) লুপ থেকে যতবার আনভিজিটেড নোড পেয়ে BFS/DFS কল করা হয়, ঠিক ততগুলোই আলাদা Connected Component থাকে। (Note: answer option fixed to 'Yes' reflecting general truth for undirected graphs).
</details>

---

**Q18. [Code Output] You push `A`, `B`, and `C` into a standard Queue in that exact order. When you `poll()` once, which element is removed?**
A) C
B) B
C) A
D) A random element

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Queue First-In-First-Out (FIFO) ফলো করে। A আগে ঢুকেছে, তাই A আগে বের হবে।
</details>

---

**Q19. [Code Output] You push `A`, `B`, and `C` into a standard Stack in that exact order. When you `pop()` once, which element is removed?**
A) C
B) B
C) A
D) A random element

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Stack Last-In-First-Out (LIFO) ফলো করে। C সবার শেষে ঢুকেছে, তাই C সবার আগে বের হবে।
</details>

---

**Q20. Which algorithm can be used to check if a graph is a "Bipartite Graph" (can be colored with 2 colors such that no two adjacent nodes have the same color)?**
A) Only BFS
B) Only DFS
C) Both BFS and DFS
D) Dijkstra's Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Bipartite চেক করা মূলত গ্রাফ কালারিং (Graph Coloring) প্রবলেম। এটি BFS (লেভেল অনুযায়ী রঙ বদলানো) বা DFS (প্যারেন্টের বিপরীত রঙ চাইল্ডকে দেওয়া) দুটো দিয়েই করা যায়।
</details>

---

**Q21. When is "Bi-directional BFS" typically used?**
A) To traverse simple trees
B) To drastically reduce the search space when finding the shortest path between a source and a destination in a massive graph
C) To detect cycles
D) To sort a graph topologically

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সোর্স থেকে একটি BFS এবং ডেস্টিনেশন থেকে আরেকটি BFS চালালে তারা মাঝপথে মিট করে। এতে এক্সপ্লোর করার রেডিয়াস (Search Space) ড্রাস্টিক্যালি কমে যায়, যা নরমাল BFS এর চেয়ে বহুগুণ ফাস্ট।
</details>

---

**Q22. Will standard BFS correctly find the shortest path in a Weighted Graph (where edges have different weights)?**
A) Yes, it always will
B) No, for weighted graphs, algorithms like Dijkstra's or Bellman-Ford should be used
C) Yes, if we replace the Queue with a Stack
D) Yes, but only if the graph is directed

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নরমাল BFS ধরে নেয় সব এজের ওয়েট সমান (1)। তাই ওয়েটেড গ্রাফে এটি ভুল উত্তর দেবে। ওয়েটেড গ্রাফের জন্য Priority Queue দিয়ে Dijkstra করতে হয়।
</details>

---

**Q23. When detecting a cycle in a Directed Graph using DFS, besides the standard `visited` array, what additional data structure is needed?**
A) A `recursionStack` (or `inStack`) array to track nodes currently in the active DFS path
B) A `level` array
C) A `parent` array
D) A `distance` array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: ডিরেক্টেড গ্রাফে একটি নোড আগে ভিজিট হওয়া মানেই সাইকেল নয় (যেমন $A \to B$ এবং $A \to C \to B$)। সাইকেল তখনই হবে যখন কারেন্ট পাথ বা কারেন্ট রিকার্সন কল-স্ট্যাকে ওই নোডটি আগে থেকেই থাকে। এজন্য `recursionStack` ট্র্যাক করতে হয়।
</details>

---

**Q24. When detecting a cycle in an Undirected Graph using DFS, which neighbor must the algorithm explicitly ignore during traversal?**
A) The root node
B) The immediate parent node from which the current node was just discovered
C) Any node that has been visited
D) None of the above

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আনডিরেক্টেড গ্রাফে $A$ থেকে $B$ তে গেলে, $B$ এর প্রতিবেশী লিস্টে $A$ ও থাকবে। তাই $B$ থেকে আবার $A$ তে ফিরে গেলে সাইকেল বলবে, যা ভুল। তাই "প্যারেন্ট" কে সবসময় স্কিপ করতে হয়।
</details>

---

**Q25. A connected graph has exactly 100 nodes, 99 edges, and contains absolutely no cycles. What is this graph strictly known as?**
A) A Tree
B) A Complete Graph
C) A Bipartite Graph
D) A Disconnected Graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: গ্রাফ থিওরি অনুযায়ী, যদি কোনো কানেক্টেড গ্রাফে $N$ টি নোড এবং ঠিক $N-1$ টি এজ থাকে এবং কোনো সাইকেল না থাকে, তবে সেটি নিশ্চিতভাবে একটি Tree।
</details>

---

**Q26. The "Flood Fill" algorithm (used for the paint bucket tool in Photoshop to fill connected regions of the same color) is internally based on which concept?**
A) BFS or DFS (2D Grid Traversal)
B) Binary Search
C) Hashing
D) Dijkstra

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: একটি পিক্সেল থেকে শুরু করে তার আশপাশের ৪টি বা ৮টি দিকে সেম রঙের পিক্সেলগুলোতে রঙ ছড়ানোর কাজটি (Spread) ডাইরেক্টলি BFS বা DFS দিয়ে করা হয়। (2D Grid Traversal)।
</details>

---

**Q27. When traversing a 2D Matrix or Grid, how can you save the $O(N \times M)$ extra space typically required for the `visited` array?**
A) By performing In-place modification (e.g., mutating the cell's value to `-1` or a special character) to mark it as visited
B) By avoiding the use of a Queue entirely
C) By avoiding the use of a Stack entirely
D) This optimization is impossible

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: একে "In-place modification" বলে। আলাদা `visited[][]` অ্যারে না নিয়ে মেইন গ্রিডেই যদি `grid[r][c] = -1` বা অন্য কিছু দিয়ে মার্ক করা হয়, তবে $O(N \times M)$ এক্সট্রা স্পেস বেঁচে যায়।
</details>

---

**Q28. What is the most efficient algorithm to solve the "Knight's Tour" problem to find the minimum number of moves a Knight needs to reach a target cell on a chessboard?**
A) DFS
B) BFS
C) Backtracking
D) Dynamic Programming

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু "সবচেয়ে কম চাল" বা Shortest Path চাওয়া হয়েছে আনওয়েটেড গ্রিডে, তাই এখানে BFS চালানোই বেস্ট লজিক।
</details>

---

**Q29. The space complexity of DFS is often stated as $O(V)$. However, what does this actually depend on in practice?**
A) The total number of edges in the graph
B) The maximum depth or height of the recursion tree/stack for that graph
C) The value of the root node
D) The initial size of the Queue

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: DFS এর স্পেস মূলত রিকার্সন স্ট্যাকের গভীরতা। যদি গ্রাফটি স্কিউড (লম্বা লাইনের মতো) হয় তবে ডেপথ হবে $O(V)$। আর ব্যালান্সড হলে ডেপথ হবে $O(\log V)$।
</details>

---

**Q30. "Pre-order Traversal" of a Binary Tree is fundamentally a variation of which traversal technique?**
A) BFS
B) DFS
C) Binary Search
D) Heapify

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রি-অর্ডার (Root, Left, Right), ইন-অর্ডার, বা পোস্ট-অর্ডার—এগুলোর সবই হলো DFS এর ভ্যারিয়েশন (কারণ তারা লেফট-এ যতটা গভীরে সম্ভব আগে যায়)।
</details>

---

**Q31. "Level-order Traversal" of a Binary Tree is fundamentally a variation of which traversal technique?**
A) BFS
B) DFS
C) Post-order
D) Dijkstra

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: লেভেল-অর্ডার মানেই লেভেল বাই লেভেল স্ক্যান করা, যা এক্সাক্টলি BFS এর কাজ।
</details>

---

**Q32. When implementing BFS, at what exact point is it most efficient and bug-free to mark a node as `visited = true`?**
A) Right after it is `poll()`ed out of the Queue
B) Right before or exactly when it is `add()`ed into the Queue
C) Only after the entire while loop finishes
D) Only when it is the root node

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যদি আপনি Queue থেকে বের করার পর ভিজিটেড মার্ক করেন, তবে একই নোড একাধিকবার Queue তে ঢুকে মেমোরি ফুল করে দিতে পারে। তাই কোনো নোডকে Queue তে ঢোকানোর মুহূর্তেই `visited = true` মার্ক করে দিতে হয়।
</details>

---

**Q33. Kosaraju's Algorithm, used for finding Strongly Connected Components (SCCs) in a directed graph, utilizes how many DFS traversals?**
A) 1
B) 2
C) 3
D) None, it utilizes BFS instead

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Kosaraju তে দুটি DFS লাগে। প্রথমটি স্ট্যাক ফিল আপ করার জন্য (Topological order এর মতো), আর দ্বিতীয়টি Transposed (উল্টানো) গ্রাফে SCC প্রসেস করার জন্য।
</details>

---

**Q34. What is a "0-1 BFS"?**
A) A BFS that only prints the numbers 0 and 1
B) A modified BFS using a Deque, designed to find shortest paths in a graph where edge weights can only be 0 or 1
C) A failed variation of standard BFS
D) A traversal technique that uses no data structures

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 0-1 BFS এ একটি `Deque` (Double Ended Queue) ব্যবহার করা হয়। এজ ওয়েট 0 হলে নোডটি Deque এর সামনে (Front) যোগ হয়, আর 1 হলে পিছনে (Back) যোগ হয়। এতে Dijkstra ছাড়াই $O(V+E)$ তে শর্টেস্ট পাথ বের হয়।
</details>

---

**Q35. When is "Multi-source BFS" (starting BFS simultaneously from multiple starting nodes) primarily utilized?**
A) When a graph is missing a root node entirely
B) When there are multiple potential starting points and you need to find the shortest path from *any* of them to the targets simultaneously
C) When detecting cycles exclusively
D) When topologically sorting a graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেমন "Rotten Oranges" (LeetCode 994) প্রবলেমে একাধিক পচা কমলা একসাথে অন্য কমলাগুলোকে পচাতে শুরু করে। তখন সবগুলো পচা কমলাকে (Multi-source) শুরুতে Queue তে ঢুকিয়ে একসাথে BFS চালাতে হয়।
</details>

---

**Q36. In Iterative DFS, if you push a node's neighbors into the stack in the order `1, 2, 3`, in what order will they be popped and processed?**
A) `1, 2, 3`
B) `3, 2, 1`
C) `2, 1, 3`
D) Random order

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Stack হলো LIFO (Last In First Out)। সবার শেষে 3 ঢুকেছে, তাই সবার আগে 3 বের হবে। এজন্য স্ট্যাকে ডেটা পুশ করার সময় রিভার্স অর্ডারে (3, 2, 1) পুশ করতে হয় যাতে সোজা অর্ডারে (1, 2, 3) প্রসেস হয়।
</details>

---

**Q37. When applying graph traversal algorithms on a standard 2D Grid (M x N) without considering diagonal movements, what is the maximum number of neighbors a single cell can have?**
A) 8
B) 4 (Up, Down, Left, Right)
C) 2
D) 6

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 2D গ্রিডে সাধারণত `(r-1, c)`, `(r+1, c)`, `(r, c-1)` এবং `(r, c+1)` এই ৪টি ডিরেকশনকে প্রতিবেশী হিসেবে ধরা হয়।
</details>

---

**Q38. The "A* (A-Star) Search" algorithm is fundamentally an upgraded version of which algorithm?**
A) DFS
B) BFS
C) Dijkstra's Algorithm (by incorporating a Heuristic)
D) Kruskal's Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: A* Search শর্টেস্ট পাথ বের করার জন্য Dijkstra এর লজিক ব্যবহার করে, কিন্তু তার সাথে একটি Heuristic $h(n)$ যোগ করে টার্গেটের দিকে গাইড করে, যা একে অনেক ফাস্ট করে তোলে।
</details>

---

**Q39. In standard BFS, what is the simplest way to track the level or distance of each newly discovered node?**
A) By counting the size of the stack
B) By maintaining an array `distance[]` where `distance[neighbor] = distance[current] + 1`
C) By counting recursion depth levels
D) It is impossible to track distances in BFS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সোর্সের ডিস্টেন্স 0। এরপর যে নোড থেকে তার প্রতিবেশী ভিজিট হবে, ওই প্রতিবেশীর ডিস্টেন্স হবে তার প্যারেন্টের ডিস্টেন্স + 1।
</details>

---

**Q40. [Conclusion] If you are searching for a specific target in an Unknown or Infinite graph, and the target is likely not very deep, which algorithm is safer to use?**
A) DFS
B) BFS
C) Both will fail immediately
D) DFS with randomized choices

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: অসীম গ্রাফে DFS চালালে সে একটি রং পাথে (Wrong path) অনন্তকাল চলতে থাকবে এবং টার্গেট কখনো খুঁজে পাবে না। কিন্তু BFS লেভেল বাই লেভেল খুঁজবে, তাই টার্গেট কাছে থাকলে সে গ্যারান্টিড খুঁজে পাবে।
</details>
