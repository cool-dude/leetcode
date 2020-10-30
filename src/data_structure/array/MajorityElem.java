class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList();
        int maj=-1;
        int n=nums.length;
        int c = 0;

        for(int i = 0; i<nums.length; i++) {
            if(c == 0){
                maj = nums[i];
                c = 1;
            }
            else if(maj == nums[i]){
                c++;
                if(c >= Math.floor(n/3))
                    res.add(maj);
            }
            else{
                c--;
            }
        }
        return res;
    }
}