Method 1 (Use Bubble k times):
        1) Modify Bubble Sort to run the outer loop at most k times.
        2) Print the last k elements of the array obtained in step 1.
//T:O(nk).

        Method 2 (Use temporary array)
        K largest elements from a[0..n-1]
        1) Store the first k elements in a temporary array t[0..k-1].
        2) Find the smallest element in t[],
        let the smallest element be min.
        3) For each element x in a[k] to arr[n-1]
        If x is greater than the min then remove min from temp[] and insert x.
        4) Print final k elements of temp[]
//T: O((n-k)*k).
//If we want sorted output,O((n-k)*k + klogk)

        Method 3(Use Sorting):
        1) Sort the elements in
        descending order in O(nLogn)
        2) Print the first k numbers
        of the sorted array O(k).
// Java code for k largest elements in an array
        import java.util.Arrays;
        import java.util.Collections;
class GFG
{
    public static void kLargest(Integer[] arr, int k) {
        // Sort the given array arr in reverse order
        // This method doesn't work with primitive data
        // types. So, instead of int, Integer type
        // array will be used
        Arrays.sort(arr, Collections.reverseOrder());

        // Print the first kth largest elements
        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");
    }
    //T:O(n lgn)

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{1, 23, 12, 9,
                30, 2, 50};
        int k = 3;
        kLargest(arr,k);
    }
}
//T:O(nlgn).