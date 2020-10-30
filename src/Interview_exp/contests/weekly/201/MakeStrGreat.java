/*LC1544: Make The String Great
https://leetcode.com/problems/make-the-string-great/
Given a string s of lower and upper case English letters.

A good string is a string which doesn't
have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is
the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent
characters that make the string bad and remove them.
You can keep doing this until the string becomes good.

Return the string after making it good. The answer
is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.

Example 1:
Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2,
both will result "leEeetcode" to be reduced to "leetcode".

Example 2:
Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""

Example 3:
Input: s = "s"
Output: "s"
Explanation -
It should be noted that the difference between the any
lowercase and uppercase alphabet is 32. Example - ASCII value of a is 97 and A is 65 , 97-65 = 32

Using same trick, we can delete adjacent characters with absolute difference of 32.

Example -
If current character is A and a is at top of stack, we pop a and dont insert A.
Otherwise, we insert the current character in stack.
Collect result in String at the end.*/
class Sln {
    public String makeGood(String s) {
        Stack<Character> st=new Stack();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && Math.abs(st.peek()-s.charAt(i))==32)
                st.pop();
            else
                st.push(s.charAt(i));
        }
        char[] res=new char[st.size()];
        int idx=st.size()-1;
        while (!st.isEmpty())
            res[idx--]=st.pop();
        return new String(res);
    }
}