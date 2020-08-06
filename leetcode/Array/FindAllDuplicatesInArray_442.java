/*

TAGS={Array}

442. Find All Duplicates in an Array


Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    /** 
    *   Mark all visited positions are negative,
    *   since duplicate element appears only twice,
    *   on spotting a negative number, means that
    *   that index is duplicate.
    */
    
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<Integer>();  
        for (int i = 0; i < nums.length; ++i) {
            
            int pos = Math.abs(nums[i]);
            
            if (nums[pos - 1] < 0) duplicates.add(pos);
                
            else nums[pos - 1] = -nums[pos - 1];
            
        }       
        return duplicates;
    }
}

public class FindAllDuplicatesInArray_442 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new Solution().findDuplicates(nums));
    }
}