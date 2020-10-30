/*LC877: Stone Game
https://leetcode.com/problems/stone-game/
Alex and Lee play a game with piles of stones.
There are an even number of piles arranged in a row,
and each pile has a positive integer number of stones piles[i].
The objective of the game is to end with the most stones.
The total number of stones is odd, so there are no ties.
Alex and Lee take turns, with Alex starting first.  Each
turn, a player takes the entire pile of stones from either
the beginning or the end of the row.  This continues until
there are no more piles left, at which point the person
with the most stones wins.
Assuming Alex and Lee play optimally, return True if
and only if Alex wins the game.
Example 1:
Input: piles = [5,3,4,5]
Output: true
Explanation:
Alex starts first, and can only take the first 5 or the last 5.
Say he takes the first 5, so that the row becomes [3, 4, 5].
If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
EXPLANATION:
Approach 1: Just return true
Alex is first to pick pile.
piles.length is even, and this lead to an interesting fact:
Alex can always pick odd piles or always pick even piles!
For example,
If Alex wants to pick even indexed piles piles[0], piles[2], ....., piles[n-2],
he picks first piles[0], then Lee can pick either piles[1] or piles[n - 1].
Every turn, Alex can always pick even indexed piles and Lee can only pick odd indexed piles.
In the description, we know that sum(piles) is odd.
If sum(piles[even]) > sum(piles[odd]), Alex just picks all evens and wins.
If sum(piles[even]) < sum(piles[odd]), Alex just picks all odds and wins.
So, Alex always defeats Lee in this game. */
class Sln1 {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
/*Approach 2:
What if piles.length can be odd?
What if we want to know exactly the diffenerce of score?
Then we need to solve it with DP.
dp[i][j] means the biggest number of stones you
can get more than opponent picking piles in piles[i] ~ piles[j].
You can first pick piles[i] or piles[j].
If you pick piles[i], your result will be piles[i] - dp[i + 1][j]
If you pick piles[j], your result will be piles[j] - dp[i][j - 1]
So we get:
dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
We start from smaller subarray and then we use that to calculate
bigger subarray.
Note that take evens or take odds, it's just an easy strategy to win when the number of stones is even.
It's not the best solution!
I didn't find a tricky solution when the number of stones is odd (maybe there is). */
class Sln2 {
    public boolean stoneGame(int[] piles){
        int n=piles.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) dp[i][j] = piles[i];
        for(int d=1;d<n;d++)
            for(int i=0;i<n-d;i++)
                dp[i][i+d]=Math.max(piles[i]-dp[i+1][i+d],piles[i+d]-dp[i][i+d-1]);
        return dp[0][n-1]>0;
    }
}
class Sln3{
    public boolean stoneGame(int[] piles){
        int n=piles.length;
        int[] dp=Arrays.copyOf(piles,piles.length);
        for(int d=1;d<n;d++)
            for(int i=0;i<n-d;i++)
                dp[i]=Math.max(piles[i]-dp[i+1],piles[i+d]-dp[i]);
        return dp[0]>0;
    }
}
/*LC1140: Stone Game II
https://leetcode.com/problems/stone-game-ii/
Alex and Lee continue their games with piles of stones.
There are a number of piles arranged in a row, and each
pile has a positive integer number of stones piles[i].
The objective of the game is to end with the most stones.

The game continues until all the stones have been taken.
Assuming Alex and Lee play optimally, return the
maximum number of stones Alex can get.
Example 1:
Input: piles = [2,7,9,4,4]
Output: 10
Explanation:  If Alex takes one pile at the beginning,
 Lee takes two piles, then Alex takes 2 piles again.
 Alex can get 2 + 4 + 4 = 10 piles in total.
  If Alex takes two piles at the beginning,
  then Lee can take all three piles left.
  In this case, Alex get 2 + 7 = 9 piles in total.
  So we return 10 since it's larger.
Constraints:
1 <= piles.length <= 100
1 <= piles[i] <= 10 ^ 4*/
class Sln4{
    int[] sums;//the sum from piles[i] to the end
    int[][] hash;
    public int stoneGameII(int[] piles){
        if(piles==null||piles.length==0) return 0;
        int n=piles.length;
        sums=new int[n];
        sums[n-1]=piles[n-1];
        for(int i=n-2;i>=0;i--)
            sums[i]=sums[i+1]+piles[i];
        hash=new int[n][n];
        return helper(piles,0,1);
    }
    int helper(int[] a,int i,int M){
        if(i==a.length) return 0;
        if(2*M>=a.length-i)
            return sums[i];
        if(hash[i][M]!=0) return hash[i][M];
        int min=Integer.MAX_VALUE;
        for(int x=1;x<=2*M;x++)
            min=Math.min(min,helper(a,i+x, Math.max(M,x)));
        hash[i][M]=sums[i]-min;
        return hash[i][M];
    }
}
/*LC1406: Stone Game III
https://leetcode.com/problems/stone-game-iii/
Alice and Bob continue their games with piles of stones.
There are several stones arranged in a row, and each
stone has an associated value which is an integer
given in the array stoneValue.
Alice and Bob take turns, with Alice starting first.
On each player's turn, that player can take 1, 2 or
3 stones from the first remaining stones in the row.
The score of each player is the sum of values of the
 stones taken. The score of each player is 0 initially.
The objective of the game is to end with the highest score,
and the winner is the player with the highest score and
there could be a tie. The game continues until all the
stones have been taken.
Assume Alice and Bob play optimally.
Return "Alice" if Alice will win, "Bob" if Bob will win or
"Tie" if they end the game with the same score.
Example 1:
Input: values = [1,2,3,7]
Output: "Bob"
Explanation: Alice will always lose.
Her best move will be to take three piles and the score become 6. Now the score of Bob is 7 and Bob wins.

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
Explanation: Alice cannot win this game. She can end the game in a draw if she decided to choose all the first three piles, otherwise she will lose.

Example 4:
Input: values = [1,2,3,-1,-2,-3,7]
Output: "Alice"

Example 5:
Input: values = [-1,-2,-3]
Output: "Tie"

Constraints:
1 <= values.length <= 50000
-1000 <= values[i] <= 1000
Algorithm:
dp[i] means, if we ignore before A[i],
what's the highest score that Alex can win over the Bob？
There are three option for Alice to choose.
Take A[i], win take - dp[i+1]
Take A[i] + A[i+1], win take - dp[i+2]
Take A[i] + A[i+1] + A[i+2], win take - dp[i+3]
dp[i] equals the best outcome of these three solutions.
Complexity
T: O(n)
S: O(n)*/
class Sln5 {
    public String stoneGameIII(int[] A) {
        int n = A.length, dp[] = new int[n+1];
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = Integer.MIN_VALUE;
            for (int k = 0, take = 0; k < 3 && i + k < n; ++k) {
                take += A[i + k];
                dp[i] = Math.max(dp[i], take - dp[i + k + 1]);
            }
        }
        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
    //T:O(n)
    //S:O(n).
    public String stoneGameIII(int[] A) {
        int n = A.length, dp[] = new int[4];
        for (int i = n - 1; i >= 0; --i) {
            dp[i % 4] = Integer.MIN_VALUE;
            for (int k = 0, take = 0; k < 3 && i + k < n; ++k) {
                take += A[i + k];
                dp[i % 4] = Math.max(dp[i % 4], take - dp[(i + k + 1) % 4]);
            }
        }
        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
    //T:O(n).
    //S:O(1).
}
/*LC1510: Stone Game IV
https://leetcode.com/problems/stone-game-iv/
Alice and Bob take turns playing a game,
with Alice starting first.
Initially, there are n stones in a pile.
On each player's turn, that player makes a
move consisting of removing any non-zero
square number of stones in the pile.
Also, if a player cannot make a move,
he/she loses the game.
Given a positive integer n. Return True if
and only if Alice wins the game otherwise
return False, assuming both players play optimally.
Example 1:
Input: n = 1
Output: true
Explanation: Alice can remove 1 stone winning the game because Bob doesn't have any moves.

Example 2:
Input: n = 2
Output: false
Explanation: Alice can only remove 1 stone, after that Bob removes the last one winning the game (2 -> 1 -> 0).

Example 3:
Input: n = 4
Output: true
Explanation: n is already a perfect square, Alice can win with one move, removing 4 stones (4 -> 0).

Example 4:
Input: n = 7
Output: false
Explanation: Alice can't win the game if Bob plays optimally.
If Alice starts removing 4 stones, Bob will remove 1 stone then Alice should remove only 1 stone and finally Bob removes the last one (7 -> 3 -> 2 -> 1 -> 0).
If Alice starts removing 1 stone, Bob will remove 4 stones then Alice only can remove 1 stone and finally Bob removes the last one (7 -> 6 -> 2 -> 1 -> 0).

Example 5:
Input: n = 17
Output: false
dp[i] means the result for n = i.

if there is any k that dp[i - k * k] == false,
it means we can make the other lose the game,
so we can win the game an dp[i] = true.
Complexity
Time O(n^1.5)
Space O(N)*/
class Sln6{
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int k = 1; k * k <= i; ++k) {
                if (!dp[i - k * k]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
/*LC1563: Stone Game V
https://leetcode.com/problems/stone-game-v/
There are several stones arranged in a row,
and each stone has an associated value which
is an integer given in the array stoneValue.

In each round of the game, Alice divides the
row into two non-empty rows (i.e. left row and
right row), then Bob calculates the value of
each row which is the sum of the values of all
the stones in this row. Bob throws away the row
which has the maximum value, and Alice's score
increases by the value of the remaining row. If
the value of the two rows are equal, Bob lets Alice
decide which row will be thrown away. The next round
starts with the remaining row.
The game ends when there is only one stone remaining. Alice's is initially zero.
Return the maximum score that Alice can obtain.

Example 1:
Input: stoneValue = [6,2,3,4,5,5]
Output: 18
Explanation: In the first round, Alice divides the row to [6,2,3], [4,5,5]. The left row has the value 11 and the right row has value 14. Bob throws away the right row and Alice's score is now 11.
In the second round Alice divides the row to [6], [2,3]. This time Bob throws away the left row and Alice's score becomes 16 (11 + 5).
The last round Alice has only one choice to divide the row which is [2], [3]. Bob throws away the right row and Alice's score is now 18 (16 + 2). The game ends because only one stone is remaining in the row.
Example 2:
Input: stoneValue = [7,7,7,7,7,7,7]
Output: 28
Example 3:
Input: stoneValue = [4]
Output: 0*/
class Sln7{
    int helper(int[] stoneValue, int l, int r, int[] prefix, Integer[][] dp) {
        if (l == r) return 0;
        if (l + 1 == r) return Math.min(stoneValue[l], stoneValue[r]);
        if (dp[l][r] != null) return dp[l][r];
        int res = 0;
        // left: [l, i], right: [i + 1, r]
        for (int i = l; i < r; ++i) {
            int left = prefix[i + 1] - prefix[l];
            int right = prefix[r + 1] - prefix[i + 1];
            if (left > right) {  // go right
                res = Math.max(res, right + helper(stoneValue, i + 1, r, prefix, dp));
            }
            else if (left < right) {  // go left
                res = Math.max(res, left + helper(stoneValue, l, i, prefix, dp));
            }
            else {  // left == right: go whatever max
                res = Math.max(res, Math.max(helper(stoneValue, l, i, prefix, dp),
                        helper(stoneValue, i + 1, r, prefix, dp))
                        + left);
            }
        }
        return dp[l][r] = res;
    }
    public int stoneGameV(int[] stoneValue) {
        int N = stoneValue.length;
        // cache prefix
        int[] prefix = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        return helper(stoneValue, 0, N - 1, prefix, new Integer[N][N]);
    }
}