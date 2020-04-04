/*

283. Move Zeroes

Given an array nums, write a function to move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.


*/

class Solution {
    //0ms solution
    //Using Two-pointer method.
    public void moveZeroes(int[] nums) {
        int i = 0;
        while(i < nums.length && nums[i] != 0){
            ++i;
        }
        for (int j = i + 1; j < nums.length; ++j) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                ++i;
            }
        }
    }

    /*
    //7ms solution.
    //Shifting numbers one by one.
    public void moveZeroes(int[] nums) {
        for (int i = 1 ; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int j = i;
                while (j - 1 > -1 && nums[j - 1] == 0) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    --j;
                }
            }
        }
    }
    */
}

public class MoveZeroes_283 {
    public static void main (String[] args) {
        int[] nums = {0,1,0,3,12};
        new Solution().moveZeroes(nums);
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
    }
}