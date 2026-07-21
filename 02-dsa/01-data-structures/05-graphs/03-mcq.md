# 05. Graphs (Practice MCQs)

এই ফাইলে গ্রাফ ডেটা স্ট্রাকচারের ওপর ৪০টি MCQ দেওয়া হলো। এখানে বেসিক ডেফিনেশন থেকে শুরু করে ইন্টারভিউ-লেভেলের সিনেরিও এবং গটচা (Gotcha) টাইপ প্রশ্ন কভার করা হয়েছে।

---

**Q1. গ্রাফ (Graph) মূলত কী ধরনের ডেটা স্ট্রাকচার?**
A) Linear Data Structure
B) Non-linear Data Structure
C) Sequential Data Structure
D) Key-Value Data Structure

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Array বা Linked List এর মতো গ্রাফে ডেটা এক লাইনে থাকে না। এটি হায়ারার্কিকাল বা নেটওয়ার্ক মডেলে থাকে, তাই এটি Non-linear.
</details>

---

**Q2. নিচের কোনটি গ্রাফের একটি স্পেশাল ফর্ম, যেখানে কোনো সাইকেল (Cycle) থাকে না এবং একটি নির্দিষ্ট রুট (Root) থাকে?**
A) Queue
B) Linked List
C) Tree
D) Hash Table

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Tree মূলত একটি গ্রাফ, যার শর্ত হলো এতে কোনো সাইকেল বা লুপ থাকতে পারবে না এবং সব নোড কানেক্টেড হতে হবে।
</details>

---

**Q3. ফেসবুকের মিউচুয়াল ফ্রেন্ড নেটওয়ার্ক কোন ধরনের গ্রাফের উদাহরণ?**
A) Directed Graph
B) Undirected Graph
C) Weighted Graph
D) Bipartite Graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফেসবুকে কেউ ফ্রেন্ড হলে দুজনের দিক থেকেই ফ্রেন্ডশিপ হয়। তাই ডিরেকশন দুই দিকেই থাকে (Undirected)।
</details>

---

**Q4. টুইটার বা ইন্সটাগ্রামের ফলোয়ার নেটওয়ার্ক কোন ধরনের গ্রাফের উদাহরণ?**
A) Directed Graph
B) Undirected Graph
C) Weighted Graph
D) Tree

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: আপনি কাউকে ফলো করলেই সে আপনাকে ফলো করবে এমন কোনো কথা নেই। এটি একমুখী বা ডিরেক্টেড (Directed)।
</details>

---

**Q5. গুগল ম্যাপসে বিভিন্ন শহরের রাস্তার নেটওয়ার্ক স্টোর করতে কোন ধরনের গ্রাফ সবচেয়ে উপযুক্ত?**
A) Unweighted Directed Graph
B) Weighted Undirected Graph
C) Unweighted Undirected Graph
D) Dense Graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: শহরগুলোর মাঝে দূরত্ব বা সময় আছে (Weight), এবং রাস্তা সাধারণত দুই দিকেই যাতায়াত করা যায় (Undirected)।
</details>

---

**Q6. Adjacency Matrix এ একটি গ্রাফ ஸ்டোর করতে মেমোরি কমপ্লেক্সিটি (Space Complexity) কত হয়? (V = Vertices, E = Edges)**
A) $O(V)$
B) $O(E)$
C) $O(V + E)$
D) $O(V^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: Adjacency Matrix হলো একটি 2D Array ($V \times V$), তাই স্পেস লাগে $O(V^2)$।
</details>

---

**Q7. Adjacency List এ একটি গ্রাফ স্টোর করতে মেমোরি কমপ্লেক্সিটি কত হয়?**
A) $O(V^2)$
B) $O(V \times E)$
C) $O(V + E)$
D) $O(1)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: List-এ প্রতিটি ভার্টেক্স (V) এবং তাদের সাথে যুক্ত এজ (E) গুলো রাখা হয়, তাই স্পেস কমপ্লেক্সিটি $O(V + E)$।
</details>

