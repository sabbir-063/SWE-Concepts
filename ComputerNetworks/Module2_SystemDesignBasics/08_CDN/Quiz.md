# Quiz: CDN (Chapter 8)

Test your knowledge of Content Delivery Networks, edge servers, push/pull topologies, and static vs dynamic caching! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What does CDN stand for?**
- A) Central Data Node
- B) Content Delivery Network
- C) Caching Distribution Network
- D) Cloud Data Network
<details>
<summary>Answer</summary>
**Correct Answer:** B) Content Delivery Network<br>
**Explanation:** A CDN is a geographically distributed network of servers designed to deliver internet content quickly to users.
</details>

**2. What is the primary problem that a CDN solves?**
- A) Database indexing slowness
- B) Physical distance (latency) between the user and the origin server
- C) Lack of hard drive space on the server
- D) Memory leaks in the application code
<details>
<summary>Answer</summary>
**Correct Answer:** B) Physical distance (latency) between the user and the origin server<br>
**Explanation:** The speed of light and network routing over long distances cause latency. A CDN places the data physically closer to the user to eliminate this delay.
</details>

**3. In CDN terminology, what is an "Edge Server"?**
- A) The main server where the database is hosted.
- B) A server physically located on the outer edge of a hard drive.
- C) A CDN server located in various geographical locations closer to the end-users.
- D) A server that only handles security.
<details>
<summary>Answer</summary>
**Correct Answer:** C) A CDN server located in various geographical locations closer to the end-users.<br>
**Explanation:** Edge servers (or PoPs - Points of Presence) are the nodes in the CDN network that cache and serve the content directly to local users.
</details>

**4. What is the "Origin Server"?**
- A) The CDN's main control center.
- B) The server where the original, definitive version of your application and database lives.
- C) The server located closest to the user.
- D) A DNS root server.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The server where the original, definitive version of your application and database lives.<br>
**Explanation:** The origin server is your own server (e.g., hosted on AWS or DigitalOcean). The CDN pulls content from the origin server to distribute it globally.
</details>

**5. Which of the following is the best candidate to be cached on a CDN?**
- A) A user's shopping cart contents
- B) A real-time banking transaction
- C) A company's logo (image file)
- D) A personalized news feed
<details>
<summary>Answer</summary>
**Correct Answer:** C) A company's logo (image file)<br>
**Explanation:** A logo is static content. It looks exactly the same for every single user, making it perfectly suited for caching on a global CDN.
</details>

**6. Which of the following is NOT typically considered a benefit of using a CDN?**
- A) Improved page load times
- B) Reduced bandwidth costs for the origin server
- C) Execution of heavy backend database queries
- D) Protection against DDoS attacks
<details>
<summary>Answer</summary>
**Correct Answer:** C) Execution of heavy backend database queries<br>
**Explanation:** A CDN does not execute your database queries. It serves static assets and proxies traffic. Database execution remains the job of your origin server.
</details>

**7. In a "Pull CDN" model, what triggers the CDN to fetch content from the origin server?**
- A) A user requesting a file that is not currently cached on the edge server (Cache Miss).
- B) The developer running a manual upload script.
- C) The origin server pushing the data automatically at midnight.
- D) A database trigger.
<details>
<summary>Answer</summary>
**Correct Answer:** A) A user requesting a file that is not currently cached...<br>
**Explanation:** In a Pull CDN, the CDN waits passively. When a user requests a file, if the CDN doesn't have it, it "pulls" it from the origin, caches it, and serves it.
</details>

**8. Which company is known as one of the largest CDN providers globally?**
- A) Adobe
- B) Cloudflare
- C) Mozilla
- D) GitHub
<details>
<summary>Answer</summary>
**Correct Answer:** B) Cloudflare<br>
**Explanation:** Cloudflare, alongside Akamai, Fastly, and AWS CloudFront, is one of the most prominent CDN and web security providers in the world.
</details>

**9. How does a CDN help reduce hosting bandwidth costs?**
- A) By compressing the database.
- B) By serving the majority of requests directly from its edge caches, preventing those requests from ever reaching the origin server.
- C) By negotiating lower internet rates with ISPs.
- D) By disabling videos on mobile devices.
<details>
<summary>Answer</summary>
**Correct Answer:** B) By serving the majority of requests directly from its edge caches...<br>
**Explanation:** If 90% of your website's traffic is static images and CSS, the CDN serves them. Your origin server only has to serve the 10% dynamic traffic, drastically reducing bandwidth bills.
</details>

