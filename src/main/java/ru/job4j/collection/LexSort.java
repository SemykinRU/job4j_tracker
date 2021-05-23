package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
       StringBuilder leftIntBuilder = new StringBuilder();
       StringBuilder rightIntBuilder = new StringBuilder();
        for (int i = 0; i < left.length(); i++) {
            if (!Character.isDigit(left.charAt(i))) {
                break;
            }
            leftIntBuilder.append(left.charAt(i));
        }

        for (int i = 0; i < right.length(); i++) {
            if (!Character.isDigit(right.charAt(i))) {
                break;
            }
            rightIntBuilder.append(right.charAt(i));
        }

        int leftInt = Integer.parseInt(leftIntBuilder.toString());
        int rightInt = Integer.parseInt(rightIntBuilder.toString());

        return Integer.compare(leftInt, rightInt);
    }
}