# REST vs GraphQL - MCQs

**Q1. Which of the following best describes the "Over-fetching" problem in REST APIs?**
A) The client receives a 429 Too Many Requests status code.
B) The server returns more data than the client actually needs for a specific view.
C) The client makes too many requests to fetch related data.
D) The server crashes due to too many simultaneous connections.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
যখন একটি endpoint থেকে ক্লায়েন্টের প্রয়োজনের তুলনায় অনেক বেশি ফিল্ড বা ডেটা চলে আসে, তখন তাকে Over-fetching বলে। এটি ব্যান্ডউইথ নষ্ট করে। C হলো Under-fetching এর বৈশিষ্ট্য।
</details>

**Q2. Which HTTP method is most commonly used by default for all GraphQL requests (both reading and writing data)?**
A) GET
B) POST
C) PUT
D) GRAPHQL

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
GraphQL সাধারণত সব রিকোয়েস্টের জন্য `POST` ব্যবহার করে, কারণ এতে রিকোয়েস্ট বডিতে লম্বা query বা mutation string পাঠানো সহজ হয়। 
</details>

**Q3. In the context of APIs, what is the N+1 problem?**
A) Adding one more server to a load balancer setup.
B) A versioning issue where v(N) is incompatible with v(N+1).
C) Executing one query to fetch a list of items, and then N additional queries to fetch related data for each item.
D) A security vulnerability in GraphQL where depth limits are exceeded.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
N+1 problem হলো ডাটাবেজ বা API ফেচিংয়ের একটি পারফরম্যান্স ইস্যু, যেখানে ১টি রিকোয়েস্টে N সংখ্যক আইটেম আনা হয়, এবং তারপর প্রতিটা আইটেমের জন্য আবার আলাদা করে ১টি করে (মোট Nটি) রিকোয়েস্ট করা হয়।
</details>

**Q4. How does GraphQL natively solve the under-fetching problem commonly found in REST?**
A) By caching all responses in the browser.
B) By automatically sending push notifications to the client.
C) By allowing the client to specify a nested query to retrieve all related data in a single request.
D) By returning every column of a database table by default.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
GraphQL ক্লায়েন্টকে ফ্লেক্সিবিলিটি দেয় যেন সে একটিমাত্র রিকোয়েস্টেই নেস্টেড রিলেশনশিপ (যেমন: User এবং তার Posts) চেয়ে নিতে পারে। ফলে মাল্টিপল রাউন্ড-ট্রিপ (under-fetching) লাগে না।
</details>

**Q5. Which architecture relies heavily on standard HTTP methods (GET, POST, PUT, DELETE) and HTTP status codes to communicate intent and state?**
A) GraphQL
B) SOAP
C) REST
D) gRPC

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
REST পুরোপুরি HTTP স্ট্যান্ডার্ডের ওপর ভিত্তি করে তৈরি। এটি CRUD অপারেশনের জন্য GET, POST, PUT, DELETE ব্যবহার করে এবং স্ট্যাটাস কোড (200, 404, 500) দিয়ে ফলাফল জানায়।
</details>

**Q6. Which API approach natively supports built-in HTTP caching mechanisms (like CDNs, ETag, Cache-Control) out of the box?**
A) GraphQL
B) WebSockets
C) gRPC
D) REST

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
REST API সাধারণত GET রিকোয়েস্ট এবং ইউনিক URL ব্যবহার করে, যা CDN এবং ব্রাউজার খুব সহজেই ক্যাশ করতে পারে। GraphQL-এ প্রায় সবই POST রিকোয়েস্ট হওয়ায় HTTP লেভেল ক্যাশিং কাজ করে না।
</details>

**Q7. In GraphQL, what is a "Resolver"?**
A) A tool that resolves merge conflicts in the API versioning.
B) A function responsible for populating the data for a single field in the schema.
C) A middleware that authenticates the user before a query runs.
D) A built-in database ORM provided by GraphQL.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
Resolver হলো সার্ভার সাইডের একটি ফাংশন, যা নির্ধারণ করে GraphQL স্কিমার একটি নির্দিষ্ট ফিল্ডের ডেটা কোথা থেকে (Database, API, etc.) এবং কীভাবে আসবে।
</details>

