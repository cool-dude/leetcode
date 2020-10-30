class Solution {
    public int[] prevPermOpt1(int[] A) {
        int idx =-1;
        int min = Integer.MAX_VALUE;
        int n = A.length;
        int num = 0;
        // Calculate index to swap
        for (int i = n-1 ; i>=1;i--) {
            if (A[i] < min)
                min = A[i];
            if (min < A[i-1]) {
                num = A[i-1];
                idx = i;
                break;
            }
        }
        if (idx == -1)
            return A;
        int maxT = -1;
        int ixr = -1;
        // Pick max element with
        // index > swap-index &
        // swap it with element at swap-index
        for (int i = idx;i<n;i++) {
            if (A[i] > maxT && A[i] < num) {
                maxT  = A[i];
                ixr = i;
            }
        }
        int t = A[ixr];
        A[ixr] = A[idx-1];
        A[idx-1] = t;
        return A;
    }
}