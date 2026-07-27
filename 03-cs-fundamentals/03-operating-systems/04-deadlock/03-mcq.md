# 04. Deadlock (Practice MCQs)

This file contains 40 in-depth MCQs covering Deadlock concepts, the 4 Coffman Conditions, Deadlock Prevention, Avoidance (Banker's Algorithm), Deadlock Detection, the Ostrich Algorithm, and differences between Deadlock and Starvation.

---

**Q1. What is a "Deadlock" in an Operating System?**
A) A situation where the OS shuts down due to overheating
B) A situation where a set of processes are permanently blocked because each process is holding a resource and waiting for another resource held by another process in the set
C) A network disconnection
D) A process that has finished execution but hasn't been deleted

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডেডলক হলো এমন একটি জ্যাম বা হ্যাং অবস্থা, যেখানে সবাই একে অপরের জন্য অনন্তকাল ওয়েট করতে থাকে এবং কেউই কাজ শেষ করতে পারে না।
</details>

---

**Q2. How many necessary conditions MUST hold simultaneously for a deadlock to occur (known as the Coffman conditions)?**
A) 2
B) 3
C) 4
D) 5

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ডেডলক হতে হলে ৪টি শর্ত (Mutual Exclusion, Hold and Wait, No Preemption, Circular Wait) একসাথে পূরণ হতে হবে। একটি ভাঙতে পারলেই ডেডলক হবে না!
</details>

---

**Q3. Which condition states that at least one resource must be held in a non-sharable mode?**
A) Hold and Wait
B) No Preemption
C) Mutual Exclusion
D) Circular Wait

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Mutual Exclusion মানে হলো এমন একটি রিসোর্স (যেমন প্রিন্টার), যা একই সময়ে শুধু একজনই ব্যবহার করতে পারবে। এটি শেয়ার করা যায় না।
</details>

---

**Q4. What does the "Hold and Wait" condition mean?**
A) A process must wait for the user to press a key
B) A process is currently holding at least one resource and is requesting additional resources that are currently held by other processes
C) A process is put on hold by the OS
D) A process releases all resources before waiting

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Hold (ধরে রাখা) এবং Wait (চাওয়া)। অর্থাৎ, প্রসেস তার নিজের কাছে থাকা জিনিস ছাড়বে না, উল্টো সে অন্যজনের জিনিস পাওয়ার জন্য ওয়েট করবে।
</details>

---

**Q5. What does the "No Preemption" condition mean in the context of Deadlock?**
A) The OS can force a process to give up its resources
B) Resources cannot be forcefully taken away from a process; they must be voluntarily released by the process holding them after it finishes its task
C) Processes cannot be deleted
D) The CPU cannot context switch

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: No Preemption মানে হলো জোর খাটানো যাবে না। যে প্রসেসটি রিসোর্স দখল করে আছে, সে নিজে থেকে না ছাড়লে কেউ তা কেড়ে নিতে পারবে না।
</details>

---

**Q6. What is the "Circular Wait" condition?**
A) Processes are waiting in a straight line queue
B) A closed chain (a circle) of two or more processes exists, where each process is waiting for a resource held by the next process in the chain
C) A process is waiting for the hard drive to spin in a circle
D) A process waiting for itself

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: P1 ওয়েট করছে P2 এর জন্য, আর P2 ওয়েট করছে P1 এর জন্য। এই গোলকধাঁধাকেই Circular Wait বলে।
</details>

---

**Q7. If we want to implement "Deadlock Prevention", what do we need to do?**
A) Buy more RAM
B) Ensure that AT LEAST ONE of the 4 Coffman conditions can never occur in the system
C) Run a virus scan
D) Reboot the system daily

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডেডলক ঠেকানোর (Prevention) একমাত্র উপায় হলো ওই ৪টি শর্তের যেকোনো একটিকে ভেঙে দেওয়া বা ফলস (False) প্রমাণ করা।
</details>

---

