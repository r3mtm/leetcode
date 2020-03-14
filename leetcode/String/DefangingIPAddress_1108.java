/*

1108. Defanging an IP Address

Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

 

Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
 

Constraints:

The given address is a valid IPv4 address.

*/

class Solution {
    public String defangIPaddr(String address) {
        int len = address.length();
        char[] defanged = new char[len+6];
        int k = 0;
        for (int i = 0; i < len; ++i) {
            if (address.charAt(i) == '.') {
                defanged[k++] = '[';
                defanged[k++] = '.';
                defanged[k++] = ']';
            } else {
                defanged[k++] = address.charAt(i);
            }
        }
        return String.valueOf(defanged);
    }
}

public class DefangingIPAddress_1108 {
    public static void main (String[] args) {
        String address = "255.100.50.0";
        System.out.println(new Solution().defangIPaddr(address));
    }
}