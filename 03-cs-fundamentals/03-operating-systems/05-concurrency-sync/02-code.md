# 05. Concurrency & Sync (Code & Implementations)

এই ফাইলে আমরা জাভাতে (Java) মাল্টি-থ্রেডিংয়ের সবচেয়ে বিখ্যাত সমস্যা—**Producer-Consumer Problem** টি `wait()` এবং `notify()` ব্যবহার করে সলভ করে দেখবো।

---

## The Producer-Consumer Implementation

আমরা ৫ সাইজের একটি বাফার (Buffer) নিবো। Producer ডেটা বানাবে আর Consumer ডেটা খাবে।
আমরা `synchronized` (Monitor) ব্যবহার করে মেকশিওর করবো যেন তারা একসাথে বাফারে হাত না দেয়। আর `wait()` এবং `notify()` দিয়ে মেকশিওর করবো যেন বাফার ফুল হলে Producer ঘুমিয়ে যায়, আর বাফার খালি হলে Consumer ঘুমিয়ে যায়।

```java
import java.util.LinkedList;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        // আমাদের শেয়ার্ড বাফার এবং তার সাইজ
        final LinkedList<Integer> buffer = new LinkedList<>();
        final int CAPACITY = 5;

        // Producer Thread
        Thread producer = new Thread(() -> {
            int value = 0;
            while (true) {
                // বাফারকে লক (synchronized) করে নিলাম
                synchronized (buffer) {
                    // বাফার যদি ফুল থাকে, তবে Producer কে ওয়েট (wait) করতে হবে
                    while (buffer.size() == CAPACITY) {
                        try {
                            System.out.println("Buffer is FULL! Producer is waiting...");
                            buffer.wait(); // ঘুমিয়ে পড়লো
                        } catch (InterruptedException e) {}
                    }
                    
                    // বাফারে জায়গা থাকলে নতুন ডেটা রাখবে
                    System.out.println("Producer produced: " + value);
                    buffer.add(value++); // ডেটা অ্যাড করলো
                    
                    // ডেটা অ্যাড করার পর সে Consumer কে সিগন্যাল (notify) দেবে যে, "আমি ডেটা রেখেছি, তুমি এবার খেতে পারো"
                    buffer.notify();
                }
                
                // একটু ব্রেক দিয়ে দিয়ে কাজ করবে
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            while (true) {
                // বাফারকে লক করে নিলাম
                synchronized (buffer) {
                    // বাফার যদি খালি থাকে, তবে Consumer কে ওয়েট করতে হবে
                    while (buffer.isEmpty()) {
                        try {
                            System.out.println("Buffer is EMPTY! Consumer is waiting...");
                            buffer.wait(); // ঘুমিয়ে পড়লো
                        } catch (InterruptedException e) {}
                    }
                    
                    // বাফারে ডেটা থাকলে সেখান থেকে ডেটা তুলে নেবে
                    int val = buffer.removeFirst(); // ডেটা রিমুভ করলো
                    System.out.println("Consumer consumed: " + val);
                    
                    // ডেটা খাওয়ার পর সে Producer কে সিগন্যাল (notify) দেবে যে, "আমি বাফারে জায়গা খালি করেছি, তুমি নতুন ডেটা রাখতে পারো"
                    buffer.notify();
                }
                
                // Consumer একটু স্লো কাজ করবে (যাতে বাফার ফুল হওয়ার সিনারিওটা দেখা যায়)
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        });

        // থ্রেড দুটি রান করে দেওয়া হলো
        producer.start();
        consumer.start();
    }
}
```

### 💡 Code Explanation (কীভাবে কাজ করছে?)
1. **`synchronized (buffer)`**: এটি মূলত Mutex/Monitor এর কাজ করছে। অর্থাৎ যখন Producer বাফারে ডেটা রাখছে, তখন Consumer চাইলেও বাফারে ঢুকতে পারবে না। তাকে দরজার বাইরে ওয়েট করতে হবে।
2. **`buffer.wait()`**: Producer যখন দেখবে বাফারের ৫টি জায়গাই ফুল, তখন সে আর জোর করে ডেটা রাখবে না। সে `wait()` কল করে ঘুমিয়ে পড়বে এবং বাফারের লকটা (তালা) ছেড়ে দেবে, যাতে Consumer এসে ডেটা খেতে পারে।
3. **`buffer.notify()`**: Consumer যখন একটি ডেটা খেয়ে বাফারকে একটু খালি করবে, তখন সে `notify()` কল করে ওই ঘুমন্ত Producer-কে জাগিয়ে দেবে।
4. **Why `while` loop instead of `if`?**: এটি ইন্টারভিউয়ের একটি ফেভারিট প্রশ্ন! `wait()` থেকে জেগে ওঠার পর থ্রেডকে আবার চেক করতে হয় যে আসলেই বাফার খালি হয়েছে কি না (Spurious wakeup এর কারণে)। একারণে `if(buffer.size() == CAPACITY)` না দিয়ে সবসময় `while` লুপের ভেতরে `wait()` কল করতে হয়। 

এভাবেই `wait` এবং `notify` (বা Semaphore) ব্যবহার করে সুন্দরভাবে থ্রেডগুলোর মাঝে সিঙ্ক্রোনাইজেশন (Synchronization) করা হয়!
