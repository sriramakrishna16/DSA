package Trees;

//problem , given an array that represents level order tree of BST
// in that tree we have to return kth smallest value

//BST , all small value are on left side

//so , we use simply inorder traversal that is left -> root -> right which is exactly prints smallest values in order
// and when we reache the required value depends on k, we return

public class KthSmallestElementInBst {
    public static void main(String args[]){
        Integer [] a = {3,1,4,null,2};
        TreeNode root = TreeNode.buildTreeLevelOrder(a);
        int k = 1;

        int small = findElement(root, k);
        System.out.println(small);
    }

    static int count = 0;
    static int ans = -1;

    public static int findElement(TreeNode root, int k ){
        inorder(root, k);
        return ans;
    }

    public static void inorder(TreeNode root , int k){
        if(root == null || ans != -1){
            return;
        }
        
        inorder(root.left, k);

        count++;

        if(count == k){
            ans = root.val;
            return;
        }

        inorder(root.right, k);
    }
}
