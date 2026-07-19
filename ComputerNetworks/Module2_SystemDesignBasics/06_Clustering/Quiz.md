# Quiz: Clustering (Chapter 6)

Test your knowledge of High Availability, Cluster configurations, Replication, and State Management! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What is the primary definition of a "Cluster" in computer networking?**
- A) A single highly powerful supercomputer.
- B) A group of independent servers working together as a single system.
- C) A type of database used for fast searches.
- D) A physical rack where servers are stored.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A group of independent servers working together as a single system.<br>
**Explanation:** Clustering connects multiple independent computers (nodes) so that they operate, load balance, and failover as a single unified entity.
</details>

**2. Which of the following is a primary benefit of clustering?**
- A) High Availability
- B) Reducing the cost of a single server
- C) Encrypting user passwords automatically
- D) Blocking malicious IP addresses
<details>
<summary>Answer</summary>
**Correct Answer:** A) High Availability<br>
**Explanation:** Clustering provides high availability by ensuring that if one node fails, others in the cluster take over its workload without system downtime.
</details>

**3. In an Active-Passive cluster configuration, what does the passive node do during normal operation?**
- A) Handles exactly 50% of the traffic.
- B) Handles all database write operations.
- C) Monitors the active node and waits to take over if a failure occurs.
- D) Serves only static files like images.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Monitors the active node and waits to take over if a failure occurs.<br>
**Explanation:** The passive (standby) node remains idle, sending heartbeat signals to the active node, ready to assume the workload if the active node goes offline.
</details>

**4. What is a major disadvantage of the Active-Passive cluster model?**
- A) It is extremely complicated to set up.
- B) The resources of the passive node are largely wasted during normal operation.
- C) It cannot handle database connections.
- D) It causes high network latency.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The resources of the passive node are largely wasted during normal operation.<br>
**Explanation:** Since the passive node just sits idle waiting for a failure, you are essentially paying for hardware that isn't actively improving system performance.
</details>

**5. What is the purpose of a "Heartbeat" in a cluster?**
- A) To synchronize the clocks of all nodes.
- B) A periodic signal sent between nodes to indicate they are alive and functioning.
- C) To measure the CPU usage of a database.
- D) To encrypt data moving between nodes.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A periodic signal sent between nodes to indicate they are alive and functioning.<br>
**Explanation:** Heartbeats are small network packets sent at regular intervals. If a node stops sending heartbeats, the cluster assumes it has failed and initiates failover.
</details>

**6. In Master-Slave (Primary-Secondary) database replication, what is the role of the Slave nodes?**
- A) They accept all Write operations.
- B) They distribute the HTTP requests.
- C) They only accept Read operations by syncing data from the Master.
- D) They perform SSL termination.
<details>
<summary>Answer</summary>
**Correct Answer:** C) They only accept Read operations by syncing data from the Master.<br>
**Explanation:** To scale read-heavy applications, data is written to the Master and replicated to Slaves, which handle the read queries.
</details>

**7. Which architecture retains user session data (like a logged-in state) in its own local memory?**
- A) Stateless Architecture
- B) Stateful Architecture
- C) Serverless Architecture
- D) Active-Active Architecture
<details>
<summary>Answer</summary>
**Correct Answer:** B) Stateful Architecture<br>
**Explanation:** A stateful server remembers client data (state) from one request to the next in its local memory or disk.
</details>

**8. What happens if a node in a Stateful cluster crashes and it holds a user's session data?**
- A) The load balancer automatically recovers the data.
- B) The user's session data is lost, and they may be logged out.
- C) The passive node instantly restores the session from its own memory.
- D) The browser resends the session data automatically.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The user's session data is lost, and they may be logged out.<br>
**Explanation:** Because the state was stored locally on the crashed node, it disappears when the server dies, negatively impacting the user experience.
</details>

**9. What is a "Stateless" application?**
- A) An application that does not use a database.
- B) An application where each request contains all the information needed to process it, and no local session data is stored on the server.
- C) An application hosted in multiple countries.
- D) An application that cannot scale horizontally.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An application where each request contains all the information needed to process it...<br>
**Explanation:** Stateless applications are ideal for clustering because any node can safely handle any request without needing prior context.
</details>

