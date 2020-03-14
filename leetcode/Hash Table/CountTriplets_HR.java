/*

Problem : https://www.hackerrank.com/challenges/count-triplets-1/problem

*/

import java.io.*;
import java.util.*;

public class CountTriplets_HR {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long count = 0, a;
        Map<Long, Integer> map_second = new HashMap<Long, Integer>();
        Map<Long, Integer> map_third = new HashMap<Long, Integer>();
        if (r == 1) {
            for (int i = 0; i < arr.size(); ++i) {
                a = arr.get(i);
                map_second.put(a, map_second.getOrDefault(a, 0) + 1);
            }
            for (long i : map_second.values()) {
                count += i * (i - 1) * (i - 2) / 6;
            }
            return count;
        }
        for (int i = 0; i < arr.size(); ++i) {
            a = arr.get(i);
            count += map_third.getOrDefault(a, 0);

            if (map_second.containsKey(a)) {
                map_third.put(a * r, map_third.getOrDefault(a * r, 0) + map_second.get(a));
            }
            
            map_second.put(a * r, map_second.getOrDefault(a * r, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        long[] old = {1, 2, 1, 2, 4};
        //long[] old = new long[100000];
        //Arrays.fill(old, 1237);
        int r = 1;
        List<Long> arr = new ArrayList<Long>();
        for (int i = 0; i < old.length; ++i) {
            arr.add(old[i]);
        }
        System.out.println("Count = " + countTriplets(arr, r));
    }
}
