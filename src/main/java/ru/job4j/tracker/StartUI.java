package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item("number 1"));
        tracker.add(new Item("Report 1"));
        tracker.add(new Item("Report 2"));
        tracker.add(new Item("Report 3"));
        tracker.add(new Item("Report 1"));
        tracker.add(new Item("Report 3"));
        tracker.add(new Item("Report 1"));

        System.out.println(tracker.findById(1));
    }
}
