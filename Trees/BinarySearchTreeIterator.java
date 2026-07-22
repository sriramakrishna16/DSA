package Trees;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack = new Stack<>();
    BinarySearchTreeIterator(TreeNode root){
        pushLeft(root);
    }
    public void pushLeft(TreeNode root){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    public int next(){
        TreeNode curr = stack.pop();
        if(curr.right != null){
            stack.push(curr.right);
        }
        return curr.val;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public static void main(String args[]){
        TreeNode t = new TreeNode();
        Integer [] arr = {7, 3, 15, null, null, 9, 20};
        TreeNode root = t.buildTreeLevelOrder(arr);
        BinarySearchTreeIterator b = new BinarySearchTreeIterator(root);
        System.out.println(b.next());
        System.out.println(b.next());
        System.out.println(b.hasNext());
    }

}
