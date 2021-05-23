package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
            int i = 0;
            while (i < left.length() && i < right.length()) {
                rsl += Character.compare(left.charAt(i), right.charAt(i));
                if (rsl != 0) {
                    break;
                }
                i++;
            }
            if (rsl == 0) {
               rsl = Integer.compare(left.length(), right.length());
            }
        return rsl;
    }
}