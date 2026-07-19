# Quiz: Distributed Databases & Consistency (Chapter 15)

Test your knowledge of the CAP Theorem, PACELC, Consistency Models, and NoSQL databases! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What does the "C" in CAP Theorem stand for?**
- A) Concurrency
- B) Consistency
- C) Caching
- D) Clustering
<details>
<summary>Answer</summary>
**Correct Answer:** B) Consistency<br>
**Explanation:** Consistency means that every read receives the most recent write (or an error). All nodes see the exact same data at the exact same time.
</details>

**2. What does the "A" in CAP Theorem stand for?**
- A) Authorization
- B) Automation
- C) Availability
- D) Asynchronous
<details>
<summary>Answer</summary>
**Correct Answer:** C) Availability<br>
**Explanation:** Availability means that every request receives a non-error response, without guaranteeing that it contains the most recent write.
</details>

**3. What does the "P" in CAP Theorem stand for?**
- A) Partition Tolerance
- B) Performance
- C) Protocol
- D) Parsing
<details>
<summary>Answer</summary>
**Correct Answer:** A) Partition Tolerance<br>
**Explanation:** Partition Tolerance means the system continues to operate despite an arbitrary number of messages being dropped or delayed by the network between nodes.
</details>

**4. According to the CAP Theorem, how many of the three guarantees can a distributed data store provide simultaneously?**
- A) Exactly 1
- B) Exactly 2
- C) All 3
- D) None of them
<details>
<summary>Answer</summary>
**Correct Answer:** B) Exactly 2<br>
**Explanation:** Eric Brewer's theorem states you can only have two out of three. In practice, because network partitions (P) are unavoidable in distributed systems, you must choose between C and A.
</details>

**5. What is "Eventual Consistency"?**
- A) A system that never updates its data.
- B) A model where, if no new updates are made to a given data item, eventually all accesses to that item will return the last updated value.
- C) A system that guarantees data is immediately synced globally.
- D) A database that deletes old records eventually.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A model where... eventually all accesses to that item will return the last updated value.<br>
**Explanation:** Eventual consistency prioritizes Availability and low Latency. It allows returning "stale" (old) data temporarily, knowing it will sync up in the background.
</details>

**6. Which type of NoSQL database is best for storing incredibly simple data, like caching user sessions (e.g., `user_123_session: "active"`)?**
- A) Graph Database
- B) Relational Database
- C) Key-Value Store
- D) Document Store
<details>
<summary>Answer</summary>
**Correct Answer:** C) Key-Value Store<br>
**Explanation:** Key-Value stores (like Redis) are extremely fast and perfect for simple lookups where complex queries are not needed.
</details>

**7. Which type of NoSQL database stores data in JSON-like formats and is excellent for rapid prototyping because it has a flexible schema?**
- A) Document Store
- B) Wide-Column Store
- C) Graph Database
- D) SQL Server
<details>
<summary>Answer</summary>
**Correct Answer:** A) Document Store<br>
**Explanation:** Document stores like MongoDB save data as JSON (BSON). You can save a document with 5 fields, and the next document with 10 fields, without altering any table schema.
</details>

**8. Which type of database is specifically designed to handle highly interconnected data, like finding "friends of friends" on a social network?**
- A) Key-Value Store
- B) Graph Database
- C) Wide-Column Store
- D) Document Store
<details>
<summary>Answer</summary>
**Correct Answer:** B) Graph Database<br>
**Explanation:** Graph databases (like Neo4j) treat the relationships (edges) between data points (nodes) as equally important as the data itself, making relationship traversal incredibly fast compared to SQL JOINs.
</details>

**9. What is a "Network Partition" in a distributed database?**
- A) Dividing the hard drive into C: and D: drives.
- B) A network failure that causes some nodes in the cluster to be unable to communicate with other nodes, splitting the cluster into isolated parts.
- C) Compressing network packets.
- D) Assigning IP addresses to servers.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A network failure that causes some nodes in the cluster to be unable to communicate with other nodes...<br>
**Explanation:** If a switch fails and Server A can no longer talk to Server B, you have a network partition. The CAP theorem dictates how the system behaves when this happens.
</details>

