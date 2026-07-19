# Quiz: Distributed Transactions (Chapter 16)

Test your knowledge of the Two-Phase Commit (2PC), Saga Pattern, CQRS, and Event Sourcing! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What is a "Transaction" in traditional database systems?**
- A) A payment made by a user.
- B) A single unit of work consisting of one or more database operations that must either ALL succeed or ALL fail (ACID properties).
- C) Transferring data from a hard drive to RAM.
- D) A network packet sent over TCP.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A single unit of work consisting of one or more database operations that must either ALL succeed or ALL fail...<br>
**Explanation:** If you transfer money, you must deduct from Account A and add to Account B. If one step fails, the entire transaction is rolled back so no money is lost.
</details>

**2. Why are Distributed Transactions much harder to implement than traditional transactions?**
- A) Because the data is spread across multiple independent databases and microservices, meaning you cannot rely on a single database's internal ACID locks.
- B) Because distributed systems cannot use SQL.
- C) Because distributed servers run on different timezones.
- D) Because distributed databases do not support passwords.
<details>
<summary>Answer</summary>
**Correct Answer:** A) Because the data is spread across multiple independent databases... meaning you cannot rely on a single database's internal ACID locks.<br>
**Explanation:** In a monolith, MySQL handles everything. In microservices, if the Payment Service uses PostgreSQL and the Inventory Service uses MongoDB, getting them to commit simultaneously over a network is extremely complex.
</details>

**3. What does "2PC" stand for?**
- A) Two-Protocol Connection
- B) Two-Phase Commit
- C) Two-Process Communication
- D) Two-Part Cryptography
<details>
<summary>Answer</summary>
**Correct Answer:** B) Two-Phase Commit<br>
**Explanation:** It is the classic algorithm for handling distributed transactions by breaking the commit process into two distinct phases (Prepare and Commit).
</details>

**4. In the Two-Phase Commit (2PC) protocol, what happens during the "Prepare" phase?**
- A) The databases delete their old data to make room.
- B) A central Coordinator asks all participating databases if they are ready to commit, and they lock their resources and reply "Yes" or "No".
- C) The user prepares their credit card.
- D) The system compresses the data.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A central Coordinator asks all participating databases if they are ready to commit, and they lock their resources...<br>
**Explanation:** Before actually saving the data permanently, the Coordinator makes sure that absolutely everyone is capable of doing so without errors.
</details>

**5. What is the biggest drawback of the Two-Phase Commit (2PC) protocol?**
- A) It is too fast and causes race conditions.
- B) It is a "blocking" protocol. Databases keep rows locked while waiting for the Coordinator, and if the Coordinator crashes, the databases can become deadlocked indefinitely.
- C) It only works with NoSQL databases.
- D) It requires users to double-click to confirm actions.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It is a "blocking" protocol... if the Coordinator crashes, the databases can become deadlocked...<br>
**Explanation:** Because of this severe performance bottleneck and risk of deadlocks, 2PC is almost entirely avoided in modern microservice and cloud architectures.
</details>

**6. What modern pattern is generally used instead of 2PC in Microservices?**
- A) The Saga Pattern
- B) The Singleton Pattern
- C) The MVC Pattern
- D) The Gateway Pattern
<details>
<summary>Answer</summary>
**Correct Answer:** A) The Saga Pattern<br>
**Explanation:** The Saga pattern embraces the distributed nature of microservices by avoiding global locks and instead using a sequence of local transactions.
</details>

**7. What is a "Compensating Transaction" in the Saga pattern?**
- A) Giving a user a discount code.
- B) A specific transaction designed to "undo" or reverse the effects of a previous successful transaction if a later step in the Saga fails.
- C) Paying a developer for writing code.
- D) Retrying a failed database write.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A specific transaction designed to "undo" or reverse the effects of a previous successful transaction...<br>
**Explanation:** You can't magically rollback a committed transaction in another service. If Payment succeeded but Inventory failed, you must explicitly execute a NEW transaction in the Payment service to refund the money.
</details>

**8. What does "CQRS" stand for?**
- A) Central Query Retrieval System
- B) Command Query Responsibility Segregation
- C) Concurrent Query Routing Server
- D) Cached Query Resolution Service
<details>
<summary>Answer</summary>
**Correct Answer:** B) Command Query Responsibility Segregation<br>
**Explanation:** It is an architectural pattern that strictly separates the operations that read data (Queries) from the operations that update data (Commands).
</details>

