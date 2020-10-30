package com.immutable;
public interface Queue<T>{
    public void enQueue(T t);
    public Queue<T> deQueue() throws Exception;
    public T head() throws Exception;
    public boolean isEmpty();
}