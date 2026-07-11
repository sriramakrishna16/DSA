package Arrays;
import java.util.Arrays;


//papers , given an array of citations where citations[i] is the number of citations a researcher received
// where in which i is the paper count
//so there are n papers and each paper has citations

// we have to return the h-index 
//in simple words h-index means, if there are 3 papers , then three papers should be >= 3 citations
// if 5 , >= 5 ciations
//so in arary , we have to find the h-index, if n not possible , then we have to find n - 1
//so at last we have to return the h-index of that array of papers.

public class HIndex {
    public static void main(String args[]){
        int citations[] = {2,2,2};
        int ans = hIndex(citations);
        System.out.println(ans);
    }
    public static int hIndex(int citations[]){
        //O(n log n) solution and O(1) space
        // Arrays.sort(citations);
        // for(int i = 0; i<citations.length; i++){
        //     int h = citations.length - i;
        //     if(citations[i] >= h){
        //         return h;
        //     }
        // }
        // return 0;

        //O(n) and O(n) bucket solution
        int n = citations.length;
        int bucket [] = new int[n +1];
        for(int citation : citations){
            if(citation >= n){
                bucket[n]++;
            }else{
                bucket[citation]++;
            }
        }
        int papers = 0;
        for(int h = n; h>=0 ; h--){
            papers += bucket[h];
            if(papers >= h){
                return h;
            }
        }
        return 0;
    }
}
