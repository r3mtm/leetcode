/*

New Year Chaos -- HACKERRANK

https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SolNewYearChaos_HR {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int val, count = 0;
        for(int i=0; i < q.length; ++i){
            val = q[i] - (i+1);
            if(val > 2){
                System.out.println("Too chaotic");
                return;
            }else if(val > 0){
                count += val;
            }else if(val <= 0){
                for(int j=i+1; j < q.length; ++j){
                    if(q[i] > q[j]){
                        ++count;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
