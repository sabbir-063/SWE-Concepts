# 03. Searching Algorithms (Practice MCQs)

This file contains 40 in-depth MCQs on Linear Search, Binary Search, Time Complexities, Edge Cases, and Java's built-in search methods.

---

**Q1. What is the worst-case time complexity of Linear Search?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Worst-case এ যে ডেটাটি খুঁজছি তা অ্যারের একদম শেষে থাকতে পারে বা অ্যারেতে না-ও থাকতে পারে। তখন অ্যারের $n$ টি ইলিমেন্টই চেক করতে হয়, তাই কমপ্লেক্সিটি $O(n)$।
</details>

---

**Q2. What is the primary prerequisite for Binary Search algorithm to work?**
A) The array elements must be positive numbers
B) The array size must be an even number
C) The array elements must be sorted
D) The array elements must only be integers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Binary Search কাজ করে "অর্ধেক বাদ দেওয়ার" (Divide and Conquer) নীতির ওপর। ডেটা সর্টেড না থাকলে বোঝা যাবে না যে বামে খুঁজবো নাকি ডানে।
</details>

---

**Q3. What is the time complexity of Binary Search?**
A) $O(n)$
B) $O(\log n)$
C) $O(n \log n)$
D) $O(1)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: প্রতিবার সার্চ স্পেস অর্ধেক হয়ে যায়। তাই $N$ সাইজের অ্যারেতে ম্যাক্সিমাম $\log_2(N)$ বার চেক করতে হয়।
</details>

---

**Q4. What is the space complexity of the iterative implementation of Binary Search?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: Iterative মেথডে শুধু কয়েকটি ভেরিয়েবল (left, right, mid) ব্যবহার করা হয়, কোনো এক্সট্রা মেমোরি বা কল-স্ট্যাক লাগে না। তাই $O(1)$।
</details>

---

**Q5. If Binary Search is implemented recursively, what will be its space complexity?**
A) $O(1)$
B) $O(\log n)$
C) $O(n)$
D) $O(n \log n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: রিকার্সিভ কলে প্রতিবার মেমোরিতে একটি করে স্ট্যাক ফ্রেম তৈরি হয়। যেহেতু ম্যাক্সিমাম $\log n$ বার কল হয়, তাই কল-স্ট্যাকের জন্য $O(\log n)$ স্পেস লাগে।
</details>

---

**Q6. [Interview Gotcha] What is the safest way to calculate `mid` in Binary Search in Java to avoid integer overflow?**
A) `(left + right) / 2`
B) `(left + right) >> 1`
C) `left + (right - left) / 2`
D) `left + right / 2`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যদি `left` এবং `right` দুটোই খুব বড় সংখ্যা হয়, তবে তাদের যোগফল Integer এর ম্যাক্স লিমিট ক্রস করে ওভারফ্লো (Overflow) করতে পারে এবং নেগেটিভ ভ্যালু দিতে পারে। `left + (right - left) / 2` ওভারফ্লো প্রিভেন্ট করে।
</details>

---

**Q7. What is the worst-case time complexity of Interpolation Search?**
A) $O(\log (\log n))$
B) $O(\log n)$
C) $O(n)$
D) $O(1)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Interpolation Search ভালো কাজ করে যখন ডেটা ইউনিফর্মলি ডিস্ট্রিবিউটেড (সমান গ্যাপে) থাকে। কিন্তু ডেটা যদি ছড়ানো-ছিটানো (Skewed) থাকে, তবে এটি $O(n)$ বা লিনিয়ার টাইমে নেমে যেতে পারে।
</details>

---

**Q8. In which scenario does Interpolation Search perform better than Binary Search?**
A) When the array is unsorted
B) When the elements are uniformly distributed and the array size is very large
C) When the array contains many duplicate elements
D) When memory constraints are tight

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেমন ডিকশনারিতে 'Z' খুঁজতে আমরা সরাসরি শেষের দিকে চলে যাই, তেমনি Uniform ডেটাতে Interpolation Search সরাসরি অনুমিত জায়গায় চলে যায়, যার টাইম $O(\log(\log n))$।
</details>

---

**Q9. Into how many parts does Ternary Search divide the array?**
A) 2 parts
B) 3 parts
C) 4 parts
D) It does not divide the array

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Ternary Search এ দুটি মিড পয়েন্ট (mid1, mid2) দিয়ে অ্যারেকে সমান ৩ ভাগে ভাগ করা হয়। এর Time Complexity $O(\log_3 n)$।
</details>

---

