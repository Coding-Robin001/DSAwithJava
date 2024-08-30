import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    TreeNode root;

    BinaryTree(){
        Scanner sc = new Scanner(System.in);
        root = createTree(sc);
    }

    TreeNode createTree(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1)
        {
            return null;
        }
        TreeNode root = new TreeNode(data);
        root.left = createTree(sc);
        root.right = createTree(sc);
        return root;
    }


    void levelOrderPrint(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode f = q.poll();
            System.out.println(f.data);
            if (f.left != null){
                q.offer(f.left);
            }
            if (f.right != null){
                q.offer(f.right);
            }
        }
        return;
    }

}
