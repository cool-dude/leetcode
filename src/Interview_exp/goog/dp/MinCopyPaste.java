//Given number N, write
//algorithm to print
//character A exactly
//N times with minimum no
//of operations
//(either copy all or paste)
public class minCopyPasteDP{
    public int find(int num){
        int result=0;
        for(int i=2;i<num;i++){
            while(num%i==0){
                result +=i;
                num/=i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumCopyPasteDP m =
                new MinimumCopyPasteDP();
        int n = 50;
        System.out.println("Minimum Operations: " + m.find(n));
    }
}