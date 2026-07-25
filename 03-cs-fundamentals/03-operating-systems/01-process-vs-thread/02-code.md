# 01. Process vs Thread (Code & Implementation)

এই ফাইলে আমরা জাভাতে (Java) Thread তৈরি করা, Shared Memory এর কারণে হওয়া সমস্যা (Race Condition) এবং তার সমাধান (Synchronization) প্র্যাকটিক্যালি দেখবো।

---

## 1. How to Create a Thread in Java?

জাভাতে থ্রেড তৈরি করার মূলত দুটি উপায় আছে: `Thread` ক্লাস এক্সটেন্ড করা, অথবা `Runnable` ইন্টারফেস ইমপ্লিমেন্ট করা (এটিই বেশি পপুলার)।

```java
// Method: Using Runnable Interface
class MyTask implements Runnable {
    private String taskName;

    public MyTask(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " is running step " + i);
            try {
                // থ্রেডটিকে একটু ঘুমাতে (Pause) বলছি, যাতে Context Switching বোঝা যায়
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadBasics {
    public static void main(String[] args) {
        System.out.println("Main Thread starts");

        // দুটি আলাদা থ্রেড তৈরি করা হলো
        Thread t1 = new Thread(new MyTask("Task-1"));
        Thread t2 = new Thread(new MyTask("Task-2"));

        // start() কল করলেই থ্রেডগুলো ব্যাকগ্রাউন্ডে চলা শুরু করবে
        t1.start();
        t2.start();

        System.out.println("Main Thread ends");
    }
}
```
**Output Explanation:** আপনি দেখবেন "Main Thread ends" সবার আগেই প্রিন্ট হয়ে গেছে। আর `Task-1` এবং `Task-2` একে অপরের সাথে মিক্স হয়ে (Context Switching) প্রিন্ট হচ্ছে।

---

## 2. The Danger: Race Condition (Shared Memory Issue)

যেহেতু থ্রেডগুলো একই মেমোরি শেয়ার করে, তাই একাধিক থ্রেড যখন একই ভেরিয়েবল আপডেট করতে যায়, তখন ডেটা করাপ্ট হয়ে যায়। 

```java
class BankAccount {
    int balance = 0;

    // থ্রেড এই মেথড কল করে ব্যালেন্স বাড়াবে
    public void deposit() {
        // ১. ব্যালেন্স রিড করে, ২. ১ যোগ করে, ৩. আবার সেভ করে
        balance = balance + 1; 
    }
}

public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        // একটি টাস্ক যা ১০,০০০ বার ১ টাকা করে জমা করবে
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                account.deposit();
            }
        };

        // দুটি থ্রেড একই অ্যাকাউন্টে টাকা জমা করছে
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        // Main thread কে ওয়েট করতে বলছি যতক্ষণ না t1, t2 শেষ হয়
        t1.join();
        t2.join();

        // আমাদের আশা: 10000 + 10000 = 20000 হবে
        System.out.println("Final Balance: " + account.balance);
    }
}
```
**Output:** আপনি অবাক হয়ে দেখবেন যে ব্যালান্স ২০,০০০ এর বদলে `13452` বা `18043` এরকম উল্টাপাল্টা একটি সংখ্যা আসছে!
**কারণ:** যখন t1 রিড করলো যে ব্যালান্স 500, ঠিক ওই মিলি-সেকেন্ডেই t2 ও রিড করলো যে ব্যালান্স 500। এরপর দুজনেই 1 যোগ করে 501 করে ডাটাবেসে সেভ করলো। ফলে 502 হওয়ার কথা থাকলেও সেটি 501 হয়ে গেলো।

---

## 3. The Solution: Synchronization (Locks/Mutex)

রেস কন্ডিশন থেকে বাঁচার উপায় হলো **Lock** (তালা) লাগানো। আমরা এমন একটি লজিক লিখবো যেন, "একটি থ্রেড যখন ব্যালান্স আপডেট করছে, তখন অন্য কোনো থ্রেড ভেতরে ঢুকতে পারবে না। তাকে লাইনে দাঁড়িয়ে ওয়েট করতে হবে।"

জাভাতে এটি `synchronized` কিওয়ার্ড দিয়ে খুব সহজেই করা যায়।

```java
class SafeBankAccount {
    int balance = 0;

    // synchronized কিওয়ার্ড অ্যাড করা হলো (এটি একটি Lock হিসেবে কাজ করে)
    public synchronized void deposit() {
        balance = balance + 1; 
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {
        SafeBankAccount account = new SafeBankAccount();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                account.deposit();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Safe Balance: " + account.balance);
    }
}
```
**Output:** `Final Safe Balance: 20000` (সবসময় 100% অ্যাকুরেট আসবে!)

### 💡 The Trade-off (The Cost of Safety)
`synchronized` ব্যবহার করলে রেস কন্ডিশন সলভ হয় ঠিকই, কিন্তু থ্রেডগুলো আর আগের মতো দ্রুত কাজ করতে পারে না। কারণ একজনকে কাজ করতে দিয়ে বাকিদের লাইনে দাঁড়িয়ে ওয়েট করতে হয়। এটি অনেকটা সিঙ্গেল-থ্রেডের মতোই স্লো হয়ে যায়! 
তাই মাল্টি-থ্রেডিংয়ে মেমোরি ম্যানেজ করা (Concurrency Control) সফটওয়্যার ইঞ্জিনিয়ারিংয়ের অন্যতম কঠিন একটি কাজ।
