import java.util.*;
import java.lang.*;
import java.io.*;
class Soln {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=Integer.parseInt(sc.nextLine());
        for(int i=0;i<t;i++){
            Scanner s=new Scanner(sc.nextLine());
            int n,k;
            k=s.nextInt();
            n=s.nextInt();
            //System.out.println(n+" "+k);
            Scanner st = new Scanner(sc.nextLine());
            //System.out.println("Array: "+s.toString());
            int[] ip = new int[n];

            for (int j = 0; j < n; j++) {
                if (st.hasNextInt()){
                    ip[j] = st.nextInt();
                    //System.out.print(ip[j]+" ");
                }
            }
            //System.out.println(" ");
            PriorityQueue<Integer> pq =
                    new PriorityQueue<Integer>();
            for(int l=0;l<k;l++){
                pq.offer(ip[l]);
                if(l<k-1)
                    System.out.print("-1 ");
            }
            for(int l=k-1;l<n;l++){
                if(ip[l] > pq.peek()){
                    pq.poll();
                    pq.offer(ip[l]);
                }
                System.out.print(pq.peek()+" ");
            }
            System.out.println("");
        }
    }
}