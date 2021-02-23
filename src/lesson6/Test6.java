package lesson6;

import java.util.TreeMap;

public class Test6 {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("s1", 23);
        treeMap.put("s2", 24);
        treeMap.put("s3", 25);
        treeMap.put("s1", 26);

//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        treeMap.put(23, 23);
//        treeMap.put(24, 24);
//        treeMap.put(25, 25);
//        treeMap.put(26, 26);

        System.out.println(treeMap);

        Tree<Integer> tree = new TreeImpl<>();
        tree.add(60);
        tree.add(50);
        tree.add(66);
        tree.add(40);
        tree.add(55);
        tree.add(70);
        tree.add(31);
        tree.add(45);
        tree.add(42);
        tree.add(43);
        tree.add(67);
        tree.add(81);

        System.out.println("Find 70: " + tree.contains(70));
        System.out.println("Find 700: " + tree.contains(700));

        tree.display();
        tree.remove(40);
        tree.display();

//        tree.traverse(Tree.TraverseMode.IN_ORDER);
//        tree.traverse(Tree.TraverseMode.PRE_ORDER);
//        tree.traverse(Tree.TraverseMode.POST_ORDER);

    }
}
