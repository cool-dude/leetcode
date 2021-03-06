/*LC1406: Stone Game III
Alice and Bob continue their games with
piles of stones. There are several stones arranged
in a row, and each stone has an associated value which
is an integer given in the array stoneValue.


Alice and Bob take turns, with Alice starting first.
On each player's turn, that player can take 1,
2 or 3 stones from the first remaining stones in the row.


The score of each player is the sum of values of the stones taken. The score of each player is 0 initially.

The objective of the game is to end with the highest score, and the winner is the player with the highest score and there could be a tie. The game continues until all the stones have been taken.

Assume Alice and Bob play optimally.

Return "Alice" if Alice will win, "Bob" if Bob will win or "Tie" if they end the game with the same score.



Example 1:
Input: values = [1,2,3,7]
Output: "Bob"
Explanation: Alice will always lose. Her best move will be to take three piles and the score become 6. Now the score of Bob is 7 and Bob wins.

Example 2:
Input: values = [1,2,3,-9]
Output: "Alice"
Explanation: Alice must choose all the three piles at the first move to win and leave Bob with negative score.
If Alice chooses one pile her score will be 1 and the next move Bob's score becomes 5. The next move Alice will take the pile with value = -9 and lose.
If Alice chooses two piles her score will be 3 and the next move Bob's score becomes 3. The next move Alice will take the pile with value = -9 and also lose.
Remember that both play optimally so here Alice will choose the scenario that makes her win.

Example 3:
Input: values = [1,2,3,6]
Output: "Tie"
Explanation: Alice cannot win this game.
She can end the game in a draw if she decided
to choose all the first three piles, otherwise she will lose.*/
/*dp[i] means, if we ignore before A[i],
what's the highest score that Alex can win over the Bob？

algo
Step1. Calculate the suffix sum of stone values.
Step2. For i = n-1, n-2, …, 0, calculate dp[i].
We need to enumerate three possible scenarios
which correspond to taking 1, 2, 3 stones at this round.
state transition: dp[i] = max(dp[i], suffixSum[i]-suffixSum[k+1] + suffixSum[k+1] - dp[k+1]) = max(dp[i], suffixSum[i] - dp[k+1])，for k = i, i+1, i+2, where (suffixSum[k+1] - dp[k+1]) means the score one can get when he/she takes stones secondly at the position k+1.
Step3. Compare suffixSum[0] with dp[0]*2. (Alice score: dp[0], Bob score: suffixSum[0]-dp[0])

Complexity
Time: O(n)
Space: O(n)*/
class Sln {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] suffixSum = new int[n+1];
        int[] dp = new int[n+1];
        suffixSum[n] = 0;
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--)
            suffixSum[i] = suffixSum[i + 1] + stoneValue[i];
        for (int i = n-1; i >= 0; i--) {
            dp[i] = stoneValue[i] + suffixSum[i+1] - dp[i+1];
            for (int k = i+1; k < i+3 && k < n; k++) {
                dp[i] = Math.max(dp[i], suffixSum[i]-dp[k+1]);
            }
        }
        if (dp[0]*2 == suffixSum[0])
            return "Tie";
        else if (dp[0]*2 > suffixSum[0])
            return "Alice";
        else
            return "Bob";
    }
}