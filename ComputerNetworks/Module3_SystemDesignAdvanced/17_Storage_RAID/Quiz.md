# Quiz: Storage & RAID (Chapter 17)

Test your knowledge of Storage Models, Network Storage (NAS/SAN), and RAID levels! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. Which type of storage organizes data into a hierarchy of directories (folders) and files?**
- A) Block Storage
- B) Object Storage
- C) File Storage
- D) Graph Storage
<details>
<summary>Answer</summary>
**Correct Answer:** C) File Storage<br>
**Explanation:** File storage is what we are most used to on our personal computers. Data is nested in folders and sub-folders.
</details>

**2. Which storage type is used by Amazon S3 (Simple Storage Service)?**
- A) File Storage
- B) Block Storage
- C) Object Storage
- D) Relational Storage
<details>
<summary>Answer</summary>
**Correct Answer:** C) Object Storage<br>
**Explanation:** S3 is an object storage service. It stores data as "objects" within "buckets", rather than in a folder hierarchy.
</details>

**3. What does "RAID" stand for?**
- A) Random Access Independent Disks
- B) Redundant Array of Independent Disks (or Inexpensive Disks)
- C) Rapid Access Internet Database
- D) Routing Algorithm for Internet Domains
<details>
<summary>Answer</summary>
**Correct Answer:** B) Redundant Array of Independent Disks<br>
**Explanation:** RAID is a technology that combines multiple physical hard drives into a single logical unit for the purposes of data redundancy, performance improvement, or both.
</details>

**4. What is the primary purpose of RAID 0?**
- A) To create an exact backup of the data.
- B) To split data evenly across two or more disks (Striping) to increase Read/Write performance.
- C) To encrypt the hard drive.
- D) To prevent viruses.
<details>
<summary>Answer</summary>
**Correct Answer:** B) To split data evenly across two or more disks (Striping) to increase Read/Write performance.<br>
**Explanation:** RAID 0 (Striping) focuses entirely on speed. By writing half the data to Disk 1 and half to Disk 2 simultaneously, it cuts the write time in half.
</details>

**5. What happens if one hard drive fails in a RAID 0 configuration?**
- A) The system slows down but keeps working.
- B) The lost data is automatically regenerated.
- C) ALL data on the entire RAID array is permanently lost.
- D) An alarm sounds, but data is safe.
<details>
<summary>Answer</summary>
**Correct Answer:** C) ALL data on the entire RAID array is permanently lost.<br>
**Explanation:** Because RAID 0 has zero redundancy (no backups, no parity), losing one disk destroys the entire striped file system.
</details>

**6. What is the primary feature of RAID 1?**
- A) Striping data for maximum speed.
- B) Mirroring data across two or more disks for 100% redundancy.
- C) Compressing data to save space.
- D) Connecting hard drives via Wi-Fi.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Mirroring data across two or more disks for 100% redundancy.<br>
**Explanation:** Whatever is written to Disk A is identically written to Disk B. If Disk A burns, Disk B has a perfect copy.
</details>

**7. In a RAID 1 setup with two 4TB hard drives, what is the total usable storage capacity?**
- A) 8TB
- B) 6TB
- C) 4TB
- D) 2TB
<details>
<summary>Answer</summary>
**Correct Answer:** C) 4TB<br>
**Explanation:** Because the second drive is an exact clone (mirror) of the first drive, you only get to use the capacity of one drive.
</details>

**8. What does "NAS" stand for?**
- A) Network Address System
- B) Node Access Security
- C) Network Attached Storage
- D) Non-Active Server
<details>
<summary>Answer</summary>
**Correct Answer:** C) Network Attached Storage<br>
**Explanation:** A NAS is essentially a small computer optimized for storing and sharing files over a local area network (LAN).
</details>

**9. Which storage model is considered the fastest and most highly suitable for installing Operating Systems or traditional SQL Databases?**
- A) File Storage
- B) Object Storage
- C) Block Storage
- D) Tape Storage
<details>
<summary>Answer</summary>
**Correct Answer:** C) Block Storage<br>
**Explanation:** Block storage (like a C: drive or AWS EBS) allows the OS to read/write specific raw sectors of the disk directly without file system overhead, making it blisteringly fast for databases.
</details>

