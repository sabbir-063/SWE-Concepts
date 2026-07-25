# 01. SQL vs NoSQL (Practice MCQs)

This file contains 40 in-depth MCQs comparing SQL and NoSQL databases, focusing on scaling, schema design, ACID vs BASE, CAP theorem, and use cases.

---

**Q1. What does the acronym SQL stand for?**
A) Simple Query Logic
B) Structured Query Language
C) Sequential Query Language
D) Synchronized Query Logic

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: SQL (Structured Query Language) রিলেশনাল ডাটাবেসে ডেটা ম্যানেজ করার জন্য ব্যবহৃত স্ট্যান্ডার্ড ল্যাঙ্গুয়েজ।
</details>

---

**Q2. Which of the following is the primary characteristic of a Relational Database (SQL)?**
A) Data is stored as JSON documents
B) Data is organized into tables consisting of rows and columns with strict relationships
C) It cannot handle transactions
D) It scales horizontally by default

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: SQL ডাটাবেসের মেইন ফিচারই হলো ডেটাকে টেবিল (Rows/Columns) আকারে রাখা এবং এক টেবিলের সাথে অন্য টেবিলের রিলেশন (Primary/Foreign Key) তৈরি করা।
</details>

---

**Q3. Which of the following accurately describes the Schema in a traditional SQL database?**
A) Dynamic and unstructured
B) Rigid and pre-defined
C) Graph-based
D) Invisible to the user

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: SQL এ ডেটা ঢোকানোর আগেই আপনাকে বলে দিতে হয় যে টেবিলে কয়টা কলাম থাকবে, কী নাম হবে এবং ডেটা টাইপ কী হবে (Rigid Schema)।
</details>

---

**Q4. What is a "Document" in the context of a NoSQL database like MongoDB?**
A) A PDF file stored as a BLOB
B) A single row in a strict table
C) A JSON or BSON object containing key-value pairs and potentially nested data
D) A physical piece of paper

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: NoSQL এ ডেটা JSON (বা BSON) অবজেক্ট হিসেবে সেভ হয়, যাকে Document বলে। এর ভেতরে আবার Array বা আরেকটা Object (Nested) থাকতে পারে।
</details>

---

**Q5. How does a NoSQL database handle Schema?**
A) It uses a strictly defined schema similar to SQL
B) It relies entirely on the operating system for schema management
C) It has a dynamic or flexible schema, meaning documents in the same collection do not need to have the exact same fields
D) It does not allow adding new fields after creation

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: NoSQL এ কোনো ফিক্সড ডিজাইন লাগে না। একই কালেকশনে (টেবিলে) আপনি চাইলে এমন ডকুমেন্ট রাখতে পারেন যার ৩টি ফিল্ড আছে, আবার এমন ডকুমেন্টও রাখতে পারেন যার ১০টি ফিল্ড আছে।
</details>

---

**Q6. What does "Vertical Scaling" (Scaling Up) primarily involve?**
A) Adding more servers or nodes to a cluster
B) Adding more CPU power, RAM, or storage to a single existing server
C) Increasing the physical height of the server rack
D) Writing more efficient queries

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Vertical Scaling মানে হলো আপনার বর্তমান পিসির বা সার্ভারের র‍্যাম/প্রসেসর বাড়িয়ে দেওয়া। SQL ডাটাবেসগুলো সাধারণত এভাবেই স্কেল করা হয়।
</details>

---

**Q7. What does "Horizontal Scaling" (Scaling Out) primarily involve?**
A) Adding more CPU cores to a single machine
B) Adding more physical or virtual servers (nodes) to distribute the database load
C) Increasing the network bandwidth
D) Using longer variable names in code

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Horizontal Scaling মানে হলো সার্ভারের শক্তি না বাড়িয়ে, সার্ভারের "সংখ্যা" বাড়ানো। NoSQL ডাটাবেসগুলো জন্মগতভাবেই একাধিক সার্ভারে ডেটা ডিস্ট্রিবিউট (Horizontal Scale) করতে এক্সপার্ট।
</details>

---

**Q8. Which type of database is natively designed to be highly horizontally scalable out-of-the-box?**
A) Traditional SQL databases (like MySQL)
B) NoSQL databases (like Cassandra or MongoDB)
C) SQLite
D) Microsoft Access

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: NoSQL ডিজাইনই করা হয়েছে Big Data হ্যান্ডেল করার জন্য, তাই এগুলো কোনো ঝামেলা ছাড়াই অনেকগুলো সার্ভারে ডেটা ভাগ করে (Sharding) রাখতে পারে।
</details>

