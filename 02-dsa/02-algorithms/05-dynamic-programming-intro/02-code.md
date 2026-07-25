# 05. Dynamic Programming Intro (Code & Implementations)

এই ফাইলে আমরা DP এর একদম বেসিক প্রবলেম (Fibonacci এবং Climbing Stairs) এর মাধ্যমে রিকার্সন থেকে শুরু করে মেমোইজেশন (Top-Down), ট্যাবুলেশন (Bottom-Up) এবং স্পেস অপ্টিমাইজেশন এর ট্রানজিশন দেখবো।

---

## 1. Fibonacci Sequence
**প্রবলেম:** $n$-তম ফিবোনাচি নাম্বার বের করতে হবে। $F(n) = F(n-1) + F(n-2)$।

### Step A: Normal Recursion (The bad way)
**Time Complexity:** $O(2^n)$ | **Space Complexity:** $O(n)$
```java
public class FibonacciRecursion {
    public static int fib(int n) {
        if (n <= 1) return n; // Base case
        return fib(n - 1) + fib(n - 2); // Exploring both choices
    }
}
```

---

### Step B: Memoization / Top-Down (The DP way)
**লজিক:** একটি অ্যারে (Memo) নিবো। কোনো ভ্যালু ক্যালকুলেট করার আগে চেক করবো সেটা অ্যারেতে আছে কি না।
**Time Complexity:** $O(n)$ | **Space Complexity:** $O(n)$ (Array) + $O(n)$ (Call Stack) = $O(n)$
```java
import java.util.Arrays;

public class FibonacciMemoization {
    public static int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // -1 মানে এখনো ক্যালকুলেট হয়নি
        return fibHelper(n, memo);
    }

    private static int fibHelper(int n, int[] memo) {
        if (n <= 1) return n;
        
        // যদি আগে থেকেই ক্যালকুলেট করা থাকে, সরাসরি রিটার্ন! (Magic of DP)
        if (memo[n] != -1) return memo[n];

        // ক্যালকুলেট করে memo তে সেভ করে রাখা
        memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
        return memo[n];
    }
}
```

---

### Step C: Tabulation / Bottom-Up (Iterative DP)
**লজিক:** রিকার্সন বাদ দিয়ে লুপ চালাবো। $0$ এবং $1$ থেকে শুরু করে $n$ পর্যন্ত হিসাব করবো।
**Time Complexity:** $O(n)$ | **Space Complexity:** $O(n)$ (Array)
```java
public class FibonacciTabulation {
    public static int fib(int n) {
        if (n <= 1) return n;
        
        int[] dp = new int[n + 1]; // DP Table
        dp[0] = 0;
        dp[1] = 1;

        // Bottom-up লুপ
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
}
```

---

### Step D: Space Optimization (The Ultimate DP trick)
**লজিক:** লুপের দিকে তাকালে দেখবেন, কারেন্ট ভ্যালু বের করতে আমাদের পুরো অ্যারের দরকার নেই, শুধু আগের ২টা ভ্যালু (`dp[i-1]` এবং `dp[i-2]`) দরকার! তাহলে খামোখা অ্যারে কেন নিবো?
**Time Complexity:** $O(n)$ | **Space Complexity:** $O(1)$ ⚡
```java
public class FibonacciOptimized {
    public static int fib(int n) {
        if (n <= 1) return n;
        
        int prev2 = 0; // F(n-2)
        int prev1 = 1; // F(n-1)
        int current = 0;

        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            // পয়েন্টার আপডেট করা
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
}
```

---

## 2. Climbing Stairs (LeetCode 70)
**প্রবলেম:** একটি সিঁড়ির $n$ তলায় উঠতে হবে। আপনি প্রতি পদক্ষেপে ১ ধাপ অথবা ২ ধাপ উঠতে পারেন। টোটাল কতভাবে (Total ways) আপনি $n$ তলায় পৌঁছাতে পারবেন?

**লজিক (How to think DP):**
- $n$ তলায় পৌঁছানোর শেষ ধাপটি কী হতে পারে? হয় আপনি $(n-1)$ তলা থেকে ১ লাফ দিয়েছেন, অথবা $(n-2)$ তলা থেকে ২ লাফ দিয়েছেন।
- অর্থাৎ, $n$ তলায় যাওয়ার উপায় = $(n-1)$ তলায় যাওয়ার উপায় + $(n-2)$ তলায় যাওয়ার উপায়।
- এটি তো হুবহু ফিবোনাচি! 

```java
public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 2) return n; // 1 তলায় যাওয়ার উপায় 1, 2 তলায় যাওয়ার উপায় 2
        
        int prev2 = 1; // n-2
        int prev1 = 2; // n-1
        int current = 0;
        
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return current;
    }
}
```

## 💡 DP Implementation Recipe (ইন্টারভিউয়ের জন্য)
যেকোনো DP প্রবলেম সলভ করার স্টেপস:
1. **State:** আপনার রিকার্সন ফাংশনের প্যারামিটারগুলো (যেমন $i, j, weight$) কী কী চেঞ্জ হচ্ছে তা বের করা।
2. **Transition:** বর্তমান স্টেট থেকে আগের বা পরের স্টেটে কীভাবে যাওয়া যায় তার ইকুয়েশন (Recurrence Relation) বের করা।
3. **Base Case:** রিকার্সন কখন থামবে তা ডিফাইন করা।
4. **Memoize/Tabulate:** রিকার্সনের ভ্যালু একটি অ্যারে বা ম্যাট্রিক্সে স্টোর করা।
