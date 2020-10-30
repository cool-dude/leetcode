'''LC1446: Consecutive Characters
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
'''
class Solution:
    def maxPower(self, s: str) -> int:
        ans = cnt = 1
        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                cnt += 1
            else:
                cnt = 1
            ans = max(ans,cnt)
        return ans