class Fib{
    public int fib(int n){
        if(n<=1) return n;
        return fib(n-1)+fib(n-2);
    }
    //1st iter
    int fib_recursive(int n,int[][] cache){
        if(cache[n]>=0) return cache[n];
        cache[n]=fib_recursive(n-1,cache)+fib_recursive(n-2,cache);
        return cache[n];
    }
    public int fib(int n){
        if(n<2) return n;
        int[] cache=new int[n+1];
        Arrays.fill(cache, -1);
        cache[0]=0;
        cache[1]=1;
        return fib_recursive(n,cache);
    }

    //bottom up
    public int fib(int n) {
        if (n < 2) return n;
        // Create cache and initialize to -1
        int[] cache = new int[n+1];
        cache[0]=0;cache[1]=1;
        for(int i=2;i<=n;i++){
            cache[i]=cache[i-1]+cache[i-2];
        }
        return cache[n];
    }
}