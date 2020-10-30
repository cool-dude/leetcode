/*Union and Intersection of 2 unsorted arrays
2 unsorted arrays that represent two sets
(elements in every array are distinct), find union and intersection of two arrays.

For example, if the input arrays are:
arr1[] = {7, 1, 5, 2, 3, 6}
arr2[] = {3, 8, 6, 20, 7}
Then your program should print Union as {1, 2, 3, 5, 6, 7, 8, 20}
and Intersection as {3, 6, 7}. Note that the elements
of union and intersection can be printed in any order.*/
class Sln1{
    void printUnion(int arr1[], int arr2[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++)
            hs.add(arr1[i]);
        for (int i = 0; i < arr2.length; i++)
            hs.add(arr2[i]);
        System.out.println(hs);
    }
    void printIntersection(int arr1[], int arr2[]) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> hs1 = new HashSet<>();

        for (int i = 0; i < arr1.length; i++)
            hs.add(arr1[i]);

        for (int i = 0; i < arr2.length; i++)
            if (hs.contains(arr2[i]))
                System.out.print(arr2[i] + " ");
    }
    public static void main(String[] args) {
        int arr1[] = {7, 1, 5, 2, 3, 6};
        int arr2[] = {3, 8, 6, 20, 7};

        System.out.println("Union of two arrays: ");
        printUnion(arr1, arr2);

        System.out.println("Intersection of two arrays: ");
        printIntersection(arr1, arr2);
    }
    //T:O(m+n).
    //S:O(m+n).
}
/*Union and Intersection of 2 sorted arrays
Given two sorted arrays, find their union and intersection.
Example:
Input : arr1[] = {1, 3, 4, 5, 7}
        arr2[] = {2, 3, 5, 6}
Output : Union : {1, 2, 3, 4, 5, 6, 7}
         Intersection : {3, 5}
Input : arr1[] = {2, 5, 6}
        arr2[] = {4, 6, 8, 10}
Output : Union : {2, 4, 5, 6, 8, 10}
         Intersection : {6}*/
class Sln2{
    void printUnion(int[] arr1,int[] arr2){
        int m=arr1[arr1.length-1];
        int n=arr2[arr2.length-1];
        int ans=0;
        if(m>n)
            ans=m;
        else
            ans=n;
        int[] table=new int[ans+1];
        print(arr1[0]);
        ++table[arr1[0]];
        for(int i=1;i<arr1.length;i++){
            if(arr1[i]!=arr[i-1]){
                print(arr1[i]+" ");
                ++table[arr1[i]];
            }
        }
        for(int j=0;j<arr2.length;j++){
            if(table[arr2[j]]==0){
                print(arr2[j]+" ");
                ++table[arr2[j]];
            }
        }
    }
    void printIntersection(int[] arr1,int[] arr2){
        int i=0,j=0;
        while (i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j])
                i++;
            else if(arr1[i]>arr2[j])
                j++;
            else {
                print(arr2[j]+" ");
                i++;j++;
            }
        }
    }
}