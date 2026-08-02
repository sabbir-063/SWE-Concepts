# REST vs GraphQL - Code Implementations

এখানে আমরা দেখবো REST এবং GraphQL-এ একই ডেটা কীভাবে ফেচ করা হয় এবং সার্ভার সাইডে কীভাবে লেখা হয়। (Examples in Node.js / JavaScript).

## 1. Client-Side: Fetching Data

### REST Example
ধরি আমাদের ইউজারের বেসিক ইনফো এবং তার পোস্টগুলো লাগবে। REST-এ আমাদের ২টা রিকোয়েস্ট করতে হবে।

```javascript
// 1. Fetch User
const userResponse = await fetch('https://api.example.com/users/1');
const user = await userResponse.json();

// 2. Fetch Posts for that User
const postsResponse = await fetch(`https://api.example.com/users/1/posts`);
const posts = await postsResponse.json();

// Combine data on the client side
const fullUserData = { ...user, posts };
console.log(fullUserData);
```
*(এখানে under-fetching এর কারণে multiple request করতে হলো।)*

### GraphQL Example
একই ডেটার জন্য GraphQL-এ মাত্র ১টি রিকোয়েস্ট যথেষ্ট, এবং আমরা ঠিক কী ফিল্ড চাই তা বলে দিতে পারি।

```javascript
const query = `
  query GetUserAndPosts($userId: ID!) {
    user(id: $userId) {
      id
      name
      email
      posts {
        title
        content
      }
    }
  }
`;

const response = await fetch('https://api.example.com/graphql', {
  method: 'POST',
  headers: { 'Content-Type': 'application/json' },
  body: JSON.stringify({ 
    query, 
    variables: { userId: "1" } 
  })
});

const result = await response.json();
console.log(result.data.user);
```
*(এখানে `method: 'POST'` ব্যবহার করা হয়েছে এবং আমরা শুধু `id`, `name`, `email` ও `title`, `content` চেয়েছি, অন্য কোনো অপ্রয়োজনীয় ডেটা সার্ভার পাঠাবে না।)*

---

## 2. Server-Side: Routing vs Resolvers

### REST Server (Express.js)
REST-এ আমরা নির্দিষ্ট URL path-এর জন্য নির্দিষ্ট route handler বা controller লিখি।

```javascript
const express = require('express');
const app = express();

// Route for User
app.get('/users/:id', async (req, res) => {
  const user = await db.users.findById(req.params.id);
  // Returns all user fields (Over-fetching possible)
  res.json(user); 
});

// Route for User's Posts
app.get('/users/:id/posts', async (req, res) => {
  const posts = await db.posts.find({ authorId: req.params.id });
  res.json(posts);
});
```

### GraphQL Server (Apollo Server)
GraphQL-এ একটাই URL থাকে। এর বদলে আমরা Schema (Type definitions) এবং Resolvers (ডেটা কীভাবে আনবে) লিখি।

```javascript
const { ApolloServer, gql } = require('apollo-server');

// 1. Schema Definition (Strongly Typed)
const typeDefs = gql`
  type User {
    id: ID!
    name: String!
    email: String!
    posts: [Post!]!
  }

  type Post {
    id: ID!
    title: String!
    content: String!
  }

  type Query {
    user(id: ID!): User
  }
`;

// 2. Resolvers (How to fetch the data)
const resolvers = {
  Query: {
    // Fetches the main user
    user: async (_, { id }) => await db.users.findById(id),
  },
  User: {
    // Resolves the 'posts' field inside a User.
    // This only runs IF the client asked for posts!
    posts: async (parentUser) => {
      return await db.posts.find({ authorId: parentUser.id });
    }
  }
};

const server = new ApolloServer({ typeDefs, resolvers });
```

> 💡 **Notice the efficiency:** 
> GraphQL সার্ভারে `User.posts` resolver-টি তখনই কল হবে, যখন ক্লায়েন্ট তার query-তে `posts` ফিল্ডটি চাইবে। যদি ক্লায়েন্ট শুধু `name` চায়, তাহলে ডাটাবেজ থেকে posts আনার কোনো কোয়েরিই রান হবে না! 
