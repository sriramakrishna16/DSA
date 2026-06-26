package Trees;

import java.util.Queue;
import java.util.LinkedList;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){};

    TreeNode(int val){
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTreeLevelOrder(Integer[] arr){
        if(arr.length == 0 || arr[0] == null){
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while(i < arr.length && !q.isEmpty()){
            TreeNode current = q.poll();

            if(arr[i] != null){
                current.left = new TreeNode(arr[i]);
                q.offer(current.left);
            }
            i++;

            if(i < arr.length && arr[i] != null){
                current.right = new TreeNode(arr[i]);
                q.offer(current.right);
            }
            i++;
        }
        return root;
    }

    //printing preorder root -> left -> right
    public static void print(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }

    //printing Inorder left -> root -> right
    public static void printInOrder(TreeNode root){
        if(root == null){
            return;
        }
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    //printing post order left-> right -> root
    public static void printPostOrder(TreeNode root){
        if(root == null){
            return;
        }
        printInOrder(root.left);
        printInOrder(root.right);
        System.out.print(root.val + " ");
    }

    //printing LevelOrder level1 , level2 ...
    public static void printLevelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        System.out.print(root.val + " ");

        while(!q.isEmpty()){
            TreeNode current = q.poll();

            if(current.left != null){
                q.offer(current.left);
                System.out.print(current.left.val + " ");
            }

            if(current.right != null){
                q.offer(current.right);
                System.out.print(current.right.val + " ");
            }
        }

    }
}
