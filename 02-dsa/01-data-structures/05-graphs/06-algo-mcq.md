# 05. Graph Algorithms (Practice MCQs)

এই ফাইলে শুধুমাত্র অ্যাডভান্সড গ্রাফ অ্যালগরিদমগুলোর (Dijkstra, Bellman-Ford, Kruskal, Prim, Union-Find, Topological Sort ইত্যাদি) ওপর ৩০টি ইন-ডেপথ MCQ দেওয়া হলো।

---

**Q1. নিচের কোন অ্যালগরিদমটি গ্রাফে "Negative Weight Cycle" ডিটেক্ট করতে পারে?**
A) Dijkstra's Algorithm
B) Kruskal's Algorithm
C) Bellman-Ford Algorithm
D) Prim's Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Bellman-Ford অ্যালগরিদম $V-1$ বার সব এজ রিল্যাক্স করে। যদি $V$ তম বারেও কোনো এজ রিল্যাক্স হয় (অর্থাৎ পাথ আরও ছোট হয়), তার মানে সেখানে Negative Weight Cycle আছে।
</details>

---

**Q2. Dijkstra's Algorithm এ নেগেটিভ ওয়েট এজ (Negative Weight Edge) থাকলে কী সমস্যা হয়?**
A) এটি Compilation Error দেয়
B) এটি Infinite Loop এ পড়ে যেতে পারে বা ভুল শর্টেস্ট পাথ দিতে পারে
C) এটি স্বয়ংক্রিয়ভাবে নেগেটিভ এজকে পজিটিভ বানিয়ে নেয়
D) কোনো সমস্যা হয় না, ঠিকভাবেই কাজ করে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Dijkstra কাজ করে এই বিশ্বাসে যে, একবার কোনো নোডে পৌঁছে গেলে সেটিই তার শর্টেস্ট পাথ, ভবিষ্যতে আর কোনো ছোট পাথ পাওয়া যাবে না। নেগেটিভ এজ এই লজিকটি ভেঙে দেয়, তাই ভুল উত্তর আসতে পারে।
</details>

---

**Q3. All-Pairs Shortest Path (যেকোনো নোড থেকে যেকোনো নোড) বের করার জন্য সবচেয়ে সহজ (লজিক্যালি) অ্যালগরিদম কোনটি?**
A) DFS
B) Floyd-Warshall Algorithm
C) Bellman-Ford Algorithm
D) A* Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Floyd-Warshall এ মাত্র ৩টি Nested Loop থাকে ($O(V^3)$), যা দিয়ে গ্রাফের যেকোনো জোড়া নোডের শর্টেস্ট পাথ বের করা যায়।
</details>

---

**Q4. "Path Compression" এবং "Union by Rank" টেকনিক দুটো কোন অ্যালগরিদম বা ডেটা স্ট্রাকচারের সাথে সম্পর্কিত?**
A) Disjoint Set (Union-Find)
B) Dijkstra's Algorithm
C) DFS
D) Kruskal's Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Union-Find এর টাইম কমপ্লেক্সিটি প্রায় $O(1)$ এ নামিয়ে আনার জন্য এই দুটো অপটিমাইজেশন ব্যবহার করা হয়।
</details>

---

**Q5. Kruskal's Algorithm ব্যবহার করে MST (Minimum Spanning Tree) বের করতে ইন্টার্নালি কোন ডেটা স্ট্রাকচারটি সবচেয়ে বেশি কাজে লাগে?**
A) Stack
B) Queue
C) Union-Find (Disjoint Set)
D) Binary Search Tree

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Kruskal এ এজগুলোকে ছোট থেকে বড় সর্ট করা হয়। এরপর এজগুলো গ্রাফে যোগ করার সময় সাইকেল (Cycle) তৈরি হচ্ছে কি না তা চেক করার জন্য Union-Find বেস্ট।
</details>

---

**Q6. Dense Graph (যেখানে প্রচুর এজ থাকে) এর MST বের করার জন্য Kruskal এর চেয়ে কোন অ্যালগরিদমটি সাধারণত বেশি ফাস্ট কাজ করে?**
A) Bellman-Ford
B) Prim's Algorithm
C) Floyd-Warshall
D) DFS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Prim's Algorithm নোড-বেইজড (Priority Queue ব্যবহার করে), তাই যেখানে প্রচুর এজ (Dense Graph) সেখানে এটি Kruskal (যা এজ-বেইজড এবং সর্ট করতে হয়) এর চেয়ে ফাস্ট।
</details>

