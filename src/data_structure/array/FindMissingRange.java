/*LC163: Missing Ranges
* https://leetcode.com/problems/missing-ranges/
Given a sorted integer array nums, where the range of
* elements are in the inclusive range [lower, upper],
* return its missing ranges.
Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]*/
class Sln {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            long prev = i == 0 ? lower : nums[i - 1] + 1L;
            long current = i == nums.length ? upper : nums[i] - 1L;
            appendMissing(prev, current, result);
        }
        return result;
    }
    void appendMissing(long prev, long current, List<String> result) {
        long diff = current - prev;
        if (diff == 0) {
            result.add(String.valueOf(prev));
        }
        else if (diff >= 1) {
            result.add(prev + "->" + current);
        }
    }
    //T:O(n).
    //S:O(1).
}