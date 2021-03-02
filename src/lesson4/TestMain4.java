package lesson4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestMain4 {

    public static void main(String[] args) {
//        testLinkedList();
        testForEach();
    }

    private static void testLinkedList() {
//        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertLast(5);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        linkedList.removeFirst();
        linkedList.remove(2);

        linkedList.display();
    }

    private static void testForEach() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

        System.out.println("----");

        Iterator<Integer> iterator = arrayList.iterator();
        Iterator<Integer> iterator1 = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }

        System.out.println("___");
        while (iterator1.hasNext()) {
            Integer value = iterator1.next();
            if(value < 3) {
                iterator1.remove();
            }
            System.out.println(value);
        }

        System.out.println("___");
        Iterator<Integer> iterator2 = arrayList.iterator();

        while (iterator2.hasNext()) {
            Integer value = iterator2.next();
            System.out.println(value);
        }
//        System.out.println("___");
//        while (iterator.hasNext()) {
//            Integer value = iterator.next();
//            System.out.println(value);
//        }

        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

        linkedList.display();
        System.out.println(linkedList.getFirst());

        for(Integer value: linkedList) {
            System.out.println(value + "!");
        }

        Iterator<Integer> integerIterator = linkedList.iterator();
        while (integerIterator.hasNext()) {
            Integer value = integerIterator.next();
            System.out.println(value);
        }
    }
}
