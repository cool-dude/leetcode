/*LC55:Jump Game
https://leetcode.com/problems/jump-game/
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
class Sln {
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
/*LC45: Jump Game II
https://leetcode.com/problems/jump-game-ii/
Given an array of non-negative integers,
you are initially positioned at
the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:
Input: [2,3,1,1,4]
Output: 2*/
class Sln2{
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
    //T:O(n).
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