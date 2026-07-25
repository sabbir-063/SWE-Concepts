# 02. CPU Scheduling Algorithms (Practice MCQs)

This file contains 40 in-depth MCQs covering Preemptive vs Non-Preemptive scheduling, FCFS, SJF, Round Robin, Priority Scheduling, Starvation, and the Convoy Effect.

---

**Q1. What is the primary objective of a CPU Scheduler?**
A) To increase the hard drive size
B) To manage which process gets to use the CPU next, aiming to maximize CPU utilization and minimize wait times
C) To cool down the CPU
D) To prevent hackers from accessing processes

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: CPU Scheduler এর কাজই হলো ট্রাফিক পুলিশের মতো প্রসেসগুলোকে কন্ট্রোল করা। কে কখন CPU ব্যবহার করবে তা ডিসাইড করে যাতে CPU কখনো বেকার বসে না থাকে।
</details>

---

**Q2. What is "Burst Time" in the context of CPU scheduling?**
A) The time it takes for a process to crash
B) The total time a process spends waiting in the ready queue
C) The exact amount of time a process actively needs to execute on the CPU to finish its task
D) The time it takes to boot the OS

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Burst Time মানে হলো একটি নির্দিষ্ট প্রসেস রান হতে টোটাল কতক্ষণ CPU-এর সময় লাগবে।
</details>

---

**Q3. What is "Waiting Time"?**
A) Time spent executing
B) The total time a process spends waiting in the ready queue before getting the CPU
C) The time it takes for the user to press a key
D) Time spent downloading a file

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রসেসটি রেডি কিউ (Ready Queue) বা লাইনে কতক্ষণ দাঁড়িয়ে ছিল, তাকেই ওয়েটিং টাইম বলে।
</details>

---

**Q4. What is "Turnaround Time"?**
A) Waiting Time minus Burst Time
B) The total time from the moment a process is submitted (arrives) until it completely finishes executing (Waiting Time + Burst Time)
C) The time it takes the CPU to spin
D) The time it takes to switch tabs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Turnaround Time (TAT) মানে হলো টোটাল কত সময় লাগলো। অর্থাৎ লাইনে দাঁড়িয়ে থাকার সময় (WT) + কাজ করার সময় (BT)।
</details>

---

**Q5. What distinguishes a "Preemptive" scheduling algorithm from a "Non-Preemptive" one?**
A) Preemptive algorithms are only used in Windows
B) Non-Preemptive algorithms are faster
C) In Preemptive scheduling, the OS can forcefully interrupt a running process and take away the CPU. In Non-Preemptive, a process holds the CPU until it voluntarily yields it or finishes.
D) There is no difference

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Preemptive মানে জোর করে কেড়ে নেওয়া। OS চাইলে যেকোনো সময় প্রসেসকে থামিয়ে অন্য প্রসেসকে CPU দিয়ে দিতে পারে। আর Non-Preemptive এ কাজ শেষ না হওয়া পর্যন্ত কেউ CPU কাড়তে পারে না।
</details>

---

**Q6. Which scheduling algorithm simply allocates the CPU to the process that requests it first?**
A) Round Robin
B) First-Come, First-Served (FCFS)
C) Shortest Job First (SJF)
D) Priority Scheduling

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: FCFS (First Come First Serve) মানে যে আগে লাইনে এসে দাঁড়িয়েছে, সে আগে কাজ করবে।
</details>

---

**Q7. Is First-Come, First-Served (FCFS) preemptive or non-preemptive?**
A) Always Preemptive
B) Always Non-Preemptive
C) It depends on the CPU
D) Neither

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: FCFS হলো Non-Preemptive. যে একবার কাজ শুরু করেছে, তার কাজ শেষ না হওয়া পর্যন্ত অন্য কেউ সুযোগ পাবে না।
</details>

---

**Q8. What is the "Convoy Effect"?**
A) When processes travel in a group across a network
B) A phenomenon in FCFS where many short processes are delayed immensely because they are stuck waiting behind one massive, long-running process
C) When the CPU overheats
D) A feature that speeds up processing

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: বড় একটি গাড়ির পেছনে জ্যামে আটকে থাকা ছোট ছোট গাড়িগুলোর অবস্থাকেই Convoy Effect বলে। FCFS এ বড় প্রসেসের পেছনে ছোট প্রসেসগুলো আটকে থাকলে এই সমস্যা হয়।
</details>

---

