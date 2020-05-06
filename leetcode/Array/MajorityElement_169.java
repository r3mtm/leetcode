/*

Tags={Array}

169. Majority Element

Given an array of size n, find the majority element.
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority
element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

*/


class Solution {
    // Boyer-Moore voting algorithm
    // Given majority element always exist in array.
    // 1ms
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; ++i ) {
            if (nums[i] == candidate) {
                ++count;
            } else {
                --count;
            }
            if (count == 0) {
                candidate = nums[i];
                ++count;
            }
        }
        return candidate;
    }

    /* 
    // 7ms
    // O(N)
    public int majorityElement(int[] nums) {
        float majority = nums.length / 2;
        HashMap<Integer, Integer> digitCountMap = new HashMap<Integer, Integer>();
        
        for (int num : nums) {
            int count = digitCountMap.getOrDefault(num, 0) + 1;
            if ((float) count > majority) return num;
            digitCountMap.put(num, count);
        }
        return -1;
    } */
}

public class MajorityElement_169 {
    public static void main (String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(new Solution().majorityElement(nums));
    }
}