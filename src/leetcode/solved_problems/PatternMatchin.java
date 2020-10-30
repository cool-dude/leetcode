/*If there were no Kleene stars (the * wildcard character
for regular expressions),  the problem would be easier -
we simply check from left to right if each character of
the text matches the pattern.

When a star is present, we may need to check many different
suffixes of the text and see if they match the rest of the
pattern. A recursive solution is a straightforward way to
represent this relationship.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    public boolean isMatch(String text, String pattern){
        if(pattern.isEmpty()) return text.isEmpty();
        boolean first_match =(!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        }
        else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}

//DP solution
//Top-down solution
enum  Result{
    TRUE, FALSE
}

class Solution{
    Result[][]  memo;

    public boolean isMatch(String text,String pattern){
        memo = new Result[text.length()+1][pattern.length()+1];
        return dp(0,0,text,pattern);
    }

    public boolean dp(int i,int j, String text, String pattern){
        if(memo[i][j]){
            memo[i][j]=Result.TRUE;
        }
        boolean ans;
        if(j==pattern.length()){
            ans = i == text.length();
        }
        else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}

//Top-down version
class Solution{
    public boolean isMatch(String text,String pattern){
        boolean[][] dp=new boolean[text.length()+1][pattern.length()+1];
        dp[text.length()][pattern.length()]=0;

        for(int i=text.length();i>=0;i--){
            for(int j=pattern.length();j>=0;j--){
                boolean first_match = (i<text.length() &&
                        (pattern.charAt(j)==text.charAt(i) ||
                                pattern.charAt(j)=='.'));
                if(j+1<pattern.length() && pattern.charAt(j+1)=='*'){
                    dp[i][j]=dp[i][j+2]||first_match && do[i+1][j];
                }
                else{
                    dp[i][j]=first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
//T: The work for every call to dp(i, j) for i=0, ... ,Ti=0,...,T; j=0, ... ,Pj=0,...,P is done once,
// and it is O(1)work. Hence, the time complexity is O(TP).
//S: O(TP).