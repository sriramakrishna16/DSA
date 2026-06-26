package Trees;

//problem statement , given two trees , so that we have to find is both trees same or not.
//simply we use dfs and recursion to solve by comparing at each node

//in online platforms , we dont need to form trees , but in ide we have to form trees by ourselves.
//i used level order to form trees , filename -> TreeNode.java 

public class SameTree {
    public static void main(String args[]){
        Integer[] arr1 ={8,9,10,23,1};
        Integer[] arr2 = {8,9,10,23,null};

        TreeNode root1 = TreeNode.buildTreeLevelOrder(arr1);
        TreeNode root2 = TreeNode.buildTreeLevelOrder(arr2);

        boolean ans = isSameTree(root1, root2);
        System.out.println(ans);
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
        return (isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right));
    }
}

