/*

TAGS={Sort, Hash Table}

274. H-Index


Given an array of citations (each citation is a non-negative integer) of a researcher,
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each,
and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

*/
class Solution {
    // Using counting sort, with elements greater than length of array
    // to the last position
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int i : citations) {
            if (i >= citations.length) count[citations.length]++;
            else count[i]++;
        }
        int sum = 0;
        for (int i = count.length - 1; i >= 0; --i) {
            sum += count[i];
            if (sum >= i) return i;
        }
        
        return 0;
    }
}

public class HIndex_274 {
    public static void main(String[] args) {
        int[] citations = { 3,0,6,1,5 };
        System.out.println(new Solution().hIndex(citations));
    }
}