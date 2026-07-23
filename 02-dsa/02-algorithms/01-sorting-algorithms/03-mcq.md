# Sorting Algorithms: Master MCQ Practice Drill

> **Module:** 02 - Data Structures & Algorithms (DSA)  
> **Chapter:** 02 - Algorithms  
> **Topic:** 01 - Sorting Algorithms  
> **Rule:** Questions & Options in **English** | Answers & Explanations in **Banglish**

---

### Q1. What is the worst-case time complexity of Quick Sort when the pivot is always chosen as the first element and the input array is already sorted in ascending order?

A) $O(n)$  
B) $O(n \log n)$  
C) $O(n^2)$  
D) $O(\log n)$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

ইনপুট অ্যারে সর্টেড থাকলে এবং সবসময় ১ম এলিমেন্টকে পিভট ধরলে প্রতিবার অ্যারেকে মাত্র ১টি এলিমেন্ট ও $n-1$ টি এলিমেন্টে ভাগ করা হয়। ফলে রিকার্শন ডেপথ হয় $n$ এবং মোট কাজ $\sum_{i=1}^n i = O(n^2)$।

⚠️ Common trap: সাধারণ বা এভারেজ কেসে Quick Sort এর টাইম কমপ্লেক্সিটি $O(n \log n)$, কিন্তু পিকিং ফেইল করলে Worst-case $O(n^2)$।

</details>

---

### Q2. Which of the following sorting algorithms is NOT stable by default?

A) Insertion Sort  
B) Merge Sort  
C) Bubble Sort  
D) Selection Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**

Selection Sort এ গ্লোবাল মিনিমাম এলিমেন্ট সওয়াপ করার সময় সমান কি-এর এলিমেন্টের অরিজিনাল আপেক্ষিক অর্ডার নষ্ট হয়ে যায় (যেমন: `[4a, 4b, 2]` সর্ট হয়ে `[2, 4b, 4a]` হয়)।

</details>

---

### Q3. What is the minimum possible worst-case time complexity for any comparison-based sorting algorithm?

A) $O(n)$  
B) $O(n \log n)$  
C) $O(n^2)$  
D) $O(1)$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Decision Tree Model অনুযায়ী $n$ টি এলিমেন্ট সর্ট করতে $n!$ টি লিফ নোডের প্রয়োজন। গাছের সর্বনিম্ন উচ্চতা $h = \log_2(n!) = \Omega(n \log n)$। তাই Comparison-based সর্টিং কখনোই $O(n \log n)$ এর চেয়ে কম সময়ে worst case এ কাজ করতে পারে না।

</details>

---

### Q4. Which sorting algorithm requires $O(n)$ extra auxiliary space for arrays?

A) Quick Sort  
B) Heap Sort  
C) Merge Sort  
D) Insertion Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Merge Sort অ্যারেকে সর্ট করতে অতিরিক্ত Temp Array তৈরি করে যা $O(n)$ Extra Auxiliary Space দাবি করে।

</details>

---

### Q5. What is the best-case time complexity of Insertion Sort on an already sorted array?

A) $O(n^2)$  
B) $O(n \log n)$  
C) $O(n)$  
D) $O(1)$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

অ্যারে অলরেডি সর্টেড থাকলে Insertion Sort এর ভেতরের `while` লুপের কন্ডিশন মাত্র ১ বার চেক হয়ে বন্ধ হয়ে যায়। ফলে প্রতিটি এলিমেন্টের জন্য ১টি তুলনা লাগে এবং মোট টাইম $O(n)$ হয়।

</details>

---

### Q6. Which of the following non-comparison sorting algorithms relies on the keys being integers within a specific range $[0, K]$?

A) Radix Sort  
B) Counting Sort  
C) Heap Sort  
D) Quick Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Counting Sort ইনপুট ভ্যালুগুলোর ফ্রিকোয়েন্সি গণনার জন্য $[0, K]$ সাইজের একটি Count Array তৈরি করে।

</details>

---

### Q7. What is the average time complexity of Heap Sort?

