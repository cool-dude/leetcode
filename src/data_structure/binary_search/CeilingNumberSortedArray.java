class Sln{
    private int findCeiling (int[] a, int start,
                             int end, int key){
        /*We do not return from the while loop
        start is less than end */
        while(start < end){
            int mid = start + (end - start) / 2;
            if(a[mid] < key){
                start = mid + 1;
            }
            else{
                end= mid;
            }
        }
        return start;
    }
}