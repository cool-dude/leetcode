class Sln {
    public static void main(String[] args) {
        int[] nums1 = {7, 8, 8, 11, 9, 7, 5, 6};
        int[] nums2 = {5, 5, 5, 5, 5, 5, 5, 6, 6};
        System.out.println(getWeeklyPrice(nums1));
        System.out.println(getWeeklyPrice(nums2));
    }
    static List<Double> getWeeklyPrice(int[] nums) {
        List<Double> res = new ArrayList<>();
        int l = 0, sum = 0;
        for (int r = 0; r < nums.length; r++) {
            if (r - l == 7) {
                res.add(Math.round(sum / 7.0 * 100.0) / 100.0);
                sum -= nums[l++];
            }
            sum += nums[r];
        }
        res.add(Math.round(sum / 7.0 * 100.0) / 100.0);
        return res;
    }
}