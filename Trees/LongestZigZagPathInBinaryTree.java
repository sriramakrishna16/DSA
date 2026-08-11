package Trees;

public class LongestZigZagPathInBinaryTree {
    public static void main(String [] args){
        Integer[] arr = {1,null,1,1,1,null,null,1,1,null,1,null,null,null,1};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        int ans = longestZigZag(root);
        System.out.println(ans);
    }
    static int max = 0;
    public static int longestZigZag(TreeNode root){
        dfs(root,0,0);
        return max;
    }
    public static void dfs(TreeNode root, int left , int right){
        if(root == null){
            return;
        }
        max = Math.max(max, Math.max(left, right));
        dfs(root.left, right+1, 0);
        dfs(root.right, 0, left+1);
    }
}
