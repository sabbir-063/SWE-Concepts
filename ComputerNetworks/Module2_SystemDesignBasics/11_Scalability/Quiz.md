# Quiz: Scalability (Chapter 11)

Test your knowledge of Vertical vs Horizontal scaling, Stateful vs Stateless systems, and Elasticity! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What does "Scalability" mean in System Design?**
- A) The ability to make the UI look good on mobile devices.
- B) The ability of a system to handle a growing amount of work by adding resources to the system.
- C) The speed at which a database can encrypt passwords.
- D) The process of shrinking a database to save space.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The ability of a system to handle a growing amount of work by adding resources...<br>
**Explanation:** A scalable system can smoothly accommodate millions of new users without crashing or slowing down unacceptably.
</details>

**2. What is Vertical Scaling (Scaling Up)?**
- A) Adding more servers to a network.
- B) Increasing the power of an existing server by adding more CPU, RAM, or a larger Hard Drive.
- C) Moving the server to a taller building.
- D) Splitting a database into multiple tables.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Increasing the power of an existing server by adding more CPU, RAM...<br>
**Explanation:** Vertical scaling means making your current machine bigger and stronger (e.g., upgrading from 8GB RAM to 64GB RAM).
</details>

**3. What is Horizontal Scaling (Scaling Out)?**
- A) Changing the server from a tower to a rack-mount.
- B) Upgrading the motherboard of a server.
- C) Adding more servers to the existing pool of servers to distribute the load.
- D) Deleting old data to make room for new data.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Adding more servers to the existing pool of servers...<br>
**Explanation:** Horizontal scaling means increasing the *quantity* of machines (e.g., going from 1 server to 10 servers).
</details>

**4. Which type of scaling usually involves downtime because the machine must be turned off to install new hardware (or rebooted in the cloud)?**
- A) Horizontal Scaling
- B) Vertical Scaling
- C) Elastic Scaling
- D) Geographic Scaling
<details>
<summary>Answer</summary>
**Correct Answer:** B) Vertical Scaling<br>
**Explanation:** Changing CPU or RAM on a single machine typically requires a restart, leading to downtime (unless specialized hot-swappable hardware is used).
</details>

**5. Which component is strictly necessary when you implement Horizontal Scaling for your web servers?**
- A) A larger Hard Drive
- B) A Load Balancer
- C) A Forward Proxy
- D) A CDN
<details>
<summary>Answer</summary>
**Correct Answer:** B) A Load Balancer<br>
**Explanation:** If you have 10 servers, you need a Load Balancer sitting in front of them to distribute the incoming user traffic evenly among those 10 servers.
</details>

**6. What is a major limitation of Vertical Scaling?**
- A) It requires rewriting the entire application.
- B) It introduces high network latency between CPUs.
- C) Hardware has a physical limit (you cannot add infinite RAM or CPUs to one motherboard), and it creates a Single Point of Failure.
- D) It requires a Load Balancer.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Hardware has a physical limit... and it creates a Single Point of Failure.<br>
**Explanation:** You will eventually hit a ceiling where you cannot buy a bigger CPU. Also, if that one super-computer crashes, the whole system is down.
</details>

**7. In a "Stateful" application architecture, where is the user's session data (like login status or shopping cart) typically stored?**
- A) In the global DNS registry.
- B) On the local memory (RAM) or hard drive of the specific web server that the user connected to.
- C) Exclusively on the user's mobile device.
- D) In a Content Delivery Network (CDN).
<details>
<summary>Answer</summary>
**Correct Answer:** B) On the local memory (RAM) or hard drive of the specific web server...<br>
**Explanation:** A stateful server "remembers" the client. The data is saved locally on that specific machine.
</details>

**8. Why is a Stateful architecture problematic for Horizontal Scaling?**
- A) It makes the UI too slow.
- B) If a Load Balancer sends a user's second request to a different server, that new server won't have the user's session data, causing them to log out or lose their cart.
- C) It requires too much electricity.
- D) Stateful architectures cannot connect to databases.
<details>
<summary>Answer</summary>
**Correct Answer:** B) If a Load Balancer sends a user's second request to a different server, that new server won't have the user's session data...<br>
**Explanation:** Because the state is locked to one server, horizontal scaling breaks. (This can be bypassed with Sticky Sessions, but that causes uneven load distribution).
</details>

