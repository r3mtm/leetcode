/*

TAGS={Binary Search, Array}

154. Find Minimum in Rotated Sorted Array II


Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1


Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?


*/


class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        int min = nums[0];
        
        while (left <= right) {
            while (left < right && nums[left] == nums[right]) {
                ++left;
                --right;
            }
            
            while (left < right && nums[left] == nums[left + 1]) ++left;
            
            while (right > left && nums[right] == nums[right - 1]) --right;
            
            mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);
            
            
            
            if (nums[left] > nums[right]) {
                if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return min;
    }

    /*
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1, mid = 0;
            int min = nums[0];
            
            while (left <= right) {
                mid = left + (right - left) / 2;
                min = Math.min(min, nums[mid]);
                
                if (nums[left] == nums[right]) {
                    for (int i = left; i <= right; ++i) {
                        min = Math.min(min, nums[i]);
                    }
                    return min;
                }
                
                if (nums[left] > nums[right]) {
                    if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    right = mid - 1;
                }
            }
            
            return min;
        }
    */

}

public class FindMinimumInRotatedSortedArrayII_154 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        System.out.println(new Solution().findMin(nums));
    }
}