**10. What does the term "PoP" stand for in CDN architecture?**
- A) Point of Presence
- B) Post Office Protocol
- C) Push or Pull
- D) Provider of Proxy
<details>
<summary>Answer</summary>
**Correct Answer:** A) Point of Presence<br>
**Explanation:** A PoP (Point of Presence) is a physical data center where the CDN provider places their edge servers to serve local geographical regions.
</details>

---

### Medium (Questions 11 - 20)

**11. What is the main difference between a Pull CDN and a Push CDN?**
- A) Pull requires IPv4; Push requires IPv6.
- B) In Pull, the CDN fetches content on-demand; in Push, the application owner manually or programmatically uploads content to the CDN ahead of time.
- C) Pull is for images; Push is for videos.
- D) Pull is secure; Push is not.
<details>
<summary>Answer</summary>
**Correct Answer:** B) In Pull, the CDN fetches content on-demand; in Push, the application owner... uploads content...<br>
**Explanation:** Pull is reactive (it waits for a user request). Push is proactive (you push the data to the CDN as soon as it's created).
</details>

**12. Why might a developer choose a Push CDN over a Pull CDN?**
- A) Push CDNs are generally free.
- B) Push CDNs don't require DNS configuration.
- C) To avoid the initial "Cache Miss" latency penalty for the first user who requests a new file.
- D) To allow the CDN to run SQL queries.
<details>
<summary>Answer</summary>
**Correct Answer:** C) To avoid the initial "Cache Miss" latency penalty...<br>
**Explanation:** Because the data is pushed to the CDN beforehand, the very first user who requests it will get a fast response (Cache Hit), unlike a Pull CDN where the first user experiences a slower Cache Miss.
</details>

**13. Can a CDN accelerate the delivery of Dynamic Content (like a personalized dashboard)?**
- A) No, dynamic content must bypass the CDN completely.
- B) Yes, by caching the HTML for 1 second.
- C) Yes, through optimized network routing, keeping the connection alive, and using specialized protocols rather than standard caching.
- D) Yes, by encrypting the data.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Yes, through optimized network routing...<br>
**Explanation:** While a CDN cannot cache a personalized banking dashboard, it can use its private, uncongested global fiber network (Dynamic Content Acceleration) to route the request to the origin much faster than the public internet.
</details>

**14. How does a CDN provide protection against DDoS (Distributed Denial of Service) attacks?**
- A) By shutting down the origin server when under attack.
- B) By utilizing its massive global bandwidth capacity and scrubbing centers to absorb and filter out malicious traffic before it reaches the origin.
- C) By changing the DNS records randomly.
- D) By hiding the SSL certificate.
<details>
<summary>Answer</summary>
**Correct Answer:** B) By utilizing its massive global bandwidth capacity and scrubbing centers to absorb... traffic...<br>
**Explanation:** A CDN's network is usually vastly larger than the attacker's botnet. It absorbs the flood of requests at the edge, serving cached data or blocking malicious IPs, keeping the origin safe.
</details>

**15. What is CDN "Cache Purging" (or Invalidation)?**
- A) The process of forcing the CDN to delete its cached version of a file so it is forced to pull a fresh copy from the origin.
- B) The process of deleting a file from the origin server.
- C) When a virus destroys the CDN memory.
- D) Upgrading the CDN servers.
<details>
<summary>Answer</summary>
**Correct Answer:** A) The process of forcing the CDN to delete its cached version of a file...<br>
**Explanation:** If you update your website's CSS file, the CDN might still serve the old cached CSS. You must "purge" the cache to force the edge servers to fetch the new version.
</details>

**16. What does the "Cache-Control" HTTP header do in the context of a CDN?**
- A) It tells the CDN which geographic region to serve.
- B) It instructs the CDN (and browser) on whether a file should be cached and for how long (TTL).
- C) It compresses the file using Gzip.
- D) It authenticates the user.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It instructs the CDN (and browser) on whether a file should be cached and for how long (TTL).<br>
**Explanation:** Headers like `Cache-Control: public, max-age=86400` tell the CDN that it is allowed to cache this file for 86,400 seconds (24 hours).
</details>

**17. What is "Anycast" routing, and why do CDNs use it?**
- A) It sends packets to all servers globally at the same time.
- B) It allows multiple physical edge servers in different cities to share the exact same IP address, naturally routing users to the closest one via BGP.
- C) It is a video streaming protocol.
- D) It encrypts DNS requests.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It allows multiple physical edge servers... to share the exact same IP address...<br>
**Explanation:** Anycast is the magic behind CDNs. By advertising the same IP from multiple data centers, the internet's routing protocol (BGP) inherently directs the user's packets to the physically nearest healthy data center.
</details>