**Q10. Practically, which one is faster between Binary Search and Ternary Search?**
A) Ternary Search
B) Binary Search
C) Both perform equally fast
D) It depends entirely on the array elements

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: গাণিতিকভাবে $\log_3 n < \log_2 n$ হলেও, Ternary Search এ প্রতি ধাপে ২টি কম্পারিজন (Comparison) করতে হয়, যেখানে Binary তে মাত্র ১টি। তাই প্র্যাকটিক্যালি Binary Search দ্রুত কাজ করে।
</details>

---

**Q11. When is Exponential Search typically used?**
A) In an unsorted array
B) In a sorted array of infinite or unknown size
C) In a singly linked list
D) In a Binary Search Tree

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যখন অ্যারের সাইজ জানা থাকে না (Infinite streams), তখন $2^0, 2^1, 2^2...$ এভাবে লাফ দিয়ে বাউন্ডারি বের করা হয়, তারপর ওই বাউন্ডারির মাঝে Binary Search করা হয়।
</details>

---

**Q12. To find the "First Occurrence" of a target in a sorted array, what modification is needed in standard Binary Search when `arr[mid] == target`?**
A) Break the loop immediately and return `mid`
B) Record `mid` and continue searching in the left half (`right = mid - 1`)
C) Record `mid` and continue searching in the right half (`left = mid + 1`)
D) This cannot be done using Binary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যেহেতু ডেটা সর্টেড, তাই ডুপ্লিকেট ডেটাগুলো পাশাপাশি থাকবে। `target` পেলেও তার আগের ইনডেক্সগুলোতে একই ভ্যালু আছে কি না তা নিশ্চিত করতে বাম দিকে (left side) মুভ করতে হয়।
</details>

---

**Q13. To find the "Last Occurrence" of a target in a sorted array, what modification is needed in standard Binary Search when `arr[mid] == target`?**
A) Search in the left half (`right = mid - 1`)
B) Record `mid` and continue searching in the right half (`left = mid + 1`)
C) Reverse the loop execution order
D) Break the loop immediately

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `target` পাওয়ার পরও ডান দিকে (Right side) আরও একই ভ্যালু আছে কি না তা চেক করার জন্য `left = mid + 1` করতে হয়।
</details>

---

**Q14. What does Java's `Arrays.binarySearch(arr, key)` return if the key is not found in the array?**
A) `-1`
B) `false`
C) `NullPointerException`
D) `-(insertion point) - 1`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: জাভার বিল্ট-ইন মেথড ডেটা না পেলে নেগেটিভ ভ্যালু দেয়। এটি এমনভাবে ডিজাইন করা যে, `-(insertion point) - 1` রিটার্ন করে। অর্থাৎ যেখানে ভ্যালুটি বসালে অ্যারেটি সর্টেড থাকতো, তার ওপর ভিত্তি করে নেগেটিভ নাম্বার দেয়।
</details>

---

**Q15. Given `arr = [10, 20, 30, 40, 50]`. If you call `Arrays.binarySearch(arr, 25)`, what will be the output?**
A) `-1`
B) `-2`
C) `-3`
D) `2`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: `25` বসানোর সঠিক জায়গা হলো ইনডেক্স 2 (30 এর জায়গায়)। ফর্মুলা অনুযায়ী: `-(2) - 1 = -3` রিটার্ন করবে।
</details>

---

**Q16. Can Binary Search be efficiently applied to a standard Singly Linked List?**
A) Yes, in $O(\log n)$ time
B) No, because Linked Lists lack random access, taking $O(n)$ time just to find the middle element
C) Yes, provided it is a Doubly Linked List
D) No, because Linked Lists cannot be sorted

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Array তে `arr[mid]` দিয়ে $O(1)$ টাইমে মাঝের এলিমেন্ট পাওয়া যায়। কিন্তু Linked List এ মাঝখানে যেতে লুপ চালিয়ে $O(n)$ সময় লাগে, ফলে Binary Search এর মূল সুবিধাটাই নষ্ট হয়ে যায়।
</details>

---

**Q17. Which of the following is a classic example of a "Divide and Conquer" algorithm?**
A) Linear Search
B) Binary Search
C) Bubble Sort
D) Insertion Sort

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Binary Search প্রতি ধাপে প্রবলেমটিকে (অ্যারেকে) অর্ধেক করে ফেলে, তাই এটি Divide and Conquer এর চমৎকার উদাহরণ।
</details>

---