**10. If an ATM network loses connection to the central bank (Network Partition), but it STILL allows you to withdraw money (assuming your balance is high enough based on old data), what is the system prioritizing?**
- A) Consistency (C)
- B) Availability (A)
- C) Latency (L)
- D) Encryption
<details>
<summary>Answer</summary>
**Correct Answer:** B) Availability (A)<br>
**Explanation:** The ATM prioritized staying "Available" to the user, even though it risked "Inconsistency" (you might have already spent that money on your phone app 2 minutes ago). This is an AP system.
</details>

---

### Medium (Questions 11 - 20)

**11. What does an "AP" database do when a network partition occurs?**
- A) It shuts down all nodes immediately to protect data.
- B) It refuses to answer any read or write queries.
- C) It continues to accept reads and writes on all available nodes, risking that the nodes might have out-of-sync (inconsistent) data until the network heals.
- D) It deletes all data.
<details>
<summary>Answer</summary>
**Correct Answer:** C) It continues to accept reads and writes on all available nodes, risking that the nodes might have out-of-sync data...<br>
**Explanation:** AP (Availability + Partition Tolerance) means the system will never give an error if it can avoid it, but you might read stale data. Cassandra is a classic AP database.
</details>

**12. What does a "CP" database do when a network partition occurs?**
- A) It continues to serve all requests normally.
- B) The isolated nodes will refuse to accept reads/writes (returning an error or timeout) to ensure that no client ever reads stale data or creates a conflicting write.
- C) It prints the data to a physical log.
- D) It switches to a relational schema.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The isolated nodes will refuse to accept reads/writes (returning an error or timeout)...<br>
**Explanation:** CP (Consistency + Partition Tolerance) systems prioritize being "correct". If they aren't 100% sure the data is synced, they prefer to be Unavailable (give an error) rather than be Inconsistent. MongoDB and HBase are usually CP.
</details>

**13. Why is "CA" (Consistency + Availability without Partition Tolerance) practically impossible in modern distributed cloud systems?**
- A) Because cloud providers ban CA systems.
- B) Because you cannot guarantee that a network will never fail. Since network partitions (P) *will* happen, you are forced to choose between C and A.
- C) Because hard drives are too slow.
- D) Because of memory leaks.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because you cannot guarantee that a network will never fail...<br>
**Explanation:** A CA system can only exist on a single machine (like a single MySQL server). Once you distribute across a network, P is mandatory, so CA is a theoretical myth in distributed systems.
</details>

**14. What does the PACELC theorem add to the CAP theorem?**
- A) It adds security protocols.
- B) It explains what trade-offs a system makes when the network is running normally (Else: choose Latency or Consistency), not just when a partition occurs.
- C) It calculates database storage limits.
- D) It is specifically for GraphQL.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It explains what trade-offs a system makes when the network is running normally...<br>
**Explanation:** CAP only talks about failure. PACELC says: If Partition (P), choose Availability (A) or Consistency (C). Else (E) [when network is fine], choose Latency (L) or Consistency (C).
</details>

**15. In PACELC, if a database is "PA/EL", what does that mean?**
- A) It prioritizes Partition and Error Logging.
- B) If partitioned, it prioritizes Availability. Else (when normal), it prioritizes low Latency (meaning it uses eventual consistency to reply to users faster).
- C) If partitioned, it prioritizes Availability. Else, it prioritizes Consistency.
- D) It is a relational database.
<details>
<summary>Answer</summary>
**Correct Answer:** B) If partitioned, it prioritizes Availability. Else... it prioritizes low Latency...<br>
**Explanation:** DynamoDB and Cassandra are classic PA/EL systems. They want to be always on and always fast, even if the data is slightly stale.
</details>

**16. What is "Strong Consistency"?**
- A) Data is encrypted with a strong key.
- B) A write operation is not considered successful until the data has been securely copied to all (or a quorum of) replicas. Any subsequent read will always return this latest value.
- C) The database uses strong passwords.
- D) Data is stored in RAM.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A write operation is not considered successful until the data has been securely copied to all... replicas.<br>
**Explanation:** This guarantees correctness but increases Latency, because the user has to wait for the network to copy the data to multiple servers before they get a "Success" response.
</details>

**17. Which of the following is a "Wide-Column Store" database, known for handling massive write throughput by storing data in column families?**
- A) MySQL
- B) Neo4j
- C) Apache Cassandra
- D) Redis
<details>
<summary>Answer</summary>
**Correct Answer:** C) Apache Cassandra<br>
**Explanation:** Cassandra (and HBase) are wide-column stores. They are incredibly efficient at writing massive amounts of time-series or logging data across hundreds of servers.
</details>

