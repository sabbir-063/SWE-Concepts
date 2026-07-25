# 01. Process vs Thread (Practice MCQs)

This file contains 40 in-depth MCQs covering the differences between Processes and Threads, Context Switching, Concurrency vs Parallelism, Race Conditions, Deadlocks, and Synchronization techniques.

---

**Q1. What is the standard definition of a "Process" in an Operating System?**
A) A piece of code written in an IDE
B) A program in execution that has been loaded into memory (RAM) and assigned resources by the OS
C) A hardware component inside the CPU
D) A function call

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: হার্ডডিস্কে থাকা কোনো সফটওয়্যার যখন ডাবল-ক্লিক করে ওপেন করা হয় এবং সেটি র‍্যামে জায়গা নিয়ে চলা শুরু করে, তখন তাকে Process বলে।
</details>

---

**Q2. What is a "Thread"?**
A) An entirely separate program
B) A network connection
C) The smallest sequence of programmed instructions (a lightweight unit of execution) that can be managed independently by a scheduler within a process
D) A database table

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: একটি প্রসেসের ভেতরে থাকা সবচেয়ে ছোট কাজের এককই হলো Thread (Lightweight process)।
</details>

---

**Q3. How do multiple Processes typically interact with each other's memory?**
A) They share the exact same Heap memory
B) They can directly read and write to each other's variables easily
C) They are completely isolated. They cannot access each other's memory directly and must use Inter-Process Communication (IPC) mechanisms
D) They share the Stack but not the Heap

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: প্রতিটি প্রসেস আলাদা। একটি প্রসেস অন্য প্রসেসের মেমোরিতে উঁকি দিতে পারে না। ডেটা আদান-প্রদান করতে হলে IPC (যেমন Sockets, Pipes, Message Queues) ব্যবহার করতে হয়।
</details>

---

**Q4. How do multiple Threads within the same process interact with memory?**
A) They are completely isolated from each other
B) They share the same memory space (Heap, Data, Code) of their parent process, making data sharing extremely fast and easy (but dangerous)
C) They communicate via IPC
D) They only share the CPU cache

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একই প্রসেসের ভেতরের সব থ্রেড একই মেমোরি (Heap) শেয়ার করে। একারণেই তারা খুব দ্রুত নিজেদের মধ্যে ডেটা শেয়ার করতে পারে।
</details>

---

**Q5. While Threads share the Heap and Code segments, what memory space is strictly UNIQUE to each individual Thread?**
A) The CPU registers and the Call Stack (which tracks function calls and local variables)
B) The Global variables
C) The Database connection
D) The File descriptors

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: প্রতিটি থ্রেডের নিজস্ব একটি Stack থাকে। কারণ থ্রেডটি কোন লাইনে আছে বা তার লোকাল ভেরিয়েবলের মান কী, তা তাকে আলাদাভাবে মনে রাখতে হয়।
</details>

---

**Q6. What happens if a single Thread encounters a fatal error (like a Segmentation Fault or Unhandled Exception) and crashes?**
A) Only that specific thread dies, the rest of the process continues
B) The operating system restarts the thread
C) The entire parent Process (and all other threads within it) immediately crashes and terminates
D) The CPU switches to a different core

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেহেতু থ্রেডগুলো একই মেমোরি শেয়ার করে, তাই একটি থ্রেড মেমোরি করাপ্ট করলে বা ক্র্যাশ করলে পুরো প্রসেসটাই (অ্যাপ্লিকেশন) বন্ধ হয়ে যায়।
</details>

---

**Q7. Google Chrome famously creates a new separate Process (not a Thread) for every single browser tab. What is the primary benefit of this architectural choice?**
A) It saves RAM
B) Isolation: If one tab crashes (e.g., due to a bad JavaScript loop), it does not bring down the entire browser or other tabs
C) It makes downloading faster
D) It bypasses firewalls

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গুগল ক্রোম যদি থ্রেড ইউজ করতো, তবে একটি ট্যাব ক্র্যাশ করলে পুরো ব্রাউজার বন্ধ হয়ে যেতো। আলাদা প্রসেস ইউজ করায় একটি ট্যাব ক্র্যাশ করলেও অন্য ট্যাবগুলো সেফ থাকে।
</details>

---

