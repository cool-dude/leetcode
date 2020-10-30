/*
LC1416: Restore Array
https://leetcode.com/problems/restore-the-array/
A program supposed to print an array of integers.
The program forgot to print whitespaces and the array
is printed as a string of digits and all we know is
that all integers in the array were in the range
[1, k] and there are no leading zeros in the array.

Given the string s and the integer k.
There can be multiple ways to restore the array.

The number of ways could be very large so return it modulo 10^9 + 7
Example 1:
Input: s = "1000", k = 10000
Output: 1
Explanation: The only possible array is [1000]

Example 2:
Input: s = "1000", k = 10
Output: 0
Explanation: There cannot be an array that was printed this way and has all integer >= 1 and <= 10.

Example 3:
Input: s = "1317", k = 2000
Output: 8
Explanation: Possible arrays are [1317],[131,7],[13,17],[1,317],[13,1,7],[1,31,7],[1,3,17],[1,3,1,7]

Example 4:
Input: s = "2020", k = 30
Output: 1
Explanation: The only possible array is [20,20]. [2020] is invalid because 2020 > 30. [2,020] is ivalid because 020 contains leading zeros.

Example 5:
Input: s = "1234567890", k = 90
Output: 34*/
class Sln {
public:
    int numberOfArrays(string s, int k) {
        const int MOD=1e9+7;
        int n=s.size();
        int* f=(int*)malloc(sizeof(int)*(n+1));
        memset(f,0,sizeof(int)*(n+1));
        f[0]=1;
        for(int i=0;i<n;++i) if(s[i]!='0'){
            long long u=0;
            for(int j=i;j<n;++j)
            {
                u=u*10+s[j]-48;
                if(u>k) break;
                (f[j+1]+=f[i])%=MOD;
            }
        }
        int ans=f[n];
        free(f);
        return ans;
    }
};