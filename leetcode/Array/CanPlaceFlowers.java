/*

605. Can Place Flowers

Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: True

Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: False

Note:

    The input array won't violate no-adjacent-flowers rule.
    The input array size is in the range of [1, 20000].
    n is a non-negative integer which won't exceed the input array size.

*/


class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, l = 0, r = i + 1;
        
        while (i < flowerbed.length) {
            //System.out.println("i = " + i);
            if (flowerbed[i] == 0) {
               if (flowerbed[l] == 0) {
                   if (r < flowerbed.length) {
                       if (flowerbed[r] == 0) {
                           --n;
                           i += 2;
                       } else {
                           i += 2;
                       }
                   } else {
                       //last element which is 0
                       ++i;
                       --n;
                   }
               } else {
                   //left of i is  1
                   ++i;
               }
            } else {
                i += 2;
            }
            
            l = i - 1;
            r = i + 1;
        }
        
        if (n <= 0) {
            return true;
        }
        return false;
    }
}

class CanPlaceFlowers {
    public static void main (String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int n = 2;
        System.out.println(new Solution().canPlaceFlowers(flowerbed, n));
    }
}