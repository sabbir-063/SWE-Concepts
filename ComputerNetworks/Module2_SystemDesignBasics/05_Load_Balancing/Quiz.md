# Quiz: Load Balancing (Chapter 5)

Test your knowledge of Load Balancing, Layer 4 vs Layer 7, algorithms, and SSL termination! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What is the primary purpose of a Load Balancer?**
- A) To compress data before sending it to the client.
- B) To distribute incoming network traffic across multiple servers.
- C) To encrypt passwords in a database.
- D) To translate domain names to IP addresses.
<details>
<summary>Answer</summary>
**Correct Answer:** B) To distribute incoming network traffic across multiple servers.<br>
**Explanation:** A load balancer acts as a reverse proxy and distributes network or application traffic across a number of servers to improve capacity and reliability.
</details>

**2. Which problem does a load balancer directly solve?**
- A) SQL Injection
- B) Single Point of Failure (if servers are overwhelmed)
- C) DNS propagation delay
- D) Hard disk fragmentation
<details>
<summary>Answer</summary>
**Correct Answer:** B) Single Point of Failure (if servers are overwhelmed)<br>
**Explanation:** By routing traffic away from failed or overwhelmed servers, a load balancer prevents a single server's failure from taking down the entire application.
</details>

**3. Layer 4 load balancing operates at which layer of the OSI model?**
- A) Network Layer
- B) Transport Layer
- C) Session Layer
- D) Application Layer
<details>
<summary>Answer</summary>
**Correct Answer:** B) Transport Layer<br>
**Explanation:** Layer 4 load balancing operates at the Transport Layer, making routing decisions based on IP addresses and TCP/UDP ports.
</details>

**4. Layer 7 load balancing operates at which layer of the OSI model?**
- A) Data Link Layer
- B) Network Layer
- C) Transport Layer
- D) Application Layer
<details>
<summary>Answer</summary>
**Correct Answer:** D) Application Layer<br>
**Explanation:** Layer 7 operates at the Application Layer, allowing it to inspect HTTP headers, URLs, and cookies to make intelligent routing decisions.
</details>

**5. Which load balancing algorithm distributes requests sequentially to each server in a list?**
- A) IP Hash
- B) Least Connections
- C) Round Robin
- D) Random
<details>
<summary>Answer</summary>
**Correct Answer:** C) Round Robin<br>
**Explanation:** Round Robin simply goes down the list of servers one by one, giving each server a request in turn, and then starts over at the top.
</details>

**6. If some of your servers have 32GB RAM and others have 8GB RAM, which algorithm is best to avoid overloading the smaller servers?**
- A) Standard Round Robin
- B) Weighted Round Robin
- C) IP Hash
- D) DNS Round Robin
<details>
<summary>Answer</summary>
**Correct Answer:** B) Weighted Round Robin<br>
**Explanation:** Weighted Round Robin allows you to assign a "weight" to each server based on its capacity. The 32GB server would receive proportionally more requests than the 8GB server.
</details>

**7. How does a load balancer know if a backend server has crashed?**
- A) By waiting for users to report errors.
- B) The server sends an email to the load balancer.
- C) By continuously performing Health Checks.
- D) By checking the server's hard drive space.
<details>
<summary>Answer</summary>
**Correct Answer:** C) By continuously performing Health Checks.<br>
**Explanation:** Load balancers periodically ping or send HTTP requests to a specific endpoint (like `/health`) on the backend servers. If a server stops responding, it is temporarily removed from the pool.
</details>

**8. What is "Sticky Sessions" (Session Affinity) in load balancing?**
- A) A security feature that blocks sticky IP addresses.
- B) A mechanism to route all requests from a specific user to the same backend server.
- C) A process of saving sessions into a Redis database.
- D) When the load balancer gets stuck and stops routing.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A mechanism to route all requests from a specific user to the same backend server.<br>
**Explanation:** Sticky sessions ensure that a user maintains an unbroken connection to the same server that holds their local session data (like a shopping cart or login state).
</details>

