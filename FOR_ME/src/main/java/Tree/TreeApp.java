package Tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class TreeApp {
    public static void main(String[] args) {

        MyTree tree = new MyTree();
        int[] numbers = new int[]{10,6,8,20,4,9,5,17,42,47,29};
        for (int i = 0; i <11 ; i++) {
            tree.insertToMyTree(numbers[i]);
        }
        System.out.println("MY TREE");
        VisualizeTree.printTree(tree.root,null,false);

        System.out.println("PreOrderTree");
        tree.preOrderTraversal(tree.root);

        System.out.println();
        System.out.println("InOrderTree");
        tree.inOrderTraversal(tree.root);

        System.out.println();
        System.out.println("PostOrderTree");
        tree.postOrderTraversal(tree.root);

        System.out.println();
        System.out.println("Level of Order Traversal of the tree");
        tree.LevelOrderTraversal(tree.root);

    }

}
