/*LC264: Ugly Number II
https://leetcode.com/problems/ugly-number-ii/
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers
whose prime factors only include 2, 3, 5.

Example:
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.
he idea of this solution is from this page:http://www.geeksforgeeks.org/ugly-numbers/

The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
because every number can only be divided by
 2, 3, 5, one way to look at the sequence
 is to split the sequence to three groups as below:

(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
We can find that every subsequence
is the ugly-sequence itself (1, 2, 3, 4, 5, …)
multiply 2, 3, 5.

Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.

Every step we choose the smallest one, and move one step after,including nums with same value.

Thanks for this author about this brilliant idea. Here is my java solution*/
class Sln{
    public int nthUglyNumber(int n){
        int[] ugly=new int[n];
        ugly[0]=1;
        int i2=0,i3=0,i5=0;
        int factor2=2,factor3=3,factor5=5;
        for(int i=1;i<n;i++){
            int min=Math.min(Math.min(factor2,factor3),factor5);
            ugly[i]=min;
            if(factor2==min)
                factor2=2*ugly[++i2];
            if(factor3==min)
                factor3=3*ugly[++i3];
            if(factor5==min)
                factor5==5*ugly[++i5];
        }
        return ugly[n-1];
    }
}