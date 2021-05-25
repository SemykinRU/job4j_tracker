package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> check = new HashSet<>();
        String[] origins = origin.replaceAll("\\p{P}", "").split(" ");
        String[] lines = line.replaceAll("\\p{P}", "").split(" ");
        Collections.addAll(check, origins);
        return check.containsAll(Arrays.asList(lines));
    }
}
