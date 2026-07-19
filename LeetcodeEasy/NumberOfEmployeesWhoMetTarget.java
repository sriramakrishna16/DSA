package LeetcodeEasy;

public class NumberOfEmployeesWhoMetTarget {
    public static void main(String args[]){
        int [] hours = {0,1,2,3,4};
        int target = 2;
        int totEmp = findEmp(hours, target);
        System.out.println(totEmp);
    }
    public static int findEmp(int[] hours, int target){
        int count=0;
        for(int hour : hours)
            if(hour >= target) count++;
        return count;
    }
}
