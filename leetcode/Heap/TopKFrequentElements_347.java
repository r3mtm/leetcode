/*

TAGS={Heap, Hash Table}

347. Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.

*/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> {
            // return e2.getValue() - e1.getValue();
            return e1.getValue() - e2.getValue();
        });
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            queue.add(e);
            if (queue.size() > k) queue.poll();
        }
        
        int[] result = new int[k];
        int i = 0;
        
        while (!queue.isEmpty() && k > 0) {
            result[i++] = queue.poll().getKey();
            --k;
        }
        
        return result;
    }
}

public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = new Solution().topKFrequent(nums, k);
    }
}