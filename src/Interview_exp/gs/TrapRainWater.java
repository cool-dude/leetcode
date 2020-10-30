/*LC11. Container With Most Water
Given n non-negative integers a1, a2, ..., an , where each
* represents a point at coordinate (i, ai). n vertical lines a
* re drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
* Find two lines, which together with x-axis forms a container,
* such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
* In this case, the max area of water (blue section)
* the container can contain is 49.
Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49*/
/*
The widest container (using first and last line) is a good candidate,
because of its width. Its water level is the height of the
smaller one of first and last line.
All other containers are less wide and thus would need
a higher water level in order to hold more water.
The smaller one of first and last line doesn't support a higher water level and can thus be safely removed from further consideration.*/
class Sln1 {
    public int maxArea(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return max;
    }
    //T:O(N).
    //S:O(1).
}
/*
* LC42. Trapping Rain Water
* https://leetcode.com/problems/trapping-rain-water/submissions/
Given n non-negative integers representing an elevation
* map where the width of each bar is 1, compute
* how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
* In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6*/
class Sln2 {
    public int trap(int[] A){
        int a=0;
        int b=A.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b){
            leftmax=Math.max(leftmax,A[a]);
            rightmax=Math.max(rightmax,A[b]);
            if(leftmax<rightmax){
                max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max+=(rightmax-A[b]);
                b--;
            }
        }
        return max;
    }
}
/*LC84: Largest Rectangle in Histogram
* https://leetcode.com/problems/largest-rectangle-in-histogram/
Given n non-negative integers representing the
* histogram's bar height where the width of each
* bar is 1, find the area of largest rectangle in the histogram.

The largest rectangle is shown in the shaded area, which has area = 10 unit.
Example:
Input: [2,1,5,6,2,3]
Output: 10*/
class Sln3{
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