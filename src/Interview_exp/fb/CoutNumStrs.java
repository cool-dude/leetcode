/*Given a length n, count the number of strings of
length n that can be made using ‘a’, ‘b’ and ‘c’
with at-most one ‘b’ and two ‘c’s allowed.*/
class Sln{
    int count_abc_rec(int n,int nb,int nc){
        if(nb<0 && nc<0)
            return 0;
        if(n==0)
            return 1;
        if(n==1)
            return 1+(nb>0?1:0)+(nc>0?1:0);
        if(nb==0 && nc==0)
            return 1;
        int res=count_abc(n-1, nb, nc);
        res += count_abc(n-1, nb-1, nc);
        res += count_abc(n-1, nb, nc-1);

        return res;
    }
}


class Sln2{
    int helper(int[][][] cache,int n,int nb,int nc){
        if(cache[n][nb][nc]!=-1){
            return cache[n][nb][nc];
        }
        int res=helper(cache, n-1, nb, nc);
        res += helper(cache, n-1, nb-1, nc);
        res += helper(cache, n-1, nb, nc-1);
    }
    int count_abc_iter(int n,int nb,int nc){
        if(nb<0 && nc<0)
            return 0;
        if(n==0)
            return 1;
        if(n==1)
            return 1+(nb>0?1:0)+(nc>0?1:0);
        if(nb==0 && nc==0)
            return 1;
        int[][][] cache=new int[n+1][2][3];
        for(int i=0;i<=n;i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    if (i == 0)
                        cache[i][j][k] = 1;
                    else if (i == 1) {
                        cache[i][j][k] = 1;
                        if (j != 0) {
                            cache[i][j][k] += 1;
                        }
                        if (k != 0) {
                            cache[i][j][k] += 1;
                        }
                    } else if (j == 0 && k == 0) {
                        cache[i][j][k] = 1;
                    }
                }
            }
        }
        return helper(cache,n,nb,nc);
    }
}