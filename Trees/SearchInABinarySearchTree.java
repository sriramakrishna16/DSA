package Trees;
public class SearchInABinarySearchTree{
    public static void main(String [] args){
        Integer [] arr = {4,2,7,1,3,null,null};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        int target = 2;
        TreeNode ans = search(root, target);
        TreeNode.printInOrder(ans);
    }
    public static TreeNode search(TreeNode root, int target){
        if(root.val == target || root == null) return root;
        if(target > root.val){
            return search(root.right, target);
        }
        return search(root.left, target);
    }
}