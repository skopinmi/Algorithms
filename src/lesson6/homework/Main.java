package lesson6.homework;

import lesson6.Tree;
import lesson6.TreeImpl;


public class Main {

//    мой вариант реализации дает очень маленький процент сбаланисированные

    public static void main(String[] args) {
        int min = -100;
        int max = 100;
        int level = 5;
        boolean balance = false;

        for (int i = 0; i < 20; i++) {
            Tree<Integer> tree = generateTree(min, max, level);
            tree.display();
            balance = tree.isBalanced();
            System.out.println("Дерево № " + i + " сбалансированно " + balance);
        }

        // пока не соберет первое сбалансированное дерево

//        int count = 0;
//        do {
//            Tree<Integer> tree = generateTree(min, max, level);
//            tree.display();
//            balance = tree.isBalanced();
//            System.out.println("Дерево № " + count++ + " сбалансированно " + balance);
//        } while (!balance);
    }

    public static Tree generateTree (int min, int max, int level) {
        TreeImpl<Integer> result = new TreeImpl<>();
//        int size;
        do {
//            size = result.size();
            int numberForPutIn = max - (int) (Math.random() * (max - min));
            result.add(numberForPutIn);
        } while (result.getHeight() <= level);
//        } while (result.getLevel() <= level && size != result.size());
        return result;
    }
}
