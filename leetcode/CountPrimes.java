/*

204. Count Primes

Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.


*/

class Solution { 
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int count = n - 2, k, prod;
        int sqrt = (int)Math.sqrt(n);
        boolean[] noList = new boolean[n];
        for (int i = 2; i <= sqrt; ++i) {
            if (noList[i - 1]) {
                continue;
            }
            k = 2;
            prod = i * k;
            while (prod < n) {
                if (!noList[prod - 1]) {
                    noList[prod - 1] = true;
                    --count;
                }
                prod = i * k;
                ++k;
            }
        }
        return count;
    }
}

public class CountPrimes {
    public static void main (String[] args) {
        System.out.println(new Solution().countPrimes(550));
    }
}

//Using Sieve of Eratosthenes