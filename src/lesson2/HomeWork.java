package lesson2;

//        1. Создать массив большого размера (миллион элементов).
//        2. Написать методы удаления, добавления, поиска элемента массива.
//        3. Заполнить массив случайными числами.
//        4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.

import java.util.*;

public class HomeWork {
    public static void main(String[] args) {



        List<Array<Integer>> arrayList = new ArrayList<Array<Integer>>(3);
        int arraySize = 1000;
        int arrayCount = 3;
//      arrayCount одинаковых массивов в arrayList

        for (int i = 0; i < arrayCount; i++) {
            arrayList.add(new ArrayImpl<>());
        }


//        1. Создать массив большого размера (миллион элементов).
//        3. Заполнить массив случайными числами.

        long startTime = System.nanoTime();
        System.out.println("Start");
        System.out.println(String.format("Create 3 arrays size %s and put random numbers in array", arraySize));
        for (int i = 0; i < arraySize; i++) {
            int randomNumber = (int) (Math.random() * arraySize);
//        запись числа в каждый массив arrayList
            for (int j = 0; j < arrayCount; j++) {
                arrayList.get(j).add(randomNumber);
            }
        }
        System.out.println(String.format("It took %s nanoseconds", (System.nanoTime()-startTime)));


        System.out.println("Start test 1");
        System.out.println(String.format("Sort Bubble testArray size %s", arraySize));
        System.out.println(String.format("Before sort %s", arrayList.get(0)));
        startTime = System.nanoTime();
        arrayList.get(0).sortBubble();
        System.out.println(String.format("After sort %s", arrayList.get(0)));
        System.out.println(String.format("It took %s nanoseconds", (System.nanoTime()-startTime)));
        System.out.println(arrayList.get(1));


        System.out.println("Start test 2");
        System.out.println(String.format("Sort Select testArray size %s", arraySize));
        System.out.println(String.format("Before sort %s", arrayList.get(1)));
        startTime = System.nanoTime();
        arrayList.get(1).sortSelect();
        System.out.println(String.format("After sort %s", arrayList.get(1)));
        System.out.println(String.format("It took %s nanoseconds", (System.nanoTime()-startTime)));



        System.out.println("Start test 3");
        System.out.println(String.format("Sort Insert testArray size %s", arraySize));
        System.out.println(String.format("Before sort %s", arrayList.get(2)));
        startTime = System.nanoTime();
        arrayList.get(2).sortInsert();
        System.out.println(String.format("After sort %s", arrayList.get(2)));
        System.out.println(String.format("It took %s nanoseconds", (System.nanoTime()-startTime)));


    }

}
