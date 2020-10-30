/*1422. Maximum Score After Splitting a String
https://leetcode.com/problems/maximum-score-after-splitting-a-string/
Given string s of zeros and ones, return
maximum score after splitting the string.
Example 1:
Input: s = "011101"
Output: 5

Example 2:
Input: s = "00111"
Output: 5
Explanation: When left = "00"
and right = "111", we get the maximum score = 2 + 3 = 5

Example 3:
Input: s = "1111"
Output: 3 */

class Solution {
public:
    int maxScore(string s) {
        int c=0;
        rep(i,s.size()) {
            if(s[i]=='1') c++;
        }
        int ans=0;
        rep(i,s.size()-1) {
            if(s[i]=='1') c--;
            else c++;
            ans=max(ans,c);
        }
        return ans;
    }
};