# Quiz: API Gateways & Service Mesh (Chapter 14)

Test your knowledge of API Gateways, Service Meshes, Sidecar patterns, and inter-service communication! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What is an API Gateway?**
- A) A physical router used in home networks.
- B) A single entry point (reverse proxy) that sits between clients (e.g., mobile apps, web browsers) and a collection of backend microservices.
- C) A database schema designed for APIs.
- D) A protocol used exclusively for file transfers.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A single entry point (reverse proxy) that sits between clients... and... backend microservices.<br>
**Explanation:** The API Gateway acts as the "front door" for your entire system, routing all incoming user requests to the appropriate internal services.
</details>

**2. Which direction of network traffic does an API Gateway primarily handle?**
- A) East-West Traffic (Internal service-to-service).
- B) North-South Traffic (External client to internal system).
- C) Up-Down Traffic.
- D) Peer-to-Peer Traffic.
<details>
<summary>Answer</summary>
**Correct Answer:** B) North-South Traffic (External client to internal system).<br>
**Explanation:** In network diagrams, clients are drawn at the top (North) and servers at the bottom (South). The Gateway handles this external-to-internal flow.
</details>

**3. What is "Rate Limiting" in the context of an API Gateway?**
- A) Speeding up the internet connection of the user.
- B) Restricting the number of requests a single client (or IP address) can make within a specific timeframe to prevent abuse or DDoS attacks.
- C) Limiting the amount of money a user can spend on the website.
- D) Restricting the database to only accept SQL commands.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Restricting the number of requests a single client (or IP address) can make within a specific timeframe...<br>
**Explanation:** By applying rules like "Max 100 requests per minute per IP", the API Gateway protects the backend microservices from being overwhelmed by spam or malicious bots.
</details>

**4. Why is Authentication typically handled at the API Gateway rather than in every individual microservice?**
- A) Because microservices cannot read tokens.
- B) To centralize security. It prevents having to write and maintain the same login-verification code in 50 different microservices.
- C) Because API Gateways generate passwords.
- D) It shouldn't be; every microservice should always re-verify the user's password with the database.
<details>
<summary>Answer</summary>
**Correct Answer:** B) To centralize security. It prevents having to write and maintain the same login-verification code in 50 different microservices.<br>
**Explanation:** The Gateway checks the JWT token once. If valid, it forwards the request. The backend services trust the Gateway, saving code duplication and processing time.
</details>

**5. What is a "Service Mesh"?**
- A) A specialized UI framework for drawing grids.
- B) A dedicated infrastructure layer for facilitating, securing, and observing communication between internal microservices.
- C) A type of wireless router network.
- D) A database partitioning strategy.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A dedicated infrastructure layer for facilitating, securing, and observing communication between internal microservices.<br>
**Explanation:** While an API Gateway handles external clients, a Service Mesh manages the complex web of network calls *between* the microservices themselves.
</details>

**6. Which direction of network traffic does a Service Mesh primarily handle?**
- A) North-South Traffic (External client to internal system).
- B) East-West Traffic (Internal service-to-service).
- C) Outbound Traffic (Internal system to external internet).
- D) Localhost Traffic only.
<details>
<summary>Answer</summary>
**Correct Answer:** B) East-West Traffic (Internal service-to-service).<br>
**Explanation:** In network diagrams, internal services are drawn side-by-side. The Service Mesh manages how Service A (on the left/East) talks to Service B (on the right/West).
</details>

**7. What design pattern is almost universally used to implement a Service Mesh?**
- A) The MVC (Model-View-Controller) Pattern.
- B) The Singleton Pattern.
- C) The Sidecar Proxy Pattern.
- D) The Factory Pattern.
<details>
<summary>Answer</summary>
**Correct Answer:** C) The Sidecar Proxy Pattern.<br>
**Explanation:** In a Service Mesh, a tiny proxy server (the Sidecar) is deployed right alongside every microservice container. The microservice only talks to its sidecar, and the sidecars talk to each other.
</details>

