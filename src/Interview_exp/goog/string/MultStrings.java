/*LC43: Multiply Strings
Given two non-negative integers num1 and num2 represented as strings,
return the product of num1 and num2, also represented as a string.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"*/
import java.math.BigInteger;
class Solution {
    public String multiply(String num1, String num2) {
        BigInteger n1= new BigInteger(num1);
        BigInteger n2= new BigInteger(num2);
        BigInteger n = n1.multiply(n2);
        return String.valueOf(n);
    }
}