/*

TAGS={Binary Search}

35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2


Example 2:

Input: [1,3,5,6], 2
Output: 1


Example 3:

Input: [1,3,5,6], 7
Output: 4


Example 4:

Input: [1,3,5,6], 0
Output: 0

*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        return left;
    }
}

public class SearchInsertPosition_35 {
    public static void main (String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(new Solution().searchInsert(nums, target));
    }
}