**18. Why is it a common practice to add a hash or version number to a static file's filename (e.g., `main-v2.css` or `app-a3f9b.js`) when using a CDN?**
- A) To encrypt the file.
- B) To compress the file size.
- C) To bypass the CDN entirely.
- D) To force the CDN to fetch the new file immediately without needing to manually purge the cache (Cache Busting).
<details>
<summary>Answer</summary>
**Correct Answer:** D) To force the CDN to fetch the new file immediately... (Cache Busting).<br>
**Explanation:** This technique is called "Cache Busting". Since the filename changes entirely, the CDN treats it as a brand new resource and pulls it instantly, avoiding the hassle of manual cache invalidation.
</details>

**19. How does a CDN perform SSL/TLS Offloading?**
- A) It blocks encrypted traffic.
- B) It holds the SSL certificate at the edge, decrypts the HTTPS traffic from the user, and optionally uses a separate connection to the origin, saving CPU power on the origin.
- C) It turns HTTPS into HTTP for the user.
- D) It forces the user to install a certificate.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It holds the SSL certificate at the edge, decrypts the HTTPS traffic...<br>
**Explanation:** Similar to a load balancer, the CDN can handle the heavy cryptographic math of the SSL handshake at the edge, freeing up the origin server's CPU.
</details>

**20. Which HTTP status code typically indicates to a CDN that the requested resource hasn't changed since the CDN last pulled it?**
- A) 200 OK
- B) 404 Not Found
- C) 304 Not Modified
- D) 500 Internal Server Error
<details>
<summary>Answer</summary>
**Correct Answer:** C) 304 Not Modified<br>
**Explanation:** When a CDN checks with the origin to see if an expired file has been updated, the origin can respond with `304 Not Modified`, saving bandwidth by not resending the entire file body.
</details>

---

### Hard (Questions 21 - 30)

**21. What is a "CDN Shield" or "Origin Shield" tier?**
- A) A firewall that blocks all traffic.
- B) An intermediate cache layer between the edge servers and the origin server, designed to collapse multiple edge cache misses into a single request to the origin.
- C) A physical security guard at the data center.
- D) A protocol that encrypts video files.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An intermediate cache layer between the edge servers and the origin server...<br>
**Explanation:** Without an Origin Shield, if a file expires, 50 different edge servers around the world might experience a cache miss simultaneously and send 50 requests to the origin. An Origin Shield sits in the middle; it receives the 50 requests, sends exactly ONE to the origin, and then distributes the file to the edges.
</details>

**22. In Video Streaming, what is the role of a CDN in delivering HLS (HTTP Live Streaming) or DASH?**
- A) The CDN transcodes the video into different resolutions.
- B) The CDN caches small chunks (segments) of the video file and the playlist (manifest), allowing users to stream efficiently via HTTP.
- C) The CDN plays the video on the server.
- D) The CDN adds DRM (Digital Rights Management) encryption to the video.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The CDN caches small chunks (segments) of the video file...<br>
**Explanation:** Modern streaming breaks video into tiny HTTP files (chunks of ~2-10 seconds). Since they are just standard HTTP files, the CDN can cache them easily at the edge, providing smooth, buffer-free playback to thousands of concurrent viewers.
</details>

**23. What is "Edge Computing" (e.g., Cloudflare Workers or AWS Lambda@Edge)?**
- A) Running the main database at the edge.
- B) Executing custom, lightweight serverless application code directly on the CDN's edge servers, extremely close to the user.
- C) Computing the shortest path for BGP routing.
- D) Storing static files on a hard drive.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Executing custom, lightweight serverless application code directly on the CDN's edge servers...<br>
**Explanation:** Edge computing allows you to run logic (like A/B testing, header modification, or token authentication) at the PoP, intercepting the request before it hits the cache or origin, with near-zero latency.
</details>

**24. Why might a CDN strip out or ignore certain HTTP Cookies (like Google Analytics trackers) before evaluating a cache key?**
- A) Because cookies contain viruses.
- B) Because if every unique tracking cookie creates a unique cache key, the cache will be fragmented, resulting in a 0% cache hit rate for otherwise identical static files.
- C) Because it is illegal to cache cookies.
- D) To make the HTTP request smaller.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because if every unique tracking cookie creates a unique cache key, the cache will be fragmented...<br>
**Explanation:** Caches use the URL and sometimes headers/cookies as the "Key". If a user-specific tracking cookie is part of the key for an image, the CDN thinks every user needs a different version of the image, breaking the cache completely.
</details>

