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

The widest container (using first and last line) is a good candidate, because of its width. Its water level is the height of the smaller one of first and last line.
All other containers are less wide and thus would need a higher water level in order to hold more water.
The smaller one of first and last line doesn't support a higher water level and can thus be safely removed from further consideration.*/
public class Sln {
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