**Q9. Which scheduling algorithm mathematically guarantees the minimum Average Waiting Time for a given set of processes?**
A) FCFS
B) Round Robin
C) Shortest Job First (SJF)
D) Priority Scheduling

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: SJF (Shortest Job First) হলো গাণিতিকভাবে সবচেয়ে বেস্ট। ছোট কাজগুলো আগে করে ফেললে লাইনের ভিড় তাড়াতাড়ি কমে যায় এবং সবার অ্যাভারেজ ওয়েটিং টাইম অনেক কমে যায়।
</details>

---

**Q10. What is the major practical difficulty in implementing Shortest Job First (SJF) in a real Operating System?**
A) It requires too much RAM
B) It is impossible for the OS to precisely know the exact future Burst Time (how long it will take) of a process before it actually runs
C) It cannot be programmed in C
D) It crashes the CPU

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: SJF এর থিওরি খুব সুন্দর। কিন্তু রিয়েল লাইফে একটি প্রসেস কাজ শুরু করার আগে OS কীভাবে জানবে যে প্রসেসটি কতক্ষণ সময় নেবে? ভবিষ্যৎ তো আর বলা যায় না! তাই OS শুধু অনুমান (Guess) করে কাজ করে।
</details>

---

**Q11. What is "Starvation" in CPU scheduling?**
A) When the CPU doesn't have enough electricity
B) A situation where a low-priority process (or a long process in SJF) waits indefinitely in the ready queue because higher-priority (or shorter) processes keep arriving and jumping ahead of it
C) When the OS deletes a process
D) When memory is full

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যদি শুধু ছোট ছোট কাজ আসতেই থাকে, তবে বড় প্রসেসটি (SJF এ) বা লো-প্রাইওরিটির প্রসেসটি কখনোই কাজের সুযোগ পাবে না। এই না খেয়ে দাঁড়িয়ে থাকাকেই Starvation বলে।
</details>

---

**Q12. Does FCFS suffer from Starvation?**
A) Yes, all the time
B) No. Since it is strictly ordered by arrival time, every process will eventually get its turn, no matter how long it takes.
C) Yes, but only for short processes
D) Only on single-core CPUs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: FCFS এ Starvation হয় না। কারণ কেউ কারো সিরিয়াল কাটে না। দেরি হলেও সবাই একদিন না একদিন সুযোগ পাবেই।
</details>

---

**Q13. How does Priority Scheduling work?**
A) Processes are assigned a priority integer. The CPU is always allocated to the process with the highest priority (e.g., smallest integer).
B) Processes are sorted alphabetically
C) The oldest process gets priority
D) Randomly selects a process

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: প্রতিটি প্রসেসকে একটি নাম্বার বা প্রাইওরিটি দেওয়া হয়। যার গুরুত্ব (Priority) বেশি, সে আগে সুযোগ পায়।
</details>

---

**Q14. What is the classic solution to prevent Starvation in Priority Scheduling?**
A) Buying a faster CPU
B) Round Robin
C) "Aging": Gradually increasing the priority of a process the longer it waits in the queue, ensuring it eventually becomes the highest priority and gets executed
D) Deleting the low-priority processes

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Aging মানে বয়স বাড়ানো। একটি লো-প্রাইওরিটি প্রসেস যদি অনেকক্ষণ ওয়েট করে, তবে OS আস্তে আস্তে তার প্রাইওরিটি বাড়িয়ে দেয়। ফলে একসময় সে হাই-প্রাইওরিটি হয়ে কাজ করার সুযোগ পায়।
</details>

---

**Q15. Which scheduling algorithm is specifically designed for Time-Sharing systems (like modern interactive OSs)?**
A) FCFS
B) SJF
C) Priority Scheduling
D) Round Robin (RR)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: আধুনিক পিসিতে আমরা একসাথে অনেকগুলো অ্যাপ চালাই (Time-Sharing)। এর জন্য Round Robin বেস্ট, কারণ এটি সবাইকে একটু একটু করে সমান সময় দেয়।
</details>

---

**Q16. How does the Round Robin (RR) algorithm work?**
A) It spins the hard drive
B) It assigns a small fixed unit of time called a "Time Quantum" (or time slice). Each process gets to run for this quantum. If it hasn't finished, it is forcefully preempted and put at the back of the queue.
C) It picks a process randomly
D) It only runs processes that take less than 1 second

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: সবাইকে সমান সময় (যেমন: ২ মিলিসেকেন্ড) দেওয়া হয়। সময় শেষ হলে জোর করে (Preemptive) কাজ থামিয়ে অন্যজনকে সুযোগ দেওয়া হয়, আর তাকে লাইনের পেছনে পাঠিয়ে দেওয়া হয়।
</details>

---

