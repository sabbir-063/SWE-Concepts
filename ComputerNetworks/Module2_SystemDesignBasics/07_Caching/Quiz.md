# Quiz: Caching (Chapter 7)

Test your knowledge of caching levels, eviction strategies, write policies, and cache-related issues! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What is the main purpose of Caching in system design?**
- A) To encrypt data stored in databases.
- B) To temporarily store frequently accessed data in fast memory to reduce latency.
- C) To permanently back up all data.
- D) To distribute traffic among multiple servers.
<details>
<summary>Answer</summary>
**Correct Answer:** B) To temporarily store frequently accessed data in fast memory to reduce latency.<br>
**Explanation:** Caching places frequently accessed data in memory (like RAM) so subsequent requests for the same data can be served much faster than querying the primary database.
</details>

**2. Which of the following is typically used for distributed database caching?**
- A) Nginx
- B) RabbitMQ
- C) Redis or Memcached
- D) PostgreSQL
<details>
<summary>Answer</summary>
**Correct Answer:** C) Redis or Memcached<br>
**Explanation:** Redis and Memcached are popular in-memory data structure stores heavily used as distributed caches to alleviate database loads.
</details>

**3. What is a "Cache Hit"?**
- A) When a cache server crashes due to high traffic.
- B) When requested data is found in the cache, allowing for a fast response.
- C) When data is deleted from the cache.
- D) When a user refreshes the browser cache.
<details>
<summary>Answer</summary>
**Correct Answer:** B) When requested data is found in the cache...<br>
**Explanation:** A cache hit occurs when the application successfully retrieves the requested data from the cache without needing to query the slower primary data store.
</details>

**4. What happens during a "Cache Miss"?**
- A) The application returns a 404 error.
- B) The cache is cleared entirely.
- C) The requested data is not in the cache, so it must be fetched from the primary database and then typically stored in the cache.
- D) The database automatically scales up.
<details>
<summary>Answer</summary>
**Correct Answer:** C) The requested data is not in the cache, so it must be fetched from the primary database...<br>
**Explanation:** A cache miss forces the system to do the heavy lifting of fetching data from the slower source, which adds latency.
</details>

**5. What is the role of a Browser Cache?**
- A) To store passwords securely.
- B) To cache HTTP responses on the server side.
- C) To store static assets (HTML, CSS, JS, images) locally on the user's device to speed up subsequent visits.
- D) To prevent DDoS attacks.
<details>
<summary>Answer</summary>
**Correct Answer:** C) To store static assets... locally on the user's device...<br>
**Explanation:** By storing static assets on the user's hard drive, the browser avoids downloading the same files over the network every time a page is refreshed.
</details>

**6. Which caching level places cached data physically closer to the user across different geographical locations?**
- A) CPU Cache
- B) CDN (Content Delivery Network) Cache
- C) Database Cache
- D) Application Server Cache
<details>
<summary>Answer</summary>
**Correct Answer:** B) CDN Cache<br>
**Explanation:** CDNs distribute cached content to "edge servers" located all over the world, significantly reducing latency for users far away from the origin server.
</details>

**7. In caching, what does TTL stand for?**
- A) Total Transfer Latency
- B) Time To Live
- C) Time To Load
- D) Temporary Transfer Limit
<details>
<summary>Answer</summary>
**Correct Answer:** B) Time To Live<br>
**Explanation:** TTL is a value that determines how long a piece of data should remain in the cache before it expires and is considered stale.
</details>

**8. What does a "Cache Eviction Policy" do?**
- A) Determines how data is encrypted in the cache.
- B) Decides which existing data should be removed from the cache when it becomes full and new data needs to be added.
- C) Increases the RAM size of the cache server.
- D) Forwards traffic to a new server.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Decides which existing data should be removed...<br>
**Explanation:** Because caches have limited memory, an eviction policy (like LRU or LFU) dictates the rules for freeing up space.
</details>

