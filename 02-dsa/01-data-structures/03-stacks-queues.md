# 03. Stacks & Queues

## Learning Objectives
- Stack (LIFO) এবং Queue (FIFO) এর বেসিক মেকানিজম বুঝতে পারা।
- Array এবং Linked List দিয়ে কিভাবে এগুলো ইমপ্লিমেন্ট করতে হয় তা জানা।
- Priority Queue এবং Circular Queue এর মত ভেরিয়েশনগুলোর কনসেপ্ট ক্লিয়ার করা।
- ইন্টারভিউতে Stack/Queue রিলেটেড টাইম কমপ্লেক্সিটি এবং এজ কেসগুলো ধরতে পারা।

## Core Concept

### Stack
Stack হলো এমন একটি ডেটা স্ট্রাকচার যা **LIFO (Last In, First Out)** নীতি মেনে চলে। অর্থাৎ, যে ডেটা সবার শেষে ঢোকানো হবে, সেটিই সবার আগে বের হবে।
**অ্যানালজি:** বিয়ের বাড়ির প্লেটের স্তূপের (stack of plates) কথা ভাবুন। ওয়েটার সবার শেষে যে প্লেটটি স্তূপের উপরে রাখে, গেস্টরা খাবার নেওয়ার সময় সবার আগে সেই ওপরের প্লেটটিই টেনে নেয়। 

Stack-এর মূল অপারেশনগুলো হলো:
- `push()`: আইটেম এড করা।
- `pop()`: ওপর থেকে আইটেম রিমুভ করা এবং রিটার্ন করা।
- `peek()` / `top()`: ওপরের আইটেমটি শুধু দেখা (রিমুভ না করে)।

> **Interview/MCQ Angle:** MCQ-তে প্রায়ই জিজ্ঞেস করে Recursion বা Function Call ইন্টার্নালি কীভাবে কাজ করে। উত্তর হলো: OS লেভেলে Stack ডেটা স্ট্রাকচার (Call Stack) ব্যবহার করে। তাছাড়া ব্রাউজারের "Back" বাটন বা যেকোনো "Undo" ফিচার Stack দিয়েই তৈরি হয়।

### Queue
Queue হলো এমন একটি ডেটা স্ট্রাকচার যা **FIFO (First In, First Out)** নীতি মেনে চলে। অর্থাৎ, যে সবার আগে আসবে, সে সবার আগে সার্ভিস পাবে।
**অ্যানালজি:** টিকিট কাউন্টারের লাইনের কথা ভাবুন। যে ব্যক্তি সবার আগে লাইনে দাঁড়াবে, সে সবার আগে টিকিট পাবে এবং লাইন থেকে বের হয়ে যাবে।

Queue-এর মূল অপারেশনগুলো হলো:
- `enqueue()` / `offer()`: লাইনের পেছনে আইটেম এড করা।
- `dequeue()` / `poll()`: লাইনের সামনে থেকে আইটেম রিমুভ করা এবং রিটার্ন করা।
- `peek()` / `front()`: সামনের আইটেমটি শুধু দেখা।

> **Interview/MCQ Angle:** BFS (Breadth-First Search) অ্যালগরিদমে কোন ডেটা স্ট্রাকচার লাগে? উত্তর: Queue। তাছাড়া OS-এ টাস্ক শিডিউলিং (যেমন প্রিন্টারের জেনারেটেড টাস্ক) Queue দিয়ে মেইনটেইন করা হয়।

## Deep Dive / Gotchas

- **Time Complexity:** Stack এবং Queue-তে `push`, `pop`, `enqueue`, `dequeue` সবগুলোর টাইম কমপ্লেক্সিটি **O(1)** হওয়া উচিত। যদি আপনার ইমপ্লিমেন্টেশনে কোনো অপারেশনে O(N) সময় লাগে, তবে সেটি এফিশিয়েন্ট হয়নি।
- **Array vs Linked List Implementation:** 
  - Array দিয়ে Stack বানালে সাইজ ফিক্সড থাকে, ফুল হয়ে গেলে "Stack Overflow" হতে পারে। তবে ডাইনামিক অ্যারে (যেমন ArrayList) ব্যবহার করলে সাইজ রিলোকেশনের সময় সাময়িক O(N) সময় লাগতে পারে। 
  - Queue যদি সাধারণ Array দিয়ে বানান, তাহলে সামনে থেকে ডিলিট করলে বাকি সব এলিমেন্টকে বামে সরাতে হবে যা O(N) সময় নিবে। তাই Array দিয়ে Queue বানালে অবশ্যই **Circular Queue** এপ্রোচ বা দুটি পয়েন্টার (`head` ও `tail`) ব্যবহার করতে হয় যেন `dequeue` O(1) হয়। 
