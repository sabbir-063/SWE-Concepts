# 02. CAP Theorem (Practice MCQs)

This file contains 40 in-depth MCQs covering the CAP Theorem, PACELC Theorem, Eventual vs Strong Consistency, Network Partitions, and real-world database architectures.

---

**Q1. What does the acronym "CAP" stand for in the CAP Theorem?**
A) Concurrency, Availability, Partition Tolerance
B) Consistency, Availability, Partition Tolerance
C) Consistency, Atomicity, Performance
D) Capacity, Availability, Processing

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: CAP থিওরেমের ৩টি মূল প্রপার্টি হলো Consistency (সব নোডে সেম ডেটা), Availability (সিস্টেম সবসময় আপ থাকবে) এবং Partition Tolerance (নেটওয়ার্ক ফেইল করলেও সিস্টেম চলবে)।
</details>

---

**Q2. The CAP Theorem states that a distributed data store can simultaneously provide at most how many of its three guarantees?**
A) 1
B) 2
C) 3
D) 0

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Brewer's Theorem অনুযায়ী, ডিস্ট্রিবিউটেড সিস্টেমে এই ৩টি গ্যারান্টির মধ্যে আপনাকে যেকোনো ২টি বেছে নিতে হবে। ৩টি একসাথে পাওয়া গাণিতিকভাবে অসম্ভব।
</details>

---

**Q3. What does "Consistency" mean in the context of the CAP Theorem?**
A) All database nodes use the exact same hardware configuration
B) Every read request receives the most recent write (or an error) regardless of which node is queried
C) The database schema remains unchanged over time
D) The database never returns an error

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Consistency মানে হলো আপনি সিস্টেমের যে সার্ভার থেকেই ডেটা রিড করেন না কেন, আপনি সবসময় লেটেস্ট (Latest) ডেটাই পাবেন। পুরনো ডেটা দেখাবে না।
</details>

---

**Q4. How is "Consistency" in CAP different from "Consistency" in ACID (SQL)?**
A) They are exactly the same concept
B) ACID Consistency ensures data validity according to strict schema rules (e.g., constraints), while CAP Consistency ensures that all nodes in a distributed system see the same data at the same time
C) CAP Consistency relates to backup storage
D) ACID Consistency applies only to NoSQL databases

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ACID এর C মানে হলো ডাটাবেসের রুলস (যেমন Primary key, Not Null) ঠিক আছে কি না। আর CAP এর C মানে হলো সব সার্ভারের কাছে লেটেস্ট ডেটা সিঙ্ক করা আছে কি না।
</details>

---

**Q5. What does "Availability" mean in the context of the CAP Theorem?**
A) The database is free and open-source
B) Every non-failing node returns a valid response to a query in a reasonable amount of time, without a guarantee that it contains the most recent write
C) The system never crashes under heavy load
D) The data is always accurate

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Availability মানে হলো সিস্টেম ডাউন হবে না। ইউজার রিকোয়েস্ট করলে সে রেসপন্স দেবেই (হতে পারে ডেটাটা একটু পুরনো, তারপরও সে ডেটা দেবে)।
</details>

---

**Q6. What is a "Network Partition" in distributed systems?**
A) Dividing a hard drive into smaller sections
B) Sharding data across multiple servers
C) A communication failure or break in the network that causes some nodes in a cluster to be unable to communicate with other nodes
D) A firewall blocking all traffic

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: দুটি সার্ভারের মাঝখানের নেটওয়ার্ক ক্যাবল কাটা যাওয়া বা নেটওয়ার্ক ড্রপ হওয়াকেই Network Partition বলে।
</details>

---

**Q7. In a distributed system that spans across multiple geographical regions (e.g., AWS US-East and EU-West), is "Partition Tolerance (P)" optional?**
A) Yes, if you buy expensive routers
B) No, because network failures and packet drops are inevitable over long distances, making P a mandatory requirement
C) Yes, if you use a CA system
D) No, because P is only needed for SQL databases

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিয়েল-ওয়ার্ল্ডে ইন্টারনেটের তার বা রাউটার যেকোনো সময় নষ্ট হতে পারে (নেটওয়ার্ক ফেইল করা আমাদের হাতে নেই)। তাই ডিস্ট্রিবিউটেড সিস্টেমে P (Partition Tolerance) ম্যান্ডেটরি।
</details>

