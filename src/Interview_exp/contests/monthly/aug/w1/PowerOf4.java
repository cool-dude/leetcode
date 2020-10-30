/*LC342. Power of Four
https://leetcode.com/problems/power-of-four/
Given an integer (signed 32 bits),
write a function to check whether it is a power of 4.

Example 1:
Input: 16
Output: true

Example 2:
Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?*/
class Sln{
class Sln{
class Sln{
class Sln{
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }
}