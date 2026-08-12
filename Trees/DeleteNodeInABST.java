package Trees;

public class DeleteNodeInABST {
    public static void main(String [] args){
        Integer [] arr = {5,3,6,2,4,null,7};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        int target = 3;
        TreeNode ans = deleteNode(root,target);
        if(ans == null){
            System.out.println("null");
        }else{
            TreeNode.printLevelOrder(ans);
        }
    }
        
    //general solution , not clean.

    /* public static TreeNode deleteNode(TreeNode root, int target){
        if(root == null || root.left == null && root.right == null && root.val == target){
            return null;
        }
        return delete(root,target);
    }
    static TreeNode prev = null;
    static TreeNode curr = null;
    static boolean found = false;
    public static TreeNode delete(TreeNode root, int target){
        if(root == null) return null;
        if(root.val == target){
            found = true;
            return root;
        }
        if(target > root.val){
            prev = root;
            curr = delete(root.right , target);
            if(found && curr == root.right){
                prev.right = curr.right;
                TreeNode temp = curr.right;
                if(temp != null){
                    while(temp.left != null){
                        temp = temp.left;
                    }
                    temp.left = curr.left;
                }
            } 
        }else if(target < root.val){
            prev = root;
            curr = delete(root.left , target);
            if(found && curr == root.left){
                prev.left = curr.left;
                TreeNode temp = curr.left;
                if(temp != null){
                    while(temp.right != null){
                        temp = temp.right;
                    }
                    temp.right = curr.right;
                }
            }
        }
        return root;
    } */

    //Standard solution..
    public static TreeNode deleteNode(TreeNode root, int target){
        if(root == null) return null;
        if(target < root.val){
            root.left = deleteNode(root.left, target);
        }else if(target > root.val){
            root.right = deleteNode(root.right, target);
        }else{
            if(root.left == null){
                return root.left;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode successor = root.right;
            while(successor.left != null){
                successor = successor.left;
            }
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
}
