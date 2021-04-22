package ru.job4j.tracker;

public class tracker {
    private final item[] items = new item[100];
    private int ids = 1;
    private int size = 0;

    public item add(item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public item findById(int id) {
        item rsl = null;
        for (int index = 0; index < size; index++) {
            item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}