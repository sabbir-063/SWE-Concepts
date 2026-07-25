# 03. Graph Traversal: BFS & DFS (Practice MCQs)

এই ফাইলে BFS, DFS, তাদের Time/Space Complexity, Data Structures (Queue/Stack) এবং রিয়েল-ওয়ার্ল্ড অ্যাপ্লিকেশনের ওপর ৪০টি ইন-ডেপথ MCQ দেওয়া হলো।

---

**Q1. Breadth-First Search (BFS) অ্যালগরিদমে কোন ডেটা স্ট্রাকচার ব্যবহৃত হয়?**
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

**Q2. Depth-First Search (DFS) অ্যালগরিদমে কোন ডেটা স্ট্রাকচার ব্যবহৃত হয়?**
A) Stack (বা Call Stack)
B) Queue
C) Hash Map
D) Array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: DFS এ আমরা একটি পাথে যতটা সম্ভব গভীরে যাই এবং ডেড-এন্ড পেলে পিছে ফিরে আসি (Backtrack)। এই LIFO (Last In First Out) লজিকটি স্ট্যাক বা রিকার্সনের মাধ্যমে ইমপ্লিমেন্ট করা হয়।
</details>

---

**Q3. BFS এবং DFS উভয়ের Time Complexity কত? (যেখানে V = Vertices, E = Edges)**
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

**Q4. যদি গ্রাফটিকে Adjacency Matrix দিয়ে রিপ্রেজেন্ট করা থাকে, তবে BFS বা DFS এর Time Complexity কত হবে?**
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

**Q5. আনওয়েটেড (Unweighted) গ্রাফে সোর্স থেকে ডেস্টিনেশনের Shortest Path (সবচেয়ে ছোট রাস্তা) বের করতে কোনটি ব্যবহার করা হয়?**
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

**Q6. মেমোরি কনজাম্পশনের (Space Complexity) দিক থেকে, একটি অনেক চওড়া (Wide) গ্রাফে (যেখানে প্রতি লেভেলে প্রচুর নোড আছে) কোন অ্যালগরিদম বেশি স্পেস নেবে?**
A) DFS
B) BFS
C) দুটোই সমান স্পেস নেবে
D) কোনোটিই স্পেস নেবে না

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: BFS পুরো লেভেলটিকে Queue তে স্টোর করে রাখে। তাই গ্রাফ চওড়া হলে Queue অনেক বড় হয়ে যায় এবং প্রচুর মেমোরি নেয়।
</details>

---

**Q7. একটি অনেক গভীর (Deep) গ্রাফ বা ট্রিতে কোন অ্যালগরিদম বেশি মেমোরি নেবে বা StackOverflow ঘটাতে পারে?**
A) DFS
B) BFS
C) দুটোই সমান
D) Dijkstra

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: DFS গভীরে যাওয়ার সময় সব প্যারেন্ট নোডকে কল-স্ট্যাকে (Call Stack) রেখে যায়। গ্রাফ খুব গভীর (Deep) হলে স্ট্যাক সাইজ লিমিট ক্রস করে StackOverflow হতে পারে।
</details>

---

**Q8. একটি মেজ (Maze) বা গোলকধাঁধায় ঢোকার পর বের হওয়ার রাস্তা খোঁজার জন্য কোন লজিকটি সবচেয়ে স্বাভাবিক?**
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

**Q9. টরেন্ট (Torrent) বা সোশ্যাল নেটওয়ার্কে (যেমন Facebook/LinkedIn) আপনার ১-ডিগ্রি এবং ২-ডিগ্রি কানেকশনগুলো খুঁজে বের করার জন্য কোনটি বেস্ট?**
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

**Q10. সাইকেল ডিটেকশন (Cycle Detection) এর জন্য কোনটি ব্যবহার করা যেতে পারে?**
A) শুধুমাত্র DFS
B) শুধুমাত্র BFS
C) BFS এবং DFS দুটোই
D) কোনোটিই নয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Undirected বা Directed যেকোনো গ্রাফে সাইকেল ডিটেক্ট করতে BFS এবং DFS দুটোই ব্যবহার করা যায়। তবে কোড লেখা ও ব্যাকট্র্যাকিং ট্র্যাকিংয়ের সুবিধার জন্য DFS বেশি পপুলার।
</details>