**9. In a "Stateless" application architecture, where should session data be stored?**
- A) On the web server's local RAM.
- B) In a shared, centralized data store like Redis, Memcached, or a Database.
- C) On the Load Balancer.
- D) It shouldn't be stored anywhere; users must log in on every single click.
<details>
<summary>Answer</summary>
**Correct Answer:** B) In a shared, centralized data store like Redis...<br>
**Explanation:** By moving the state out of the web servers and into a centralized cache (like Redis), any web server can handle any request by simply fetching the state from Redis.
</details>

**10. What is "Elasticity" in cloud computing?**
- A) The ability to stretch a network cable over long distances.
- B) The system's ability to automatically and dynamically scale resources up (add servers) when traffic spikes, and scale down (remove servers) when traffic drops.
- C) The process of compressing images.
- D) The ability to change programming languages at runtime.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The system's ability to automatically and dynamically scale resources up... and scale down...<br>
**Explanation:** Elasticity is automated scalability. It ensures you have enough servers to handle the Super Bowl traffic spike, but you aren't paying for those servers at 3 AM on a Tuesday.
</details>

---

### Medium (Questions 11 - 20)

**11. Which scaling method provides inherently higher Availability and Fault Tolerance?**
- A) Vertical Scaling
- B) Horizontal Scaling
- C) Manual Scaling
- D) Database Normalization
<details>
<summary>Answer</summary>
**Correct Answer:** B) Horizontal Scaling<br>
**Explanation:** Horizontal scaling relies on multiple machines. If one machine burns down, the load balancer simply stops sending traffic to it, and the other machines keep the system running (Fault Tolerance).
</details>

**12. When you upgrade your database from a 4-core processor to a 16-core processor, what kind of scaling have you performed?**
- A) Horizontal Scaling
- B) Elastic Scaling
- C) Vertical Scaling
- D) Diagonal Scaling
<details>
<summary>Answer</summary>
**Correct Answer:** C) Vertical Scaling<br>
**Explanation:** You increased the capacity of an existing single node. Relational databases (like MySQL/PostgreSQL) are traditionally much easier to scale vertically than horizontally.
</details>

**13. What is an Auto-Scaling Group (ASG)?**
- A) A group of developers who manage the servers.
- B) A cloud computing feature that automatically adds or removes compute instances (servers) based on defined metrics like CPU utilization or network traffic.
- C) A type of Load Balancer.
- D) A protocol for encrypting scale data.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A cloud computing feature that automatically adds or removes compute instances...<br>
**Explanation:** An ASG monitors your servers. If average CPU hits 80%, the ASG automatically spins up two new servers and attaches them to the Load Balancer. This is how Elasticity is achieved.
</details>

**14. Why is Horizontal Scaling more complex for Databases than for Web Servers?**
- A) Databases don't use electricity.
- B) Web servers are stateless by nature, making them easy to clone. Databases hold the "State" (data) of the entire application, so adding database nodes requires complex data replication, partitioning, and consistency management.
- C) Databases cannot be connected to Load Balancers.
- D) Databases do not support IP addresses.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Web servers are stateless by nature... Databases hold the "State"... requiring complex data replication...<br>
**Explanation:** Cloning a stateless web server takes 10 seconds. Cloning a database means you have to figure out how to keep the data perfectly synced between the old node and the new node without corrupting transactions.
</details>

**15. What is the primary disadvantage of using "Sticky Sessions" (Session Affinity) to solve the Stateful scaling problem?**
- A) It encrypts the data too heavily.
- B) It can lead to uneven load distribution. If a server has highly active users "stuck" to it, that server might become overloaded while other servers sit idle.
- C) It causes the database to crash.
- D) It prevents users from logging in.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It can lead to uneven load distribution...<br>
**Explanation:** Sticky sessions force the load balancer to send User A to Server 1 always. If Server 1's users happen to be downloading huge files, Server 1 will crash, while Server 2 does nothing.
</details>

**16. How does JSON Web Token (JWT) help achieve a Stateless architecture?**
- A) It saves the session on the Load Balancer.
- B) The server does not store the session. Instead, all necessary user data is cryptographically signed and stored in the token, which the client sends with every request.
- C) It stores the session in a centralized MySQL database.
- D) It prevents cross-site scripting (XSS).
<details>
<summary>Answer</summary>
**Correct Answer:** B) The server does not store the session. Instead, all necessary user data is... stored in the token...<br>
**Explanation:** With JWT, the server doesn't even need to query Redis. It just cryptographically verifies the token the user sent. If valid, the server knows who the user is immediately. This is the ultimate stateless approach.
</details>

