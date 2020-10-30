package dp;
import java.util.Arrays;
/***https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 *Let us discuss LongestTurbulentSubarray Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming.
 * The LongestTurbulentSubarray Increasing Sub-sequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * longest-increasing-sub-sequence
 *
 * More Examples:
 *
 * Input  : arr[] = {3, 10, 2, 1, 20}
 * Output : Length of LIS = 3
 * The longest increasing sub-sequence is 3, 10, 20
 *
 * Input  : arr[] = {3, 2}
 * Output : Length of LIS = 1
 * The longest increasing sub-sequences are {3} and {2}
 *
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing sub-sequence is {3, 7, 40, 80}*/
class Sln1{
    int maxLIS(int[] nums,int end,int[] lis){
        for(int i=0;i<end;i++){
            if(nums[i]<nums[end] && lis[i]>lis[end])
                lis[end]=lis[i];
        }
        return lis[end];
    }
    int findLIS(int[] nums){
        if(nums==null||nums.length==0)
            return 0;
        int[] lis=new int[nums.length];
        lis[0]=1;
        for(int i=1;i<nums.length;i++){
            lis[i]=1+maxLIS(nums,i,lis);
        }
        return lis[nums.length-1];
    }
}

class Sln2{
    int maxLIS(int[] lis){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<lis.length;i++){
            if(lis[i]>max)
                max=lis[i];
        }
        return max;
    }
    int findLIS(int[] nums){
        if(nums==null||nums.length==0)
            return 0;
        int[] lis=new int[nums.length];
        lis[0]=1;
        for(int i=1;i<nums.length;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    lis[i]=Math.max(lis[j]+1,lis[i]);
            }
        }
        return maxLIS(lis);
    }
}