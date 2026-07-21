// ট্রির প্রতিটি নোড কেমন হবে তার একটি স্ট্রাকচার
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class TreeCloneExample {

    // এই ফাংশনটি ট্রি ক্লোন করার আসল কাজ করবে (Pre-order Traversal)
    public TreeNode cloneTree(TreeNode root) {
        // যদি অরিজিনাল ট্রি খালি থাকে (নোড না থাকে), তাহলে কপিও খালি হবে
        if (root == null) {
            return null;
        }

        // ১. প্রথমে রুট নোডটি কপি করে নতুন একটি নোড তৈরি করলাম (Root)
        TreeNode newNode = new TreeNode(root.val);

        // ২. রুটের বাম দিকের সব নোড কপি করার জন্য ফাংশনটিকে আবার কল করলাম (Left)
        newNode.left = cloneTree(root.left);

        // ৩. রুটের ডান দিকের সব নোড কপি করার জন্য ফাংশনটিকে আবার কল করলাম (Right)
        newNode.right = cloneTree(root.right);

        // সবশেষে তৈরি করা নতুন নোডটি (যা পুরো নতুন ট্রির রুট) রিটার্ন করলাম
        return newNode;
    }

    // ট্রির ডেটা প্রিন্ট করে দেখার জন্য একটি ফাংশন (Pre-order এ প্রিন্ট করবে)
    public void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " "); // Root
        printPreOrder(node.left);         // Left
        printPreOrder(node.right);        // Right
    }

    public static void main(String[] args) {
        TreeCloneExample treeUtils = new TreeCloneExample();

        // একটি অরিজিনাল ট্রি তৈরি করি
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode originalRoot = new TreeNode(1);
        originalRoot.left = new TreeNode(2);
        originalRoot.right = new TreeNode(3);
        originalRoot.left.left = new TreeNode(4);
        originalRoot.left.right = new TreeNode(5);

        System.out.print("Original Tree (Pre-order): ");
        treeUtils.printPreOrder(originalRoot);
        System.out.println();

        // অরিজিনাল ট্রিটি ক্লোন বা কপি করি
        TreeNode clonedRoot = treeUtils.cloneTree(originalRoot);

        System.out.print("Cloned Tree (Pre-order): ");
        treeUtils.printPreOrder(clonedRoot);
        System.out.println();
    }
}
