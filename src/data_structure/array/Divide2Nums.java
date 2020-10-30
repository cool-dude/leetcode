class Solution {
    public int divide(int dividend, int divisor) {
        boolean positive = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
        if ((dividend == Integer.MAX_VALUE || dividend == Integer.MIN_VALUE) && Math.abs((long) divisor) <= 1) {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        long end = Math.abs((long) dividend);
        long sor = Math.abs((long) divisor);
        if (sor > end) return 0;
        else if (sor == end) return positive ? 1 : -1;
        long lo = 0, hi = end;
        while (lo <= hi) {
            long mid = ((hi - lo) >> 1) + lo;
            long y = sor * mid;
            if (y > end)
                hi = mid - 1;
            else if (y < end)
                lo = mid + 1;
            else
                return positive ? (int) mid : (int) -mid;
        }
        return positive ? (int) hi : (int) -hi;
    }
    public int divide(int dd, int dv){
        boolean pos=dd>0 && dv>0||dd<0 && dv<0;
        if((dd==Integer.MAX_VALUE||dd=Integer.MIN_VALUE) && Math.abs((long)dv)<=1){
            return pos?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        long end = Math.abs((long)dd);
        long sor = Math.abs((long)dv);
        if(sor>end) return 0;
        else if(sor==end) return pos?1:-1;
        long lo=0,hi=end;
        while (lo<=hi){
            long mi=((hi-lo)>>1)+lo;
            long y=sor*mi;
            if(y>end)
                hi=mi-1;
            else if(y<end)
                lo=mi+1;
            else
                return pos?(int)mi:(int)-mi;
        }
        return pos?(int)hi:(int)-hi;
    }
}