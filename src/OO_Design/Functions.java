import java.io.*;
import java.util.*;
/*Function signature query engine
* FunctionName (variable declarations)
* Func1(int, string, int)    int#string#int   Func1
                              int#string#int#int . Func1
* Func2(int, int, int)
* Func3(int, int, ...string) => (3,4) (3,4,"some string") (3,4,"some string", "name 2")
*
* Repository =>  Design an in memory store  where function signatures can be present.
*
* Query => Find me functions of this type (int, string, string) => null
* Query => Find me functions of this type (int, string, int) => Func1
add int , ...string
add int, string, string, string, ...string
query int, string, string, string
    int#string#string#string
    int#string#string#string#string?
    int#string#string#string?
    int#string#string?
    int#string?*/
class Sln {
    public static void main(String[] args) {
        Map<String,String> funMap=new HashMap<>();
        populate(funMap,"Func1(int,string,int)");
        populate(funMap,"Func2(int,string,string,string,...string)");
        populate(funMap,"Func3(int,string,string,string,...int)");
        populate(funMap,"Func4(int,string,string,string,...float)");
        System.out.println(query(funMap,"int,string,string,string"));
    }

    //<func name, arguments>
    public static void populate(Map<String,String> funMap, String fun) {
        if(fun==null||fun.length()==0) return;
        int start=fun.indexOf("(",0);
        int end=fun.lastIndexOf(")");
        String sub=fun.substring(start+1,end);
        String func=fun.substring(0,start);
        String[] args=sub.split(",");
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<args.length-1;i++){
            sb.append(args[i]);
            sb.append('#');
        }
        sb.append(args[args.length-1]);
        String key = sb.toString();
        System.out.println("Func populate key: "+key+" func: "+func);
        if(!funMap.containsKey(key)) funMap.put(key, func);
    }

    public static String query(Map<String,String> funMap,String q){
        String[] args=q.split(",");
        String last=args[args.length-1];
        int sameCnt=1;
        boolean same=false;
        StringBuilder prv=new StringBuilder("");
        for(int i=args.length-2;i>=0;i--){
            if(same==true && last.equals(args[i]))
                sameCnt++;
            else if(last.equals(args[i])){
                same=true;
                sameCnt++;
            }
            else{
                for(int j=0;j<=i;j++)
                    prv.append(args[i]);
                break;
            }
        }
        System.out.println("Same cnt:"+sameCnt);
        String k="";
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<args.length-1;i++){
            sb.append(args[i]);
            sb.append('#');
        }
        sb.append(args[args.length-1]);
        if(sameCnt==1){
            System.out.println("Func query key: "+sb.toString());
            return funMap.get(sb.toString());
        }
        else{
            List<String> opts=new ArrayList<>();
            opts.add(sb.toString());
            sb=new StringBuilder("");
            sb.append(prv.toString());
            String varargs="..."+last;
            for(int i=1;i<=sameCnt;i++)
                fillList(opts,prv,last,i,varargs,"#");
            for(String s:opts)
                if(funMap.containsKey(s))
                    return funMap.get(s);
        }
        return null;
    }

    static void fillList(List<String> opts,StringBuilder prv,String key,int c,String var,String delim) {
        if(c==0){
            opts.add(prv+delim+var);
        }
        else{
            StringBuilder res=new StringBuilder("");
            res.append(prv.toString());
            for(int i=1;i<=c;i++)
                res.append(delim+key);
            res.append(delim+var);
            opts.add(res.toString());
        }
    }
}