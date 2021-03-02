package lesson8;

import java.util.Iterator;
import java.util.LinkedList;

public class HashTableChainImpl <K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    private final LinkedList<Item<K, V>>[]data;
    private final int maxSize;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableChainImpl(int maxSize) {
        this.data = new LinkedList[maxSize];
        this.maxSize = maxSize;
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        if (size == maxSize) {
            System.out.println("HashTable is full");
            return false;
        }
        if (data[index] == null) {
            data[index] = new LinkedList<Item<K, V>>();
            data[index].add(new Item<>(key, value));
        } else {
            Item<K, V> newItem = new Item<>(key, value);
            data[index].remove(newItem);
            data[index].add(newItem);
        }
        size++;
        return true;
    }

    protected int getStep(K key) {
        return 1;
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        LinkedList<Item<K,V>> linkedList = data[index];
        if (linkedList == null) {
            return  null;
        }
        for (Item<K, V> item : linkedList) {
            if (key.equals(item.getKey())) {
                return item.getValue();
            }
        }
        return null;
    }

    private int indexOf(K key) {
        return hashFunc(key);
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }
        LinkedList<Item<K,V>> linkedList = data[index];
        if (linkedList == null) {
            return  null;
        }

        for (int i = 0; i < linkedList.size(); i++) {
            Item<K, V> tempItem = linkedList.get(i);
            if (key.equals(tempItem.getKey())) {
                linkedList.remove(i);
                size--;
                return tempItem.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                for (Item<K, V> item : data[i]) {
                    System.out.printf(item.toString());
                    System.out.println();
                }
            }
        }
        System.out.println("----------");
    }
}