**8. Which of the following is a highly popular, open-source API Gateway?**
- A) React
- B) Kong
- C) PostgreSQL
- D) Jenkins
<details>
<summary>Answer</summary>
**Correct Answer:** B) Kong<br>
**Explanation:** Kong (built on NGINX) is one of the most widely used API Gateways. Others include AWS API Gateway, Traefik, and Apigee.
</details>

**9. Which of the following is a highly popular, open-source Service Mesh?**
- A) Istio
- B) Ubuntu
- C) Apache HTTP Server
- D) Redis
<details>
<summary>Answer</summary>
**Correct Answer:** A) Istio<br>
**Explanation:** Istio, along with Linkerd and Consul, are the leading Service Mesh implementations used in Kubernetes environments.
</details>

**10. What is a major disadvantage of using an API Gateway?**
- A) It makes the system completely un-secure.
- B) It can become a Single Point of Failure (SPOF) and a potential bottleneck if not scaled properly.
- C) It forces users to install a desktop app.
- D) It prevents mobile apps from connecting.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It can become a Single Point of Failure (SPOF) and a potential bottleneck...<br>
**Explanation:** Because 100% of external traffic must pass through the Gateway, if the Gateway crashes, the entire system is down, even if the backend microservices are perfectly healthy.
</details>

---

### Medium (Questions 11 - 20)

**11. What is the "BFF" (Backend for Frontend) pattern in the context of API Gateways?**
- A) A pattern where developers are required to write frontend and backend code simultaneously.
- B) Deploying multiple, tailored API Gateways (e.g., one for Mobile, one for Web) so each frontend gets an API specifically optimized for its needs, rather than a single, bloated, one-size-fits-all API.
- C) A pattern where the frontend directly queries the SQL database.
- D) Using Node.js on both the frontend and backend.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Deploying multiple, tailored API Gateways... so each frontend gets an API specifically optimized for its needs...<br>
**Explanation:** A mobile app might need a lightweight JSON response with just 3 fields, while a desktop dashboard needs 20 fields. A BFF Gateway filters and formats the data perfectly for the specific device calling it.
</details>

**12. How does a Service Mesh help developers focus on writing business logic?**
- A) It automatically writes unit tests for them.
- B) It offloads complex network logic (like retries, timeouts, circuit breaking, and TLS encryption) from the application code (Java/Python) into the infrastructure layer (the Sidecar proxy).
- C) It translates their code into machine language faster.
- D) It provides a drag-and-drop UI for coding.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It offloads complex network logic... from the application code... into the infrastructure layer...<br>
**Explanation:** Without a Service Mesh, a Java developer must write `try-catch` blocks for network retries and implement SSL certificates inside their Java code. With a Service Mesh, they just write plain HTTP calls; the Sidecar handles the complex network realities.
</details>

**13. What is "mTLS" (Mutual TLS), and why is it a core feature of a Service Mesh?**
- A) It is a way to compress images.
- B) It ensures that traffic between microservices is strictly unencrypted for faster speed.
- C) It is a security protocol where both the client and the server cryptographically authenticate each other, ensuring that internal service-to-service communication is fully encrypted and trusted (Zero Trust Network).
- D) It allows multiple users to log in simultaneously.
<details>
<summary>Answer</summary>
**Correct Answer:** C) It is a security protocol where both the client and the server cryptographically authenticate each other...<br>
**Explanation:** Standard TLS (like HTTPS on a website) only authenticates the server. Mutual TLS (mTLS) means the Payment Service proves its identity to the Order Service, AND the Order Service proves its identity to the Payment Service, preventing internal impersonation.
</details>

