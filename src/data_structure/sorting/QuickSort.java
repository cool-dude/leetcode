public class QuickSort {
    private void swap(int [] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private int partition(int [] a, int start, int end){
        int pivot = a[start];
        int i  = start;
        int j  = end;
        while(i < j){
            while(i <= end && a[i] <= pivot) i++;
            while(j >= start && a[j] > pivot) j--;

            if(i < j) {
                swap(a, i, j);
            }
        }
        swap(a, start, j);
        return j;
    }
    public void quickSort(int[] a, int start, int end){
        if(start < end){
            int p = partition(a, start, end);
            quickSort(a,start, p-1);
            quickSort(a, p+1, end);
        }
    }
}