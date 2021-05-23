package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус начинает движение.");
    }

    @Override
    public void passengers(int count) {
        if (count > 0) {
            this.move();
        } else {
            System.out.println("Автобус пустой.");
        }
    }
}
