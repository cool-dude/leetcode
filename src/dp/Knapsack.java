package dp;
class Sln1 {
    //Knapsack build-up
    public class Item {
        int weight;
        int value;
    }
    // Naive brute force solution. Recursively
    // include/exclude each item to
    // try every possible combination
    public int knapsack(Item[] items, int W) {
        return knapsackUtil(items, W, 0);
    }
    // Overloaded recursive function
    private int knapsackUtil(Item[] items, int W, int i) {
        if (i == items.length) return 0;
        if (W - items[i].weight < 0) return knapsack(items, W, i + 1);
        return Math.max(
                knapsack(items, W - items[i].weight, i + 1) + items[i].value,
                knapsack(items, W, i + 1));
    }

    //top-down DP
    public int knapsack(Item[] items, int W) {
        Map<Integer, Map<Integer, Integer>> cache =
                new HashMap<Integer, Map<Integer, Integer>>();
        return knapsackUtil(items, W, 0, cache);
    }
    private int knapsackUtil(Item[] items, int W, int i,
                             Map<Integer, Map<Integer, Integer>> cache) {
        if (i == items.length) return 0;
        //check value in cache
        if (!cache.containeKey(i))
            cache.put(i, new HashMap<Integer, Integer>());
        Integer cached = cache.get(i).get(W);
        if (cache != null) return cached;
        //compute item
        int toReturn;
        if (W - items[i].weight < 0) {
            //skip heavy item
            toReturn = knapsackUtil(items, i + 1, W, cache);
        } else {
            toReturn =
                    Math.max(knapsackUtil(items, W - items[i], i + 1, cache) + items[i].value,
                            knapsackUtil(items, W, i + 1, cache));
        }
        cache.get(i).put(W, toReturn);
        return toReturn;
    }

    //bottom-up DP
    public int knapsack(Item[] items, int W){
        // Init cache
        int[][] cache =
                new int[items.length + 1][W + 1];
        for(int i=1;i<=items.length;i++){
            for(int j=0;j<=W;j++){
                if(items[i-1].weight > j) {
                    cache[i][j] = cache[i-1][j];
                }
                else {
                    cache[i][j] = Math.max(cache[i-1][j],
                            cache[i-1][j-items[i-1].weight]+items[i-1].value);
                }
            }
        }
        return cache[items.length][W];
    }

    //bottom-up 1D DP
    public int knapsack(Item[] items, int W){
        int[] cache = new int[W+1];
        for(Item i:items){
            int[] newCache=new int[W+1];
            for(int j=0;j<=W;j++){
                if (i.weight>j) newCache[j]=cache[j];
                else newCache[j] = Math.max(cache[j], cache[j-i.weight]+i.value);
            }
            cache=newCache;
        }
        return cache[W];
    }
}