**9. Which algorithm naturally provides a "Sticky Session" behavior without using cookies?**
- A) Round Robin
- B) Least Connections
- C) IP Hash
- D) Weighted Round Robin
<details>
<summary>Answer</summary>
**Correct Answer:** C) IP Hash<br>
**Explanation:** IP Hash uses the client's IP address to generate a hash key, which is used to select the server. Because the IP stays the same, the user is consistently routed to the same server.
</details>

**10. What does SSL Termination (SSL Offloading) do?**
- A) Terminates the user's connection if they use SSL.
- B) Decrypts incoming HTTPS traffic at the load balancer, sending unencrypted HTTP traffic to backend servers.
- C) Encrypts data stored in the backend database.
- D) Blocks invalid SSL certificates.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Decrypts incoming HTTPS traffic at the load balancer...<br>
**Explanation:** SSL decryption requires CPU overhead. By handling it at the load balancer, backend servers are freed from this processing burden.
</details>

---

### Medium (Questions 11 - 20)

**11. Which load balancer type can route requests based on the URL path (e.g., routing `/video` to server A and `/images` to server B)?**
- A) Layer 4 Load Balancer
- B) Layer 7 Load Balancer
- C) Layer 2 Switch
- D) DNS Load Balancer
<details>
<summary>Answer</summary>
**Correct Answer:** B) Layer 7 Load Balancer<br>
**Explanation:** Only Layer 7 load balancers can read the application data (like the URL path or HTTP headers) to make context-aware routing decisions.
</details>

**12. When is the "Least Connections" algorithm most beneficial?**
- A) When all requests take exactly the same amount of time to process.
- B) When servers are identical and traffic is completely static.
- C) When sessions are long-lived and request processing times vary significantly.
- D) When you only have two servers.
<details>
<summary>Answer</summary>
**Correct Answer:** C) When sessions are long-lived and request processing times vary significantly.<br>
**Explanation:** If some requests take longer (e.g., a heavy database query vs a simple file fetch), Round Robin might accidentally send a new request to a server that is still busy. Least Connections checks which server has the fewest active tasks before sending.
</details>

**13. A load balancer itself can become a Single Point of Failure. How is this typically prevented?**
- A) By backing up the load balancer's hard drive daily.
- B) By using an Active-Passive or Active-Active pair of load balancers.
- C) By restarting the load balancer every night.
- D) By assigning two IP addresses to the same load balancer.
<details>
<summary>Answer</summary>
**Correct Answer:** B) By using an Active-Passive or Active-Active pair of load balancers.<br>
**Explanation:** Redundancy is key. High availability is achieved by deploying multiple load balancers. If the active one fails, the passive one instantly takes over the virtual IP (VIP).
</details>

**14. What is the downside of using sticky sessions stored purely in a single backend server's memory?**
- A) It makes the load balancer run out of memory.
- B) It prevents the use of SSL.
- C) If that specific server crashes, all users routed to it will lose their session data (e.g., get logged out).
- D) It violates the OSI model rules.
<details>
<summary>Answer</summary>
**Correct Answer:** C) If that specific server crashes, all users routed to it will lose their session data...<br>
**Explanation:** While sticky sessions keep a user attached to one server, a crash of that server means their local session data is gone. (Modern systems solve this by storing sessions externally in Redis/Memcached).
</details>

**15. Which of the following is true about Layer 4 load balancers?**
- A) They can read HTTP cookies.
- B) They terminate SSL by default.
- C) They perform Network Address Translation (NAT) to forward packets.
- D) They only work with UDP traffic.
<details>
<summary>Answer</summary>
**Correct Answer:** C) They perform Network Address Translation (NAT) to forward packets.<br>
**Explanation:** Layer 4 balancers change the destination IP (from the LB's IP to the backend server's IP) without looking at the packet payload.
</details>

**16. In an Active-Passive load balancer setup, what does the Passive node do during normal operations?**
- A) It serves 50% of the traffic.
- B) It monitors the Active node via a heartbeat signal and waits to take over if the Active node fails.
- C) It handles all database write operations.
- D) It acts as a DNS server.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It monitors the Active node via a heartbeat signal...<br>
**Explanation:** The passive node stays idle, constantly checking the health of the active node. It only receives traffic if the active node goes down.
</details>