**10. What is a key limitation of Object Storage (like AWS S3) compared to Block Storage?**
- A) Object storage cannot hold images.
- B) Object storage is limited to 1GB total.
- C) You cannot edit a small piece of an object; if you change one byte, you must re-upload and overwrite the entire object.
- D) Object storage cannot be accessed via the internet.
<details>
<summary>Answer</summary>
**Correct Answer:** C) You cannot edit a small piece of an object; if you change one byte, you must re-upload and overwrite the entire object.<br>
**Explanation:** Block storage lets you change one block of a 10GB database file instantly. Object storage requires you to replace the whole 10GB file. Therefore, Object storage is terrible for running databases.
</details>

---

### Medium (Questions 11 - 20)

**11. What does "SAN" stand for?**
- A) Storage Area Network
- B) Server Allocation Node
- C) Secure Access Network
- D) Synchronous Array Node
<details>
<summary>Answer</summary>
**Correct Answer:** A) Storage Area Network<br>
**Explanation:** A SAN is a dedicated high-speed network that interconnects and presents shared pools of storage devices to multiple servers.
</details>

**12. What is the fundamental architectural difference between NAS and SAN?**
- A) NAS is for Macs, SAN is for PCs.
- B) NAS operates at the File level (using protocols like NFS/SMB) over standard Ethernet. SAN operates at the Block level (using protocols like iSCSI/Fibre Channel) over a dedicated high-speed network.
- C) NAS uses hard drives; SAN uses floppy disks.
- D) NAS is faster than SAN.
<details>
<summary>Answer</summary>
**Correct Answer:** B) NAS operates at the File level... SAN operates at the Block level...<br>
**Explanation:** To a server, a NAS looks like a "Shared Folder" on the network. But a SAN looks exactly like a raw, unformatted hard drive plugged directly into the motherboard.
</details>

**13. What is "Parity" in the context of RAID 5?**
- A) Equal pay for all servers.
- B) A mathematical value (usually calculated using XOR) stored alongside the data. If a disk fails, the remaining data and the Parity value can be used to perfectly reconstruct the lost data.
- C) A tool used to format the hard drive.
- D) An encryption key.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A mathematical value (usually calculated using XOR) stored alongside the data. If a disk fails... perfectly reconstruct the lost data.<br>
**Explanation:** Think of it like this: `3 + 4 = 7` (7 is parity). If the disk holding '3' dies, the system does `7 - 4` to realize the missing data was '3'.
</details>

**14. What is the minimum number of disks required to build a RAID 5 array?**
- A) 1
- B) 2
- C) 3
- D) 4
<details>
<summary>Answer</summary>
**Correct Answer:** C) 3<br>
**Explanation:** RAID 5 requires at least 3 disks (e.g., 2 for data striping, 1 equivalent for parity distributed across them).
</details>

**15. If you have four 2TB drives in a RAID 5 array, what is your total usable storage capacity?**
- A) 8TB
- B) 6TB
- C) 4TB
- D) 2TB
<details>
<summary>Answer</summary>
**Correct Answer:** B) 6TB<br>
**Explanation:** In RAID 5, you lose the equivalent capacity of exactly ONE drive for parity. Total = (N-1) * Size. So, (4-1) * 2TB = 6TB.
</details>

**16. How many simultaneous disk failures can a RAID 5 array survive without losing any data?**
- A) 0
- B) 1
- C) 2
- D) 3
<details>
<summary>Answer</summary>
**Correct Answer:** B) 1<br>
**Explanation:** RAID 5 can withstand exactly one drive failure. If a second drive dies before the first one is replaced and rebuilt, all data is lost.
</details>

**17. Why might an enterprise choose RAID 6 instead of RAID 5?**
- A) Because RAID 6 is much cheaper.
- B) Because RAID 6 uses "Double Parity", meaning it can survive TWO simultaneous disk failures without data loss, which is crucial for massive arrays where rebuilding a drive takes days.
- C) Because RAID 6 is twice as fast.
- D) Because RAID 6 uses fewer disks.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Because RAID 6 uses "Double Parity", meaning it can survive TWO simultaneous disk failures...<br>
**Explanation:** As hard drives get bigger (e.g., 18TB), rebuilding a replaced drive can take 48 hours. During that time, the other drives are working extremely hard. If a second drive fails from the stress, RAID 5 dies, but RAID 6 survives.
</details>