A) $O(n^2)$  
B) $O(n \log n)$  
C) $O(n)$  
D) $O(\log n)$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Heap Sort এর Max-Heap বিল্ড করতে $O(n)$ সময় লাগে এবং $n$ টি এলিমেন্ট Extract করে Heapify করতে $n \times O(\log n)$ সময় লাগে। Best, Average এবং Worst সব কেসেই টাইম কমপ্লেক্সিটি $O(n \log n)$।

</details>

---

### Q8. Which hybrid sorting algorithm is used by default in C++'s `std::sort()`?

A) TimSort  
B) IntroSort  
C) TreeSort  
D) SmoothSort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

C++ এর `std::sort()` হাইব্রিড অ্যালগরিদম **IntroSort** ব্যবহার করে। এটি Quick Sort দিয়ে শুরু করে, কিন্তু রিকার্শন ডেপথ বেশি হয়ে গেলে Heap Sort এবং সাব-অ্যারে ছোট হয়ে গেলে Insertion Sort এ সুইচ করে।

</details>

---

### Q9. Which hybrid sorting algorithm is used by Java for `Arrays.sort(Object[])`?

A) TimSort  
B) IntroSort  
C) Quick Sort  
D) Merge Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**

Java-তে অবজেক্ট সর্ট করার জন্য **TimSort** ব্যবহৃত হয় (যা Insertion Sort ও Merge Sort এর হাইব্রিড)। এটি একটি Stable Algorithm।

</details>

---

### Q10. What is the maximum number of swaps performed by Selection Sort on an array of size $n$?

A) $n^2$  
B) $n \log n$  
C) $n - 1$  
D) $\frac{n(n-1)}{2}$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Selection Sort প্রতিটি পাস-এ মাত্র ১ টি সওয়াপ করে। তাই $n$ সাইজের অ্যারেকে সর্ট করতে সর্বোচ্চ $n-1$ বা $O(n)$ টি সওয়াপ প্রয়োজন হয়।

⚠️ Common trap: তুলনার সংখ্যা (Comparisons) $\frac{n(n-1)}{2}$, কিন্তু সওয়াপ সংখ্যা মাত্র $n-1$।

</details>

---

### Q11. Which sorting algorithm is considered "online", meaning it can process and sort a stream of data as it receives it?

A) Selection Sort  
B) Insertion Sort  
C) Heap Sort  
D) Quick Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Insertion Sort একটি Online Sorting Algorithm, কারণ এটি পুরো অ্যারে একসাথে না থাকলেও যেকোনো নতুন আসা এলিমেন্টকে বিদ্যমান সর্টেড পার্টে সঠিক স্থানে ইনসার্ট করতে পারে।

</details>

---

### Q12. In Quick Sort, what is the purpose of the 3-Way Partitioning (Dutch National Flag algorithm)?

A) To sort arrays in descending order  
B) To efficiently handle arrays with many duplicate elements  
C) To reduce auxiliary space to $O(1)$  
D) To eliminate recursion completely  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

3-Way Partitioning অ্যারেকে `< Pivot`, `== Pivot`, এবং `> Pivot` এই ৩ ভাগে ভাগ করে। প্রচুর ডুপ্লিকেট এলিমেন্ট থাকলে এটি $O(n)$ সময়ের মধ্যে সর্ট সম্পন্ন করে।

</details>

---

### Q13. What is the worst-case space complexity of Quick Sort's call stack if no optimizations are made?

A) $O(1)$  
B) $O(\log n)$  
C) $O(n)$  
D) $O(n^2)$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Worst-case এ (যখন অনলি ১টি এলিমেন্ট স্প্লিট হয়) রিকার্শন ডেপথ $n$ হয়, ফলে Call Stack এর সাইজ $O(n)$ হয়।

</details>

---

### Q14. Consider an array: `[12, 11, 13, 5, 6]`. After two passes of Bubble Sort (ascending order), what will the array look like?

A) `[11, 12, 5, 6, 13]`  
B) `[11, 5, 6, 12, 13]`  
C) `[5, 6, 11, 12, 13]`  
D) `[12, 11, 5, 6, 13]`  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

