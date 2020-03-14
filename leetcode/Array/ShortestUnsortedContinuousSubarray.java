/*

581. Shortest Unsorted Continuous Subarray

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:

Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Note:

    Then length of the input array is in range [1, 10,000].
    The input array may contain duplicates, so ascending order here means <=.

*/


//Solution 1 : 5ms
/*
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int lastOrderedIndex = -1, left = -1, right = 0, k, i, max = nums[0];
        int len = nums.length - 1, nextIndex;
        for (i = 0; i < len; ++i) {
            nextIndex = i + 1;
            if (nums[i] > max) {
                max = nums[i];
            }
            if (left == -1) {
                if (nums[i] <= nums[nextIndex]) {
                    lastOrderedIndex = i;
                } else {
                    left = i;
                    right = nextIndex;
                }
            } else {
                k = lastOrderedIndex;
                while (k >= 0) {
                    if (nums[k] > nums[i]) {
                        left = k;
                        --lastOrderedIndex;
                    } else {
                        break;
                    }
                    --k;
                }
                if (nums[i] > nums[nextIndex]) {
                    right = nextIndex;
                }else if (nums[i] < max) {
                    right = i;
                }
            }
        }
        
        //Checking with the nums[nums.length-1] element
        if (nums[i] < max) {
            right = i;
        }
        
        if (left != -1) {
            k = lastOrderedIndex;
            while (k >= 0) {
                if (nums[k] > nums[i]) {
                    left = k;
                    --lastOrderedIndex;
                } else {
                    break;
                }
                --k;
            }
        }
                
        if (left <= 0 && right == 0) {
            return 0;
        }
        return Math.min(right - left + 1, nums.length);
    }
}
*/

//Solution 2 : 3ms

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length - 1;
        int left = 0, right = 0, max, min;
        int i, j;
        for (i = 0; i < len; ++i) {
            if (nums[i] > nums[i + 1]){
                left = i;
                break;
            }
        }
        if (i == nums.length - 1) {
            return 0;
        }
        
        for (j = len; j > i; --j) {
            if (nums[j - 1] > nums[j]) {
                right = j;
                break;
            }
        }
        
        min = max = nums[left];
                
        for (i = left + 1; i <= right; ++i) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int k = 0;
        while (k <= left) {
            if (nums[k] > min) {
                left = k;
                break;
            }
            ++k;
        }
        k = len;
        while (k >= right) {
            if (nums[k] < max) {
                right = k;
                break;
            }
            --k;
        }
        return right - left + 1;
    }
}

class ShortestUnsortedContinuousSubarray {
    public static void main (String[] args) {
        int[] ar = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new Solution().findUnsortedSubarray(ar));
    }
}