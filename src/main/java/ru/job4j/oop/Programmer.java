package ru.job4j.oop;

public class Programmer extends Engineer{

    private boolean sleep;

    public Programmer(String name, String surname, String education, String birthday, String direction, boolean sleep) {
        super(name, surname, education, birthday, direction);
        this.sleep = sleep;
    }

    public boolean getSleep(){return this.sleep;}

    public void startProgramming(){}
}
