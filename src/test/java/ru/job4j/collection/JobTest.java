package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByName() {
        List<Job> actual = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 4),
                new Job("Add task", 0)
        );
        actual.sort(new SortJobByName());
        List<Job> expected = Arrays.asList(
                new Job("Add task", 0),
                new Job("Fix bug", 1),
                new Job("Impl task", 4)
        );
        assertThat(actual, is(expected));
    }

    @Test
    public void whenComparatorByPriority() {
        List<Job> actual = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 4),
                new Job("Add task", 0)
        );
        actual.sort(new SortJobByName());
        List<Job> expected = Arrays.asList(
                new Job("Add task", 0),
                new Job("Fix bug", 1),
                new Job("Impl task", 4)
        );
        assertThat(actual, is(expected));
    }

    @Test
    public void whenComparatorReversByName() {
        List<Job> actual = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 4),
                new Job("Add task", 0)
        );
        actual.sort(new JobDescByName());
        assertThat(actual.get(0), is(new Job("Impl task", 4)));
        assertThat(actual.get(2), is(new Job("Add task", 0)));
    }

    @Test
    public void whenComparatorReversByPriority() {
        List<Job> actual = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 4),
                new Job("Add task", 0),
                new Job("Any task", 5)
        );
        actual.sort(new JobDescByPriority());
        assertThat(actual.get(0), is(new Job("Any task", 5)));
        assertThat(actual.get(3), is(new Job("Add task", 0)));
    }

    @Test
    public void whenComboComparatorByPriorityPlusByName() {
        List<Job> actual = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 4),
                new Job("Add task", 0),
                new Job("Any task", 5),
                new Job("Impl task", 3),
                new Job("Fixed", 1)
        );
        actual.sort(new SortJobByPriority().thenComparing(new SortJobByName()));
        List<Job> expected = Arrays.asList(
                new Job("Add task", 0),
                new Job("Fix bug", 1),
                new Job("Fixed", 1),
                new Job("Impl task", 3),
                new Job("Impl task", 4),
                new Job("Any task", 5)
        );
        assertThat(actual, is(expected));
    }

    @Test
    public void whenComboComparatorByNamePlusByPriority() {
        List<Job> actual = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 4),
                new Job("Add task", 0),
                new Job("Any task", 5),
                new Job("Impl task", 3),
                new Job("Fixed", 1)
        );
        actual.sort(new SortJobByName().thenComparing(new SortJobByPriority()));
        List<Job> expected = Arrays.asList(
                new Job("Add task", 0),
                new Job("Any task", 5),
                new Job("Fix bug", 1),
                new Job("Fixed", 1),
                new Job("Impl task", 3),
                new Job("Impl task", 4)
        );
        assertThat(actual, is(expected));
    }

    @Test
    public void whenReversComboComparatorByPriorityPlusByName() {
        List<Job> actual = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 4),
                new Job("Add task", 0),
                new Job("Any task", 5),
                new Job("Impl task", 3),
                new Job("Fixed", 1)
        );
        actual.sort(new JobDescByPriority().thenComparing(new JobDescByName()));
        List<Job> expected = Arrays.asList(
                new Job("Any task", 5),
                new Job("Impl task", 4),
                new Job("Impl task", 3),
                new Job("Fixed", 1),
                new Job("Fix bug", 1),
                new Job("Add task", 0)
        );
        assertThat(actual, is(expected));
    }

    @Test
    public void whenReversComboComparatorByNamePlusByPriority() {
        List<Job> actual = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Impl task", 4),
                new Job("Add task", 0),
                new Job("Any task", 5),
                new Job("Impl task", 3),
                new Job("Fixed", 1)
        );
        actual.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        List<Job> expected = Arrays.asList(
                new Job("Impl task", 4),
                new Job("Impl task", 3),
                new Job("Fixed", 1),
                new Job("Fix bug", 1),
                new Job("Any task", 5),
                new Job("Add task", 0)
        );
        assertThat(actual, is(expected));
    }

}