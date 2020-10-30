/*
* Design a stack that supports push, pop, top,
* retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.*/
/*Leetcode MinStack*/
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

class MinStack1 {
    Stack<Integer> s;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        s=new Stack<Integer>();
        min=Integer.MAX_VALUE;
    }
    public void push(int x) {
        if(s.isEmpty()) {
            min = x;
            s.push(x);
            return;
        }
        //if new number less than original
        //min element
        if(x<min){
            s.push(2*x-min);
            min=x;
        }
        else
            s.push(x);
    }
    public void pop() {
        if(s.isEmpty()){
            System.out.println("Stack is empty ");
            return;
        }
        Integer top=s.peek();
        s.pop();
        if(top<min){
            min=2*min-top;
        }
    }
    public int top() {
        if(s.isEmpty()){
            System.out.println("Stack is empty ");
            return Integer.MAX_VALUE;
        }
        Integer top=s.peek();
        if(top<min){
            return min;
        }
        return top;
    }
    public int getMin() {
        return min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */