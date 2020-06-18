package com.soyphea.generic;

import java.util.ArrayList;
import java.util.List;

public class UnboundWidCard {

    public static void print(List<?> list){
        for (Object elem : list)
            System.out.println(elem + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        print(List.of(1,2,4,5));
        print(List.of("a","b"));
        addNumbers(list);
    }


    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        print(list);
    }
}
