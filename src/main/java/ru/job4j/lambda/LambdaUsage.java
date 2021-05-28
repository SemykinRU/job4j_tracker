package ru.job4j.lambda;

import java.util.*;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] numbers = {
                "1. Task",
                "2. Task",
                "11. Task"
        };
        Comparator<String> numSrt = (left, right) -> {
            int first = Integer.valueOf(right.substring(0, right.indexOf(".")));
            int second = Integer.valueOf(left.substring(0, left.indexOf(".")));
            return first - second;
        };
        List<String> listNumbers = new ArrayList<>(Arrays.asList(numbers));
        listNumbers.sort(numSrt);
        for (String item : listNumbers) {
            System.out.println(item);
        }
    }
}
