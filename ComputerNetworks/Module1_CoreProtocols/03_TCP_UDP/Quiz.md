# Quiz: TCP & UDP (Chapter 3)

Test your knowledge of TCP, UDP, Handshakes, Flow Control, and Congestion Control! Each question has a collapsible answer with an explanation. Try to answer all 30 questions yourself before expanding the answer.

---

### Easy (Questions 1 - 10)

**1. Which layer of the OSI model do TCP and UDP operate in?**
- A) Network Layer
- B) Transport Layer
- C) Session Layer
- D) Application Layer
<details>
<summary>Answer</summary>
**Correct Answer:** B) Transport Layer<br>
**Explanation:** Both TCP and UDP are Transport Layer (Layer 4) protocols responsible for end-to-end communication and port addressing.
</details>

**2. Which of the following is true about TCP?**
- A) Connectionless and unreliable
- B) Connection-oriented and unreliable
- C) Connectionless and reliable
- D) Connection-oriented and reliable
<details>
<summary>Answer</summary>
**Correct Answer:** D) Connection-oriented and reliable<br>
**Explanation:** TCP establishes a connection before sending data and guarantees delivery using acknowledgments.
</details>

**3. What is the size of a standard TCP header (without options)?**
- A) 8 Bytes
- B) 16 Bytes
- C) 20 Bytes
- D) 32 Bytes
<details>
<summary>Answer</summary>
**Correct Answer:** C) 20 Bytes<br>
**Explanation:** The standard TCP header is 20 bytes long. UDP's header is 8 bytes.
</details>

**4. What is the primary purpose of the UDP protocol?**
- A) To guarantee data delivery
- B) To provide fast, low-overhead communication
- C) To establish secure connections
- D) To control network congestion
<details>
<summary>Answer</summary>
**Correct Answer:** B) To provide fast, low-overhead communication<br>
**Explanation:** UDP is connectionless and lacks error recovery, making it faster and suitable for real-time applications where minor data loss is acceptable.
</details>

**5. How many steps are there in a TCP connection establishment?**
- A) 2-way handshake
- B) 3-way handshake
- C) 4-way handshake
- D) 5-way handshake
<details>
<summary>Answer</summary>
**Correct Answer:** B) 3-way handshake<br>
**Explanation:** The 3-way handshake (SYN, SYN-ACK, ACK) is used to establish a TCP connection.
</details>

**6. Which TCP flag is used to initiate a connection?**
- A) ACK
- B) FIN
- C) SYN
- D) RST
<details>
<summary>Answer</summary>
**Correct Answer:** C) SYN<br>
**Explanation:** SYN stands for Synchronize. It is the first packet sent in the 3-way handshake to request a connection.
</details>

**7. Which protocol would be best suited for online multiplayer gaming?**
- A) TCP
- B) UDP
- C) FTP
- D) HTTP
<details>
<summary>Answer</summary>
**Correct Answer:** B) UDP<br>
**Explanation:** UDP is preferred for gaming because speed and low latency are more important than 100% reliable data delivery (a lost frame is better than a delayed one).
</details>

**8. Which field in the TCP header ensures that packets are reassembled in the correct order?**
- A) Acknowledgment Number
- B) Sequence Number
- C) Window Size
- D) Checksum
<details>
<summary>Answer</summary>
**Correct Answer:** B) Sequence Number<br>
**Explanation:** The Sequence Number is used to order the segments and reassemble them correctly at the destination.
</details>

**9. What happens if a packet is lost while using UDP?**
- A) It is retransmitted automatically.
- B) The connection is closed.
- C) It is ignored, and data is not retransmitted.
- D) The sender is notified via an ICMP message.
<details>
<summary>Answer</summary>
**Correct Answer:** C) It is ignored, and data is not retransmitted.<br>
**Explanation:** UDP is "fire and forget". It has no built-in mechanism to detect lost packets or retransmit them.
</details>

**10. What is the purpose of the Checksum field in both TCP and UDP headers?**
- A) To encrypt the data
- B) To detect data corruption during transmission
- C) To count the number of hops
- D) To determine the size of the packet
<details>
<summary>Answer</summary>
**Correct Answer:** B) To detect data corruption during transmission<br>
**Explanation:** The Checksum ensures the integrity of the header and data by checking for errors/corruption that occurred during transit.
</details>

---

### Medium (Questions 11 - 20)

**11. During a TCP 3-way handshake, if the client sends a SYN packet with Sequence Number 100, what will be the Acknowledgment Number in the server's SYN-ACK response?**
- A) 100
- B) 101
- C) 0
- D) Randomly generated
<details>
<summary>Answer</summary>
**Correct Answer:** B) 101<br>
**Explanation:** The Acknowledgment Number is always the Sequence Number received + 1 (100 + 1 = 101). It indicates "I received 100, now I am expecting 101".
</details>

