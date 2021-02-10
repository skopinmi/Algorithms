package lesson3.homework;

import lesson3.homework.deque.DequeImpl;

public class testDeque {
    public static void main(String[] args) {
        DequeImpl<Integer> deque = new DequeImpl<>(5);
//        System.out.println(deque.insertRight(5));
//        System.out.println(deque.toString());
//        System.out.println(deque.insertRight(4));
//        System.out.println(deque.toString());
//        System.out.println(deque.insertRight(3));
        System.out.println(deque.toString());
        System.out.println(deque.insertLeft(2));
        System.out.println(deque.toString());
        System.out.println(deque.insertLeft(1));
        System.out.println(deque.toString());
        System.out.println(deque.insertLeft(4));
        System.out.println(deque.insertLeft(2));
        System.out.println(deque.toString());
        System.out.println(deque.insertLeft(1));
        System.out.println(deque.toString());
        System.out.println(deque.insertLeft(4));
        System.out.println(deque.removeRight());
        System.out.println(deque.toString());
        System.out.println(deque.insertLeft(2));
        System.out.println(deque.toString());
        System.out.println(deque.insertLeft(1));
        System.out.println(deque.toString());
        System.out.println(deque.insertLeft(4));
        System.out.println(deque.removeLeft());
        System.out.println(deque.toString());
        System.out.println(deque.insertRight(3));
        System.out.println(deque.toString());
        System.out.println(deque.insertLeft(2));
        System.out.println(deque.toString());
        System.out.println(deque.removeRight());
        System.out.println(deque.toString());
        System.out.println(deque.removeLeft());
        System.out.println(deque.toString());
        while (!deque.isEmpty()) {
            System.out.println(deque.removeRight());
        }
    }
}