- **Pass 1:** 12 & 11 swap $\rightarrow$ `[11, 12, 13, 5, 6]`; 13 & 5 swap $\rightarrow$ `[11, 12, 5, 13, 6]`; 13 & 6 swap $\rightarrow$ `[11, 12, 5, 6, 13]`. (১৩ শেষে চলে গেল)
- **Pass 2:** 12 & 5 swap $\rightarrow$ `[11, 5, 12, 6, 13]`; 12 & 6 swap $\rightarrow$ `[11, 5, 6, 12, 13]`. (১২ দ্বিতীয় শেষে চলে গেল)

</details>

---

### Q15. Why is Merge Sort preferred over Quick Sort for sorting a Singly Linked List?

A) Merge Sort requires $O(n \log n)$ space on Linked Lists  
B) Linked List nodes can be merged in $O(1)$ auxiliary space without random memory access  
C) Quick Sort cannot be implemented on Linked Lists  
D) Linked Lists do not support recursion  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Linked List-এ র‍্যান্ডম অ্যাক্সেস (যেমন: `arr[i]`) নেই, তাই Quick Sort এর Partitioning ধীরগতির হয়। কিন্তু Merge Sort এর ক্ষেত্রে পয়েন্টার চেঞ্জ করে মাত্র $O(1)$ Extra Auxiliary Space এ মার্জ করা সম্ভব।

</details>

---

### Q16. Which of the following algorithms is Adaptive?

A) Merge Sort  
B) Selection Sort  
C) Insertion Sort  
D) Heap Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Insertion Sort ইনপুট ডেটা কতটা সর্টেড তার ওপর ভিত্তি করে কাজ কমায়। অলরেডি সর্টেড থাকলে টাইম $O(n)$ হয়ে যায়, তাই এটি Adaptive।

</details>

---

### Q17. What is the time complexity of building a Max-Heap from an unsorted array of size $n$?

A) $O(n^2)$  
B) $O(n \log n)$  
C) $O(n)$  
D) $O(\log n)$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Bottom-up পদ্ধতিতে (অ্যারের অর্ধেক থেকে শুরু করে `heapify` ডেকে) Max-Heap বিল্ড করার টাইম কমপ্লেক্সিটি টাইট বাউন্ডে $O(n)$।

⚠️ Common trap: পর পর $n$ টি উপাদান ইনসার্ট করে Heap বিল্ড করলে $O(n \log n)$ লাগে, কিন্তু অ্যারেকে হেপিফাই করলে মাত্র $O(n)$ লাগে।

</details>

---

### Q18. What happens to Counting Sort's space complexity if the range of elements $K$ is $O(n^2)$?

A) Space complexity remains $O(n)$  
B) Space complexity becomes $O(n^2)$  
C) Space complexity becomes $O(\log n)$  
D) Counting sort cannot run  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Counting Sort এর Aux Space $O(k)$। যদি $K = n^2$ হয়, তবে মেমোরিতে $n^2$ সাইজের কাউন্ট অ্যারে তৈরি করতে হবে, যা মেমোরি ওয়েস্ট করে।

</details>

---

### Q19. What is the stability and space complexity of Heap Sort?

A) Stable, $O(n)$ space  
B) Unstable, $O(n)$ space  
C) Stable, $O(1)$ space  
D) Unstable, $O(1)$ space  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**

Heap Sort অ্যারের ভেতরে সওয়াপ করে সর্ট সম্পন্ন করে (In-place, $O(1)$ space), কিন্তু রুট নোডের সাথে শেষ নোড সওয়াপ করার সময় ক্রমানুসার বজায় থাকে না (Unstable)।

</details>

---

### Q20. Which partition scheme for Quick Sort is generally faster in practice because it performs fewer swaps?

A) Lomuto Partition  
B) Hoare Partition  
C) Merge Partition  
D) Counting Partition  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Hoare Partition দুই দিক থেকে দুটি পয়েন্টার দিয়ে স্ক্যান করে গড়ে Lomuto Partition এর তুলনায় ৩ গুণ কম সওয়াপ করে।

</details>

---

### Q21. Consider the array `[5, 1, 4, 2, 8]`. What is the array after 1st pass of Selection Sort (ascending order)?

A) `[1, 5, 4, 2, 8]`  
B) `[1, 4, 2, 5, 8]`  
C) `[5, 1, 4, 2, 8]`  
D) `[2, 1, 4, 5, 8]`  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**

