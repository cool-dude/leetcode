package program_creek;
//Self SOLN
class Sln {
    public String addBinary(String a,String b){
        if(a==null||a.length()==0)
            return b;
        if(b==null||b.length()==0)
            return a;
        int curA=a.length()-1;
        int curB=b.length()-1;
        int flag=0;
        StringBuilder sb=new StringBuilder();
        while (curA>=0||curB>=0){
            int charA=0;
            int charB=0;

            if(curA>=0){
                charA=a.charAt(curA)=='0'?0:1;
                curA--;
            }
            if(curB>=0){
                charB=b.charAt(curB)=='0'?0:1;
                curB--;
            }
            int sum=charA+charB+flag;
            if(sum==2){
                sb.append(String.valueOf(0));
                flag=1;
            }
            else{
                sb.append(String.valueOf(sum));
                flag=0;
            }
        }
        if(flag==1)
            sb.append("1");
        return sb.reverse().toString();
    }
    //T:O(max(M,N))
}
