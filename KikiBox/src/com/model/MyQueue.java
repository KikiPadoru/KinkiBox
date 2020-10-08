package com.model;

public class MyQueue<T> implements ListStackQueue<T>{
    MyList<T> list;

    public MyQueue(MyList<T> list){
        this.list = list;
    }

    public MyQueue(){}

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public void setList(MyList<T> list) {
        this.list = list;
    }
}