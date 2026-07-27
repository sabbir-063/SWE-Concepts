# 04. Deadlock (Code & Implementations)

এই ফাইলে আমরা জাভাতে (Java) মাল্টি-থ্রেডিং ব্যবহার করে একটি রিয়েল **Deadlock** তৈরি করে দেখবো। তারপর দেখবো কীভাবে কোডের স্ট্রাকচার চেঞ্জ করে (Circular Wait ভেঙে দিয়ে) সেই ডেডলকটি সমাধান (Fix) করা যায়।

---

## 1. Creating a Deadlock (The Problem)

আমরা দুটি রিসোর্স নিবো (Lock-1 এবং Lock-2)। 
- Thread-1 প্রথমে Lock-1 কে ধরবে, তারপর Lock-2 কে চাইবে।
- Thread-2 প্রথমে Lock-2 কে ধরবে, তারপর Lock-1 কে চাইবে।
ফলে তারা একে অপরের জন্য অনন্তকাল ওয়েট করবে!

```java
public class DeadlockExample {
    // দুটি শেয়ার্ড রিসোর্স (Locks)
    public static final Object Lock1 = new Object();
    public static final Object Lock2 = new Object();

    public static void main(String[] args) {
        
        // Thread 1
        Thread t1 = new Thread(() -> {
            synchronized (Lock1) { // প্রথমে Lock-1 কে লক করলো
                System.out.println("Thread 1: Holding lock 1...");
                
                try { Thread.sleep(100); } // একটু ঘুমালো, যাতে Thread 2 এর কাজ শুরু করার সুযোগ পায়
                catch (InterruptedException e) {}
                
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (Lock2) { // এবার Lock-2 কে চাচ্ছে (কিন্তু সেটি T2 এর কাছে লক করা)
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            synchronized (Lock2) { // প্রথমে Lock-2 কে লক করলো (উল্টা দিক থেকে)
                System.out.println("Thread 2: Holding lock 2...");
                
                try { Thread.sleep(100); } 
                catch (InterruptedException e) {}
                
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (Lock1) { // এবার Lock-1 কে চাচ্ছে (কিন্তু সেটি T1 এর কাছে লক করা)
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

### 🔴 Output of Deadlock:
```text
Thread 1: Holding lock 1...
Thread 2: Holding lock 2...
Thread 1: Waiting for lock 2...
Thread 2: Waiting for lock 1...
// (প্রোগ্রাম এখানে চিরতরে হ্যাং হয়ে যাবে, কখনোই শেষ হবে না!)
```

---

## 2. Fixing the Deadlock (The Solution)

ডেডলক প্রিভেনশনের একটি সেরা উপায় হলো **"Circular Wait" (গোলকধাঁধা) ভেঙে দেওয়া**।
আমরা যদি নিয়ম করে দিই যে, সব থ্রেডকে **সবসময় একই অর্ডারে (সিরিয়ালে)** লক চাইতে হবে—যেমন: সবাইকে আগে Lock-1 নিতে হবে, তারপর Lock-2 নিতে হবে। তাহলে আর কখনোই ডেডলক হবে না!

```java
public class DeadlockFixed {
    public static final Object Lock1 = new Object();
    public static final Object Lock2 = new Object();

    public static void main(String[] args) {
        
        // Thread 1
        Thread t1 = new Thread(() -> {
            synchronized (Lock1) { // প্রথমে Lock-1 নিলো
                System.out.println("Thread 1: Holding lock 1...");
                
                try { Thread.sleep(100); } 
                catch (InterruptedException e) {}
                
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (Lock2) { // তারপর Lock-2 নিলো
                    System.out.println("Thread 1: Acquired both locks successfully!");
                }
            }
        });

        // Thread 2 (The Fix is here!)
        Thread t2 = new Thread(() -> {
            // আগেরবার T2 প্রথমে Lock-2 নিয়েছিল। এবার আমরা তাকেও আগে Lock-1 নিতে বাধ্য করবো।
            synchronized (Lock1) { 
                System.out.println("Thread 2: Holding lock 1...");
                
                try { Thread.sleep(100); } 
                catch (InterruptedException e) {}
                
                System.out.println("Thread 2: Waiting for lock 2...");
                synchronized (Lock2) { 
                    System.out.println("Thread 2: Acquired both locks successfully!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

### 🟢 Output of Fixed Code:
```text
Thread 1: Holding lock 1...
Thread 1: Waiting for lock 2...
Thread 1: Acquired both locks successfully!
Thread 2: Holding lock 1...
Thread 2: Waiting for lock 2...
Thread 2: Acquired both locks successfully!
// (প্রোগ্রাম সুন্দরভাবে শেষ হবে, কোনো হ্যাং হবে না!)
```

**কী ঘটলো?**
যেহেতু আমরা নিয়ম করে দিয়েছি যে সবাইকে আগে Lock-1 ধরতে হবে, তাই Thread-1 যখন Lock-1 ধরে বসে আছে, তখন Thread-2 কাজ শুরুই করতে পারবে না (তাকে Lock-1 এর জন্য ওয়েট করতে হবে)। ফলে Thread-1 নিশ্চিন্তে Lock-2 ব্যবহার করে কাজ শেষ করবে এবং লকগুলো ছেড়ে দেবে। এরপর Thread-2 কাজ করার সুযোগ পাবে। 

এভাবেই অর্ডারিং (Lock Ordering) এর মাধ্যমে ডেডলক সলভ করা হয়!
