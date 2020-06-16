/*

TAGS={String}

468. Validate IP Address

Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
The groups are separated by colons (":").
For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones,
 so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity.
For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Note: You may assume there is no extra space or special characters in the input string.

Example 1:
Input: "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".


Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".


Example 3:
Input: "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.


*/

class Solution {
    public String validIPAddress(String IP) {
        
        if (IP.length() > 39) return "Neither";
        
        if (IP.indexOf(".") > -1) {
            if(checkValidIPv4(IP)) {
                return "IPv4";
            }
        } else {
            if (checkValidIPV6(IP)) {
                return "IPv6";
            }
        }
        return "Neither";
    }
    
    private boolean checkValidIPV6(String IP) {
        
        int fromIndex = 0, count = 0, nextIndex;
        String subStr;
        
        while ((nextIndex = IP.indexOf(":", fromIndex)) > -1) {
            ++count;
            int subCount = 0;
            for (int i = fromIndex; i < nextIndex; ++i) {
                if (!((IP.charAt(i) >= '0' && IP.charAt(i) <= '9') 
                    || (IP.charAt(i) >= 'a' && IP.charAt(i) <= 'f')
                    || (IP.charAt(i) >= 'A' && IP.charAt(i) <= 'F')))   return false;
                ++subCount;
            }
            if (!(subCount > 0 && subCount < 5)) return false;
            fromIndex = nextIndex + 1;
        }
        int subCount = 0;
        for (int i = fromIndex; i < IP.length(); ++i) {
            if (!((IP.charAt(i) >= '0' && IP.charAt(i) <= '9') 
                || (IP.charAt(i) >= 'a' && IP.charAt(i) <= 'f')
                || (IP.charAt(i) >= 'A' && IP.charAt(i) <= 'F')))   return false;
            ++subCount;
        }
        if (!(subCount > 0 && subCount < 5)) return false;
        
        return count == 7 ? true : false;
    }
    
    
    private boolean checkValidIPv4(String IP) {
        int fromIndex = 0, count = 0, nextIndex;
        String subStr;
        
        while ((nextIndex = IP.indexOf(".", fromIndex)) > -1) {
            ++count;
            subStr = IP.substring(fromIndex, nextIndex);
            if (subStr.length() == 0) return false;
            if ((subStr.charAt(0) == '0' || subStr.charAt(0) == '-') && subStr.length() > 1) return false;
            try {
                int num = Integer.parseInt(subStr);
                if (!(num > -1 && num < 256)) return false; 
                
            } catch (Exception e) {
                return false;
            }
            fromIndex = nextIndex + 1;
        }
        
        subStr = IP.substring(fromIndex, IP.length());
        if (subStr.length() == 0) return false;
        if ((subStr.charAt(0) == '0' || subStr.charAt(0) == '-') && subStr.length() > 1) return false;
        try {
            int num = Integer.parseInt(subStr);
            if (!(num > -1 && num < 256)) return false; 
        } catch (Exception e) {
            return false;
        }
        
        return count == 3 ? true : false;
    }
}

public class ValidateIPAddress_468 {
    public static void main (String[] args) {
        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(new Solution().validIPAddress(IP));
    }
}