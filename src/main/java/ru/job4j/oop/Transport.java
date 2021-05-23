package ru.job4j.oop;

public class Transport {
    public static void main(String[] args) {
        Vehicle plane1 = new Plane();
        Vehicle plane2 = new Plane();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();

        Vehicle[] array = {plane1, plane2, train1, train2, bus1, bus2};

        for (Vehicle vehicle : array) {
            vehicle.passengers(20);
        }
    }
}
