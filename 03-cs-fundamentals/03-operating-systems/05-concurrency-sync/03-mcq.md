# 05. Concurrency & Synchronization (Practice MCQs)

This file contains 40 in-depth MCQs covering Race Conditions, Critical Sections, Mutexes, Semaphores, Monitors, the Producer-Consumer problem, and Java's `wait()` and `notify()` mechanisms.

---

**Q1. What is "Concurrency" in Operating Systems?**
A) Executing two tasks at the exact same physical millisecond on different cores
B) The ability of the OS to manage multiple tasks seemingly at the same time by rapidly interleaving their execution (context switching) on a single or multiple cores
C) A type of network error
D) Running a program from a USB drive

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কনকারেন্সি মানে হলো অনেকগুলো কাজ একসাথে হ্যান্ডেল করা। CPU এত দ্রুত এক কাজ থেকে অন্য কাজে সুইচ করে যে আমাদের মনে হয় সব কাজ একসাথেই চলছে।
</details>

---

**Q2. What is a "Race Condition"?**
A) A competition between two CPUs to render graphics
B) A software bug that occurs when two or more threads access shared data concurrently and the final outcome critically depends on the exact timing or sequence of their execution
C) An error that happens only in car racing games
D) A hardware failure in the RAM

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একাধিক থ্রেড যদি একসাথে একই ভেরিয়েবল (যেমন Bank Balance) আপডেট করতে যায়, তবে কে কার আগে ডেটা রাইট করলো তার ওপর ভিত্তি করে রেজাল্ট ভুল আসতে পারে। একেই Race Condition বলে।
</details>

---

**Q3. What is a "Critical Section"?**
A) A section of the OS that cannot be deleted
B) The specific block of code in a program where shared resources (variables, files, databases) are accessed or modified, which requires protection from concurrent access
C) The part of the code that handles user passwords
D) The main function of a C program

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: পুরো কোডের যে অংশে Shared data (যেটা নিয়ে সবার মারামারি) থাকে, সেই স্পেসিফিক কোড ব্লকটিকেই Critical Section বলে।
</details>

---

**Q4. What is the primary goal of "Synchronization"?**
A) To make sure all clocks in a network show the same time
B) To ensure that multiple threads coordinate their execution correctly so that only one thread can execute its Critical Section at a time, preventing Race Conditions
C) To compress data before sending it over the network
D) To synchronize files to Google Drive

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সিঙ্ক্রোনাইজেশনের মূল উদ্দেশ্যই হলো Critical Section এ তালা (Lock) লাগিয়ে দেওয়া, যাতে একবারে শুধু একজনই ওই কোডটুকু রান করতে পারে।
</details>

---

**Q5. To successfully solve the Critical Section problem, three requirements must be met. Which of the following is NOT one of them?**
A) Mutual Exclusion
B) Progress
C) Bounded Waiting
D) Infinite Looping

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: Critical Section সমাধানের ৩টি শর্ত হলো: ১. Mutual Exclusion (একসাথে দুজন ঢুকবে না), ২. Progress (কেউ না থাকলে যে চাইবে সে ঢুকতে পারবে), ৩. Bounded Waiting (কাউকে অনন্তকাল ওয়েট করতে হবে না)। Infinite Looping কোনো শর্ত নয়।
</details>

---

**Q6. What does "Mutual Exclusion" mean in the context of the Critical Section problem?**
A) Both threads must exclude each other completely
B) If a thread is executing in its critical section, then no other threads can be executing in their critical sections (only one inside at a time)
C) Both threads execute exactly at the same time
D) The OS kills one of the threads

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Mutual Exclusion মানে হলো এক্সক্লুসিভ অ্যাক্সেস। একজন ভেতরে কাজ করলে অন্যরা কেউ ভেতরে ঢুকতে পারবে না।
</details>

---

**Q7. What does "Bounded Waiting" ensure?**
A) That threads are bounded by the RAM size
B) That there is a strict limit on how many times other threads can bypass a waiting thread, guaranteeing that the waiting thread will eventually get to enter its critical section (preventing Starvation)
C) That threads wait forever
D) That the waiting time is bounded by the internet speed

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Bounded Waiting মেকশিওর করে যে, কোনো থ্রেডকে যেন সারাজীবন দরজার বাইরে ওয়েট করতে না হয় (Starvation)। সে যেন একটা নির্দিষ্ট সময় পর অবশ্যই ভেতরে ঢোকার সুযোগ পায়।
</details>