---

**Q11. Web Crawlers (যেমন গুগল বট) সাধারণত ইন্টারনেট ইনডেক্স করার জন্য কোন ট্রাভার্সাল ফলো করে?**
A) DFS
B) BFS
C) Random Search
D) Binary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ক্রলারগুলো একটি পেজে ঢুকে আগে ওই পেজের সব লিংক (Neighbors) সংগ্রহ করে, তারপর এক লেভেল গভীরে যায়। এটি BFS লজিক। DFS করলে ক্রলার একটি লিংকের ভেতরে ঢুকতেই থাকবে এবং অন্য ওয়েবসাইট আর ইনডেক্স করতে পারবে না।
</details>

---

**Q12. "Topological Sorting" বের করার জন্য কোন অ্যালগরিদমটি ইন্টার্নালি ব্যবহৃত হয়?**
A) BFS (Kahn's Algorithm) এবং DFS দুটোই ব্যবহার করা যায়
B) শুধুমাত্র BFS
C) শুধুমাত্র Kruskal's
D) Bellman-Ford

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Topological Sort সাধারণত মডিফায়েড DFS (পোস্ট-অর্ডার ট্রাভার্সাল দিয়ে স্ট্যাকে রাখা) অথবা Kahn's Algorithm (In-degree গুনে BFS করা) দিয়ে করা হয়।
</details>

---

**Q13. গ্রাফ ট্রাভার্সালে `visited` অ্যারে (বা সেট) ব্যবহার করার মূল কারণ কী?**
A) স্পেস বাঁচানো
B) ইনফিনিট লুপ (Infinite Loop) থেকে রক্ষা পাওয়া
C) কোড ছোট করা
D) ট্রি-কে গ্রাফে কনভার্ট করা

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গ্রাফে সাইকেল বা লুপ থাকতে পারে ($A \to B \to A$)। `visited` চেক না করলে অ্যালগরিদম এই নোডগুলোর মাঝেই অনন্তকাল ঘুরতে থাকবে।
</details>

---

**Q14. একটি Tree (যেমন Binary Tree) তে ট্রাভার্স করার সময় কি `visited` অ্যারে লাগে?**
A) হ্যাঁ, সবসময় লাগে
B) না, লাগে না
C) শুধু ব্যালান্সড ট্রিতে লাগে
D) শুধু স্কিউড ট্রিতে লাগে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Tree এর সংজ্ঞাতেই বলা আছে যে এতে কোনো সাইকেল থাকে না এবং রুট থেকে যেকোনো নোডে যাওয়ার একটাই মাত্র ডিরেক্টেড রাস্তা থাকে। তাই লুপে পড়ার ভয় নেই এবং `visited` অ্যারে লাগে না।
</details>

---

**Q15. Iterative DFS এ নোড প্রসেসিং অর্ডারের ক্ষেত্রে Recursive DFS এর সাথে একটি পার্থক্য দেখা যেতে পারে। কেন?**
A) Iterative DFS ভুল কাজ করে
B) Recursive DFS বাম থেকে ডানে যায়, আর Iterative DFS এ স্ট্যাকে বাম থেকে ডানে পুশ করলে পপ হয় ডান দিক থেকে আগে (LIFO)
C) Iterative DFS এ Queue ব্যবহার করা হয়
D) Iterative DFS শর্টেস্ট পাথ দেয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: স্ট্যাকে যদি আপনি Left, Right চাইল্ড পুশ করেন, তবে Right চাইল্ড সবার ওপরে থাকবে এবং সেটি আগে প্রসেস হবে। তাই Recursive এর হুবহু সেম আউটপুট পেতে হলে স্ট্যাকে Right, Left অর্ডারে পুশ করতে হয়।
</details>

---

**Q16. Disconnected Graph এ সব নোড ভিজিট করার জন্য কী করতে হয়?**
A) BFS বা DFS কে রিকার্সিভলি কল করতে হয়
B) গ্রাফের সব নোডের ওপর একটি লুপ চালিয়ে চেক করতে হয় `visited[i] == false` কি না
C) এটি সম্ভব নয়
D) গ্রাফটিকে গাছে (Tree) কনভার্ট করতে হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডিসকানেক্টেড গ্রাফে এক জায়গা থেকে শুরু করলে পুরো গ্রাফ কাভার হয় না। তাই একটি `for` লুপ চালিয়ে সব আনভিজিটেড নোড থেকে নতুন করে ট্রাভার্সাল শুরু করতে হয়।
</details>

