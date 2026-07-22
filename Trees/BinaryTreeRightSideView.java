package Trees;
import java.util.*;

public class BinaryTreeRightSideView {
    public static void main(String args[]){
        Integer arr[] = {1,2,3,4,null,null,null,5};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        List<Integer> ans = rightSide(root);
        System.out.println(ans);
    }
    public static List<Integer> rightSide(TreeNode root){
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size ; i++){
                TreeNode curr = q.poll();
                if(i == size - 1){
                    list.add(curr.val);
                }
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
        }
        return list;
    }
}
