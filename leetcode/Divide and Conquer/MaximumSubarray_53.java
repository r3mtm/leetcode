/*

TAGS={Dynamic Programming, Divide and Conquer, Array}

53. Maximum Subarray

Given an integer array nums, find the contiguous subarray
(containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using
the divide and conquer approach, which is more subtle.


*/

class Solution {
    public int maxSubArray(int[] a) {
	    int max = a[0],  currMax = a[0];
	    for (int i = 1; i < a.length; ++i) {
	        currMax += a[i];
	        
            if (currMax < a[i]) {
                currMax = a[i];
            }
            if (max < currMax) {
                max = currMax;
            }
	    }
	    return max;
    }
}

public class MaximumSubarray_53 {
    public static void main (String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(a));
    }
}