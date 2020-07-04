/*

TAGS={Math, Dynamic Programming, Heap}

264. Ugly Number II

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.


*/

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 6) return n;
        
        int multTwo = 2, multThree = 3, multFive = 5;
        int indexTwo = 0, indexThree = 0, indexFive = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        
        for (int i = 1; i < n; ++i) {
            int min = Math.min(multTwo, Math.min(multThree, multFive));
            ugly[i] = min;
            if (min == multTwo) {
                multTwo = 2 * ugly[++indexTwo];
            } 
            if (min == multThree) {
                multThree = 3 * ugly[++indexThree];
            } 
            if (min == multFive){
                multFive = 5 * ugly[++indexFive];
            }
        }
        return ugly[n - 1];
    }
}

public class UglyNumberII_264 {
    public static void main(String[] args) {
        int n = 125;
        System.out.println(new Solution().nthUglyNumber(n));
    }
}