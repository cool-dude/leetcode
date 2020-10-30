class Sln{
    public double nthGP(double x,double y,int n){
        double r=y/x;
        double r=x*Math.pow(y/x,n-2);
        DecimalFormat df2 = new DecimalFormat("#.##");
        return df2.format(r);
    }
}