package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public void printInfo(){
        System.out.println("Поле active = " + this.active);
        System.out.println("Поле status = " + this.status);
        System.out.println("Поле message = " + this.message);
    }

    public Error(){}

    public Error(boolean active, int status, String message){
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public static void main(String[] args) {
        Error errorDefolt = new Error();
        errorDefolt.printInfo();
        Error error1 = new Error(true,5, "Нет связи.");
        error1.printInfo();
        Error error2 = new Error(false, 0, "Все ОК.");
        error2.printInfo();
    }
}
