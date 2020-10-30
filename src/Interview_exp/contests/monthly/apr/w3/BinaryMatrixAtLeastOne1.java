/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim=binaryMatrix.dimensions();
        if(dim==null||dim.size()==0)
            return -1;
        int i=dim.get(0)-1,j=dim.get(1)-1;
        while (i>=0 && j>=0){
            if(binaryMatrix.get(i,j)==0) i--;
            else j--;
        }
        return (j==c-1)?-1:j+1;
    }
}