**Q8. Why is it generally impossible to eliminate the "Mutual Exclusion" condition to prevent deadlocks?**
A) Because hackers will attack the system
B) Because some hardware resources (like Printers, Tape Drives, or specific memory locks) are inherently non-sharable. Two processes cannot print at the exact same physical millisecond.
C) Because the OS doesn't support it
D) Because it makes the code too long

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কিছু জিনিস আছে যা চাইলেও শেয়ার করা যায় না। দুজন মানুষ একসাথে একটি কি-বোর্ডে টাইপ করতে পারে না। তাই Mutual Exclusion শর্তটি ভাঙা প্রায় অসম্ভব।
</details>

---

**Q9. How can a system break the "Hold and Wait" condition?**
A) By making all processes wait indefinitely
B) By requiring a process to request and acquire ALL the resources it will ever need at the very beginning before it starts running. If it can't get all of them, it gets none.
C) By increasing the CPU speed
D) By killing processes randomly

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কাজ শুরুর আগেই প্রসেসকে যদি তার সব দরকারি জিনিস দিয়ে দেওয়া হয়, তবে সে আর মাঝপথে গিয়ে কারো জন্য ওয়েট (Wait) করবে না।
</details>

---

**Q10. What is the main disadvantage of breaking "Hold and Wait" by giving a process all resources at the start?**
A) It uses too much internet bandwidth
B) Severe Resource Inefficiency (Low resource utilization). A process might hold a printer for 5 hours just because it needs it for 1 minute at the very end.
C) It deletes files
D) It crashes the OS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রসেসটি হয়তো কাজ করবে ৫ ঘণ্টা, আর তার প্রিন্টার লাগবে লাস্টের ১ মিনিটে। কিন্তু কাজ শুরুর আগেই সে প্রিন্টার দখল করে বসে থাকলে বাকি ৫ ঘণ্টা অন্য কেউ প্রিন্টার ইউজ করতে পারবে না। এতে বিশাল লস!
</details>

---

**Q11. How can a system theoretically break the "No Preemption" condition?**
A) By never preempting
B) If a process requests a resource that is not available, the OS forces it to release all the resources it currently holds, putting them back in the pool, and makes the process start over.
C) By upgrading to Windows 11
D) By lowering the priority

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কোনো প্রসেস যদি জেদ করে বসে থাকে, তবে OS তাকে ঘাড় ধরে বের করে দেবে এবং তার সব রিসোর্স কেড়ে নিয়ে অন্য কাউকে দিয়ে দেবে।
</details>

---

**Q12. What is the most practical and commonly used technique to prevent Deadlock (by breaking Circular Wait)?**
A) Never using locks
B) Resource Ordering: Assigning a unique numerical ID to every resource (1, 2, 3...) and forcing all processes to request resources strictly in increasing numerical order.
C) Giving every process its own CPU
D) Using random numbers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আমরা যদি নিয়ম করি যে সবাইকে আগে Lock-1 নিতে হবে, তারপর Lock-2 নিতে হবে (উল্টা নেওয়া যাবে না), তবে আর কখনোই সাইকেল (Circular wait) তৈরি হবে না।
</details>

---

**Q13. What is "Deadlock Avoidance"?**
A) Avoiding writing bad code
B) The OS dynamically examines every resource request before granting it. If granting it might lead to a future deadlock (an "Unsafe State"), the OS denies the request and makes the process wait.
C) Reinstalling the OS
D) Deleting large files

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এখানে OS কোনো প্রসেসকে রিসোর্স দেওয়ার আগে ভবিষৎ প্রেডিক্ট করে। যদি দেখে রিসোর্স দিলে সামনে গিয়ে জ্যাম (Unsafe state) লাগতে পারে, তবে সে রিকোয়েস্ট রিজেক্ট করে দেয়।
</details>

---

**Q14. What is a "Safe State" in Deadlock Avoidance?**
A) A state where no viruses exist
B) A state where there is at least one sequence of execution for all processes that allows them all to finish without causing a deadlock
C) A state where all files are saved
D) A state where the CPU is idle

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সেফ স্টেট মানে হলো, সিস্টেমে এমন অন্তত একটি রাস্তা (Sequence) আছে, যে রাস্তায় হাঁটলে সবার কাজ শেষ হবে এবং কোনো জ্যাম বা ডেডলক লাগবে না।
</details>

---

