package Trees;

import java.util.HashMap;

public class PathSum3 {
    public static void main(String [] args){
        Integer [] arr = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode root = TreeNode.buildTreeLevelOrder(arr);
        int targetSum = 8;
        int paths = pathSum(root, targetSum);
        System.out.println(paths);
    }
    static int count = 0;
    
    public static int pathSum(TreeNode root, int targetSum){
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        return dfs(root,0L,targetSum,map);
    }
    public static int dfs(TreeNode root, long currentSum, int targetSum, HashMap<Long,Integer> map){
        if(root == null) return 0;
        currentSum += root.val;
        int count = map.getOrDefault(currentSum-targetSum, 0);
        map.put(currentSum,map.getOrDefault(currentSum,0)+1);
        count += dfs(root.left, currentSum, targetSum, map);
        count += dfs(root.right, currentSum, targetSum, map);
        map.put(currentSum, map.get(currentSum) - 1);
        return count;
    }
}
