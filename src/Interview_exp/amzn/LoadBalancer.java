class Sln {
    static boolean solve(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        int l = 0, r = nums.length - 1, sumL = nums[l], sumR = nums[r];
        while (l < r) {
            if (sumL == sumR) {
                if (sumL == sum - sumL * 2 - nums[l + 1] - nums[r - 1] && r - l > 1)
                    return true;
                else {
                    l++;
                    r--;
                    sumL += nums[l];
                    sumR += nums[r];
                }
            }
            else if (sumL > sumR) {
                r--;
                sumR += nums[r];
            }
            else {
                l++;
                sumL += nums[l];
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 2, 2, 1, 1, 2}, nums2 = {1, 1, 1, 1, 1, 1};
        System.out.println(solve(nums1));
        System.out.println(solve(nums2));
    }
}