---

**Q17. গ্রাফে "Connected Components" (কতগুলো আলাদা আলাদা অংশ আছে) বের করতে BFS/DFS কতবার নতুন করে (For loop থেকে) কল করা হয়, সেটাই তার উত্তর। এটি কি সত্য?**
A) হ্যাঁ
B) না
C) শুধুমাত্র আনডিরেক্টেড গ্রাফের জন্য সত্য
D) শুধুমাত্র ডিরেক্টেড গ্রাফের জন্য সত্য

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: আনডিরেক্টেড গ্রাফে (Undirected graph) লুপ থেকে যতবার আনভিজিটেড নোড পেয়ে BFS/DFS কল করা হয়, ঠিক ততগুলোই আলাদা Connected Component থাকে।
</details>

---

**Q18. [Code Output] একটি Queue তে আপনি `A, B, C` পুশ করলেন। এরপর পপ (`poll`) করলে কোন নোডটি সবার আগে বের হবে?**
A) C
B) B
C) A
D) র্যান্ডমলি একটি

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Queue First-In-First-Out (FIFO) ফলো করে। A আগে ঢুকেছে, তাই A আগে বের হবে।
</details>

---

**Q19. [Code Output] একটি Stack এ আপনি `A, B, C` পুশ করলেন। এরপর পপ (`pop`) করলে কোন নোডটি সবার আগে বের হবে?**
A) C
B) B
C) A
D) র্যান্ডমলি একটি

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Stack Last-In-First-Out (LIFO) ফলো করে। C সবার শেষে ঢুকেছে, তাই C সবার আগে বের হবে।
</details>

---

**Q20. "Bipartite Graph" (যে গ্রাফকে দুটি ভিন্ন রঙে রাঙানো যায় যাতে পাশাপাশি কোনো নোডের রঙ এক না হয়) চেক করতে কোনটি ব্যবহার করা যায়?**
A) শুধুমাত্র BFS
B) শুধুমাত্র DFS
C) BFS এবং DFS দুটোই
D) Dijkstra's Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Bipartite চেক করা মূলত গ্রাফ কালারিং (Graph Coloring) প্রবলেম। এটি BFS (লেভেল অনুযায়ী রঙ বদলানো) বা DFS (প্যারেন্টের বিপরীত রঙ চাইল্ডকে দেওয়া) দুটো দিয়েই করা যায়।
</details>

---

**Q21. Bi-directional BFS কখন ব্যবহার করা হয়?**
A) ট্রি ট্রাভার্স করতে
B) অনেক বড় গ্রাফে সোর্স এবং ডেস্টিনেশনের শর্টেস্ট পাথ খুব দ্রুত বের করতে
C) সাইকেল ডিটেক্ট করতে
D) গ্রাফ সর্ট করতে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সোর্স থেকে একটি BFS এবং ডেস্টিনেশন থেকে আরেকটি BFS চালালে তারা মাঝপথে মিট করে। এতে এক্সপ্লোর করার রেডিয়াস (Search Space) ড্রাস্টিক্যালি কমে যায়, যা নরমাল BFS এর চেয়ে বহুগুণ ফাস্ট।
</details>

---

**Q22. একটি Weighted Graph (যেখানে এজের বিভিন্ন ওয়েট বা দূরত্ব আছে) এ শর্টেস্ট পাথ বের করতে কি নরমাল BFS কাজ করবে?**
A) হ্যাঁ
B) না, এক্ষেত্রে Dijkstra's বা Bellman-Ford ব্যবহার করতে হবে
C) হ্যাঁ, যদি Queue এর বদলে Stack ব্যবহার করা হয়
D) হ্যাঁ, যদি গ্রাফটি ডিরেক্টেড হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নরমাল BFS ধরে নেয় সব এজের ওয়েট সমান (1)। তাই ওয়েটেড গ্রাফে এটি ভুল উত্তর দেবে। ওয়েটেড গ্রাফের জন্য Priority Queue দিয়ে Dijkstra করতে হয়।
</details>

