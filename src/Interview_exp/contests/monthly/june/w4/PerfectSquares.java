/*LC279: Perfect Squares
https://leetcode.com/problems/perfect-squares/
Given a positive integer n,
find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9*/
class Sln1{
    boolean isSquare(int n){
        int sqrt_n=(int)(Math.sqrt(n));
        return (sqrt_n*sqrt_n==n);
    }
    public int numSquares(int n){
        if(isSquare(n))
            return 1;
        // The result is 4 if and only if n can be written in the
        // form of 4^k*(8*m + 7). Please refer to
        // Legendre's three-square theorem.
        while ((n & 3) == 0) // n%4 == 0{
            n >>= 2;
        }
        if ((n & 7) == 7) // n%8 == 7{
            return 4;
        }
        // Check whether 2 is the result.
        int sqrt_n = (int)(Math.sqrt(n));
        for(int i = 1; i <= sqrt_n; i++) {
            if (isSquare(n - i*i))
            {
                return 2;
            }
        }
        return 3;
    }
}