# 01. SQL vs NoSQL (Code & Queries)

এই ফাইলে আমরা একই অপারেশন SQL (PostgreSQL/MySQL) এবং NoSQL (MongoDB) তে কীভাবে লেখা হয় তা পাশাপাশি তুলনা করে দেখবো। এতে করে Schema এবং Query Syntax এর মূল পার্থক্যগুলো ক্লিয়ার হবে।

---

## 1. Creating the Structure (Schema vs Schemaless)

### SQL: Strict Schema (DDL)
এসকিউএল এ ডেটা ইনসার্ট করার আগেই টেবিলের ডিজাইন (কলামের নাম ও ডাটা টাইপ) ফিক্স করে দিতে হয়।
```sql
-- Creating a User table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    email VARCHAR(100) UNIQUE NOT NULL
);
```

### NoSQL (MongoDB): Dynamic Schema
মঙ্গোডিবি তে আগে থেকে কোনো কালেকশন (টেবিল) তৈরি করতে হয় না। সরাসরি ডেটা পুশ করলেই সে অটোমেটিক কালেকশন বানিয়ে নেয়। কোনো কলাম মিসিং থাকলেও এরর দেয় না।
```javascript
// No need to create a table. Just start inserting documents!
// db.users.insertOne(...) will automatically create the 'users' collection.
```

---

## 2. Inserting Data

### SQL: `INSERT`
```sql
-- Inserting a single row
INSERT INTO users (name, age, email) 
VALUES ('Sabbir', 25, 'sabbir@example.com');
```

### NoSQL: `insertOne` / `insertMany`
JSON (BSON) ফরম্যাটে ডেটা দেওয়া হয়।
```javascript
// Inserting a document (JSON object)
db.users.insertOne({
    name: "Sabbir",
    age: 25,
    email: "sabbir@example.com",
    // NoSQL allowed to add extra fields anytime!
    hobbies: ["coding", "gaming"] 
});
```

---

## 3. Retrieving Data (Queries)

### SQL: `SELECT`
```sql
-- Get all users
SELECT * FROM users;

-- Get user by condition
SELECT name, email FROM users WHERE age > 20 ORDER BY name ASC;
```

### NoSQL: `find`
```javascript
// Get all users
db.users.find({});

// Get user by condition
// 1 means 'true' (include this field), 0 means 'false'
db.users.find(
    { age: { $gt: 20 } }, // Condition
    { name: 1, email: 1, _id: 0 } // Projection (Select)
).sort({ name: 1 }); // Sort Ascending
```

---

## 4. Updating Data

### SQL: `UPDATE`
```sql
UPDATE users 
SET age = 26 
WHERE email = 'sabbir@example.com';
```

### NoSQL: `updateOne`
```javascript
db.users.updateOne(
    { email: "sabbir@example.com" }, // Filter
    { $set: { age: 26 } } // Action
);
```

---

## 5. Handling Relationships (The Biggest Difference)

ধরা যাক, একজন ইউজারের একাধিক "অর্ডার" (Orders) আছে (1-to-Many Relationship)। 

### SQL: Normalized Approach (Using JOIN)
SQL এ ডেটা ভেঙে আলাদা আলাদা টেবিলে রাখা হয় (Normalization) এবং `JOIN` করে ডেটা বের করা হয়।
```sql
-- Table 2: Orders
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    product_name VARCHAR(100),
    amount DECIMAL
);

-- Query to get User and their Orders
SELECT u.name, o.product_name, o.amount
FROM users u
JOIN orders o ON u.id = o.user_id
WHERE u.id = 1;
```

### NoSQL: Denormalized Approach (Embedding/Nesting)
NoSQL এ সাধারণত JOIN করা হয় না। পারফরম্যান্স ফাস্ট করার জন্য ইউজারের ডেটার ভেতরেই তার অর্ডারের ডেটা ঢুকিয়ে দেওয়া হয় (Denormalization)।
```javascript
// The user document inherently contains the orders inside an array!
{
    "_id": ObjectId("5f4e..."),
    "name": "Sabbir",
    "email": "sabbir@example.com",
    "orders": [
        { "product_name": "Laptop", "amount": 1200 },
        { "product_name": "Mouse", "amount": 50 }
    ]
}

// Query is super simple and extremely fast (No JOIN needed!)
db.users.find({ name: "Sabbir" });
```
*Note: মঙ্গোডিবি তে `$lookup` ব্যবহার করে SQL এর মতো JOIN করা যায়, তবে এটি স্লো এবং NoSQL এর বেস্ট প্র্যাকটিস নয়।*

---

## 6. Deleting Data

### SQL: `DELETE`
```sql
DELETE FROM users WHERE age < 18;
```

### NoSQL: `deleteMany`
```javascript
db.users.deleteMany({ age: { $lt: 18 } });
```