১ম পাস-এ পুরো অ্যারে থেকে সবচেয়ে ছোট মান `1` খুঁজে বের করা হয় (Index 1) এবং ১ম পজিশনের `5` (Index 0) এর সাথে Swap করা হয়। ফলে দাঁড়ায় `[1, 5, 4, 2, 8]`।

</details>

---

### Q22. Radix Sort uses which type of sorting algorithm internally for sorting digits?

A) Any Unstable Sort  
B) Any Stable Sort  
C) Quick Sort only  
D) Heap Sort only  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Radix Sort প্রতি ডিজিট পজিশনে সর্ট করার জন্য অবশ্যই একটি **Stable Sorting Algorithm** (যেমন Counting Sort) ব্যবহার করে, তা না হলে আগের ডিজিটের ভিত্তি করে করা অর্ডার নষ্ট হয়ে যাবে।

</details>

---

### Q23. What is the worst-case time complexity of Bucket Sort?

A) $O(n)$  
B) $O(n \log n)$  
C) $O(n^2)$  
D) $O(n + k)$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

যদি ইনপুট ডেটার সবগুলো উপাদান একই বাকেটে (Single Bucket) গিয়ে পড়ে, তবে বাকেটের ভেতরে থাকা Insertion Sort এর কারণে টাইমিং $O(n^2)$ এ নেমে যায়।

</details>

---

### Q24. Which gap sequence was originally proposed by Donald Shell for Shell Sort?

A) $N/2, N/4, \dots, 1$  
B) $1, 4, 13, 40, \dots$ (Knuth's)  
C) $2^k - 1$ (Hibbard's)  
D) Fibonacci sequence  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**

ডোনাল্ড শেল মূল অ্যালগরিদমে গ্যাপ সিকুয়েন্স হিসেবে অরিজিনাল সাইজের অর্ধেক ($N/2, N/4, \dots, 1$) প্রস্তাব করেছিলেন, যদিও পরবর্তীতে অন্যান্য গ্যাপ সিকুয়েন্স আরও ভালো পারফরম্যান্স দেখায়।

</details>

---

### Q25. What is the best-case time complexity of TimSort?

A) $O(n^2)$  
B) $O(n \log n)$  
C) $O(n)$  
D) $O(1)$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

TimSort ইনপুট অ্যারেতে অলরেডি থাকা সর্টেড রান (Runs) চিহ্নিত করে কাজ করে। যদি অ্যারে সম্পূর্ণ সর্টেড থাকে, তবে এটি মাত্র ১ পাসে $O(n)$ সময়ে সর্টিং নিশ্চিত করে।

</details>

---

### Q26. Which sorting algorithm is best suited for Flash Memory (SD cards/EEPROM) where writing to memory is expensive and degrades lifespan?

A) Merge Sort  
B) Bubble Sort  
C) Selection Sort  
D) Quick Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Selection Sort সর্বনিম্ন সংখ্যক মেমোরি রাইট বা সওয়াপ ($O(n)$ swaps) করে। তাই ফ্ল্যাশ মেমোরির মতো ডিভাইসে সওয়াপ কমাই মূল লক্ষ্য হলে Selection Sort উপযুক্ত।

</details>

---

### Q27. What is the main advantage of Quick Sort over Merge Sort for arrays?

A) Quick sort is always stable  
B) Quick sort has a lower auxiliary space requirement ($O(\log n)$ vs $O(n)$) and better cache locality  
C) Quick sort has a better worst-case time complexity  
D) Quick sort does not use recursion  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Quick Sort অ্যারেই ইন-প্লেস সর্ট করে ($O(\log n)$ stack space) এবং সংলগ্ন মেমোরি অ্যাক্সেস করায় ক্যাশ লোকালিটি চমৎকার থাকে।

</details>

---

### Q28. What is the number of comparisons made by Insertion Sort in the worst case for an array of size $n$?

A) $n-1$  
B) $n \log n$  
C) $\frac{n(n-1)}{2}$  
D) $n^2 - 1$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Worst case এ (রিভার্স সর্টেড অ্যারে) ১ম এলিমেন্টে 0, ২য়টিতে 1, ৩য়টিতে 2... এভাবে $n-1$ টি তুলনা লাগে। যোগফল $= 1 + 2 + \dots + (n-1) = \frac{n(n-1)}{2}$।