---

**Q8. Since Partition Tolerance (P) is unavoidable in distributed systems, the real choice a software architect must make during a network failure is between:**
A) Atomicity and Durability
B) Sharding and Replication
C) Consistency and Availability (CP vs AP)
D) Speed and Memory

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেহেতু P নিতেই হবে, তাই নেটওয়ার্ক কাটা গেলে আমাদের ডিসাইড করতে হয় যে আমরা কি সিস্টেম ডাউন করে দিয়ে ডেটার অ্যাকুরেসি (Consistency) বাঁচাবো, নাকি পুরনো ডেটা দেখিয়ে সিস্টেম আপ (Availability) রাখবো।
</details>

---

**Q9. Which database configuration perfectly represents a "CA" (Consistency + Availability) system?**
A) A global Cassandra cluster
B) A multi-region MongoDB cluster
C) A single-node SQL database (like a standalone MySQL server) that does not communicate across a network
D) Redis cluster

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: CA শুধু তখনি সম্ভব যখন আপনার কোনো নেটওয়ার্ক নেই, অর্থাৎ আপনার পুরো ডাটাবেস একটি সিঙ্গেল মেশিনে চলছে। নেটওয়ার্ক না থাকলে Partition (P) এর ভয় নেই।
</details>

---

**Q10. In a "CP" (Consistent and Partition Tolerant) system, what happens when a network partition occurs between two nodes, and a client requests data from a node that cannot reach the primary/master node?**
A) It returns the most recent cached data it has, even if it might be stale
B) It blocks the request and returns an Error (or timeout) because it cannot guarantee the data is the most recent
C) It creates a new master node immediately
D) It converts the data to JSON

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: CP সিস্টেম কখনো ভুল বা পুরনো ডেটা দেয় না। সে যখন দেখবে যে সে লেটেস্ট ডেটা সিঙ্ক করতে পারছে না, তখন সে রেসপন্স না দিয়ে ডিরেক্ট Error দিয়ে দেবে।
</details>

---

**Q11. MongoDB is traditionally categorized as which type of system under the CAP Theorem?**
A) AP
B) CA
C) CP
D) None of the above

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: মঙ্গোডিবি একটি Primary নোড দিয়ে সব রাইট (Write) কন্ট্রোল করে। যদি Primary ডাউন হয়ে যায়, তবে নতুন Primary তৈরি না হওয়া পর্যন্ত সিস্টেম রাইট অপারেশন অফ রাখে। তাই এটি CP সিস্টেম।
</details>

---

**Q12. In an "AP" (Available and Partition Tolerant) system, what happens during a network partition?**
A) The system shuts down to protect data integrity
B) Nodes continue to accept reads and writes independently, potentially leading to conflicting or stale data that must be resolved later (Eventual Consistency)
C) The system instantly becomes strongly consistent
D) The database switches to SQL mode

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: AP সিস্টেমে (যেমন ক্যাসান্দ্রা) নেটওয়ার্ক কাটা পড়লেও সব নোড যার যার মতো ক্লায়েন্টকে সার্ভ করতে থাকে। এতে পুরনো ডেটা সার্ভ হতে পারে, তবে সিস্টেম অন্তত ডাউন থাকে না।
</details>

---

**Q13. Apache Cassandra is traditionally categorized as which type of system?**
A) AP
B) CP
C) CA
D) ACID

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: ক্যাসান্দ্রার কোনো নির্দিষ্ট মাস্টার নোড নেই (Masterless)। যেকোনো নোড ডেটা রিড/রাইট করতে পারে। তাই এটি প্রচণ্ড লেভেলের Available (AP)।
</details>

---

**Q14. If you are building a social media feed where it is okay if a user sees a post 5 seconds later than another user, which architecture is best?**
A) CP (e.g., MongoDB with strict majorities)
B) AP (e.g., Cassandra) because Availability and speed are more critical than strict real-time Consistency
C) CA (Single node SQL)
D) Blockchain

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফেসবুকের নিউজফিড বা কমেন্ট যদি ২ সেকেন্ড পরে লোড হয়, তাতে কারো বিশাল কোনো ক্ষতি হবে না। কিন্তু ফেসবুক ডাউন থাকলে সমস্যা। তাই এসব ক্ষেত্রে Availability (AP) কে বেশি প্রায়োরিটি দেওয়া হয়।
</details>

