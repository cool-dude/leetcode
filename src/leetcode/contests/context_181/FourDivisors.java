/*1390. Four Divisors
Given an integer array nums, return the
sum of divisors of the integers in
that array that have exactly four divisors.

If there is no such integer in the array,
return 0.

Example 1:
Input: nums = [21,4,7]
Output: 32
Explanation:
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.

Constraints:
1 <= nums.length <= 10^4
1 <= nums[i] <= 10^5*/
class Sln{
    public int sumFourDivisors(int[] nums){
        int sum=0;
        for(int num:nums){
            int sqrt=(int)Math.sqrt(num);
            if(sqrt*sqrt==num) continue;
            int tmp=num+1;
            int c=0;
            for(int i=2;i<=sqrt;i++){
                if(num%i==0){
                    c++;
                    if(c>1) break;
                    tmp+=(i+num/i);
                }
            }
            if(c==1) sum+=tmp;
        }
        return sum;
    }
}