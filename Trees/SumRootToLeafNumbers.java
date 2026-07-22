package Trees;

public class SumRootToLeafNumbers {
    public static void main(String args[]){
        Integer [] arr = {4,9,0,5,1};
        TreeNode t = new TreeNode();
        TreeNode root = t.buildTreeLevelOrder(arr);
        int ans = sumNumbers(root);
        System.out.println(ans);
    }
    public static int sumNumbers(TreeNode root){
        return sum(root, 0);
    }
    public static int sum(TreeNode root, int num){
        if(root == null){
            return 0;
        }
        num = num * 10 + root.val;
        if(root.left == null && root.right == null){
            return num;
        }
        return sum(root.left, num) + sum(root.right, num);
    }
}