**Q8. What is the primary disadvantage of Google Chrome's "One Process per Tab" architecture?**
A) It makes the browser look ugly
B) Creating a new Process for every tab consumes a massive amount of RAM and CPU overhead compared to creating lightweight threads
C) It prevents playing videos
D) It requires a fast internet connection

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রসেস তৈরি করা অনেক ভারী কাজ এবং এতে অনেক মেমোরি নষ্ট হয়। একারণেই ক্রোম ব্রাউজার এত বেশি র‍্যাম (RAM) খায়!
</details>

---

**Q9. What is "Context Switching"?**
A) Changing the font context in a word processor
B) The process of saving the current state (context) of a running process/thread so that it can be paused, and loading the saved state of another process/thread to execute it
C) Rebooting the computer
D) Switching from HTTP to HTTPS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: CPU যখন একটি কাজ (Thread/Process) থামিয়ে অন্য কাজে যায়, তখন আগের কাজের অবস্থা সেভ করে নতুন কাজের অবস্থা রিস্টোর করাকেই Context Switching বলে।
</details>

---

**Q10. Which is significantly faster and less resource-intensive?**
A) Process Context Switching
B) Thread Context Switching
C) They take the exact same amount of time
D) Creating a new Process

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: থ্রেডগুলো যেহেতু একই মেমোরি শেয়ার করে, তাই এক থ্রেড থেকে অন্য থ্রেডে যাওয়ার সময় মেমোরি অ্যাড্রেস চেঞ্জ করতে হয় না। তাই এটি প্রসেস সুইচের চেয়ে অনেক ফাস্ট।
</details>

---

**Q11. What is the fundamental difference between "Concurrency" and "Parallelism"?**
A) Concurrency is for Windows, Parallelism is for Linux
B) Concurrency means doing multiple tasks at the exact same physical millisecond. Parallelism means dealing with multiple tasks by rapidly switching between them.
C) Concurrency is dealing with multiple tasks at once (interleaving them via context switching on a single core). Parallelism is executing multiple tasks at the exact same physical time (requires multi-core processors).
D) They are synonyms

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Concurrency মানে অনেকগুলো কাজ হ্যান্ডেল করা (যেমন একসাথে খাওয়া আর টিভি দেখা, যদিও চোখ একবার প্লেটে আরেকবার টিভিতে যাচ্ছে)। আর Parallelism মানে আক্ষরিক অর্থেই একই সাথে কাজ করা (যেমন দুই হাত দিয়ে টাইপ করা)।
</details>

---

**Q12. If you have an older computer with only a Single-Core CPU, can it achieve Concurrency?**
A) Yes, the CPU rapidly context-switches between threads, giving the illusion that they are running simultaneously
B) No, a single core can only run one program at a time, strictly sequentially
C) Yes, but only for background services
D) No, Concurrency requires at least two cores

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: সিঙ্গেল-কোর প্রসেসর কনকারেন্সি করতে পারে। সে এত ফাস্ট (মিলিসেকেন্ডে) সুইচ করে যে আমাদের মনে হয় গান শোনা এবং টাইপিং দুটো একসাথেই হচ্ছে।
</details>

---

**Q13. If you have a Single-Core CPU, can it achieve true Parallelism?**
A) Yes, through hyper-threading software
B) No. True parallelism physically requires multiple cores to execute multiple instructions at the exact same moment
C) Yes, by increasing the clock speed
D) Yes, if using a 64-bit OS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Parallelism মানে একই সেকেন্ডে একাধিক কাজ হওয়া। যেহেতু কোর একটাই, তাই সে একই সেকেন্ডে দুটি কাজ করতে পারবে না। প্যারালালিজমের জন্য একাধিক কোর (Multi-core) মাস্ট।
</details>

---

**Q14. In multi-threaded programming, what is a "Race Condition"?**
A) Two threads competing to see which finishes executing first to win a prize
B) A bug that occurs when two or more threads access shared data concurrently and try to change it at the same time, leading to unpredictable or corrupted results
C) A hardware error
D) A feature that speeds up the program

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যখন একাধিক থ্রেড একসাথে একই ভেরিয়েবল (যেমন Bank Balance) আপডেট করতে যায়, তখন ডেটা ওভাররাইট হয়ে বা হারিয়ে গিয়ে যে ভুল রেজাল্ট আসে, তাকেই Race Condition বলে।
</details>

---

