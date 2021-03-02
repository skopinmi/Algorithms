package lesson5.homework;

import java.util.ArrayList;
import java.util.List;

//  задача с рюкзаками
public class Backpack {

    private final int maxWeight;
    private ArrayList<Item> listItems;
    private final ArrayList<ArrayList<Item>> allVariants = new ArrayList<>();

    public Backpack(int maxWeight, ArrayList<Item> listItems) {
        this.maxWeight = maxWeight;
        this.listItems = listItems;
    }

    public static void main(String[] args) {
        ArrayList<Item> arrayList = new ArrayList<>();
        arrayList.add(new Item("книга",1, 600));
        arrayList.add(new Item("бинокль",2, 5000));
        arrayList.add(new Item("аптечка",4, 1500));
        arrayList.add(new Item("ноутбук",2, 40000));
        arrayList.add(new Item("кошелек",1, 500));
        Backpack backpack = new Backpack(5, arrayList);
        ArrayList<Item> result = backpack.getBestComposition();

        for (Item item : backpack.getBestComposition()) {
            System.out.println(item.toString());
        }

//        for (ArrayList<Item> list: backpack.allVariants) {
//            System.out.println("----");
//            for (Item it: list) {
//                System.out.println(it.toString());
//            }
//        }

    }



    public ArrayList<Item> getBestComposition () {
        ArrayList<Item> result = new ArrayList<>();
        processComposition(listItems.size());
        int maxTotalPrice = 0;
        for (ArrayList<Item> listItems: allVariants) {
            int totalPriceItem = 0;
            for (Item item: listItems) {
                totalPriceItem += item.price;
            }
            if (totalPriceItem > maxTotalPrice) {
                result = listItems;
                maxTotalPrice = totalPriceItem;
            }
        }
        return result;
    }

    private void processComposition (int size) {
        if (size <= 1) {
            return;
        }
        for (int i = 0; i < size; i++) {
            processComposition(size - 1);
            addToVariants();
            rotate(size);
        }
    }

// добавть в список вариантов только набор с допустимым весом

    private void addToVariants (){
        ArrayList<Item> items = new ArrayList<>();
        int totalWeight = 0;
        for (Item item: listItems) {
            totalWeight += item.weight;
            if (!overLoad(totalWeight)) {
                items.add(item);
            } else {
                break;
            }
        }
        allVariants.add(items);
    }

    private void rotate(int size) {
        int pos = listItems.size() - size;
        Item temp = listItems.get(pos);
        for (int i = pos + 1; i < listItems.size(); i++) {
            listItems.set(i - 1, listItems.get(i));
        }
        listItems.set(listItems.size() - 1, temp);
    }

// перегруз

    private boolean overLoad (int weight) {
        return weight > maxWeight;
    }
}

class Item {
    String name;
    int weight;
    int price;

    public Item(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}