**9. In CQRS, what is a "Command"?**
- A) Fetching the user's profile.
- B) Any operation that changes the state of the system (e.g., Create, Update, Delete) without returning business data.
- C) Typing code in a terminal.
- D) Searching for a product.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Any operation that changes the state of the system (e.g., Create, Update, Delete)...<br>
**Explanation:** Commands alter data. In CQRS, commands are usually routed to a database optimized for high-integrity writes (like a relational DB).
</details>

**10. What is "Event Sourcing"?**
- A) Buying concert tickets online.
- B) A pattern where state changes are not stored as current values, but rather as an immutable sequence of events (a log) that occurred over time.
- C) Finding the IP address of an event server.
- D) Writing HTML events like `onclick`.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A pattern where state changes are not stored as current values, but rather as an immutable sequence of events...<br>
**Explanation:** Instead of storing `Balance: $50`, Event Sourcing stores `[Deposited $100, Withdrew $30, Withdrew $20]`. You calculate the balance by replaying the events.
</details>

---

### Medium (Questions 11 - 20)

**11. In an Orchestration-based Saga, who controls the flow of the transaction?**
- A) The frontend UI.
- B) A centralized controller (the Orchestrator) that explicitly tells each participating service what local transaction to execute and when.
- C) The individual services decide among themselves.
- D) The database administrator.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A centralized controller (the Orchestrator) that explicitly tells each participating service...<br>
**Explanation:** Like an orchestra conductor, one central service manages the workflow (e.g., AWS Step Functions). If a step fails, the Orchestrator commands the previous services to run their compensating transactions.
</details>

**12. In a Choreography-based Saga, who controls the flow of the transaction?**
- A) A centralized orchestrator.
- B) No one. Each service independently listens to events from a Message Broker (like Kafka) and decides how to react, subsequently publishing its own events.
- C) The API Gateway.
- D) The primary database.
<details>
<summary>Answer</summary>
**Correct Answer:** B) No one. Each service independently listens to events... and decides how to react...<br>
**Explanation:** Like dancers (choreography) who know their steps based on the music, Service B listens for an "OrderCreated" event, does its job, and publishes a "PaymentProcessed" event for Service C to hear.
</details>

**13. What is a major ADVANTAGE of Choreography over Orchestration in the Saga pattern?**
- A) It is much easier to track the status of a complex transaction.
- B) It reduces the Single Point of Failure (SPOF) and bottleneck of having a central orchestrator, making the system more decentralized and loosely coupled.
- C) It guarantees 100% strong consistency.
- D) It requires no coding.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It reduces the Single Point of Failure (SPOF)... making the system more decentralized and loosely coupled.<br>
**Explanation:** Because there is no central brain, services just react to events. However, this makes it harder to debug when things go wrong (a disadvantage).
</details>

**14. Why is CQRS highly beneficial in read-heavy applications (like E-commerce or Social Media)?**
- A) It forces reads and writes to use the exact same server.
- B) It allows you to use a heavily normalized SQL database for strict writes, while simultaneously syncing that data to a denormalized NoSQL database (like Elasticsearch or Redis) specifically optimized for blazing-fast reads.
- C) It prevents users from reading data.
- D) It uses less hard drive space.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It allows you to use a heavily normalized SQL database for strict writes, while simultaneously syncing that data to a denormalized NoSQL database...<br>
**Explanation:** You get the best of both worlds. Safe, ACID-compliant writes on one side, and massively scalable, fast, flexible reads on the other side.
</details>

**15. What is the biggest trade-off/disadvantage introduced by implementing CQRS?**
- A) It limits the application to a single server.
- B) Eventual Consistency. The Read database might lag slightly behind the Write database, meaning a user might update their profile but see the old profile when they immediately refresh the page.
- C) It causes the database to crash frequently.
- D) It encrypts data permanently.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Eventual Consistency. The Read database might lag slightly behind the Write database...<br>
**Explanation:** Because data must be copied from the Write DB to the Read DB (usually via a message broker), there is a slight delay. UI designers must account for this (e.g., showing a "Pending" status).
</details>

**16. How does Event Sourcing help with auditing and debugging?**
- A) It deletes logs automatically to save space.
- B) Because every single change is saved as an immutable event, it creates a perfect, unalterable audit trail. You can "time travel" by replaying events up to a specific timestamp to see exactly what the system state was at that moment.
- C) It sends an email to the admin for every click.
- D) It uses blockchain to encrypt logs.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because every single change is saved as an immutable event, it creates a perfect, unalterable audit trail...<br>
**Explanation:** If a bug corrupted user balances today, you can wipe the database, replay all events from the beginning of time up until yesterday, and perfectly restore the healthy state.
</details>