- **Double Ended Queue (Deque):** এটি এমন একটি Queue যেখানে সামনে বা পেছনে—দুই দিক থেকেই আইটেম এড বা রিমুভ করা যায়। জাভাতে `ArrayDeque` হলো Stack এবং Queue উভয়ের জন্যই একটি স্ট্যান্ডার্ড এবং ফাস্ট ইমপ্লিমেন্টেশন।
- **Priority Queue:** সাধারণ Queue তে ফার্স্ট-ইন ফার্স্ট-আউট হয়, কিন্তু Priority Queue তে প্রতিটি আইটেমের একটি প্রায়োরিটি থাকে। যে আইটেমের প্রায়োরিটি সবচেয়ে বেশি, সে সবার আগে বের হয় (আগে আসুক বা পরে আসুক)। এটি ইন্টার্নালি Heap দিয়ে তৈরি হয় (Heap অধ্যায়ে বিস্তারিত থাকবে)।

## Code Example(s)

জাভাতে Stack এবং Queue ব্যবহারের একটি বেসিক উদাহরণ:

```java
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class StackQueueExample {
    public static void main(String[] args) {
        // --- STACK (LIFO) ---
        // জাভাতে পুরোনো Stack ক্লাসের বদলে ArrayDeque ব্যবহার করা রেকমেন্ডেড (ফাস্টার)
        Deque<Integer> stack = new ArrayDeque<>();
        
        stack.push(10); // 10
        stack.push(20); // 20, 10
        stack.push(30); // 30, 20, 10
        
        System.out.println("Stack Top: " + stack.peek()); // 30
        System.out.println("Popped: " + stack.pop());     // 30 রিমুভ হবে
        
        // --- QUEUE (FIFO) ---
        // Queue একটি ইন্টারফেস, তাই LinkedList বা ArrayDeque দিয়ে অবজেক্ট বানাতে হয়
        Queue<String> queue = new LinkedList<>();
        
        queue.offer("Alice"); // Alice
        queue.offer("Bob");   // Alice, Bob
        queue.offer("Charlie"); // Alice, Bob, Charlie
        
        System.out.println("Queue Front: " + queue.peek()); // Alice
        // poll() প্রথম আইটেম রিমুভ করে এবং রিটার্ন করে। লিস্ট খালি হলে null দেয়।
        System.out.println("Dequeued: " + queue.poll());    // Alice রিমুভ হবে
    }
}
```
*নোট: জাভাতে `java.util.Stack` ক্লাসটি থ্রেড-সেফ (Vector এক্সটেন্ড করে), তাই সিঙ্গল-থ্রেডেড কাজে এটি একটু স্লো। মডার্ন জাভাতে `ArrayDeque` কে স্ট্যাক হিসেবে ব্যবহার করা বেস্ট প্র্যাকটিস।*

## Diagram

```mermaid
graph TD
    subgraph STACK (LIFO)
        S_Top[Top] --> S_30[30]
        S_30 --> S_20[20]
        S_20 --> S_10[10]
        S_Push((Push)) --> S_Top
        S_Top --> S_Pop((Pop))
    end

    subgraph QUEUE (FIFO)
        Q_In((Enqueue)) --> Q_Rear[Rear: Charlie]
        Q_Rear -.-> Q_Mid[Bob] -.-> Q_Front[Front: Alice]
        Q_Front --> Q_Out((Dequeue))
    end
```

## Quick Recap
- **Stack:** LIFO. Operations: `push()`, `pop()`, `peek()`. Used in function calls, undo features.
- **Queue:** FIFO. Operations: `enqueue()`, `dequeue()`, `peek()`. Used in BFS, scheduling.
- **Complexity:** Insert/Delete should be O(1) in both.
- **Java Tip:** Use `ArrayDeque` for Stack, and `LinkedList` or `ArrayDeque` for Queue. 

## Practice MCQs (20 Questions)

**Q1. Stack ডেটা স্ট্রাকচার কোন নীতি ফলো করে?**
A) FIFO (First In, First Out)
B) LIFO (Last In, First Out)
C) FILO (First In, Last Out)
D) B এবং C উভয়েই

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**

