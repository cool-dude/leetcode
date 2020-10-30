/*1411. Number of Ways to Paint N × 3 Grid
User Accepted:1702
User Tried:2092
Total Accepted:1831
Total Submissions:3192
Difficulty:Hard
You have a grid of size n x 3 and you want to
paint each cell of the grid with exactly one of
the three colours: Red, Yellow or Green while making
sure that no two adjacent cells have the same colour
(i.e no two cells that share vertical or horizontal
sides have the same colour).
Return the number of ways you can paint this grid.
As the answer may grow large, the answer must be computed modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 12*/
class Sln{
    public int numOfWays(int n) {
        long a121 = 6, a123 = 6, b121, b123, mod = (long)1e9 + 7;
        for (int i = 1; i < n; ++i) {
            b121 = a121 * 3 + a123 * 2;
            b123 = a121 * 2 + a123 * 2;
            a121 = b121 % mod;
            a123 = b123 % mod;
        }
        return (int)((a121 + a123) % mod);
    }
}