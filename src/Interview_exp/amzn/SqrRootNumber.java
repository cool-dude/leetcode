/*Given a number N, the task is to
find the square root of N without using sqrt() function.

Examples:
Input: N = 25
Output: 5

Input: N = 3
Output: 1.73205

Input: N = 2.5
Output: 1.58114*/
class Sln{
    double helper(double n,double i,double j){
        double mi=i+(j-i)/2;
        double mul=mi*mi;
        if(mul==n||Math.abs(mul-n)<0.00001)
            return mi;
        else  if(mul<n)
            return helper(n,mi,j);
        else return helper(n,i,mi);
    }
    void findSqrt(double n){
        double i=1;
        boolean found=false;
        while (!found){
            if(i*i==n){
                System.out.println(i);
                found=true;
            }
            else if(i*i>n){
                double res=helper(n,i-1,i);
                System.out.printf(res+"\n");
                found=true;
            }
            i++;
        }
    }
}