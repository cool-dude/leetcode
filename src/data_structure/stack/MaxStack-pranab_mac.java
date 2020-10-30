package data_structure.stack;

import java.util.LinkedList;

public class MaxStack {
    static LinkedList list;
    static MaxData curMax;
    private static class MaxData{
        int data;
        MaxData prevMax;

        public MaxData(int data) {
            this.data = data;
        }

        public void setPrevMax(MaxData data){
            this.prevMax=data;
        }
    }

    public static void main(String[] args) {
        list = new LinkedList();
        push(1);
        push(2);
        push(3);

        System.out.println(pop());
        //System.out.println(pop());
        System.out.println(max());

        System.out.println(pop());
        //System.out.println(pop());
        System.out.println(max());

    }

    public static void push(int data) {
        list.push(data);
        if(curMax==null){
            curMax=new MaxData(data);
        }
        if(data>curMax.data){
            MaxData temp=curMax;
            curMax=new MaxData(data);
            curMax.prevMax=temp;
        }
    }

    public static int pop() {
        int pooped = (int) list.getFirst();
        if(pooped==curMax.data){
            curMax=curMax.prevMax;
        }
        list.removeFirst();
        return pooped;
    }

    public static int max() {
        return curMax.data;

    }
}

public class MaxStack{
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
    }

    public void push(int x){
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        if(x >= max){
            maxStack.push(x);
        }
        stack.push(x);
    }

    public int pop(){
        if(stack.peek()==maxStack.peek())
            maxStack.pop();
        return stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int peekMax(){
        return maxStack.peek();
    }

    public int popMax(){
        int max=peekMax();
        Stack<Integer> buf=new Stack();
        while (stack.top()!=max) buf.push(stack.pop());
        pop();
        while(!buf.isEmpty()) stack.push(buf.pop());
        return max;
    }
}
//T:O(N) for popMax();
//S:O(N).