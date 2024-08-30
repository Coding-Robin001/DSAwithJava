import java.util.Scanner;

public class BinarySearchTree {
    private TreeNode root;

    BinarySearchTree(){
        this.root = buildTree();
    }

    public TreeNode buildTree() {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();

        TreeNode root = null;
        while (value != -1){
            this.root = insert(root, value);
            value = sc.nextInt();
        }
        return root;
    }

    TreeNode insert(TreeNode root, int key){
        if (root == null){
            return new TreeNode(key);
        }
        if (key <= root.data){
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public void inOrder(){
        inOrderRecursion(root);
    }

    public void inOrderRecursion(TreeNode root){
        if (root != null){
            inOrderRecursion(root.left);
            System.out.print(root.data + " ");
            inOrderRecursion(root.right);
        }
    }

    boolean search(int key){
        return searchRecursion(this.root, key);
    }

    boolean searchRecursion(TreeNode root, int key){

        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (root.data >= key)
            return searchRecursion(root.left, key);
        else
            return searchRecursion(root.right, key);
    }



    void removeKey(int key){
        remove(this.root, key);
    }

    TreeNode remove(TreeNode root, int key){
        if (root == null) return null;
        if (key < root.data)
            root.left = remove(root.left, key);
        else if (key > root.data)
            root.right = remove(root.right, key);
        else {
            if (root.left == null && root.right == null)return null;
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                TreeNode temp = root.left;
                while (temp.right != null){
                    temp = temp.right;
                }
                root.data = temp.data;
                root.left = remove(root.left, temp.data);
            }
        }
        return root;
    }
}
