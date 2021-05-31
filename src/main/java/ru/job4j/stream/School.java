package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                        .filter(predict)
                        .collect(Collectors.toList());
    }

    public Map<String, Student> studentMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getSurname,
                        x -> x,
                        (x, y) -> x.getScore() > y.getScore() ? x : y));
    }
}
