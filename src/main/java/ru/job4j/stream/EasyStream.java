package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
   private final List<Integer> rsl;

   private EasyStream(List<Integer> list) {
       this.rsl = list;
   }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> result = new ArrayList<>();
        for (var item : rsl) {
            result.add(fun.apply(item));
        }
        return new EasyStream(result);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> result = new ArrayList<>();
        for (var item : rsl) {
            if (fun.test(item)) {
                result.add(item);
            }
        }
        return new EasyStream(result);
    }

    public List<Integer> collect() {
    return List.copyOf(rsl);
    }
}