package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class trackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        tracker tracker = new tracker();
        item item = new item();
        item.setName("test1");
        tracker.add(item);
        ru.job4j.tracker.item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
}