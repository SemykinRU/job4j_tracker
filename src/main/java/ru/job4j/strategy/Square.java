package ru.job4j.strategy;

public class Square implements Shape{
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    "00000" + ln
                + "0   0" + ln
                + "00000" + ln;

    }
}
