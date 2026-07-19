# Quiz: Availability & Reliability (Chapter 10)

Test your knowledge of High Availability, SLA/SLO/SLI, MTBF, MTTR, and system redundancy! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What is the definition of "Reliability" in system design?**
- A) The speed at which a system processes requests.
- B) The probability that a system will perform its intended function without failure over a specific period.
- C) The percentage of time a system is accessible to users.
- D) The amount of data a system can store.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The probability that a system will perform its intended function without failure...<br>
**Explanation:** Reliability measures the time between failures. A highly reliable system rarely crashes or produces errors.
</details>

**2. What is the definition of "Availability"?**
- A) The time it takes to reboot a server.
- B) The fraction of time a system is fully operational and accessible when required by users.
- C) The number of backups a system has.
- D) The cost of maintaining a server.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The fraction of time a system is fully operational and accessible...<br>
**Explanation:** Availability is simply "Is the system up and running when the user tries to access it?" (Usually measured as Uptime percentage).
</details>

**3. Which of the following describes a system that frequently crashes but automatically reboots within 1 second every time?**
- A) High Reliability, Low Availability
- B) Low Reliability, High Availability
- C) Low Reliability, Low Availability
- D) High Reliability, High Availability
<details>
<summary>Answer</summary>
**Correct Answer:** B) Low Reliability, High Availability<br>
**Explanation:** Because it crashes often, its reliability is poor. However, because it recovers so fast (1 second), the user barely notices, making its overall availability very high.
</details>

**4. What does the term "Five Nines" (99.999%) refer to?**
- A) A system that costs $99,999.
- B) A system that can handle 99,999 concurrent users.
- C) A highly available system that experiences only about 5.26 minutes of downtime per year.
- D) A system that fails 99.999% of the time.
<details>
<summary>Answer</summary>
**Correct Answer:** C) A highly available system that experiences only about 5.26 minutes of downtime per year.<br>
**Explanation:** "Five Nines" is the gold standard for High Availability in critical infrastructure like telecom and banking.
</details>

**5. What is a "Single Point of Failure" (SPOF)?**
- A) The only router in a network.
- B) A specific part of a system that, if it fails, will stop the entire system from working.
- C) A bug in the code.
- D) The primary database server in an Active-Active cluster.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A specific part of a system that, if it fails, will stop the entire system from working.<br>
**Explanation:** Designing for High Availability primarily revolves around identifying and removing Single Points of Failure by adding redundancy.
</details>

**6. What does SLA stand for?**
- A) System Level Architecture
- B) Service Level Agreement
- C) Server Load Analysis
- D) Standard Latency Average
<details>
<summary>Answer</summary>
**Correct Answer:** B) Service Level Agreement<br>
**Explanation:** An SLA is a formal, legally binding contract between a service provider and a customer outlining the expected level of service (e.g., guaranteed 99.9% uptime).
</details>

**7. If a cloud provider promises a 99.9% uptime SLA, what happens if their uptime drops to 99.0% for the month?**
- A) The cloud provider shuts down.
- B) The customer is typically entitled to financial compensation or service credits as outlined in the contract.
- C) The SLA automatically updates to 99.0%.
- D) Nothing, SLAs are just guidelines.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The customer is typically entitled to financial compensation...<br>
**Explanation:** The "Agreement" part of an SLA includes penalties if the provider fails to meet their obligations.
</details>

**8. What is Redundancy in system design?**
- A) Deleting unnecessary data.
- B) The duplication of critical components (servers, databases, network links) to increase reliability and availability.
- C) Running the exact same code twice.
- D) Reducing the number of servers to save money.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The duplication of critical components...<br>
**Explanation:** Redundancy means having backups. If your primary database crashes, a redundant secondary database is there to take over.
</details>

**9. What does MTTR stand for?**
- A) Maximum Time To Respond
- B) Mean Time To Recovery (or Repair)
- C) Minimum Traffic Transfer Rate
- D) Main Terminal Transmission Route
<details>
<summary>Answer</summary>
**Correct Answer:** B) Mean Time To Recovery (or Repair)<br>
**Explanation:** MTTR is the average time it takes to repair a failed system and restore it to full functionality.
</details>

