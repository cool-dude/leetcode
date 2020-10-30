//modulo exponetiation
int modularExponentiation(int x,int n,int M){
    int result=1;
    while(n>0)
    {
        if(power % 2 ==1)
            result=(result * x)%M;
        x=(x*x)%M;
        n=n/2;
    }
    return result;
}

//Euclid's algorithm
int GCD(int A, int B) {
    if(B==0)
        return A;
    else
        return GCD(B, A % B);
}

//mod inverse
int modInverse(int A,int M)
{
    return modularExponentiation(A,M-2,M);
}