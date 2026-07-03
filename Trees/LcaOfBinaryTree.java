package Trees;

// problem, given array that represents level order tree and also give root, p and q where p and q are subroots
// so we have to find the Least common ansestor of both p and q 
// if p or q is itself root , we return the root as descendant itself

public class LcaOfBinaryTree{
    public static void main(String args[]){
        Integer [] tree = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNode.buildTreeLevelOrder(tree);
        TreeNode p = find(root, 7);
        TreeNode q = find(root, 4);

        TreeNode ans = findLCA(root, p, q);
        System.out.println(ans.val);
    }
    public static TreeNode find(TreeNode root, int val){
        if(root == null ){
            return root;
        }

        if(root.val == val){
            return root;
        }

        TreeNode left = find(root.left, val);
        if(left != null){
            return left;
        }
        TreeNode right = find(root.right, val);

        return find(root.right, val);
    }
    public static TreeNode findLCA(TreeNode root , TreeNode p , TreeNode q){
        if(root == null){
            return root;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = findLCA(root.left , p , q);
        TreeNode right = findLCA(root.right , p , q);

        if(left != null && right != null){
            return root;
        }

        return left!= null ? left : right;
    }

    
}