**10. To achieve high availability, what should your goal be regarding MTBF and MTTR?**
- A) Decrease MTBF, Decrease MTTR
- B) Increase MTBF, Increase MTTR
- C) Increase MTBF, Decrease MTTR
- D) Decrease MTBF, Increase MTTR
<details>
<summary>Answer</summary>
**Correct Answer:** C) Increase MTBF, Decrease MTTR<br>
**Explanation:** You want to increase the Mean Time Between Failures (make crashes rare) and decrease the Mean Time To Recovery (fix crashes incredibly fast).
</details>

---

### Medium (Questions 11 - 20)

**11. What is the difference between an SLO (Service Level Objective) and an SLI (Service Level Indicator)?**
- A) SLO is the target goal set by the team; SLI is the actual real-world measurement of the service's performance.
- B) SLO is the actual measurement; SLI is the target goal.
- C) SLO is a legal contract; SLI is a hardware metric.
- D) There is no difference; they mean the same thing.
<details>
<summary>Answer</summary>
**Correct Answer:** A) SLO is the target goal... SLI is the actual real-world measurement...<br>
**Explanation:** If your objective (SLO) is to have pages load in under 200ms, and your monitoring tool reports (SLI) that pages are loading in 150ms, you are successfully meeting your SLO.
</details>

**12. Which formula correctly calculates Availability?**
- A) `Downtime / (Uptime + Downtime)`
- B) `Uptime / (Uptime + Downtime)`
- C) `MTTR / MTBF`
- D) `(Uptime * Downtime) / 100`
<details>
<summary>Answer</summary>
**Correct Answer:** B) `Uptime / (Uptime + Downtime)`<br>
**Explanation:** Availability is the ratio of time a system is functional divided by the total time it was supposed to be functional.
</details>

**13. What is "Graceful Degradation"?**
- A) When a server crashes elegantly without displaying an error message.
- B) A design strategy where a system maintains partial functionality rather than failing completely when a specific component breaks.
- C) Downgrading the user's subscription plan.
- D) Using older hardware to save money.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A design strategy where a system maintains partial functionality...<br>
**Explanation:** If Netflix's "Recommended for You" microservice goes down, graceful degradation means the app still lets you search and watch movies, rather than bringing down the entire Netflix platform.
</details>

**14. What is "Failover"?**
- A) The process of completely shutting down a system.
- B) The automatic switching of traffic and operations to a redundant standby system upon the failure of the primary system.
- C) A metric that tracks how many users failed to log in.
- D) The process of deleting corrupted data.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The automatic switching of traffic and operations to a redundant standby system...<br>
**Explanation:** Failover is the mechanism that utilizes redundancy. Without failover, a redundant server just sits there uselessly when the main server dies.
</details>

**15. If a system is rated at "Three Nines" (99.9%) availability, roughly how much downtime is permitted per year?**
- A) ~5 minutes
- B) ~52 minutes
- C) ~8.7 hours
- D) ~3.6 days
<details>
<summary>Answer</summary>
**Correct Answer:** C) ~8.7 hours<br>
**Explanation:** 0.1% of a year (365 days * 24 hours * 60 minutes) equals roughly 8.76 hours of permitted downtime.
</details>

**16. In an Active-Passive high availability setup, what is a potential drawback?**
- A) The passive node cannot be monitored.
- B) It requires exactly three servers to work.
- C) The hardware/resources of the passive node are underutilized because it only processes traffic if the active node fails.
- D) It causes the database to desynchronize.
<details>
<summary>Answer</summary>
**Correct Answer:** C) The hardware/resources of the passive node are underutilized...<br>
**Explanation:** You are paying for a server that does nothing most of the time. (Conversely, Active-Active utilizes all servers but is harder to manage).
</details>

