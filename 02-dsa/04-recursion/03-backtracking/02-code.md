# 03. Backtracking (Code & Implementations)

এই ফাইলে আমরা Backtracking-এর ৩টি ক্লাসিক প্রবলেম (Subsets, Permutations এবং N-Queens) জাভাতে সলভ করবো। প্রতিটি প্রবলেমেই **Choose ➡️ Explore ➡️ Undo** টেমপ্লেটটি ফলো করা হয়েছে।

---

## 1. Subsets (Power Set)
**প্রবলেম:** একটি অ্যারে দেওয়া থাকবে (যেমন `[1, 2, 3]`), এর সব পসিবল সাবসেট বের করতে হবে।
**লজিক:** প্রতিটি এলিমেন্টের জন্য আমাদের কাছে ২টি অপশন থাকে—হয় তাকে নেবো (Include), না হয় নেবো না (Exclude)। 

```java
import java.util.*;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums, int start) {
        // ১. Base Case (বা রেজাল্ট অ্যাড করা)
        // আমরা প্রতিটি স্টেপেই কারেন্ট লিস্টটিকে রেজাল্টে অ্যাড করবো (Deep Copy করে)
        result.add(new ArrayList<>(currentList));

        // ২. Loop / Choices
        for (int i = start; i < nums.length; i++) {
            // a. CHOOSE (লিস্টে অ্যাড করো)
            currentList.add(nums[i]);
            
            // b. EXPLORE (পরের এলিমেন্টের জন্য গভীরে যাও)
            backtrack(result, currentList, nums, i + 1);
            
            // c. UNDO / BACKTRACK (ফিরে আসার সময় শেষ এলিমেন্ট রিমুভ করো)
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2})); 
        // Output: [[], [1], [1, 2], [2]]
    }
}
```

---

## 2. Permutations
**প্রবলেম:** `[1, 2, 3]` অ্যারের সবগুলো পসিবল সাজানো রূপ (বিন্যাস) বের করতে হবে। যেমন: `[1,2,3], [1,3,2], [2,1,3]...`
**লজিক:** এখানে `start` পয়েন্টার লাগে না। লুপ সবসময় `0` থেকে শুরু হয়। তবে যেই এলিমেন্টটা অলরেডি নেওয়া হয়েছে, তাকে স্কিপ (Pruning) করতে হয়।

```java
import java.util.*;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums) {
        // ১. Base Case: লিস্টের সাইজ অরিজিনাল অ্যারের সাইজের সমান হলে একটি পারমুটেশন রেডি!
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // ২. Loop / Choices (সবসময় 0 থেকে শুরু)
        for (int i = 0; i < nums.length; i++) {
            // Pruning: যদি অলরেডি লিস্টে থাকে, তবে স্কিপ করো
            if (currentList.contains(nums[i])) continue; 

            // a. CHOOSE
            currentList.add(nums[i]);
            
            // b. EXPLORE
            backtrack(result, currentList, nums);
            
            // c. UNDO
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2})); 
        // Output: [[1, 2], [2, 1]]
    }
}
```
*Note: `contains()` এর জন্য $O(N)$ সময় লাগে। ইন্টারভিউতে আরও অপ্টিমাইজ করার জন্য একটি `boolean[] used` অ্যারে ব্যবহার করা হয়।*

---

## 3. The N-Queens Problem (Hard but Classic)
**প্রবলেম:** একটি $N \times N$ দাবার বোর্ডে $N$ সংখ্যক রানি (Queen) বসাতে হবে, যেন কেউ কাউকে আক্রমণ (Attack) করতে না পারে।
**লজিক:** আমরা সারি (Row) বাই সারি রানি বসাবো। প্রতি সারিতে চেক করবো কোন কলামে (Column) বসালে সে সেফ থাকে।

```java
import java.util.*;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // বোর্ডটিকে ডট ('.') দিয়ে ইনিশিয়ালাইজ করা
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        backtrack(result, board, 0, n);
        return result;
    }

    private static void backtrack(List<List<String>> result, char[][] board, int row, int n) {
        // ১. Base Case: যদি সব সারি (row) পার হয়ে যাই, মানে সব রানি সেফলি বসে গেছে!
        if (row == n) {
            result.add(buildBoard(board));
            return;
        }

        // ২. Loop over choices (প্রতি সারিতে N টি কলাম আছে)
        for (int col = 0; col < n; col++) {
            // Pruning: যদি এই ঘরে বসালে কেউ অ্যাটাক করে, তবে স্কিপ!
            if (!isSafe(board, row, col, n)) continue;

            // a. CHOOSE (এই ঘরে রানি বসালাম)
            board[row][col] = 'Q';
            
            // b. EXPLORE (পরের সারিতে রানি বসাতে গেলাম)
            backtrack(result, board, row + 1, n);
            
            // c. UNDO / BACKTRACK (ফিরে আসার সময় রানি সরিয়ে ফেললাম)
            board[row][col] = '.';
        }
    }

    // এই ঘরটি রানির জন্য সেফ কি না তা চেক করার লজিক
    private static boolean isSafe(char[][] board, int row, int col, int n) {
        // ১. উপরের দিকে সোজা কলামে কেউ আছে কি না
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // ২. বাম দিকের কোণায় (Upper-Left Diagonal)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // ৩. ডান দিকের কোণায় (Upper-Right Diagonal)
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        // নিচে চেক করার দরকার নেই, কারণ আমরা এখনো নিচ পর্যন্ত পৌঁছাইনি!
        return true;
    }

    // 2D char array কে List of Strings এ কনভার্ট করার হেল্পার
    private static List<String> buildBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}
```

## 💡 Backtracking Pro-Tips for Interviews
1. **Always Deep Copy:** `result.add(currentList)` দিলে কাজ করবে না (রেফারেন্স পাস হয়ে সব ফাঁকা হয়ে যাবে)। সবসময় `new ArrayList<>(currentList)` দিয়ে ডিপ-কপি করতে হয়।
2. **Identify the Pattern:** যদি প্রবলেমে সব পসিবল ওয়ে (All possible ways / combinations) বের করতে বলে, তবে 99% ক্ষেত্রে সেটি Backtracking এর প্রবলেম।
3. **Array vs List for State:** যদি ইনপুটের সাইজ আগে থেকেই ফিক্সড থাকে, তবে `currentList` এর বদলে `array` বা `boolean[]` ব্যবহার করলে স্পিড অনেক বেড়ে যায়।
