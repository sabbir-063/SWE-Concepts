# 04. Greedy Algorithms (Code & Implementations)

এই ফাইলে আমরা ইন্টারভিউতে আসা সবচেয়ে কমন দুটি Greedy প্রবলেম (Activity Selection এবং Fractional Knapsack) জাভাতে ইমপ্লিমেন্ট করে দেখবো।

---

## 1. Activity Selection Problem
**প্রবলেম:** আপনাকে কিছু মিটিংয়ের `start` এবং `end` টাইম দেওয়া হলো। একজন মানুষ সর্বোচ্চ কয়টি মিটিং করতে পারবে?
**লজিক:** মিটিংগুলোকে তাদের `end` টাইম অনুযায়ী সর্ট করুন। এরপর প্রথমটি সিলেক্ট করুন এবং পরবর্তী মিটিংয়ের স্টার্ট টাইম যদি সিলেক্টেড মিটিংয়ের এন্ড টাইমের সমান বা বড় হয়, তবে সেটি সিলেক্ট করুন।

```java
import java.util.*;

class Activity {
    int start, end;
    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ActivitySelection {
    public static void selectActivities(List<Activity> activities) {
        // ১. End Time অনুযায়ী সর্ট করা (Greedy Choice)
        // (a, b) -> a.end - b.end মানে ছোট End Time আগে আসবে
        Collections.sort(activities, (a, b) -> a.end - b.end);

        System.out.println("Selected Activities:");
        
        // ২. প্রথম অ্যাক্টিভিটি সবসময় সিলেক্ট হবে
        Activity prevActivity = activities.get(0);
        System.out.println("[" + prevActivity.start + ", " + prevActivity.end + "]");
        
        int count = 1;

        // ৩. বাকি অ্যাক্টিভিটিগুলো চেক করা
        for (int i = 1; i < activities.size(); i++) {
            Activity currentActivity = activities.get(i);
            
            // যদি বর্তমান মিটিংয়ের স্টার্ট টাইম আগেরটার এন্ড টাইমের সমান বা পরে হয়
            if (currentActivity.start >= prevActivity.end) {
                System.out.println("[" + currentActivity.start + ", " + currentActivity.end + "]");
                prevActivity = currentActivity; // পয়েন্টার আপডেট
                count++;
            }
        }
        
        System.out.println("Total Activities Attended: " + count);
    }

    public static void main(String[] args) {
        List<Activity> list = new ArrayList<>();
        list.add(new Activity(1, 4));
        list.add(new Activity(3, 5));
        list.add(new Activity(0, 6));
        list.add(new Activity(5, 7));
        list.add(new Activity(8, 9));
        list.add(new Activity(5, 9));

        selectActivities(list);
    }
}
```
**Time Complexity:** $O(n \log n)$ (সর্টিংয়ের জন্য)।

---

## 2. Fractional Knapsack Problem
**প্রবলেম:** ব্যাগে মালপত্র ভরতে হবে ম্যাক্সিমাম প্রফিটের জন্য। আইটেম ভেঙেও নেওয়া যাবে।
**লজিক:** প্রতিটি আইটেমের Value per Weight (রেশিও) বের করে বড় থেকে ছোট সাজান (Descending order)। রেশিও অনুযায়ী ব্যাগে ভরতে থাকুন।

```java
import java.util.*;

class Item {
    int value, weight;
    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {
    public static double getMaxValue(List<Item> items, int capacity) {
        // ১. Value/Weight রেশিও অনুযায়ী বড় থেকে ছোট সর্ট করা (Greedy Choice)
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                double ratioA = (double) a.value / a.weight;
                double ratioB = (double) b.value / b.weight;
                return Double.compare(ratioB, ratioA); // Descending order
            }
        });

        double totalValue = 0.0;

        // ২. আইটেম ব্যাগে ভরা
        for (Item item : items) {
            if (capacity >= item.weight) {
                // ব্যাগ এখনো খালি আছে, পুরো আইটেমটাই ঢুকিয়ে দাও
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // ব্যাগে অল্প জায়গা আছে, আইটেম ভেঙে (Fraction) ঢোকাও
                double fraction = (double) capacity / item.weight;
                totalValue += (item.value * fraction);
                capacity = 0; // ব্যাগ ফুল
                break; // আর জায়গা নেই, লুপ ব্রেক
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(60, 10));  // রেশিও 6
        items.add(new Item(100, 20)); // রেশিও 5
        items.add(new Item(120, 30)); // রেশিও 4

        int capacity = 50;
        double maxVal = getMaxValue(items, capacity);
        System.out.println("Maximum value we can obtain = " + maxVal); // 240.0
    }
}
```
**Time Complexity:** $O(n \log n)$ (সর্টিংয়ের জন্য)।

---

## 💡 Edge Cases to Remember
- **Floating Point Comparison:** Fractional Knapsack-এ রেশিও সর্ট করার সময় ইন্টিজার ডিভিশন করবেন না। `(double) value / weight` ব্যবহার করবেন। সর্ট করার সময় `Double.compare()` ব্যবহার করা সেফ।
- **Ties in Activity Selection:** যদি দুটি মিটিংয়ের End Time সমান হয়, তবে যেকোনো একটিকে আগে নিলেও রেজাল্টে (Total count) কোনো প্রভাব পড়ে না।
