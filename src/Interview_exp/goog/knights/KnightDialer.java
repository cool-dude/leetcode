/*LC935:Knight Dialer
https://leetcode.com/problems/knight-dialer/
A chess knight can move as indicated in
the chess diagram below:
This time, we place our chess knight on any numbered
key of a phone pad (indicated above), and the
knight makes N-1 hops.  Each hop must be from
one key to another numbered key.
Each time it lands on a key (including the
initial placement of the knight), it presses the number of that key, pressing N digits total.
How many distinct numbers can you dial in this manner?
Since the answer may be large, output the answer modulo 10^9 + 7.*/
NEIGHBORS_MAP={
        0:(4,6),
    1:(6,8),
    2:(7,9),
    3:(4,8),
    4:(3,9,0),
    5:((),
    6:(1,7,0),
    7:(2,6),
    8:(1,3),
    9:(2,4)
}
class Sln {
    public int knightDialer(int N) {
        if(N==1) return 10;
        long mod = 1000000007;
        long[] pre = new long[10];  // to record previous result. It is needed because if we only use cur, the cur array itself is changed during calculation.
        long[] cur = new long[10];  // to record current result.
        Arrays.fill(pre,1);
        while(--N>0){
            cur[0]=(pre[4]+pre[6])%mod;
            cur[1]=(pre[6]+pre[8])%mod;
            cur[2]=(pre[7]+pre[9])%mod;
            cur[3]=(pre[4]+pre[8])%mod;
            cur[4]=(pre[3]+pre[9]+pre[0])%mod;
            //cur[5]=0;
            cur[6]=(pre[1]+pre[7]+pre[0])%mod;
            cur[7]=(pre[2]+pre[6])%mod;
            cur[8]=(pre[1]+pre[3])%mod;
            cur[9]=(pre[2]+pre[4])%mod;
            //pre = cur; //Wrong for it's address copy. 错误，这是地址拷贝了,导致出错
            for(int i=0; i<10; i++) pre[i]=cur[i];  //Right for it's value copy(deep copy).
        }
        long sum = 0;
        for(int i=0; i<10; i++){
            sum = (sum+cur[i])%mod;
        }
        return (int)sum;
    }
}