**25. What is a "Vary" HTTP header, and how does it affect CDN caching?**
- A) It tells the CDN to vary the IP address.
- B) It instructs the CDN that the response varies depending on certain request headers (like `Accept-Encoding: gzip`), so the CDN must store separate cached copies for different header values.
- C) It varies the TTL randomly.
- D) It tells the CDN to bypass the cache.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It instructs the CDN that the response varies depending on certain request headers...<br>
**Explanation:** If the origin sends `Vary: Accept-Encoding`, the CDN knows it needs to keep one cached copy for browsers that support gzip, and a separate cached copy for those that don't, even though the URL is identical.
</details>

**26. How do CDNs typically handle TCP connection optimization to the origin server?**
- A) They open and close a new TCP connection for every single request to save memory.
- B) They maintain long-lived, persistent TCP/TLS connections (Connection Pooling) to the origin to eliminate the handshake latency for future requests.
- C) They use UDP instead of TCP for all origin traffic.
- D) They do not connect to the origin server.
<details>
<summary>Answer</summary>
**Correct Answer:** B) They maintain long-lived, persistent TCP/TLS connections...<br>
**Explanation:** Establishing a TCP and TLS handshake takes time. By keeping connections open (Keep-Alive) between the Edge and the Origin, the CDN can forward cache misses instantly.
</details>

**27. What is "Byte-Range Caching" in a CDN, and why is it crucial for large files (like 50GB game downloads)?**
- A) It only caches the first byte of a file.
- B) It allows the CDN to request and cache the file in smaller, manageable chunks (ranges) rather than waiting for the entire 50GB file to download to the edge before serving the user.
- C) It restricts users to downloading a specific range of bytes per day.
- D) It changes the byte order for security.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It allows the CDN to request and cache the file in smaller, manageable chunks...<br>
**Explanation:** Without byte-range caching, the first user requesting a huge file would have to wait hours for the CDN to pull it from the origin. Range caching lets the CDN stream the file in pieces, serving the user immediately while caching concurrently.
</details>

**28. In a Multi-CDN strategy, how is traffic typically routed between different CDN providers?**
- A) By chaining the CDNs together (CDN A pulls from CDN B).
- B) By using intelligent DNS routing (like Route53) that directs users to the CDN performing best in their specific geographic region at that moment.
- C) By hardcoding IP addresses in the HTML.
- D) Multi-CDN is impossible to configure.
<details>
<summary>Answer</summary>
**Correct Answer:** B) By using intelligent DNS routing...<br>
**Explanation:** Large enterprises use Multi-CDN (e.g., combining Cloudflare and Fastly) to avoid vendor lock-in, increase redundancy, and ensure they get the best performance globally by letting smart DNS direct traffic to the fastest provider.
</details>

**29. What is the purpose of "Stale-While-Revalidate" (SWR) cache directive?**
- A) It serves stale content forever.
- B) It allows the CDN to immediately serve slightly stale content to the user while asynchronously fetching a fresh copy from the origin in the background.
- C) It forces the user to validate their identity.
- D) It throws an error if the content is stale.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It allows the CDN to immediately serve slightly stale content... while asynchronously fetching a fresh copy...<br>
**Explanation:** SWR provides the best of both worlds: zero latency for the user (since they get the cached, albeit slightly old, copy) and the cache is silently updated in the background for the next user.
</details>

**30. Why do some CDNs use a secondary protocol like QUIC (HTTP/3) between the client and the edge server?**
- A) Because QUIC is an older, more stable protocol.
- B) Because QUIC (built on UDP) eliminates the TCP Head-of-Line blocking problem and reduces connection handshake time, especially on unreliable mobile networks.
- C) Because QUIC requires less RAM on the edge server.
- D) Because QUIC is the only protocol that supports video.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because QUIC (built on UDP) eliminates the TCP Head-of-Line blocking problem and reduces connection handshake time...<br>
**Explanation:** HTTP/3 (QUIC) is a massive performance upgrade. CDNs implement it at the edge so clients get the speed benefits of HTTP/3, even if the connection between the CDN and the Origin still uses older HTTP/1.1 or HTTP/2.
</details>