---

**Q15. If you are building a banking ledger or trading platform where showing an incorrect balance could lead to massive financial loss, which architecture is required?**
A) AP (e.g., Cassandra)
B) CP (e.g., HBase, strongly configured MongoDB, or strongly consistent distributed SQL) because showing an error is infinitely better than showing a wrong balance
C) A completely Partitioned system
D) In-memory cache with no persistence

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফাইন্যান্সিয়াল অ্যাপে আমরা চাই ডেটা যেন 100% অ্যাকুরেট থাকে। দরকার হলে সিস্টেম ডাউন থাকুক, কিন্তু ভুল ব্যালান্স দেখানো যাবে না। তাই এখানে Consistency (CP) মাস্ট।
</details>

---

**Q16. What is "Eventual Consistency"?**
A) The guarantee that data will never be consistent
B) The guarantee that if no new updates are made, all replicas will eventually converge to the same value
C) The guarantee that all nodes are updated simultaneously
D) The process of deleting old events

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: AP সিস্টেমে ডেটা সাথে সাথে সিঙ্ক হয় না। তবে ব্যাকগ্রাউন্ডে তারা ডেটা আদান-প্রদান করতে থাকে এবং একসময় গিয়ে সবার কাছে লেটেস্ট ডেটা চলে আসে (Eventually consistent)।
</details>

---

**Q17. What is "Strong Consistency"?**
A) Returning data incredibly fast
B) Ensuring that any read operation immediately following a write operation will see that updated write, regardless of which node is queried
C) Encrypting the data with strong algorithms
D) Storing data on SSDs instead of HDDs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রাইট (Write) অপারেশন শেষ হওয়ার সাথে সাথেই যদি আপনি যেকোনো নোড থেকে ওই লেটেস্ট ডেটা রিড (Read) করতে পারেন, তবে তাকে Strong Consistency বলে।
</details>

---

**Q18. How does the "PACELC" theorem expand upon the CAP theorem?**
A) It proves CAP is wrong
B) It states that in the case of a Partition (P), one must choose between A and C. Else (E), when the system is running normally, one must choose between Latency (L) and Consistency (C).
C) It focuses purely on CPU architecture
D) It adds Security to the CAP theorem

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: CAP থিওরেম শুধু নেটওয়ার্ক ফেইল করলে কী হবে তা বলে। আর PACELC বলে, নেটওয়ার্ক ফেইল না করলেও (নরমাল টাইমে) আপনাকে স্পিড (Latency) এবং অ্যাকুরেসি (Consistency) এর মধ্যে ব্যালান্স করতে হবে।
</details>

---

**Q19. Under normal network conditions (no partition), if a database is configured to replicate data to all 5 nodes before returning a "Success" message to the client, what is the trade-off according to PACELC?**
A) High Latency for Strong Consistency
B) Low Latency for Low Consistency
C) It has no effect on latency
D) High Availability for Low Partition Tolerance

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: ৫টি নোডে ডেটা কপি হতে সময় লাগবে। আপনি যেহেতু 100% কনফার্ম (Strong Consistency) হওয়ার জন্য ওয়েট করছেন, তাই রেসপন্স পেতে দেরি হবে (High Latency)।
</details>

---

**Q20. Under normal network conditions, if a database returns "Success" the millisecond data hits the first node (and replicates in the background), what is the trade-off?**
A) High Latency for Strong Consistency
B) Low Latency for Eventual Consistency (Risk of data loss if that first node crashes before replicating)
C) Absolute Data Durability
D) High Partition Tolerance

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একটি নোডে সেভ হতেই সাকসেস মেসেজ দিলে স্পিড তো রকেটের মতো (Low Latency) হবে, কিন্তু অন্য নোডে কপি হওয়ার আগেই ওই নোডটি ক্র্যাশ করলে ডেটা হারিয়ে যাবে (Low Consistency)।
</details>

---