---

**Q8. একটি Dense Graph (যেখানে প্রায় সব নোড সবার সাথে কানেক্টেড) রিপ্রেজেন্ট করার জন্য কোনটি বেশি এফিশিয়েন্ট?**
A) Adjacency List
B) Adjacency Matrix
C) Edge List
D) Array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Dense গ্রাফে প্রচুর এজ থাকে ($E \approx V^2$), তাই Adjacency Matrix ব্যবহার করলে স্পেসের খুব একটা ক্ষতি হয় না এবং খুব দ্রুত $O(1)$ টাইমে কানেকশন চেক করা যায়।
</details>

---

**Q9. রিয়েল ওয়ার্ল্ডের সোশ্যাল নেটওয়ার্ক (যেমন ফেসবুক) মূলত কোন ধরনের গ্রাফ?**
A) Dense Graph
B) Sparse Graph
C) Complete Graph
D) Bipartite Graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফেসবুকে বিলিয়ন ইউজার (V) থাকলেও একজন মানুষের ফ্রেন্ড হয়তো মাত্র ৫০০ জন। অর্থাৎ $E$ অনেক ছোট $V^2$ এর চেয়ে। একে Sparse Graph বলে, যার জন্য Adjacency List বেস্ট।
</details>

---

**Q10. Adjacency List ব্যবহার করলে নোড $U$ থেকে নোড $V$ তে কোনো এজ আছে কি না, তা চেক করার Time Complexity কত?**
A) $O(1)$
B) $O(V)$
C) $O(V^2)$
D) $O(E)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: $U$ এর লিষ্টে গিয়ে $V$ কে খুঁজতে হবে। Worst case-এ $U$ এর সাথে বাকি সব নোড যুক্ত থাকতে পারে, তাই খুঁজতে $O(V)$ সময় লাগবে (যদি LinkedList/Array হয়)। HashSet ব্যবহার করলে $O(1)$ করা যায়।
</details>

---

**Q11. Adjacency Matrix এ $U$ থেকে $V$ এর কানেকশন চেক করার Time Complexity কত?**
A) $O(1)$
B) $O(V)$
C) $O(\log V)$
D) $O(E)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: সরাসরি `matrix[U][V]` চেক করলেই হয়, যা একটি Array Lookup। তাই সময় লাগে $O(1)$।
</details>

---

**Q12. "Degree of a Vertex" বলতে কী বোঝায়? (Undirected গ্রাফের ক্ষেত্রে)**
A) নোডটির ভ্যালু
B) নোডটির সাথে যুক্ত এজের (Edges) সংখ্যা
C) রুট থেকে নোডটির দূরত্ব
D) গ্রাফের মোট এজ সংখ্যা

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কোনো নোডের সাথে যতগুলো সরাসরি কানেকশন থাকে, তাকে তার Degree বলে।
</details>

---

**Q13. Directed গ্রাফের ক্ষেত্রে In-degree মানে কী?**
A) যতগুলো এজ নোডটি থেকে বের হয়ে গেছে
B) যতগুলো এজ নোডটির দিকে এসেছে
C) মোট এজ সংখ্যা
D) নোডটির লেভেল

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যে এজগুলো নোডের দিকে ইনকামিং (Incoming), তাদের সংখ্যাই হলো In-degree।
</details>

---

**Q14. একটি Undirected গ্রাফে $V$ টি নোড থাকলে ম্যাক্সিমাম কয়টি এজ (Edge) থাকতে পারে? (Self-loop ছাড়া)**
A) $V$
B) $V - 1$
C) $V(V - 1) / 2$
D) $V^2$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: কমপ্লিট গ্রাফে প্রতিটি নোড বাকি $(V-1)$ নোডের সাথে যুক্ত থাকে। যেহেতু Undirected (অর্থাৎ A-B এবং B-A একই), তাই ২ দিয়ে ভাগ করতে হয়।
</details>