**Q15. Which famous algorithm is used by Operating Systems for Deadlock Avoidance?**
A) The Dijkstra Algorithm
B) The Banker's Algorithm
C) The Round Robin Algorithm
D) The Bubble Sort Algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডেডলক অ্যাভয়েড করার সবচেয়ে বিখ্যাত অ্যালগরিদম হলো Banker's Algorithm.
</details>

---

**Q16. Why is it called the "Banker's Algorithm"?**
A) Because it was invented by a banker
B) Because it mimics how a bank operates: A bank never gives out a loan if doing so means it won't have enough cash left to satisfy the needs of its most important customers (preventing the bank from going bankrupt/deadlocking).
C) Because it costs money to run
D) Because it stores data in vaults

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ব্যাংক যেমন লোন দেওয়ার আগে চেক করে দেখে যে লোন দিলে তার দেউলিয়া হওয়ার চান্স আছে কি না, এই অ্যালগরিদমটিও ঠিক সেভাবেই কাজ করে।
</details>

---

**Q17. What information MUST the OS know in advance for the Banker's Algorithm to work?**
A) The user's passwords
B) The EXACT "Maximum Need" of every single process (i.e., the maximum number of each resource a process will ever request during its entire lifetime).
C) The file sizes
D) The IP addresses

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এই অ্যালগরিদমের সবচেয়ে বড় সমস্যা হলো, প্রসেস শুরু হওয়ার আগেই OS কে জানতে হয় যে ওই প্রসেসের ফিউচারে ম্যাক্সিমাম কয়টি রিসোর্স লাগতে পারে। বাস্তবে এটি জানা প্রায় অসম্ভব।
</details>

---

**Q18. Why is Deadlock Avoidance (Banker's Algorithm) rarely used in general-purpose modern Operating Systems like Windows or Linux?**
A) It is patented by Apple
B) It is highly impractical. Processes rarely know their maximum resource needs in advance, and running the algorithm for every single request causes massive CPU overhead.
C) It deletes files
D) It only works on 32-bit systems

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রতি সেকেন্ডে হাজার হাজার রিকোয়েস্ট আসে। প্রত্যেকবার Banker's Algorithm চালিয়ে চেক করাটা CPU এর জন্য অনেক ওভারহেড এবং রিয়েল লাইফে প্র্যাকটিক্যাল না।
</details>

---

**Q19. Instead of Prevention or Avoidance, what do modern OSs (Windows, Linux, macOS) typically do regarding Deadlocks?**
A) They use AI to solve them
B) Deadlock Ignorance (The Ostrich Algorithm): They simply pretend deadlocks will never happen because they are rare. If a deadlock does occur, they rely on the user to manually reboot the PC or kill the frozen app via Task Manager.
C) They format the hard drive
D) They email the developer

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: উটপাখি (Ostrich) যেমন ঝড় দেখলে বালিতে মাথা গুঁজে থাকে, আমাদের OS গুলোও ডেডলক চেক করা বাদ দিয়ে বালিতে মাথা গুঁজে থাকে! কারণ ডেডলক চেক করার চেয়ে হ্যাং করলে ইউজারকে দিয়ে 'End Task' করানো অনেক সস্তা।
</details>

---

**Q20. What is "Deadlock Detection and Recovery"?**
A) Using antivirus software
B) The OS allows deadlocks to happen, but periodically runs a scanner to detect if a circular wait exists. If detected, it recovers by forcefully terminating (killing) one or more of the deadlocked processes.
C) A feature in Google Chrome
D) A hardware reset switch

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: অনেক স্পেশাল সিস্টেমে (যেমন ডাটাবেস) OS মাঝে মাঝে স্ক্যান করে দেখে ডেডলক লেগেছে কি না। জ্যাম লাগলে সে জোর করে একটি বা দুটি প্রসেসকে কিল (Kill) করে জ্যাম ছাড়িয়ে দেয়।
</details>

---