স্ট্যাক LIFO (Last In First Out) মেনে চলে, যার মানে হলো সবার শেষেরটা সবার আগে বের হয়। আর FILO (First In Last Out) মানে সবার প্রথমেরটা সবার শেষে বের হয়। লজিক্যালি এই দুটি একই জিনিস বোঝায়!
</details>

---

**Q2. নিচের কোন অ্যাপ্লিকেশনে Queue ডেটা স্ট্রাকচার ব্যবহৃত হয়?**
A) ব্রাউজারের হিস্ট্রি (Back/Forward)
B) রিকার্সিভ ফাংশন কল ট্র্যাকিং
C) প্রিন্টারের টাস্ক শিডিউলিং
D) আনডু (Undo) অপারেশন

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

প্রিন্টারে যে টাস্ক সবার আগে দেওয়া হয়, সেটিই আগে প্রিন্ট হয়, যা Queue (FIFO) এর ক্লাসিক উদাহরণ। বাকি ৩টি (A, B, D) Stack-এর উদাহরণ।
</details>

---

**Q3. একটি এমপ্টি Stack-এ পর্যায়ক্রমে 1, 2, 3 পুশ (push) করা হলো। তারপর পরপর দুবার পপ (pop) করা হলো। এখন Stack-এর টপে (top) কোন এলিমেন্টটি আছে?**
A) 1
B) 2
C) 3
D) Stack is empty

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**

পুশ: 1 (top: 1) -> 2 (top: 2) -> 3 (top: 3).
১ম পপ: 3 রিমুভ হলো, top এখন 2.
২য় পপ: 2 রিমুভ হলো, top এখন 1.
</details>

---

**Q4. একটি Queue তে `enqueue` ও `dequeue` অপারেশনের আইডিয়াল টাইম কমপ্লেক্সিটি কত?**
A) O(1), O(N)
B) O(N), O(1)
C) O(1), O(1)
D) O(N), O(N)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Queue তে নতুন আইটেম পেছনে যুক্ত করা এবং সামনে থেকে সরানো—উভয় কাজই O(1) টাইমে হওয়া উচিত।
</details>

---

**Q5. জাভাতে Stack এর বদলে সাধারণত কোন ক্লাসটি ব্যবহার করতে রেকমেন্ড করা হয়?**
A) Vector
B) ArrayList
C) PriorityQueue
D) ArrayDeque

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**

`java.util.Stack` লিগ্যাসি ক্লাস যা সিঙ্ক্রোনাইজড হওয়ায় স্লো। সিঙ্গল থ্রেডেড কাজের জন্য `Deque` ইন্টারফেসের ইমপ্লিমেন্টেশন `ArrayDeque` ব্যবহার করা সবচেয়ে ফাস্ট।
</details>

---

**Q6. সাধারণ Array দিয়ে Queue তৈরি করলে প্রধান সমস্যাটি কী হতে পারে?**
A) মেমরি লিক হওয়া
B) `dequeue` করার পর বাকি এলিমেন্টগুলোকে বামে সরাতে O(N) সময় লাগা
C) `enqueue` করতে O(N) সময় লাগা
D) এটি কখনোই ইমপ্লিমেন্ট করা সম্ভব নয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

অ্যারের ইনডেক্স ০ থেকে যদি কেউ বের হয়ে যায়, তাহলে 1, 2, 3 ইনডেক্সের ভ্যালুগুলোকে 0, 1, 2 তে শিফট করতে হয়। এর ফলে `dequeue` O(N) হয়ে যায়। Circular Queue ব্যবহার করে এই সমস্যা সমাধান করা হয়।
</details>

---

**Q7. Circular Queue-তে `front` এবং `rear` পয়েন্টার দুটি যদি সমান হয়ে যায় (প্রাথমিক অবস্থা ছাড়া), তার মানে কী?**
A) Queue এমপ্টি (Empty)
B) Queue ফুল (Full)
C) Queue তে একটিমাত্র এলিমেন্ট আছে
D) A অথবা B

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**

ইমপ্লিমেন্টেশনের ওপর ভিত্তি করে, `front == rear` মানে Queue পুরোপুরি খালি হতে পারে, আবার পুরোপুরি ভর্তিও হতে পারে (তাই সাইজ ট্র্যাক করতে আরেকটি ভেরিয়েবল বা বিশেষ কন্ডিশন লাগে)।
⚠️ Common trap: অনেকেই ভাবে এটা শুধু Empty বোঝায়।
</details>