**Q21. What is the "Split-Brain" problem in distributed systems?**
A) When a developer writes code in two different languages
B) When a network partition causes a cluster to divide into two or more independent sub-clusters, each believing it is the primary and accepting writes, leading to massively conflicting data
C) When the CPU uses hyper-threading
D) When memory is allocated dynamically

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নেটওয়ার্ক কাটা পড়লে যদি ২ পাশের নোডগুলোই নিজেদেরকে 'বস' বা মাস্টার ভাবতে শুরু করে এবং ক্লায়েন্টের রিকোয়েস্ট অ্যাকসেপ্ট করে ডেটা মডিফাই করে, তখন ডেটাবেসে জগাখিচুড়ি লেগে যায়। একেই Split-Brain বলে।
</details>

---

**Q22. How is the Split-Brain problem generally prevented in distributed databases (e.g., MongoDB Replica Sets)?**
A) By using a minimum of 2 nodes
B) By requiring a "Quorum" (strict majority, usually `N/2 + 1`) of nodes to elect a Primary or accept a Write. The smaller isolated partition cannot achieve a quorum and steps down.
C) By restarting the servers hourly
D) By manually checking the cables

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Quorum (সংখ্যাগরিষ্ঠতা) হলো সমাধান। ৫টি নোড ২ ভাগ হলে একপাশে ৩টি এবং অন্যপাশে ২টি থাকবে। ৩টি নোড মেজরিটি পাবে এবং কাজ চালিয়ে যাবে, আর ২টি নোড কাজ করা বন্ধ করে দেবে।
</details>

---

**Q23. In a 5-node cluster, what is the strict majority (Quorum) required to make decisions or accept strong writes?**
A) 2
B) 3
C) 4
D) 5

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ফর্মুলা হলো `(Total/2) + 1`। তাই $5/2 = 2.5 \approx 2$ (পূর্ণসংখ্যা), এর সাথে ১ যোগ করলে ৩ হয়।
</details>

---

**Q24. Why is it heavily recommended to deploy an ODD number of nodes (e.g., 3, 5, 7) rather than an EVEN number (e.g., 2, 4) in CP distributed systems?**
A) Odd numbers use less electricity
B) Even numbers cannot be divided
C) An odd number prevents a "Tie" during a network partition (e.g., a 4-node cluster splitting exactly 2-2 means neither side can achieve a strict majority of 3, shutting down the entire system)
D) It is an aesthetic choice

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ৪টি নোড যদি ২-২ ভাগে ভাগ হয়ে যায়, তবে কেউই ৩ (Majority) পাবে না, ফলে পুরো সিস্টেম বসে যাবে। কিন্তু ৩ বা ৫টি নোড হলে এক সাইড সবসময় বেশি নোড পাবেই (Tie হবে না)।
</details>

---

**Q25. In MongoDB, what does the `writeConcern: { w: 1 }` configuration signify?**
A) Write to all nodes before returning success
B) Write to the primary node only, return success quickly (Lower consistency, higher speed/availability)
C) Wait exactly 1 second before writing
D) Delete 1 document

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `w: 1` মানে হলো শুধু ১টি নোডে (Primary) ডেটা রাইট করতে পারলেই ক্লায়েন্টকে সাকসেস মেসেজ দিয়ে দাও। এটি ফাস্ট, কিন্তু কিছুটা রিস্কি।
</details>

---

**Q26. In MongoDB, what does the `writeConcern: { w: "majority" }` configuration signify?**
A) Write to all nodes
B) The primary must wait for an acknowledgment from a strict majority of nodes before returning success to the client (Strong Consistency)
C) Write to the node that has the majority of RAM
D) Write blindly without checking

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `majority` মানে হলো ডেটা অর্ধেকের বেশি নোডে সফলভাবে কপি হওয়ার পরেই কেবল ক্লায়েন্টকে সাকসেস মেসেজ দেবে। এটি 100% সেফ।
</details>

---

**Q27. In Apache Cassandra, if a client reads data with `CONSISTENCY ALL`, what happens if even a single node in the cluster is offline?**
A) The query executes faster
B) The query returns stale data from the available nodes
C) The query fails entirely because the system cannot guarantee that all nodes agree
D) Cassandra boots up a backup node automatically

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: `ALL` মানে হলো সব নোডের কনফার্মেশন লাগবে। একটি নোড অফলাইন থাকলে যেহেতু সে কনফার্ম করতে পারবে না, তাই পুরো কুয়েরি ফেইল করবে। (Consistency বাড়াতে গিয়ে Availability কমে গেলো)।
</details>

