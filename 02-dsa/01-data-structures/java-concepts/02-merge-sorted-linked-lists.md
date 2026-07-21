# Merge Two Sorted Linked Lists

দুটি সর্টেড (Sorted) Linked List কে মার্জ করে একটি নতুন সর্টেড Linked List তৈরি করার কনসেপ্টটি ইন্টারভিউয়ের জন্য খুবই গুরুত্বপূর্ণ।

## Time and Space Complexity
- **Time Complexity:** **O(n + m)**, যেখানে `n` হলো প্রথম লিস্টের লেংথ এবং `m` হলো দ্বিতীয় লিস্টের লেংথ। কারণ লুপটি সর্বোচ্চ `n + m` বার চলবে, প্রতিটি নোড ঠিক একবার করে ভিজিট করা হবে।
- **Space Complexity:** **O(1)** (Auxiliary Space)। আমরা নতুন কোনো নোড তৈরি করি না, শুধু বিদ্যমান নোডগুলোর পয়েন্টার বা রেফারেন্স (next) পরিবর্তন করে লিংক জোড়া লাগাই। তাই কোনো এক্সট্রা মেমরি লাগে না।

## Explanation & Approach (Dummy Node Technique)

এই প্রবলেমটি সলভ করার বেস্ট উপায় হলো একটি **Dummy Node** ব্যবহার করা।
১. একটি `dummy` নোড তৈরি করব। এটি মার্জড লিস্টের শুরুটা (head) মনে রাখতে সাহায্য করবে।
২. একটি `current` পয়েন্টার রাখব, যা মার্জড লিস্টের একদম শেষের নোডটিকে পয়েন্ট করে থাকবে।
৩. এরপর একটি `while` লুপ চালাব যতক্ষণ না কোনো একটি লিস্ট শেষ হয়ে যায় (`list1 != null && list2 != null`)।
৪. লুপের ভেতরে চেক করব `list1` এবং `list2` এর মধ্যে কার ভ্যালু ছোট। যার ভ্যালু ছোট, `current.next` কে সেই নোডে পয়েন্ট করব এবং ওই লিস্টের পয়েন্টারটি একঘর সামনে এগিয়ে দেব।
৫. `current` পয়েন্টারটিকেও একঘর সামনে এগিয়ে দেব।
৬. লুপ শেষ হওয়ার পর যদি কোনো লিস্টে এখনো কিছু নোড বাকি থাকে (যেহেতু দুটি লিস্টের লেংথ সমান নাও হতে পারে), তবে সেই বাকি অংশটুকু সরাসরি `current.next` এ জোড়া লাগিয়ে দেব। কারণ সেগুলো আগে থেকেই সর্টেড।
৭. সবশেষে `dummy.next` রিটার্ন করব, যা আমাদের নতুন সর্টেড লিস্টের আসল হেড (head)।

## Java Code Implementation

```java
// Linked List এর নোড ক্লাস
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeSortedLists {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // একটি ডামি নোড তৈরি করা হলো যার ভ্যালু -1 (যেকোনো ডামি ভ্যালু হতে পারে)
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy; // current পয়েন্টারটি ডামি নোড থেকে শুরু হবে
        
        // যতক্ষণ দুটি লিস্টেই নোড আছে
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // list1 এর ভ্যালু ছোট হলে একে যুক্ত করব
                list1 = list1.next;   // list1 কে একঘর সামনে বাড়াবো
            } else {
                current.next = list2; // list2 এর ভ্যালু ছোট হলে একে যুক্ত করব
                list2 = list2.next;   // list2 কে একঘর সামনে বাড়াবো
            }
            current = current.next;   // current পয়েন্টারকেও সামনে বাড়াবো
        }
        
        // লুপ শেষের পর যদি list1 এ কিছু বাকি থাকে
        if (list1 != null) {
            current.next = list1;
        }
        
        // অথবা যদি list2 এ কিছু বাকি থাকে
        if (list2 != null) {
            current.next = list2;
        }
        
        // ডামি নোডের পরের নোডটিই হলো আমাদের আসল রেজাল্ট লিস্টের হেড
        return dummy.next;
    }
}
```
