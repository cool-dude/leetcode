/*LC1167. Minimum Cost to Connect Sticks
* https://leetcode.com/problems/minimum-cost-to-connect-sticks/
You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into
* one stick by paying a cost of X + Y.  You perform this
* action until there is one stick remaining.

Return the minimum cost of connecting all the given
* sticks into one stick in this way.

Example 1:
Input: sticks = [2,4,3]
Output: 14
*
Example 2:
Input: sticks = [1,8,3,5]
Output: 30*/
package iview_exp.amzn;
import java.util.*;
class Sln{
    public int connectSticks(int[] sticks) {
            Queue<Integer> minHeap=new PriorityQueue<Integer>();
            for(int stick:sticks){
                minHeap.offer(stick);
            }
            int res=0;
            while (minHeap.size()>1){
                int s1=minHeap.poll();
                int s2=minHeap.poll();
                res+=s1+s2;
                minHeap.offer(s1+s2);
            }
            return res;
    }
}