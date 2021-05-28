package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 6,
                3, 5, 10);
        List<Integer> sortEvenNumbers = number.stream()
                                            .filter(x -> x % 2 == 0)
                                            .collect(Collectors.toList());
        for (Integer item : sortEvenNumbers) {
            System.out.println(item);
        }
    }
}
