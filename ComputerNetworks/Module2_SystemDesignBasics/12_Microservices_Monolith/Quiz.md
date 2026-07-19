# Quiz: Microservices vs Monolith (Chapter 12)

Test your knowledge of Monolithic Architectures, Microservices, SOA, and inter-process communication! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What is a Monolithic Architecture?**
- A) A system where data is stored in memory.
- B) An architectural style where all components of an application (UI, business logic, database access) are combined into a single, unified codebase and executable.
- C) An architecture exclusively for mobile apps.
- D) A system that uses multiple programming languages for a single function.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An architectural style where all components... are combined into a single, unified codebase...<br>
**Explanation:** "Monolith" means one giant stone. In software, it means everything is bundled together in one massive project directory and runs as a single process.
</details>

**2. What is a Microservices Architecture?**
- A) An architecture that only uses micro-computers like Raspberry Pi.
- B) An architectural style that structures an application as a collection of small, loosely coupled, and independently deployable services.
- C) A way to compress code to make it smaller.
- D) An architecture where every function is stored in a separate database.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An architectural style that structures an application as a collection of small, loosely coupled... services.<br>
**Explanation:** Instead of one big app, you have 20 small apps that talk to each other over the network to form the complete application.
</details>

**3. Which of the following is a primary ADVANTAGE of a Monolithic Architecture?**
- A) It is very easy to scale individual features.
- B) It is immune to system-wide crashes.
- C) It is generally simpler to develop, test, and deploy initially.
- D) It allows teams to use 10 different programming languages easily.
<details>
<summary>Answer</summary>
**Correct Answer:** C) It is generally simpler to develop, test, and deploy initially.<br>
**Explanation:** For small teams and new projects, a monolith is much faster to build. You don't have to deal with complex network routing, distributed databases, or Docker orchestration.
</details>

**4. Which of the following is a primary DISADVANTAGE of a Monolithic Architecture?**
- A) It requires too many network HTTP calls between internal functions.
- B) A single memory leak or fatal bug in one minor feature can crash the entire application.
- C) It is impossible to connect it to a database.
- D) It cannot be run on a cloud server.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A single memory leak or fatal bug in one minor feature can crash the entire application.<br>
**Explanation:** Because all code runs in the same process and shares the same memory, a bug in the "Send Newsletter" function could crash the "Payment Processing" function.
</details>

**5. How are components coupled in a Monolithic Architecture vs Microservices?**
- A) Monoliths are loosely coupled; Microservices are tightly coupled.
- B) Monoliths are tightly coupled; Microservices are loosely coupled (decoupled).
- C) Both are tightly coupled.
- D) Both are loosely coupled.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Monoliths are tightly coupled; Microservices are loosely coupled (decoupled).<br>
**Explanation:** In a monolith, changing a database schema might break 10 different parts of the code. In microservices, services are isolated (decoupled), so changing the `Cart` service doesn't break the `Auth` service.
</details>

**6. What is a major ADVANTAGE of Microservices regarding scalability?**
- A) They cannot be scaled.
- B) They can only be scaled vertically.
- C) You can independently scale specific services that are under heavy load without wasting resources scaling the entire application.
- D) You must scale all microservices together at all times.
<details>
<summary>Answer</summary>
**Correct Answer:** C) You can independently scale specific services that are under heavy load...<br>
**Explanation:** If your Video Encoding service is overwhelmed, you can spin up 50 instances of just the Video Encoding service, while leaving the User Profile service at 2 instances. This saves immense amounts of money.
</details>

**7. In a Microservices architecture, how do different services typically communicate with each other?**
- A) By directly reading each other's RAM.
- B) By sharing a single global variable.
- C) Over a network using Inter-Process Communication (IPC) like HTTP/REST APIs, gRPC, or Message Queues.
- D) By reading files from the same hard drive.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Over a network using Inter-Process Communication (IPC)...<br>
**Explanation:** Because they are separate processes (often on separate physical servers), they must communicate over the network.
</details>

**8. What does "Technology Diversity" mean in the context of Microservices?**
- A) The team must use the exact same technology for every service.
- B) Different teams can choose the best programming language, framework, and database for their specific service (e.g., Python for AI, Go for networking).
- C) The application must run on Windows, Mac, and Linux simultaneously.
- D) Using multiple browsers to test the app.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Different teams can choose the best programming language... for their specific service...<br>
**Explanation:** This is a huge benefit. You aren't locked into one technology. A monolith forces you to use one language for everything.
</details>

