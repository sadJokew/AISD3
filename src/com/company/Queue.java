package com.company;

import java.util.Arrays;

class Queue {
    private Object[] queue;
    private int maxSize; // максимальное количество элементов в очереди
    private int nElem;  // текущее количество элементов в очереди
    private int front;
    private int rear;

    Queue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Object[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }

    int getMaxSize(){
        return maxSize;
    }

    Queue(Queue example){
        this.maxSize = example.maxSize;
        this.nElem = example.nElem;
        this.front = example.front;
        this.rear = example.rear;
        queue = new Object[this.maxSize];
        System.arraycopy(example.queue, 0, this.queue, 0, maxSize);
    }

    void insert(Object elem) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = elem;
        nElem++;
    }

    Object remove() {
        Object temp = queue[front++]; // получаем первый элемент из очереди

        if (front == maxSize) { // циклический перенос
            front = 0;
        }
        nElem--; // уменьшаем количество элементов в очереди
        return temp;

    }

    public Object top(){
        return queue[rear];
    }

    public boolean isFull() {
        return (nElem == maxSize - 1);
    }

    boolean isEmpty() {
        return (nElem == 0);
    }

    //delete this
    void print(){
        System.out.println(Arrays.toString(queue));
    }

}