---

**Q9. What does the acronym "ACID" stand for in SQL database transactions?**
A) Accuracy, Consistency, Isolation, Durability
B) Atomicity, Consistency, Isolation, Durability
C) Atomicity, Concurrency, Integration, Durability
D) Availability, Consistency, Isolation, Distributed

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এটি ট্রানজ্যাকশনের 100% রিলায়েবিলিটি গ্যারান্টি দেয়। ব্যাংকিং সিস্টেমে ACID প্রপার্টি ছাড়া কাজ করা অসম্ভব।
</details>

---

**Q10. In ACID, what does "Atomicity" guarantee?**
A) That the data is small
B) That a transaction is treated as a single, indivisible logical unit of work—it either completely succeeds, or completely fails and rolls back
C) That the server will never crash
D) That read operations are extremely fast

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Atomicity মানে হলো "হলে পুরোটা হবে, না হলে কিছুই হবে না"। অর্ধেক কাজ হয়ে আটকে যাওয়ার কোনো সুযোগ নেই।
</details>

---

**Q11. What does the "BASE" model stand for in NoSQL architectures?**
A) Basic Availability, Secure State, Eventually Consistent
B) Basically Available, Soft state, Eventual consistency
C) Binary Algorithms, Simple Execution
D) Backup Available, Solid state, Eventual recovery

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: NoSQL ট্রানজ্যাকশনের গ্যারান্টির চেয়ে স্পিড এবং এভেইলঅ্যাবিলিটি (Availability) কে বেশি প্রায়োরিটি দেয়, তাই এরা ACID এর বদলে BASE রুল ফলো করে।
</details>

---

**Q12. What does "Eventual Consistency" mean in the BASE model?**
A) Data is never consistent
B) Data is consistent immediately across all nodes the millisecond it is written
C) If no new updates are made, eventually all nodes will receive the latest data and become consistent
D) The database will eventually delete old data

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: এর মানে হলো, আমি একটা ডেটা আপডেট করলে সাথে সাথে দুনিয়ার সব সার্ভারে আপডেট না-ও হতে পারে। তবে "একটু পরে" (Eventually) সব সার্ভার সিঙ্ক (Sync) করে নেবে এবং ডেটা সেইম হয়ে যাবে।
</details>

---

**Q13. In a banking application where transferring funds securely between accounts is the highest priority, which database type should be chosen?**
A) A Document NoSQL Database (like MongoDB)
B) A Relational SQL Database (like PostgreSQL) due to strict ACID compliance
C) A Graph Database (like Neo4j)
D) An In-Memory Database (like Redis)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ব্যাংকিংয়ে 100% অ্যাকুরেসি লাগে। টাকা পাঠালে আমার থেকে কাটবে এবং ওর কাছে যাবে, এই ট্রানজ্যাকশনটা ACID গ্যারান্টি ছাড়া পসিবল নয়। তাই SQL বেস্ট।
</details>

---

**Q14. Which NoSQL database type is specifically optimized for storing and querying highly interconnected data, like social networks (e.g., "Friends of Friends")?**
A) Key-Value Store (Redis)
B) Column-Family Store (Cassandra)
C) Graph Database (Neo4j)
D) Document Store (MongoDB)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: গ্রাফ ডাটাবেস নোড (Node) এবং এজের (Edge) মাধ্যমে ডেটার মধ্যকার সম্পর্ক খুব ফাস্ট ট্রাভার্স করতে পারে। ফেসবুক বা লিঙ্কডইনের কানেকশন বের করার জন্য এটি বেস্ট।
</details>

---

**Q15. How is a "One-to-Many" relationship generally handled for maximum performance in a Document NoSQL database (like MongoDB)?**
A) By creating two separate collections and using complex JOIN queries
B) By embedding the "Many" side as an array of sub-documents inside the "One" parent document (Denormalization)
C) By duplicating the parent document for every child
D) NoSQL cannot handle relationships

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: NoSQL এ JOIN অপারেশন স্লো। তাই পারফরম্যান্সের জন্য ইউজারের ডেটার ভেতরেই তার সব অর্ডারের লিস্ট (Array) এমবেড (Embed) করে দেওয়া হয়।
</details>

---

**Q16. What is "Normalization" in a Relational Database?**
A) The process of putting all data into a single massive table
B) The process of organizing data into multiple related tables to reduce data redundancy and improve data integrity
C) The process of converting SQL to NoSQL
D) The process of deleting old data

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডেটা যেন বারবার রিপিট না হয় (Redundancy কমানো), সেজন্য একটি বড় টেবিলকে ভেঙে ছোট ছোট টেবিলে ভাগ করে প্রাইমারি/ফরেন কি (Key) দিয়ে রিলেশন তৈরি করাকেই নরমালাইজেশন বলে।
</details>

