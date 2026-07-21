package Trees;

public class FlattenBinaryTree {
    public static void main(String args[]){
        TreeNode t = new TreeNode();
        Integer [] arr = {1,2,5,3,4,null,6};
        TreeNode root = t.buildTreeLevelOrder(arr);
        t.print(root);
        System.out.println();
        flatten(root);
        t.printLevelOrder(root); //it prints same for both preorder and levelorder because of flatten
        System.out.println();
        t.printInOrder(root);
        System.out.println();
    }
    static TreeNode prev = null;
    public static void flatten(TreeNode root){
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
