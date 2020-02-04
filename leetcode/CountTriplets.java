/*

Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class CountTriplets {
    
    //sorting function.
    static void sort (int ar[]) {
        int leftStart, leftEnd, rightStart, rightEnd;
        for (int i = 1; i < ar.length; i = 2 * i) {
            for (int j = 0; j < ar.length; j += i * 2) {
                leftStart = j;
                leftEnd = Math.min(leftStart + i - 1, ar.length-1);
                rightStart = leftEnd + 1;
                rightEnd = (rightStart + (i - 1)) > (ar.length - 1) ? ar.length -1 : rightStart + (i - 1);
                merge(ar, leftStart, leftEnd, rightStart, rightEnd);
            }
        }
    }
    
    static void merge (int[] ar, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int i = leftStart, j = rightStart, k = 0;
        int[] temp = new int[rightEnd - leftStart + 1];
        
        while (i <= leftEnd && j <= rightEnd) {
            if (ar[i] < ar[j]){
                temp[k++] = ar[i++];
            }else {
                temp[k++] = ar[j++];
            }
        }
        while (i <= leftEnd) {
            temp[k++] = ar[i++];
        }
        
        while (j <= rightEnd) {
            temp[k++] = ar[j++];
        }
        for (int x = 0; x < k; ++x, ++leftStart) {
            ar[leftStart] = temp[x];
        }
    }
    static void countTriplet (int ar[]) {
        int limit = ar.length - 2;
        int innerLimit = ar.length - 1;
        int sum, mid, count = 0, t;
        for (int i = 0; i < limit; ++i) {
            for (int j = i + 1; j < innerLimit; ++j) {
                sum = ar[i] + ar[j];
                mid = (i + j) / 2;
                t = mid;
                if (sum > ar[mid]) {
                    while (t < ar.length) {
                        if (ar[t++] == sum) {
                            ++count;
                            break;
                        }
                    }
                } else if (sum < ar[mid]) {
                    while (t > j) {
                        if (ar[t--] == sum) {
                            ++count;
                            break;
                        }
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println(-1);
        }else {
            System.out.println(count);
        }
    }
    
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner (System.in);
		int limit = sc.nextInt();
		for ( int i = 0; i < limit; ++i ) {
		    int size = sc.nextInt();
		    sc.skip("\n");
		    String[] arr = sc.nextLine().split(" ");
		    int[] num = new int[size];
		    for (int k = 0; k < size; ++k) {
		        num[k] = Integer.parseInt(arr[k]);
		    }
		    sort(num);
		    countTriplet(num);
        }
        sc.close();
	}
}
//2 3 54 10 4 67 19 23 8 7
//0 1 2  3  4 5  6  7  8 9
