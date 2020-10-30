/*You have given height array of array.
Generate the original array.
Input: [6,3,0,2,2,0,0]
Output : [ 1,5,7,3,2,6,4]
A[i] value in input array is the number
of greater element on right side.*/
class Sln {
    void originalArray(int greater[], int n) {
        List<Integer> lst=new ArrayList<>();
        for (int i = 0; i <= n; i++)
            lst.add(i);
        // Traverse the array element
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            // find the K-th (n-greater[i]-i)
            // smallest element in Include_Array
            int k = n - greater[i] - i;
            arr[i] = temp.get(k);

            // remove current k-th element
            // from Include array
            temp.remove(k);
        }
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    // Driver code
    public static void main(String[] args) {
        int Arr[] = { 6, 3, 2, 1, 0, 1, 0 };
        int n = Arr.length;
        originalArray(Arr, n);
    }
}