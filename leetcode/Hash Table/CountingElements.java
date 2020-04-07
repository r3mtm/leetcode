/*

TAGS={Hash Table}
From 30-Day LeetCoding Challenge - April '20.

Counting Elements

Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.

Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.
 

Constraints:

1 <= arr.length <= 1000
0 <= arr[i] <= 1000

*/

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int countElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int i = 0; i < arr.length; ++i) {
            map.put(arr[i] + 1, map.getOrDefault(arr[i] + 1, 0) + 1);
        }
        for (int i = 0; i < arr.length; ++i) {
            if (map.containsKey(arr[i])) {
                count += map.get(arr[i]);
                map.remove(arr[i]);
            }
        }
        return count;
    }
}
public class CountingElements {
    public static void main (String[] args) {
        int[] arr = {1,3,2,3,5,0};
        System.out.println(new Solution().countElements(arr));
    }
}