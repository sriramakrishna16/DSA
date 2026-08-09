package Z_LeetCode_Contest.Week514;
import java.util.HashMap;
import java.util.Arrays;

//problem given an array of nodes as index with values as parents mean parent = [-1,0,0,2,1] , 1st node parent -1
//  root , 2nd node parent 0 , 3rd node parent 0, 4 node 2 , 5 th node 1.

// and also given an array of values which denotes the node i
// weight of node is nums[i] * (height - depth + 1) mean [5] -> node 1 parent -1 and node 1 val - 5

//we have to return the sum of weights of all nodes.
//solution done by simply finding the depth of each node. 

public class WeightedSumOfATree {
    public static void main(String [] args){
        int parent[] = {-1,0,0,2,1};
        int nums[] = {23,63,38,82,15};
        long ans = weightedSum(parent,nums);
        System.out.println(ans); 
    }

    public static long weightedSum(int[] parent, int[] nums){
        // it only works if problem gurenteed that the parent[i] < i for all i..
        //but if parent is greater than current i , it fails example node 3 parent 2 works
        // node 3 parent node 4 then it fails because we never calculated the node 4 before node.

        // HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0,1);
        // int height = 1;
        // for(int i = 1 ; i < parent.length ; i++){
        //     int depth = map.get(parent[i]) + 1;
        //     map.put(i, depth);
        //     height = Math.max(height, depth);
        // }
        // System.out.println(map.values());
        // long sum = 0;
        // for(int i = 0 ; i < nums.length ; i++){
        //     int depth = map.get(i);
        //     sum += nums[i] * (height - depth + 1);
        // }
        // return sum;

        int n = parent.length;
        int [] depth = new int[n];
        int height = 1;
        for(int i = 0 ; i < n ; i++){
            depth[i] = findDepth(i, parent, depth);
            height = Math.max(height, depth[i]);
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) nums[i] * (height - depth[i] + 1);
        }
        return sum;
    }
    public static int findDepth(int i , int [] parent, int [] depth){
        if(depth[i] != 0){ //-1,0,0,2,1...?
            return depth[i];
        }
        if(parent[i] == -1){
            return depth[i] = 1;
        }
        return depth[i] = findDepth(parent[i], parent, depth) + 1;
    }
}
