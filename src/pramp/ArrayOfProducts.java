package pramp;

import java.util.Arrays;

public class ArrayOfProducts {
    static int[] arrayOfArrayProducts(int[] arr) {
        if(arr==null || arr.length==0) return new int[]{};
        if(arr.length==1) return new int[]{};

        int[] left=new int[arr.length];
        left[0]=1;
        for(int i=1;i<arr.length;i++){
            left[i]=left[i-1]*arr[i-1];
        }

        int[] right=new int[arr.length];
        int len=arr.length;

        right[len-1]=1;

        for(int j=len-2;j>=0;j--){
            right[j]=right[j+1]*arr[j+1];
        }

        for(int k=0;k<len;k++){
            left[k]=left[k]*right[k];
        }
        return left;
    }

    public static void main(String[] args) {
        int[] in=new int[]{8, 10, 2};
        int[] res= arrayOfArrayProducts(in);
        Arrays.stream(res).forEach(val->System.out.println(val));
    }
}

public class Soln{
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return new int[]{};
        if (n == 1) return new int[]{};

        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            right[i] = right[i] * left[i];
        }
        return right;
    }
}