**14. What is a "Circuit Breaker" pattern, commonly implemented by an API Gateway or Service Mesh?**
- A) A hardware switch that turns off the server rack.
- B) A pattern that detects when a downstream service is failing. Instead of continuing to send requests and waiting for timeouts, it "trips" the circuit, instantly returning an error to prevent cascading failures and allowing the failing service time to recover.
- C) A protocol for breaking large JSON files into smaller pieces.
- D) A security rule that blocks IP addresses permanently.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A pattern that detects when a downstream service is failing... it "trips" the circuit, instantly returning an error...<br>
**Explanation:** Just like an electrical circuit breaker prevents a house fire when a wire shorts, a software circuit breaker stops sending traffic to a struggling microservice so it doesn't crash completely.
</details>

**15. What is "API Composition" or "Data Aggregation" at the Gateway level?**
- A) Compressing the API responses using GZIP.
- B) The Gateway takes a single request from the client, makes multiple parallel requests to different backend microservices, aggregates their responses into one unified JSON object, and sends it back to the client.
- C) Converting XML APIs to REST APIs.
- D) Automatically generating API documentation.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The Gateway takes a single request... makes multiple parallel requests... aggregates their responses into one unified JSON object...<br>
**Explanation:** A mobile app wants the "User Profile". The Gateway fetches the Name from the `User Service`, the Avatar from the `Image Service`, and the Subscription status from the `Billing Service`, combining them into one fast response.
</details>

**16. In a Service Mesh architecture (like Istio), what is the difference between the "Data Plane" and the "Control Plane"?**
- A) The Data Plane stores databases; the Control Plane stores passwords.
- B) The Data Plane is the collection of all the Sidecar proxies that actually route the traffic. The Control Plane is the central management server that configures and pushes rules to those proxies.
- C) The Data Plane is for REST; the Control Plane is for gRPC.
- D) They are exactly the same thing.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The Data Plane is the collection of all the Sidecar proxies... The Control Plane is the central management server...<br>
**Explanation:** The proxies do the heavy lifting of moving bytes (Data Plane). The admin uses the Control Plane to say "Route 10% of traffic to the new V2 of the service," and the Control Plane updates all the proxies.
</details>

**17. How does a Service Mesh improve "Observability"?**
- A) By installing a webcam in the server room.
- B) Because all inter-service traffic flows through the sidecar proxies, the mesh can automatically generate detailed metrics, logs, and distributed traces without changing the application code.
- C) By sending an email every time a user logs in.
- D) By making the source code public.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because all inter-service traffic flows through the sidecar proxies, the mesh can automatically generate detailed metrics...<br>
**Explanation:** The sidecar knows exactly when a request was sent, when it returned, and if it failed. It sends this telemetry data to tools like Prometheus or Jaeger, giving you a perfect map of your system's health.
</details>

**18. Why would you use BOTH an API Gateway and a Service Mesh in the same system?**
- A) You shouldn't; they do exactly the same thing and will conflict.
- B) Because they solve different problems. The API Gateway handles external client auth, rate limiting, and edge routing. The Service Mesh handles internal mTLS, complex internal routing, and sidecar observability.
- C) To double the speed of the application.
- D) To allow the database to connect to the internet directly.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because they solve different problems. The API Gateway handles external... The Service Mesh handles internal...<br>
**Explanation:** They are highly complementary. The Gateway protects the perimeter (Edge), while the Mesh secures and manages the internal guts of the application.
</details>

**19. What does the term "Zero Trust Network" mean, which a Service Mesh helps enforce?**
- A) A network where users are not allowed to create passwords.
- B) A security model assuming that threats exist both inside and outside the network. Therefore, every single request between internal microservices must be authenticated and encrypted (mTLS), rather than blindly trusting internal traffic.
- C) A network with zero firewalls.
- D) A network that blocks all incoming traffic.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A security model assuming that threats exist both inside and outside the network. Therefore, every single request... must be authenticated and encrypted...<br>
**Explanation:** Historically, companies assumed their internal network was safe behind a firewall. Zero Trust says, "Assume a hacker is already inside the network. Encrypt and verify everything anyway."
</details>