---

**Q23. ডিরেক্টেড গ্রাফে (Directed Graph) সাইকেল ডিটেক্ট করার জন্য DFS এ `visited` অ্যারে ছাড়াও আরেকটি অ্যারে বা সেট লাগে। তার নাম কী?**
A) `recursionStack` (বা `inStack`) অ্যারে
B) `level` অ্যারে
C) `parent` অ্যারে
D) `distance` অ্যারে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: ডিরেক্টেড গ্রাফে একটি নোড আগে ভিজিট হওয়া মানেই সাইকেল নয় (যেমন $A \to B$ এবং $A \to C \to B$)। সাইকেল তখনই হবে যখন কারেন্ট পাথ বা কারেন্ট রিকার্সন কল-স্ট্যাকে ওই নোডটি আগে থেকেই থাকে। এজন্য `recursionStack` ট্র্যাক করতে হয়।
</details>

---

**Q24. আনডিরেক্টেড গ্রাফে (Undirected Graph) সাইকেল ডিটেক্ট করতে DFS চালানোর সময় কারেন্ট নোডের প্রতিবেশীদের মধ্যে কাকে ইগনোর (Ignore) করতে হয়?**
A) রুট নোডকে
B) প্যারেন্ট (Parent) নোডকে, যেখান থেকে সে এইমাত্র এসেছে
C) যেকোনো ভিজিটেড নোডকে
D) কোনোটিই নয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আনডিরেক্টেড গ্রাফে $A$ থেকে $B$ তে গেলে, $B$ এর প্রতিবেশী লিস্টে $A$ ও থাকবে। তাই $B$ থেকে আবার $A$ তে ফিরে গেলে সাইকেল বলবে, যা ভুল। তাই "প্যারেন্ট" কে সবসময় স্কিপ করতে হয়।
</details>

---

**Q25. একটি গ্রাফে 100 টি নোড এবং 99 টি এজ আছে এবং কোনো সাইকেল নেই। গ্রাফটি আসলে কী?**
A) একটি Tree
B) একটি Complete Graph
C) একটি Bipartite Graph
D) একটি Disconnected Graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: গ্রাফ থিওরি অনুযায়ী, যদি কোনো কানেক্টেড গ্রাফে $N$ টি নোড এবং ঠিক $N-1$ টি এজ থাকে এবং কোনো সাইকেল না থাকে, তবে সেটি নিশ্চিতভাবে একটি Tree।
</details>

---

**Q26. Flood Fill Algorithm (যেমন পেইন্ট বা ফটোশপে একটি রঙের এরিয়া ফিল করা) ইন্টার্নালি কোন লজিক ব্যবহার করে?**
A) BFS বা DFS
B) Binary Search
C) Hashing
D) Dijkstra

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: একটি পিক্সেল থেকে শুরু করে তার আশপাশের ৪টি বা ৮টি দিকে সেম রঙের পিক্সেলগুলোতে রঙ ছড়ানোর কাজটি (Spread) ডাইরেক্টলি BFS বা DFS দিয়ে করা হয়। (2D Grid Traversal)।
</details>

---

**Q27. 2D ম্যাট্রিক্স বা গ্রিড (Grid) ট্রাভার্সালের সময় `visited` অ্যারের বদলে স্পেস বাঁচানোর জন্য কী করা যেতে পারে?**
A) ম্যাট্রিক্সের ডেটা পরিবর্তন করে (যেমন 1 কে -1 বা অন্য কোনো স্পেশাল ভ্যালু করে দেওয়া) ভিজিটেড মার্ক করা
B) Queue ব্যবহার না করা
C) Stack ব্যবহার না করা
D) এটি সম্ভব নয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: একে "In-place modification" বলে। আলাদা `visited[][]` অ্যারে না নিয়ে মেইন গ্রিডেই যদি `grid[r][c] = -1` বা অন্য কিছু দিয়ে মার্ক করা হয়, তবে $O(N \times M)$ এক্সট্রা স্পেস বেঁচে যায়।
</details>

---

