class LeftRotArray{
    void leftRotate(int[] a,int d,int n){
        int gcd(int a,int b){
            if(b==0)
                return a;
            return gcd(b,a%b);
        }
        for(int i=0;i<gcd(d,n);i++){
            int t=a[i];
            int j=i;
            while (true){
                int k=j+d;
                if(k>=n)
                    k-=n;
                if(k==i)
                    break;
                a[j]=a[k];
                j=k;
            }
            a[j]=t;
        }
    }
}
//T:O(n)
//S:O(1).

class RightRotateArray{
    void reverseArray(int[] arr,int start,int end){
        while (start<end){
            int t=arr[start];
            arr[start]=arr[end];
            arr[end]=t;
            start++;
            end--;
        }
    }
    void rightRotate(int[] a,int d){
        int n=a.length;
        k%=n;
        reverseArray(a,0,n-1);
        reverseArray(a,0,d-1);
        reverseArray(a, d,n-1);
    }
}