package pramp;

import java.util.Arrays;

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

class Soln{
    public List<Integer> pancakeSort(int[] a) {
        int n=a.length;
        List<Integer> list=new ArrayList<>();
        while(n>1){
            int index=get_max_index(a,n);
            flip(a,index);
            flip(a,n);
            list.add(index);
            list.add(n);
            n--;
        }
        return list;
    }

    public void flip(int a[],int n){
        int b[]=new int[n];
        for(int i=n-1;i>=0;i--){
            b[n-1-i]=a[i];
        }
        for(int i=0;i<n;i++)a[i]=b[i];
    }

    public int get_max_index(int a[],int n){
        int max=0,j=0;
        for(int i=0;i<n;i++){if(a[i]>max){max=a[i];j=i+1;}}
        return j;
    }
}

class Soln{
    private int get_max_idx(int[] arr,int n){
        int j, max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                j=i+1;
            }
        }
        return max;
    }

    private void flip(int[] arr,int n){
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