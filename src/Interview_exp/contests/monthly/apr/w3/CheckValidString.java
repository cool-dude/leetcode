/*LC678. Valid Parenthesis String
https://leetcode.com/problems/valid-parenthesis-string/
Given string containing only three types
of characters: '(', ')' and '*', write function
to check whether this string is valid.

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True*/
class Sln{
    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                max++;
                min++;
            }
            else if (c == ')') {
                max--;
                min = Math.max(min - 1, 0);
            }
            else {
                max++;
                min = Math.max(min - 1, 0);
            }
            if (max < 0) return false;
        }
        return min == 0;
    }
}