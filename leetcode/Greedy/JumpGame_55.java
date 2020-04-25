/*

TAGS={Greedy}

55. Jump Game

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

*/

/* 
    class Solution {
        // Time exceeded for last test case.
        // Dynamic programming.
        int[] copy;
        int dst;
        public boolean canJump(int[] nums) {
            copy = nums;
            dst = nums.length - 1;
            return check(0);
        }
        
        boolean check(int val) {
            if (val == dst) {
                return true;
            }
            if (val > dst) {
                return false;
            }
            for (int i = copy[val]; i > 0; --i) {
                if (check(val + i)) {
                    return true;
                }
            }
            return false;
        }
    } 
*/

class Solution {
    //Greedy
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        int i;
        for (i = target - 1; i > -1; --i) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        if (target == 0) {
            return true;
        }
        return false;
    }
}

public class JumpGame_55 {
    public static void main (String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Solution().canJump(nums));
    }
}
