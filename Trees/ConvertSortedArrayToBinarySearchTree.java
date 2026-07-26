package Trees;

//sub-category : Divide and Conquer
public class ConvertSortedArrayToBinarySearchTree{
    public static void main(String args[]){
        int [] arr = {-9,-8,4,7,9};
        TreeNode root = buildBST(arr);
        TreeNode.print(root);
    }
    public static TreeNode buildBST(int [] arr){
        TreeNode root = build(arr, 0 , arr.length - 1);
        return root;
    }
    private static TreeNode build(int [] arr , int start , int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = build(arr, start , mid - 1);
        root.right = build(arr, mid + 1 , end);
        return root;
    }
}
