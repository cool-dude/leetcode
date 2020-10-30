/*LC930: Binary Subarrays With Sum
https://leetcode.com/problems/binary-subarrays-with-sum/
In an array A of 0s and 1s, how many non-empty subarrays have sum S?
Example 1:
Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation:
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Note:
A.length <= 30000
0 <= S <= A.length
A[i] is either 0 or 1.*/
class Sln{
    int atMost(int[] A,int S){
        if(S<0) return 0;
        int res=0,i=0,n=A.length;
        for(int j=0;j<n;j++){
            S-=A[j];
            while (S<0)
                S+=A[i++];
            res+=j-i+1;
        }
        return res;
    }
    public int numSubarraysWithSum(int[] A,int S){
        return atMost(A,S)-atMost(A,S-1);
    }
    //T:O(n)
    //S:O(1).
}