**Q8. Why is rate limiting generally considered more complex to implement in GraphQL compared to REST?**
A) GraphQL does not support IP addresses.
B) GraphQL uses UDP instead of TCP.
C) A single GraphQL request to one endpoint can contain a deeply nested query asking for massive amounts of data.
D) GraphQL servers cannot use middleware.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
REST-এ আপনি endpoint-এর কল সংখ্যার উপর লিমিট বসাতে পারেন। কিন্তু GraphQL-এ ১টি কলের ভেতরেই ক্লায়েন্ট চাইলে হাজারটা নেস্টেড ডেটা চাইতে পারে, তাই শুধু রিকোয়েস্ট কাউন্ট করে রেট লিমিট করা যায় না। Query complexity বা depth মেপে লিমিট করতে হয়।
</details>

**Q9. Which of the following is true about Versioning in GraphQL vs REST?**
A) GraphQL requires strict versioning (e.g., /v1/graphql, /v2/graphql).
B) REST APIs never need versioning.
C) GraphQL is often considered "versionless" because you can simply add new fields and deprecate old ones without breaking existing clients.
D) REST APIs deprecate fields automatically.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
GraphQL-এ ক্লায়েন্ট কেবল তার প্রয়োজনীয় ফিল্ডগুলোই চায়। তাই সার্ভারে নতুন ফিল্ড যোগ করলে পুরনো ক্লায়েন্টের কোনো সমস্যা হয় না। পুরনো ফিল্ড `@deprecated` দিয়ে মার্ক করে রাখা যায়। তাই এটি মূলত versionless.
</details>

**Q10. You are building a public API for a highly cacheable resource (e.g., weather data by city) that will be accessed by millions of web clients globally. Which API style is technically better suited for leveraging Edge CDNs?**
A) GraphQL
B) REST
C) SOAP
D) Webhook

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
REST-এ `GET /weather/dhaka` এর মতো রিকোয়েস্ট করা হয়, যা CDN (Cloudflare, Akamai) খুব সহজে ক্যাশ করে রাখতে পারে। GraphQL-এ এটি POST রিকোয়েস্ট হওয়ায় CDN ক্যাশিং কঠিন।
</details>

**Q11. What is the role of Schema Definition Language (SDL) in GraphQL?**
A) It writes SQL queries automatically.
B) It defines the shape of the data, types, queries, and mutations available in the API.
C) It serves as a CSS stylesheet for the API documentation.
D) It encrypts the payload over HTTP.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
SDL বা Schema হলো GraphQL-এর চুক্তি (contract)। এটি সার্ভার এবং ক্লায়েন্টকে বলে দেয় যে কী কী টাইপের ডেটা এভেইলেবল আছে এবং কী কী কুয়েরি বা মিউটেশন করা যাবে।
</details>

**Q12. In REST, if you want to update only a specific field of a resource (e.g., just the email of a user), which HTTP method is most semantically correct?**
A) GET
B) PUT
C) PATCH
D) POST

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
`PATCH` ব্যবহৃত হয় আংশিক আপডেট (partial update) করার জন্য। `PUT` ব্যবহৃত হয় সম্পূর্ণ রিসোর্সটি রিপ্লেস করার জন্য।
</details>

**Q13. In GraphQL, how do you modify or insert data on the server?**
A) Using a Query with a PUT method.
B) Using a Mutation.
C) Using a Subscription.
D) Using a Resolver function directly from the client.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
GraphQL-এ ডেটা রিড করার জন্য `Query` এবং ডেটা রাইট/আপডেট/ডিলিট করার জন্য `Mutation` ব্যবহার করা হয়।
</details>

**Q14. Which popular utility/library is commonly used in Node.js GraphQL servers to solve the N+1 database querying problem by batching and caching requests?**
A) Redux
B) DataLoader
C) Axios
D) Webpack

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
DataLoader একটি ইউটিলিটি যা Facebook তৈরি করেছে। এটি একই ইভেন্ট লুপের মধ্যে আসা ডাটাবেজ রিকোয়েস্টগুলোকে ব্যাচ (batch) করে একটিমাত্র কুয়েরিতে রূপান্তর করে N+1 প্রবলেম সলভ করে।
</details>

