package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenSortByID() {
        List<Item> actual = Arrays.asList(
                new Item(3, "item 3"),
                new Item(1, "item 1"),
                new Item(10, "item 10"),
                new Item(6, "item 6")
        );
       List<Item> expected = Arrays.asList(
               new Item(1, "item 1"),
               new Item(3, "item 3"),
               new Item(6, "item 6"),
               new Item(10, "item 10")
       );
       actual.sort(new SortItemByID());
       assertThat(actual, is(expected));
    }

    @Test
    public void whenReversSortByID() {
        List<Item> actual = Arrays.asList(
                new Item(3, "item 3"),
                new Item(1, "item 1"),
                new Item(10, "item 10"),
                new Item(6, "item 6")
        );
        List<Item> expected = Arrays.asList(
                new Item(10, "item 10"),
                new Item(6, "item 6"),
                new Item(3, "item 3"),
                new Item(1, "item 1")
        );
        actual.sort(new ReversSortItemByID());
        assertThat(actual, is(expected));
    }
}