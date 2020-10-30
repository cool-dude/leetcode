/*LC75:Sort Colors
https://leetcode.com/problems/sort-colors
DNF sorting
Given an array with n objects colored red,
white or blue, sort them in-place so that
objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2
to represent the color red, white, and blue respectively.
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:
Could you come up with a one-pass algorithm using only constant space?*/
class Sln {
    public static void main(String[] args) {
        int[] input = new int[]{2, 0, 0, 1, 2, 1};
        int[] result=sort(input);
        Arrays.stream(result).forEach(out->System.out.println(out));
    }
    private static int[] sort(int[] arr) {
        int low=0;
        int mid = 0;
        int high = arr.length - 1;
        // one pass through the array swapping
        // the necessary elements in place
        while (mid <= high) {
            if (arr[mid] == 0) { swap(arr, low++, mid++); }
            else if (arr[mid] == 1) { mid++; }
            else if (arr[mid] == 2) { swap(arr, mid, high--); }
        }
        return arr;
    }
    private static void swap(int[] input, int start, int end) {
        int data=input[end];
        input[end]=input[start];
        input[start]=data;
    }
}