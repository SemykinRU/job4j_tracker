package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] leftArray = left.toCharArray();
        char[] rightArray = right.toCharArray();
        int count;
        Map<Character, Integer> maps = new HashMap<>();
        for (char value : leftArray) {
            count = maps.containsKey(value) ? maps.get(value) + 1 : 1;
            maps.put(value, count);
        }
        for (char value : rightArray) {
            if (!maps.containsKey(value)) {
                return false;
            }
            count = maps.get(value);
            if (count == 1) {
                maps.remove(value);
            } else if (count > 1) {
                maps.replace(value, count - 1);
            }
        }
        return maps.size() == 0;
    }
}
