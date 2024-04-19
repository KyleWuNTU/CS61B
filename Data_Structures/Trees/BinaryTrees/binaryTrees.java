package Data_Structures.Trees.BinaryTrees;
import java.util.LinkedList;
import java.util.Queue;

public class binaryTrees {
    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
    
        if (value < current.value) {
            current.left = addRecursive(current.left, value); // Update current.left with the result of the recursive call
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value); // Update current.right with the result of the recursive call
        }
    
        return current; // Return the updated node
    }
    

    public void add(int value) {
        root = addRecursive(root, value); // Update the root after adding a new node
    }

    private boolean containValue(Node current, int value){
        if(current == null){
            return false;
        }
        if(current.value == value){
            return true;
        }
        return value < current.value
            ? containValue(current.left, value)
            : containValue(current.right, value);
    }

    public boolean containValue(int value){
        return containValue(root, value);
    }

    public void inorderTraversal(Node node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.value + " ");
        inorderTraversal(node.right);
    }

    private void inorderTraversal(){
        inorderTraversal(root);
    }

    private void preorderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.value + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void preorderTraversal(){
        preorderTraversal(root);
    }

    private void postorderTraversal(Node node){
        if(node == null){
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.value + " ");
    }

    public void postorderTraversal(){
        postorderTraversal(root);
    }

    private void bfsTraversal(Node node){
        if(node == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.value + " ");
            
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }

    }

    public void bfsTraversal(){
        bfsTraversal(root);
    }


    private static binaryTrees createBinaryTree() {
        binaryTrees bt = new binaryTrees();
        return bt;
    }


    public static void main(String[] args) {
        binaryTrees bt = createBinaryTree(); // Instantiate and initialize the binary tree
        bt.add(3);
        bt.add(2);
        bt.add(1);
        bt.add(4);
        bt.add(5);
        bt.bfsTraversal();
    }
}
