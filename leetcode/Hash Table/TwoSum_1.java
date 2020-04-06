/*

TAGS={Hash Table}

1. Two Sum

Given an array of integers, return indices of the two numbers such that
they add up to a specific target.

You may assume that each input would have exactly one solution, and
you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/


import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; ++i) {
            int dis = target - nums[i];
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(dis, i);
            }
        }
        return result;
    }
}


public class TwoSum_1 {
    public static void main (String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new Solution().twoSum(nums, target);
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i] + " ");
        }
    }
}