**Q21. How does an OS graphically represent processes and resources to detect deadlocks?**
A) Using a Pie Chart
B) Using a Resource Allocation Graph (RAG), where circles are processes, squares are resources, and arrows show who is holding or requesting what. A cycle in this graph indicates a potential deadlock.
C) Using a Bar Graph
D) Using HTML tables

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Resource Allocation Graph (RAG) এ তীরচিহ্ন দিয়ে বোঝানো হয় কে কার জন্য ওয়েট করছে। যদি তীরচিহ্নগুলো মিলে একটি গোল সার্কেল বা সাইকেল (Cycle) তৈরি করে, তার মানে সেখানে ডেডলক হয়েছে।
</details>

---

**Q22. What is the fundamental difference between Starvation and Deadlock?**
A) They are exactly the same
B) In Deadlock, processes are permanently frozen and will NEVER finish. In Starvation, a process is indefinitely delayed because other processes are jumping the queue, but it is NOT permanently frozen (it will finish if the high-priority traffic stops).
C) Starvation only happens to RAM
D) Deadlock only happens to Hard Drives

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Starvation মানে শুধু ওয়েট করা, সিস্টেম হ্যাং করে না (দেরিতে হলেও কাজ শেষ হবে)। কিন্তু Deadlock মানে হলো সিস্টেম পুরোপুরি মারা গেছে, কেউই আর নড়তে পারবে না।
</details>

---

**Q23. Can a system be in an "Unsafe State" but NOT be in a Deadlock?**
A) No, Unsafe means Deadlock
B) Yes. An Unsafe state simply means a deadlock is POSSIBLE in the future if processes request resources in the worst possible order. It does not mean they are currently deadlocked.
C) Only in Linux
D) Only if RAM is full

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Unsafe state মানে জ্যাম লাগার 'সম্ভাবনা' আছে, কিন্তু এখনো জ্যাম লাগেনি। প্রসেসগুলো যদি নিজে থেকে আগেভাগে রিসোর্স ছেড়ে দেয়, তবে ডেডলক নাও হতে পারে।
</details>

---

**Q24. Which deadlock recovery method involves rolling a process back to a previous "save state" instead of killing it completely?**
A) Safe Mode
B) Checkpointing and Rollback
C) Factory Reset
D) System Restore

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডাটাবেস সিস্টেমে ডেডলক হলে পুরো প্রসেস কিল না করে, তাকে আগের একটি সেভ করা পয়েন্টে (Checkpoint) ফেরত পাঠিয়ে দেওয়া হয় (Rollback)।
</details>

---

**Q25. What is a "Livelock"?**
A) A deadlock that is broadcast live on the internet
B) Two or more processes continuously change their states in response to changes in the other processes without doing any useful work. (Like two people walking in a hallway, repeatedly stepping to the same side to avoid each other, blocking each other infinitely).
C) A lock that cannot be broken
D) A database lock

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডেডলকে সবাই ফ্রিজ (Frozen) হয়ে থাকে। কিন্তু লাইভলকে (Livelock) তারা ফ্রিজ থাকে না, তারা বারবার চেষ্টা করতে থাকে কিন্তু লাভ কিছুই হয় না। (যেমন: দুজন মানুষ রাস্তায় মুখোমুখি হলে একে অপরকে সাইড দিতে গিয়ে বারবার একই দিকে সরে গিয়ে ব্লক করা)।
</details>

---

**Q26. Which of the following is NOT one of the 4 Coffman conditions?**
A) Mutual Exclusion
B) Hold and Wait
C) Context Switching
D) Circular Wait

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Context Switching হলো OS এর একটি নরমাল কাজ, এটি ডেডলকের কোনো শর্ত (Condition) নয়।
</details>

---

**Q27. If a Resource Allocation Graph (RAG) contains a cycle, and every resource has exactly ONE instance (e.g., only 1 printer, only 1 scanner), is it a Deadlock?**
A) No
B) Yes, a cycle in a single-instance resource graph guarantees a Deadlock.
C) Maybe
D) Only if the CPU is single-core

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গ্রাফে যদি সাইকেল থাকে এবং প্রতিটি রিসোর্স যদি একটাই থাকে, তবে ১০০% গ্যারান্টি যে সেখানে ডেডলক হয়েছে।
</details>

---

