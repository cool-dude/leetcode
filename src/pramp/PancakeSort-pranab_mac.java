package pramp;
/*
* LC969: Pancake Sorting
Given an array A, we can perform a pancake flip:
* We choose some positive integer k <= A.length,
* then reverse the order of the first k elements
* of A.  We want to perform zero or more pancake
* flips (doing them one after another in succession)
*  to sort the array A.

Return the k-values corresponding to a sequence of
* pancake flips that sort A.  Any valid answer that
* sorts the array within 10 * A.length flips will
* be judged as correct.

* Example 1:
Input: [3,2,4,1]
Output: [4,2,4,3]
Explanation:
We perform 4 pancake flips, with k values 4, 2, 4, and 3.
Starting state: A = [3, 2, 4, 1]
After 1st flip (k=4): A = [1, 4, 2, 3]
After 2nd flip (k=2): A = [4, 1, 2, 3]
After 3rd flip (k=4): A = [3, 2, 1, 4]
After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
* Example 2:
Input: [1,2,3]
Output: []
Explanation: The input is already sorted,
* so there is no need to flip anything.
Note that other answers, such as [3, 3],
* would also be accepted.*/
public class PancakeSort {
    static int[] pancakeSort(int[] arr) {
        int i = arr.length;
        int len = arr.length;
        while (i >= 0) {
            int pos = max(arr, 0, len);
            flip(arr, pos);
            flip(arr, len - 1);
            len--;
            i--;
        }
        return arr;
    }
    public static void flip(int[] arr, int k) {
        int i = 0;
        int j = k;
        while (i < k) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;j--;
        }
    }
    public static int max(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        int maxPosition = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                maxPosition = i;
            }
        }
        return maxPosition;
    }
    public static void main(String[] args) {
        int[] result = pancakeSort(new int[]{1, 5, 4, 3, 2});
        Arrays.stream(result).forEach(val -> System.out.println(val));
    }
}


class Sln{
    int get_max_idx(int[] arr,int n){
        int maxPos=-1, max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                maxPos=i;
            }
        }
        return maxPos;
    }
    void flip(int[] arr,int n){
        for(int i=0;i<n/2;i++){
            int t=arr[i];
            arr[i]=arr[n-1-i];
            arr[n-1-i]=t;
        }
    }
    public List<Integer> pancakeSort(int[] arr){
        int n=arr.length;
        List<Integer> result=new ArrayList<>();
        while (n>1){
            int index=get_max_idx(arr, n);
            flip(arr, index);
            flip(arr, n);
            result.add(index);
            result.add(n);
            n--;
        }
    }
}