**18. Why are Relational Databases (RDBMS like PostgreSQL) often difficult to scale horizontally?**
- A) They are written in old programming languages.
- B) They enforce strict ACID properties and complex table JOINs, which require extensive locking and coordination across servers, killing network performance when distributed.
- C) They do not support IP addresses.
- D) They only work on Windows OS.
<details>
<summary>Answer</summary>
**Correct Answer:** B) They enforce strict ACID properties and complex table JOINs, which require extensive locking...<br>
**Explanation:** SQL databases are designed for data integrity (ACID). Doing a JOIN across three tables that live on three different physical servers requires locking data across the network, which is extremely slow.
</details>

**19. What is a "Quorum" in distributed databases?**
- A) A type of error message.
- B) The minimum number of nodes that must acknowledge a read or write operation for it to be considered successful (usually `(N/2) + 1`).
- C) The maximum size of a JSON document.
- D) A tool for formatting code.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The minimum number of nodes that must acknowledge a read or write operation...<br>
**Explanation:** If you have 5 replicas, a quorum is 3. If you require 3 nodes to acknowledge a write, and 3 nodes to acknowledge a read, you guarantee Strong Consistency (because the read and write quorums will always overlap by at least 1 node).
</details>

**20. If you are building a financial ledger where an incorrect balance is unacceptable, which PACELC configuration should you prefer?**
- A) PA/EL (Availability & Latency)
- B) PC/EC (Consistency during partitions & Consistency during normal operation)
- C) AP/EL
- D) Any NoSQL database will do.
<details>
<summary>Answer</summary>
**Correct Answer:** B) PC/EC (Consistency during partitions & Consistency during normal operation)<br>
**Explanation:** For money, correctness is more important than speed or uptime. You want the system to block operations (High Latency/Unavailable) rather than process a transaction with out-of-sync data.
</details>

---

### Hard (Questions 21 - 30)

**21. What is "Read-Your-Writes" consistency?**
- A) A system where you can only read data you wrote.
- B) A client-centric consistency model where, once a client writes a value, that specific client is guaranteed to see that updated value in all subsequent reads, even if other clients still see the old value.
- C) A system that reads the hard drive while writing to it.
- D) A database that prevents overwriting data.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A client-centric consistency model where, once a client writes a value, that specific client is guaranteed to see that updated value...<br>
**Explanation:** If you post a comment on Facebook, YOU should see it immediately when you refresh the page. It's okay if your friend in another country doesn't see it for 5 more seconds (Eventual Consistency for them, Read-Your-Writes for you).
</details>

**22. How does a "Vector Clock" help resolve conflicts in an AP distributed database?**
- A) It uses a literal atomic clock in the server.
- B) It is a data structure that tracks the causal history of updates across different nodes, allowing the system to determine which version of the data is newest, or if there is a concurrent conflict that requires application logic to resolve.
- C) It stops time on the server.
- D) It encrypts the data using time hashes.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It is a data structure that tracks the causal history of updates across different nodes...<br>
**Explanation:** In an AP system (like DynamoDB), Server A and Server B might accept writes for the same data while disconnected. Vector clocks `[A:2, B:1]` help the database figure out how to merge them when the network heals.
</details>

**23. What is "Monotonic Read" consistency?**
- A) The database only returns data in alphabetical order.
- B) A guarantee that if a process has seen a particular value for an object, any subsequent accesses will never return any older values. (Time doesn't go backwards for the reader).
- C) The user can only read one record at a time.
- D) The database uses a single tone for alerts.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A guarantee that if a process has seen a particular value... any subsequent accesses will never return any older values.<br>
**Explanation:** Without monotonic reads, you might refresh a page and see 10 comments (hit Server A), refresh again and see 8 comments (hit Server B which is lagging behind). Monotonic reads prevent this "time travel" bug.
</details>

