/*Let there be a simple language like this:
expr ::= int | '(' op expr+ ')'
op ::= '+' | '*'
The task is to write a function int evaluate(String expression)
that evaluates a given expression. You can assume that
expression is valid for this given language.

Examples:
"3" = 3
"( + 1 2 )" = 3
"( + 3 4 5 )" = 12
"( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )" = 288*/
class Sln{
    public static void main(String[] args) {
        String s1 = "3" ;
        String s2 = "( + 1 2 )";
        String s3 = "( + 3 4 5 )";
        String s4 = "( + 7 ( * 8 12 )  (   * 2    ( + 9 4 ) 7 ) 3 )";
        System.out.println(getResult(s1));
        System.out.println(getResult(s2));
        System.out.println(getResult(s3));
        System.out.println(getResult(s4));
    }
    private static int getResult(String s) {
        Queue<String> q = new LinkedList<>();
        for(String str : s.split(" ")) {
            if(str.equals(""))
                continue;
            q.offer(str);
        }
        q.offer(" ");
        return helper(q);
    }
    private static int helper(Queue<String> q) {
        int prev = 0, num = 0, sum = 0;
        char op = '+';
        while(!q.isEmpty()) {
            String s = q.poll();
            char c = s.charAt(0);
            if((c >= '0' && c <= '9') || c == '(') {
                if(c >= '0' && c <= '9')
                    num = Integer.parseInt(s + "");
                else if(c == '(')
                    num = helper(q);
                switch (op) {
                    case '+':
                        sum += prev;
                        prev = num;
                        break;
                    case '-':
                        sum -= prev;
                        prev = -num;
                        break;
                    case '*':
                        prev *= num;
                        break;
                    case '/':
                        prev /= num;
                        break;
                }
            }
            else {
                if(c == ')')
                    break;
                op = c;
                if(op == '*' || op == '/')
                    prev = 1;
                num = 0;
            }
        }
        return prev + sum;
    }
}