**10. How is user session data best managed in a modern, scalable cluster?**
- A) Using Sticky Sessions at the Load Balancer.
- B) Storing all sessions in local server RAM.
- C) Using a centralized distributed cache (like Redis or Memcached).
- D) Forcing the user to log in for every single click.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Using a centralized distributed cache (like Redis or Memcached).<br>
**Explanation:** A centralized cache acts as an external state store. If any application node crashes, the user's session remains safe in Redis, and a new node can pick it up.
</details>

---

### Medium (Questions 11 - 20)

**11. What is the key advantage of an Active-Active cluster over an Active-Passive cluster?**
- A) Active-Active requires fewer servers.
- B) Active-Active does not require a load balancer.
- C) Active-Active utilizes all available hardware resources to improve performance and throughput.
- D) Active-Active completely eliminates the need for data replication.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Active-Active utilizes all available hardware resources...<br>
**Explanation:** Since all nodes are actively processing requests, you get the combined performance of all servers rather than leaving some idle.
</details>

**12. What is "Failover" in the context of clustering?**
- A) The process of automatically switching traffic to a redundant or standby system upon the failure of the primary system.
- B) When a database transaction fails due to invalid syntax.
- C) When the load balancer crashes.
- D) The process of adding new servers to a cluster manually.
<details>
<summary>Answer</summary>
**Correct Answer:** A) The process of automatically switching traffic to a redundant or standby system...<br>
**Explanation:** Failover is the recovery mechanism that ensures high availability by immediately routing work away from a dead node to a healthy one.
</details>

**13. In a Master-Slave replication setup, what happens if the Master node crashes?**
- A) The entire system deletes its data.
- B) One of the Slave nodes must be promoted to become the new Master to resume Write operations.
- C) The Slave nodes automatically start accepting Write operations without being promoted.
- D) The application becomes completely unreachable for Read queries.
<details>
<summary>Answer</summary>
**Correct Answer:** B) One of the Slave nodes must be promoted to become the new Master...<br>
**Explanation:** Slaves are read-only. If the Master dies, the system cannot process Writes until an administrator (or an automated script) promotes a Slave to act as the new Master.
</details>

**14. What is a major challenge when using Multi-Master (Active-Active) database replication?**
- A) It is impossible to read from multiple masters.
- B) Handling Data Conflicts when the same record is modified simultaneously on different master nodes.
- C) Multi-Master only supports IPv6.
- D) It requires specialized hardware load balancers.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Handling Data Conflicts when the same record is modified simultaneously...<br>
**Explanation:** If User A updates a row on Master 1, and User B updates the same row on Master 2 at the exact same time, resolving which update "wins" during replication is complex.
</details>

**15. What does the term "Split-Brain" refer to in clustering?**
- A) When a node is running both Windows and Linux.
- B) A scenario where nodes lose network contact with each other and both assume the other is dead, leading to both trying to act as the primary master.
- C) When a database is partitioned into two different disks.
- D) A load balancing algorithm that splits requests randomly.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A scenario where nodes lose network contact with each other...<br>
**Explanation:** In a split-brain scenario, the cluster fractures. Two nodes might simultaneously try to write to a shared disk or database without coordinating, causing severe data corruption.
</details>

**16. How is the "Split-Brain" problem typically prevented in high-availability clusters?**
- A) By using only one server.
- B) By using a Tie-Breaker or Quorum (an odd number of nodes) so a majority vote decides who the master is.
- C) By increasing the CPU speed.
- D) By disabling heartbeats.
<details>
<summary>Answer</summary>
**Correct Answer:** B) By using a Tie-Breaker or Quorum (an odd number of nodes)...<br>
**Explanation:** A quorum ensures that a node must have the "majority vote" of the cluster to act as the master. If a cluster splits, only the partition with the majority can function, preventing two active masters.
</details>