**Q17. In Round Robin, what happens if the "Time Quantum" is extremely LARGE (e.g., infinity)?**
A) The CPU crashes
B) The algorithm degenerates and behaves exactly like First-Come, First-Served (FCFS), because no process is ever preempted
C) It becomes SJF
D) It runs much faster

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: টাইম কোয়ান্টাম যদি ১০ ঘণ্টা হয়, তবে প্রসেসের কাজ তো তার আগেই শেষ হয়ে যাবে। তখন কেউ আর টাইম-আউট হবে না, যার ফলে এটি পুরোপুরি FCFS এর মতো আচরণ করবে।
</details>

---

**Q18. In Round Robin, what happens if the "Time Quantum" is extremely SMALL (e.g., 0.001 milliseconds)?**
A) The system achieves perfect concurrency and runs perfectly
B) The CPU spends almost all of its time performing Context Switches rather than actually executing the processes, leading to massive overhead and terrible performance
C) The CPU temperature drops
D) Starvation occurs

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: টাইম কোয়ান্টাম খুব ছোট হলে, প্রসেস কাজ শুরু করার আগেই তার সময় শেষ হয়ে যাবে! ফলে OS শুধু প্রসেস পাল্টানোতেই (Context Switch) সময় নষ্ট করবে, আসল কাজ কিছুই হবে না।
</details>

---

**Q19. Is Round Robin susceptible to Starvation?**
A) Yes
B) No, because every process in the ready queue is guaranteed to get a slice of CPU time in every cycle
C) Yes, but only for long processes
D) Only if the queue is full

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গোল হয়ে ঘুরতে ঘুরতে সিরিয়াল সবার কাছেই আসবে। তাই কেউ এখানে না খেয়ে (Starvation) বসে থাকে না।
</details>

---

**Q20. What is "Multilevel Queue Scheduling"?**
A) Using multiple CPUs
B) Partitioning the ready queue into several separate queues (e.g., System processes queue, Interactive queue, Background queue), each with its own scheduling algorithm and priority level
C) A data structure in Java
D) Storing queues in a database

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিয়েল OS এ অনেকগুলো আলাদা আলাদা লাইন (Queue) থাকে। সিস্টেমের কাজের জন্য একটি লাইন, ইউজারের কাজের জন্য আরেকটি লাইন ইত্যাদি। প্রতিটি লাইনের নিজস্ব রুলস থাকে।
</details>

---

**Q21. In a Multilevel Queue, what scheduling algorithm is best suited for the "Interactive / Foreground Queue" (like typing in Word)?**
A) FCFS
B) SJF
C) Round Robin (to ensure quick response times and no lag)
D) Non-Preemptive Priority

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: আমরা যখন কি-বোর্ডে টাইপ করি বা মাউস নাড়াই, তখন আমাদের সাথে সাথে রেসপন্স লাগে। Round Robin খুব ফাস্ট রেসপন্স দেয় বলে Interactive কাজের জন্য এটি বেস্ট।
</details>

---

**Q22. In a Multilevel Queue, what scheduling algorithm is acceptable for the "Background / Batch Queue" (like downloading a 10GB file)?**
A) Round Robin with a 1ms quantum
B) FCFS (since response time doesn't matter much for a background download, avoiding context switch overhead is better)
C) Shortest Remaining Time First
D) Preemptive Priority

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ব্যাকগ্রাউন্ডে একটি ফাইল ডাউনলোড হতে থাকলে আমাদের রেসপন্সের দরকার নেই, সেটি নিজের মতো হতে থাকলেই হলো। তাই সেখানে FCFS ইউজ করলে Context Switch এর প্যারা থেকে বাঁচা যায়।
</details>

---

**Q23. What is "Multilevel Feedback Queue Scheduling"?**
A) A queue that asks for user reviews
B) A flexible version of Multilevel Queue where processes can actively move BETWEEN queues based on their behavior (e.g., if a process uses too much CPU, it is demoted to a lower priority queue)
C) A queue that only handles network feedback
D) It is an outdated hardware design

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি সবচেয়ে স্মার্ট শিডিউলার। একটি প্রসেস যদি বেশি CPU খায়, তবে OS তাকে পানিশমেন্ট হিসেবে নিচের লাইনে (Low priority) পাঠিয়ে দেয়। আবার নিচে কেউ অনেকক্ষণ ওয়েট করলে তাকে প্রমোশন দিয়ে ওপরের লাইনে নিয়ে আসে।
</details>

---

