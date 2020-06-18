package com.soyphea.generic.type;

import java.util.Arrays;
import java.util.List;

public class ShapeUsage {

    public static void upper_bound_wildcard(List<? extends Shape> list) {
        list.forEach(System.out::println);
    }

    public static void lower_bound_card(List<? super Circle> list) {
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {

        upper_bound_wildcard(Arrays.asList(new Circle()));
        upper_bound_wildcard(Arrays.asList(new Triangle()));
        lower_bound_card(Arrays.asList(new Circle()));
        lower_bound_card(Arrays.asList(new Triangle()));
    }


}
