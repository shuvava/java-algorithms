package com.github.shuuvava.arrays;

import java.util.ArrayList;
import java.util.stream.Stream;

public abstract class BaseTest {
    protected static ArrayList<ArrayList<Integer>> parseToArrayOfArray(String input) {
        if (input == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        return Stream
            .of(input.split(";"))
            .map(String::trim)
            .map(line -> Stream
                .of(
                    line.split(",")
                )
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll)
            )
            .collect(ArrayList<ArrayList<Integer>>::new, ArrayList::add, ArrayList::addAll);
    }

    protected static ArrayList<Integer> parseArray(String input) {
        if (input == null) {
            return new ArrayList<>();
        }
        return Stream
            .of(
                input.split(",")
            )
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
