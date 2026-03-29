package TwoPointers;

public class ContainerWithMostWater {
    public static void main(String args[]){
        int[] array = {1,8,6,2,5,4,8,3,7};
        int area = findMax(array);
        System.out.println(area);
    }
    public static int findMax(int[] array){
        int l = 0;
        int r = array.length - 1;
        int area = 0;
        while(l < r){
            int min = Math.min(array[l], array[r]);
            int maxArea = min * (r - l);
            area = Math.max(maxArea , area);
            if(array[l] < array[r]){
                l++;
            }else{
                r--;
            }
            
        }
        return area;
    }
}
