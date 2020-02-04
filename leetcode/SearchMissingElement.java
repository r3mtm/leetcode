/*
    Searches for a missing number.
    If the input array is sorted use the function 'searchMissing()' with one parameter,
    else use the other one.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class SearchMissingElement {
    
    //Takes O(lg n) time
    static void searchMissing(int[] ar) {
        int left = 0, right = ar.length - 1, mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (mid < ar[mid] - 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left+1);
    }

    //Takes O(n) time.
    static void searchMissing(int[] ar, int actLen) {
        int len = ar.length;
        int sum = (len * (len + 1)) / 2;
        for (int i = 0; i < actLen; ++i) {
            sum -= ar[i];
        }
        System.out.println(sum);
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int limit = sc.nextInt();
		for (int i = 0; i < limit; ++i) {
		    int size = sc.nextInt();
		    int[] ar = new int[size];
		    sc.skip("\n");
		    String[] str = sc.nextLine().split(" ");
		    for (int k = 0; k < str.length; ++k) {
		        ar[k] = Integer.parseInt(str[k]);
            }
            searchMissing(ar);
		}
	}
}