**Q15. An API returns this payload: `{ "id": 1, "name": "John" }` along with a status code of `201 Created`. This is indicative of which API style?**
A) GraphQL
B) REST
C) Both A and B
D) Neither

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
REST HTTP স্ট্যাটাস কোড (যেমন 201 Created) এর উপর ব্যাপকভাবে নির্ভরশীল। GraphQL সফল বা ব্যর্থ সব রিকোয়েস্টেই সাধারণত 200 OK রিটার্ন করে এবং বডিতে এরর মেসেজ দিয়ে দেয়।
</details>

**Q16. If a GraphQL query fails due to a validation error in one of the fields, what HTTP status code does the server typically return?**
A) 400 Bad Request
B) 404 Not Found
C) 200 OK
D) 500 Internal Server Error

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
⚠️ **Common trap:** GraphQL সাধারণত নেটওয়ার্ক লেভেলে রিকোয়েস্ট সফল হলে HTTP 200 OK-ই রিটার্ন করে, এমনকি যদি কুয়েরিতে কোনো এরর থাকে তবুও। এররগুলো JSON রেসপন্সের `errors` অ্যারের ভেতরে পাঠানো হয়।
</details>

**Q17. Which of the following scenarios is a perfect use case for choosing GraphQL over REST?**
A) A simple microservice that only returns the current time.
B) An application requiring strict HTTP-level CDN caching for media files.
C) A mobile app with strict bandwidth limitations that needs to fetch aggregated data from multiple microservices.
D) A legacy system where the client developers prefer standard URLs and HTTP status codes.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
মোবাইল অ্যাপে ব্যান্ডউইথ বাঁচানো খুব জরুরি (Over-fetching রোধ করা)। মাল্টিপল মাইক্রোসার্ভিস থেকে ডেটা এগ্রিগেট করার জন্য GraphQL API Gateway খুব ভালো কাজ করে।
</details>

**Q18. Consider the following REST endpoints: `/authors/1` and `/authors/1/books`. To get an author and their books, a client makes two requests. What is this an example of?**
A) Over-fetching
B) Under-fetching
C) Load Balancing
D) Schema Definition

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
যেহেতু প্রথম রিকোয়েস্টে ক্লায়েন্টের কাঙ্ক্ষিত সব ডেটা আসেনি এবং তাকে আবার রিকোয়েস্ট করতে হয়েছে, তাই একে Under-fetching বলে। 
</details>

**Q19. (Code Snippet) What is the fundamental issue with the following GraphQL resolver implementation for `User.posts` if 50 users are queried?**
```javascript
const resolvers = {
  User: {
    posts: async (parent) => {
      // Runs a SQL query for EVERY user separately
      return await db.query(`SELECT * FROM posts WHERE userId = ${parent.id}`);
    }
  }
}
```
A) It will cause an over-fetching problem on the client side.
B) It will trigger the N+1 problem on the server side.
C) It uses a GET request instead of POST.
D) It violates the REST specification.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
যদি আমরা ৫০ জন ইউজারের লিস্ট চাই, তবে মেইন ইউজারের জন্য ১টি ডাটাবেজ কুয়েরি হবে, এবং এই `posts` রিযলভারটি ৫০ বার কল হবে (৫০টি আলাদা SQL কুয়েরি রান হবে)। এটি ক্লাসিক সার্ভার-সাইড N+1 প্রবলেম। এটি DataLoader দিয়ে সলভ করতে হয়।
</details>

**Q20. In REST, HATEOAS (Hypermedia As The Engine Of Application State) means:**
A) The server sends executable JavaScript to the client.
B) The API responses include hypermedia links to indicate dynamically what actions the client can perform next.
C) The client must send a hypermedia token to authenticate.
D) The API uses GraphQL underneath.

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
HATEOAS হলো REST-এর সবচেয়ে অ্যাডভান্সড লেভেল (Richardson Maturity Model Level 3), যেখানে রেসপন্সের ভেতরেই লিঙ্ক দেওয়া থাকে যে এরপর ওই রিসোর্সের সাথে কী কী করা যাবে। 
</details>
