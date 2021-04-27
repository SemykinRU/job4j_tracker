package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tracker {
    private final Item[] Items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        Items[size++] = item;
        return item;
    }

    public Item[] findAll(){
        return Arrays.copyOf(this.Items,size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (Items[i].getName().equals(key))
                rsl[index++] = Items[i];
        }
        return Arrays.copyOf(rsl, index);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = Items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}