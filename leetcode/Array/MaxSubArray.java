/*

Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the size of array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 110
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class MaxSubArray {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		for (int i = 0; i < limit; ++i) {
		    int size = sc.nextInt();
		    int[] ar = new int[size];
		    sc.skip("\n");
		    String []str = sc.nextLine().split(" ");
		    for (int k = 0; k < size; ++k) {
		        ar[k] = Integer.parseInt(str[k]);
		    }
		    findMaxSubArray(ar);
		}
	}
	
	public int maxSubArray(int[] nums) {
        int prevSum = nums[0], sum = nums[0];
        int left = 0, right = 0, bcIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
                bcIndex = i;
                if (sum > prevSum) {
                    prevSum = sum;
                    left = right = i;
                }
            } else if (sum > prevSum) {
                prevSum = sum;
                right = i;
                if (left < bcIndex) {
                    left = bcIndex;
                }
            }
        }
        System.out.println("Left = " + left + " right = " + right); //Range having the max. continuous sum (Optional).
        System.out.println(prevSum); //Max Sum
    }
}
