public class TreeApp {
    public static void main(String[] args) {
        MyTree tree=new MyTree();
        int[] numbers=new int[] {10, 6, 8, 20, 4, 9, 5, 17, 42, 47, 29};

        for (int i = 0; i <11; i++) {
            tree.insert(numbers[i]);
        }
      VisualizeTree.printTree(tree.root,null,false);
      // tree.preOrderTraversal(tree.root);
      //   Task 1 : Contains Method
        System.out.println("Tree contains 1?:  " + tree.contains(42));
        // Task 2; isLeaf() method
        System.out.println("Is root leaf? :   " + tree.isLeaf(tree.root));
        // Task 3 Print Leaf Nodes
        tree.printLeaves(tree.root);
        // Task 4 Height of a node
        System.out.println("Height of the tree is: " + tree.height(tree.root));
        // Task 5 Count number of Leaf Nodes
        System.out.println("Number of Leaves of the tree is: " + tree.countLeaves(tree.root));
        // Task 6 Sum of Lef nodes
        System.out.println("Sum of Leaves of the tree is: " + tree.findSumOfLeaves(tree.root));
        // Task 7 Sum of all nodes of a tree
        System.out.println("Sum of all Nodes of the tree is: " + tree.calculateNodeSums(tree.root));
    }
}
