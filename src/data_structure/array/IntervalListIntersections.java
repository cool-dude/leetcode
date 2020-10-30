#LC#986: Interval List interactions
/*Algorithm
  If A[0] has the smallest endpoint, it can only intersect B[0].
  After, we can discard A[0] since it cannot intersect anything else.

  Similarly, if B[0] has the smallest endpoint, it can only
  intersect A[0], and we can discard B[0] after since it cannot intersect anything else.

  We use two pointers, i and j, to
  virtually manage "discarding" A[0] or B[0] repeatedly.
 */
class Soln{
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans=new ArrayList();
        int i=0,j=0;

        while (i<A.length && j<B.length){
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo=Math.max(A[i][0],B[j][0]);
            int hi=Math.min(A[i][1],B[j][1]);

            if(lo<=hi){
                ans.add(new int[]){lo,hi});
            }
            //Remove the smallest interval
            if(A[i][1]<B[j][1]){
                i++;
            }
            else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
//T:O(M+N).
//S:O(M+N).