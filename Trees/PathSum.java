package Trees;

public class PathSum {
    public static void main(String args[]){
        Integer [] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode t = new TreeNode();
        TreeNode root = t.buildTreeLevelOrder(arr);
        int target = 22;
        boolean ans = targetPath(root, target);
        System.out.println(ans);
    }
    public static boolean targetPath(TreeNode root, int target){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return target == root.val;
        }
        return targetPath(root.left , target - root.val) || targetPath(root.right, target - root.val);
    }
}
