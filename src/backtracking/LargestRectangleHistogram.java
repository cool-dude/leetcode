/*LC84: Largest Rectangle in Histogram
* https://leetcode.com/problems/largest-rectangle-in-histogram
Given n non-negative integers representing the
* histogram's bar height where the width of each
* bar is 1, find the area of largest rectangle in the histogram.
*
The largest rectangle is shown in the shaded area, which has area = 10 unit.
Example:
Input: [2,1,5,6,2,3]
Output: 10*/
//Largest rectangular Histogram
//heights={1,3,4,1,3}

//Largest rectangular Histogram
//heights={1,3,4,1,3}
class Sln{
    public int maxArea(int[] heights){
        if(heights.length==0) return 0;
        if(heights.length==1) return heights[0];
        int max=0;
        for(int i=0;i<heights.length-1;i++){
            int min=heights[i];
            for(int j=i+1;j<heights.length;j++){
                min=Math.min(min, heights[j]);
                max=Math.max(heights[j],Math.max(max, min*(j-i+1)));
                max=Math.max(max, heights[i]);
            }
        }
        return max;
    }
}