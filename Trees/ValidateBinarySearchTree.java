package Trees;

//problem, given an array that represents of level order tree 
// and we have to verify is it a valid BST or not
// and return true or false

//BST rules : 1) left sub tree values should be less than root val 
           // 2) right sub tree values should be greater than root val
           // 3) now both left sub and right sub tree should follow the same rule.
           


public class ValidateBinarySearchTree {
    public static void main(String args[]){
        Integer [] a = {2,1,3};
        TreeNode root = TreeNode.buildTreeLevelOrder(a);
        TreeNode.printLevelOrder(root);
        System.out.println();

        boolean ans = isValidate(root);
        System.out.println(ans);
    }
    public static boolean isValidate(TreeNode root){
        //taking min and max values
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean validate(TreeNode root, long min , long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }

        //min and max values are used to represent the values are in correct order or not
        //in left , max = root , so left node must less than max
        //in right, min = root value, so right must greater than min
        
        boolean left = validate(root.left , min , root.val);
        boolean right = validate(root.right, root.val, max);

        return left && right;
    }
}
