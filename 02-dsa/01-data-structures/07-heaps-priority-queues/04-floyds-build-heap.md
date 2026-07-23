# Floyd's Algorithm for Build Heap ($\mathcal{O}(n)$ Time Complexity)

> **Module:** 02 - Data Structures & Algorithms (DSA)  
> **Chapter:** 01 - Data Structures  
> **Topic:** 07 - Heaps & Priority Queues  
> **File:** `04-floyds-build-heap.md`

---

## 🎯 1. সমস্যা ও সমাধান (Problem & Intuition)

অবিন্যস্ত (Unsorted) একটি অ্যারে থেকে Heap তৈরি করার জন্য ২টি উপায়ের তুলনা করা যাক:

### ১.১ Naive Approach: Successive Insertion ($\mathcal{O}(n \log n)$)
- **পদ্ধতি:** একটি ফাঁকা Heap দিয়ে শুরু করা হয়। এরপর অ্যারের প্রতিটি এলিমেন্টকে এক এক করে `insert()` করা হয়।
- **মেকানিজম:** প্রতি ইনসারশনে এলিমেন্টটিকে শেষে রেখে `heapify-up` বা `sift-up` পরিচালনা করা হয়।
- **টাইম কমপ্লেক্সিটি:** $i$-তম উপাদান ইনসার্ট করতে $\mathcal{O}(\log i)$ সময় লাগে।  
  $$\text{Total Time} = \sum_{i=1}^n \mathcal{O}(\log i) = \mathcal{O}(\log(n!)) = \mathcal{O}(n \log n)$$

---

### ১.২ Floyd's Algorithm: Bottom-Up Heapify ($\mathcal{O}(n)$)
- **পদ্ধতি:** প্রথমে পুরো অ্যারেকে একটি Complete Binary Tree হিসেবে চিন্তা করা হয়।
- **মেকানিজম:** 
  1. ট্রির **শেষ লিফ নোডগুলোর (Leaf Nodes) কোনো চাইল্ড নেই**, তাই তাদের ওপর `heapify` করার কোনো প্রয়োজন নেই!
  2. প্রথম **নন-লিফ নোড (Last non-leaf node)** $\lfloor \frac{n}{2} \rfloor - 1$ থেকে শুরু করে উল্টো দিকে (Index 0 পর্যন্ত) এক এক করে `heapify-down` (বা `sift-down`) পরিচালনা করা হয়।
- **টাইম কমপ্লেক্সিটি:** মাত্র **$\mathcal{O}(n)$**!

---

## 📐 2. Mathematical Proof of $\mathcal{O}(n)$ Time Complexity

> ❓ **কেন এটি $\mathcal{O}(n)$ সময় নেয়, $\mathcal{O}(n \log n)$ নয়?**

একটি Complete Binary Tree-র গঠন পর্যবেক্ষণ করো:
- ট্রির **নিচের দিকে (Leaves-এর কাছে) নোডের সংখ্যা সবচেয়ে বেশি**, কিন্তু সেখানে `heapify-down` করতে পথ বা উচ্চতা ($h$) অত্যন্ত কম (০ বা ১)।
- ট্রির **উপরের দিকে (Root-এর কাছে) নোডের সংখ্যা কম (মাত্র ১টি)**, শুধু সেইখানে উচ্চতা $h = \log n$ হয়।

```text
Level 3 (Leaves):  n/2 টি নোড  --> 0 টি সওয়াপ (উচ্চতা 0)
Level 2:          n/4 টি নোড  --> সর্বোচ্চ 1 টি সওয়াপ (উচ্চতা 1)
Level 1:          n/8 টি নোড  --> সর্বোচ্চ 2 টি সওয়াপ (উচ্চতা 2)
...
Level 0 (Root):   1 টি নোড    --> সর্বোচ্চ log n টি সওয়াপ (উচ্চতা h)
```

### গাণিতিক প্রমাণ (Mathematical Summation):
$h$ উচ্চতায় সর্বোচ্চ নোড থাকে $\lceil \frac{n}{2^{h+1}} \rceil$ টি।  
মোট কাজ $S$:
$$S = \sum_{h=0}^{\lfloor \log_2 n \rfloor} \frac{n}{2^{h+1}} \cdot h = \frac{n}{2} \sum_{h=0}^{\lfloor \log_2 n \rfloor} \frac{h}{2^h}$$

আমরা জানি, Arithmetico-Geometric Series $\sum_{h=0}^{\infty} \frac{h}{2^h}$ এর সমষ্টি:
$$\sum_{h=0}^{\infty} \frac{h}{2^h} = 0 + \frac{1}{2} + \frac{2}{4} + \frac{3}{8} + \frac{4}{16} + \dots = 2$$

সুতরাং:
$$S \le \frac{n}{2} \cdot 2 = \mathcal{O}(n)$$

