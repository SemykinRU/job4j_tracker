package ru.job4j.oop;

public class Plane implements Vehicle{
    @Override
    public void move() {
        System.out.println("Взлетаем и летим");
    }

    @Override
    public void passengers(int count) {
        if (count > 0) {
            this.move();
        } else {
            System.out.println("Самолет пустой.");
        }
    }
}