---

**Q8. নিচের কোডটির আউটপুট কী হবে?**
```java
Queue<Integer> q = new LinkedList<>();
q.offer(10);
q.offer(20);
System.out.println(q.peek());
System.out.println(q.poll());
System.out.println(q.peek());
```
A) 10, 10, 20
B) 20, 10, 20
C) 10, 20, 10
D) 20, 20, 10

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**

`peek()` প্রথম এলিমেন্টটি দেখায় কিন্তু মুছবে না, তাই প্রিন্ট হবে 10।
`poll()` প্রথম এলিমেন্টটি দেখাবে এবং মুছে ফেলবে, তাই প্রিন্ট হবে 10। এখন Queue তে আছে শুধু 20।
পরের `peek()` নতুন প্রথম এলিমেন্ট দেখাবে, তাই প্রিন্ট হবে 20।
</details>

---

**Q9. BFS (Breadth-First Search) অ্যালগরিদমে কোন ডেটা স্ট্রাকচার অপরিহার্য?**
A) Stack
B) Queue
C) Priority Queue
D) Array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

BFS লেভেল-বাই-লেভেল ট্রাভার্স করে, যার জন্য সবার আগে পাওয়া নোডগুলোকে আগে প্রোসেস করতে হয় (FIFO)। তাই Queue ব্যবহার করা হয়।
</details>

---

**Q10. DFS (Depth-First Search) ইমপ্লিমেন্ট করতে নিচের কোনটি লাগে?**
A) Queue
B) Priority Queue
C) Stack
D) Linked List

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

DFS রিকার্সন দিয়ে ইমপ্লিমেন্ট করা যায় (যা ইন্টার্নালি কল স্ট্যাক ব্যবহার করে) অথবা ম্যানুয়ালি Stack ব্যবহার করে ইমপ্লিমেন্ট করা যায় (LIFO)।
</details>

---

**Q11. Deque (Double Ended Queue) এর বৈশিষ্ট্য কী?**
A) এটি শুধুমাত্র দুই প্রান্ত দিয়ে পুশ করতে পারে
B) এতে শুধুমাত্র ইনসার্ট করা যায়, ডিলিট করা যায় না
C) এর উভয় প্রান্ত (front এবং rear) দিয়ে ইনসার্ট এবং ডিলিট করা যায়
D) এটি Queue এবং Stack এর মিশ্রণ নয়

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Deque-তে `addFirst`, `addLast`, `removeFirst`, `removeLast`—এই চারটি অপারেশনই করা যায়।
</details>

---

**Q12. Priority Queue তে ডিফল্টভাবে জাভাতে এলিমেন্টগুলো কীভাবে রিমুভ হয়?**
A) FIFO অর্ডারে
B) LIFO অর্ডারে
C) ছোট থেকে বড় অর্ডারে (Min-Heap)
D) বড় থেকে ছোট অর্ডারে (Max-Heap)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

জাভার `PriorityQueue` ডিফল্টভাবে Min-Heap হিসেবে কাজ করে, অর্থাৎ যার ভ্যালু সবচেয়ে ছোট সেটি সবার আগে রিমুভ হয়।
</details>

---

**Q13. একটি Stack-এ যদি 5 টি এলিমেন্ট থাকে এবং আপনি 6 বার `pop()` কল করেন (জাভার `java.util.Stack` ব্যবহার করে), তাহলে কী ঘটবে?**
A) null রিটার্ন করবে
B) -1 রিটার্ন করবে
C) EmptyStackException থ্রো করবে
D) কোড ক্র্যাশ না করেই রান করবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

`java.util.Stack` ক্লাস এমপ্টি থাকা অবস্থায় পপ করলে `EmptyStackException` দেয়। (তবে Queue এর `poll()` মেথড এমপ্টি অবস্থায় null দেয়)।
</details>

---

**Q14. দুটি Queue ব্যবহার করে একটি Stack ইমপ্লিমেন্ট করার সময় `push` অপারেশনকে O(1) রাখলে, `pop` অপারেশনের টাইম কমপ্লেক্সিটি কত হবে?**
A) O(1)
B) O(log N)
C) O(N)
D) O(N^2)

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