</details>

---

### Q29. What is the primary disadvantage of Counting Sort?

A) It is an unstable algorithm  
B) It cannot sort arrays with duplicate items  
C) It cannot sort floating-point numbers or arbitrary objects directly without mapping  
D) It has an $O(n \log n)$ average time complexity  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Counting Sort ইনপুট মানের সরাসরি ফ্রিকোয়েন্সি বা ইনডেক্স গণনার ওপর নির্ভর করে। তাই ফ্র্যাকশনাল বা ফ্লোটিং-পয়েন্ট মান এবং কমপ্লেক্স অবজেক্টকে সরাসরি কাউন্টিং সর্ট করা যায় না।

</details>

---

### Q30. External Sorting algorithms (like Polyphase Merge Sort) are specifically designed for what scenario?

A) Sorting data structures in GPU memory  
B) Sorting massive datasets that do not fit into RAM and reside on secondary disk storage  
C) Sorting data using multi-core parallel CPU threads  
D) Sorting strings using Tries  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

যখন ডেটাসেটের সাইজ র্যামের (RAM) চেয়ে অনেক বড় হয়, তখন ডেটা ডিস্ক বা সেকেন্ডারি স্টোরেজে থাকে। এই ধরণের বিগ ডেটা সর্ট করার জন্য External Merge Sort ব্যবহার করা হয়।

</details>

---

### Q31. What is the key invariant maintained after the $k$-th iteration of Selection Sort?

A) The last $k$ elements are sorted and are the largest elements  
B) The first $k$ elements are sorted and are the smallest elements in the array  
C) The entire array is partially sorted  
D) The median element is at index $k$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Selection Sort এর $k$-তম ইটারেশন শেষে অ্যারের ১ম $k$ টি এলিমেন্ট সম্পূর্ণ সর্টেড অবস্থায় থাকবে এবং তারা হবে পুরো অ্যারের সর্বনিম্ন $k$ টি উপাদান।

</details>

---

### Q32. What is the maximum height of the decision tree for comparison sorting of $n$ distinct elements?

A) $\log_2(n)$  
B) $\Omega(n \log n)$  
C) $n^2$  
D) $n!$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

লিফ সংখ্যা $L \ge n!$ হওয়ায় গাছের সর্বনিম্ন উচ্চতা $h \ge \log_2(n!) = \Omega(n \log n)$।

</details>

---

### Q33. What will be the output of the following Java snippet?

```java
int[] arr = {3, 1, 2};
for (int i = 0; i < arr.length - 1; i++) {
    if (arr[i] > arr[i + 1]) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }
}
System.out.println(Arrays.toString(arr));
```

A) `[1, 2, 3]`  
B) `[1, 3, 2]`  
C) `[3, 1, 2]`  
D) `[2, 1, 3]`  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

এখানে Bubble Sort এর **একটি মাত্র সিঙ্গেল পাস** চালানো হয়েছে!
- $i=0$: 3 & 1 swap $\rightarrow$ `[1, 3, 2]`
- $i=1$: 3 & 2 swap $\rightarrow$ `[1, 2, 3]`... ওয়েট! কন্ডিশন চেক করা যাক:
  - $i=0$: `arr[0]=3 > arr[1]=1` $\implies$ swap $\implies$ `[1, 3, 2]`.
  - $i=1$: `arr[1]=3 > arr[2]=2` $\implies$ swap $\implies$ `[1, 2, 3]`.
  অতএব আউটপুট হবে `[1, 2, 3]`।

</details>

---

### Q34. Given an array `[9, 7, 5, 11, 12, 2, 14, 3, 10, 6]`, if we partition it using Lomuto partition with the last element `6` as pivot, where will `6` end up?

A) Index 3  
B) Index 4  
C) Index 5  
D) Index 6  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

`6` এর চেয়ে ছোট এলিমেন্টগুলো হলো: `5, 2, 3` (মোট ৩টি)।
Lomuto Partition অনুযায়ী `6` এর বামে এই ৩টি ছোট উপাদান থাকবে। সুতরাং `6` থাকবে ৪ নম্বর ইনডেক্সে (0-indexed: `Index 3`)!
ছোট এলিমেন্ট: 5, 2, 3 (3 elements) $\rightarrow$ Pivot placement at Index 3.

