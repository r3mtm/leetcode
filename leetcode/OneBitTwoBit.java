/*

1-bit and 2-bit Characters

We have two special characters. The first character can be represented by one bit 0.
The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits.
Return whether the last character must be a one-bit character or not.
The given string will always end with a zero.

Example 1:

Input: 
bits = [1, 0, 0]
Output: True
Explanation: 
The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.

Example 2:

Input: 
bits = [1, 1, 1, 0]
Output: False
Explanation: 
The only way to decode it is two-bit character and two-bit character.
So the last character is NOT one-bit character.

Note:
1 <= len(bits) <= 1000.
bits[i] is always 0 or 1.


*/

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int last = bits.length - 1;
        if (bits.length > 1 && bits[bits.length - 2] == 0) {
            return true;
        } else {
            while (i < bits.length) {
                if (bits[i] == 1) {
                    if (i+1 == last) {
                        return false;
                    } else {
                        i = i + 2;
                    }
                } else if (i == last) {
                    return true;
                } else {
                    ++i;
                }
            }
        }
        return false; //doesn't matter what it returns;
    }
}

public class OneBitTwoBit {
    public static void main (String[] args) {
        int[] ar = {1, 1, 1, 0, 1, 0};
        System.out.println(new Solution().isOneBitCharacter(ar));
    }
}