**Q28. "Knight's Tour" বা দাবার ঘোড়া সবচেয়ে কম কয় চালে একটি টার্গেট ঘরে পৌঁছাতে পারবে—এটি সলভ করার বেস্ট উপায় কী?**
A) DFS
B) BFS
C) Backtracking
D) DP

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু "সবচেয়ে কম চাল" বা Shortest Path চাওয়া হয়েছে আনওয়েটেড গ্রিডে, তাই এখানে BFS চালানোই বেস্ট লজিক।
</details>

---

**Q29. DFS এর স্পেস কমপ্লেক্সিটি $O(V)$ বলা হয়, কিন্তু আসলে এটি কিসের ওপর নির্ভর করে?**
A) গ্রাফের মোট এজের (Edges) ওপর
B) ট্রির বা গ্রাফের ম্যাক্সিমাম গভীরতা বা হাইটের (Maximum Depth/Height) ওপর
C) রুট নোডের ভ্যালুর ওপর
D) Queue এর সাইজের ওপর

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: DFS এর স্পেস মূলত রিকার্সন স্ট্যাকের গভীরতা। যদি গ্রাফটি স্কিউড (লম্বা লাইনের মতো) হয় তবে ডেপথ হবে $O(V)$। আর ব্যালান্সড হলে ডেপথ হবে $O(\log V)$।
</details>

---

**Q30. Tree এর "Pre-order Traversal" মূলত কোন অ্যালগরিদমের একটি রূপ?**
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

**Q31. Tree এর "Level-order Traversal" মূলত কোন অ্যালগরিদমের একটি রূপ?**
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

**Q32. BFS এ কোনো নোডকে `visited = true` কখন মার্ক করা সবচেয়ে ইফিশিয়েন্ট এবং বাগ-ফ্রি (Bug-free)?**
A) Queue থেকে `poll()` বা বের করার ঠিক পর পর
B) Queue তে `add()` বা ঢোকানোর ঠিক আগে বা ঢোকানোর সময়
C) লুপ শেষ হওয়ার পর
D) রুট নোডে যাওয়ার পর

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যদি আপনি Queue থেকে বের করার পর ভিজিটেড মার্ক করেন, তবে একই নোড একাধিকবার Queue তে ঢুকে মেমোরি ফুল করে দিতে পারে। তাই কোনো নোডকে Queue তে ঢোকানোর মুহূর্তেই `visited = true` মার্ক করে দিতে হয়।
</details>

---

**Q33. ডিরেক্টেড গ্রাফে "Strongly Connected Components (SCC)" বের করার জন্য Kosaraju's Algorithm কয়টি DFS ট্রাভার্সাল ব্যবহার করে?**
A) ১টি
B) ২টি
C) ৩টি
D) কোনোটিই নয়, এটি BFS ব্যবহার করে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Kosaraju তে দুটি DFS লাগে। প্রথমটি স্ট্যাক ফিল আপ করার জন্য (Topological order এর মতো), আর দ্বিতীয়টি Transposed (উল্টানো) গ্রাফে SCC প্রসেস করার জন্য।
</details>

---

**Q34. 0-1 BFS কী?**
A) এটি এমন একটি BFS যা শুধুমাত্র 0 এবং 1 প্রিন্ট করে
B) এটি এমন একটি গ্রাফের শর্টেস্ট পাথ বের করে যেখানে এজের ওয়েট শুধুমাত্র 0 অথবা 1 হতে পারে
C) এটি BFS এর একটি ফেইল্ড অ্যালগরিদম
D) এটি কোনো ডেটা স্ট্রাকচার ব্যবহার করে না

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 0-1 BFS এ একটি `Deque` (Double Ended Queue) ব্যবহার করা হয়। এজ ওয়েট 0 হলে নোডটি Deque এর সামনে (Front) যোগ হয়, আর 1 হলে পিছনে (Back) যোগ হয়। এতে Dijkstra ছাড়াই $O(V+E)$ তে শর্টেস্ট পাথ বের হয়।
</details>

---