যদি push O(1) হয়, তাহলে pop করার সময় শেষের এলিমেন্টটি পাওয়ার জন্য Q1 থেকে (N-1) টি এলিমেন্ট Q2 তে সরাতে হবে, যা O(N) সময় নিবে।
</details>

---

**Q15. একটি স্ট্রিংকে রিভার্স (Reverse) করার জন্য সবচেয়ে উপযুক্ত ডেটা স্ট্রাকচার কোনটি?**
A) Queue
B) Stack
C) Hash Table
D) Graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

স্ট্রিংয়ের ক্যারেক্টারগুলো একে একে Stack এ পুশ করে, তারপর পপ করলে সেগুলো রিভার্স অর্ডারে বের হয়ে আসবে। LIFO এর পারফেক্ট ইউজ কেস।
</details>

---

**Q16. "Expression Evaluation" বা Mathematical Expression (যেমন: Postfix/Prefix) সলভ করতে ইন্টার্নালি কোনটি ব্যবহৃত হয়?**
A) Queue
B) Binary Search Tree
C) Stack
D) Linked List

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

অপারেন্ড এবং অপারেটর মেইনটেইন করার জন্য Stack ব্যবহার করা হয় (যেমন: Shunting-yard algorithm)।
</details>

---

**Q17. একটি singly linked list দিয়ে Queue বানাতে হলে `enqueue` এবং `dequeue` এর জন্য `head` ও `tail` পয়েন্টার কিভাবে ব্যবহার করতে হবে?**
A) `enqueue` at head, `dequeue` at tail
B) `enqueue` at tail, `dequeue` at head
C) `enqueue` at head, `dequeue` at head
D) যেকোনো একটি করলেই হবে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Singly linked list এ tail থেকে ডিলিট করা O(N) কারণ tail এর আগের নোডটি জানা থাকোসহজভাবে পাওয়া যায় না। তাই `dequeue` সবসময় head থেকে করা উচিত (O(1)) এবং `enqueue` tail-এ করা উচিত (O(1))।
⚠️ Common trap: A সিলেক্ট করলে `dequeue` O(N) হয়ে যাবে।
</details>

---

**Q18. নিচের কোনটিকে "Fair" (ন্যায়সঙ্গত) ডেটা স্ট্রাকচার বলা যায়?**
A) Stack
B) Queue
C) Tree
D) Heap

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Queue ফার্স্ট-ইন ফার্স্ট-আউট নীতি মেনে চলে, যা সবার আগে আসাকে প্রাধান্য দেয় (লাইনের মতো)। তাই এটিকে ফেয়ার বলা হয়।
</details>

---

**Q19. জাভাতে Queue ইন্টারফেসের মেথড `add()` এবং `offer()` এর মধ্যে পার্থক্য কী?**
A) `offer()` এক্সেপশন থ্রো করে, `add()` করে না
B) কোনো পার্থক্য নেই
C) Queue ফুল হলে `add()` এক্সেপশন থ্রো করে, কিন্তু `offer()` false রিটার্ন করে
D) `add()` পেছনে যুক্ত করে, `offer()` সামনে যুক্ত করে

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

ক্যাপাসিটি রেস্ট্রিক্টেড Queue তে ডেটা ঢোকাতে না পারলে `add()` `IllegalStateException` থ্রো করে, অন্যদিকে `offer()` সুন্দরভাবে `false` রিটার্ন করে।
</details>

---

**Q20. [Advanced] দুটি Stack (Stack1 এবং Stack2) ব্যবহার করে একটি Queue বানালে, `dequeue` করার লজিক কোনটি?**
A) Stack1 থেকে সরাসরি পপ করা
B) Stack1 থেকে সব এলিমেন্ট Stack2 তে ঢেলে, তারপর Stack2 থেকে পপ করা (যদি Stack2 খালি থাকে)
C) Stack2 তে সবসময় পুশ করা এবং পপ করা
D) Stack1 এর টপ এলিমেন্টটি রিটার্ন করা

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Queue-এর বৈশিষ্ট্য পেতে Stack1 (In-stack) এ সব ইনসার্ট করা হয়। ডিলিট বা `dequeue` করার সময় Stack2 (Out-stack) থেকে পপ করা হয়। Stack2 খালি থাকলে, Stack1 এর সব পপ করে Stack2 তে পুশ করা হয় (এতে অর্ডার রিভার্স হয়ে Queue এর মতো FIFO আচরণ করে)।
</details>