---

**Q17. What is "Denormalization," which is heavily used in NoSQL?**
A) Encrypting database fields
B) Intentionally copying or duplicating data across documents to avoid slow JOIN operations during reads
C) Removing all data from a table
D) Splitting a single document into hundreds of smaller collections

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: NoSQL এ রিড স্পিড (Read speed) বাড়ানোর জন্য ডেটা ডুপ্লিকেট করতে দ্বিধা করা হয় না। ডেটা স্টোরেজ সস্তা, কিন্তু প্রসেসিং (JOIN) দামি। তাই সব ডেটা একসাথে রাখা হয়।
</details>

---

**Q18. Redis is a highly popular NoSQL database. Which category does it fall into?**
A) Graph Database
B) Wide-Column Store
C) In-Memory Key-Value Store
D) Relational Database

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Redis র্যামের (In-Memory) ভেতরে Key-Value পেয়ারে ডেটা রাখে। এটি মূলত ক্যাশিং (Caching), লিডারবোর্ড বা সেশন ম্যানেজ করার জন্য ব্যবহৃত হয়। এর স্পিড অসম্ভব ফাস্ট।
</details>

---

**Q19. Which database architecture is better suited for handling massive amounts of unstructured or semi-structured data (like IoT sensor logs or social media posts)?**
A) SQL
B) NoSQL
C) SQLite
D) MS Access

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: লগ বা সেন্সর ডেটার কোনো ফিক্সড স্ট্রাকচার থাকে না এবং ডেটার ভলিউমও অনেক বেশি হয়। NoSQL এর ফ্লেক্সিবল স্কিমা এবং হরাইজন্টাল স্কেলিং এর জন্য পারফেক্ট।
</details>

---

**Q20. According to the CAP Theorem, a distributed database can only guarantee two out of which three properties simultaneously?**
A) Consistency, Availability, Partition Tolerance
B) Concurrency, Atomicity, Performance
C) Cost, Availability, Processing
D) Consistency, Accuracy, Partition Tolerance

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: CAP থিওরেম অনুযায়ী কোনো ডিস্ট্রিবিউটেড সিস্টেম একই সাথে 100% Consistency, 100% Availability এবং 100% Partition Tolerance দিতে পারে না। যেকোনো দুটো বেছে নিতে হয় (যেমন CP বা AP)।
</details>

---

**Q21. In a standard SQL query, what clause is used to filter records?**
A) `ORDER BY`
B) `GROUP BY`
C) `WHERE`
D) `FILTER`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: SQL এ ডেটা ফিল্টার করার জন্য `WHERE` ক্লজ ব্যবহৃত হয়। (যেমন `SELECT * FROM users WHERE age > 20`)।
</details>

---

**Q22. What is the equivalent of the SQL `WHERE` clause in MongoDB?**
A) Passing a query object (filter document) into the `find()` method
B) Using the `.where()` method
C) MongoDB cannot filter data
D) Using a `JOIN`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: মঙ্গোডিবিতে `find({ age: { $gt: 20 } })` দিয়ে ফিল্টার করা হয়। ভেতরের অবজেক্টটাই ফিল্টারের কাজ করে।
</details>

---

**Q23. Which SQL keyword is used to retrieve data from two or more tables based on a related column between them?**
A) `MERGE`
B) `COMBINE`
C) `LINK`
D) `JOIN`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: `JOIN` (যেমন INNER JOIN, LEFT JOIN) ব্যবহার করে দুই বা ততোধিক টেবিলের ডেটা এক করে দেখানো যায়।
</details>

---

**Q24. Does MongoDB natively support SQL-style `JOIN`s?**
A) Yes, using the exact `JOIN` keyword
B) No, MongoDB physically prevents combining data
C) It supports an aggregation stage called `$lookup` to mimic a LEFT OUTER JOIN, but it is less efficient than SQL joins and generally discouraged for massive datasets
D) Yes, but only for numbers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: মঙ্গোডিবিতে `$lookup` আছে, তবে NoSQL এর মূল উদ্দেশ্য JOIN করা নয়। তাই এটি খুব স্লো কাজ করে। ডেটা এমবেড (Embed) করে রাখাই বেস্ট প্র্যাকটিস।
</details>

---

