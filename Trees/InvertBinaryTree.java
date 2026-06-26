package Trees;

//problem , given an arr that represents level order tree 
// so that , we have to invert the tree like mirror
//sol is simple , we have to swap the left and right nodes

//note : tree structure file needed to run this code , TreeNode.java


public class InvertBinaryTree {
    public static void main(String args[]){
        Integer[] arr = {4,2,7,1,3,6,9};

        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        TreeNode.printLevelOrder(root);

        invertTree(root);

        System.out.println();
        TreeNode.printLevelOrder(root);
    }
    public static TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}