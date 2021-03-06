/*

914. X of a Kind in a Deck of Cards


In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.
 

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false´
Explanation: No possible partition.
Example 3:

Input: deck = [1]
Output: false
Explanation: No possible partition.
Example 4:

Input: deck = [1,1]
Output: true
Explanation: Possible partition [1,1].
Example 5:

Input: deck = [1,1,2,2,2,2]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2].
 

Constraints:

1 <= deck.length <= 10^4
0 <= deck[i] < 10^4

*/


class Solution {
    
    public int gcd(int a, int b) {
        
        // int r, temp;
        // if (b > a) {
        //     temp = a;
        //     a = b;
        //     b = temp;
        // }

        // r = a % b;

        // while(r != 0) {
        //     a = b;
        //     b = r;
        //     r = a % b;
        // }
        // return b;
        
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
    
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int card : deck) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        int X = map.get(deck[0]);
        
        for (int val : map.values()) {
            X = gcd(val, X);
        }
        
        if (X > 1) {
            return true;
        }
        return false;
    }
}

public class XKindDeckofCards_914 {
    public static void main (String[] args) {
        int[] deck = {1,1,1,2,2,2,3,3};
        System.out.println(new Solution().hasGroupsSizeX(deck));
    }
}