**17. What is a "Snapshot" in the context of Event Sourcing?**
- A) A screenshot of the UI.
- B) Because replaying a million events to calculate a bank balance is slow, the system periodically saves the computed current state (a snapshot). To get the balance, you load the latest snapshot and only replay events that happened *after* it.
- C) Taking a picture of the server rack.
- D) A backup stored on AWS S3.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because replaying a million events... is slow, the system periodically saves the computed current state...<br>
**Explanation:** Snapshots are a performance optimization. If an account has 10,000 transactions over 10 years, you might save a snapshot of the balance every month so you only have to replay a maximum of 30 days of events.
</details>

**18. Why do Event Sourcing and CQRS almost always go together?**
- A) They are built by the same company.
- B) Because an Event Store (an append-only log of events) is terrible at answering complex queries like "Show me all users with a balance over $100". CQRS takes those events and projects them into a Read database that can easily answer those queries.
- C) Because Event Sourcing requires relational tables.
- D) Because CQRS cannot function without an event log.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because an Event Store... is terrible at answering complex queries... CQRS takes those events and projects them into a Read database...<br>
**Explanation:** The "Command" side is the Event Store (writing events). The "Query" side listens to those events and builds a standard searchable database table out of them.
</details>

**19. What is a "Distributed Lock" (e.g., using Redis or ZooKeeper)?**
- A) A physical padlock on a server.
- B) A mechanism to ensure that multiple independent microservices do not simultaneously modify the same shared resource, preventing race conditions across the network.
- C) A firewall that blocks IP addresses.
- D) A tool for encrypting passwords.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A mechanism to ensure that multiple independent microservices do not simultaneously modify the same shared resource...<br>
**Explanation:** Even without 2PC, sometimes you absolutely must prevent two services from modifying the same data at the same millisecond. A distributed lock acts as a global "Do Not Disturb" sign.
</details>

**20. In an Orchestration Saga, what happens if the Orchestrator service itself crashes halfway through a transaction?**
- A) The transaction is permanently lost.
- B) Modern Orchestrators (like Temporal or AWS Step Functions) persistently save their execution state to a database. When they restart, they resume the workflow exactly where it left off.
- C) It deletes the databases.
- D) It triggers a DDoS attack.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Modern Orchestrators... persistently save their execution state to a database. When they restart, they resume...<br>
**Explanation:** This is why you use specialized workflow engines for Sagas rather than writing your own `while` loops. They are designed to be fault-tolerant and resume after a crash.
</details>

---

### Hard (Questions 21 - 30)

**21. What does it mean when we say a Compensating Transaction must be "Idempotent"?**
- A) It must run very fast.
- B) If the compensating transaction fails due to a network glitch and is retried, executing it multiple times must have the exact same effect as executing it once (e.g., it doesn't accidentally refund the user twice).
- C) It must be written in Python.
- D) It must use a relational database.
<details>
<summary>Answer</summary>
**Correct Answer:** B) If the compensating transaction fails... executing it multiple times must have the exact same effect as executing it once...<br>
**Explanation:** Network failures mean messages might be delivered multiple times. If your refund logic says "Add $50 to balance," running it twice adds $100 (Bad). It must say "Set balance to $100 if it hasn't been refunded yet."
</details>

**22. What is the "Semantic Lock" countermeasure in a Saga pattern?**
- A) A lock on the database table.
- B) An application-level flag (e.g., setting a record's status to `PENDING`) that indicates a Saga is currently modifying this data, warning other transactions to either wait or proceed with caution to avoid dirty reads.
- C) A security protocol.
- D) A password hashing algorithm.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An application-level flag (e.g., setting a record's status to `PENDING`)...<br>
**Explanation:** Because Sagas don't use database-level ACID locks, another user might read data while a Saga is halfway done. Using a status flag tells the application, "This data is in a transitional state."
</details>

**23. How does the "Outbox Pattern" solve the dual-write problem in Microservices?**
- A) By sending emails automatically.
- B) Instead of trying to write to the database AND publish an event to Kafka simultaneously (which can fail midway), the service writes the data AND the event to the *same* database in a single local transaction (to an "Outbox" table). A background process then safely reads the Outbox table and publishes the events to Kafka.
- C) By using a 2PC protocol.
- D) By storing data in an inbox.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Instead of trying to write to the database AND publish an event... the service writes the data AND the event to the *same* database in a single local transaction...<br>
**Explanation:** This guarantees atomicity. The business data and the event are saved together safely. The background process (like Debezium) ensures the event eventually reaches Kafka, eliminating the risk of dual-write failures.
</details>

