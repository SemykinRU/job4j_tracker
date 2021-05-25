package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        int count = 1;
        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();
        for (char value : leftArray) {
            if (leftMap.containsKey(value)) {
                count += leftMap.get(value);
                leftMap.replace(value, count);
                count = 1;
                continue;
            }
            leftMap.put(value, count);
        }

        for (char value : rightArray) {
            if (rightMap.containsKey(value)) {
                count += rightMap.get(value);
                rightMap.replace(value, count);
                count = 1;
                continue;
            }
            rightMap.put(value, count);
        }

        return leftMap.equals(rightMap);
    }
}
