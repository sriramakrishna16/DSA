import java.util.*;

public class TextJustification {
    public static void main(String args[]){
        String [] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> ans = justify(words,maxWidth);
        for(String s : ans){
            System.out.println(s);
        }
    }
    public static List<String> justify(String[] words, int width){
        List<String> result = new ArrayList<>();

        int i = 0;
        while(i < words.length){
            int j = i;
            int lineLength = 0;
            while(j < words.length && lineLength + words[j].length() + (j - i) <= width){
                lineLength += words[j].length();
                j++;
            }
            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();

            if(j == words.length || gaps == 0){
                for(int k = i; k < j ; k++){
                    sb.append(words[k]);
                    if(k != j -1){
                        sb.append(" ");
                    }
                }
                while(sb.length() < width){
                    sb.append(" ");
                }
            }else{
                int totalSpaces = width - lineLength;
                int eachGap = totalSpaces/gaps;
                int extra = totalSpaces % gaps;
                for(int k = i; k<j ; k++){
                    sb.append(words[k]);
                    if(k != j -1){
                        for(int s = 0; s < eachGap ; s++){
                            sb.append(" ");
                        }
                        if(extra > 0){
                            sb.append(" ");
                            extra--;
                        }
                    }
                }
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }
}
