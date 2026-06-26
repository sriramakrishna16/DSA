package Trees;

//problem , given array of values that represents nodes in level order like first level1 then level2...
//for example 3,9,20,null,null,15,7 then 3 root, 3.left -> 9 ,3.right -> 20 now 9.left and right -> null ,
// and 20.left -> 15 20.right -> 7

//so we have to find the maximum depth in this tree , that is 3 -> 3,20,7

//if we are running in ide , we have to define treenode structure and build level order tree on our own
//i have already done . filename -> TreeNode.java available in folder Trees. 

public class MaxDepthBinaryTree {
    public static void main(String args[]){
        Integer [] arr = {3,9,20,null,null,15,7};

        //treenode is own created class . not java function.
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);

        TreeNode.print(root);
        System.out.println();

        int ans = findMaxDepth(root);
        System.out.println("max depth is :" + ans);

    }
    public static int findMaxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = findMaxDepth(root.left);
        int right = findMaxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    
}