**12. Which mechanism does TCP use for Flow Control?**
- A) Sliding Window
- B) Congestion Window
- C) Slow Start
- D) Fast Retransmit
<details>
<summary>Answer</summary>
**Correct Answer:** A) Sliding Window<br>
**Explanation:** TCP uses the Sliding Window protocol for Flow Control to prevent the sender from overwhelming the receiver's buffer.
</details>

**13. In TCP Congestion Control, what is the initial phase called where the congestion window grows exponentially?**
- A) Congestion Avoidance
- B) Fast Recovery
- C) Slow Start
- D) Linear Growth
<details>
<summary>Answer</summary>
**Correct Answer:** C) Slow Start<br>
**Explanation:** Despite its name, "Slow Start" actually increases the sending rate exponentially (1, 2, 4, 8) to quickly find the network's capacity.
</details>

**14. Which flag is used to gracefully terminate a TCP connection?**
- A) RST
- B) FIN
- C) PSH
- D) URG
<details>
<summary>Answer</summary>
**Correct Answer:** B) FIN<br>
**Explanation:** The FIN (Finish) flag is used in the 4-way handshake to gracefully close a connection when there is no more data to send.
</details>

**15. What is the size of the UDP header?**
- A) 8 Bytes
- B) 12 Bytes
- C) 20 Bytes
- D) 32 Bytes
<details>
<summary>Answer</summary>
**Correct Answer:** A) 8 Bytes<br>
**Explanation:** The UDP header is only 8 bytes long (Source Port, Destination Port, Length, Checksum), making it very lightweight.
</details>

**16. If a receiver advertises a Window Size of 0 (Zero Window), what should the TCP sender do?**
- A) Double the sending speed.
- B) Stop sending data until the window size is greater than 0.
- C) Retransmit all previous packets.
- D) Close the connection immediately.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Stop sending data until the window size is greater than 0.<br>
**Explanation:** A Window Size of 0 means the receiver's buffer is full. The sender must stop sending to prevent data loss.
</details>

**17. How does TCP handle a situation where an ACK is not received before the retransmission timeout (RTO) expires?**
- A) It sends a FIN packet.
- B) It ignores the loss and sends the next sequence.
- C) It retransmits the unacknowledged segment.
- D) It requests an ICMP error message.
<details>
<summary>Answer</summary>
**Correct Answer:** C) It retransmits the unacknowledged segment.<br>
**Explanation:** If the timeout expires before an ACK is received, TCP assumes the packet was lost and retransmits it.
</details>

**18. Which TCP flag forcefully resets a connection instantly, without a graceful termination?**
- A) SYN
- B) URG
- C) FIN
- D) RST
<details>
<summary>Answer</summary>
**Correct Answer:** D) RST<br>
**Explanation:** The RST (Reset) flag forcefully and instantly drops a connection, usually due to an error, timeout, or receiving a packet for a closed port.
</details>

**19. Why is DNS primarily built on top of UDP?**
- A) Because DNS responses are huge.
- B) Because UDP encrypts DNS queries.
- C) Because DNS queries fit within a single packet and need fast resolution.
- D) Because DNS requires ordered delivery.
<details>
<summary>Answer</summary>
**Correct Answer:** C) Because DNS queries fit within a single packet and need fast resolution.<br>
**Explanation:** A standard DNS query/response is small enough for one UDP packet. Using TCP would require a 3-way handshake, adding unnecessary delay. (Note: DNS falls back to TCP for large responses like zone transfers).
</details>

**20. Which phase of TCP Congestion Control increases the window size linearly rather than exponentially?**
- A) Slow Start
- B) Congestion Avoidance
- C) Fast Recovery
- D) Window Scaling
<details>
<summary>Answer</summary>
**Correct Answer:** B) Congestion Avoidance<br>
**Explanation:** Once the congestion window hits the threshold (ssthresh), TCP switches to Congestion Avoidance, growing linearly (by 1 MSS per RTT) to avoid congesting the network.
</details>

---

### Hard (Questions 21 - 30)

**21. In a TCP header, the "Data Offset" field specifies:**
- A) The total size of the segment in bytes.
- B) The size of the TCP header in 32-bit words.
- C) The sequence number of the first byte of data.
- D) The size of the window scale option.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The size of the TCP header in 32-bit words.<br>
**Explanation:** The Data Offset field indicates where the data begins. It represents the length of the TCP header (including Options) in 32-bit (4-byte) words.
</details>

**22. During the 4-way TCP termination, the client sends a FIN and receives an ACK. What TCP state is the client in while waiting for the server's FIN?**
- A) ESTABLISHED
- B) FIN_WAIT_1
- C) FIN_WAIT_2
- D) TIME_WAIT
<details>
<summary>Answer</summary>
**Correct Answer:** C) FIN_WAIT_2<br>
**Explanation:** After sending FIN (FIN_WAIT_1) and receiving an ACK for it, the client enters FIN_WAIT_2, waiting for the server to send its own FIN.
</details>

