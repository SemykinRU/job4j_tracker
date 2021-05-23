package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void goIn() {
        System.out.println("Поехали!");
    }

    @Override
    public void passengers(int count) {
        if (count > 0) {
           this.goIn();
        }
    }

    @Override
    public double refuel(double value) {
        return value * 46.6;
    }
}
