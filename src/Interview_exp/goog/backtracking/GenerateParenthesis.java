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
class Sln1 {
    public void backtrack(List<String> ans, String cur, int open, int close, int max){
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
class Sln2 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        }
        else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis(c))
                    for (String right: generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}
//n-th Catalan num#  1/(n+1)(2nCn)<=4^n/n*n^(0.5)
//T:O(4^n/n^(0.5)).
//S:O(4^n/^(0.5)).