**20. If you are building a small monolithic application, should you use a Service Mesh?**
- A) Yes, it is mandatory for all applications.
- B) No. A Service Mesh solves problems inherent to distributed microservices. Using it for a monolith adds massive, unnecessary operational complexity with zero benefit.
- C) Yes, but only if the monolith is written in Java.
- D) Yes, to make the database faster.
<details>
<summary>Answer</summary>
**Correct Answer:** B) No. A Service Mesh solves problems inherent to distributed microservices. Using it for a monolith adds massive, unnecessary operational complexity...<br>
**Explanation:** A monolith runs in a single process. It doesn't have "East-West" network traffic. Adding a Service Mesh would be like buying a traffic light for a one-lane dirt road.
</details>

---

### Hard (Questions 21 - 30)

**21. What is "Canary Deployment" or "Traffic Splitting," and how does a Service Mesh facilitate it?**
- A) Deploying code to servers that are painted yellow.
- B) A deployment strategy where a new version of a service (V2) is rolled out to a small percentage of users (e.g., 5%). The Service Mesh Control Plane easily configures the sidecars to route exactly 5% of traffic to V2 for safe testing before a full rollout.
- C) Splitting a single HTTP request into multiple UDP packets.
- D) Scaling the database horizontally.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A deployment strategy where a new version of a service (V2) is rolled out to a small percentage of users...<br>
**Explanation:** Instead of replacing the whole system and praying it works, you use the Service Mesh routing rules to softly test the waters. If the 5% traffic produces errors, you instantly route it back to V1.
</details>

**22. How does an API Gateway handle "Payload Transformation"?**
- A) It converts electricity into data.
- B) It can modify the incoming or outgoing request on the fly. For example, a legacy client might send an XML payload, and the Gateway transforms it into JSON before passing it to the modern microservice.
- C) It translates English text to Spanish.
- D) It encrypts the hard drive.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It can modify the incoming or outgoing request on the fly. For example... XML... to JSON...<br>
**Explanation:** This allows backend services to remain clean and modern (only accepting JSON), while the Gateway takes on the messy job of supporting legacy clients that still speak XML or SOAP.
</details>

**23. What is the primary performance overhead introduced by a Service Mesh (Sidecar pattern)?**
- A) It uses too much GPU power.
- B) An extra "network hop" (or two) for every single inter-service call. A request from Service A to Service B must go: Service A -> Sidecar A -> Sidecar B -> Service B, adding slight latency and CPU/RAM usage per proxy.
- C) It limits the hard drive write speed.
- D) It requires users to download large JavaScript files.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An extra "network hop" (or two) for every single inter-service call... adding slight latency...<br>
**Explanation:** While sidecars are written in ultra-fast languages (like C++ or Rust/Envoy), passing data through proxies still takes a millisecond or two. In a system with hundreds of hops, this adds up.
</details>

**24. In the context of an API Gateway, what does "Offloading" refer to?**
- A) Deleting old data from the database.
- B) Moving cross-cutting concerns (like SSL/TLS termination, token validation, CORS headers, and gzip compression) out of the application code and onto the Gateway to save backend CPU cycles.
- C) Uploading files to an S3 bucket.
- D) Shutting down servers at night.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Moving cross-cutting concerns (like SSL/TLS termination...) out of the application code and onto the Gateway...<br>
**Explanation:** Decrypting SSL traffic takes CPU power. By having the Gateway "offload" this work (SSL Termination), the backend servers can dedicate 100% of their CPU to processing business logic.
</details>

**25. What is the "Envoy Proxy"?**
- A) A new programming language.
- B) A high-performance, open-source edge and service proxy, originally built at Lyft, which serves as the underlying Data Plane (the sidecar) for many modern Service Meshes like Istio.
- C) A type of Load Balancer specifically for AWS.
- D) A database schema migration tool.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A high-performance, open-source edge and service proxy... which serves as the underlying Data Plane...<br>
**Explanation:** Envoy is the engine of the modern Service Mesh. It is written in C++ for maximum performance and is designed to handle millions of requests per second.
</details>

