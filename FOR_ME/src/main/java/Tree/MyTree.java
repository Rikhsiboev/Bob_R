package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {

    // I need Road
    TNode root;
    //constructor
    public MyTree(){}
    //insert or adding to Tree
    void insertToMyTree(int value){

        /*insertToMyTree

        0 newNode
        1 root empty
        2 while (true)
        3 value<=current.value
            current.leftChild==null
                current.leftChild=newNode
            current=current.leftChild;
        4 value<=current.value
            current.rightChild==null
                current.rightChild=newNode
            current=current.rightChild;

         */



        // 1 step empty
        TNode newNode=new TNode(value);
        if (root==null){
            root=newNode;
            return;
        }
        // 2 step not empty
        TNode current = root;
        // condition of left and right and insert
        while (true){
            if (value<=current.value){ // direction
                if (current.leftChild==null){ // finding null on left side by value
                    current.leftChild=newNode; // insert new node for left side
                break; // stop here loop after insert value to left
                }
                //if left not null go to left
                current=current.leftChild;
            } else {
                if (current.rightChild==null){ // finding null on rightChild side by value
                    current.rightChild=newNode; // insert new node for rightChild side
                    break; // stop here loop after insert value to rightChild
                }
                //if rightChild not null go to rightChild
                current=current.rightChild;
            }
        }

    }

    // Tree
    ///A)  Traversal
    ///B)  LevelOrder or Breadth First

    ///A) Traversal
    // 1 PRE        Root    Left    Right
    // 2 InOrder    Left    Root    Right
    // 3 PostOrder  Left    Right   Root

    //PRR
    void preOrderTraversal(TNode root){
        if (root == null){//termination
            return;
        }
        System.out.printf(root.value+ ", "); //visit root
        preOrderTraversal(root.leftChild); // visit left subtree
        preOrderTraversal(root.rightChild); // visit right subtree
    }

    //INORDER

    void inOrderTraversal(TNode root){
        if (root == null){//termination
            return;
        }
        inOrderTraversal(root.leftChild); // visit left subtree
        System.out.printf(root.value+ ", "); //visit root
        inOrderTraversal(root.rightChild); // visit right subtree
    }


    //PostORDER

    void postOrderTraversal(TNode root){
        if (root == null){//termination
            return;
        }
        postOrderTraversal(root.leftChild); // visit left subtree
        postOrderTraversal(root.rightChild); // visit right subtree
        System.out.printf(root.value+ ", "); //visit root
    }


    /// B) LevelOrder or Breadth First

    void LevelOrderTraversal(TNode root){
        if (root==null){
            return;
        }
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TNode toVisit = queue.poll();
            System.out.print(toVisit.value+", ");
            if (toVisit.leftChild!=null){
                queue.add(toVisit.leftChild);
            }
            if (toVisit.rightChild!=null){
                queue.add(toVisit.rightChild);
            }
        }
    }

    /// Deletion of free
    // 1) NoChild
    // 2) OneChild
    // 3) Two Child
            //a) InOrder (Max left Subtree)
            //b) inOrder (Min Right Subtree)


}