**Q18. In standard Binary Search (with `while(left <= right)`), what is the condition of `left` and `right` pointers when the loop terminates without finding the target?**
A) `left == right`
B) `left > right` (they cross each other)
C) `left < right`
D) `left = 0`, `right = 0`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `while (left <= right)` লুপটি তখনই ব্রেক হয় যখন `left` পয়েন্টারটি `right` কে ক্রস করে সামনে চলে যায় (অর্থাৎ `left > right` হয়)। এর মানে পুরো সার্চ স্পেস শেষ।
</details>

---

**Q19. What is the maximum number of comparisons required by Binary Search in the worst case for a sorted array of 1,000,000 elements?**
A) 1,000,000
B) Around 10
C) Around 20
D) 500,000

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: $2^{20} \approx 1,000,000$। অর্থাৎ ১ মিলিয়ন ডেটাকে অর্ধেক করতে করতে ১ এ পৌঁছাতে সর্বোচ্চ ২০ বার ভাগ করতে হবে। ($\log_2(1,000,000) \approx 20$)।
</details>

---

**Q20. What does the "Floor of a Number" mean in the context of Binary Search variations?**
A) The smallest number in the array
B) The greatest element in the array that is smaller than or equal to the target
C) The smallest element in the array that is greater than or equal to the target
D) The index of the target

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Floor মানে হলো ওই নাম্বারের ঠিক ইমিডিয়েট ছোট বা সমান ভ্যালু। যেমন `[2, 4, 6, 8]` এ 5 এর Floor হলো 4।
</details>

---

**Q21. What does the "Ceiling (Ceil) of a Number" mean?**
A) The greatest element in the array that is smaller than the target
B) The smallest element in the array that is greater than or equal to the target
C) The largest number in the array
D) The index of the target

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Ceil মানে হলো ওই নাম্বারের ঠিক ইমিডিয়েট বড় বা সমান ভ্যালু। যেমন `[2, 4, 6, 8]` এ 5 এর Ceil হলো 6।
</details>

---

**Q22. What is the core logic to achieve $O(\log n)$ time in LeetCode's "Search in Rotated Sorted Array" problem?**
A) Sorting the array first before searching
B) Falling back to Linear Search
C) Checking at each step whether the left half or the right half from `mid` is completely sorted
D) Splitting the array into two separate new arrays

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: Rotated Array তে যেকোনো Mid পয়েন্ট নিলে হয় তার বাম দিক সর্টেড থাকবে, না হয় ডান দিক সর্টেড থাকবে। এই প্রপার্টি কাজে লাগিয়ে Binary Search করা হয়।
</details>

---

**Q23. [Code Output] What is the major bug in the following Binary Search implementation?**
```java
int left = 0, right = arr.length - 1;
while(left < right) {
    int mid = left + (right - left) / 2;
    if(arr[mid] == target) return mid;
    else if(arr[mid] < target) left = mid; // Here
    else right = mid - 1;
}
```
A) There is no bug
B) Assigning `left = mid` can lead to an Infinite Loop when `left` and `right` are adjacent
C) `mid` calculation is syntactically wrong
D) The `while` condition is wrong

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: যখন `left` এবং `right` পাশাপাশি থাকে (যেমন ২ ও ৩), তখন `mid` হবে ২। যদি `arr[mid] < target` হয়, তবে `left = mid` করলে `left` ২-ই থেকে যাবে এবং লুপটি আজীবন চলতে থাকবে! সঠিক নিয়ম হলো `left = mid + 1`।
</details>

---

**Q24. What is the difference in time complexity when searching for an element in a Binary Search Tree (BST) versus applying Binary Search on a Sorted Array?**
A) BST takes $O(n)$, Array takes $O(\log n)$
B) BST takes $O(\log n)$ if balanced but $O(n)$ if skewed, whereas Sorted Array always guarantees $O(\log n)$
C) Both always guarantee $O(\log n)$
D) Array takes $O(n)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: BST যদি একপাশে লম্বা হয়ে যায় (Skewed), তবে সার্চ টাইম $O(n)$ হয়ে যায়। কিন্তু Array তে সরাসরি Mid ইনডেক্সে যাওয়া যায় বলে সবসময় $O(\log n)$ গ্যারান্টিড।
</details>

---

