/*

532. K-diff Pairs in an Array

 Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:

Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

Example 2:

Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

Example 3:

Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).

Note:

    The pairs (i, j) and (j, i) count as the same pair.
    The length of the array won't exceed 10,000.
    All the integers in the given input belong to the range: [-1e7, 1e7].

*/

import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k == 0) {
            HashSet<Integer> set1 = new HashSet<Integer>();
            HashSet<Integer> set2 = new HashSet<Integer>();
            for (int x = 0; x < nums.length; ++x) {
                if (set1.contains(nums[x])) {
                    set2.add(nums[x]);
                } else {
                    set1.add(nums[x]);
                }
            }
            return set2.size();
        }
        
        int len = nums.length - 1, count = 0;
        int i = 0, j = 1, diff;
        Arrays.sort(nums);
        while (j < nums.length) {
            while (i < len && nums[i] == nums[i + 1]) {
                ++i;
            }
            
            if (j <= i) {
                if (i >= len) {
                    break;
                }
                j = i + 1;
            }
            
            while(nums[j] == nums[j - 1] && j < len) {
                ++j;
            }
            
            
            diff = nums[j] - nums[i];
            
            if (diff < k) {
                ++j;
            } else if (diff > k) {
                ++i;
            } else {
                ++count;
                ++i;
                ++j;
            }
        }
        return count;
    }
}

public class KdiffPairs {
    public static void main (String[] args) {
        int[] ar = {1,2,3,4,5};
        int k = 5;
        System.out.println(new Solution().findPairs(ar, k));
    }
}