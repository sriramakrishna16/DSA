package Arrays;

//problem , we have to implement a data structure so that insert , remove and getRandom works in O(1).
// if problem never asked about getRandom , we can do it using single hashset or hashmap
//but if problem asked get random too, hashset doesnt work and hashmap takes o(n) breaks the requirement.
//so we use list and hashmap to get random in o(1) , by using list to get val in o(1).
 
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom {
    static List<Integer> list;
    static HashMap<Integer,Integer> map;
    static Random random;
    
    public InsertDeleteGetRandom(){
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    public boolean insert(int val){
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size() - 1);
        return true;
    } 

    public boolean remove(int val){
        if(!map.containsKey(val)){
            return false;
        }

        int index = map.get(val);
        int last = list.get(list.size() - 1);

        list.set(index,last);
        map.put(last,index);

        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    public int getRandom(){
        return list.get(random.nextInt(list.size()));
    }
    public static void main(String args[]){
        InsertDeleteGetRandom i = new InsertDeleteGetRandom();
        System.out.println(i.insert(1));
        System.out.println(i.insert(1));
        System.out.println(i.insert(3));
        System.out.println(i.insert(10));
        System.out.println(i.remove(1));
        System.out.println(i.remove(1));
        System.out.println(i.getRandom());
    }
}