---

**Q15. Breadth-First Search (BFS) ইমপ্লিমেন্ট করতে ইন্টার্নালি কোন ডেটা স্ট্রাকচার ব্যবহৃত হয়?**
A) Stack
B) Queue
C) Priority Queue
D) Hash Table

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: BFS লেভেল বাই লেভেল ভিজিট করে (First In First Out), তাই Queue ব্যবহৃত হয়।
</details>

---

**Q16. Depth-First Search (DFS) ইমপ্লিমেন্ট করতে ইন্টার্নালি কোন ডেটা স্ট্রাকচার ব্যবহৃত হয়?**
A) Queue
B) Stack (বা Call Stack via Recursion)
C) Linked List
D) BST

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: DFS কোনো পাথ ধরে গভীরে যায় এবং ব্যাকট্র্যাক করে (Last In First Out)। তাই Stack ব্যবহৃত হয়।
</details>

---

**Q17. একটি Unweighted গ্রাফে সোর্স (Source) নোড থেকে অন্য কোনো নোডের সবচেয়ে ছোট রাস্তা (Shortest Path) বের করতে কোন অ্যালগরিদম ব্যবহৃত হয়?**
A) DFS
B) BFS
C) Bubble Sort
D) Binary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Unweighted গ্রাফে BFS লেভেল বাই লেভেল এগোয়, তাই যে নোডটি আগে ভিজিট হবে, সেটিই সবচেয়ে কম দূরত্বের হবে।
</details>

---

**Q18. DFS (Depth First Search) সাধারণত কোন কাজে বেশি ব্যবহৃত হয়?**
A) Shortest Path বের করতে
B) Maze solving বা Backtracking প্রবলেম সলভ করতে
C) ডেটা সর্ট করতে
D) গ্রাফের ম্যাক্সিমাম ভ্যালু খুঁজতে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গোলকধাঁধা (Maze) বা পাজল সলভ করার সময় আমরা একটি রাস্তা ধরে শেষ পর্যন্ত যাই, না পারলে ফিরে আসি। এটি DFS এর ক্লাসিক ইউজ কেস।
</details>

---

**Q19. গ্রাফ ট্রাভার্সালে (BFS/DFS) `visited` অ্যারে বা সেট কেন ব্যবহার করা হয়?**
A) মেমোরি কমানোর জন্য
B) শর্টেস্ট পাথ প্রিন্ট করার জন্য
C) সাইকেল বা লুপে আটকে যাওয়া (Infinite Loop) ঠেকানোর জন্য
D) গ্রাফকে ট্রি তে রূপান্তর করার জন্য

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: গ্রাফে সাইকেল থাকতে পারে (A->B, B->C, C->A)। `visited` ট্র্যাক না রাখলে কোড সারা জীবন ঘুরতেই থাকবে।
</details>

---

**Q20. DAG (Directed Acyclic Graph) এর একটি ক্লাসিক রিয়েল-ওয়ার্ল্ড ইউজ কেস কোনটি?**
A) ফেসবুক ফ্রেন্ড নেটওয়ার্ক
B) টাস্ক ডিপেন্ডেন্সি বা কোর্স প্রিরিকুইজিট (Course Prerequisite)
C) শহরের রোড ম্যাপ
D) দাবা খেলার বোর্ড

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: টাস্ক A না হলে B করা যাবে না, B না হলে C করা যাবে না। এখানে ডিরেকশন আছে, কিন্তু সাইকেল থাকা অসম্ভব (সাইকেল থাকলে ডেডলক হয়ে যাবে)। এটি DAG এর ক্লাসিক উদাহরণ।
</details>

---

