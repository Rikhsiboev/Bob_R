package OOP_design_interview_questions_solutionsv.HashMap;

import java.util.LinkedList;

class Item {
    int key;
    String value;

    public Item(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class HashMap {
    private int size;
    private LinkedList<Item>[] table;

    public HashMap(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            this.table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void set(int key, String value) {
        int hashIndex = hashFunction(key);
        for (Item item : table[hashIndex]) {
            if (item.key == key) {
                item.value = value;
                return;
            }
        }
        table[hashIndex].add(new Item(key, value));
    }

    public String get(int key) {
        int hashIndex = hashFunction(key);
        for (Item item : table[hashIndex]) {
            if (item.key == key) {
                return item.value;
            }
        }
        throw new IllegalArgumentException("Key not found");
    }

    public void remove(int key) {
        int hashIndex = hashFunction(key);
        for (Item item : table[hashIndex]) {
            if (item.key == key) {
                table[hashIndex].remove(item);
                return;
            }
        }
        throw new IllegalArgumentException("Key not found");
    }
}