**17. Why is "Sticky Sessions" (Session Affinity) generally considered an anti-pattern for true horizontal scalability?**
- A) It prevents the use of SSL.
- B) It distributes traffic unevenly if certain users are very active, and causes session loss if the sticky node fails.
- C) It is too difficult to configure on Layer 4.
- D) It causes database replication to fail.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It distributes traffic unevenly if certain users are very active, and causes session loss...<br>
**Explanation:** Sticky sessions tie a user to a server. If that user sends heavy traffic, that specific server gets overloaded while others sit idle. Also, server death means data loss.
</details>

**18. In database clustering, what is "Replication Lag"?**
- A) The time it takes for a user to log into the database.
- B) The delay between when a Write occurs on the Master and when it is visible on the Slaves.
- C) The delay in pinging the load balancer.
- D) The time it takes to reboot the cluster.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The delay between when a Write occurs on the Master and when it is visible on the Slaves.<br>
**Explanation:** Because copying data over a network takes time, a user might write data to the Master and immediately try to read it from a Slave, finding that it hasn't arrived yet (Replication Lag).
</details>

**19. What is the difference between Synchronous and Asynchronous replication?**
- A) Sync uses TCP; Async uses UDP.
- B) Sync waits for all nodes to confirm the write before telling the user "success"; Async tells the user "success" immediately and copies data in the background.
- C) Sync is used for Active-Passive; Async is for Active-Active.
- D) Sync requires internet; Async requires a local network.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Sync waits for all nodes to confirm... Async tells the user "success" immediately...<br>
**Explanation:** Synchronous guarantees no data loss but adds high latency. Asynchronous is fast but risks data loss if the master crashes before the background copy finishes.
</details>

**20. A "Shared-Nothing" architecture means:**
- A) Nodes do not share any data at all and operate completely independently.
- B) Nodes do not share memory or disk storage; each has its own, and they communicate purely over the network.
- C) The application is completely open-source.
- D) The cluster uses a single massive hard drive.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Nodes do not share memory or disk storage; each has its own...<br>
**Explanation:** Shared-nothing is highly scalable. Every node is self-sufficient with its own RAM/Disk. Data sharing happens via network protocols (like database replication) rather than physical hardware sharing.
</details>

---

### Hard (Questions 21 - 30)

**21. What is "Fencing" (or STONITH) in high-availability clustering?**
- A) A security firewall around the cluster.
- B) A mechanism to forcibly power off or isolate a malfunctioning node to prevent it from causing data corruption (Shoot The Other Node In The Head).
- C) Partitioning a database into smaller tables.
- D) Limiting the number of users that can access the cluster.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A mechanism to forcibly power off or isolate a malfunctioning node...<br>
**Explanation:** STONITH ensures that if a node becomes unresponsive but might still be writing to shared storage (a "zombie" node), the cluster physically cuts its power or network to protect data integrity.
</details>

**22. How does a Distributed Cache like Redis help achieve a Stateless architecture?**
- A) By storing HTML files so the server doesn't have to render them.
- B) By offloading session state from the application servers' memory to a fast, centralized in-memory datastore accessible by all nodes.
- C) By encrypting the session data inside the user's browser cookie.
- D) By acting as a Layer 4 load balancer.
<details>
<summary>Answer</summary>
**Correct Answer:** B) By offloading session state from the application servers' memory to a fast, centralized... datastore.<br>
**Explanation:** Because Redis holds the state, the application servers themselves hold nothing (stateless). Any server can pick up any request and fetch the required state from Redis.
</details>

**23. In a multi-region Active-Active architecture (e.g., US-East and EU-West), what is a major challenge for database replication?**
- A) DNS routing cannot handle multiple regions.
- B) Speed of light latency creates significant Replication Lag and conflict resolution issues across long distances.
- C) Load balancers cannot span across oceans.
- D) Different regions use different OSI models.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Speed of light latency creates significant Replication Lag and conflict resolution issues...<br>
**Explanation:** Network latency between continents means data cannot be synced instantly. Managing Active-Active writes across regions requires complex conflict resolution algorithms (like CRDTs).
</details>