**Q28. If a Resource Allocation Graph (RAG) contains a cycle, but resources have MULTIPLE instances (e.g., 3 printers available), is it a guaranteed Deadlock?**
A) Yes, always
B) No. A cycle is a necessary condition, but not a sufficient one if multiple instances exist. Another process outside the cycle might release a printer, breaking the deadlock.
C) Never
D) Only on Mac

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: মাল্টিপল প্রিন্টার থাকলে সাইকেল হলেও ডেডলক নাও হতে পারে। কারণ সাইকেলের বাইরের অন্য কোনো প্রসেস হয়তো তার প্রিন্টারটি ছেড়ে দেবে, আর তখন আটকে থাকা প্রসেসটি সেই প্রিন্টার নিয়ে কাজ শুরু করে সাইকেলটি ভেঙে দেবে।
</details>

---

**Q29. In Java, what is the most common cause of Deadlocks when using multi-threading?**
A) Using too many variables
B) Nested `synchronized` blocks where two threads acquire locks in different orders (e.g., T1 locks A then B; T2 locks B then A)
C) Throwing exceptions
D) Creating too many classes

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: জাভাতে নেস্টেড লকের সিরিয়াল ব্রেক করলেই (Circular wait) ডেডলক লেগে যায়।
</details>

---

**Q30. How can you detect a Deadlock in a running Java application?**
A) By reading the source code
B) By taking a "Thread Dump" (using tools like `jstack` or VisualVM) which analyzes the JVM and explicitly points out which threads are blocked and waiting for which locks.
C) By checking the RAM usage
D) By reinstalling Java

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সার্ভারে অ্যাপ হ্যাং করলে আমরা `jstack` কমান্ড দিয়ে Thread Dump নিই। এটি পরিষ্কারভাবে বলে দেয় যে কোন থ্রেড কোন লকের কারণে ডেডলকে আটকে আছে।
</details>

---

**Q31. In the Banker's Algorithm, what does the "Need Matrix" represent?**
A) How much RAM the OS needs
B) The remaining resources a process still requires to finish its task (Calculated as: Maximum Need - Currently Allocated)
C) The user's internet speed
D) The number of CPU cores

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Need (কতটুকু দরকার) = Max (সর্বোচ্চ কত লাগবে) - Allocated (এখন কতটুকু দেওয়া হয়েছে)।
</details>

---

**Q32. In the Banker's Algorithm, what is the "Available Vector"?**
A) The IP addresses available
B) The exact count of each resource type (e.g., Printers, Scanners) that are currently completely free and not held by any process in the system
C) The amount of free hard drive space
D) The number of available threads

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Available মানে হলো এই মুহূর্তে সিস্টেমে কয়টি প্রিন্টার বা স্ক্যানার ফাঁকা পড়ে আছে।
</details>

---

**Q33. What is "Priority Inversion"?**
A) When a low priority process runs faster
B) A problematic scenario where a High-priority task is indirectly forced to wait for a Low-priority task because the Low-priority task holds a lock on a shared resource that the High-priority task needs.
C) When the OS flips the priorities
D) A feature of Round Robin

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ভিআইপি (High priority) প্রসেসের একটি লক দরকার, কিন্তু সেই লকটি ধরে বসে আছে একটি গরিব (Low priority) প্রসেস। ফলে ভিআইপি প্রসেসকে বাধ্য হয়ে গরিবের কাজ শেষ হওয়া পর্যন্ত ওয়েট করতে হয়! একেই Priority Inversion বলে।
</details>

---

**Q34. How is "Priority Inversion" typically solved?**
A) By killing the high priority task
B) Priority Inheritance: The OS temporarily boosts the priority of the low-priority task holding the lock to match the high-priority task, so it finishes faster and releases the lock quickly.
C) By deleting the lock
D) By rebooting

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ভিআইপি প্রসেস যখন দেখবে গরিব প্রসেসের কারণে সে আটকে আছে, তখন সে গরিবকে নিজের ভিআইপি পাওয়ার (Priority) ধার দেবে। যাতে গরিবটা ফাস্ট কাজ শেষ করে লকটা ছেড়ে দিতে পারে!
</details>

---

