package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public static void main(String args[]){
        Integer [] arr = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        List<Double> ans = avg(root);
        System.out.println(ans);
    }
    public static List<Double> avg(TreeNode root){
        List<Double> list = new LinkedList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            double size = q.size();
            double avg = 0;
            for(int i = 0 ; i < size ; i++){
                TreeNode curr = q.poll();
                avg += curr.val;
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            list.add(avg/size);
        }
        return list;
    }
}
