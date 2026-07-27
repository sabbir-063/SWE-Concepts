# 03. Memory Management (Code & Implementations)

এই ফাইলে আমরা মেমোরি অ্যালোকেশনের (Contiguous) ৩টি পপুলার অ্যালগরিদম—**First Fit, Best Fit এবং Worst Fit** কীভাবে কাজ করে তা জাভা (Java) কোডের মাধ্যমে সিমুলেট করে দেখবো।

ধরা যাক, আমাদের RAM এ কয়েকটি ফাঁকা মেমোরি ব্লক (Hole/Block) আছে। এখন একটি নতুন প্রসেস আসলে তাকে কোন ব্লকে বসানো হবে?

---

## 1. First Fit (যেটা আগে পাবো, সেটাতেই বসবো)
এটি সবচেয়ে সিম্পল এবং ফাস্ট লজিক। এটি শুরু থেকে চেক করা শুরু করবে, যে ব্লকটির সাইজ প্রসেসের সাইজের চেয়ে বড় বা সমান হবে, সে চোখ বন্ধ করে সেখানেই বসে যাবে।

```java
public class FirstFit {
    public static void main(String[] args) {
        int[] blockSizes = {100, 500, 200, 300, 600}; // RAM এর ফাঁকা ব্লকগুলো
        int[] processSizes = {212, 417, 112, 426};    // যে প্রসেসগুলো আসবে
        
        int m = blockSizes.length;
        int n = processSizes.length;
        int[] allocation = new int[n]; // কোন প্রসেস কোন ব্লকে গেলো তার হিসাব
        
        // শুরুতে সব প্রসেসকে -1 (Unallocated) ধরে নিই
        for (int i = 0; i < n; i++) allocation[i] = -1;

        // প্রতিটি প্রসেসের জন্য ব্লক খোঁজা
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // ব্লকটি যদি প্রসেসের চেয়ে বড় বা সমান হয়
                if (blockSizes[j] >= processSizes[i]) {
                    allocation[i] = j; // প্রসেসটিকে এই ব্লকে বসিয়ে দাও
                    // প্রসেসটি বসার পর ব্লকের ফাঁকা জায়গা কমিয়ে দাও
                    blockSizes[j] -= processSizes[i]; 
                    break; // জায়গা পেয়ে গেছি, আর খোঁজার দরকার নেই (First Fit)
                }
            }
        }

        // আউটপুট প্রিন্ট করা
        System.out.println("Process No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i+1) + "\t\t" + processSizes[i] + "\t\t");
            if (allocation[i] != -1) System.out.print(allocation[i] + 1);
            else System.out.print("Not Allocated");
            System.out.println();
        }
    }
}
```
**Output Explanation:** P1 (212) খুঁজবে কে তার চেয়ে বড়। 100 ছোট, কিন্তু 500 বড়। তাই সে Block-2 তে বসবে। Block-2 এর জায়গা বাকি থাকবে (500-212) = 288.

---

## 2. Best Fit (একদম মাপে মাপে বসাবো)
এখানে প্রসেসটি বসার জন্য সবচেয়ে পারফেক্ট (সবচেয়ে ছোট কিন্তু যথেষ্ট বড়) ব্লকটি খুঁজবে, যাতে Internal Fragmentation (জায়গা নষ্ট) সবচেয়ে কম হয়।

```java
public class BestFit {
    public static void main(String[] args) {
        int[] blockSizes = {100, 500, 200, 300, 600};
        int[] processSizes = {212, 417, 112, 426};
        
        int m = blockSizes.length;
        int n = processSizes.length;
        int[] allocation = new int[n];
        
        for (int i = 0; i < n; i++) allocation[i] = -1;

        for (int i = 0; i < n; i++) {
            int bestIdx = -1; // সবচেয়ে ভালো ব্লকের ইনডেক্স
            for (int j = 0; j < m; j++) {
                if (blockSizes[j] >= processSizes[i]) {
                    // যদি আগে কোনো বেস্ট ব্লক না পেয়ে থাকি, অথবা বর্তমান ব্লকটি আগের বেস্টের চেয়েও ছোট (পারফেক্ট) হয়
                    if (bestIdx == -1 || blockSizes[j] < blockSizes[bestIdx]) {
                        bestIdx = j;
                    }
                }
            }
            // যদি একটি বেস্ট ব্লক পাওয়া যায়
            if (bestIdx != -1) {
                allocation[i] = bestIdx;
                blockSizes[bestIdx] -= processSizes[i];
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i+1) + "\t\t" + processSizes[i] + "\t\t");
            if (allocation[i] != -1) System.out.print(allocation[i] + 1);
            else System.out.print("Not Allocated");
            System.out.println();
        }
    }
}
```
**Output Explanation:** P1 (212) এর জন্য Best Fit হবে 300 (Block 4)। কারণ 300 তে বসলে মাত্র 88 জায়গা নষ্ট হবে। সে 500 তে বসবে না। এতে করে বড় ব্লকগুলো (500, 600) বড় প্রসেসের জন্য ফাঁকা থেকে যাবে।

---

## 3. Worst Fit (সবচেয়ে বড় জায়গাটিতে বসাবো)
এটি Best Fit এর সম্পূর্ণ উল্টো। সে সবসময় সবচেয়ে বড় ফাঁকা ব্লকটিতে গিয়ে বসে। লজিক হলো, বড় ব্লকে বসলে যে বিশাল জায়গাটা বেঁচে যাবে, সেখানে হয়তো অন্য কোনো প্রসেস বসতে পারবে।
*(Worst fit এর কোড হুবহু Best fit এর মতোই, শুধু `blockSizes[j] < blockSizes[bestIdx]` এর জায়গায় `>` গ্রেটার-দেন সাইন দিতে হবে)।*
