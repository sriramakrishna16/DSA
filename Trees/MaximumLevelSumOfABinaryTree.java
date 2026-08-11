package Trees;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree{
    public static void main(String [] args){
        Integer arr[] = {1,7,0,7,-8,null,null};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        int level = maxLevelSum(root);
        System.out.println(level);
    }
    
    public static int maxLevelSum(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int level = 1;
        int ans = 1;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0 ; i < size; i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            if(sum > max){
                max = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}