---

**Q7. Topological Sorting গ্রাফের কোন প্রপার্টির ওপর নির্ভর করে?**
A) গ্রাফটিকে Undirected হতে হবে
B) গ্রাফটিতে নেগেটিভ এজ থাকা যাবে না
C) গ্রাফটিকে Directed Acyclic Graph (DAG) হতে হবে
D) গ্রাফটিকে Bipartite হতে হবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Topological Sort এর জন্য গ্রাফে ডিরেকশন (ডিপেন্ডেন্সি বোঝাতে) থাকতে হয় এবং সাইকেল থাকা যাবে না।
</details>

---

**Q8. একটি কোর্স ম্যানেজমেন্ট সিস্টেমে "Course A না করে Course B করা যাবে না"—এই ধরনের প্রিরিকুইজিট (Prerequisite) রিলেশনশিপ সলভ করতে কোন অ্যালগরিদম ব্যবহার করবেন?**
A) Kruskal's
B) Topological Sort
C) Dijkstra's
D) Bellman-Ford

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডিপেন্ডেন্সি রেজোলিউশন বা কাজের সিকোয়েন্স বের করার জন্য Topological Sort ব্যবহার করা হয়।
</details>

---

**Q9. Kosaraju's Algorithm প্রধানত কী কাজে ব্যবহৃত হয়?**
A) Shortest Path বের করতে
B) Strongly Connected Components (SCC) বের করতে
C) Minimum Spanning Tree তৈরি করতে
D) Maximum Flow বের করতে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Kosaraju's Algorithm দুটি DFS (একটি অরিজিনাল গ্রাফে, আরেকটি Transposed বা উল্টানো গ্রাফে) ব্যবহার করে Directed Graph এর SCC বের করে।
</details>

---

**Q10. "A-Star (A*) Search" অ্যালগরিদমটি শর্টেস্ট পাথ বের করতে Dijkstra এর চেয়ে ফাস্ট কেন কাজ করে?**
A) এটি নেগেটিভ এজ ইগনোর করে
B) এটি Heuristic ফাংশন ব্যবহার করে অনুমান করে কোন দিকে গেলে ডেস্টিনেশন কাছে হবে
C) এটি গ্রাফের সব এজ আগে থেকে সর্ট করে রাখে
D) এটি Queue এর বদলে Stack ব্যবহার করে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Dijkstra ব্লাইন্ডলি চারদিকে খোঁজে, কিন্তু A* একটি Heuristic (যেমন: সোজা লাইনের দূরত্ব) ব্যবহার করে টার্গেটের দিকে বেশি ফোকাস করে, তাই দ্রুত রাস্তা খুঁজে পায়।
</details>

---

**Q11. $V$ ভার্টেক্স এবং $E$ এজ বিশিষ্ট একটি গ্রাফে Kruskal's Algorithm এর Time Complexity কত?**
A) $O(V^2)$
B) $O(V \log V)$
C) $O(E \log E)$ বা $O(E \log V)$
D) $O(V + E)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Kruskal এর মেইন কাজ হলো এজগুলোকে ওয়েট অনুযায়ী সর্ট করা। এজ সর্ট করতে $O(E \log E)$ সময় লাগে, যা পুরো অ্যালগরিদমের ডমিনেটিং ফ্যাক্টর।
</details>

---

**Q12. [Gotcha] আপনাকে একটি Unweighted Graph দেওয়া হলো এবং বলা হলো Source থেকে Destination এর শর্টেস্ট পাথ বের করতে। কোন অ্যালগরিদম সবচেয়ে অপটিমাল?**
A) Dijkstra
B) Bellman-Ford
C) Floyd-Warshall
D) BFS (Breadth-First Search)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: Unweighted গ্রাফে সব এজের ওয়েট সমান (বা 1)। এক্ষেত্রে BFS সবসময় লেভেল বাই লেভেল স্ক্যান করে, তাই এটি $O(V+E)$ টাইমে শর্টেস্ট পাথ দেয়। Dijkstra ব্যবহার করলে ওভারহেড বেশি হবে ($O(E \log V)$)।
</details>

