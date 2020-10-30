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
class Sln1 {
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
    public int jump(int[] nums) {
        int steps = 0;
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
    //T:O(n)
}
/*LC1306: Jump Game III
https://leetcode.com/problems/jump-game-iii/
Given an array of non-negative integers arr,
you are initially positioned at start index
of the array. When you are at index i, you can
jump to i + arr[i] or i - arr[i], check if
you can reach to any index with value 0.
Notice that you can not jump outside of the array at any time.
Example 1:
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3

Example 2:
Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3

Example 3:
Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
1 <= arr.length <= 5 * 10^4
0 <= arr[i] < arr.length
0 <= start < arr.length*/
class Sln3 {
    public boolean canReach(int[] arr, int start) {
        if(start>=0 && start<arr.length && arr[start]<arr.length){
            int jump=arr[start];
            arr[start]+=arr.length;
            return jump==0||canReach(arr,start+jump)||canReach(arr,start-jump);
        }
        return false;
    }
    //T:O(n)
    //S:O(n)
}
/*LC1345: Jump Game IV
https://leetcode.com/problems/jump-game-iv/
Given an array of integers arr, you are
initially positioned at the first index of the array.
In one step you can jump from index i to index:
i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.
Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

Example 2:
Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You don't need to jump.

Example 3:
Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.

Example 4:
Input: arr = [6,1,9]
Output: 2

Example 5:
Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
Output: 3*/
class Sln4{
    public int minJumps(int[] arr){
        int n=arr.length;
        Map<Integer,List<Integer>> indicesVal=new HashMap<>();
        for(int i=0;i<n;i++)
            indicesVal.computeIfAbsent(arr[i],x->new LinkedList<>()).add(i);
        boolean[] visited=new boolean[n];visited[0]=true;
        Queue<Integer> q=new LinkedList<>();q.offer(0);
        int step=0;
        while (!q.isEmpty()){
            for(int sz=q.size();sz>0;sz--){
                int i=q.poll();
                if(i==n-1) return step;//reached last index
                List<Integer> indices=indicesVal.get(arr[i]);
                indices.add(i-1);indices.add(i+1);
                for(int j:indices){
                    if(j>=0 && j<n && !visited[j]){
                        visited[j]=true;
                        q.offer(j);
                    }
                }
                indices.clear();
            }
            step++;
        }
        return 0;
    }
}
/*LC1340: Jump Game V
https://leetcode.com/problems/jump-game-v/
Given an array of integers arr and an
integer d. In one step you can jump from index i to index:

i + x where: i + x < arr.length and 0 < x <= d.
i - x where: i - x >= 0 and 0 < x <= d.
In addition, you can only jump from index i to index
j if arr[i] > arr[j] and arr[i] > arr[k] for all
indices k between i and j (More formally min(i, j) < k < max(i, j)).

You can choose any index of the array and start
jumping. Return the maximum number of indices you can visit.

Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
Output: 4
Explanation: You can start at index 10. You can jump 10 --> 8 --> 6 --> 7 as shown.
Note that if you start at index 6 you can only jump to index 7. You cannot jump to index 5 because 13 > 9. You cannot jump to index 4 because index 5 is between index 4 and 6 and 13 > 9.
Similarly You cannot jump from index 3 to index 2 or index 1.

Example 2:
Input: arr = [3,3,3,3,3], d = 3
Output: 1
Explanation: You can start at any index. You always cannot jump to any index.

Example 3:
Input: arr = [7,6,5,4,3,2,1], d = 1
Output: 7
Explanation: Start at index 0. You can visit all the indicies.

Example 4:
Input: arr = [7,1,7,1,7,1], d = 2
Output: 2

Example 5:
Input: arr = [66], d = 1
Output: 1
Constraints:
1 <= arr.length <= 1000
1 <= arr[i] <= 10^5
1 <= d <= arr.length*/
class Sln5{
    int dfs(int[] arr,int n,int d,int i,int[] dp){
        if(dp[i]!=0) return dp[i];
        int res=1;
        for(int j=i+1;j<=Math.min(i+d,n-1) && arr[j]<arr[i];j++)
            res=Math.max(res,1+dfs(arr,n,d,j,dp));
        for(int j=i-1;j>=Math.max(i-d,0) && arr[j]<arr[i];j--)
            res=Math.max(res,1+dfs(arr,n,d,j,dp));
        return dp[i]=res;
    }
    public int maxJumps(int[] arr,int d){
        int n=arr.length;
        int[] dp=new int[n];
        int res=1;
        for(int i=0;i<n;i++)
            res=Math.max(res,dfs(arr,n,d,i,dp));
        return res;
    }
}