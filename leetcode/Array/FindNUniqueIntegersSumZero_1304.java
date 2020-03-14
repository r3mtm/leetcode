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

public class FindNUniqueIntegersSumZero_1304 {
    public static void main (String[] args) {
        int n = 5;
        int[] res = new Solution().sumZero(n);
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}