**Q15. How do software engineers solve or prevent Race Conditions?**
A) By deleting one of the threads
B) By using Synchronization mechanisms (like Locks, Mutexes, or Semaphores) to ensure that only one thread can access the critical section of code at a time
C) By increasing the RAM
D) By slowing down the CPU clock speed

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আমরা ভেরিয়েবলের ওপর একটি 'তালা (Lock)' লাগিয়ে দিই। যাতে একটি থ্রেড কাজ করার সময় অন্য কোনো থ্রেড সেখানে ঢুকতে না পারে।
</details>

---

**Q16. What is a "Critical Section" in multi-threaded programming?**
A) The `main()` function of the program
B) A specific block of code that accesses shared resources (variables, files) and must not be executed by more than one thread at the same time
C) The part of the code that prints errors
D) The connection to the database

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কোডের যে অংশে Shared data (যেটা নিয়ে সবার মারামারি) থাকে এবং যেখানে Lock লাগানো প্রয়োজন হয়, সেই স্পেসিফিক কোড ব্লকটিকেই Critical Section বলে।
</details>

---

**Q17. What is a "Mutex" (Mutual Exclusion)?**
A) A sound setting to mute the application
B) A locking mechanism used to synchronize access to a resource. Only one thread can acquire the mutex (lock) at a time, forcing others to wait.
C) A type of array
D) A CPU register

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Mutex হলো একটি তালা। একটি থ্রেড টয়লেটে (Critical Section) ঢুকে দরজা লক (Mutex lock) করে দেয়। কাজ শেষ হলে সে আনলক করে। অন্য থ্রেডগুলোকে বাইরে ওয়েট করতে হয়।
</details>

---

**Q18. What is the fundamental difference between a Mutex and a Semaphore?**
A) There is no difference
B) A Mutex allows only exactly ONE thread to access a resource (locking mechanism). A Semaphore uses a counter to allow a SPECIFIC NUMBER of threads (e.g., 5) to access a pool of resources simultaneously (signaling mechanism).
C) Semaphores are for Processes, Mutexes are for Threads
D) Semaphores are hardware, Mutexes are software

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Mutex এ শুধু ১ জন ঢুকতে পারে। আর Semaphore হলো একটি কাউন্টার (ধরা যাক ৫)। এটি ৫ জনকে এক্সেস দেয়, ৫ জন হয়ে গেলে ৬ষ্ঠ জনকে ওয়েট করতে বলে। (যেমন: রেস্টুরেন্টে ৫টি টেবিল ফাঁকা আছে)।
</details>

---

**Q19. What is the main drawback of using Locks (Synchronization) heavily in a multi-threaded program?**
A) It makes the code too small
B) It introduces significant performance bottlenecks. Threads spend a lot of time waiting in line (blocked state), effectively turning the parallel program into a slow, sequential one.
C) It uses too much hard drive space
D) It crashes the OS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আপনি মাল্টি-থ্রেডিং করেছেন স্পিড বাড়ানোর জন্য। কিন্তু Lock লাগালে তো থ্রেডগুলোকে লাইনে দাঁড়িয়ে ওয়েট করতে হয়। ফলে স্পিড কমে গিয়ে সেটা সিঙ্গেল-থ্রেডের মতোই স্লো হয়ে যায়।
</details>

---

**Q20. What is a "Deadlock" in operating systems?**
A) When a server loses power
B) A catastrophic situation where two or more threads are permanently blocked, each waiting for a lock that the other thread is currently holding, resulting in a frozen application
C) When a thread completes its task successfully
D) When the OS deletes a file

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: থ্রেড-১ এর কাছে চাবি-A আছে, সে চাবি-B চাচ্ছে। আর থ্রেড-২ এর কাছে চাবি-B আছে, সে চাবি-A চাচ্ছে। কেউই চাবি ছাড়ছে না, ফলে তারা অনন্তকাল দাঁড়িয়ে থাকবে। এটিই Deadlock (অ্যাপ হ্যাং করা)।
</details>

---