**17. Why might a company choose NOT to use SSL Termination at the load balancer (choosing SSL Passthrough instead)?**
- A) To save money on load balancer licenses.
- B) Because strict security compliance requires traffic to be encrypted all the way to the backend server.
- C) Because it speeds up the load balancer.
- D) Because Layer 7 balancers cannot perform SSL termination.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because strict security compliance requires traffic to be encrypted all the way to the backend server.<br>
**Explanation:** In highly secure environments (like banking), sending unencrypted HTTP traffic inside the internal network (from LB to backend) might be considered a risk, so SSL Passthrough is used.
</details>

**18. What is Hardware Load Balancing vs Software Load Balancing?**
- A) Hardware LB is a physical appliance (like F5 BIG-IP); Software LB is an application (like Nginx, HAProxy) running on standard servers.
- B) Hardware LB uses RAM; Software LB uses CPUs.
- C) Hardware LB only does Layer 7; Software LB only does Layer 4.
- D) There is no such thing as Software Load Balancing.
<details>
<summary>Answer</summary>
**Correct Answer:** A) Hardware LB is a physical appliance; Software LB is an application...<br>
**Explanation:** Hardware load balancers are specialized, expensive proprietary devices. Software load balancers (like HAProxy, Nginx) are flexible, cheaper, and widely used in cloud environments.
</details>

**19. How does DNS Load Balancing (Round Robin DNS) differ from a dedicated Load Balancer?**
- A) DNS Load Balancing requires special hardware.
- B) DNS returns different IP addresses to different clients, but it cannot perform active health checks or manage active connections.
- C) DNS Load Balancing operates at Layer 7.
- D) DNS Load Balancing only works for IPv6.
<details>
<summary>Answer</summary>
**Correct Answer:** B) DNS returns different IP addresses to different clients, but it cannot perform active health checks...<br>
**Explanation:** DNS Round Robin simply hands out different IPs sequentially. If a server is down, DNS doesn't know instantly (due to TTL caching) and might still send clients to the dead server.
</details>

**20. Which HTTP header is commonly added by a Layer 7 Load Balancer to tell the backend server the original client's IP address?**
- A) X-Forwarded-For (XFF)
- B) Authorization
- C) User-Agent
- D) Content-Type
<details>
<summary>Answer</summary>
**Correct Answer:** A) X-Forwarded-For (XFF)<br>
**Explanation:** Because the load balancer acts as a proxy, the backend server sees the LB's IP. The LB adds the `X-Forwarded-For` header so the backend knows the actual user's IP.
</details>

---

### Hard (Questions 21 - 30)

**21. In the "Least Response Time" load balancing algorithm, what two metrics are combined to make a decision?**
- A) CPU usage and RAM usage.
- B) The number of active connections and the lowest average response time.
- C) The client's IP hash and the server's uptime.
- D) SSL handshake time and HTTP header size.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The number of active connections and the lowest average response time.<br>
**Explanation:** This algorithm routes traffic to the server with the fewest active connections AND the fastest response time to a health check, ensuring optimal performance.
</details>

**22. What happens in a "Cache Stampede" scenario if a load balancer routes thousands of identical requests to a newly spun-up backend server with an empty local cache?**
- A) The load balancer automatically blocks the requests.
- B) The backend server's CPU spikes as it hits the database for every single request, potentially crashing it.
- C) The load balancer serves the cached data itself.
- D) The database automatically scales up.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The backend server's CPU spikes as it hits the database...<br>
**Explanation:** A cache stampede occurs when high concurrency hits a system right as a cache expires (or is empty). All requests bypass the cache and hit the DB simultaneously, causing system failure.
</details>

**23. What is the role of a Virtual IP Address (VIP) in a High Availability Load Balancer setup?**
- A) It is the IP address of the backend database.
- B) It is a floating IP that points to the Active load balancer and can instantly switch to the Passive one if a failure occurs.
- C) It is a fake IP used to trick hackers.
- D) It assigns a new IP to every client.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It is a floating IP that points to the Active load balancer...<br>
**Explanation:** DNS points to the VIP. The VIP is held by the Active LB. If it dies, the Passive LB assumes the VIP (using protocols like VRRP or Keepalived), making the failover transparent to clients.
</details>

