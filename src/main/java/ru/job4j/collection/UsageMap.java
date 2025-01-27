package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("semykinru@yandex.ru", "Semykin Roman");
        map.put("semykinru@mail.ru", "Semykin Roman");
        map.put("semykinru@rambler.ru", "Semykin Roman");
        map.put("ivanovii@yandex.ru", "Ivanov Ivan");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