**Q21. [Scenario] আপনি একটি গ্রাফে BFS চালাচ্ছেন, কিন্তু দেখলেন কিছু নোড কোনোভাবেই ভিজিট হলো না। এর কারণ কী হতে পারে?**
A) গ্রাফটি একটি DAG
B) গ্রাফটি Weighted
C) গ্রাফটি Disconnected (অর্থাৎ ওই নোডগুলোর সাথে সোর্স নোডের কোনো রাস্তা নেই)
D) BFS এ Stack Overflow হয়েছে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: গ্রাফ যদি খণ্ডিত বা Disconnected হয়, তবে এক পার্ট থেকে BFS শুরু করলে অন্য পার্টে যাওয়া যায় না।
</details>

---

**Q22. Disconnected গ্রাফের সব নোড ভিজিট করতে হলে কী করতে হবে?**
A) DFS ব্যবহার করতে হবে, BFS কাজ করবে না
B) `visited` অ্যারে চেক করে লুপের মাধ্যমে আনভিজিটেড নোড থেকে বারবার BFS/DFS কল করতে হবে
C) গ্রাফটি Tree তে কনভার্ট করতে হবে
D) Disconnected গ্রাফ ট্রাভার্স করা যায় না

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একটি লুপ চালিয়ে প্রতিটি নোড চেক করতে হয় `!visited[i]` কি না। যদি হয়, তবে সেখান থেকে আবার ট্রাভার্সাল শুরু করতে হয়।
</details>

---

**Q23. Adjacency List ব্যবহার করে V নোড এবং E এজের একটি গ্রাফে BFS বা DFS এর Time Complexity কত?**
A) $O(V)$
B) $O(E)$
C) $O(V + E)$
D) $O(V^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: BFS/DFS এ প্রতিটি নোড (V) একবার ভিজিট হয় এবং প্রতিটি এজ (E) একবার চেক করা হয়। তাই মোট সময় $O(V + E)$ লাগে।
</details>

---

**Q24. Adjacency Matrix ব্যবহার করে গ্রাফ ট্রাভার্স (BFS/DFS) করলে Time Complexity কত হবে?**
A) $O(V)$
B) $O(V + E)$
C) $O(V^2)$
D) $O(E^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ম্যাট্রিক্সে কোনো নোডের প্রতিবেশী কে কে, তা বের করতে পুরো $V$ সাইজের রো (row) স্ক্যান করতে হয়। $V$ নোডের জন্য মোট $V \times V = V^2$ বার স্ক্যান করতে হয়।
</details>

---

**Q25. একটি গ্রাফে সাইকেল (Cycle) আছে কি না, তা বের করার জন্য নিচের কোন অ্যালগরিদমটি ব্যবহার করা যায়?**
A) Binary Search
B) DFS (Depth First Search)
C) Merge Sort
D) Two Pointers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: DFS বা BFS চালানোর সময় যদি এমন কোনো নোড পাওয়া যায় যা আগে থেকেই `visited` (এবং Undirected এর ক্ষেত্রে Parent নয়), তার মানে সেখানে একটি সাইকেল আছে।
</details>

---

**Q26. Complete Graph বলতে কী বোঝায়?**
A) যার কোনো সাইকেল নেই
B) যার প্রতিটি নোড একে অপরের সাথে সরাসরি যুক্ত (এজ দ্বারা কানেক্টেড)
C) যার সব এজ ওয়েটেড (Weighted)
D) যাকে ট্রি তে কনভার্ট করা যায়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Complete Graph এ সম্ভাব্য সর্বোচ্চ সংখ্যক এজ থাকে, অর্থাৎ যেকোনো দুটো নোড তুললে তাদের মাঝে একটি ডিরেক্ট এজ থাকবেই।
</details>

---

**Q27. একটি ট্রি (Tree) কি গ্রাফ হতে পারে?**
A) হ্যাঁ, ট্রি হলো একটি Connected Acyclic Graph
B) না, ট্রি এবং গ্রাফ সম্পূর্ণ আলাদা
C) হ্যাঁ, কিন্তু শুধু যদি ডিরেকশন থাকে
D) হ্যাঁ, কিন্তু তাতে সাইকেল থাকতে হবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Tree হলো গ্রাফেরই একটি স্পেশাল ভার্সন, যেখানে সব নোড কানেক্টেড থাকে এবং কোনো সাইকেল বা লুপ থাকে না।
</details>