**24. When using Layer 4 load balancing with Direct Server Return (DSR), how does the response reach the client?**
- A) The backend server sends the response back through the load balancer.
- B) The backend server sends the response directly to the client, bypassing the load balancer.
- C) The database sends the response to the client.
- D) The response is dropped.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The backend server sends the response directly to the client, bypassing the load balancer.<br>
**Explanation:** In DSR, the LB only handles incoming request packets. The backend servers alter their packets to use the LB's IP as the source and send responses directly to the client. This vastly reduces outbound bandwidth load on the LB.
</details>

**25. Which open-source software is widely considered the industry standard for high-performance TCP/HTTP load balancing?**
- A) Apache Tomcat
- B) HAProxy
- C) MySQL
- D) Redis
<details>
<summary>Answer</summary>
**Correct Answer:** B) HAProxy<br>
**Explanation:** HAProxy (High Availability Proxy) and Nginx are the two most prominent open-source software load balancers used globally.
</details>

**26. If a Layer 7 load balancer reads a cookie to route a user, what must it do before it can read that cookie?**
- A) Compress the data.
- B) Terminate the SSL/TLS connection (if the site uses HTTPS).
- C) Perform a DNS lookup.
- D) Ping the client's router.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Terminate the SSL/TLS connection (if the site uses HTTPS).<br>
**Explanation:** Because HTTPS encrypts HTTP headers (including cookies), a Layer 7 LB *must* have the SSL certificate and decrypt the traffic before it can inspect the cookie for routing.
</details>

**27. What is "Anycast" in the context of global load balancing?**
- A) Sending packets to all servers simultaneously.
- B) A routing methodology where multiple servers in different geographical locations share the same IP address, and BGP routes the client to the physically closest one.
- C) A specific algorithm for video streaming.
- D) Encrypting traffic dynamically.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A routing methodology where multiple servers... share the same IP address...<br>
**Explanation:** Anycast allows a global CDN or DNS provider (like Cloudflare's 1.1.1.1) to use a single IP worldwide. The internet's core routing protocol (BGP) naturally directs the user to the nearest data center advertising that IP.
</details>

**28. In AWS, what is the key difference between an Application Load Balancer (ALB) and a Network Load Balancer (NLB)?**
- A) ALB is for Layer 4; NLB is for Layer 7.
- B) ALB is for Layer 7 (HTTP/HTTPS); NLB is for Layer 4 (TCP/UDP) and extreme high performance.
- C) ALB only works internally; NLB works externally.
- D) ALB is hardware; NLB is software.
<details>
<summary>Answer</summary>
**Correct Answer:** B) ALB is for Layer 7 (HTTP/HTTPS); NLB is for Layer 4 (TCP/UDP)...<br>
**Explanation:** AWS ALB is designed specifically to parse HTTP/HTTPS traffic (L7), while NLB is built to handle millions of requests per second at ultra-low latency at the TCP/UDP level (L4).
</details>

**29. What happens if you enable "Connection Draining" (or Deregistration Delay) on a load balancer?**
- A) It instantly cuts off all connections to a server being removed.
- B) It stops sending *new* requests to a server being removed but allows existing in-flight connections to finish processing gracefully.
- C) It drains the RAM of the backend server.
- D) It drops all packets that take longer than 1 second.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It stops sending *new* requests to a server being removed but allows existing in-flight connections to finish...<br>
**Explanation:** Connection draining ensures users aren't abruptly disconnected when a server is taken out of service for maintenance or scaling down.
</details>

**30. Which of the following statements about SSL Passthrough is FALSE?**
- A) The load balancer cannot read the HTTP headers.
- B) The load balancer cannot modify the request (e.g., cannot add X-Forwarded-For).
- C) The backend server must have the SSL certificate installed.
- D) The load balancer decrypts the traffic and re-encrypts it before sending to the backend.
<details>
<summary>Answer</summary>
**Correct Answer:** D) The load balancer decrypts the traffic and re-encrypts it before sending to the backend.<br>
**Explanation:** Statement D describes "SSL Bridging/Re-encryption". In pure "SSL Passthrough", the load balancer treats the encrypted stream as opaque Layer 4 TCP traffic and passes it untouched to the backend, which holds the certificate and decrypts it.
</details>
