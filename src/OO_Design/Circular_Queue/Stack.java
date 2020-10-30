package com.immutable;
public interface Stack<T>{
    public Stack<T> push(T t);
    public Stack<T> pop() throws Exceptio;
    public T peek() throws Exception;
    public boolean isEmpty();
}