**Q21. Node.js is famous for being "Single-Threaded" but highly concurrent. How does it handle 10,000 simultaneous connections without crashing?**
A) By secretly creating 10,000 hidden processes
B) By using a non-blocking, asynchronous Event Loop. When a heavy I/O task (like database query) happens, Node.js offloads it to the OS and continues serving other users on the single thread.
C) By using supercomputers
D) Node.js actually uses 10,000 threads

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Node.js এর মেইন থ্রেড একটাই। কিন্তু সে কারো জন্য ওয়েট করে বসে থাকে না। ডেটাবেসকে কাজ দিয়ে সে অন্য ইউজারের কাজ করা শুরু করে (Non-blocking Asynchronous Event Loop)।
</details>

---

**Q22. When is a Multi-Threaded language (like Java or C++) significantly better than a Single-Threaded language (like Node.js)?**
A) For simple chat applications
B) For CPU-bound tasks that require massive mathematical calculations, video rendering, or image processing, where the workload can be split across multiple CPU cores
C) For basic I/O operations
D) For writing HTML

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ভিডিও রেন্ডারিংয়ের মতো কাজ যেখানে অনেক ক্যালকুলেশন (CPU-bound) লাগে, সেখানে সিঙ্গেল থ্রেড আটকে যায়। এরকম ক্ষেত্রে জাভা বা সি++ এর মাল্টি-থ্রেডিং দিয়ে কাজগুলো ভাগ করে দিলে খুব ফাস্ট হয়।
</details>

---

**Q23. In Java, what keyword is primarily used to easily lock a method or block of code, ensuring only one thread can execute it at a time?**
A) `locked`
B) `mutex`
C) `synchronized`
D) `await`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: জাভাতে কোনো মেথডের আগে `synchronized` লিখে দিলে সেটি Lock হয়ে যায়। এক থ্রেড কাজ শেষ না করা পর্যন্ত অন্য থ্রেড সেখানে ঢুকতে পারে না।
</details>

---

**Q24. What does the `Thread.join()` method do in Java/Python?**
A) It merges two threads into one
B) It pauses the main/calling thread and forces it to wait until the specified thread completely finishes executing its task before moving to the next line of code
C) It creates a database join
D) It kills the thread

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `t1.join()` মানে হলো: "t1 এর কাজ শেষ না হওয়া পর্যন্ত তুমি (Main thread) এখানেই ওয়েট করো, সামনের লাইনে যেয়ো না।"
</details>

---

**Q25. What is a "Thread Pool"?**
A) A literal pool of water used to cool down the CPU
B) A pre-created group of worker threads standing by to execute tasks. Instead of creating and destroying threads repeatedly (which is costly), tasks are just handed to these existing idle threads.
C) A graphical user interface
D) An array of strings

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: থ্রেড তৈরি করা ফাস্ট হলেও, হাজার হাজার থ্রেড তৈরি করাটা ওভারহেড। তাই আগে থেকেই ১০-২০টি থ্রেড বানিয়ে রাখা হয়। কাজ আসলে তাদের দেওয়া হয়, কাজ শেষ হলে তারা আবার ফ্রি হয়ে যায় (Thread Pool)।
</details>

---

**Q26. Which OS component is responsible for deciding which Thread or Process gets to use the CPU at any given microsecond?**
A) The Hard Drive Controller
B) The Scheduler (CPU Scheduler)
C) The File System
D) The BIOS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: OS এর Scheduler ঠিক করে কোন থ্রেড কতক্ষণ CPU পাবে এবং কখন Context Switch হবে।
</details>

---

**Q27. In a Web Server architecture (like Apache vs NGINX), what is the "Thread-per-Connection" model?**
A) The server creates a brand new thread for every single user that connects. It consumes massive memory if 10,000 users connect simultaneously. (Used by traditional Apache)
B) The server uses a single thread for everyone
C) The server creates a new database for every user
D) The server uses WebSockets only

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: পুরানো Apache সার্ভার প্রতি ইউজারের জন্য একটি করে থ্রেড বানাতো। ফলে ১০ হাজার ইউজার আসলে ১০ হাজার থ্রেড তৈরি হয়ে সার্ভারের র‍্যাম ফুল হয়ে ক্র্যাশ করতো (যাকে C10K প্রবলেম বলে)।
</details>

---

**Q28. What is the "C10K Problem"?**
A) The challenge of writing 10,000 lines of C code
B) The historical challenge of optimizing a web server to handle 10,000 concurrent client connections efficiently without running out of memory (which led to the rise of Event-Driven servers like NGINX and Node.js)
C) A bug in Windows 10
D) A Y2K style bug

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ১০ হাজার কারেন্ট কানেকশন (Concurrent) হ্যান্ডেল করার সমস্যাটাকেই C10K প্রবলেম বলা হতো। NGINX এবং Node.js তাদের ইভেন্ট-লুপ আর্কিটেকচার দিয়ে এই সমস্যার সমাধান করেছে।
</details>

