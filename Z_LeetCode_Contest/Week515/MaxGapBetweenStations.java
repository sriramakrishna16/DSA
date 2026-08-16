package Z_LeetCode_Contest.Week515;

public class MaxGapBetweenStations {
    public static void main(String [] args){
        String skill = "aa";
        String station = "aaaa";
        int ans = maximumGap(skill, station);
        System.out.println(ans);
    }
    public static int maximumGap(String skill, String station){
        int n = skill.length();
        int m = station.length();
        if(n <= 1){
            return 0;
        }
        int[] L = new int[n];
        int[] R = new int[n];
        int stationIdx = 0;
        for(int i = 0; i < n; i++){
            while(stationIdx < m && station.charAt(stationIdx) != skill.charAt(i)){
                stationIdx++;
            }
            L[i] = stationIdx;
            stationIdx++;
        }
        stationIdx = m - 1;
        for(int i = n - 1; i >=0 ; i--){
            while(stationIdx >= 0 && station.charAt(stationIdx) != skill.charAt(i)){
                stationIdx--;
            }
            R[i] = stationIdx;
            stationIdx--;
        }
        int maxGap = 0;
        for(int i = 1; i < n; i++){
            maxGap = Math.max(maxGap, R[i] - L[i-1]);
        }
        return maxGap;
    }
}