**17. What is "Database Sharding"?**
- A) A form of Vertical Scaling for databases.
- B) A form of Horizontal Scaling where a massive database is partitioned into smaller, faster, easily managed parts called "shards" that are distributed across multiple servers.
- C) A process to encrypt database passwords.
- D) Taking daily backups of the database.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A form of Horizontal Scaling where a massive database is partitioned... across multiple servers.<br>
**Explanation:** Instead of one massive 10TB database, Sharding splits it into ten 1TB databases. E.g., Users A-C on Server 1, Users D-F on Server 2. It is complex but allows infinite database scaling.
</details>

**18. What is the difference between Scalability and Performance?**
- A) They are the exact same thing.
- B) Performance measures how fast a system processes a single request. Scalability measures how well the system maintains that performance as the number of concurrent requests increases.
- C) Performance is for hardware; Scalability is for software.
- D) Scalability measures speed; Performance measures size.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Performance measures how fast a system processes a single request. Scalability measures how well the system maintains that performance...<br>
**Explanation:** A system can be highly performant for 1 user (loads in 50ms), but if 100 users make it crash, it is NOT scalable.
</details>

**19. Why might a startup initially prefer Vertical Scaling over Horizontal Scaling?**
- A) Horizontal scaling is illegal for small businesses.
- B) Vertical scaling is structurally simpler. It requires no architectural changes, no load balancers, and no distributed systems engineering.
- C) Vertical scaling is infinitely expandable.
- D) Vertical scaling uses less electricity.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Vertical scaling is structurally simpler...<br>
**Explanation:** For a startup with limited engineering resources, it's much cheaper and faster to just click a button on AWS to upgrade the server size than to re-architect the whole app to be stateless and distributed.
</details>

**20. Which modern architectural style is specifically designed to maximize Horizontal Scalability?**
- A) Monolithic Architecture
- B) Microservices Architecture
- C) Mainframe Architecture
- D) Peer-to-Peer Architecture
<details>
<summary>Answer</summary>
**Correct Answer:** B) Microservices Architecture<br>
**Explanation:** Microservices break an app into tiny pieces (e.g., Auth Service, Payment Service). If the Payment Service is under heavy load, you can horizontally scale *only* the Payment Service, saving resources.
</details>

---

### Hard (Questions 21 - 30)

**21. What is the "CAP Theorem" in the context of distributed, horizontally scaled data systems?**
- A) A system can only have one Central Processing Unit (CPU).
- B) It states that a distributed data store can simultaneously provide only two of the following three guarantees: Consistency, Availability, and Partition Tolerance.
- C) It calculates the maximum capacity of a Load Balancer.
- D) It proves that Vertical Scaling is mathematically superior.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It states that a distributed data store can simultaneously provide only two... Consistency, Availability, and Partition Tolerance.<br>
**Explanation:** In a horizontally scaled database, if a network link breaks (Partition), you must choose: either stop serving requests to prevent bad data (sacrificing Availability), or keep serving requests even if the data might be out-of-sync (sacrificing Consistency).
</details>

**22. In database scaling, what is "Read Replica" (Master-Slave) replication?**
- A) A form of Vertical Scaling.
- B) A form of Horizontal Scaling where all writes go to a Master node, and data is asynchronously copied to multiple Slave nodes that handle only read requests.
- C) A process that prevents data from being copied.
- D) A backup stored offline on magnetic tape.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A form of Horizontal Scaling where all writes go to a Master node... Slave nodes... handle only read requests.<br>
**Explanation:** Most web apps have 10x more reads than writes. By routing all read queries to 5 different Read Replicas, you horizontally scale the database's read capacity massively.
</details>

**23. What challenge does "Asynchronous Replication" introduce in a Master-Slave scaled database?**
- A) It uses too much hard drive space.
- B) Replication Lag: A user might write data to the Master, immediately request it from a Slave, and not see it because the data hasn't finished copying over yet (Eventual Consistency).
- C) It encrypts the data incorrectly.
- D) It requires a manual reboot of the servers.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Replication Lag...<br>
**Explanation:** Because copying takes a few milliseconds, reading from a replica immediately after writing can return stale data. This is the trade-off for high performance.
</details>

**24. What is "Diagonal Scaling" (or Hybrid Scaling)?**
- A) Scaling servers by placing them diagonally in the rack.
- B) A combination of both vertical and horizontal scaling. (e.g., upgrading your 5 servers to be more powerful, AND adding 5 more servers to the cluster).
- C) Scaling the database horizontally but the web servers vertically.
- D) Using a CDN and a Proxy at the same time.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A combination of both vertical and horizontal scaling.<br>
**Explanation:** In the real world, massive systems do both. They use very powerful machines (Vertical) and network thousands of them together (Horizontal).
</details>

