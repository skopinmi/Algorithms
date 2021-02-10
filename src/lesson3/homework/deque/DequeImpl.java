package lesson3.homework.deque;


import lesson3.queue.QueueImpl;

import java.util.Arrays;

public class DequeImpl<E> extends QueueImpl implements IDeque<E> {



    private static final int DEFAULT_HEAD = 0;
    private static final int DEFAULT_TAIL = -1;


    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        if (head == data.length - 1) {
            head = DEFAULT_HEAD;
        }

        E removedValue = (E) data[head];
        data[head++] = null;
        size--;
        return removedValue;
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        if (head == 0) {
            head = data.length;
        }

        data[--head] = value;
        size++;
        return true;
    }
    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        if (tail == -1) {
            tail = data.length - 1;
        }

        E removedValue = (E) data[tail];
        data[tail--] = null;
        size--;
        return removedValue;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "Deque{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", tail=" + tail +
                ", head=" + head +
                '}';
    }
}
