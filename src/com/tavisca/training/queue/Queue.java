package com.tavisca.training.queue;

import java.util.ArrayList;
import java.util.List;

public class Queue<T>{
    List<T> queue = null;
    public static final int defaultCapacity = 8;
    private int capacity;
    private int size;

    public Queue(int capacity){
        queue = new ArrayList<>(capacity);
        this.capacity = capacity;
        size = 0;
    }
    public Queue() {
        this(defaultCapacity);
    }

    public boolean add(T item){
       if(size < capacity) {
           if(queue.add(item)){
               size++;
               return true;
           }else
               return false;
       } else
           throw new IndexOutOfBoundsException();
    }

    public boolean add(List<T> items){
        for (T item: items)
            add(item);
        return true;
    }

    public boolean add(T[] items){
        for (T item: items)
           add(item);
        return true;
    }

    public T remove(){
        if(capacity <= 0)
            throw new IndexOutOfBoundsException();

        T item = queue.remove(0);
        if(item != null){
            size--;
            return item;
        }else
            return null;
    }

    public int capacity() {
        return capacity;
    }
}
