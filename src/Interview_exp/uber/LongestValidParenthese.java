/*LC32: Longest Valid Parentheses
https://leetcode.com/problems/longest-valid-parentheses/
Given a string containing just the characters
'(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"*/
class Sln{
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<Integer>();
        int ans=0;
        // You can imagine there is a ) at index -1 position
        // i.e. s[-1] = ')'
        st.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                st.push(i);
            else {
                // if there is a match (i.e. "()"), then we can pop the stack
                // and update the max length by (i - indices.top())
                // (because the string in (indices.top(), i] is a valid parenthese)
                // else if there isn't a match (i.e. "))"), then we can substitute
                // the top of the stack by the latest one
                // To sum up, no matter "()" or "))", we all need to pop the stack
                st.pop();
                if(st.isEmpty())
                    st.push(i);
                else {
                    // if there is a match (i.e. "()"), then we can pop the stack
                    // and update the max length by (i - indices.top())
                    // (because the string in (indices.top(), i] is a valid parenthese)
                    // else if there isn't a match (i.e. "))"), then we can substitute
                    // the top of the stack by the latest one
                    // To sum up, no matter "()" or "))", we all need to pop the stack
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }
}