**26. How does "Distributed Tracing" work across an API Gateway and a Service Mesh?**
- A) The Gateway guesses the path of the request.
- B) The Gateway generates a unique `Trace ID` (e.g., in the HTTP headers) for the incoming request. The Service Mesh sidecars propagate this exact same Trace ID to every downstream service they call, allowing observability tools to stitch the entire journey together.
- C) Tracing is impossible in a Service Mesh.
- D) Every service generates its own random ID.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The Gateway generates a unique `Trace ID`... The Service Mesh sidecars propagate this exact same Trace ID...<br>
**Explanation:** Without a shared Trace ID passed in the headers (`x-b3-traceid` or `traceparent`), Jaeger or Zipkin would just see thousands of random logs and couldn't figure out which ones belonged to the same user click.
</details>

**27. What is "Egress" traffic in a Service Mesh?**
- A) Traffic entering the cluster from the internet.
- B) Traffic leaving the internal microservice cluster to an external, third-party API (e.g., calling the Stripe API or Twilio API). A Service Mesh can monitor and secure this traffic via an Egress Gateway.
- C) Traffic between two internal services.
- D) Traffic sent to a database.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Traffic leaving the internal microservice cluster to an external, third-party API...<br>
**Explanation:** Controlling Egress is critical for security. If a hacker breaches a microservice, they will try to send stolen data out to the internet. An Egress Gateway blocks unauthorized outbound connections.
</details>

**28. What is the difference between a traditional "ESB" (Enterprise Service Bus) and an API Gateway?**
- A) They are identical.
- B) An ESB (from the SOA era) was heavy, contained complex business logic, and orchestrated transactions. An API Gateway is lightweight, contains NO business logic, and simply routes requests ("Smart endpoints, dumb pipes").
- C) An ESB is faster than a Gateway.
- D) An ESB is used for REST; an API Gateway is used for SOAP.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An ESB... was heavy, contained complex business logic... An API Gateway is lightweight, contains NO business logic...<br>
**Explanation:** Microservices architecture explicitly avoids putting business logic in the middleware (like an ESB did). The Gateway should be "dumb" and fast.
</details>

**29. What is "eBPF" (Extended Berkeley Packet Filter), and how is it related to the future of Service Meshes?**
- A) It is a tool for filtering spam emails.
- B) A Linux kernel technology that allows running sandboxed programs safely inside the OS kernel. It is being used to create "Sidecar-less" service meshes (like Cilium), offering massive performance gains by bypassing the TCP/IP stack overhead.
- C) A protocol for BGP routing.
- D) A new type of JSON format.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A Linux kernel technology... used to create "Sidecar-less" service meshes (like Cilium)...<br>
**Explanation:** eBPF is revolutionary. Instead of injecting a proxy container next to every app (which uses RAM and adds network hops), eBPF intercepts the network traffic directly inside the Linux kernel, making the Service Mesh virtually invisible and blisteringly fast.
</details>

**30. Why might a startup choose NOT to implement an API Gateway on day one?**
- A) Gateways are illegal in some countries.
- B) If the architecture is a Monolith or only has 2-3 services, the operational complexity, infrastructure cost, and maintenance of a Gateway far outweigh the benefits. A simple Load Balancer (like NGINX) is usually sufficient initially.
- C) Gateways do not support HTTPS.
- D) Gateways require the code to be written in Go.
<details>
<summary>Answer</summary>
**Correct Answer:** B) If the architecture is a Monolith or only has 2-3 services, the operational complexity... outweigh the benefits...<br>
**Explanation:** Engineering is about trade-offs. Don't adopt enterprise patterns (Gateways, Meshes) until the pain of *not* having them is greater than the pain of managing them.
</details>