---

**Q28. Bipartite Graph কাকে বলে?**
A) যে গ্রাফে মাত্র ২টি নোড থাকে
B) যে গ্রাফের নোডগুলোকে দুটি সেটে ভাগ করা যায়, এবং একই সেটের নোডগুলোর মধ্যে কোনো এজ থাকে না
C) যে গ্রাফে দুটি সাইকেল থাকে
D) যে গ্রাফে ২টি এজ থাকে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Bipartite গ্রাফকে ২ কালার দিয়ে রং করা যায় এমনভাবে যাতে পাশাপাশি কোনো নোডের রং এক না হয়।
</details>

---

**Q29. Topological Sorting কোন ধরনের গ্রাফের ওপর করা যায়?**
A) Undirected Graph
B) Directed Cyclic Graph
C) Directed Acyclic Graph (DAG)
D) Complete Graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Topological Sort এর জন্য গ্রাফে ডিরেকশন থাকতে হয় (ডিপেন্ডেন্সি বোঝাতে) এবং সাইকেল থাকা যাবে না (সাইকেল থাকলে কাজ কখনোই শেষ হবে না)।
</details>

---

**Q30. গ্রাফে "Isolated Vertex" বলতে কী বোঝায়?**
A) যার কোনো প্রতিবেশী (Neighbor/Edge) নেই (Degree 0)
B) যার ১টি প্রতিবেশী আছে (Degree 1)
C) যে নোডটি রুটে থাকে
D) যে নোড থেকে সাইকেল শুরু হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Isolated নোড সম্পূর্ণ একা থাকে, তার সাথে অন্য কোনো নোডের কানেকশন থাকে না।
</details>

---

**Q31. [Code Output] নিচের কোডটি দেখুন:**
```java
public void addEdge(int u, int v) {
    adj[u].add(v);
}
```
**এটি কোন ধরনের গ্রাফের ইমপ্লিমেন্টেশন?**
A) Undirected Graph
B) Directed Graph
C) Weighted Graph
D) Complete Graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এখানে শুধু `u` থেকে `v` তে এজ অ্যাড করা হয়েছে, কিন্তু `v` থেকে `u` তে করা হয়নি। তাই এটি একমুখী বা Directed Graph।
</details>

---

**Q32. [Tricky] একটি Tree তে $N$ নোড থাকলে তার এজ সংখ্যা ঠিক কত?**
A) $N$
B) $N+1$
C) $N-1$
D) $N^2$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Tree যেহেতু Acyclic এবং Connected, তাই রুট ছাড়া বাকি প্রতিটি নোডের ঠিক একটি প্যারেন্ট কানেকশন থাকে। তাই মোট এজ $N-1$ টি।
</details>

---

**Q33. Weighted Graph মেমোরিতে Adjacency List এ রাখতে হলে কী পরিবর্তন করতে হয়?**
A) লিস্টের বদলে স্ট্যাক ব্যবহার করতে হয়
B) `ArrayList<Integer>` এর জায়গায় `ArrayList<Node>` বা Pair(Destination, Weight) ব্যবহার করতে হয়
C) ম্যাট্রিক্স ছাড়া Weighted গ্রাফ রাখা যায় না
D) List-এ ওয়েট স্টোর করা যায় না

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: सिर्फ ডেস্টিনেশন নোড সেভ না করে তার সাথে এজ ওয়েট (Weight) সেভ করার জন্য একটি Object বা Pair/Tuple ব্যবহার করতে হয়।
</details>

---

