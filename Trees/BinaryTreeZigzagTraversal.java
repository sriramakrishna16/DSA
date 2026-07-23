package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagTraversal {
    public static void main(String args[]){
        Integer [] arr = {1,2,3,4,5,6,7};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        List<List<Integer>> ans = zigzag(root);
        System.out.println(ans);
    }
    public static List<List<Integer>> zigzag(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0 ; i< size ; i++){
                TreeNode curr = q.poll();
                if(leftToRight){
                    list.addLast(curr.val);
                }else{
                    list.addFirst(curr.val);
                }
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            ans.add(list);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}