---

**Q28. In Cassandra, setting both Read and Write consistency levels to `QUORUM` ensures what?**
A) Absolute failure
B) The fastest possible latency
C) Strong Consistency (because $Read\_Nodes + Write\_Nodes > Total\_Nodes$, forcing an overlap where the latest data is always read)
D) Eventual Consistency

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যদি ডেটা রাইট করার সময় মেজরিটি নোডে লেখা হয়, এবং রিড করার সময়ও মেজরিটি নোড থেকে চেক করা হয়, তবে গাণিতিকভাবে অন্তত ১টি নোড কমন (Overlap) পড়বেই যার কাছে লেটেস্ট ডেটা আছে। তাই এটি Strong Consistency দেয়।
</details>

---

**Q29. What is a "Master-Slave" (Primary-Replica) architecture?**
A) All nodes are equal and can accept writes
B) One specific node handles all Writes, while other nodes copy data from it and can handle Reads
C) Nodes do not communicate with each other
D) A deprecated SQL terminology for single servers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: MongoDB তে একটি Primary (Master) থাকে যেখানে ডেটা ইনপুট হয়। আর বাকি Secondary (Slave) নোডগুলো সেখান থেকে ডেটা কপি করে।
</details>

---

**Q30. What is a "Masterless" (Peer-to-Peer) architecture?**
A) There are no servers, only client devices
B) Every node in the cluster is identical and can process both read and write requests directly (e.g., Cassandra)
C) The database requires manual intervention to save data
D) An architecture used exclusively for offline apps

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Cassandra বা DynamoDB তে কোনো বস (Master) নেই। যেকোনো সার্ভারে রিকোয়েস্ট পাঠালেই সে প্রসেস করে নেবে। এটি হাইলি অ্যাভেইলেবল (AP)।
</details>

---

**Q31. [Scenario] You are implementing a Shopping Cart for an e-commerce site on Black Friday. Millions of users are adding items. If a network partition occurs, users should still be able to add items to their cart, even if the count is slightly delayed across servers. What is your choice?**
A) CP
B) AP
C) CA
D) None

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: শপিং কার্টে আইটেম অ্যাড করতে না পারলে কাস্টমার বিরক্ত হয়ে চলে যাবে (কোম্পানির লস)। তাই কার্টের জন্য Availability (AP) বেশি জরুরি।
</details>

---

**Q32. [Scenario] You are managing the Stock/Inventory of the same e-commerce site. Only 1 PlayStation 5 is left in stock. Two users try to buy it at the exact same millisecond from different network regions. What is your choice?**
A) AP (Sell it to both and apologize later)
B) CP (Ensure strict locks and consistency so only one person successfully buys it, throwing an error for the other)
C) CA
D) Eventually sell it to neither

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইনভেন্টরি বা স্টকের ক্ষেত্রে ভুল ডেটা দিলে এক বিশাল বিপত্তি ঘটবে (মাল নেই কিন্তু বিক্রি হয়ে গেছে)। তাই এখানে Consistency (CP) মাস্ট।
</details>

---

**Q33. Can a database dynamically switch between being CP and AP?**
A) No, it is hardcoded into the CPU architecture
B) In some modern databases (like CosmosDB or configurable Cassandra/MongoDB deployments), developers can tweak consistency levels per-query, sliding the scale between CP and AP based on immediate needs
C) Yes, but only during system reboot
D) Only SQL databases can do this

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আধুনিক ডাটাবেসগুলোতে এটি কুয়েরি লেভেলে কনফিগার করা যায়। আপনি চাইলে পেমেন্টের কুয়েরির সময় `majority` দিয়ে CP আচরণ পেতে পারেন, আবার লাইকের কুয়েরির সময় `w: 1` দিয়ে AP আচরণ পেতে পারেন।
</details>

---

**Q34. What is "Replication Lag"?**
A) The time it takes for a hard drive to spin up
B) The delay between a Write occurring on the Primary node and that same data being copied/reflected on the Replica nodes
C) The time it takes to boot the server
D) Network latency between the client and the frontend

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রাইমারি নোডে ডেটা সেভ হওয়ার পর সেকেন্ডারি নোডগুলোতে সেই ডেটা কপি হতে কয়েক মিলিসেকেন্ড বা সেকেন্ড সময় লাগে। এই গ্যাপটিকেই Replication Lag বলে।
</details>