**9. Which cache eviction strategy removes the item that was added to the cache first, regardless of how often it's used?**
- A) LRU (Least Recently Used)
- B) LFU (Least Frequently Used)
- C) FIFO (First In, First Out)
- D) Random Replacement
<details>
<summary>Answer</summary>
**Correct Answer:** C) FIFO (First In, First Out)<br>
**Explanation:** FIFO treats the cache like a queue; the oldest item is always the first one to be evicted when space is needed.
</details>

**10. Which cache eviction strategy removes the item that hasn't been accessed for the longest period of time?**
- A) LRU (Least Recently Used)
- B) LFU (Least Frequently Used)
- C) FIFO (First In, First Out)
- D) LIFO (Last In, First Out)
<details>
<summary>Answer</summary>
**Correct Answer:** A) LRU (Least Recently Used)<br>
**Explanation:** LRU tracks when items were last accessed. The item that has sat untouched for the longest time is evicted first. It is the most common eviction strategy.
</details>

---

### Medium (Questions 11 - 20)

**11. What is "Stale Data" in the context of caching?**
- A) Data that cannot be compressed.
- B) Data in the cache that no longer matches the primary database because the database was updated.
- C) Data that has been encrypted twice.
- D) Data that causes a cache miss.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Data in the cache that no longer matches the primary database...<br>
**Explanation:** If the database updates but the cache is not invalidated or updated, users will receive outdated (stale) information from the cache.
</details>

**12. In the "Write-Through" cache policy, how is data written?**
- A) Data is written only to the cache.
- B) Data is written only to the database.
- C) Data is written to the cache and the backing database simultaneously.
- D) Data is written to the database, and the cache is cleared.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Data is written to the cache and the backing database simultaneously.<br>
**Explanation:** Write-Through ensures the cache and database are always in sync, preventing stale data. However, it introduces higher write latency because two write operations must complete.
</details>

**13. Which cache writing policy provides the fastest write performance but risks data loss if the cache server crashes?**
- A) Write-Through
- B) Write-Back (Write-Behind)
- C) Write-Around
- D) Read-Through
<details>
<summary>Answer</summary>
**Correct Answer:** B) Write-Back (Write-Behind)<br>
**Explanation:** In Write-Back, the application writes data only to the cache and immediately gets a success response. The cache writes it to the database later asynchronously. If the cache dies before syncing, data is lost.
</details>

**14. What is a "Cache Stampede" (or Thundering Herd)?**
- A) When the cache server runs out of memory.
- B) When a highly requested cached item expires, and thousands of concurrent requests miss the cache and simultaneously overwhelm the database.
- C) When a virus spreads through the cache network.
- D) When the load balancer routes all traffic to the cache server.
<details>
<summary>Answer</summary>
**Correct Answer:** B) When a highly requested cached item expires, and thousands of concurrent requests... overwhelm the database.<br>
**Explanation:** If a popular item's TTL expires, all sudden requests experience a cache miss and hit the database at the exact same moment, potentially crashing it.
</details>

**15. How can a "Cache Stampede" be mitigated?**
- A) By setting the TTL to 1 second.
- B) By using a Mutex Lock (or Promise) so only the first request queries the database while others wait, or by preemptively refreshing the cache before it expires.
- C) By switching to Write-Through policy.
- D) By clearing the entire cache hourly.
<details>
<summary>Answer</summary>
**Correct Answer:** B) By using a Mutex Lock... or by preemptively refreshing the cache...<br>
**Explanation:** Locking ensures only one thread does the heavy database query to repopulate the cache. Other threads wait and then read the newly populated cache.
</details>

**16. If your application writes data that is almost NEVER read again (e.g., system logs), which write policy is the best choice?**
- A) Write-Through
- B) Write-Back
- C) Write-Around
- D) Cache-Aside
<details>
<summary>Answer</summary>
**Correct Answer:** C) Write-Around<br>
**Explanation:** Write-Around writes directly to the database and bypasses the cache. This prevents the cache from being filled with "useless" data that won't be read.
</details>

**17. What is the "Cache-Aside" (Lazy Loading) pattern?**
- A) The cache automatically loads all data from the database on startup.
- B) The application first checks the cache; if a miss occurs, the application queries the DB, writes the result to the cache, and returns the data.
- C) The database writes to the cache when it is idle.
- D) The cache is placed physically beside the database server.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The application first checks the cache; if a miss occurs, the application queries the DB...<br>
**Explanation:** This is the most common caching pattern. The cache doesn't interact directly with the DB; the application code orchestrates reading from the DB on a miss and updating the cache.
</details>

