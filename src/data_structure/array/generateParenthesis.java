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
class Sln {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList();
        backtrack(ans,"",0,0,n);
        return ans;
    }
    public void backtrack(List<String> ans,String cur,int open,int close,int n){
        if(cur.length() == n*2){
            ans.add(cur);
            return;
        }
        if(open>close){
            backtrack(ans, cur+')',open,close+1,n);
        }
        if(open<n){
            backtrack(ans, cur+'(',open+1,close,n);
        }
    }
}
//n-th Catalan num#  1/(n+1)(2nCn)<=4^n/n*n^(0.5)
//T:O(4^n/n^(0.5)).
//S:O(4^n/^(0.5)).