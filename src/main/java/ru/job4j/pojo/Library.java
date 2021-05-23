package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book[] arrayBook = {new Book("Евгений Онегин", 140), new Book("Ревизор", 130),
                            new Book("Библия", 1768), new Book("Clean code", 1)};

        for (int i = 0; i < arrayBook.length; i++) {
            System.out.println(arrayBook[i].getName() + " - " + arrayBook[i].getCount() + "стр.");
        }

        Book temp = arrayBook[0];
        arrayBook[0] = arrayBook[3];
        arrayBook[3] = temp;

        for (int i = 0; i < arrayBook.length; i++) {
            System.out.println(arrayBook[i].getName() + " - " + arrayBook[i].getCount() + "стр.");
        }

        for (int i = 0; i < arrayBook.length; i++) {
            if (arrayBook[i].getName().equals("Clean code")) {
                System.out.println(arrayBook[i].getName()
                        + " - " + arrayBook[i].getCount()
                        + "стр.");
            }
        }
    }
}
