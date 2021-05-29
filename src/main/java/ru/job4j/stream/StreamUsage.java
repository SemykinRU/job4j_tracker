package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 10),
                new Task("Task #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .filter(task -> task.spent > 30)
                .map(task -> task.name + " " + task.spent)
                .forEach(System.out::println);

        List<Integer> number = Arrays.asList(1, -2, 6,
                3, -5, 10);
        List<Integer> sortEvenNumbers = number.stream()
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        for (Integer item : sortEvenNumbers) {
            System.out.println(item);
        }
    }
}