package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public static Predicate<List<String>> isValuesStartWithUpperCase() {
                return list -> list.stream().allMatch(value -> Character.isUpperCase(value.charAt(0)));
    }
    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
            return list ->{
              List<Integer> evenValue = list.stream()
                      .filter(num->num % 2 == 0)
                      .toList();
                list.addAll(evenValue);
            };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(
                str -> str.startsWith("A")).toList();
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
       return list -> list.stream().collect(Collectors.toMap(
               Function.identity(),
               String::length
       ));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1 , list2)->{
          List<Integer> conc = new ArrayList<>(list1);
            conc.addAll(list2);
            return conc;
        };
    }

}
