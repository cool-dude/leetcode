/*LC394: Decode String
https://leetcode.com/problems/decode-string/
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string],
where the encoded_string inside the square
brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always
valid; No extra white spaces, square brackets
are well-formed, etc.

Furthermore, you may assume that the original
data does not contain any digits and that digits
 are only for those repeat numbers, k.
 For example, there won't be input like 3a or 2[4].
Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:
Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"*/
class Sln1 {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countS = new Stack<>();
        Stack<String> resS = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countS.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resS.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resS.pop());
                int repeatTimes = countS.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}

class Sln2{
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            }
            else if (ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            }
            else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k) cur.append(tmp);
            }
            else cur.append(ch);
        }
        return cur.toString();
    }
}