**24. What is "Read-After-Write Consistency"?**
- A) The guarantee that once a user writes a record, their subsequent read will immediately reflect that write.
- B) A database feature that prevents reading.
- C) The process of reading a log file after writing it.
- D) An asynchronous replication model.
<details>
<summary>Answer</summary>
**Correct Answer:** A) The guarantee that once a user writes a record, their subsequent read will immediately reflect that write.<br>
**Explanation:** In distributed systems with replication lag, a user might update their profile (Write to Master) and immediately refresh (Read from Slave). If the slave hasn't synced yet, they see old data. Read-After-Write consistency solves this.
</details>

**25. What is the role of a "Virtual IP" (VIP) in a cluster failover scenario?**
- A) It masks the IP of the client for privacy.
- B) The VIP is assigned to the Active node. If it crashes, the cluster software dynamically reassigns the VIP to the Standby node so clients experience no IP change.
- C) It creates a virtual machine inside the cluster.
- D) It assigns IPv6 addresses to IPv4 nodes.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The VIP is assigned to the Active node. If it crashes, the cluster software dynamically reassigns...<br>
**Explanation:** Clients only know the VIP. Failover is seamless because the new master simply "steals" the VIP address via ARP broadcasts, instantly routing traffic to the healthy node.
</details>

**26. In the context of the CAP Theorem, which two properties does a standard Relational Database Cluster (like MySQL Master-Slave) typically prioritize?**
- A) Consistency and Partition Tolerance (CP)
- B) Availability and Partition Tolerance (AP)
- C) Consistency and Availability (CA)
- D) Speed and Reliability (SR)
<details>
<summary>Answer</summary>
**Correct Answer:** C) Consistency and Availability (CA) - traditionally, though modern systems lean CP/AP depending on configuration.<br>
**Explanation:** The CAP Theorem states a distributed data store can only provide two of three: Consistency, Availability, Partition Tolerance. Traditional RDBMS clusters prioritize Consistency and Availability on a reliable local network (CA). If partitioned over a WAN, they usually sacrifice Availability for Consistency (CP).
</details>

**27. What is "Eventual Consistency"?**
- A) A system where data is never consistent.
- B) A guarantee that if no new updates are made to a given data item, eventually all accesses to that item will return the last updated value.
- C) A strict lock on a database row during a transaction.
- D) Synchronous replication.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A guarantee that if no new updates are made... eventually all accesses... return the last updated value.<br>
**Explanation:** Used highly in NoSQL and multi-master clusters. It accepts that nodes may temporarily have stale data (high availability), but they will eventually sync up.
</details>

**28. Which consensus algorithm is commonly used in distributed clusters (like etcd, Consul, or ZooKeeper) to manage leader election and configuration?**
- A) Round Robin
- B) Dijkstra's Algorithm
- C) Raft or Paxos
- D) SHA-256
<details>
<summary>Answer</summary>
**Correct Answer:** C) Raft or Paxos<br>
**Explanation:** Raft and Paxos are distributed consensus algorithms. They ensure that all nodes in a cluster agree on the state of the system, securely managing leader election and preventing split-brain.
</details>

**29. What is "Sharding" (Data Partitioning) in database clustering?**
- A) Replicating the entire database to every node.
- B) Splitting a large database horizontally across multiple independent nodes so each node holds only a portion of the data.
- C) Encrypting data at rest.
- D) Using SSDs instead of HDDs.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Splitting a large database horizontally across multiple independent nodes...<br>
**Explanation:** When a database is too large for one server's disk/RAM, sharding splits the rows (e.g., Users A-M on Node 1, N-Z on Node 2), allowing massive horizontal scaling.
</details>

**30. Why might an application use a "JWT" (JSON Web Token) for authentication in a Stateless Cluster?**
- A) Because JWTs are faster than passwords.
- B) Because JWTs store the session state directly on the client side (in the browser), meaning the backend servers do not need to query a database or Redis to verify the session.
- C) Because JWTs perform load balancing.
- D) Because JWTs automatically replicate to all nodes.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because JWTs store the session state directly on the client side...<br>
**Explanation:** A JWT contains digitally signed user info. The client sends it with every request. The server verifies the signature without needing to look up session data in memory or Redis, achieving pure statelessness.
</details>
