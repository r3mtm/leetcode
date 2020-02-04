/*

1304. Find N Unique Integers Sum up to Zero


Given an integer n, return any array containing n unique integers such that they add up to 0.


Example 1:

Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

Example 2:

Input: n = 3
Output: [-1,0,1]

Example 3:

Input: n = 1
Output: [0]

 

Constraints:

    1 <= n <= 1000

*/

class Solution {
    public int[] sumZero(int n) {
        int[] nos = new int[n];
        int k = 0;
        if (n % 2 != 0) {
            nos[k++] = 0;
        }
        for (int i = 1; i <= n/2; ++i) {
            nos[k++] = i;
            nos[k++] = -i;
        }
        return nos;
    }
}

public class FindUniqueIntegersSumZero {
    public static void main (String[] args) {
        System.out.println(new Solution().sumZero(9));
    }
}