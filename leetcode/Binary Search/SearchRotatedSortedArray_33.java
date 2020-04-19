/*

TAGS={Array, Binary Search}

33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

*/

class Solution {
    //Time - O(log(N))
    //Space - O(1)
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                    return mid;
            }
            // If the target element is within the sorted range.
            // e.g. "4,5,6,7,8" in 4,5,6,7,8,0,1,2,3 and target = 5
            if (nums[left] <= nums[mid] && target >= nums[left]) {
                if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[right] && (target < nums[mid] || target >= nums[left])) {
                // Go to the first half if the target element is greater than the "left" element (e.g. 14,15,1,2,3 and target = 15)
                // or target is less than the "mid" element (e.g. 5,1,2,3,4 and target = 1), WHILE SECOND HALF REMAINS RELATIVELY SORTED,
                // so that inputs like (4,5,6,7,0,1,2 and target = 0) are not counted
                right = mid - 1;
            } else {
                //e.g. 4,5,6,7,0,1,2 and target = 0
                left = mid + 1;
            }
        }    
        return -1;
    }
}

public class SearchRotatedSortedArray_33 {
    public static void main (String[] agrs) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(new Solution().search(nums, target));
    }
}
