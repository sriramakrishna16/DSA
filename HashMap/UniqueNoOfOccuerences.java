import java.util.HashMap;
import java.util.HashSet;

public class UniqueNoOfOccuerences {
    public static void main(String [] args){
        int [] arr = {2,2};
        boolean ans = uniqueOccurences(arr);
        System.out.println(ans);
    }

    public static boolean uniqueOccurences(int [] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int freq : map.values()){
            set.add(freq);
        }
        return map.size() == set.size();
    }
}
