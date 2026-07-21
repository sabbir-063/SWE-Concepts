# 06. Hash Tables (Code & Implementations)

এই ফাইলে আমরা জাভা ব্যবহার করে স্ক্র্যাচ (Scratch) থেকে একটি Hash Table ইমপ্লিমেন্ট করবো, যাতে এর ভেতরের কাজগুলো (Hashing, Chaining, Rehashing) একদম ক্লিয়ার হয়ে যায়।

## 1. Custom HashTable Implementation (Separate Chaining)

আমরা একটি জেনেরিক (Generic) কাস্টম `MyHashMap<K, V>` তৈরি করবো। কলিশন হ্যান্ডেল করার জন্য আমরা Separate Chaining (অ্যারে অব লিঙ্কড লিস্ট) ব্যবহার করবো।

```java
import java.util.ArrayList;

// একটি বাকেটের ভেতরের নোড (Linked List এর নোড)
class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next; // চেইনের পরের নোডের পয়েন্টার

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class MyHashMap<K, V> {
    private ArrayList<HashNode<K, V>> bucketArray;
    private int numBuckets; // অ্যারের সাইজ
    private int size;       // মোট এন্ট্রির সংখ্যা (Key-Value pairs)

    public MyHashMap() {
        bucketArray = new ArrayList<>();
        numBuckets = 10; // ইনিশিয়াল সাইজ
        size = 0;

        // অ্যারেটিকে null দিয়ে ইনিশিয়ালাইজ করা
        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // ১. হ্যাশ ফাংশন (Key কে ইনডেক্সে কনভার্ট করা)
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode(); // জাভার বিল্ট-ইন হ্যাশকোড (পজিটিভ বা নেগেটিভ হতে পারে)
        int index = hashCode % numBuckets;
        // মডুলাস করার পর যদি ইনডেক্স নেগেটিভ হয়, তাকে পজিটিভ করা
        return index < 0 ? index * -1 : index;
    }

    // ২. GET মেথড ($O(1)$)
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // চেইনের মধ্যে খোঁজা
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // না পেলে null রিটার্ন করবে
    }

    // ৩. PUT মেথড ($O(1)$)
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // যদি Key আগে থেকেই থাকে, তবে তার Value আপডেট করা
        HashNode<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Key নতুন হলে লিস্টের একদম সামনে (Head এ) অ্যাড করা
        size++;
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode); // নতুন নোডটিকে বাকেটের হেড বানিয়ে দেওয়া

        // ৪. Load Factor চেক করা এবং Rehashing
        double loadFactor = (1.0 * size) / numBuckets;
        if (loadFactor >= 0.75) {
            rehash();
        }
    }

    // ৫. REMOVE মেথড ($O(1)$)
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break; // ডেটা পেয়েছি
            }
            prev = head;
            head = head.next;
        }

        if (head == null) return null; // ডেটা নেই

        size--;
        if (prev != null) {
            prev.next = head.next; // মাঝখান থেকে রিমুভ
        } else {
            bucketArray.set(bucketIndex, head.next); // একদম প্রথম নোড রিমুভ
        }

        return head.value;
    }

    // ৬. REHASHING (Double the size)
    private void rehash() {
        System.out.println("Rehashing! Doubling the array size...");
        ArrayList<HashNode<K, V>> temp = bucketArray; // পুরোনো অ্যারে সেভ রাখা
        
        numBuckets = 2 * numBuckets; // সাইজ দ্বিগুণ
        bucketArray = new ArrayList<>(numBuckets); // নতুন অ্যারে
        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
        size = 0;

        // পুরোনো অ্যারের সব ডেটাকে নতুন অ্যারেতে রিহ্যাশ করে বসানো
        for (HashNode<K, V> headNode : temp) {
            while (headNode != null) {
                put(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }

    // Main মেথড টেস্টিংয়ের জন্য
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        
        map.put("Sabbir", 1);
        map.put("Rahim", 2);
        map.put("Karim", 3);
        
        System.out.println("Size: " + map.size()); // 3
        System.out.println("Value for Sabbir: " + map.get("Sabbir")); // 1
        
        System.out.println("Removing Rahim: " + map.remove("Rahim")); // 2
        System.out.println("Value for Rahim: " + map.get("Rahim")); // null
        System.out.println("Size after removal: " + map.size()); // 2
    }
}
```

## 2. Common Algorithmic Problems using Hash Tables

Hash Table সাধারণত $O(n^2)$ টাইমের প্রবলেমগুলোকে মেমোরি ($O(n)$ space) ব্যবহার করে $O(n)$ টাইমে নামিয়ে আনতে সাহায্য করে। নিচে সবচেয়ে কমন কিছু প্রবলেম দেওয়া হলো।

### A. Two Sum (LeetCode 1)
**প্রবলেম:** একটি অ্যারে থেকে এমন দুটি সংখ্যা বের করুন যাদের যোগফল একটি নির্দিষ্ট টার্গেটের সমান।
**লজিক:** প্রতিটি সংখ্যা স্ক্যান করার সময় চেক করুন `target - number` আগে থেকেই Hash Map এ আছে কি না।

```java
public int[] twoSum(int[] nums, int target) {
    // Key = Number, Value = Index
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i }; // উত্তর পেয়ে গেছি!
        }
        
        // না পেলে ম্যাপে সেভ করে রাখবো ভবিষ্যতের জন্য
        map.put(nums[i], i);
    }
    
    return new int[]{}; // কোনো পেয়ার নেই
}
```

### B. First Unique Character in a String
**লজিক:** প্রথমে পুরো স্ট্রিং স্ক্যান করে ক্যারেক্টারগুলোর ফ্রিকোয়েন্সি (কাউন্ট) Hash Map-এ সেভ করুন। তারপর আবার স্ক্যান করে দেখুন কার কাউন্ট ১।

```java
public int firstUniqChar(String s) {
    HashMap<Character, Integer> countMap = new HashMap<>();
    
    // ১ম পাস: ফ্রিকোয়েন্সি কাউন্ট
    for (char c : s.toCharArray()) {
        countMap.put(c, countMap.getOrDefault(c, 0) + 1);
    }
    
    // ২য় পাস: প্রথম ইউনিক ক্যারেক্টার খোঁজা
    for (int i = 0; i < s.length(); i++) {
        if (countMap.get(s.charAt(i)) == 1) {
            return i; // ইনডেক্স রিটার্ন
        }
    }
    
    return -1; // কোনো ইউনিক ক্যারেক্টার নেই
}
```

## 3. Edge Cases & Gotchas
- **`null` Keys:** জাভার `HashMap` এ সর্বোচ্চ ১টি `null` Key রাখা যায় (এটি ইনডেক্স 0 তে বসে)। কিন্তু `HashTable` বা `ConcurrentHashMap` এ `null` Key বা Value অ্যালাউড না (NullPointerException খাবে)।
- **Custom Objects as Keys:** যদি আপনি নিজের বানানো কোনো ক্লাস (যেমন `Employee`) কে Key হিসেবে ব্যবহার করতে চান, তবে অবশ্যই সেই ক্লাসের `hashCode()` এবং `equals()` মেথড ওভাররাইড (Override) করতে হবে। না হলে ডেটা স্টোর হবে ঠিকই, কিন্তু পরে আর খুঁজে পাবেন না! (ইন্টারভিউয়ের জন্য খুবই ইম্পর্ট্যান্ট!)
