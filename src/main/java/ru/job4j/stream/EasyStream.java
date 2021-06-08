package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
   private final List<Integer> rsl = new ArrayList<>();

    public static EasyStream of(List<Integer> source) {
        EasyStream stream = new EasyStream();
        stream.rsl.addAll(source);
        return stream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> result = new ArrayList<>();
        for (var item : rsl) {
            result.add(fun.apply(item));
        }
        rsl.clear();
        rsl.addAll(result);
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> result = new ArrayList<>();
        for (var item : rsl) {
            if (fun.test(item)) {
                result.add(item);
            }
        }
        rsl.clear();
        rsl.addAll(result);
        return this;
    }

    public List<Integer> collect() {
    return this.rsl;
    }
}