**18. What is the minimum number of disks required for RAID 6?**
- A) 2
- B) 3
- C) 4
- D) 5
<details>
<summary>Answer</summary>
**Correct Answer:** C) 4<br>
**Explanation:** Because it uses double parity (losing the capacity of two drives), you need at least 4 drives to make it work (e.g., 2 for data, 2 for parity).
</details>

**19. Why is AWS S3 (Object Storage) preferred over AWS EBS (Block Storage) for storing millions of user profile pictures?**
- A) Object storage is infinitely scalable, vastly cheaper per GB, and data can be requested directly via an HTTP URL over the internet, unlike block storage which must be attached to a specific server.
- B) EBS cannot store JPEG files.
- C) S3 uses RAID 0, making it faster.
- D) S3 is a relational database.
<details>
<summary>Answer</summary>
**Correct Answer:** A) Object storage is infinitely scalable, vastly cheaper per GB, and data can be requested directly via an HTTP URL...<br>
**Explanation:** Block storage is expensive and tethered to an OS. Object storage is cheap, global, and designed for static media files.
</details>

**20. What is "Metadata" in Object Storage?**
- A) Data about the physical hard drive.
- B) Custom, highly detailed tags and key-value pairs (e.g., `Author: John, Camera: Sony, Topic: Vacation`) attached directly to the object, allowing for powerful searching and indexing without needing a separate SQL database.
- C) The actual bytes of the image file.
- D) The CSS styling of the data.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Custom, highly detailed tags and key-value pairs... attached directly to the object...<br>
**Explanation:** File storage only has basic metadata (Name, Size, Date Created). Object storage allows you to attach any custom metadata you want to the file itself.
</details>

---

### Hard (Questions 21 - 30)

**21. What is RAID 10 (or RAID 1+0)?**
- A) A software-only RAID.
- B) A nested RAID level that combines RAID 1 (Mirroring) and RAID 0 (Striping). Data is mirrored for redundancy and then striped for performance.
- C) A RAID level that uses 10 disks.
- D) An obsolete RAID from the 1990s.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A nested RAID level that combines RAID 1 (Mirroring) and RAID 0 (Striping)...<br>
**Explanation:** It offers the massive performance benefits of RAID 0 with the extreme safety of RAID 1. It is the gold standard for high-performance databases.
</details>

**22. In a RAID 10 array with four 2TB disks, what is the usable storage capacity?**
- A) 8TB
- B) 6TB
- C) 4TB
- D) 2TB
<details>
<summary>Answer</summary>
**Correct Answer:** C) 4TB<br>
**Explanation:** Because it incorporates mirroring (RAID 1), you lose exactly 50% of your total raw capacity. (4 * 2TB = 8TB raw / 2 = 4TB usable).
</details>

**23. Why is RAID 10 preferred over RAID 5 for heavy, write-intensive SQL databases?**
- A) RAID 10 is cheaper.
- B) RAID 5 suffers from a "Write Penalty" because every write operation requires reading the old data, calculating the new parity, and writing both the new data and new parity. RAID 10 simply writes the data twice (mirroring) with no CPU math overhead.
- C) RAID 5 cannot be used with SSDs.
- D) RAID 10 uses less electricity.
<details>
<summary>Answer</summary>
**Correct Answer:** B) RAID 5 suffers from a "Write Penalty" because every write operation requires... calculating the new parity...<br>
**Explanation:** For heavy database writes, the parity calculation of RAID 5/6 causes massive performance degradation compared to the simple duplication of RAID 10.
</details>

