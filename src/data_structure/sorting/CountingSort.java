class Sln{
    public void countingSort(int[] a,int k){
        int n=a.length;
        int count[k];
        for(int i=0;i<l;i++)
            count[i]=0;
        for(int i=0;i<n;i++)
            count[a[i]]++;
        for(i=1;i<=K;i++){
            count[i] +=count[i-1];
        }
        for(j=0;j<n;j++){
            b[j]=0;
        }
        for(i=0; i<n;i++){
            count[a[i]]--;
            b[count[a[i]]] = a[i];
        }
    }
    int main(){
        int a[]= {0,1,1,1,0,0,0,3,3,3,4,4};
        int n  =  sizeof(a)/sizeof(a[0]);
        count_sort(a,n,4);
    }
}