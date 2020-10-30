/*1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
Given a rectangular cake with height h and width w,
and two arrays of integers horizontalCuts and
verticalCuts where horizontalCuts[i] is the distance
from the top of the rectangular cake to the ith
horizontal cut and similarly, verticalCuts[j]
is the distance from the left of the rectangular
cake to the jth vertical cut.

Return the maximum area of a piece of cake after
you cut at each horizontal and vertical position
provided in the arrays horizontalCuts and verticalCuts.
Since the answer can be a huge number, return
this modulo 10^9 + 7.

Example 1:
Input: h = 5, w = 4, horizontalCuts = [1,2,4],
verticalCuts = [1,3]
Output: 4
Explanation: The figure above represents the given
rectangular cake. Red lines are the horizontal
and vertical cuts. After you cut the cake, the
green piece of cake has the maximum area.

Example 2:
Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.

Example 3:
Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9*/
class Solution {
public:
    const long long int mod = 1000000007;
    int maxArea(int hh, int ww, vector<int>& h, vector<int>& v) {
		// Sort
        sort(h.begin(), h.end());
        sort(v.begin(), v.end());
        vector<int> thickh = {h[0]}, thickv = {v[0]};
		// Horizontal
        int nh = h.size();
        for (int i=1; i<nh; i++) {
            thickh.push_back(h[i]-h[i-1]);
        }
        thickh.push_back(hh-h[nh-1]);
		//Vertical
        int nv = v.size();
        for (int i=1; i<nv; i++) {
            thickv.push_back(v[i]-v[i-1]);
        }
        thickv.push_back(ww-v[nv-1]);
		//Take max
        long long int a = *max_element(thickh.begin(), thickh.end());
        long long int b = *max_element(thickv.begin(), thickv.end());
        // return multiplication modulo.
        return (int)(a%mod*b%mod);
    }
};