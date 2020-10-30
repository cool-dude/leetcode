class Solution {
    public int[] plusOne(int[] digits) {
        int idx = digits.length - 1;
        boolean flag = true;

        while(idx > -1){
            int tmp = flag ? digits[idx] +  1 : digits[idx];
            if(tmp > 9){
                flag = true;
                tmp -= 10;
            }
            else{
                flag = false;
            }
            digits[idx] = tmp;
            idx--;
        }
        if(flag){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for(int i = 0; i < digits.length; i++){
                res[i+1] = digits[i];
            }
            return res;
        }
        else{
            return digits;
        }
    }
}




class Soln{
    public int[] plusOne(int[] digits){
        int idx = digits.length-1;
        boolean flag = true;

        while (idx >= 0){
            int tmp = flag ? digits[idx]+1:digits[idx];
            if(tmp == 10){
                flag = true;
                tmp = 0;
            }
            else {
                flag = false;
            }
            digits[idx]=tmp;
            idx--;
        }
        if(flag){
            int[] res=new int[digits.length+1];
            res[0]=1;
            for(int i=0;i<digits.length;i++){
                res[i]=digits[i];
            }
            return res;
        }
        else {
            return digits;
        }
    }
}