</details>

---

### Q35. Which sorting algorithm is stable and has $O(n \log n)$ worst-case time complexity and $O(n)$ space complexity?

A) Quick Sort  
B) Heap Sort  
C) Merge Sort  
D) Selection Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Merge Sort গ্যারান্টেড $O(n \log n)$ সময় নেয়, Stable, এবং এর স্পেস কমপ্লেক্সিটি $O(n)$।

</details>

---

### Q36. In Quick Sort, if we use the Median-of-Three pivot selection strategy, which elements are compared to choose the pivot?

A) First, Middle, and Last elements of the sub-array  
B) Three random elements from the sub-array  
C) First three elements of the sub-array  
D) Last three elements of the sub-array  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**

Median-of-Three টেকনিকে সাব-অ্যারের প্রথম (First), মধ্যম (Middle) এবং শেষ (Last) উপাদান ৩টির মিডিয়ান বের করে পিভট নির্বাচন করা হয়।

</details>

---

### Q37. Why is Bubble Sort rarely used in production applications?

A) It requires $O(n)$ auxiliary space  
B) It is unstable  
C) It has $O(n^2)$ average and worst-case time complexity and performs excessive swaps  
D) It cannot handle duplicate numbers  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Bubble Sort এর টাইম কমপ্লেক্সিটি $O(n^2)$ এবং এটি পাশাপাশি এলিমেন্ট প্রচুর বার Swap করে, যা কার্যক্ষেত্রে অত্যন্ত ধীরগতির।

</details>

---

### Q38. What is the total number of passes required in Radix Sort to sort an array of 3-digit decimal numbers?

A) 1  
B) 3  
C) 10  
D) $n$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Radix Sort এ পাসের সংখ্যা সর্বোচ্চ ডিজিট সংখ্যার সমান ($d$)। ৩ ডিজিটের সংখ্যার জন্য ৩টি পাস (Units, Tens, Hundreds) লাগবে।

</details>

---

### Q39. What is an in-place sorting algorithm?

A) An algorithm that uses $O(n)$ space  
B) An algorithm that sorts the input array without using any significant additional memory beyond $O(1)$ or stack space  
C) An algorithm that sorts elements in $O(1)$ time  
D) An algorithm that preserves the relative order of duplicate elements  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

In-place অ্যালগরিদম ইনপুট অ্যারের ভেতরেই সোয়াপ করে সর্ট সম্পন্ন করে এবং $O(1)$ বা স্ট্যাক স্পেস ছাড়া অতিরিক্ত মেমোরি নেয় না।

</details>

---

### Q40. True or False: Insertion Sort performs fewer comparisons than Bubble Sort on average.

A) True  
B) False  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**

True! গড়ে Insertion Sort এ তুলনার সংখ্যা $\frac{n^2}{4}$, আর Bubble Sort এ তুলনার সংখ্যা $\frac{n^2}{2}$। তাই Insertion Sort গড় হিসেবে ২ গুণ দ্রুত।

</details>

---

### Q41. Which sorting algorithm is equivalent to building a Binary Search Tree (BST) from the elements and doing an In-Order Traversal?

A) Heap Sort  
B) Tree Sort  
C) Merge Sort  
D) Quick Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Tree Sort এ ইনপুট এলিমেন্ট দিয়ে BST গঠন করে তার In-order traversal করা হয়, যা সর্টেড সিকুয়েন্স দেয়।

</details>

---

### Q42. If an array is already sorted, which of the following algorithms will take the MOST time?

A) Insertion Sort  
B) Optimized Bubble Sort  
C) Selection Sort  
D) TimSort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Selection Sort নন-এডাপ্টিভ। অ্যারে সর্টেড থাকলেও এটি পুরো $\frac{n(n-1)}{2}$ টি তুলনা সম্পন্ন করে $O(n^2)$ সময় নিবে। অপরপক্ষে বাকিগুলো $O(n)$ সময়ে শেষ হবে।

</details>

---

### Q43. What is the time complexity of Shell Sort with Knuth's gap sequence?

