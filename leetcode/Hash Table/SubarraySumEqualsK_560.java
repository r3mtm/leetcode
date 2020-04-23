/*

TAGS={Hash Table, Array}

560. Subarray Sum Equals K

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

Hint 1:
Will Brute force work here? Try to optimize it.

Hint 2:
Can we optimize it by using some extra space?

Hint 3:
What about storing sum frequencies in a hash table? Will it be useful?

Hint 4:
sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1. Can we use this property to optimize it.

*/

import java.util.HashMap;

class Solution {
    //Time - O(N)
    //Space - O(N)
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            if (sum == k) {
                ++count;
            }
            map.put(sum + k, map.getOrDefault(sum + k, 0) + 1);
        }
        return count;
    }

    /*
        //Time - O(N^2)
        //Space - O(1)
        public int subarraySum(int[] nums, int k) {
            int sum;
            int count = 0;
            for (int i = 0; i < nums.length; ++i) {
                sum = 0;
                for (int j = i; j < nums.length; ++j) {
                    sum += nums[j];
                    if (sum == k) {
                        ++count;
                    }
                }
            }
            return count;
        }
    */
}

public class SubarraySumEqualsK_560 {
    public static void main (String[] args) {
        int[] nums = {3,4,7,2,-3,1,4,2,1};
        int k = 7;
        System.out.println(new Solution().subarraySum(nums, k));
    }
}