---

**Q8. What is a "Mutex" (Mutual Exclusion Object)?**
A) A type of array
B) A software lock that a thread must acquire before entering a critical section, and release upon exiting. It guarantees exclusive access.
C) A hardware component inside the MMU
D) An antivirus feature

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Mutex হলো একটি তালা। থ্রেড ভেতরে ঢোকার সময় দরজায় এই তালাটি লাগিয়ে দেয়, কাজ শেষ হলে সে নিজে এসে তালা খোলে।
</details>

---

**Q9. Which of the following is a key characteristic of a Mutex?**
A) It can allow 5 threads at once
B) Ownership: Only the specific thread that acquired (locked) the Mutex has the right to release (unlock) it. Another thread cannot forcefully unlock it.
C) It deletes files if it fails
D) It is only used for databases

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Mutex এর সবচেয়ে বড় বৈশিষ্ট্য হলো Ownership (মালিকানা)। যে থ্রেড তালা লাগিয়েছে, শুধু সেই থ্রেডই তালা খুলতে পারবে। অন্য কেউ খুলতে পারবে না।
</details>

---

**Q10. What is a "Semaphore"?**
A) An integer variable that acts as a signaling mechanism (counter) to control access to a shared resource by multiple processes, using `wait()` and `signal()` operations
B) A type of network cable
C) A specialized load balancer
D) An encryption algorithm

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Semaphore কোনো তালা না, এটি হলো একটি সিগন্যাল বা কাউন্টার। কেউ ঢুকলে কাউন্টার ১ কমে যায়, বের হলে ১ বেড়ে যায়।
</details>

---

**Q11. What is the fundamental difference between a Mutex and a Semaphore?**
A) There is no difference
B) A Mutex is an ownership-based locking mechanism (only 1 thread allows access). A Semaphore is a signaling mechanism (counter) that can allow a specified number of threads (e.g., 3) to access a resource pool, and it has no strict ownership.
C) Semaphores are for threads, Mutexes are for processes
D) Mutexes are integers, Semaphores are strings

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Mutex এ শুধু ১ জন ঢুকতে পারে এবং এর মালিকানা আছে। আর Semaphore (Counting semaphore) এ একাধিক জন ঢুকতে পারে (কাউন্টার অনুযায়ী) এবং এর কোনো নির্দিষ্ট মালিকানা নেই।
</details>

---

**Q12. What is a "Binary Semaphore"?**
A) A semaphore that only works on binary files
B) A semaphore whose integer value can only be 0 or 1, essentially functioning very similarly to a Mutex (but without strict ownership rules)
C) A semaphore for 32-bit systems
D) A semaphore that compiles code

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: বাইনারি সেমাফোরের ভ্যালু শুধু ০ বা ১ হতে পারে। অর্থাৎ এটি একবারে শুধু একজনকে ঢুকতে দেয় (Mutex এর মতো)।
</details>

---

**Q13. In Semaphore terminology, what does the `wait()` (or `P()`) operation do?**
A) It makes the OS sleep
B) It decrements the semaphore value. If the value becomes negative, it blocks the calling thread until someone else signals.
C) It increases the RAM
D) It waits for the user to press Enter

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কেউ রুমে ঢুকলে সেমাফোরের `wait()` কল হয়, যার ফলে কাউন্টার থেকে ১ কমে যায়। কাউন্টার ০ হয়ে গেলে নতুন কেউ আসলে তাকে ব্লক (ওয়েট) করানো হয়।
</details>

---

**Q14. In Semaphore terminology, what does the `signal()` (or `V()`) operation do?**
A) It increments the semaphore value, potentially waking up one of the blocked threads waiting in the queue
B) It sends an email
C) It kills a thread
D) It connects to Wi-Fi

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: কেউ রুম থেকে কাজ শেষ করে বের হওয়ার সময় `signal()` কল করে। এতে কাউন্টার ১ বেড়ে যায় এবং লাইনে দাঁড়িয়ে থাকা কাউকে জাগিয়ে (Wake up) ভেতরে পাঠানো হয়।
</details>

---

**Q15. What is a "Monitor" in synchronization?**
A) The screen you are looking at
B) A high-level synchronization construct built directly into some programming languages (like Java) that encapsulates both the shared data and the methods that operate on it, automatically providing Mutual Exclusion without the programmer needing to manually manage locks
C) A network monitoring tool
D) A type of OS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Mutex/Semaphore দিয়ে কোড করা কঠিন। তাই Java-র মতো ল্যাঙ্গুয়েজগুলো Monitor কনসেপ্ট নিয়ে এসেছে (যেমন `synchronized` কিওয়ার্ড), যেখানে ল্যাঙ্গুয়েজ নিজেই তালামারার কাজটা হ্যান্ডেল করে।
</details>

