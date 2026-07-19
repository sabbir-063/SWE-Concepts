# OS & Computer Networks Learning Plan

This plan outlines the structured, step-by-step curriculum to teach Computer Networks and Operating Systems in-depth. For every topic, we will provide detailed study guides (concepts, illustrations, real-world system design scenarios) and a comprehensive 30-MCQ assessment.

---

## Proposed Folder Structure
We will organize all files under the user's workspace at `d:\Websites\Learning\SWE`:

```text
SWE/
├── ComputerNetworks/
│   ├── Module1_CoreProtocols/
│   │   ├── 01_IP_Protocol/
│   │   │   ├── README.md (Detailed Theory)
│   │   │   └── Quiz.md (30 MCQs + Answers & Explanations)
│   │   ├── 02_OSI_Model/
│   │   ├── 03_TCP_UDP/
│   │   └── 04_DNS/
│   └── Module2_SystemDesignBasics/
│       ├── 05_Load_Balancing/
│       ├── 06_Clustering/
│       ├── 07_Caching/
│       ├── 08_CDN/
│       ├── 09_Proxy/
│       ├── 10_Availability_Reliability/
│       ├── 11_Scalability/
│       └── 12_Storage/
└── OperatingSystems/
    ├── Module1_Processes_Threads/
    │   ├── 01_Process_Management/
    │   │   ├── README.md
    │   │   └── Quiz.md
    │   ├── 02_CPU_Scheduling/
    │   ├── 03_Threads_Concurrency/
    │   ├── 04_IPC_Synchronization/
    │   └── 05_Deadlocks/
    ├── Module2_Memory_Management/
    │   ├── 06_Main_Memory/
    │   ├── 07_Paging_Segmentation/
    │   └── 08_Virtual_Memory/
    └── Module3_Storage_IO/
        ├── 09_File_Systems/
        ├── 10_Disk_Scheduling/
        └── 11_IO_Systems/
```

---

## Detailed Curriculum

### Part 1: Computer Networks (কম্পিউটার নেটওয়ার্কিং)

#### Module 1: Core Networking & Protocols
1. **IP (Internet Protocol)**: IPv4 & IPv6 structure, Subnetting, CIDR notation, Routing, NAT, DHCP, private vs public IPs.
2. **OSI & TCP/IP Reference Models**: Detailed walkthrough of all 7 layers (Physical to Application) and their TCP/IP mappings. Encapsulation, decapsulation, and data formats (frames, packets, segments).
3. **TCP & UDP**: 3-Way Handshake, TCP connection termination, Flow Control (sliding window), Congestion Control, TCP state machine, UDP lightweight packet delivery, and headers.
4. **Domain Name System (DNS)**: Hierarchy (Root, TLD, Authoritative), query resolution process (recursive vs iterative), DNS records (A, AAAA, CNAME, MX, TXT, NS), caching, and propagation.

#### Module 2: System Design & Scaling Basics (as referenced in the image)
5. **Load Balancing**: L4 vs L7 load balancing, algorithms (Round Robin, Weighted, Least Connections, IP Hash), health checks, SSL termination.
6. **Clustering**: High-availability clusters, active-passive vs active-active configurations, replication, and state persistence.
7. **Caching**: Caching levels (CPU, Browser, CDN, DB caches like Redis/Memcached), cache eviction strategies (LRU, LFU, FIFO), write policies (write-through, write-back, write-around), cache stampede/misses.
8. **Content Delivery Network (CDN)**: Edge servers, latency reduction, Push vs Pull CDN topologies, static vs dynamic caching.
9. **Proxy**: Forward vs Reverse proxies, security benefits, load distribution, and TLS termination.
10. **Availability & Reliability**: Designing for high availability, failover systems, SLOs, SLAs, SLIs, MTBF, MTTR, active redundancy.
11. **Scalability**: Vertical vs Horizontal scaling, database sharding/partitioning, read replicas, stateless architecture patterns.
12. **Storage**: Block, File, and Object storage models, NAS/SAN architectures, RAID levels (0, 1, 5, 6, 10) and their trade-offs.

