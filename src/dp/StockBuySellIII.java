class Sol{
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int h = prices.length-1;
        if(prices.length == 2){
            return (prices[h]-prices[h-1]>0?(prices[h]-prices[h-1]):0);
        }
        int[] ar = new int[prices.length];
        int[] pr = new int[prices.length];
        int max = Math.max(prices[h],prices[h-1]);
        pr[h-1] = prices[h]-prices[h-1]>0?(prices[h]-prices[h-1]):0;
        pr[h] = pr[h-1];
        for (int i=h-2;i>=0;i--) {
            pr[i] = Math.max(max-prices[i], pr[i+1]);
            max = Math.max(max, prices[i]);
        }
        ar[0] = Math.max(pr[0], pr[1]);
        int l = prices[0];
        for (int i = 1; i<h-1; i++) {
            ar[i] = Math.max(ar[i-1], prices[i]-l+pr[i+1]);
            l = Math.min(l, prices[i]);
        }
        ar[h-1] = Math.max(prices[h-1]-l, ar[h-2]);
        max = ar[0];
        for (int i = 1; i < ar.length-1; i++) {
            max = Math.max(ar[i],max);
        }
        return max;
    }
}