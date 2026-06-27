package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//problem , given a tree and we have to traverse in level order.
//and return values as group for each level , simply [[1],[2,3],[5,6,7,8]]

//we have to form tree ourselves to print values in IDE , must run TreeNode.java file

public class BinaryTreeLevelOrderTraversal {
    public static void main(String args[]){
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        List<List<Integer>> ans = levelOrderTraversal(root);
        System.out.println(ans);
    }
    public static List<List<Integer>> levelOrderTraversal(TreeNode root){
        if(root == null){
            return null;
        }

        //we use queue because level order involves bfs
        Queue<TreeNode> q = new LinkedList<>();

        //final list initialization
        List<List<Integer>> list = new ArrayList<>();

        //we add root to the queue
        q.offer(root);
        
        //so , now q is not empty
        while(!q.isEmpty()){
            //all values in queue referes to single level
            //we have to all values in queue to list and at a time , we have to insert next level values in to queue
            //so we use size to identify the values by level
            
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                TreeNode current = q.poll();
                level.add(current.val);

                if(current.left != null){
                    q.offer(current.left);
                }
                if(current.right != null){
                    q.offer(current.right);
                }
            }
            list.add(level);
        }

        return list;
    }
}
