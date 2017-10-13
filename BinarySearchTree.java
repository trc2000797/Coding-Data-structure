public class BinarySearchTree {

    public static Node root;

    public BinarySearchTree() {
        root = null;
    }

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            left = null;
            right = null;
            this.data = data;
        }
    }

    public void insert(int value) {
        //if the tree is empty
        if (root == null) {
            root = new Node(value);
            return;
        }

        //if the root already exist
        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (value < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = new Node(value);
                    return;
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new Node(value);
                        return;
                    }
                }
            }
        }
    }

    public boolean Search(int value) {
        Node current = root;
        while (current != null) {
            if(current.data == value)
                return true;
            else if(current.data > value)
                current = current.left;
            else current = current.right;
        }
        return false;
    }

    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }



    public static void main(String[] args) {
        //try here
        BinarySearchTree b = new BinarySearchTree();
        b.insert(3);b.insert(8);
        b.insert(1);b.insert(6);
        System.out.print("Original Tree : ");
        b.display(b.root);
    }
}
