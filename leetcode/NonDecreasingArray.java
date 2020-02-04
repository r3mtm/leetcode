/*

665. Non-decreasing Array

Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:

Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

Example 2:

Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.

Note: The n belongs to [1, 10,000]. 

*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean isPossible = true;
        boolean alreadyMod = false;
        int len = nums.length - 1;
        
        for (int i = 0; i < len; ++i) {
            if (nums[i] > nums[i + 1]) {
                if (alreadyMod) {
                  return false;  
                }
                if (i - 1 < 0) {
                    //no issues
                    //nums[i] = nums[i + 1];
                    alreadyMod = true;
                } else {
                    if (nums[i - 1] <= nums[i + 1]) {
                        //nums[i] = nums[i + 1];
                    } else if (i + 2 <= len) {
                        if (nums[i] <= nums[i + 2]) {
                            //nums[i + 1] = nums[i + 2];
                        } else {
                            return false;
                        }
                    }
                    alreadyMod = true;
                }
            }
        }
        return isPossible;
    }
}

public class NonDecreasingArray {
    public static void main (String[] args) {
        int[] ar = {2,3,3,2,4};
        System.out.println(new Solution().checkPossibility(ar));
    }
}