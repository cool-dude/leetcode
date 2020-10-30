class Sln{
    boolean checkPowerOf10(long n){
        if(n==0) return false;
        while (n>1 && n%10==0){
            n/=10;
        }
        return n==1;
    }
    public static boolean isPowerOfTen(long number){
        long[] powersOfTen = new long[] {1, 10, 100, 1000, 10000,
                100000, 1000000, 10000000, 100000000, 1000000000,
                10000000000, 100000000000, 1000000000000, 10000000000000,
                100000000000000, 1000000000000000, 10000000000000000,
                100000000000000000, 1000000000000000000
        };
        return Arrays.binarySearch(powersOfTen, number) >= 0;
    }
}