**24. In the context of CAP theorem, what does Google Cloud Spanner claim to achieve, and how?**
- A) True CA, by ignoring network partitions.
- B) It claims to be effectively CA (though technically CP) by utilizing atomic clocks and GPS receivers (TrueTime API) to achieve perfectly synchronized time across data centers, reducing the "P" failure window to near zero.
- C) True AP, by dropping all read requests.
- D) It is just a standard MySQL database.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It claims to be effectively CA (though technically CP) by utilizing atomic clocks and GPS receivers (TrueTime API)...<br>
**Explanation:** Google Spanner is a marvel of engineering. Because their internal network is so robust and they use atomic clocks to perfectly order transactions, network partitions are so rare that it feels like a CA system to developers.
</details>

**25. What is the "Gossip Protocol" in distributed databases like Cassandra?**
- A) Nodes sending text messages to admins.
- B) A peer-to-peer communication mechanism where nodes periodically exchange state information about themselves and other nodes they know about, eventually ensuring all nodes know the cluster's topology and health.
- C) A security vulnerability where data is leaked.
- D) A method for logging user activity.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A peer-to-peer communication mechanism where nodes periodically exchange state information...<br>
**Explanation:** Instead of a central master node monitoring everyone (which is a SPOF), Cassandra nodes "gossip" with a few random neighbors every second. Like a real-world rumor, information about a dead node spreads exponentially fast to the whole cluster.
</details>

**26. What is "Consistent Hashing" used for in distributed NoSQL databases?**
- A) Hashing passwords securely.
- B) Distributing data (keys) evenly across a cluster of nodes in a way that minimizes the amount of data that needs to be moved when a node is added or removed.
- C) Checking if a file has been corrupted.
- D) Preventing SQL injection.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Distributing data (keys) evenly across a cluster of nodes in a way that minimizes... data... moved...<br>
**Explanation:** If you use `Hash(key) % N`, adding a node changes `N`, forcing almost all data to move to new servers. Consistent hashing maps nodes and keys to a ring, meaning adding a node only affects its immediate neighbors.
</details>

**27. In a Leader-Follower (Master-Slave) replication setup, what happens if the Leader node fails (Network Partition) in a CP system?**
- A) A Follower immediately accepts writes.
- B) The system stops accepting writes entirely until a new Leader is formally elected and agreed upon by the majority of the nodes (maintaining Consistency, sacrificing Availability).
- C) The system deletes the Followers.
- D) The system becomes an AP system.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The system stops accepting writes entirely until a new Leader is formally elected...<br>
**Explanation:** To prevent "Split-Brain" (where two nodes think they are the leader and accept conflicting writes), CP systems pause writes during the election process.
</details>

**28. What is a "Tombstone" in distributed NoSQL databases (like Cassandra)?**
- A) A marker placed on a dead server.
- B) A special record written to the database indicating that a specific piece of data has been deleted. This is necessary because in an eventually consistent, append-only system, you cannot simply erase data from the disk immediately.
- C) An archive of old data.
- D) A metric indicating fatal errors.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A special record written to the database indicating that a specific piece of data has been deleted.<br>
**Explanation:** If you just delete data on Node A, Node B (which was offline) might come back and re-sync the "missing" data back to Node A. A Tombstone tells Node B: "This data wasn't missed; it was intentionally killed."
</details>

**29. What is "Read Repair" in an eventually consistent database?**
- A) Fixing a broken hard drive.
- B) A background process triggered during a read operation. If the coordinator node notices that some replicas returned older data than others, it automatically sends the newest data to the stale replicas to update them.
- C) A tool that checks code for syntax errors.
- D) Restoring data from a backup.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A background process triggered during a read operation... it automatically sends the newest data to the stale replicas...<br>
**Explanation:** This is a clever optimization. Instead of waiting for a heavy background sync process, the database fixes inconsistencies on-the-fly exactly when the data is requested by a user.
</details>

**30. Why is calculating a simple `COUNT(*)` incredibly slow and resource-intensive in a distributed Wide-Column or Key-Value NoSQL database?**
- A) Because NoSQL databases do not use RAM.
- B) Because data is sharded across many physical servers. To count all records, the database must scan the entire dataset across all nodes, aggregate the results over the network, and handle potential duplicates from replicas.
- C) Because they don't support numbers.
- D) Because the data is always encrypted.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because data is sharded across many physical servers. To count all records, the database must scan the entire dataset...<br>
**Explanation:** In a single MySQL server, `COUNT` is often just reading a metadata variable. In a 50-node Cassandra cluster, counting every row requires a massive distributed map-reduce job. NoSQL is optimized for targeted lookups, not global aggregations.
</details>
