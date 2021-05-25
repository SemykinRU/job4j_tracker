package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class FreezeStrTest {

    @Test
    public void whenEq() {
        assertThat(FreezeStr.eq("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eq("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eq("heloo", "hello"), is(false));
    }

    @Test
    public void whenTrue() {
        assertThat(FreezeStr.eq("heloo111", "helo11o1"), is(true));
    }

    @Test
    public void whenFalse() {
        assertThat(FreezeStr.eq("heloo111", "helo11o1s"), is(false));
    }
}