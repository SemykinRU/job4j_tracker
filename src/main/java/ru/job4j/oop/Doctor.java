package ru.job4j.oop;

public class Doctor extends Profession {

    private boolean work;

    public Doctor(String name, String surname, String education, String birthday, boolean work) {
        super(name, surname, education, birthday);
        this.work = work;
    }

    public boolean getWork() {return this.work;}
}
