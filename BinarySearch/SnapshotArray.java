import java.util.ArrayList;
import java.util.List;

public class SnapshotArray {
    private List<List<int[]>> arr;
    private int snapId;
    public SnapshotArray(int length){
        arr = new ArrayList<>();
        for(int i = 0 ; i < length ; i++){
            List<int[]> history = new ArrayList<>();
            history.add(new int[]{0,0});
            arr.add(history);
        }
        snapId = 0;
    }
    public void set(int index, int val){
        List<int[]> history = arr.get(index);
        if(history.get(history.size()-1)[0] == snapId){
            history.get(history.size()-1)[1] = val;
        }else{
            history.add(new int[]{snapId, val});
        }
    }

    public int snap(){
        return snapId++;
    }

    public int get(int index, int snapid){
        List<int[]> history = arr.get(index);
        int left = 0;
        int right = history.size()-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(history.get(mid)[0] <= snapid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return history.get(right)[1];
    }
    public static void main(String [] args){
        SnapshotArray s = new SnapshotArray(3);
        s.set(0,5);
        int snap0 = s.snap();
        System.out.println(snap0);
        s.set(0,10);
        s.set(1,7);
        int snap1 = s.snap();
        System.out.println(snap1);
        System.out.println(s.get(0,0));
        System.out.println(s.get(0,1));
        System.out.println(s.get(1,0));
        System.out.println(s.get(1,1));
    }
}
