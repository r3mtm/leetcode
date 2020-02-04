/*

168. Excel Sheet Column Title

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...

Example 1:

Input: 1
Output: "A"

Example 2:

Input: 28
Output: "AB"

Example 3:

Input: 701
Output: "ZY"

*/

class Solution {
    public String convertToTitle(int n) {
        int rem;
        StringBuilder colTitle = new StringBuilder();
        if (n <= 0){
            return "";
        }
        while (n > 0) {
            rem = n % 26;
            n = n / 26;
            if (rem == 0) {
                colTitle.append('Z');
                --n;
            } else {
                colTitle.append((char)(64 + rem));
            }
        }
        return colTitle.reverse().toString();
    }
}

public class ExcelSheetColumnTitle {
    public static void main (String[] args) {
        System.out.println(new Solution().convertToTitle(729));
    }
}