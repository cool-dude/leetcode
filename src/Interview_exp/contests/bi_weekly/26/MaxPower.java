/*LC1446: Consecutive Characters
https://leetcode.com/problems/consecutive-characters/
Given a string s, the power of the string is the maximum
length of a non-empty substring that contains only
one unique character.

Return the power of the string.
Example 1:
Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.

Example 2:
Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5

Example 4:
Input: s = "hooraaaaaaaaaaay"
Output: 11*/
class Sln{
    public int maxPower(String s){
        int ans=1;
        for(int i=1,cnt=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1))
                cnt++;
            else
                cnt=1;
            ans=Math.max(ans,cnt);
        }
        return ans;
    }
}