---

**Q16. In Java, how do you easily create a Monitor for a block of code?**
A) By importing `java.util.Monitor`
B) By wrapping the code block or method with the `synchronized` keyword
C) By using a try-catch block
D) By creating a new Thread

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: জাভাতে কোনো মেথড বা ব্লকের আগে `synchronized` লিখে দিলেই সেটি Monitor হয়ে যায়। একবারে শুধু একজন থ্রেড ওই ব্লকে ঢুকতে পারে।
</details>

---

**Q17. What is the classic "Producer-Consumer Problem" (Bounded-Buffer Problem)?**
A) A problem about economics and inflation
B) A synchronization problem where one or more "Producers" are generating data and placing it in a fixed-size buffer, while "Consumers" are removing and processing that data from the buffer. They must be synchronized to prevent data corruption, buffer overflow, and buffer underflow.
C) A problem about downloading files
D) A database indexing problem

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রডিউসার ডেটা বানায়, আর কনজিউমার তা খায়। তাদের দুজনের মাঝখানে একটি নির্দিষ্ট সাইজের বাফার থাকে। তারা যেন একসাথে বাফারে হাত না দেয় এবং বাফার ফুল/খালি হলে যেন সঠিকভাবে ওয়েট করে, এটিই হলো মূল প্রবলেম।
</details>

---

**Q18. In the Producer-Consumer problem, what must the Producer do if the buffer is completely FULL?**
A) Overwrite the old data
B) It must go to sleep (wait) and stop producing until the Consumer removes some data and signals (notifies) it that there is free space
C) Throw an exception and crash
D) Increase the buffer size automatically

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: বাফার ফুল হলে প্রডিউসারকে ওয়েট করতে হবে। কনজিউমার একটু খালি করে সিগন্যাল দিলে সে আবার কাজ শুরু করবে।
</details>

---

**Q19. In the Producer-Consumer problem, what must the Consumer do if the buffer is completely EMPTY?**
A) Read garbage data
B) It must go to sleep (wait) until the Producer generates new data, places it in the buffer, and signals (notifies) it
C) Close the application
D) Return a null pointer exception

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: বাফার খালি থাকলে কনজিউমারকে ওয়েট করতে হবে। প্রডিউসার নতুন ডেটা রেখে সিগন্যাল দিলে সে আবার খেতে শুরু করবে।
</details>

---

**Q20. In Java, which methods are used by threads to communicate with each other inside a synchronized block (e.g., for solving the Producer-Consumer problem)?**
A) `start()` and `stop()`
B) `wait()`, `notify()`, and `notifyAll()`
C) `sleep()` and `interrupt()`
D) `lock()` and `unlock()`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `wait()` দিয়ে থ্রেড ঘুমিয়ে পড়ে (লক ছেড়ে দিয়ে), আর `notify()` বা `notifyAll()` দিয়ে অন্য থ্রেড তাকে জাগিয়ে দেয়। এগুলো অবজেক্ট (Object) ক্লাসের মেথড।
</details>

---

**Q21. What is the key difference between `Thread.sleep()` and `Object.wait()` in Java?**
A) They are exactly the same
B) `sleep()` is for milliseconds, `wait()` is for seconds
C) `sleep()` keeps the lock (does not release it) while the thread pauses. `wait()` immediately RELEASES the lock it holds, allowing other threads to enter the synchronized block while it waits to be notified.
D) `sleep()` can only be called once

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: এটি ইন্টারভিউয়ের সুপার ফেভারিট প্রশ্ন! `sleep` করলে থ্রেড তালা (Lock) হাতে নিয়েই ঘুমায়, ফলে অন্য কেউ ঢুকতে পারে না। কিন্তু `wait` করলে থ্রেড তালাটা দরজায় রেখে ঘুমায়, যাতে অন্য কেউ রুমে ঢুকে কাজ করতে পারে।
</details>

---

