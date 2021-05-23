package ru.job4j.oop;

public class Dentist extends Doctor {

    public Dentist(String name, String surname, String education, String birthday, boolean work) {
        super(name, surname, education, birthday, work);
    }

    public void takeInstrument() { }

    public void givePain() { }
}
