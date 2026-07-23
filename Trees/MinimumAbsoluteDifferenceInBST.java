package Trees;
import java.util.*;

public class MinimumAbsoluteDifferenceInBST{
    public static void main(String args[]){
        Integer arr [] = {4,2,6,1,3};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        int ans = minimum(root);
        System.out.println(ans);
    }
    static TreeNode prev = null;
    static int min = Integer.MAX_VALUE;
    public static int minimum(TreeNode root){
        inorder(root);
        return min;
    }
    public static void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null){
            min = Math.min(min,root.val - prev.val);
        }
        prev = root;
        inorder(root.right);
    }
}