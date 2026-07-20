package Trees;
import java.util.HashMap;

//problem , construct binary tree by using inorder and postorder traversal
//solution we can get root form the last value of postorder array
// and by using root , we can find left and right sub trees using inorder values

public class BinaryTreeFromInAndPostOrder {
    public static void main(String args[]){
        int [] inorder = {9,3,15,20,7};
        int [] postorder = {9,15,7,20,3};

        TreeNode root = buildTree(inorder, postorder);
        TreeNode.printLevelOrder(root);
    }
    static int postIndex;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static TreeNode buildTree(int [] inorder , int [] postorder){
        postIndex = postorder.length - 1;
        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = build(inorder, postorder , 0 , inorder.length-1);
        return root;
    }
    public static TreeNode build(int[] inorder, int[] postorder, int left, int right){
        if(left > right){
            return null;
        }
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        root.right = build(inorder, postorder, mid+1, right);
        root.left = build(inorder, postorder, left , mid -1);

        return root;
    }
}