**Q25. What is "Sharding" in the context of databases?**
A) Deleting corrupted data
B) Compressing database backups
C) A method of distributing a single large database across multiple machines (Horizontal Scaling) based on a shard key
D) Encrypting columns

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Sharding মানে হলো বিশাল ডেটাবেসকে টুকরো টুকরো করে বিভিন্ন সার্ভারে ভাগ করে রাখা। NoSQL এ এটি খুব সহজেই করা যায়।
</details>

---

**Q26. What does a "Primary Key" do in an SQL table?**
A) It encrypts the row
B) It uniquely identifies each record (row) in a table and cannot contain NULL values
C) It links two tables together
D) It defines the table name

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রাইমারি কি (Primary Key) হলো একটি টেবিলের প্রতিটি রো-এর ইউনিক আইডি (যেমন NID বা Roll No)। এটি দিয়ে ডেটা খুব দ্রুত খুঁজে বের করা যায়।
</details>

---

**Q27. In MongoDB, what is the default unique identifier assigned to every newly inserted document if one is not explicitly provided?**
A) `id` (an integer)
B) `uid` (a UUID)
C) `_id` (an ObjectId generated by MongoDB)
D) `primary_key`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: মঙ্গোডিবি অটোমেটিকভাবে ১২-বাইটের একটি ইউনিক হেক্সাডেসিমাল স্ট্রিং জেনারেট করে এবং সেটি `_id` ফিল্ডে সেভ করে।
</details>

---

**Q28. What is a "Foreign Key" in SQL?**
A) A key used by foreign users to access the DB
B) A column or group of columns in one table that uniquely identifies a row of another table, establishing a link between the data
C) An alternative to a Primary Key
D) A key used for SSL connections

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: এক টেবিলের প্রাইমারি কি যখন অন্য টেবিলে রেফারেন্স হিসেবে রাখা হয়, তখন তাকে ফরেন কি (Foreign Key) বলে। এটি দিয়ে রিলেশন তৈরি করা হয়।
</details>

---

**Q29. What is "Polyglot Persistence"?**
A) Translating SQL commands into multiple languages
B) Using only one database for everything
C) The architectural pattern of using multiple different types of databases (SQL, NoSQL, Cache) in a single application to leverage the specific strengths of each
D) Using a database that supports multiple languages

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: রিয়েল ওয়ার্ল্ডে বড় কোম্পানিগুলো কোনো একটি ডাটাবেসের ওপর নির্ভর করে না। পেমেন্টের জন্য SQL, চ্যাটের জন্য MongoDB, ক্যাশের জন্য Redis—এভাবে মিক্স করে ব্যবহার করাকেই Polyglot Persistence বলে।
</details>

---

**Q30. If your startup is building an MVP and you anticipate the data structure to change heavily on a weekly basis, which database type is safer to start with?**
A) SQL (PostgreSQL)
B) NoSQL (MongoDB)
C) A flat CSV file
D) GraphQL

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু স্কিমা বা টেবিলের ডিজাইন ঘন ঘন চেঞ্জ হবে, তাই SQL এ বারবার `ALTER TABLE` করা অনেক ঝামেলার। NoSQL এর ফ্লেক্সিবল স্কিমার কারণে এটি দ্রুত ডেভেলপমেন্টের জন্য বেস্ট।
</details>

---

**Q31. Which standard SQL command is used to add a new column to an existing table?**
A) `UPDATE TABLE table_name ADD column_name;`
B) `MODIFY TABLE table_name INSERT column_name;`
C) `ALTER TABLE table_name ADD column_name datatype;`
D) `CREATE COLUMN column_name IN table_name;`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: টেবিলের স্ট্রাকচার চেঞ্জ করার জন্য SQL এ `ALTER TABLE` কমান্ড ব্যবহার করা হয়।
</details>

---

**Q32. In MongoDB, how do you add a new field to an existing document?**
A) Using the `ALTER` command
B) By using the `updateOne()` method with the `$set` operator
C) By dropping the document and inserting a new one
D) You cannot add new fields once a document is created

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: মঙ্গোডিবিতে `$set` অপারেটর ব্যবহার করে খুব সহজেই যেকোনো ডকুমেন্টে নতুন ফিল্ড অ্যাড বা আপডেট করা যায়।
</details>

---

