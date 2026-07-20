package Trees;

public class SymmetricTree {
    public static void main(String args[]){
        Integer arr [] = {1,2,2,3,4,4,3};
        TreeNode t = new TreeNode();
        TreeNode root = t.buildTreeLevelOrder(arr);
        t.printLevelOrder(root);
        System.out.println();

        boolean ans = isSymmetric(root);
        System.out.println(ans);
    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) 
            return true;
        return isMirror(root.left, root.right);
    }
    public static boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null) 
            return true;
        if(left == null || right == null) 
            return false;
        if(left.val != right.val) 
            return false;
        
        return isMirror(left.left, right.right) && isMirror(left.right , right.left);
    }
}
