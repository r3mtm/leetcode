/*

TAGS={Random, Binary Search}

528. Random Pick with Weight

Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.

Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]


Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]


Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments.
Solution's constructor has one argument, the array w. pickIndex has no arguments.
Arguments are always wrapped with a list, even if there aren't any.

*/

class Solution {

    int[] wt_sum;
    int sum = 0;
    
    Random randGen;
    
    public Solution(int[] w) {
        randGen = new Random();
        wt_sum = new int[w.length];
        for (int i = 0; i < w.length; ++i) {
            sum += w[i];
            wt_sum[i] = sum;
        }
    }
    
    public int pickIndex() {
        int randWt = randGen.nextInt(sum) + 1;
        int start = 0, end = wt_sum.length, mid = start + (end - start) / 2;
        
        while (start <= end) {
            if (randWt > wt_sum[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }
        return mid;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
