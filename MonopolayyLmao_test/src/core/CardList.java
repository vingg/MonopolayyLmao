package core;

import java.util.*;

public class CardList implements interfaces.Queue {
    private int[] array;
    private int rear;
    private int front;
    private int N = 16;

    public CardList(int size) {//Creates array
        array = new int[size];
        rear = 0;
    }

    public void enqueue(int object) {
        //Checks if rear has looped around to front
        array[rear] = object;
        rear = (rear + 1) % N;
    }

    public Object dequeue() {
        //Checks if front has a value
        Object temp = array[front];
        array[front] = -1;
        front = (front + 1) % N;
        return temp;
    }

    public int front() {
        //Just needs to return 0th position in array
        return array[front];
    }

    public int size() {
        return (N + rear - front) % N;
    }

    public void fill() {
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Collections.shuffle(Arrays.asList(tempArr));
        for (int i = 0; i < 16; i++) {
            array[rear] = tempArr[i];
            rear = (rear + 1) % N;
        }
    }
}

