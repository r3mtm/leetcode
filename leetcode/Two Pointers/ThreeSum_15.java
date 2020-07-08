import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

TAGS={Hash Table, Two pointers}

15. 3Sum

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; ++i) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int j = i + 1;
                int k = nums.length -1;
                int target = -nums[i];
                while (j < k) {
                    int sum = nums[j] + nums[k];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        while (j < k && nums[j] == nums[j + 1]) ++j;
                        while (j < k && nums[k] == nums[k - 1]) --k;

                        --k;
                        ++j;
                    }
                    else if (sum > target) --k;
                    else ++j;
                }
            }
            
        }
        return list;
    }

    /*
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1;
            int k = nums.length -1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    --k;
                    ++j;
                }
                else if (sum > 0) --k;
                else ++j;
            }
        }
        return new ArrayList<>(set);
    }
    */
}

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = new Solution().threeSum(nums);
        for (List<Integer> sublist: list) {
            for (int num : sublist) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}