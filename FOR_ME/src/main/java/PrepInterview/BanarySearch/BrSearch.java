package PrepInterview.BanarySearch;

public class BrSearch {
    public static void main(String[] args) {
        BnNode root = new BnNode(3);
        root.left = new BnNode(1);
        root.right = new BnNode(5);
        root.left.left = new BnNode(0);
        root.left.right = new BnNode(2);
        root.right.left = new BnNode(4);
        root.right.right = new BnNode(6);
        System.out.println((insert(root, 8)));
        print(root);
    }

    public static BnNode insert(BnNode root, int value) {
        BnNode workingNode = new BnNode(value);
        if (root == null) {
            return workingNode;
        }
        BnNode current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = workingNode;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = workingNode;
                    break;
                }
                current = current.right;
            }
        }
        return workingNode;
    }

    public static void print(BnNode root) {
        if (root == null) return;
        System.out.println(root.value);
        print(root.left);
        print(root.right);
    }


}
