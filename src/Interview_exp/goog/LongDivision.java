/*LC29: Divide Two Integers
Given two integers dividend and divisor,
divide two integers without using multiplication,
division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero,
which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
Example 1:
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.

Example 2:
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.*/
class Sln1 {
    public int divide(int dividend, int divisor){
        boolean pos = dividend>0 && divisor>0 || dividend<0 && divisor<0;
        if(dividend==Integer.MAX_VALUE||dividend==Integer.MIN_VALUE && Math.abs((long)divisor)<=1)
            return pos?Integer.MAX_VALUE:Integer.MIN_VALUE;
        long end=Math.abs((long)dividend);
        long div=Math.abs((long)divisor);
        if(div>end) return 0;
        else if(div==end) return pos?1:-1;
        long lo=0, hi=end;
        while (lo<=hi){
            long mid = ((hi-lo)>>1)+lo;
            long mult = div*mid;
            if(mult > end)
                hi = mid-1;
            else if(mult < end)
                lo = mid+1;
            else
                return pos ? (int)mid : (int)-mid;
        }
        return pos ? (int)hi : (int)-hi;
    }
}
class Sln2 {
    public Strig longDivision(int num,int divisor){
        String divd = num.toString();
        String ans="";
        int idx=0;
        char[] num = divd.toCharArray();
        int t=num[idx]-'0';

        while (t < divisor)
            t = t*10 + (num[++idx]-'0');
        ++idx;

        while (num.length>idx){
            ans += (t/divisor);
            t = (t%divisor)*10 + (num[idx++]-'0');
        }
        if(ans.length()==0)
            return "0";
        return ans;
    }
    //driver code
    public static void main(String[] args) {
        String number = "1248163264128256512";
        int divisor = 125;
        System.out.println(longDivision(number, divisor));
    }
}