---

**Q29. What is a "Daemon Thread" (or Background Thread)?**
A) A thread containing a virus
B) A low-priority thread that runs in the background (like Java's Garbage Collector). The JVM will not wait for daemon threads to finish; it shuts down once all main (user) threads finish.
C) A thread that only runs at night
D) A thread that executes bash scripts

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডেমন থ্রেড হলো ব্যাকগ্রাউন্ড হেল্পার। মেইন কাজ শেষ হয়ে গেলে প্রোগ্রাম এদের জন্য ওয়েট করে না, সরাসরি শাটডাউন হয়ে যায়।
</details>

---

**Q30. Python has a famous limitation regarding multi-threading. What is it called?**
A) The Python Thread Blocker (PTB)
B) The Global Interpreter Lock (GIL) - A mutex that protects access to Python objects, preventing multiple native threads from executing Python bytecodes at once in CPython, effectively neutralizing true parallelism.
C) The Snake Lock
D) The Local Execution Lock

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Python এর GIL এর কারণে আপনি ১০টি থ্রেড বানালেও, একই সেকেন্ডে শুধুমাত্র ১টি থ্রেডই কাজ করতে পারবে। তাই পাইথনে মাল্টি-থ্রেডিং দিয়ে CPU-bound কাজে স্পিড বাড়ানো যায় না। (এর জন্য পাইথনে `multiprocessing` মডিউল ব্যবহার করতে হয়)।
</details>

---

**Q31. [Code Logic] If `Thread A` and `Thread B` both try to execute `account.balance += 1` at the exact same millisecond, and the initial balance is 10, what might the final balance be if there is NO synchronization?**
A) Always 12
B) It will always throw a compilation error
C) It could be 12, but it could also incorrectly be 11 because both threads might read "10", add "1", and save "11", overwriting each other
D) Always 10

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: এটিই হলো ক্লাসিক রেস কন্ডিশন। দুজনই একই সাথে ১০ রিড করে ১১ বানাবে এবং সেভ করবে। ফলে রেজাল্ট ১২ এর বদলে ১১ হয়ে যাবে।
</details>

---

**Q32. In modern hardware, what is "Hyper-Threading"?**
A) A software used for hacking
B) Intel's technology that makes a single physical CPU core appear as two logical virtual cores to the operating system, allowing it to handle two threads concurrently more efficiently
C) Running a CPU at a higher voltage
D) A type of cooling system

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একটি ফিজিক্যাল কোরকে লজিক্যালি ২টি কোর বানিয়ে ফেলার টেকনোলজিকেই Hyper-Threading বলে (যেমন ৪ কোর, ৮ থ্রেড প্রসেসর)।
</details>

---

**Q33. What is "Starvation" in thread scheduling?**
A) When a thread doesn't have enough RAM
B) When a low-priority thread is perpetually denied access to the CPU because higher-priority threads keep jumping the queue, so it never gets to execute
C) When the computer runs out of battery
D) When a thread throws an exception

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যদি খুব পাওয়ারফুল বা হাই-প্রায়োরিটি থ্রেডগুলো সবসময় CPU দখল করে রাখে, তবে গরিব (Low-priority) থ্রেডটি আর কখনোই কাজ করার সুযোগ পাবে না। এই না খেয়ে থাকা অবস্থাকেই Starvation বলে।
</details>

---

**Q34. What is a "Zombie Process" in Linux/Unix?**
A) A process that has come back to life after being killed
B) A process that has completed execution but still has an entry in the process table because its parent process hasn't read its exit status yet
C) A virus
D) A process that consumes 100% CPU

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কাজ শেষ হয়ে গেলেও (মারা যাওয়ার পরও) একটি প্রসেসের নাম লিস্টে থেকে যায় যতক্ষণ না তার মেইন প্রসেস (Parent) সেটিকে চেক করে ডিলিট করে। এই মৃত অবস্থাকেই জম্বি প্রসেস বলে।
</details>

---

