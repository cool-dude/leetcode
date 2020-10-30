import java.util.Arrays;
class ArrayQuadruplet {
    /**unsorted array
     * random quadruplet
     * 0 1 2 3  4 5 7 9
     * i=0;
     * j=7
     * s = 20 .. s=11 j--  j=6 counter = 1
     * s = 20 .. s=4 j--  j=5 counter = 2
     * while(i<j){
     * }*/
    public List<List<Integer>> 4Sum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null|| nums.length<4)
            return result;
        Arrays.sort(nums);
        for (int i = 0; i < len - 4; i++) {
            for (int j = 0; j < len - 3; j++) {
                int r = s - (nums[i] + nums[j]);
                int low = j + 1;
                int high = len - 1;
                while (low < high) {
                    if(in[low]+in[high]<r)
                        low++;
                    else if(in[low]+in[high]<r)
                        high--;
                    else{
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[low]);
                        t.add(nums[high]);
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }
    public List<List<Integer>> 4Sum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null|| nums.length<4)
            return result;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                        k++;
                    }
                    else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                    }
                    else{
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        result.add(t);
                        k++;
                        l--;
                        while(k<l && nums[l]==nums[l+1] ){
                            l--;
                        }
                        while(k<l && nums[k]==nums[k-1]){
                            k++;
                        }
                    }
                }
            }
        }
        return result;
    }
    public List<List<Integer>> 4Sum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4)
            return result;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int k=j+1;
                int l=nums.length-1;
                while (k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                        k++;
                    }
                    else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                    }
                    else {
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        result.add(t);
                        k++;
                        l--;
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    }
                }
            }
        }
        return result;
    }
}