/*LC91: Decode Ways
https://leetcode.com/problems/decode-ways/
A message containing letters from A-Z is
being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits,
determine the total number of ways to decode it.
The answer is guaranteed to fit in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26),
"VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "0"
Output: 0
Explanation: There is no character that is mapped
to a number starting with '0'. We cannot ignore a
zero when we face it while decoding. So, each '0'
should be part of "10" --> 'J' or "20" --> 'T'.

Example 4:
Input: s = "1"
Output: 1
Constraints:
1 <= s.length <= 100
s contains only digits and may contain leading zero(s).*/
class Sln{
    public int numDecodings(String s){
        if(s==null||s.length()==0)
            return 0;
        char[] chars=s.toCharArray();
        int n=chars.length;
        int[] dp=new int[n];
        dp[0] = chars[0] == '0' ? 0 : 1;
        for(int i=1;i<n;i++){
            char cur=chars[i];
            char prev=chars[i-1];
            if(cur>='1' && cur<='9')
                dp[i]=dp[i-1];
            if((prev=='1' && cur>='0' && cur<='9')||
                    (prev=='2' && cur>='0' && cur<='6'))
                dp[i]+=i>=2?dp[i-2]:1;
        }
        return dp[n-1];
    }
}