---

**Q13. Network Routing Protocols (যেমন OSPF) এ সাধারণত শর্টেস্ট পাথ বের করতে কোন অ্যালগরিদম ব্যবহৃত হয়?**
A) DFS
B) Dijkstra's Algorithm
C) Kruskal's
D) Topological Sort

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রাউটারগুলোর মাঝে ডেটা প্যাকেট পাঠানোর জন্য সবচেয়ে ফাস্ট রুট (যেখানে লিংকের ডিলে বা ওয়েট পজিটিভ) বের করতে OSPF প্রোটোকল ইন্টার্নালি Dijkstra ব্যবহার করে।
</details>

---

**Q14. Topological Sort এ একটি বৈধ (Valid) সর্টেড অর্ডার পেতে হলে গ্রাফে সাইকেল থাকলে কী হবে?**
A) সাইকেল থাকা নোডগুলো শেষে থাকবে
B) এটি একটি Infinite Loop এ পড়বে
C) Topological Sort সম্ভব নয় (অ্যালগরিদম ফেইল করবে)
D) সাইকেলের একটি এজ ডিলিট হয়ে যাবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Topological Sort শুধুমাত্র DAG (Directed Acyclic Graph) এর জন্যই ডিফাইনড। সাইকেল থাকলে ডেডলক হয়ে যায়, তাই সর্ট করা সম্ভব নয়।
</details>

---

**Q15. Floyd-Warshall Algorithm এর স্পেস কমপ্লেক্সিটি (Space Complexity) কত?**
A) $O(V)$
B) $O(E)$
C) $O(V^2)$
D) $O(V^3)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Floyd-Warshall এ $V \times V$ সাইজের একটি 2D Matrix মেইনটেইন করতে হয় ডিস্টেন্স স্টোর করার জন্য, তাই স্পেস লাগে $O(V^2)$। (টাইম কমপ্লেক্সিটি $O(V^3)$)।
</details>

---

**Q16. Priority Queue ব্যবহার করে ইমপ্লিমেন্ট করা Dijkstra's Algorithm এর Time Complexity কত?**
A) $O(V^2)$
B) $O(V + E)$
C) $O(E \log V)$
D) $O(E^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: প্রতিটি এজের জন্য Priority Queue তে পুশ/পপ অপারেশন হতে পারে। তাই টাইম কমপ্লেক্সিটি $O(E \log V)$ হয়।
</details>

---

**Q17. নিচের কোনটি Minimum Spanning Tree (MST) এর একটি প্রপার্টি নয়?**
A) এটি একটি Connected Graph হবে
B) এতে ঠিক $V-1$ টি এজ থাকবে (যেখানে V = ভার্টেক্স)
C) এতে একটি সাইকেল (Cycle) থাকতে পারে
D) এর টোটাল এজ ওয়েট সবচেয়ে কম হবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: "Tree" ডেটা স্ট্রাকচারের সংজ্ঞাতেই বলা আছে যে এতে কোনো সাইকেল থাকতে পারবে না। তাই MST তেও সাইকেল থাকে না।
</details>

---

**Q18. [Scenario] একটি কারেন্সি এক্সচেঞ্জ মার্কেটে ট্রেড করে লাভ (Arbitrage) করা সম্ভব কি না, তা বের করার জন্য কোন কনসেপ্টটি কাজে লাগে?**
A) Topological Sort
B) Positive Weight Cycle
C) Negative Weight Cycle (via Bellman-Ford)
D) Minimum Spanning Tree

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: কারেন্সি রেটগুলোকে যদি Negative Logarithm এ কনভার্ট করে গ্রাফ বানানো হয়, তবে কারেন্সি এক্সচেঞ্জ করে প্রফিট করা মানে হলো একটি Negative Weight Cycle খুঁজে পাওয়া। এটি Bellman-Ford দিয়ে করা যায়।
</details>

---