**17. What is an "Error Budget"?**
- A) The amount of money allocated to fix bugs.
- B) The maximum allowable amount of downtime or error rate a service can have before consequences (like halting new feature releases) are enforced.
- C) A metric used to track financial losses during an outage.
- D) The cost of hiring Site Reliability Engineers (SREs).
<details>
<summary>Answer</summary>
**Correct Answer:** B) The maximum allowable amount of downtime or error rate...<br>
**Explanation:** If your SLO is 99.9%, your Error Budget is 0.1%. If developers consume their 0.1% error budget for the month due to buggy releases, they must stop pushing new features and focus solely on stability.
</details>

**18. Why is achieving 100% Availability generally considered impossible or impractical?**
- A) Because the speed of light limits data transfer.
- B) Because it requires infinite servers.
- C) Due to unpredictable hardware failures, network cuts, mandatory maintenance, software bugs, and the exponential cost of mitigating every possible edge case.
- D) Because DNS takes 24 hours to update.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Due to unpredictable hardware failures, network cuts... and the exponential cost...<br>
**Explanation:** To go from 99.99% to 99.999% might cost millions of dollars in engineering and redundant global data centers. Trying to reach 100% is statistically and financially unfeasible.
</details>

**19. What is "Chaos Engineering"?**
- A) A poorly managed development process.
- B) The practice of intentionally injecting failures (like shutting down servers randomly) into a production system to prove its resilience and high availability mechanisms work.
- C) A hacking technique to take down websites.
- D) Using random number generators for encryption.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The practice of intentionally injecting failures... into a production system...<br>
**Explanation:** Popularized by Netflix's "Chaos Monkey", this practice ensures that the failover, redundancy, and alerts actually work in the real world before a genuine crisis occurs.
</details>

**20. If your system requires manual human intervention to restart a crashed database, what metric is most negatively impacted?**
- A) MTBF (Mean Time Between Failures)
- B) SLO (Service Level Objective)
- C) MTTR (Mean Time To Recovery)
- D) SLI (Service Level Indicator)
<details>
<summary>Answer</summary>
**Correct Answer:** C) MTTR (Mean Time To Recovery)<br>
**Explanation:** Waiting for a human to wake up, read an alert, log in, and restart the database drastically increases the time it takes to recover (high MTTR). Automated failover minimizes MTTR.
</details>

---

### Hard (Questions 21 - 30)

**21. In a multi-component system, if Component A has 99% availability and Component B has 99% availability, and they are connected in SERIES (both must work for the system to work), what is the total system availability?**
- A) 99%
- B) 99.99%
- C) 98.01%
- D) 198%
<details>
<summary>Answer</summary>
**Correct Answer:** C) 98.01%<br>
**Explanation:** For components in series, you multiply their availabilities: 0.99 * 0.99 = 0.9801 (98.01%). Adding dependencies *decreases* overall availability.
</details>

**22. If Component A (99%) and Component B (99%) are connected in PARALLEL (only one needs to work for the system to function), what is the total system availability?**
- A) 99%
- B) 98.01%
- C) 99.99%
- D) 100%
<details>
<summary>Answer</summary>
**Correct Answer:** C) 99.99%<br>
**Explanation:** For parallel components (redundancy), you calculate the probability of *both* failing: (1 - 0.99) * (1 - 0.99) = 0.01 * 0.01 = 0.0001 (0.01% chance of total failure). Thus, availability is 100% - 0.01% = 99.99%.
</details>

**23. What is the "Thundering Herd" problem during system recovery?**
- A) When a database recovers, it deletes all new data.
- B) When a failed service comes back online and is immediately overwhelmed by a massive backlog of retried requests, causing it to crash again instantly.
- C) When servers consume too much electricity during boot.
- D) When multiple master databases try to sync simultaneously.
<details>
<summary>Answer</summary>
**Correct Answer:** B) When a failed service comes back online and is immediately overwhelmed...<br>
**Explanation:** If clients aggressively retry their failed requests in a tight loop, the moment the server revives, the flood of retries acts like a self-inflicted DDoS attack.
</details>

