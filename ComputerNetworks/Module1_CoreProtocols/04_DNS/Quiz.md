# Quiz: DNS (Chapter 4)

Test your knowledge of the Domain Name System, its hierarchy, records, and resolution processes! Each question has a collapsible answer with an explanation.

---

### Easy (Questions 1 - 10)

**1. What is the primary function of DNS?**
- A) To secure website connections
- B) To translate domain names into IP addresses
- C) To assign IP addresses to devices dynamically
- D) To route packets across the internet
<details>
<summary>Answer</summary>
**Correct Answer:** B) To translate domain names into IP addresses<br>
**Explanation:** DNS acts as the phonebook of the internet, resolving human-readable names (like google.com) into machine-readable IP addresses.
</details>

**2. Which port does DNS primarily use for standard queries?**
- A) Port 80
- B) Port 443
- C) Port 53
- D) Port 22
<details>
<summary>Answer</summary>
**Correct Answer:** C) Port 53<br>
**Explanation:** DNS primarily uses UDP port 53 for standard query resolutions. It uses TCP port 53 for large responses or zone transfers.
</details>

**3. Which DNS record type maps a domain name to an IPv4 address?**
- A) CNAME
- B) A
- C) AAAA
- D) MX
<details>
<summary>Answer</summary>
**Correct Answer:** B) A<br>
**Explanation:** The "A" (Address) record is used to point a domain name to an IPv4 address.
</details>

**4. What does the AAAA record do in DNS?**
- A) Maps a domain to four different IP addresses.
- B) Maps a domain to an IPv6 address.
- C) Serves as a backup for the A record.
- D) Handles email routing.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Maps a domain to an IPv6 address.<br>
**Explanation:** The AAAA (Quad-A) record is specifically used to map a domain to a 128-bit IPv6 address.
</details>

**5. What is the highest level of the DNS hierarchy?**
- A) TLD Server
- B) Recursive Resolver
- C) Root Server
- D) Authoritative Server
<details>
<summary>Answer</summary>
**Correct Answer:** C) Root Server<br>
**Explanation:** The Root Name Servers (represented by a dot `.`) sit at the very top of the DNS hierarchy tree.
</details>

**6. Which of the following is an example of a TLD (Top-Level Domain)?**
- A) www
- B) .com
- C) google
- D) https://
<details>
<summary>Answer</summary>
**Correct Answer:** B) .com<br>
**Explanation:** TLDs are the last segment of a domain name, such as .com, .org, .net, or .edu.
</details>

**7. Which DNS server holds the actual, final IP address record for a specific domain like "example.com"?**
- A) Root Server
- B) TLD Server
- C) Authoritative Name Server
- D) ISP Resolver
<details>
<summary>Answer</summary>
**Correct Answer:** C) Authoritative Name Server<br>
**Explanation:** The Authoritative Name Server is the final destination in the DNS lookup process. It holds the actual DNS records created by the domain owner.
</details>

**8. If you want to configure email for your domain, which DNS record must you create?**
- A) CNAME
- B) A
- C) MX
- D) NS
<details>
<summary>Answer</summary>
**Correct Answer:** C) MX<br>
**Explanation:** The MX (Mail Exchange) record directs emails to a specific mail server responsible for accepting email messages on behalf of a domain.
</details>

**9. What does TTL stand for in the context of DNS?**
- A) Time To Load
- B) Total Transfer Length
- C) Time To Live
- D) Top TLD Level
<details>
<summary>Answer</summary>
**Correct Answer:** C) Time To Live<br>
**Explanation:** TTL defines how long (in seconds) a DNS record should be cached by resolvers and browsers before it expires and a new query is required.
</details>

**10. What is a CNAME record used for?**
- A) To map an IP to a hostname
- B) To map a domain name to another domain name (Alias)
- C) To specify the Name Server
- D) To add text descriptions to a domain
<details>
<summary>Answer</summary>
**Correct Answer:** B) To map a domain name to another domain name (Alias)<br>
**Explanation:** CNAME (Canonical Name) acts as an alias, pointing one domain/subdomain to another domain name instead of directly to an IP.
</details>

---

### Medium (Questions 11 - 20)

**11. In a DNS query, what is the difference between a Recursive query and an Iterative query?**
- A) Recursive queries are encrypted; iterative are not.
- B) Recursive asks the server to find the final answer; iterative asks the server for the best reference it has.
- C) Recursive uses TCP; iterative uses UDP.
- D) Recursive asks for an IP; iterative asks for a domain name.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Recursive asks the server to find the final answer; iterative asks the server for the best reference it has.<br>
**Explanation:** In a recursive query, the resolver does all the legwork. In an iterative query, a server replies with the address of the next server in the hierarchy to ask.
</details>

**12. When you type `www.example.com`, where does your computer typically look FIRST to find the IP address?**
- A) The Root Server
- B) The ISP's DNS Resolver
- C) The Local Browser/OS Cache
- D) The TLD Server
<details>
<summary>Answer</summary>
**Correct Answer:** C) The Local Browser/OS Cache<br>
**Explanation:** The OS and browser always check their local cache first to save time and network resources before sending a query to the DNS resolver.
</details>

