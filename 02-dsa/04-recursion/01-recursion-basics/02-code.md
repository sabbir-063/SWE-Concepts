# 01. Recursion Basics (Code & Implementations)

এই ফাইলে আমরা জাভাতে রিকার্সনের বেসিক কিছু ইমপ্লিমেন্টেশন দেখবো—ফ্যাক্টোরিয়াল, হেড বনাম টেইল রিকার্সন এবং একটি স্ট্রিং রিভার্স করার লজিক।

---

## 1. Factorial (Standard Recursion)
**প্রবলেম:** $5!$ (ফ্যাক্টোরিয়াল ৫) বের করতে হবে। $5! = 5 \times 4 \times 3 \times 2 \times 1$।
**লজিক:** $fact(n) = n \times fact(n-1)$। Base Case: $n = 0$ বা $n = 1$ হলে $1$ রিটার্ন করবে।

```java
public class Factorial {
    public static int getFactorial(int n) {
        // ১. Base Case (থামার শর্ত)
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // ২. Recursive Case
        // কারেন্ট n এর সাথে ছোট প্রবলেম (n-1) এর গুণ
        return n * getFactorial(n - 1); 
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(5)); // Output: 120
    }
}
```
**Time Complexity:** $O(n)$ | **Space Complexity:** $O(n)$ (Call Stack এর জন্য)।

---

## 2. Tail Recursion (Optimized Factorial)
আগের ফ্যাক্টোরিয়াল ফাংশনে রিকার্সন থেকে ভ্যালু ব্যাক করার পর `n * result` গুণ করতে হতো। অর্থাৎ রিকার্সনটি শেষ কাজ ছিল না। 
Tail Recursion-এ আমরা একটি `accumulator` ভেরিয়েবল পাস করে গুণফলটি আগেই ক্যালকুলেট করে ফেলি।

```java
public class TailRecursionFactorial {
    // Helper function (যেখানে accumulator পাস করা হয়)
    public static int factTail(int n, int accumulator) {
        if (n == 0 || n == 1) {
            return accumulator; // বেস কেসে ডাইরেক্ট অ্যান্সার!
        }
        
        // রিকার্সন কলটিই একদম শেষ কাজ, এর সাথে কিছু গুণ/যোগ হচ্ছে না
        return factTail(n - 1, n * accumulator);
    }

    public static int getFactorial(int n) {
        return factTail(n, 1); // শুরুতে accumulator = 1
    }

    public static void main(String[] args) {
        System.out.println(getFactorial(5)); // Output: 120
    }
}
```
*(যদিও জাভাতে এটি ইন্টার্নালি $O(n)$ স্পেসই নেবে, কিন্তু C/C++ এ কম্পাইলার একে অপ্টিমাইজ করে $O(1)$ স্পেস করে ফেলবে)।*

---

## 3. Head Recursion vs Tail Recursion (Printing Numbers)
প্রিন্ট করার অর্ডার (ওপর থেকে নিচে নাকি নিচ থেকে ওপরে) রিকার্সনের কোথায় কোড লিখছেন তার ওপর নির্ভর করে।

```java
public class PrintNumbers {
    
    // Tail Recursion (প্রিন্ট আগে, রিকার্সন পরে)
    // আউটপুট: 5 4 3 2 1
    public static void printTail(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printTail(n - 1); // রিকার্সন শেষ কাজ
    }

    // Head Recursion (রিকার্সন আগে, প্রিন্ট পরে)
    // আউটপুট: 1 2 3 4 5
    public static void printHead(int n) {
        if (n == 0) return;
        printHead(n - 1); // আগে গভীরে যাবে (1 পর্যন্ত), তারপর ফেরার পথে প্রিন্ট করবে
        System.out.print(n + " "); 
    }

    public static void main(String[] args) {
        printTail(5);
        System.out.println();
        printHead(5);
    }
}
```

---

## 4. Reversing a String (Interview Favorite)
**প্রবলেম:** একটি স্ট্রিংকে রিকার্সন দিয়ে উল্টাতে হবে (Reverse)।
**লজিক:** প্রথম ক্যারেক্টারটিকে একদম শেষে বসিয়ে দেবো এবং বাকি স্ট্রিংটিকে রিকার্সিভলি রিভার্স করতে পাঠাবো।

```java
public class ReverseString {
    public static String reverse(String str) {
        // ১. Base Case: স্ট্রিং ফাঁকা বা ১ ক্যারেক্টারের হলে ওটাই রিটার্ন
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }
        
        // ২. Recursive Case
        // "hello" -> 'h' আলাদা করলাম, "ello" কে রিভার্স করতে পাঠালাম
        // "ello" রিভার্স হয়ে আসলে তার সাথে 'h' যোগ করে দিলাম
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String original = "hello";
        System.out.println(reverse(original)); // Output: "olleh"
    }
}
```

## 💡 Edge Cases & Best Practices
- **Never forget the Base Case:** রিকার্সন কোড লেখার সময় সবসময় আগে Base Case লিখবেন। না হলে ভুলেই যেতে পারেন!
- **Base Case should be reachable:** এমন কোনো লজিক লিখবেন না যা কখনোই Base Case হিট করবে না (যেমন `fact(n+1)` লিখতে থাকা)।
- **Stack Limit:** যদি প্রবলেমের ইনপুট ১ লাখ ($10^5$) এর বেশি হয়, তবে রিকার্সন ব্যবহার থেকে বিরত থাকুন, Iterative লুপ (while/for) ব্যবহার করুন।