**24. How can clients help prevent the Thundering Herd problem when retrying failed requests?**
- A) By using UDP instead of TCP.
- B) By implementing Exponential Backoff and Jitter.
- C) By sending the request in an infinite loop.
- D) By clearing their local cache.
<details>
<summary>Answer</summary>
**Correct Answer:** B) By implementing Exponential Backoff and Jitter.<br>
**Explanation:** Exponential backoff means waiting longer between each retry (1s, 2s, 4s, 8s). Jitter adds a random delay (e.g., 1.2s, 2.5s) so not all clients retry at the exact same millisecond, smoothing out the traffic spike.
</details>

**25. What is a "Circuit Breaker" pattern in microservices?**
- A) A hardware switch to turn off the server rack.
- B) A software pattern that detects when a downstream service is failing and temporarily blocks calls to it, immediately returning an error to prevent cascading failures.
- C) A tool that breaks encryption to inspect packets.
- D) A load balancing algorithm.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A software pattern that detects when a downstream service is failing and temporarily blocks calls...<br>
**Explanation:** Just like an electrical circuit breaker trips to prevent a house fire, the software circuit breaker trips to prevent a failing microservice from tying up all threads and crashing the calling service (cascading failure).
</details>

**26. In the context of SLAs, what are "Service Credits"?**
- A) Points users can use to buy premium features.
- B) Financial compensation or discounts provided by a cloud provider to a customer if the provider breaches the agreed-upon SLA uptime.
- C) Credits used by servers to prioritize CPU time.
- D) A metric used to calculate SLI.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Financial compensation or discounts provided by a cloud provider...<br>
**Explanation:** If AWS or Azure guarantees 99.99% uptime and drops below it, they automatically owe the customer service credits (refunds) on their next bill.
</details>

**27. What is "Multi-Region" (or Multi-AZ) deployment in Cloud Architecture?**
- A) Translating a website into multiple languages.
- B) Deploying redundant infrastructure across physically distant data centers to ensure availability even if a flood, earthquake, or total power grid failure destroys an entire region.
- C) Using both AWS and Google Cloud simultaneously.
- D) Deploying different versions of an app to different users.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Deploying redundant infrastructure across physically distant data centers...<br>
**Explanation:** A single data center (Availability Zone) can be destroyed by a natural disaster. Multi-Region deployment ensures that if US-East goes dark, EU-West takes over seamlessly.
</details>

**28. Which component is strictly necessary for cross-region automated failover?**
- A) A Forward Proxy
- B) A Local Layer 4 Load Balancer
- C) Global DNS Routing with Health Checks (e.g., Route 53)
- D) A Content Delivery Network (CDN)
<details>
<summary>Answer</summary>
**Correct Answer:** C) Global DNS Routing with Health Checks (e.g., Route 53)<br>
**Explanation:** A local load balancer only works inside one data center. To route traffic from a dead data center in New York to a healthy one in London, you must rely on Global DNS services that monitor the regions and update IP routing dynamically.
</details>

**29. What is "Rate Limiting" and how does it improve Availability?**
- A) It limits the amount of data a server can store.
- B) It restricts the number of requests a user or IP can make in a given timeframe, preventing accidental abuse or malicious spikes from overwhelming the system and bringing it down for everyone else.
- C) It limits the CPU speed to save power.
- D) It restricts the number of servers that can run simultaneously.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It restricts the number of requests a user or IP can make... preventing... spikes from overwhelming the system...<br>
**Explanation:** Rate limiting ensures fair usage. If one faulty script tries to send 10,000 requests per second, the rate limiter blocks it, ensuring the system remains available for all other legitimate users.
</details>

**30. What role does "Observability" (Monitoring, Logging, Tracing) play in High Availability?**
- A) It actively blocks hackers.
- B) It provides the data necessary to calculate SLIs, detect anomalies before they cause a crash, and drastically reduce MTTR during an outage by pinpointing the root cause quickly.
- C) It automatically writes code to fix bugs.
- D) It compresses the database to save space.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It provides the data necessary to calculate SLIs, detect anomalies... and drastically reduce MTTR...<br>
**Explanation:** You cannot achieve High Availability if you are blind. Good observability tools (like Prometheus, Datadog) alert engineers immediately when things go wrong, allowing for rapid recovery.
</details>