**13. Which DNS record is often used to verify domain ownership for services like Google Workspace or to store SPF records?**
- A) NS Record
- B) TXT Record
- C) AAAA Record
- D) CNAME Record
<details>
<summary>Answer</summary>
**Correct Answer:** B) TXT Record<br>
**Explanation:** TXT (Text) records allow administrators to insert arbitrary text into the DNS record, commonly used for domain verification, SPF, and DKIM (email security).
</details>

**14. What is "DNS Propagation"?**
- A) The process of registering a new domain name.
- B) The time it takes for DNS changes to update across all caching servers globally.
- C) The process of encrypting a DNS query.
- D) When a root server goes down.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The time it takes for DNS changes to update across all caching servers globally.<br>
**Explanation:** Because of TTL and caching at various ISPs, when you change an IP address in your DNS settings, it takes time for the old cached data to expire globally.
</details>

**15. You want to point your root domain (`example.com`) directly to `another-site.com`. Why might using a CNAME record cause an issue?**
- A) CNAME records only support IPv6.
- B) DNS standards generally do not allow CNAME records at the root (apex) of a domain.
- C) CNAME records bypass TTL settings.
- D) CNAME records cannot resolve to external domains.
<details>
<summary>Answer</summary>
**Correct Answer:** B) DNS standards generally do not allow CNAME records at the root (apex) of a domain.<br>
**Explanation:** RFC standards state that if a CNAME exists for a node, no other records (like MX or TXT) can exist for that same node. Root domains require SOA and NS records, so a CNAME cannot be placed there. (Providers use ALIAS or ANAME records as workarounds).
</details>

**16. What is the role of an NS Record?**
- A) It specifies the mail servers for the domain.
- B) It maps a hostname to an IP address.
- C) It indicates which DNS servers are authoritative for the domain.
- D) It secures the DNS zone.
<details>
<summary>Answer</summary>
**Correct Answer:** C) It indicates which DNS servers are authoritative for the domain.<br>
**Explanation:** NS (Name Server) records delegate a domain to a set of authoritative name servers. When you buy a domain, you set its NS records to point to your hosting/DNS provider.
</details>

**17. What happens when the TTL of a DNS record expires in an ISP's resolver cache?**
- A) The domain is deleted from the internet.
- B) The resolver must perform a new full lookup to fetch the updated record.
- C) The browser throws a "DNS_PROBE_FINISHED_NXDOMAIN" error.
- D) The resolver automatically increases the TTL.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The resolver must perform a new full lookup to fetch the updated record.<br>
**Explanation:** Expiration of TTL means the cached data is no longer considered fresh. The next time a user requests it, the resolver must query the authoritative server again.
</details>

**18. How many logical IPv4 Root Name Server clusters exist globally?**
- A) 7
- B) 13
- C) 64
- D) 256
<details>
<summary>Answer</summary>
**Correct Answer:** B) 13<br>
**Explanation:** There are 13 logical root name servers globally, named `a.root-servers.net` through `m.root-servers.net`. However, through Anycast routing, they are backed by hundreds of physical servers.
</details>

**19. Which command-line tool is commonly used to manually query DNS records (A, MX, NS, etc.)?**
- A) ping
- B) traceroute
- C) dig (or nslookup)
- D) netstat
<details>
<summary>Answer</summary>
**Correct Answer:** C) dig (or nslookup)<br>
**Explanation:** `dig` (Domain Information Groper) and `nslookup` are the standard CLI tools used to troubleshoot and query specific DNS records from specific servers.
</details>

**20. When a TLD server responds to a resolver, what does it typically provide?**
- A) The final IP address of the website.
- B) The IP address of the Authoritative Name Server for that specific domain.
- C) A CNAME record.
- D) An HTTP 200 OK status.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The IP address of the Authoritative Name Server for that specific domain.<br>
**Explanation:** The TLD server (like the `.com` server) doesn't know the website's IP, but it knows which Authoritative Servers manage that specific `.com` domain.
</details>

---

### Hard (Questions 21 - 30)

**21. What is "Reverse DNS" (rDNS)?**
- A) Translating an IP address back to a domain name.
- B) Resolving a domain name starting from the Authoritative server up to the Root.
- C) Reversing the byte order in a DNS packet.
- D) Using a CNAME to point an IP to a domain.
<details>
<summary>Answer</summary>
**Correct Answer:** A) Translating an IP address back to a domain name.<br>
**Explanation:** While standard forward DNS translates a name to an IP, Reverse DNS (rDNS) uses a PTR (Pointer) record to resolve an IP address back into a hostname.
</details>

**22. Which DNS record type is specifically used for Reverse DNS lookups?**
- A) A
- B) SRV
- C) PTR
- D) SOA
<details>
<summary>Answer</summary>
**Correct Answer:** C) PTR<br>
**Explanation:** A Pointer (PTR) record is used in reverse DNS zones (`in-addr.arpa`) to map an IP address to a canonical name.
</details>

