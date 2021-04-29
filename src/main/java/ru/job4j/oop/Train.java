package ru.job4j.oop;

public class Train implements Vehicle{
    @Override
    public void move() {
        System.out.println("Начинаем движение по  рельсам.");
    }

    @Override
    public void passengers(int count) {
        if (count > 0) {
            this.move();
        } else {
            System.out.println("Поез пустой.");
        }
    }
}
