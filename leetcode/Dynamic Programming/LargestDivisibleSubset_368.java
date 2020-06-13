/*

TAGS={Dynamic Programming}

368. Largest Divisible Subset

Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]

*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (nums.length == 0) return list;
        
        Arrays.sort(nums);
        
        int[] count = new int[nums.length];
        int[] prevItem = new int[nums.length];
        
        Arrays.fill(count, 1);
        Arrays.fill(prevItem, -1);
        
        int maxIndex = 0;
        
        for (int j = 1; j < nums.length; ++j) {
            for (int i = 0; i < j; ++i) {
                if (nums[j] % nums[i] == 0 && count[i] + 1 > count[j]) {
                    prevItem[j] = i;
                    count[j] = count[i] + 1;
                }
            }
            
            if (count[j] > count[maxIndex]) {
                maxIndex = j;
            }
        }
        
        while(maxIndex > -1) {
            list.add(nums[maxIndex]);
            maxIndex = prevItem[maxIndex];
        }
        
        return list;
    }
}

public class LargestDivisibleSubset_368 {
    public static void main (String[] args) {
        int[] nums = {4,8,10,240};
        List<Integer> list = new Solution().largestDivisibleSubset(nums);
    }
}