**Q24. [Calculation] Using FCFS, what is the Average Waiting Time for P1(Burst=5), P2(Burst=2), P3(Burst=1) arriving in that exact order?**
A) (0 + 2 + 3) / 3 = 1.66
B) (0 + 5 + 7) / 3 = 4.0
C) (5 + 7 + 8) / 3 = 6.66
D) 0

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: P1 ওয়েট করবে 0. P2 ওয়েট করবে P1 এর সময় (5). P3 ওয়েট করবে P1+P2 এর সময় (5+2 = 7). 
তাহলে অ্যাভারেজ = (0 + 5 + 7) / 3 = 12/3 = 4.0
</details>

---

**Q25. [Calculation] Using Non-Preemptive SJF, what is the sequence of execution for P1(Burst=5), P2(Burst=2), P3(Burst=1)?**
A) P1 -> P2 -> P3
B) P3 -> P2 -> P1
C) P2 -> P3 -> P1
D) P1 -> P3 -> P2

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: SJF এ যার কাজ সবচেয়ে ছোট সে আগে যায়। তাই সিরিয়াল হবে: P3 (1), তারপর P2 (2), তারপর P1 (5).
</details>

---

**Q26. What does "Preemptive SJF" (also known as Shortest Remaining Time First - SRTF) do?**
A) It behaves like FCFS
B) If a new process arrives with a shorter burst time than what is remaining for the currently running process, it forcefully preempts the running process
C) It uses a time quantum
D) It deletes the running process

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একটি প্রসেসের কাজ চলছে, এমন সময় যদি তার চেয়েও ছোট কোনো প্রসেস লাইনে এসে দাঁড়ায়, তবে SRTF সাথে সাথে চলতি কাজ থামিয়ে দিয়ে নতুন ছোট প্রসেসটিকে সুযোগ দেয় (Preemptive)।
</details>

---

**Q27. Why do operating systems avoid using strictly FCFS for modern desktop environments?**
A) It is too complex to code
B) It results in terrible "Response Time". If a user clicks the start menu but a video render is running via FCFS, the start menu won't open until the render finishes hours later.
C) It requires an internet connection
D) It uses too much battery

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: FCFS এ কাজ শেষ না হওয়া পর্যন্ত কেউ CPU ছাড়ে না। তাই ভিডিও রেন্ডার হওয়ার সময় আপনি মাউস নাড়ালে সেটি কাজ করবে না। এজন্যই আধুনিক OS এ Round Robin (Preemptive) ইউজ করা হয়।
</details>

---

**Q28. What is the "Dispatcher" in an operating system?**
A) The module that gives control of the CPU to the process selected by the short-term scheduler (performs the actual context switch)
B) A police officer
C) The module that downloads files
D) A hardware component

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Scheduler শুধু সিলেক্ট করে কাকে CPU দেওয়া হবে। আর Dispatcher হলো সেই ব্যক্তি যে আগের প্রসেসকে বের করে নতুন প্রসেসকে ফিজিক্যালি CPU তে বসিয়ে দেয় (Context switch করে)।
</details>

---

**Q29. What is "Dispatch Latency"?**
A) The time it takes to download a game
B) The time it takes for the dispatcher to stop one process and start another running (the overhead time of a context switch)
C) Network ping
D) The time it takes to boot

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একটি প্রসেসকে বের করে আরেকটিকে ঢোকাতে মাঝখানে যেটুকু সময় লস হয়, তাকেই Dispatch Latency বা ওভারহেড বলে।
</details>

---

**Q30. Which of the following states does a Process enter when it is waiting for an I/O operation (like waiting for the user to press a key)?**
A) Ready State
B) Running State
C) Waiting / Blocked State
D) Terminated State

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ইউজারের ইনপুটের জন্য ওয়েট করলে প্রসেসটি Blocked স্টেটে চলে যায়, এবং CPU সেই সময়ে বেকার বসে না থেকে অন্য প্রসেসকে সময় দেয়।
</details>

---

**Q31. When a process finishes its I/O operation (e.g., the user presses a key), which state does it go to?**
A) Directly back to Running State
B) It goes to the Ready Queue, waiting for the scheduler to pick it again
C) Terminated State
D) It crashes

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: কাজ শেষ হলেই সে সরাসরি CPU পায় না, তাকে আবার Ready Queue (লাইনের পেছনে) গিয়ে দাঁড়াতে হয়।
</details>

---

**Q32. CPU Bound processes vs I/O Bound processes: Which one does the CPU Scheduler usually prefer to give a higher priority to?**
A) CPU Bound
B) I/O Bound processes (because they only need quick, short bursts of CPU to issue a hardware command and then they get out of the way, keeping the system highly responsive)
C) They are treated exactly the same
D) Neither

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: I/O কাজের (যেমন প্রিন্ট দেওয়া) জন্য CPU এর খুব কম সময় লাগে। তাই OS সবসময় I/O প্রসেসকে আগে সুযোগ দেয়, কারণ তারা একটুখানি সময় নিয়েই আবার ওয়েটিং-এ চলে যায়।
</details>

