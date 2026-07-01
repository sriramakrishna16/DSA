package Trees;

import java.util.LinkedList;
import java.util.Queue;

//problem , given a tree and subtree
//so that we have to find that subtree presents in tree or not
//if found , return true . if not return false.

//i used recursion to solve this problem

public class SubTreeOfAnotherTree {
    /* public static void main(String args[]){
        Integer [] arr = {3,4,5,1,2};
        Integer [] arr2 = {4,1,2};

        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        TreeNode root1 = TreeNode.buildTreeLevelOrder(arr2);

        TreeNode.printLevelOrder(root);
        System.out.println();

        TreeNode.printLevelOrder(root1);
        System.out.println();

        boolean ans = isSubTree(root, root1);
        System.out.println("sub tree contains ? :" + ans);
    }

    public static boolean isSubTree(TreeNode root1, TreeNode root2){
        if(root1 == null){
            return false;
        }

        if(isSameTree(root1,root2)){
            return true;
        }

        return isSubTree(root1.left , root2) || isSubTree(root1.right, root2);
    }
    public static boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    } */


    //another optimised solution 
    public static void main(String args[]){
        Integer [] arr = {12};
        Integer [] arr2 = {2};

        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        TreeNode root1 = TreeNode.buildTreeLevelOrder(arr2);

        TreeNode.printLevelOrder(root);
        System.out.println();

        TreeNode.printLevelOrder(root1);
        System.out.println();

        String tree = serialize(root);
        String subTree = serialize(root1);
        System.out.println(tree);
        System.out.println(subTree);

        System.out.println(tree.contains(subTree));
    }

        
    public static String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    public static void preorder(TreeNode root , StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }

        sb.append("$").append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }
}