**25. When designing for Elasticity, what is "Scale-Out Thrashing" (or Flapping)?**
- A) When the cooling fans spin too fast.
- B) When scaling thresholds are too close together, causing the auto-scaler to rapidly add and remove servers in an endless, inefficient loop.
- C) When hackers trigger the auto-scaler.
- D) When the database deletes its own records.
<details>
<summary>Answer</summary>
**Correct Answer:** B) When scaling thresholds are too close together, causing the auto-scaler to rapidly add and remove servers...<br>
**Explanation:** If you set "Scale Up at 70% CPU" and "Scale Down at 65% CPU", a slight traffic bump will cause a new server to boot, lowering CPU to 60%, which triggers a scale down, raising CPU to 72%, triggering a scale up, over and over. (Solved by adding a "Cooldown" period).
</details>

**26. Why do NoSQL databases (like Cassandra or MongoDB) naturally scale horizontally better than traditional SQL databases (like MySQL)?**
- A) NoSQL uses smaller hard drives.
- B) Traditional SQL requires rigid schemas and strict ACID guarantees (which require heavy locking across servers). NoSQL often relaxes ACID constraints (Eventual Consistency), making data distribution across nodes much easier.
- C) NoSQL is written in Assembly language.
- D) NoSQL databases do not store actual data.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Traditional SQL requires rigid schemas and strict ACID guarantees... NoSQL often relaxes ACID constraints...<br>
**Explanation:** Maintaining perfect transaction integrity across 100 servers in a distributed SQL database is incredibly slow due to network locks. NoSQL was designed from the ground up to prioritize horizontal scale over perfect immediate consistency.
</details>

**27. What is "Consistent Hashing" and why is it vital for scaling distributed caches (like a Redis cluster)?**
- A) It ensures all passwords are encrypted exactly the same way.
- B) It is a hashing algorithm that minimizes the number of keys that need to be remapped when a cache node is added or removed from the horizontally scaled cluster.
- C) It compresses the cache to save RAM.
- D) It forces all users to use the same server.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It is a hashing algorithm that minimizes the number of keys that need to be remapped...<br>
**Explanation:** If you have 4 Redis servers and use standard `hash % 4`, adding a 5th server (`hash % 5`) changes the math for almost every key, causing a massive cache miss storm. Consistent hashing maps keys to a ring, so adding a 5th server only affects ~20% of the keys.
</details>

**28. How does a "Message Queue" (like RabbitMQ or Kafka) assist in scaling an application?**
- A) It sends SMS messages to users.
- B) It acts as a buffer. It decouples heavy background tasks from the fast web servers, allowing worker servers to consume and process the tasks at their own scalable pace without dropping requests during traffic spikes.
- C) It provides a UI for the database.
- D) It replaces the Load Balancer.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It acts as a buffer. It decouples heavy background tasks...<br>
**Explanation:** If 10,000 users upload a video to be processed, the web server doesn't process them. It drops 10,000 messages in Kafka. A pool of worker servers reads from Kafka and processes them safely, preventing the web servers from crashing.
</details>

**29. What is "Serverless Computing" (e.g., AWS Lambda) in the context of Scalability?**
- A) An architecture where there are absolutely no physical servers anywhere.
- B) An execution model where the cloud provider dynamically manages the allocation and provisioning of servers. It automatically scales from zero to tens of thousands of concurrent functions per second based on demand, charging only for the exact milliseconds used.
- C) A mobile app that works offline.
- D) Using a laptop instead of a server.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An execution model where the cloud provider dynamically manages... automatically scales from zero...<br>
**Explanation:** Serverless is the ultimate form of Elasticity. You don't manage OS updates, load balancers, or auto-scaling groups. You just write code, and AWS scales it instantly based on traffic.
</details>

**30. Which of the following is an example of a system reaching the limits of its Vertical Scalability?**
- A) The web server runs out of IP addresses.
- B) The database requires more RAM to hold its indexes, but it is already running on the largest, most expensive instance type offered by AWS (e.g., 24TB of RAM), and no bigger machine exists.
- C) The Load Balancer refuses to accept more than 2 servers.
- D) The application code cannot be compiled anymore.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The database requires more RAM... but it is already running on the largest... machine exists.<br>
**Explanation:** This is the hard limit of Vertical scaling. Once you buy the biggest machine money can buy, you have hit a wall. At this point, you are forced to re-architect the database to scale horizontally (Sharding).
</details>