**Q35. What is an "Orphan Process"?**
A) A process that has no parent (the parent process died or crashed before the child process finished). The OS usually adopts it (e.g., assigning it to the `init` process).
B) A process without child threads
C) A completely detached daemon
D) A process with no memory allocated

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: চাইল্ড প্রসেস কাজ শেষ করার আগেই যদি প্যারেন্ট প্রসেস ক্র্যাশ করে বা মারা যায়, তবে চাইল্ডটি এতিম (Orphan) হয়ে যায়। তখন OS সেটির দায়িত্ব নেয়।
</details>

---

**Q36. What happens if two isolated Processes need to share a massive amount of data very quickly (e.g., a gigabyte of video data)?**
A) They can use standard global variables
B) They must write it to a hard drive file and read it back
C) The OS can set up "Shared Memory" segments (a type of fast IPC) that maps a section of RAM into the address space of both processes
D) It is physically impossible

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যদিও প্রসেসগুলো আলাদা, কিন্তু অনেক বড় ডেটা শেয়ার করার জন্য OS তাদের মাঝে একটি কমন মেমোরি (Shared Memory) জায়গা করে দিতে পারে, যা পাইপ বা সকেটের চেয়ে অনেক ফাস্ট।
</details>

---

**Q37. Which of the following is true about Thread local storage?**
A) It is accessible by all processes on the computer
B) It is data that is stored on the hard drive
C) It is memory allocated specifically for one thread that NO other thread in the same process can access, ensuring thread-safety without locks
D) It is automatically uploaded to the cloud

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Shared মেমোরি নিয়ে মারামারি এড়ানোর জন্য, আমরা প্রতিটি থ্রেডকে তার নিজস্ব কিছু সিক্রেট মেমোরি (Thread Local) দিয়ে দিতে পারি। এতে Lock লাগানোর ঝামেলা থাকে না।
</details>

---

**Q38. Why do GUIs (Graphical User Interfaces, like Android UI or Java Swing) typically enforce a rule that UI updates must only happen on the "Main UI Thread"?**
A) Because it looks better
B) Because UI components are not thread-safe. If multiple background threads try to paint pixels on the screen simultaneously, the UI would glitch, tear, or crash (Race Conditions on pixels).
C) Because it saves battery
D) It is just a myth

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: অ্যান্ড্রয়েড বা উইন্ডোজে কোনো ব্যাকগ্রাউন্ড থ্রেড দিয়ে স্ক্রিনে লেখা চেঞ্জ করা যায় না (Error দেয়)। কারণ অনেকগুলো থ্রেড একসাথে ড্র (Draw) করতে গেলে স্ক্রিন গ্লিচ করবে। তাই শুধু একটি থ্রেড (Main Thread) কেই স্ক্রিনে ড্র করার পারমিশন দেওয়া হয়।
</details>

---

**Q39. What is "Asynchronous Programming" compared to Multi-threading?**
A) It is exactly the same thing
B) Multi-threading uses multiple workers. Asynchronous programming uses a single worker who doesn't wait around—when faced with a delay (like a network request), they start another task and come back later via callbacks/promises.
C) Asynchronous programming only works in C++
D) It requires multiple CPUs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: মাল্টি-থ্রেডিং মানে ৩ জন মানুষ ৩টি কাজ করছে। আর অ্যাসিঙ্ক্রোনাস (Asynchronous) মানে ১ জন মানুষই স্মার্টলি কাজ করছে (চুলায় ভাত বসিয়ে দিয়ে সে ওই সময়ে বসে না থেকে ঘর ঝাড়ু দিচ্ছে)।
</details>

---

**Q40. [Conclusion] If you are building a web scraper that needs to download 1,000 images from the internet, which approach is most efficient?**
A) A single-threaded blocking `for` loop
B) Multi-threading (or Asynchronous programming), because downloading is an I/O bound task that involves a lot of waiting for the network, making it perfect for concurrency
C) Using 1,000 separate Processes
D) Writing it in Assembly language

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: নেটওয়ার্ক থেকে ফাইল নামানো একটি I/O (Input/Output) কাজ। এখানে CPU এর চেয়ে ওয়েট করতে হয় বেশি। তাই থ্রেড বা অ্যাসিঙ্ক্রোনাস ওয়েতে কাজগুলো দিলে অনেক দ্রুত সব ডাউনলোড হয়ে যাবে।
</details>
