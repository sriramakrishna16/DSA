package Stack;

import java.util.*;
public class NextGreaterElement{
    public static void main(String [] args){
        int nums1 [] = {4,1,2};
        int nums2 [] = {1,3,4,2};
        int [] result = findElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
    public static int[] findElement(int[] nums1,int[] nums2){
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                int index = stack.pop();
                int value = num;
                map.put(index, value); 
            }
            stack.push(num);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            int value = -1;
            map.put(index, value);
        }

        for(int i=0;i<nums1.length;i++){
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}