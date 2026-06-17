import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

//problem, given List of words
//we have to find anagrams , group them together
//solution used , hashmap, key is used to identify the anagrams

public class GroupAnagram {
    public static void main(String args[]){
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // String[] strs = {""};
        List<List<String>> ans = groupStrings(strs);
        System.out.println(ans);
    }
    public static List<List<String>> groupStrings(String[] strs){
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