**Q22. What is a "Spurious Wakeup"?**
A) Waking up from a bad dream
B) A rare situation where a thread blocked on `wait()` might wake up randomly WITHOUT being explicitly notified by a `notify()` call from another thread
C) Waking up a thread that is already dead
D) A hardware alarm clock

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: মাঝে মাঝে OS এর গ্লিচের কারণে কোনো সিগন্যাল (notify) ছাড়াই ঘুমন্ত থ্রেড নিজে নিজেই জেগে উঠতে পারে! একেই Spurious Wakeup বলে।
</details>

---

**Q23. Because of "Spurious Wakeups", how MUST a thread check its waiting condition in Java?**
A) Inside an `if` statement
B) Inside a `while` loop. (e.g., `while (buffer.isFull()) { wait(); }`). If it wakes up spuriously, the loop ensures it re-checks the condition and goes back to sleep if the buffer is still full.
C) Using a switch case
D) It doesn't need to check

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ভুল করে জেগে (Spurious wakeup) গেলে যেন সে কনফার্ম হয়ে নেয় যে আসলেই বাফার খালি হয়েছে কি না। এজন্য সবসময় `wait()` কে `if` এর বদলে `while` লুপের ভেতরে লিখতে হয়।
</details>

---

**Q24. What happens if a developer forgets to call `notify()` in the Consumer thread after consuming an item?**
A) The program runs faster
B) The Producer thread might remain stuck in the `wait()` state forever, resulting in a Deadlock-like scenario where production halts permanently
C) The Java compiler throws an error
D) The OS reboots

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কনজিউমার যদি খাওয়ার পর `notify()` না দেয়, তবে প্রডিউসার সারাজীবন ওয়েট করতেই থাকবে, সে আর কখনোই জাগবে না! পুরো সিস্টেম ফ্রিজ হয়ে যাবে।
</details>

---

**Q25. What is the "Readers-Writers Problem"?**
A) A problem with PDF software
B) A classic synchronization problem where a shared database can be read by multiple "Readers" simultaneously (which is safe), but if a "Writer" wants to modify the database, it must have exclusive access (no other readers or writers allowed).
C) A problem where the hard drive cannot be read
D) A network routing problem

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিডাররা শুধু ডেটা পড়ে, তাই একসাথে ১০০ জন রিডার পড়লে কোনো সমস্যা নেই। কিন্তু রাইটার ডেটা চেঞ্জ করে, তাই রাইটার যখন কাজ করবে, তখন অন্য কোনো রাইটার বা রিডার সেখানে থাকতে পারবে না। এটিই Readers-Writers প্রবলেমের মূল কনসেপ্ট।
</details>

---

**Q26. What does `notifyAll()` do in Java?**
A) It sends a push notification to the user
B) It wakes up ALL threads that are currently waiting on that object's monitor, rather than just waking up one random thread like `notify()` does
C) It stops all threads
D) It deletes all variables

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `notify()` কল করলে ওয়েট করা থ্রেডগুলোর মধ্যে থেকে র‍্যান্ডমলি শুধু একজনকে জাগানো হয়। আর `notifyAll()` কল করলে ওয়েট করা সবাইকে একসাথে জাগিয়ে দেওয়া হয় (তারপর তারা নিজেদের মধ্যে মারামারি করে একজন লক পায়)।
</details>

---

**Q27. Can you call `wait()` or `notify()` outside of a `synchronized` block in Java?**
A) Yes, perfectly fine
B) No. If you try, Java will throw an `IllegalMonitorStateException` because a thread MUST own the object's lock (be inside a synchronized block) before it can wait or notify on it.
C) Yes, but only in Python
D) Only if the thread is a daemon

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যার কাছে তালা (Lock) নেই, সে কীভাবে বলবে যে "আমি তালা রেখে ঘুমাচ্ছি"? একারণেই `wait` বা `notify` কল করতে হলে মাস্ট ওই অবজেক্টের `synchronized` ব্লকের ভেতরে থাকতে হবে।
</details>

---

**Q28. What is a "Spinlock"?**
A) A lock that rotates the CPU fan
B) A type of lock where the waiting thread aggressively loops ("spins") in a `while` loop continuously checking if the lock is available, rather than going to sleep.
C) A lock used for databases only
D) A feature of Windows 95

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নরমাল লকে থ্রেড ঘুমিয়ে যায়। কিন্তু Spinlock এ থ্রেড না ঘুমিয়ে সারাক্ষণ চেক করতে থাকে "লক কি ফ্রি হয়েছে? লক কি ফ্রি হয়েছে?"। এটি মাল্টি-কোর সিস্টেমে খুব অল্প সময়ের লকের জন্য ভালো, কারণ এতে ঘুম পাড়ানো এবং জাগানোর টাইম (Context switch overhead) বাঁচে।
</details>

