package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StreamUsageTest {

    @Test
    public void whenIntArrayToList() {
        Integer[][] intArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        StreamUsage usage = new StreamUsage();
        assertThat(usage.intArrayToList(intArray), is(expected));
    }
}