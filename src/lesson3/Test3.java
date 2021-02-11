package lesson3;

import lesson3.queue.IQueue;
import lesson3.queue.PriorityQueueImpl;
import lesson3.queue.QueueImpl;
import lesson3.stack.IStack;
import lesson3.stack.StackImpl;

public class Test3 {

    public static void main(String[] args) {
//        testStack();
        testQueue();
    }

    private static void testStack() {
        IStack<Integer> stack = new StackImpl<>(5);

        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6));

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());
        stack.display();

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    private static boolean addToStack(IStack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

    private static void testQueue() {
//        IQueue<Integer> queue = new QueueImpl<>(5);
        IQueue<Integer> queue = new PriorityQueueImpl<>(5);
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("Queue peek: " + queue.peekHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
