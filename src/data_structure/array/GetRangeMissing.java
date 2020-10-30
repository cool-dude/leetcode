problem: we present an API that collects elements of a range
        when we have presented N-1 elements, another API call returns the missing element
        ie.
        accept(-1)
        accept(2)
        accept(0)
        getMissing() —> 1
        Constraints: You determine the range and the missing element
        Any size range
        you have 0.5K of RAM

class Soln{
    static int min=Integer.MAX_VALUE;
    static int max=Integer.MIN_VALUE;
    static int sum=0;
    public void accept(int x){
        if(x<min){
            min=x;
        }
        if(x>max){
            max=x;
        }
        sum+=x;
    }
    public int getN(){
        return max-min+1;
    }
    public int getMissing(){
        int n=getN();
        int expectedSum= n*{min+(n-1) /2};
        return expectedSum-sum;
    }
}

2,3,4 = 9
        N = 4-2+1 = 3
        SUM = 2, 4 = 6
        expected =3*(2+(3-1)/2)
        =3*(2+1)
        =9
        (min, max, missing)
        (2,4,3)

        two use cases to test with
        (-2,1,0)
        (Integer.MIN_VALUE, Integer.MAX_VALUE, 1000);
        (0, 5000, 455)