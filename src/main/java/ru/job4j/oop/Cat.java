package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println("Кот, с именем " + this.name + ", съел " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        Cat black = new Cat();
        gav.giveNick("gav");
        black.giveNick("black");
        gav.eat("kotletka");
        black.eat("fish");
        gav.show();
        black.show();
    }
}