---

**Q29. When is a Spinlock generally better to use than a traditional sleeping Mutex?**
A) On a single-core CPU
B) On multi-core systems when the expected wait time for the lock is extremely short (shorter than the time it takes to perform a full context switch to put the thread to sleep)
C) When writing HTML
D) When downloading large files

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যদি থ্রেড জানে যে লকটি ১ মিলিসেকেন্ড পরেই ফ্রি হয়ে যাবে, তবে ঘুমিয়ে গিয়ে আবার জেগে ওঠার প্রসেসে ২ মিলিসেকেন্ড নষ্ট করার চেয়ে, ১ মিলিসেকেন্ড জেগে থেকে (Spin) চেক করাটাই ফাস্ট!
</details>

---

**Q30. What is "Hardware Synchronization" (e.g., Test-and-Set or Compare-and-Swap instructions)?**
A) Physical locks on a server rack
B) Special atomic instructions provided directly by the CPU hardware that can read and modify a memory location in a single, uninterruptible clock cycle, serving as the foundation for building Mutexes and Semaphores in software.
C) Syncing an iPhone to a Mac
D) Using USB drives

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সফটওয়্যারের তালাগুলো (Mutex) কীভাবে কাজ করে? তারা আসলে হার্ডওয়্যারের (CPU) কিছু স্পেশাল কমান্ড (যেমন Compare-and-Swap) ব্যবহার করে, যে কমান্ডগুলো এতটাই ফাস্ট যে মাঝখানে কেউ ইন্টারাপ্ট করতে পারে না (Atomic)।
</details>

---

**Q31. [Code Logic] If a Semaphore is initialized with a value of 3 (e.g., `Semaphore s = new Semaphore(3);`), how many threads can execute the `wait()` operation successfully without getting blocked?**
A) 1
B) 2
C) 3
D) 4

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ভ্যালু ৩ মানে হলো ৩টি টেবিল ফাঁকা আছে। তাই পর পর ৩ জন মানুষ (Thread) বিনা বাধায় ঢুকে যেতে পারবে। ৪র্থ জন আসলে তাকে ব্লক করা হবে।
</details>

---

**Q32. In a database, what is "Optimistic Concurrency Control"?**
A) Hoping the database never crashes
B) Instead of locking a row before reading/writing (Pessimistic), the system reads the data, makes changes, and just before saving, checks if anyone else modified it in the meantime. If yes, it aborts and retries.
C) Locking the entire database table
D) Using a Semaphore for everything

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Optimistic (আশাবাদী) মানে হলো সে ধরে নেয় যে কেউ ডেটা চেঞ্জ করবে না। সে ডেটা রিড করে মডিফাই করে। সেভ করার ঠিক আগ মুহূর্তে সে চেক করে দেখে যে মাঝখানে অন্য কেউ চেঞ্জ করেছে কি না। চেঞ্জ করলে সে ফেইল মারে। এতে অহেতুক Lock লাগানোর টাইম বাঁচে।
</details>

---

**Q33. What is the "Sleeping Barber Problem"?**
A) A problem where the CPU goes to sleep
B) A classic synchronization problem involving a barber, a barber chair, and a waiting room with chairs. It models scenarios where a server (barber) sleeps when there are no clients, and wakes up when a client arrives, requiring careful semaphore coordination.
C) A hardware failure in the cooling fan
D) A web development framework

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: দোকানে কাস্টমার না থাকলে নাপিত ঘুমায়। কাস্টমার আসলে নাপিতকে জাগায়। আবার অনেক কাস্টমার আসলে তারা লাইনে বসে থাকে। এই জটিল রিয়েল-লাইফ সিনারিওগুলো Semaphore দিয়ে সলভ করাটাই হলো Sleeping Barber Problem।
</details>

---

**Q34. What does the term "Atomic Operation" mean?**
A) An operation that causes a nuclear explosion
B) An operation that is guaranteed to execute completely as a single, indivisible unit. It cannot be interrupted halfway through by a context switch.
C) An operation written in C language
D) An operation that deletes a file

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Atomic (অ্যাটমিক) কাজ মানে হলো এমন একটি কাজ যা মাঝপথে থামানো যায় না। কাজ শুরু হলে পুরোটা শেষ করেই ছাড়বে। এর মাঝখানে কোনো Context Switch হতে পারবে না।
</details>

---