**Q19. Kosaraju's Algorithm এর দ্বিতীয় ধাপে (Step 2) কী করা হয়?**
A) এজের ওয়েট নেগেটিভ করা হয়
B) গ্রাফের সব এজ উল্টে দেওয়া হয় (Transpose the Graph)
C) গ্রাফকে ট্রি-তে কনভার্ট করা হয়
D) সব নোডকে স্ট্যাকে পুশ করা হয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Kosaraju's Algorithm এর ৩টি মেইন ধাপ: ১. DFS করে স্ট্যাক ফিল করা, ২. গ্রাফ উল্টে দেওয়া (Transpose), ৩. স্ট্যাক থেকে পপ করে উল্টানো গ্রাফে আবার DFS চালানো।
</details>

---

**Q20. "Bridges" বা "Articulation Points" (যে নোড বা এজ কাটলে গ্রাফ দুই টুকরো হয়ে যায়) বের করার জন্য কোন অ্যালগরিদম ব্যবহৃত হয়?**
A) Tarjan's Algorithm (Modified DFS)
B) Kruskal's
C) Bellman-Ford
D) A* Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Tarjan's Algorithm (Discovery Time এবং Lowest Time কনসেপ্ট ব্যবহার করে) খুব ইফিশিয়েন্টলি $O(V+E)$ টাইমে নেটওয়ার্কের ক্রিটিকাল পয়েন্ট বা Bridge বের করতে পারে।
</details>

---

**Q21. [Code Output] Dijkstra অ্যালগরিদমে যদি একটি গ্রাফের এজ ওয়েটগুলো এমন হয়: A-B (5), A-C (2), B-C (-4)। সোর্স A হলে C এর ডিস্টেন্স কত রিটার্ন করতে পারে?**
A) 2
B) 1
C) -2
D) এটি গ্যারান্টি দেওয়া যায় না (ভুল উত্তর আসতে পারে)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: Dijkstra নেগেটিভ এজ হ্যান্ডেল করতে পারে না। এটি C এর ডিস্টেন্স 2 ফিক্স করে দেবে, কিন্তু বাস্তবে A -> B -> C এর ডিস্টেন্স 5 + (-4) = 1। তাই এটি ভুল উত্তর দেবে।
</details>

---

**Q22. Bellman-Ford Algorithm এ $V$ টি নোড থাকলে সব এজকে কতবার রিল্যাক্স (Relax) করতে হয়?**
A) $V$ বার
B) $V - 1$ বার
C) $E$ বার
D) $V^2$ বার

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একটি $V$ নোডের গ্রাফে শর্টেস্ট পাথে সর্বোচ্চ $V-1$ টি এজ থাকতে পারে। তাই $V-1$ বার সব এজ চেক করলেই শর্টেস্ট পাথ গ্যারান্টিড পাওয়া যায় (যদি নেগেটিভ সাইকেল না থাকে)।
</details>

---

**Q23. Kruskal's Algorithm এর সাথে Prim's Algorithm এর মূল পার্থক্য কী?**
A) Kruskal শুধু Directed গ্রাফে কাজ করে, Prim Undirected এ
B) Kruskal এজ-বেসড (এজ সর্ট করে), Prim নোড-বেসড (Priority Queue দিয়ে গ্রো করে)
C) Kruskal নেগেটিভ ওয়েট সাপোর্ট করে, Prim করে না
D) কোনো পার্থক্য নেই

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Kruskal ছোট এজগুলো সিলেক্ট করে (এমনকি তারা আলাদা আলাদা কম্পোনেন্টে থাকলেও) এবং পরে জয়েন করে। আর Prim একটি নির্দিষ্ট নোড থেকে শুরু করে আস্তে আস্তে কানেক্টেড ট্রি-টি বড় করে।
</details>

---

**Q24. [Tricky] একটি গ্রাফে যদি একাধিক এজের ওয়েট সমান হয়, তবে ওই গ্রাফের Minimum Spanning Tree (MST) এর ক্ষেত্রে কোনটি সত্য?**
A) MST বানানো সম্ভব নয়
B) গ্রাফের একাধিক ভিন্ন ভিন্ন MST থাকতে পারে (কিন্তু সবার টোটাল ওয়েট সমান হবে)
C) Kruskal এবং Prim আলাদা আলাদা ওয়েটের MST দেবে
D) ওয়েটগুলো নেগেটিভ হয়ে যাবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যদি এজ ওয়েট সেম হয়, তবে কোন এজটি আগে পিক করা হবে তার ওপর ভিত্তি করে ট্রির শেপ বা স্ট্রাকচার ভিন্ন হতে পারে, কিন্তু টোটাল কস্ট (Cost) সবসময় একই বা মিনিমাম থাকবে।
</details>