**9. When starting a brand-new startup to build a Minimum Viable Product (MVP), which architecture is generally recommended by experts?**
- A) Microservices, because they scale better later.
- B) Monolith, because it is simpler, faster to iterate, and avoids premature optimization and operational complexity.
- C) Serverless architecture only.
- D) Blockchain architecture.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Monolith, because it is simpler, faster to iterate...<br>
**Explanation:** "Don't build microservices until you have a monolith that is too big to manage." Building microservices on day one usually leads to failing to deliver the product because the team spends all their time fighting infrastructure.
</details>

**10. What is "Fault Isolation"?**
- A) When a developer works alone.
- B) The ability of a system to contain a failure so it doesn't spread. Microservices have excellent fault isolation; if the "Email" service crashes, the "Checkout" service can still function.
- C) When a bug is impossible to find.
- D) When servers are physically separated by a wall.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The ability of a system to contain a failure so it doesn't spread.<br>
**Explanation:** Because microservices run in isolated processes, a crash in one does not take down the entire system, leading to higher overall Availability.
</details>

---

### Medium (Questions 11 - 20)

**11. Why is data management often considered the hardest part of adopting Microservices?**
- A) Because SQL cannot be used in microservices.
- B) Because best practices dictate that every microservice should have its own private database, making cross-service queries (Joins) and distributed transactions incredibly difficult.
- C) Because microservices cannot connect to databases over the network.
- D) Because all data must be stored in JSON files.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because best practices dictate that every microservice should have its own private database...<br>
**Explanation:** In a monolith, you just do a `JOIN` between the Users and Orders tables. In microservices, the Users DB and Orders DB are entirely separate, so a simple `JOIN` becomes a complex network API call and data aggregation problem.
</details>

**12. What is SOA (Service-Oriented Architecture)?**
- A) The exact same thing as Microservices, just an older name.
- B) An older enterprise architectural style where large services communicated through a heavy, centralized Enterprise Service Bus (ESB).
- C) A monolithic architecture that uses APIs.
- D) An architecture strictly for SOAP APIs.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An older enterprise architectural style where large services communicated through a heavy... ESB.<br>
**Explanation:** SOA often involved massive services (e.g., an entire HR department system) communicating through a "smart" ESB that handled routing and transformation. Microservices favors small services and "dumb" pipes (simple HTTP).
</details>

**13. What is the "Two-Pizza Team" rule (coined by Amazon) and how does it relate to Microservices?**
- A) Developers must be fed pizza to code faster.
- B) A development team should be small enough to be fed by two pizzas (roughly 6-10 people). Microservices align with this perfectly, as one small team can fully own, build, and deploy one microservice independently.
- C) A server must be the size of two pizzas.
- D) A microservice should cost the equivalent of two pizzas per month to run.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A development team should be small enough to be fed by two pizzas...<br>
**Explanation:** Microservices aren't just a technical solution; they are an organizational solution. They allow a company of 1,000 developers to work as 100 autonomous small teams without stepping on each other's toes.
</details>

**14. What problem does "Network Latency" introduce in Microservices?**
- A) It makes the UI look distorted.
- B) A single user request to the frontend might require 10 different microservices to talk to each other over the network, adding milliseconds of delay at each hop, resulting in a slow overall response.
- C) It causes the databases to delete data.
- D) It encrypts the network packets.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A single user request... might require 10 different microservices to talk... adding milliseconds of delay...<br>
**Explanation:** In a monolith, calling a function takes microseconds (memory speed). In microservices, calling a function takes milliseconds (network speed). Too many chained API calls will kill performance.
</details>

**15. How do Microservices typically solve the problem of slow, synchronous HTTP communication between services?**
- A) By putting all services back into a Monolith.
- B) By using Asynchronous Communication via Message Brokers (like Apache Kafka or RabbitMQ) or Event-Driven architectures.
- C) By using a VPN.
- D) By increasing the RAM of the servers.
<details>
<summary>Answer</summary>
**Correct Answer:** B) By using Asynchronous Communication via Message Brokers...<br>
**Explanation:** Instead of Service A waiting for an HTTP response from Service B, Service A drops an event ("Order Created") into Kafka and immediately responds to the user. Service B reads the event whenever it's ready.
</details>

**16. What is the "API Gateway" pattern in a Microservices architecture?**
- A) A physical router in the data center.
- B) A single entry point that acts as a Reverse Proxy for all clients, routing their requests to the correct internal microservices, and often handling authentication and rate limiting.
- C) A tool used to connect to the database.
- D) A payment gateway for credit cards.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A single entry point that acts as a Reverse Proxy for all clients, routing their requests...<br>
**Explanation:** Without an API Gateway, a mobile app would have to know the IP addresses of 20 different microservices. The Gateway provides a clean, unified API to the outside world.
</details>

