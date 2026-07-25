# 02. Searching Algorithms (Code & Implementations)

এই ফাইলে আমরা জাভাতে Linear Search এবং Binary Search (Iterative & Recursive) এর একদম ক্লিন ইমপ্লিমেন্টেশন দেখবো। এরপর Binary Search এর কিছু কমন ভ্যারিয়েশন (First/Last Occurrence) সলভ করবো।

## 1. Linear Search
খুবই সিম্পল, একটি লুপ চালিয়ে চেক করা।

```java
public class LinearSearch {
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // ডেটা পেলে ইনডেক্স রিটার্ন
            }
        }
        return -1; // না পেলে -1 রিটার্ন
    }
}
```

---

## 2. Binary Search (Iterative Approach)
এটি সবচেয়ে বেশি ব্যবহৃত হয়। রিকার্সিভ অ্যাপ্রোচের চেয়ে এটি ভালো কারণ এতে স্ট্যাক মেমোরি ($O(\log n)$ Space) বাঁচে।
**Time Complexity:** $O(\log n)$ | **Space Complexity:** $O(1)$

```java
public class BinarySearchIterative {
    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // ওভারফ্লো এড়াতে সঠিক উপায়ে Mid বের করা
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // ডেটা পাওয়া গেছে
            }
            else if (arr[mid] < target) {
                left = mid + 1; // টার্গেট বড়, তাই ডানে খুঁজবো
            }
            else {
                right = mid - 1; // টার্গেট ছোট, তাই বামে খুঁজবো
            }
        }
        
        return -1; // ডেটা নেই
    }
}
```

---

## 3. Binary Search (Recursive Approach)
কখনো কখনো ইন্টারভিউতে রিকার্সিভলি লিখতে বলতে পারে।
**Time Complexity:** $O(\log n)$ | **Space Complexity:** $O(\log n)$ (Call Stack এর জন্য)

```java
public class BinarySearchRecursive {
    public static int search(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: ডেটা নেই
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        else if (arr[mid] < target) {
            // ডানে খোঁজা
            return search(arr, target, mid + 1, right);
        }
        else {
            // বামে খোঁজা
            return search(arr, target, left, mid - 1);
        }
    }
    
    // Wrapper method for easy calling
    public static int search(int[] arr, int target) {
        return search(arr, target, 0, arr.length - 1);
    }
}
```

---

## 4. Binary Search Variation: First and Last Occurrence
**প্রবলেম:** একটি সর্টেড অ্যারেতে ডুপ্লিকেট ডেটা থাকতে পারে। আপনাকে একটি টার্গেটের প্রথম (First) এবং শেষ (Last) ইনডেক্স বের করতে হবে। 
*Example:* `arr = [1, 2, 2, 2, 3, 5]`, `target = 2` -> Output: First: 1, Last: 3.

**লজিক:** Binary search দিয়ে ডেটা পেলেও থামা যাবে না। First occurrence এর জন্য বাম দিকে খুঁজতে হবে, আর Last occurrence এর জন্য ডান দিকে খুঁজতে হবে।

```java
public class FirstLastOccurrence {
    
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1; // বাই ডিফল্ট -1
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid; // ডেটা পেয়েছি, সেভ করলাম
                right = mid - 1; // কিন্তু আরও বামে (আগে) আছে কি না তা খুঁজবো!
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid; // ডেটা পেয়েছি
                left = mid + 1; // কিন্তু আরও ডানে (পরে) আছে কি না তা খুঁজবো!
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
```

## 5. Built-in Methods in Java
ইন্টারভিউতে বা কম্পিটিটিভ প্রোগ্রামিংয়ে স্ক্র্যাচ থেকে না লিখে জাভার বিল্ট-ইন মেথড ব্যবহার করা যায়:

- **Arrays.binarySearch(arr, key):**
  - রিটার্ন: ডেটা থাকলে ইনডেক্স রিটার্ন করে।
  - যদি ডেটা না থাকে: `-(insertion point) - 1` রিটার্ন করে। (Insertion point হলো সেই ইনডেক্স যেখানে ভ্যালুটি বসালে অ্যারেটি সর্টেড থাকবে)।
  
```java
import java.util.Arrays;

public class BuiltInSearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        
        int index = Arrays.binarySearch(arr, 30);
        System.out.println("Found 30 at: " + index); // 2
        
        int notFound = Arrays.binarySearch(arr, 25);
        System.out.println("25 would be at index: " + (-(notFound + 1))); // 2
    }
}
```