---

**Q25. Build System (যেমন NPM বা Maven) এ কোন প্যাকেজ আগে ডাউনলোড করতে হবে তা বের করার জন্য কোন গ্রাফ অ্যালগরিদম ব্যবহার করা হয়?**
A) Union-Find
B) Topological Sort
C) Floyd-Warshall
D) BFS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্যাকেজগুলোর মধ্যে ডিপেন্ডেন্সি থাকে (A এর জন্য B লাগে)। এটি একটি Directed Acyclic Graph (DAG)। Topological Sort এই ডিপেন্ডেন্সি সলভ করে একটি সঠিক অর্ডার বের করে দেয়।
</details>

---

**Q26. Union-Find ডেটা স্ট্রাকচারে "Path Compression" এর কাজ কী?**
A) ট্রি-এর হাইট ছোট করে দেওয়া যাতে পরের বার Find অপারেশন খুব দ্রুত হয়
B) গ্রাফের এজের ওয়েট কমানো
C) ডেটাকে জিপ (ZIP) করে মেমরি বাঁচানো
D) সাইকেল ডিটেক্ট করা

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Find করার সময় যে নোডগুলো ট্রাভার্স করা হয়, তাদের সবাইকে সরাসরি রুটের (Root) সাথে কানেক্ট করে দেওয়া হয়। ফলে পরবর্তীতে ওই নোডগুলোর প্যারেন্ট খুঁজতে $O(1)$ সময় লাগে।
</details>

---

**Q27. Dijkstra অ্যালগরিদমে নেগেটিভ সাইকেল থাকলে কী ঘটে?**
A) অ্যালগরিদম ঠিকঠাক কাজ করে
B) Priority Queue তে ইনফিনিট লুপ তৈরি হতে পারে, কারণ ডিস্টেন্স বারবার আপডেট হতে থাকবে
C) প্রথমবারেই নেগেটিভ সাইকেল ডিটেক্ট করে কোড থেমে যায়
D) এটি Bellman-Ford এ কল ট্রান্সফার করে দেয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নেগেটিভ সাইকেল থাকলে প্রতিবার ওই সাইকেলে ঘুরলে ডিস্টেন্স কমতে থাকবে এবং নতুন ভ্যালু Priority Queue তে অ্যাড হতে থাকবে। ফলে ইনফিনিট লুপ হবে।
</details>

---

**Q28. Heuristic ফাংশন নিচের কোন অ্যালগরিদমের মূল ভিত্তি?**
A) A* (A-Star) Search
B) Dijkstra's
C) DFS
D) Prim's Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: A* Search $f(n) = g(n) + h(n)$ ফর্মুলা ব্যবহার করে, যেখানে $h(n)$ হলো হিউরিস্টিক (Heuristic) বা টার্গেট পর্যন্ত আনুমানিক দূরত্ব।
</details>

---

**Q29. Undirected গ্রাফে Cycle Detection করার সবচেয়ে ইফিশিয়েন্ট উপায় কোনটি?**
A) Topological Sort
B) Union-Find (Disjoint Set)
C) Kruskal's
D) Bellman-Ford

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Undirected গ্রাফে যদি দুটি নোডের প্যারেন্ট (বা রুট) আগে থেকেই সেম থাকে এবং তাদের মধ্যে নতুন এজ দেওয়া হয়, তবে সাথে সাথেই সাইকেল ডিটেক্ট করা যায়। এটি Union-Find দিয়ে খুব সহজে করা যায়।
</details>

---

**Q30. Floyd-Warshall Algorithm কোন প্যারাডাইম বা টেকনিক ব্যবহার করে কাজ করে?**
A) Greedy Approach
B) Divide and Conquer
C) Dynamic Programming (DP)
D) Backtracking

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Floyd-Warshall ডাইনামিক প্রোগ্রামিং ব্যবহার করে। এটি ছোট সাব-প্রবলেম (যেমন শুধুমাত্র ১ নম্বর নোড ব্যবহার করে শর্টেস্ট পাথ, তারপর ১ ও ২ নম্বর নোড ব্যবহার করে) থেকে বড় প্রবলেম সলভ করে।
</details>
