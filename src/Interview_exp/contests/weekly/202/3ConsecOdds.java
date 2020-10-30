class Sln{
    public boolean threeConsecutiveOdds(int[] arr) {
        int oddCnt=0;
        for(int a:arr){
            if(a%2==1) {
                oddCnt++;
                if (oddCnt >= 3)
                    return true;
            }
            else {
                oddCnt=0;
            }
        }
        return false;
    }
}