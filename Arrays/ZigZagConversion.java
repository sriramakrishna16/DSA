package Arrays;

public class ZigZagConversion {
    public static void main(String args[]){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String output = convert(s,numRows);
        System.out.println(output);
    }
    public static String convert(String s, int k){
        if(k == 1 || k >= s.length()){
            return s;
        }
        int n = s.length();
        int cycle = 2 * k - 2;
        StringBuilder ans = new StringBuilder();
        for(int row = 0; row < k ; row++){
            for(int j = row ; j < n; j += cycle){
                ans.append(s.charAt(j));
                int diagonal = j + cycle - 2 * row;
                if(row != 0 && row != k -1 && diagonal < n){
                    ans.append(s.charAt(diagonal));
                }
            }
        }
        return ans.toString();
    }
}
