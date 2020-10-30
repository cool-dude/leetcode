/*LC739: Daily Temperatures
https://leetcode.com/problems/daily-temperatures/
Given a list of daily temperatures T,
return a list such that, for each day
in the input, tells you how many days
you would have to wait until a warmer temperature.
If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures
T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].*/
class Sln{
    public int[] dailyTemperatures(int[] T) {
        int[] stack = new int[T.length];
        int top=-1;
        int[] ret=new int[T.length];
        for(int i=0;i<T.length;i++){
            while (top>-1 && T[i]>T[stack[top]]){
                int idx=stack[top--];
                ret[idx]=i-idx;
            }
            stack[++top]=i;
        }
        return ret;
    }
    //T:O(n)
    //S:O(n).
}