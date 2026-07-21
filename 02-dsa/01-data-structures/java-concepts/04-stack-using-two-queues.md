# Implementing a Stack using Two Queues

ইন্টারভিউতে একটি খুব পপুলার প্রশ্ন হলো: **"দুটি Queue ব্যবহার করে কীভাবে একটি Stack তৈরি করা যায়?"**

Stack হলো **LIFO** (Last In, First Out), আর Queue হলো **FIFO** (First In, First Out)। 
Queue দিয়ে Stack-এর আচরণ অনুকরণ করতে হলে, আমাদের এমন একটি মেকানিজম দরকার যাতে সবার শেষে ঢোকানো এলিমেন্টটিই সবার আগে বের হয়।

এটি দুটি উপায়ে করা যায়:
1. **Push অপারেশনকে $O(1)$ রেখে, Pop কে $O(N)$ করা।**
2. **Push অপারেশনকে $O(N)$ রেখে, Pop কে $O(1)$ করা।**

এখানে আমরা **১ম অ্যাপ্রোচ (Push $O(1)$, Pop $O(N)$)** নিয়ে আলোচনা করব, যা আপনার প্রশ্নে উল্লেখ করা হয়েছে।

## Explanation & Approach (Push $O(1)$, Pop $O(N)$)

আমাদের কাছে দুটি Queue আছে: `q1` এবং `q2`। 
আমরা সবসময় মেইন ডেটা `q1` এ রাখব।

**`push(x)` অপারেশন ($O(1)$):**
- নতুন যেকোনো এলিমেন্ট সরাসরি `q1` এর পেছনে এড (enqueue) করে দেব। এটি করতে $O(1)$ সময় লাগে।

**`pop()` অপারেশন ($O(N)$):**
- Stack-এর নিয়ম অনুযায়ী, সবার শেষের এলিমেন্টটি পপ (pop) হতে হবে। কিন্তু `q1` যেহেতু একটি Queue, আমরা শুধু এর সামনের এলিমেন্টটিই বের করতে পারি। 
- তাই আমরা `q1` থেকে একটি বাদে বাকি সবগুলো (অর্থাৎ $N-1$ টি) এলিমেন্ট বের করে `q2` তে রেখে দেব। 
- এখন `q1` এ যে একটিমাত্র এলিমেন্ট অবশিষ্ট আছে, সেটিই হলো সবার শেষে ঢোকানো এলিমেন্ট! আমরা সেটিকে `q1` থেকে বের (dequeue) করে ইউজারকে রিটার্ন করব।
- এরপর `q1` এবং `q2` এর নাম অদলবদল (swap) করে নেব, যাতে `q2` আবার খালি হয়ে যায় এবং `q1` এ বাকি ডেটাগুলো থাকে।
- যেহেতু প্রতিবার পপ করার সময় $N-1$ টি এলিমেন্ট শিফট করতে হচ্ছে, তাই এর টাইম কমপ্লেক্সিটি $O(N)$।

## Java Code Implementation

```java
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingTwoQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push অপারেশন: O(1)
    public void push(int x) {
        // সরাসরি q1-এ ডেটা পুশ করা হলো
        q1.offer(x);
    }

    // Pop অপারেশন: O(N)
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // q1 থেকে (N-1) টি এলিমেন্ট বের করে q2 তে রাখা
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        // q1 এ এখন শুধু লাস্ট এলিমেন্টটি আছে, সেটি পপ করব
        int poppedElement = q1.poll();

        // q1 এবং q2 কে সোয়াপ (swap) করব
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedElement;
    }

    // Top এলিমেন্ট দেখা: O(N)
    public int top() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // q1 থেকে (N-1) টি এলিমেন্ট বের করে q2 তে রাখা
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        // লাস্ট এলিমেন্টটি হলো আমাদের top ভ্যালু
        int topElement = q1.poll();
        
        // যেহেতু এটি শুধু top(), তাই ভ্যালুটিকে হারিয়ে যেতে দেওয়া যাবে না।
        // একেও q2 তে পুশ করে দেব।
        q2.offer(topElement);

        // q1 এবং q2 কে সোয়াপ (swap) করব
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Top element is: " + stack.top()); // Output: 30
        System.out.println("Popped element is: " + stack.pop()); // Output: 30
        System.out.println("Top element is: " + stack.top()); // Output: 20
    }
}
```

> **Interview Tip:** ইন্টারভিউয়ার যদি জিজ্ঞেস করে "কোন অপারেশনটি ফাস্ট করা উচিত?", উত্তর হলো: আপনার সিস্টেমে যদি পুশ (push) অনেক বেশি হয় আর পপ (pop) খুব কম হয়, তাহলে এই $O(1)$ push অ্যাপ্রোচটি ভালো। আর যদি পপ বেশি হয়, তাহলে $O(1)$ pop (যেখানে পুশ $O(N)$) অ্যাপ্রোচটি ব্যবহার করা উচিত।
