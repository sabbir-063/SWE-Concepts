# 07. Heaps & Priority Queues (Code & Implementations)

এই ফাইলে আমরা জাভাতে একটি কাস্টম **Min Heap** ইমপ্লিমেন্ট করবো এবং এরপর জাভার বিল্ট-ইন `PriorityQueue` ব্যবহার করে পপুলার কিছু প্রবলেম সলভ করবো।

## 1. Custom Min Heap Implementation
ইন্টারভিউতে অনেক সময় স্ক্র্যাচ থেকে Heap এর `insert` এবং `deleteMin` ফাংশন লিখতে বলে। নিচে Array (বা `ArrayList`) ব্যবহার করে এর ইমপ্লিমেন্টেশন দেওয়া হলো।

```java
import java.util.ArrayList;

public class CustomMinHeap {
    private ArrayList<Integer> heap;

    public CustomMinHeap() {
        heap = new ArrayList<>();
    }

    // Helper Methods
    private int getParent(int i) { return (i - 1) / 2; }
    private int getLeftChild(int i) { return 2 * i + 1; }
    private int getRightChild(int i) { return 2 * i + 2; }
    
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // ১. PEEK: সবচেয়ে ছোট ভ্যালু দেখা O(1)
    public int peek() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    // ২. INSERT: নতুন ভ্যালু যোগ করা O(log n)
    public void insert(int value) {
        heap.add(value); // একদম শেষে অ্যাড করা
        heapifyUp(heap.size() - 1); // ঠিক জায়গায় বসানো
    }

    private void heapifyUp(int index) {
        // যতক্ষণ রুট এ না পৌঁছাই এবং কারেন্ট নোড তার প্যারেন্টের চেয়ে ছোট থাকে
        while (index > 0 && heap.get(index) < heap.get(getParent(index))) {
            swap(index, getParent(index));
            index = getParent(index); // প্যারেন্টে উঠে যাওয়া
        }
    }

    // ৩. POLL: সবচেয়ে ছোট ভ্যালু রিমুভ করা O(log n)
    public int poll() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        
        int min = heap.get(0); // রুট সেভ করে রাখা
        
        // একদম শেষের নোডটিকে রুটে নিয়ে আসা এবং শেষেরটা ডিলিট করা
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        
        if (!heap.isEmpty()) {
            heapifyDown(0); // রুটকে ঠিক জায়গায় নামানো
        }
        
        return min;
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int left = getLeftChild(index);
        int right = getRightChild(index);

        // যদি লেফট চাইল্ড ছোট হয়
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        // যদি রাইট চাইল্ড আরও ছোট হয়
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        // যদি কারেন্ট নোডটি সবচেয়ে ছোট না হয়, তবে সোয়াপ করে নিচে নামো
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest); // রিকার্সিভলি নিচে নামা
        }
    }

    public static void main(String[] args) {
        CustomMinHeap minHeap = new CustomMinHeap();
        minHeap.insert(10);
        minHeap.insert(4);
        minHeap.insert(15);
        minHeap.insert(1);
        
        System.out.println("Min: " + minHeap.peek()); // 1
        System.out.println("Polled: " + minHeap.poll()); // 1
        System.out.println("New Min: " + minHeap.peek()); // 4
    }
}
```

## 2. Using Java's Built-in PriorityQueue
জাভাতে স্ক্র্যাচ থেকে Heap না লিখে সরাসরি `PriorityQueue` ক্লাস ব্যবহার করা যায়। বাই ডিফল্ট এটি একটি **Min Heap**।

```java
import java.util.Collections;
import java.util.PriorityQueue;

public class PQExample {
    public static void main(String[] args) {
        // Min Heap (Default)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(2);
        minHeap.add(5);
        System.out.println("Min Heap Peek: " + minHeap.peek()); // 2

        // Max Heap (Collections.reverseOrder() ব্যবহার করে)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(10);
        maxHeap.add(2);
        maxHeap.add(5);
        System.out.println("Max Heap Peek: " + maxHeap.peek()); // 10
    }
}
```

## 3. Common Algorithmic Problem (Kth Largest Element)
**প্রবলেম (LeetCode 215):** একটি আনসর্টেড অ্যারে থেকে K-তম বড় এলিমেন্ট (Kth Largest Element) বের করুন। 
*লজিক:* একটি K সাইজের Min Heap মেইনটেইন করুন। এতে সব সময় বড় K টা এলিমেন্ট থাকবে এবং রুটে থাকবে ওই K টার মধ্যে সবচেয়ে ছোটটা (অর্থাৎ K-th largest)।

```java
public int findKthLargest(int[] nums, int k) {
    // Min Heap
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
    for (int num : nums) {
        minHeap.add(num);
        
        // যদি Heap এর সাইজ K এর চেয়ে বড় হয়, তবে সবচেয়ে ছোট এলিমেন্ট ফেলে দাও
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    
    // লুপ শেষে Heap এ ঠিক K টা বড় এলিমেন্ট থাকবে, যার রুট হবে Kth Largest
    return minHeap.peek();
}
```
*Time Complexity:* $O(n \log k)$। সর্ট করলে লাগতো $O(n \log n)$। তাই Priority Queue এখানে অনেক ফাস্ট!

## Edge Cases & Gotchas
- **`null` Elements:** Java `PriorityQueue` তে `null` ভ্যালু ইনসার্ট করা যায় না (`NullPointerException` থ্রো করবে)।
- **Thread Safety:** `PriorityQueue` Thread-safe নয়। মাল্টি-থ্রেডিং এনভায়রনমেন্টে `PriorityBlockingQueue` ব্যবহার করতে হয়।
- **Iteration Order:** PriorityQueue তে `for-each` লুপ চালালে সেটি সর্টেড অর্ডারে ডেটা প্রিন্ট করে না। সর্টেড অর্ডারে পেতে হলে লুপ চালিয়ে `poll()` করতে হয়।
