/*LC223 : Rectangle Area
* https://leetcode.com/problems/rectangle-area/
Find the total area covered by
* 2 rectilinear rectangles in a 2D plane.
Each rectangle is defined by its
* bottom left corner and top right
* corner as shown in the figure.
* Ex:
Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45*/
class Sln{
    private int overlap(int[][] r1,int[][] r2){
        int w1 = Math.min(r1[1][0], r2[1][0]);
        int h1 = Math.min(r1[1][1], r2[1][1]);
        int w2 = Math.max(r1[0][0], r2[0][0]);
        int h2 = Math.max(r1[0][1], r2[0][1]);
        if (w1 > w2 && h1 > h2) return (w1 - w2) * (h1 - h2);
        return 0;
    }
    private int areaOf(int[][] r){
        int w=r[1][0]-r[0][0];
        int h=r[[1][1]-r[0][1];
        return w*h;
    }
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[][] r1 = {{A, B}, {C, D}};
        int[][] r2 = {{E, F}, {G, H}};
        int total=areaOf(r1)+areaOf(r2)-overlap(r1,r2);
    }
}