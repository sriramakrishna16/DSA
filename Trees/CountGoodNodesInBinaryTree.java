package Trees;

public class CountGoodNodesInBinaryTree {
    public static void main(String [] args){
        Integer [] arr = {3,1,4,3,null,1,5};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        int ans = goodNodes(root);
        System.out.println(ans);
    }
    static int count = 0;
    public static int goodNodes(TreeNode root){
        int max = Integer.MIN_VALUE;
        findNodes(root, max);
        return count;
    }
    public static void findNodes(TreeNode root , int max){
        if(root == null){
            return;
        }
        if(root.val >= max){
            count += 1;
            max = root.val;
        }
        findNodes(root.left, max);
        findNodes(root.right, max);
    }
    
}
