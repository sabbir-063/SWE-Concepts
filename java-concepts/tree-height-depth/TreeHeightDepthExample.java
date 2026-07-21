/*
 ============================================================================
  Tree Height & Depth Calculation (ট্রি হাইট ও ডেপথ নির্ণয়)
 ============================================================================

  ডায়গ্রাম (Diagram):
  -----------------
           (50)         <-- Level 0 (Root)  [Depth = 0, Height = 3]
         /      \
       (30)     (70)    <-- Level 1         [Depth = 1, Height = 2]
      /   \     /   \
    (20)  (40) (60) (80)<-- Level 2         [Depth = 2]
                \
                (65)    <-- Level 3 (Leaf)  [Depth = 3, Height = 0]


  সংজ্ঞা (Definitions):
  ----------------------
  1. Depth (ডেপথ): Root (মূল নোড) থেকে কোনো নির্দিষ্ট নোড পর্যন্ত দূরত্বের (Edge সংখ্যা)।
     - Root (50) এর Depth = 0
     - Node 70 এর Depth = 1
     - Node 65 এর Depth = 3

  2. Height (হাইট): কোনো নোড থেকে তার সবচেয়ে দূরের Leaf (পাতা) নোড পর্যন্ত সর্বোচ্চ Edge সংখ্যা।
     - Leaf Node (65) এর Height = 0
     - Node 70 এর Height = 2 (70 -> 60 -> 65)
     - পুরো Tree এর Height = Root (50) এর Height = 3 (50 -> 70 -> 60 -> 65)

 ============================================================================
*/

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class TreeHeightDepthExample {

    // ১. ট্রির বা যেকোনো নোডের Height নির্ণয় করার ফাংশন (Recursive)
    // (Edge-based convention: ফাঁকা ট্রির হাইট -1, লীফ নোডের হাইট 0)
    public int getHeight(TreeNode node) {
        if (node == null) {
            return -1; // ফাঁকা সাব-ট্রির ক্ষেত্রে -1
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        // বাম ও ডানের মধ্যে সর্বোচ্চ হাইট + ১ (নিজের এডজ)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // ২. কোনো নির্দিষ্ট ভ্যালুর Node এর Depth নির্ণয় করার ফাংশন (Recursive)
    public int getDepth(TreeNode root, int targetVal) {
        return findDepthHelper(root, targetVal, 0);
    }

    private int findDepthHelper(TreeNode node, int targetVal, int currentDepth) {
        if (node == null) {
            return -1; // নোডটি পাওয়া না গেলে -1
        }

        if (node.val == targetVal) {
            return currentDepth; // টার্গেট নোড পাওয়া গেলে বর্তমান ডেপথ রিটার্ন করবে
        }

        // প্রথমে বামে খুঁজি
        int leftDepth = findDepthHelper(node.left, targetVal, currentDepth + 1);
        if (leftDepth != -1) {
            return leftDepth;
        }

        // না পাওয়া গেলে ডানে খুঁজি
        return findDepthHelper(node.right, targetVal, currentDepth + 1);
    }

    public static void main(String[] args) {
        TreeHeightDepthExample treeCalc = new TreeHeightDepthExample();

        /*
                 50
               /    \
             30      70
            /  \    /  \
           20  40  60  80
                     \
                     65
        */
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        root.right.left.right = new TreeNode(65); // লীফ নোড

        System.out.println("==========================================");
        System.out.println("   Tree Height & Depth Calculation Result ");
        System.out.println("==========================================\n");

        // Tree Height
        int treeHeight = treeCalc.getHeight(root);
        System.out.println("1. Tree Height (Root Node 50): " + treeHeight + " (Edges)");

        // Specific nodes depth
        int[] testNodes = {50, 70, 60, 65, 100};

        System.out.println("\n2. Node Depths (Distance from Root):");
        for (int val : testNodes) {
            int depth = treeCalc.getDepth(root, val);
            if (depth != -1) {
                System.out.println("   - Depth of Node (" + val + ") = " + depth);
            } else {
                System.out.println("   - Node (" + val + ") not found in Tree!");
            }
        }
    }
}
