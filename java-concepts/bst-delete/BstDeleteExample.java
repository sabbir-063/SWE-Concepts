class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class BstDeleteExample {

    // BST থেকে নোড ডিলিট করার ফাংশন
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // নোডটি খোঁজার কাজ
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // নোডটি খুঁজে পেয়েছি! এবার ডিলিট করার পালা।

            // Case 1 & 2: কোনো চাইল্ড নেই অথবা একটি চাইল্ড আছে
            if (root.left == null) {
                return root.right; // বামে কিছু না থাকলে ডান দিকের অংশ জুড়ে দিলাম
            } else if (root.right == null) {
                return root.left; // ডানে কিছু না থাকলে বাম দিকের অংশ জুড়ে দিলাম
            }

            // Case 3: দুটোই চাইল্ড আছে!
            // ডান দিকের সাব-ট্রির সবচেয়ে ছোট ভ্যালু (In-order Successor) খুঁজে বের করি
            TreeNode successor = getMinNode(root.right);
            
            // Successor এর ভ্যালুটা বর্তমান নোডে কপি করে বসিয়ে দিলাম (রিপ্লেস)
            root.val = successor.val;

            // এবার ডান দিকের সাব-ট্রি থেকে আসল Successor নোডটিকে ডিলিট করে দিলাম
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    // একটি ট্রির সবচেয়ে ছোট ভ্যালু খোঁজার ফাংশন (সবসময় বামে যেতে হয়)
    private TreeNode getMinNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // ট্রি দেখার জন্য In-order Traversal (ছোট থেকে বড় প্রিন্ট করবে)
    public void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        BstDeleteExample bst = new BstDeleteExample();

        // ট্রি তৈরি করি:
        //        50
        //      /    \
        //    30      70
        //   /  \    /  \
        //  20  40  60  80
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        System.out.print("Before Deletion (In-order): ");
        bst.printInOrder(root);
        System.out.println();

        // 50 ডিলিট করবো (যার দুটোই চাইল্ড আছে)
        System.out.println("\nDeleting 50 (will be replaced by In-order Successor 60)...");
        root = bst.deleteNode(root, 50);

        System.out.print("After Deletion (In-order): ");
        bst.printInOrder(root);
        System.out.println();
    }
}