---

**Q33. What is the role of a "Short-Term Scheduler" (CPU Scheduler)?**
A) It selects which processes should be brought from disk into RAM
B) It selects from among the processes that are in the ready queue and allocates the CPU to one of them (happens very frequently, every few milliseconds)
C) It deletes old files
D) It manages network packets

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Short-Term Scheduler এর কাজই হলো র‍্যামের লাইনে দাঁড়িয়ে থাকা প্রসেসগুলোর মধ্যে থেকে কাকে এখন CPU তে পাঠানো হবে তা ডিসাইড করা। এটি প্রতি মিলিসেকেন্ডে কাজ করে।
</details>

---

**Q34. What is the role of a "Long-Term Scheduler" (Job Scheduler)?**
A) It manages the time clock
B) It determines which programs are admitted into the RAM (Ready Queue) from the hard disk, controlling the Degree of Multiprogramming
C) It checks for OS updates
D) It formats the hard drive

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আপনার পিসিতে হয়তো ১০০টি অ্যাপ আছে। এর মধ্যে কোন কোন অ্যাপ র‍্যামে ঢুকতে পারবে, তা ডিসাইড করে Long-Term Scheduler। এটি খুব কম সময় পরপর কাজ করে।
</details>

---

**Q35. What is the "Degree of Multiprogramming"?**
A) How many programming languages the OS supports
B) The number of processes currently existing in the main memory (RAM) at the same time
C) The number of CPU cores
D) The amount of cache memory

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একই সাথে র‍্যামের মধ্যে কয়টি প্রসেস লোড করা আছে, সেই সংখ্যাটিকেই Degree of Multiprogramming বলে।
</details>

---

**Q36. In Priority Scheduling, if two processes arrive with the exact same priority, how is the tie typically broken?**
A) They are run simultaneously using magic
B) They are rejected
C) The tie is broken using FCFS (whoever arrived slightly earlier gets it)
D) The system crashes

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: দুজনের গুরুত্ব (Priority) সমান হলে, যে আগে লাইনে এসে দাঁড়িয়েছে (FCFS), সে আগে সুযোগ পায়।
</details>

---

**Q37. What is "Throughput" in CPU scheduling?**
A) The heat generated by the CPU
B) The number of processes completed per unit of time (e.g., 5 processes completed per second). Schedulers aim to maximize this.
C) The speed of the RAM
D) The network download speed

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রতি সেকেন্ডে বা ঘণ্টায় কয়টি প্রসেসের কাজ পুরোপুরি শেষ হলো, তাকেই থ্রুপুট (Throughput) বলে।
</details>

---

**Q38. Why is Round Robin considered "Fair"?**
A) Because it is alphabetical
B) Because no process gets special treatment; everyone gets exactly the same Time Quantum in a circular order, eliminating Starvation
C) Because it is open source
D) Because it is slow

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Round Robin এ কারো কোনো আলাদা প্রাইওরিটি নেই, বড়-ছোটর কোনো ভেদাভেদ নেই। সবাই সমান টাইম পাবে। তাই এটি সবচেয়ে ফেয়ার (Fair) অ্যালগরিদম।
</details>

---

**Q39. [Code Logic] In the FCFS implementation, how do we calculate the Waiting Time for process `i`?**
A) `Waiting Time = Burst Time * 2`
B) `Waiting Time of Process i = Waiting Time of Process (i-1) + Burst Time of Process (i-1)`
C) It is randomly generated
D) It is always zero

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আমার ওয়েটিং টাইম হলো—আমার সামনের জনের ওয়েটিং টাইম + তার কাজ করার সময় (Burst time)।
</details>

---

**Q40. [Conclusion] If your goal is strictly to build a highly responsive interactive system (like Windows or macOS UI), which algorithm concept MUST you incorporate?**
A) Strictly FCFS
B) Non-Preemptive SJF
C) Preemption and Time-Sharing (like Round Robin or Multilevel Feedback Queue)
D) LIFO (Last In First Out)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ইউজার এক্সপেরিয়েন্স ভালো করতে হলে এবং সিস্টেমকে রেসপন্সিভ রাখতে হলে মাস্ট Preemptive (জোর করে কেড়ে নেওয়ার ক্ষমতা) এবং Round Robin এর টাইম-শেয়ারিং কনসেপ্ট থাকতে হবে।
</details>
