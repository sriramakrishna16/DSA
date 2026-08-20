import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {
    HashMap<String, List<Pair>> map;

    public TimeBasedKeyValueStore(){
        map = new HashMap<>();
    }
    
    class Pair{
        int timestamp;
        String value;
        Pair(int timestamp , String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    public void set(String key, String value, int timestamp){
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp){
        if(!map.containsKey(key)){
            return "";
        }

        String ans = "";
        List<Pair> list = map.get(key);
        int left = 0;
        int right = list.size()-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(list.get(mid).timestamp <= timestamp){
                ans = list.get(mid).value;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String [] args){
        TimeBasedKeyValueStore t = new TimeBasedKeyValueStore();
        t.set("foo","bar",1);
        System.out.println(t.get("foo",1));
        System.out.println(t.get("foo",3));

        t.set("foo","bar2",4);
        System.out.println(t.get("foo",4));
        System.out.println(t.get("foo",5));

        System.out.println(t.get("foo",0));
    }


}
