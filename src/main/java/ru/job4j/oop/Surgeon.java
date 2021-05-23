package ru.job4j.oop;

public class Surgeon extends Doctor {

    private String anyThink;

    public Surgeon(String name, String surname,
                   String education, String birthday,
                   boolean work, String anyThink) {
        super(name, surname, education, birthday, work);
        this.anyThink = anyThink;
    }

    public String getAnyThink() {
        return anyThink;
    }

    public void operation() { }
}
