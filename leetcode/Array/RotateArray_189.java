/*

189. Rotate Array

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Note:

==>Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
==>Could you do it in-place with O(1) extra space?

*/

class Solution {

    //Solution 
    public void reverse(int[] arr, int start, int stop) {
        int temp;
        while (start < stop) {
            temp = arr[start];
            arr[start] = arr[stop];
            arr[stop] = temp;
            ++start;
            --stop;
        }
    }
    
    public void rotate(int[] nums, int k) {
        //rotation of array in O(2n) => O(n), with O(1) space.
        reverse(nums, 0, nums.length - 1); // c* n/2 => O(n)
        k = k % nums.length; // O(1)
        reverse(nums, 0, k - 1); // O(k)
        reverse(nums, k, nums.length - 1); // O(n-k)
    }


    //Solution 2
    /*
    public void rotate(int[] nums, int k) {
        //rotation using O(n) space
        int[] result = new int[nums.length];
        int rot = k % nums.length;
        int j = 0;
        for (int i = rot; i < result.length; ++i) {
            result[i] = nums[j++];
        }
        
        for (int i = 0; i < rot; ++i) {
            result[i] = nums[j++];
        }
        
        //copying back elements.
        for (int i = 0; i < result.length; ++i) {
            nums[i] = result[i];
        }
    }
    */

    //Solution 3
    /*
    public void rotate(int[] nums, int k) {
        //rotation using O(1) space, with O(k * n) time complexity

        k = k % nums.length;
        int temp;
        for (int i = 0; i < k; ++i) {
            temp = nums[nums.length - 1];
            for (int j = nums.length - 2; j > -1; --j) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }*/
}

public class RotateArray_189 {
    public static void main (String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 8;
        new Solution().rotate(nums, k);
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
    }
}
