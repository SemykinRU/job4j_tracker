package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            switch (Integer.parseInt(scanner.nextLine())) {
                case 0 -> {
                    System.out.println("=== Создаем новую заявку ====");
                    System.out.print("Введите имя заявки: ");
                    tracker.add(new Item(scanner.nextLine()));
                }
                case 1 -> {
                    for (Item item : tracker.findAll()) {
                        System.out.println(item);
                    }
                    System.out.println("==== Нажмите Enter для продолжения ====");
                    scanner.nextLine();
                }
                case 2 -> {
                    for (Item item : tracker.findAll()) {
                        System.out.println(item);
                    }
                    System.out.print("Введите ID изменяемой заявки: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите имя заявки: ");
                    if (tracker.replace(id, new Item(scanner.nextLine()))) {
                        System.out.println("Успешно.");
                    } else {
                        System.out.println("Ошибка. Заявка с таким ID отсутствует.");
                    }
                }
                case 3 -> {
                    for (Item item : tracker.findAll()) {
                        System.out.println(item);
                    }
                    System.out.print("Введите ID удаляемой заявки: ");
                    if (tracker.delete(Integer.parseInt(scanner.nextLine()))) {
                        System.out.println("Успешно");
                    } else {
                        System.out.println("Ошибка. Заявка с таким ID отсутствует.");
                    }
                }
                case 4 -> {
                    System.out.print("Введите ID заявки: ");
                    Item item = tracker.findById(Integer.parseInt(scanner.nextLine()));
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Заявка с таким ID отсутствует.");
                    }
                    System.out.println("==== Нажмите Enter для продолжения ====");
                    scanner.nextLine();
                }
                case 5 -> {
                    System.out.print("Введите имя заявки: ");
                    Item[] items = tracker.findByName(scanner.nextLine());
                    if (items.length > 0) {
                        for (Item value : items) {
                            System.out.println(value);
                        }
                    } else {
                        System.out.println("Заявка с таким именем не найдена.");
                    }
                    System.out.println("==== Нажмите Enter для продолжения ====");
                    scanner.nextLine();
                }
                case 6 -> run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.print("Select: ");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