**18. What is the difference between LRU and LFU eviction policies?**
- A) LRU evicts based on time since last access; LFU evicts based on the total number of accesses.
- B) LRU evicts the largest files; LFU evicts the smallest files.
- C) LRU is for databases; LFU is for browsers.
- D) LRU is faster but LFU requires less memory.
<details>
<summary>Answer</summary>
**Correct Answer:** A) LRU evicts based on time since last access; LFU evicts based on the total number of accesses.<br>
**Explanation:** LRU drops the item that hasn't been touched in the longest time. LFU tracks a counter of how many times an item was requested and drops the one with the lowest count.
</details>

**19. Why might caching dynamic content (like a user's personal bank account dashboard) be dangerous or difficult?**
- A) Dynamic content takes up too much RAM.
- B) If not properly keyed by user ID, one user might see another user's cached private data.
- C) Dynamic content cannot be stored in Redis.
- D) Browsers block dynamic cache.
<details>
<summary>Answer</summary>
**Correct Answer:** B) If not properly keyed by user ID, one user might see another user's cached private data.<br>
**Explanation:** Caching highly personalized data requires extreme care with cache keys (e.g., `dashboard_user_123`). A mistake could serve User A's cached page to User B.
</details>

**20. What HTTP Header is used by servers to tell browsers how long they should cache a response?**
- A) `Cache-Control`
- B) `X-Forwarded-For`
- C) `Content-Type`
- D) `Authorization`
<details>
<summary>Answer</summary>
**Correct Answer:** A) `Cache-Control`<br>
**Explanation:** The `Cache-Control` header (e.g., `Cache-Control: max-age=3600`) instructs the browser and intermediate proxies how long the resource is valid before it needs to be refetched.
</details>

---

### Hard (Questions 21 - 30)

**21. What is the "Cache Penetration" problem?**
- A) When a hacker breaks into the cache server.
- B) When users constantly request a key that does NOT exist in the cache NOR in the database, causing every request to bypass the cache and hit the database.
- C) When cache data leaks into the database.
- D) When the cache writes data directly to the disk.
<details>
<summary>Answer</summary>
**Correct Answer:** B) When users constantly request a key that does NOT exist in the cache NOR in the database...<br>
**Explanation:** If an attacker requests `id=-1` (which doesn't exist), the cache misses, the DB is queried, finds nothing, and nothing is cached. The next request does the exact same thing, overwhelming the DB.
</details>

**22. How can you effectively solve the "Cache Penetration" problem?**
- A) By using the FIFO eviction policy.
- B) By caching the "Null" or "Empty" results with a short TTL, or by using a Bloom Filter.
- C) By increasing the database size.
- D) By disabling the cache entirely.
<details>
<summary>Answer</summary>
**Correct Answer:** B) By caching the "Null" or "Empty" results... or by using a Bloom Filter.<br>
**Explanation:** If you cache the fact that the data doesn't exist (`key=-1, value=null`), the next request will hit the cache and get `null` without hitting the DB. A Bloom Filter can also quickly determine if a key absolutely doesn't exist before querying the DB.
</details>

**23. What is a "Bloom Filter"?**
- A) A security tool to filter out SQL injections.
- B) A highly space-efficient probabilistic data structure used to test whether an element is a member of a set, which can yield false positives but never false negatives.
- C) A tool to clean stale data from Redis.
- D) An algorithm to compress cached images.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A highly space-efficient probabilistic data structure...<br>
**Explanation:** Bloom filters are used in caching to quickly check if a record might exist in the DB. If the filter says "No", it definitely doesn't exist (preventing cache penetration). If it says "Yes", it *might* exist, and the DB is queried.
</details>