**24. What is "Change Data Capture (CDC)" in relation to the Outbox Pattern?**
- A) Taking screenshots of the database.
- B) A technology that listens to the database's internal transaction log (e.g., MySQL Binlog) to detect when changes occur (like a new row in the Outbox table) and instantly streams those changes as events to a message broker.
- C) A tool that captures user keystrokes.
- D) A protocol for compressing data.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A technology that listens to the database's internal transaction log... to detect when changes occur...<br>
**Explanation:** Tools like Debezium use CDC to reliably extract events from the database log and push them to Kafka, completing the Outbox pattern with zero data loss.
</details>

**25. In Event Sourcing, what is an "Aggregate"?**
- A) A mathematical sum of all events.
- B) A Domain-Driven Design concept representing a cluster of domain objects that can be treated as a single unit for data changes, ensuring business invariants are maintained when applying events.
- C) A type of NoSQL database.
- D) A load balancing algorithm.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A Domain-Driven Design concept representing a cluster of domain objects that can be treated as a single unit...<br>
**Explanation:** An Aggregate (like an "Order" which contains "Order Items") acts as a consistency boundary. Events are applied to an Aggregate to reconstruct its state and ensure rules (like "An order must have at least one item") are enforced.
</details>

**26. What happens if a Compensating Transaction in a Saga permanently fails, even after retries?**
- A) The database deletes itself.
- B) The system must rely on manual intervention. It should alert human operators via monitoring systems (or a Dead Letter Queue) to investigate and manually fix the inconsistent data.
- C) The system automatically issues a 2PC.
- D) The system ignores it and continues.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The system must rely on manual intervention. It should alert human operators...<br>
**Explanation:** Sagas are robust but not invincible. If a refund fails because the payment gateway's API is permanently broken, a human developer/admin must eventually step in to resolve the inconsistency.
</details>

**27. In CQRS, what is a "Projection"?**
- A) Displaying data on a screen.
- B) The process of listening to the stream of events generated by Commands, applying business logic, and transforming/saving that data into a format specifically optimized for the Query database.
- C) Predicting future database size.
- D) Generating 3D graphics.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The process of listening to the stream of events... transforming/saving that data into a format specifically optimized for the Query database.<br>
**Explanation:** The "Projector" is the bridge in CQRS. It takes a raw event ("UserUpdatedName") and updates the Read database (e.g., updating the user document in Elasticsearch) so the UI can query it fast.
</details>

**28. Why is "Event Versioning" a critical challenge in Event Sourcing?**
- A) Because events take up too much storage space.
- B) Over time, the structure of events changes (e.g., adding a "discount_code" field). Replaying old events (Version 1) alongside new events (Version 2) requires complex code (Upcasters) to ensure the system can still interpret the old data correctly.
- C) Because Git cannot track events.
- D) Because versioning breaks the database locks.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Over time, the structure of events changes... Replaying old events... requires complex code... to ensure the system can still interpret the old data...<br>
**Explanation:** Unlike a standard DB where you just `ALTER TABLE`, an event store is immutable. If the event format changes, your application code must be smart enough to handle events written 5 years ago in an old format.
</details>

**29. What is a "Commutative" operation, and why is it useful in distributed systems?**
- A) An operation that commutes to work.
- B) An operation where changing the order of execution does not change the final result (e.g., Addition: A+B = B+A). Designing events to be commutative makes the system highly resilient to messages arriving out-of-order.
- C) An operation that deletes data.
- D) An operation that requires 2PC.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An operation where changing the order of execution does not change the final result...<br>
**Explanation:** In distributed systems, messages often arrive out of order. If your logic is "Add 5, then Add 10", the order doesn't matter. If your logic is "Multiply by 2, then Add 10", order matters greatly, which is much harder to coordinate.
</details>

**30. Which of the following best summarizes when you should use Event Sourcing + CQRS?**
- A) For every single microservice, regardless of complexity.
- B) For extremely complex domains where an exact audit trail is mandatory (banking, legal, complex state machines), and the read/write performance requirements are vastly different, justifying the immense operational complexity.
- C) For building a simple blog or static website.
- D) When you don't know how to write SQL.
<details>
<summary>Answer</summary>
**Correct Answer:** B) For extremely complex domains where an exact audit trail is mandatory... justifying the immense operational complexity.<br>
**Explanation:** Event Sourcing and CQRS are considered highly advanced, "heavyweight" patterns. They add significant complexity and should only be used when the business domain absolutely requires their benefits.
</details>
