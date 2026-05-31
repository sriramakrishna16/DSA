import java.util.HashSet;
import java.util.Set;

//problem , given unsorted array of numbers.
// we have to return the length of longest continous element sequences.

//using graphs to solve this , first add all nodes into set and traverse each node that is node -1 
//node + 1 to the current node and increase length if sequnece found and mark each visited node.

//instead of graph , hashset itself can handle this problem in optimised way.

public class LongestConsecutiveSequence {
    public static void main(String args[]){
        int [] nums = {100,4,5,6,7,200,1,3,2};
        int ans = findMax(nums);
        System.out.println(ans);
    }

    //graph solution

    // public static int findMax(int[] nums){
    //     Set<Integer> set = new HashSet<>();

    //     for(int num : nums){
    //         set.add(num);
    //     }

    //     Set<Integer> visited = new HashSet<>();

    //     int maxLen = 0;

    //     for(int num : set){
    //         if(!visited.contains(num)){
    //             int len = dfs(num, visited, set);
    //             maxLen = Math.max(len, maxLen);
    //         }
    //     }

    //     return maxLen;
    // }
    // public static int dfs(int num, Set<Integer> visited , Set<Integer> set){
    //     visited.add(num);
    //     int count = 1;

    //     if(set.contains(num - 1) && !visited.contains(num - 1)){
    //         count += dfs(num-1, visited, set);
    //     }

    //     if(set.contains(num + 1) && !visited.contains(num + 1)){
    //         count += dfs(num + 1 , visited, set);
    //     }

    //     return count;
    // }


    //Simple hashSet solution 

    public static int findMax(int[] nums){
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int maxLen = 0;

        for(int num : set){
            if(!set.contains(num - 1)){
                int current = num;
                int len = 1;
                while(set.contains(current + 1)){
                    current++;
                    len++;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
}
