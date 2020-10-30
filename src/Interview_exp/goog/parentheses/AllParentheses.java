/*LC20: Valid Parentheses
https://leetcode.com/problems/valid-parentheses/
Given a string containing just the characters
'(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "{[]}"
Output: true*/
class Sln1{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
/*LC22: Generate Parentheses
* https://leetcode.com/problems/generate-parentheses/
Given n pairs of parentheses, write a
* function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]*/
class Sln2{
    void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max) {
            backtrack(ans, cur + "(", open + 1, close, max);
        }
        if (open > close) {
            backtrack(ans, cur + ")", open, close + 1, max);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
}
//n-th Catalan num#  1/(n+1)(2nCn)<=4^n/n*n^(0.5)
//T:O(4^n/n^(0.5)).
//S:O(4^n/^(0.5)).
/*LC241: Different Ways to Add Parentheses
https://leetcode.com/problems/different-ways-to-add-parentheses/
Given a string of numbers and operators, return all
possible results from computing all the different
possible ways to group numbers and operators.
The valid operators are +, - and *.
Example 1:
Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2

Example 2:
Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10*/
class Sln3{
    public List<Integer> diffWaysToCompute(String input){
        List<Integer> ret=new LinkedList<>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='-'||input.charAt(i)=='*'||input.charAt(i)=='+'){
                String p1=input.substring(0,i);
                String p2=input.substring(i+1);
                List<Integer> p1Ret=diffWaysToCompute(p1);
                List<Integer> p2Ret=diffWaysToCompute(p2);
                for(Integer p1:p1Ret){
                    for(Integer p2:p2Ret){
                        int c=0;
                        switch (input.charAt(i)){
                            case '+':c=p1+p2;
                            case '*':c=p1*p2;
                            case '/':c=p1/p2;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if(ret.size()==0)
            ret.add(Integer.valueOf(input));
        return ret;
    }
}
class Sln4{
    List<Integer> computeDP(String ip,Map<String,List<Integer>> dpMap){
        List<Integer> res;
        for(int i=0;i<ip.length();i++){
            if(ip.charAt(i)=='+'||ip.charAt(i)=='-'||ip.charAt(i)=='*'){
                List<Int> r1,r2;
                if(dpMap.get(ip.substring(0,i))!=null) r1=dpMap.get(ip.substring(0,i));
                else r1=computeDP(ip.substring(0,i),dpMap);
                if(dpMap.get(ip.substring(i+1))!=null) r2=dpMap.get(ip.substring(i+1));
                else r2=computeDP(ip.substring(i+1),dpMap);
                for(int ri:r1){
                    for(int rj:r2 ){
                        int c=0;
                        switch (input.charAt(i)){
                            case '+':c=ri+rj;
                            case '*':c=ri*rj;
                            case '/':c=ri/rj;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if(res.size()==0)
            res.add(Integer.valueOf(ip));
        dpMap.put(ip,res);
        return res;
    }
    public List<Integer> diffWaysToCompute(String input){
        Map<String,List<Integer>> dpMap=new HashMap<>();
        return computeDP(input,dpMap);
    }
}
/*LC301: Remove Invalid Parentheses
https://leetcode.com/problems/remove-invalid-parentheses/
Remove the minimum number of invalid
parentheses in order to make the input
string valid. Return all possible results.
Note: The input string may contain letters
other than the parentheses ( and ).
Example 1:
Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:
Input: ")("
Output: [""]*/
class Sln5{
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }
}
class Sln6{
    public List<String> removeInvalidParentheses(String s){
        List<String> ans=new ArrayList<>();
        remove(s,ans,0,0,new char[]{'(',')'});
        return ans;
    }
    void remove(String s,List<String> ans,int last_i,int last_j,char[] par){
        for(int stack=0;i=last_i;i<s.length();i++){
            if(s.charAt(i)==par[0]) stack++;
            if(s.charAt(i)==par[1]) stack--;
            if(stack>=0) continue;
            for(int j=last_j;j<=i;j++)
                if(s.charAt(j)==par[1] && (j==last_j||s.charAt(j-1)!=par[1]))
                    remove(s.substring(0,j)+s.substring(j+1),ans,i,j,par);
            return;
        }
        String reversed=new StringBuilder(s).reverse().toString();
        if(par[0]=='(')
            remove(reversed,ans,0,0,new char[]{')','('});
        else
            ans.add(reversed);
    }
}
/*LC678: Valid Parenthesis String
https://leetcode.com/problems/valid-parenthesis-string/
Given a string containing only three types of
characters: '(', ')' and '*', write a function
to check whether this string is valid.
We define the validity of a string by these rules:

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
Output: True
Note:
The string size will be in the range [1, 100].
scan from left to right, and record counts of unpaired
‘(’ for all possible cases. For ‘(’ and ‘)’,
it is straightforward, just increment and decrement all counts, respectively.
When the character is '*', there are three cases,
‘(’, empty, or ‘)’, we can think those three cases
as three branches in the ongoing route.
Take “(**())” as an example. There are 6 chars:
----At step 0: only one count = 1.
----At step 1: the route will be diverted into three branches.
so there are three counts: 1 - 1, 1, 1 + 1 which is 0, 1, 2, for ‘)’, empty and ‘(’ respectively.
----At step 2 each route is diverged into three routes again. so there will be 9 possible routes now.
-- For count = 0, it will be diverted into 0 – 1, 0, 0 + 1, which is -1, 0, 1, but when the count is -1, that means there are more ‘)’s than ‘(’s, and we need to stop early at that route, since it is invalid. we end with 0, 1.
-- For count = 1, it will be diverted into 1 – 1, 1, 1 + 1, which is 0, 1, 2
-- For count = 2, it will be diverted into 2 – 1, 2, 2 + 1, which is 1, 2, 3
To summarize step 2, we end up with counts of 0,1,2,3
----At step 3, increment all counts --> 1,2,3,4
----At step 4, decrement all counts --> 0,1,2,3
----At step 5, decrement all counts --> -1, 0,1,2, the route with count -1 is invalid, so stop early at that route. Now we have 0,1,2.
In the very end, we find that there is a route that can reach count == 0. Which means all ‘(’ and ‘)’ are cancelled. So, the original String is valid.
Another finding is counts of unpaired ‘(’ for all valid routes are consecutive integers. So we only need to keep a lower and upper bound of that consecutive integers to save space.
One case doesn’t show up in the example is: if the upper bound is negative, that means all routes have more ‘)’ than ‘(’ --> all routes are invalid --> stop and return false.*/
class Sln7 {
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