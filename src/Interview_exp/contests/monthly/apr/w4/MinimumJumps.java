/*LC55:Jump Game
Given an array of non-negative integers,
you are initially positioned at the first index of the array.

Each element in the array represents
your maximum jump length at that position.
Determine if you are able to reach the last index.

Example 1:
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1,
then 3 steps to the last index.

Example 2:
Input: [3,2,1,0,4]
Output: false*/
public class Sln {
    public boolean canJump(int[] a) {
        if (a.length <= 1)
            return true;
        int maxReach = 0;
        int steps = 1;
        for (int i = 0; i < a.length; i++) {
            steps--;
            if (i + a[i] > maxReach) {
                maxReach = i + a[i];
                steps = a[i];
            }
            if (steps == 0 && i < a.length - 1)
                return false;
        }
        return true;
    }
}

/*
LC45: Jump Game II
Given an array of non-negative integers,
you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:
Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
class Sln2{
    public int jump(int[] nums) {
        int steps=0;
        int currentMax = 0;
        int nextMax = nums[0];
        for(int i=0;i<nums.length;i++) {
            if(i > currentMax) {
                steps++;
                currentMax = nextMax;
            }
            nextMax = Math.max(nextMax, i+nums[i]);
        }
        return steps;
    }

    public static int minJmpsDP(int[] a){
        int n=a.length;
        if(n==0||a[0]==0)
            return -1;
        int[] jumps=new int[n];
        jumps[0]=0;
        for(int i=1;i<n;i++){
            jumps[i]=-1;
            for(int j=0;j<i;j++){
                if(i<=j+a[j] && jumps[j]!=-1){
                    jumps[i]=Math.max(jumps[i],jumps[j]+1);
                    break;
                }
            }
        }
        return jumps[n-1];
    }
    //T:O(n)
}