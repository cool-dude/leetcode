/*Given a set of n nuts of different sizes and n
bolts of different sizes. There is a one-one
mapping between nuts and bolts. Match nuts and
bolts efficiently.

Constraint: Comparison of a nut to another nut
or a bolt to another bolt is not allowed. It means
nut can only be compared with bolt and bolt can
only be compared with nut to see which one is
bigger/smaller.

Other way of asking this problem is, given a box
with locks and keys where one lock can be opened
by one key in the box. We need to match the pair.*/
class Sln{
    static void swap(char[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    static int partition(char[] arr,int lo,int hi,char pivot){
        int start=lo;
        for(int j=lo;j<hi;j++){
            if(isMatch(arr[j],pivot)<0){
                swap(arr,start,j);
                start++;
            }
            else if(!isMatch(arr[j],pivot)){
                swap(arr,j,hi);
                j--;
            }
        }
        swap(arr,start,hi);
        return start;
    }
    public static void matchPairs(char[] nuts,char[] bolts,int lo,int hi){
        if(lo<hi){
            int piv=partition(nuts,lo,hi,bolts[hi]);
            partition(bolts,lo,hi,nuts[piv]);

            matchPairs(nuts,bolts,lo,piv-1);
            matchPairs(nuts,bolts,piv+1,hi);
        }
    }
    //Driver method
    public static void main(String[] args) {
        // Nuts and bolts are represented as array of characters
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        // Method based on quick sort which matches nuts and bolts
        matchPairs(nuts, bolts, 0, 5);

        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts);
        printArray(bolts);
    }
    // Method to print the array
    private static void printArray(char[] arr) {
        for (char ch : arr){
            System.out.print(ch + " ");
        }
        System.out.print("n");
    }
}