package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DepAscCompTest {

    @Test
    public void whenGreater() {
        int rsl = new DepAscComp().compare(
                "K1",
                "K2");
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenLess() {
        int rsl = new DepAscComp().compare(
                "K2",
                "K1/SK2");
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenEquals() {
        int rsl = new DepAscComp().compare(
                "K2",
                "K2/SK1");
        assertThat(rsl, is(0));
    }
}