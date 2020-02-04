/*

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

*/

class ReverseInteger {
    public int reverse(int x) {
        int cp = Math.abs(x), rem, sum = 0, prevSum = 0;
        while (cp > 0) {
            rem = cp % 10;
            prevSum = sum;
            sum = sum * 10 + rem;
            if (((sum - rem) / 10) != prevSum) {
                return 0;
            }
            cp = cp / 10;
        }
        if (x < 0) {
            sum = sum * -1;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);
            
            int ret = new Solution().reverse(x);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}