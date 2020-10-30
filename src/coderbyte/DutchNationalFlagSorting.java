package coderbyte;
import java.util.Arrays;
public class DutchNationalFlagSorting {
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
            else if (arr[mid] == 2) { swap(arr, mid, high--); }
            else if (arr[mid] == 1) { mid++; }
        }
        return arr;
    }
    private static void swap(int[] input, int start, int end) {
        int data=input[end];
        input[end]=input[start];
        input[start]=data;
    }
}