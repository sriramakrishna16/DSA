import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {
    public static void main(String [] args){
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(0, new ArrayList<>(List.of(1,3)));
        rooms.add(1, new ArrayList<>(List.of(3,0,1)));
        rooms.add(2, new ArrayList<>(List.of(2)));
        rooms.add(3, new ArrayList<>(List.of(0)));
        boolean ans = canVisitAllRooms(rooms);
        System.out.println(ans);
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms){
        boolean [] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);
        for(boolean room : visited){
            if(!room) return false;
        }
        return true;
    }
    public static void dfs(int room, List<List<Integer>> rooms, boolean[] visited){
        if(visited[room]){
            return;
        }
        visited[room] = true;
        for(int j = 0 ; j < rooms.get(room).size(); j++){
            dfs(rooms.get(room).get(j), rooms, visited);
        }
    }
}
