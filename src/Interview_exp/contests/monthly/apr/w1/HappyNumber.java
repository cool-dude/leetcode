/*Write an algorithm to determine if a number is "happy".
A happy number is a number defined by the following process:
* Starting with any positive integer, replace the number
* by the sum of the squares of its digits, and repeat the
*  process until the number equals 1 (where it will stay),
* or it loops endlessly in a cycle which does not include 1.
* Those numbers for which this process ends in 1 are happy numbers.
* Example:
Input: 19
Output: true
Explanation:
19->82->68->100->1*/
class Sln{
    int helper(int n){
        int squareSum=0;
        while (n!=0){
            squareSum+=(n%10)*(n%10);
            n/=10;
        }
        return squareSum;
    }
    //Floyd Marshal's algo
    boolean isHappy(int n){
        int slow,fast;
        slow=fast=n;
        do{
            slow=helper(n);
            fast=helper(helper(n));
        }while (slow!=fast);
        return (slow==1);
    }
}