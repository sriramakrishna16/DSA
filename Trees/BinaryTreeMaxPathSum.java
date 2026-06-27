package Trees;

//problem, given level order tree and we have to find a path that produces max result
//path mean , there is way of connecting between the nodes. and each node value can be taken once.
//we use max of left, right + node value as result to each node maintains a path.
//and current nodes value produces the maxsum.

//if we take 0 as initially for max , it may effect for negative trees. so we have to take Integer.MIN_VALUE.

public class BinaryTreeMaxPathSum {
    static int maxSum = Integer.MIN_VALUE; //dont take 0 , if 0, then if tree results negative then max becomes 0
    public static void main(String args[]){
        Integer [] arr = {-15};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        TreeNode.printLevelOrder(root);
        System.out.println(); //line break

        int ans = findMax(root);
        System.out.println(ans);
    }
    public static int findMax(TreeNode root){
        dfs(root);
        return maxSum;
    }
    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0,dfs(root.left));
        int right = Math.max(0,dfs(root.right));

        int current = root.val + left + right;
        
        maxSum = Math.max(maxSum, current); 

        return root.val + Math.max(left, right);
    }
}
