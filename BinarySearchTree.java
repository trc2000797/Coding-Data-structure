import java.io.*;
import java.util.Scanner;

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

    public boolean isEmpty() {
        if(root == null) return true;
        else return false;
    }

    public void add(int value) {
        //if the tree is empty
        if (isEmpty()) {
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
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = new Node(value);
                    return;
                }
            }
        }
    }

    public boolean contains(int value) {
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

    public boolean remove(int value) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while (current.data != value) {
            parent = current;
            if (current.data > value) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        else if (current.right == null) {
            if(current == root) {
                root = current.left;
            } else if(isLeftChild) {
                parent.left = current.left;
            } else { parent.right = current.left; }
        }
        else if(current.left == null) {
            if(current == root) {
                root = current.right;
            } else if(isLeftChild){
                parent.left = current.right;
            } else { parent.right = current.right;}
        } else if(current.left != null && current.right != null) {
            Node successor = getSuccessor(current);
            if(current == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.left = successor;
            } else { parent.right = successor; }
        successor.left = current.left;
        }
        return true;
    }

    public Node getSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.right;

        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if(successor != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
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


        //The name of the file to open
        String fileName = "src/infile.dat";
        String str = null;
        //This will reference one line at a time
        String line = null;

        try{
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println("Sorted Set A Contains " + line);
                //Get the String array divided into mutiple numbers
                String[] numbers = line.split(",");
                //Store int
                int[] intNumbers = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    intNumbers[i] = Integer.parseInt(numbers[i]);
                }

                //Init the tree here
                BinarySearchTree b = new BinarySearchTree();

                for(int j = 0; j < intNumbers.length; j++) {
                    b.add(intNumbers[j]);
                }

//                b.display(b.root);
                System.out.println();
                System.out.print("User Input = ");

                //grab an input from user
                int in;
                Scanner keyboard = new Scanner(System.in);
                in = keyboard.nextInt();
                if(b.contains(in)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName);
        }
        catch(IOException ex) {
            System.out.println("Error reading file'" + fileName + "'");
            ex.printStackTrace();
        }

    }
}