**24. In the context of SAN architectures, what is "Fibre Channel"?**
- A) A brand of ethernet cable.
- B) A specialized, high-speed network technology and protocol primarily used for connecting servers to SAN storage arrays, offering lossless delivery and much lower latency than standard TCP/IP Ethernet.
- C) A type of SSD.
- D) A routing algorithm for the internet.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A specialized, high-speed network technology and protocol primarily used for connecting servers to SAN storage arrays...<br>
**Explanation:** While modern iSCSI uses standard Ethernet, traditional enterprise SANs use Fibre Channel (FC) switches and cables specifically engineered for un-interrupted storage traffic.
</details>

**25. What is the difference between "Hardware RAID" and "Software RAID"?**
- A) Hardware RAID uses tape drives.
- B) Hardware RAID uses a dedicated physical controller card (with its own CPU and cache) to manage the disks, offloading the work from the main CPU. Software RAID relies on the OS (like Linux `mdadm`) and the main CPU to do the RAID calculations.
- C) Software RAID is faster.
- D) Hardware RAID is free.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Hardware RAID uses a dedicated physical controller card... Software RAID relies on the OS...<br>
**Explanation:** Hardware RAID is standard in enterprise servers because it is faster (especially for RAID 5 parity calculations) and has battery-backed caches to prevent data loss during power outages.
</details>

**26. What does "iSCSI" do in a SAN environment?**
- A) It formats the hard drives to NTFS.
- B) It allows SCSI commands (block storage commands) to be sent over standard IP (Ethernet) networks, allowing companies to build a SAN without buying expensive Fibre Channel equipment.
- C) It is a protocol for streaming video.
- D) It encrypts the NAS folder.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It allows SCSI commands (block storage commands) to be sent over standard IP (Ethernet) networks...<br>
**Explanation:** iSCSI (Internet Small Computer Systems Interface) makes SAN accessible over standard networking gear, revolutionizing enterprise storage costs.
</details>

**27. What is an "IOPS" metric, and why is it critical for Block Storage?**
- A) Internet Object Processing Speed.
- B) Input/Output Operations Per Second. It measures how many read/write actions the storage can handle in one second. It is the primary metric for database performance.
- C) Internal Operating System Priority.
- D) A measure of network bandwidth in Megabytes.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Input/Output Operations Per Second. It measures how many read/write actions the storage can handle in one second.<br>
**Explanation:** A hard drive might have high throughput (can transfer a 5GB movie fast), but low IOPS (terrible at looking up 10,000 tiny 4KB database records). Databases need high IOPS.
</details>

**28. Why should you NEVER use RAID as a replacement for Backups?**
- A) Because RAID is illegal for backups.
- B) RAID protects against hardware failure (a dead drive). It does NOT protect against human error (accidentally typing `DROP TABLE`), ransomware, or building fires. A backup is an offline, disconnected copy.
- C) RAID encrypts the backup.
- D) RAID cannot store large files.
<details>
<summary>Answer</summary>
**Correct Answer:** B) RAID protects against hardware failure (a dead drive). It does NOT protect against human error... ransomware, or building fires.<br>
**Explanation:** "RAID is not a backup" is the most important rule in IT. If a hacker encrypts your server, RAID 1 will beautifully mirror the encrypted data to both drives instantly.
</details>

**29. What is a "Hot Spare" in a RAID array?**
- A) A drive that is overheating.
- B) An extra, unused hard drive plugged into the server. If an active drive in the RAID array fails, the controller automatically powers on the hot spare and begins rebuilding the lost data onto it immediately, without human intervention.
- C) A backup power supply.
- D) A USB flash drive.
<details>
<summary>Answer</summary>
**Correct Answer:** B) An extra, unused hard drive plugged into the server. If an active drive... fails, the controller automatically powers on the hot spare...<br>
**Explanation:** This minimizes the window of vulnerability. Instead of waiting for an admin to drive to the data center with a replacement disk, the rebuild starts in seconds.
</details>

**30. Which storage model allows for "Storage Tiering", automatically moving rarely accessed data to slower, cheaper storage (like AWS Glacier)?**
- A) Hardware RAID 0
- B) RAM
- C) Object Storage
- D) Standard NAS
<details>
<summary>Answer</summary>
**Correct Answer:** C) Object Storage<br>
**Explanation:** Cloud Object Storage (like S3) has intelligent tiering. If an object isn't accessed for 90 days, it automatically shifts to "cold" archive storage to save money.
</details>
