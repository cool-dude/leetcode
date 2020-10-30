package goog;
class LargestConSubArraySum {
    public int maxSubArraySum(int[] in) {
        int max_so_far = 0;
        int max_end = 0;
        for (int i = 0; i < in.length; i++) {
            max_end = max_end + in[i];
            if (max_end < 0)
                max_end = 0;
            if (max_end > max_so_far)
                max_so_far = max_end;
        }
        return max_so_far;
    }
}