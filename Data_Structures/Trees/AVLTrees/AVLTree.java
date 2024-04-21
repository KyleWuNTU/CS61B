package Data_Structures.Trees.AVLTrees;

class TreeNode {
    int key, height;
    TreeNode left, right;

    TreeNode(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class AVLTree {
    private TreeNode root;
    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    private int balanceFactor(TreeNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private TreeNode leftRotate(TreeNode x){
        TreeNode y = x.right;
        TreeNode tmp = y.left;

        y.left = x;
        x.right = tmp;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }

    private TreeNode rightRotate(TreeNode x){
        TreeNode y = x.left;
        TreeNode tmp = y.right;

        y.right = x;
        x.left = tmp;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        
        return y;
    }

    // handle the null situation
    // find the leaves
    // count balance factor
    // rebalance according to balance factor
    private TreeNode insertRec(TreeNode node, int key){
        if(node == null){
            return new TreeNode(key);
        }
        if(key < node.key){
            node.left = insertRec(node.left, key);
        }
        else if(key > node.key){
            node.right = insertRec(node.right, key);
        }
        else return node; //no duplication of key is allowed

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balanceFactor = balanceFactor(node);
        
        if(balanceFactor > 1 && key < node.left.key){
            return rightRotate(node);
        }

        if (balanceFactor > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        if(balanceFactor < -1 && key > node.right.key){
            return leftRotate(node);
        }

        if (balanceFactor < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.key + " ");
            inorderTraversal(node.right);
        }
    }

    public void inorder() {
        inorderTraversal(root);
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        System.out.println("Inorder traversal of the constructed AVL tree is:");
        avlTree.inorder();
    }
}