**23. What is the purpose of the SOA (Start of Authority) record?**
- A) It defines the primary name server and administrative details (like TTL and admin email) for the DNS zone.
- B) It forces DNSSEC encryption on the domain.
- C) It points the root domain to an IP address.
- D) It authorizes email senders for the domain.
<details>
<summary>Answer</summary>
**Correct Answer:** A) It defines the primary name server and administrative details...<br>
**Explanation:** Every DNS zone must have an SOA record. It contains essential zone data including the primary name server, admin email, serial number, and various timers (refresh, retry, expire).
</details>

**24. In the context of DNS, what is a "Zone Transfer" (AXFR)?**
- A) Transferring a domain name to a new registrar.
- B) The replication of DNS databases across a set of DNS servers (Primary to Secondary).
- C) Migrating from IPv4 (A) to IPv6 (AAAA).
- D) Transferring the TTL cache to a local machine.
<details>
<summary>Answer</summary>
**Correct Answer:** B) The replication of DNS databases across a set of DNS servers...<br>
**Explanation:** A zone transfer is used to synchronize DNS records from a Primary Authoritative server to a Secondary (slave) server. This typically uses TCP port 53.
</details>

**25. Which protocol extension adds cryptographic signatures to existing DNS records to prevent spoofing and cache poisoning?**
- A) DoH (DNS over HTTPS)
- B) DoT (DNS over TLS)
- C) DNSSEC
- D) DNSCrypt
<details>
<summary>Answer</summary>
**Correct Answer:** C) DNSSEC<br>
**Explanation:** DNSSEC (Domain Name System Security Extensions) adds digital signatures to DNS data so the resolver can verify the origin and integrity of the DNS records, preventing cache poisoning attacks.
</details>

**26. What is the difference between DoH (DNS over HTTPS) and traditional DNS?**
- A) DoH uses TCP port 53 instead of UDP.
- B) DoH encrypts the DNS query inside an HTTPS request, hiding it from ISPs and local networks.
- C) DoH only resolves IPv6 addresses.
- D) DoH bypasses the root servers entirely.
<details>
<summary>Answer</summary>
**Correct Answer:** B) DoH encrypts the DNS query inside an HTTPS request...<br>
**Explanation:** Traditional DNS queries are sent in plaintext. DoH encrypts the query using HTTPS (Port 443), enhancing privacy and preventing eavesdropping or tampering.
</details>

**27. What is DNS Cache Poisoning (or DNS Spoofing)?**
- A) Injecting malicious code into an A record's IP address.
- B) Tricking a DNS resolver into caching a fake IP address for a legitimate domain.
- C) Using a DDoS attack to take down the root servers.
- D) Sending corrupted packets to a browser.
<details>
<summary>Answer</summary>
**Correct Answer:** B) Tricking a DNS resolver into caching a fake IP address for a legitimate domain.<br>
**Explanation:** Attackers send forged DNS responses to a resolver. If successful, the resolver caches the fake IP, and all subsequent users querying that domain are redirected to a malicious server.
</details>

**28. If a domain has multiple A records pointing to different IP addresses, how does the DNS resolver typically respond?**
- A) It throws a configuration error.
- B) It returns all IP addresses, often in a rotated order (Round Robin DNS).
- C) It only returns the first IP address.
- D) It attempts to ping them and returns the fastest one.
<details>
<summary>Answer</summary>
**Correct Answer:** B) It returns all IP addresses, often in a rotated order (Round Robin DNS).<br>
**Explanation:** Round Robin DNS is a basic load balancing technique. When multiple A records exist, the DNS server rotates the order of the IP addresses in its response, distributing traffic across multiple servers.
</details>

**29. What is an SRV (Service) record used for?**
- A) To define the SPF policy for emails.
- B) To map an IP to a MAC address.
- C) To specify the host and port for specific services (like SIP or XMPP/Chat).
- D) To create a wildcard subdomain.
<details>
<summary>Answer</summary>
**Correct Answer:** C) To specify the host and port for specific services...<br>
**Explanation:** Unlike A or CNAME records, SRV records can specify the target host, port, priority, and weight for a specific service running on a domain.
</details>

**30. Why is the Root DNS zone represented by a dot (`.`)?**
- A) It is a placeholder for IPv4.
- B) The dot represents the unnamed root of the DNS tree, and technically all Fully Qualified Domain Names (FQDNs) end with it (e.g., `www.example.com.`).
- C) It indicates the end of a CNAME record.
- D) It is an abbreviation for "Domain".
<details>
<summary>Answer</summary>
**Correct Answer:** B) The dot represents the unnamed root of the DNS tree...<br>
**Explanation:** In strict DNS terminology, a Fully Qualified Domain Name ends with a trailing dot representing the root server (e.g., `google.com.`). Browsers simply hide this trailing dot for convenience.
</details>
