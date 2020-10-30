/*https://www.hackerrank.com/challenges/max-array-sum/problem
Given an array of integers, find the
subset of non-adjacent elements with
the maximum sum. Calculate the sum of that subset.
For example, given an array  we have the following possible subsets:
Subset      Sum
[-2, 3, 5]   6
[-2, 3]      1
[-2, -4]    -6
[-2, 5]      3
[1, -4]     -3
[1, 5]       6
[3, 5]       8
Our maximum subset sum is .*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
public class Solution {
    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int n=arr.length;
        if(n==0||arr==null) return 0;
        int[] dp=new int[n];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<n;i++)
            dp[i]=Math.max(Math.max(dp[i-2]+arr[i],dp[i-1]),Math.max(dp[i-2],arr[i]));
        return dp[n-1];
    }
}