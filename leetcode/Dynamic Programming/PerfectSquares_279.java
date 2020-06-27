/*

TAGS={Dynamic Programming, BFS}

279. Perfect Squares

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.


Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.


*/

import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public int numSquares(int n) {
        if (n < 4) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; ++i) {
            int lvl = numSquares(n - i * i) + 1;
            min = Math.min(lvl, min);
        }

        map.put(n, min);

        return min;
    }
}

class PerfectSquares_279 {
    public static void main(String[] args) {
        int n = 60;
        System.out.println(new Solution().numSquares(n));
    }
}


/*
    * For each number substract 1,4,9...n from the given "n".
    * Some values will repeat save the distance from the number to 0.
    * If number is less 4, then only 1 can be subtracted from the number,
    * therefore return the number.

*/