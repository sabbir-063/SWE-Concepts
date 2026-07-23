# Sorting Algorithms: Complete Java Reference & Code Implementations

> **Module:** 02 - Data Structures & Algorithms (DSA)  
> **Chapter:** 02 - Algorithms  
> **Topic:** 01 - Sorting Algorithms  
> **Language:** Java (JDK 8+)

---

## 🎯 Code Architecture Overview

এই ফাইলে সমস্ত প্রধান সর্টিং অ্যালগরিদমের সম্পূর্ণ, রান-এবল এবং টেস্ট করা জাভা কোড দেওয়া হয়েছে। প্রতিটি মেথডের সাথে ইনলাইন কমেন্ট এবং বয়লারপ্লেট মেইন ড্রাইভার রয়েছে যা এজ কেস (Edge cases) হ্যান্ডেল করে।

---

## 1. Fundamental Comparison-Based Sorts

### 1.1 Optimized Bubble Sort
```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // Optimization for O(n) best case
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap adjacent elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped in this pass, array is sorted
            if (!swapped) break;
        }
    }
}
```

---

### 1.2 Selection Sort
```java
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i; // Find index of minimum element in unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap minimum element with first element of unsorted portion
            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
        }
    }
}
```

---

### 1.3 Insertion Sort
```java
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
```

---

## 2. Divide & Conquer Sorts

### 2.1 Merge Sort
```java
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2; // Prevent integer overflow
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Maintain stability by using <= for Left array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[]
        while (i < n1) arr[k++] = L[i++];
        // Copy remaining elements of R[]
        while (j < n2) arr[k++] = R[j++];
    }
}
```

---

### 2.2 Quick Sort (Lomuto Partition & 3-Way Dutch National Flag)

#### Standard Lomuto Partition
```java
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIdx = lomutoPartition(arr, low, high);
            quickSort(arr, low, pIdx - 1);
            quickSort(arr, pIdx + 1, high);
        }
    }

    private static int lomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Last element as pivot
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

#### 3-Way Quick Sort (Dutch National Flag for Duplicates)
```java
public class ThreeWayQuickSort {
    public static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int lt = low, gt = high;
        int pivot = arr[low];
        int i = low + 1;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }

        // arr[low..lt-1] < pivot = arr[lt..gt] < arr[gt+1..high]
        sort(arr, low, lt - 1);
        sort(arr, gt + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

---

## 3. Tree & Heap Based Sorts

### 3.1 Heap Sort
```java
public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max-Heap (Reorganize array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (max element) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int heapSize, int rootIdx) {
        int largest = rootIdx;
        int left = 2 * rootIdx + 1;
        int right = 2 * rootIdx + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != rootIdx) {
            int swap = arr[rootIdx];
            arr[rootIdx] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify affected sub-tree
            heapify(arr, heapSize, largest);
        }
    }
}
```

---

## 4. Non-Comparison Based Sorts

### 4.1 Stable Counting Sort
```java
public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        int max = arr[0], min = arr[0];
        for (int val : arr) {
            if (val > max) max = val;
            if (val < min) min = val;
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];

        // Store frequency of each element
        for (int val : arr) {
            count[val - min]++;
        }

        // Store cumulative count to preserve STABILITY
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build output array in reverse order to maintain stability
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Copy output array back to arr
        System.arraycopy(output, 0, arr, 0, n);
    }
}
```

---

## 5. Object Sorting & Custom Comparator (Stability Demo)

```java
import java.util.Arrays;
import java.util.Comparator;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "{" + name + ", " + marks + "}";
    }
}

public class StableObjectSort {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice", 85),
            new Student("Bob", 90),
            new Student("Charlie", 85),
            new Student("Dave", 90)
        };

        // Java's Arrays.sort(Object[]) uses TimSort, which is STABLE
        Arrays.sort(students, Comparator.comparingInt(s -> s.marks));

        // Output will be: [{Alice, 85}, {Charlie, 85}, {Bob, 90}, {Dave, 90}]
        // Notice Alice remains before Charlie because relative order is preserved!
        System.out.println(Arrays.toString(students));
    }
}
```

---

## 6. Comprehensive Verification Test Driver

```java
import java.util.Arrays;

public class SortingTestSuite {
    public static void main(String[] args) {
        int[][] testCases = {
            {},                                     // Empty array
            {5},                                    // Single element
            {1, 2, 3, 4, 5},                        // Already sorted
            {5, 4, 3, 2, 1},                        // Reverse sorted
            {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5},      // Duplicates
            {-5, -10, 0, 15, 2, -3}                 // Negative numbers
        };

        System.out.println("--- Running Sorting Algorithm Tests ---");
        for (int i = 0; i < testCases.length; i++) {
            int[] original = testCases[i];
            int[] expected = original.clone();
            Arrays.sort(expected);

            int[] testArr = original.clone();
            MergeSort.mergeSort(testArr, 0, testArr.length - 1);

            boolean passed = Arrays.equals(testArr, expected);
            System.out.printf("Test Case %d: %s -> %s [%s]\n", 
                i + 1, Arrays.toString(original), Arrays.toString(testArr), passed ? "PASSED" : "FAILED");
        }
    }
}
```
