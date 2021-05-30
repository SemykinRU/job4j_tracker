package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenNotHaveDuplicateAddress() {
        List<Profile> in = Arrays.asList(
                new Profile(new Address("Moscow", "Red Squarl", 1, 0)),
                new Profile(new Address("Leningrad", "Lenina", 1, 0)),
                new Profile(new Address("Moscow", "Red Squarl", 1, 10))
        );
        List<Address> expected = Arrays.asList(
                new Address("Leningrad", "Lenina", 1, 0),
                new Address("Moscow", "Red Squarl", 1, 0),
                new Address("Moscow", "Red Squarl", 1, 10)
        );
        Profiles rsl = new Profiles();
        assertThat(expected, is(rsl.collect(in)));
    }

    @Test
    public void whenNotHaveAddress() {
        List<Profile> in = new ArrayList<>();
        Profiles rsl = new Profiles();
        assertThat(new ArrayList<>(), is(rsl.collect(in)));
    }

    @Test
    public void whenHaveDuplicateAddress() {
        List<Profile> in = Arrays.asList(
                new Profile(new Address("Moscow", "Red Squarl", 1, 0)),
                new Profile(new Address("Leningrad", "Lenina", 1, 0)),
                new Profile(new Address("Moscow", "Red Squarl", 1, 0))
        );
        List<Address> expected = Arrays.asList(
                new Address("Leningrad", "Lenina", 1, 0),
                new Address("Moscow", "Red Squarl", 1, 0)
        );
        Profiles rsl = new Profiles();
        assertThat(expected, is(rsl.collect(in)));
    }
}