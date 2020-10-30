/*LC1155: Number of Dice Rolls With Target Sum
https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
Return the number of possible ways (out of
fd total ways) modulo 10^9 + 7 to roll the
dice so the sum of the face up numbers equals target.

Example 1:
Input: d = 1, f = 6, target = 3
Output: 1
Explanation:
You throw one die with 6 faces.  There is only one way to get a sum of 3.

Example 2:
Input: d = 2, f = 6, target = 7
Output: 6
Explanation:
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.

Example 3:
Input: d = 2, f = 5, target = 10
Output: 1
Explanation:
You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.

Example 4:
Input: d = 1, f = 2, target = 3
Output: 0
Explanation:
You throw one die with 2 faces.  There is no way to get a sum of 3.
Example 5:

Input: d = 30, f = 30, target = 500
Output: 222616187
Explanation:
The answer must be returned modulo 10^9 + 7.*/
class Sln1 {
public:
    int numRollsToTarget(int d, int f, int target) {
        if(d==0||target<=0) return d==target;
        for(auto i=1;i<=f;i++)
            res=(res+numRollsToTarget(d-1, f, target-i))%1000000007;
        return res;
    }
    //T:O(f^d).
    //S:O(d).
};

class Sln2{
    int dp[31][1001]={};
    int numRollsToTarget(int d, int f, int target, int res = 0) {
        if(d==0||target<=0) return d==target;
        if(dp[d][target]>0) return dp[d][target]-1;
        for(auto i=1;i<=f;i++)
            res=(res+numRollsToTarget(d-1,f,target-i))%1000000007;
        dp[d][target]=res+1;
        return res;
    }
}