package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> comDescSize = (left, right) -> {
            System.out.println("Строка с размером "
                    + right.length()
                    + " меняется со стройкой с размером "
                    + left.length());
            return right.length() - left.length();
        };
    }
}
