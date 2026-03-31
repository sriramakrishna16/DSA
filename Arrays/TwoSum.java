package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


// brute force approach order of n2
//for returning all possible items , we use List of int [] arrays that is arraylist 
//only one possible solution , return immediately after finding . only use array that is int[] result 

// class Twosum {
//     public static void main(String [] args){
//         int arr[] ={2,7,11,15,2,7};
//         int target = 9;
//         List<int[]> result  = findTwoSum(arr,target);
//         for(int[] pair : result){
//             System.out.println(Arrays.toString(pair));
//         }
//     }
//     public static List<int[]> findTwoSum(int nums[],int target){
//         List<int[]> result = new ArrayList<>(); 
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(target == nums[i] + nums [j]){
//                     result.add(new int[]{i,j});
//                 }
//             }
//         }
//         return result;
        
//     }
// }


//Optimised approach

//I use a HashMap to store previously seen indices. For each element,
//  I check the complement in O(1) and collect all matches, reducing complexity from O(n²) to O(n)."

//HashMap is a java collection thats uses key value pair to store

//at storing each value , i will check with next to store item with o(1) to collect all possible pairs

// class Twosum{
//     public static void main(String [] args){
//         int nums[] = {2,7,11,15,18};
//         int target = 9;
//         int[] result = findTwoSum(nums,target);
//         System.out.println(Arrays.toString(result));
//     }
//     public static int[] findTwoSum(int[] nums, int target){
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int i = 0 ; i< nums.length ; i++){
//             int needed = target - nums[i];
//             if (map.containsKey(needed)){
//                 return new int[]{map.get(needed),i};
//             }
//             map.put(nums[i], i);
//         } 
//         return new int[] {};
//     }

// }


//all possible solutions

class Twosum{
    public static void main(String [] args){
        int nums[] = {2,7,11,15,18,2,5,7,4};
        int target = 9;
        List<int[]> result = findTwoSum(nums,target);
        for(int[] i: result){
            System.out.println(Arrays.toString(i));
        }
        
    }
    public static List<int[]> findTwoSum(int[] nums, int target){
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<int []> result = new ArrayList<>();
        for (int i = 0 ; i< nums.length ; i++){
            int needed = target - nums[i];
            if (map.containsKey(needed)){
                for(int index : map.get(needed)){
                    result.add(new int[]{index,i});
                }
            }
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
            //if key present directly we add in list
        } 
        return result;
    }
}