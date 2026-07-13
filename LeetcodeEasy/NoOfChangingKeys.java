package LeetcodeEasy;

//key changiing from capital to small only considered as key change.

public class NoOfChangingKeys {
    public static void main(String args[]){
        String s = "aAbBc";
        int ans = countKeys(s);
        System.out.println(ans);
    }
    public static int countKeys(String s){
        s = s.toLowerCase();

        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)){
                count++;
            }
        }

        return count;
    }
}