**Q35. "Multi-source BFS" (একাধিক সোর্স থেকে একই সাথে BFS শুরু করা) কখন ব্যবহার করা হয়?**
A) যখন গ্রাফে কোনো রুট নেই
B) যখন একাধিক स्टार्टिंग পয়েন্ট থাকে এবং টার্গেটে পৌঁছানোর সবচেয়ে ফাস্ট পাথটি দরকার হয়
C) যখন সাইকেল ডিটেক্ট করতে হয়
D) যখন সর্ট করতে হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেমন "Rotten Oranges" (LeetCode 994) প্রবলেমে একাধিক পচা কমলা একসাথে অন্য কমলাগুলোকে পচাতে শুরু করে। তখন সবগুলো পচা কমলাকে (Multi-source) শুরুতে Queue তে ঢুকিয়ে একসাথে BFS চালাতে হয়।
</details>

---

**Q36. Iterative DFS এর ক্ষেত্রে স্ট্যাকে যদি আপনি প্রতিবেশীদের (Neighbors) 1, 2, 3 এই অর্ডারে পুশ করেন, তবে পপ (Pop) হওয়ার অর্ডার কী হবে?**
A) 1, 2, 3
B) 3, 2, 1
C) 2, 1, 3
D) র্যান্ডম

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Stack হলো LIFO (Last In First Out)। সবার শেষে 3 ঢুকেছে, তাই সবার আগে 3 বের হবে। এজন্য স্ট্যাকে ডেটা পুশ করার সময় রিভার্স অর্ডারে পুশ করতে হয় যাতে সোজা অর্ডারে বের হয়।
</details>

---

**Q37. একটি 2D Grid (M x N) এ গ্রাফ অ্যালগরিদম চালানোর সময় ম্যাক্সিমাম কয়টি প্রতিবেশী (Neighbors) থাকতে পারে (যদি ডায়াগোনাল বা কোনাকুনি না ধরা হয়)?**
A) ৮টি
B) ৪টি (উপরে, নিচে, বামে, ডানে)
C) ২টি
D) ৬টি

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 2D গ্রিডে সাধারণত `(r-1, c)`, `(r+1, c)`, `(r, c-1)` এবং `(r, c+1)` এই ৪টি ডিরেকশনকে প্রতিবেশী হিসেবে ধরা হয়।
</details>

---

**Q38. "A* Search" বা "A-Star" অ্যালগরিদম মূলত কোন অ্যালগরিদমের একটি আপগ্রেডেড ভার্সন?**
A) DFS
B) BFS
C) Dijkstra's Algorithm (Heuristic যোগ করে)
D) Kruskal's

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: A* Search শর্টেস্ট পাথ বের করার জন্য Dijkstra এর লজিক ব্যবহার করে, কিন্তু তার সাথে একটি Heuristic $h(n)$ যোগ করে টার্গেটের দিকে গাইড করে, যা একে অনেক ফাস্ট করে তোলে।
</details>

---

**Q39. BFS এ কোনো নোডের লেভেল (Level) বা ডিস্টেন্স ট্র্যাক করার সবচেয়ে সহজ উপায় কোনটি?**
A) স্ট্যাকের সাইজ গুনে
B) একটি `int[] distance` অ্যারে রাখা, যেখানে `distance[neighbor] = distance[current] + 1`
C) রিকার্সনের লেভেল গুনে
D) কোনো উপায় নেই

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সোর্সের ডিস্টেন্স 0। এরপর যে নোড থেকে তার প্রতিবেশী ভিজিট হবে, ওই প্রতিবেশীর ডিস্টেন্স হবে তার প্যারেন্টের ডিস্টেন্স + 1।
</details>

---

**Q40. [Conclusion] একটি আননোন (Unknown) বা অসীম (Infinite) গ্রাফে কোনো নির্দিষ্ট টার্গেট খুঁজছেন (যেটা খুব বেশি গভীরে নেই)। কোন অ্যালগরিদম ভালো?**
A) DFS
B) BFS
C) DFS ভালো কাজ করবে
D) দুটোই ফেইল করবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: অসীম গ্রাফে DFS চালালে সে একটি রং পাথে (Wrong path) অনন্তকাল চলতে থাকবে এবং টার্গেট কখনো খুঁজে পাবে না। কিন্তু BFS লেভেল বাই লেভেল খুঁজবে, তাই টার্গেট কাছে থাকলে সে গ্যারান্টিড খুঁজে পাবে।
</details>
