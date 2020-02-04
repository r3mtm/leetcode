/*
	Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

Input: arr1[] = {10};
       arr2[] = {2, 3};
Output: arr1[] = {2}
        arr2[] = {3, 10}  

Input: arr1[] = {1, 5, 9, 10, 15, 20};
       arr2[] = {2, 3, 8, 13};
Output: arr1[] = {1, 2, 3, 5, 8, 9}
        arr2[] = {10, 13, 15, 20} 

Input:
First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.

Output:
For each test case, print (X + Y) space separated integer representing the merged array.

Constraints:
1 <= T <= 100
1 <= X, Y <= 5*104
0 <= arr1i, arr2i <= 109

Example:
Input:
2
4 5
1 3 5 7
0 2 6 8 9
2 3
10 12
5 18 20

Output:
0 1 2 3 5 6 7 8 9
5 10 12 18 20

Explanation:
Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class MergeWithoutExtraSpace  {
    
    static void merge(int []arr1, int []arr2) {
		int key, k;
		for (int i = 0; i < arr1.length; ++i) {
			if (arr1[i] > arr2[0]) {
				swap(arr1, arr2, i, 0);
				key = arr2[0];
				k = -1;
				while (++k < arr2.length - 1) {
					if (key > arr2[k+1]) {
						arr2[k] = arr2[k+1];
					} else {
						break;
					}
				}
				arr2[k] = key;
			}
		}

		for (int i = 0; i < arr1.length; ++i) {
			System.out.print(arr1[i] + " ");
		}
		for (int i = 0; i < arr2.length; ++i) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
	}
	
	static void swap(int []arr1, int []arr2, int i, int j) {
		int temp = arr1[i];
		arr1[i] = arr2[j];
		arr2[j] = temp;
	}
    
	public static void main (String[] args) {
		//int arr1[] = {1, 5, 9, 10, 15, 20};
		//int arr2[] = {2, 3, 8, 13};
		//int []arr1 = {10};
		//int []arr2 = {2, 3};
		
		Scanner sc = new Scanner (System.in);
		int t = sc.nextInt();
		sc.skip("\n");
		for (int i = 0; i < t; ++i) {
		    String[] sizes = sc.nextLine().split(" ");
		    String[] temp1 = sc.nextLine().split(" ");
		    String[] temp2 = sc.nextLine().split(" ");
		    int size1 = Integer.parseInt(sizes[0]);
		    int size2 = Integer.parseInt(sizes[1]);
		    int[] arr1 = new int[size1];
		    int[] arr2 = new int[size2];
		    
		    for (int k = 0; k < size1; ++k) {
		        arr1[k] = Integer.parseInt(temp1[k]);
		    }
		    
		    for (int k = 0; k < size2; ++k) {
		        arr2[k] = Integer.parseInt(temp2[k]);
		    }
			merge(arr1, arr2);
		}
		sc.close();
	}
}