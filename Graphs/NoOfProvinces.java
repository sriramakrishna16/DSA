public class NoOfProvinces {
    public static void main(String[] args){
        int [][] cities = { {1, 0, 0, 1},
                            {0, 1, 1, 0},
                            {0, 1, 1, 0},
                            {1, 0, 0, 1}};
        int ans = findProvinces(cities);
        System.out.println(ans);
    }
    public static int findProvinces(int[][] cities){
        boolean visited [] = new boolean [cities.length];
        int provinces = 0;
        for(int i = 0 ; i < cities.length ; i++){
            if(!visited[i]){
                provinces++;
                dfs(i, visited, cities);
            }
        }
        return provinces;
    }
    public static void dfs(int i , boolean [] visited, int[][] cities){
        if(visited[i]){
            return;
        }
        visited[i] = true;
        for(int j = 0 ; j < cities[0].length ; j++){
            if(cities[i][j] == 1 && !visited[j]){
                dfs(j,visited, cities);
            }
        }
    }
}
