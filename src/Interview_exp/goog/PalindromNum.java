/*LC9: Palindrome Number
* https://leetcode.com/problems/palindrome-number/
Determine whether an integer is a palindrome.
* An integer is a palindrome when it reads
* the same backward as forward.
*
Input: 121
Output: true

Input: -121
Output: false
Explanation: From left to right,
* it reads -121. From right to left,
* it becomes 121-.
* Therefore it is not a palindrome.
Follow up:*/
class Sln{
    boolean isPalindrome(int x){
        if(x<0||(x%10==0 && x!=0)){
            return false;
        }
        int reverted=0;
        while (x>reverted){
            reverted=reverted*10+x%10;
            x/=10;
        }
        return (x==reverted||x==reverted/10);
    }
}