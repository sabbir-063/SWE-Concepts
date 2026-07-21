# Using ArrayDeque as a Queue in Java

জাভাতে `Queue` একটি ইন্টারফেস। একে ইমপ্লিমেন্ট করার জন্য আমরা সাধারণত দুটি ক্লাস ব্যবহার করি:
১. `LinkedList`
২. `ArrayDeque`

মডার্ন জাভাতে **`ArrayDeque`** ব্যবহার করাকে `LinkedList` এর চেয়ে বেশি রেকমেন্ড করা হয়, কারণ `ArrayDeque` ইন্টার্নালি একটি রিসিজেবল অ্যারে (Resizable Array / Circular Buffer) ব্যবহার করে, ফলে ক্যাশ লোকালিটি (Cache Locality) ভালো হয় এবং এটি `LinkedList` এর (যাতে প্রতি নোডের জন্য আলাদা অবজেক্ট তৈরি করতে হয়) চেয়ে অনেক ফাস্ট।

## Queue-এর মেথড বনাম Deque-এর মেথড

যেহেতু `ArrayDeque` একটি Deque (Double Ended Queue), এতে দুই প্রান্তেই ডেটা ইনসার্ট/ডিলিট করা যায়। কিন্তু একে যখন আমরা স্ট্যান্ডার্ড **Queue (FIFO - First In, First Out)** হিসেবে ব্যবহার করব, তখন আমরা মূলত Queue ইন্টারফেসের মেথডগুলোই কল করব:

- **Enqueue (পিছনে এড করা):** `offer(element)` অথবা `add(element)`
- **Dequeue (সামনে থেকে রিমুভ করা):** `poll()` অথবা `remove()`
- **Peek (সামনের আইটেম দেখা):** `peek()` অথবা `element()`

*(বি.দ্র: `offer`, `poll`, `peek` ব্যবহার করা ভালো কারণ এগুলো এক্সেপশন থ্রো করার বদলে যথাক্রমে false বা null রিটার্ন করে)।*

## Java Code Example

নিচে `ArrayDeque` কে Queue হিসেবে ব্যবহার করার একটি পূর্ণাঙ্গ উদাহরণ দেওয়া হলো:

```java
import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeAsQueue {
    public static void main(String[] args) {
        
        // ArrayDeque কে Queue ইন্টারফেসের রেফারেন্সে ডিক্লেয়ার করা হলো
        Queue<String> queue = new ArrayDeque<>();
        
        System.out.println("--- Enqueue Operations ---");
        // offer() মেথড দিয়ে লাইনের পেছনে (Rear) ডেটা ইনসার্ট করা হয়
        queue.offer("Customer 1: Alice");
        queue.offer("Customer 2: Bob");
        queue.offer("Customer 3: Charlie");
        
        // বর্তমান কিউ দেখা
        System.out.println("Current Queue: " + queue);
        
        System.out.println("\n--- Peek Operation ---");
        // peek() মেথড প্রথম জনকে দেখায়, কিন্তু রিমুভ করে না
        System.out.println("Next in line (Peek): " + queue.peek());
        
        System.out.println("\n--- Dequeue Operations ---");
        // poll() মেথড লাইনের সামনের (Front) জনকে রিমুভ করে এবং রিটার্ন করে
        String servedCustomer = queue.poll(); 
        System.out.println("Served: " + servedCustomer);
        
        System.out.println("Queue after serving 1 customer: " + queue);
        
        // আরও একজনকে সার্ভ করা হলো
        System.out.println("Served: " + queue.poll());
        
        System.out.println("Final Queue state: " + queue);
    }
}
```

### আউটপুট:
```text
--- Enqueue Operations ---
Current Queue: [Customer 1: Alice, Customer 2: Bob, Customer 3: Charlie]

--- Peek Operation ---
Next in line (Peek): Customer 1: Alice

--- Dequeue Operations ---
Served: Customer 1: Alice
Queue after serving 1 customer: [Customer 2: Bob, Customer 3: Charlie]
Served: Customer 2: Bob
Final Queue state: [Customer 3: Charlie]
```

## কেন ArrayDeque ফাস্টার?
1. **No Node Allocation:** `LinkedList` এর মতো প্রতিবার নতুন আইটেম এড করার সময় নতুন অবজেক্ট (`Node`) মেমোরিতে তৈরি করতে হয় না। `ArrayDeque` একটি ব্যাকএন্ড অ্যারে মেইনটেইন করে।
2. **CPU Cache Locality:** অ্যারের ডেটা মেমোরিতে পাশাপাশি (contiguous) থাকে, তাই CPU Cache থেকে ডেটা দ্রুত রিড করা যায়।
3. **Circular Buffer:** এটি ইন্টার্নালি দুটি পয়েন্টার (head এবং tail) ব্যবহার করে একটি সার্কুলার অ্যারের মতো কাজ করে। তাই সামনে থেকে আইটেম রিমুভ (`poll`) করলেও বাকি আইটেমগুলোকে বাম দিকে সরাতে (shift) হয় না। ফলে সব অপারেশনই $O(1)$ টাইমে হয়।
