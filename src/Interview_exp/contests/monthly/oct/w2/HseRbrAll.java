/*LC198: House Robber
https://leetcode.com/problems/house-robber/
You are a professional robber planning to
rob houses along a street. Each house has
a certain amount of money stashed, the only
constraint stopping you from robbing each
of them is that adjacent houses have security
system connected and it will automatically
contact the police if two adjacent houses
were broken into on the same night.
Given a list of non-negative integers
representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
Constraints:
0 <= nums.length <= 100
0 <= nums[i] <= 400
This particular problem and most of others can be approached using the following sequence:
Recursive (top-down)
Recursive + memo (top-down)
Iterative + memo (bottom-up)
Iterative + N variables (bottom-up)
Step 1. Figure out recursive relation.
A robber has 2 options:
a) rob current house i;
b) don't rob current house.
If an option "a" is selected it means
she can't rob previous i-1 house but
can safely proceed to the one before
previous i-2 and gets all cumulative
loot that follows.
If an option "b" is selected the robber
gets all the possible loot from robbery
of i-1 and all the following buildings.
So it boils down to calculating what is more profitable:

robbery of current house + loot from houses before the previous
loot from the previous house robbery and any loot captured before that
rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )

Step 2. Recursive (top-down)
Converting the recurrent relation from Step 1 shound't be very hard.*/
class Sln1{
    public int rob(int[] nums) {
        return helper(nums,nums.length-1);
    }
    int helper(int[] nums,int i){
        if(i<0)
            return 0;
        return Math.max(helper(nums,i-2)+nums[i],helper(nums,i-1));
    }
}
//top-down DP
class Sln2{
    public int rob(int[] nums){
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(nums,nums.length-1,dp);
    }
    int helper(int[] nums,int i,int[] dp){
        if(i<0)
            return 0;
        if(dp[i]>=0) return dp[i];
        dp[i]=Math.max(helper(nums,i-2,dp)+nums[i],helper(nums,i-1,dp));
        return dp[i];
    }
}
//bottom-up DP
class Sln3{
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i+1]=Math.max(dp[i],dp[i-1]+nums[i]);
        }
        return dp[nums.length];
    }
}
/*LC213: House Robber II
You are a professional robber planning to
* rob houses along a street. Each house has
* a certain amount of money stashed. All
* houses at this place are arranged in a circle.
* That means the first house is the neighbor of the last one.
* Meanwhile, adjacent houses have security system
* connected and it will automatically contact
* the police if two adjacent houses were broken into on the same night.
Example 1:
Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
because they are adjacent houses.
Example 2:
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.*/
class Sln4{
    int helper(int[] nums, int i, int j){
        if(i==j)
            return nums[i];
        int[] dp=new int[nums.length];
        dp[i] = nums[i];
        dp[i+1] = Math.max(nums[i+1], dp[i]);
        for(int k=i+2; k<=j; k++){
            dp[k] = Math.max(dp[k-1], dp[k-2]+nums[k]);
        }
        return dp[j];
    }
    public int rob(int[] nums){
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int max1=robUtil(nums, 0, nums.length-2);
        int max2=robUtil(nums, 1, nums.length-1);
        return Math.max(max1,max2);
    }
}
/*LC337: House Robber III
https://leetcode.com/problems/house-robber-iii/
The thief has found himself a new place for his
* thievery again. There is only one entrance to this area,
* called the "root." Besides the root, each house has one and
* only one parent house. After a tour, the smart thief realized
* that "all houses in this place forms a binary tree".
* It will automatically contact the police if two
* directly-linked houses were broken into on the same night.
Example 1:
Input: [3,2,3,null,3,null,1]

3
/ \
2   3
\   \
3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
Input: [3,4,5,1,3,null,1]

3
/ \
4   5
/ \   \
1   3   1
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
Accepted*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Sln{
    int[] robUtil(TreeNode root){
        if(root==null){
            return {0,0};
        }
        int[] result = new int[2];
        int[] l = robUtil(root.left);
        int[] r = robUtil(root.left);
        result[0] = root.val+ l[1]+r[1];
        result[1] = Math.max(l[0], l[1])+Math.max(r[0], r[1]);
        return result;
    }
    public int rob(TreeNode root){
        if(root==null)
            return 0;
        int[] result=robUtil(root);
        return Math.max(result[0], result[1]);
    }
    //T:O(N)
    //S:O(1)
}