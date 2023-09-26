package PrepInterview.BanarySearch;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            return true;
        }
        int left = findH(root.left);
        int right = findH(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int findH(TreeNode rood) {
        if (rood==null)return 0;
        int leftH = findH(rood.left);
        int rightH = findH(rood.right);
        return 1 + Math.max(leftH, rightH);
    }



        public static void main(String[] args) {
            // Example 1
            TreeNode tree1 = new TreeNode(3);
            tree1.left = new TreeNode(9);
            tree1.right = new TreeNode(20);
            tree1.right.left = new TreeNode(15);
            tree1.right.right = new TreeNode(7);

            // Example 2
            TreeNode tree2 = new TreeNode(1);
            tree2.left = new TreeNode(2);
            tree2.right = new TreeNode(2);
            tree2.left.left = new TreeNode(3);
            tree2.left.right = new TreeNode(3);
            tree2.left.left.left = new TreeNode(4);
            tree2.left.left.right = new TreeNode(4);

            // Example 3 (Empty Tree)
            TreeNode tree3 = null;

            // Check if the trees are balanced
            System.out.println("Example 1: " + tree1.isBalanced(tree1)); // Output: true
            System.out.println("Example 2: " + tree2.isBalanced(tree2)); // Output: false
            System.out.println("Example 3: " + tree3.isBalanced(tree3)); // Output: true
        }
}