**Q35. What is a "Semaphore"?**
A) A lock that only allows one thread
B) An integer variable used for signaling among processes. It uses two atomic operations: `wait()` (decrements) and `signal()` (increments) to control access to a pool of resources.
C) A network protocol
D) A database table

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Semaphore হলো একটি কাউন্টার (যেমন ৫)। কেউ ঢুকলে সে ১ কমিয়ে দেয় (`wait`), আর বের হলে ১ বাড়িয়ে দেয় (`signal`)। ৫ জন ঢুকে গেলে কাউন্টার ০ হয়ে যায় এবং বাকিদের ওয়েট করতে হয়।
</details>

---

**Q36. What is a "Binary Semaphore"?**
A) A semaphore with 10 slots
B) A semaphore that can only have values 0 or 1, essentially acting exactly like a Mutex lock
C) A semaphore used for compiling binary code
D) A hardware semaphore

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: বাইনারি সেমাফোরের ভ্যালু শুধু ০ বা ১ হতে পারে। অর্থাৎ এটি Mutex লকের মতোই কাজ করে (একবারে শুধু একজন ঢুকতে পারবে)।
</details>

---

**Q37. What is the classic "Dining Philosophers Problem"?**
A) A problem about writing a restaurant app
B) A classic synchronization problem illustrating Deadlock. 5 philosophers sit at a table with 5 forks. They need 2 forks to eat. If everyone picks up their left fork simultaneously, no one can get a right fork, resulting in a deadlock.
C) A problem about database queries
D) A web development framework

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ৫ জন মানুষ গোল হয়ে বসে আছে, তাদের মাঝে ৫টি চামচ আছে। খেতে হলে ২ হাতে ২টি চামচ লাগবে। সবাই যদি একসাথে বাম হাতের চামচটি তুলে নেয়, তবে ডান হাতের জন্য আর কোনো চামচ বাকি থাকে না। সবাই অনন্তকাল ওয়েট করতে থাকে (Deadlock)।
</details>

---

**Q38. How can the "Dining Philosophers Problem" be solved to prevent Deadlock?**
A) By adding more food
B) Resource Ordering: Number the forks 1 to 5. Force every philosopher to always pick up the lower-numbered fork first. This breaks the Circular Wait.
C) By making them eat with one hand
D) By asking them to leave

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: চামচগুলোকে ১ থেকে ৫ সিরিয়াল দিয়ে যদি বলা হয় যে সবাইকে ছোট নাম্বারের চামচটি আগে তুলতে হবে, তবে ৫ নাম্বার মানুষটি ১ নাম্বার চামচ আগে তুলতে যাবে এবং সাইকেল বা গোলকধাঁধাটি ভেঙে যাবে।
</details>

---

**Q39. [Code Logic] If Thread A has Lock 1 and wants Lock 2, and Thread B has Lock 2 and wants Lock 3, and Thread C has Lock 3 and wants Lock 1... what will happen?**
A) They will execute sequentially
B) A perfect Deadlock, because a Circular Wait (A->B->C->A) has formed.
C) The OS will automatically fix it
D) Thread C will crash

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি একটি পারফেক্ট সাইকেল (Cycle)। A ওয়েট করছে B এর জন্য, B ওয়েট করছে C এর জন্য, C ওয়েট করছে A এর জন্য। সবাই ডেডলকে আটকে যাবে।
</details>

---

**Q40. [Conclusion] Why is the Ostrich Algorithm the preferred method for dealing with Deadlocks in personal computers (like your laptop)?**
A) Because it is mathematically perfect
B) Because deadlocks are relatively rare on PCs, and the massive CPU overhead required to constantly run Avoidance/Detection algorithms (like Banker's) is simply not worth the cost. It's cheaper to let the user reboot the rare frozen app.
C) Because Microsoft owns the patent
D) Because laptops don't have enough RAM

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডেডলক চেক করা অনেক দামি কাজ। পার্সোনাল পিসিতে বছরে হয়তো ১-২ বার ডেডলক হতে পারে। এই ২ বারের জন্য প্রতিদিন CPU এর এত পাওয়ার নষ্ট করার কোনো মানে হয় না। অ্যাপ হ্যাং করলে ইউজার রিস্টার্ট দিয়ে নেবে, এটাই সবচেয়ে সস্তা সমাধান (Ostrich Algorithm)!
</details>
