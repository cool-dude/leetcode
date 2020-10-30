/*LC1231. Divide Chocolate
https://leetcode.com/problems/divide-chocolate/
You have one chocolate bar that consists of some chunks.
Each chunk has its own sweetness given by the array sweetness.

You want to share the chocolate with your K friends
so you start cutting the chocolate bar into K+1
pieces using K cuts, each piece consists of some consecutive chunks.
Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.
Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
Example 1:
Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]

Example 2:
Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
Output: 1
Explanation: There is only one way to cut the bar into 9 pieces.

Example 3:
Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
Output: 5
Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
Constraints:
0 <= K < sweetness.length <= 10^4
1 <= sweetness[i] <= 10^5
We want to maximize the minimum sweetness.
Binary search the result between 1 and 10^9.

Don'e explain binary search too much again and again.
Please find more related explanation in More.
Also will explain it more in details on youtube lee215.*/
class Sln{
    public int maximizeSweetness(int[] A, int K) {
        int left=1,right=(int)1e9/(K+1);
        while (left<right){
            int mid=(left+right+1)/2;
            int cur=0,cuts=0;
            for(int a:A){
                if((cur+=a)>=mid){
                    cur=0;
                    if(++cuts>K) break;
                }
            }
            if(cuts>K)
                left=mid;
            else
                right=mid-1;
        }
        return left;
    }
}