**17. What is "Distributed Tracing" (e.g., Jaeger, Zipkin) and why is it essential for Microservices?**
- A) Tracing the physical location of servers on a map.
- B) A method to track a single user request as it travels across multiple different microservices, which is critical for debugging where an error or slowdown occurred.
- C) A way to trace stolen passwords.
- D) A protocol for downloading large files.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A method to track a single user request as it travels across multiple different microservices...<br>
**Explanation:** In a monolith, a stack trace tells you exactly where a crash happened. In microservices, a request might touch 5 services. If it fails on the 4th, distributed tracing lets you see the entire path and find the culprit.
</details>

**18. What is the "Strangler Fig Pattern"?**
- A) A security mechanism to strangle DDoS attacks.
- B) A popular strategy for migrating from a Monolith to Microservices by gradually replacing specific pieces of the monolith's functionality with new microservices, until the monolith can be "strangled" and shut down.
- C) A database joining algorithm.
- D) A networking pattern that restricts bandwidth.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A popular strategy for migrating from a Monolith to Microservices by gradually replacing specific pieces...<br>
**Explanation:** Rewriting a monolith from scratch takes years and often fails. The Strangler pattern advocates for chipping away at it one feature at a time (e.g., move only "Billing" to a microservice today).
</details>

**19. Why do Microservices heavily rely on CI/CD (Continuous Integration / Continuous Deployment) and Containerization (Docker/Kubernetes)?**
- A) Because CI/CD is required by law.
- B) Because manually deploying, configuring, and tracking 50 different applications across hundreds of servers is humanly impossible; it must be completely automated.
- C) Because Docker makes the code run faster than bare metal.
- D) Because Kubernetes writes the code for you.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because manually deploying... 50 different applications... is humanly impossible; it must be completely automated.<br>
**Explanation:** The operational overhead (DevOps complexity) is the biggest drawback of microservices. Without strong automation (Docker, K8s, CI/CD pipelines), a microservices architecture will collapse under its own weight.
</details>

**20. What is "Eventual Consistency"?**
- A) A guarantee that a database will eventually crash.
- B) A model in distributed systems (common in microservices) where data changes are not immediately reflected across all databases, but are guaranteed to sync "eventually" after a short delay.
- C) Consistent UI design across all services.
- D) When all developers consistently write good code.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A model... where data changes are not immediately reflected across all databases, but are guaranteed to sync "eventually"...<br>
**Explanation:** Because microservices have separate databases, a user updating their address in the "User Service" might take 2 seconds to propagate to the "Shipping Service". The system is "eventually" consistent.
</details>

---

### Hard (Questions 21 - 30)

**21. In a Microservices architecture, what is the "Saga Pattern"?**
- A) A long story written in the code comments.
- B) A design pattern used to manage distributed transactions across multiple microservices without using strict ACID locks, typically through a sequence of local transactions and compensating (rollback) actions.
- C) A tool used to compress log files.
- D) A specific type of Load Balancer.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A design pattern used to manage distributed transactions... through a sequence of local transactions and compensating actions.<br>
**Explanation:** Since you can't use a standard SQL transaction across two separate databases, a Saga orchestrates it. If Step 1 (Deduct Money) succeeds, but Step 2 (Reserve Inventory) fails, the Saga automatically triggers a "Compensating Transaction" (Refund Money) to undo Step 1.
</details>

**22. What is the difference between an Orchestration-based Saga and a Choreography-based Saga?**
- A) Orchestration uses humans; Choreography uses AI.
- B) In Orchestration, a central controller dictates the steps; in Choreography, each service reacts autonomously to events published by other services without a central controller.
- C) Orchestration is for monoliths; Choreography is for microservices.
- D) Orchestration uses REST; Choreography uses gRPC.
<details>
<summary>Answer</summary>
**Correct Answer:** B) In Orchestration, a central controller dictates the steps; in Choreography, each service reacts autonomously...<br>
**Explanation:** Think of Orchestration like a conductor leading an orchestra. Think of Choreography like dancers reacting to the music and each other, without anyone telling them specifically what to do next.
</details>

**23. What is "gRPC" and why is it increasingly favored over REST for internal microservice communication?**
- A) It is a protocol that uses XML.
- B) A high-performance Remote Procedure Call framework developed by Google that uses HTTP/2 and Protocol Buffers (binary data), making it vastly faster and more efficient than text-based JSON/REST.
- C) It is a database query language.
- D) It is a tool for rendering UI components.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A high-performance Remote Procedure Call framework... that uses HTTP/2 and Protocol Buffers...<br>
**Explanation:** JSON is heavy and requires parsing. gRPC sends highly compressed binary data over persistent HTTP/2 connections, drastically reducing network latency between internal services.
</details>

