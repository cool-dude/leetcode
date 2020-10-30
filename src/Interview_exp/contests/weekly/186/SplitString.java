/*LC1422: Maximum Score After Splitting a String
https://leetcode.com/problems/maximum-score-after-splitting-a-string/
Given string s of zeros and ones, return
maximum score after splitting the string.
Example 1:
Input: s = "011101"
Output: 5

Example 2:
Input: s = "00111"
Output: 5
Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5

Example 3:
Input: s = "1111"
Output: 3 */
class Sln1 {
    public int maxScore(String s) {
        int l = 0, n = s.length();
        if (n == 0 || s == null) return 0;
        int max = 0;
        while (l < n - 1) {
            int sum0 = 0, sum1 = 0;
            for (int i = 0; i <= l; i++) {
                sum0 += s.charAt(i) == '0' ? 1 : 0;
            }
            for (int i = l + 1; i < n; i++) {
                sum1 += s.charAt(i) == '1' ? 1 : 0;
            }
            max = Math.max(sum0 + sum1, max);
            l++;
        }
        return max;
    }
    //T:O(n)
    //S:O(1)
}
class Sln2{
    public int maxScore(String s) {
        int n = s.length();
        int c1 = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') c1++;
        }
        int max = 0;
        int c2 = 0;
        for(int i = 0; i < n - 1; i++) {
            if(s.charAt(i) == '0') c2++;
            else c1--;
            max = Math.max(max, c1 + c2);
        }
        return max;
    }
    //T:O(n)
    //S:O(1)
}