**Q25. When is the "Binary Search on Answer" (Monotonic Search) technique primarily used?**
A) When searching for a character in a String
B) When the range of possible answers is known and the validity of answers forms a monotonic function (e.g., all `false` followed by all `true`)
C) When the given array is unsorted
D) When traversing a Graph

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: অনেক প্রবলেমে ডাইরেক্ট ডেটা খুঁজতে না বলে ক্যাপাসিটি বা স্পিড বের করতে বলে। সেখানে আমরা উত্তরের রেঞ্জের ওপর Binary Search চালিয়ে চেক করি। (যেমন: Koko Eating Bananas - LeetCode 875)।
</details>

---

**Q26. What is the only guaranteed way to find a specific element in an completely unsorted array?**
A) Binary Search
B) Interpolation Search
C) Linear Search
D) Ternary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: যেহেতু ডেটা এলোমেলো, তাই প্রথম থেকে শেষ পর্যন্ত একটি একটি করে চেক করা (Linear Search) ছাড়া আর কোনো উপায় নেই।
</details>

---

**Q27. You have a 2D Matrix where both rows and columns are sorted. To search for an element in $O(N+M)$ time, from which position should you ideally start the search?**
A) Top-Left corner (0, 0)
B) Bottom-Right corner (N, M)
C) Top-Right corner (0, M-1) or Bottom-Left corner (N-1, 0)
D) From the exact middle of the matrix

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: টপ-রাইট কর্নার থেকে শুরু করলে বামে গেলে ভ্যালু কমে আর নিচে নামলে ভ্যালু বাড়ে। এটি অনেকটা Binary Search এর ডিসিশন মেকিংয়ের মতো কাজ করে, ফলে খুব দ্রুত টার্গেট পাওয়া যায়।
</details>

---

**Q28. What is the logic behind finding a "Peak Element" (an element strictly greater than its neighbors) in $O(\log n)$ time?**
A) Linear Search through all elements
B) Binary Search by comparing `arr[mid]` with `arr[mid+1]` to determine the slope's direction
C) Sorting the entire array first
D) Hashing all elements

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `mid` এবং `mid+1` চেক করে বোঝা যায় গ্রাফটি উপরের দিকে উঠছে নাকি নিচের দিকে নামছে। উপরের দিকে উঠলে পিক ডানদিকে আছে, আর নামলে পিক বামদিকে আছে।
</details>

---

**Q29. In standard Binary Search, if the array contains multiple occurrences of the target and you use `if (arr[mid] == target) return mid;`, which index is returned?**
A) Guaranteed first index
B) Guaranteed last index
C) Any index that happens to match `mid` first during execution
D) A list of all matching indices

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: নরমাল Binary Search গ্যারান্টি দেয় না যে সে ফার্স্ট বা লাস্ট ইনডেক্সটাই দেবে। লুপ চালানোর সময় যে ইনডেক্সটি প্রথম `mid` এর সাথে ম্যাচ করে যাবে, সেটিই রিটার্ন হয়ে যাবে।
</details>

---

**Q30. What will be the output of `System.out.println(Arrays.binarySearch(new int[]{1, 2, 4, 5}, 3));` in Java?**
A) `-2`
B) `-3`
C) `-1`
D) `2`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: 3 এর সঠিক পজিশন হলো ইনডেক্স 2 (4 এর জায়গায়)। তাই আউটপুট হবে `-(2) - 1 = -3`।
</details>

---

**Q31. What is the average-case time complexity of Linear Search in an array of 1000 elements?**
A) $O(\log n)$
B) $O(1)$
C) Mathematically $O(n/2)$, which simplifies to $O(n)$ in Big-O notation
D) $O(n^2)$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: C**
ব্যাখ্যা: গড়ে আপনাকে অ্যারের অর্ধেক (৫০০ বার) স্ক্যান করতে হতে পারে। তবে Big-O নোটেশনে কনস্ট্যান্ট (1/2) বাদ দেওয়া হয়, তাই এটি $O(n)$ ই থাকে।
</details>

---

**Q32. Under which specific condition can Linear Search perform faster than Binary Search?**
A) When the target element is located at the very first index (index 0)
B) When the array size is astronomically large
C) When the target element is located exactly in the middle of the array
D) When the array is perfectly sorted

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: টার্গেট যদি ইনডেক্স 0 তেই থাকে, তবে Linear Search প্রথম চেক করেই উত্তর দিয়ে দেবে ($O(1)$)। কিন্তু Binary Search প্রথমে মাঝখানে যাবে, তারপর বামে আসবে, ফলে একটু বেশি স্টেপ লাগবে।
</details>

---

