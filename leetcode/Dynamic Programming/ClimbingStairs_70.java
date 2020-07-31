/*

TAGS={Dynamic Programming}

70. Climbing Stairs


You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps


Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45

*/

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dfs(0, n, dp);
        return dp[0];
    }
    
    public int dfs(int step, int n, int[] dp) {
        if (step == n) return 1;
        
        int one = 0, two = 0;
        
        if (dp[step] == 0) {
            if (step + 1 <= n) {
                one = dfs(step + 1, n, dp);
            }
            if (step + 2 <= n) {    
                two = dfs(step + 2, n, dp);
            }
            dp[step] = one + two;
        }
        
        return dp[step];
    }
}

public class ClimbingStairs_70 {
    public static void main(String[] args) {
        int n = 43;
        System.out.println(new Solution().climbStairs(n));
    }
}