**উপসংহার:** বেশিরভাগ নোড লিফ বা লিফের কাছাকাছি থাকায় মোট কাজের পরিমাণ $\mathcal{O}(n)$ এ সীমাবদ্ধ থাকে।

---

## 💻 3. Complete Java Code Implementation

```java
import java.util.Arrays;

public class FloydBuildHeap {

    /**
     * Floyd's Build-Heap Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1) Auxiliary Space (In-place)
     */
    public static void buildMaxHeap(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;

        // Last non-leaf node index = (n / 2) - 1
        int lastNonLeafIndex = (n / 2) - 1;

        // Bottom-Up Heapify: Start from last non-leaf node down to root index 0
        for (int i = lastNonLeafIndex; i >= 0; i--) {
            heapifyDown(arr, n, i);
        }
    }

    /**
     * Standard Heapify-Down (Sift-Down) for Max-Heap
     */
    private static void heapifyDown(int[] arr, int size, int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Check if left child exists and is greater than current largest
        if (leftChild < size && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // Check if right child exists and is greater than current largest
        if (rightChild < size && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // If largest is not current node, swap and recurse down
        if (largest != index) {
            swap(arr, index, largest);
            // Recursively heapify the affected sub-tree
            heapifyDown(arr, size, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1, 8, 9};

        System.out.println("Original Unsorted Array: " + Arrays.toString(arr));

        // Building Max Heap using Floyd's Algorithm in O(n)
        buildMaxHeap(arr);

        System.out.println("Max-Heap Built Array:    " + Arrays.toString(arr));
    }
}
```

---

## 🎨 4. Step-by-Step Visual Execution Trace

ইনপুট অ্যারে: `[4, 10, 3, 5, 1, 8, 9]`, $n = 7$

**ট্রির শুরুর দৃশ্য (Unsorted Tree):**
```text
          4 (0)
        /       \
     10 (1)      3 (2)
    /    \      /    \
  5 (3)  1 (4) 8 (5)  9 (6)
```

1. **Last Non-Leaf Index Calculation:** $\lfloor 7/2 \rfloor - 1 = 2$ (যা নোড `3`)
2. **`heapifyDown` at Index 2 (Node 3):**
   - Left child = 8, Right child = 9.
   - Max(3, 8, 9) = 9 (Index 6).
   - Swap 3 and 9 $\rightarrow$ Tree at node 2 is valid.
```text
          4 (0)
        /       \
     10 (1)      9 (2)
    /    \      /    \
  5 (3)  1 (4) 8 (5)  3 (6)
```

3. **`heapifyDown` at Index 1 (Node 10):**
   - Left child = 5, Right child = 1.
   - 10 $\ge$ 5 and 10 $\ge$ 1 $\rightarrow$ Already valid Max-Heap at index 1.

4. **`heapifyDown` at Index 0 (Node 4 - Root):**
   - Left child = 10, Right child = 9.
   - Max(4, 10, 9) = 10 (Index 1).
   - Swap 4 and 10.
   - Recurse down to Index 1 (Node 4): Left child = 5, Right child = 1.
   - Max(4, 5, 1) = 5 (Index 3).
   - Swap 4 and 5.

**চূড়ান্ত Max-Heap Tree:**
```text
          10 (0)
        /        \
      5 (1)       9 (2)
    /    \       /    \
  4 (3)  1 (4)  8 (5)  3 (6)
```
**চূড়ান্ত সর্টেড/হিপফাইড অ্যারে আউটপুট:** `[10, 5, 9, 4, 1, 8, 3]`

---

## 📊 5. Summary Comparison

| বিষয় (Aspect) | Successive Insertion | Floyd's Build Heap |
| :--- | :--- | :--- |
| **Approach** | Top-Down (`heapify-up`) | Bottom-Up (`heapify-down`) |
| **Time Complexity** | $\mathcal{O}(n \log n)$ | **$\mathcal{O}(n)$** |
| **Auxiliary Space** | $\mathcal{O}(1)$ | $\mathcal{O}(1)$ |
| **Starting Index** | Index 0 to $n-1$ | Index $\lfloor n/2 \rfloor - 1$ down to $0$ |
| **Use Case** | যখন ডেটা এক এক করে স্টিমে আসে | যখন পুরো অ্যারে একবারে হাতে থাকে |

---

## ⚠️ MCQ & Interview Gotchas

> ⚠️ **Question:** *Why does Floyd's algorithm start from index $\lfloor n/2 \rfloor - 1$?*  
> **Answer:** কারণ Complete Binary Tree-তে $\lfloor n/2 \rfloor$ থেকে $n-1$ ইনডেক্সের সব উপাদানই হলো **Leaf Nodes**। লিফ নোডগুলোর নিচে কোনো চাইল্ড না থাকায় তারা এমনিতেই ভ্যালিড ১-এলিমেন্ট হিপ। তাই তাদের হিপফাই করার প্রয়োজন নেই!
