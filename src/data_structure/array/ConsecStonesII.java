/*LC:1040 Moving Stones consecutive
https://leetcode.com/problems/moving-stones-until-consecutive-ii/
First, sort the position of stones in ascending order.

max:
Each time you can move the leftmost or rightmost,
        so the maximum
        value must come from
        either move the leftmost first or the rightmost first;

If you move the rightmost for the first time, the
        first step must be to move it to the left of stones[n-2],
        where n is the length of stones, and the leftmost position is stones[0],
Therefore, the moving distance is stones[n-2]-stones[0]-1-(n-3),
        which is the position inside the current interval,
        minus the number of stones already in the interior (there are 3 not in the interval,
        they are left and right ends of the interval and stones[n-1]),
        and the remaining empty position is the position where the stone can be moved.

For example: [1,3,5,7,12,65], there are 7 empty slots between 1 and 12,
        that is, move the right end first, and can move up to 7 times.

Similarly, if you move the leftmost end for the first time,
the first step must be to move it to the right of the stones[1],
        the rightmost end of which is stones[n-1],
Therefore the moving distance is stones[n-1]-stones[1]-1-(n-3);

For example: [1,3,5,7,12,65], there are 58 empty slots left between 3 and 65,
that is, the left end is moved first, and the maximum movement is 58 times.

The maximum value of the above two values ​​is the two number of steps that can be moved currently.

min:
idea comes from sliding window, continuously constructing an interval,
        this interval [i, j] will satisfy: the length of the interval
        should not be greater than the number of stones, that is,
        this interval can be filled with stones outside the interval
        (some stones can still be outside the interval) .

Then check if this interval is consecutive and there is only one leftmost
        or rightmost stone not in this consecutive interval, then this is the corner case, returning 2.

For example, [1, 2, 3, 4, 10], the interval [1, 2, 3, 4] is consecutive,
        but there is only one external stone, you need to put 1 to the position 6,
        then put 10 to position 5.

If it isn't the corner case mentioned above, then it is not necessary
        to check whether the stones positions in the interval is consecutive or not, that is,
        put the numbers other than the [i, j] interval into the [i, j] interval,
        and let them be consecutive, only need n - (j-i+1) step.

E.g:
Intervalis not consecutive inside:
[1,4,7,9,20,30], the current i is 0, j is 1, we need only 4 steps to make [7,9,20,30] and [1,4] consecutive.

Put 30 in the 6 position, [1,4,6,7,9,20];
Put 20 in the 5 position, [1,4,5,6,7,9];
Put 9 in the position of 3, [1, 3, 4, 5, 6, 7];
4 .Put 7 in the 2 position, [1, 2, 3, 4, 5, 6] and end.
Interval is consecutive inside:

[1,2,3,56,89], i is 0, j is 2, only 2 steps

Put 89 in the position of 5, [1, 2, 3, 5, 56];
Put 56 into the 4 position, [1, 2, 3, 4, 5], and end.*/
class Sln{
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n=stones.length;
        int hi=Math.max(stones[n-2]-stones[0]-1-(n-3),stones[n-1]-stones[1]-1-(n-3));
        int lo=n,i=0;
        for(int j=0;j<n;++j){
            while (stones[j]-stones[i]>=n) ++i;
            if(j-i==n-2 && stones[j]-stones[i]==n-2){
                lo = Math.min(lo, 2);
            }
            else {
                lo = Math.min(lo, n-(j-i+1));
            }
        }
        return new int[]{lo,hi};
    }
}








































class Sln{
    public int numMovesStonesII(int[] stones){
        Arrays.sort(stones);
        int n=stones.length;
        int hi=Math.max(stones[n-2]-stones[0]-1-(n-3),stones[n-1]-stones[1]-1-(n-3));
        int lo=n,i=0;
        for(int j=0;j<n;j++){
            while (stones[j]-stones[i]>=n) ++i;
            if(stones[j]-stones[i]==n-2 && j-i==n-2){
                lo=Math.min(lo,2);
            }
            else{
                lo=Math.min(lo, n-(j-i+1));
            }
        }
        return new int[]{lo,hi};
    }
}