---

**Q35. If a client reads from a Secondary node during a high "Replication Lag", what kind of data will they get?**
A) A 404 Error
B) Stale Data (Old data that has not yet been updated)
C) Future Data
D) Empty Data

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু সেকেন্ডারি নোডে এখনো আপডেট পৌঁছায়নি, তাই ক্লায়েন্ট ওই নোড থেকে পুরনো ডেটাই দেখতে পাবে (Stale Data)।
</details>

---

**Q36. What is the fundamental mechanism used by nodes in a distributed database to know if other nodes are alive or dead?**
A) Manual pinging by the sysadmin
B) Heartbeats (small periodic network signals/pings sent continuously between nodes)
C) Sending entire database dumps
D) They don't track this

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নোডগুলো একে অপরকে প্রতি সেকেন্ডে ছোট ছোট সিগন্যাল (Heartbeat) পাঠায়। কয়েক সেকেন্ড সিগন্যাল না পেলেই তারা ধরে নেয় যে ওই নোডটি ডাউন হয়ে গেছে বা নেটওয়ার্ক কাটা পড়েছে।
</details>

---

**Q37. How does the concept of "Microservices" interact with the CAP Theorem?**
A) Microservices violate CAP
B) Each microservice often manages its own database, allowing different services to choose CP or AP depending on their specific business requirements (e.g., Payment Service = CP, Notification Service = AP)
C) Microservices combine all databases into a CA system
D) Microservices only use SQL

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: মাইক্রোসার্ভিসের সবচেয়ে বড় সুবিধাই হলো, পেমেন্ট সার্ভিসের জন্য আমরা CP ডাটাবেস ইউজ করতে পারি, আবার নোটিফিকেশন সার্ভিসের জন্য AP ডাটাবেস ইউজ করতে পারি।
</details>

---

**Q38. Why is "Eventual Consistency" often acceptable for modern web scale applications (like YouTube view counts or Facebook likes)?**
A) Because it is impossible to count numbers accurately
B) Because the business impact of a user seeing 1,000 likes instead of 1,005 likes for a few seconds is practically zero, whereas keeping the app ultra-fast and available is highly profitable
C) Because users do not care about data
D) It is an unresolved bug

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ইউটিউবের ভিউ বা লাইক ১০০ টা কম-বেশি দেখালে দুনিয়া উল্টে যাবে না। কিন্তু ভিডিও লোড হতে দেরি হলে বা সাইট ডাউন থাকলে মানুষ বিরক্ত হবে। তাই এসব ক্ষেত্রে Availability কে কনসিস্টেন্সির চেয়ে অনেক বেশি দাম দেওয়া হয়।
</details>

---

**Q39. In the context of CAP, what does it mean when someone says "The network is reliable" is a fallacy?**
A) It means routers never break
B) It means assuming networks will never drop packets or disconnect is a dangerous misconception; distributed architectures MUST be designed expecting failures
C) It implies LAN is better than WAN
D) It refers to 5G speeds

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: "The network is reliable" হলো সফটওয়্যার ইঞ্জিনিয়ারিংয়ের অন্যতম বড় একটি ভুল ধারণা (Fallacy)। ক্যাবল কাটা যাবেই, রাউটার রিস্টার্ট হবেই—এটি মাথায় রেখেই সিস্টেম ডিজাইন করতে হয়।
</details>

---

**Q40. [Conclusion] If an interviewer asks: "Is MongoDB AP or CP?", what is the most accurate and nuanced engineering answer?**
A) It is strictly CA
B) It is 100% AP
C) By default, its replica-set architecture acts as a CP system (choosing consistency and shutting down writes if a primary is lost). However, via read preferences and write concerns, developers can tune it towards Eventual Consistency to mimic AP behavior.
D) It is a relational database

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: এটি ইন্টারভিউয়ের ক্লাসিক প্রশ্ন। মঙ্গোডিবি বাই ডিফল্ট CP, কারণ প্রাইমারি ডাউন হলে সে রাইট অপারেশন অফ করে দেয়। তবে আপনি চাইলে কনফিগারেশন চেঞ্জ করে একে AP এর মতো আচরণ করাতে পারেন।
</details>