**23. What is the purpose of the TIME_WAIT state in TCP connection termination?**
- A) To wait for the application to close.
- B) To ensure the final ACK sent by the client reaches the server, and to prevent delayed packets from interfering with new connections.
- C) To keep the connection open for further data transfer.
- D) To allow the server to retransmit the SYN packet.
<details>
<summary>Answer</summary>
**Correct Answer:** B) To ensure the final ACK sent by the client reaches the server...<br>
**Explanation:** TIME_WAIT (typically 2 * Maximum Segment Lifetime) ensures that the other side received the final ACK. If the ACK is lost, the server will resend FIN, and the client in TIME_WAIT can resend the ACK.
</details>

**24. Which condition triggers "Fast Retransmit" in TCP?**
- A) A timeout (RTO) expires.
- B) Receiving 3 duplicate ACKs for the same sequence number.
- C) Receiving a Zero Window size.
- D) Receiving a RST flag.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Receiving 3 duplicate ACKs for the same sequence number.<br>
**Explanation:** If the sender receives 3 duplicate ACKs (4 ACKs total for the same seq num), it implies a packet was dropped but subsequent packets arrived. TCP quickly retransmits the missing packet without waiting for the timeout.
</details>

**25. A UDP header has a Length field. What does this Length field specify?**
- A) Only the length of the UDP header.
- B) Only the length of the UDP payload (data).
- C) The length of the entire UDP datagram (header + payload).
- D) The length of the IP header + UDP header.
<details>
<summary>Answer</summary>
**Correct Answer:** C) The length of the entire UDP datagram (header + payload).<br>
**Explanation:** The UDP Length field specifies the total length in bytes of the UDP header and the data combined. The minimum value is 8 (header only).
</details>

**26. Why does TCP use "Window Scaling" (an optional TCP feature)?**
- A) To scale down the window size during congestion.
- B) To overcome the 64KB limit of the 16-bit Window Size field in high-bandwidth, high-latency networks.
- C) To encrypt the window size.
- D) To split large packets into smaller ones.
<details>
<summary>Answer</summary>
**Correct Answer:** B) To overcome the 64KB limit of the 16-bit Window Size field...<br>
**Explanation:** The 16-bit field allows a max window of 65,535 bytes. For fast, long-distance links (LFNs), this is too small. Window Scaling allows multiplying the window size to support much larger buffers (up to 1GB).
</details>

**27. What happens if the `ssthresh` (Slow Start Threshold) is reached during TCP Congestion Control?**
- A) The connection is reset.
- B) The window size drops to zero.
- C) The algorithm switches from exponential growth (Slow Start) to linear growth (Congestion Avoidance).
- D) Fast Retransmit is triggered.
<details>
<summary>Answer</summary>
**Correct Answer:** C) The algorithm switches from exponential growth...<br>
**Explanation:** Once the congestion window hits `ssthresh`, TCP stops aggressive exponential growth and begins cautiously increasing the window linearly.
</details>

**28. What is "Silly Window Syndrome" in TCP?**
- A) When a receiver mistakenly sends a negative window size.
- B) A scenario where small amounts of data are sent in tiny packets, causing massive overhead and inefficiency.
- C) When the sliding window moves backward.
- D) When the congestion window grows infinitely.
<details>
<summary>Answer</summary>
**Correct Answer:** B) A scenario where small amounts of data are sent in tiny packets...<br>
**Explanation:** Silly Window Syndrome occurs if the sender sends tiny packets (e.g., 1 byte data + 40 bytes header) or the receiver advertises tiny window updates, degrading network performance. Algorithms like Nagle's and Clark's solve this.
</details>

**29. In a network capture, you see a packet with the SYN and ACK flags both set to 1. What does this packet represent?**
- A) The client initiating a connection.
- B) The server responding to a client's connection request.
- C) The client acknowledging the server's data.
- D) The server closing the connection.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The server responding to a client's connection request.<br>
**Explanation:** SYN-ACK is the second step of the 3-way handshake, where the server accepts the client's SYN and sends its own SYN.
</details>

**30. Which of the following is NOT an advantage of UDP over TCP?**
- A) Smaller header size
- B) No connection setup delay
- C) Built-in congestion control
- D) Support for broadcasting and multicasting
<details>
<summary>Answer</summary>
**Correct Answer:** C) Built-in congestion control<br>
**Explanation:** UDP does NOT have congestion control, flow control, or reliability. Its advantages are small headers, speed, and support for broadcast/multicast (TCP is strictly unicast).
</details>
