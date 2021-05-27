package ru.job4j.collection;

import java.util.Comparator;

public class DepAscComp implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int i = 0;
        while (i < right.length() && i < left.length()) {
            if (right.charAt(i) == '/' || left.charAt(i) == '/') {
                break;
            }
            rsl += Character.compare(right.charAt(i), left.charAt(i));
            if (rsl != 0) {
                break;
            }
            i++;
        }
        return rsl;
    }
}
