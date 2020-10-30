/*LC1447: Simplified Fractions
https://leetcode.com/problems/simplified-fractions/
Given an integer n, return a list of all simplified
fractions between 0 and 1 (exclusive) such that the
denominator is less-than-or-equal-to n. The fractions can be in any order.

Example 1:
Input: n = 2
Output: ["1/2"]
Explanation: "1/2" is the only unique fraction with a denominator less-than-or-equal-to 2.

Example 2:
Input: n = 3
Output: ["1/2","1/3","2/3"]

Example 3:
Input: n = 4
Output: ["1/2","1/3","1/4","2/3","3/4"]
Explanation: "2/4" is not a simplified fraction because it can be simplified to "1/2"*/
class Sln{
    int gcd(int x,int y){
        return x==0?y:gcd(y%x,x);
    }
    public List<String> simplifiedFraction(int n){
        List<String> ans=new ArrayList<>();
        for(int den=2;den<=n;den++){
            for(int num=1;num<den;num++){
                if(gcd(num,den)==1){
                    ans.add(num+"/"+den);
                }
            }
        }
        return ans;
    }
}