package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        if (!left.equals(right)) {
            int i = 0;
            while (i < left.length() && i < right.length()) {
                rsl += left.charAt(i) - right.charAt(i);
                if (rsl != 0) {
                    break;
                }
                i++;
            }
            if (rsl == 0) {
               rsl = left.length() > right.length() ? 1 : -1;
            }

        }
        return rsl;
    }
}