package lesson4;

import java.util.*;
import java.util.function.Consumer;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected int size;
    protected Node<E> firstElement; //002[006 --> 005]

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement); //001[005] --> //002[006-->005]
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
//        firstElement = firstElement.next;

        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }

            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public void display() {
        System.out.println("----------");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.item);
            current = current.next;
        }
        System.out.println("----------");
    }

    @Override
    public E getFirst() {
        return firstElement != null ? firstElement.item : null;
//        return Optional.ofNullable(firstElement)
//                .map(node -> node.item)
//                .orElse(null);
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorLinkedList();
    }


    private class IteratorLinkedList implements Iterator<E> {

        private Node<E> thisNode;
        private int nextIndex;


        public IteratorLinkedList() {
            this.thisNode = firstElement;
        }

//      не доделал
        @Override
        public void remove() {
//            if (hasNext()) {
//                Node<E> temp =
//                thisNode.last.next = thisNode.next;
//                thisNode.next.last = thisNode.last;
//                thisNode = null;
//                size--;
//            }
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node<E> temp = thisNode;
            thisNode = thisNode.next;
            nextIndex++;
            return temp.item;
        }
    }
}
