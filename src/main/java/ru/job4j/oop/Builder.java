package ru.job4j.oop;

public class Builder extends Engineer{

    private String position;

    public Builder(String name, String surname, String education, String birthday, String direction, String position) {
        super(name, surname, education, birthday, direction);
        this.position = position;
    }

    public String getPosition(){return this.position;}

    public void takeCement(){}
}
