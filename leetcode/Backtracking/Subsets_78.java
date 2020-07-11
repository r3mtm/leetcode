/*

TAGS={Array, DFS, Backtracking, Bit Manipulation}

78. Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/


import java.util.ArrayList;
import java.util.List;

class Solution {
    
    List<List<Integer>> list;
    
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<List<Integer>>();
        list.add(new ArrayList<>());
        recurse(nums, 0, new ArrayList<Integer>());
        return list;
    }
    
    private void recurse(int[] nums, int start, List<Integer> oldList) {
        
        for (int i = start; i < nums.length; ++i) {
            List<Integer> tempList = new ArrayList<>(oldList);
            tempList.add(nums[i]);
            list.add(tempList);
            recurse(nums, i + 1, tempList);
        }
    }
}

public class Subsets_78 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(new Solution().subsets(nums));
        
    }
}