# 02. Recursion vs Iteration (Code & Implementations)

এই ফাইলে আমরা একই প্রবলেমকে Recursion এবং Iteration (Loop) উভয় পদ্ধতিতেই সলভ করে দেখবো, যাতে এদের পার্থক্য এবং পারফরম্যান্স গ্যাপ ক্লিয়ার হয়।

---

## 1. Fibonacci Sequence (The Classic Comparison)
ফিবোনাচি নাম্বার বের করার ক্ষেত্রে রিকার্সন কতটা স্লো হতে পারে, আর লুপ কতটা ফাস্ট হতে পারে, এটি তার চমৎকার উদাহরণ।

### A. Recursive Fibonacci (খুবই স্লো)
**Time Complexity:** $O(2^n)$ (এক্সপোনেনশিয়াল) | **Space Complexity:** $O(n)$ (Call Stack)
```java
public class FibonacciComparison {
    // Recursive (Tree Recursion)
    public static int fibRecursive(int n) {
        if (n <= 1) return n;
        // একই সাব-প্রবলেম বারবার কল হয় (Overlapping)
        return fibRecursive(n - 1) + fibRecursive(n - 2); 
    }
}
```

### B. Iterative Fibonacci (অনেক ফাস্ট)
**Time Complexity:** $O(n)$ (লিনিয়ার) | **Space Complexity:** $O(1)$ (শুধু ২টি ভেরিয়েবল)
```java
public class FibonacciComparison {
    // Iterative
    public static int fibIterative(int n) {
        if (n <= 1) return n;
        
        int prev2 = 0;
        int prev1 = 1;
        int current = 0;
        
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
```
**Conclusion:** ফিবোনাচির মতো প্রবলেমে যদি DP (Memoization) ব্যবহার না করেন, তবে নরমাল রিকার্সনের চেয়ে Iteration কয়েক হাজার গুণ ফাস্ট!

---

## 2. Tree Traversal (Where Recursion Shines)
বাইনারি ট্রি এর In-order ট্রাভার্সাল (Left -> Root -> Right) করার ক্ষেত্রে রিকার্সন কতোটা সহজ আর ইটারেটিভ কতোটা কঠিন, তা দেখুন।

### A. Recursive In-order (Beautiful & Clean)
```java
class TreeNode {
    int val;
    TreeNode left, right;
}

public class TreeTraversal {
    // Recursive
    public static void inorderRecursive(TreeNode root) {
        if (root == null) return;
        
        inorderRecursive(root.left);       // Left
        System.out.print(root.val + " ");  // Root
        inorderRecursive(root.right);      // Right
    }
}
```

### B. Iterative In-order (Complex & Painful)
রিকার্সন বাদ দিলে আমাদের ম্যানুয়ালি একটি `Stack` বানিয়ে পুরো লজিক মেইনটেইন করতে হয়।
```java
import java.util.Stack;

public class TreeTraversal {
    // Iterative
    public static void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            // যতটা সম্ভব Left এ যাও
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // ডেড-এন্ডে পৌঁছালে পপ করো (Root) এবং প্রিন্ট করো
            current = stack.pop();
            System.out.print(current.val + " ");
            
            // এরপর Right এ যাও
            current = current.right;
        }
    }
}
```
**Conclusion:** Tree বা Graph এর প্রবলেমে সবসময় Recursion ব্যবহার করবেন (যদি না ইন্টারভিউয়ার ইচ্ছাকৃতভাবে Iterative কোড লিখতে বলে)।

---

## 3. Reversing a Linked List (The Trade-off)
Linked List রিভার্স করার প্রবলেমে রিকার্সন এবং ইটারেশন দুটোরই আলাদা ফ্যানবেস আছে। 

### A. Iterative Reverse (Best Practice)
**Time:** $O(n)$ | **Space:** $O(1)$
```java
class ListNode {
    int val;
    ListNode next;
}

public class ReverseLinkedList {
    // Iterative
    public static ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next; // পরের নোডটা সেভ করে রাখা
            current.next = prev;              // উল্টো দিকে পয়েন্ট করা
            prev = current;                   // এক স্টেপ সামনে আগানো
            current = nextTemp;
        }
        return prev;
    }
}
```

### B. Recursive Reverse (Elegant but uses extra Space)
**Time:** $O(n)$ | **Space:** $O(n)$ (Call Stack)
```java
public class ReverseLinkedList {
    // Recursive
    public static ListNode reverseRecursive(ListNode head) {
        // Base case: লিস্ট ফাঁকা বা শেষ নোডে পৌঁছালে
        if (head == null || head.next == null) {
            return head; 
        }
        
        // রিকার্সিভলি বাকি লিস্টটা রিভার্স করে আনা
        ListNode newHead = reverseRecursive(head.next);
        
        // কারেন্ট নোড এবং তার পরের নোডের ডিরেকশন উল্টে দেওয়া
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}
```
**Conclusion:** লুপের (Iterative) কোডটি মেমোরি ফ্রেন্ডলি ($O(1)$ স্পেস), কিন্তু রিকার্সনের লজিকটি বুঝতে পারলে অনেক স্মার্ট মনে হয়। প্রোডাকশনে সাধারণত Iterative ভার্সনটাই বেশি প্রেফার করা হয়।