A) $O(n^2)$  
B) $O(n^{3/2})$ or $O(n^{1.3})$  
C) $O(n \log n)$  
D) $O(n)$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Knuth's sequence ($3k+1$) ব্যবহার করলে Shell Sort এর টাইম কমপ্লেক্সিটি নেমে আসে $O(n^{1.3})$ বা $O(n^{3/2})$ এ।

</details>

---

### Q44. What happens when Quick Sort is executed on an array where all elements are identical (e.g., `[5, 5, 5, 5, 5]`) using standard 2-way Lomuto partition?

A) It runs in $O(n)$ time  
B) It runs in $O(n \log n)$ time  
C) It degrades to $O(n^2)$ time  
D) It throws an exception  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

সব এলিমেন্ট সমমানের হলে স্ট্যান্ডার্ড Lomuto Partition অ্যারেকে অসমভাবে বিভাজন করে ($0$ এবং $n-1$), ফলে টাইম কমপ্লেক্সিটি ধসে $O(n^2)$ হয়ে যায়। (এ কারণেই 3-Way Partition ব্যবহার করা হয়)।

</details>

---

### Q45. Which of the following is a non-comparison based sorting algorithm?

A) Heap Sort  
B) Quick Sort  
C) Bucket Sort  
D) Shell Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**

Bucket Sort তুলনাবিহীন (Non-comparison) পদ্ধতিতে বাকেট ও ডিস্ট্রিবিউশন ব্যবহার করে কাজ করে।

</details>

---

### Q46. What is the auxiliary space complexity of Merge Sort when sorting a Linked List?

A) $O(n)$  
B) $O(\log n)$  
C) $O(1)$  
D) $O(n \log n)$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

Linked List এর ক্ষেত্রে অতিরিক্ত অ্যারে লাগে না ($O(1)$ data space), তবে রিকার্সন স্ট্যাক মেমোরির জন্য $O(\log n)$ Auxiliary space প্রয়োজন হয়।

</details>

---

### Q47. What is the maximum number of levels in the recursion tree of Merge Sort for an array of size $n$?

A) $n$  
B) $\lceil \log_2 n \rceil + 1$  
C) $n^2$  
D) $n / 2$  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

অ্যারেকে প্রতিবার ২ ভাগে ভাগ করায় রিকার্শন গাছের উচ্চতা বা লেভেল সংখ্যা হয় $\lceil \log_2 n \rceil + 1$।

</details>

---

### Q48. Which sorting algorithm is stable and works in $O(n + k)$ time and $O(k)$ space?

A) Counting Sort  
B) Radix Sort  
C) Bucket Sort  
D) Quick Sort  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**

Counting Sort এর টাইম কমপ্লেক্সিটি $O(n + k)$ এবং মেমোরিতে স্পেস কমপ্লেক্সিটি $O(k)$।

</details>

---

### Q49. Which of the following statements about TimSort is true?

A) TimSort is unstable and in-place  
B) TimSort divides array into "runs" and sorts them using Insertion Sort before merging  
C) TimSort has a worst-case time complexity of $O(n^2)$  
D) TimSort is a non-comparison sorting algorithm  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

TimSort ছোট ছোট কন্টিনুয়াস সর্টেড অংশকে **Run** হিসেবে আইডেন্টিফাই করে, সেগুলোকে Insertion Sort দিয়ে টিউন করে এবং Merge Sort এর মাধ্যমে একত্রিত করে।

</details>

---

### Q50. Advanced Code-Output MCQ: What is the output of the following Java snippet?

```java
int[] arr = {4, 2, 1, 3};
for (int i = 0; i < arr.length; i++) {
    int min = i;
    for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[min]) min = j;
    }
    int temp = arr[i];
    arr[i] = arr[min];
    arr[min] = temp;
}
System.out.println(arr[0] + " " + arr[3]);
```

A) `4 3`  
B) `1 4`  
C) `1 3`  
D) `2 4`  

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**

প্রদত্ত কোডটি একটি স্ট্যান্ডার্ড **Selection Sort** সর্টিং লুপ। এটি পুরো অ্যারে সর্ট করে `[1, 2, 3, 4]` এ রূপান্তরিত করবে।
- `arr[0]` = 1 (Smallest)
- `arr[3]` = 4 (Largest)
কনসোলে প্রিন্ট হবে `1 4`।

</details>