**Q34. নিচের কোন অ্যালগরিদমটি Weighted Graph-এ Shortest Path বের করতে ব্যবহৃত হয়?**
A) BFS
B) DFS
C) Dijkstra's Algorithm
D) Kruskal's Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Unweighted গ্রাফে BFS দিয়ে শর্টেস্ট পাথ বের হয়, কিন্তু Weighted গ্রাফে ওয়েট হিসাব করার জন্য Dijkstra's বা Bellman-Ford অ্যালগরিদম লাগে।
</details>

---

**Q35. "Connected Components" বের করার জন্য কোনটি বেশি কার্যকর?**
A) DFS বা BFS
B) Binary Search
C) Merge Sort
D) Insertion Sort

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: একটি লুপের ভেতর থেকে DFS বা BFS চালালেই কতগুলো আলাদা আলাদা কানেক্টেড কম্পোনেন্ট আছে তা বের হয়ে যায়।
</details>

---

**Q36. [Scenario] একটি ওয়েব ক্রলার (Web Crawler) ইন্টারনেট থেকে পেজ কালেক্ট করছে। একটি পেজ থেকে লিংকে ক্লিক করে অন্য পেজে যায়। এটি কোন অ্যালগরিদমের মতো কাজ করে?**
A) BFS (Breadth-First Search)
B) Binary Search
C) Selection Sort
D) Heap Sort

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: ওয়েব ক্রলার সাধারণত BFS ফলো করে, অর্থাৎ একটি পেজের সব লিংক আগে কিউ-তে রাখে, তারপর লেভেল বাই লেভেল স্ক্যান করে।
</details>

---

**Q37. আপনি একটি Maze (গোলকধাঁধা) সলভ করার গেম বানাচ্ছেন। ডেড-এন্ডে পৌঁছালে ফিরে এসে অন্য রাস্তা চেক করতে হবে। কোন অ্যালগরিদম বেস্ট?**
A) BFS
B) DFS
C) Linear Search
D) Two Pointer

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: DFS স্ট্যাক বা রিকার্শন ব্যবহার করে, তাই কোনো রাস্তায় আটকে গেলে সে অটোমেটিক ব্যাকট্র্যাক (Backtrack) করে আগের পয়েন্টে চলে আসে।
</details>

---

**Q38. নিচের কোনটি গ্রাফ রিপ্রেজেন্টেশনের একটি মেথড?**
A) Edge List
B) Adjacency Matrix
C) Adjacency List
D) ওপরের সবগুলো

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: গ্রাফকে এই তিনভাবেই রিপ্রেজেন্ট করা যায়। Edge List এ শুধু এজের পেয়ারগুলো (u, v) একটি লিস্টে রাখা হয়।
</details>

---

**Q39. [Gotcha] একটি গ্রাফে BFS চালাতে গেলে `visited` অ্যারের সাইজ কত হতে হবে?**
A) এজের (Edges) সংখ্যার সমান
B) নোডের (Vertices) সংখ্যার সমান
C) গ্রাফের হাইটের সমান
D) $V \times E$ এর সমান

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রতিটি নোড ভিজিট হয়েছে কি না তা ট্র্যাক করতে হয়, তাই `visited` অ্যারের সাইজ মোট নোড বা ভার্টেক্স (V) এর সমান হয়।
</details>

---

**Q40. "Graph Coloring Problem" এ মূলত কী করা হয়?**
A) গ্রাফের এজগুলোর ওয়েট কমানো হয়
B) কোনো দুটি কানেক্টেড নোড যেন একই কালার না পায়, তা নিশ্চিত করে কালার অ্যাসাইন করা হয়
C) ম্যাট্রিক্সের শূন্যস্থানগুলো কালার করা হয়
D) শর্টেস্ট পাথ বের করা হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গ্রাফ কালারিংয়ের মূল শর্ত হলো Adjacent (প্রতিবেশী) নোডগুলোর কালার যেন ভিন্ন হয়। এটি সুডোকু সলভ বা শিডিউলিং প্রবলেমে কাজে লাগে।
</details>