**24. In a distributed cache cluster (like Memcached), what problem does "Consistent Hashing" solve?**
- A) It encrypts passwords securely.
- B) It prevents massive cache invalidation and redistribution when a cache server is added or removed from the cluster.
- C) It hashes the client IP for sticky sessions.
- D) It prevents cache stampedes.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It prevents massive cache invalidation and redistribution when a cache server is added or removed...<br>
**Explanation:** Standard modulo hashing (`hash(key) % N`) breaks if `N` (number of servers) changes, causing almost all keys to remap. Consistent hashing maps data to a ring, so adding/removing a server only affects a small fraction of the keys.
</details>

**25. What is the "Read-Through" caching pattern?**
- A) The application reads from the DB and writes to the cache.
- B) The application asks the cache for data; if there's a miss, the *cache provider itself* (not the application code) synchronously fetches the data from the DB, caches it, and returns it.
- C) The cache reads data before the application requests it.
- D) Reading data directly from RAM without CPU processing.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The application asks the cache for data; if there's a miss, the cache provider itself... fetches the data...<br>
**Explanation:** Unlike Cache-Aside where application code handles the fallback, Read-Through places the cache inline. The cache library/service handles the database querying logic transparently.
</details>

**26. Why might LFU (Least Frequently Used) be a poor choice for a news website cache?**
- A) LFU is too slow for text data.
- B) A breaking news article might get millions of hits today, securing a high frequency count, but never be read tomorrow. LFU would keep it in cache forever, evicting newer articles with lower counts.
- C) LFU deletes data randomly.
- D) LFU cannot handle images.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A breaking news article might get millions of hits today... LFU would keep it in cache forever...<br>
**Explanation:** LFU suffers from "historical baggage". Items that were once wildly popular will have huge counters and won't be evicted, even if they are no longer relevant. (Modern caches use variations like W-LFU or aging to fix this).
</details>

**27. What is "Cache Invalidation"?**
- A) The process of rebooting the cache server.
- B) The difficult process of explicitly removing or updating cached data when the source of truth (the DB) changes, to prevent stale data.
- C) A hardware failure in the CPU cache.
- D) Overwriting a cache with a larger file.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The difficult process of explicitly removing or updating cached data...<br>
**Explanation:** "There are only two hard things in Computer Science: cache invalidation and naming things." Ensuring data is removed from the cache exactly when it changes in the DB is notoriously complex in distributed systems.
</details>

**28. If an application requires 100% strict consistency (e.g., banking transactions), how should caching be handled?**
- A) Use a Write-Back cache with a 10-minute TTL.
- B) Use a CDN for all data.
- C) Caching for transactional/balance data should either be avoided entirely, or strictly managed with Write-Through policies and immediate invalidation.
- D) Use a Write-Around cache with infinite TTL.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Caching for transactional/balance data should either be avoided entirely...<br>
**Explanation:** For financial data, a user seeing stale data (e.g., seeing $100 after they just spent $50) is unacceptable. Caching is usually bypassed for critical transactional reads to guarantee consistency.
</details>

**29. What is a "Global Cache" vs a "Distributed Cache"?**
- A) Global cache is in the cloud; Distributed cache is on-premise.
- B) A Global cache is a single, large cache server shared by all nodes; A Distributed cache partitions data across multiple cache servers, acting as one logical cache.
- C) They are exactly the same thing.
- D) Global cache uses IPv4; Distributed cache uses IPv6.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A Global cache is a single, large cache server... A Distributed cache partitions data across multiple cache servers...<br>
**Explanation:** A single global cache server is easy to manage but becomes a bottleneck and single point of failure. A distributed cache (like a Redis Cluster) scales horizontally by partitioning the data.
</details>

**30. How does a Reverse Proxy (like Varnish) handle the caching of HTTP responses?**
- A) It stores the database queries in RAM.
- B) It sits in front of the web server and caches the fully rendered HTML (or JSON API) responses. Future identical HTTP requests are served directly by the proxy without hitting the web server.
- C) It caches CSS files on the user's hard drive.
- D) It acts as a DNS cache for the ISP.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It sits in front of the web server and caches the fully rendered HTML...<br>
**Explanation:** Reverse proxies operate at Layer 7. If they see a GET request for `/api/products` that was requested recently, they return the cached JSON response instantly, completely shielding the backend application servers from the load.
</details>