**24. What is the "BFF (Backend for Frontend)" pattern?**
- A) When backend developers and frontend developers are best friends.
- B) Creating multiple, specialized API Gateways tailored for specific client types (e.g., one API for Mobile Apps, one for Web Apps, one for Smart TVs) rather than a single generic API.
- C) Using Node.js on the backend.
- D) Storing frontend code in the backend database.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Creating multiple, specialized API Gateways tailored for specific client types...<br>
**Explanation:** A mobile app might need less data per request than a desktop web dashboard. A BFF tailors the data aggregation for each specific frontend, improving performance for that device.
</details>

**25. What is a "Service Mesh" (e.g., Istio, Linkerd) designed to handle in a microservices ecosystem?**
- A) The actual business logic of the application.
- B) The frontend user interface.
- C) The complex operational requirements of service-to-service communication, including mutual TLS, retries, circuit breaking, and observability, by injecting sidecar proxies next to every service.
- D) Database backups.
<details>
<summary>Answer</summary>
**Correct Answer:** C) The complex operational requirements of service-to-service communication... by injecting sidecar proxies...<br>
**Explanation:** Instead of writing retry logic and encryption logic into the Java/Python code of every single microservice, a Service Mesh handles all of it at the network layer transparently.
</details>

**26. Why is sharing a single database among multiple microservices considered an anti-pattern?**
- A) Because databases cannot handle multiple connections.
- B) It violates the principle of loose coupling; if one service changes the database schema, it might instantly break all other services that rely on that schema.
- C) Because it is too fast and causes race conditions.
- D) Because SQL does not allow it.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It violates the principle of loose coupling; if one service changes the database schema, it might instantly break all other services...<br>
**Explanation:** The golden rule of microservices is "Database per Service". If they share a DB, they are not truly independent. You have built a "Distributed Monolith," which has the disadvantages of both architectures.
</details>

**27. What is the "CQRS (Command Query Responsibility Segregation)" pattern, often used in microservices?**
- A) A pattern that combines all commands into a single file.
- B) A pattern that strictly separates the data modification operations (Commands/Writes) from the data retrieval operations (Queries/Reads), often using separate databases tailored for each.
- C) A pattern for separating CSS from HTML.
- D) A security pattern that blocks SQL injection.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A pattern that strictly separates the data modification operations... from the data retrieval operations...<br>
**Explanation:** In complex systems, how you write data is often very different from how you need to query it. CQRS allows you to optimize the Write database (e.g., relational SQL) separately from the Read database (e.g., Elasticsearch).
</details>

**28. How does "Event Sourcing" differ from traditional database state storage?**
- A) It uses a calendar to store events.
- B) Instead of only storing the *current state* of an object (e.g., Balance = $50), Event Sourcing stores every individual *event* that led to that state (e.g., Deposited $100, Withdrew $50) in an immutable append-only log.
- C) It stores data directly in the browser.
- D) It deletes data after an event is over.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Instead of only storing the *current state*... Event Sourcing stores every individual *event*...<br>
**Explanation:** Used heavily in finance and complex microservices, it allows you to completely rebuild the current state at any time by replaying the history of events. It provides a perfect audit trail.
</details>

**29. What is a "Distributed Monolith"?**
- A) A highly successful microservice implementation.
- B) A system that deployed multiple services but failed to decouple them properly (e.g., they share a DB, or make deep synchronous calls to each other). It suffers the operational complexity of microservices but retains the tight coupling of a monolith.
- C) A monolith deployed across multiple continents.
- D) A database that spans multiple hard drives.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A system that deployed multiple services but failed to decouple them properly...<br>
**Explanation:** This is the worst-case scenario. You get none of the benefits of microservices, but all of the pain of managing distributed network infrastructure.
</details>

**30. Which Conway's Law principle deeply affects whether a company should choose Microservices?**
- A) "Software runs slower every year."
- B) "Organizations which design systems are constrained to produce designs which are copies of the communication structures of these organizations."
- C) "There is no cloud, just someone else's computer."
- D) "Code is read more often than it is written."
<details>
<summary>Answer</summary>
**Correct Answer:** B) "Organizations which design systems are constrained to produce designs which are copies of the communication structures of these organizations."<br>
**Explanation:** Conway's Law suggests that if you have 5 heavily siloed departments, you will end up building an architecture with 5 distinct services. Microservices work best when the organizational structure (small, autonomous teams) matches the software structure.
</details>
