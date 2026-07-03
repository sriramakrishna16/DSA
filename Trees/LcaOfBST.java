package Trees;

//finding LCA in BST , in BST advantage is if p and q are less than root val then we search left else right

//if one val is in left and other in right we return root

//we can done this in two ways. One is recursion and other is iterative solution.

public class LCAOfBST {
    public static void main(String args[]){
        Integer [] arr = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        TreeNode p = find(root, 2);
        TreeNode q = find(root, 4);

        TreeNode ans = findLCA(root, p, q);
        System.out.println(ans.val);
    }
    public static TreeNode find(TreeNode root, int val){
        if(root == null){
            return root;
        }

        if(root.val == val){
            return root;
        }

        TreeNode left = find(root.left, val);

        if(left != null){
            return left;
        }

        return find(root.right, val);
    }
    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        // if(root == null ){
        //     return root;
        // }

        // if(root.val > p.val && root.val > q.val){
        //     return findLCA(root.left, p, q);
        // }else if(root.val < p.val && root.val < q.val){
        //     return findLCA(root.right, p, q);
        // }

        // return root;

        //iterative method
        while(root != null){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
    }
}