**Q33. What is the fundamental problem with Vertical Scaling (SQL)?**
A) It makes queries slower
B) It fundamentally alters the database schema
C) It has a hard hardware limit (you can only add so much RAM or CPU to a single motherboard) and it often requires downtime to upgrade
D) It deletes old data

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: একটি পিসির মাদারবোর্ডে র‍্যাম বা প্রসেসর লাগানোর একটি লিমিট থাকে। লিমিট শেষ হলে আর স্কেল করা যায় না। তাছাড়া পার্টস লাগানোর জন্য সার্ভার অফ (Downtime) করতে হয়।
</details>

---

**Q34. Cassandra (a NoSQL database) is famous for what architecture?**
A) Master-Slave architecture
B) A single-node architecture
C) A Masterless Ring architecture (Peer-to-Peer) allowing massive write speeds and high availability without a single point of failure
D) It relies purely on the browser

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ক্যাসান্দ্রাতে কোনো 'মাস্টার' সার্ভার থাকে না। সবগুলো সার্ভার সমান (Peer-to-peer)। তাই যেকোনো সার্ভার ডাউন হলেও পুরো সিস্টেম চলতে থাকে।
</details>

---

**Q35. [Code Logic] If you run `SELECT COUNT(*) FROM users;` in SQL, what is the MongoDB equivalent?**
A) `db.users.count();` (or `db.users.countDocuments({});`)
B) `db.users.find().length;`
C) `db.users.size();`
D) `db.users.aggregate()`;

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: মঙ্গোডিবিতে ডকুমেন্টের সংখ্যা গোনার জন্য `countDocuments()` ফাংশন ব্যবহার করা হয়।
</details>

---

**Q36. Which database allows you to easily enforce strict constraints (e.g., "age must be > 18" or "email must be unique") directly at the database schema level?**
A) MongoDB
B) Redis
C) Relational SQL Databases (like PostgreSQL)
D) Memcached

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: SQL ডাটাবেসগুলো ডাটা ইনটিগ্রিটি (Data Integrity) এবং কনস্ট্রেইন্ট (Constraints) এনফোর্স করার জন্য বেস্ট। (যদিও আধুনিক MongoDB তেও স্কিমা ভ্যালিডেশন দেওয়া যায়, তবে SQL এ এটি কোর ফিচার)।
</details>

---

**Q37. What does "Eventual Consistency" look like in a real-world scenario?**
A) A bank transfer vanishing permanently
B) Commenting on a YouTube video and it showing up instantly for you, but taking 2 seconds to appear for a user in another country
C) A database crashing completely
D) A user being unable to log in

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু ডেটা অনেকগুলো সার্ভারে কপি হতে একটু সময় লাগে (Replication lag), তাই অন্য দেশের সার্ভারে আপডেট যেতে কয়েক সেকেন্ড দেরি হতে পারে। কিন্তু শেষ পর্যন্ত ঠিকই আপডেট হয়ে যায়।
</details>

---

**Q38. What is a "Transaction" in a database?**
A) The process of buying the database software
B) A sequence of operations performed as a single logical unit of work, providing a guarantee of completeness (ACID)
C) Moving data from one table to another permanently
D) Encrypting passwords

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: একাধিক কুয়েরি (যেমন: এক অ্যাকাউন্ট থেকে ব্যালান্স কমানো এবং অন্য অ্যাকাউন্টে ব্যালান্স বাড়ানো) যখন একটি প্যাকেজ হিসেবে কাজ করে, তখন তাকে ট্রানজ্যাকশন বলে।
</details>

---

**Q39. Can NoSQL databases handle Transactions?**
A) No, never
B) Yes, modern NoSQL databases (like MongoDB 4.0+) support multi-document ACID transactions, though they are inherently slower than SQL transactions and should be used sparingly
C) Yes, they are faster at transactions than SQL
D) Only if they use JSON

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: আগে NoSQL এ ট্রানজ্যাকশন ছিল না। কিন্তু এখন মঙ্গোডিবি ট্রানজ্যাকশন সাপোর্ট করে। তবে ডিস্ট্রিবিউটেড সিস্টেম হওয়ায় NoSQL এর ট্রানজ্যাকশন SQL এর মতো ফাস্ট বা এফিশিয়েন্ট হয় না।
</details>

---

**Q40. [Conclusion] If you have tightly related data, need complex joins, and require strict ACID compliance, what is your definite choice?**
A) Document Database (MongoDB)
B) Graph Database (Neo4j)
C) Relational Database (SQL like PostgreSQL/MySQL)
D) Key-Value Store (Redis)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: ডেটার মধ্যে রিলেশন থাকলে, জয়েন কুয়েরি লাগলে এবং 100% গ্যারান্টি (ACID) দরকার হলে চোখ বন্ধ করে SQL ইউজ করতে হবে।
</details>
