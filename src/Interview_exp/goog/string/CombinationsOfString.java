package strings;
import java.lang.StringBuilder;
/*ip="wxyz"
" op=w wx wxy wxyz wxz wy wyz wz x xy xyz xz y yz z"*/
class Sln {
    static String ip;
    static StringBuilder op=new StringBuilder();
    public static void main(String[] args){
        inputstring = "wxyz";
        combine(0);
    }
    private static void combine(int start) {
        for(int i=start;i<ip.length();i++){
            op.append(ip.charAt(i));
            System.out.println(op);
            if ( i < ip.length())
                combine( i + 1);
            op.setLength(op.length() - 1);
        }
    }
}