**Q35. Why is the statement `count++` in Java/C++ NOT an atomic operation?**
A) Because it is too short
B) Because at the CPU/machine level, it actually requires 3 separate steps: Read the value from RAM to register, Add 1 to the register, and Write the value back to RAM. A context switch can happen between any of these steps, causing a Race Condition.
C) Because it is a syntax error
D) Because Java doesn't support math

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `count++` দেখতে এক লাইনের কোড মনে হলেও, CPU এর কাছে এটি ৩ লাইনের কাজ (Read, Add, Write)। এই ৩ কাজের মাঝখানে Context Switch হয়ে গেলে অন্য থ্রেড এসে ডেটা করাপ্ট করে দিতে পারে। তাই এটি Atomic নয়।
</details>

---

**Q36. How can you make `count++` thread-safe (atomic) in Java without using a heavy `synchronized` block?**
A) By wrapping it in parenthesis `(count++)`
B) By using atomic variables provided by the `java.util.concurrent.atomic` package (e.g., `AtomicInteger count = new AtomicInteger(); count.incrementAndGet();`) which use fast hardware-level compare-and-swap instructions.
C) By declaring it as a string
D) You cannot

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: জাভাতে `AtomicInteger` নামে একটি স্পেশাল ক্লাস আছে। এটি হার্ডওয়্যার লেভেলের ইনস্ট্রাকশন ইউজ করে, তাই `synchronized` এর মতো স্লো না হয়েও এটি 100% সেফলি (Atomic) ভ্যালু বাড়াতে পারে।
</details>

---

**Q37. What is "Thread Safety"?**
A) Wearing safety gear while coding
B) A concept ensuring that a piece of code or a data structure can be safely accessed and modified by multiple threads simultaneously without causing data corruption or race conditions.
C) Preventing a thread from being deleted
D) A type of firewall

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Thread-safe মানে হলো ওই কোড বা ফাংশনটি এমনভাবে লেখা হয়েছে (Lock বা Atomic দিয়ে), যে ১০০টি থ্রেড একসাথে কল করলেও কোনো ডেটা নষ্ট হবে না বা রেজাল্ট ভুল আসবে না।
</details>

---

**Q38. Is a standard `ArrayList` in Java thread-safe?**
A) Yes, completely safe
B) No. If multiple threads add items to a standard ArrayList simultaneously, data loss or exceptions (`ConcurrentModificationException`) will occur. You must use `Vector` or `Collections.synchronizedList()`.
C) Only in Python
D) Yes, but only for Strings

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নরমাল `ArrayList` বা `HashMap` থ্রেড-সেফ নয়। এদেরকে মাল্টি-থ্রেডিংয়ে ইউজ করতে হলে আলাদাভাবে লক করে নিতে হয় অথবা জাভার বিল্ট-ইন `ConcurrentHashMap` বা `Vector` ইউজ করতে হয়।
</details>

---

**Q39. What is the main disadvantage of making every single method in a class `synchronized` to ensure thread safety?**
A) The code becomes too short
B) Severe performance degradation (Bottleneck). It destroys concurrency because threads will constantly be blocked waiting for the single lock, effectively turning your multi-threaded program into a slow, single-threaded one.
C) It causes memory leaks
D) The OS will crash

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সবকিছুতে লক (synchronized) লাগিয়ে দিলে থ্রেডগুলো লাইনে দাঁড়িয়ে ওয়েট করতে করতেই সময় পার করে দেবে। ফলে আপনার মাল্টি-থ্রেডিং প্রোগ্রামটি সিঙ্গেল-থ্রেডিংয়ের মতোই স্লো হয়ে যাবে।
</details>

---

**Q40. [Conclusion] Why is understanding Concurrency and Synchronization crucial for modern Software Engineering?**
A) Because it is required for HTML
B) Because modern systems (Cloud, Web Servers, Microservices) rely heavily on multi-threading to handle thousands of concurrent users. Without proper synchronization, user data will get corrupted, balances will be miscalculated, and servers will randomly crash.
C) Because it makes the UI look pretty
D) Because it is a legal requirement

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: বর্তমানের সবকিছুই মাল্টি-কোর এবং ক্লাউড-বেজড। হাজার হাজার ইউজার একই সাথে সার্ভারে হিট করছে। তাই Concurrency কন্ট্রোল করতে না পারলে ইউজারের ব্যাংক ব্যালান্স উল্টাপাল্টা হয়ে যাবে এবং সিস্টেম ক্র্যাশ করবে!
</details>
