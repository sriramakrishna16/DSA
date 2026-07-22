package Trees;

public class CountCompleteTreeNodes {
    public static void main(String args[]){
        Integer arr[] = {1,2,3,4,5,6};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        int count = countNodes(root);
        System.out.println(count);
    }
    public static int countNodes(TreeNode root){
        // if(root == null) return 0;
        // return 1 + countNodes(root.left) + countNodes(root.right);

        //optimised solution
        if(root == null){
            return 0;
        }
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh == rh) return (1 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public static int leftHeight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }
    public static int rightHeight(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    }
}
