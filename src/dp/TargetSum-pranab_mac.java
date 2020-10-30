package dp;
class Sln1{
    private int targetSumUtil(int[] nums, int T,int i,int sum){
        if(i==nums.length) {
            return sum == T ? 1 : 0;
        }
        //combine add/subtract
        return targetSumUtil(nums, T,i+1,sum+nums[i])+
                targetSumUtil(nums, T, i+1, sum-nums[i]);
    }
    public int targetSum(int[] nums,int T){
        return targetSumUtil(nums,T,i,sum);
    }
}
class Sln2{
    private int targetSumUtil(int[] nums, int T, int i,int sum,
                              Map<Integer, Map<Integer,Integer>> cache){
        if(i==nums.length){
            return sum==T?1:0;
        }
        //check cache return
        if(!cache.containsKey(i)) cache.put(i, new HashMap<Integer, Integer>());
        Integer cached=cache.get(i).get(sum);
        if(cached!=null) return cached;
        // didn't hit cache,
        // compute and store cache
        int toRet=targetSumUtil(nums, T,i+1,sum+nums[i], cache)+
                targetSumUtil(nums, T, i-1, sum-nums[i], cache);
        cache.get(i).put(sum, toRet);
        return toRet;
    }
    public int targetSum(int[] nums,int T){
        // Map: i -> sum -> val
        Map<Integer, Map<Integer,Integer>> cache=
                new HashMap<Integer, Map<Integer, Integer>>();
        return targetSumUtil(nums,T,0,0,cache);
    }
}
class Sln3 {
    public int targetSum(int[] nums, int T) {
        int sum = 0;
        // cache range -sum(nums) to
        // sum(nums), so offset everything
        for (int num : nums) sum += num;
        int[][] cache = new int[nums.length + 1][2 * sum + 1];
        if (sum == 0) return 0;
        // Initialize i=0, T=0
        cache[0][sum] = 1;
        // Iterate over previous update current
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                int prev = cache[i - 1][j];
                if (prev != 0) {
                    cache[i][j - nums[i - 1]] += prev;
                    cache[i][j + nums[i - 1]] += prev;
                }
            }
        }
        return cache[nums.length][sum + T];
    }
}