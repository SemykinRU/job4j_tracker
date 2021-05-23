package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan Ivanovich");
        student.setGroup("OIT-405");
        student.setReceiptDate(new Date());
        System.out.println("Студент "
                + student.getFullName() + ", учащийся в группе "
                + student.getGroup()
                + ", поступил "
                + student.getReceiptDate());
    }
}
