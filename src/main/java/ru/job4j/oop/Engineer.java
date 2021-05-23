package ru.job4j.oop;

public class Engineer extends Profession {

    private String direction;

    public Engineer(String name, String surname,
                    String education, String birthday,
                    String direction) {
        super(name, surname, education, birthday);
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }
}