**Q33. How does the "Jump Search" algorithm work?**
A) It checks elements at completely random indices
B) It jumps ahead by fixed block sizes (e.g., $\sqrt{n}$) to find a boundary, then performs Linear Search within that block
C) It divides the array in half iteratively like Binary Search
D) It is specifically designed for Singly Linked Lists

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Jump Search এ $\sqrt{n}$ স্টেপ পর পর জাম্প করে বাউন্ডারি খোঁজা হয়। এর Time Complexity $O(\sqrt{n})$ যা Linear Search এর চেয়ে ভালো কিন্তু Binary Search এর চেয়ে স্লো।
</details>

---

**Q34. In C++ STL, which functions are provided for Binary Search variations (useful to know as Java alternatives)?**
A) `binary_search()`, `lower_bound()`, `upper_bound()`
B) `find()`
C) `search()`
D) `b_search()`

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: A**
ব্যাখ্যা: `binary_search()` শুধু True/False দেয়। `lower_bound()` ফার্স্ট অকারেন্স বা Ceil দেয় এবং `upper_bound()` টার্গেটের ঠিক বড় ভ্যালুটি দেয়।
</details>

---

**Q35. You are building a 3D game and need to detect collision between objects whose positions are unsorted. Which search approach is typically used at a basic level?**
A) Binary Search
B) Linear Search (or advanced Spatial Partitioning like Quadtrees)
C) Interpolation Search
D) Jump Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: পজিশন আনসর্টেড থাকলে Linear Search ই বেসিক উপায়। তবে ગેম ইঞ্জিনে অপ্টিমাইজ করার জন্য Quadtree/Octree (Spatial Partitioning) ব্যবহার করা হয়।
</details>

---

**Q36. What is the primary advantage of using Bitwise Right Shift (`>>> 1`) to calculate `mid` in Java?**
A) It reduces the overall size of the array
B) It performs an unsigned right shift, which safely handles positive integer overflow and is slightly faster than division
C) It converts the result into a floating-point `Double`
D) It only works properly for negative numbers

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `(left + right) >>> 1` জাভাতে ওভারফ্লো হওয়া নেগেটিভ বিটকে পজিটিভে কনভার্ট করে দেয় এবং ২ দিয়ে ভাগ করার কাজটা খুব দ্রুত (CPU লেভেলে) করে।
</details>

---

**Q37. If an array has exactly 1 element, how many times will the standard Binary Search `while (left <= right)` loop execute?**
A) 0 times
B) exactly 1 time
C) 2 times
D) Infinite times

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: `left = 0`, `right = 0`। `0 <= 0` কন্ডিশন সত্য, তাই লুপ ১ বার চলবে, `mid = 0` চেক করবে এবং তারপর `left` বা `right` আপডেট হয়ে লুপ ব্রেক হবে।
</details>

---

**Q38. When using Binary Search to find the integer square root of a number $x$ (e.g., $\sqrt{10}$), what should be the initial search space?**
A) `1` to `10`
B) `0` to `5`
C) `1` to $x/2$
D) `1` to $x$

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: D**
ব্যাখ্যা: যেকোনো সংখ্যার (যেমন $x$) বর্গমূল 1 থেকে $x$ এর মাঝেই থাকবে (ছোট সংখ্যার জন্য)। তাই `left = 1` এবং `right = x` ধরে Binary Search করে $mid \times mid \le x$ চেক করা যায়।
</details>

---

**Q39. In an infinite data stream where the upper bound is unknown, which technique is used to find a boundary before applying Binary Search?**
A) Linear Search
B) Exponential Search (doubling the index like 1, 2, 4, 8... until a boundary is found)
C) Jump Search
D) Ternary Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: Exponential Search খুব দ্রুত $O(\log i)$ টাইমে একটি বাউন্ডারি (যেখানে `arr[high] > target`) বের করে দেয়। এরপর ওই `low` এবং `high` রেঞ্জের মাঝে Binary Search করা হয়।
</details>

---

**Q40. [Conclusion] To make searches extremely fast, which hybrid or modified tree concept is internally used by Database Indexing engines?**
A) Linear Search
B) B-Tree / B+ Tree (which is a balanced N-ary Search Tree variation)
C) Bubble Sort
D) Interpolation Search

<details>
<summary>✅ Answer & Explanation</summary>

**Answer: B**
ব্যাখ্যা: ডেটাবেসে B+ Tree ব্যবহার করা হয়, যা Binary Search Tree এর একটি ব্যালান্সড এবং মাল্টি-নোড ভার্সন। এটি ডিস্ক আই/ও (I/O) কমানোর পাশাপাশি $O(\log n)$ টাইমে ডেটা সার্চ করতে পারে।
</details>
