/*LC1465: Maximum Area of a Piece of Cake
https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
After Horizontal and Vertical Cuts
Given a rectangular cake with height h and
width w, and two arrays of integers horizontalCuts
and verticalCuts where horizontalCuts[i] is the
distance from the top of the rectangular cake
to the ith horizontal cut and similarly,
verticalCuts[j] is the distance from the left
of the rectangular cake to the jth vertical cut.

Return the maximum area of a piece of cake after
you cut at each horizontal and vertical position
provided in the arrays horizontalCuts and verticalCuts.
Since the answer can be a huge number, return this modulo 10^9 + 7.

Example 1:
Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4

Example 2:
Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6

Example 3:
Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9*/
class Sln {
    static int MOD=1000000007;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int max_h=Math.max(horizontalCuts[0],h-horizontalCuts[horizontalCuts.length-1]);
        int max_w=Math.max(verticalCuts[0],w-verticalCuts[verticalCuts.length-1]);
        for(int i=0;i<horizontalCuts.length;i++)
            max_h=Math.max(max_h,horizontalCuts[i+1]-horizontalCuts[i]);
        for(int i=0;i<verticalCuts.length-1;i++)
            max_w=Math.max(max_w,verticalCuts[i+1]-verticalCuts[i]);
        return (int)((long)max_h * max_w % 1000000007);
    }
    //T:O(hlgh)+O(vlgv)
    //S:O(1).
}