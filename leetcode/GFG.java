/*
===== Subarray with given sum ======

Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:
Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5

Explanation :
Testcase1: sum of elements from 2nd position to 4th position is 12
Testcase2: sum of elements from 1st position to 5th position is 15


*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static void compute(int ar[], int target){
        int start = 0, end = 0, partSum = 0;
        while(true) {
            if(partSum == target){
                System.out.println((start+1) + " " + end);
                break;
            }
            if(end == ar.length && start == ar.length-1){
                System.out.println(-1);
                break;
            }
            if(partSum > target) {
                partSum = partSum - ar[start++];
            }else{
                if(end != ar.length){
                    partSum += ar[end++];
                } else {
                    ++start;
                }
            }
        }
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int target, size;
		for(int i = 0; i < testCase; ++i) {
		    size = sc.nextInt();
		    target = sc.nextInt();
		    int[] ar = new int[size];
		    sc.skip("\n");
		    String[] input = sc.nextLine().split(" ");
		    for(int k = 0; k < input.length; ++k) {
		        ar[k] = Integer.parseInt(input[k]);
		    }
		    compute(ar, target);   
		}
		sc.close();
	}
}