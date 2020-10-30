/* LC8: my atoi
https://leetcode.com/problems/string-to-integer-atoi/
Example 1:
Input: "42"
Output: 42

Example 2:
Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:
Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

Example 4:
Input: "words and 987"
Output: 0.
* */
class Sln {
    public double atoi(String str) {
        int n = str.length(), idx = -1;
        int sign = str.charAt(0) == '-' ? -1 : 1;
        double result;
        boolean isFloat = false;
        for (int i = 1; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '.') {
                idx = i;
                isFloat = true;
                continue;
            }
            int digit = ch - '0';
            result = result * 10 + digit;
        }
        if (isFloat)
            result /= Math.pow(10, n - idx - 1);
        return result * sign;
    }
}