#### Module 3: System Design Advanced
70. **Message Queues & Event Streaming**: RabbitMQ vs Kafka, pub/sub models, event-driven architectures, decoupling background tasks.
71. **API Gateways & Service Mesh**: Routing, rate limiting, authentication at the edge (Kong, API Gateway), and service-to-service communication (Istio).
72. **Distributed Databases & Consistency**: Deep dive into the CAP Theorem, PACELC, NoSQL types (Key-Value, Document, Graph), Eventual vs Strong Consistency.
73. **Distributed Transactions**: Two-Phase Commit (2PC), Saga Pattern (Choreography vs Orchestration), Event Sourcing, CQRS.
74. **Storage & RAID**: Block vs File vs Object storage models (S3), NAS/SAN architectures, RAID levels (0, 1, 5, 6, 10).

---

### Part 2: Operating Systems (অপারেটিং সিস্টেম)

#### Module 1: Processes, Threads & Concurrency
1. **Process Management**: Process Control Blocks (PCB), state transitions, context switching overhead, process creation (`fork`, `exec`).
2. **CPU Scheduling**: Scheduling criteria, non-preemptive vs preemptive algorithms (FCFS, SJF, Priority, Round Robin, Multilevel Feedback Queue).
3. **Threads & Concurrency**: User vs Kernel threads, multi-threading models, race conditions, critical section requirements (mutual exclusion, progress, bounded waiting).
4. **IPC & Synchronization**: Semaphores (binary/counting), Mutexes, Monitors, Classical problems (Producer-Consumer, Readers-Writers, Dining Philosophers).
5. **Deadlocks**: Necessary conditions (Havoc: Hold & Wait, Mutual Exclusion, No Preemption, Circular Wait), Banker's Algorithm (avoidance), recovery strategies.

#### Module 2: Memory Management
6. **Main Memory**: Logical vs Physical address translation, fragmentation (internal and external), compaction, contiguous allocation algorithms.
7. **Paging & Segmentation**: Page tables, translation lookaside buffers (TLB), page table overhead, multi-level paging, segment table mechanisms.
8. **Virtual Memory**: Demand paging, page fault handling, page replacement policies (FIFO, Optimal, LRU, Second-Chance/Clock), thrashing and working set model.

#### Module 3: Storage & I/O Systems
9. **File Systems**: File attributes, allocation strategies (contiguous, linked, indexed like inodes), free space management, directory designs.
10. **Disk Scheduling**: Hard disk drive mechanics, seek time optimization, scheduling algorithms (FCFS, SSTF, SCAN, C-SCAN, LOOK, C-LOOK).
11. **I/O Systems**: Interrupts, DMA (Direct Memory Access), buffering, double buffering, spooling, device driver architectures.

---

## Pedagogical Strategy (কিভাবে শেখানো হবে)
1. **Benglish/English Explanation**: Conceptual guides will be written in highly clear English combined with friendly Benglish annotations to ensure deep intuition.
2. **Visual Text Diagrams**: Detailed ASCII/Unicode flowcharts to illustrate packet paths, handshakes, memory offsets, and CPU states.
3. **Comprehensive Quizzes**: After studying a section's `README.md`, you will attempt the `Quiz.md`.
   - Each quiz will contain **exactly 30 high-quality MCQs** spanning Easy, Medium, and Hard difficulty levels.
   - Questions will test conceptual understanding, numerical calculations (e.g., subnetting, disk seek times, CPU scheduling timeline), and edge cases.
   - Answers and detailed explanations will be provided at the bottom of the file inside a `<details>` disclosure tag (so you don't spoil the answers while practicing).

---

## Next Steps & User Review Required
Please review the proposed syllabus and folder structure. Once you approve, we will:
1. Initialize the directory structure.
2. Create the first topic: **Computer Networks Module 1 - Chapter 1: IP (Internet Protocol)** containing the full detailed theory guide and 30 MCQs.

Let me know if you would like to adjust any topics or if you are ready to proceed!
